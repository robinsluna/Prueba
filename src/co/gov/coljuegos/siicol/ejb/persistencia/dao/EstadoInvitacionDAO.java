package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoInvitacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoInvitacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoInvitacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoInvitacion buscarEstadoInvitacionPorId(Long einCodigo) throws ExcepcionDAO {
        SiiEstadoInvitacion localEstadoInvitacion = null;
        try {
            localEstadoInvitacion = (SiiEstadoInvitacion) manager.find(SiiEstadoInvitacion.class, einCodigo);
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoInvitacionDAO");
        }
        return localEstadoInvitacion;
    }
    
    public SiiEstadoInvitacion insertarEstadoInvitacion(SiiEstadoInvitacion estadoInvitacion) throws ExcepcionDAO {
        try {
            manager.persist(estadoInvitacion);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoInvitacionDAO");
        }
        return estadoInvitacion;
    }
    
    public SiiEstadoInvitacion actualizarEstadoInvitacion(SiiEstadoInvitacion estadoInvitacion) throws ExcepcionDAO {
        try {
            manager.merge(estadoInvitacion);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoInvitacionDAO");
        }
        return estadoInvitacion;
    }
    
    public void eliminarEstadoInvitacion(long einCodigo) throws ExcepcionDAO {
        SiiEstadoInvitacion localEstadoInvitacion;
        try {
            localEstadoInvitacion = (SiiEstadoInvitacion) manager.find(SiiEstadoInvitacion.class, einCodigo);
            manager.remove(localEstadoInvitacion);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO","mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoInvitacionDAO");
        }
    }
    
    public List<SiiEstadoInvitacion> buscarTodoEstadoInvitacion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoInvitacion o");
            Query query = manager.createQuery(sql.toString());
            List<SiiEstadoInvitacion> listaEstadoInvitacion = query.getResultList();
            return listaEstadoInvitacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoInvitacionDAO");
        }
    }
    
    public List<SiiEstadoInvitacion> buscarEstadoInvitacion(String estado) throws ExcepcionDAO {
        List<SiiEstadoInvitacion> listaEstadoInvitacion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiEstadoInvitacion o WHERE o.siiEstadoInvitacion.einNombre = :estado ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaEstadoInvitacion = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoInvitacionDAO");
        }
        return listaEstadoInvitacion;
    }
}
