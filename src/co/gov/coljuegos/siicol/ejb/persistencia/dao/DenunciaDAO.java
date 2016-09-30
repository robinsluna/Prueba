package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDenuncia;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
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
public class DenunciaDAO {

    /** Entity Manager */
    @PersistenceContext(unitName = "siicolPU")
    protected EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    protected Recursos recursos;
    
    public DenunciaDAO(){
            this.recursos = new Recursos();
    }

    public SiiDenuncia buscarPorCodigo (Long denCodigo) 
        throws ExcepcionDAO 
    {
        SiiDenuncia entidad = null;
        try {
            entidad = em.find(SiiDenuncia.class, denCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return entidad;

    }
    
    /**
     * Buscar denuncias por estado
     * @param estado 
     * @return listaSiiDenuncia - lista de denuncias según estado.
     * @throws ExcepcionDAO
     */
    public List<SiiDenuncia> buscarDenunciasPorEstado(Long estado) throws ExcepcionDAO{
        List<SiiDenuncia> listaSiiDenuncia = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT den FROM SiiDenuncia den ");
            sql.append("INNER JOIN den.siiEstadoDenuncia est ");
            sql.append("WHERE est.ednCodigo = :estado order by den.denNumero desc");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("estado", estado);

            listaSiiDenuncia = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDenuncia;
    }
    
    /**
     * Buscar todas las denuncias con resoluciones de decomiso y destrucción
     * @return listaSiiDenuncia - Lista de denuncias
     * @throws ExcepcionDAO
     */
    
    public List<SiiDenuncia> buscarDenunciasConResolucionDecomisoDestruccion() throws ExcepcionDAO {
        List<SiiDenuncia> listaSiiDenuncia = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT den FROM SiiDenuncia den ");
            sql.append("INNER JOIN den.siiEstadoDenuncia est ");
            sql.append(" WHERE est.ednCodigo = :estado1 ");
            sql.append(" or est.ednCodigo = :estado2");
            sql.append(" or est.ednCodigo = :estado3");
            sql.append(" or est.ednCodigo = :estado4");
            sql.append(" or est.ednCodigo = :estado5");
            sql.append(" or est.ednCodigo = :estado6");
            sql.append(" or est.ednCodigo = :estado7");
            sql.append(" or est.ednCodigo = :estado8");
            sql.append(" order by den.denNumero desc");

            Query query = em.createQuery(sql.toString());
            query.setParameter("estado1", EnumEstadoDenuncia.TRAMITE_RESOLUCION_DECOMISO_Y_DESTRUCCION.getId());
            query.setParameter("estado2", EnumEstadoDenuncia.TRAMITE_RESOLUCION_RESULEVE_RECURSO.getId());
            query.setParameter("estado3", EnumEstadoDenuncia.RESOLUCION_DEVOLUCION.getId());
            query.setParameter("estado4", EnumEstadoDenuncia.RESOLUCION_DECOMISO_Y_DESTRUCCION.getId());
            query.setParameter("estado5", EnumEstadoDenuncia.RESOLUCION_DEVOLUCION_DECOMISO_Y_DESTRUCCION.getId());
            query.setParameter("estado6", EnumEstadoDenuncia.RESOLUCION_DEVOLUCION_CON_RECURSO.getId());
            query.setParameter("estado7", EnumEstadoDenuncia.RESOLUCION_DECOMISO_Y_DESTRUCCION_CON_RECURSO.getId());
            query.setParameter("estado8", EnumEstadoDenuncia.RESOLUCION_DEVOLUCION_DECOMISO_Y_DESTRUCCION_CON_RECURSO.getId());
            
            listaSiiDenuncia = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDenuncia;
    }

    /**
     * Buscar denuncias por estado del resultado de verificación, y que además estén en los estados:
     * REGISTRADO o VERIFICADO_ESCRITORIO o RESPUESTA_ENVIADA
     * @param estado
     * @return listaSiiDenuncia - Lista de denuncias con el estado del resultado de verificación
     * @throws ExcepcionDAO
     */
    public List<SiiDenuncia> buscarDenunciasPorResultadoVerif(Long estado) throws ExcepcionDAO {
        List<SiiDenuncia> listaSiiDenuncia = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT den FROM SiiDenuncia den ");
            sql.append(" INNER JOIN den.siiResultadoVerifDenun est ");
            sql.append(" WHERE est.revCodigo = :estado ");
            sql.append(" AND ( den.siiEstadoDenuncia.ednCodigo = ");
            sql.append(EnumEstadoDenuncia.REGISTRADO.getId());
            sql.append(" OR den.siiEstadoDenuncia.ednCodigo = ");
            sql.append(EnumEstadoDenuncia.VERIFICADO_ESCRITORIO.getId());
            sql.append(" OR den.siiEstadoDenuncia.ednCodigo = ");
            sql.append(EnumEstadoDenuncia.RESPUESTA_ENVIADA.getId());
            sql.append(" )");

            Query query = em.createQuery(sql.toString());
            query.setParameter("estado", estado);

            listaSiiDenuncia = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDenuncia;
    }
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Entidad.
     * @param entidad
     * @return SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public SiiDenuncia actualizar (SiiDenuncia entidad) 
        throws ExcepcionDAO 
    {
        try {
            SiiDenuncia result = em.merge(entidad); 
            em.flush(); 
            return result; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public List<SiiDenuncia> buscarTodo () 
        throws ExcepcionDAO 
    {
        List<SiiDenuncia> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDenuncia o order by o.denCodigo desc");
            Query query = em.createQuery(sql.toString());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Entidad.
     * @param 
     * @throws ExcepcionDAO
     */
    public void eliminar(SiiDenuncia entidadBorrar) throws ExcepcionDAO {
        try {
            SiiDenuncia registroDelete;
            registroDelete = em.find(SiiDenuncia.class, entidadBorrar.getDenCodigo());
            if (registroDelete != null) {
                em.remove(registroDelete);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    /**
     * Realiza la Inserci&oacute;n de un registro de la Entidad.
     * @param entidad
     * @return SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public SiiDenuncia insertar (SiiDenuncia entidad) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(entidad); 
            em.flush(); 
            return entidad; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }

    public List<SiiDenuncia> denunciasHallazgosEnEstadoAutoComisorioSinAccionControl() throws ExcepcionDAO {
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDenuncia o WHERE o.siiEstadoDenuncia.ednNombre = 'AUTO COMISORIO' " +
                " AND NOT EXISTS " +
                " (SELECT acc FROM SiiAccionControl acc " +
                "  WHERE acc.siiAutoComisorioAccCon.siiDenuncia.denCodigo = o.denCodigo " +
                "  AND acc.accEstado <> 'N') " +
                " ORDER BY o.denNumero DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    /**
     * Realiza la consulta para obtener el Consecutivo del Documento Contable a trav&eacute;s del Tipo de Documento Contable.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @return documentoContable.numero.nextval
     * @throws ExcepcionDAO
     */
    public Integer buscarConsecutivoDenuncia() throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(MAX(DEN.DEN_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_DENUNCIA den "); 
            sql.append("WHERE DEN.DEN_NUMERO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            Query query = em.createNativeQuery(sql.toString());
            
            if(query.getSingleResult() != null){
                consecutivo = new Integer(((BigDecimal)query.getSingleResult()).intValueExact());
            }
            
        }
        catch (javax.persistence.NoResultException ne) {
            consecutivo = null;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }
    
    public List<SiiDenuncia> denunciasXdenNumero( Long denNumero ) throws ExcepcionDAO {
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiDenuncia o WHERE o.denNumero = :denNumero ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("denNumero", denNumero);
            return query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    public List<SiiDenuncia> buscarDenunciasPorOrdenTrabajo(Long estado) throws ExcepcionDAO{
        List<SiiDenuncia> listaSiiDenuncia = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT den FROM SiiDenuncia den ");
            sql.append("INNER JOIN den.siiEstadoDenuncia est ");
            sql.append("WHERE est.ednCodigo = :estado ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("estado", estado);

            listaSiiDenuncia = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDenuncia;
    }
   
    
    
}
