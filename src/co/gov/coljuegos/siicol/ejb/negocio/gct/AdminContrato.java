package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DeclaracionSugeridaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteContratoConcesionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DeclaracionOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.LiquidacionOtrosConceptosWSVO;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminContrato {
    public List<ContratoVO> buscarContratosPorEstadoEjecucion(String estado) throws ExcepcionDAO;

    public List<ContratoVO> buscarContratosOuterJoinEstadoSolicitud(String pEstado) throws ExcepcionDAO;

    public List<ContratoVO> contratosPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO;

    public List<EstadoCuentaVO> estadoCuenta(String contrato, Integer concepto, Date fechaCorte,
                                             boolean isOrderDesc) throws ExcepcionDAO;

    public List<EstadoCuentaVO> estadoCuentaNit(String contrato, Integer concepto, Date fechaCorte, boolean isOrderDesc,
                                                String nit) throws ExcepcionDAO;

    public ContratoVO guardarContrato(ContratoVO contratoVo, UsuarioVO usuarioLogueado, boolean cambioEstado,
                                      SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO;

    public List<EstadoCuentaVO> interesesXCuota(String contrato, Integer concepto, Integer cuota) throws ExcepcionDAO;

    public List<ContratoVO> buscarContratosEstadoCuenta() throws ExcepcionDAO;

    public List<EstadoCuentaVO> estadoAcuerdoPago(String nit, Date fechaCorte) throws ExcepcionDAO;

    public List<ContratoVO> buscarContratosPorNit(String nit) throws ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosVigentesPorNit(String nit) throws ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosXFechaTermi() throws ExcepcionDAO ;

    /**
     *Metodo encargado de generar la declaracion del operador para las obligaciones por concepto de derechos
     * de explotacion y gastos de administracion de un mes determinado
     * @author David Tafur
     * @param nit
     * @param numeroContrato
     * @param mesDeclararar
     * @return
     */
    public DeclaracionOperadorWSVO generarDeclaracionOperadorGaDe(String nit, String numeroContrato, Integer mesDeclararar,
                                                                  Integer anoDeclarar) throws ExcepcionAplicacion, ExcepcionDAO;

    /**
     *Metodo encargado de generar la liquidacion del operador para otro conceptos
     * @author David Tafur
     * @param nit
     * @return
     */
    public LiquidacionOtrosConceptosWSVO generarLiquidacionOtrosConceptos(String nit) throws ExcepcionAplicacion, ExcepcionDAO;

    /**
     *Metodo encargado de hacer la consulta del estado de cuenta para los conceptos diferentes a GA y DE
     * Adaptacion por : David Tafur
     * @param nit
     * @param fechaCorte
     * @param isOrderTipo
     * @return
     * @throws ExcepcionDAO
     */
    public List<EstadoCuentaVO> estadoCuentaLiquidacionOtrosConceptos(String nit, Date fechaCorte) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param idContrato
     * @return
     */
    public ContratoVO buscarContratoPolizaConcesion(Long idContrato) throws ExcepcionDAO;

    public void actualizarSiiDeclaracionOperador(SiiDeclaracionSugerida siiDeclaracionSugerida) throws ExcepcionDAO;

    public DeclaracionSugeridaVO buscarDeclaracionSugeridaPorId(Long idDeclaracionSugerida) throws ExcepcionDAO;

    public List<ContratoVO> buscarTodoSiiContrato() throws ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosDesdePerfeccionados() throws ExcepcionDAO;

    public ContratoVO buscarContratoPorNumero(String conNumero) throws ExcepcionDAO;    
    
    /**
     * @author Giovanni
     * @param conCodigo
     * @throws ExcepcionDAO
     */
    public ReporteContratoConcesionVO reporteContratoConcesion(Long conCodigo) throws ExcepcionDAO; 

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ContratoVO> contratosVigentesSinPolizasPendientes() throws ExcepcionDAO ;
    
    public BigDecimal calculoValorXEjecutarContratoConc(Long conCodigo) throws ExcepcionDAO;
    
    /**
     * @author Giovanni
     * @param conCodigo
     * @return
     * @throws ExcepcionDAO
     */
   // public BigDecimal calculoValorXEjecutarContratoConcesion(Long conCodigo) throws ExcepcionDAO;
    
    /**
     * @author Giovanni
     * @param conCodigo
     * @return
     * @throws ExcepcionDAO
     */
    //public BigDecimal calculoValorContratoConcesion(Long conCodigo) throws ExcepcionDAO;
    
    /**
     * Calcular el valor liquidado del contrato hasta el mes anterior a la fecha actual
     * @param miContrato
     * @return totCto1 - valor desde el inicio hasta el último mes liquidado, así:
     * TOT_CTO1 = Suma valor del concepto DE para el contrato en Cuota operador +
     *            Suma valor del concepto GA para el contrato en Cuota operador
     * @throws ExcepcionDAO
     */

    public BigDecimal calculoValorLiquidadoContratoConcesion(ContratoVO miContrato) throws ExcepcionDAO;

    /**
     * Calcular el valor del contrato de concesión
     * @param miContrato
     * @return tot_cto - valor total del contrato TOT_CTO =   DE + GA
     * @throws ExcepcionDAO
     */

    public BigDecimal calculoValorContratoConcesion(ContratoVO miContrato) throws ExcepcionDAO;

    /**
     * Calcular el Valor del Contrato de Concesión
     * @param conCodigo
     * @return tot_cto - valor total del contrato TOT_CTO =   DE + GA
     * @throws ExcepcionDAO
     */
    
    public BigDecimal calculoValorContratoConcesion(Long conCodigo) throws ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosXEstadoEjecucionYFechaTermi(String estado) throws ExcepcionDAO ;
    
    public List<EstadoCuentaVO> saldoLiqContrato(String contrato) throws ExcepcionDAO ;
        
    public void cargarContrato(List<List<EstadoCuentaVO>> listaListaCuotas, UsuarioVO usuarioVo) throws ExcepcionAplicacion, ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosEnEjecucion() throws ExcepcionDAO;
    
    public ContratoVO buscarContratoPorId(Long conCodigo) throws ExcepcionDAO;
    
    public void reanudarContratosSuspendidos() throws ExcepcionDAO;

    public List<ContratoVO> buscarContratosEnEjecucionSinTramiteSuspension() throws ExcepcionDAO;
    
    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXCodigoCuotaConDetalle(Long codigoCuota) throws ExcepcionDAO;
    
    public DeclaracionOperadorWSVO generarDeclaracionOperadorGaDeSeleccion(String nit, String numeroContrato, Integer mesDeclararar,
                                                                  Integer anoDeclarar, String estado) throws ExcepcionAplicacion, ExcepcionDAO;
    
    public BigDecimal calcularValorEjecutadoContrato (Long conCodigo) throws ExcepcionDAO;
    public BigDecimal calcularValorEjecutadoContrato (ContratoVO contratoVo) throws ExcepcionDAO;
    
    
    public ContratoVO insertarContrato(ContratoVO contratoVo) throws ExcepcionDAO;
    public ContratoVO actualizarContrato(ContratoVO contratoVo) throws ExcepcionDAO;
    
    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXVigenciaMesConNumero(Integer vigencia, Integer mes, String conNumero) throws ExcepcionDAO;
    
    public List<EstadoCuentaVO> estadoMultasSanciones(String nit, Date fechaCorte) throws ExcepcionDAO;
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // METODOS PARA LA CONSULTA DEL ESTADO DE CUENTA, CON LA DEPURACION DE LA LISTA RESULTANTE //
    /////////////////////////////////////////////////////////////////////////////////////////////
    public List<EstadoCuentaVO> consultarEstadoCuenta (String contrato, Integer concepto, Date unaFechaCorte, boolean isOrderTipo) throws Exception;
    public List<EstadoCuentaVO> consultarEstadoCuentaNit (String contrato, Integer concepto, Date unaFechaCorte, boolean isOrderDesc, String nit) throws Exception;
    public List<EstadoCuentaVO> consultarEstadoCuentaLiquidacionOtrosConceptos(String contrato, Date unaFechaCorte) throws Exception;
    public List<EstadoCuentaVO> procesarLista (List<EstadoCuentaVO> listaEntrada, Date unaFechaCorte) throws Exception;
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    public List<ContratoVO> buscarContratosXEstadoEjecucion(String estado) throws ExcepcionDAO;
    
    public List<EstadoCuentaVO>  estadoCuentaIlegalidad(String nit, Date fechaCorte) throws ExcepcionDAO;
    
    public void actualizacionMultasySanciones();
    
    public List<ContratoVO> buscarContratosVigentes(String vigente) throws ExcepcionDAO;
    
    public List<ContratoVO> buscarContratosVigentesOrdenDesc() throws ExcepcionDAO;
    
    public ContratoVO buscarContratoPolizaConcesionRenovacion(Long idContrato) throws ExcepcionDAO;
    
    public ContratoVO buscarContratoPorCedente(Long conCodigo) throws ExcepcionDAO ;
}
