package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.vo.ClaseJuegoVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.InstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.MarcaVO;
import co.gov.coljuegos.siicol.ejb.vo.MetVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoJuegoVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public interface AdminNovedad {
    public int insertarError(Long codigoError, long estado, int contErrores) throws ExcepcionDAO;

    public List<NovedadVO> buscarNovedadesPorIdContrato(Long idContrato) throws ExcepcionDAO;
    
    public BigDecimal valorInicialContrato(Long idContrato) throws ExcepcionDAO ;

    public BigDecimal valorOtroSi(Long idOtroSi) throws ExcepcionDAO;
    
    public SiiContrato insertarSiiContrato(Date pFechaInicio, Date pFechaFin, long pEstado,
                                           SiiOperador pOperador) throws ExcepcionDAO;

    public SiiNovedad insertarSiiNovedad(Date pFecha, SiiContrato contrato, Long tipoNovedad,
                                         SiiSolicitudAutoriza solicitud) throws ExcepcionDAO;

    public SiiMet insertarSiiMet(MetVO unaMet, SiiMarca marca) throws ExcepcionDAO;

    public SiiMarca insertarSiiMarca(MarcaVO marcaVo) throws ExcepcionDAO;

    public SiiInventario insertarSiiInventario(Date fechaIniLiq, Date fechaFinLiq, Date fechaIniOfi, Date fechaFinOfi,
                                               SiiEstablecimiento establecimiento, SiiInstrumento instrumento,
                                               SiiNovedad novedad, SiiTipoApuesta tipoApuesta,
                                               Integer numeroSillas) throws ExcepcionDAO;

    public SiiPersona actualizarSiiPersona(SiiPersona personaOrigen, PersonaVO personaDestino) throws ExcepcionDAO;

    public SiiDetalleFinanc actualizarDetalleFinan(SiiDetalleFinanc detalleFinancOrg,
                                                   DetalleFinancVO detalleFinancVo) throws ExcepcionDAO;

    public String aplicarNovedadesSolicitudLocalizados(SolicitudAutorizaVO solicitud, ContratoVO contrato,
                                                       int tiempoProrroga, Long tipoNovedad, String direccionLocal,
                                                       String ubicacionLocal,
                                                       List<InstrumentoVO> listaInstContratoNuevo,
                                                       EstablecimientoVO establecimiento, TipoApuestaVO tipoApuesta,
                                                       ClaseJuegoVO claseJuegoVo, TipoJuegoVO tipoJuegoVo,
                                                       InventarioVO inventarioVo, Integer numeroSillas,
                                                       PersonaVO operador, String pNit, PersonaVO repLegal,
                                                       PersonaVO revisor, PersonaVO contacto, PersonaVO apoderado,
                                                       PersonaVO socio1, PersonaVO socio2, PersonaVO socio3,
                                                       PersonaVO socio4, PersonaVO socio5,
                                                       DetalleFinancVO detalleFinanVo,
                                                       Long tipoElemento) throws ExcepcionDAO;

    public List<NovedadVO> buscarNovedadPorSolicitudAutotiza(Long sauCodigo) throws ExcepcionDAO;

    public List<NovedadVO> buscarNovedadesPorEstadoDeSolicitud(String estadoSolicitud) throws ExcepcionDAO;

    /**
     *Metodo encargado de almacenar en la base de datos todos los elementos de una novedad (Adicion de Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String insertarNovedadAdicionElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                                 List<MovCargueInventarioWSVO> listaInventarioSiito,
                                                 List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo,
                                                 Boolean docCargados) throws ExcepcionAplicacion,
                                                                                                                  ExcepcionDAO;


    /**
     *Metodo encargado de hacer la creacion de un establecimiento con la informacion que llega del web-services
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..   siiEstablecimiento.getEstCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String crearLocal(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                             List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                             List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo,
                                                 Boolean docCargados) throws ExcepcionAplicacion,
                                                                                              ExcepcionDAO;


    /**
     *Metodo encargado de almacenar en la base de datos todos los elementos de una novedad (Adicion de Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String insertarNovedadRetiroElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO,
                                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo, boolean docCargados) throws ExcepcionAplicacion, ExcepcionDAO;

    /**
     *Metodo encargado de almacenar en la base de datos una novedad de traslado (Traslado de Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String trasladoElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                   List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO,
                                   List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion,
                                                                                                    ExcepcionDAO;

    /**
     *Metodo encargado de hacer el reemplazo en la base de datos todos los elementos de una novedad (Reemplazo Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String reemplazoElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                    List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO,
                                    List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion,
                                                                                                     ExcepcionDAO;

    /**
     *Metodo encargado de hacer un cambio de apuesta sobre algun instrumento en el inventario
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..   siiEstablecimiento.getEstCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String cambioApuesta(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO,
                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion,
                                                                                                 ExcepcionDAO;

    /**
     *Metodo encargado de almacenar en la base de datos todos los elementos de una novedad (Elementos en bodega)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String elementosEnBodega(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                    List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO,
                                    List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion,
                                                                                                     ExcepcionDAO;

    /**
     *
     * Metodo de validacion adicion elementos
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesOtrasNovedades(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                             List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO,
                                                                                                            Exception;

    /**
     *
     * Metodo de validacion Met linea
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesReporteMetLinea(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                              List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO;

    /**
     *
     * Metodo de validacion Contadores Met
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesReporteContadoresMet(SolicitudAutorizaWSVO solicitudAutorizacionWSVO,
                                                   List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO;

    /**
     *Metodo encargado de almacenar en la base de datos todos los datos ACDV
     * @param solicitudAutorizaWSVO
     * @author Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String creacionLicenciaACDV(SolicitudAutorizaWSVO solicitudAutorizaWSVO,
                                       List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO ,
                                       
                                       List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion,
                                                                                                        ExcepcionDAO;

    /**
     * @author Giovanni
     * @param solicitudAutorizacionWSVO
     * @param movCargueInventarioWSVOs
     * @return
     * @throws ExcepcionDAO
     * @throws Exception
     */
    public String cargaOtrasNovedades(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                      List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    public List<Long> buscarUltimasSolicitudeDelContrato(Long conCodigo) throws ExcepcionDAO, Exception;
    
    public SolicitudAutorizaVO buscarSolicitudAutorizaContratoNuevoPorIdContrato(Long conCodigo) throws ExcepcionDAO;
    
    public List<NovedadVO> buscarNovedadesPorIdOtrosi(Long idOtrosi) throws ExcepcionDAO;
}



