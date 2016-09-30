/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 24-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class NovedadDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;

    public NovedadDAO() {
        recursos = new Recursos();
    }


    public SiiNovedad insertarSiiNovedad(SiiNovedad novedad) throws ExcepcionDAO {
        try {
            manager.persist(novedad);
            manager.flush();
    
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return novedad;
    }

    public SiiNovedad actualizarSiiNovedad(SiiNovedad novedad) throws ExcepcionDAO {
        try {
            manager.merge(novedad);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return novedad;
    }

    public SiiNovedad buscarNovedadPorId(Long novCodigo) throws ExcepcionDAO {
        SiiNovedad novedad = null;
        try {
            novedad = (SiiNovedad) manager.find(SiiNovedad.class, novCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return novedad;
    }

    public List<SiiNovedad> buscarNovedadesPorIdContrato(Long idContrato, boolean ordenFecha) throws ExcepcionDAO {
        List<SiiNovedad> novedades = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT nov FROM SiiNovedad nov WHERE nov.siiContrato.conCodigo = :idContrato");
            if(ordenFecha){
                sql.append(" ORDER BY nov.novFecha");
            }
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idContrato", idContrato);
            novedades = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return novedades;
    }

    public SiiSolicitudAutoriza buscarSolicitudAutorizaContratoNuevoPorIdContrato(Long conCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT sau.sau_codigo\n" + " FROM sii_Contrato co\n" + " JOIN Sii_Novedad nov\n" + " ON co.CON_CODIGO = nov.CON_CODIGO\n" + " JOIN sii_Solicitud_Autoriza sau\n" +
                       " ON nov.SAU_CODIGO = sau.SAU_CODIGO\n" + " JOIN sii_Tipo_Solic_Autoriza tsa\n" + " ON sau.TSA_CODIGO   = tsa.TSA_CODIGO\n" + " WHERE co.CON_CODIGO = #conCodigo\n" +
                       " AND tsa.tsa_nombre IN ('Contrato nuevo', 'Renovación contrato')");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            BigDecimal sauCodigo = (BigDecimal) query.getSingleResult();
            return solicitudAutorizaDao.buscarSolicitudAutorizacionPorCodigo(sauCodigo.longValue());
        } catch(NoResultException nre) {
            return new SiiSolicitudAutoriza();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public BigDecimal valorInicialContrato(Long idContrato) throws ExcepcionDAO {
        try {
            SiiSolicitudAutoriza solicitud = buscarSolicitudAutorizaContratoNuevoPorIdContrato(idContrato);
            if(solicitud.getSauCodigo() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT  o FROM SiiOficioLiquidacion o WHERE o.siiSolicitudAutoriza.sauCodigo = :sauCodigo");
                Query query = manager.createQuery(sql.toString());
                query.setParameter("sauCodigo", solicitud.getSauCodigo());
                SiiOficioLiquidacion oficio = (SiiOficioLiquidacion) query.getSingleResult();
                return Utilidades.redondear(oficio.getOliValorDerExpl().add(oficio.getOliValorGastAdm()));
            }
            else {
                return BigDecimal.ZERO;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    private SiiSolicitudAutoriza buscarSolicitudAutorizaPorOtroSi(Long idOtroSi) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT DISTINCT o.siiSolicitudAutoriza FROM SiiNovedad o WHERE o.siiOtrosi.osiCodigo = :idOtroSi AND o.siiSolicitudAutoriza.siiTipoSolicAutoriza.tsaNombre ='Otras Novedades'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOtroSi", idOtroSi);
            return (SiiSolicitudAutoriza) query.getSingleResult();

        } catch(NoResultException nre) {
            return new SiiSolicitudAutoriza();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public BigDecimal valorOtroSi(Long idOtroSi) throws ExcepcionDAO {
        try {
            SiiSolicitudAutoriza solicitud = buscarSolicitudAutorizaPorOtroSi(idOtroSi);
            if(solicitud.getSauCodigo() != null) {
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT  o FROM SiiOficioLiquidacion o WHERE o.siiSolicitudAutoriza.sauCodigo = :sauCodigo");
                Query query = manager.createQuery(sql.toString());
                query.setParameter("sauCodigo", solicitud.getSauCodigo());
                SiiOficioLiquidacion oficio = (SiiOficioLiquidacion) query.getSingleResult();
                return Utilidades.redondear(oficio.getOliValorDerExpl().add(oficio.getOliValorGastAdm()));
            }
            else {
                return BigDecimal.ZERO;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

    }


    /**
     * @author Giovanni
     * @param idOtrosi
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiNovedad> buscarNovedadesPorIdOtrosi(Long idOtrosi) throws ExcepcionDAO {
        List<SiiNovedad> siiNovedads = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT nov FROM SiiNovedad nov");
            sql.append(" WHERE nov.siiOtrosi.osiCodigo = :idOtrosi");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOtrosi", idOtrosi);
            siiNovedads = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiNovedads;
    }


    public List<SiiNovedad> buscarNovedadPorSolicitudAutotiza(Long sauCodigo) throws ExcepcionDAO {
        List<SiiNovedad> novedades = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiNovedad o WHERE o.siiSolicitudAutoriza.sauCodigo = :sauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("sauCodigo", sauCodigo);
            novedades = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return novedades;

    }

    public List<SiiNovedad> buscarNovedadesPorEstadoDeSolicitud(String estadoSolicitud) throws ExcepcionDAO {
        List<SiiNovedad> novedades = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiNovedad o WHERE o.siiSolicitudAutoriza.siiEstadoSolicAutoriz.esaNombre = :estadoSolicitud");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoSolicitud", estadoSolicitud);
            novedades = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return novedades;
    }


    public List<Long> buscarUltimasSolicitudeDelContrato(Long conCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT o.siiSolicitudAutoriza.sauCodigo FROM SiiNovedad o WHERE o.siiContrato.conCodigo = :conCodigo ORDER BY o.siiSolicitudAutoriza.sauCodigo DESC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

}

