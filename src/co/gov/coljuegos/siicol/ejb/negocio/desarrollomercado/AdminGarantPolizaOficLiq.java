package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AmparoOficioLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;

import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;

import java.util.List;

public interface AdminGarantPolizaOficLiq {
   
    public GarantPolizaOficLiqVO insertarSiiGarantPolizaOficLiq(GarantPolizaOficLiqVO garantPolizaOficLiqVo) throws ExcepcionDAO;
    public GarantPolizaOficLiqVO actualizarSiiGarantPolizaOficLiq(GarantPolizaOficLiqVO garantPolizaOficLiqVo) throws ExcepcionDAO;
    public GarantPolizaOficLiqVO buscarGarantPolizaOficLiqPorCodigo(Long idCodigoGarantPolizaOficLiq)  throws ExcepcionDAO;
    public List<AmparoOficioLiqVO> buscarGarantiaPorOficioLiquidacion(Long idOficio)  throws ExcepcionDAO;
}
