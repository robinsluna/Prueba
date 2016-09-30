package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoFechaVO;

import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionLiquidacionVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ResolucionLiquidacionDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ResolucionLiquidacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiResolucionLiquid insertarResolucionLiq (SiiResolucionLiquid siiResolucionLiquid) throws ExcepcionDAO {
        try {
            manager.persist(siiResolucionLiquid);
            manager.flush();
            return siiResolucionLiquid;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ResolucionLiquidacionDAO");
        }
    }
    
    public SiiResolucionLiquid buscarResolucionLiquidPorId(Long codigo) throws ExcepcionDAO {
        try {
            return (SiiResolucionLiquid) manager.find(SiiResolucionLiquid.class, codigo);
        } catch (PersistenceException pe) {
            throw new ExcepcionDAO(recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema"), "ResolucionAutorizDAO");
        }
    }
    
    public SiiResolucionLiquid actualizarSiiResolucionLiquid(SiiResolucionLiquid siiResolucionLiquid) throws ExcepcionDAO {
        try {
            manager.merge(siiResolucionLiquid);
            manager.flush();
            return siiResolucionLiquid;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ResolucionLiquidacionDAO");
        }
    }
    
    public List<SiiResolucionLiquid> buscarSiiResolucionLiquidPorIdLiq(Long lcoCodigo) throws ExcepcionDAO {
        List<SiiResolucionLiquid> listaSiiResolucionLiquid = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiResolucionLiquid o INNER JOIN o.siiLiquidacionContrato lq WHERE lq.lcoCodigo = :lcoCodigo order by lq.lcoCodigo desc" );
            Query query = manager.createQuery(sql.toString());
            query.setParameter("lcoCodigo", lcoCodigo);
            listaSiiResolucionLiquid = query.getResultList();
            return listaSiiResolucionLiquid;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
    }
    
   
    
    
    
    
}
