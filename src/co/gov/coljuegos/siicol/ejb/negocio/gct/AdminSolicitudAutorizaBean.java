package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoInventario;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteDocumDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.JuegoMesaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MarcaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesaCasinoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SmmlvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminalAcdvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoInstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPersonalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoSolicAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UsuarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.EstadoCargueInventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.MovCargInvEstCargInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.SolicitudAutorizaWSDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiJuegoMesa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminalAcdv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoEstadoCargueInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargInvEstCargInv;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOWS;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioWebVO;
import co.gov.coljuegos.siicol.ejb.vo.LocalesMinimosVO;
import co.gov.coljuegos.siicol.ejb.vo.MunicipiosMinimosVO;
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
import co.gov.coljuegos.siicol.ejb.wsvo.DocumentoRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.EstablecimientoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.UbicacionWSVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import oracle.xml.xsql.Res;


@Stateless
public class AdminSolicitudAutorizaBean implements AdminSolicitudAutoriza {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ConversionVOWS conversionWSVoEntidad;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDAO;
    @EJB
    private SolicitudAutorizaWSDAO solicitudAutorizawsDAO;
    @EJB
    private OficioLiquidacionDAO oficioLiquidacionDAO;
    @EJB
    private EstablecimientoDAO establecimientoDAO;
    @EJB
    private DetalleFinancDAO detalleFinancDAO;
    @EJB
    private InventarioDAO inventarioDAO;
    @EJB
    private NovedadDAO novedadDAO;
    @EJB
    private ConversionVOWS conversionVOWS;
    @EJB
    private ContratoDAO contratoDAO;
    @EJB
    private PersonaDAO personaDAO;
    @EJB
    private OperadorDAO operadorDAO;
    @EJB
    private MetDAO metDAO;
    @EJB
    private InstrumentoDAO instrumentoDAO;
    @EJB
    private UbicacionDAO ubicacionDAO;
    @EJB
    private MesaCasinoDAO mesaCasinoDAO;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ExpedienteDocumDAO expedienteDocumDAO;
    @EJB
    private DocumentoRadicadoDAO documentoRadicadoDAO;
    @EJB
    private ExpedienteRadicadoDAO expedienteRadicadoDAO;
    @EJB
    private EstadoCargueInventarioDAO estadoCargueInventarioDAO;
    @EJB
    private MovCargInvEstCargInvDAO movCargInvEstCargInvDAO;
    @EJB
    private EnteTerritorialDAO enteTerritorialDAO;
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private TerminalAcdvDAO terminalAcdvDAO;
    @EJB
    private EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    @EJB
    private TipoInstrumentoDAO tipoInstrumentoDao;
    @EJB
    private MarcaDAO marcaDao;
    @EJB
    private JuegoMesaDAO juegoMesaDao;
    @EJB
    private TipoApuestaDAO tipoApuestaDao;
    @EJB
    private TipoDocRadicadoDAO tipoDocRadicadoDao;
    @EJB
    private TipoSolicAutorizaDAO tipoSolicAutorizaDao;
    @EJB
    private SmmlvDAO smmlvDAO;
    @EJB
    private TipoPersonalDAO tipoPersonalDao;
    @EJB
    private PersonaDAO personaDao;

    public AdminSolicitudAutorizaBean() {

    }

    public List<SolicitudAutorizaVO> buscarTodoSiiSolicitudAutoriza() throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> solicitudesAutoriza = solicitudAutorizaDAO.buscarTodoSiiSolicitudAutoriza();
        List<SolicitudAutorizaVO> solicitudesAutorizaVO = new ArrayList();
        for (SiiSolicitudAutoriza solicitudAutoriza : solicitudesAutoriza) {
            solicitudesAutorizaVO.add(new SolicitudAutorizaVO(solicitudAutoriza));
        }
        return solicitudesAutorizaVO;
    }

    public List<ConsultaInventarioVO> consultarInventario(SolicitudAutorizaWSVO sol) throws ExcepcionDAO {
        return solicitudAutorizaDAO.consultarInventario(sol);
    }

    public ConsultaInventarioNitVO consultarInventarioNit(String nit) throws ExcepcionDAO {
        return solicitudAutorizaDAO.consultarInventarioNit(nit);
    }

    public List<UbicacionWSVO> municipiosPorDepartamento(String numeroDepto) throws ExcepcionDAO {
        return solicitudAutorizaDAO.municipiosPorDepartamento(numeroDepto);
    }

    /**
     *Metodo encargado de consultar los establecimientos por su ubicacion
     * @param codUbicacion
     * @return
     * @throws ExcepcionDAO
     */
    public List<EstablecimientoWSVO> establecimientosPorCodUbicacion(String codUbicacion) throws ExcepcionDAO {

        List<EstablecimientoWSVO> listaEstablecimientoWSVO = new ArrayList<EstablecimientoWSVO>();
        List<EstablecimientoVO> listaEstablecimientoVO = new ArrayList<EstablecimientoVO>();
        listaEstablecimientoVO = solicitudAutorizaDAO.establecimientosPorCodUbicacion(codUbicacion);
        if (listaEstablecimientoVO != null) {
            for (EstablecimientoVO establecimientoVO : listaEstablecimientoVO) {

                EstablecimientoWSVO establecimientoWSVO = new EstablecimientoWSVO();
                establecimientoWSVO = conversionVOWS.convertir(establecimientoVO);
                listaEstablecimientoWSVO.add(establecimientoWSVO);
            }
        }
        return listaEstablecimientoWSVO;
    }

    public String insertarInventario(List<ConsultaInventarioVO> inventario) throws ExcepcionDAO {
        return solicitudAutorizawsDAO.insertarInventario(inventario);
    }

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionPorNombreEstado(Long estado, Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSiiSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNombreEstado(estado, usuarioLogueado);
        List<SolicitudAutorizaVO> solicitudesAutorizaVO = new ArrayList();
        for (SiiSolicitudAutoriza solicitud : listaSiiSolicitudes) {
            SolicitudAutorizaVO solicitudVo = new SolicitudAutorizaVO(solicitud);
            List<NovedadVO> listaNovedadVo = new ArrayList();
            if (solicitud.getSiiNovedadList() != null && !solicitud.getSiiNovedadList().isEmpty()) {
                for (SiiNovedad unaNov : solicitud.getSiiNovedadList()) {
                    listaNovedadVo.add(new NovedadVO(unaNov));
                }
            }
            solicitudVo.setNovedadListVo(listaNovedadVo);
            solicitudesAutorizaVO.add(solicitudVo);


        }
        return solicitudesAutorizaVO;
    }

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionPorEstadoPorTipoSol(Long estado, Long tipoSol) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSiiSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorEstadoPorTipoSol(estado, tipoSol);
        List<SolicitudAutorizaVO> solicitudesAutorizaVO = new ArrayList();
        for (SiiSolicitudAutoriza solicitud : listaSiiSolicitudes) {
            solicitudesAutorizaVO.add(new SolicitudAutorizaVO(solicitud));
        }
        return solicitudesAutorizaVO;
    }

    public List<DetalleEstablecimientoVO> detalleEstablecimientosPorCodUbicacion(Long codEstablecimiento) throws ExcepcionDAO {
        return solicitudAutorizaDAO.detalleEstablecimientosPorCodUbicacion(codEstablecimiento);
    }

    public SolicitudAutorizaVO buscarSolicitudAutorizacionPorCodigo(Long idCodigoSolicitudAutorizacion) throws ExcepcionDAO {
        SiiSolicitudAutoriza solicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorCodigo(idCodigoSolicitudAutorizacion);
        return new SolicitudAutorizaVO(solicitudAutoriza);
    }

    /**
     * @author Modifica Giovanni
     * @param oficioLiquidacionVO
     * @param solicitudAutorizaVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public SolicitudAutorizaVO actualizarEstadoOficioSolicitudAutoriza(OficioLiquidacionVO oficioLiquidacionVO, SolicitudAutorizaVO solicitudAutorizaVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                                                                                                           ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /* SiiOficioLiquidacion siiOficioLiquidacionTemp = new SiiOficioLiquidacion();
        siiOficioLiquidacionTemp =
            oficioLiquidacionDAO.buscarPorCodigoOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());
        if (siiOficioLiquidacionTemp.getSiiEstadoOficioLiq().getEolCodigo() !=
            oficioLiquidacionVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud autoriza fue cambiado durante la modificación. Seleccione nuevamente  la solicitud autoriza");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (oficioLiquidacionVO.getEstadoOficioLiqVo().getEolCodigo() != oficioLiquidacionVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(), oficioLiquidacionVO.getEstadoOficioLiqVo().getEolCodigo(), usuarioLogueado,
                                                         oficioLiquidacionVO.getOliCodigo());
        }

        /*
         * Manejo de error de concurrencia
         */
        /*SiiSolicitudAutoriza siiSolicitudAutorizaTemp = new SiiSolicitudAutoriza();
        siiSolicitudAutorizaTemp =
            solicitudAutorizaDAO.buscarSolicitudAutorizacionPorCodigo(solicitudAutorizaVO.getSauCodigo());
        if (siiSolicitudAutorizaTemp.getSiiEstadoSolicAutoriz().getEsaCodigo() !=
            solicitudAutorizaVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud autoriza fue cambiado durante la modificación. Seleccione nuevamente  la solicitud autoriza");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (solicitudAutorizaVO.getEstadoSolicAutoriz().getEsaCodigo() != solicitudAutorizaVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(), solicitudAutorizaVO.getEstadoSolicAutoriz().getEsaCodigo(), usuarioLogueado,
                                                         solicitudAutorizaVO.getSauCodigo());
        }

        // Se actualiza el estado de la solicitud
        SiiSolicitudAutoriza resultadoSolicitud = solicitudAutorizaDAO.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVO));

        SiiOficioLiquidacion siiOficioLiquidacion = conversionVoEntidad.convertir(oficioLiquidacionVO);
        siiOficioLiquidacion.setSiiSolicitudAutoriza(resultadoSolicitud);
        oficioLiquidacionDAO.actualizarSiiOficioLiquidacion(siiOficioLiquidacion);
        return new SolicitudAutorizaVO(resultadoSolicitud);

    }

    /*
    public String cargarDeclaracionOtros(DeclaracionConsultaOtrosVO declaracionOtros) throws ExcepcionDAO {
        String retorno = "1 Cargue exitoso";
        //Se obtiene la liquidación
        // SiiLiquidacionMes liquidacion = liquidacionMesDao.buscarLiquidacionMesPorId(declaracionOtros.getNumLiquidacion());

        //Se obtiene la Cuota
        SiiCuotaOperador cuotaOperador =
            cuotaOperadorDAO.buscarCuotaOperadorPorCuotaVigencia(declaracionOtros.numConsecutivoCuota,
                                                                 declaracionOtros.numLiquidacion);

        //Se crea la referencia de pago
        SiiReferenciaPagoDecl referencia = new SiiReferenciaPagoDecl();
        long codigoRef = referenciaPagoDAO.buscarConsecutivoReferencia();
        long numeroRef = referenciaPagoDAO.buscarNumeroReferencia();
        referencia.setRpdCodigo(codigoRef);
        referencia.setRpdNumero(numeroRef);
        //Se inserta la Referencia de Pago
        try {
            referenciaPagoDeclDAO.insertarReferenciaPagoDecl(referencia);
        } catch (ExcepcionDAO e) {
            retorno = "-1 Error insertando Referencia de Pago";
        }

        //se crea declaración operador
        SiiDeclaracionOperador decOperador = new SiiDeclaracionOperador();
        decOperador.setDopCodigo(declaracionOperadorDAO.consultarConsecutivo());
        decOperador.setDopFecha(new Date(System.currentTimeMillis()));
        decOperador.setDopTipo("D");
        //Guardar la declaracion
        try {
            declaracionOperadorDAO.insertarSiiDeclaracionOperador(decOperador);
        } catch (ExcepcionDAO e) {
            retorno = "-1 Error insertando Declaración Operador";
        }

        //Calculan los dias de interes
        int dias = 100;

        //Se crea la declaracion
        SiiDetalleDeclaracion declaracion = new SiiDetalleDeclaracion();
        declaracion.setDdeBaseCalcInt(100L); //DDE_BASE_CALC_INT
        declaracion.setDdeCodigo(detalleDeclaracionDAO.buscarConsecutivoDetalle()); //DDE_CODIGO
        declaracion.setDdeDiasInteres(dias); //DDE_DIAS_INTERES
        declaracion.setDdeValorDeclarado(declaracionOtros.valorAPagar); //DDE_VALOR_DECLARADO
        declaracion.setDdeValorInter(declaracionOtros.interesesMoraCausados); //DDE_VALOR_INTER
        declaracion.setDdeValorPagInt(declaracionOtros.interesesMoraPpagar); //DDE_VALOR_PAG_INT
        declaracion.setDdeValorPagado(declaracionOtros.valorAPagar); //DDE_VALOR_PAGADO
        declaracion.setSiiCuotaOperador(cuotaOperador); //COP_CODIGO
        declaracion.setSiiDeclaracionOperador(decOperador); //DRE_CODIGO
        //declaracion.setSiiDetalleRecaudo(siiDetalleRecaudo); debe ser NULL
        declaracion.setSiiReferenciaPagoDecl(referencia); //RPD_CODIGO

        //Guardar el detalle
        try {
            detalleDeclaracionDAO.insertarDetalleDeclaracion(declaracion);
        } catch (ExcepcionDAO e) {
            retorno = "-1 Error insertando DetalleDeclaración";
        }

        return retorno;

    }*/

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioLiq(UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSiiSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionOficioLiq(usuarioLogueado.getUsuCodigo());
        List<SolicitudAutorizaVO> listaSol = new ArrayList<SolicitudAutorizaVO>();

        if (listaSiiSolicitudes.size() > 0) {
            for (SiiSolicitudAutoriza sol : listaSiiSolicitudes) {
                SolicitudAutorizaVO solicitud = new SolicitudAutorizaVO(sol);
                listaSol.add(solicitud);
            }
        }

        return listaSol;

    }

    /**
     *Metodo encargado de registrar un nuevo contrato
     * @author David Tafur
     * @author Modifica: Giovanni
     * @param solicitudAutorizacionWSVO
     * @param detalleFinancieroWSVO
     * @param listaMovCargueInventarioWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public String contratoNuevo(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, DetalleFinancieroWSVO detalleFinancieroWSVO, List<MovCargueInventarioWSVO> listaMovCargueInventarioWSVO,
                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion {

        String resultado = "";
        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * SOLICITUD AUTORIZACION
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */
        if (solicitudAutorizacionWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;

        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                //if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null ||
                //  expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                hayDocumento = true;
                break;
            }
        }


        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        //Gestion Documental
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
        siiExpedienteDocumento.setEdoFecha(calendar.getTime());
        siiExpedienteDocumento = expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);
        //Radicado
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            //Creamos el expediente radicado y lo asociamos con el expediente
            SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
            siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
            siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
            siiExpedienteRadicado.setExrFecha(new Date());
            siiExpedienteRadicado = expedienteRadicadoDAO.insertarExpedienteRadicado(siiExpedienteRadicado);

            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {

                    SiiDocumentoRadicado siiDocumentoRadicado = documentoRadicadoDAO.buscarDocumentoRadicadoPorId(radicadoWSVO.draCodigo);

                    if (siiDocumentoRadicado == null) {
                        siiDocumentoRadicado = new SiiDocumentoRadicado();
                        siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                        siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);
                        siiDocumentoRadicado.setSiiExpedienteRadicado(siiExpedienteRadicado);
                        if (radicadoWSVO.cargo != null) {
                            SiiTipoPersonal siiTipoPersonal = tipoPersonalDao.buscarTipoPersonalPorCodigo(radicadoWSVO.cargo);
                            if (siiTipoPersonal == null) {
                                throw new ExcepcionAplicacion("No se encontró el cargo con identificador " + radicadoWSVO.cargo);
                            }
                            siiDocumentoRadicado.setSiiTipoPersonal(siiTipoPersonal);
                        }

                        if (radicadoWSVO.perNumIdentificacion == null || radicadoWSVO.perNumIdentificacion.equals("")) {
                            throw new ExcepcionAplicacion("Falta el número de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                        }

                        if (radicadoWSVO.perTipoIdentificacion == null || radicadoWSVO.perTipoIdentificacion <= 0) {
                            throw new ExcepcionAplicacion("Falta el tipo de identificación de la persona del documento " + siiDocumentoRadicado.getDraCodigo());
                        }

                        SiiPersona siiPersonaRadicado = personaDao.buscarPersonaPorTipoYNumeroIdentificacion(radicadoWSVO.perTipoIdentificacion, radicadoWSVO.perNumIdentificacion);
                        if (siiPersonaRadicado == null) {
                            throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " + radicadoWSVO.perNumIdentificacion);
                        }
                        siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                        if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                            throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                        if (siiTipoDocRadicado == null) {
                            throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " + siiDocumentoRadicado.getDraCodigo());
                        }
                        siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                        documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                    }
                }
            }
        }

        /*
        * Convertimos la solicitud de autorizacion WS a Entidad
         */

        //Convertimos a VO
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizacionWSVO);
        //Convertimos a entidad
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);
        //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        siiSolicitudAutoriza.setSauFecha(calendar.getTime());

        //Usuario
        List<SiiUsuario> siiUsuarios = null;
        SiiUsuario siiUsuarioSiito = new SiiUsuario();
        siiUsuarioSiito.setUsuNombreUsuario(solicitudAutorizacionWSVO.UsuarioColjuegos.toUpperCase());
        siiUsuarios = usuarioDAO.buscarUsuarioPorNombre(siiUsuarioSiito);
        if (siiUsuarios != null && !siiUsuarios.isEmpty()) {
            siiSolicitudAutoriza.setSiiUsuario(siiUsuarios.get(0));
        }

        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
        //Persistimos en la base de datos la solicitud de autorizacion
        solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);


        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        if (siiOperadorPersona.getPerCodigo() == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un operador por ese numero de nit: " + solicitudAutorizacionWSVO.nit);
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         *DETALLE FINANCIERO
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */
        SiiDetalleFinanc siiDetalleFinanciero = new SiiDetalleFinanc();
        DetalleFinancVO detalleFinancVO = new DetalleFinancVO();
        detalleFinancVO = conversionWSVoEntidad.convertir(detalleFinancieroWSVO);
        siiDetalleFinanciero = conversionVoEntidad.convertir(detalleFinancVO);
        siiDetalleFinanciero.setSiiPersona2(siiOperadorPersona);
        siiDetalleFinanciero.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanciero);

        /*
        * VAMOS A ORGANIZAR LA LISTA DE LOS REGISTROS QUE TRAEMOS DE SIITO PARA QUE LAS PRIMERAS OPERACIONES
        * QUE SE HAGAN SEAN LAS DE CREACION DE LOCAL, DE ESTA FORMA CUANDO SE VAYA A HACER UNA ADICION
        * YA TENDREMOS LOS LOCALES A LOS CUALES SE VAN A RELACIONAR
        */
        List<MovCargueInventarioWSVO> listaOrdenadaRegistrosSiito = new ArrayList<MovCargueInventarioWSVO>();
        //Variables usadas para verificar si el contrato nuevo viene con almenos una novedad de tipo
        //Creacion de elemento o de tipo adicion de elementos
        boolean almenosUnLocal = false;
        boolean almenosUnaAdicion = false;
        //Agregamos a las primeras posiciones de la lista los elementos cuya novedad sea de tipo crear local
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaMovCargueInventarioWSVO) {
            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {

                //Le cambiamos el estado para decir que si viene almenos una noveda de tipo creacion de local
                if (!almenosUnLocal) {
                    almenosUnLocal = true;
                }

                listaOrdenadaRegistrosSiito.add(movCargueInventarioWSVO);
            }
        }
        //Seguido a esto agregamos a la lista los registros cuya novedad sea adicion de elementos
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaMovCargueInventarioWSVO) {
            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                //Le cambiamos el estado para decir que si viene almenos una noveda de tipo adicion de elemenotos
                if (!almenosUnaAdicion) {
                    almenosUnaAdicion = true;
                }
                listaOrdenadaRegistrosSiito.add(movCargueInventarioWSVO);
            }
        }

        SiiNovedad siiNovedadCreacionLocal = null;
        SiiNovedad siiNovedadAdicionElementos = null;

        if (almenosUnLocal) {
            /*
            * Novedad
            */
            siiNovedadCreacionLocal = new SiiNovedad();
            //Tipo de novedad
            SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(EnumTipoNovedad.CREACION_LOCAL.getId());
            siiNovedadCreacionLocal.setSiiTipoNovedad(siiTipoNovedad);
            //Seteo la solicitud al cual corresponde
            siiNovedadCreacionLocal.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
            //Seteo la fecha
            siiNovedadCreacionLocal.setNovFecha(calendar.getTime());
            //    siiNovedad.setSiiContrato(siiContrato);
            //Registro de la novedad
            novedadDAO.insertarSiiNovedad(siiNovedadCreacionLocal);
        }

        if (almenosUnaAdicion) {
            /*
            * Novedad
            */
            siiNovedadAdicionElementos = new SiiNovedad();
            //Tipo de novedad
            SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(EnumTipoNovedad.ADICION_ELEMENTOS.getId());
            siiNovedadAdicionElementos.setSiiTipoNovedad(siiTipoNovedad);
            //Seteo la solicitud al cual corresponde
            siiNovedadAdicionElementos.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
            //Seteo la fecha
            siiNovedadAdicionElementos.setNovFecha(calendar.getTime());
            //    siiNovedad.setSiiContrato(siiContrato);
            //Registro de la novedad
            novedadDAO.insertarSiiNovedad(siiNovedadAdicionElementos);
        }


        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder a crear
        * los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaOrdenadaRegistrosSiito) {

            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                 *ADICION ELEMENTOS
                 *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                 */

                SiiInventario siiInventario = new SiiInventario();

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * ESTABLECIMIENTO
                * Buscamos el establecimiento para ese registro de inventario
                * _/_/_/_/_/_/_/_/_/_/_/_/*/

                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                //Tipo de instrumento
                SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));
                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * INSTRUMENTO
                * Tipo intrumento
                * _/_/_/_/_/_/_/_/_/_/_/_/*/

                SiiInstrumento siiInstrumento = null;
                if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId() && movCargueInventarioWSVO.movCargueInvIucAd != null &&
                    !movCargueInventarioWSVO.movCargueInvIucAd.toString().equals("")) {
                    siiInstrumento = instrumentoDAO.consultarInstrumentosMETXNUC(movCargueInventarioWSVO.movCargueInvIucAd.toString());
                    if (siiInstrumento != null) {
                        Long marca = siiInstrumento.getSiiMet().getSiiMarca().getMarCodigo();
                        if (marca.equals(1L) || marca.equals(72L)) {
                            SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                            siiInstrumento.getSiiMet().setSiiMarca(siiMarca);
                            metDAO.actualizarSiiMet(siiInstrumento.getSiiMet());
                        }

                    }
                }

                if (siiInstrumento == null) {
                    siiInstrumento = new SiiInstrumento();
                    siiInstrumento.setSiiTipoInstrumento(siiTipoInstrumento);
                    siiInstrumento.setTapCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
                    siiInstrumento.setInsFechaRegistro(calendar.getTime());
                    siiInstrumento.setSiiOperador1(siiOperador);
                    siiInstrumento.setInsActivo("S");
                    siiInstrumento.setInsFechaRegistro(calendar.getTime());
                    siiInstrumento.setInsFechaModific(calendar.getTime());
                    /*
                * Si el tipo de instrumento que llega del ws es MET entonces creamos y registramos la MET
                */
                    SiiMet siiMet = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId()) {


                        String homologado = movCargueInventarioWSVO.movCargueInvIndInstHomo == 1 ? "S" : "N";
                        String online = movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 1 ? "S" : "N";
                        siiMet = new SiiMet();
                        siiMet.setMetHomologado(homologado);
                        siiMet.setMetOnline(online);
                        //siiMet.setMetMarcaAnterior(siitoMovCargueInventario.getMovCargueInvCodMarca());
                        //siiMet.setMetModelo();
                        siiMet.setMetNuid(movCargueInventarioWSVO.movCargueInvNuidAd);
                        //  siiMet.setMetOnline(siitoMovCargueInventario.get);
                        siiMet.setMetSerial(movCargueInventarioWSVO.movCargueInvSerialInstAd);
                        //Marca de la met
                        SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                        siiMet.setSiiMarca(siiMarca);

                        metDAO.insertarSiiMet(siiMet);
                        siiInstrumento.setSiiMet(siiMet);
                    }

                    /*
                * Si el tipo de instrumento que llega del ws es Terminal ACDV entonces creamos y registramos la Terminal ACDV
                */
                    SiiTerminalAcdv siiTerminalAcdv = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.ACDV.getId()) {
                        siiTerminalAcdv = new SiiTerminalAcdv();

                        siiTerminalAcdv.setTacSerial(movCargueInventarioWSVO.movCargueInvSerialInstAd);

                        //Marca de la terminal ACDV
                        SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                        siiTerminalAcdv.setSiiMarca(siiMarca);

                        siiTerminalAcdv.setTacModelo(movCargueInventarioWSVO.movCargueInvCodModelo);
                        siiTerminalAcdv.setTacAnioFabric(Integer.valueOf(String.valueOf(movCargueInventarioWSVO.movCargueInvAnoFab)));

                        terminalAcdvDAO.insertarSiiLicenciaAcdv(siiTerminalAcdv);

                        siiInstrumento.setSiiTerminalAcdv(siiTerminalAcdv);
                    }

                    /*
                * Si el tipo de istrumento es una mesa de casino
                */
                    SiiMesaCasino siiMesaCasino = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                        siiMesaCasino = new SiiMesaCasino();
                        SiiJuegoMesa siiJuegoMesa = juegoMesaDao.buscarJuegoMesaPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipJuegos));
                        siiMesaCasino.setSiiJuegoMesa(siiJuegoMesa);
                        mesaCasinoDAO.insertarSiiMesaCasino(siiMesaCasino);
                        siiInstrumento.setSiiMesaCasino(siiMesaCasino);
                    }

                    //Persisto el instrumento
                    instrumentoDAO.insertarSiiInstrumento(siiInstrumento);
                }

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * TIPO APUESTA
                * _/_/_/_/_/_/_/_/_/_/_/_/*/
                //SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
                SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta + "");

                /*
                * Lleno los datos del inventario
                */
                if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                    siiInventario.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
                }

                siiInventario.setSiiEstablecimiento(siiEstablecimiento);
                siiInventario.setSiiInstrumento(siiInstrumento);
                siiInventario.setSiiNovedad(siiNovedadAdicionElementos);
                siiInventario.setSiiTipoApuesta(siiTipoApuesta);
                siiInventario.setInvFechaFinLiq(calendarHoraCero.getTime());
                siiInventario.setInvFechaFinOfi(calendarHoraCero.getTime());
                siiInventario.setInvFechaIniLiq(calendarHoraCero.getTime());
                siiInventario.setInvFechaIniOfi(calendarHoraCero.getTime());
                siiInventario.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

                inventarioDAO.insertarSiiInventario(siiInventario);
            } else if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                *ESTABLECIMIENTOS
                *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                */
                /*
                * Verificamos que el establecimiento que nos llega tenga todos los campos que son obligatorios y creamos une establecimiento
                */
                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();

                //Codigo interno
                if (movCargueInventarioWSVO.movCargueInvCodLocal == null || movCargueInventarioWSVO.movCargueInvCodLocal.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta el codigo interno del establecimiento.");
                } else {
                    siiEstablecimiento.setEstCodInterno(movCargueInventarioWSVO.movCargueInvCodLocal);
                }

                //Nombre
                if (movCargueInventarioWSVO.movCargueInvNomLocal == null || movCargueInventarioWSVO.movCargueInvNomLocal.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta el nombre del establecimiento.");
                } else {
                    siiEstablecimiento.setEstNombre(movCargueInventarioWSVO.movCargueInvNomLocal);
                }

                //Direccion
                if (movCargueInventarioWSVO.movCargueInvDirDesc == null || movCargueInventarioWSVO.movCargueInvDirDesc.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta la direccion del establecimiento.");
                } else {
                    siiEstablecimiento.setEstDireccion(movCargueInventarioWSVO.movCargueInvDirDesc);
                }

                //Ubicacion
                if (movCargueInventarioWSVO.movCargueInvCodMunLoc == null || movCargueInventarioWSVO.movCargueInvCodMunLoc.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta la ubicacion  del establecimiento.");
                } else {

                    //Consultamos la ubicacion


                    SiiUbicacion siiUbicacion = new SiiUbicacion();
                    siiUbicacion = ubicacionDAO.buscarUbicacionPorId(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                    siiEstablecimiento.setSiiUbicacion1(siiUbicacion);
                }

                siiEstablecimiento.setEstEstado("PA");
                siiEstablecimiento.setSiiOperador2(siiOperador);
                siiEstablecimiento.setSiiNovedad(siiNovedadCreacionLocal);
                establecimientoDAO.insertarSiiEstablecimiento(siiEstablecimiento);

            }


        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }

    /**
     * Metodo encargado de registrar una renovacion de un contrato
     * @author Giovanni
     * @param solicitudAutorizacionWSVO
     * @param detalleFinancieroWSVO
     * @param listaMovCargueInventarioWSVO
     * @return
     * @throws ExcepcionDAO
     */
    public String renovacionContrato(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, DetalleFinancieroWSVO detalleFinancieroWSVO, List<MovCargueInventarioWSVO> listaMovCargueInventarioWSVO,
                                     List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion {

        String resultado = "";
        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         * SOLICITUD AUTORIZACION
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */
        if (solicitudAutorizacionWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                hayDocumento = true;
                break;
            }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        //Gestion Documental
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
        siiExpedienteDocumento.setEdoFecha(calendar.getTime());
        expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);
        //Radicado
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            //Creamos el expediente radicado y lo asociamos con el expediente
            SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
            siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
            siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
            siiExpedienteRadicado.setExrFecha(new Date());
            siiExpedienteRadicado = expedienteRadicadoDAO.insertarExpedienteRadicado(siiExpedienteRadicado);

            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {

                    SiiDocumentoRadicado siiDocumentoRadicado = documentoRadicadoDAO.buscarDocumentoRadicadoPorId(radicadoWSVO.draCodigo);

                    if (siiDocumentoRadicado == null) {
                        siiDocumentoRadicado = new SiiDocumentoRadicado();
                        siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                        siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);

                        //Tipo radicado
                        SiiTipoDocRadicado siiTipoDocRadicado = new SiiTipoDocRadicado();
                        siiTipoDocRadicado.setTdrCodigo(radicadoWSVO.codigoTipoDocRadicado);
                        siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                        documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                    }
                }
            }

        }

        /*
        * Convertimos la solicitud de autorizacion WS a Entidad
         */

        //Convertimos a VO
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizacionWSVO);
        //Convertimos a entidad
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);
        //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        siiSolicitudAutoriza.setSauFecha(calendar.getTime());

        //Usuario
        List<SiiUsuario> siiUsuarios = null;
        SiiUsuario siiUsuarioSiito = new SiiUsuario();
        siiUsuarioSiito.setUsuNombreUsuario(solicitudAutorizacionWSVO.UsuarioColjuegos.toUpperCase());
        siiUsuarios = usuarioDAO.buscarUsuarioPorNombre(siiUsuarioSiito);
        if (siiUsuarios != null && !siiUsuarios.isEmpty()) {
            siiSolicitudAutoriza.setSiiUsuario(siiUsuarios.get(0));
        }

        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
        //Persistimos en la base de datos la solicitud de autorizacion
        solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);


        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        if (siiOperadorPersona.getPerCodigo() == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un operador por ese numero de nit: " + solicitudAutorizacionWSVO.nit);
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         *DETALLE FINANCIERO
         *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
         */
        SiiDetalleFinanc siiDetalleFinanciero = new SiiDetalleFinanc();
        DetalleFinancVO detalleFinancVO = new DetalleFinancVO();
        detalleFinancVO = conversionWSVoEntidad.convertir(detalleFinancieroWSVO);
        siiDetalleFinanciero = conversionVoEntidad.convertir(detalleFinancVO);
        siiDetalleFinanciero.setSiiPersona2(siiOperadorPersona);
        siiDetalleFinanciero.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
        detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanciero);

        /*
        * VAMOS A ORGANIZAR LA LISTA DE LOS REGISTROS QUE TRAEMOS DE SIITO PARA QUE LAS PRIMERAS OPERACIONES
        * QUE SE HAGAN SEAN LAS DE CREACION DE LOCAL, DE ESTA FORMA CUANDO SE VAYA A HACER UNA ADICION
        * YA TENDREMOS LOS LOCALES A LOS CUALES SE VAN A RELACIONAR
        */
        List<MovCargueInventarioWSVO> listaOrdenadaRegistrosSiito = new ArrayList<MovCargueInventarioWSVO>();
        //Variables usadas para verificar si el contrato nuevo viene con almenos una novedad de tipo
        //Creacion de elemento o de tipo adicion de elementos
        boolean almenosUnLocal = false;
        boolean almenosUnaAdicion = false;
        //Agregamos a las primeras posiciones de la lista los elementos cuya novedad sea de tipo crear local
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaMovCargueInventarioWSVO) {
            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {

                //Le cambiamos el estado para decir que si viene almenos una noveda de tipo creacion de local
                if (!almenosUnLocal) {
                    almenosUnLocal = true;
                }

                listaOrdenadaRegistrosSiito.add(movCargueInventarioWSVO);
            }
        }
        //Seguido a esto agregamos a la lista los registros cuya novedad sea adicion de elementos
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaMovCargueInventarioWSVO) {
            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                //Le cambiamos el estado para decir que si viene almenos una noveda de tipo adicion de elemenotos
                if (!almenosUnaAdicion) {
                    almenosUnaAdicion = true;
                }
                listaOrdenadaRegistrosSiito.add(movCargueInventarioWSVO);
            }
        }

        SiiNovedad siiNovedadCreacionLocal = null;
        SiiNovedad siiNovedadAdicionElementos = null;

        if (almenosUnLocal) {
            /*
            * Novedad
            */
            siiNovedadCreacionLocal = new SiiNovedad();
            //Tipo de novedad
            SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(EnumTipoNovedad.CREACION_LOCAL.getId());
            siiNovedadCreacionLocal.setSiiTipoNovedad(siiTipoNovedad);
            //Seteo la solicitud al cual corresponde
            siiNovedadCreacionLocal.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
            //Seteo la fecha
            siiNovedadCreacionLocal.setNovFecha(calendar.getTime());
            //    siiNovedad.setSiiContrato(siiContrato);
            //Registro de la novedad
            novedadDAO.insertarSiiNovedad(siiNovedadCreacionLocal);
        }

        if (almenosUnaAdicion) {
            /*
            * Novedad
            */
            siiNovedadAdicionElementos = new SiiNovedad();
            //Tipo de novedad
            SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(EnumTipoNovedad.ADICION_ELEMENTOS.getId());
            siiNovedadAdicionElementos.setSiiTipoNovedad(siiTipoNovedad);
            //Seteo la solicitud al cual corresponde
            siiNovedadAdicionElementos.setSiiSolicitudAutoriza(siiSolicitudAutoriza);
            //Seteo la fecha
            siiNovedadAdicionElementos.setNovFecha(calendar.getTime());
            //    siiNovedad.setSiiContrato(siiContrato);
            //Registro de la novedad
            novedadDAO.insertarSiiNovedad(siiNovedadAdicionElementos);
        }


        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder a crear
        * los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaOrdenadaRegistrosSiito) {

            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                 *ADICION ELEMENTOS
                 *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                 */

                SiiInventario siiInventario = new SiiInventario();

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * ESTABLECIMIENTO
                * Buscamos el establecimiento para ese registro de inventario
                * _/_/_/_/_/_/_/_/_/_/_/_/*/

                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);


                //Tipo de instrumento
                SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * INSTRUMENTO
                * Tipo intrumento
                * _/_/_/_/_/_/_/_/_/_/_/_/*/

                SiiInstrumento siiInstrumento = null;
                if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId() && movCargueInventarioWSVO.movCargueInvIucAd != null &&
                    !movCargueInventarioWSVO.movCargueInvIucAd.toString().equals("")) {
                    siiInstrumento = instrumentoDAO.consultarInstrumentosMETXNUC(movCargueInventarioWSVO.movCargueInvIucAd.toString());
                    if (siiInstrumento != null) {
                        Long marca = siiInstrumento.getSiiMet().getSiiMarca().getMarCodigo();
                        if (marca.equals(1L) || marca.equals(72L)) {
                            SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                            siiInstrumento.getSiiMet().setSiiMarca(siiMarca);
                            metDAO.actualizarSiiMet(siiInstrumento.getSiiMet());
                        }

                    }
                }

                if (siiInstrumento == null) {
                    siiInstrumento = new SiiInstrumento();
                    siiInstrumento.setSiiTipoInstrumento(siiTipoInstrumento);
                    siiInstrumento.setTapCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
                    siiInstrumento.setInsFechaRegistro(calendar.getTime());
                    siiInstrumento.setSiiOperador1(siiOperador);
                    siiInstrumento.setInsActivo("S");
                    siiInstrumento.setInsFechaRegistro(calendar.getTime());
                    siiInstrumento.setInsFechaModific(calendar.getTime());
                    /*
                * Si el tipo de instrumento que llega del ws es MET entonces creamos y registramos la MET
                */
                    SiiMet siiMet = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId()) {
                        String homologado = movCargueInventarioWSVO.movCargueInvIndInstHomo == 1 ? "S" : "N";
                        String online = movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 1 ? "S" : "N";
                        siiMet = new SiiMet();
                        siiMet.setMetHomologado(homologado);
                        siiMet.setMetOnline(online);
                        //siiMet.setMetMarcaAnterior(siitoMovCargueInventario.getMovCargueInvCodMarca());
                        //siiMet.setMetModelo();
                        siiMet.setMetNuid(movCargueInventarioWSVO.movCargueInvNuidAd);
                        //  siiMet.setMetOnline(siitoMovCargueInventario.get);
                        siiMet.setMetSerial(movCargueInventarioWSVO.movCargueInvSerialInstAd);
                        //Marca de la met
                        SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                        siiMet.setSiiMarca(siiMarca);

                        metDAO.insertarSiiMet(siiMet);
                        siiInstrumento.setSiiMet(siiMet);
                    }

                    /*
                * Si el tipo de instrumento que llega del ws es Terminal ACDV entonces creamos y registramos la Terminal ACDV
                */
                    SiiTerminalAcdv siiTerminalAcdv = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.ACDV.getId()) {
                        siiTerminalAcdv = new SiiTerminalAcdv();

                        siiTerminalAcdv.setTacSerial(movCargueInventarioWSVO.movCargueInvSerialInstAd);

                        //Marca de la terminal ACDV
                        SiiMarca siiMarca = marcaDao.buscarMarcaPorCodigo(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                        siiTerminalAcdv.setSiiMarca(siiMarca);

                        siiTerminalAcdv.setTacModelo(movCargueInventarioWSVO.movCargueInvCodModelo);
                        siiTerminalAcdv.setTacAnioFabric(Integer.valueOf(String.valueOf(movCargueInventarioWSVO.movCargueInvAnoFab)));

                        terminalAcdvDAO.insertarSiiLicenciaAcdv(siiTerminalAcdv);

                        siiInstrumento.setSiiTerminalAcdv(siiTerminalAcdv);
                    }

                    /*
                * Si el tipo de istrumento es una mesa de casino
                */
                    SiiMesaCasino siiMesaCasino = null;
                    if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                        siiMesaCasino = new SiiMesaCasino();
                        SiiJuegoMesa siiJuegoMesa = juegoMesaDao.buscarJuegoMesaPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipJuegos));
                        siiMesaCasino.setSiiJuegoMesa(siiJuegoMesa);
                        mesaCasinoDAO.insertarSiiMesaCasino(siiMesaCasino);
                        siiInstrumento.setSiiMesaCasino(siiMesaCasino);
                    }


                    //Persisto el instrumento
                    instrumentoDAO.insertarSiiInstrumento(siiInstrumento);
                }

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/
                * TIPO APUESTA
                * _/_/_/_/_/_/_/_/_/_/_/_/*/
                //SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
                SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta + "");


                /*
                * Lleno los datos del inventario
                */
                if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                    siiInventario.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
                }

                siiInventario.setSiiEstablecimiento(siiEstablecimiento);
                siiInventario.setSiiInstrumento(siiInstrumento);
                siiInventario.setSiiNovedad(siiNovedadAdicionElementos);
                siiInventario.setSiiTipoApuesta(siiTipoApuesta);
                siiInventario.setInvFechaFinLiq(calendarHoraCero.getTime());
                siiInventario.setInvFechaFinOfi(calendarHoraCero.getTime());
                siiInventario.setInvFechaIniLiq(calendarHoraCero.getTime());
                siiInventario.setInvFechaIniOfi(calendarHoraCero.getTime());
                siiInventario.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

                inventarioDAO.insertarSiiInventario(siiInventario);
            } else if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {

                /*_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                *ESTABLECIMIENTOS
                *_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
                */
                /*
                * Verificamos que el establecimiento que nos llega tenga todos los campos que son obligatorios y creamos une establecimiento
                */
                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();

                //Codigo interno
                if (movCargueInventarioWSVO.movCargueInvCodLocal == null || movCargueInventarioWSVO.movCargueInvCodLocal.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta el codigo interno del establecimiento.");
                } else {
                    siiEstablecimiento.setEstCodInterno(movCargueInventarioWSVO.movCargueInvCodLocal);
                }

                //Nombre
                if (movCargueInventarioWSVO.movCargueInvNomLocal == null || movCargueInventarioWSVO.movCargueInvNomLocal.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta el nombre del establecimiento.");
                } else {
                    siiEstablecimiento.setEstNombre(movCargueInventarioWSVO.movCargueInvNomLocal);
                }

                //Direccion
                if (movCargueInventarioWSVO.movCargueInvDirDesc == null || movCargueInventarioWSVO.movCargueInvDirDesc.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta la direccion del establecimiento.");
                } else {
                    siiEstablecimiento.setEstDireccion(movCargueInventarioWSVO.movCargueInvDirDesc);
                }

                //Ubicacion
                if (movCargueInventarioWSVO.movCargueInvCodMunLoc == null || movCargueInventarioWSVO.movCargueInvCodMunLoc.equals("")) {
                    throw new ExcepcionAplicacion("No fue posible completar la operacion, falta la ubicacion  del establecimiento.");
                } else {

                    //Consultamos la ubicacion


                    SiiUbicacion siiUbicacion = new SiiUbicacion();
                    siiUbicacion = ubicacionDAO.buscarUbicacionPorId(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                    siiEstablecimiento.setSiiUbicacion1(siiUbicacion);
                }

                siiEstablecimiento.setEstEstado("PA");
                siiEstablecimiento.setSiiOperador2(siiOperador);
                siiEstablecimiento.setSiiNovedad(siiNovedadCreacionLocal);
                establecimientoDAO.insertarSiiEstablecimiento(siiEstablecimiento);

            }


        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo encargado de cargar la prorroga de un contrato
     * @author David Tafur
     * @param solicitudAutorizacionWSVO
     * @param detalleFinancieroWSVO
     * @return
     * @throws ExcepcionDAO
     * @throws Exception
     */
    public String cargarProrrogaContrato(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, DetalleFinancieroWSVO detalleFinancieroWSVO,
                                         List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion {

        String retorno = "";
        SolicitudAutorizaVO solicitudVO = null;
        DetalleFinancVO detalleFinancVO = null;
        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        /*
        * Validaciones
        */
        if (detalleFinancieroWSVO == null) {
            throw new ExcepcionAplicacion("El detalle financiero no puede ser nulo");
        }
        if (solicitudAutorizacionWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud no puede ser nula");
        }

        if (solicitudAutorizacionWSVO.tiempoContratoMeses < 1) {
            throw new ExcepcionAplicacion("Falta el tiempo de prórroga del contrato");
        }
        if (solicitudAutorizacionWSVO.valorContrato == null || solicitudAutorizacionWSVO.valorContrato.equals(new BigDecimal(0))) {
            throw new ExcepcionAplicacion("El valor del contrato no puede ser nulo o blanco");
        }
        if (solicitudAutorizacionWSVO.valorProrroga == null || solicitudAutorizacionWSVO.valorProrroga.equals(new BigDecimal(0))) {
            throw new ExcepcionAplicacion("Falta el valor de la prorroga");
        }

        if (solicitudAutorizacionWSVO.numeroSiito == null || solicitudAutorizacionWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("El número de la solicitud SIITO no puede ser nulo o blanco");
        } else {
            List<SiiSolicitudAutoriza> listaSol = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSolicitudSIITO(solicitudAutorizacionWSVO.numeroSiito);
            if (listaSol.size() > 0) {
                throw new ExcepcionDAO("Ya existe una solicitud con ese numero en SIICOL ");
            }
        }
        if (solicitudAutorizacionWSVO.codigoMovimiento == null) {
            throw new ExcepcionAplicacion("El codigo de movimiento solicitud no puede ser nulo");
        }
        if (solicitudAutorizacionWSVO.tipoSolicitud < 0) {
            throw new ExcepcionAplicacion("Falta el tipo de solicitud");
        }
        if (solicitudAutorizacionWSVO.fecha == null) {
            throw new ExcepcionAplicacion("Falta la fecha de la solicitud");
        }
        if (solicitudAutorizacionWSVO.radicado == null || solicitudAutorizacionWSVO.radicado.equals("")) {
            throw new ExcepcionAplicacion("El numero de radicado no puede ser nulo o blanco");
        }
        if (solicitudAutorizacionWSVO.nit == null || solicitudAutorizacionWSVO.nit.equals("")) {
            throw new ExcepcionAplicacion("El nit no puede ser nulo o blanco");
        }
        if (solicitudAutorizacionWSVO.numeroContrato == null || solicitudAutorizacionWSVO.numeroContrato.equals("")) {
            throw new ExcepcionAplicacion("El numero de contrato no puede ser nulo o blanco");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
            }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        /*
         * Convertimos a VO
         */
        solicitudVO = conversionWSVoEntidad.convertir(solicitudAutorizacionWSVO);
        detalleFinancVO = conversionWSVoEntidad.convertir(detalleFinancieroWSVO);

        /*
         * Convertimos a Entidad
         */
        SiiSolicitudAutoriza siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudVO);
        SiiDetalleFinanc siiDetalleFinanc = conversionVoEntidad.convertir(detalleFinancVO);


        /*
        * Buscamos el operador
        */

        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);


        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        //Gestion Documental
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
        siiExpedienteDocumento.setEdoFecha(calendar.getTime());
        siiExpedienteDocumento = expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);
        //Radicado
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            //Creamos el expediente radicado y lo asociamos con el expediente
            SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
            siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
            siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
            siiExpedienteRadicado.setExrFecha(new Date());
            siiExpedienteRadicado = expedienteRadicadoDAO.insertarExpedienteRadicado(siiExpedienteRadicado);
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {
                for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {
                    SiiDocumentoRadicado siiDocumentoRadicado = new SiiDocumentoRadicado();
                    siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                    siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);

                    //Tipo radicado
                    SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                    siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                    /*
                     * Si el documento radicado tiene un numero de identificacion asociado entonces vamos a buscar esa persona
                     * en la base de datos de siicol para poder hacer la asociacion con el documento radicado al momento de registrarlo.
                     */
                    if (radicadoWSVO.perNumIdentificacion != null && !radicadoWSVO.perNumIdentificacion.equals("")) {
                        SiiPersona siiPersonaRadicado =
                            personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), radicadoWSVO.perNumIdentificacion);
                        if (siiPersonaRadicado == null) {
                            throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " + radicadoWSVO.perNumIdentificacion);
                        }
                        siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);
                    }

                    documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                }
            }
        }


        /*_/_/_/_/_/_/_/_/_/_/_/_/_/
        * SOLICITUD AUTORIZACION
        * _/_/_/_/_/_/_/_/_/_/_/_/*/

        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        SiiTipoSolicAutoriza siiTipoSolicAutoriza = tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(EnumTipoSolicitudAutoriza.PRORROGA_CONTRATO.getId());
        siiSolicitudAutoriza.setSiiTipoSolicAutoriza(siiTipoSolicAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

        SiiSolicitudAutoriza resultadoSiiSolicitudAutoriza = solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);

        //Usuario
        List<SiiUsuario> siiUsuarios = null;
        SiiUsuario siiUsuarioSiito = new SiiUsuario();
        siiUsuarioSiito.setUsuNombreUsuario(solicitudAutorizacionWSVO.UsuarioColjuegos.toUpperCase());
        siiUsuarios = usuarioDAO.buscarUsuarioPorNombre(siiUsuarioSiito);
        if (siiUsuarios != null && !siiUsuarios.isEmpty()) {
            siiSolicitudAutoriza.setSiiUsuario(siiUsuarios.get(0));
        }

        //Se inserta el detalle financiero
        siiDetalleFinanc.setSiiSolicitudAutoriza(resultadoSiiSolicitudAutoriza);
        siiDetalleFinanc.setSiiPersona2(siiOperadorPersona);
        detalleFinancDAO.insertarSiiDetalleFinanc(siiDetalleFinanc);


        /*_/_/_/_/_/_/_/_/_/_/_/_/_/
        * NOVEDAD
        * _/_/_/_/_/_/_/_/_/_/_/_/*/

        SiiNovedad siiNovedad = new SiiNovedad();
        //Tipo de novedad
        // SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(solicitudAutorizacionWSVO.tipoNovedad);
        // siiNovedad.setSiiTipoNovedad(siiTipoNovedad);

        //Seteo la solicitud al cual corresponde
        siiNovedad.setSiiSolicitudAutoriza(siiSolicitudAutoriza);

        //Seteo la fecha
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizacionWSVO.numeroContrato, siiOperador.getOpeCodigo());

        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato registrado por el numero de contrato, por favor verifique.");
        }

        siiNovedad.setSiiContrato(siiContrato);
        SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(EnumTipoNovedad.PRORROGA_CONTRATO.getId());
        siiNovedad.setSiiTipoNovedad(siiTipoNovedad);
        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);


        /*
        * Buscamos todos los registro de inventario asociados a ese contrato
        */
        List<SiiInventario> listaInventarioContrato = new ArrayList<SiiInventario>();
        listaInventarioContrato = inventarioDAO.buscarInventarioPorNumContrato(solicitudAutorizacionWSVO.numeroContrato);

        /*
        *Por cada elemento de juego asociado al contrato que se va a prorrogar (Dato Contrato en la Solicitud)
        * inserta un registro con la misma información, reemplazando los siguientes datos:
        * Fi  Liq = 0H Fecha actual
        * Ff Liq = 0H Fecha actual
        * Fi Of = 0H Fecha actual
        * Ff Of = 0H Fecha actual
        * Estado = PA (Pendiente de Activar)

        */
        for (SiiInventario siiInventario : listaInventarioContrato) {


            SiiInventario siiNuevoInventario = new SiiInventario();
            siiNuevoInventario.setSiiEstablecimiento(siiInventario.getSiiEstablecimiento());
            siiNuevoInventario.setSiiInstrumento(siiInventario.getSiiInstrumento());
            siiNuevoInventario.setSiiNovedad(siiNovedad);
            siiNuevoInventario.setSiiTipoApuesta(siiInventario.getSiiTipoApuesta());
            siiNuevoInventario.setInvFechaFinLiq(calendarHoraCero.getTime());
            siiNuevoInventario.setInvFechaFinOfi(calendarHoraCero.getTime());
            siiNuevoInventario.setInvFechaIniLiq(calendarHoraCero.getTime());
            siiNuevoInventario.setInvFechaIniOfi(calendarHoraCero.getTime());
            siiNuevoInventario.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

            inventarioDAO.insertarSiiInventario(siiInventario);


        }


        retorno = "1 " + solicitudAutorizacionWSVO.codigoMovimiento.toString() + " Proceso Exitoso";
        return retorno;
    }


    public List<UbicacionWSVO> obtenerDepartamentos() throws ExcepcionDAO {
        return solicitudAutorizaDAO.obtenerDepartamentos();
    }

    /**
     *Metodo encargado de desistir la solicitud de autorizacion que se ha ingresado anteriormente
     * @Author David Tafur
     * @param solicitudAutorizacionWSVO
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public String desistirSolicitud(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion {
        String resultado = "";
        SolicitudAutorizaVO solicitudVo = null;
        Calendar calendar = Calendar.getInstance();

        // Se realizan las transformaciones
        if (solicitudAutorizacionWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud no puede ser nula");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null && !expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.isEmpty()) {
                hayDocumento = true;
                break;
            }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }
        /*
        * Buscamos la solicitud por el numero de solicitud
        */
        List<SiiSolicitudAutoriza> listaSolicitudes = new ArrayList<SiiSolicitudAutoriza>();
        listaSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSolicitudSIITO(solicitudAutorizacionWSVO.numeroSiitoSolicitudDesitir);
        SiiSolicitudAutoriza siiSolicitudAutoriza = null;
        if (listaSolicitudes != null && !listaSolicitudes.isEmpty()) {
            siiSolicitudAutoriza = listaSolicitudes.get(0);
        }

        //Estado desistido
        SiiEstadoSolicAutoriz siiEstadoSolicAutorizDesis = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.DESISTIDO.getId());

        //SiiSolicitudAutoriza siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizacionWSVO.numeroSiitoSolicitudDesitir);
        if (siiSolicitudAutoriza == null || siiSolicitudAutoriza.getSauCodigo() == null) {
            // Se inserta la solicitud
            solicitudVo = conversionWSVoEntidad.convertir(solicitudAutorizacionWSVO);
            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudVo);
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutorizDesis);
            SiiTipoSolicAutoriza siiTipoSolicAutoriza = tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(solicitudAutorizacionWSVO.tipoSolicitud);
            siiSolicitudAutoriza.setSiiTipoSolicAutoriza(siiTipoSolicAutoriza);
            //siiSolicitudAutoriza.setSiiSolicitudAutDesistida(siiSolicitudAntigua);
            //Gestion Documental

            SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
            siiExpedienteDocumento.setEdoFecha(calendar.getTime());
            siiExpedienteDocumento = expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);
            //Radicado
            for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
                //Creamos el expediente radicado y lo asociamos con el expediente
                SiiExpedienteRadicado siiExpedienteRadicado = new SiiExpedienteRadicado();
                siiExpedienteRadicado.setExrCodigo(expedienteRadicadoWsVo.codigoExpedienteRadicado);
                siiExpedienteRadicado.setSiiExpedienteDocum(siiExpedienteDocumento);
                siiExpedienteRadicado.setExrFecha(new Date());
                siiExpedienteRadicado = expedienteRadicadoDAO.insertarExpedienteRadicado(siiExpedienteRadicado);
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null) {


                    for (DocumentoRadicadoWSVO radicadoWSVO : expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo) {
                        SiiDocumentoRadicado siiDocumentoRadicado = new SiiDocumentoRadicado();
                        siiDocumentoRadicado.setDraFecha(radicadoWSVO.draFecha);
                        siiDocumentoRadicado.setDraCodigo(radicadoWSVO.draCodigo);
                        //Tipo radicado
                        SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                        siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                        // Si el documento radicado tiene un numero de identificacion asociado entonces vamos a buscar esa persona
                        // en la base de datos de siicol para poder hacer la asociacion con el documento radicado al momento de registrarlo.

                        if (radicadoWSVO.perNumIdentificacion != null && !radicadoWSVO.perNumIdentificacion.equals("")) {
                            SiiPersona siiPersonaRadicado = new SiiPersona();
                            siiPersonaRadicado =
                                personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), radicadoWSVO.perNumIdentificacion);

                            if (siiPersonaRadicado == null) {
                                throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " + radicadoWSVO.perNumIdentificacion);
                            }

                            siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);
                        }

                        documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);

                    }
                }
            }
            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
            resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";
        } else {
            if (!estaEstadoEnResoluciones(siiSolicitudAutoriza.getSiiResolucionAutorizList(), EnumEstadoResolucAut.NOTIFICADO_Y_EN_TERMINOS.getId()) &&
                !estaEstadoEnResoluciones(siiSolicitudAutoriza.getSiiResolucionAutorizList(), EnumEstadoResolucAut.EN_FIRME.getId())) {
                siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutorizDesis);
                solicitudAutorizaDAO.actualizarSiiSolicitudAutoriza(siiSolicitudAutoriza);
                //SiiSolicitudAutoriza siiSolicitudAntigua = new SiiSolicitudAutoriza();
                //siiSolicitudAntigua = listaSolicitudes.get(0);
                resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizacionWSVO.codigoMovimiento + " Proceso Exitoso";
            } else {
                resultado = "Resolución de autorización ya fue notificada. No es posible desistir la solicitud";
            }
        }
        return resultado;
    }

    public boolean estaEstadoEnResoluciones(List<SiiResolucionAutoriz> lista, Long idEstado) {
        for (SiiResolucionAutoriz sra : lista) {
            if (sra.getSiiEstadoResolucAut().getEraCodigo().equals(idEstado)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @author Giovanni
     * @param transladoAutomaticoWSVo
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public String transladoAutomatico(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calDiaAnterior = Calendar.getInstance();
        calDiaAnterior.add(Calendar.DAY_OF_YEAR, -1);
        calDiaAnterior.set(Calendar.HOUR, 23);
        calDiaAnterior.set(Calendar.MINUTE, 59);
        calDiaAnterior.set(Calendar.SECOND, 59);

        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        String resultado = "";

        /*
        * Buscamos el operador
        */

        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizaWSVO.nit);

        if (siiOperadorPersona.getPerCodigo() == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un operador por ese numero de nit: " + solicitudAutorizaWSVO.nit);
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());


        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();


        //Convertimos a VO

        solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

        //Convertimos a entidad
        siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);


        //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
        siiExpedienteDocumento.setEdoFecha(Calendar.getInstance().getTime());
        siiExpedienteDocumento = expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);

        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.PROCESO_FINALIZADO_TRASLADO_AUTOMATICO.getId());
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        //Persistimos en la base de datos la solicitud de autorizacion
        solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);


        /*_/_/_/_/_/_/_/_/_/_/_/_/_/
        * NOVEDAD
        * _/_/_/_/_/_/_/_/_/_/_/_/*/

        SiiNovedad siiNovedad = new SiiNovedad();
        //Tipo de novedad
        SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(movCargueInventarioWSVOs.get(0).movCargueInvTipNov);
        siiNovedad.setSiiTipoNovedad(siiTipoNovedad);

        //Seteo la solicitud al cual corresponde
        siiNovedad.setSiiSolicitudAutoriza(siiSolicitudAutoriza);

        //Seteo la fecha
        siiNovedad.setNovFecha(Calendar.getInstance().getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);


        List<SiiInventario> siiInventarioMesasContrato = new ArrayList();
        siiInventarioMesasContrato = inventarioDAO.buscarInventarioMesaPorContrato(siiContrato.getConCodigo());
        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder
        * a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            //Tipo de instrumento
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));

            SiiEstablecimiento siiEstablecimientoDestino = new SiiEstablecimiento();
            siiEstablecimientoDestino = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocalDest);
            if (siiEstablecimientoDestino == null) {
                throw new ExcepcionAplicacion("-1 No existe el local destino");
            }
            /*
            * Si el tipo de elemento es met entonces buscamos el ultimo registro
            * insertado del elemento de juego en el inventario y lo colocamos en estado inactivo
            */
            //MET
            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId()) {

                /*
                * Si el registro del inventario de la tabla intermedia trae el codigo del uid que es unico entonces podemos
                * consultarlo por este criterio, de lo contrario debemos consultar por el serial el operador y la marca
                */
                SiiInventario siiInventarioPorTrasladar = new SiiInventario();
                if (movCargueInventarioWSVO.movCargueInvIucAd != null && !movCargueInventarioWSVO.movCargueInvIucAd.equals("")) {

                    siiInventarioPorTrasladar =
                        inventarioDAO.buscarInventarioXUIDYContrato(movCargueInventarioWSVO.movCargueInvIucAd.toString(), movCargueInventarioWSVO.movCargueInvCont,
                                                                    movCargueInventarioWSVO.movCargueInvCodLocal);
                } else {
                    siiInventarioPorTrasladar =
                        inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                      movCargueInventarioWSVO.movCargueInvCodMarca, movCargueInventarioWSVO.movCargueInvCont,
                                                                                      movCargueInventarioWSVO.movCargueInvCodLocal);
                }

                /*
                 * Una vez tenemos el inventario entonces procedemos a cambiarle el estado a inactivo
                 */
                if (siiInventarioPorTrasladar != null) { 
                    siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                    inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);


                    /*
                     * Creamos una replica del registro y remplazamos las fechas y el estado que seria pendiente de retiro
                     */

                    SiiInventario siiInvNuevoRegistro = new SiiInventario();
                    siiInvNuevoRegistro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    siiInvNuevoRegistro.setInvFechaFinLiq(calDiaAnterior.getTime());
                    siiInvNuevoRegistro.setSiiNovedad(siiNovedad);
                    siiInvNuevoRegistro.setInvEstado(EnumEstadoInventario.RETIRADO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvNuevoRegistro);

                    /*
                     * Registramos otro inventario con el codigo del local de destino y el estado pendiente de activar
                    */


                    SiiInventario siiInvNuevoPendActivar = new SiiInventario();
                    siiInvNuevoPendActivar = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    siiInvNuevoPendActivar.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                    siiInvNuevoPendActivar.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);
                    siiInvNuevoPendActivar.setInvFechaFinLiq(siiContrato.getConFechaFinDefin() != null ? siiContrato.getConFechaFinDefin() : siiContrato.getConFechaFin());
                    siiInvNuevoPendActivar.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvNuevoPendActivar.setSiiNovedad(siiNovedad);
                    /*
                     * Nuevo establecimiento donde se va a trasladar (Ya debe existir)
                     */
                    siiInvNuevoPendActivar.setSiiEstablecimiento(siiEstablecimientoDestino);
                    siiInvNuevoPendActivar.setInvEstado(EnumEstadoInventario.ACTIVO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvNuevoPendActivar);
                } else {
                    resultado = "-1 No se encuentra la maquina con serial " + movCargueInventarioWSVO.movCargueInvCodMarca + " en el inventario con los criterios mencionados.";
                    throw new ExcepcionAplicacion("-1 No se encuentra la maquina con serial " + movCargueInventarioWSVO.movCargueInvCodMarca + " en el inventario con los criterios mencionados.");
                }


                //ACDV
            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.ACDV.getId()) {
                //Esperando especificaciones FIXME ALAN.

























            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId() || siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.OTRO.getId()) {

                /*
                * Si el registro del inventario de la tabla intermedia trae el codigo del uid que es unico entonces podemos
                * consultarlo por este criterio, de lo contrario debemos consultar por el serial el operador y la marca
                */
                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                for (SiiInventario siiInventarioPorTrasladar : siiInventarioMesasContrato) {
                    if (siiInventarioPorTrasladar.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipInst) &&
                        siiInventarioPorTrasladar.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc) &&
                        siiInventarioPorTrasladar.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "") &&
                        siiInventarioPorTrasladar.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal) &&
                        siiInventarioPorTrasladar.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {


                        siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                        inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);


                        //Creamos una replica del registro y remplazamos las fechas y el estado que seria pendiente de retiro

                        SiiInventario siiInvNuevoRegistro = new SiiInventario();
                        siiInvNuevoRegistro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                        siiInvNuevoRegistro.setInvFechaFinLiq(calDiaAnterior.getTime());
                        siiInvNuevoRegistro.setSiiNovedad(siiNovedad);
                        siiInvNuevoRegistro.setInvEstado(EnumEstadoInventario.RETIRADO.getId());
                        inventarioDAO.insertarSiiInventario(siiInvNuevoRegistro);


                        //* Registramos otro inventario con el codigo del local de destino y el estado pendiente de activar

                        SiiInventario siiInvNuevoPendActivar = new SiiInventario();
                        siiInvNuevoPendActivar = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                        siiInvNuevoPendActivar.setInvFechaFinLiq(siiContrato.getConFechaFinDefin() != null ? siiContrato.getConFechaFinDefin() : siiContrato.getConFechaFin());
                        siiInvNuevoPendActivar.setInvFechaIniLiq(calendarHoraCero.getTime());
                        siiInvNuevoPendActivar.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                        siiInvNuevoPendActivar.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);

                        //Nuevo establecimiento donde se va a trasladar (Ya debe existir)

                        siiInvNuevoPendActivar.setSiiEstablecimiento(siiEstablecimientoDestino);
                        siiInvNuevoPendActivar.setInvEstado(EnumEstadoInventario.ACTIVO.getId());

                        inventarioDAO.insertarSiiInventario(siiInvNuevoPendActivar);
                        siiInventarioMesasContrato.remove(siiInventarioPorTrasladar);

                        break;
                    }
                }
                //BINGO
            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {

                /*
                * Para traslado de sillas
                */
                SiiInventario siiInventarioPorTrasladar = new SiiInventario();

                //siiInventarioPorTrasladar = inventarioDAO.buscarUltimoInstrumentoPorTipoElementoYLocal(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst),movCargueInventarioWSVO.movCargueInvCodLocal);
                siiInventarioPorTrasladar =
                    inventarioDAO.buscarUltimoInstrumentoPorTipoElementoApuestaYLocalPorOperador(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst),
                                                                                                 movCargueInventarioWSVO.movCargueInvCodApuesta, movCargueInventarioWSVO.movCargueInvCodLocal,
                                                                                                 siiContrato.getConCodigo());

                //Actualizamos el registro
                siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);

                //Copiamos el registro y insertamos las nuevas fechas y el nuevo estado

                SiiInventario siiInventarioRetiro = new SiiInventario();
                siiInventarioRetiro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                siiInventarioRetiro.setInvFechaFinLiq(calDiaAnterior.getTime());
                siiInventarioRetiro.setSiiNovedad(siiNovedad);
                siiInventarioRetiro.setInvEstado(EnumEstadoInventario.RETIRADO.getId());

                inventarioDAO.insertarSiiInventario(siiInventarioRetiro);

                /*
                 * Verificamos si el numero de sillas del
                 * ultimo registro en el inventario es mayor al numero de siullas en la solicitud
                 */
                Long cantidadSillasFinal = siiInventarioPorTrasladar.getInvSillas() - movCargueInventarioWSVO.movCargueInvCantSillas;
                if (cantidadSillasFinal.intValue() > 0) {

                    SiiInventario siiInvCantSillasMayor = new SiiInventario();
                    siiInvCantSillasMayor = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);


                    //Cantidad de sillas

                    siiInvCantSillasMayor.setInvSillas(cantidadSillasFinal.intValue());
                    siiInvCantSillasMayor.setInvFechaFinLiq(siiContrato.getConFechaFinDefin() != null ? siiContrato.getConFechaFinDefin() : siiContrato.getConFechaFin());
                    siiInvCantSillasMayor.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvCantSillasMayor.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                    siiInvCantSillasMayor.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);
                    siiInvCantSillasMayor.setSiiNovedad(siiNovedad);
                    siiInvCantSillasMayor.setInvEstado(EnumEstadoInventario.ACTIVO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvCantSillasMayor);

                }

                /*
                *Consultamos el ultimo registro de inventario para el local de detino
                */
                SiiInventario siiInventarioLocalDest = new SiiInventario();
                siiInventarioLocalDest =
                    inventarioDAO.buscarUltimoInstrumentoPorTipoElementoApuestaYLocalPorOperador(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst),
                                                                                                 movCargueInventarioWSVO.movCargueInvCodApuesta, movCargueInventarioWSVO.movCargueInvCodLocalDest,
                                                                                                 siiContrato.getConCodigo());

                if (siiInventarioLocalDest != null && siiInventarioLocalDest.getInvCodigo() > 0) {

                    siiInventarioLocalDest.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                    inventarioDAO.actualizarSiiInventario(siiInventarioLocalDest);


                    // Copiamos el registro para cambiarle las fecha y el estado

                    SiiInventario siiInvRetiroDestino = new SiiInventario();
                    siiInvRetiroDestino = copiarInventarioObjetoNuevo(siiInventarioLocalDest);
                    siiInvRetiroDestino.setInvFechaFinLiq(calDiaAnterior.getTime());
                    siiInvRetiroDestino.setSiiNovedad(siiNovedad);
                    siiInvRetiroDestino.setInvEstado(EnumEstadoInventario.RETIRADO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvRetiroDestino);

                    /*
                    * Sumamos la cantidad de sillas
                    */

                    SiiInventario siiInvSumaSillas = new SiiInventario();
                    siiInvSumaSillas = copiarInventarioObjetoNuevo(siiInventarioLocalDest);

                    //Cantidad de sillas
                    Long cantidadSillasFinalDestino = siiInventarioLocalDest.getInvSillas() + movCargueInventarioWSVO.movCargueInvCantSillas;

                    siiInvSumaSillas.setInvSillas(cantidadSillasFinalDestino.intValue());
                    siiInvSumaSillas.setInvFechaFinLiq(siiContrato.getConFechaFinDefin() != null ? siiContrato.getConFechaFinDefin() : siiContrato.getConFechaFin());
                    siiInvSumaSillas.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                    siiInvSumaSillas.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);
                    siiInvSumaSillas.setSiiNovedad(siiNovedad);
                    siiInvSumaSillas.setInvEstado(EnumEstadoInventario.ACTIVO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvSumaSillas);
                } else {
                    SiiInventario siiInvSumaSillas = new SiiInventario();
                    siiInvSumaSillas = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    siiInvSumaSillas.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
                    siiInvSumaSillas.setInvFechaFinLiq(siiContrato.getConFechaFinDefin() != null ? siiContrato.getConFechaFinDefin() : siiContrato.getConFechaFin());
                    siiInvSumaSillas.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                    siiInvSumaSillas.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);
                    siiInvSumaSillas.setInvEstado(EnumEstadoInventario.ACTIVO.getId());
                    siiInvSumaSillas.setSiiEstablecimiento(siiEstablecimientoDestino);
                    siiInvSumaSillas.setSiiNovedad(siiNovedad);
                    inventarioDAO.insertarSiiInventario(siiInvSumaSillas);
                }
            }

        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo especializado, encargado de copiar un inventario de tipo entidad a otro, haciendo la copia
     * campo a campo para quitarle las referencias
     * @Author David Tafur
     * @param siiInventarioAnterior
     * @return
     */
    private SiiInventario copiarInventarioObjetoNuevo(SiiInventario siiInventarioAnterior) throws ExcepcionDAO {
        SiiInventario siiInventarioNuevo = new SiiInventario();
        if (siiInventarioAnterior.getInvCodigo() != null && siiInventarioAnterior.getInvCodigo() > 0) {
            siiInventarioNuevo.setInvCodigo(null);
        }
        siiInventarioNuevo.setInvEstado(siiInventarioAnterior.getInvEstado());
        siiInventarioNuevo.setInvFechaFinLiq(siiInventarioAnterior.getInvFechaFinLiq());
        siiInventarioNuevo.setInvFechaFinOfi(siiInventarioAnterior.getInvFechaFinOfi());
        siiInventarioNuevo.setInvFechaIniLiq(siiInventarioAnterior.getInvFechaIniLiq());
        siiInventarioNuevo.setInvFechaIniOfi(siiInventarioAnterior.getInvFechaIniOfi());
        siiInventarioNuevo.setInvSillas(siiInventarioAnterior.getInvSillas());


        if (siiInventarioAnterior.getSiiEstablecimiento() != null && siiInventarioAnterior.getSiiEstablecimiento().getEstCodigo() > 0) {
            SiiEstablecimiento siiEstablecimiento = establecimientoDAO.buscarEstablecimientoPorId(siiInventarioAnterior.getSiiEstablecimiento().getEstCodigo());
            siiInventarioNuevo.setSiiEstablecimiento(siiEstablecimiento);
        }

        if (siiInventarioAnterior.getSiiTipoApuesta() != null && siiInventarioAnterior.getSiiTipoApuesta().getTapCodigoApuesta().length() > 0) {
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(siiInventarioAnterior.getSiiTipoApuesta().getTapCodigo());
            siiInventarioNuevo.setSiiTipoApuesta(siiTipoApuesta);
        }

        if (siiInventarioAnterior.getSiiInstrumento() != null && siiInventarioAnterior.getSiiInstrumento().getInsCodigo() > 0) {
            SiiInstrumento siiInstrumento = instrumentoDAO.buscarPorCodigoInstrumento(siiInventarioAnterior.getSiiInstrumento().getInsCodigo());
            siiInventarioNuevo.setSiiInstrumento(siiInstrumento);
        }

        if (siiInventarioAnterior.getSiiNovedad() != null && siiInventarioAnterior.getSiiNovedad().getNovCodigo() > 0) {
            SiiNovedad siiNovedad = novedadDAO.buscarNovedadPorId(siiInventarioAnterior.getSiiNovedad().getNovCodigo());
            siiInventarioNuevo.setSiiNovedad(siiNovedad);
        }


        return siiInventarioNuevo;
    }


    /**
     *Metodo encargado de desistir la solicitud de autorizacion que se ha ingresado anteriormente
     * @Author David Tafur
     * @param solicitudAutorizacionWSVO
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public String marcarMetOnline(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> listaInventarioSiitoWSVO) throws ExcepcionDAO, ExcepcionAplicacion, Exception {
        String retorno = "";
        SolicitudAutorizaVO solicitudVO = null;
        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        /*
        * Validaciones
        */

        if (solicitudAutorizacionWSVO == null) {
            throw new Exception("La solicitud no puede ser nula");
        }

        if (solicitudAutorizacionWSVO.numeroSiito == null || solicitudAutorizacionWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("1 El número de la solicitud SIITO no puede ser nulo o blanco");
        } else {
            List<SiiSolicitudAutoriza> listaSol = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSolicitudSIITO(solicitudAutorizacionWSVO.numeroSiito);
            if (listaSol.size() > 0) {
                throw new ExcepcionDAO("Ya existe una solicitud con ese numero en SIICOL ");
            }
        }

        if (solicitudAutorizacionWSVO.codigoMovimiento == null) {
            throw new ExcepcionAplicacion("El codigo de movimiento solicitud no puede ser nulo");
        }
        if (solicitudAutorizacionWSVO.tipoSolicitud < 0) {
            throw new ExcepcionAplicacion("Falta el tipo de solicitud");
        }

        if (solicitudAutorizacionWSVO.nit == null || solicitudAutorizacionWSVO.nit.equals("")) {
            throw new ExcepcionAplicacion("El nit no puede ser nulo o blanco");
        }
        if (solicitudAutorizacionWSVO.numeroContrato == null || solicitudAutorizacionWSVO.numeroContrato.equals("")) {
            throw new ExcepcionAplicacion("El numero de contrato no puede ser nulo o blanco");
        }
        /*if (listaDocumentoRadicadosWSVO == null || listaDocumentoRadicadosWSVO.size() < 1) {
            throw new Exception("La solicitud de autorizacion debe tener almenos 1 radicado.");
        }*/

        /*
         * Convertimos a VO
         */
        solicitudVO = conversionWSVoEntidad.convertir(solicitudAutorizacionWSVO);

        /*
         * Convertimos a Entidad
         */
        SiiSolicitudAutoriza siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudVO);

        /*
        * Buscamos el operador
        */

        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);
        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());


        //Gestion Documental
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        siiExpedienteDocumento.setEdoCodigo(solicitudAutorizacionWSVO.numeroSiito);
        siiExpedienteDocumento.setEdoFecha(calendar.getTime());
        expedienteDocumDAO.insertarExpedienteDocum(siiExpedienteDocumento);

        /*_/_/_/_/_/_/_/_/_/_/_/_/_/
        * SOLICITUD AUTORIZACION
        * _/_/_/_/_/_/_/_/_/_/_/_/*/

        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
        siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        SiiTipoSolicAutoriza siiTipoSolicAutoriza = tipoSolicAutorizaDao.buscarTipoSolicAutorizaPorCodigo(EnumTipoSolicitudAutoriza.CAMBIO_ESTADO_METL.getId());
        siiSolicitudAutoriza.setSiiTipoSolicAutoriza(siiTipoSolicAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);
        siiSolicitudAutoriza.setSauFecha(calendar.getTime());
        solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);


        /*_/_/_/_/_/_/_/_/_/_/_/_/_/
        * NOVEDAD
        * _/_/_/_/_/_/_/_/_/_/_/_/*/

        SiiNovedad siiNovedad = new SiiNovedad();
        //Tipo de novedad
        SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorCodigo(listaInventarioSiitoWSVO.get(0).movCargueInvTipNov);
        siiNovedad.setSiiTipoNovedad(siiTipoNovedad);

        //Seteo la solicitud al cual corresponde
        siiNovedad.setSiiSolicitudAutoriza(siiSolicitudAutoriza);

        //Seteo la fecha
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizacionWSVO.numeroContrato, siiOperador.getOpeCodigo());

        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato registrado por el numero de contrato, por favor verifique.");
        }

        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);

        /*
        * Una vez que hacemos el registro de la solicitud y de la novedad entonces procedemos a marcar la met si está
        * online o no está online
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : listaInventarioSiitoWSVO) {
            SiiMet met = null;

            if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                met =
                    metDAO.buscarMetXPorNucYContrato(movCargueInventarioWSVO.movCargueInvIucAd, movCargueInventarioWSVO.movCargueInvCodLocal, solicitudAutorizacionWSVO.nit,
                                                     movCargueInventarioWSVO.movCargueInvCont);


            } else {

                met =
                    metDAO.buscarMetXMarcaYSerialYLocalYContrato(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodLocal,
                                                                 movCargueInventarioWSVO.movCargueInvCodMarca, solicitudAutorizacionWSVO.nit, movCargueInventarioWSVO.movCargueInvCont);

            }

            if (met != null) {

                String online = String.valueOf(movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 1 ? 'S' : 'N');
                met.setMetOnline(online);
                metDAO.actualizarSiiMet(met);

            } else {
                return "1 No se encontro registrada ninguna met para ese operador con esa informacion.";
            }

        }


        retorno = "1 " + solicitudAutorizacionWSVO.codigoMovimiento.toString() + " Proceso Exitoso";
        return retorno;
    }

    /**
     *
     * Metodo validacion contrato nuevo
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesContratoNuevo(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO {

        String respuesta = null;
        int contErrores = 0;
        //contErrores = validarInventarioXOperador(movCargueInventarioWSVOs, 10L);
        boolean entroNovedad = false;

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (siiOperador != null) {
            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

                /*
                 * ------------------------------------------
                 * 1.1 - TIPO DE NOVEDAD 50 CREACION DE LOCAL
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                    entroNovedad = true;

                    /*
                     * VALIDACION: El codigo el local no debe existir en el inventario del operador-contrato. Si no desplegar el
                     * Mensaje: 1050001 - Codigo del local ya existe.
                     */
                    SiiEstablecimiento siiEstablecimiento = null;
                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                    if (siiEstablecimiento != null) {
                        contErrores++;
                        // Relacion con el cargue inventario estado cargue
                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050001L);
                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                    }

                    /*
                     * VALIDACION: El codigo del municipio DANE debe existir en la tabla correspondiente. Si no desplegar el
                     * Mensaje: 1050002 - Codigo DANE municipio no existe.
                     */
                    SiiUbicacion siiUbicacion = new SiiUbicacion();
                    siiUbicacion = ubicacionDAO.buscarUbicacionPorId(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                    if (siiUbicacion == null) {
                        contErrores++;
                        /*
                         * Relacion con el cargue inventario estado cargue
                         */
                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050002L);
                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                    }
                }

                /*
                 * ------------------------------------------
                 * 1.2 - TIPO DE NOVEDAD 10 ADICION ELEMENTOS
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                    entroNovedad = true;

                    //Tipo de elemento mets
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        //Para el tipo de elemento 1-MET, SI el NUC viene diligenciado, deberá buscarlo en el inventario de Coljuegos,
                        //validar que NO se encuentre ACTIVO, Si no desplegar el Mensaje: 1010001- NUC se encuentra Activo”.
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");

                            if (siiInventario != null) {


                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                contErrores++;

                                if (!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {

                                    contErrores++;
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010004L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    //siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero()); no se complementa porque es de cara al operador.
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;

                                } else if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    //if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                    contErrores++;
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010005L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                }


                                String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                    if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(1010011L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    } else {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(1010002L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                    if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(1010012L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                }

                            } else {

                                siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), null);
                                if (siiInventario == null) {

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010010L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;

                                } else if (siiInventario != null) {
                                    String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                    long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                    if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                        if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010011L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        } else {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010002L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                        if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010012L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    }
                                }
                            }
                        } else {

                            //SiiInventario siiInventario = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                            List<Long> marcas = new ArrayList();
                            marcas.add(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                            List<SiiInventario> listSiiInventarioSMA = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas, "A");

                            //if (siiInventario != null) {
                            if (listSiiInventarioSMA != null && !listSiiInventarioSMA.isEmpty()) {

                                //SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                HashMap<Long, String> errores = new HashMap();
                                for (SiiInventario siiInventario : listSiiInventarioSMA) {
                                    if (!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                        if (!errores.containsKey(1010004L)) {
                                            errores.put(1010004L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(1010004L, errores.get(1010004L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        }
                                    } else {
                                        if (!errores.containsKey(1010005L)) {
                                            errores.put(1010005L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(1010005L, errores.get(1010005L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        }

                                    }
                                }

                                for (Long iderror : errores.keySet()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(iderror);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv.setComplemento(errores.get(iderror));
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                }

                            } else {


                                List<Long> marcas1_72 = new ArrayList();
                                marcas1_72.add(1L);
                                marcas1_72.add(72L);
                                List<SiiInventario> listaSiiInventarioSM1_72 = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas1_72, "A");
                                if (listaSiiInventarioSM1_72 != null && !listaSiiInventarioSM1_72.isEmpty()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(1010004L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>CONTRATO</th>");
                                    for (SiiInventario itemSiiInventario : listaSiiInventarioSM1_72) {
                                        complemento.append("<tr>");
                                        complemento.append("<td>");
                                        complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                        complemento.append("</td>");
                                        complemento.append("<td>");
                                        complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                        complemento.append("</td>");
                                        complemento.append("<td>");
                                        complemento.append(itemSiiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        complemento.append("</td>");
                                        complemento.append("</tr>");
                                    }

                                    complemento.append("</table></center><br/>");
                                    siitoMovCargInvEstCargInv2.setComplemento(complemento.toString());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                    contErrores++;
                                }

                                List<Long> marcasSMNULL = new ArrayList();
                                marcasSMNULL.add(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                                marcasSMNULL.add(1L);
                                marcasSMNULL.add(72L);
                                List<SiiInventario> listSiiInventarioSMNULL = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcasSMNULL, null);
                                if (!listSiiInventarioSMNULL.isEmpty()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(1010013L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
                                    List<String> smn = new ArrayList();
                                    for (SiiInventario itemSiiInventario : listSiiInventarioSMNULL) {
                                        if (!smn.contains(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                          itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                          itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid())) {
                                            smn.add(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                    itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                    itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                            complemento.append("<tr>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                            complemento.append("</td>");
                                            complemento.append("</tr>");
                                        }

                                    }
                                    complemento.append("</table></center><br/>");
                                    siitoMovCargInvEstCargInv2.setComplemento(complemento.toString());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                    contErrores++;
                                }


                            }


                        }


                        /*if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                            // verificamos en siicol la informacion

                            SiiInstrumento siiInstrumento = null;
                            siiInstrumento =
                                instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                  String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                            // Verificamos la informacion de serial y la marca para el registro
                            if (siiInstrumento != null) {
                                if (siiInstrumento.getSiiMet().getMetNuid() != movCargueInventarioWSVO.movCargueInvNuidAd) {
                                    contErrores++;


                                    // Relacion con el cargue inventario estado cargue

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010003L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        }*/

                        /*if (movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 2L) {
                            SiiInventario siiInventario = null;
                            if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                                siiInventario =
                                    inventarioDAO.buscarInventarioXUIDYContrato(movCargueInventarioWSVO.movCargueInvIucAd.toString(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                movCargueInventarioWSVO.movCargueInvCodLocal);
                            } else {
                                siiInventario =
                                    inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                  movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                                  movCargueInventarioWSVO.movCargueInvCodLocal);
                            }

                            if (siiInventario != null) {
                                if (!siiInventario.getInvPg().equals("S")) {
                                    contErrores++;


                                    // Relacion con el cargue inventario estado cargue
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010006L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        }*/


                        // VALIDACION: Validar que el codigo de apuesta reportado corresponda al tipo de elemento reportado, Si no desplegar
                        // el Mensaje: 1010007 - Codigo de apuesta no corresponde a ese tipo de elemento.

                        /*if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta <= 1 && movCargueInventarioWSVO.movCargueInvCodApuesta >= 3) {
                                contErrores++;


                                // Relacion con el cargue inventario estado cargue

                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010007L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }

                        }*/
                    }


                    //5-ACDV
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.ACDV.getId()) {

                        //NUC sin diligenciar
                        if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                            SiiInventario siiInventario =
                                inventarioDAO.buscarInventarioACDVPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                            if (siiInventario != null) {
                                contErrores++;

                                /*
                                 * Relacion con el cargue inventario estado cargue
                                 */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                /*
                                * VALIDACION: Si la 1-MET o (5-ACDV), se encuentra en un contrato activo y si el Nit y el contrato del operador
                                * de la base de datos es diferente al Nit y el contrato del operador que realiza la novedad debera desplegar el
                                * Mensaje: 1010004 - Elemento de juego autorizado en el inventario de otro contrato de concesion.
                                */
                                if (!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    contErrores++;

                                    /*
                                     * Relacion con el cargue inventario estado cargue
                                     */
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010004L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                } else {

                                    /*
                                     * VALIDACION: Si la 1-MET o (5-ACDV), se encuentra en un contrato activo y si el Nit y el contrato del operador
                                     * de la base de datos es IGUAL al Nit y el contrato que realiza la novedad y el establecimiento de la base de datos
                                     * es diferente al establecimiento de la novedad debera despelgar el Mensaje: 1010005 - Elemento de juego
                                     * actualmente autorizado en el establecimiento xxxx (xxxx: Establecimiento de la base de datos).
                                     */
                                    if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                        contErrores++;

                                        /*
                                         * Relacion con el cargue inventario estado cargue
                                         */
                                        siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010005L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    }
                                }
                            }
                        }
                    }


                    /*
                     * VALIDACION: Para tipo de elemento 2-Bingo validar que el codigo de apuesta reportado corresponda con la poblacion
                     * del municipio. Si no desplegar el Mensaje: 1010008 - Codigo de apuesta para bingo no corresponde a la poblacion.
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                        //SiiEnteTerritorial siiEnteTerritorial = new SiiEnteTerritorial();
                        //siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                        if (siiEnteTerritorial != null) {
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 6) {
                                //if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                   * Relacion con el cargue inventario estado cargue
                                   */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 7) {
                                //if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 8) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 9) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 10) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 11) {
                                if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                    contErrores++;


                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 12) {
                                if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                    contErrores++;


                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 13) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 14) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 15) {
                                //if (siiEnteTerritorial.getEtiPoblacion() <= 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            /*if (movCargueInventarioWSVO.movCargueInvCodApuesta == 22) {
                                if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                    contErrores++;


                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv =
                                        new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 23) {
                                if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                    contErrores++;

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv =
                                        new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }*/
                        } else {
                            contErrores++;

                            /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                            SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                            siitoEstadoCargueInventario = estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("El ente territorial no existe en el sistema para Bingo");

                            if (siitoEstadoCargueInventario == null) {
                                siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                siitoEstadoCargueInventario.setEstCargInvDesc("El ente territorial no existe en el sistema para Bingo");
                                siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                            }

                            /*
                            * Relacion con el cargue inventario estado cargue
                            */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }

                    /*
                     * VALIDACION: en espera con numero = 1010014L
                     */
                    SiiEstablecimiento siiEstablecimiento = null;
                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                    if (siiEstablecimiento == null) {

                        boolean estaLocal = false;
                        for (MovCargueInventarioWSVO movCargueInventarioTempWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioTempWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(movCargueInventarioTempWSVO.movCargueInvCodLocal)) {
                                    estaLocal = true;
                                    break;
                                }
                            }
                        }

                        if (!estaLocal) {
                            contErrores++;

                            /*
                            * Relacion con el cargue inventario estado cargue
                            */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010014L);
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }
                }
            }
        } else {
            respuesta = "30 El operador no se encuentra registrado";
        }

        /*
         * Verificar el numero de errores
         */
        if (contErrores > 0) {
            respuesta = "1 Se encontraron " + contErrores + " errores";
        } else {
            if (entroNovedad) {
                respuesta = "1 No se encontraron errores";
            } else {
                respuesta = "20 No registra el tipo de Novedad";
            }
        }

        if (respuesta.contains("1 ")) {
            respuesta = respuesta + validarInventarioXOperadorSol(movCargueInventarioWSVOs, 10L);
        }

        return respuesta;
    }

    /**
     *
     * Metodo validacion renovacio
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesRenovacion(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO {

        String respuesta = null;
        int contErrores = 0;
        //contErrores = validarInventarioXOperador(movCargueInventarioWSVOs, 20L);
        boolean entroNovedad = false;

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (siiOperador != null) {
            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

                /*
                 * ------------------------------------------
                 * 2.1 - TIPO DE NOVEDAD 50 CREACION DE LOCAL
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                    entroNovedad = true;

                    /*
                     * VALIDACION: El codigo el local no debe existir en el inventario del operador-contrato. Si no desplegar el
                     * Mensaje: 2050001 - Codigo del local ya existe.
                     */
                    SiiEstablecimiento siiEstablecimiento = null;
                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                    if (siiEstablecimiento != null) {
                        contErrores++;

                        /*
                         * Relacion con el cargue inventario estado cargue
                         */
                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(2050001L);
                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                        if (siitoMovCargInvEstCargInv.getMovCargueInvCodigo() != null && siitoMovCargInvEstCargInv.getEstCargInvCodigo() != null) {
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }

                    /*
                     * VALIDACION: El codigo del municipio DANE debe existir en la tabla correspondiente. Si no desplegar el
                     * Mensaje: 2050002 - Codigo DANE municipio no existe.
                     */
                    //                    SiiUbicacion siiUbicacion = new SiiUbicacion();
                    //                    siiUbicacion = ubicacionDAO.buscarUbicacionPorId(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                    //
                    //                    if (siiUbicacion == null) {
                    //                        contErrores++;
                    //
                    //                        /*
                    //                         * Relacion con el cargue inventario estado cargue
                    //                         */
                    //                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                    //                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(2050002L);
                    //                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                    //                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                    //                    }
                }

                /*
                 * ------------------------------------------
                 * 2.2 - TIPO DE NOVEDAD 10 ADICION ELEMENTOS
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                    entroNovedad = true;


                    //VALIDACION: Para el tipo de elemento 1-MET, Si el NUC viene diligenciado, debera buscarlo en el inventario de Coljuegos,
                    //validar que NO se encuentre activo, Si no desplegar el Mensaje: 2010001 - NUC se encuentra Activo.

                    //1-MET
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        //Para el tipo de elemento 1-MET, SI el NUC viene diligenciado, deberá buscarlo en el inventario de Coljuegos,
                        //validar que NO se encuentre ACTIVO, Si no desplegar el Mensaje: 1010001- NUC se encuentra Activo”.
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");

                            if (siiInventario != null) {


                                if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010001L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                        contErrores++;
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010005L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        siitoMovCargInvEstCargInv2.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                } else {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010001L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010004L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    //siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero()); no se complementa porque es de cara al operador.
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                    contErrores++;
                                }
                                String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                    if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010011L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    } else {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010002L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                    if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010012L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                }
                            } else {

                                siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), null);
                                if (siiInventario == null) {

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010010L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;

                                } else if (siiInventario != null) {
                                    String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                    long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                    if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                        if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010011L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        } else {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010002L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                        if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010012L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    }
                                }
                            }
                        } else {

                            //SiiInventario siiInventario = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                            List<Long> marcas = new ArrayList();
                            marcas.add(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                            List<SiiInventario> listSiiInventarioSMA = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas, "A");

                            //if (siiInventario != null) {
                            if (listSiiInventarioSMA != null && !listSiiInventarioSMA.isEmpty()) {
                                contErrores++;

                                //SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                HashMap<Long, String> errores = new HashMap();
                                StringBuilder complemento2 = new StringBuilder("<br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
                                List<String> smn = new ArrayList();
                                boolean activoNuc=false;
                                for (SiiInventario siiInventario : listSiiInventarioSMA) {
                                    if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                        if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                            if (!errores.containsKey(2010005L)) {
                                                errores.put(2010005L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                            } else {
                                                errores.put(2010005L, errores.get(2010005L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                            }

                                        }else if (siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                            if (!smn.contains(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                              siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                              siiInventario.getSiiInstrumento().getSiiMet().getMetUid())) {
                                                activoNuc = true;
                                                smn.add(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                        siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                        siiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                                complemento2.append("<tr>");
                                                complemento2.append("<td>");
                                                complemento2.append(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                                complemento2.append("</td>");
                                                complemento2.append("<td>");
                                                complemento2.append(siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                                complemento2.append("</td>");
                                                complemento2.append("<td>");
                                                complemento2.append(siiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                                complemento2.append("</td>");
                                                complemento2.append("</tr>");
                                            }
                                        }
                                    } else {
                                        if (!errores.containsKey(2010004L)) {
                                            errores.put(2010004L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(2010004L, errores.get(2010004L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        }

                                    }
                                }

                                for (Long iderror : errores.keySet()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(iderror);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv.setComplemento(errores.get(iderror));
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                }
                                
                                complemento2.append("</table>");
                                if (activoNuc) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010013L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv2.setComplemento(complemento2.toString());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                    contErrores++;
                                }

                            } else {


                                List<Long> marcas1_72 = new ArrayList();
                                marcas1_72.add(1L);
                                marcas1_72.add(72L);
                                List<SiiInventario> listaSiiInventarioSM1_72 = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas1_72, "A");
                                if (listaSiiInventarioSM1_72 != null && !listaSiiInventarioSM1_72.isEmpty()) {

                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>CONTRATO</th>");
                                    StringBuilder complemento2 = new StringBuilder("<br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
                                    List<String> smn = new ArrayList();
                                    boolean activoOtroContrato = false;
                                    boolean activoNuc = false;
                                    for (SiiInventario itemSiiInventario : listaSiiInventarioSM1_72) {
                                        if (!itemSiiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                            complemento.append("<tr>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                            complemento.append("</td>");
                                            complemento.append("</tr>");
                                            activoOtroContrato = true;
                                        } else if (itemSiiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                            if (!smn.contains(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                              itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                              itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid())) {
                                                activoNuc = true;
                                                smn.add(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                        itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                        itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                                complemento2.append("<tr>");
                                                complemento2.append("<td>");
                                                complemento2.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                                complemento2.append("</td>");
                                                complemento2.append("<td>");
                                                complemento2.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                                complemento2.append("</td>");
                                                complemento2.append("<td>");
                                                complemento2.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                                complemento2.append("</td>");
                                                complemento2.append("</tr>");
                                            }
                                        }
                                    }
                                    complemento2.append("</table></center><br/>");
                                    complemento.append("</table></center><br/>");
                                    if (activoOtroContrato) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010004L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        siitoMovCargInvEstCargInv2.setComplemento(complemento.toString());
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }
                                    if (activoNuc) {
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010013L);
                                        siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        siitoMovCargInvEstCargInv2.setComplemento(complemento2.toString());
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                        contErrores++;
                                    }

                                }

                                List<Long> marcasSMNULL = new ArrayList();
                                marcasSMNULL.add(movCargueInventarioWSVO.movCargueInvCodMarca.longValue());
                                marcasSMNULL.add(1L);
                                marcasSMNULL.add(72L);
                                List<SiiInventario> listSiiInventarioSMNULL = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcasSMNULL, null);
                                if (!listSiiInventarioSMNULL.isEmpty()) {
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"ui-datatable newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
                                    List<String> smn = new ArrayList();
                                    for (SiiInventario itemSiiInventario : listSiiInventarioSMNULL) {
                                        if (!smn.contains(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                          itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                          itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid())) {
                                            smn.add(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial() + "-" +
                                                    itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "-" +
                                                    itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                            complemento.append("<tr>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetSerial());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo());
                                            complemento.append("</td>");
                                            complemento.append("<td>");
                                            complemento.append(itemSiiInventario.getSiiInstrumento().getSiiMet().getMetUid());
                                            complemento.append("</td>");
                                            complemento.append("</tr>");
                                        }

                                    }
                                    complemento.append("</table></center><br/>");
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(2010013L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    siitoMovCargInvEstCargInv2.setComplemento(complemento.toString());
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv2);
                                    contErrores++;
                                }


                            }


                        }

                        /*if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                             //verificamos en siicol la informacion

                            SiiInstrumento siiInstrumento = null;
                            siiInstrumento =
                                instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                  String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                            // Verificamos la informacion de serial y la marca para el registro
                            if (siiInstrumento != null) {
                                if (siiInstrumento.getSiiMet().getMetNuid() != movCargueInventarioWSVO.movCargueInvNuidAd) {
                                    contErrores++;


                                     // Relacion con el cargue inventario estado cargue

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010003L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        }*/

                        /*if (movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 2L) {
                            SiiInventario siiInventario = null;
                            if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                                siiInventario =
                                    inventarioDAO.buscarInventarioXUIDYContrato(movCargueInventarioWSVO.movCargueInvIucAd.toString(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                movCargueInventarioWSVO.movCargueInvCodLocal);
                            } else {
                                siiInventario =
                                    inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                  movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                                  movCargueInventarioWSVO.movCargueInvCodLocal);
                            }

                            if (siiInventario != null) {
                                if (!siiInventario.getInvPg().equals("S")) {
                                    contErrores++;


                                     // Relacion con el cargue inventario estado cargue

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010006L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        }*/

                        /*if (movCargueInventarioWSVO.movCargueInvCodApuesta <= 1 && movCargueInventarioWSVO.movCargueInvCodApuesta >= 3) {
                            contErrores++;

                            // Relacion con el cargue inventario estado cargue

                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010007L);
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }*/

                    }

                    //5-ACDV
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.ACDV.getId()) {

                        //NUC sin diligenciar
                        if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                            SiiInventario siiInventario =
                                inventarioDAO.buscarInventarioACDVPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                            if (siiInventario != null) {
                                //contErrores++;

                                /*
                                 * Relacion con el cargue inventario estado cargue
                                 */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                /*
                                * VALIDACION: Si la 1-MET o (5-ACDV), se encuentra en un contrato activo y si el Nit y el contrato del operador
                                * de la base de datos es diferente al Nit y el contrato del operador que realiza la novedad debera desplegar el
                                * Mensaje: 2010004 - Elemento de juego autorizado en el inventario de otro contrato de concesion.
                                */
                                if (!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    contErrores++;

                                    /*
                                     * Relacion con el cargue inventario estado cargue
                                     */
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010004L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                } else {

                                    /*
                                     * VALIDACION: Si la 1-MET o (5-ACDV), se encuentra en un contrato activo y si el Nit y el contrato del operador
                                     * de la base de datos es IGUAL al Nit y el contrato que realiza la novedad y el establecimiento de la base de datos
                                     * es diferente al establecimiento de la novedad debera despelgar el Mensaje: 2010005 - Elemento de juego
                                     * actualmente autorizado en el establecimiento xxxx (xxxx: Establecimiento de la base de datos).
                                     */
                                    if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                        contErrores++;

                                        /*
                                         * Relacion con el cargue inventario estado cargue
                                         */
                                        siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010005L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    }
                                }
                            }
                        }
                    }

                    /*
                     * VALIDACION: Para el tipo de elemento 1-MET y 5-ACDV, Si el NUC viene diligenciado, debera buscarlo en el inventario de Coljuegos,
                     * Si existe debe validar que el serial y la marca reportada corresponda con el registrado, Si no desplegar el Mensaje: 2010002 -
                     * Serial y Marca no corresponde a ese NUC
                     */
                    //1-MET
                    /*if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {

                            if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                                 // verificamos en siicol la informacion

                                SiiInstrumento siiInstrumento = null;
                                siiInstrumento =
                                    instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                      String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                                // Verificamos la informacion de serial y la marca para el registro
                                if (siiInstrumento != null) {
                                    if (!siiInstrumento.getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd) &&
                                        siiInstrumento.getSiiMet().getSiiMarca().getMarCodigo() != movCargueInventarioWSVO.movCargueInvCodMarca.longValue()) {
                                        contErrores++;


                                         // Relacion con el cargue inventario estado cargue

                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010002L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    }
                                }
                            }
                    }*/

                    /*
                     * VALIDACION: Para el tipo de elemento 1-MET, Si el NUC viene diligenciado debera buscarlo en el inventario de Coljuegos,
                     * si el NUID esta diligenciado validar que el NUID corresponda con el registrado, Si no deplegar el Mensaje: 2010003 -
                     * NUID no corresponde a ese NUC.
                     */


                    /*
                     * VALIDACION: Para tipo de elemento 1-MET, Si el campo "Indicador conexion en linea SCLM" reportado es 2 y la MET existe en el
                     * inventario del operador-contrato y NO esta marcada como en "Periodo de gracia", desplegar el Mensaje: 2010006 -
                     * MET no se encuentra en el peridodo de gracia.
                     */


                    /*
                      * VALIDACION: Validar que el codigo de apuesta reportado corresponda al tipo de elemento reportado, Si no desplegar
                      * el Mensaje: 2010007 - Codigo de apuesta no corresponde a ese tipo de elemento.
                      */


                    /*
                     * VALIDACION: Para tipo de elemento 2-Bingo validar que el codigo de apuesta reportado corresponda con la poblacion
                     * del municipio. Si no desplegar el Mensaje: 2010008 - Codigo de apuesta para bingo no corresponde a la poblacion.
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                        //SiiEnteTerritorial siiEnteTerritorial = new SiiEnteTerritorial();
                        //siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                        if (siiEnteTerritorial != null) {
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 6) {
                                //if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                   * Relacion con el cargue inventario estado cargue
                                   */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 7) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 8) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 9) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 10) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 11) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 12) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 13) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 14) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 15) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 22) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 23) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores++;

                                    /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010009L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        } else {
                            contErrores++;

                            /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                            SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                            siitoEstadoCargueInventario = estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("El ente territorial no existe en el sistema para Bingo");

                            if (siitoEstadoCargueInventario == null) {
                                siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                siitoEstadoCargueInventario.setEstCargInvDesc("El ente territorial no existe en el sistema para Bingo");
                                siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                            }

                            /*
                            * Relacion con el cargue inventario estado cargue
                            */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }

                    /*
                     * VALIDACION: en espera con numero = 2010014L
                     */
                    SiiEstablecimiento siiEstablecimiento = null;
                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                    if (siiEstablecimiento == null) {

                        boolean estaLocal = false;
                        for (MovCargueInventarioWSVO movCargueInventarioTempWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioTempWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(movCargueInventarioTempWSVO.movCargueInvCodLocal)) {
                                    estaLocal = true;
                                    break;
                                }
                            }
                        }

                        if (!estaLocal) {
                            contErrores++;

                            /*
                            * Relacion con el cargue inventario estado cargue
                            */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010014L);
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }
                }
            }
        } else {
            respuesta = "30 El operador no se encuentra registrado";
        }

        /*
         * Verificar el numero de errores
         */
        if (contErrores > 0) {
            respuesta = "1 Se encontraron " + contErrores + " errores";
        } else {
            if (entroNovedad) {
                respuesta = "1 No se encontraron errores";
            } else {
                respuesta = "20 No registra el tipo de Novedad";
            }
        }

        if (respuesta.contains("1 ")) {
            respuesta = respuesta + validarInventarioXOperadorSol(movCargueInventarioWSVOs, 20L);
        }

        return respuesta;
    }

    public String inventarioElementos(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.inventarioElementos(sauCodigo);
    }

    /**
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @return
     * @throws ExcepcionDAO
     */
    public int validarInventarioXOperador(List<MovCargueInventarioWSVO> movCargueInventarioWSVOs, Long tipoSolicitud) throws ExcepcionDAO {
        int respuesta = 0;
        int contErrores = 0;
        Calendar calendar = Calendar.getInstance();
        double salarioMinimoVigente = smmlvDAO.buscarSmmlvPorVigencia(calendar.get(Calendar.YEAR));

        long cantMet = 0;
        long cantBingos = 0;
        long cantMesas = 0;
        long cantOtros = 0;
        long cantAcdv;
        cantAcdv = 0;
        long codError = 0L;
        Long tipoInst = 0L;

        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        cantMet++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                        //cantBingos++;
                        cantBingos = cantBingos + movCargueInventarioWSVO.movCargueInvCantSillas;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                        cantMesas++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.OTRO.getId()) {
                        cantOtros++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.ACDV.getId()) {
                        cantAcdv++;
                    }
                }
            }
        }

        /*
         *  VALIDACION: Cuando los elementos de juego son solo 1-MET el mismo tiene que ser 80 METS en cantidad
         *  (independiente del valor de la apuesta). Si NO desplegar el mensaje "4000001 - No
         *  cumple con el minimo de Elementos de juego (1-MET) por contrato".
         *  ó cuando los elementos de juego son solo ACDV
         */
        if ((cantMet > 0 && cantBingos == 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0) || (cantMet == 0 && cantBingos == 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv > 0)) {

            /*
             * Si los elmentos son solo met se valida que como minimo sean 80
             */
            if (cantMet < 80) {
                contErrores++;

                if (cantMet > 0 && cantBingos == 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0)
                    codError = 4000001L;
                else
                    codError = 4000006L;

                /*
                * Relacion con el cargue inventario estado cargue
                */
                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000001L);
                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVOs.get(0).movCargueInvCodigo);
                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
            }
        } else
        /*
         * Cuando los elementos de juegos son combinados (1-MET, 2-Bingos, 3-Mesas, esfereodromos, acdv) el minimo sera el equivalente al valor de 80
         * 1-MET con apuesta menor a $500 pesos, Si NO desplegar el mensaje "4000002 - No cumple con el minimo de Elementos de juego
         * (1-MET, 2-Bingos, 3-Mesas) por contrato"
         * ó cuando los elementos de juego son solo MESAS
         * y no vienen solo sillas
         */
        if (((cantMet > 0 || cantBingos > 0 || cantMesas > 0 || cantOtros > 0) || (cantMet == 0 && cantBingos == 0 && cantMesas > 0 && cantOtros == 0 && cantAcdv == 0)) &&
            !(cantMet == 0 && cantBingos > 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0)) {

            // sacamos el equivalente total pra los elementos con el salario minimo vigente de 80 maquinas de menor de 500 pesos
            double salarioMvxTreinta = salarioMinimoVigente * 0.3;
            double totalPesos = salarioMvxTreinta * 80;

            double totalPesosInventario = 0;
            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                        BigDecimal total = null;
                        total = tipoApuestaDao.buscarDerechoExplotacionXCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta);

                        if (total != null) {
                            if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                                totalPesosInventario += total.doubleValue() * movCargueInventarioWSVO.movCargueInvCantSillas;
                            } else {
                                totalPesosInventario += total.doubleValue();
                            }
                        }
                    }
                }
            }

            if (totalPesosInventario < totalPesos) {
                contErrores++;

                if (cantMet > 0 || cantBingos > 0 || cantMesas > 0 || cantOtros > 0)
                    codError = 4000005L;
                else
                    codError = 4000002L;

                /*
                * Relacion con el cargue inventario estado cargue
                */
                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                siitoMovCargInvEstCargInv.setEstCargInvCodigo(codError);
                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVOs.get(0).movCargueInvCodigo);
                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
            }

            /*
             ************** Cuando vienen sillas de 2-Bingos, el minimo depende de la cantidad de habitantes del respectivo municipio: *******
             */
            if (cantBingos > 0) {

                ArrayList<String> danes = new ArrayList<String>();
                int sillas = 0;
                int poblacionTotal = 0;
                EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO();

                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                            tipoInst = new Long(movCargueInventarioWSVO.movCargueInvTipInst);

                            if (tipoInst.equals(EnumTipoInstrumento.BINGO.getId())) {

                                if (movCargueInventarioWSVO.movCargueInvCodMunLoc != null && !movCargueInventarioWSVO.movCargueInvCodMunLoc.isEmpty()) {
                                    siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                                    if (siiEnteTerritorial != null) {
                                        if (!danes.contains(movCargueInventarioWSVO.movCargueInvCodMunLoc))
                                            danes.add(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                                    } else {
                                        contErrores++;

                                        /*
                                                     * Relacion con el cargue inventario estado cargue
                                                     */
                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050002L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    }
                                }
                            }

                        }
                    }
                }

                for (String dane : danes) {
                    sillas = 0;
                    for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                        if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                    sillas += movCargueInventarioWSVO.movCargueInvCantSillas;
                                }
                            }
                        }
                    }
                    /* Si es un municipio menor de 100.000 habitantes el minimo sera 100 sillas de bingos, Si NO desplegar
                        * el mensaje "4000003 - No cumple con el minimo de sillas (2-Bingos-100 Sillas) por contrato"
                        */
                    siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(dane));
                    //if (siiEnteTerritorial.getEtiPoblacion() < 100000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                        if (sillas < 100) {
                            contErrores++;

                            /*
                                * Relacion con el cargue inventario estado cargue
                                */

                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000003L);
                            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                        if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            break;
                                        }
                                    }
                                }
                            }


                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                        }
                        /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                             * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                            */
                    } else {
                        /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                                 * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                                */
                        if (sillas < 200) {
                            contErrores++;

                            /*
                                * Relacion con el cargue inventario estado cargue
                                */

                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000004L);
                            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                        if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            break;
                                        }
                                    }
                                }
                            }
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }

                }
            }
        } else
        /*
         * Cuando son solo sillas de 2-Bingos, el minimo depende de la cantidad de habitantes del respectivo municipio:
         */
        if (cantMet == 0 && cantBingos > 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0) {

            ArrayList<String> danes = new ArrayList<String>();
            int sillas = 0;
            int poblacionTotal = 0;
            EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO();

            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                        siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                        if (siiEnteTerritorial != null) {
                            if (!danes.contains(movCargueInventarioWSVO.movCargueInvCodMunLoc))
                                danes.add(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                        } else {
                            contErrores++;

                            /*
                             * Relacion con el cargue inventario estado cargue
                             */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050002L);
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }
                }
            }

            for (String dane : danes) {
                sillas = 0;
                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                            if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                sillas += movCargueInventarioWSVO.movCargueInvCantSillas;
                            }
                        }
                    }
                }
                /* Si es un municipio menor de 100.000 habitantes el minimo sera 100 sillas de bingos, Si NO desplegar
            * el mensaje "4000003 - No cumple con el minimo de sillas (2-Bingos-100 Sillas) por contrato"
            */
                siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(dane));
                //if (siiEnteTerritorial.getEtiPoblacion() < 100000) {
                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                    if (sillas < 100) {
                        contErrores++;

                        /*
                    * Relacion con el cargue inventario estado cargue
                    */

                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000003L);
                        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                    if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        break;
                                    }
                                }
                            }
                        }


                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                    }
                    /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                 * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                */
                } else {
                    /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                     * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                    */
                    if (sillas < 200) {
                        contErrores++;

                        /*
                    * Relacion con el cargue inventario estado cargue
                    */

                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000004L);
                        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                    if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        break;
                                    }
                                }
                            }
                        }
                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                    }
                }


            }
        }


        /*
         * Cuando son solo 4-Otros (Esferodromos) se permite a partir de la unidad
         */
        if (cantMet == 0 && cantBingos == 0 && cantMesas == 0 && cantOtros > 0 && cantAcdv == 0) {

        }

        /*
         * Cuando son solo 3-Mesas de casino no se permite, Desplegar el mensaje "4000005 - No cumple con el minimo de
         * elementos de juego por contrato"
         */
        /*if (cantMet == 0 && cantBingos == 0 && cantMesas > 0) {
            contErrores++;


            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
            siitoMovCargInvEstCargInv.setEstCargInvCodigo(4000005L);
            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVOs.get(0).movCargueInvCodigo);
            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
        }*/

        /*
         * Minimos por Local
         */

        /*
         * Verificamos cuantos locales registran en el inventario
         */
        List<MunicipiosMinimosVO> municipiosMinimosVOs = new ArrayList<MunicipiosMinimosVO>();
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                    boolean esta = false;
                    for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {
                        if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(municipiosMinimosVO.getCodigoMunicipio())) {
                            esta = true;
                            break;
                        }
                    }

                    if (!esta) {
                        MunicipiosMinimosVO municipiosMinimosVO = new MunicipiosMinimosVO();
                        municipiosMinimosVO.setCodigoMunicipio(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                        municipiosMinimosVO.setLocalesMinimosVOs(new ArrayList<LocalesMinimosVO>());
                        for (MovCargueInventarioWSVO movCargueInventarioLocalWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioLocalWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                if (movCargueInventarioLocalWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                    if (movCargueInventarioLocalWSVO.movCargueInvCodMunLoc.equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {

                                        boolean estaLocal = false;
                                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                                            if (movCargueInventarioLocalWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                estaLocal = true;
                                                break;
                                            }
                                        }

                                        if (!estaLocal) {
                                            LocalesMinimosVO localesMinimosVO = new LocalesMinimosVO();
                                            localesMinimosVO.setCodigoLocal(movCargueInventarioLocalWSVO.movCargueInvCodLocal);

                                            /*
                                             * Verificamos los elementos
                                             */
                                            int cantidadElementos = 0;
                                            for (MovCargueInventarioWSVO movCargueInventarioLocalCntWSVO : movCargueInventarioWSVOs) {
                                                if (movCargueInventarioLocalCntWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                                    if (movCargueInventarioLocalCntWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                                        if (movCargueInventarioLocalCntWSVO.movCargueInvCodLocal.equals(movCargueInventarioLocalWSVO.movCargueInvCodLocal)) {
                                                            if (Long.parseLong(movCargueInventarioLocalCntWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                                                                cantidadElementos += Integer.parseInt(String.valueOf(movCargueInventarioLocalCntWSVO.movCargueInvCantSillas));
                                                            } else {
                                                                cantidadElementos++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            localesMinimosVO.setNumeroInstrumentos(cantidadElementos);
                                            municipiosMinimosVO.getLocalesMinimosVOs().add(localesMinimosVO);
                                        }
                                    }
                                }
                            }
                        }

                        municipiosMinimosVOs.add(municipiosMinimosVO);
                    }
                }
            }
        }

        /*
         * Validacion: verifica que un local no se encuentre repetido en varios municipios
         */
        boolean estaRepetido = false;
        List<String> localesRepetidos = new ArrayList<String>();
        List<String> localesAdicionados = new ArrayList<String>();
        for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {
            for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                boolean esta = false;
                for (String local : localesAdicionados) {
                    if (local.equals(localesMinimosVO.getCodigoLocal())) {
                        esta = true;
                        localesRepetidos.add(localesMinimosVO.getCodigoLocal());
                    }
                }

                if (!esta) {
                    localesAdicionados.add(localesMinimosVO.getCodigoLocal());
                }
            }
        }

        for (String localAdicionado : localesRepetidos) {
            contErrores++;
            estaRepetido = true;

            /*
            * Creamos la descripcion del error en estado cargue inventario
            */
            SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
            siitoEstadoCargueInventario =
                estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("Verifique codigos establecimiento, ya que no pueden estar en diferentes municipios. Codigo local:" +
                                                                                           localAdicionado);

            if (siitoEstadoCargueInventario == null) {
                siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("5000" + localAdicionado));
                siitoEstadoCargueInventario.setEstCargInvDesc("Verifique codigos establecimiento, ya que no pueden estar en diferentes municipios. Codigo local:" + localAdicionado);
                siitoEstadoCargueInventario.setEstCargInvEstado(true);
                estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
            }

            /*
            * Relacion con el cargue inventario estado cargue
            */
            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
            siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

            /*
            * Verificamos la linea del local mov cargue inventario codigo
            */
            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                        if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localAdicionado)) {
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                        }
                    }
                }
            }
            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
        }

        if (!estaRepetido) {

            for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {

                //SiiEnteTerritorial siiEnteTerritorial = new SiiEnteTerritorial();
                //siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio());
                EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio()));

                //Item 1: De 500.001 en adelante = 20 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 500001) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 500001) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 20) {
                                contErrores++;

                                /*
                                * Creamos la descripcion del error en estado cargue inventario
                                */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                                * Relacion con el cargue inventario estado cargue
                                */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                                 * Verificamos la linea del local mov cargue inventario codigo
                                 */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 2: De 100.001 a 500.000 = 16 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 100000 && siiEnteTerritorial.getEtiPoblacion() < 500000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000 && siiEnteTerritorial.getEtiPoblacionActual() < 500000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 16) {
                                contErrores++;

                                /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                            * Relacion con el cargue inventario estado cargue
                            */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                             * Verificamos la linea del local mov cargue inventario codigo
                             */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }

                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 3: De 50.001 a 100.000 = 13 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 50000 && siiEnteTerritorial.getEtiPoblacion() < 100000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 50000 && siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 13) {
                                contErrores++;

                                /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                            * Relacion con el cargue inventario estado cargue
                            */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                             * Verificamos la linea del local mov cargue inventario codigo
                             */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }

                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 4: De 25.001 a 50.000 = 11 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 25000 && siiEnteTerritorial.getEtiPoblacion() < 50000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 25000 && siiEnteTerritorial.getEtiPoblacionActual() < 50000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 11) {
                                contErrores++;

                                /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                            * Relacion con el cargue inventario estado cargue
                            */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                             * Verificamos la linea del local mov cargue inventario codigo
                             */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }

                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 5: De 10.001 a 25.000 = 7 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 10000 && siiEnteTerritorial.getEtiPoblacion() < 25000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 10000 && siiEnteTerritorial.getEtiPoblacionActual() < 25000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 7) {
                                contErrores++;

                                /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                            * Relacion con el cargue inventario estado cargue
                            */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                             * Verificamos la linea del local mov cargue inventario codigo
                             */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }

                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 6: De menos de 10.000  = 3 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() < 10000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() < 10000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 3) {
                                contErrores++;

                                /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                                SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                                siitoEstadoCargueInventario =
                                    estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("No cumple con el minimo de elementos por el local " +
                                                                                                               localesMinimosVO.getCodigoLocal());

                                if (siitoEstadoCargueInventario == null) {
                                    siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                    siitoEstadoCargueInventario.setEstCargInvCodigo(Long.parseLong("4000" + localesMinimosVO.getCodigoLocal()));
                                    siitoEstadoCargueInventario.setEstCargInvDesc("No cumple con el minimo de elementos por el local " + localesMinimosVO.getCodigoLocal());
                                    siitoEstadoCargueInventario.setEstCargInvEstado(true);
                                    estadoCargueInventarioDAO.registrarEstadoCargueInventario(siitoEstadoCargueInventario);
                                }

                                /*
                            * Relacion con el cargue inventario estado cargue
                            */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());

                                /*
                             * Verificamos la linea del local mov cargue inventario codigo
                             */
                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            }
                                        }
                                    }
                                }

                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }
            }
        }

        /*
         * Verificar el numero de errores
         */
        if (contErrores > 0) {
            respuesta = contErrores;
        }

        return respuesta;
    }


    public BigDecimal DerechoDeExplotacionApuesta(long apuesta) {
        try {
            return tipoApuestaDao.buscarDerechoExplotacionXCodigoTipoApuesta(apuesta);
        } catch (ExcepcionDAO e) {
            e.printStackTrace();
            return null;
        }
    }


    public Long buscarSmmlvPorVigencia(Integer vigencia) {
        try {
            return smmlvDAO.buscarSmmlvPorVigencia(vigencia);
        } catch (ExcepcionDAO e) {
            e.printStackTrace();
            return null;
        }
    }

    public String validarInventarioXOperadorSol(List<MovCargueInventarioWSVO> movCargueInventarioWSVOs, Long tipoSolicitud) throws ExcepcionDAO {
        StringBuilder respuesta = new StringBuilder("");
        int contErrores = 0;
        Calendar calendar = Calendar.getInstance();
        double salarioMinimoVigente = smmlvDAO.buscarSmmlvPorVigencia(calendar.get(Calendar.YEAR));

        long cantMet = 0;
        long cantBingos = 0;
        long cantMesas = 0;
        long cantOtros = 0;
        long cantAcdv;
        cantAcdv = 0;
        long codError = 0L;
        Long tipoInst = 0L;

        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        cantMet++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                        //cantBingos++;
                        cantBingos = cantBingos + movCargueInventarioWSVO.movCargueInvCantSillas;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                        cantMesas++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.OTRO.getId()) {
                        cantOtros++;
                    }
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.ACDV.getId()) {
                        cantAcdv++;
                    }
                }
            }
        }

        /*
         *  VALIDACION: Cuando los elementos de juego son solo 1-MET el mismo tiene que ser 80 METS en cantidad
         *  (independiente del valor de la apuesta). Si NO desplegar el mensaje "4000001 - No
         *  cumple con el minimo de Elementos de juego (1-MET) por contrato".
         *  ó cuando los elementos de juego son solo ACDV
         */
        if ((cantMet > 0 && cantBingos == 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0) || (cantMet == 0 && cantBingos == 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv > 0)) {

            /*
             * Si los elmentos son solo met se valida que como minimo sean 80
             */
            if (cantMet < 80) {
                contErrores++;

                respuesta.append("&& No cumple con el minimo de Elementos de juego (MET) por contrato (Minimo 80) (Actual " + cantMet + ")");
            }
        } else
        /*
         * Cuando los elementos de juegos son combinados (1-MET, 2-Bingos, 3-Mesas, esfereodromos, acdv) el minimo sera el equivalente al valor de 80
         * 1-MET con apuesta menor a $500 pesos, Si NO desplegar el mensaje "4000002 - No cumple con el minimo de Elementos de juego
         * (1-MET, 2-Bingos, 3-Mesas) por contrato"
         * ó cuando los elementos de juego son solo MESAS
         * y no vienen solo sillas
         */
        if (((cantMet > 0 || cantBingos > 0 || cantMesas > 0 || cantOtros > 0) || (cantMet == 0 && cantBingos == 0 && cantMesas > 0 && cantOtros == 0 && cantAcdv == 0)) &&
            !(cantMet == 0 && cantBingos > 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0)) {

            // sacamos el equivalente total pra los elementos con el salario minimo vigente de 80 maquinas de menor de 500 pesos

            double salarioMvxTreinta = salarioMinimoVigente * 0.3;
            double totalPesos = salarioMvxTreinta * 80;

            double totalPesosInventario = 0;
            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                        BigDecimal total = null;
                        total = tipoApuestaDao.buscarDerechoExplotacionXCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta);

                        if (total != null) {
                            if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                                totalPesosInventario += total.doubleValue() * movCargueInventarioWSVO.movCargueInvCantSillas;
                            } else {
                                totalPesosInventario += total.doubleValue();
                            }
                        }
                    }
                }
            }

            if (totalPesosInventario < totalPesos) {
                contErrores++;

                if (cantMet > 0 || cantBingos > 0 || cantMesas > 0 || cantOtros > 0) {
                    //codError = 4000005L;
                    respuesta.append("&& No cumple con el minimo de elementos de juego por contrato");
                } else {
                    //codError = 4000002L;
                    respuesta.append("&& No cumple con el minimo de Elementos de juego (1-MET, 2-Bingos, 3-Mesas) por contrato");
                }
            }

            /*
             ************** Cuando vienen sillas de 2-Bingos, el minimo depende de la cantidad de habitantes del respectivo municipio: *******
             */
            if (cantBingos > 0) {

                ArrayList<String> danes = new ArrayList<String>();
                int sillas = 0;
                int poblacionTotal = 0;
                EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO();

                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                            tipoInst = new Long(movCargueInventarioWSVO.movCargueInvTipInst);

                            if (tipoInst.equals(EnumTipoInstrumento.BINGO.getId())) {

                                if (movCargueInventarioWSVO.movCargueInvCodMunLoc != null && !movCargueInventarioWSVO.movCargueInvCodMunLoc.isEmpty()) {
                                    siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                                    if (siiEnteTerritorial != null) {
                                        if (!danes.contains(movCargueInventarioWSVO.movCargueInvCodMunLoc))
                                            danes.add(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                                    } else {
                                        contErrores++;

                                        //Relacion con el cargue inventario estado cargue

                                        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050002L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    }
                                }
                            }

                        }
                    }
                }

                for (String dane : danes) {
                    sillas = 0;
                    for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                        if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                            if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                    sillas += movCargueInventarioWSVO.movCargueInvCantSillas;
                                }
                            }
                        }
                    }
                    /* Si es un municipio menor de 100.000 habitantes el minimo sera 100 sillas de bingos, Si NO desplegar
                        * el mensaje "4000003 - No cumple con el minimo de sillas (2-Bingos-100 Sillas) por contrato"
                        */
                    siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(dane));
                    //if (siiEnteTerritorial.getEtiPoblacion() < 100000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                        if (sillas < 100) {
                            contErrores++;
                            respuesta.append("&& No cumple con el minimo de sillas de Bingos por Municipio - Codigo Dane:" + dane + " (Minimo 100 Sillas) (Actual " + sillas + " Sillas)");

                        }
                        /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                             * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                            */
                    } else {
                        /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                                 * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                                */
                        if (sillas < 200) {
                            contErrores++;
                            respuesta.append("&& No cumple con el minimo de sillas de Bingos por Municipio - Codigo Dane:" + dane + " (Minimo 200 Sillas) (Actual " + sillas + " Sillas)");
                        }
                    }

                }
            }
        } else
        /*
         * Cuando son solo sillas de 2-Bingos, el minimo depende de la cantidad de habitantes del respectivo municipio:
         */
        if (cantMet == 0 && cantBingos > 0 && cantMesas == 0 && cantOtros == 0 && cantAcdv == 0) {

            ArrayList<String> danes = new ArrayList<String>();
            int sillas = 0;
            int poblacionTotal = 0;
            EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO();

            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {

                        siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                        if (siiEnteTerritorial != null) {
                            if (!danes.contains(movCargueInventarioWSVO.movCargueInvCodMunLoc))
                                danes.add(movCargueInventarioWSVO.movCargueInvCodMunLoc);
                        } else {
                            contErrores++;

                            /*
                             * Relacion con el cargue inventario estado cargue
                             */
                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(1050002L);
                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                        }
                    }
                }
            }

            for (String dane : danes) {
                sillas = 0;
                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                            if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(dane)) {
                                sillas += movCargueInventarioWSVO.movCargueInvCantSillas;
                            }
                        }
                    }
                }
                /* Si es un municipio menor de 100.000 habitantes el minimo sera 100 sillas de bingos, Si NO desplegar
            * el mensaje "4000003 - No cumple con el minimo de sillas (2-Bingos-100 Sillas) por contrato"
            */
                siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(dane));
                //if (siiEnteTerritorial.getEtiPoblacion() < 100000) {
                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                    if (sillas < 100) {
                        contErrores++;
                        respuesta.append("&& No cumple con el minimo de sillas de Bingos por Municipio - Codigo Dane:" + dane + " (Minimo 100 Sillas) (Actual " + sillas + " Sillas)");

                    }
                    /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                 * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                */
                } else {
                    /* Si es un municipio mayor de 100.000 habitantes el minimo sera 200 sillas de bingos, Si NO desplegar
                     * el mensaje "4000004 - No cumple con el minimo de sillas (2-Bingos-200 Sillas) por contrato"
                    */
                    if (sillas < 200) {
                        contErrores++;
                        respuesta.append("&& No cumple con el minimo de sillas de Bingos por Municipio - Codigo Dane:" + dane + " (Minimo 200 Sillas) (Actual " + sillas + " Sillas)");
                    }
                }


            }
        }


        List<MunicipiosMinimosVO> municipiosMinimosVOs = new ArrayList<MunicipiosMinimosVO>();
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
            if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                    boolean esta = false;
                    for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {
                        if (movCargueInventarioWSVO.movCargueInvCodMunLoc.equals(municipiosMinimosVO.getCodigoMunicipio())) {
                            esta = true;
                            break;
                        }
                    }

                    if (!esta) {
                        MunicipiosMinimosVO municipiosMinimosVO = new MunicipiosMinimosVO();
                        municipiosMinimosVO.setCodigoMunicipio(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                        municipiosMinimosVO.setLocalesMinimosVOs(new ArrayList<LocalesMinimosVO>());
                        for (MovCargueInventarioWSVO movCargueInventarioLocalWSVO : movCargueInventarioWSVOs) {
                            if (movCargueInventarioLocalWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                if (movCargueInventarioLocalWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                    if (movCargueInventarioLocalWSVO.movCargueInvCodMunLoc.equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {

                                        boolean estaLocal = false;
                                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                                            if (movCargueInventarioLocalWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                estaLocal = true;
                                                break;
                                            }
                                        }

                                        if (!estaLocal) {
                                            LocalesMinimosVO localesMinimosVO = new LocalesMinimosVO();
                                            localesMinimosVO.setCodigoLocal(movCargueInventarioLocalWSVO.movCargueInvCodLocal);

                                            /*
                                             * Verificamos los elementos
                                             */
                                            int cantidadElementos = 0;
                                            for (MovCargueInventarioWSVO movCargueInventarioLocalCntWSVO : movCargueInventarioWSVOs) {
                                                if (movCargueInventarioLocalCntWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                                    if (movCargueInventarioLocalCntWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                                                        if (movCargueInventarioLocalCntWSVO.movCargueInvCodLocal.equals(movCargueInventarioLocalWSVO.movCargueInvCodLocal)) {
                                                            if (Long.parseLong(movCargueInventarioLocalCntWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {
                                                                cantidadElementos += Integer.parseInt(String.valueOf(movCargueInventarioLocalCntWSVO.movCargueInvCantSillas));
                                                            } else {
                                                                cantidadElementos++;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            localesMinimosVO.setNumeroInstrumentos(cantidadElementos);
                                            municipiosMinimosVO.getLocalesMinimosVOs().add(localesMinimosVO);
                                        }
                                    }
                                }
                            }
                        }

                        municipiosMinimosVOs.add(municipiosMinimosVO);
                    }
                }
            }
        }

        /*
         * Validacion: verifica que un local no se encuentre repetido en varios municipios
         */
        boolean estaRepetido = false;
        List<String> localesRepetidos = new ArrayList<String>();
        List<String> localesAdicionados = new ArrayList<String>();
        for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {
            for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                boolean esta = false;
                for (String local : localesAdicionados) {
                    if (local.equals(localesMinimosVO.getCodigoLocal())) {
                        esta = true;
                        localesRepetidos.add(localesMinimosVO.getCodigoLocal());
                    }
                }

                if (!esta) {
                    localesAdicionados.add(localesMinimosVO.getCodigoLocal());
                }
            }
        }

        for (String localAdicionado : localesRepetidos) {
            contErrores++;
            estaRepetido = true;
            respuesta.append("&& Verifique codigos establecimiento, ya que no pueden estar en diferentes municipios. Codigo local:" + localAdicionado);
        }

        if (!estaRepetido) {

            for (MunicipiosMinimosVO municipiosMinimosVO : municipiosMinimosVOs) {

                EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio()));
                //SiiEnteTerritorial siiEnteTerritorial = new SiiEnteTerritorial();
                //siiEnteTerritorial =   enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio());

                //Item 1: De 500.001 en adelante = 20 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 500001) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 500001) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 20) {
                                contErrores++;
                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 20 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }

                //Item 2: De 100.001 a 500.000 = 16 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 100000 &&  siiEnteTerritorial.getEtiPoblacion() < 500000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000 && siiEnteTerritorial.getEtiPoblacionActual() < 500000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 16) {
                                contErrores++;
                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 16 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }

                //Item 3: De 50.001 a 100.000 = 13 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 50000 && siiEnteTerritorial.getEtiPoblacion() < 100000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 50000 && siiEnteTerritorial.getEtiPoblacionActual() < 100000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 13) {
                                contErrores++;
                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 13 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }

                //Item 4: De 25.001 a 50.000 = 11 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 25000 && siiEnteTerritorial.getEtiPoblacion() < 50000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 25000 && siiEnteTerritorial.getEtiPoblacionActual() < 50000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 11) {
                                contErrores++;
                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 11 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }

                //Item 5: De 10.001 a 25.000 = 7 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() > 10000 && siiEnteTerritorial.getEtiPoblacion() < 25000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 10000 && siiEnteTerritorial.getEtiPoblacionActual() < 25000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 7) {
                                contErrores++;
                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 7 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }

                //Item 6: De menos de 10.000  = 3 Elementos
                if (siiEnteTerritorial != null) {
                    //if (siiEnteTerritorial.getEtiPoblacion() < 10000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() < 10000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 3) {
                                contErrores++;


                                respuesta.append("&& No cumple con el minimo de elementos para el local " + localesMinimosVO.getCodigoLocal() + " (Minimo 3 elementos) (Actual " +
                                                 localesMinimosVO.getNumeroInstrumentos() + " elementos)");
                            }
                        }
                    }
                }
            }
        }

        /*
         * Verificar el numero de errores
         */
        /*if (contErrores > 0) {
            respuesta = contErrores;
        }*/

        return respuesta.toString();
    }

    public List<SolicitudAutorizaVO> solicitudesAutorizacionPorEstadoPorTipoSolPorUsuario(Long estado, Long tipoSol, Long usuCodigo) throws ExcepcionDAO {
        List<SolicitudAutorizaVO> solicitudesVo = new ArrayList<SolicitudAutorizaVO>();
        for (SiiSolicitudAutoriza solicitud : solicitudAutorizaDAO.solicitudesAutorizacionPorEstadoPorTipoSolPorUsuario(estado, tipoSol, usuCodigo)) {
            solicitudesVo.add(new SolicitudAutorizaVO(solicitud));
        }
        return solicitudesVo;
    }

    public List<SolicitudAutorizaVO> solicitudesAutorizacionAprobadasQueNoModificanValor(Long usuCodigo) throws ExcepcionDAO {
        List<SolicitudAutorizaVO> solicitudesVo = new ArrayList<SolicitudAutorizaVO>();
        for (SiiSolicitudAutoriza solicitud : solicitudAutorizaDAO.solicitudesAutorizacionAprobadasQueNoModificanValor(usuCodigo)) {
            solicitudesVo.add(new SolicitudAutorizaVO(solicitud));
        }
        return solicitudesVo;
    }

    public List<SolicitudAutorizaVO> solicitudesAutorizacionAprobadasQueNoModificanValor() throws ExcepcionDAO {
        List<SolicitudAutorizaVO> solicitudesVo = new ArrayList<SolicitudAutorizaVO>();
        for (SiiSolicitudAutoriza solicitud : solicitudAutorizaDAO.solicitudesAutorizacionAprobadasQueNoModificanValor()) {
            solicitudesVo.add(new SolicitudAutorizaVO(solicitud));
        }
        return solicitudesVo;
    }

    public List<UbicacionMetAutorizadaVO> ubicacionMetsAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.ubicacionMetsAutorizadas(sauCodigo);
    }

    public List<UbicacionSillasBingoAutorizadasVO> ubicacionSillasBingoAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.ubicacionSillasBingoAutorizadas(sauCodigo);
    }

    public List<UbicacionMesasCasinoAutorizadasVO> ubicacionMesasCasinoAutorizadas(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.ubicacionMesasCasinoAutorizadas(sauCodigo);
    }

    public List<UbicacionDemasJuegosAutorizadosVO> ubicacionEsferodromosAutorizados(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.ubicacionEsferodromosAutorizados(sauCodigo);
    }

    public List<ValorMensualPorApuestaVO> valorMensualPorApuesta(Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.valorMensualPorApuesta(sauCodigo);
    }

    public BigDecimal contarElementosPorTipoNovedadPorSolicitud(String movimiento, String listaEstados, Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.contarElementosPorTipoNovedadPorSolicitud(movimiento, listaEstados, sauCodigo);
    }

    public List<InventarioWebVO> inventarioNitWeb(String nit) throws ExcepcionDAO {
        return solicitudAutorizaDAO.consultarInventarioNitWeb(nit);
    }

    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioPorEstado(Long estado, Long estado2, Long usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSiiSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionOficioPorEstado(estado, estado2, usuarioLogueado);
        List<SolicitudAutorizaVO> solicitudesAutorizaVO = new ArrayList();
        for (SiiSolicitudAutoriza solicitud : listaSiiSolicitudes) {
            SolicitudAutorizaVO solVo = new SolicitudAutorizaVO(solicitud);
            if (solicitud.getSiiNovedadList() != null && solicitud.getSiiNovedadList().size() > 0) {
                List<NovedadVO> novedadListVo = new ArrayList();
                for (SiiNovedad siiNovedad : solicitud.getSiiNovedadList()) {
                    NovedadVO unaNovedadVo = new NovedadVO(siiNovedad);
                    novedadListVo.add(unaNovedadVo);
                }
                solVo.setNovedadListVo(novedadListVo);
            }
            solicitudesAutorizaVO.add(solVo);
        }


        return solicitudesAutorizaVO;
    }

    public List<NovedadVO> buscarNovedadesPorSolicitudAutorizacion(Long idSolicitud) throws ExcepcionDAO {
        List<SiiNovedad> listaSiiNovedades = solicitudAutorizaDAO.buscarNovedadesPorSolicitudAutorizacion(idSolicitud);
        List<NovedadVO> novedadesVO = new ArrayList();
        for (SiiNovedad novedad : listaSiiNovedades) {
            novedadesVO.add(new NovedadVO(novedad));
        }
        return novedadesVO;
    }

    public String localesExcluidosContrato(Long conCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.localesExcluidosContrato(conCodigo);
    }

    public String textoCantidadElementosPorAccionPorSolicitud(String accion, String listaEstados, Long sauCodigo) throws ExcepcionDAO {
        return solicitudAutorizaDAO.textoCantidadElementosPorAccionPorSolicitud(accion, listaEstados, sauCodigo);
    }

    // ******
    public List<SolicitudAutorizaVO> buscarSolicitudAutorizacionOficioLiqPorTipoSolicitud(UsuarioVO usuarioLogueado) throws ExcepcionDAO {
        List<SiiSolicitudAutoriza> listaSiiSolicitudes = solicitudAutorizaDAO.buscarSolicitudAutorizacionOficioLiqPorTipoSolicitud(usuarioLogueado.getUsuCodigo());
        List<SolicitudAutorizaVO> listaSol = new ArrayList<SolicitudAutorizaVO>();

        if (listaSiiSolicitudes.size() > 0) {
            for (SiiSolicitudAutoriza sol : listaSiiSolicitudes) {
                SolicitudAutorizaVO solicitud = new SolicitudAutorizaVO(sol);
                listaSol.add(solicitud);
            }
        }

        return listaSol;

    }

    public String nombreEstadoSolicitud(Long esaCodigo) throws ExcepcionDAO {
        return estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(esaCodigo).getEsaNombre();
    }

    public EstadoSolicAutorizVO buscarEstadoSolicAutorizPorId(Long esaCodigo) throws ExcepcionDAO {
        return new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(esaCodigo));
    }


}


