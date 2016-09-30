package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligDetRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;

import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;


import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligDetRubroCdpVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminObligacionPagoBean implements AdminObligacionPago{
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    ObligacionPagoDAO obligacionPagoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    ObligDetRubroCdpDAO obligDetRuboCdpDao;    
    public AdminObligacionPagoBean() {
    }
    
    public ObligacionPagoVO insertarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago siiObligDetRubroCdp = conversionVoEntidad.convertir(obligacionPagoVo);
        SiiObligacionPago resultadoSiiObligacionPago = obligacionPagoDao.insertarObligacionPago(siiObligDetRubroCdp);
       
        return new ObligacionPagoVO(resultadoSiiObligacionPago);    
    }
    
    public ObligacionPagoVO buscarObligacionPagoPorId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago unaObligacionPago = obligacionPagoDao.buscarObligacionPagoPorId(obligacionPagoVo.getOpaCodigo());
        ObligacionPagoVO obligacionPagoVoRetorno = new ObligacionPagoVO(unaObligacionPago);        
        return obligacionPagoVoRetorno;        
    }
    
    
    public List<ObligacionPagoVO>  buscarObligacionPagoXCamposSinId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        List<ObligacionPagoVO> listaObligacionPagoVo = new ArrayList();
        SiiObligacionPago obligacionPago = conversionVoEntidad.convertir(obligacionPagoVo);
        listaObligacionPagoVo = obligacionPagoDao.buscarObligacionPagoXCamposSinId(obligacionPago);        
        return listaObligacionPagoVo;        
    }
    
    public ObligacionPagoVO actualizarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago obligacionPago = conversionVoEntidad.convertir(obligacionPagoVo);
        obligacionPago = obligacionPagoDao.actualizarObligacionPago(obligacionPago);
        List <ObligDetRubroCdpVO> listaActualizarObligDetRubroCdpVo = obligacionPagoVo.getListaGuardarObligDetRubroCdpListVo();       
        List <ObligDetRubroCdpVO> listaBorarObligDetRubroCdpVo = obligacionPagoVo.getListaBorrarObligDetRubroCdpListVo(); 
        for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaActualizarObligDetRubroCdpVo){
            SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);
            obligDetRuboCdpDao.actualizarObligDetRubroCdp(nuevaObligDetRubroCdp);
        }
        if(listaBorarObligDetRubroCdpVo != null){
            for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaBorarObligDetRubroCdpVo){
                        SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);          
                        obligDetRuboCdpDao.eliminarObligDetRubroCdp(nuevaObligDetRubroCdp.getOdrCodigo());
            }
        }
        return new ObligacionPagoVO(obligacionPago);        
    }
    
    public List<ObligacionPagoVO> buscarTodoObligacionPago() throws ExcepcionDAO{
        List<SiiObligacionPago> listaObligacionPago = obligacionPagoDao.buscarTodoObligacionPago();
        List<ObligacionPagoVO> listaObligacionPagoVo = new ArrayList();
        for (SiiObligacionPago unaObligacionPago : listaObligacionPago){
            listaObligacionPagoVo.add(new ObligacionPagoVO(unaObligacionPago));
        }
        return listaObligacionPagoVo;
    } 


public ObligacionPagoVO insertarObligacionPagoConDetalleRubroCdp (ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO{
        SiiObligacionPago obligacionPago = conversionVoEntidad.convertir(obligacionPagoVo);
        SiiObligacionPago obligacionPagoResultado = obligacionPagoDao.insertarObligacionPago(obligacionPago);
        List <ObligDetRubroCdpVO> listaGuardarObligDetRubroCdpVo = obligacionPagoVo.getListaGuardarObligDetRubroCdpListVo();       
        List <ObligDetRubroCdpVO> listaBorarObligDetRubroCdpVo = obligacionPagoVo.getListaBorrarObligDetRubroCdpListVo(); 
        
        for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaGuardarObligDetRubroCdpVo){
            SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);
            nuevaObligDetRubroCdp.setSiiObligacionPago(obligacionPagoResultado);            
            obligDetRuboCdpDao.insertarObligDetRubroCdp(nuevaObligDetRubroCdp);
        }
        
        /*for (ObligDetRubroCdpVO unaObligDetRubroCdpVo : listaBorarObligDetRubroCdpVo){
            SiiObligDetRubroCdp nuevaObligDetRubroCdp = conversionVoEntidad.converir(unaObligDetRubroCdpVo);          
            obligDetRuboCdpDao.eliminarObligDetRubroCdp(nuevaObligDetRubroCdp.getOdrCodigo());
        }*/
        
        
        return new ObligacionPagoVO(obligacionPagoResultado);
    }



}

