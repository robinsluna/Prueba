package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;
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

public class EstadoAlcanceInvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoAlcanceInvDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoAlcanceInv buscarEstadoAlcanceInvPorId(Long eaiCodigo) throws ExcepcionDAO {
        SiiEstadoAlcanceInv localEstadoAlcanceInv = null;
        try {
            localEstadoAlcanceInv = (SiiEstadoAlcanceInv) manager.find(SiiEstadoAlcanceInv.class, eaiCodigo);
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoAlcanceInvDAO");
        }
        return localEstadoAlcanceInv;
    }
    
    public SiiEstadoAlcanceInv insertarEstadoAlcanceInv(SiiEstadoAlcanceInv estadoAlcanceInv) throws ExcepcionDAO {
        try {
            manager.persist(estadoAlcanceInv);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoAlcanceInvDAO");
        }
        return estadoAlcanceInv;
    }
    
    public SiiEstadoAlcanceInv actualizarEstadoAlcanceInv(SiiEstadoAlcanceInv estadoAlcanceInv) throws ExcepcionDAO {
        try {
            manager.merge(estadoAlcanceInv);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoAlcanceInvDAO");
        }
        return estadoAlcanceInv;
    }
    
    public void eliminarEstadoAlcanceInv(long eaiCodigo) throws ExcepcionDAO {
        SiiEstadoAlcanceInv localEstadoAlcanceInv;
        try {
            localEstadoAlcanceInv = (SiiEstadoAlcanceInv) manager.find(SiiEstadoAlcanceInv.class, eaiCodigo);
            manager.remove(localEstadoAlcanceInv);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO","mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoAlcanceInvDAO");
        }
    }
    
    public List<SiiEstadoAlcanceInv> buscarTodoEstadoAlcanceInv() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoAlcanceInv o");
            Query query = manager.createQuery(sql.toString());
            List<SiiEstadoAlcanceInv> listaEstadoAlcanceInv = query.getResultList();
            return listaEstadoAlcanceInv;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoAlcanceInvDAO");
        }
    }
    
    public List<SiiEstadoAlcanceInv> buscarEstadoAlcanceInv(String estado) throws ExcepcionDAO {
        List<SiiEstadoAlcanceInv> listaEstadoAlcanceInv = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiEstadoAlcanceInv o WHERE o.eaiNombre = :estado ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            listaEstadoAlcanceInv = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoAlcanceInvDAO");
        }
        return listaEstadoAlcanceInv;
    }
}
