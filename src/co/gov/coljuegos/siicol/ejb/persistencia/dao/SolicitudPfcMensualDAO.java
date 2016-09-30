/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPfcAnual;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetallePFCMensualVO;

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
public class SolicitudPfcMensualDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public SolicitudPfcMensualDAO() {
        recursos = new Recursos();
    }
    
    public SiiSolicitudPfcMens buscarSolicitudPfcMensPorId(Long idSolicitudPfcMens) throws ExcepcionDAO{
        SiiSolicitudPfcMens siiSolicitudPfcMensRetorno = null;
        try{
            siiSolicitudPfcMensRetorno = (SiiSolicitudPfcMens) manager.find(SiiSolicitudPfcMens.class, idSolicitudPfcMens);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return siiSolicitudPfcMensRetorno;
    }
    
    public SiiSolicitudPfcMens buscarPorCodigoSpfcm(Long idSolicPfcm) throws ExcepcionDAO {
        SiiSolicitudPfcMens siiSolicitudPfcMensRetorno = null;
        try {
            siiSolicitudPfcMensRetorno =(SiiSolicitudPfcMens) manager.find(SiiSolicitudPfcMens.class, idSolicPfcm);
         
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicitudPfcMensualDAO");
        }
        return siiSolicitudPfcMensRetorno;
    }
    
    public SiiSolicitudPfcMens insertarSolicPfcm(SiiSolicitudPfcMens siiSolicitudPfcMens) throws ExcepcionDAO {
        try {
            manager.persist(siiSolicitudPfcMens);                                                            //La guarda en el almacen
            manager.flush();                                                                                 //Pasa a la Bd
            return siiSolicitudPfcMens;                                                                      //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicitudPfcMensualDAO");
        }
    }
    
    public SiiSolicitudPfcMens actualizarSolicPfcm(SiiSolicitudPfcMens siiSolicitudPfcMens) throws ExcepcionDAO {
        try {
            manager.merge(siiSolicitudPfcMens);                                                                           
            manager.flush();                                                                                             
           return siiSolicitudPfcMens;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPfcMensualDAO");
        }
    }
    
    public List<SiiSolicitudPfcMens> buscarTodaSolicitudPfcm() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solicPfcm FROM SiiSolicitudPfcMens solicPfcm");
            Query query = manager.createQuery(sql.toString());
            List<SiiSolicitudPfcMens> listaSolicPfcm = query.getResultList();
            
            return listaSolicPfcm;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPfcMensualDAO");
        }
    }
    
    public SiiSolicitudPfcMens buscarTodaSolicitudPfcmxVigenciMes(Integer vigencia,Integer mes) throws ExcepcionDAO {
        try {
        SiiSolicitudPfcMens siiSolicitudPfcMensRetorno=null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT solicPfcm FROM SiiSolicitudPfcMens solicPfcm");
            sql.append(" WHERE solicPfcm.siiMes1.mesCodigo = :mes");
            sql.append(" and solicPfcm.spfVigencia = :vigencia");            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mes", mes);
            query.setParameter("vigencia", vigencia);
            List<SiiSolicitudPfcMens> listaSiiModificPfcAnual= query.getResultList();
            
            if (listaSiiModificPfcAnual != null && !listaSiiModificPfcAnual.isEmpty()) {
                siiSolicitudPfcMensRetorno = listaSiiModificPfcAnual.get(0);
            }
            return siiSolicitudPfcMensRetorno;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPfcMensualDAO");
        }
    }
    
    
    public List<SiiSolicitudPfcMens> buscarTodaSolicitudPfcmNacion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT solicPfcm FROM SiiSolicitudPfcMens solicPfcm");
            sql.append(" WHERE  solicPfcm.siiEstadoSolicPfcm.espNombre='APROBADO TESORERIA' ");
            sql.append(" or solicPfcm.siiEstadoSolicPfcm.espNombre='CERRADO MHCP' ");
            sql.append(" or solicPfcm.siiEstadoSolicPfcm.espNombre='APROBADO MHCP' ");
            Query query = manager.createQuery(sql.toString());
            List<SiiSolicitudPfcMens> listaSolicPfcm = query.getResultList();
            
            return listaSolicPfcm;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPfcMensualDAO");
        }
    }
    
    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObli(RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO{
        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetallePFCMensualVo= new ArrayList<RubroFuenteDetallePFCMensualVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("  select * from (select distinct ");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append("  dru.dru_codigo,dpf.dpf_valor_aprobado,dpf.dpf_codigo");
            sql.append(" from sii_proyeccion_flujo_caja pfc");
            sql.append(" inner join sii_estado_pfc epf on pfc.epf_codigo=epf.epf_codigo");
            sql.append(" inner join sii_distribucion_pfc dpf on pfc.pfc_codigo=dpf.pfc_codigo");
            sql.append(" inner join sii_detalle_rubro dru on dpf.dru_codigo=dru.dru_codigo");
            sql.append(" inner join sii_dtlle_fuente_financiacion dff on dru.dff_codigo=dff.dff_codigo");
            sql.append(" inner join sii_fuente_financiacion ffi on dff.ffi_codigo=ffi.ffi_codigo");
            sql.append(" inner join pr_rubro Rubro on rubro.vigencia= dru.vigencia and rubro.interno=dru.interno");
            sql.append(" inner join sii_detalle_rubro_cdp drc on dru.dru_codigo=drc.dru_codigo");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where dpf.mes_codigo=#mes and pfc.pfc_vigencia=#vigencia)");
            sql.append(" order by cadena asc");
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("mes",rubroFuenteDetPFCMensualVo.getMes());
            query.setParameter("vigencia",rubroFuenteDetPFCMensualVo.getVigencia());            
            List<Object[]> results = query.getResultList();
            
            
            for(Object[] object : results){
                RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMenVo = new RubroFuenteDetallePFCMensualVO();                               
                rubroFuenteDetPFCMenVo.setCadena((String) object[0]);   
                rubroFuenteDetPFCMenVo.setCodigoDetalleRubro(((BigDecimal) object[1]).longValue());
                rubroFuenteDetPFCMenVo.setDpfValorPFCAnual((BigDecimal) object[2]);
                rubroFuenteDetPFCMenVo.setCodigoDistribucion(((BigDecimal) object[3]).longValue());
                //rubroFuenteDetPFCMenVo.setDpfValorPFCMensual((BigDecimal) object[3]);
                
                listaRubroFuenteDetallePFCMensualVo.add(rubroFuenteDetPFCMenVo);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
        }
        
        return listaRubroFuenteDetallePFCMensualVo;
    }
    
    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObliNacion (RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO{
        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetallePFCMensualVo= new ArrayList<RubroFuenteDetallePFCMensualVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("  select * from (select distinct ");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append("  dru.dru_codigo,dpf.dpf_valor_aprobado");
            sql.append(" from sii_proyeccion_flujo_caja pfc");
            sql.append(" inner join sii_estado_pfc epf on pfc.epf_codigo=epf.epf_codigo");
            sql.append(" inner join sii_distribucion_pfc dpf on pfc.pfc_codigo=dpf.pfc_codigo");
            sql.append(" inner join sii_detalle_rubro dru on dpf.dru_codigo=dru.dru_codigo");
            sql.append(" inner join sii_dtlle_fuente_financiacion dff on dru.dff_codigo=dff.dff_codigo");
            sql.append(" inner join sii_fuente_financiacion ffi on dff.ffi_codigo=ffi.ffi_codigo");
            sql.append(" inner join pr_rubro Rubro on rubro.vigencia= dru.vigencia and rubro.interno=dru.interno");
            sql.append(" inner join sii_detalle_rubro_cdp drc on dru.dru_codigo=drc.dru_codigo");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where dpf.mes_codigo=#mes and pfc.pfc_vigencia=#vigencia and ffi.ffi_Nombre='NACION')");
            sql.append(" order by cadena asc");
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("mes",rubroFuenteDetPFCMensualVo.getMes());
            query.setParameter("vigencia",rubroFuenteDetPFCMensualVo.getVigencia());            
            List<Object[]> results = query.getResultList();
            
            
            for(Object[] object : results){
                RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMenVo = new RubroFuenteDetallePFCMensualVO();                               
                rubroFuenteDetPFCMenVo.setCadena((String) object[0]);   
                rubroFuenteDetPFCMenVo.setCodigoDetalleRubro(((BigDecimal) object[1]).longValue());
                rubroFuenteDetPFCMenVo.setDpfValorPFCAnual((BigDecimal) object[2]);
                //rubroFuenteDetPFCMenVo.setDpfValorPFCMensual((BigDecimal) object[3]);
                
                listaRubroFuenteDetallePFCMensualVo.add(rubroFuenteDetPFCMenVo);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
        }
        
        return listaRubroFuenteDetallePFCMensualVo;
    }
    
    
    
    
    
    
    
}
