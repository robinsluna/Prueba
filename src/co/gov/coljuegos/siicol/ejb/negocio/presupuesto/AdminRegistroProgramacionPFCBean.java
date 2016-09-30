/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Walter becerra
 * FECHA	: 26-11-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;


import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;

import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudEstMercadoVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminRegistroProgramacionPFCBean implements AdminRegistroProgramacionPFC {
    @Resource
    SessionContext sessionContext;

    @EJB
    ObligacionPagoDAO obligacionPagoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ObligDetRubroCdpDAO obligDetRuboCdpDao; 
   
    public AdminRegistroProgramacionPFCBean() {
    }
    
    public ObligacionPagoVO insertarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO {
        SiiObligacionPago siiObligDetRubroCdp = conversionVoEntidad.convertir(obligacionPagoVo);
        SiiObligacionPago resultadoSiiObligacionPago = obligacionPagoDao.insertarObligacionPago(siiObligDetRubroCdp);
        
        List <ObligDetRubroCdpVO> listaGuardarObligDetRubroCdpVo = obligacionPagoVo.getListaGuardarObligDetRubroCdpListVo();       
        List <ObligDetRubroCdpVO> listaBorarObligDetRubroCdpVo = obligacionPagoVo.getListaBorrarObligDetRubroCdpListVo(); 
        
        for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaGuardarObligDetRubroCdpVo){
            SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);
            nuevaObligDetRubroCdp.setSiiObligacionPago(resultadoSiiObligacionPago);            
            obligDetRuboCdpDao.insertarObligDetRubroCdp(nuevaObligDetRubroCdp);
        }
        
        for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaBorarObligDetRubroCdpVo){
           if(unaObligDetRubroCdpVo.getObligacionPagoVo().getOpaCodigo()!=null){
            SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);          
            obligDetRuboCdpDao.eliminarObligDetRubroCdp(nuevaObligDetRubroCdp.getOdrCodigo());
            }
        }
        return new ObligacionPagoVO(resultadoSiiObligacionPago);
    }
    
    public ObligacionPagoVO buscarObligacionPagoPorId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago unaObligacionPago = obligacionPagoDao.buscarObligacionPagoPorId(obligacionPagoVo.getOpaCodigo());
        ObligacionPagoVO obligacionPagoVoRetorno = new ObligacionPagoVO(unaObligacionPago);        
        return obligacionPagoVoRetorno;        
    }
    
    public List<ObligacionPagoVO> buscarTodoObligacionPago() throws ExcepcionDAO {
        List<SiiObligacionPago> listaSiiObligacionPago = obligacionPagoDao.buscarTodoObligacionPago();
        List<ObligacionPagoVO> listaSiiObligacionPagoVo = new ArrayList(); 
        
        for(SiiObligacionPago unaObligDetRubroCdp : listaSiiObligacionPago){
            listaSiiObligacionPagoVo.add(new ObligacionPagoVO(unaObligDetRubroCdp));
        }
        return listaSiiObligacionPagoVo;         
     }  
    
    public List<ObligacionPagoVO>  buscarObligacionPagoXCamposSinId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago siiObligpago = conversionVoEntidad.convertir(obligacionPagoVo);
        List<ObligacionPagoVO>  lsitaObligacionPagoVo= obligacionPagoDao.buscarObligacionPagoXCamposSinId(siiObligpago);                                                                               
        return  lsitaObligacionPagoVo;
    }
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarListaFuenteDetallefuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO {
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarListaFuenteDetallefuenteXRp(rubroFuenteDetallefuenteRpVo); 
        BigDecimal temp = new BigDecimal(0);
        //saldo por ejecutar
       
        for(int i=0;i<listaRubroFuenteDetallefuenteRpVo.size();i++){
            BigDecimal tempBig = BigDecimal.ZERO;
          RubroFuenteDetalleFuenteRpVO unRfdFRpVo=obligacionPagoDao.buscarTotalDecrementoRPXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),null);
          unRfdFRpVo.setRdfMesPago(listaRubroFuenteDetallefuenteRpVo.get(i).getRdfMesPago());  
          unRfdFRpVo.setRfdidDetalleRubro(listaRubroFuenteDetallefuenteRpVo.get(i).getRfdidDetalleRubro());  
          RubroFuenteDetalleFuenteRpVO  unRubroFudFRpVo=obligacionPagoDao.buscarTotalObligacionesPagoXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp());             
            
          temp=(listaRubroFuenteDetallefuenteRpVo.get(i).getRfdValorRp().subtract(unRfdFRpVo.getDecrementoRp())).subtract(unRubroFudFRpVo.getValorTotalObligaciones());
          listaRubroFuenteDetallefuenteRpVo.get(i).setSaldoXejecutar(temp);
            
        }
        
          
                                                                                                         
        return listaRubroFuenteDetallefuenteRpVo;         
     }
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO {
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarRubroFuenteFDetfuenteXRp(rubroFuenteDetallefuenteRpVo); 
         BigDecimal temp = new BigDecimal(0);
            for(int i=0;i<listaRubroFuenteDetallefuenteRpVo.size();i++){
                  BigDecimal tempBig = BigDecimal.ZERO;
                  RubroFuenteDetalleFuenteRpVO unRfdFRpVo=obligacionPagoDao.buscarTotalDecrementoRPXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),null);
                  unRfdFRpVo.setRdfMesPago(listaRubroFuenteDetallefuenteRpVo.get(i).getRdfMesPago());  
                  unRfdFRpVo.setRfdidDetalleRubro(listaRubroFuenteDetallefuenteRpVo.get(i).getRfdidDetalleRubro());  
                   
                  //RubroFuenteDetalleFuenteRpVO unRuFudFRpVo=obligacionPagoDao.buscarObligacionXIdDetalleRubroCdp(unRfdFRpVo.getRfdidDetalleRubro(),unRfdFRpVo.getRdfMesPago()); 
                  RubroFuenteDetalleFuenteRpVO  unRubroFudFRpVo=obligacionPagoDao.buscarTotalObligacionesPagoXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp());             
                
                  temp=(listaRubroFuenteDetallefuenteRpVo.get(i).getRfdValorRp().subtract(unRfdFRpVo.getDecrementoRp())).subtract(unRubroFudFRpVo.getValorTotalObligaciones());
                  listaRubroFuenteDetallefuenteRpVo.get(i).setSaldoXejecutar(temp);
                
            }
        
                                                                                                         
        return listaRubroFuenteDetallefuenteRpVo;         
     }
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdObligacion(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO {
        List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarRubroFuenteFDetfuenteXIdObligacion(rubroFuenteDetallefuenteRpVo); 
         BigDecimal temp = new BigDecimal(0);
            for(int i=0;i<listaRubroFuenteDetallefuenteRpVo.size();i++){
                  BigDecimal tempBig = BigDecimal.ZERO;
                  RubroFuenteDetalleFuenteRpVO unRfdFRpDecrementoVo = obligacionPagoDao.buscarTotalDecrementoRPXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),"D");
                  RubroFuenteDetalleFuenteRpVO unRfdFRpIncrementoVo = obligacionPagoDao.buscarTotalDecrementoRPXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),"I");
                  RubroFuenteDetalleFuenteRpVO unRfdFRpReintegroSiVo =  obligacionPagoDao.buscarReintegrosAsoXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),"S");
                  RubroFuenteDetalleFuenteRpVO unRfdFRpReintegroNoVo =  obligacionPagoDao.buscarReintegrosAsoXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp(),"N");
                  RubroFuenteDetalleFuenteRpVO  unRubroFudFRpVo=obligacionPagoDao.buscarTotalObligacionesPagoXIdRp(listaRubroFuenteDetallefuenteRpVo.get(i).getCodigoRp());             
                
                  temp=(listaRubroFuenteDetallefuenteRpVo.get(i).getRfdValorRp().add(unRfdFRpIncrementoVo.getIncrementoRp()).subtract(unRfdFRpDecrementoVo.getDecrementoRp())).
                      subtract((unRubroFudFRpVo.getValorTotalObligaciones().subtract(unRfdFRpReintegroSiVo.getValorReintegroIndSi()).subtract(unRfdFRpReintegroNoVo.getValorReintegroIndNo())  )) ;
                  listaRubroFuenteDetallefuenteRpVo.get(i).setSaldoXejecutar(temp);
            }
        
                                                                                                         
        return listaRubroFuenteDetallefuenteRpVo;         
     }
    
    
    
    
    public List<RubroFuenteDetalleFuenteRpVO>  buscarObligacionXIdDetalleRubroCdp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO {
         List<RubroFuenteDetalleFuenteRpVO>  unRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarObligacionXIdDetalleRubroCdp(rubroFuenteDetallefuenteRpVo.getRfdidDetalleRubro(),
                                                                                                                                    rubroFuenteDetallefuenteRpVo.getRdfMesPago());                                                                                              
        return unRubroFuenteDetallefuenteRpVo;         
     }
    
    public RubroFuenteDetalleFuenteRpVO  buscarTotalDecrementoRPXIdRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo ) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO unRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarTotalDecrementoRPXIdRp(rubroFuenteDetallefuenteRpVo.getCodigoRp(),null);                                                                                              
        return unRubroFuenteDetallefuenteRpVo;  
    }
    
    public RubroFuenteDetalleFuenteRpVO  buscarTotalObligacionesPagoXIdRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo ) throws ExcepcionDAO{
        RubroFuenteDetalleFuenteRpVO unRubroFuenteDetallefuenteRpVo = obligacionPagoDao.buscarTotalObligacionesPagoXIdRp(rubroFuenteDetallefuenteRpVo.getCodigoRp());                                                                                              
        return unRubroFuenteDetallefuenteRpVo;  
    }
    
    
    
}
