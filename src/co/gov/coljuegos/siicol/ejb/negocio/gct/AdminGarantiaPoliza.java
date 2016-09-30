package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaPolizaVO;

import java.util.List;

public interface AdminGarantiaPoliza {
    public List<GarantiaPolizaVO> buscarGarantiaPolizaPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO;
    public List<GarantiaPolizaVO> consultarGarantiasUltimaPolizaAprobadaXContrato(Long idContrato) throws ExcepcionDAO;
    public List<GarantiaPolizaVO> consultarGarantiasUltimaPolizaAprobadaXOtrosiContrato(Long idContrato) throws ExcepcionDAO;
}
