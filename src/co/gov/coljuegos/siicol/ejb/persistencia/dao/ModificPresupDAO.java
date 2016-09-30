package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoModificPresup;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPresup;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ModificPresupDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    
    public ModificPresupDAO() {
        recursos = new Recursos();
    }
    
    public SiiModificPresup buscarModificPresupPorId (Long idMprCodigo) throws ExcepcionDAO{
        SiiModificPresup  siiModificPresup = null;
        try{
            siiModificPresup = manager.find(SiiModificPresup.class, idMprCodigo);
        }catch (PersistenceException pe) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError, "ModificPresupDAO");
        }
        return siiModificPresup;
    }
    
    public SiiModificPresup actualizarModificPresup (SiiModificPresup siiModificPresup) throws ExcepcionDAO{
        try{
            manager.merge(siiModificPresup);
            manager.flush();
        }catch (PersistenceException pe) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError, "ModificPresupDAO");
        }
        return siiModificPresup;
    }
    
    public SiiModificPresup insertarModificPresup(SiiModificPresup siiModificPresup) throws ExcepcionDAO {
        try{
            manager.persist(siiModificPresup);
            manager.flush();
        }catch (PersistenceException pe) {
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError, "ModificPresupDAO");
        }
        return siiModificPresup;
    }
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarTodaModificPresup () throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificPresup o");
            Query query = manager.createQuery(sql.toString());
            List<SiiModificPresup> lista = query.getResultList();
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales.
     * @param empCodigo - C&oacute;digo del Estado de la Modificaci&oacute;n Presupuestal.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarModificPresupPorEstado (Long empCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificPresup o ");
            sql.append("WHERE o.siiEstadoModifPresup.empCodigo = :empCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("empCodigo", empCodigo);
            
            List<SiiModificPresup> lista = query.getResultList();
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales que se encuentren en el Tipo y Estado especificados.
     * @param mprTipo - Tipo de la Modificaci&oacute;n Presupuestal.
     * @param empCodigo - Estado de la Modificaci&oacute;n Presupuestal.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarModificPresupPorTipoYEstado (String mprTipo, Long empCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificPresup o ");
            sql.append("WHERE o.mprTipo = :mprTipo ");
            
            if (empCodigo!=null)
                sql.append("AND o.siiEstadoModifPresup.empCodigo = :empCodigo ");
            
            sql.append("ORDER BY o.mprCodigo DESC ");
            
                
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mprTipo", mprTipo);
            
            if (empCodigo!=null)
                query.setParameter("empCodigo", empCodigo);
            
            List<SiiModificPresup> lista = query.getResultList();
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>TRASLADO</b>.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarTodoTrasladoPresupuestal () throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.TRASLADO.getId(), null));
    }
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>TRASLADO</b> que se encuentren en el Estado especificado.
     * @param empCodigo - Estado de la Modificaci&oacute;n Presupuestal.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarTrasladoPresupuestalPorEstado (Long empCodigo) throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.TRASLADO.getId(), empCodigo));
    }
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>ADICI&Oacute;N</b>.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarTodaAdicionPresupuestal () throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.ADICION.getId(), null));
    }
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>ADICI&Oacute;N</b> que se encuentren en el Estado especificado.
     * @param empCodigo - Estado de la Modificaci&oacute;n Presupuestal.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarAdicionPresupuestalPorEstado (Long empCodigo) throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.ADICION.getId(), empCodigo));
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>REDUCCI&Oacute;N</b>.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarTodaReduccionPresupuestal () throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.REDUCCION.getId(), null));
    }
    
    
    /**
     * Realiza la b&uacute;squeda de todas las Modificaciones Presupuestales de tipo <b>REDUCCI&Oacute;N</b> que se encuentren en el Estado especificado.
     * @param empCodigo - Estado de la Modificaci&oacute;n Presupuestal.
     * @return List of SiiModificPresup.
     * @throws ExcepcionDAO
     */
    public List<SiiModificPresup> buscarReduccionPresupuestalPorEstado (Long empCodigo) throws ExcepcionDAO {
        return (this.buscarModificPresupPorTipoYEstado(EnumTipoModificPresup.REDUCCION.getId(), empCodigo));
    }
    
    
    
    /**
     * Realiza la consulta para obtener el Consecutivo de la Modificaci&oacute;n Presupuestal.
     * @return obligacion.numero.nextval
     * @throws ExcepcionDAO
     */
    public Long generarConsecutivoModificPresup() throws ExcepcionDAO 
    {
        Long consecutivo = null;
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("SELECT NVL(MAX(MPR_CONSECUTIVO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yyyy')||'000001')) ");
            sql.append("FROM SII_MODIFIC_PRESUP mp "); 
            sql.append("WHERE MPR_CONSECUTIVO LIKE ''||TO_CHAR(CURRENT_DATE,'yyyy')||'%'");
            Query query = manager.createNativeQuery(sql.toString());
                        
            if(query.getSingleResult() != null){
                consecutivo = new Long(((BigDecimal)query.getSingleResult()).longValue());
            }
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }

    public BigDecimal valorAdicionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0)\n" + 
            "  FROM sii_modific_presup mpr\n" + 
            "  INNER JOIN sii_estado_modif_presup emp\n" + 
            "  ON emp.EMP_CODIGO = mpr.EMP_CODIGO\n" + 
            "  INNER JOIN sii_mod_pres_det_rubro mpd\n" + 
            "  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO\n" + 
            "  WHERE emp.EMP_CODIGO = #empCodigo\n" + 
            "  AND mpr.MPR_TIPO     = 'A'\n" + 
            "  AND mpd.DRU_CODIGO_DESTINO = #druCodigo\n");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            return (BigDecimal) query.getSingleResult();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public BigDecimal valorReduccionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0)\n" + 
            "  FROM sii_modific_presup mpr\n" + 
            "  INNER JOIN sii_estado_modif_presup emp\n" + 
            "  ON emp.EMP_CODIGO = mpr.EMP_CODIGO\n" + 
            "  INNER JOIN sii_mod_pres_det_rubro mpd\n" + 
            "  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO\n" + 
            "  WHERE emp.EMP_CODIGO = #empCodigo\n" + 
            "  AND mpr.MPR_TIPO     = 'R'\n" + 
            "  AND mpd.DRU_CODIGO_DESTINO = #druCodigo\n");            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            return (BigDecimal) query.getSingleResult();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public BigDecimal valorCreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0)\n" + 
            "  FROM sii_modific_presup mpr\n" + 
            "  INNER JOIN sii_estado_modif_presup emp\n" + 
            "  ON emp.EMP_CODIGO = mpr.EMP_CODIGO\n" + 
            "  INNER JOIN sii_mod_pres_det_rubro mpd\n" + 
            "  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO\n" + 
            "  WHERE emp.EMP_CODIGO = #empCodigo\n" + 
            "  AND mpr.MPR_TIPO     = 'T'\n" + 
            "  AND mpd.DRU_CODIGO_DESTINO = #druCodigo\n");            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            return (BigDecimal) query.getSingleResult();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

    }
    
    public BigDecimal valorContracreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(SUM(mpd.MPD_VALOR), 0)\n" + 
            "  FROM sii_modific_presup mpr\n" + 
            "  INNER JOIN sii_estado_modif_presup emp\n" + 
            "  ON emp.EMP_CODIGO = mpr.EMP_CODIGO\n" + 
            "  INNER JOIN sii_mod_pres_det_rubro mpd\n" + 
            "  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO\n" + 
            "  WHERE emp.EMP_CODIGO = #empCodigo'\n" + 
            "  AND mpr.MPR_TIPO     = 'T'\n" + 
            "  AND mpd.DRU_CODIGO_ORIGEN = #druCodigo\n");            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
            return (BigDecimal) query.getSingleResult();
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

    }
    
    
    /**
     * Obtiene el saldo del valor del Detalle Rubro, producto de las Adiciones, Reducciones, Cr&eacute;ditos y Contracr&eacute;ditos asociados al Detalle Rubro especificado.
     * @param druCodigo - C&uacute;digo del Detalle Rubro.
     * @return Saldo del Detalle Rubro = DRU_VALOR + ADICIONES - REDUCCIONES + CR&Eacute;DITOS - CONTRACR&Eacute;DITOS.
     * @throws ExcepcionDAO
     */
    public BigDecimal obtenerSaldoDetalleRubroModificPresup (Long druCodigo) throws ExcepcionDAO 
    {
        BigDecimal saldo = BigDecimal.ZERO;
        
        if (druCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT (Y.DRU_VALOR + Y.ADICIONES - Y.REDUCCIONES + Y.CREDITOS - Y.CONTRACREDITOS) AS TOTAL ");
                sql.append("FROM ( "); 
                sql.append("    SELECT  ");
                sql.append("        (SELECT dru.DRU_VALOR ");
                sql.append("         FROM SII_DETALLE_RUBRO dru ");
                sql.append("         WHERE dru.DRU_CODIGO = #druCodigo) AS DRU_VALOR, ");
                sql.append("         ");
                sql.append("        (SELECT NVL(SUM(mpd.MPD_VALOR), 0)  ");
                sql.append("        FROM sii_modific_presup mpr ");
                sql.append("        INNER JOIN sii_estado_modif_presup emp  ON emp.EMP_CODIGO = mpr.EMP_CODIGO ");
                sql.append("        INNER JOIN sii_mod_pres_det_rubro mpd   ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO ");
                sql.append("        WHERE emp.EMP_CODIGO = #empCodigo ");
                sql.append("        AND mpr.MPR_TIPO     = #mprAdicion ");
                sql.append("        AND mpd.DRU_CODIGO_DESTINO = #druCodigo) AS ADICIONES, ");
                sql.append("         ");
                sql.append("        (SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS TOTAL ");
                sql.append("        FROM sii_modific_presup mpr ");
                sql.append("        INNER JOIN sii_estado_modif_presup emp ON emp.EMP_CODIGO = mpr.EMP_CODIGO ");
                sql.append("        INNER JOIN sii_mod_pres_det_rubro mpd  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO ");
                sql.append("        WHERE emp.EMP_CODIGO = #empCodigo ");
                sql.append("        AND mpr.MPR_TIPO     = #mprReduccion ");
                sql.append("        AND mpd.DRU_CODIGO_DESTINO = #druCodigo) AS REDUCCIONES, ");
                sql.append("         ");
                sql.append("        (SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS TOTAL ");
                sql.append("        FROM sii_modific_presup mpr ");
                sql.append("        INNER JOIN sii_estado_modif_presup emp  ON emp.EMP_CODIGO = mpr.EMP_CODIGO ");
                sql.append("        INNER JOIN sii_mod_pres_det_rubro mpd  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO ");
                sql.append("        WHERE emp.EMP_CODIGO = #empCodigo ");
                sql.append("        AND mpr.MPR_TIPO     = #mprTraslado ");
                sql.append("        AND mpd.DRU_CODIGO_DESTINO = #druCodigo) AS CREDITOS, "); 
                sql.append("         ");
                sql.append("        (SELECT NVL(SUM(mpd.MPD_VALOR), 0) AS TOTAL  "); 
                sql.append("        FROM sii_modific_presup mpr "); 
                sql.append("        INNER JOIN sii_estado_modif_presup emp  ON emp.EMP_CODIGO = mpr.EMP_CODIGO ");
                sql.append("        INNER JOIN sii_mod_pres_det_rubro mpd  ON mpd.MPR_CODIGO    = mpr.MPR_CODIGO "); 
                sql.append("        WHERE emp.EMP_CODIGO = #empCodigo "); 
                sql.append("        AND mpr.MPR_TIPO     = #mprTraslado "); 
                sql.append("        AND mpd.DRU_CODIGO_ORIGEN = #druCodigo) AS CONTRACREDITOS ");
                sql.append("    "); 
                sql.append("    FROM DUAL) ");
                sql.append("Y ");
                
                
                Query query = manager.createNativeQuery(sql.toString());
                query.setParameter("empCodigo", EnumEstadoModifPresup.AUTORIZADO.getId());
                query.setParameter("mprTraslado", EnumTipoModificPresup.TRASLADO.getId());
                query.setParameter("mprReduccion", EnumTipoModificPresup.REDUCCION.getId());
                query.setParameter("mprAdicion", EnumTipoModificPresup.ADICION.getId());
                query.setParameter("druCodigo", druCodigo);
                
                saldo = (BigDecimal) query.getSingleResult();
            }
            catch (NoResultException e) {
                saldo = BigDecimal.ZERO;
            }
            catch (PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (saldo);
    }

}


