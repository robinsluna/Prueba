package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.EstudioMercadoVO;

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
public class EstudioMercadoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public EstudioMercadoDAO() {
        recursos = new Recursos();

    }

    public SiiEstudioMercado buscarEstudioMercadoPorId(Long idEstudioMercado) throws ExcepcionDAO {
        SiiEstudioMercado localEstudioMercado = null;
        try {
            localEstudioMercado = (SiiEstudioMercado) manager.find(SiiEstudioMercado.class, idEstudioMercado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }
        return localEstudioMercado;
    }

    public SiiEstudioMercado buscarEstudioMercadoPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {

        SiiEstudioMercado estudioMercado = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiEstudioMercado o WHERE o.siiProcesoContratacion1.prcCodigo = :idProcesoContratacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);
            List<SiiEstudioMercado> listaEstudioMercado =  query.getResultList();
            if (listaEstudioMercado.isEmpty()) {
                
            } else {
                estudioMercado = listaEstudioMercado.get(0);
            }

        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstudioMercadoDAO");

        }
        return estudioMercado;
    }

    public SiiEstudioMercado insertarEstudioMercado(SiiEstudioMercado estudioMercado) throws ExcepcionDAO {
        try {
            manager.persist(estudioMercado);
            manager.flush();
            return estudioMercado;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }

    }

    public SiiEstudioMercado actualizarEstudioMercado(SiiEstudioMercado estudioMercado) throws ExcepcionDAO {
        try {
            manager.merge(estudioMercado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }
        return estudioMercado;
    }

    public void eliminarEstudioMercado(Long idEstudioMercado) throws ExcepcionDAO {
        SiiEstudioMercado localEstudioMercado = null;
        try {
            localEstudioMercado = (SiiEstudioMercado) manager.find(SiiEstudioMercado.class, idEstudioMercado);
            manager.remove(localEstudioMercado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }
    }

    public List<SiiEstudioMercado> buscarTodoEstudioMercado() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstudioMercado o");
            //sql.append(" where o.estudioMercado.emeCodigo=:codigo");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("codigo", estudioMercado.getEmeCodigo());
            List<SiiEstudioMercado> listaEstudioMercado = query.getResultList();
            return listaEstudioMercado;


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }
    }

    public List<SiiEstudioMercado> buscarEstudiosMercadoPorEstado(String estado) throws ExcepcionDAO {
        List<SiiEstudioMercado> localEstudioMercado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiEstudioMercado o JOIN o.siiEstadoEstudioMerc");
            sql.append(" WHERE o.eemNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            localEstudioMercado = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstudioMercadoDAO");
        }
        return localEstudioMercado;
    }
}
