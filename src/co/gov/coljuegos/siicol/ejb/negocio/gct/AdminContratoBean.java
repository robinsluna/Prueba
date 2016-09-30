package co.gov.coljuegos.siicol.ejb.negocio.gct;

//import co.gov.coljuegos.siicol.ejb.vo.ActMulSancionesVO;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoCuota;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoContrato;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoPersonal;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoUbicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminCuotaOperador;
import co.gov.coljuegos.siicol.ejb.negocio.ryt.AdminLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActualizacCuotaOpeDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ActualizacionMultaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AcuerdoPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AjusteCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AjusteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AjusteDetRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DeclaracionSugeridaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleCorteCarteraDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionSugDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantPolizaOficLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MedioPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificaVentasMetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficLiqTipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperacionLineaBanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PagoOpePseDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcedenciaPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecaudoBancoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReporteVentasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResumenNoConectadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionGctDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SmmlvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoAjusteDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoCuentaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActualizacCuotaOpe;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActualizacionMulta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjuste;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteDetRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDeclaracionSugerida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperacionLineaBan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcedenciaPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoLineaBan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoPse;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAjuste;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoCuenta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DeclaracionSugeridaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoAsociadoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCuentaVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.InstrumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.ModReporteContratoConcesionVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteContratoConcesionVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinanVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.wsvo.DeclaracionOperadorWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ElementoAsociadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.LiquidacionOtrosConceptosWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.VentasMetCuotaWSVO;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class AdminContratoBean implements AdminContrato {
    @EJB
    private ContratoDAO contratoDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private PersonaDAO personaDAO;
    @EJB
    private OperadorDAO operadorDAO;
    @EJB
    private MesDAO mesDao;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDAO;
    @EJB
    private InteresCuotaDAO interesCuotaDao;
    @EJB
    private EstablecimientoDAO establecimientoDAO;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    @EJB
    private InventarioDAO inventarioDAO;
    @EJB
    private NovedadDAO novedadDAO;
    @EJB
    private UbicacionDAO ubicacionDAO;
    @EJB
    private InstrumentoDAO instrumentoDAO;
    @EJB
    private DetalleCorteCarteraDAO detalleCorteCarteraDao;
    @EJB
    private CorteCarteraDAO corteCarteraDao;
    @EJB
    private DeclaracionSugeridaDAO declaracionSugeridaDAO;
    @EJB
    private ResolucionAutorizDAO resolucionAutorizDAO;
    @EJB
    private OficioLiquidacionDAO oficioLiquidacionDAO;
    @EJB
    private OficLiqTipoApuestaDAO oficLiqTipoApuestaDAO;
    @EJB
    private DetalleDeclaracionSugDAO detalleDeclaracionSugDAO;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    private EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    private RevisionFinanDAO adminRevisionFinanDao;
    @EJB
    private RevisionGctDAO adminRevisionGctDao;
    @EJB
    private PolizaContratDAO polizaContratDAO;
    @EJB
    private GarantiaPolizaDAO garantiaPolizaDAO;
    @EJB
    private GarantPolizaOficLiqDAO garantPolizaOficLiqDAO;
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    private AjusteCuotaDAO ajusteCuotaDao;
    @EJB
    private AjusteDAO ajusteDao;
    @EJB
    private TipoAjusteDAO tipoAjusteDao;
    @EJB
    private DeclaracionOperadorDAO declaracionOperadorDao;
    @EJB
    private DetalleDeclaracionDAO detalleDeclaracionDao;
    @EJB
    private AjusteDetRecaudoDAO ajusteDetRecaudoDao;
    @EJB
    private DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    private AcuerdoPagoDAO acuerdoPagoDao;
    @EJB
    private BancoDAO bancoDao;
    @EJB
    private TipoCuentaDAO tipoCuentaDao;
    @EJB
    private RecaudoBancoDAO recaudoBancoDao;
    @EJB
    private ProcedenciaPagoDAO procedenciaPagoDao;
    @EJB
    private MedioPagoDAO medioPagoDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    SmmlvDAO smmlvDao;
    @EJB
    private PagoOpePseDAO pagoOpePseDao;
    @EJB
    private OperacionLineaBanDAO operacionLineaBanDao;
    @EJB
    private AdminLiquidacionMes adminLiquidacionMes;
    @EJB
    private ResumenNoConectadoDAO resumenNoConetadoDao;
    @EJB
    private AdminCuotaOperador adminCuotaOperador;
    @EJB
    private ModificaVentasMetDAO modificaVentasMetDao;
    @EJB
    private ReporteVentasDAO reporteVentasDao;
    @EJB 
    private ActualizacCuotaOpeDAO actualizacCuotaOpeDao;
    @EJB 
    private ActualizacionMultaDAO actualizacionMultaDao;
    @EJB
    private AdminLogGeneral adminLogGeneral;
    
    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000;
    //final 


    public AdminContratoBean() {
    }

    public List<ContratoVO> buscarContratosPorEstadoEjecucion(String estado) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosPorEstadoEjecucion(estado);
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;
    }

    public List<ContratoVO> buscarContratosOuterJoinEstadoSolicitud(String pEstado) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosOuterJoinEstadoSolicitud(pEstado);
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;

    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ContratoVO> contratosPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.contratosPerfeccionadosSinPolizasPendientes();
        for (SiiContrato contrato : contratos) {
            ContratoVO contratoVO = new ContratoVO(contrato);

            //Novedades
            List<SiiNovedad> siiNovedads = null;
            siiNovedads = novedadDAO.buscarNovedadesPorIdContrato(contratoVO.getConCodigo(), false);
            if (siiNovedads != null && !siiNovedads.isEmpty()) {
                contratoVO.setNovedadVoList(new ArrayList<NovedadVO>());
                contratoVO.getNovedadVoList().add(new NovedadVO(siiNovedads.get(0)));

                //Resolucion Autorizacion
                List<SiiResolucionAutoriz> siiResolucionAutorizs = null;
                siiResolucionAutorizs = resolucionAutorizDAO.buscarResolucionAutorizPorSolicitudAutoriza(siiNovedads.get(0).getSiiSolicitudAutoriza().getSauCodigo());
                if (siiResolucionAutorizs != null && !siiResolucionAutorizs.isEmpty()) {
                    contratoVO.getNovedadVoList().get(0).getSolicitudAutorizaVO().setResolucionAutorizListVo(new ArrayList<ResolucionAutorizVO>());
                    contratoVO.getNovedadVoList().get(0).getSolicitudAutorizaVO().getResolucionAutorizListVo().add(new ResolucionAutorizVO(siiResolucionAutorizs.get(0)));
                }
            }

            contratosVO.add(contratoVO);
        }

        return contratosVO;
    }

    public ContratoVO guardarContrato(ContratoVO contratoVo, UsuarioVO usuarioLogueado, boolean cambioEstado, SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO {
        if (contratoVo.getConNumero() == null) {
            contratoVo.setConConsecutivo(contratoDAO.siguienteNumeroContrato());
            contratoVo.setConNumero("C" + Integer.toString(contratoVo.getConConsecutivo()));
            contratoVo.setConPermiso(contratoVo.getConNumero());
        }
        List<RevisionFinanVO> revisionesFinanVo = contratoVo.getRevisionFinanListVo();
        List<RevisionGctVO> revisionesGctVo = contratoVo.getRevisionGctListVo();
        if (contratoVo.getConCodigo() == null) {
            contratoVo = new ContratoVO(contratoDAO.insertarSiiContrato(conversionVoEntidad.convertir(contratoVo)));
        }
        else {
            contratoVo = new ContratoVO(contratoDAO.actualizarSiiContrato(conversionVoEntidad.convertir(contratoVo)));
        }

        for (NovedadVO nov : solicitudAutorizaVo.getNovedadListVo()) {

            nov.setContratoVO(contratoVo);
            novedadDAO.actualizarSiiNovedad(conversionVoEntidad.convertir(nov));


        }

        if (cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(), contratoVo.getEstadoContratoVo().getEcoCodigo(), usuarioLogueado, contratoVo.getConCodigo());
        }
        if (EnumEstadoContrato.PROYECTADO.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo())) {
            EstadoSolicAutorizVO estadoVo = new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.CONTRATO_EN_TRAMITE.getId()));
            solicitudAutorizaVo.setEstadoSolicAutoriz(estadoVo);
            solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));
        }

        if (EnumEstadoContrato.VALIDADO_FINANCIERA.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo()) || EnumEstadoContrato.NO_VALIDADO_FINANCIERA.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo())) {
            for (RevisionFinanVO rev : revisionesFinanVo) {
                if ("FIN".equals(rev.getRfiTipoValidac())) {
                    rev.setContratoVo(contratoVo);
                    if (rev.getRfiCodigo() == null) {
                        rev = new RevisionFinanVO(adminRevisionFinanDao.insertarRevisionFinan(conversionVoEntidad.convertir(rev)));
                    }
                    else {
                        rev = new RevisionFinanVO(adminRevisionFinanDao.actualizarRevisionFinan(conversionVoEntidad.convertir(rev)));


                    }
                }

            }
        }

        contratoVo.setRevisionFinanListVo(revisionesFinanVo);

        if (EnumEstadoContrato.VALIDADO_GCT.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo()) || EnumEstadoContrato.NO_VALIDADO_GCT.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo())) {
            for (RevisionGctVO rev : revisionesGctVo) {
                rev.setContratoVo(contratoVo);
                if (rev.getRgcCodigo() == null) {
                    rev = new RevisionGctVO(adminRevisionGctDao.insertarRevisionGct(conversionVoEntidad.convertir(rev)));
                }
                else {
                    rev = new RevisionGctVO(adminRevisionGctDao.actualizarRevisionGct(conversionVoEntidad.convertir(rev)));
                }
            }

            contratoVo.setRevisionGctListVo(revisionesGctVo);
        }

        if (EnumEstadoContrato.VALIDADO_CCA.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo()) || EnumEstadoContrato.NO_VALIDADO_CCA.getId().equals(contratoVo.getEstadoContratoVo().getEcoCodigo())) {
            for (RevisionFinanVO rev : revisionesFinanVo) {
                if ("CCA".equals(rev.getRfiTipoValidac())) {
                    rev.setContratoVo(contratoVo);
                    if (rev.getRfiCodigo() == null) {
                        rev = new RevisionFinanVO(adminRevisionFinanDao.insertarRevisionFinan(conversionVoEntidad.convertir(rev)));
                    }
                    else {
                        rev = new RevisionFinanVO(adminRevisionFinanDao.actualizarRevisionFinan(conversionVoEntidad.convertir(rev)));


                    }
                }

            }
        }

        contratoVo.setRevisionFinanListVo(revisionesFinanVo);

        return contratoVo;

    }

    public List<EstadoCuentaVO> estadoCuenta(String contrato, Integer concepto, Date fechaCorte, boolean isOrderDesc) throws ExcepcionDAO {
        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        int vigencia = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        SiiCorteCartera corteCartera = corteCarteraDao.buscarCorteCarteraPorVigenciaPorMes(vigencia, mes);
        List<EstadoCuentaVO> listaEstadoCuentaVo = null;
        if (corteCartera != null) {
            listaEstadoCuentaVo = detalleCorteCarteraDao.estadoCuentaCorte(contrato, concepto, fechaCorte, isOrderDesc);
        }
        else {
            listaEstadoCuentaVo = contratoDAO.estadoCuenta(contrato, concepto, fechaCorte, isOrderDesc, null);
        }
        return listaEstadoCuentaVo;
    }

    public List<EstadoCuentaVO> estadoCuentaNit(String contrato, Integer concepto, Date fechaCorte, boolean isOrderDesc, String nit) throws ExcepcionDAO {
        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fechaCorte);
        int vigencia = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH) + 1;
        SiiCorteCartera corteCartera = corteCarteraDao.buscarCorteCarteraPorVigenciaPorMes(vigencia, mes);
        List<EstadoCuentaVO> listaEstadoCuentaVo = null;
        if (corteCartera != null) {
            listaEstadoCuentaVo = detalleCorteCarteraDao.estadoCuentaCorte(contrato, concepto, fechaCorte, isOrderDesc);
        }
        else {
            listaEstadoCuentaVo = contratoDAO.estadoCuenta(contrato, concepto, fechaCorte, isOrderDesc, nit);
        }
        return listaEstadoCuentaVo;
    }

    /**
     *Metodo encargado de hacer la consulta del estado de cuenta para los conceptos diferentes a GA y DE
     * Adaptacion por : David Tafur
     * @param nit
     * @param fechaCorte
     * @param isOrderTipo
     * @return
     * @throws ExcepcionDAO
     */
    public List<EstadoCuentaVO> estadoCuentaLiquidacionOtrosConceptos(String nit, Date fechaCorte) throws ExcepcionDAO {
        if (fechaCorte == null) {
            fechaCorte = new Date();
        }
        List<EstadoCuentaVO> listaEstadoCuentaVo = null;

        listaEstadoCuentaVo = contratoDAO.estadoCuentaLiquidacionOtrosConceptos(nit, fechaCorte);

        return listaEstadoCuentaVo;
    }


    public List<EstadoCuentaVO> interesesXCuota(String contrato, Integer concepto, Integer cuota) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = contratoDAO.interesesXCuota(contrato, concepto, cuota);
        return estadoCuentaVO;
    }

    /**
     * @author Modifica Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ContratoVO> buscarContratosEstadoCuenta() throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosEstadoCuenta();
        for (SiiContrato contrato : contratos) {
            ContratoVO contratoVO = new ContratoVO(contrato);

            if (contratoVO.getOperadorVo().getPersonaVo().getPersonaRepresentanteVo() != null) {
                SiiPersona siiPersonaRL = new SiiPersona();
                siiPersonaRL = personaDAO.buscarPersonaPorId(contratoVO.getOperadorVo().getPersonaVo().getPersonaRepresentanteVo().getPerCodigo());
                PersonaVO personaRLVO = new PersonaVO(siiPersonaRL);
                contratoVO.getOperadorVo().getPersonaVo().setPersonaRepresentanteVo(personaRLVO);
            }
            contratosVO.add(contratoVO);
        }

        return contratosVO;
    }

    /**
     * Consultar el estado de los acuerdos de pago
     * @author El Gatopardo
     * @param contrato
     * @param fechaCorte
     * @param isOrderTipo
     * @return
     * @throws ExcepcionDAO
     */
    public List<EstadoCuentaVO> estadoAcuerdoPago(String nit, Date fechaCorte) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = contratoDAO.estadoAcuerdoPago(nit, fechaCorte);
        return estadoCuentaVO;
    }

    public List<ContratoVO> buscarContratosPorNit(String nit) throws ExcepcionDAO {
        List<ContratoVO> listaContratosVo = new ArrayList<ContratoVO>();
        List<SiiContrato> listaContratos = contratoDAO.buscarContratosPorNit(nit);
        for (SiiContrato unSiiContrato : listaContratos) {
            ContratoVO unContratoVo = new ContratoVO(unSiiContrato);
            listaContratosVo.add(unContratoVo);
        }
        return listaContratosVo;
    }

    public List<ContratoVO> buscarContratosVigentesPorNit(String nit) throws ExcepcionDAO {
        List<ContratoVO> listaContratosVo = new ArrayList<ContratoVO>();
        List<SiiContrato> listaContratos = contratoDAO.buscarContratosVigentesPorNit(nit);
        for (SiiContrato unSiiContrato : listaContratos) {
            ContratoVO unContratoVo = new ContratoVO(unSiiContrato);
            listaContratosVo.add(unContratoVo);
        }
        return listaContratosVo;
    }

    /**
     *Metodo encargado de generar la declaracion del operador para las obligaciones por concepto de derechos
     * de explotacion y gastos de administracion de un mes determinado
     * @author David Tafur
     * @param nit
     * @param numeroContrato
     * @param mesDeclararar
     * @return
     */
    public DeclaracionOperadorWSVO generarDeclaracionOperadorGaDe(String nit, String numeroContrato, Integer mesDeclararar, Integer anoDeclarar) throws ExcepcionAplicacion, ExcepcionDAO {


        if (nit == null || nit.equals("")) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el nit.");
        }

        if (numeroContrato == null || numeroContrato.equals("")) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el numero de contrato.");
        }

        if (mesDeclararar == null || mesDeclararar == 0) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el mes.");
        }

        if (anoDeclarar == null || anoDeclarar == 0) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el año.");
        }

        int totalElementos = 0;
        SiiCuotaOperador siiCuotaOperadorDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorGA = new SiiCuotaOperador();

        /*
            * Objeto donde se va a almacenar la informacion con la que se le va a responder al web services
           */
        DeclaracionOperadorWSVO declaracionOperadorWSVO = new DeclaracionOperadorWSVO();
        //    List<EstablecimientoWSVO> listaEstablecimientoWSVO = new ArrayList<EstablecimientoWSVO>();
        List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO = new ArrayList<ElementoAsociadoWSVO>();
        List<VentasMetCuotaWSVO> listaVentasMetCuotaWSVO = new ArrayList<VentasMetCuotaWSVO>();
        List<VentasMetCuotaWSVO> listaModificacionVentasMetCuotaWSVO = new ArrayList<VentasMetCuotaWSVO>();
        List<VentasMetCuotaWSVO> listaReporteModificacionVentasMetCuotaWSVO = new ArrayList<VentasMetCuotaWSVO>();
        List<SiiResumenNoConectado> listaResumenNoConectado = new ArrayList<SiiResumenNoConectado>();
        List<SiiModificaVentasMet> listaModificaVentasMet = new ArrayList<SiiModificaVentasMet>();
        List<ElementoAsociadoWSVO> listaElementoAsociadoWSVO = new ArrayList<ElementoAsociadoWSVO>();
        /*
            * Variables usadas para los calculos de la declaracion
            */
        //    BigDecimal saldoCuotaDE = new BigDecimal(0);
        //  BigDecimal saldoInteresesDE = new BigDecimal(0);
        // BigDecimal saldoCuotaGA = new BigDecimal(0);
        // BigDecimal saldoInteresesGA = new BigDecimal(0);

        //Traemos el mes de la declaracion
        SiiMes siiMes = new SiiMes();
        siiMes = mesDao.buscarMesPorId(mesDeclararar);
        /*
           * Buscamos el operador
           */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), nit);

        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una persona por ese numero de nit por favor verifique.");
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());
        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una operador por ese nit por favor verifique.");
        }

        /*
           * Traemos el contrato por ese numero de contrato
           */
        SiiContrato siiContrato = new SiiContrato();
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(numeroContrato, siiOperador.getOpeCodigo());
        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato por ese numero de contrato por favor verifique.");
        }


        //Consultamos el revisor fiscal para el operador
        SiiPersona siiRevisorFiscalPersona = null;
        siiRevisorFiscalPersona = personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(siiOperadorPersona.getPerCodigo(), EnumTipoPersonal.REVISOR_FISCAL.getId());


        siiCuotaOperadorDE = cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConcepto(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);

        siiCuotaOperadorGA = cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConcepto(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "GA", anoDeclarar);

        if (siiCuotaOperadorDE.getCopFechaLimPag() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(siiCuotaOperadorDE.getCopFechaLimPag());
            int mes = cal.get(Calendar.MONTH) + 1;

            Calendar calFechaActual = Calendar.getInstance();
            System.out.println("mes " + mes + " mes actual " + calFechaActual.get(Calendar.MONTH) + 1);

            //if(mes == calFechaActual.get(Calendar.MONTH) + 1) {
            //Consultamos la liquidacion mensual del operador
            SiiLiquidacionMes siiLiquidacionMesOperador = new SiiLiquidacionMes();
            siiLiquidacionMesOperador =
                liquidacionMesDao.consultarLiquidacionMesXOperadorXContratoXMesXConcepto(siiOperador.getOpeCodigo(), siiContrato.getConCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);

            //Buscamos la informacion para la columna valor total del establecimiento, que es donde se guardar
            //el valor a pagar del operador para cada establecimiento

            if (siiLiquidacionMesOperador != null && siiLiquidacionMesOperador.getLmeCodigo() != null && siiLiquidacionMesOperador.getLmeCodigo() > 0) {

                /*
            * Consultamos los instrumentos asociados al contrato y hacemos el conteo de la cantidad de estos elementos
            * activos para la fecha de liquidacion, para luego retornar dicha informacion por el ws*/

                //Calendar
                Calendar fechaDeclaracionFin = Calendar.getInstance();
                fechaDeclaracionFin.set(Calendar.YEAR, anoDeclarar);
                fechaDeclaracionFin.set(Calendar.MONTH, mesDeclararar);
                fechaDeclaracionFin.set(Calendar.DAY_OF_MONTH, fechaDeclaracionFin.getActualMaximum(Calendar.DAY_OF_MONTH));

                Calendar fechaDeclaracionInicio = Calendar.getInstance();
                fechaDeclaracionInicio.set(Calendar.YEAR, anoDeclarar);
                fechaDeclaracionInicio.set(Calendar.MONTH, mesDeclararar);
                fechaDeclaracionInicio.set(Calendar.DAY_OF_MONTH, 1);

                System.out.println("CONSULTA DE INVENTARIO OPERADOR " + System.currentTimeMillis());
                long startTime = System.currentTimeMillis();

                /*   List<SiiInventario> listaInventarios = new ArrayList<SiiInventario>();
                    listaInventarios =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(),
                                                                                  fechaDeclaracionInicio.getTime(),
                                                                                  fechaDeclaracionFin.getTime());*/

                /*
                    listaElementosAsociadosWSVO =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(), fechaDeclaracionInicio.getTime(), fechaDeclaracionFin.getTime());
                    System.out.println("TIEMPO CONSULTA INVENTARIO " + String.valueOf(System.currentTimeMillis() - startTime));
                    */
                listaResumenNoConectado = resumenNoConetadoDao.buscarResumenPorCodigoCuota(siiCuotaOperadorDE.getCopCodigo());
                

                System.out.println("CONSULTA VENTAS MET CUOTA OPERADOR " + System.currentTimeMillis());
                long inicioVentasMetCuotaOperador = System.currentTimeMillis();
                Calendar fechaInicial = Calendar.getInstance();
                fechaInicial.set(siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo() - 1, 1);
                Calendar fechaFinal = Calendar.getInstance();
                fechaFinal.set(siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo() - 1, fechaInicial.getActualMaximum(Calendar.DAY_OF_MONTH));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String inicial = sdf.format(fechaInicial.getTime());
                String termina = sdf.format(fechaFinal.getTime());
                System.out.println("fecha inicial " + inicial + " fecha final " + termina);
                listaVentasMetCuotaWSVO =
                    cuotaOperadorDao.buscarVentasMetPorCuotaOperador(siiContrato.getConCodigo(), siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), inicial, termina, "P");
                System.out.println("TIEMPO VENTAS MET CUOTA OPERADOR " + String.valueOf(System.currentTimeMillis() - inicioVentasMetCuotaOperador));

                //listaElementoAsociadoWSVO = inventarioDAO.buscarInventarioPorCodigoContratoVigencia(siiCuotaOperadorDE.getCopVigencia(), siiContrato.getConCodigo(), inicial, termina);
                
                System.out.println("CONSULTA MODIFICACION VENTAS MET CUOTA OPERADOR " + System.currentTimeMillis());
                long inicioModificacionVentasMetCuotaOperador = System.currentTimeMillis();
                listaModificacionVentasMetCuotaWSVO =
                    cuotaOperadorDao.buscarVentasMetPorCuotaOperador(siiContrato.getConCodigo(), siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), inicial, termina, "P");
                listaReporteModificacionVentasMetCuotaWSVO =
                cuotaOperadorDao.buscarVentasMetPorCuotaOperador(siiContrato.getConCodigo(), siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), inicial, termina, "M");
                System.out.println("TIEMPO MODIFICACION VENTAS MET CUOTA OPERADOR " + String.valueOf(System.currentTimeMillis() - inicioModificacionVentasMetCuotaOperador));
                
                SiiReporteVentas siiReporteVentasModificado = reporteVentasDao.buscarReporteVentasPorVigenciaMesContratoNitTipo (siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), siiContrato.getConNumero(), siiOperadorPersona.getPerNumIdentificacion(),  "M");
                if (siiReporteVentasModificado != null){
                    for(VentasMetCuotaWSVO misVentasMetCuotaWSVo:listaModificacionVentasMetCuotaWSVO){
                        for (VentasMetCuotaWSVO misReporteVentasMetCuotaWSVo :listaReporteModificacionVentasMetCuotaWSVO){
                        if (misVentasMetCuotaWSVo.getVmeCodigo() != null && misReporteVentasMetCuotaWSVo.getRveCodigo() != null){
                            listaModificaVentasMet = modificaVentasMetDao.buscarModificacionesVentasPorCodigoVentasYRpteVtas(misVentasMetCuotaWSVo.getVmeCodigo(), misReporteVentasMetCuotaWSVo.getRveCodigo());
                                if (listaModificaVentasMet.size() > 0){
                                    if (listaModificaVentasMet.get(0) != null){
                                        misVentasMetCuotaWSVo.setVmeLiqTarifaFija(listaModificaVentasMet.get(0).getMvmLiqTarifaFija());
                                        misVentasMetCuotaWSVo.setVmeLiqTarifaVar(listaModificaVentasMet.get(0).getMvmLiqTarifaVar());
                                        misVentasMetCuotaWSVo.setVmeLiqEfectiva(listaModificaVentasMet.get(0).getMvmLiqEfectiva());
                                        misVentasMetCuotaWSVo.setValorVentasNetas(listaModificaVentasMet.get(0).getMvmValorVentas());
                                    }
                                }
                        }
                        }
                    }
                }else{
                    listaModificacionVentasMetCuotaWSVO.clear();
                }
                
            }

            //}
        }

        //Datos del operador

        declaracionOperadorWSVO.perJurNombreLargo = siiOperadorPersona.getPerJurNombreLargo();
        declaracionOperadorWSVO.perNumIdentificacion = siiOperadorPersona.getPerNumIdentificacion();
        declaracionOperadorWSVO.perTelefono = siiOperadorPersona.getPerTelefono();
        declaracionOperadorWSVO.perEmail = siiOperadorPersona.getPerEmail();
        declaracionOperadorWSVO.tipoIdentificacionEmpresa = siiOperadorPersona.getSiiTipoIdentificacion1().getTidNombre();

        if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.DEPARTAMENTO.getTiuCodigo()) {
            declaracionOperadorWSVO.perDepartamento = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }
        else if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.CIUDAD.getTiuCodigo()) {
            SiiUbicacion siiUbicacionPadre = new SiiUbicacion();
            siiUbicacionPadre = ubicacionDAO.buscarUbicacionPorId(siiOperadorPersona.getSiiUbicacion1().getUbiCodigoPadre());

            declaracionOperadorWSVO.perDepartamento = siiUbicacionPadre.getUbiNombre();
            declaracionOperadorWSVO.perCiudad = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }

        declaracionOperadorWSVO.perDireccion = siiOperadorPersona.getPerDireccion();

        if (siiOperadorPersona.getSiiPersona() != null && siiOperadorPersona.getSiiPersona().getPerCodigo() != null) {

            String representanteLegal = "";

            if (siiOperadorPersona.getSiiPersona().getPerPrimerNombre() != null) {
                representanteLegal += siiOperadorPersona.getSiiPersona().getPerPrimerNombre();
            }

            if (siiOperadorPersona.getSiiPersona().getPerPrimerApellido() != null) {
                representanteLegal += " " + siiOperadorPersona.getSiiPersona().getPerPrimerApellido();
            }

            declaracionOperadorWSVO.representanteLegal = representanteLegal;

            declaracionOperadorWSVO.representanteLegalIdentificacion = siiOperadorPersona.getSiiPersona().getPerNumIdentificacion();
        }

        if (siiRevisorFiscalPersona != null && siiRevisorFiscalPersona.getPerCodigo() != null) {
            declaracionOperadorWSVO.revisorFiscal = siiRevisorFiscalPersona.getPerPrimerNombre() + " " + siiRevisorFiscalPersona.getPerPrimerApellido();
        }

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/NUMERO DELCARACION/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //Consultamos la tabla para saber si es la primera vez que se hace un registro en declaraicon operador sugerida


        List<SiiDeclaracionSugerida> listaDeclaracionSugerida = new ArrayList<SiiDeclaracionSugerida>();
        listaDeclaracionSugerida = declaracionSugeridaDAO.consultaListaSiiDeclaracionSugerida();
        Calendar calendar = Calendar.getInstance();
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();

        if (listaDeclaracionSugerida.size() > 0) {
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            //FIXME Cacosta
            System.out.println("***************************************INICIO DEBUG************************************************");
            
            //siiDeclaracionSugerida.setDsuConsecutivo(listaDeclaracionSugerida.get(0).getDsuConsecutivo() + 1);
            Long l = declaracionSugeridaDAO.buscarConsecutivoDeclaracionSugerida();
            System.out.println("siiDeclaracionSugerida.setDsuConsecutivo:  "+l);
            siiDeclaracionSugerida.setDsuConsecutivo(Integer.valueOf(l.intValue()));
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();


            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            System.out.println("setSiiCuotaOperador GASTOS: "+siiCuotaOperadorGA.getCopCodigo());
            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            System.out.println("---->>>>>> getDsuConsecutivo GASTOS: "+siiDeclaracionSugerida.getDsuConsecutivo());
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            
            
            System.out.println("setSiiCuotaOperador DERECHOS: "+siiCuotaOperadorDE.getCopCodigo());
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            System.out.println("---->>>>>> getDsuConsecutivo DERECHOS: "+siiDeclaracionSugerida.getDsuConsecutivo());
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));
            
            System.out.println("***************************************FIN DEBUG************************************************");
            


            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);

        }
        else {
            //FIXME Cacosta
            System.out.println("***************************************INICIO DEBUG 2 141000001 ************************************************");
            
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            siiDeclaracionSugerida.setDsuConsecutivo(141000001);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);
            
            System.out.println("***************************************FIN DEBUG 2 ************************************************");
        }

        Integer numeroConsecutivo = siiDeclaracionSugerida.getDsuConsecutivo();


        declaracionOperadorWSVO.numeroDeclaracion = numeroConsecutivo;
        declaracionOperadorWSVO.fechaDeclaracion = calendar.getTime();
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/

        BigDecimal liquidacionTarifaFija = new BigDecimal("0");
        BigDecimal liquidacionTarifaVariable = new BigDecimal("0");
        BigDecimal modificacionLiquidacionTarifaVariable = new BigDecimal("0");

        Long elementosTarifaFija = 0L;
        Long elementosTarifaVariable = 0L;
        Long modificacionElementosTarifaVariable = 0L;
        /*
        BigDecimal numeroDiasALiquidar = new BigDecimal(0);
        BigDecimal maximoDiaLiq = new BigDecimal(1);

        List<OficioLiquidacionPrevioVO> miListaInventarioVo = null;

        miListaInventarioVo = liquidacionMesDao.buscarInventarioPorContrato(siiContrato.getConCodigo());        
            DuplaVO miDupla =
                adminLiquidacionMes.calcularDiasALiquidar(anoDeclarar, siiCuotaOperadorDE.getMesCodigo(), miListaInventarioVo.get(0).getFechaInicioLiq(), miListaInventarioVo.get(0).getFechaFinLiq(),
                                                          siiContrato.getConFechaIni(), siiContrato.getConFechaFin());
            if (miDupla != null) {
                numeroDiasALiquidar = miDupla.getValor();
                maximoDiaLiq = new BigDecimal(miDupla.getConcepto());
            }
        */

        for (SiiResumenNoConectado resumenNoConectado : listaResumenNoConectado) {
            ElementoAsociadoWSVO elementoAsociadoWSVO = new ElementoAsociadoWSVO();
            if (resumenNoConectado.getSiiTipoApuesta() != null) {
                elementosTarifaFija = resumenNoConectado.getRncNumElemen().longValue() + elementosTarifaFija;
                liquidacionTarifaFija = resumenNoConectado.getRncValorDe().add(liquidacionTarifaFija);
                elementoAsociadoWSVO.setTipoApuesta(resumenNoConectado.getSiiTipoApuesta().getTapCodigo());
                elementoAsociadoWSVO.setValorDerechosExp(resumenNoConectado.getRncValorDe());
                elementoAsociadoWSVO.setVentasMet(resumenNoConectado.getRncValorTarifa());
                elementoAsociadoWSVO.setNombreApuesta(resumenNoConectado.getSiiTipoApuesta().getTapNombre());
                elementoAsociadoWSVO.setCantidadElemento(resumenNoConectado.getRncNumElemen().longValue());
                listaElementosAsociadosWSVO.add(elementoAsociadoWSVO);

            }
        }
        /*
        for (ElementoAsociadoWSVO elementoAsociadoWSVO : listaElementoAsociadoWSVO){
            elementosTarifaFija = elementoAsociadoWSVO.cantidadElemento + elementosTarifaFija;
            liquidacionTarifaFija = elementoAsociadoWSVO.valorDerechosExp.add(liquidacionTarifaFija);
        }
        */
        /*
        for(ElementoAsociadoWSVO elementosAsociadosWSVo : listaElementosAsociadosWSVO) {
                    elementosAsociadosWSVo.setValorDerechosExp(elementosAsociadosWSVo.getVentasMet().multiply(numeroDiasALiquidar));
                    elementosAsociadosWSVo.setVentasMet(elementosAsociadosWSVo.getVentasMet().multiply(new BigDecimal(31)));
        }

        for(ElementoAsociadoWSVO elementosAsociadosWSVo : listaElementosAsociadosWSVO) {
            elementosTarifaFija = elementosAsociadosWSVo.getCantidadElemento() + elementosTarifaFija;
            liquidacionTarifaFija = elementosAsociadosWSVo.getValorDerechosExp().add(liquidacionTarifaFija);
        }
        */
        for (VentasMetCuotaWSVO ventasMetCuotaWSVo : listaVentasMetCuotaWSVO) {
            elementosTarifaVariable = elementosTarifaVariable + 1;
            if (ventasMetCuotaWSVo.getVmeLiqEfectiva() != null) {
                liquidacionTarifaVariable = ventasMetCuotaWSVo.getVmeLiqEfectiva().add(liquidacionTarifaVariable);
            }
        }

        for (VentasMetCuotaWSVO ventasModificadasMetCuotaWSVo : listaModificacionVentasMetCuotaWSVO) {
            modificacionElementosTarifaVariable = modificacionElementosTarifaVariable + 1;
            if (ventasModificadasMetCuotaWSVo.getVmeLiqEfectiva() != null) {
                modificacionLiquidacionTarifaVariable = ventasModificadasMetCuotaWSVo.getVmeLiqEfectiva().add(modificacionLiquidacionTarifaVariable);
            }
        }

        //Reporte Ventas Met Cuota Operador
        declaracionOperadorWSVO.listaVentasMetCuotaWSVO = listaVentasMetCuotaWSVO;
        //Elementos Asociados
        if (listaElementosAsociadosWSVO != null){
            declaracionOperadorWSVO.listaElementosAsociadosWSVO = listaElementosAsociadosWSVO;
        }
        /*
        if (listaElementoAsociadoWSVO != null){
            declaracionOperadorWSVO.listaElementosAsociadosWSVO = listaElementoAsociadoWSVO;
        }
        */
        //Modificacion Reporte Ventas Met
        declaracionOperadorWSVO.listaModificacionVentasMetCuotaWSVO = listaModificacionVentasMetCuotaWSVO;

        //Ingresos reportados
        declaracionOperadorWSVO.ingresosBrutos = new BigDecimal(0);
        declaracionOperadorWSVO.totalVentas = new BigDecimal(0);

        //Total de elementos
        declaracionOperadorWSVO.numeroTotalElementos = totalElementos;

        //Cupones de pago
        String referenciaPagoDE = "105" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoDE = new Long(referenciaPagoDE);

        String referenciaPagoGA = "205" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoGA = new Long(referenciaPagoGA);

        declaracionOperadorWSVO.numeroContrato = siiContrato.getConNumero();
        declaracionOperadorWSVO.fechaSubscripcion = siiContrato.getConFecha();
        declaracionOperadorWSVO.fechaInicioContrato = siiContrato.getConFechaIni();

        //Periodo declarecion y liquidacion
        declaracionOperadorWSVO.anoOperacion = anoDeclarar;
        declaracionOperadorWSVO.mesOperacion = siiMes.getMesNombre();
        declaracionOperadorWSVO.mesCodigo = siiMes.getMesCodigo();
        declaracionOperadorWSVO.numeroCuota = siiCuotaOperadorDE.getCopNumCuota();
        declaracionOperadorWSVO.pagoOportunoHasta = siiCuotaOperadorDE.getCopFechaLimPag();


        //Liquidación Tarifa Fija y Liquidación Tarifa Variable
        declaracionOperadorWSVO.tarifaFija = Utilidades.redondear(liquidacionTarifaFija, 0);
        declaracionOperadorWSVO.totalElementosTarifaFija = elementosTarifaFija;
        declaracionOperadorWSVO.totalElementosTarifaVariable = elementosTarifaVariable;
        declaracionOperadorWSVO.tarifaVariable = Utilidades.redondear(liquidacionTarifaVariable, 0);
        declaracionOperadorWSVO.totalElementosTarifaVariableModificada = modificacionElementosTarifaVariable;
        declaracionOperadorWSVO.tarifaVariableModificada = Utilidades.redondear(modificacionLiquidacionTarifaVariable, 0);
        return declaracionOperadorWSVO;
    }

    /**
     *Metodo encargado de generar la liquidacion del operador para otro conceptos
     * @author David Tafur
     * @param nit
     * @return
     */
    public LiquidacionOtrosConceptosWSVO generarLiquidacionOtrosConceptos(String nit) throws ExcepcionAplicacion, ExcepcionDAO {

        if (nit == null || nit.equals("")) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el nit.");
        }

        /*
         * Objeto donde se va a almacenar la informacion con la que se le va a responder al web services
        */
        LiquidacionOtrosConceptosWSVO liquidacionOtrosConceptosWSVO = new LiquidacionOtrosConceptosWSVO();
        Calendar calendar = Calendar.getInstance();

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), nit);

        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una persona por ese numero de nit por favor verifique.");
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());
        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una operador por ese nit por favor verifique.");
        }

        //Consultamos el revisor fiscal para el operador
        SiiPersona siiRevisorFiscalPersona = null;
        siiRevisorFiscalPersona = personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(siiOperadorPersona.getPerCodigo(), EnumTipoPersonal.REVISOR_FISCAL.getId());

        //Consultamos el contador para el operador
        SiiPersona siiContador = null;
        siiContador = personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(siiOperadorPersona.getPerCodigo(), EnumTipoPersonal.CONTADOR.getId());


        /*
        * LLENAMOS LOS DATOS DE SALIDA DEL WS
        */

        liquidacionOtrosConceptosWSVO.fechaLiquidacion = calendar.getTime();
        liquidacionOtrosConceptosWSVO.razonSocial = siiOperadorPersona.getPerJurNombreLargo();
        liquidacionOtrosConceptosWSVO.telefonos = siiOperadorPersona.getPerTelefono();
        liquidacionOtrosConceptosWSVO.nit = siiOperadorPersona.getPerNumIdentificacion();
        liquidacionOtrosConceptosWSVO.perEmail = siiOperadorPersona.getPerEmail();
        liquidacionOtrosConceptosWSVO.tipoIdentificacionEmpresa = siiOperadorPersona.getSiiTipoIdentificacion1().getTidNombre();

        if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.DEPARTAMENTO.getTiuCodigo()) {
            liquidacionOtrosConceptosWSVO.departamento = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }
        else if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.CIUDAD.getTiuCodigo()) {
            SiiUbicacion siiUbicacionPadre = new SiiUbicacion();
            siiUbicacionPadre = ubicacionDAO.buscarUbicacionPorId(siiOperadorPersona.getSiiUbicacion1().getUbiCodigoPadre());

            liquidacionOtrosConceptosWSVO.departamento = siiUbicacionPadre.getUbiNombre();
            liquidacionOtrosConceptosWSVO.ciudad = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }

        liquidacionOtrosConceptosWSVO.direccion = siiOperadorPersona.getPerDireccion();
        liquidacionOtrosConceptosWSVO.contador = "";


        if (siiOperadorPersona.getSiiPersona() != null && siiOperadorPersona.getSiiPersona().getPerCodigo() != null) {
            liquidacionOtrosConceptosWSVO.representanteLegal = siiOperadorPersona.getSiiPersona().getPerPrimerNombre() + " " + siiOperadorPersona.getPerPrimerApellido();
        }

        if (siiRevisorFiscalPersona != null && siiRevisorFiscalPersona.getPerCodigo() != null && siiRevisorFiscalPersona.getPerCodigo() > 0) {
            liquidacionOtrosConceptosWSVO.revisorFiscal = siiRevisorFiscalPersona.getPerPrimerNombre() + " " + siiRevisorFiscalPersona.getPerPrimerApellido();
        }

        if (siiContador != null && siiContador.getPerCodigo() != null && siiContador.getPerCodigo() > 0) {
            liquidacionOtrosConceptosWSVO.contador = siiContador.getPerPrimerNombre() + " " + siiContador.getPerPrimerApellido();
        }

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/CUPONES DE PAGO/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //Consultamos la tabla para saber si es la primera vez que se hace un registro en declaracion operador sugerida
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();
        Long nuevoConsecutivo;
        nuevoConsecutivo = declaracionSugeridaDAO.buscarConsecutivoDeclaracionSugerida();
        if (nuevoConsecutivo != null){
            siiDeclaracionSugerida.setDsuConsecutivo(nuevoConsecutivo.intValue());
        }else {
            int inicioConsecutivoVigencia = (calendar.get(Calendar.YEAR) - 2000) * 1000000;
            siiDeclaracionSugerida.setDsuConsecutivo(inicioConsecutivoVigencia + 1);
        }
        /*
        List<SiiDeclaracionSugerida> listaDeclaracionSugerida = new ArrayList<SiiDeclaracionSugerida>();
        listaDeclaracionSugerida = declaracionSugeridaDAO.consultaListaSiiDeclaracionSugerida();
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();

        int inicioConsecutivoVigencia = (calendar.get(Calendar.YEAR) - 2000) * 1000000;

        if (listaDeclaracionSugerida.size() > 0) {
            int ultimoConsecutivo = listaDeclaracionSugerida.get(0).getDsuConsecutivo();
            if (ultimoConsecutivo < inicioConsecutivoVigencia) {
                ultimoConsecutivo = inicioConsecutivoVigencia;
            }
            siiDeclaracionSugerida.setDsuConsecutivo(ultimoConsecutivo + 1);
        }
        else {
            siiDeclaracionSugerida.setDsuConsecutivo(inicioConsecutivoVigencia + 1);
        }
        */
        siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
        declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);

        Integer numeroConsecutivo = siiDeclaracionSugerida.getDsuConsecutivo();

        liquidacionOtrosConceptosWSVO.numeroLiquidacion = numeroConsecutivo.longValue();
        liquidacionOtrosConceptosWSVO.codigoLiquidacionSug = siiDeclaracionSugerida.getDsuCodigo();

        //Cupones de pago
        String referenciaPagoDE = "105" + numeroConsecutivo;
        liquidacionOtrosConceptosWSVO.referenciaPagoDE = new Long(referenciaPagoDE);

        String referenciaPagoGA = "205" + numeroConsecutivo;
        liquidacionOtrosConceptosWSVO.referenciaPagoGA = new Long(referenciaPagoGA);

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN CUPONES PAGO_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        return liquidacionOtrosConceptosWSVO;
    }

    /**
     * @author Giovanni
     * @param idContrato
     * @return
     */
    public ContratoVO buscarContratoPolizaConcesion(Long idContrato) throws ExcepcionDAO {
        SiiContrato siiContrato = new SiiContrato();
        siiContrato = contratoDAO.buscarContratoPorId(idContrato);
        ContratoVO contratoVO = new ContratoVO(siiContrato);

        //Novedad
        List<SiiNovedad> siiNovedads = new ArrayList<SiiNovedad>();
        siiNovedads = novedadDAO.buscarNovedadesPorIdContrato(idContrato, false);

        contratoVO.setNovedadVoList(new ArrayList<NovedadVO>());
        for (SiiNovedad siiNovedad : siiNovedads) {
            if (siiNovedad.getSiiOtrosi() == null) {
                if (siiNovedad.getSiiSolicitudAutoriza() != null) {
                    NovedadVO novedadVO = new NovedadVO(siiNovedad);

                    //Oficio Liquidacion
                    List<SiiOficioLiquidacion> siiOficioLiquidacions = new ArrayList<SiiOficioLiquidacion>();
                    siiOficioLiquidacions = oficioLiquidacionDAO.buscarOficioLiquidacionPorSolicitudAutorizacion(novedadVO.getSolicitudAutorizaVO().getSauCodigo());

                    novedadVO.getSolicitudAutorizaVO().setOficioLiquidacionListVo(new ArrayList<OficioLiquidacionVO>());
                    OficioLiquidacionVO oficioLiquidacionVO = new OficioLiquidacionVO() ;

                    if (siiOficioLiquidacions.size()>0) {
                        oficioLiquidacionVO = new OficioLiquidacionVO(siiOficioLiquidacions.get(siiOficioLiquidacions.size() - 1));
                    }

                    //oficio liquidacion tipo apuesta
                    List<SiiOficLiqTipoApuesta> siiOficLiqTipoApuestas = new ArrayList<SiiOficLiqTipoApuesta>();
                    siiOficLiqTipoApuestas = oficLiqTipoApuestaDAO.buscarSiiOficLiqTipoApuestaPorOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());

                    oficioLiquidacionVO.setOficLiqTipoApuestaListVo(new ArrayList<OficLiqTipoApuestaVO>());
                    for (SiiOficLiqTipoApuesta siiOficLiqTipoApuesta : siiOficLiqTipoApuestas) {
                        OficLiqTipoApuestaVO oficLiqTipoApuestaVO = new OficLiqTipoApuestaVO(siiOficLiqTipoApuesta);
                        oficioLiquidacionVO.getOficLiqTipoApuestaListVo().add(oficLiqTipoApuestaVO);
                    }

                    /*
                     * Buscamos los amparos de oficio liquidacion para ayudar a diligenciar la poliza de contrato
                     */
                    List<SiiGarantPolizaOficLiq> siiGarantPolizaOficLiqs = null;
                    siiGarantPolizaOficLiqs = garantPolizaOficLiqDAO.consultarGarantPolizaOficLiqXOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());

                    oficioLiquidacionVO.setGarantPolizaOficLiqVOs(new ArrayList<GarantPolizaOficLiqVO>());
                    if (siiGarantPolizaOficLiqs != null) {
                        for (SiiGarantPolizaOficLiq siiGarantPolizaOficLiq : siiGarantPolizaOficLiqs) {
                            GarantPolizaOficLiqVO garantPolizaOficLiqVO = new GarantPolizaOficLiqVO(siiGarantPolizaOficLiq);
                            oficioLiquidacionVO.getGarantPolizaOficLiqVOs().add(garantPolizaOficLiqVO);
                        }
                    }
                    novedadVO.getSolicitudAutorizaVO().getOficioLiquidacionListVo().add(oficioLiquidacionVO);

                    //Resolucion de autorizacion
                    List<SiiResolucionAutoriz> siiResolucionAutorizs = new ArrayList<SiiResolucionAutoriz>();
                    siiResolucionAutorizs = resolucionAutorizDAO.buscarResolucionAutorizPorSolicitudAutoriza(novedadVO.getSolicitudAutorizaVO().getSauCodigo());

                    novedadVO.getSolicitudAutorizaVO().setResolucionAutorizListVo(new ArrayList<ResolucionAutorizVO>());
                    for (SiiResolucionAutoriz siiResolucionAutoriz : siiResolucionAutorizs) {
                        ResolucionAutorizVO resolucionAutorizVO = new ResolucionAutorizVO(siiResolucionAutoriz);
                        novedadVO.getSolicitudAutorizaVO().getResolucionAutorizListVo().add(resolucionAutorizVO);
                    }
                    contratoVO.getNovedadVoList().add(novedadVO);
                }
            }
        }

        /*
         * Buscamos los instrumentos para ese contrato operador
         */
        contratoVO.getOperadorVo().setInstrumentoVoList(new ArrayList<InstrumentoVO>());
        List<SiiInstrumento> siiInstrumentos = null;
        siiInstrumentos = instrumentoDAO.consultarInstrumentosXOperador(contratoVO.getOperadorVo().getOpeCodigo());

        if (siiInstrumentos != null) {
            for (SiiInstrumento siiInstrumento : siiInstrumentos) {
                InstrumentoVO instrumentoVO = new InstrumentoVO(siiInstrumento);
                contratoVO.getOperadorVo().getInstrumentoVoList().add(instrumentoVO);
            }
        }

        return contratoVO;
    }
    
    
    public ContratoVO buscarContratoPolizaConcesionRenovacion(Long idContrato) throws ExcepcionDAO {
        Calendar calHoy = Calendar.getInstance();
        Integer vigenciaActual = calHoy.get(Calendar.YEAR);
        SiiContrato siiContrato = contratoDAO.buscarContratoPorId(idContrato);
        ContratoVO contratoVO = new ContratoVO(siiContrato);
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strFechaHoy = formatter.format(new Date());

        /*
         * Buscamos los instrumentos para ese contrato operador
         */
        List<ElementoAsociadoWSVO> listaElementosWsVo = inventarioDAO.buscarInventarioPorCodigoContratoVigencia(vigenciaActual, idContrato, strFechaHoy, strFechaHoy);
        List<ElementoAsociadoVO> listaElementoAsociadoVo = new ArrayList<>();
        for(ElementoAsociadoWSVO unElementoWsVo : listaElementosWsVo){
            ElementoAsociadoVO unElementoAsociadoVo = new ElementoAsociadoVO();
            unElementoAsociadoVo.setCantidadElemento(unElementoWsVo.getCantidadElemento());
            unElementoAsociadoVo.setNombreApuesta(unElementoWsVo.getNombreApuesta());
            unElementoAsociadoVo.setValorDerechosExp(unElementoWsVo.getValorDerechosExp().setScale(0, BigDecimal.ROUND_HALF_UP));
            //unElementoAsociadoVo.setValorGastosAdm(unElementoWsVo.getValorDerechosExp().divide(new BigDecimal(100),0,BigDecimal.ROUND_HALF_UP));
            unElementoAsociadoVo.setCantidadElemento(unElementoWsVo.getCantidadElemento());
            unElementoAsociadoVo.setTipoApuesta(unElementoWsVo.getTipoApuesta());
            listaElementoAsociadoVo.add(unElementoAsociadoVo);
        }
        contratoVO.setListaElementoAsociadoVo(listaElementoAsociadoVo);
        
        //Buscamos la fecha de la última liquidación
        SiiLiquidacionMes siiLiquidacionMes = liquidacionMesDao.buscarUltimaLiquidacionMesPorContrato(contratoVO.getConCodigo());
        if(siiLiquidacionMes != null){
            contratoVO.setFechaUltimaLiquidacion(siiLiquidacionMes.getLiqFecha());
        }
        
        return contratoVO;
    }

    public void actualizarSiiDeclaracionOperador(SiiDeclaracionSugerida siiDeclaracionSugerida) throws ExcepcionDAO {
        declaracionSugeridaDAO.actualizarSiiDeclaracionSugerida(siiDeclaracionSugerida);
    }

    public DeclaracionSugeridaVO buscarDeclaracionSugeridaPorId(Long idDeclaracionSugerida) throws ExcepcionDAO {
        return new DeclaracionSugeridaVO(declaracionSugeridaDAO.buscarDeclaracionSugeridaPorId(idDeclaracionSugerida));
    }

    /**
     * @author Modifica Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ContratoVO> buscarTodoSiiContrato() throws ExcepcionDAO {
        List<ContratoVO> contratosVOs = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarTodoSiiContrato();
        for (SiiContrato contrato : contratos) {
            ContratoVO contratoVO = new ContratoVO(contrato);
            contratosVOs.add(contratoVO);
        }
        return contratosVOs;
    }

    public List<ContratoVO> buscarContratosDesdePerfeccionados() throws ExcepcionDAO {
        List<ContratoVO> contratosVOs = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosDesdePerfeccionados();
        for (SiiContrato contrato : contratos) {
            ContratoVO contratoVO = new ContratoVO(contrato);
            contratosVOs.add(contratoVO);
        }
        return contratosVOs;
    }

    @Override
    public ContratoVO buscarContratoPorNumero(String conNumero) throws ExcepcionDAO {
        ContratoVO resultado = null;
        SiiContrato siiContrato = contratoDAO.buscarContratoPorNumero(conNumero);
        if (siiContrato != null)
            resultado = new ContratoVO(siiContrato);

        return (resultado);
    }

    /**
     * @author Giovanni
     * @param conCodigo
     * @throws ExcepcionDAO
     * @return
     */
    public ReporteContratoConcesionVO reporteContratoConcesion(Long conCodigo) throws ExcepcionDAO {
        ReporteContratoConcesionVO reporteContratoConcesionVO = new ReporteContratoConcesionVO();

        SiiContrato siiContrato = null;
        siiContrato = contratoDAO.buscarContratoPorId(conCodigo);

        if (siiContrato != null) {

            //Informacion Operador
            //Nombre operador
            reporteContratoConcesionVO.setNombre_operador(siiContrato.getSiiOperador().getSiiPersona().getPerJurNombreLargo());
            //Correo electronico
            reporteContratoConcesionVO.setCorreo_electronico(siiContrato.getSiiOperador().getSiiPersona().getPerEmail());
            //Nit
            reporteContratoConcesionVO.setNit(siiContrato.getSiiOperador().getSiiPersona().getPerNumIdentificacion());
            //Ciudad domicilio
            reporteContratoConcesionVO.setCiudad(siiContrato.getSiiOperador().getSiiPersona().getSiiUbicacion1().getUbiNombre());
            //Departamento
            SiiUbicacion siiUbicacion = null;
            siiUbicacion = ubicacionDAO.buscarUbicacionPorId(siiContrato.getSiiOperador().getSiiPersona().getSiiUbicacion1().getUbiCodigoPadre());
            reporteContratoConcesionVO.setDepartamento(siiUbicacion.getUbiNombre());
            //Direccion operador
            reporteContratoConcesionVO.setDireccion(siiContrato.getSiiOperador().getSiiPersona().getPerDireccion());
            //Codigo DANE
            reporteContratoConcesionVO.setCodigo_DANE(siiContrato.getSiiOperador().getSiiPersona().getSiiUbicacion1().getUbiCodigo());
            //Telefonos operador
            reporteContratoConcesionVO.setTelefonos(siiContrato.getSiiOperador().getSiiPersona().getPerTelefono());

            //Informacion Contrato
            //No. Contrato
            reporteContratoConcesionVO.setNum_contrato(siiContrato.getConNumero());
            //Fecha suscripcion
            reporteContratoConcesionVO.setFecha_Suscripcion(siiContrato.getConFecha());
            //Fecha inicio Ejecucion
            reporteContratoConcesionVO.setFecha_Inicio_Ejecucion(siiContrato.getConFechaIni());
            //Fecha finalizacion
            reporteContratoConcesionVO.setFecha_finalizacion(siiContrato.getConFechaFin());

            /*
             * Numero de establecimientos
             */
            reporteContratoConcesionVO.setNum_Establecimientos(establecimientoDAO.numeroEstablecimientosPorContrato(conCodigo));

            //Numero met
            reporteContratoConcesionVO.setMETs(inventarioDAO.cantidadElementosPorContratoPorTipoInstrumento(conCodigo, "MET"));

            //Numero Sillas bingo
            reporteContratoConcesionVO.setSILLAS(inventarioDAO.cantidadElementosPorContratoPorTipoInstrumento(conCodigo, "BINGO"));

            //Numero Mesa Casino
            reporteContratoConcesionVO.setMESAS(inventarioDAO.cantidadElementosPorContratoPorTipoInstrumento(conCodigo, "MESA DE CASINO"));
            //Numero Terminal ACDV

            reporteContratoConcesionVO.setTERMINALES(inventarioDAO.cantidadElementosPorContratoPorTipoInstrumento(conCodigo, "ACDV"));

            //Numero de elementos
            reporteContratoConcesionVO.setNum_Elementos(reporteContratoConcesionVO.getMETs() + reporteContratoConcesionVO.getSILLAS() + reporteContratoConcesionVO.getMESAS() +
                                                        reporteContratoConcesionVO.getTERMINALES());

            //poliza contrato
            SiiPolizaContrat siiPolizaContrat = null;
            siiPolizaContrat = polizaContratDAO.consultarPolizaXOperadorYEstado(siiContrato.getSiiOperador().getSiiPersona().getPerNumIdentificacion(), 2);

            if (siiPolizaContrat != null && siiPolizaContrat.getPccCodigo() != null) {

                //Numero de la poliza
                reporteContratoConcesionVO.setNumero_Poliza(siiPolizaContrat.getPccNumero());
                //Aseguradora
                reporteContratoConcesionVO.setAseguradora(siiPolizaContrat.getSiiAseguradora().getSiiPersona().getPerJurNombreLargo());
                //Fecha Aprobacion
                reporteContratoConcesionVO.setFecha_Aprobacion_Poliza(siiPolizaContrat.getPccFechaAprobac());

                //Garantias poliza
                List<SiiGarantiaPoliza> siiGarantiaPolizas = null;
                siiGarantiaPolizas = garantiaPolizaDAO.buscarGarantiaPolizaPorPolizaContrat(siiPolizaContrat.getPccCodigo());

                if (siiGarantiaPolizas != null) {

                    for (SiiGarantiaPoliza siiGarantiaPoliza : siiGarantiaPolizas) {
                        // Amparo de cumplimiento
                        if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(1L)) {
                            // Valor
                            reporteContratoConcesionVO.setValor_amparo_Cumplimiento(siiGarantiaPoliza.getGpoMontoValor());
                            // Vigencia Inicial
                            reporteContratoConcesionVO.setAmparo_Cumplimiento(siiGarantiaPoliza.getGpoVigenciaDesde());
                            // Vigencia Final
                            reporteContratoConcesionVO.setAmparo_Cumplimiento_Fin(siiGarantiaPoliza.getGpoVigenciaHasta());
                        }
                        // Amparo de premios
                        if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(3L)) {
                            // Valor
                            reporteContratoConcesionVO.setValor_amparo_Premios(siiGarantiaPoliza.getGpoMontoValor());
                            // Vigencia Inicial
                            reporteContratoConcesionVO.setAmparo_Premios(siiGarantiaPoliza.getGpoVigenciaDesde());
                            // Vigencia Final
                            reporteContratoConcesionVO.setAmparo_Premios_Fin(siiGarantiaPoliza.getGpoVigenciaHasta());
                        }
                        //Amparo de salarios y Prestaiones Sociales
                        if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(2L)) {
                            // Valor
                            reporteContratoConcesionVO.setValor_amparo_Sal_Pres_Soci(siiGarantiaPoliza.getGpoMontoValor());
                            // Vigencia Inicial
                            reporteContratoConcesionVO.setAmparo_Sal_Pres_Soci(siiGarantiaPoliza.getGpoVigenciaDesde());
                            // Vigencia Final
                            reporteContratoConcesionVO.setAmparo_Sal_Pres_Soci_Fin(siiGarantiaPoliza.getGpoVigenciaHasta());
                        }
                    }
                }

            }

            //Modificaciones
            List<SiiNovedad> siiNovedads = null;
            siiNovedads = novedadDAO.buscarNovedadesPorIdContrato(siiContrato.getConCodigo(), false);
            if (siiNovedads != null && siiNovedads.size() > 0 && !siiNovedads.isEmpty()) {
                //Oficio Liquidacion
                List<SiiOficioLiquidacion> siiOficioLiquidacions = new ArrayList<SiiOficioLiquidacion>();
                if (siiNovedads.get(0).getSiiSolicitudAutoriza() != null) {
                    siiOficioLiquidacions = oficioLiquidacionDAO.buscarOficioLiquidacionPorSolicitudAutorizacion(siiNovedads.get(0).getSiiSolicitudAutoriza().getSauCodigo());

                    reporteContratoConcesionVO.setValor_Contrato(new BigDecimal(siiOficioLiquidacions.get(0).getOliValorDerExpl().doubleValue() +
                                                                                siiOficioLiquidacions.get(0).getOliValorGastAdm().doubleValue()));

                }


                for (SiiNovedad siiNovedad : siiNovedads) {
                    if (siiNovedad.getSiiOtrosi() != null) {
                        ModReporteContratoConcesionVO modReporteContratoConcesionVO = new ModReporteContratoConcesionVO();

                        //poliza contrato
                        SiiPolizaContrat siiPolizaContratOS = null;
                        siiPolizaContratOS =
                            polizaContratDAO.consultarPolizaOtroSiXOperadorYEstado(siiContrato.getSiiOperador().getSiiPersona().getPerNumIdentificacion(), 2, siiNovedad.getSiiOtrosi().getOsiCodigo());

                        if (siiPolizaContratOS != null && siiPolizaContratOS.getPccCodigo() != null) {

                            //Numero de la poliza
                            modReporteContratoConcesionVO.setNumero_Poliza(siiPolizaContratOS.getPccNumero());
                            //Aseguradora
                            modReporteContratoConcesionVO.setAseguradora(siiPolizaContratOS.getSiiAseguradora().getSiiPersona().getPerJurNombreLargo());
                            //Fecha Aprobacion
                            modReporteContratoConcesionVO.setFecha_aprobacion_Poliza(siiPolizaContratOS.getPccFechaRecep());

                            //Garantias poliza
                            List<SiiGarantiaPoliza> siiGarantiaPolizas = null;
                            siiGarantiaPolizas = garantiaPolizaDAO.buscarGarantiaPolizaPorPolizaContrat(siiPolizaContratOS.getPccCodigo());

                            if (siiGarantiaPolizas != null) {

                                for (SiiGarantiaPoliza siiGarantiaPoliza :
                                     siiGarantiaPolizas) {
                                    // Amparo de cumplimiento
                                    if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(1L)) {
                                        // Valor
                                        modReporteContratoConcesionVO.setValor_amparo_Cumplimiento(siiGarantiaPoliza.getGpoMontoValor());
                                        // Vigencia
                                        modReporteContratoConcesionVO.setAmparo_Cumplimiento(String.valueOf((siiGarantiaPoliza.getGpoVigenciaDesde().getTime() -
                                                                                                             siiGarantiaPoliza.getGpoVigenciaHasta().getTime()) / MILLSECS_PER_DAY));
                                        // Amparo de premios
                                    }
                                    if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(2L)) {
                                        // Valor
                                        modReporteContratoConcesionVO.setValor_amparo_Premios(siiGarantiaPoliza.getGpoMontoValor());
                                        // Vigencia
                                        modReporteContratoConcesionVO.setAmparo_Premios(String.valueOf((siiGarantiaPoliza.getGpoVigenciaDesde().getTime() -
                                                                                                        siiGarantiaPoliza.getGpoVigenciaHasta().getTime()) / MILLSECS_PER_DAY));
                                    }
                                    //Amparo de salarios y Prestaiones Sociales
                                    if (siiGarantiaPoliza.getSiiGarantiaExigida().getGexCodigo().equals(3L)) {
                                        // Valor
                                        modReporteContratoConcesionVO.setValor_amparo_Salarios_Prestaciones_Sociales(siiGarantiaPoliza.getGpoMontoValor());
                                        // Vigencia
                                        modReporteContratoConcesionVO.setAmparo_Salarios_Prestaciones_Sociales(String.valueOf((siiGarantiaPoliza.getGpoVigenciaDesde().getTime() -
                                                                                                                               siiGarantiaPoliza.getGpoVigenciaHasta().getTime()) / MILLSECS_PER_DAY));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return reporteContratoConcesionVO;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<ContratoVO> contratosVigentesSinPolizasPendientes() throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.contratosVigentesSinPolizasPendientes();
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;

    }
    
    public List<ContratoVO> buscarContratosVigentes(String vigente) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosVigentes(vigente);
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;

    }
    

    public List<ContratoVO> buscarContratosVigentesOrdenDesc() throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosVigentesOrdenDesc();
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }
        return contratosVO;
    }


    public BigDecimal calculoValorXEjecutarContratoConc(Long conCodigo) throws ExcepcionDAO {
        BigDecimal valorContratoConcesion = new BigDecimal(0);
        List<OficioLiquidacionPrevioVO> oficioLiquidacionPrevioVOs;
        oficioLiquidacionPrevioVOs = liquidacionMesDao.buscarInventarioPorContratoMES(conCodigo);


        /*
         * Buscamos el ultimo mes liquidado para este contrato
         */
        SiiLiquidacionMes siiLiquidacionMes = null;


        BigDecimal DET = new BigDecimal(0);
        BigDecimal DE = new BigDecimal(0);
        //Fecha Definitiva Fin Liquidacion
        Calendar fechaFinDefinLiqui = Calendar.getInstance();
        //Fecha Fin Liquidacion
        Calendar fechaFinLiqui = Calendar.getInstance();
        //hoy
        Date hoy = new Date();
        Calendar fechaIni = liquidacionMesDao.obtenerUltimoMesLiquidado(conCodigo);

        if (oficioLiquidacionPrevioVOs != null && !oficioLiquidacionPrevioVOs.isEmpty()) {
            for (OficioLiquidacionPrevioVO oficioLiquidacionPrevioVO : oficioLiquidacionPrevioVOs) {

                //Meses
                double meses = 0;

                //Resetear las variables para el nuevo elemento
                DE = new BigDecimal(0);

                fechaFinLiqui.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());

                if (oficioLiquidacionPrevioVO.getFechaFinDefinitiva() != null) {
                    fechaFinDefinLiqui.setTime(oficioLiquidacionPrevioVO.getFechaFinDefinitiva());
                    fechaFinLiqui = (fechaFinLiqui.before(fechaFinDefinLiqui))? fechaFinDefinLiqui : fechaFinLiqui;
                }

                //calcular numero de meses
                meses = calcularMeses((GregorianCalendar) fechaFinLiqui, (GregorianCalendar) fechaIni);

                int dias = fechaFinLiqui.get(Calendar.DAY_OF_MONTH);

                meses = Math.rint(((meses * 30 + dias) / 30) * 100) / 100;

                /*
                 * Verificamos que los meses sean mayor a 0
                 */
                if (meses > 0) {

                    /*
                     * Derechos de explotacion (DE)
                     */

                    //Maquinas Tragamonedas
                    if (Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 1 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 3) {
                        DE = new BigDecimal(oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue());

                    }

                    //Salones de Bingo
                    if (Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 6 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 15) {

                        /*if (oficioLiquidacionPrevioVO.getInventarioSillas().intValue() <
                            oficioLiquidacionPrevioVO.getMinimoSillas()) {
                            DE =
                                (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue()) *
                                oficioLiquidacionPrevioVO.getMinimoSillas();
                        }

                        if (oficioLiquidacionPrevioVO.getInventarioSillas().intValue() >=
                            oficioLiquidacionPrevioVO.getMinimoSillas()) {
                            DE =
                                (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue()) *
                                oficioLiquidacionPrevioVO.getInventarioSillas().intValue();
                        }*/
                        DE = new BigDecimal((oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue()) * oficioLiquidacionPrevioVO.getInventarioSillas());

                    }

                    //Juegos de Casino y otros
                    if (Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 4 || Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 5) {
                        DE = new BigDecimal(oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue());
                    }

                    /*
                     * Gastos de administracio (GA)
                     */
                    DE = Utilidades.redondear(DE, 0);
                    DE = DE.multiply(new BigDecimal(meses));
                    DET = DET.add(DE);

                }

            }
        }

        /*
         * Valor a pagar
         */
        valorContratoConcesion = Utilidades.redondear(DET.add(DET.multiply(new BigDecimal(0.01))), 0);

        return valorContratoConcesion;
    }

    public int calcularMeses(GregorianCalendar g1, GregorianCalendar g2) {
        int elapsed = -1; // Por defecto estaba en 0 y siempre asi no haya pasado un mes contaba 1)
        GregorianCalendar gc1, gc2;
        Date d1, d2;

        if (g2.after(g1)) {
            gc2 = (GregorianCalendar) g2.clone();
            gc1 = (GregorianCalendar) g1.clone();
        }
        else {
            gc2 = (GregorianCalendar) g1.clone();
            gc1 = (GregorianCalendar) g2.clone();
        }

        while (gc1.before(gc2)) {
            gc1.add(Calendar.MONTH, 1);
            elapsed++;
        }

        if (gc1.get(Calendar.DATE) == (gc2.get(Calendar.DATE)))
            elapsed++; // si es el mismo dia cuenta para la suma de meses
        return elapsed;
    }

    /*
     * @author Giovanni
     * @param conCodigo
     * @return
     * @throws ExcepcionDAO
     */
    /*
    public BigDecimal calculoValorXEjecutarContratoConcesion(Long conCodigo) throws ExcepcionDAO {
        BigDecimal valorContratoConcesion = null;
        List<OficioLiquidacionPrevioVO> oficioLiquidacionPrevioVOs;
        oficioLiquidacionPrevioVOs = liquidacionMesDao.buscarInventarioPorContrato(conCodigo);

        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día

        // Buscamos el ultimo mes liquidado para este contrato
        SiiLiquidacionMes siiLiquidacionMes = null;
        siiLiquidacionMes = liquidacionMesDao.ultimoMesContratoLiquidado(conCodigo);

        Date fechaMesALiquidar = new Date();
        Calendar fechaMesALiquidarTemp = Calendar.getInstance();

        if(siiLiquidacionMes != null) {

            fechaMesALiquidarTemp.set(Calendar.DATE, 01);
            fechaMesALiquidarTemp.set(Calendar.MONTH, siiLiquidacionMes.getSiiMes().getMesCodigo() + 1);

            fechaMesALiquidar = fechaMesALiquidarTemp.getTime();
        }

        double DET = 0;
        double GAT = 0;
        double DE = 0;
        double GA = 0;

        if(oficioLiquidacionPrevioVOs != null && !oficioLiquidacionPrevioVOs.isEmpty()) {
            for(OficioLiquidacionPrevioVO oficioLiquidacionPrevioVO : oficioLiquidacionPrevioVOs) {

                //Meses
                int meses = 0;

                //Dias
                long diasInicio = 0;
                long diasFin = 0;

                //Acomulado DE y GA
                DET += DE;
                GAT += GA;

                //Resetear las variables para el nuevo elemento
                DE = 0;
                GA = 0;

                //Fecha incio Liquidacion
                Calendar fechaInicioLiqui = Calendar.getInstance();
                fechaInicioLiqui.setTime(oficioLiquidacionPrevioVO.getFechaInicioLiq());

                //Fecha Fin Liquidacion
                Calendar fechaFinLiqui = Calendar.getInstance();
                fechaFinLiqui.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());

                // Si la fecha de inicio es anterior al mes ultimo liquidado
                if(oficioLiquidacionPrevioVO.getFechaInicioLiq().before(fechaMesALiquidar)) {
                    meses = fechaInicioLiqui.get(Calendar.YEAR) - fechaMesALiquidarTemp.get(Calendar.YEAR);
                    meses = meses * -2;

                    //Dias Fin
                    Calendar fechaDiasMes = Calendar.getInstance();
                    fechaDiasMes.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());
                    fechaDiasMes.set(Calendar.DATE, 01);

                    Date datefechaDiasMes = new Date();
                    datefechaDiasMes = fechaDiasMes.getTime();

                    diasFin = (datefechaDiasMes.getTime() - oficioLiquidacionPrevioVO.getFechaFinLiq().getTime()) / MILLSECS_PER_DAY;

                }

                //Si la fecha de inicio esta dentro al mes ultimo liquidado
                if(fechaInicioLiqui.get(Calendar.MONTH) == fechaMesALiquidarTemp.get(Calendar.MONTH)) {
                    meses = fechaInicioLiqui.get(Calendar.YEAR) - fechaFinLiqui.get(Calendar.YEAR);
                    meses = meses * -3;

                    //Dias Inicio
                    Calendar fechaDiasMesI = Calendar.getInstance();
                    fechaDiasMesI.setTime(oficioLiquidacionPrevioVO.getFechaInicioLiq());
                    fechaDiasMesI.set(Calendar.DATE, 01);

                    Date datefechaDiasMesI = new Date();
                    datefechaDiasMesI = fechaDiasMesI.getTime();

                    diasInicio = (datefechaDiasMesI.getTime() - oficioLiquidacionPrevioVO.getFechaInicioLiq().getTime()) / MILLSECS_PER_DAY;


                    //Dias Fin
                    Calendar fechaDiasMes = Calendar.getInstance();
                    fechaDiasMes.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());
                    fechaDiasMes.set(Calendar.DATE, 01);

                    Date datefechaDiasMes = new Date();
                    datefechaDiasMes = fechaDiasMes.getTime();

                    diasFin = (datefechaDiasMes.getTime() - oficioLiquidacionPrevioVO.getFechaFinLiq().getTime()) / MILLSECS_PER_DAY;
                }

                // Verificamos que los meses sean mayor a 0
                if(meses > 0) {

                    // Derechos de explotacion (DE)
                    double diasDEI = 0;
                    double diasDEF = 0;
                    boolean ingresoDias = false;

                    //Maquinas Tragamonedas
                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 1 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 3) {
                        DE = meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30;


                        // Verificamos los dias
                        if(diasInicio > 0) {
                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(diasFin > 0) {
                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(ingresoDias) {
                            DE = DE + diasDEI + diasDEF;
                        }
                    }

                    //Salones de Bingo
                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 6 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 15) {

                        if(oficioLiquidacionPrevioVO.getInventarioSillas().intValue() < oficioLiquidacionPrevioVO.getMinimoSillas()) {
                            DE = (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30) * oficioLiquidacionPrevioVO.getMinimoSillas();
                        }

                        if(oficioLiquidacionPrevioVO.getInventarioSillas().intValue() >= oficioLiquidacionPrevioVO.getMinimoSillas()) {
                            DE = (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30) * oficioLiquidacionPrevioVO.getInventarioSillas().intValue();
                        }



                        // Verificamos los dias

                        if(diasInicio > 0) {
                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(diasFin > 0) {
                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(ingresoDias) {
                            DE = DE + diasDEI + diasDEF;
                        }
                    }

                    //Juegos de Casino y otros
                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 4 || Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 5) {
                        DE = meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30;


                        // Verificamos los dias

                        if(diasInicio > 0) {
                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(diasFin > 0) {
                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
                            ingresoDias = true;
                        }

                        if(ingresoDias) {
                            DE = DE + diasDEI + diasDEF;
                        }
                    }


                    // Gastos de administracion (GA)


                    GA = DE * (0.01);
                }

            }
        }

        // Valor a pagar
        valorContratoConcesion = Utilidades.redondear(new BigDecimal(DET + GAT), 0);

        return valorContratoConcesion;
    }
    */


    /**
     * @author Giovanni
     * @param conCodigo
     * @return
     * @throws ExcepcionDAO
     */
    //    public BigDecimal calculoValorContratoConcesion(Long conCodigo) throws ExcepcionDAO {
    //        BigDecimal valorContratoConcesion = null;
    //        List<OficioLiquidacionPrevioVO> oficioLiquidacionPrevioVOs;
    //        oficioLiquidacionPrevioVOs = liquidacionMesDao.buscarInventarioPorContrato(conCodigo);
    //
    //        final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día
    //
    //        /*
    //         * Buscamos el ultimo mes liquidado para este contrato
    //         */
    //        SiiLiquidacionMes siiLiquidacionMes = null;
    //        siiLiquidacionMes = liquidacionMesDao.ultimoMesContratoLiquidado(conCodigo);
    //
    //        Date fechaMesALiquidar = new Date();
    //        Calendar fechaMesALiquidarTemp = Calendar.getInstance();
    //
    //        if(siiLiquidacionMes != null) {
    //
    //            fechaMesALiquidarTemp.set(Calendar.DATE, 01);
    //            fechaMesALiquidarTemp.set(Calendar.MONTH, siiLiquidacionMes.getSiiMes().getMesCodigo() + 1);
    //
    //            fechaMesALiquidar = fechaMesALiquidarTemp.getTime();
    //        }
    //
    //        /*
    //         * Buscamos el valor final liquidado
    //         */
    //        BigDecimal TOT_CTO1 = null;
    //        TOT_CTO1 = cuotaOperadorDao.buscarTotalLiquidacioCuotaOperadorXContrato(conCodigo);
    //
    //        if(TOT_CTO1 == null) {
    //            TOT_CTO1 = new BigDecimal(0);
    //        }
    //
    //        double DET = 0;
    //        double GAT = 0;
    //        double DE = 0;
    //        double GA = 0;
    //
    //        if(oficioLiquidacionPrevioVOs != null && !oficioLiquidacionPrevioVOs.isEmpty()) {
    //            for(OficioLiquidacionPrevioVO oficioLiquidacionPrevioVO : oficioLiquidacionPrevioVOs) {
    //
    //                //Meses
    //                int meses = 0;
    //
    //                //Dias
    //                long diasInicio = 0;
    //                long diasFin = 0;
    //
    //                //Acomulado DE y GA
    //                DET += DE;
    //                GAT += GA;
    //
    //                //Resetear las variables para el nuevo elemento
    //                DE = 0;
    //                GA = 0;
    //
    //                //Fecha incio Liquidacion
    //                Calendar fechaInicioLiqui = Calendar.getInstance();
    //                fechaInicioLiqui.setTime(oficioLiquidacionPrevioVO.getFechaInicioLiq());
    //
    //                //Fecha Fin Liquidacion
    //                Calendar fechaFinLiqui = Calendar.getInstance();
    //                fechaFinLiqui.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());
    //
    //                // Si la fecha de inicio es anterior al mes ultimo liquidado
    //                if(oficioLiquidacionPrevioVO.getFechaInicioLiq().before(fechaMesALiquidar)) {
    //                    meses = fechaInicioLiqui.get(Calendar.YEAR) - fechaMesALiquidarTemp.get(Calendar.YEAR);
    //                    meses = meses * -2;
    //
    //                    //Dias Fin
    //                    Calendar fechaDiasMes = Calendar.getInstance();
    //                    fechaDiasMes.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());
    //                    fechaDiasMes.set(Calendar.DATE, 01);
    //
    //                    Date datefechaDiasMes = new Date();
    //                    datefechaDiasMes = fechaDiasMes.getTime();
    //
    //                    diasFin = (datefechaDiasMes.getTime() - oficioLiquidacionPrevioVO.getFechaFinLiq().getTime()) / MILLSECS_PER_DAY;
    //
    //                }
    //
    //                //Si la fecha de inicio esta dentro al mes ultimo liquidado
    //                if(fechaInicioLiqui.get(Calendar.MONTH) == fechaMesALiquidarTemp.get(Calendar.MONTH)) {
    //                    meses = fechaInicioLiqui.get(Calendar.YEAR) - fechaFinLiqui.get(Calendar.YEAR);
    //                    meses = meses * -3;
    //
    //                    //Dias Inicio
    //                    Calendar fechaDiasMesI = Calendar.getInstance();
    //                    fechaDiasMesI.setTime(oficioLiquidacionPrevioVO.getFechaInicioLiq());
    //                    fechaDiasMesI.set(Calendar.DATE, 01);
    //
    //                    Date datefechaDiasMesI = new Date();
    //                    datefechaDiasMesI = fechaDiasMesI.getTime();
    //
    //                    diasInicio = (datefechaDiasMesI.getTime() - oficioLiquidacionPrevioVO.getFechaInicioLiq().getTime()) / MILLSECS_PER_DAY;
    //
    //
    //                    //Dias Fin
    //                    Calendar fechaDiasMes = Calendar.getInstance();
    //                    fechaDiasMes.setTime(oficioLiquidacionPrevioVO.getFechaFinLiq());
    //                    fechaDiasMes.set(Calendar.DATE, 01);
    //
    //                    Date datefechaDiasMes = new Date();
    //                    datefechaDiasMes = fechaDiasMes.getTime();
    //
    //                    diasFin = (datefechaDiasMes.getTime() - oficioLiquidacionPrevioVO.getFechaFinLiq().getTime()) / MILLSECS_PER_DAY;
    //                }
    //
    //                /*
    //                 * Verificamos que los meses sean mayor a 0
    //                 */
    //                if(meses > 0) {
    //
    //                    /*
    //                     * Derechos de explotacion (DE)
    //                     */
    //                    double diasDEI = 0;
    //                    double diasDEF = 0;
    //                    boolean ingresoDias = false;
    //
    //                    //Maquinas Tragamonedas
    //                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 1 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 3) {
    //                        DE = meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30;
    //
    //                        /*
    //                         * Verificamos los dias
    //                         */
    //                        if(diasInicio > 0) {
    //                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(diasFin > 0) {
    //                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(ingresoDias) {
    //                            DE = DE + diasDEI + diasDEF;
    //                        }
    //                    }
    //
    //                    //Salones de Bingo
    //                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) >= 6 && Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) <= 15) {
    //
    //                        if(oficioLiquidacionPrevioVO.getInventarioSillas().intValue() < oficioLiquidacionPrevioVO.getMinimoSillas()) {
    //                            DE = (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30) * oficioLiquidacionPrevioVO.getMinimoSillas();
    //                        }
    //
    //                        if(oficioLiquidacionPrevioVO.getInventarioSillas().intValue() >= oficioLiquidacionPrevioVO.getMinimoSillas()) {
    //                            DE = (meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30) * oficioLiquidacionPrevioVO.getInventarioSillas().intValue();
    //                        }
    //
    //
    //                        /*
    //                         * Verificamos los dias
    //                         */
    //                        if(diasInicio > 0) {
    //                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(diasFin > 0) {
    //                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(ingresoDias) {
    //                            DE = DE + diasDEI + diasDEF;
    //                        }
    //                    }
    //
    //                    //Juegos de Casino y otros
    //                    if(Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 4 || Integer.parseInt(oficioLiquidacionPrevioVO.getCodigoApuesta()) == 5) {
    //                        DE = meses * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue() * 30;
    //
    //                        /*
    //                         * Verificamos los dias
    //                         */
    //                        if(diasInicio > 0) {
    //                            diasDEI = diasInicio * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(diasFin > 0) {
    //                            diasDEF = diasFin * oficioLiquidacionPrevioVO.getDerechosExplMensual().doubleValue();
    //                            ingresoDias = true;
    //                        }
    //
    //                        if(ingresoDias) {
    //                            DE = DE + diasDEI + diasDEF;
    //                        }
    //                    }
    //
    //                    /*
    //                     * Gastos de administracio (GA)
    //                     */
    //
    //                    GA = DE * (0.01);
    //                }
    //
    //            }
    //        }
    //
    //        /*
    //         * Valor a pagar
    //         */
    //        TOT_CTO1 = new BigDecimal(TOT_CTO1.doubleValue() + DET + GAT);
    //        valorContratoConcesion = Utilidades.redondear(TOT_CTO1, 0);
    //
    //        return valorContratoConcesion;
    //    }

    /**
     * Obtener Liquidación por Contrato y Conceptos
     * @param idCodigoContrato
     * @param fechaInicio
     * @param fechaFin
     * @return listLiquidacinVo - lista de SiiLiquidacionMes
     * @throws ExcepcionDAO
     */

    private List<LiquidacionMesVO> obtenerLiquidacionPorContratoYConceptos(Long idCodigoContrato, Date fechaInicio, Date fechaFin) throws ExcepcionDAO {
        List<SiiLiquidacionMes> listaLiquidacion = liquidacionMesDao.obtenerLiquidacionPorContratoYConceptos(idCodigoContrato, fechaInicio, fechaFin);
        List<LiquidacionMesVO> listLiquidacinVo = new ArrayList<LiquidacionMesVO>();
        for (SiiLiquidacionMes siiliq : listaLiquidacion) {
            listLiquidacinVo.add(new LiquidacionMesVO(siiliq));
        }
        return listLiquidacinVo;
    }
    
    
    
    /**
     * Calcular el valor liquidado del contrato hasta el mes anterior a la fecha actual.
     * (<b>VALOR EJECUTADO DEL CONTRATO</b>)
     * @param miContrato - Contrato.
     * @return totCto1 - valor desde el inicio hasta el último mes liquidado, así:
     * TOT_CTO1 = Suma valor del concepto DE para el contrato en Cuota operador +
     *            Suma valor del concepto GA para el contrato en Cuota operador
     * @throws ExcepcionDAO
     */
    public BigDecimal calculoValorLiquidadoContratoConcesion(ContratoVO miContrato) throws ExcepcionDAO {
        BigDecimal totCto1 = new BigDecimal(0);
        
        try {
            Calendar fechTmpFin = Calendar.getInstance();
            fechTmpFin.add(Calendar.MONTH, -1);
            Integer vigencia = null;
            Integer mes = null;
            Calendar fechaSiguiente = Calendar.getInstance();
            String fechasig = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            BigDecimal deTotCto1 = new BigDecimal(0);
            BigDecimal gaTotCto1 = new BigDecimal(0);
            BigDecimal tarifaGA = (new BigDecimal(1)).divide(new BigDecimal(100));
        
            // 1. Se halla el valor liquidado del contrato hasta el mes anterior a la fecha actual
            Date fechaActual = new Date(System.currentTimeMillis());
            List<EstadoCuentaVO> listaEstadoCuentaVo = this.consultarEstadoCuenta(miContrato.getConNumero(), -1, fechaActual, false);
             
            if  (listaEstadoCuentaVo!= null && listaEstadoCuentaVo.size()> 0){
                for(EstadoCuentaVO estVo : listaEstadoCuentaVo){
                    if (estVo!=null && estVo.getCodigoConcepto()!=null) {
                        if (estVo.getCodigoConcepto().equals(new BigDecimal(EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId()))){
                            deTotCto1 = deTotCto1.add( estVo.getMonto_obligacion());
                        }
                        /*
                        else if (estVo.getCodigoConcepto().equals(new BigDecimal(EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId()))){
                            gaTotCto1 = gaTotCto1.add( estVo.getMonto_obligacion());
                        }
                        */
                    }
                }
                gaTotCto1 = deTotCto1.multiply(tarifaGA); 
                totCto1 =  deTotCto1.add(gaTotCto1);
                totCto1 = Utilidades.redondear(totCto1, 0);
            }
        }
        catch (ExcepcionDAO e) {
            throw e;
        }
        catch (Exception e) {
            throw new ExcepcionDAO(e.getMessage(), e);
        }
         
        return totCto1;
    }
    
    
    
    /**
     * Calcular el valor del contrato de concesión
     * @param miContrato
     * @return tot_cto - valor total del contrato TOT_CTO =   DE + GA
     * @throws ExcepcionDAO
     */

    public BigDecimal calculoValorContratoConcesion(ContratoVO miContrato) throws ExcepcionDAO {
        BigDecimal tot_cto = new BigDecimal(0);
        BigDecimal valorContratoConcesion = new BigDecimal(0);

        BigDecimal totCto1 = new BigDecimal(0);
        
        // VALOR EJECUTADO DEL CONTRATO
        totCto1 = this.calculoValorLiquidadoContratoConcesion(miContrato);
        
        // VALOR POR EJECUTAR DEL CONTRATO
        valorContratoConcesion = this.calculoValorXEjecutarContratoConc(miContrato.getConCodigo());

        tot_cto = totCto1.add(valorContratoConcesion);

        return tot_cto;
    }

    /**
     * Calcular el Valor del Contrato de Concesión
     * @param conCodigo
     * @return tot_cto - valor total del contrato TOT_CTO =   DE + GA
     * @throws ExcepcionDAO
     */

    public BigDecimal calculoValorContratoConcesion(Long conCodigo) throws ExcepcionDAO {
        BigDecimal tot_cto = new BigDecimal(0);

        if (conCodigo != null) {
            ContratoVO contratoVo = this.buscarContratoPorId(conCodigo);
            if (contratoVo != null)
                tot_cto = this.calculoValorContratoConcesion(contratoVo);
        }

        return (tot_cto);
    }

    public List<ContratoVO> buscarContratosXEstadoEjecucionYFechaTermi(String estado) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosXEstadoEjecucionYFechaTermi(estado);
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;
    }
    
    public List<ContratoVO> buscarContratosXFechaTermi() throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosXFechaTermi();
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;
    }
    

    public List<EstadoCuentaVO> saldoLiqContrato(String contrato) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVo = contratoDAO.saldoLiqContrato(contrato);
        return estadoCuentaVo;
    }


    public void cargarContrato(List<List<EstadoCuentaVO>> listaListaCuotas, UsuarioVO usuarioVo) throws ExcepcionAplicacion, ExcepcionDAO {
        //DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            for (List<EstadoCuentaVO> listaEstadoCuentaVo : listaListaCuotas) {
                List<SiiDetalleDeclaracion> listaDetallesDeclaracionReutilizar = new ArrayList<>();
                EstadoCuentaVO estadoCuentaRaiz = listaEstadoCuentaVo.get(0);
                String numeroContrato = estadoCuentaRaiz.getContrato();
                Integer vigencia = new Integer(estadoCuentaRaiz.getAnio().intValue());
                Integer mes = estadoCuentaRaiz.getMes().intValue();
                Integer numCuota = estadoCuentaRaiz.getCuota().intValue();
                String nit = estadoCuentaRaiz.getNit();
                String concepto = estadoCuentaRaiz.getAbreviaturaConcepto();

                SiiLiquidacionMes siiLiquidacionMes = liquidacionMesDao.buscarLiquidacionMesPorContratoPorVigenciaPorMesPorConceptoPorNit(numeroContrato, vigencia, mes, concepto, nit);

                if (siiLiquidacionMes == null) {
                    //throw new ExcepcionAplicacion("No se encontró la liquidación del contrato " + numeroContrato + " con vigencia " + vigencia + " mes " + mes + " y concepto " + concepto);
                    //Crear la liquidación
                    siiLiquidacionMes = new SiiLiquidacionMes();
                    SiiContrato siiContrato = contratoDAO.buscarContratoPorNumeroPorNit(estadoCuentaRaiz.getContrato(), estadoCuentaRaiz.getNit());
                    if (siiContrato == null) {
                        throw new ExcepcionAplicacion("No se encontró el contrato " + estadoCuentaRaiz.getContrato() + "del operador con NIT " + estadoCuentaRaiz.getNit() + " + Linea " +
                                                      estadoCuentaRaiz.getRazonSocial());
                    }
                    siiLiquidacionMes.setSiiContrato(siiContrato);
                    siiLiquidacionMes.setLiqConcepto(estadoCuentaRaiz.getAbreviaturaConcepto());

                    //La fecha de la liquidación es el último día del mes anterior
                    Calendar calLiq = Calendar.getInstance();
                    calLiq.set(Calendar.YEAR, vigencia);
                    calLiq.set(Calendar.MONTH, mes - 1);
                    calLiq.set(Calendar.DAY_OF_MONTH, 1);
                    calLiq.add(Calendar.DAY_OF_MONTH, -1);
                    siiLiquidacionMes.setLiqFecha(calLiq.getTime());

                    siiLiquidacionMes.setLiqFechaLimPago(estadoCuentaRaiz.getFecha_vencimiento());
                    siiLiquidacionMes.setLiqValor(estadoCuentaRaiz.getMonto_obligacion());
                    siiLiquidacionMes.setLmeNumCuota(estadoCuentaRaiz.getCuota().intValue());
                    siiLiquidacionMes.setLmeVigencia(estadoCuentaRaiz.getAnio().intValue());
                    SiiMes siiMes = mesDao.buscarMesPorId(estadoCuentaRaiz.getMes().intValue());
                    if (siiMes == null) {
                        throw new ExcepcionAplicacion("Error en el mes. Línea " + estadoCuentaRaiz.getRazonSocial());
                    }
                    siiLiquidacionMes.setSiiMes(siiMes);
                    SiiSmmlv siiSmmlv = smmlvDao.buscarSmmlvPorId(estadoCuentaRaiz.getAnio().intValue());
                    siiLiquidacionMes.setSiiSmmlv(siiSmmlv);
                    liquidacionMesDao.insertarLiquidacionMes(siiLiquidacionMes);
                }

                else {
                    //La fecha de la liquidación es el último día del mes anterior
                    Calendar calLiq = Calendar.getInstance();
                    calLiq.set(Calendar.YEAR, vigencia);
                    calLiq.set(Calendar.MONTH, mes - 1);
                    calLiq.set(Calendar.DAY_OF_MONTH, 1);
                    calLiq.add(Calendar.DAY_OF_MONTH, -1);
                    siiLiquidacionMes.setLiqFecha(calLiq.getTime());

                    siiLiquidacionMes.setLiqFechaLimPago(estadoCuentaRaiz.getFecha_vencimiento());
                    siiLiquidacionMes.setLiqValor(estadoCuentaRaiz.getMonto_obligacion());
                    siiLiquidacionMes.setLmeNumCuota(numCuota);

                    liquidacionMesDao.actualizarLiquidacionMes(siiLiquidacionMes);
                }


                //Buscamos la cuota operador
                List<SiiCuotaOperador> listaSiiCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorXIdLiquidacion(siiLiquidacionMes.getLmeCodigo());
                if (listaSiiCuotaOperador != null && listaSiiCuotaOperador.size() > 1) {
                    throw new ExcepcionAplicacion("Se encontró más de una cuota para el contrato " + numeroContrato + " con vigencia " + vigencia + " mes " + mes + " y concepto " + concepto);
                }
                SiiCuotaOperador siiCuotaOperador = null;
                if (listaSiiCuotaOperador == null) {
                    //Crear nueva cuota
                    siiCuotaOperador = new SiiCuotaOperador();
                    siiCuotaOperador.setSiiLiquidacionMes(siiLiquidacionMes);

                    Long idConcepto = concepto.equals("DE")? EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId() : EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId();
                    SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(idConcepto);
                    siiCuotaOperador.setSiiConceptoCuota(siiConceptoCuota);
                    siiCuotaOperador.setCopNumCuota(numCuota);
                    siiCuotaOperador.setCopVigencia(vigencia);
                    siiCuotaOperador.setMesCodigo(mes);
                    cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperador);
                }
                else {
                    siiCuotaOperador = listaSiiCuotaOperador.get(0);
                }

                siiCuotaOperador.setCopTipoDocSopor("CO");
                siiCuotaOperador.setCopFechaLimPag(estadoCuentaRaiz.getFecha_vencimiento());
                siiCuotaOperador.setCopCancelada("N");
                siiCuotaOperador.setCopValor(estadoCuentaRaiz.getMonto_obligacion());
                siiCuotaOperador.setSiiOperador(siiLiquidacionMes.getSiiContrato().getSiiOperador());
                siiCuotaOperador.setCopTipoCartera("C");
                cuotaOperadorDao.actualizarCuotaOperador(siiCuotaOperador);

                //Buscamos ajustes a la cuota:
                List<SiiAjusteCuota> listaSiiAjusteCuota = ajusteCuotaDao.buscarAjustesCuotaPorIdCuota(siiCuotaOperador.getCopCodigo());
                if (listaSiiAjusteCuota != null && listaSiiAjusteCuota.size() > 0) {
                    //Ponemos en 0 el valor de los ajustes
                    for (SiiAjusteCuota siiAjusteCuota : listaSiiAjusteCuota) {
                        siiAjusteCuota.setAjuValor(BigDecimal.ZERO);
                        ajusteCuotaDao.actualizar(siiAjusteCuota);
                    }
                }

                //Sumamos los intereses y borramos los ajustes. Debe coincidir con el valor entregado
                //si no coincide se hace un ajuste
                Long diferenciaIntereses = 0L;
                BigDecimal totalInteresArchivo = estadoCuentaRaiz.getTotal_interes();

                //buscamos todos los intereses del mes
                List<SiiInteresCuota> listaIntereses = interesCuotaDao.buscarInteresPorIdCuota(siiCuotaOperador.getCopCodigo());
                if (listaIntereses != null && listaIntereses.size() > 0) {
                    BigDecimal totalIntereses = BigDecimal.ZERO;
                    for (SiiInteresCuota siiInteresCuota : listaIntereses) {
                        //Ponemos en cero los valores pagados
                        siiInteresCuota.setIcuValorPagado(BigDecimal.ZERO);
                        //Ponemos en cero las cuotas creadas por ajustes
                        if (siiInteresCuota.getSiiAjuste() != null) {
                            siiInteresCuota.setIcuValor(BigDecimal.ZERO);
                        }
                        //Quitamos los decimales
                        siiInteresCuota.setIcuValor(siiInteresCuota.getIcuValor().setScale(0, BigDecimal.ROUND_HALF_UP));
                        //Fijamos la bandera de carga de contrato
                        siiInteresCuota.setIcuCancelado("C");
                        interesCuotaDao.actualizarSiiInteresCuota(siiInteresCuota);
                        totalIntereses = totalIntereses.add(siiInteresCuota.getIcuValor());
                    }
                    diferenciaIntereses = totalInteresArchivo.longValue() - totalIntereses.longValue();

                }
                else { //No hay cuotas de interes
                    if (!totalInteresArchivo.equals(BigDecimal.ZERO)) {
                        diferenciaIntereses = totalInteresArchivo.longValue();
                    }
                }

                if (diferenciaIntereses != 0L) {
                    //Creamos un nuevo ajuste
                    SiiAjuste siiAjuste = new SiiAjuste();
                    Integer ultimoConsecutivo = ajusteDao.buscarUltimoConsecutivoPorVigencia(vigencia);
                    if (ultimoConsecutivo == null) {
                        //Para evitar el trigger de período cerrado sumamos 5E7
                        ultimoConsecutivo = ((vigencia - 2000) * 1000000) + 50000000;
                    }
                    else {
                        ultimoConsecutivo++;
                    }
                    siiAjuste.setAjuConsecutivo(ultimoConsecutivo);
                    //La fecha del ajuste es el último día del mes
                    Calendar cal = Calendar.getInstance();
                    cal.set(Calendar.YEAR, vigencia);
                    cal.set(Calendar.MONTH, mes - 1);
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                    cal.add(Calendar.MONTH, 1);
                    cal.add(Calendar.DAY_OF_MONTH, -1);
                    siiAjuste.setAjuFecha(cal.getTime());

                    SiiTipoAjuste siiTipoAjuste = tipoAjusteDao.buscarPorCodigo(13L);
                    siiAjuste.setSiiTipoAjuste(siiTipoAjuste);

                    siiAjuste.setSiiUsuario(conversionVoEntidad.convertir(usuarioVo));
                    ajusteDao.insertar(siiAjuste);

                    //Creamos la cuota de interés
                    SiiInteresCuota siiInteresCuota = new SiiInteresCuota();
                    siiInteresCuota.setIcuBaseCalc(new BigDecimal(diferenciaIntereses));
                    siiInteresCuota.setIcuCancelado("C");
                    siiInteresCuota.setIcuFecha(cal.getTime());
                    siiInteresCuota.setIcuTasaAplic(BigDecimal.ZERO);
                    siiInteresCuota.setIcuValor(new BigDecimal(diferenciaIntereses));
                    siiInteresCuota.setIcuValorPagado(BigDecimal.ZERO);
                    siiInteresCuota.setSiiAjuste(siiAjuste);
                    siiInteresCuota.setSiiCuotaOperador(siiCuotaOperador);
                    interesCuotaDao.insertarSiiInteresCuota(siiInteresCuota);
                }

                //Buscamos los detalles declaración y sus pagos (INNER JOIN)
                List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = detalleDeclaracionDao.buscarDetalleDeclaracionDetRacaudoPorXCodigoCuota(siiCuotaOperador.getCopCodigo());

                //Buscamos los recaudos que estén asociados a otras declaraciones. En esos casos agregamos
                //los detalles declaración a la lista de reutilización que implica crear nuevos
                //recaudos banco. Si sobran estas declaraciones se desligan del detalle recaudo para
                // poner en cero su valor y desligar el detalle recaudo
                for (SiiDetalleDeclaracion unDetalleDeclaracionRecaudo : listaSiiDetalleDeclaracion) {
                    //Buscamos las declaraciones con el mismo recaudo
                    SiiRecaudoBanco siiRecaudoBanco = unDetalleDeclaracionRecaudo.getSiiDetalleRecaudo().getSiiRecaudoBanco();
                    if (siiRecaudoBanco == null) {
                        throw new ExcepcionAplicacion("El detalle recaudo no tiene un recaudo banco asociado. Revise que las fechas de operación sean anteriores a la entrada de operación de SIICOL");
                    }
                    List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracionRepetidos = detalleDeclaracionDao.buscarDetalleDeclaracionPorIdRecaudoBanco(siiRecaudoBanco.getRbaCodigo());
                    if (listaSiiDetalleDeclaracionRepetidos != null && listaSiiDetalleDeclaracionRepetidos.size() > 1) {
                        //Significa que el recaudo ya está siendo usado en otra declaración
                        //agregar a la lista de reutilización de detalleDeclaración
                        System.out.println("RBA_CODIGO  " + siiRecaudoBanco.getRbaCodigo() + " tiene más de un detalle declaración");
                        listaDetallesDeclaracionReutilizar.add(unDetalleDeclaracionRecaudo);
                    }
                }

                //Quitamos de la lista de detalles de declaración los recaudos a reutilizar
                for (SiiDetalleDeclaracion siiDetalleDeclaracionReutilizar : listaDetallesDeclaracionReutilizar) {
                    listaSiiDetalleDeclaracion.remove(siiDetalleDeclaracionReutilizar);
                }

                //Quitamos de la lista de detalles de declaración los recaudos que sean ajuste
                if (listaSiiDetalleDeclaracion != null && listaSiiDetalleDeclaracion.size() > 0) {
                    List<SiiDetalleDeclaracion> listaSiiDetallesDeclaracionQuitar = new ArrayList<>();
                    for (SiiDetalleDeclaracion siiDetalleDeclaracion : listaSiiDetalleDeclaracion) {
                        if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiAjuste() != null) {
                            SiiDeclaracionOperador siiDeclaracionOperador = siiDetalleDeclaracion.getSiiDeclaracionOperador();
                            siiDeclaracionOperador.setDopTipo("C");
                            declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                            siiDetalleDeclaracion.setSiiDetalleRecaudo(null);
                            siiDetalleDeclaracion.setDdeValorPagado(BigDecimal.ZERO);
                            siiDetalleDeclaracion.setDdeValorPagInt(BigDecimal.ZERO);
                            detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetalleDeclaracion);
                            listaSiiDetallesDeclaracionQuitar.add(siiDetalleDeclaracion);
                        }
                    }
                    //Quitamos los detalles declaracion que estaban asociados a ajustes
                    for (SiiDetalleDeclaracion siiDetalleDeclaracionRemover : listaSiiDetallesDeclaracionQuitar) {
                        listaSiiDetalleDeclaracion.remove(siiDetalleDeclaracionRemover);
                    }
                }

                //Emparejamos el estado de cuenta del archivo con el detalle declaración
                List<EstadoCuentaVO> listaEstadoCuentaVoProcesados = new ArrayList<>();
                List<SiiDetalleDeclaracion> listaSiiDetallesDeclaracionProcesados = new ArrayList<>();
                for (EstadoCuentaVO estadoCuentaVo : listaEstadoCuentaVo) {
                    //Emparejamos el estado de cuenta del archivo con el detalle declaración
                    if (listaSiiDetalleDeclaracion != null && listaSiiDetalleDeclaracion.size() > 0) {
                        for (SiiDetalleDeclaracion siiDetalleDeclaracion : listaSiiDetalleDeclaracion) {
                            boolean hayCoincidencia = false;
                            if (!estadoCuentaVo.getReferenciaPago().equals("")) {
                                if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoBanco() == null && siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoPse() == null &&
                                    siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoLineaBan() == null) {
                                    continue;
                                }
                                if (!estadoCuentaVo.getReferenciaPago().equals(siiDetalleDeclaracion.getSiiDetalleRecaudo().getDreRefPago())) {
                                    continue;
                                }
                                //Se encontró una coincidencia
                                hayCoincidencia = true;
                            }

                            else if (estadoCuentaVo.getNumeroAcuerdoPago() != null) {
                                if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiAcuerdoPago() == null) {
                                    continue;
                                }
                                if (estadoCuentaVo.getNumeroAcuerdoPago() != siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiAcuerdoPago().getApaNumero()) {
                                    continue;
                                }
                                //Se encontró una coincidencia
                                hayCoincidencia = true;
                            }

                            if (hayCoincidencia) {
                                //Buscamos los ajustes detalle recaudo y los ponemos en cero
                                List<SiiAjusteDetRecaudo> listaSiiAjusteDetRecaudo =
                                    ajusteDetRecaudoDao.buscarAjusteDetRecaudoPorIdDetRecaudo(siiDetalleDeclaracion.getSiiDetalleRecaudo().getDreCodigo());
                                if (listaSiiAjusteDetRecaudo != null && listaSiiAjusteDetRecaudo.size() > 0) {
                                    for (SiiAjusteDetRecaudo siiAjusteDetRecaudo : listaSiiAjusteDetRecaudo) {
                                        siiAjusteDetRecaudo.setAdrValor(BigDecimal.ZERO);
                                        siiAjusteDetRecaudo.setAdrValorInteres(BigDecimal.ZERO);
                                    }
                                }

                                if (estadoCuentaVo.getFecha_pago() == null) {
                                    throw new ExcepcionAplicacion("Error, la fecha de pago es nula. Línea " + estadoCuentaVo.getRazonSocial());
                                }

                                //Actualizamos la fecha de recaudo
                                if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoBanco() != null) {
                                    SiiRecaudoBanco siiRecaudoBanco = siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoBanco();
                                    siiRecaudoBanco.setRbaFechaRec(estadoCuentaVo.getFecha_pago());
                                    //System.out.println("Cuota " + estadoCuentaVo.getCuota() + " RBA_CODIGO = " + siiRecaudoBanco.getRbaCodigo() + " Fecha pago " + dateFormatter.format(estadoCuentaVo.getFecha_pago()));
                                    recaudoBancoDao.actualizar(siiRecaudoBanco);
                                }
                                else if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoPse() != null) {
                                    SiiRecaudoPse siiRecaudoPse = siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoPse();
                                    siiRecaudoPse.setRpsFechaEstado(estadoCuentaVo.getFecha_pago());
                                    pagoOpePseDao.actualizarRecaudoPse(siiRecaudoPse);
                                }
                                else if (siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoLineaBan() != null) {
                                    SiiRecaudoLineaBan siiRecaudoLineaBan = siiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoLineaBan();
                                    SiiOperacionLineaBan siiOperacionLineaBan = siiRecaudoLineaBan.getSiiOperacionLineaBan();
                                    siiOperacionLineaBan.setOlbFecha(estadoCuentaVo.getFecha_pago());
                                    operacionLineaBanDao.actualizarSiiOperacionLineaBan(siiOperacionLineaBan);
                                }

                                SiiDetalleRecaudo siiDetalleRecaudo = siiDetalleDeclaracion.getSiiDetalleRecaudo();
                                siiDetalleRecaudo.setDreEstado("A");
                                siiDetalleRecaudo.setDreValor(estadoCuentaVo.getMonto_pago().add(estadoCuentaVo.getPagado_interes()));
                                detalleRecaudoDao.actualizar(siiDetalleRecaudo);

                                SiiDeclaracionOperador siiDeclaracionOperador = siiDetalleDeclaracion.getSiiDeclaracionOperador();
                                siiDeclaracionOperador.setDopFecha(estadoCuentaVo.getFecha_pago());
                                siiDeclaracionOperador.setDopTipo("C");
                                declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                                siiDetalleDeclaracion.setDdeValorDeclarado(estadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracion.setDdeValorInter(estadoCuentaVo.getPagado_interes());
                                siiDetalleDeclaracion.setDdeValorPagado(estadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracion.setDdeValorPagInt(estadoCuentaVo.getPagado_interes());
                                siiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                                detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetalleDeclaracion);

                                listaSiiDetallesDeclaracionProcesados.add(siiDetalleDeclaracion);
                                listaEstadoCuentaVoProcesados.add(estadoCuentaVo);
                            }
                        }
                        //Quitamos los detalles declaracion procesados
                        for (SiiDetalleDeclaracion siiDetalleDeclaracionRemover : listaSiiDetallesDeclaracionProcesados) {
                            listaSiiDetalleDeclaracion.remove(siiDetalleDeclaracionRemover);
                        }
                    }
                }
                //Quitamos los estados de cuenta procesados
                for (EstadoCuentaVO estadoCuentaRemover : listaEstadoCuentaVoProcesados) {
                    listaEstadoCuentaVo.remove(estadoCuentaRemover);
                }
                //Procesamos los estados de cuenta y los detalles declaración sobrantes
                listaSiiDetallesDeclaracionProcesados = new ArrayList<>();
                int totalRecaudos = listaSiiDetalleDeclaracion.size();
                int recaudosSobrantes = totalRecaudos;
                for (EstadoCuentaVO unEstadoCuentaVo : listaEstadoCuentaVo) {
                    if (unEstadoCuentaVo.getMonto_pago().intValue() <= 0 && unEstadoCuentaVo.getPagado_interes().intValue() <= 0) {
                        continue;
                    }
                    //Buscamos el acuerdo de pago
                    if (unEstadoCuentaVo.getNumeroAcuerdoPago() != null && !unEstadoCuentaVo.getNumeroAcuerdoPago().equals("")) {
                        SiiAcuerdoPago siiAcuerdoPago = acuerdoPagoDao.buscarAcuerdoPagoPorNumero(unEstadoCuentaVo.getNumeroAcuerdoPago());
                        if (siiAcuerdoPago == null) {
                            throw new ExcepcionAplicacion("No es posible encontrar un acuerdo de pago para la línea: " + unEstadoCuentaVo.getRazonSocial());
                        }

                        SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
                        siiDetalleRecaudo.setDreEstado("A");
                        siiDetalleRecaudo.setDreValor(unEstadoCuentaVo.getMonto_pago());
                        siiDetalleRecaudo.setSiiAcuerdoPago(siiAcuerdoPago);
                        detalleRecaudoDao.insertar(siiDetalleRecaudo);
                        continue;
                    }

                    if (recaudosSobrantes > 0) {
                        SiiDetalleDeclaracion unSiiDetalleDeclaracion = listaSiiDetalleDeclaracion.get(totalRecaudos - recaudosSobrantes);

                        SiiDetalleRecaudo siiDetalleRecaudo = unSiiDetalleDeclaracion.getSiiDetalleRecaudo();
                        siiDetalleRecaudo.setDreEstado("A");
                        siiDetalleRecaudo.setDreValor(unEstadoCuentaVo.getMonto_pago());
                        detalleRecaudoDao.actualizar(siiDetalleRecaudo);

                        SiiDeclaracionOperador siiDeclaracionOperador = unSiiDetalleDeclaracion.getSiiDeclaracionOperador();
                        siiDeclaracionOperador.setDopFecha(unEstadoCuentaVo.getFecha_pago());
                        siiDeclaracionOperador.setDopTipo("C");
                        declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                        unSiiDetalleDeclaracion.setDdeValorDeclarado(unEstadoCuentaVo.getMonto_pago());
                        unSiiDetalleDeclaracion.setDdeValorInter(unEstadoCuentaVo.getPagado_interes());
                        unSiiDetalleDeclaracion.setDdeValorPagado(unEstadoCuentaVo.getMonto_pago());
                        unSiiDetalleDeclaracion.setDdeValorPagInt(unEstadoCuentaVo.getPagado_interes());
                        unSiiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                        detalleDeclaracionDao.actualizarDetalleDeclaracion(unSiiDetalleDeclaracion);

                        //Actualizamos la fecha de recaudo
                        if (unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoBanco() != null) {
                            SiiRecaudoBanco siiRecaudoBanco = unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoBanco();
                            siiRecaudoBanco.setRbaFechaRec(unEstadoCuentaVo.getFecha_pago());
                            //System.out.println("Cuota " + unEstadoCuentaVo.getCuota() + " RBA_CODIGO = " + siiRecaudoBanco.getRbaCodigo() + " Fecha pago " + dateFormatter.format(unEstadoCuentaVo.getFecha_pago()));
                            recaudoBancoDao.actualizar(siiRecaudoBanco);
                        }
                        else if (unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoPse() != null) {
                            SiiRecaudoPse siiRecaudoPse = unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoPse();
                            siiRecaudoPse.setRpsFechaEstado(unEstadoCuentaVo.getFecha_pago());
                            pagoOpePseDao.actualizarRecaudoPse(siiRecaudoPse);
                        }
                        else if (unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoLineaBan() != null) {
                            SiiRecaudoLineaBan siiRecaudoLineaBan = unSiiDetalleDeclaracion.getSiiDetalleRecaudo().getSiiRecaudoLineaBan();
                            SiiOperacionLineaBan siiOperacionLineaBan = siiRecaudoLineaBan.getSiiOperacionLineaBan();
                            siiOperacionLineaBan.setOlbFecha(unEstadoCuentaVo.getFecha_pago());
                            operacionLineaBanDao.actualizarSiiOperacionLineaBan(siiOperacionLineaBan);
                        }

                        listaSiiDetallesDeclaracionProcesados.add(unSiiDetalleDeclaracion);
                        recaudosSobrantes--;
                    }
                    else { //Hay menos detalles recaudo que recaudos en el archivo
                        if (!unEstadoCuentaVo.getReferenciaPago().equals("")) {
                            throw new ExcepcionAplicacion("No es posible encontrar un recaudo bancario o PSE para la línea: " + unEstadoCuentaVo.getRazonSocial());
                        }
                        else {
                            //Agregar un recaudo banco
                            SiiRecaudoBanco siiRecaudoBanco = new SiiRecaudoBanco();
                            siiRecaudoBanco.setRbaNumCuenta("1303090200016470");
                            siiRecaudoBanco.setRbaOrdenDia("A");
                            siiRecaudoBanco.setRbaFechaRec(unEstadoCuentaVo.getFecha_pago());
                            if (unEstadoCuentaVo.getFecha_pago() == null) {
                                throw new ExcepcionAplicacion("La fecha de recaudo no puede ir nula para la línea: " + unEstadoCuentaVo.getRazonSocial());
                            }
                            siiRecaudoBanco.setRbaFechaArchivo(unEstadoCuentaVo.getFecha_pago());
                            SiiBanco siiBanco = bancoDao.buscarBancoPorCodigo("13");
                            siiRecaudoBanco.setSiiBanco(siiBanco);
                            SiiTipoCuenta siiTipoCuenta = tipoCuentaDao.buscarTipoCuentaXId(1L);
                            siiRecaudoBanco.setSiiTipoCuenta(siiTipoCuenta);
                            SiiArchivoFisico siiArchivoFisico = archivoFisicoDao.buscarArchivoFisicoPorId(1140L);
                            siiRecaudoBanco.setSiiArchivoFisico(siiArchivoFisico);
                            recaudoBancoDao.insertar(siiRecaudoBanco);

                            //Si quedan detalles recaudo por reutiliza, usarlos
                            if (listaDetallesDeclaracionReutilizar.size() > 0) {
                                SiiDetalleDeclaracion siiDetalleDeclaracionReutilizar = listaDetallesDeclaracionReutilizar.get(0);

                                SiiDetalleRecaudo siiDetalleRecaudo = siiDetalleDeclaracionReutilizar.getSiiDetalleRecaudo();
                                siiDetalleRecaudo.setSiiRecaudoPse(null);
                                siiDetalleRecaudo.setSiiRecaudoLineaBan(null);
                                siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
                                detalleRecaudoDao.actualizar(siiDetalleRecaudo);

                                SiiDeclaracionOperador siiDeclaracionOperador = siiDetalleDeclaracionReutilizar.getSiiDeclaracionOperador();
                                siiDeclaracionOperador.setDopFecha(unEstadoCuentaVo.getFecha_pago());
                                siiDeclaracionOperador.setDopTipo("C");
                                declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                                siiDetalleDeclaracionReutilizar.setDdeValorPagado(unEstadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracionReutilizar.setDdeBaseCalcInt(unEstadoCuentaVo.getMonto_obligacion().longValue());
                                siiDetalleDeclaracionReutilizar.setDdeDiasInteres(0);
                                siiDetalleDeclaracionReutilizar.setDdeValorDeclarado(unEstadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracionReutilizar.setDdeValorInter(unEstadoCuentaVo.getTotal_interes());
                                siiDetalleDeclaracionReutilizar.setDdeValorPagInt(unEstadoCuentaVo.getPagado_interes());
                                detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetalleDeclaracionReutilizar);

                                listaDetallesDeclaracionReutilizar.remove(siiDetalleDeclaracionReutilizar);
                            }

                            else {
                                //Insertamos el detalle recaudo
                                SiiDetalleRecaudo siiDetalleRecaudo = new SiiDetalleRecaudo();
                                siiDetalleRecaudo.setDreValor(unEstadoCuentaVo.getMonto_pago().add(unEstadoCuentaVo.getPagado_interes()));
                                SiiProcedenciaPago siiProcedenciaPago = procedenciaPagoDao.buscarProcedenciaPagoXId("01");
                                siiDetalleRecaudo.setSiiProcedenciaPago(siiProcedenciaPago);
                                SiiMedioPago siiMedioPago = medioPagoDao.buscarMedioPagoXId(1L);
                                siiDetalleRecaudo.setSiiMedioPago(siiMedioPago);
                                siiDetalleRecaudo.setSiiBanco(siiBanco);
                                siiDetalleRecaudo.setSiiRecaudoBanco(siiRecaudoBanco);
                                siiDetalleRecaudo.setDreEstado("A");
                                detalleRecaudoDao.insertar(siiDetalleRecaudo);

                                //Agregamos una declaracion
                                SiiDeclaracionOperador siiDeclaracionOperador = new SiiDeclaracionOperador();
                                siiDeclaracionOperador.setDopFecha(unEstadoCuentaVo.getFecha_pago());
                                siiDeclaracionOperador.setDopTipo("C");
                                declaracionOperadorDao.insertar(siiDeclaracionOperador);
                                //Agregamos el detalle declaracion
                                SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();
                                siiDetalleDeclaracion.setSiiCuotaOperador(siiCuotaOperador);
                                siiDetalleDeclaracion.setDdeValorPagado(unEstadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracion.setDdeBaseCalcInt(unEstadoCuentaVo.getMonto_obligacion().longValue());
                                siiDetalleDeclaracion.setDdeDiasInteres(0);
                                siiDetalleDeclaracion.setSiiDeclaracionOperador(siiDeclaracionOperador);
                                siiDetalleDeclaracion.setDdeValorDeclarado(unEstadoCuentaVo.getMonto_pago());
                                siiDetalleDeclaracion.setSiiDetalleRecaudo(siiDetalleRecaudo);
                                siiDetalleDeclaracion.setDdeValorInter(unEstadoCuentaVo.getTotal_interes());
                                siiDetalleDeclaracion.setDdeValorPagInt(unEstadoCuentaVo.getPagado_interes());
                                detalleDeclaracionDAO.insertarDetalleDeclaracion(siiDetalleDeclaracion);
                            }
                        }
                    }
                }
                //Quitamos los detalles declaracion procesados
                for (SiiDetalleDeclaracion siiDetalleDeclaracionRemover : listaSiiDetallesDeclaracionProcesados) {
                    listaSiiDetalleDeclaracion.remove(siiDetalleDeclaracionRemover);
                }
                //Pueden haber quedado detalles declaración sobrantes
                //en ese caso se desligan del detalle declaración los recaudos
                if (listaSiiDetalleDeclaracion != null && listaSiiDetalleDeclaracion.size() > 0) {
                    for (SiiDetalleDeclaracion siiDetallesDeclaracionDesligar : listaSiiDetalleDeclaracion) {
                        SiiDeclaracionOperador siiDeclaracionOperador = siiDetallesDeclaracionDesligar.getSiiDeclaracionOperador();
                        siiDeclaracionOperador.setDopTipo("C");
                        declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                        siiDetallesDeclaracionDesligar.setSiiDetalleRecaudo(null);
                        detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetallesDeclaracionDesligar);
                    }
                }

                //Si quedaron detalles declaracion a reutilizar, desasociamos el detalle recaudo
                for (SiiDetalleDeclaracion siiDetalleDeclaracionReutilizar : listaDetallesDeclaracionReutilizar) {
                    SiiDeclaracionOperador siiDeclaracionOperador = siiDetalleDeclaracionReutilizar.getSiiDeclaracionOperador();
                    siiDeclaracionOperador.setDopTipo("C");
                    declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                    siiDetalleDeclaracionReutilizar.setSiiDetalleRecaudo(null);
                }

                //Ponemos en cero los valores pagados en las declaraciones sin recaudo asociado y las inactivamos
                List<SiiDetalleDeclaracion> listaTodosSiiDetalleDeclaracion = detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(siiCuotaOperador.getCopCodigo());
                for (SiiDetalleDeclaracion siiDetalleDeclaracionBorrar : listaTodosSiiDetalleDeclaracion) {
                    if (siiDetalleDeclaracionBorrar.getSiiDetalleRecaudo() == null) {
                        SiiDeclaracionOperador siiDeclaracionOperador = siiDetalleDeclaracionBorrar.getSiiDeclaracionOperador();
                        siiDeclaracionOperador.setDopTipo("C");
                        declaracionOperadorDao.actualizar(siiDeclaracionOperador);

                        siiDetalleDeclaracionBorrar.setDdeValorPagado(BigDecimal.ZERO);
                        siiDetalleDeclaracionBorrar.setDdeValorPagInt(BigDecimal.ZERO);
                        siiDetalleDeclaracionBorrar.setDdeEstado("I");
                        detalleDeclaracionDao.actualizarDetalleDeclaracion(siiDetalleDeclaracionBorrar);
                    }
                }
            }
        } catch (ExcepcionAplicacion | ExcepcionDAO ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general al cargar el contrato: " + ex.getMessage());
        }
    }

    public List<ContratoVO> buscarContratosEnEjecucion() throws ExcepcionDAO {
        List<ContratoVO> contratosVo = new ArrayList<ContratoVO>();
        for (SiiContrato contrato : contratoDAO.buscarContratosEnEjecucion()) {
            contratosVo.add(new ContratoVO(contrato));
        }
        return contratosVo;
    }

    public List<ContratoVO> buscarContratosEnEjecucionSinTramiteSuspension() throws ExcepcionDAO {
        List<ContratoVO> contratosVo = new ArrayList<ContratoVO>();
        for (SiiContrato contrato : contratoDAO.buscarContratosEnEjecucionSinTramiteSuspension()) {
            contratosVo.add(new ContratoVO(contrato));
        }
        return contratosVo;
    }

    public ContratoVO buscarContratoPorId(Long conCodigo) throws ExcepcionDAO {
        return new ContratoVO(contratoDAO.buscarContratoPorId(conCodigo));
    }

    @Schedule(second = "1", minute = "0", hour = "0")
    public void reanudarContratosSuspendidos() {
        // Al día siguiente a la fecha final del período  de suspensión el sistema  coloca automáticamente el Contrato de concesión en estado REANUDADO.
        try {
            contratoDAO.reanudarContratosSuspendidos();
        } catch (ExcepcionDAO e) {
            e.printStackTrace();
        }
    }


    /*
     * Autor: El Gatopardo
     * Método que devuelve los valores de la cuota actual sugerida (si se encuentra activa) y los
     * valores de la cuota Modificada/Corrección que se encuentre en estado temporal
     */
    public DeclaracionOperadorWSVO consultarCuotasSugeridaModificada(String nit, String numeroContrato, Integer mesDeclararar, Integer anoDeclarar, String tipoReporte) throws ExcepcionAplicacion,
                                                                                                                                                                               ExcepcionDAO {


        if (nit == null || nit.equals("")) {
            throw new ExcepcionAplicacion("Es necesario el nit.");
        }

        if (numeroContrato == null || numeroContrato.equals("")) {
            throw new ExcepcionAplicacion("Es necesario el numero de contrato.");
        }

        if (mesDeclararar == null || mesDeclararar == 0) {
            throw new ExcepcionAplicacion("Es necesario el mes.");
        }

        if (anoDeclarar == null || anoDeclarar == 0) {
            throw new ExcepcionAplicacion("Es necesario el año.");
        }

        //int totalElementos = 0;
        SiiCuotaOperador siiCuotaOperadorDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorGA = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorModificadaDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorModificadaGA = new SiiCuotaOperador();
        /*
        * Objeto donde se va a almacenar la informacion con la que se le va a responder al web services
        */
        DeclaracionOperadorWSVO declaracionOperadorWSVO = new DeclaracionOperadorWSVO();
        //    List<EstablecimientoWSVO> listaEstablecimientoWSVO = new ArrayList<EstablecimientoWSVO>();
        List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO = new ArrayList<ElementoAsociadoWSVO>();


        //Traemos el mes de la declaracion
        SiiMes siiMes = mesDao.buscarMesPorId(mesDeclararar);

        //Buscamos el operador
        SiiPersona siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), nit);

        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una persona por ese numero de nit por favor verifique.");
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());
        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una operador por ese nit por favor verifique.");
        }

        //Traemos el contrato por numero de contrato
        SiiContrato siiContrato = new SiiContrato();
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(numeroContrato, siiOperador.getOpeCodigo());
        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato por ese numero de contrato por favor verifique.");
        }


        //Consultamos el revisor fiscal para el operador
        SiiPersona siiRevisorFiscalPersona = null;
        siiRevisorFiscalPersona = personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(siiOperadorPersona.getPerCodigo(), EnumTipoPersonal.REVISOR_FISCAL.getId());

        //if("P".equals(tipoReporte)){
        siiCuotaOperadorDE = cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConcepto(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);
        siiCuotaOperadorGA = cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConcepto(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "GA", anoDeclarar);

        siiCuotaOperadorModificadaDE =
            cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConceptoXReporteVenta(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "GA", anoDeclarar);
        siiCuotaOperadorModificadaGA =
            cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConceptoXReporteVenta(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "GA", anoDeclarar);

        if ("I".equals(siiCuotaOperadorDE.getCopCancelada())) {
            //Si la liquidación sugerida está inactiva, buscamos la cuota modificada o corregida
        }
        //}
        //Buscamos todas las cuotas de la vigencia y mes que no hayan sido pagadas


        if (siiCuotaOperadorDE.getCopFechaLimPag() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(siiCuotaOperadorDE.getCopFechaLimPag());
            int mes = cal.get(Calendar.MONTH) + 1;

            Calendar calFechaActual = Calendar.getInstance();

            if (mes == calFechaActual.get(Calendar.MONTH) + 1) {
                //Consultamos la liquidacion mensual del operador
                SiiLiquidacionMes siiLiquidacionMesOperador = new SiiLiquidacionMes();
                siiLiquidacionMesOperador =
                    liquidacionMesDao.consultarLiquidacionMesXOperadorXContratoXMesXConcepto(siiOperador.getOpeCodigo(), siiContrato.getConCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);

                //Buscamos la informacion para la columna valor total del establecimiento, que es donde se guardar
                //el valor a pagar del operador para cada establecimiento

                if (siiLiquidacionMesOperador != null && siiLiquidacionMesOperador.getLmeCodigo() != null && siiLiquidacionMesOperador.getLmeCodigo() > 0) {

                    /*
            * Consultamos los instrumentos asociados al contrato y hacemos el conteo de la cantidad de estos elementos
            * activos para la fecha de liquidacion, para luego retornar dicha informacion por el ws*/

                    //Calendar
                    Calendar fechaDeclaracionFin = Calendar.getInstance();
                    fechaDeclaracionFin.set(Calendar.YEAR, anoDeclarar);
                    fechaDeclaracionFin.set(Calendar.MONTH, mesDeclararar);
                    fechaDeclaracionFin.set(Calendar.DAY_OF_MONTH, fechaDeclaracionFin.getActualMaximum(Calendar.DAY_OF_MONTH));

                    Calendar fechaDeclaracionInicio = Calendar.getInstance();
                    fechaDeclaracionInicio.set(Calendar.YEAR, anoDeclarar);
                    fechaDeclaracionInicio.set(Calendar.MONTH, mesDeclararar);
                    fechaDeclaracionInicio.set(Calendar.DAY_OF_MONTH, 1);

                    System.out.println("CONSULTA DE INVENTARIO OPERADOR " + System.currentTimeMillis());
                    long startTime = System.currentTimeMillis();

                    /*   List<SiiInventario> listaInventarios = new ArrayList<SiiInventario>();
                    listaInventarios =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(),
                                                                                  fechaDeclaracionInicio.getTime(),
                                                                                  fechaDeclaracionFin.getTime());*/

                    listaElementosAsociadosWSVO =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(), fechaDeclaracionInicio.getTime(), fechaDeclaracionFin.getTime());
                    System.out.println("TIEMPO CONSULTA INVENTARIO " + String.valueOf(System.currentTimeMillis() - startTime));


                }

            }
        }


        if (siiCuotaOperadorModificadaDE.getCopFechaLimPag() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(siiCuotaOperadorModificadaDE.getCopFechaLimPag());
            int mes = cal.get(Calendar.MONTH) + 1;

            Calendar calFechaActual = Calendar.getInstance();

            if (mes == calFechaActual.get(Calendar.MONTH) + 1) {
                //Consultamos la liquidacion mensual del operador
                SiiLiquidacionMes siiLiquidacionMesOperador = new SiiLiquidacionMes();
                siiLiquidacionMesOperador =
                    liquidacionMesDao.consultarLiquidacionMesXOperadorXContratoXMesXConcepto(siiOperador.getOpeCodigo(), siiContrato.getConCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);

                //Buscamos la informacion para la columna valor total del establecimiento, que es donde se guardar
                //el valor a pagar del operador para cada establecimiento

                if (siiLiquidacionMesOperador != null && siiLiquidacionMesOperador.getLmeCodigo() != null && siiLiquidacionMesOperador.getLmeCodigo() > 0) {

                    /*
            * Consultamos los instrumentos asociados al contrato y hacemos el conteo de la cantidad de estos elementos
            * activos para la fecha de liquidacion, para luego retornar dicha informacion por el ws*/

                    //Calendar
                    Calendar fechaDeclaracionFin = Calendar.getInstance();
                    fechaDeclaracionFin.set(Calendar.YEAR, anoDeclarar);
                    fechaDeclaracionFin.set(Calendar.MONTH, mesDeclararar);
                    fechaDeclaracionFin.set(Calendar.DAY_OF_MONTH, fechaDeclaracionFin.getActualMaximum(Calendar.DAY_OF_MONTH));

                    Calendar fechaDeclaracionInicio = Calendar.getInstance();
                    fechaDeclaracionInicio.set(Calendar.YEAR, anoDeclarar);
                    fechaDeclaracionInicio.set(Calendar.MONTH, mesDeclararar);
                    fechaDeclaracionInicio.set(Calendar.DAY_OF_MONTH, 1);

                    System.out.println("CONSULTA DE INVENTARIO OPERADOR " + System.currentTimeMillis());
                    long startTime = System.currentTimeMillis();

                    /*   List<SiiInventario> listaInventarios = new ArrayList<SiiInventario>();
                    listaInventarios =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(),
                                                                                  fechaDeclaracionInicio.getTime(),
                                                                                  fechaDeclaracionFin.getTime());*/

                    listaElementosAsociadosWSVO =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(), fechaDeclaracionInicio.getTime(), fechaDeclaracionFin.getTime());
                    System.out.println("TIEMPO CONSULTA INVENTARIO " + String.valueOf(System.currentTimeMillis() - startTime));


                }

            }
        }
        //Datos del operador

        declaracionOperadorWSVO.perJurNombreLargo = siiOperadorPersona.getPerJurNombreLargo();
        declaracionOperadorWSVO.perNumIdentificacion = siiOperadorPersona.getPerNumIdentificacion();
        declaracionOperadorWSVO.perTelefono = siiOperadorPersona.getPerTelefono();
        declaracionOperadorWSVO.perEmail = siiOperadorPersona.getPerEmail();
        declaracionOperadorWSVO.tipoIdentificacionEmpresa = siiOperadorPersona.getSiiTipoIdentificacion1().getTidNombre();

        if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.DEPARTAMENTO.getTiuCodigo()) {
            declaracionOperadorWSVO.perDepartamento = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }
        else if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.CIUDAD.getTiuCodigo()) {
            SiiUbicacion siiUbicacionPadre = new SiiUbicacion();
            siiUbicacionPadre = ubicacionDAO.buscarUbicacionPorId(siiOperadorPersona.getSiiUbicacion1().getUbiCodigoPadre());

            declaracionOperadorWSVO.perDepartamento = siiUbicacionPadre.getUbiNombre();
            declaracionOperadorWSVO.perCiudad = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }

        declaracionOperadorWSVO.perDireccion = siiOperadorPersona.getPerDireccion();

        if (siiOperadorPersona.getSiiPersona() != null && siiOperadorPersona.getSiiPersona().getPerCodigo() != null) {

            String representanteLegal = "";

            if (siiOperadorPersona.getSiiPersona().getPerPrimerNombre() != null) {
                representanteLegal += siiOperadorPersona.getSiiPersona().getPerPrimerNombre();
            }

            if (siiOperadorPersona.getSiiPersona().getPerPrimerApellido() != null) {
                representanteLegal += " " + siiOperadorPersona.getSiiPersona().getPerPrimerApellido();
            }

            declaracionOperadorWSVO.representanteLegal = representanteLegal;

            declaracionOperadorWSVO.representanteLegalIdentificacion = siiOperadorPersona.getSiiPersona().getPerNumIdentificacion();
        }

        if (siiRevisorFiscalPersona != null && siiRevisorFiscalPersona.getPerCodigo() != null) {
            declaracionOperadorWSVO.revisorFiscal = siiRevisorFiscalPersona.getPerPrimerNombre() + " " + siiRevisorFiscalPersona.getPerPrimerApellido();
        }

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/NUMERO DELCARACION/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //Consultamos la tabla para saber si es la primera vez que se hace un registro en declaraicon operador sugerida


        List<SiiDeclaracionSugerida> listaDeclaracionSugerida = new ArrayList<SiiDeclaracionSugerida>();
        listaDeclaracionSugerida = declaracionSugeridaDAO.consultaListaSiiDeclaracionSugerida();
        Calendar calendar = Calendar.getInstance();
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();


        if (listaDeclaracionSugerida.size() > 0) {
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            siiDeclaracionSugerida.setDsuConsecutivo(listaDeclaracionSugerida.get(0).getDsuConsecutivo() + 1);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);

        }
        else {
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            siiDeclaracionSugerida.setDsuConsecutivo(141000001);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);
        }


        Integer numeroConsecutivo = siiDeclaracionSugerida.getDsuConsecutivo();


        declaracionOperadorWSVO.numeroDeclaracion = numeroConsecutivo;
        declaracionOperadorWSVO.fechaDeclaracion = calendar.getTime();


        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/NUMERO DELCARACION MODIFICADA/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //Consultamos la tabla para saber si es la primera vez que se hace un registro en declaraicon operador modificada


        List<SiiDeclaracionSugerida> listaDeclaracionModificada = new ArrayList<SiiDeclaracionSugerida>();
        listaDeclaracionModificada = declaracionSugeridaDAO.consultaListaSiiDeclaracionSugerida();
        Calendar calendarModificada = Calendar.getInstance();
        SiiDeclaracionSugerida siiDeclaracionModificada = new SiiDeclaracionSugerida();


        if (listaDeclaracionModificada.size() > 0) {
            siiDeclaracionModificada.setDsuFecha(calendarModificada.getTime());
            siiDeclaracionModificada.setDsuConsecutivo(listaDeclaracionModificada.get(0).getDsuConsecutivo() + 2);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionModificada);
            declaracionOperadorWSVO.idDeclaracionModificada = siiDeclaracionModificada.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionModificadaGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionModificadaDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionModificadaGA.setSiiCuotaOperador(siiCuotaOperadorModificadaGA);
            siiDetalleDeclaracionModificadaGA.setSiiDeclaracionSugerida(siiDeclaracionModificada);
            siiDetalleDeclaracionModificadaGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaDE.setSiiCuotaOperador(siiCuotaOperadorModificadaDE);
            siiDetalleDeclaracionModificadaDE.setSiiDeclaracionSugerida(siiDeclaracionModificada);
            siiDetalleDeclaracionModificadaDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionModificadaGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionModificadaDE);

        }
        else {
            siiDeclaracionModificada.setDsuFecha(calendarModificada.getTime());
            siiDeclaracionModificada.setDsuConsecutivo(141000001);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionModificada);
            declaracionOperadorWSVO.idDeclaracionModificada = siiDeclaracionModificada.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionModificadaGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionModificadaDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionModificadaGA.setSiiCuotaOperador(siiCuotaOperadorModificadaGA);
            siiDetalleDeclaracionModificadaGA.setSiiDeclaracionSugerida(siiDeclaracionModificada);
            siiDetalleDeclaracionModificadaGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaDE.setSiiCuotaOperador(siiCuotaOperadorModificadaDE);
            siiDetalleDeclaracionModificadaDE.setSiiDeclaracionSugerida(siiDeclaracionModificada);
            siiDetalleDeclaracionModificadaDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionModificadaDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionModificadaGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionModificadaDE);
        }


        Integer numeroConsecutivoModificada = siiDeclaracionModificada.getDsuConsecutivo();


        declaracionOperadorWSVO.numeroDeclaracion = numeroConsecutivoModificada;
        declaracionOperadorWSVO.fechaDeclaracion = calendar.getTime();


        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //ElementosAsociados
        declaracionOperadorWSVO.listaElementosAsociadosWSVO = listaElementosAsociadosWSVO;

        //Ingresos reportados
        declaracionOperadorWSVO.ingresosBrutos = new BigDecimal(0);
        declaracionOperadorWSVO.totalVentas = new BigDecimal(0);

        //Total de elementos
        //declaracionOperadorWSVO.numeroTotalElementos = totalElementos;

        //Cupones de pago
        String referenciaPagoDE = "105" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoDE = new Long(referenciaPagoDE);

        String referenciaPagoGA = "205" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoGA = new Long(referenciaPagoGA);

        //Cupones de pago
        String referenciaPagoModificadaDE = "105" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoModificadaDE = new Long(referenciaPagoModificadaDE);

        String referenciaPagoModificadaGA = "205" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoModificadaGA = new Long(referenciaPagoModificadaGA);

        declaracionOperadorWSVO.numeroContrato = siiContrato.getConNumero();
        declaracionOperadorWSVO.fechaSubscripcion = siiContrato.getConFecha();
        declaracionOperadorWSVO.fechaInicioContrato = siiContrato.getConFechaIni();

        //Periodo declarecion y liquidacion
        declaracionOperadorWSVO.anoOperacion = anoDeclarar;
        declaracionOperadorWSVO.mesOperacion = siiMes.getMesNombre();
        declaracionOperadorWSVO.mesCodigo = siiMes.getMesCodigo();
        declaracionOperadorWSVO.numeroCuota = siiCuotaOperadorDE.getCopNumCuota();
        declaracionOperadorWSVO.pagoOportunoHasta = siiCuotaOperadorDE.getCopFechaLimPag();

        return declaracionOperadorWSVO;
    }

    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXCodigoCuotaConDetalle(Long codigoCuota) throws ExcepcionDAO {
        List<DetalleDeclaracionVO> listaDetalleDeclaracionVo = new ArrayList<DetalleDeclaracionVO>();
        List<SiiDetalleDeclaracion> listaDetalleDeclaracion = new ArrayList<SiiDetalleDeclaracion>();
        listaDetalleDeclaracion = detalleDeclaracionDAO.buscarDetalleDeclaracionPorXCodigoCuotaConDetalle(codigoCuota);
        for (SiiDetalleDeclaracion detalleDeclaracion : listaDetalleDeclaracion) {
            listaDetalleDeclaracionVo.add(new DetalleDeclaracionVO(detalleDeclaracion));
        }
        return listaDetalleDeclaracionVo;
    }

    public DeclaracionOperadorWSVO generarDeclaracionOperadorGaDeSeleccion(String nit, String numeroContrato, Integer mesDeclararar, Integer anoDeclarar, String estado) throws ExcepcionAplicacion,
                                                                                                                                                                                ExcepcionDAO {


        if (nit == null || nit.equals("")) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el nit.");
        }

        if (numeroContrato == null || numeroContrato.equals("")) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el numero de contrato.");
        }

        if (mesDeclararar == null || mesDeclararar == 0) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el mes.");
        }

        if (anoDeclarar == null || anoDeclarar == 0) {
            throw new ExcepcionAplicacion("Para poder generar la declaracion del operador es necesario el año.");
        }

        int totalElementos = 0;
        SiiCuotaOperador siiCuotaOperadorDE = new SiiCuotaOperador();
        SiiCuotaOperador siiCuotaOperadorGA = new SiiCuotaOperador();

        /*
            * Objeto donde se va a almacenar la informacion con la que se le va a responder al web services
           */
        DeclaracionOperadorWSVO declaracionOperadorWSVO = new DeclaracionOperadorWSVO();
        //    List<EstablecimientoWSVO> listaEstablecimientoWSVO = new ArrayList<EstablecimientoWSVO>();
        List<ElementoAsociadoWSVO> listaElementosAsociadosWSVO = new ArrayList<ElementoAsociadoWSVO>();
        List<VentasMetCuotaWSVO> listaVentasMetCuotaWSVO = new ArrayList<VentasMetCuotaWSVO>();
        List<VentasMetCuotaWSVO> listaModificacionVentasMetCuotaWSVO = new ArrayList<VentasMetCuotaWSVO>();
        List<SiiResumenNoConectado> listaResumenNoConectado = new ArrayList<SiiResumenNoConectado>();
        /*
            * Variables usadas para los calculos de la declaracion
            */
        //    BigDecimal saldoCuotaDE = new BigDecimal(0);
        //  BigDecimal saldoInteresesDE = new BigDecimal(0);
        // BigDecimal saldoCuotaGA = new BigDecimal(0);
        // BigDecimal saldoInteresesGA = new BigDecimal(0);

        //Traemos el mes de la declaracion
        SiiMes siiMes = new SiiMes();
        siiMes = mesDao.buscarMesPorId(mesDeclararar);
        /*
           * Buscamos el operador
           */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), nit);

        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una persona por ese numero de nit por favor verifique.");
        }

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());
        if (siiOperadorPersona == null || siiOperadorPersona.getPerCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro una operador por ese nit por favor verifique.");
        }

        /*
           * Traemos el contrato por ese numero de contrato
           */
        SiiContrato siiContrato = new SiiContrato();
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(numeroContrato, siiOperador.getOpeCodigo());
        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato por ese numero de contrato por favor verifique.");
        }


        //Consultamos el revisor fiscal para el operador
        SiiPersona siiRevisorFiscalPersona = null;
        siiRevisorFiscalPersona = personaDAO.buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(siiOperadorPersona.getPerCodigo(), EnumTipoPersonal.REVISOR_FISCAL.getId());


        siiCuotaOperadorDE =
            cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar, estado);

        siiCuotaOperadorGA =
            cuotaOperadorDao.buscarCuotaOperadorXContratoXOperadorXMesXConceptoXEstado(siiContrato.getConCodigo(), siiOperador.getOpeCodigo(), siiMes.getMesCodigo(), "GA", anoDeclarar, estado);

        if (siiCuotaOperadorDE.getCopFechaLimPag() != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(siiCuotaOperadorDE.getCopFechaLimPag());
            int mes = cal.get(Calendar.MONTH) + 1;

            Calendar calFechaActual = Calendar.getInstance();
            System.out.println("mes " + mes + " mes actual " + calFechaActual.get(Calendar.MONTH) + 1);

            //if(mes == calFechaActual.get(Calendar.MONTH) + 1) {
            //Consultamos la liquidacion mensual del operador
            SiiLiquidacionMes siiLiquidacionMesOperador = new SiiLiquidacionMes();
            siiLiquidacionMesOperador =
                liquidacionMesDao.consultarLiquidacionMesXOperadorXContratoXMesXConcepto(siiOperador.getOpeCodigo(), siiContrato.getConCodigo(), siiMes.getMesCodigo(), "DE", anoDeclarar);

            //Buscamos la informacion para la columna valor total del establecimiento, que es donde se guardar
            //el valor a pagar del operador para cada establecimiento

            if (siiLiquidacionMesOperador != null && siiLiquidacionMesOperador.getLmeCodigo() != null && siiLiquidacionMesOperador.getLmeCodigo() > 0) {

                /*
            * Consultamos los instrumentos asociados al contrato y hacemos el conteo de la cantidad de estos elementos
            * activos para la fecha de liquidacion, para luego retornar dicha informacion por el ws*/

                //Calendar
                Calendar fechaDeclaracionFin = Calendar.getInstance();
                fechaDeclaracionFin.set(Calendar.YEAR, anoDeclarar);
                fechaDeclaracionFin.set(Calendar.MONTH, mesDeclararar);
                fechaDeclaracionFin.set(Calendar.DAY_OF_MONTH, fechaDeclaracionFin.getActualMaximum(Calendar.DAY_OF_MONTH));

                Calendar fechaDeclaracionInicio = Calendar.getInstance();
                fechaDeclaracionInicio.set(Calendar.YEAR, anoDeclarar);
                fechaDeclaracionInicio.set(Calendar.MONTH, mesDeclararar);
                fechaDeclaracionInicio.set(Calendar.DAY_OF_MONTH, 1);

                System.out.println("CONSULTA DE INVENTARIO OPERADOR " + System.currentTimeMillis());
                long startTime = System.currentTimeMillis();

                /*   List<SiiInventario> listaInventarios = new ArrayList<SiiInventario>();
                    listaInventarios =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(),
                                                                                  fechaDeclaracionInicio.getTime(),
                                                                                  fechaDeclaracionFin.getTime());*/

                /*
                    listaElementosAsociadosWSVO =
                        inventarioDAO.buscarInventarioPorNumContratoFechaVigencia(siiContrato.getConNumero(), fechaDeclaracionInicio.getTime(), fechaDeclaracionFin.getTime());
                    System.out.println("TIEMPO CONSULTA INVENTARIO " + String.valueOf(System.currentTimeMillis() - startTime));
                    */
                listaResumenNoConectado = resumenNoConetadoDao.buscarResumenPorCodigoCuota(siiCuotaOperadorDE.getCopCodigo());

                System.out.println("CONSULTA VENTAS MET CUOTA OPERADOR " + System.currentTimeMillis());
                long inicioVentasMetCuotaOperador = System.currentTimeMillis();
                Calendar fechaInicial = Calendar.getInstance();
                fechaInicial.set(siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo() - 1, 1);
                Calendar fechaFinal = Calendar.getInstance();
                fechaFinal.set(siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo() - 1, fechaInicial.getActualMaximum(Calendar.DAY_OF_MONTH));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String inicial = sdf.format(fechaInicial.getTime());
                String termina = sdf.format(fechaFinal.getTime());
                System.out.println("fecha inicial " + inicial + " fecha final " + termina);
                listaVentasMetCuotaWSVO =
                    cuotaOperadorDao.buscarVentasMetPorCuotaOperador(siiContrato.getConCodigo(), siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), inicial, termina, "P");
                System.out.println("TIEMPO VENTAS MET CUOTA OPERADOR " + String.valueOf(System.currentTimeMillis() - inicioVentasMetCuotaOperador));


                System.out.println("CONSULTA MODIFICACION VENTAS MET CUOTA OPERADOR " + System.currentTimeMillis());
                long inicioModificacionVentasMetCuotaOperador = System.currentTimeMillis();
                listaModificacionVentasMetCuotaWSVO =
                    cuotaOperadorDao.buscarVentasMetPorCuotaOperador(siiContrato.getConCodigo(), siiCuotaOperadorDE.getCopVigencia(), siiCuotaOperadorDE.getMesCodigo(), inicial, termina, "M");
                System.out.println("TIEMPO MODIFICACION VENTAS MET CUOTA OPERADOR " + String.valueOf(System.currentTimeMillis() - inicioModificacionVentasMetCuotaOperador));
            }

            //}
        }

        //Datos del operador

        declaracionOperadorWSVO.perJurNombreLargo = siiOperadorPersona.getPerJurNombreLargo();
        declaracionOperadorWSVO.perNumIdentificacion = siiOperadorPersona.getPerNumIdentificacion();
        declaracionOperadorWSVO.perTelefono = siiOperadorPersona.getPerTelefono();
        declaracionOperadorWSVO.perEmail = siiOperadorPersona.getPerEmail();
        declaracionOperadorWSVO.opeCodigo = siiOperador.getOpeCodigo();
        declaracionOperadorWSVO.tipoIdentificacionEmpresa = siiOperadorPersona.getSiiTipoIdentificacion1().getTidNombre();

        if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.DEPARTAMENTO.getTiuCodigo()) {
            declaracionOperadorWSVO.perDepartamento = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }
        else if (siiOperadorPersona.getSiiUbicacion1().getSiiTipoUbicacion().getTiuCodigo() == EnumTipoUbicacion.CIUDAD.getTiuCodigo()) {
            SiiUbicacion siiUbicacionPadre = new SiiUbicacion();
            siiUbicacionPadre = ubicacionDAO.buscarUbicacionPorId(siiOperadorPersona.getSiiUbicacion1().getUbiCodigoPadre());

            declaracionOperadorWSVO.perDepartamento = siiUbicacionPadre.getUbiNombre();
            declaracionOperadorWSVO.perCiudad = siiOperadorPersona.getSiiUbicacion1().getUbiNombre();
        }

        declaracionOperadorWSVO.perDireccion = siiOperadorPersona.getPerDireccion();

        if (siiOperadorPersona.getSiiPersona() != null && siiOperadorPersona.getSiiPersona().getPerCodigo() != null) {

            String representanteLegal = "";

            if (siiOperadorPersona.getSiiPersona().getPerPrimerNombre() != null) {
                representanteLegal += siiOperadorPersona.getSiiPersona().getPerPrimerNombre();
            }

            if (siiOperadorPersona.getSiiPersona().getPerPrimerApellido() != null) {
                representanteLegal += " " + siiOperadorPersona.getSiiPersona().getPerPrimerApellido();
            }

            declaracionOperadorWSVO.representanteLegal = representanteLegal;

            declaracionOperadorWSVO.representanteLegalIdentificacion = siiOperadorPersona.getSiiPersona().getPerNumIdentificacion();
        }

        if (siiRevisorFiscalPersona != null && siiRevisorFiscalPersona.getPerCodigo() != null) {
            declaracionOperadorWSVO.revisorFiscal = siiRevisorFiscalPersona.getPerPrimerNombre() + " " + siiRevisorFiscalPersona.getPerPrimerApellido();
        }

        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/NUMERO DELCARACION/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/


        //Consultamos la tabla para saber si es la primera vez que se hace un registro en declaraicon operador sugerida


        List<SiiDeclaracionSugerida> listaDeclaracionSugerida = new ArrayList<SiiDeclaracionSugerida>();
        listaDeclaracionSugerida = declaracionSugeridaDAO.consultaListaSiiDeclaracionSugerida();
        Calendar calendar = Calendar.getInstance();
        SiiDeclaracionSugerida siiDeclaracionSugerida = new SiiDeclaracionSugerida();

        if (listaDeclaracionSugerida.size() > 0) {
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            siiDeclaracionSugerida.setDsuConsecutivo(listaDeclaracionSugerida.get(0).getDsuConsecutivo() + 1);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();


            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));


            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);

        }
        else {
            siiDeclaracionSugerida.setDsuFecha(calendar.getTime());
            siiDeclaracionSugerida.setDsuConsecutivo(141000001);
            declaracionSugeridaDAO.insertarSiiDeclaracionSugerida(siiDeclaracionSugerida);
            declaracionOperadorWSVO.idDeclaracionSugerida = siiDeclaracionSugerida.getDsuCodigo();

            /*
             * Cuando hacen la consulta de la declaracion sugerida debemos hacer el registro del detalle de esa declaraicon
             * sugerida para saber cuales fueron las cantidades que se declararon
             */
            SiiDetalleDeclaracionSug siiDetalleDeclaracionGA = new SiiDetalleDeclaracionSug();
            SiiDetalleDeclaracionSug siiDetalleDeclaracionDE = new SiiDetalleDeclaracionSug();

            siiDetalleDeclaracionGA.setSiiCuotaOperador(siiCuotaOperadorGA);
            siiDetalleDeclaracionGA.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionGA.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionGA.setDdsValorInteres(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setSiiCuotaOperador(siiCuotaOperadorDE);
            siiDetalleDeclaracionDE.setSiiDeclaracionSugerida(siiDeclaracionSugerida);
            siiDetalleDeclaracionDE.setDdsValor(new BigDecimal("0"));
            siiDetalleDeclaracionDE.setDdsValorInteres(new BigDecimal("0"));

            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionGA);
            detalleDeclaracionSugDAO.insertar(siiDetalleDeclaracionDE);
        }

        Integer numeroConsecutivo = siiDeclaracionSugerida.getDsuConsecutivo();


        declaracionOperadorWSVO.numeroDeclaracion = numeroConsecutivo;
        declaracionOperadorWSVO.fechaDeclaracion = calendar.getTime();
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/FIN /_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
        //_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/

        BigDecimal liquidacionTarifaFija = new BigDecimal("0");
        BigDecimal liquidacionTarifaVariable = new BigDecimal("0");
        BigDecimal modificacionLiquidacionTarifaVariable = new BigDecimal("0");

        Long elementosTarifaFija = 0L;
        Long elementosTarifaVariable = 0L;
        Long modificacionElementosTarifaVariable = 0L;

        BigDecimal numeroDiasALiquidar = new BigDecimal(0);
        BigDecimal maximoDiaLiq = new BigDecimal(1);

        List<OficioLiquidacionPrevioVO> miListaInventarioVo = null;

        miListaInventarioVo = liquidacionMesDao.buscarInventarioPorContrato(siiContrato.getConCodigo());
        DuplaVO miDupla =
            adminLiquidacionMes.calcularDiasALiquidar(anoDeclarar, siiCuotaOperadorDE.getMesCodigo(), miListaInventarioVo.get(0).getFechaInicioLiq(), miListaInventarioVo.get(0).getFechaFinLiq(),
                                                      siiContrato.getConFechaIni(), siiContrato.getConFechaFin());
        if (miDupla != null) {
            numeroDiasALiquidar = miDupla.getValor();
            maximoDiaLiq = new BigDecimal(miDupla.getConcepto());
        }

        for (SiiResumenNoConectado resumenNoConectado : listaResumenNoConectado) {
            ElementoAsociadoWSVO elementoAsociadoWSVO = new ElementoAsociadoWSVO();
            if (resumenNoConectado.getSiiTipoApuesta() != null) {
                elementosTarifaFija = resumenNoConectado.getRncNumElemen().longValue() + elementosTarifaFija;
                liquidacionTarifaFija = resumenNoConectado.getRncValorDe().add(liquidacionTarifaFija);
                elementoAsociadoWSVO.setTipoApuesta(resumenNoConectado.getSiiTipoApuesta().getTapCodigo());
                elementoAsociadoWSVO.setValorDerechosExp(resumenNoConectado.getRncValorDe());
                elementoAsociadoWSVO.setVentasMet(resumenNoConectado.getRncValorTarifa());
                elementoAsociadoWSVO.setNombreApuesta(resumenNoConectado.getSiiTipoApuesta().getTapNombre());
                elementoAsociadoWSVO.setCantidadElemento(resumenNoConectado.getRncNumElemen().longValue());
                listaElementosAsociadosWSVO.add(elementoAsociadoWSVO);

            }
        }
        /*
        for(ElementoAsociadoWSVO elementosAsociadosWSVo : listaElementosAsociadosWSVO) {
                    elementosAsociadosWSVo.setValorDerechosExp(elementosAsociadosWSVo.getVentasMet().multiply(numeroDiasALiquidar));
                    elementosAsociadosWSVo.setVentasMet(elementosAsociadosWSVo.getVentasMet().multiply(new BigDecimal(31)));
        }

        for(ElementoAsociadoWSVO elementosAsociadosWSVo : listaElementosAsociadosWSVO) {
            elementosTarifaFija = elementosAsociadosWSVo.getCantidadElemento() + elementosTarifaFija;
            liquidacionTarifaFija = elementosAsociadosWSVo.getValorDerechosExp().add(liquidacionTarifaFija);
        }
        */
        for (VentasMetCuotaWSVO ventasMetCuotaWSVo : listaVentasMetCuotaWSVO) {
            elementosTarifaVariable = elementosTarifaVariable + 1;
            if (ventasMetCuotaWSVo.getVmeLiqEfectiva() != null) {
                liquidacionTarifaVariable = ventasMetCuotaWSVo.getVmeLiqEfectiva().add(liquidacionTarifaVariable);
            }
        }

        for (VentasMetCuotaWSVO ventasModificadasMetCuotaWSVo : listaModificacionVentasMetCuotaWSVO) {
            modificacionElementosTarifaVariable = modificacionElementosTarifaVariable + 1;
            if (ventasModificadasMetCuotaWSVo.getVmeLiqEfectiva() != null) {
                modificacionLiquidacionTarifaVariable = ventasModificadasMetCuotaWSVo.getVmeLiqEfectiva().add(modificacionLiquidacionTarifaVariable);
            }
        }

        //Reporte Ventas Met Cuota Operador
        declaracionOperadorWSVO.listaVentasMetCuotaWSVO = listaVentasMetCuotaWSVO;
        //Elementos Asociados
        declaracionOperadorWSVO.listaElementosAsociadosWSVO = listaElementosAsociadosWSVO;
        //Modificacion Reporte Ventas Met
        declaracionOperadorWSVO.listaModificacionVentasMetCuotaWSVO = listaModificacionVentasMetCuotaWSVO;

        //Ingresos reportados
        declaracionOperadorWSVO.ingresosBrutos = new BigDecimal(0);
        declaracionOperadorWSVO.totalVentas = new BigDecimal(0);

        //Total de elementos
        declaracionOperadorWSVO.numeroTotalElementos = totalElementos;

        //Cupones de pago
        String referenciaPagoDE = "105" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoDE = new Long(referenciaPagoDE);

        String referenciaPagoGA = "205" + numeroConsecutivo;
        declaracionOperadorWSVO.referenciaPagoGA = new Long(referenciaPagoGA);

        declaracionOperadorWSVO.numeroContrato = siiContrato.getConNumero();
        declaracionOperadorWSVO.conCodigo = siiContrato.getConCodigo();
        declaracionOperadorWSVO.fechaSubscripcion = siiContrato.getConFecha();
        declaracionOperadorWSVO.fechaInicioContrato = siiContrato.getConFechaIni();

        //Periodo declarecion y liquidacion
        declaracionOperadorWSVO.anoOperacion = anoDeclarar;
        declaracionOperadorWSVO.mesOperacion = siiMes.getMesNombre();
        declaracionOperadorWSVO.mesCodigo = siiMes.getMesCodigo();
        declaracionOperadorWSVO.numeroCuota = siiCuotaOperadorDE.getCopNumCuota();
        declaracionOperadorWSVO.pagoOportunoHasta = siiCuotaOperadorDE.getCopFechaLimPag();


        //Liquidación Tarifa Fija y Liquidación Tarifa Variable
        declaracionOperadorWSVO.tarifaFija = Utilidades.redondear(liquidacionTarifaFija, 0);
        declaracionOperadorWSVO.totalElementosTarifaFija = elementosTarifaFija;
        declaracionOperadorWSVO.totalElementosTarifaVariable = elementosTarifaVariable;
        declaracionOperadorWSVO.tarifaVariable = Utilidades.redondear(liquidacionTarifaVariable, 0);
        declaracionOperadorWSVO.totalElementosTarifaVariableModificada = modificacionElementosTarifaVariable;
        declaracionOperadorWSVO.tarifaVariableModificada = Utilidades.redondear(modificacionLiquidacionTarifaVariable, 0);
        return declaracionOperadorWSVO;
    }


    /**
     * Calcula el valor Ejecutado del Contrato especificado.
     * @param conCodigo - C&oacute;digo del Contrato.
     * @return Sumatoria de valores liquidados de cada registro de Liquidaci&oacute;n.
     * @throws ExcepcionDAO
     */
    @Override
    public BigDecimal calcularValorEjecutadoContrato(Long conCodigo) throws ExcepcionDAO {
        BigDecimal valorEjecutado = null;

        if (conCodigo != null) {
            ContratoVO contratoVo = this.buscarContratoPorId(conCodigo);
            if (contratoVo != null)
                valorEjecutado = this.calcularValorEjecutadoContrato(contratoVo);
        }

        return (valorEjecutado);
    }


    /**
     * Calcula el valor Ejecutado del Contrato especificado.
     * @param contratoVo - Contrato.
     * @return Sumatoria de valores liquidados de cada registro de Liquidaci&oacute;n.
     * @throws ExcepcionDAO
     */
    @Override
    public BigDecimal calcularValorEjecutadoContrato(ContratoVO contratoVo) throws ExcepcionDAO {
        BigDecimal valorEjecutado = new BigDecimal(0);

        if (contratoVo != null && contratoVo.getConCodigo() != null && contratoVo.getConFechaIni() != null) {
            
            valorEjecutado = this.calculoValorLiquidadoContratoConcesion(contratoVo);
            
            /*
            Date fechaActual = new Date(System.currentTimeMillis());
            // Busca los registros de liquidacion mes asociados al contrato
            List<LiquidacionMesVO> liquidacionMesListVo = adminLiquidacionMes.obtenerLiquidacionPorContratoYConceptos(contratoVo.getConCodigo(), contratoVo.getConFechaIni(), fechaActual);

            if (liquidacionMesListVo != null && !liquidacionMesListVo.isEmpty()) {
                Map<Long, List<CuotaOperadorVO>> mapaCuotaOperadorPorLiqMes = new HashMap<Long, List<CuotaOperadorVO>>();

                for (LiquidacionMesVO liqMesVo : liquidacionMesListVo) {
                    if (liqMesVo != null && liqMesVo.getLiqConcepto() != null && liqMesVo.getLmeCodigo() != null) {
                        List<CuotaOperadorVO> listaCuotaOperador = mapaCuotaOperadorPorLiqMes.get(liqMesVo.getLmeCodigo());
                        if (listaCuotaOperador == null) {
                            listaCuotaOperador = adminCuotaOperador.buscarCuotaOperadorXIdLiquidacion(liqMesVo.getLmeCodigo());

                            if (listaCuotaOperador != null && !listaCuotaOperador.isEmpty())
                                mapaCuotaOperadorPorLiqMes.put(liqMesVo.getLmeCodigo(), listaCuotaOperador);
                        }

                        if (listaCuotaOperador != null && !listaCuotaOperador.isEmpty()) {
                            // Sumar unicamente el valor de aquellas cuotas en estado ACTIVO o CANCELADO.
                            Iterator<CuotaOperadorVO> itCO = listaCuotaOperador.iterator();
                            boolean encontrado = false;
                            while (itCO.hasNext() && !encontrado) {
                                CuotaOperadorVO cuotaOperadorVo = itCO.next();
                                if (cuotaOperadorVo != null && cuotaOperadorVo.getCopCancelada() != null && cuotaOperadorVo.getCopValor() != null) {
                                    if (EnumEstadoCuotaOperador.ACTIVA.getId().equals(cuotaOperadorVo.getCopCancelada()) ||
                                        EnumEstadoCuotaOperador.CANCELADA.getId().equals(cuotaOperadorVo.getCopCancelada())) {
                                        valorEjecutado = valorEjecutado.add(cuotaOperadorVo.getCopValor());
                                        encontrado = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            */
        }

        return (valorEjecutado);
    }


    @Override
    public ContratoVO insertarContrato(ContratoVO contratoVo) throws ExcepcionDAO {
        ContratoVO resultado = null;
        SiiContrato siiContrato = contratoDAO.insertarSiiContrato(conversionVoEntidad.convertir(contratoVo));
        if (siiContrato != null)
            resultado = new ContratoVO(siiContrato);

        return (resultado);
    }


    @Override
    public ContratoVO actualizarContrato(ContratoVO contratoVo) throws ExcepcionDAO {
        ContratoVO resultado = null;
        SiiContrato siiContrato = contratoDAO.actualizarSiiContrato(conversionVoEntidad.convertir(contratoVo));
        if (siiContrato != null)
            resultado = new ContratoVO(siiContrato);

        return (resultado);
    }
    
    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXVigenciaMesConNumero  (Integer vigencia, Integer mes, String conNumero) throws ExcepcionDAO {
        List<DetalleDeclaracionVO> listaDetalleDeclaracionVo = new ArrayList<DetalleDeclaracionVO>();
        List<SiiDetalleDeclaracion> listaDetalleDeclaracion = new ArrayList<SiiDetalleDeclaracion>();
        listaDetalleDeclaracion = detalleDeclaracionDAO.buscarDetalleDeclaracionPorXVigenciaMesConNumero( vigencia, mes, conNumero);
        for (SiiDetalleDeclaracion detalleDeclaracion : listaDetalleDeclaracion) {
            listaDetalleDeclaracionVo.add(new DetalleDeclaracionVO(detalleDeclaracion));
        }
        return listaDetalleDeclaracionVo;
    }
    
    public List<EstadoCuentaVO> estadoMultasSanciones(String nit, Date fechaCorte) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = contratoDAO.estadoMultasSanciones(nit, fechaCorte, null);
        return estadoCuentaVO;
    }
    
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // METODOS PARA LA CONSULTA DEL ESTADO DE CUENTA, CON LA DEPURACION DE LA LISTA RESULTANTE //
    /////////////////////////////////////////////////////////////////////////////////////////////
    
    /**
     * Realiza la consulta del ESTADO DE CUENTA por medio del Contrato (<i>PROCESANDO LA LISTA RESULTANTE</i>).
     * @param contrato - Contrato.
     * @param concepto - Concepto.
     * @param unaFechaCorte - Fecha de Corte.
     * @param isOrderTipo - Flag que determina si se debe realizar ordenamiento en la lista resultante.
     * @throws Exception
     */
    public List<EstadoCuentaVO> consultarEstadoCuenta (String contrato, Integer concepto, Date unaFechaCorte, boolean isOrderTipo) throws Exception
    {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList();
        
        System.out.println("Consultando estado de cuenta " + (contrato.equals("") ? "" : ("contrato " + contrato)));
        List<EstadoCuentaVO> unaListaEstadoCuentaVo = this.estadoCuenta(contrato, concepto, unaFechaCorte, isOrderTipo);
        listaFiltradaRetorno = this.procesarLista(unaListaEstadoCuentaVo, unaFechaCorte);
        
        return listaFiltradaRetorno;
    }
    
    
    /**
     * Realiza la consulta del ESTADO DE CUENTA por medio del Contrato y NIT (<i>PROCESANDO LA LISTA RESULTANTE</i>)..
     * @param contrato - Contrato.
     * @param concepto - Concepto.
     * @param unaFechaCorte - Fecha de Corte.
     * @param isOrderTipo - Flag que determina si se debe realizar ordenamiento en la lista resultante.
     * @param nit - NIT.
     * @throws Exception
     */
    public List<EstadoCuentaVO> consultarEstadoCuentaNit (String contrato, Integer concepto, Date unaFechaCorte, boolean isOrderDesc, String nit) throws Exception
    {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList();
        
        System.out.println("Consultando estado de cuenta " + (contrato.equals("") ? "" : ("contrato " + contrato)));
        List<EstadoCuentaVO> unaListaEstadoCuentaVo = this.estadoCuentaNit(contrato, concepto, unaFechaCorte, isOrderDesc, nit);
        listaFiltradaRetorno = this.procesarLista(unaListaEstadoCuentaVo, unaFechaCorte);
        
        return listaFiltradaRetorno;
    }
    
    
    /**
     *Metodo encargado de hacer la consulta del estado de cuenta para los conceptos diferentes a GA y DE
     * Adaptacion por : David Tafur
     * @param contrato - Contrato.
     * @param unaFechaCorte - Fecha de Corte.
     * @return Listado de registros que conforman el <b>ESTADO DE CUENTA</b>.
     * @throws Exception
     */
    public List<EstadoCuentaVO> consultarEstadoCuentaLiquidacionOtrosConceptos(String contrato, Date unaFechaCorte) throws Exception
    {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList();
        
        System.out.println("Consultando estado de cuenta otros conceptos " + (contrato.equals("") ? "" : ("contrato " + contrato)));
        List<EstadoCuentaVO> unaListaEstadoCuentaVo = this.estadoCuentaLiquidacionOtrosConceptos(contrato, unaFechaCorte);
        listaFiltradaRetorno = this.procesarLista(unaListaEstadoCuentaVo, unaFechaCorte);
        
        return listaFiltradaRetorno;
    }
    
    
    /**
     * Procesa el listado de Estado de Cuenta a la Fecha de Corte suministrada.
     * @param listaEntrada - Estado de Cuenta que se procesar&aacute;.
     * @param unaFechaCorte - Fecha de Corte.
     * @return Listado de Estado de Cuenta procesado.
     * @throws Exception
     */
    public List<EstadoCuentaVO> procesarLista (List<EstadoCuentaVO> listaEntrada, Date unaFechaCorte) throws Exception 
    {
        List<EstadoCuentaVO> listaFiltradaRetorno = new ArrayList<EstadoCuentaVO>();
        List<EstadoCuentaVO> copiaListaParaSuma = new ArrayList();
        
        for(EstadoCuentaVO unEstadoCopia : listaEntrada){
            //Si no hay contrato, es multa o sanción y debe tener resolucion
            if(unEstadoCopia.getContrato() == null){
                unEstadoCopia.setContrato(unEstadoCopia.getResolucion());
            }
            copiaListaParaSuma.add(unEstadoCopia);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String strUnaFechaCorte = formatter.format(unaFechaCorte);
        long elapsedTimeMark = 0;
        Long lUnaFechaCorte = new Long(strUnaFechaCorte);
        try {
            List<EstadoCuentaVO> unaListaEstadoCuentaVo = listaEntrada;
            EstadoCuentaVO estadoOld = new EstadoCuentaVO();
            System.out.println("Empezando analisis");
            long startTimeSetMark = System.currentTimeMillis();
            for (int i = 0; i < unaListaEstadoCuentaVo.size(); i++) {
                EstadoCuentaVO estadoActual = unaListaEstadoCuentaVo.get(i);
                if (i != 0) {
                    estadoOld = unaListaEstadoCuentaVo.get(i - 1);
                }
                //Pone ceros a las cuotas operador repetidas
                if (estadoOld != null) {
                    if (estadoActual.getContrato().equals(estadoOld.getContrato()) &&
                        estadoActual.getCuota().equals(estadoOld.getCuota()) &&
                        estadoActual.getDescripcionConcepto().equals(estadoOld.getDescripcionConcepto()) &&
                        estadoActual.getRazonSocial().equals(estadoOld.getRazonSocial()) && !estadoActual.getCancelada().equals("T") && !estadoActual.getCancelada().equals("A") ) {
                        estadoActual.setMonto_obligacion(new BigDecimal(-9999999999999999D));
                    }
                }

                String conNumero = estadoActual.getContrato();
                BigDecimal numCuota = estadoActual.getCuota();
                String razonSocial = estadoActual.getRazonSocial();
                BigDecimal numConcepto = null;

                numConcepto = estadoActual.getCodigoConcepto();

                //Hace la suma del total pagado
                BigDecimal totalPagado = BigDecimal.ZERO;

                boolean barriendoIguales = false;
                List<EstadoCuentaVO> listaEstadosParaRetirar = new ArrayList<EstadoCuentaVO>();

                
                for (EstadoCuentaVO unEstado : copiaListaParaSuma) {
                    if (unEstado.getContrato().equals(conNumero) && 
                            unEstado.getCuota().equals(numCuota) &&
                            unEstado.getCodigoConcepto().equals(numConcepto) &&
                            unEstado.getRazonSocial().equals(razonSocial)) {
                        totalPagado = totalPagado.add(unEstado.getMonto_pago());
                        listaEstadosParaRetirar.add(unEstado);
                        barriendoIguales = true;
                    } else if (barriendoIguales) { //Ya terminó el barrido y paso por aca
                        break;
                    }
                }
                //Retiramos de la copia de la lista los elementos ya procesados
                for(EstadoCuentaVO unEstadoRetirar : listaEstadosParaRetirar){
                    copiaListaParaSuma.remove(unEstadoRetirar);
                }

                estadoActual.setTotal_pagado(totalPagado);

                if (estadoActual.getTotalTodosInteres() == null) {
                    estadoActual.setTotalTodosInteres(BigDecimal.ZERO);
                }
                if (estadoActual.getPagado_interes() == null) {
                    estadoActual.setPagado_interes(BigDecimal.ZERO);
                }

                estadoActual.setTotalTodosSaldoInteres(estadoActual.getTotalTodosInteres().subtract(estadoActual.getPagado_interes()));
                if (estadoActual.getTotalTodosSaldoInteres().doubleValue() < 0D && lUnaFechaCorte > 20131231235959L) {
                    estadoActual.setRecaudoInteresPorClasificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoInteresPorClasificar(estadoActual.getRecaudoInteresPorClasificar().subtract(estadoActual.getTotalTodosSaldoInteres()));
                    estadoActual.setTotalTodosSaldoInteres(BigDecimal.ZERO);
                }

                estadoActual.setSaldo(estadoActual.getMonto_obligacion().subtract(totalPagado));
                if (estadoActual.getSaldo().doubleValue() < 0D && lUnaFechaCorte > 20131231235959L) {
                    estadoActual.setRecaudoPorCalsificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoPorCalsificar(estadoActual.getRecaudoPorCalsificar().subtract(estadoActual.getSaldo()));
                    estadoActual.setSaldo(BigDecimal.ZERO);
                }
                listaFiltradaRetorno.add(estadoActual);

            }

            //Quita los saldos repetidos
            for (int i = 0; i < listaFiltradaRetorno.size(); i++) {
                EstadoCuentaVO estadoActual = unaListaEstadoCuentaVo.get(i);
                if (estadoActual.getMonto_obligacion().equals(new BigDecimal(-9999999999999999D))) {
                    estadoActual.setMonto_obligacion(BigDecimal.ZERO);
                    estadoActual.setSaldo(BigDecimal.ZERO);
                    estadoActual.setTotalTodosInteres(BigDecimal.ZERO);
                    estadoActual.setPagado_interes(BigDecimal.ZERO);
                    estadoActual.setTotalTodosSaldoInteres(BigDecimal.ZERO);
                    estadoActual.setRecaudoInteresPorClasificar(BigDecimal.ZERO);
                    estadoActual.setRecaudoPorCalsificar(BigDecimal.ZERO);
                }
            }
            long stopTimeSetMark = System.currentTimeMillis();
            elapsedTimeMark += (stopTimeSetMark - startTimeSetMark);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Tiempo marcacion: " + elapsedTimeMark + " mseg.");
        return listaFiltradaRetorno;
    }
    

    @Schedule(month = "01",dayOfMonth = "01", hour = "01" ,minute = "00" ) //Para probar cada 5 minutos usar minute = "*/5", hour = "*"
   // @Schedule(hour = "00" ,minute = "30" )

    public void actualizacionMultasySanciones() {
        List<EstadoCuentaVO> listaEstadoCuentaVo = null;
        
        Calendar fechaActual = Calendar.getInstance();
        Integer anyoActual = new Integer(fechaActual.get(Calendar.YEAR));
        
        try{
            SiiActualizacionMulta siiActualizacionMultaActual = actualizacionMultaDao.buscarActualizacionMultaPorVigencia(anyoActual);
            if(siiActualizacionMultaActual != null){
                adminLogGeneral.logConsola("Ya existe la actualización de multas para la vigencia " + anyoActual);
                return;
            }
        } catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        
        Calendar primeroEneroActual = Calendar.getInstance();
        primeroEneroActual.set(Calendar.MONTH, 0);
        primeroEneroActual.set(Calendar.DAY_OF_MONTH, 1);
        primeroEneroActual.set(Calendar.HOUR_OF_DAY, 0);
        primeroEneroActual.set(Calendar.MINUTE, 0);
        primeroEneroActual.set(Calendar.SECOND, 0);
        Integer vigenciaAnyoAnterior = primeroEneroActual.get(Calendar.YEAR) - 1;
        Long numcuotasConInteres = 0L;
        
        while(numcuotasConInteres == 0){
            try{
                SiiSmmlv siiSmmlv = smmlvDao.buscarSmmlvPorId(vigenciaAnyoAnterior);
                if (siiSmmlv == null) {
                    adminLogGeneral.logConsola("No se encontró el SMMLV para la vigencia " + vigenciaAnyoAnterior);
                    throw new ExcepcionAplicacion("No se encontró el SMMLV para la vigencia " + vigenciaAnyoAnterior);
                }
                else if (siiSmmlv.getSmmIpc() == null){
                    adminLogGeneral.logConsola("No se encontró el IPC para la vigencia " + vigenciaAnyoAnterior);
                    throw new ExcepcionAplicacion("No se encontró el IPC para la vigencia " + vigenciaAnyoAnterior);
                }
                
                SiiActualizacionMulta siiActualizacionMulta = null;
        
                numcuotasConInteres = interesCuotaDao.buscarNumeroInteresesPorDia(primeroEneroActual.getTime());
                if (numcuotasConInteres > 0) {
                    
                    List<SiiCuotaOperador> listSiiCuotaOperador = cuotaOperadorDao.buscarCuotaOperadorXCategoriaCuota("ACTUACIONES ADMINISTRATIVAS");
        
                    //Itera en cada una de las cuotas
                    for (SiiCuotaOperador siiCuotaOperador : listSiiCuotaOperador) {
                        
                        //busca estado de cuenta  por cuota
                        listaEstadoCuentaVo = contratoDAO.estadoMultasSanciones("", primeroEneroActual.getTime(), siiCuotaOperador.getCopCodigo());
                        
                        if (listaEstadoCuentaVo.size()>0 && listaEstadoCuentaVo.get(0).getFechaResolucion() != null){
                        
                                if(listaEstadoCuentaVo == null || listaEstadoCuentaVo.size() == 0){
                                    continue;
                                }
                                
                                if(listaEstadoCuentaVo.get(0).getFechaResolucion() == null){
                                    continue;
                                }
                                
                                Calendar calFechaEjecutora = Calendar.getInstance();
                                calFechaEjecutora.setTime(listaEstadoCuentaVo.get(0).getFechaResolucion()); //fecha ejecutora
                                Integer vigenciaResolucion = new Integer(calFechaEjecutora.get(Calendar.YEAR));
                                Integer diferenciaAnyos = anyoActual - vigenciaResolucion;
                                
                                int numPagos = 0;
                                for (EstadoCuentaVO estadoCuentaVo : listaEstadoCuentaVo) {
                                    if (estadoCuentaVo.getMonto_pago() != null && estadoCuentaVo.getMonto_pago().doubleValue() > 0 && estadoCuentaVo.getFecha_pago() != null ) {
                                        Calendar fechaPago = Calendar.getInstance();
                                        fechaPago.setTime(estadoCuentaVo.getFecha_pago());
                                        Integer anyoPago = fechaPago.get(Calendar.YEAR);
                                        if(anyoPago.intValue() == vigenciaAnyoAnterior.intValue()){
                                            numPagos++;
                                        }
                                    }
                                }
                                
                                BigDecimal saldo = BigDecimal.ZERO;
                                BigDecimal incremento = BigDecimal.ZERO;
                                Date fechaUltimoPago = new Date();
                                boolean primerPagoProcesado = false;
                                BigDecimal saldoIni = BigDecimal.ZERO;
                                Date fechaSaldo = new Date();
                                
                                Calendar calFinAnyoAnterior = Calendar.getInstance();
                                calFinAnyoAnterior.set(Calendar.YEAR, anyoActual - 1);
                                calFinAnyoAnterior.set(Calendar.MONTH, 11);
                                calFinAnyoAnterior.set(Calendar.DAY_OF_MONTH, 31);
                                calFinAnyoAnterior.set(Calendar.HOUR_OF_DAY, 23);
                                calFinAnyoAnterior.set(Calendar.MINUTE, 59);
                                calFinAnyoAnterior.set(Calendar.SECOND, 59);
                                Date fechaUltimoDiaAnyoAnterior = calFinAnyoAnterior.getTime();
                                calFinAnyoAnterior.add(Calendar.YEAR, -1);
                                Date fechaUltimoDiaDosAnyosAntes = calFinAnyoAnterior.getTime();
                                
                                if (diferenciaAnyos == 1) {
                                    saldoIni = listaEstadoCuentaVo.get(0).getMonto_obligacion();
                                    fechaSaldo = listaEstadoCuentaVo.get(0).getFechaResolucion();
                                }
                                else{
                                    //Consultar el estado de cuenta del 31/dic de dos años anteriores
                                    List<EstadoCuentaVO> listaEstadoCuentaDosAnyosVo = contratoDAO.estadoMultasSanciones("", fechaUltimoDiaDosAnyosAntes, siiCuotaOperador.getCopCodigo());
                                    if(listaEstadoCuentaDosAnyosVo == null || listaEstadoCuentaDosAnyosVo.size() == 0){
                                        adminLogGeneral.logConsola("No se encontró el estado de cuenta de dos años antes para la cuota " + siiCuotaOperador.getCopCodigo());
                                        continue;
                                    }
                                    saldoIni = listaEstadoCuentaDosAnyosVo.get(0).getSaldo();
                                    fechaSaldo = fechaUltimoDiaDosAnyosAntes;
                                }
                                
                                BigDecimal BD_MILLSECS_PER_DAY = new BigDecimal(MILLSECS_PER_DAY);
                                
                                if(numPagos > 0){
                                    //Itera en las entradas del estado de cuenta para la cuota
                                    for (EstadoCuentaVO estadoCuentaVo : listaEstadoCuentaVo) {
                                        BigDecimal diasSaldo = BigDecimal.ZERO;
                                        
                                        if (numPagos > 0) {
                                            if (estadoCuentaVo.getMonto_pago() != null && estadoCuentaVo.getMonto_pago().doubleValue() == 0) {
                                                //No hay pago, continúa con la siguiente entrada
                                                continue;
                                            }
                                            
                                            numPagos--;
                                            
                                            if(!primerPagoProcesado){
                                                primerPagoProcesado = true;
                                                
                                                diasSaldo = (new BigDecimal(estadoCuentaVo.getFecha_pago().getTime() - fechaSaldo.getTime())).divide(BD_MILLSECS_PER_DAY, 0, RoundingMode.HALF_UP);
                                                BigDecimal fraccionAnyo = diasSaldo.divide(new BigDecimal(365), 9, RoundingMode.HALF_UP);
                                                incremento = saldoIni.multiply(siiSmmlv.getSmmIpc()).multiply(fraccionAnyo).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
                                                saldo = saldoIni.subtract(estadoCuentaVo.getMonto_pago());
                                            }
                                            else{
                                                diasSaldo = (new BigDecimal(estadoCuentaVo.getFecha_pago().getTime() - fechaUltimoPago.getTime())).divide(BD_MILLSECS_PER_DAY, 0, RoundingMode.HALF_UP);
                                                BigDecimal fraccionAnyo = diasSaldo.divide(new BigDecimal(365), 9, RoundingMode.HALF_UP);
                                                incremento = incremento.add((saldo.multiply(siiSmmlv.getSmmIpc())).multiply(fraccionAnyo).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP));
                                                saldo = saldo.subtract(estadoCuentaVo.getMonto_pago());
                                            }
                                            
                                            fechaUltimoPago = estadoCuentaVo.getFecha_pago();
                                            if(numPagos == 0 && saldo.doubleValue() > 0){
                                                //Se procesa la última fracción de año
                                                diasSaldo = (new BigDecimal(fechaUltimoDiaAnyoAnterior.getTime() - fechaUltimoPago.getTime())).divide(BD_MILLSECS_PER_DAY, 0, RoundingMode.HALF_UP);
                                                BigDecimal fraccionAnyo = diasSaldo.divide(new BigDecimal(365), 9, RoundingMode.HALF_UP);
                                                incremento = incremento.add((saldo.multiply(siiSmmlv.getSmmIpc())).multiply(fraccionAnyo).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP));
                                                break; //No procesa el resto de las entradas porque no hay más pagos
                                            }
                                        }
                                        
                                    }
                                }
                                //Si no hay pagos se calcula el incremento para el total del año o fracción según la fecha de la resolución
                                else {
                                    BigDecimal diasSaldo = (new BigDecimal(fechaUltimoDiaAnyoAnterior.getTime() - fechaSaldo.getTime())).divide(BD_MILLSECS_PER_DAY, 0, RoundingMode.HALF_UP);
                                    BigDecimal fraccionAnyo = diasSaldo.divide(new BigDecimal(365), 9, RoundingMode.HALF_UP);
                                    incremento = saldoIni.multiply(siiSmmlv.getSmmIpc()).multiply(fraccionAnyo).divide(new BigDecimal(100), 0, RoundingMode.HALF_UP);
                                    saldo = saldoIni;
                                }
                                
                                
                                if(siiActualizacionMulta == null){
                                    siiActualizacionMulta = new SiiActualizacionMulta();
                                    siiActualizacionMulta.setAmuFecha(new Date());
                                    siiActualizacionMulta.setAmuVigencia(primeroEneroActual.get(Calendar.YEAR));
                                    siiActualizacionMulta.setSiiSmmlv(siiSmmlv);
                                    siiActualizacionMulta = actualizacionMultaDao.insertar(siiActualizacionMulta);
                                }
                                
                                SiiActualizacCuotaOpe siiActualizacCuotaOpe = new SiiActualizacCuotaOpe();
                                siiActualizacCuotaOpe.setSiiActualizacionMulta(siiActualizacionMulta);
                                siiActualizacCuotaOpe.setSiiCuotaOperador(siiCuotaOperador);
                                siiActualizacCuotaOpe.setAopSaldo(saldo);
                                siiActualizacCuotaOpe.setAopIncremento(incremento.setScale(0, RoundingMode.HALF_UP));
                                actualizacCuotaOpeDao.insertar(siiActualizacCuotaOpe);
                            }
                 }
                }
                //Si no hay intereses para el primero de enero del año actual, reintenta el siguiente día
                else {
                    try {
                        Thread.sleep(MILLSECS_PER_DAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }catch(Exception ex){
                adminLogGeneral.logConsola("Se presentó el siguiente error al actualizar las cuotas de multas y sanciones: ");
                ex.printStackTrace();       
            }
        }
    }
    
    
    public List<ContratoVO> buscarContratosXEstadoEjecucion(String estado) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> contratos = contratoDAO.buscarContratosXEstadoEjecucion(estado);
        for (SiiContrato contrato : contratos) {
            contratosVO.add(new ContratoVO(contrato));
        }

        return contratosVO;
    }    
    
    public List<EstadoCuentaVO> estadoCuentaIlegalidad(String nit, Date fechaCorte) throws ExcepcionDAO {
        List<EstadoCuentaVO> estadoCuentaVO = contratoDAO.estadoCuentaIlegalidad(nit, fechaCorte, null); 
        return estadoCuentaVO;
    }   
    
    public ContratoVO buscarContratoPorCedente(Long conCodigo) throws ExcepcionDAO {
        ContratoVO resultado = null;
        SiiContrato siiContrato = contratoDAO.buscarContratoPorCedente(conCodigo);
        if (siiContrato != null)
            resultado = new ContratoVO(siiContrato);

        return (resultado);
    }
}
