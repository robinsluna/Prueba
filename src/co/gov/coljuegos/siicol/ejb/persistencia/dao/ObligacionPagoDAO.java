package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.MesVO;
import co.gov.coljuegos.siicol.ejb.vo.NivelRubroDetFuenteValorVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;


import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoDocSoporteVO;

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
public class ObligacionPagoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ObligacionPagoDAO() {
        recursos = new Recursos();
    }
    
    public SiiObligacionPago insertarObligacionPago(SiiObligacionPago obligacionPago) throws ExcepcionDAO{
        try{
            manager.persist(obligacionPago);                                                                                
            manager.flush();                                                                                                     
            return obligacionPago;                                                                                        
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
    }
    
    
    public SiiObligacionPago buscarObligacionPagoPorId(Long idObligacionPago) throws ExcepcionDAO{
        SiiObligacionPago obligacionPagoRetorno = null;
        try{
            obligacionPagoRetorno = (SiiObligacionPago) manager.find(SiiObligacionPago.class, idObligacionPago);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");            
        }
        return obligacionPagoRetorno;
    }
    
    
    public SiiObligacionPago actualizarObligacionPago(SiiObligacionPago obligacionPago) throws ExcepcionDAO{
        try{            
            manager.merge(obligacionPago);
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");            
        }
        return obligacionPago;
    }
    
        public List<SiiObligacionPago> buscarTodoObligacionPago()
                throws ExcepcionDAO{
            try{
                List<SiiObligacionPago> listaObligacionPago = new ArrayList();           
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT oblPago FROM SiiObligacionPago oblPago");
                Query query = manager.createQuery(sql.toString());
                listaObligacionPago= query.getResultList();
                return listaObligacionPago;
                
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
            }
        }    
        
    public List<ObligacionPagoVO>  buscarObligacionPagoXCamposSinId(SiiObligacionPago obligacionPago ) throws ExcepcionDAO{
        List<ObligacionPagoVO> listaObligacionesRetornoVo= new ArrayList<ObligacionPagoVO>();
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * FROM sii_Obligacion_Pago opa ");
            sql.append("WHERE opa.opa_vigencia=#vigencia ");
            sql.append("and opa.mes_Codigo_pago=#mesPago ");
            sql.append("and opa.opa_Numero_Doc_Sop=#docSoporte ");
            sql.append("and opa.tds_codigo=#tipDoc ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("vigencia", obligacionPago.getOpaVigencia());
            query.setParameter("mesPago", obligacionPago.getSiiMes1().getMesCodigo());
            query.setParameter("docSoporte", obligacionPago.getOpaNumeroDocSop());
            query.setParameter("tipDoc", obligacionPago.getSiiTipoDocSoporte().getTdsCodigo());
            
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
                ObligacionPagoVO obligacionPagoVo = new ObligacionPagoVO();         
                TipoDocSoporteVO tipoDocSoporteVo = new TipoDocSoporteVO();
                MesVO unMesVo = new MesVO();
                MesVO unMes1Vo = new MesVO();
                obligacionPagoVo.setOpaCodigo(((BigDecimal) object[0]).longValue());   
                obligacionPagoVo.setOpaVigencia(((BigDecimal) object[1]).intValue());
                tipoDocSoporteVo.setTdsCodigo((((BigDecimal) object[2]).longValue()));
                obligacionPagoVo.setTipoDocSoporteVo(tipoDocSoporteVo);
                unMesVo.setMesCodigo(((BigDecimal) object[3]).intValue());
                obligacionPagoVo.setMesVo(unMesVo);
                obligacionPagoVo.setOpaNumeroDocSop((String) object[4]);
                unMes1Vo.setMesCodigo(((BigDecimal) object[5]).intValue());
                obligacionPagoVo.setMes1Vo(unMes1Vo);
               
                listaObligacionesRetornoVo.add(obligacionPagoVo);
            }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return listaObligacionesRetornoVo;
    }    
    public List<RubroFuenteDetalleFuenteRpVO> buscarListaFuenteDetallefuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFDFuenteRpVo) throws ExcepcionDAO{
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo= new ArrayList<RubroFuenteDetalleFuenteRpVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select distinct rdr.rdr_valor,drc.drc_codigo,odr.odr_codigo,odr.odr_valor_pagar,");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,dr.dru_codigo,rp.rp_codigo");
            sql.append(" from sii_obligacion_pago opa");
            sql.append(" inner join sii_oblig_det_rubro_cdp  odr on opa.opa_codigo=odr.opa_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr on odr.rdr_codigo=rdr.rdr_codigo ");
            sql.append(" inner join sii_rp rp on rdr.rp_codigo=rp.rp_codigo");
            sql.append(" inner join sii_detalle_rubro dr on drc.dru_codigo=dr.dru_codigo");
            sql.append(" inner join sii_estado_rp erp on rp.erp_codigo=erp.erp_codigo");
            sql.append(" inner join Pr_Rubro Rubro  on dr.vigencia=Rubro.vigencia and dr.interno=Rubro.interno");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where  opa.opa_codigo=#idObligacion ");
            sql.append(" order by cadena asc");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idObligacion",rubroFDFuenteRpVo.getRfdidObligacion());   
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
                RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo = new RubroFuenteDetalleFuenteRpVO();                               
                rubroFuenteDetallefuenteRpVo.setRfdValorRp((BigDecimal) object[0]);   
                rubroFuenteDetallefuenteRpVo.setRdfCodigoDetalleRubroCdp(((BigDecimal) object[1]).longValue());
                if( object[4] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdCodigoDetalleObligacion(((BigDecimal) object[2]).longValue());
                }
                if( object[5] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdValoraPagar((BigDecimal) object[3]);
                }
                rubroFuenteDetallefuenteRpVo.setRdfCadena((String) object[4]);
                if( object[7] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdidDetalleRubro(((BigDecimal) object[5]).longValue());
                }
                listaRubroFuenteDetallefuenteRpVo.add(rubroFuenteDetallefuenteRpVo);
                rubroFuenteDetallefuenteRpVo.setCodigoRp(((BigDecimal) object[6]).longValue());
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
        }
        
        return listaRubroFuenteDetallefuenteRpVo;
    }
    
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFDFuenteRpVo) throws ExcepcionDAO{
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo= new ArrayList<RubroFuenteDetalleFuenteRpVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select rdr.rdr_valor,ffi.ffi_codigo,dtff.dff_codigo,rdr.drc_codigo,");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append(" dr.dru_codigo,rp.rp_codigo,rdr.rdr_codigo,drc.DRC_APLICA_GMF");
            sql.append(" from sii_rp_det_rubro_cdp rdr");
            sql.append(" inner join sii_rp rp on rdr.rp_codigo=rp.rp_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo ");
            sql.append(" inner join sii_detalle_rubro dr on drc.dru_codigo=dr.dru_codigo");
            sql.append(" inner join sii_dtlle_fuente_financiacion dtff on  dr.dff_codigo=dtff.dff_codigo");
            sql.append(" inner join sii_cdp cdp on drc.cdp_codigo=cdp.cdp_codigo");
            sql.append(" inner join sii_tipo_doc_soporte tds on cdp.tds_codigo=tds.tds_codigo");
            sql.append(" inner join  sii_fuente_financiacion ffi on dtff.ffi_codigo=ffi.ffi_codigo");
            sql.append(" inner join sii_estado_rp erp on rp.erp_codigo=erp.erp_codigo");
            sql.append(" inner join Pr_Rubro Rubro  on dr.vigencia=Rubro.vigencia and dr.interno=Rubro.interno");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where tds.tds_codigo=#tipoDocumento and cdp.cdp_vigencia=#vigencia and cdp.cdp_numero_doc_sop=#numeroDoc  ");
            sql.append(" and erp.erp_nombre='RP APROBADO'  ");
            sql.append(" order by cadena asc");
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("tipoDocumento",rubroFDFuenteRpVo.getTipoDocumento());
            query.setParameter("numeroDoc",rubroFDFuenteRpVo.getRdfNumeroDocSoporte());
            query.setParameter("vigencia",rubroFDFuenteRpVo.getVigencia());    
            query.setParameter("idObligacion",rubroFDFuenteRpVo.getRfdidObligacion());    
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
                RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo = new RubroFuenteDetalleFuenteRpVO();                               
                rubroFuenteDetallefuenteRpVo.setRfdValorRp((BigDecimal) object[0]);   
                rubroFuenteDetallefuenteRpVo.setRfdCodigoFuente(((BigDecimal) object[1]).longValue());
                rubroFuenteDetallefuenteRpVo.setRfdCodigoDetalleF(((BigDecimal) object[2]).longValue());
                rubroFuenteDetallefuenteRpVo.setRdfCodigoDetalleRubroCdp(((BigDecimal) object[3]).longValue());
                rubroFuenteDetallefuenteRpVo.setRdfCadena((String) object[4]);
                if( object[5] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdidDetalleRubro(((BigDecimal) object[5]).longValue());
                }
                rubroFuenteDetallefuenteRpVo.setCodigoRp(((BigDecimal) object[6]).longValue());
                rubroFuenteDetallefuenteRpVo.setRfdCodigoRpDetRubroCdp(((BigDecimal) object[7]).longValue());
                rubroFuenteDetallefuenteRpVo.setAplicaGMF((String) object[8]);
                listaRubroFuenteDetallefuenteRpVo.add(rubroFuenteDetallefuenteRpVo);
            }
           
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
        }
        
        return listaRubroFuenteDetallefuenteRpVo;
    }
    
    public  List<RubroFuenteDetalleFuenteRpVO>  buscarObligacionXIdDetalleRubroCdp(Long idDetalleRubro, Long mesPago ) throws ExcepcionDAO{
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetalleFuenteRpVo= new ArrayList<RubroFuenteDetalleFuenteRpVO>();
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append(" select odr.odr_codigo, sum(odr.odr_valor_pagar) from sii_obligacion_pago opa");
            sql.append(" inner join sii_oblig_det_rubro_cdp odr on opa.opa_codigo=odr.opa_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on odr.drc_codigo=drc.drc_codigo");
            sql.append(" WHERE opa.mes_codigo_pago=#mesPago ");
            sql.append(" and drc.dru_codigo=#detallerubro ");
            sql.append(" group by odr.odr_codigo  ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("detallerubro",idDetalleRubro );
            query.setParameter("mesPago", mesPago);
            List<Object[]> results = query.getResultList();
            
                   for(Object[] object : results){
                       RubroFuenteDetalleFuenteRpVO rubroFuenteDetFuenteRpVo = new RubroFuenteDetalleFuenteRpVO();         
                       rubroFuenteDetFuenteRpVo.setRfdidObligacion(((BigDecimal) object[0]).longValue());   
                       rubroFuenteDetFuenteRpVo.setRfdValoraPagar((BigDecimal) object[1]);
                                    
                       listaRubroFuenteDetalleFuenteRpVo.add(rubroFuenteDetFuenteRpVo);
                   }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return listaRubroFuenteDetalleFuenteRpVo;
    }    
    
    
    public RubroFuenteDetalleFuenteRpVO  buscarTotalDecrementoRPXIdRp(Long idRp,String tipo ) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO rubroFuenteDetFuenteRpVo = new RubroFuenteDetalleFuenteRpVO();    
      
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append(" select nvl(sum (mrd.mrd_valor),0) from sii_rp rp");
            sql.append(" inner join sii_modificacion_rp mrp on rp.rp_codigo=mrp.rp_codigo");
            sql.append(" inner join sii_modif_rp_det_rub_cdp mrd on mrp.mrp_codigo=mrd.mrp_codigo");
            sql.append(" inner join sii_rp_det_rubro_cdp rdr on mrd.rdr_codigo=rdr.rdr_codigo");
            sql.append(" inner join sii_estado_modific_rp emr on mrp.emr_codigo=emr.emr_codigo");
            sql.append(" where emr.emr_codigo =3 and  rp.rp_codigo =#idRp  "); 
            if (tipo!= null )
                sql.append(" and  mrp.mrp_tipo_modif =#tipo");
            
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRp",idRp );
            if (tipo!= null )
                query.setParameter("tipo",tipo );
             List<BigDecimal> results = query.getResultList();
            BigDecimal tempBig = BigDecimal.ZERO;
                for(BigDecimal object : results){
                    if(object != null && object.equals(0) )  
                        if (tipo.equals("D") )
                            rubroFuenteDetFuenteRpVo.setDecrementoRp((BigDecimal) object); 
                        else
                            rubroFuenteDetFuenteRpVo.setIncrementoRp((BigDecimal) object);
                    else {
                        rubroFuenteDetFuenteRpVo.setDecrementoRp(tempBig);
                        rubroFuenteDetFuenteRpVo.setIncrementoRp(tempBig);
                    }
                }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return rubroFuenteDetFuenteRpVo;
    }  
    
    public RubroFuenteDetalleFuenteRpVO  buscarTotalObligacionesPagoXIdRp(Long idRp ) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO rubroFuenteDetFuenteRpVo = new RubroFuenteDetalleFuenteRpVO();    
      
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum(obl.OBL_SUBTOTAL) as total from sii_rp rp");
            sql.append(" inner join sii_obligacion_concepto oco on rp.rp_codigo=oco.rp_codigo");
            sql.append(" inner join sii_obligacion obl on oco.obl_codigo=obl.obl_codigo");
            sql.append(" inner join sii_estado_obligacion eob on obl.eob_codigo=eob.eob_codigo");
            sql.append(" where rp.rp_codigo= #idRp and eob.eob_codigo=3 "); 
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRp",idRp );
            List<BigDecimal> results = query.getResultList();
            BigDecimal tempBig = BigDecimal.ZERO;
                for(BigDecimal object : results){
                    if(object != null)                        
                        rubroFuenteDetFuenteRpVo.setValorTotalObligaciones((BigDecimal) object); 
                    else 
                        rubroFuenteDetFuenteRpVo.setValorTotalObligaciones(tempBig); 
                }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return rubroFuenteDetFuenteRpVo;
    }    

    public RubroFuenteDetalleFuenteRpVO buscarValorAplazamientoXIdRubroIdMes(Long idRubro, Long IdMes) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO rubroFuenteDetFuenteRpVo = new RubroFuenteDetalleFuenteRpVO(); 
        
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append(" select sum(obl.OBL_SUBTOTAL) as total from sii_rp rp");
            sql.append(" inner join sii_obligacion_concepto oco on rp.rp_codigo=oco.rp_codigo");
            sql.append(" inner join sii_obligacion obl on oco.obl_codigo=obl.obl_codigo");
            sql.append(" inner join sii_estado_obligacion eob on obl.eob_codigo=eob.eob_codigo");
            sql.append(" where rp.rp_codigo= #idRp and eob.eob_codigo=3 "); 
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRubro",idRubro );
            List<BigDecimal> results = query.getResultList();
            BigDecimal tempBig = BigDecimal.ZERO;
                for(BigDecimal object : results){
                    if(object != null)                        
                        rubroFuenteDetFuenteRpVo.setValorTotalObligaciones((BigDecimal) object); 
                    else 
                        rubroFuenteDetFuenteRpVo.setValorTotalObligaciones(tempBig); 
                }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return rubroFuenteDetFuenteRpVo;
    }        
    
   
    
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdObligacion(RubroFuenteDetalleFuenteRpVO rubroFDFuenteRpVo) throws ExcepcionDAO{
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo= new ArrayList<RubroFuenteDetalleFuenteRpVO>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" select rdr.rdr_valor,ffi.ffi_codigo,dtff.dff_codigo,rdr.drc_codigo,odr.odr_codigo,odr.odr_valor_pagar,");
            sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
            sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
            sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
            sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
            sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
            sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
            sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
            sql.append(" dr.dru_codigo,rp.rp_codigo,rdr.rdr_codigo,drc.drc_aplica_gmf");
            sql.append(" from sii_rp_det_rubro_cdp rdr");
            sql.append(" inner join sii_rp rp on rdr.rp_codigo=rp.rp_codigo");
            sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo ");
            sql.append(" inner join sii_detalle_rubro dr on drc.dru_codigo=dr.dru_codigo");
            sql.append(" inner join sii_dtlle_fuente_financiacion dtff on  dr.dff_codigo=dtff.dff_codigo");
            sql.append(" inner join sii_cdp cdp on drc.cdp_codigo=cdp.cdp_codigo");
            sql.append(" left join sii_oblig_det_rubro_cdp  odr on rdr.rdr_codigo=odr.rdr_codigo");
            sql.append(" left join sii_obligacion_pago opa on  odr.opa_codigo=opa.opa_codigo");
            sql.append(" inner join sii_tipo_doc_soporte tds on cdp.tds_codigo=tds.tds_codigo");
            sql.append(" inner join  sii_fuente_financiacion ffi on dtff.ffi_codigo=ffi.ffi_codigo");
            sql.append(" inner join sii_estado_rp erp on rp.erp_codigo=erp.erp_codigo");
            sql.append(" inner join Pr_Rubro Rubro  on dr.vigencia=Rubro.vigencia and dr.interno=Rubro.interno");
            sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
            sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
            sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
            sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
            sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
            sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
            sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno");            
            sql.append(" Where tds.tds_codigo=#tipoDocumento and cdp.cdp_vigencia=#vigencia and cdp.cdp_numero_doc_sop=#numeroDoc  ");
            sql.append(" and erp.erp_nombre='RP APROBADO' and opa.opa_codigo=#idObligacion ");
            sql.append(" order by cadena asc");
            
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("tipoDocumento",rubroFDFuenteRpVo.getTipoDocumento());
            query.setParameter("numeroDoc",rubroFDFuenteRpVo.getRdfNumeroDocSoporte());
            query.setParameter("vigencia",rubroFDFuenteRpVo.getVigencia());    
            query.setParameter("idObligacion",rubroFDFuenteRpVo.getRfdidObligacion());    
            List<Object[]> results = query.getResultList();
            
            
            for(Object[] object : results){
                RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo = new RubroFuenteDetalleFuenteRpVO();                               
                rubroFuenteDetallefuenteRpVo.setRfdValorRp((BigDecimal) object[0]);   
                rubroFuenteDetallefuenteRpVo.setRfdCodigoFuente(((BigDecimal) object[1]).longValue());
                rubroFuenteDetallefuenteRpVo.setRfdCodigoDetalleF(((BigDecimal) object[2]).longValue());
                rubroFuenteDetallefuenteRpVo.setRdfCodigoDetalleRubroCdp(((BigDecimal) object[3]).longValue());
                if( object[4] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdCodigoDetalleObligacion(((BigDecimal) object[4]).longValue());
                }
                if( object[5] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdValoraPagar((BigDecimal) object[5]);
                }
                rubroFuenteDetallefuenteRpVo.setRdfCadena((String) object[6]);
                if( object[7] !=null ){
                    rubroFuenteDetallefuenteRpVo.setRfdidDetalleRubro(((BigDecimal) object[7]).longValue());
                }
                rubroFuenteDetallefuenteRpVo.setCodigoRp(((BigDecimal) object[8]).longValue());
                rubroFuenteDetallefuenteRpVo.setRfdCodigoRpDetRubroCdp(((BigDecimal) object[9]).longValue());
                rubroFuenteDetallefuenteRpVo.setAplicaGMF((String) object[10]);
                listaRubroFuenteDetallefuenteRpVo.add(rubroFuenteDetallefuenteRpVo);
            }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
        }
        
        return listaRubroFuenteDetallefuenteRpVo;
    }
    
        public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdNotaCredito( Long ncrCodigo) throws ExcepcionDAO{
            
            List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo= new ArrayList<RubroFuenteDetalleFuenteRpVO>();
            try{
                StringBuilder sql = new StringBuilder();
    
                sql.append("select sum(total),cadena,ffi_codigo,dff_codigo,rp_codigo,rdr_codigo  from  (");
                             sql.append(" select distinct n.ncr_codigo,obc.oco_codigo,ob.obl_codigo,rp.rp_codigo ,Nvl(obc.oco_subtotal+obc.oco_valor_iva,0)as total  ");
                             sql.append(" ,ffi.ffi_codigo,dtff.dff_codigo,cdp.cdp_vigencia,rdr.rdr_codigo,");
                             sql.append(" TO_CHAR(Nivel1.CODIGO) ||");
                             sql.append(" (case when Nivel2.Codigo is null then '' else '.' || TO_CHAR(Nivel2.Codigo) end) ||");
                             sql.append(" (case when Nivel3.Codigo is null then '' else '.' || TO_CHAR(Nivel3.Codigo) end) ||");
                             sql.append(" (case when Nivel4.Codigo is null then '' else '.' || TO_CHAR(Nivel4.Codigo) end) ||");
                             sql.append(" (case when Nivel5.Codigo is null then '' else '.' || TO_CHAR(Nivel5.Codigo) end) ||");
                             sql.append(" (case when Nivel6.Codigo is null then '' else '.' || TO_CHAR(Nivel6.Codigo) end) ||");
                             sql.append(" (case when Nivel7.Codigo is null then '' else '.' || TO_CHAR(Nivel7.Codigo) end) as cadena,");
                             sql.append(" dr.dru_codigo");
                             sql.append(" from sii_nota_credito n");
                             sql.append(" inner join sii_obligacion ob on n.obl_codigo=ob.obl_codigo");
                             sql.append(" inner join sii_obligacion_concepto obc on obc.obl_codigo = n.obl_codigo");
                             sql.append(" inner join sii_rp rp on rp.rp_codigo = obc.rp_codigo");
                             sql.append(" inner join sii_rp_det_rubro_cdp rdr on rdr.rp_codigo = rp.rp_codigo");
                             sql.append(" inner join sii_detalle_rubro_cdp drc on rdr.drc_codigo=drc.drc_codigo ");
                             sql.append(" inner join sii_detalle_rubro dr on drc.dru_codigo=dr.dru_codigo");
                             sql.append(" inner join sii_dtlle_fuente_financiacion dtff on  dr.dff_codigo=dtff.dff_codigo");
                             sql.append(" inner join sii_cdp cdp on drc.cdp_codigo=cdp.cdp_codigo");
                             sql.append(" inner join sii_tipo_doc_soporte tds on cdp.tds_codigo=tds.tds_codigo");
                             sql.append(" inner join  sii_fuente_financiacion ffi on dtff.ffi_codigo=ffi.ffi_codigo");
                             sql.append(" inner join sii_estado_rp erp on rp.erp_codigo=erp.erp_codigo");
                             sql.append(" inner join Pr_Rubro Rubro  on dr.vigencia=Rubro.vigencia and dr.interno=Rubro.interno");
                             sql.append(" Inner Join Pr_Nivel1 Nivel1 On Rubro.Vigencia = Nivel1.Vigencia And Rubro.Interno_Nivel1 = Nivel1.Interno");
                             sql.append(" Left  Join Pr_Nivel2 Nivel2 On Rubro.Vigencia = Nivel2.Vigencia And Rubro.Interno_Nivel2 = Nivel2.Interno");
                             sql.append(" Left  Join Pr_Nivel3 Nivel3 On Rubro.Vigencia = Nivel3.Vigencia And Rubro.Interno_Nivel3 = Nivel3.Interno");
                             sql.append(" Left  Join Pr_Nivel4 Nivel4 On Rubro.Vigencia = Nivel4.Vigencia And Rubro.Interno_Nivel4 = Nivel4.Interno");
                             sql.append(" Left  Join Pr_Nivel5 Nivel5 On Rubro.Vigencia = Nivel5.Vigencia And Rubro.Interno_Nivel5 = Nivel5.Interno");
                             sql.append(" Left  Join Pr_Nivel6 Nivel6 On Rubro.Vigencia = Nivel6.Vigencia And Rubro.Interno_Nivel6 = Nivel6.Interno");
                             sql.append(" Left  Join Pr_Nivel7 Nivel7 On Rubro.Vigencia = Nivel7.Vigencia And Rubro.Interno_Nivel7 = Nivel7.Interno  ");          
                                      
             
             sql.append(" Where  n.ncr_codigo =#ncrCodigo  and drc.drc_aplica_gmf='N'");
             sql.append(" order by cadena asc) group by ffi_codigo, rp_codigo, rdr_codigo, cadena, dff_codigo   ");
    
            Query query = manager.createNativeQuery(sql.toString());
            
            query.setParameter("ncrCodigo",ncrCodigo);
     
            List<Object[]> results = query.getResultList();
            
            for(Object[] object : results){
                RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo = new RubroFuenteDetalleFuenteRpVO();                               
                rubroFuenteDetallefuenteRpVo.setValorTotalObligaciones((BigDecimal) object[0]);   
                rubroFuenteDetallefuenteRpVo.setRdfCadena((String) object[1]);
                rubroFuenteDetallefuenteRpVo.setRfdCodigoFuente(((BigDecimal) object[2]).longValue());
                rubroFuenteDetallefuenteRpVo.setRfdidDetalleRubro(((BigDecimal) object[3]).longValue());
                rubroFuenteDetallefuenteRpVo.setCodigoRp(((BigDecimal) object[4]).longValue());
                rubroFuenteDetallefuenteRpVo.setRdfCodigoDetalleRubroCdp(((BigDecimal) object[5]).longValue());
             
                listaRubroFuenteDetallefuenteRpVo.add(rubroFuenteDetallefuenteRpVo);
            }
            }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ApropiacionInicialDAO");
            }
            
            return listaRubroFuenteDetallefuenteRpVo;
        }
    
    public RubroFuenteDetalleFuenteRpVO  buscarReintegrosAsoXIdRp(Long idRp,String tipo ) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO rubroFuenteDetFuenteRpVo = new RubroFuenteDetalleFuenteRpVO();    
      
        try{
            SiiObligacionPago ObligacionPagoRetorno = new SiiObligacionPago();           
            StringBuilder sql = new StringBuilder();
            sql.append(" select nvl(sum(r.rip_valor),0)as valor  from sii_reintegro_ingreso_pag   r ");
            sql.append(" inner join sii_nota_credito n on r.ncr_codigo=n.ncr_codigo  ");
            sql.append(" inner join sii_obligacion o on  o.obl_codigo = n.obl_codigo ");
            sql.append(" inner join sii_solicitud_pago sp on sp.spa_codigo = o.spa_codigo ");
            sql.append(" inner join sii_rp rp on sp.rp_codigo = rp.rp_codigo ");
            sql.append(" WHERE n.ncr_rc_independ= #tipo and rp.rp_codigo = #idRp "); 
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idRp",idRp );
            List<BigDecimal> results = query.getResultList();
            BigDecimal tempBig = BigDecimal.ZERO;
                for(BigDecimal object : results){
                    if(object != null)  
                        if(tipo.equals("S") )
                            rubroFuenteDetFuenteRpVo.setValorReintegroIndSi((BigDecimal) object); 
                        else
                            rubroFuenteDetFuenteRpVo.setValorReintegroIndNo((BigDecimal) object); 
                }
       
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ObligacionPagoDAO");
        }
        return rubroFuenteDetFuenteRpVo;
    }  
    
        
}
