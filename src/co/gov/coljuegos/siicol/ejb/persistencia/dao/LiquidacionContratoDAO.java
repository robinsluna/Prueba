package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCausalTermContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoLiquidCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionLiquid;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.LiquidacionContratoVO;

import co.gov.coljuegos.siicol.ejb.vo.ResolucionLiquidacionVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LiquidacionContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public LiquidacionContratoDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiLiquidacionContrato buscarLiquidacionContratoXId(Long  idLiqContrato) throws ExcepcionDAO {
        SiiLiquidacionContrato retornoSiiLiquidacionContrato = null;
        try {
            retornoSiiLiquidacionContrato = (SiiLiquidacionContrato) manager.find(SiiLiquidacionContrato.class, idLiqContrato);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionContratoDAO");
        }
        return retornoSiiLiquidacionContrato;

    }
    
    public SiiLiquidacionContrato insertarLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) throws ExcepcionDAO{

            try {
                manager.persist(siiLiquidacionContrato); //La guarda en el almacen
                manager.flush(); //Pasa a la Bd
                //Retorna la Entidad
            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionMesDAO");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return siiLiquidacionContrato;
    }
    
    
    public List<SiiLiquidacionContrato> buscarTodosLiquidacionContrato() throws ExcepcionDAO{
            try{
                List<SiiLiquidacionContrato> listaLiquidacionContrato = null;
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT liq FROM SiiLiquidacionContrato liq order by liq.lcoCodigo desc   ");
                Query query = manager.createQuery(sql.toString());
                listaLiquidacionContrato = query.getResultList();
                return listaLiquidacionContrato;
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
            }
        }
    
    public SiiLiquidacionContrato actualizarLiquidacionContrato(SiiLiquidacionContrato siiLiquidacionContrato) throws ExcepcionDAO {
        try {
            manager.merge(siiLiquidacionContrato);
            manager.flush();
            return siiLiquidacionContrato;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpDAO");
        }
    }
    
    
    public LiquidacionContratoVO buscarLiquidacionContratoPorContrato(String conNumero) throws ExcepcionDAO{
            LiquidacionContratoVO  liquidacionContratoVo = new LiquidacionContratoVO();
            SiiLiquidacionContrato siiLiquidacionContrato = new  SiiLiquidacionContrato();
            try{
                List<SiiLiquidacionContrato> listaLiquidacionContrato = null;
                
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT liq FROM SiiLiquidacionContrato liq ");
                sql.append(" INNER JOIN liq.siiContrato c ");
                sql.append(" where c.conNumero = :conNumero");
                Query query = manager.createQuery(sql.toString());
                query.setParameter("conNumero", conNumero);
                listaLiquidacionContrato = query.getResultList();
                if (listaLiquidacionContrato != null && !listaLiquidacionContrato.isEmpty()) {
                    siiLiquidacionContrato = listaLiquidacionContrato.get(0);
                    liquidacionContratoVo= new LiquidacionContratoVO(siiLiquidacionContrato);
                }
                
                return liquidacionContratoVo;
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
            }
        }
    
    public List<LiquidacionContratoVO>  listaLiquidacionNotificada() throws ExcepcionDAO {
        try {
            List<LiquidacionContratoVO>  listLiquidacionContratoVo= new ArrayList();
            StringBuilder sql = new StringBuilder();
        
            sql.append("    select distinct lq.lco_codigo,lq.elc_codigo   from  sii_liquidacion_contrato lq ");
            sql.append("    inner join sii_resolucion_liquid rl on rl.lco_codigo = lq.lco_codigo");
            sql.append("    where lq.lco_codigo in (");
            sql.append("    select distinct  l.lco_codigo from  sii_liquidacion_contrato l ");
            sql.append("    inner join sii_resolucion_liquid rl on rl.lco_codigo = l.lco_codigo");
            sql.append("    inner join sii_log_cambio_estado lo on rl.erl_codigo=lo.lce_estado_nuevo AND rl.rli_codigo=lo.lce_codigo_doc  ");
            sql.append("    inner join sii_estado_resoluc_liq lq on lo.lce_estado_nuevo=lq.erl_codigo");
            sql.append("    where rl.rli_tipo_res='R' and lq.erl_nombre='NOTIFICADO' "); //and rl.rli_fecha <   to_char(sysdate, 'dd/MM/yyyy') ");
            sql.append("    and  l.lco_codigo in ( ");
            sql.append("    select distinct l.lco_codigo  from  sii_liquidacion_contrato l ");
            sql.append("    inner join sii_resolucion_liquid rl on rl.lco_codigo = l.lco_codigo");
            sql.append("    inner join sii_log_cambio_estado lo on rl.erl_codigo=lo.lce_estado_nuevo AND rl.rli_codigo=lo.lce_codigo_doc  ");
            sql.append("    inner join sii_estado_resoluc_liq lq on lo.lce_estado_nuevo=lq.erl_codigo");
            sql.append("    where rl.rli_tipo_res='L' and lq.erl_nombre='NOTIFICADO') )");          
            
            Query query = manager.createNativeQuery(sql.toString());
            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
              
                  for (Object[] object : results) {
                      
                      LiquidacionContratoVO liquidacionContratoVo = new LiquidacionContratoVO();
                      liquidacionContratoVo.setLcoCodigo(((BigDecimal)object[0]).longValue());
                      listLiquidacionContratoVo.add(liquidacionContratoVo);
                  }
            }     
        
            return listLiquidacionContratoVo ;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LogCambioEstadoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

    }
    
    
}
