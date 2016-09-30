package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicPfcmDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPfcm;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolEstMercadoVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPfcmVO;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
@Stateless
public class AdminEstadoSolicPfcmBean implements AdminEstadoSolicPfcm {
    
    @Resource
    SessionContext sessionContext;
    
    @EJB
    EstadoSolicPfcmDAO estadoSolicPfcmDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    
    public AdminEstadoSolicPfcmBean() {
        
    }
    
    public EstadoSolicPfcmVO buscarEstadoSolicPfcmPorNombre(EstadoSolicPfcmVO estadoSolicPfcmVo) throws ExcepcionDAO{
        
        SiiEstadoSolicPfcm siiEstadoSolicPfcm = conversionVoEntidad.convertir(estadoSolicPfcmVo);
        SiiEstadoSolicPfcm resultadoSiiEstadoSolicPfcm = estadoSolicPfcmDao.buscarEstadoSolicPfcmPorNombre(siiEstadoSolicPfcm);
        return new EstadoSolicPfcmVO(resultadoSiiEstadoSolicPfcm);
    }
    
    
    
}
