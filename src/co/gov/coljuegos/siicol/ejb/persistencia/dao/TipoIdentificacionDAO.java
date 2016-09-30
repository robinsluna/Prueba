package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean


public class TipoIdentificacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoIdentificacionDAO() {
        recursos = new Recursos();
    }

    public SiiTipoIdentificacion buscarTipoIdentificacionPorId(Long idTipoIdentificacion) throws ExcepcionDAO {
        SiiTipoIdentificacion tipoIdentificacionRetorno = null;
        try {
            tipoIdentificacionRetorno = manager.find(SiiTipoIdentificacion.class, idTipoIdentificacion);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return tipoIdentificacionRetorno;
    }


    public List<SiiTipoIdentificacion> buscarTipoIdentificacionPorNombre(SiiTipoIdentificacion unTipoIdentificacion) throws ExcepcionDAO {
        List<SiiTipoIdentificacion> tipoIdentificacionRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT tipoIdent FROM SiiTipoIdentificacion tipoIdent");
            sql.append(" WHERE tipoIdent.tidNombre = :tipoIdentificacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoIdentificacion", unTipoIdentificacion.getTidNombre());
            tipoIdentificacionRetorno = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return tipoIdentificacionRetorno;
    }

    /**
     * @author Modifica Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiTipoIdentificacion> buscarTodosTipoIdentificacion() throws ExcepcionDAO {
        List<SiiTipoIdentificacion> listaTipoIdentificacion = null;
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ti FROM SiiTipoIdentificacion ti");
            sql.append(" ORDER BY ti.tidNombre ASC");
            
            Query query = manager.createQuery(sql.toString());
            listaTipoIdentificacion = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaTipoIdentificacion;
    }
    
    public SiiTipoIdentificacion buscarTipoIdentificacionPorNombre(String tidNombre) throws ExcepcionDAO {
        SiiTipoIdentificacion siiTipoIdentificacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tid FROM SiiTipoIdentificacion tid where tid.tidNombre = :tidNombre");            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tidNombre", tidNombre);
            //return (SiiTipoIdentificacion) query.getSingleResult();
            List<SiiTipoIdentificacion> listTipoIdentificacion = query.getResultList();
            if(listTipoIdentificacion != null && listTipoIdentificacion.size() > 0){
                siiTipoIdentificacion = listTipoIdentificacion.get(0);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoIdentificacion;
    }

}
