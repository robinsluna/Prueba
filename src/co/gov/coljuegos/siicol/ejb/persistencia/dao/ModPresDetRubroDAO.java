package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoModificPresup;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPresDetRubro;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ModPresDetRubroDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModPresDetRubroDAO() {
        recursos = new Recursos();
    }
    
    public SiiModPresDetRubro  buscarModPresDetRubroPorId (Long idMpdCodigo) throws ExcepcionDAO {
        SiiModPresDetRubro siiModPresDetRubro = null;
        try{
            siiModPresDetRubro = manager.find(SiiModPresDetRubro.class,idMpdCodigo);
        }catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, "ModPresDetRubroDAO");
        }
        return siiModPresDetRubro;
    }

    public SiiModPresDetRubro  insertarModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) throws ExcepcionDAO {
        try{
            manager.persist(siiModPresDetRubro);
            manager.flush();
        }catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, "ModPresDetRubroDAO");
        }
        return siiModPresDetRubro;
    }
    
    public SiiModPresDetRubro actualizarModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) throws ExcepcionDAO {
        try{
            siiModPresDetRubro = manager.merge(siiModPresDetRubro);
            manager.flush();
        }catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, "ModPresDetRubroDAO");
        }
        return siiModPresDetRubro;
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de SiiModPresDetRubro.
     * @param mpdCodigo
     * @throws ExcepcionDAO
     */
    public void borrarModPresDetRubro (Long mpdCodigo) throws ExcepcionDAO 
    {
        SiiModPresDetRubro entidadBorrar = null;
        try {
            entidadBorrar = manager.find(SiiModPresDetRubro.class, mpdCodigo);
            if (entidadBorrar!=null) {
                manager.remove(entidadBorrar);
                manager.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la consulta del listado de relaciones Modificaci&oacute;n Presupuestal con Detalle Rubro, asociadas al c&oacute;digo de la Modificaci&oacute;n Presupuestal suministrado.
     * @param mprCodigo
     * @return List of SiiModPresDetRubro
     */
    public List<SiiModPresDetRubro> buscarPorCodigoModificPresup (Long mprCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mpdr FROM SiiModPresDetRubro mpdr ");
            sql.append("WHERE mpdr.siiModificPresup.mprCodigo = :mprCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mprCodigo", mprCodigo);
            List<SiiModPresDetRubro> lista = query.getResultList();
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la consulta del valor total de Cr&eacute;ditos asociados al Detalle Rubro especificado.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @return Sumatoria de Cr&eacute;ditos.
     * @throw ExcepcionDAO
     */
    public Long consultarValorCreditos (Long druCodigo) throws ExcepcionDAO {
        Long creditos = new Long(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS CREDITOS "); 
            sql.append("FROM SII_MOD_PRES_DET_RUBRO mpd ");
            sql.append("INNER JOIN SII_MODIFIC_PRESUP mp  ON  mp.mpr_codigo = mpd.mpr_codigo ");
            sql.append("WHERE mpd.DRU_CODIGO_DESTINO = #druCodigo ");
            sql.append("AND mp.mpr_tipo = #mprTipo ");
            sql.append("AND mp.emp_codigo = #empCodigo");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("mprTipo", EnumTipoModificPresup.TRASLADO.getId());
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            BigDecimal resultado = (BigDecimal) query.getSingleResult();
            creditos = resultado!=null?resultado.longValue():0L;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (creditos);
    }
    
    
    
    /**
     * Realiza la consulta del valor total de Contracr&eacute;ditos asociados al Detalle Rubro especificado.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @return Sumatoria de Contracr&eacute;ditos.
     * @throw ExcepcionDAO
     */
    public Long consultarValorContracreditos (Long druCodigo) throws ExcepcionDAO {
        Long contracreditos = new Long(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS CONTRACREDITOS "); 
            sql.append("FROM SII_MOD_PRES_DET_RUBRO mpd ");
            sql.append("INNER JOIN SII_MODIFIC_PRESUP mp  ON  mp.mpr_codigo = mpd.mpr_codigo ");
            sql.append("WHERE mpd.DRU_CODIGO_ORIGEN = #druCodigo ");
            sql.append("AND mp.mpr_tipo = #mprTipo ");
            sql.append("AND mp.emp_codigo = #empCodigo");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("mprTipo", EnumTipoModificPresup.TRASLADO.getId());
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            BigDecimal resultado = (BigDecimal) query.getSingleResult();
            contracreditos = resultado!=null?resultado.longValue():0L;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (contracreditos);
    }
    
    
    /**
     * Realiza la consulta del valor total de Adiciones asociadas al Detalle Rubro especificado.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @return Sumatoria de Adiciones.
     * @throw ExcepcionDAO
     */
    public Long consultarValorAdiciones (Long druCodigo) throws ExcepcionDAO {
        Long adiciones = new Long(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS ADICIONES "); 
            sql.append("FROM SII_MOD_PRES_DET_RUBRO mpd ");
            sql.append("INNER JOIN SII_MODIFIC_PRESUP mp  ON  mp.mpr_codigo = mpd.mpr_codigo ");
            sql.append("WHERE mpd.DRU_CODIGO_DESTINO = #druCodigo ");
            sql.append("AND mp.mpr_tipo = #mprTipo ");
            sql.append("AND mp.emp_codigo = #empCodigo");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("mprTipo", EnumTipoModificPresup.ADICION.getId());
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            BigDecimal resultado = (BigDecimal) query.getSingleResult();
            adiciones = resultado!=null?resultado.longValue():0L;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (adiciones);
    }
    
    
    
    /**
     * Realiza la consulta del valor total de Reducciones asociadas al Detalle Rubro especificado.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @return Sumatoria de Reducciones.
     * @throw ExcepcionDAO
     */
    public Long consultarValorReducciones (Long druCodigo) throws ExcepcionDAO {
        Long reducciones = new Long(0);
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS REDUCCIONES "); 
            sql.append("FROM SII_MOD_PRES_DET_RUBRO mpd ");
            sql.append("INNER JOIN SII_MODIFIC_PRESUP mp  ON  mp.mpr_codigo = mpd.mpr_codigo ");
            sql.append("WHERE mpd.DRU_CODIGO_DESTINO = #druCodigo ");
            sql.append("AND mp.mpr_tipo = #mprTipo ");
            sql.append("AND mp.emp_codigo = #empCodigo");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("mprTipo", EnumTipoModificPresup.REDUCCION.getId());
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            BigDecimal resultado = (BigDecimal) query.getSingleResult();
            reducciones = resultado!=null?resultado.longValue():0L;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (reducciones);
    }
}

