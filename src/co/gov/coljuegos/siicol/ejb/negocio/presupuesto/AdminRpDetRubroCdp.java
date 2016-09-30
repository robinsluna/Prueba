package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRpDetRubroCdp {
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorDetRubCdp(Long drcCodigo) throws ExcepcionDAO;

    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRp(Long rpCodigo) throws ExcepcionDAO;
    
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
    
    public List<RpDetRubroCdpVO> buscarRpDetRubroCdpPorRpFFCGMF (Long rpCodigo, String ffcCodigo, Boolean aplicaGmf) throws ExcepcionDAO;

    public BigDecimal valorRpDetRubroCdpAprobado(Long drcCodigo) throws ExcepcionDAO;

    public List<RpDetRubroCdpVO> listaRubrosRpsAsociadosConLosCdpAsociadosConElRubroRp(RpDetRubroCdpVO rpDetRubroCdpVO) throws ExcepcionDAO;
}
