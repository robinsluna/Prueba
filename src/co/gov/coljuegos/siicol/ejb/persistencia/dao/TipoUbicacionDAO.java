package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoUbicacion;
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
public class TipoUbicacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoUbicacionDAO() {
        recursos = new Recursos();
    }

    public SiiTipoUbicacion buscarTipoUbicacionPorId(Long idTipoUbicacion) throws ExcepcionDAO {
        SiiTipoUbicacion siiTipoUbicacionRetorno = null;
        try {
            siiTipoUbicacionRetorno = (SiiTipoUbicacion) manager.find(SiiTipoUbicacion.class, idTipoUbicacion);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoUbicacionRetorno;
    }

    public List<SiiTipoUbicacion> buscarTodosTipoUbicacion() throws ExcepcionDAO {
        List<SiiTipoUbicacion> listaTipoUbicacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tUbicacion FROM SiiTipoUbicacion tUbicacion");
            Query query = manager.createQuery(sql.toString());
            listaTipoUbicacion = query.getResultList();


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaTipoUbicacion;
    }

    public List<SiiTipoUbicacion> buscarTipoUbicacionPorNombre(SiiTipoUbicacion unTipoUbicacion) throws ExcepcionDAO {
        List<SiiTipoUbicacion> tipoUbicacionRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT tUbicacion FROM SiiTipoUbicacion tUbicacion");
            sql.append(" WHERE tUbicacion.ubiNombre = : ubicacionNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ubicacionNombre", unTipoUbicacion.getTiuNombre());
            tipoUbicacionRetorno = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return tipoUbicacionRetorno;
    }
}
