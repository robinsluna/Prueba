package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucionLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoResolucionLiqDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoResolucionLiqDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoResolucLiq buscarEstadoResolucionLiqXId(Long  idEstadoResLiq) throws ExcepcionDAO {
        SiiEstadoResolucLiq retornoSiiEstadoResolucLiq = null;
        try {
            retornoSiiEstadoResolucLiq = (SiiEstadoResolucLiq) manager.find(SiiEstadoResolucLiq.class, idEstadoResLiq);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionContratoDAO");
        }
        return retornoSiiEstadoResolucLiq;

    }
    
    
    
    public EstadoResolucionLiqVO  buscarEstadoResolucLiqPorEstado(String nombreEstado) throws ExcepcionDAO {
                
        EstadoResolucionLiqVO estadoResolucionLiqVo = new EstadoResolucionLiqVO();
        
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoResolucLiq o WHERE o.erlNombre like :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado",nombreEstado);
              List< SiiEstadoResolucLiq> listaEstadoResolucLiq  =  query.getResultList();
            
            if (listaEstadoResolucLiq != null && !listaEstadoResolucLiq.isEmpty()) {
                SiiEstadoResolucLiq siiEstadoResolucLiq = listaEstadoResolucLiq.get(0);
                estadoResolucionLiqVo = new EstadoResolucionLiqVO(siiEstadoResolucLiq);
            }
            
            return estadoResolucionLiqVo;
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoResolucionLiqDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoResolucAutDAO");
        }
        
    }
    
}
