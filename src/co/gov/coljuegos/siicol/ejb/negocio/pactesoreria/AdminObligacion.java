package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminObligacion {
    public ObligacionVO buscarPorCodigoObligacion(Long idObligacion) throws ExcepcionDAO;

    public ObligacionVO insertarObligacion(ObligacionVO obligacionVO) throws ExcepcionDAO, ExcepcionAplicacion;

    public ObligacionVO actualizarObligacion(ObligacionVO obligacionVO) throws ExcepcionDAO, ExcepcionAplicacion;

    public void borrarObligacion(Long idObligacion) throws ExcepcionDAO;

    public List<ObligacionVO> buscarTodaObligacion() throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesRegistradasVigenciaActual() throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesRegistradasVigencia() throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesSinOrdenDePago() throws ExcepcionDAO;

    public Integer buscarConsecutivoObligacion() throws ExcepcionDAO;

    public Integer buscarConsecutivoObligacion(String tdcCodigo) throws ExcepcionDAO;

    public ObligacionVO obtenerUltimaObligacion() throws ExcepcionDAO;

    public ObligacionVO obtenerUltimaObligacion(String tdcCodigo) throws ExcepcionDAO;

    public ObligacionVO obtenerUltimaObligacion(Long oblCodigoOmision) throws ExcepcionDAO;

    public ObligacionVO obtenerUltimaObligacion(String tdcCodigo, Long oblCodigoOmision) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionPorRP(Long rpCodigo) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionPorRPYEstado(Long rpCodigo, Long idEstadoObligacion) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionPorBeneficiario(Long idBeneficiario) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionPorBeneficiarioYEstado(Long idBeneficiario,
                                                                     Long idEstadoObligacion) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionPorBeneficiarioMesYEstado(Long idBeneficiario, Long idEstadoObligacion,
                                                                        Date fecha) throws ExcepcionDAO;

    public BigDecimal obtenerValorTotalObligacion(Long oblCodigo) throws ExcepcionDAO;

    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo) throws ExcepcionDAO;

    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo, Date fecha) throws ExcepcionDAO;

    public BigDecimal obtenerValorObligacionesBeneficiarioMes(Long proCodigo, Date fecha,
                                                              boolean ivaIncluido) throws ExcepcionDAO;

    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(Long proCodigo) throws ExcepcionDAO;

    public BigDecimal obtenerTotalPagoAntRfteObligacionesBeneficiarioMes(Long proCodigo,
                                                                         Date fecha) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPago() throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPago(boolean mostrarObligacionesCuentasPorPagar) throws ExcepcionDAO;

    public List<ObligacionVO> buscarObligacionesNoCubiertasPorOrdenPagoCuentasPagar() throws ExcepcionDAO;

    public void insertarObligaciones(List<ObligacionVO> obligaciones) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<ObligacionVO> buscarPorCodigoCargaNomina(Long cnoCodigo) throws ExcepcionDAO;

    public List<ObligacionVO> buscarPorTipoDocContable(String tdcCodigo) throws ExcepcionDAO;
    
    public List<ObligacionVO> buscarPorIdDistribucionMes (Long dmeCodigo) throws ExcepcionDAO;
    
    public List<ObligacionVO> buscarObligacionConConceptoReintegro (Long eobCodigo) throws ExcepcionDAO;


    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaObligacionConceptoEliminar(List<ObligacionConceptoVO> listaObligacionConceptoEliminar);

    public void setListaOblConcRpDetRubCdpEliminar(List<OblConcRpDetRubCdpVO> listaOblConcRpDetRubCdpEliminar);
}
