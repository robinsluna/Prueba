package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
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
public class ResolucionAutorizDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public ResolucionAutorizDAO() {
        recursos = new Recursos();

    }

    public List<SiiResolucionAutoriz> buscarTodaResolucionAutoriz() throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o");
            Query query = manager.createQuery(sql.toString());

            resolucionesAutoriz = query.getResultList();
        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
        return resolucionesAutoriz;

    }

    public List<SiiResolucionAutoriz> buscarTodaResolucionAutorizLeftJoinSolicitudAutoriza() throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o LEFT JOIN o.siiSolicitudAutoriza s");
            Query query = manager.createQuery(sql.toString());

            resolucionesAutoriz = query.getResultList();
        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
        return resolucionesAutoriz;

    }


    public List<SiiSolicitudAutoriza> buscarTodaSolicitudAutorizLeftJoinResolucionAutoriz() throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> solicitudesAutoriza;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiSolicitudAutoriza o LEFT JOIN o.siiResolucionAutorizList r");
            Query query = manager.createQuery(sql.toString());

            solicitudesAutoriza = query.getResultList();
        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
        return solicitudesAutoriza;

    }

    public List<SiiResolucionAutoriz> buscarTodaResolucionAutorizOuterJoinSolicitudes() throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT r FROM SiiSolicitudAutoriza o LEFT JOIN o.siiResolucionAutorizList r");
            Query query = manager.createQuery(sql.toString());

            resolucionesAutoriz = query.getResultList();
        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
        return resolucionesAutoriz;

    }

    public SiiResolucionAutoriz insetarResolucionAutoriz(SiiResolucionAutoriz resolucionAutoriz) throws ExcepcionDAO {
        try {
            manager.persist(resolucionAutoriz);
            manager.flush();
            return resolucionAutoriz;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResolucionAutorizDAO");
        }


    }

    public SiiResolucionAutoriz actualizarResolucionAutoriz(SiiResolucionAutoriz resolucionAutoriz) throws ExcepcionDAO {
        try {
            manager.merge(resolucionAutoriz);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        }
        return resolucionAutoriz;

    }

    public SiiResolucionAutoriz buscarResolucionAutorizPorId(Long codigo) throws ExcepcionDAO {
        try {
            return (SiiResolucionAutoriz) manager.find(SiiResolucionAutoriz.class, codigo);
        } catch (PersistenceException pe) {
            throw new ExcepcionDAO(recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema"), "ResolucionAutorizDAO");
        }

    }

    public List<SiiResolucionAutoriz> buscarResolucionAutorizPorSolicitudAutoriza(Long sauCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.sauCodigo = :sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }


    }

    public List<SiiResolucionAutoriz> buscarResolucionAutorizPorEstadoSolicitudAutoriza(String estado,
                                                                                        String condicionTipoSolicitud) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaNombre = :estado " +
                       condicionTipoSolicitud);
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }


    }

    public List<SiiResolucionAutoriz> buscarResolucionAutorizPorEstadoSolicitudAutoriza(Long estado,
                                                                                        String condicionTipoSolicitud) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaCodigo = :estado " +
                       condicionTipoSolicitud);
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }


    }

    public List<SiiResolucionAutoriz> resolucionesAutorizPorEstadoSolicitudPorUsuario(String estado,
                                                                                      String condicionTipoSolicitud,
                                                                                      Long usuCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaNombre = :estado " +
                       condicionTipoSolicitud + " AND o.siiSolicitudAutoriza.siiUsuario.usuCodigo = :usuCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("usuCodigo", usuCodigo);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }

    }

    public List<SiiResolucionAutoriz> resolucionesAutorizPorEstadoSolicitudPorUsuario(Long estado,
                                                                                      String condicionTipoSolicitud,
                                                                                      Long usuCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaCodigo = :estado " +
                       condicionTipoSolicitud + " AND o.siiSolicitudAutoriza.siiUsuario.usuCodigo = :usuCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            query.setParameter("usuCodigo", usuCodigo);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }

    }

    public List<SiiResolucionAutoriz> buscarResolucionAutorizPorTipoSolicitud(String tipoSolicitud) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiTipoSolicAutoriza.tsaNombre = :tipoSolicitud ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoSolicitud", tipoSolicitud);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
    }

    public List<SiiResolucionAutoriz> buscarResolucionAutorizPorTipoSolicitud(Long tipoSolicitud) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiTipoSolicAutoriza.tsaCodigo = :tipoSolicitud ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoSolicitud", tipoSolicitud);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
    }

    public List<SiiResolucionAutoriz> resolucionesAutorizPorTipoSolicitudPorUsuario(String tipoSolicitud,
                                                                                    Long usuCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiTipoSolicAutoriza.tsaNombre = :tipoSolicitud AND o.siiSolicitudAutoriza.siiUsuario.usuCodigo = :usuCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoSolicitud", tipoSolicitud);
            query.setParameter("usuCodigo", usuCodigo);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
    }

    public List<SiiResolucionAutoriz> resolucionesAutorizPorTipoSolicitudPorUsuario(Long tipoSolicitud,
                                                                                    Long usuCodigo) throws ExcepcionDAO {
        List<SiiResolucionAutoriz> resolucionesAutoriz;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiResolucionAutoriz o WHERE o.siiSolicitudAutoriza.siiTipoSolicAutoriza.tsaCodigo = :tipoSolicitud AND o.siiSolicitudAutoriza.siiUsuario.usuCodigo = :usuCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoSolicitud", tipoSolicitud);
            query.setParameter("usuCodigo", usuCodigo);
            resolucionesAutoriz = query.getResultList();
            return resolucionesAutoriz;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ResolucionAutorizDAO");

        }
    }

}
