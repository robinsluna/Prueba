package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioWebVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionDemasJuegosAutorizadosVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionMesasCasinoAutorizadasVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionMetAutorizadaVO;
import co.gov.coljuegos.siicol.ejb.vo.UbicacionSillasBingoAutorizadasVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.ValorMensualPorApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.ConsultaInventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.establecimientos.DetalleEstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.siito.inventarioPorNit.ConsultaInventarioNitVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DetalleFinancieroWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.EstablecimientoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.UbicacionWSVO;

import java.math.BigDecimal;

import java.util.List;


public interface AdminSolicitudAutoriza {
    public List<ConsultaInventarioVO> consultarInventario(SolicitudAutorizaWSVO sol) throws ExcepcionDAO;

    public ConsultaInventarioNitVO consultarInventarioNit(String nit) throws ExcepcionDAO;

    public List<UbicacionWSVO> municipiosPorDepartamento(String numeroDepto) throws ExcepcionDAO;

    public List<EstablecimientoWSVO> establecimientosPorCodUbicacion(String codUbicacion) throws ExcepcionDAO;

    public String insertarInventario(List<ConsultaInventarioVO> inventario) throws ExcepcionDAO;

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionPorNombreEstado(Long estado,
                                                                                Long usuarioLogueado) throws ExcepcionDAO;

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionPorEstadoPorTipoSol(Long estado,
                                                                                    Long tipoSol) throws ExcepcionDAO;

    public List<DetalleEstablecimientoVO> detalleEstablecimientosPorCodUbicacion(Long codEstablecimiento) throws ExcepcionDAO;

    // public String cargarDeclaracionDeGa(DeclaracionConsultaVO declaracionOtros) throws ExcepcionDAO;

    //  public String cargarDeclaracionOtros(DeclaracionConsultaOtrosVO declaracionOtros) throws ExcepcionDAO;

    public SolicitudAutorizaVO buscarSolicitudAutorizacionPorCodigo(Long idCodigoSolicitudAutorizacion) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param oficioLiquidacionVO
     * @param solicitudAutorizaVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public SolicitudAutorizaVO actualizarEstadoOficioSolicitudAutoriza(OficioLiquidacionVO oficioLiquidacionVO,
                                                                       SolicitudAutorizaVO solicitudAutorizaVO,
                                                                       UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                         ExcepcionAplicacion;

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioLiq(UsuarioVO usuarioLogueado) throws ExcepcionDAO;

    /**
     *Metodo encargado de registrar un nuevo contrato
     * @author David Tafur
     * @param solicitudAutorizacionWSVO
     * @param detalleFinancieroWSVO
     * @param listaMovCargueInventarioWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public String contratoNuevo(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                DetalleFinancieroWSVO detalleFinancieroWSVO,
                                List<MovCargueInventarioWSVO> listaMovCargueInventarioWSVO,
                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion;


    public String cargarProrrogaContrato(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                         DetalleFinancieroWSVO detalleFinancieroWSVO,
                                         List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                          ExcepcionAplicacion;

    public String desistirSolicitud(SolicitudAutorizaWSVO SolicitudAutorizacion,
                                    List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                     ExcepcionAplicacion;

    public String transladoAutomatico(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                   List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionAplicacion,
                                                                                                    ExcepcionDAO;

    public List<UbicacionWSVO> obtenerDepartamentos() throws ExcepcionDAO;


    /**
     *Metodo encargado de desistir la solicitud de autorizacion que se ha ingresado anteriormente
     * @Author David Tafur
     * @param solicitudAutorizacionWSVO
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public String marcarMetOnline(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                  List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO) throws ExcepcionDAO,
                                                                                                 ExcepcionAplicacion,
                                                                                                 Exception;

    /**
     *
     * Metodo validacion contrato nuevo
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesContratoNuevo(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                            List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO;

    /**
     *
     * Metodo validacion renovacio
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesRenovacion(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                         List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO;

    public String inventarioElementos(Long sauCodigo) throws ExcepcionDAO;

    /**
     * Metodo encargado de registrar una renovacion de un contrato
     * @author Giovanni
     * @param solicitudAutorizacionWSVO
     * @param detalleFinancieroWSVO
     * @param listaMovCargueInventarioWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public String renovacionContrato(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                     DetalleFinancieroWSVO detalleFinancieroWSVO,
                                     List<MovCargueInventarioWSVO> listaMovCargueInventarioWSVO,
                                     List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO,
                                                                                                      ExcepcionAplicacion;

    public List<SolicitudAutorizaVO> solicitudesAutorizacionPorEstadoPorTipoSolPorUsuario(Long estado, Long tipoSol,
                                                                                          Long usuCodigo) throws ExcepcionDAO;

    public List<SolicitudAutorizaVO> solicitudesAutorizacionAprobadasQueNoModificanValor(Long usuCodigo) throws ExcepcionDAO;

    public List<SolicitudAutorizaVO> solicitudesAutorizacionAprobadasQueNoModificanValor() throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @return
     * @throws ExcepcionDAO
     */
    public int validarInventarioXOperador(List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                          Long tipoSolicitud) throws ExcepcionDAO;


    public List<UbicacionMetAutorizadaVO> ubicacionMetsAutorizadas(Long sauCodigo) throws ExcepcionDAO;

    public List<UbicacionSillasBingoAutorizadasVO> ubicacionSillasBingoAutorizadas(Long sauCodigo) throws ExcepcionDAO;

    public List<UbicacionMesasCasinoAutorizadasVO> ubicacionMesasCasinoAutorizadas(Long sauCodigo) throws ExcepcionDAO;

    public List<UbicacionDemasJuegosAutorizadosVO> ubicacionEsferodromosAutorizados(Long sauCodigo) throws ExcepcionDAO;

    public List<ValorMensualPorApuestaVO> valorMensualPorApuesta(Long sauCodigo) throws ExcepcionDAO;
    
    public BigDecimal contarElementosPorTipoNovedadPorSolicitud(String movimiento, String listaEstados, Long sauCodigo) throws ExcepcionDAO;
    
    public List<InventarioWebVO> inventarioNitWeb(String nit) throws ExcepcionDAO;
    
    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioPorEstado(Long estado,Long estado2,Long usuarioLogueado) throws ExcepcionDAO;
	
    public List<NovedadVO> buscarNovedadesPorSolicitudAutorizacion(Long idSolicitud) throws ExcepcionDAO;
        
    public String localesExcluidosContrato(Long conCodigo) throws ExcepcionDAO;
    
    public String textoCantidadElementosPorAccionPorSolicitud(String accion, String listaEstados, Long sauCodigo) throws ExcepcionDAO;

    public BigDecimal DerechoDeExplotacionApuesta(long apuesta);
    
    public Long buscarSmmlvPorVigencia(Integer vigencia);
    
    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioLiqPorTipoSolicitud(UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    
    public String nombreEstadoSolicitud(Long esaCodigo) throws ExcepcionDAO;
    
    public EstadoSolicAutorizVO buscarEstadoSolicAutorizPorId(Long esaCodigo) throws ExcepcionDAO;
}
