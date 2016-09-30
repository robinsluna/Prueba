/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
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
public class OficLiqTipoApuestaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public OficLiqTipoApuestaDAO() {
        recursos = new Recursos();
    }

    public SiiOficLiqTipoApuesta buscarOficLiqTipoApuestaPorCodigo(Long idCodigoOficLiqTipoApuesta) throws ExcepcionDAO {
        SiiOficLiqTipoApuesta retorno = null;
        try {
            retorno = (SiiOficLiqTipoApuesta) manager.find(SiiOficLiqTipoApuesta.class, idCodigoOficLiqTipoApuesta);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;

    }

    public SiiOficLiqTipoApuesta insertarSiiOficLiqTipoApuesta(SiiOficLiqTipoApuesta oficLiqTipoApuesta) throws ExcepcionDAO {
        try {
            manager.persist(oficLiqTipoApuesta);
            manager.flush();
            return oficLiqTipoApuesta;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    public List<SiiOficLiqTipoApuesta> buscarTodoSiiOficLiqTipoApuesta() throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> listaOficLiqTipoApuesta = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOficLiqTipoApuesta o");
            Query query = manager.createQuery(sql.toString());
            listaOficLiqTipoApuesta = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaOficLiqTipoApuesta;
    }

    public List<SiiOficLiqTipoApuesta> buscarSiiOficLiqTipoApuestaPorOficioLiquidacion(Long oliCodigo) throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> listaOficLiqTipoApuesta = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOficLiqTipoApuesta o WHERE o.siiOficioLiquidacion.oliCodigo = :oliCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("oliCodigo", oliCodigo);
            listaOficLiqTipoApuesta = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaOficLiqTipoApuesta;
    }

    public List<SiiOficLiqTipoApuesta> buscarSiiOficLiqTipoApuestaNuevoPorOficioLiquidacion(Long oliCodigo) throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> listaOficLiqTipoApuesta = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ota FROM SiiOficLiqTipoApuesta ota WHERE ota.siiOficioLiquidacion.oliCodigo = :oliCodigo");
            sql.append(" AND ota.otaIndicadorLiq = 'N'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("oliCodigo", oliCodigo);
            listaOficLiqTipoApuesta = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaOficLiqTipoApuesta;
    }

    public List<SiiOficLiqTipoApuesta> buscarSiiOficLiqTipoApuestaPorCodigoEIndicador(Long idOficio, String indicador) throws ExcepcionDAO {
        List<SiiOficLiqTipoApuesta> listaOficLiqTipoApuesta = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOficLiqTipoApuesta o WHERE o.siiOficioLiquidacion.oliCodigo = :idOficio ");
            sql.append(" and o.otaIndicadorLiq = :indicador");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOficio", idOficio);
            query.setParameter("indicador", indicador);
            listaOficLiqTipoApuesta = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaOficLiqTipoApuesta;
    }

    public BigDecimal valorAutorizacionMensual(Long oliCodigo, String otaIndicadorLiq) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(o.otaDerExplMes+o.otaGasAdmin) FROM SiiOficLiqTipoApuesta o WHERE o.siiOficioLiquidacion.oliCodigo = :oliCodigo ");
            sql.append(" and o.otaIndicadorLiq = :otaIndicadorLiq");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("oliCodigo", oliCodigo);
            query.setParameter("otaIndicadorLiq", otaIndicadorLiq);
            return (BigDecimal) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficLiqTipoApuestaDAO");
        }
    }

    public BigDecimal valorAutorizacionGasAdmNumero(Long oliCodigo, String otaIndicadorLiq) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(o.otaGasAdmin) FROM SiiOficLiqTipoApuesta o WHERE o.siiOficioLiquidacion.oliCodigo = :oliCodigo ");
            sql.append(" and o.otaIndicadorLiq = :otaIndicadorLiq");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("oliCodigo", oliCodigo);
            query.setParameter("otaIndicadorLiq", otaIndicadorLiq);
            return (BigDecimal) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficLiqTipoApuestaDAO");
        }
    }

    public BigDecimal valorAutorizacionDerExpNumero(Long oliCodigo, String otaIndicadorLiq) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(o.otaDerExplMes) FROM SiiOficLiqTipoApuesta o WHERE o.siiOficioLiquidacion.oliCodigo = :oliCodigo ");
            sql.append(" and o.otaIndicadorLiq = :otaIndicadorLiq");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("oliCodigo", oliCodigo);
            query.setParameter("otaIndicadorLiq", otaIndicadorLiq);
            return (BigDecimal) query.getSingleResult();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OficLiqTipoApuestaDAO");
        }
    }
}
