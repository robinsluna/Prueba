package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantPolizaOficLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AmparoOficioLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;

import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminGarantPolizaOficLiqBean implements AdminGarantPolizaOficLiq{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    GarantPolizaOficLiqDAO garantPolizaOficLiqDao;
    


    public AdminGarantPolizaOficLiqBean() {
    }
    
    public GarantPolizaOficLiqVO insertarSiiGarantPolizaOficLiq(GarantPolizaOficLiqVO garantPolizaOficLiqVo) throws ExcepcionDAO{
        SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = conversionVoEntidad.convertir(garantPolizaOficLiqVo);
        siiGarantPolizaOficLiq = garantPolizaOficLiqDao.insertarSiiGarantPolizaOficLiq(siiGarantPolizaOficLiq);
        return new GarantPolizaOficLiqVO(siiGarantPolizaOficLiq);
    }

   
    public GarantPolizaOficLiqVO actualizarSiiGarantPolizaOficLiq(GarantPolizaOficLiqVO garantPolizaOficLiqVo) throws ExcepcionDAO {
        SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = garantPolizaOficLiqDao.actualizarSiiGarantPolizaOficLiq(conversionVoEntidad.convertir(garantPolizaOficLiqVo));
        return new GarantPolizaOficLiqVO(siiGarantPolizaOficLiq);
    }
    
   
   
    public GarantPolizaOficLiqVO buscarGarantPolizaOficLiqPorCodigo(Long idCodigoGarantPolizaOficLiq)  throws ExcepcionDAO {
        SiiGarantPolizaOficLiq siiGarantPolizaOficLiq = garantPolizaOficLiqDao.buscarGarantPolizaOficLiqPorCodigo(idCodigoGarantPolizaOficLiq);
        return new GarantPolizaOficLiqVO(siiGarantPolizaOficLiq);
        
    }
    public List<AmparoOficioLiqVO> buscarGarantiaPorOficioLiquidacion(Long idOficio)  throws ExcepcionDAO {
        List<AmparoOficioLiqVO> listAmparos = garantPolizaOficLiqDao.buscarGarantiaPorOficioLiquidacion(idOficio);
        return listAmparos;        
    }
    
   
}
