package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
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
public class EstadoEstudioMercDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public EstadoEstudioMercDAO() {
        recursos = new Recursos();

    }

    public SiiEstadoEstudioMerc buscarEstadoEstudioMercPorId(Long idEstadoEstudioMercado) throws ExcepcionDAO {
        SiiEstadoEstudioMerc localEstadoEstudioMerc = null;
        try {
            localEstadoEstudioMerc =
                (SiiEstadoEstudioMerc) manager.find(SiiEstadoEstudioMerc.class, idEstadoEstudioMercado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
        return localEstadoEstudioMerc;
    }
    
    public SiiEstadoEstudioMerc insertarEstadoEstudioMerc(SiiEstadoEstudioMerc estadoEstudioMerc) throws ExcepcionDAO {
        try {
            manager.persist(estadoEstudioMerc);
            manager.flush();
            return estadoEstudioMerc;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
    }

    public SiiEstadoEstudioMerc actualizarEstadoEstudioMerc(SiiEstadoEstudioMerc estadoEstudioMerc) throws ExcepcionDAO {
        try {
            manager.merge(estadoEstudioMerc);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
        return estadoEstudioMerc;
    }

    public void eliminarEstadoEstudioMerc(Long idEstadoEstudioMercado) throws ExcepcionDAO {
        SiiEstadoEstudioMerc localEstadoEstudioMerc = null;
        try {
            localEstadoEstudioMerc = (SiiEstadoEstudioMerc) manager.find(SiiEstadoEstudioMerc.class, idEstadoEstudioMercado);
            manager.remove(localEstadoEstudioMerc);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
    }

    public List<SiiEstadoEstudioMerc> buscarTodoEstadoEstudioMerc() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoEstudioMerc o");
            //sql.append(" where o.estadoEstudioMercado.eemCodigo=:codigo");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("codigo", estadoEstudioMerc.getEemCodigo());
            List<SiiEstadoEstudioMerc> listaEstadoEstudioMerc = query.getResultList();
            return listaEstadoEstudioMerc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
    }


}
