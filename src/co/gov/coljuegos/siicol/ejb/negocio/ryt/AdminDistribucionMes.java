package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoAAVO;
import co.gov.coljuegos.siicol.ejb.vo.BeneficiarioEnteVO;
import co.gov.coljuegos.siicol.ejb.vo.CategoriaDistribVO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.ConsolidadoDistVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribVO;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;

import co.gov.coljuegos.siicol.ejb.vo.RecaudoEnteVO;

import co.gov.coljuegos.siicol.ejb.vo.ReporteDistribucionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDistribucionMes {    
    public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMes(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO;
    public int buscarConsecutivoDistribucion() throws ExcepcionDAO;
    public DistribucionMesVO  insertarSiiDistribucionMes(DistribucionMesVO distribucionMesVo,List<DetalleDistribVO> listaDetalleDistrib,
                                                            DistribucionMesVO  distribucionMesVoAnular,List<DetalleDeclaracionVO> listaDeclaracion,List<AsignacionRecaudoAAVO> listaAsigRec ) throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarDistribucionMesPorEstado (Long edeCodigo) throws ExcepcionDAO;
    public DistribucionMesVO buscarPorCodigoDistribucionMes(Long idCodigoDistMes) throws ExcepcionDAO;
    public List<DetalleDistribVO> buscarDetalleDistribPorIdDistribucion(Long idDistriMes) throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarDistribucionPorMesYVigencia (int pMes, int pVigencia )throws ExcepcionDAO;
    public DistribucionMesVO actualizarSiiDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin) throws ExcepcionDAO, ExcepcionAplicacion;
    public DistribucionMesVO actualizarDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin, boolean doCascadeUpdate) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<ConceptoCuotaVO> buscarSiiConceptoCuotaPorModalidades(String modalidad1, String modalidad2, String modalidad3) throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarDistribucionMesConOrdenPagoPendientes () throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarDistribucionMesConOrdenPagoPendientes (String tdcCodigo) throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarTodoDistribucion() throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMes(int mes, String pTipoCuota,Integer vigencia) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarDistribucionOperadorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoTodosMunicipiosPorMesSinDdeCodigo(int mes, Long idCategoria, Integer vigencia, String fechaLiq) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoInteresTodosMunicipiosPorMesSinDdeCodigo(int mes, String pDistribucion,Integer vigencia) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarDistribucionMunicGeneradorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    //public List<ReporteDistribucionVO> buscarTransferenciaMunicipiosPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarDistribucionOperadorPorMesYDepto(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoInteresMoraTodosMunicipiosPorMes(int mes, Integer vigencia) throws ExcepcionDAO;
    public List<ReporteDistribucionVO> generarReporteTransferenciaPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<DistribucionMesVO> buscarDistribucionMesSinObligacionPorEstado (Long edeCodigo) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarDistribucionConsolidadoOperadorPorMes(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarDistribucionMunicPorMesConsolidado(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public DistribucionMesVO anularDistribucionMes(DistribucionMesVO distribucionMesVO, UsuarioVO usuLogin) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<ReporteDistribucionVO> buscarRecaudoInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteDistribucionVO> buscarTransferenciaInteresPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoInteresPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoIFPorMesVigenciaTipoCuota(int mes, Integer vigencia, String pBandera, String pReporte) throws ExcepcionDAO;
    public CategoriaDistribVO buscarPorCodigoCategoriaDistrib(Long idCodigoCategoria) throws ExcepcionDAO;
    public List<ReporteDistribucionVO> buscarTransferenciaInteresMoraPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteDistribucionVO> buscarTransferenciaInteresFinanciacionPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarConsolidadoReporteRecaudoInteresMoraOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoRifasPorMes(int mes, Integer vigencia, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    public List<ReporteDistribucionVO> buscarTransferenciaPorMesVigenciaYCategoria(int mes,Integer vigenciaReporte,Long idCategoria) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoPromocionales(int mes, Integer vigencia, String bandera) throws ExcepcionDAO;
    public void insertarConsolidadoDist(List<ConsolidadoDistVO> listaConsolidado,DistribucionMesVO unaDistriVo,UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarValorRecaudoPromocionalesReporte(int mes, Integer vigencia) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarConsolidadoReportePromocionalesOperadorPorMesYVigencia(int mes,Integer vigenciaReporte) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarReporteRecaudoInteresMoraConsolidadoActAdmOperadorPorMesYVigencia(int mes,Integer vigenciaReporte, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarValorRecaudoRifasPorMesReporte(int mes, Integer vigencia, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5,String concepto) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarValorRecaudoRifasConsolidadoPorMesReporte(int mes, Integer vigencia, String nivel1,String nivel2, String nivel3, String nivel4, String nivel5, String concepto) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarPagosSinRecaudoEstablecimientoPorMesYVigencia(int mes, Integer vigencia) throws ExcepcionDAO;
    public BigDecimal buscarTotalPagosActuacionesAdmPorMesYVigencia(int mes,Integer vigencia) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesConARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO;
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmTodosMunicipiosPorMesSinARaCodigo(int mes, Integer vigencia, String fechaLiq) throws ExcepcionDAO;
    public List<ConsolidadoDistVO> buscarConsolidadoDistribPorIdDistribucion(Long dmeCodigo) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmPorMesVigenciaReporte(int mes, Integer vigencia, String concepto,String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    public List<ReporteOperadorVO> buscarValorRecaudoActAdmConsolidadoPorMesReporte(int mes, Integer vigencia, String concepto,String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesValidacion(int mes, Integer vigencia) throws ExcepcionDAO;
    
    public List<RecaudoEnteVO> buscarValorRecaudoActAdmPorMesYVigencia(int mes, Integer vigencia, String nivel1, 
                                                             String nivel2, String nivel3, String nivel4, String nivel5) throws ExcepcionDAO;
    
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaBeneficiariosEnteActualizar(List<BeneficiarioEnteVO> listaBeneficiariosEnteActualizar);
}
