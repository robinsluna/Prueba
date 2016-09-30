/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 21-10-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaRpVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpRubroDetalleFuenteVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoRpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRp {

    public RpVO buscarPorCodigoRp(Long idCodigoRp) throws ExcepcionDAO;

    public RpVO buscarPorCodigoRp(RpVO rpVo) throws ExcepcionDAO;

    public RpVO insertarRp(RpVO rpVo) throws ExcepcionDAO;

    public RpVO insertarRpConDetalle(RpVO rpVo) throws ExcepcionDAO;

    public RpVO actualizarRp(RpVO rpVo) throws ExcepcionDAO;

    public List<RpVO> buscarTodoRp() throws ExcepcionDAO;

    public List<RpVO> buscarRpPorEstado(String estado) throws ExcepcionDAO;
    
    public List<RpVO> buscarRpAprobadosSinIncrementosEnTramite() throws ExcepcionDAO;
    
    public List<RpVO> buscarRpAprobadosSinDecrementosEnTramite() throws ExcepcionDAO;

    public RpDetRubroCdpVO buscarCodigoRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO;

    public RpDetRubroCdpVO insertarRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO;

    public RpDetRubroCdpVO actualizarRpDetRubroCdp(RpDetRubroCdpVO rpDetRubroCdpVo) throws ExcepcionDAO;

    public List<RpDetRubroCdpVO> buscarTodoRpDetRubroCdp() throws ExcepcionDAO;

    public EstadoRpVO buscarEstadoRpPorId(EstadoRpVO estadoRpVo) throws ExcepcionDAO;

    public List<EstadoRpVO> buscarEstadoRpPorCodigo(EstadoRpVO estadoRpVo) throws ExcepcionDAO;

    public List<EstadoRpVO> buscarCodEstadoPorNombre(String estadoRp) throws ExcepcionDAO;

    public List<EstadoRpVO> buscarTodoEstadoRp() throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> bucarCdpConSaldo(Integer vigencia) throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdp(Long IdCdp) throws ExcepcionDAO;

    public Long buscarConsecutivoRp() throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> buscarRubroFteDetPorRp(RpVO unRpVo) throws ExcepcionDAO;

    public CdpRubroDetalleFuenteVO buscarSaldoPorCdp(Long IdCdp, Long IdRubro) throws ExcepcionDAO;

    public List<String> buscarObjetosPorCodigosRp(List<Long> rps) throws ExcepcionDAO;

    public List<RpVO> buscarRPPorIdProveedor(Long idProveedor) throws ExcepcionDAO;

    public BigDecimal consultarValorRP(Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal consultarValorRPSinGMF(Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal consultarValorRP(Long rpCodigo, boolean incluirGMF) throws ExcepcionDAO;

    public BigDecimal consultarValorRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
    
    public BigDecimal consultarValorRP (Long rpCodigo, String ffcCodigo, boolean incluirGMF) throws ExcepcionDAO;

    public BigDecimal consultarValorRP(Long rpCodigo, Long druCodigo, Long dffCodigo) throws ExcepcionDAO;

    public BigDecimal consultarDecrementosRP(Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal consultarDecrementosRP(Long rpCodigo, Long idEstadoModificRP) throws ExcepcionDAO;

    public BigDecimal consultarDecrementosRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;

    public BigDecimal consultarDecrementosRP(Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO;
    
    public BigDecimal consultarIncrementosRP(Long rpCodigo) throws ExcepcionDAO;

    public BigDecimal consultarIncrementosRP(Long rpCodigo, Long idEstadoModificRP) throws ExcepcionDAO;

    public BigDecimal consultarIncrementosRP(Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;

    public BigDecimal consultarIncrementosRP(Long rpCodigo, Long emrCodigo, String ffcCodigo) throws ExcepcionDAO;
    

    public BigDecimal buscarTotalRpAprobadosPorCdp(Long idCdp) throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> reporteDetallePorRp(Long IdRp) throws ExcepcionDAO;

    public List<RpVO> buscarRpPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;

    public BigDecimal getGastosPersonal(Long IdRp) throws ExcepcionDAO;

    public BigDecimal getGastosGenerales(Long IdRp) throws ExcepcionDAO;

    public BigDecimal getRecursosPropios(Long IdRp) throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> bucarRubroFteDetPorCdps(String IdCdp) throws ExcepcionDAO;

    public List<RpVO> buscarRpAprobadosPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO;

    public List<CdpRubroDetalleFuenteVO> buscarDetalleRpPorRp(Long idRp) throws ExcepcionDAO;

    public BigDecimal getGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;

    public BigDecimal getTotalGastosPersonalPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;

    public BigDecimal getGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;

    public BigDecimal getTotalRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;

    public BigDecimal getRecursosPropiosPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;

    public BigDecimal getTotalGastosGeneralesPorObligacionConcepto(Integer concepto) throws ExcepcionDAO;
    
    public BigDecimal getGastosTransferenciaPorObligacion (Integer oblNumero) throws ExcepcionDAO;
    
    public BigDecimal getRecursosControlIlegalidadPorObligacion (Integer oblNumero) throws ExcepcionDAO;

    public RpVO buscarPorConsecutivoRp(Long rpConsecutivo) throws ExcepcionDAO;

    public CargaRpVO guardarListaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<RpVO> listaRpsAsociadosConLosCdpAsociadosConElRp(RpVO rpVO) throws ExcepcionDAO;

}
