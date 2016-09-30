package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalPDFVO;
import co.gov.coljuegos.siicol.ejb.vo.CadenaPresupuestalVO;
import co.gov.coljuegos.siicol.ejb.vo.CdpVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudDetalleRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCdp {
    public CdpVO buscarCdpPorId(Long idCodigoCdp) throws ExcepcionDAO;

    public CdpVO insertarCdp(CdpVO CdpVO) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param cdpVO
     * @param listaInicialDetalleRubroCdpVo
     * @param listaFinalDetalleRubroCdpVo
     * @param listaActualizarDetalleRubroCdpVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CdpVO actualizarCdp(CdpVO cdpVO, List<DetalleRubroCdpVO> listaInicialDetalleRubroCdpVo,
                               List<DetalleRubroCdpVO> listaFinalDetalleRubroCdpVo,
                               List<DetalleRubroCdpVO> listaActualizarDetalleRubroCdpVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                ExcepcionAplicacion;

    /**
     * @author Modifica Giovanni
     * @param cdpVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public CdpVO actualizarEstadoCdp(CdpVO cdpVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<CdpVO> buscarTodoCdp() throws ExcepcionDAO;

    public List<CdpVO> buscarCdpPorEstado(String estado) throws ExcepcionDAO;
    
    public List<CdpVO> buscarCdpsAprobadosSinIncrementosEnTramite() throws ExcepcionDAO;
    
    public List<CdpVO> buscarCdpsAprobadosSinDecrementosEnTramite() throws ExcepcionDAO;

    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdp(Long idIpc,
                                                                                         Long idCdp) throws ExcepcionDAO;

    public List<SolicitudDetalleRubroCdpVO> buscarDetalleRubroCdpPorItemPlanContratIdCdpParaRecursosPropios(Long idIpc,
                                                                                                            Long idCdp) throws ExcepcionDAO;

    public Long consultarConsecutivoCdp() throws ExcepcionDAO;

    public List<CdpVO> buscarCdpExpedidos() throws ExcepcionDAO;

    public List<CdpVO> buscarCdpSolicitados() throws ExcepcionDAO;

    public List<SolicitudDetalleRubroCdpVO> calcularSaldoApropiacion(Long idItemPlanContratacion,
                                                                     Long idVigencia) throws ExcepcionDAO;

    public List<PrRubroVO> buscarDescricionRubroN2N3XCdp(Long idCdp) throws ExcepcionDAO;

    public BigDecimal valorActualApropiadoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO;

    public BigDecimal valorActualComprometidoPorRubrosCdp(Long cdpCodigo) throws ExcepcionDAO;
    
    public CdpVO buscarCdpPorConsecutivo(Long cdpConsecutivo) throws ExcepcionDAO;
    
    public List<DetalleRubroCdpVO> buscarDetalleRubroCdpPorCdpCodigo(Long cdpCodigo) throws ExcepcionDAO;

    public BigDecimal valorEjecutadoCdp(Long cdpConsecutivo) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<CadenaPresupuestalVO> reporteCadenaPresupuestal(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<CadenaPresupuestalPDFVO> reporteCadenaPresupuestalPDF(Date fechaInicial,
                                                                      Date fechaFinal) throws ExcepcionDAO;

    public List<CdpVO> buscarCdpsPorItemPlanCont(Long ipcCodigo) throws ExcepcionDAO;    
                                                                          
}
