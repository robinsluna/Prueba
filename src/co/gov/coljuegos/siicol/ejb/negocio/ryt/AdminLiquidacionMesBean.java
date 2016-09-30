package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumConceptoCuota;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionContable;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTasaIntSuperBan;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoReporteVentas;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoTasa;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogGeneral;
import co.gov.coljuegos.siicol.ejb.negocio.sistema.AdminParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConceptoCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaContTipoDocContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FestivoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InteresCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionEstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LiquidacionMesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificaVentasMetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ParametrosSistemaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReporteVentasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResumenNoConectadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SmmlvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaIntSuperbanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TasaInteresDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.VentasMetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInteresCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificaVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiParametrosSistema;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidaMetOnLineVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionMesVO;
import co.gov.coljuegos.siicol.ejb.vo.LiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.RepLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteVentasVO;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.eclipse.persistence.exceptions.DatabaseException;


@Stateless
public class AdminLiquidacionMesBean implements AdminLiquidacionMes {
    @Resource
    SessionContext sessionContext;

    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private LiquidacionMesDAO liquidacionMesDao;
    @EJB
    private SmmlvDAO smmlvDAO;
    @EJB
    private LiquidacionEstablecimientoDAO liquidacionEstablecimientoDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private CuentaContTipoDocContDAO cuentaContTipoDocContDao;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private InteresCuotaDAO interesCuotaDAO;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    @EJB
    private OperadorDAO operadorDao;
    @EJB
    private FestivoDAO festivoDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private EstablecimientoDAO establecimientoDao;
    @EJB
    private MesDAO mesDao;
    @EJB
    private ConceptoCuotaDAO conceptoCuotaDao;
    @EJB
    private AdminLogGeneral adminLogGeneral;
    @EJB
    private AdminParametrosSistema adminParametrosSistema;
    @EJB
    VentasMetDAO ventasMetDao;
    @EJB
    ReporteVentasDAO reporteVentasDao;
    @EJB
    ModificaVentasMetDAO modificaVentasMetDao;
    @EJB
    ParametrosSistemaDAO parametrosSistemaDao;
    @EJB
    ResumenNoConectadoDAO resumenNoConectadoDao;
    @EJB
    TasaIntSuperbanDAO tasaIntSuperbanDao;
    @EJB
    InteresCuotaDAO InteresCuotaDao;
    @EJB
    TipoApuestaDAO tipoApuestaDao;
    @EJB
    MetDAO metDao;
    @EJB
    TasaInteresDAO tasaInteresDao;

    public AdminLiquidacionMesBean() {
    }
    Long MAQUINAS_TRAGAMONEDAS = new Long(1);
    Long SALONES_BINGO_SILLAS = new Long(4);
    Long JUEGOS_DE_CASINO = new Long(2);
    Long CODIGO_APUESTA_1 = new Long(1);
    Long CODIGO_APUESTA_3 = new Long(3);
    Long CODIGO_APUESTA_6 = new Long(6);
    Long CODIGO_APUESTA_15 = new Long(15);
    Long CODIGO_APUESTA_4 = new Long(4);
    Long CODIGO_APUESTA_5 = new Long(5);
    Long ESTADO_BORRADOR_DOC_CON = 1L;
    Long ESTADO_ANULADO_DOC_CON = 3L;
    String TIPO_DOC_CONT_ACC = "ACC";
    Long CONCEPTO_CUOTA_DE = 1L;
    Long CONCEPTO_CUOTA_GA = 2L;


    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    /**
     * @param tipoReporteVtas
     * @param vigencia
     * @param mesALiquidar
     * @param contrato
     * @param nit
     * @return
     * @throws ExcepcionDAO
     */
    public String ejecutarLiquidacionMensualOperadores(String tipoReporteVtas, Integer vigencia, Integer mesALiquidar, String contrato, String nit) throws ExcepcionDAO {
        String respuesta = "";
        BigDecimal tarifaGA = (new BigDecimal(1)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        BigDecimal totalDE = new BigDecimal(0);
        BigDecimal totalGA = new BigDecimal(0);
        List<SiiLiquidacionMes> listaLiq = null;
        SiiLiquidacionMes resultadoSiiLiquidaDE = null;
        SiiLiquidacionMes resultadoSiiLiquidaGA = null;
        Long consecutivoCuota = new Long(0);
        Date fechaActual = new Date();

        //****************************************
        Date fechaPagoOportuno = null;
        Calendar fechaInicial = Calendar.getInstance();
        fechaInicial.set(vigencia, mesALiquidar, 1);
        Calendar fechaFinal = Calendar.getInstance();
        fechaFinal.set(fechaInicial.get(Calendar.YEAR), fechaInicial.get(Calendar.MONTH), fechaInicial.getActualMaximum(Calendar.DAY_OF_MONTH));
        List<ContratoVO> miListaContratos = new ArrayList();
        BigDecimal valorSmmlv = new BigDecimal(0);
        SiiReporteVentas reporteVtas = null;
        SiiReporteVentas reporteVtasAnt = null;

        LiquidacionVO liquidacion = null;
        SiiCuotaOperador resultadoSiiCuotaOperador = null;
        List<SiiResumenNoConectado> listaNoConectadas = null;
        Calendar fechaTmpInicio = Calendar.getInstance();
        fechaTmpInicio.set(fechaTmpInicio.get(Calendar.YEAR), 0, 1);

        Calendar fechaTmpFin = Calendar.getInstance();
        fechaTmpFin.set(fechaTmpFin.get(Calendar.YEAR), 11, 31);

        List<SiiLiquidacionMes> listaLiquidacionSugerida = new ArrayList();

        SiiLiquidacionMes miLiquidacionMes = null;
        //  ****Fecha para los movimientos contables
        Calendar fechaContable = Calendar.getInstance();
        fechaContable.set(vigencia, mesALiquidar - 1, 1);
        fechaContable.set(fechaContable.get(Calendar.YEAR), fechaContable.get(Calendar.MONTH), fechaContable.getActualMaximum(Calendar.DAY_OF_MONTH));
        // ***************

        try {

            // Calculo de la fecha de pago oportuno
            fechaPagoOportuno = obtenerDiasHabiles(fechaInicial, fechaFinal);

            // Se obtiene el valor del Smmlv
            Long valorSmmlvTmp = buscarSmmlvPorVigencia(vigencia);

            if (valorSmmlvTmp != null) {
                valorSmmlv = new BigDecimal(valorSmmlvTmp.longValue());
                System.out.println("Salario minimo legal vigente:" + valorSmmlv + " vigencia:" + vigencia);

            }
            if (tipoReporteVtas.equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                SiiContrato miContrato = contratoDao.buscarContratoPorNumeroYConVigente(contrato);
                if (miContrato != null){
                    miListaContratos.add(new ContratoVO(miContrato));
                }
            }
            else {
                SiiContrato miContratoVo = contratoDao.buscarContratoPorNumeroPorNit(nit, contrato);
                miListaContratos.add(new ContratoVO(miContratoVo));
            }

            if (miListaContratos.size() > 0) {

                if (tipoReporteVtas.equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                    for (ContratoVO miContrato : miListaContratos) {
                        try {
                            reporteVtas = reporteVentasDao.buscarReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, tipoReporteVtas, miContrato.getConCodigo());
                            consecutivoCuota = liquidacionMesDao.buscarConsecutivoCuotaPorCodigoContrato(miContrato.getConCodigo());
                            
                            // busca el consecutivo de  la cuota del cedente para continuar la numeracion.
                            if(miContrato.getContratoCedenteVo() != null && consecutivoCuota == 0){
                                consecutivoCuota = liquidacionMesDao.buscarConsecutivoCuotaPorCodigoContrato(miContrato.getContratoCedenteVo().getConCodigo());
                            }
                            
                            consecutivoCuota = consecutivoCuota + 1;

                            // 1. Liquidacion sugerida
                            System.out.println("Calculo liquidacion sugerida contrato:" + miContrato.getConNumero());
                            liquidacion = ejecutarLiquidacionSugerida(miContrato, valorSmmlv, vigencia, mesALiquidar, fechaPagoOportuno, reporteVtas, consecutivoCuota, null);

                            if (liquidacion != null) {
                                listaLiq = liquidacion.getListaLiq();

                                listaNoConectadas = liquidacion.getListaNoConectados();
                                if (listaLiq != null && listaLiq.size() > 0) {
                                    for (SiiLiquidacionMes unSiiLiquida : listaLiq) {
                                        if (unSiiLiquida.getLiqConcepto().equals("DE"))
                                            totalDE = unSiiLiquida.getLiqValor();
                                    }
                                }
                            }


                            // 2.  guarda liquidación mensual y liquidación establecimiento

                            List<SiiLiquidacionMes> resultadoSiiLiquidacion = guardarLiquidacion(liquidacion, totalDE, tarifaGA, miContrato, vigencia, mesALiquidar, reporteVtas);

                            // 3.  Guarda la cuota por operador para DE
                            if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                                for (SiiLiquidacionMes siiLiquida : resultadoSiiLiquidacion) {
                                    if (siiLiquida.getLiqConcepto().equals("DE")) {
                                        resultadoSiiLiquidaDE = siiLiquida;
                                    }
                                    if (siiLiquida.getLiqConcepto().equals("GA")) {
                                        resultadoSiiLiquidaGA = siiLiquida;
                                    }
                                }
                            }
                            System.out.println("Guarda cuota operador DE contrato:" + miContrato.getConNumero());
                            resultadoSiiCuotaOperador = null;
                            if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                                resultadoSiiCuotaOperador =
                                    insertarCuotaOperador(resultadoSiiLiquidaDE, fechaPagoOportuno, consecutivoCuota.intValue(), totalDE, vigencia, mesALiquidar, "DE",
                                                          miContrato.getOperadorVo().getOpeCodigo(), reporteVtas, "A");

                                System.out.println("Guarda resumen no conectado:" + miContrato.getConNumero());
                                if (listaNoConectadas != null && listaNoConectadas.size() > 0) {
                                    for (SiiResumenNoConectado elemNoConectado : listaNoConectadas) {
                                        elemNoConectado.setSiiCuotaOperador(resultadoSiiCuotaOperador);
                                        resumenNoConectadoDao.insertarSiiResumenNoConectado(elemNoConectado);
                                    }
                                }
                                totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);
                                System.out.println("Guarda cuota operador GA contrato:" + miContrato.getConNumero());
                                resultadoSiiCuotaOperador = null;
                                resultadoSiiCuotaOperador = insertarCuotaOperador(resultadoSiiLiquidaGA, fechaPagoOportuno, consecutivoCuota.intValue(), totalGA, vigencia, mesALiquidar, "GA",
                                                          miContrato.getOperadorVo().getOpeCodigo(), reporteVtas, "A");

                                // 4. se insertar los documentos contables

                                System.out.println("Guarda movimientos contables contrato:" + miContrato.getConNumero());
                                insertarMovimientosContables(TIPO_DOC_CONT_ACC, fechaContable.getTime(), consecutivoCuota, miContrato.getConNumero(), totalDE, totalGA,
                                                             miContrato.getOperadorVo().getOpeCodigo(), resultadoSiiLiquidaDE, resultadoSiiLiquidaGA);

                            }

                        } catch (Exception de) {
                            throw new ExcepcionDAO("Error al procesar el contrato: " + miContrato.getConNumero() + de.getMessage());
                        }

                    }

                }
                else if (tipoReporteVtas.equals(EnumTipoReporteVentas.VENTAS_MODIFICADAS.getId()) || tipoReporteVtas.equals(EnumTipoReporteVentas.VENTAS_CORREGIDAS.getId())) {

                    List<SiiReporteVentas> listaReportes = new ArrayList();
                    List<SiiReporteVentas> listaReportesSugerida = new ArrayList();
                    ContratoVO miContrato = miListaContratos.get(0);
                    SiiReporteVentas reporteVtasSugerida = null;
                    SiiInteresCuota SiiInteresDE = null;
                    SiiInteresCuota SiiInteresGA = null;

                    // Consulto el reporte de ventas de la sugerida para el contrato
                    listaReportesSugerida =
                        reporteVentasDao.buscarUltimoReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, EnumTipoReporteVentas.PRIMER_REPORTE.getId(), miContrato.getConCodigo());
                    if (listaReportesSugerida.size() > 0) {
                        reporteVtasSugerida = listaReportesSugerida.get(0);
                    }

                    // Se busca el último reporte de ventas
                    listaReportes = reporteVentasDao.buscarUltimoReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, tipoReporteVtas, miContrato.getConCodigo());
                    if (listaReportes.size() > 1) {
                        reporteVtas = listaReportes.get(0);
                        reporteVtasAnt = listaReportes.get(1);
                    }
                    else if (listaReportes.size() == 1) {
                        reporteVtas = listaReportes.get(0);
                    }

                    // Se busca la cuota de la sugerida (original)
                    listaLiquidacionSugerida =
                        liquidacionMesDao.buscarLiquidacionMesPorContratoVigenciaMesTipoReporteVetas(miContrato.getConCodigo(), vigencia, mesALiquidar, EnumTipoReporteVentas.PRIMER_REPORTE.getId());
                    if (listaLiquidacionSugerida != null && listaLiquidacionSugerida.size() > 0 && listaLiquidacionSugerida.get(0).getSiiCuotaOperadorList() != null) {
                        miLiquidacionMes = listaLiquidacionSugerida.get(0);
                        consecutivoCuota = miLiquidacionMes.getSiiCuotaOperadorList().get(0).getCopNumCuota().longValue();
                    }

                    // 1. Liquidacion sugerida
                    System.out.print("Calculo liquidacion sugerida contrato:" + miContrato.getConNumero());
                    liquidacion = ejecutarLiquidacionSugerida(miContrato, valorSmmlv, vigencia, mesALiquidar, fechaPagoOportuno, reporteVtas, consecutivoCuota, reporteVtasSugerida);
                    if (liquidacion != null) {
                        listaLiq = liquidacion.getListaLiq();

                        listaNoConectadas = liquidacion.getListaNoConectados();
                        if (listaLiq != null && listaLiq.size() > 0) {
                            for (SiiLiquidacionMes unSiiLiquida : listaLiq) {
                                if (unSiiLiquida.getLiqConcepto().equals("DE"))
                                    totalDE = unSiiLiquida.getLiqValor();

                            }
                        }
                    }


                    // 2.  guarda liquidación mensual y liquidación establecimiento

                    List<SiiLiquidacionMes> resultadoSiiLiquidacion = guardarLiquidacion(liquidacion, totalDE, tarifaGA, miContrato, vigencia, mesALiquidar, reporteVtas);

                    // 3.  Guarda la cuota por operador para DE
                    if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                        for (SiiLiquidacionMes siiLiquida : resultadoSiiLiquidacion) {
                            if (siiLiquida.getLiqConcepto().equals("DE")) {
                                resultadoSiiLiquidaDE = siiLiquida;
                            }
                            if (siiLiquida.getLiqConcepto().equals("GA")) {
                                resultadoSiiLiquidaGA = siiLiquida;
                            }
                        }
                    }
                    System.out.println("Guarda cuota operador DE contrato:" + miContrato.getConNumero());
                    resultadoSiiCuotaOperador = null;
                    if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                        resultadoSiiCuotaOperador =
                            insertarCuotaOperador(resultadoSiiLiquidaDE, fechaPagoOportuno, consecutivoCuota.intValue(), totalDE, vigencia, mesALiquidar, "DE",
                                                  miContrato.getOperadorVo().getOpeCodigo(), reporteVtas, "T");

                        System.out.println("Guarda resumen no conectado:" + miContrato.getConNumero());
                        if (listaNoConectadas != null && listaNoConectadas.size() > 0) {
                            for (SiiResumenNoConectado elemNoConectado : listaNoConectadas) {
                                elemNoConectado.setSiiCuotaOperador(resultadoSiiCuotaOperador);
                                resumenNoConectadoDao.insertarSiiResumenNoConectado(elemNoConectado);
                            }
                        }
                        // 3. Recalcula intereses de mora
                        // Se calcula los dias de mora DE
                        if (fechaPagoOportuno.before(fechaActual)) {
                            //Se calcula los intereses de mora para DE
                            SiiInteresDE = calcularInteresModificada(fechaPagoOportuno, totalDE, resultadoSiiCuotaOperador);
                            // Se guarda el interes para DE
                            System.out.println("Guarda interes para DE contrato:" + miContrato.getConNumero());
                            InteresCuotaDao.insertarSiiInteresCuota(SiiInteresDE);


                        }
                        totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);


                        System.out.println("Guarda cuota operador GA contrato:" + miContrato.getConNumero());
                        resultadoSiiCuotaOperador = null;
                        resultadoSiiCuotaOperador =
                            insertarCuotaOperador(resultadoSiiLiquidaGA, fechaPagoOportuno, consecutivoCuota.intValue(), totalGA, vigencia, mesALiquidar, "GA",
                                                  miContrato.getOperadorVo().getOpeCodigo(), reporteVtas, "T");

                        // 3.  Se recalculan intereses para GA
                        if (fechaPagoOportuno.before(fechaActual)) {
                            SiiInteresGA = calcularInteresModificada(fechaPagoOportuno, totalDE.multiply(tarifaGA), resultadoSiiCuotaOperador);
                            InteresCuotaDao.insertarSiiInteresCuota(SiiInteresGA);
                        }
                    }

                    // 4. Se inactivan las cuotas anteriores
                    // Se busca el reporte de ventas anterior al actual

                    if (reporteVtasAnt != null) {
                        List<SiiCuotaOperador> listaCuotas = cuotaOperadorDao.buscarCuotasAsociadasAReporteVentas(reporteVtasAnt.getRveCodigo());
                        if (listaCuotas != null && listaCuotas.size() > 0) {
                            for (SiiCuotaOperador vo : listaCuotas) {
                                if (vo.getCopCancelada().equals("T"))
                                    vo.setCopCancelada("I");
                                cuotaOperadorDao.actualizarCuotaOperador(vo);
                            }
                        }
                    }

                    return null;

                }
                else if (tipoReporteVtas.equals(EnumTipoReporteVentas.VENTAS_Q.getId())) {
                    SiiInteresCuota SiiInteresDE = null;
                    SiiInteresCuota SiiInteresGA = null;
                    totalGA = new BigDecimal(0);
                    ContratoVO miContrato = miListaContratos.get(0);
                    List<SiiReporteVentas> listaReportes = new ArrayList();
                    SiiReporteVentas reporteVtasSugerida = null;
                    List<SiiReporteVentas> listaReportesSugerida = new ArrayList();

                    // Consulto el reporte de ventas de la sugerida para el contrato
                    listaReportesSugerida =
                        reporteVentasDao.buscarUltimoReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, EnumTipoReporteVentas.PRIMER_REPORTE.getId(), miContrato.getConCodigo());
                    if (listaReportesSugerida.size() > 0) {
                        reporteVtasSugerida = listaReportesSugerida.get(0);
                    }

                    // Se consulta el ultimo reporte de ventas de Q
                    listaReportes = reporteVentasDao.buscarUltimoReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, tipoReporteVtas, miContrato.getConCodigo());
                    if (listaReportes.size() > 0) {
                        reporteVtas = listaReportes.get(0);
                    }

                    // Se busca la cuota de la sugerida (original)
                    listaLiquidacionSugerida =
                        liquidacionMesDao.buscarLiquidacionMesPorContratoVigenciaMesTipoReporteVetas(miContrato.getConCodigo(), vigencia, mesALiquidar, EnumTipoReporteVentas.PRIMER_REPORTE.getId());
                    if (listaLiquidacionSugerida != null && listaLiquidacionSugerida.size() > 0 && listaLiquidacionSugerida.get(0).getSiiCuotaOperadorList() != null) {
                        miLiquidacionMes = listaLiquidacionSugerida.get(0);
                        consecutivoCuota = miLiquidacionMes.getSiiCuotaOperadorList().get(0).getCopNumCuota().longValue();
                    }
                    // 1. Liquidacion sugerida
                    System.out.print("Calculo liquidacion sugerida contrato:" + miContrato.getConNumero());
                    liquidacion = ejecutarLiquidacionSugerida(miContrato, valorSmmlv, vigencia, mesALiquidar, fechaPagoOportuno, reporteVtas, consecutivoCuota, reporteVtasSugerida);

                    if (liquidacion != null) {
                        listaLiq = liquidacion.getListaLiq();
                        listaNoConectadas = liquidacion.getListaNoConectados();
                        if (listaLiq != null && listaLiq.size() > 0) {
                            for (SiiLiquidacionMes unSiiLiquida : listaLiq) {
                                if (unSiiLiquida.getLiqConcepto().equals("DE"))
                                    totalDE = unSiiLiquida.getLiqValor();
                            }
                        }
                    }
                    totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);

                    // 3. Recalcula intereses de mora
                    // Se obtienen la cuota operador
                    if (fechaPagoOportuno.before(fechaActual)) {
                        //Se calcula los intereses de mora para DE
                        SiiInteresDE = calcularInteresModificada(fechaPagoOportuno, totalDE, miLiquidacionMes.getSiiCuotaOperadorList().get(0));
                        // 3.  Se recalculan intereses para GA
                        SiiInteresGA = calcularInteresModificada(fechaPagoOportuno, totalDE.multiply(tarifaGA), miLiquidacionMes.getSiiCuotaOperadorList().get(0));
                        return totalDE + " " + totalGA + " " + SiiInteresDE.getIcuValor() + " " + SiiInteresGA.getIcuValor();
                    }
                    else 
                        return totalDE + " " + totalGA + " " + "0" + " " + "0";
                        

                }

            }

        } catch (DatabaseException de) {
            throw new ExcepcionDAO(de.getMessage());
        }
        return respuesta;
    }

    // Método para calcular los días hábiles que hay entre un rango de fechas

    public Date obtenerDiasHabiles(Calendar fechaInicial, Calendar fechaFinal) {
        String fechaIni = sdf.format(fechaInicial.getTime());
        Date festivo;
        int conta = 0;
        try {
            while (fechaInicial.before(fechaFinal) || fechaInicial.equals(fechaFinal)) {
                fechaIni = sdf.format(fechaInicial.getTime());
                festivo = festivoDao.buscarSiiFestivo(fechaInicial.getTime());
                if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && festivo == null) {
                    fechaInicial.add(Calendar.DATE, 1);
                    conta++;
                }
                else {
                    fechaInicial.add(Calendar.DATE, 1);
                }
                if (conta == 9) {
                    break;
                }
                fechaIni = sdf.format(fechaInicial.getTime());
            }
            fechaIni = sdf.format(fechaInicial.getTime());
            if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                fechaInicial.add(Calendar.DATE, 2);

            }
            else if (fechaInicial.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                fechaInicial.add(Calendar.DATE, 1);
            }
            if (festivoDao.buscarSiiFestivo(fechaInicial.getTime()) != null) {
                fechaInicial.add(Calendar.DATE, 1);
            }
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();

        }
        fechaIni = sdf.format(fechaInicial.getTime());
        return fechaInicial.getTime();

    }

    public static Calendar getPrimerDiaDelMes() {

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.getActualMinimum(Calendar.DAY_OF_MONTH), cal.getMinimum(Calendar.HOUR_OF_DAY), cal.getMinimum(Calendar.MINUTE),
                cal.getMinimum(Calendar.SECOND));

        return cal;
    }

    public List<LiquidacionMesVO> obtenerLiquidacionPorContratoYConceptos(Long idCodigoContrato, Date fechaInicio, Date fechaFin) throws ExcepcionDAO {
        List<SiiLiquidacionMes> listaLiquidacion = liquidacionMesDao.obtenerLiquidacionPorContratoYConceptos(idCodigoContrato, fechaInicio, fechaFin);
        List<LiquidacionMesVO> listLiquidacinVo = new ArrayList<LiquidacionMesVO>();
        for (SiiLiquidacionMes siiliq : listaLiquidacion) {
            listLiquidacinVo.add(new LiquidacionMesVO(siiliq));
        }
        return listLiquidacinVo;
    }

    public List<ContratoVO> buscarContratosPorEstadoEjecucion(String unEstado) throws ExcepcionDAO {
        List<ContratoVO> contratosVO = new ArrayList<ContratoVO>();
        List<SiiContrato> listSiiContratos = contratoDao.buscarContratosVigentes(unEstado);
        for (SiiContrato contrato : listSiiContratos) {
            contratosVO.add(new ContratoVO(contrato));
        }
        return contratosVO;
    }


    public Long buscarSmmlvPorVigencia(int vigencia) throws ExcepcionDAO {
        Long valorSmmlvTmp = smmlvDAO.buscarSmmlvPorVigencia(vigencia);
        return valorSmmlvTmp;
    }

    public void insertarLiquidacionEstablecimiento(List<SiiLiquidacionEstabl> listaLiqEstabDE) {
        try {
            // Se inserta liquidacion por Establecimiento para DE
            for (SiiLiquidacionEstabl unaLiqEst : listaLiqEstabDE) {
                liquidacionEstablecimientoDao.insertarSiiLiquidacionEstabl(unaLiqEst);
            }

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
        }
    }

    public void insertarMovimientosContables(String tipoDocumentoContable, Date fechaActual, Long consecutivoCuota, String numContrato, BigDecimal totalDE, BigDecimal totalGA, Long codOperador,
                                             SiiLiquidacionMes liquidacionDe, SiiLiquidacionMes liquidacionGa) {
        try {
            
            //anula  anterior documento contable 
            List<SiiImputacionContable> listImputacionContable = imputacionContableDao.buscarPorRef1Ref2ImputacionCont(numContrato, consecutivoCuota.toString());
            if(listImputacionContable.size()>0){
                SiiDocumentoContable unsiidocumentocontable =
                documentoContableDao.buscarPorCodigo(listImputacionContable.get(0).getSiiDocumentoContable().getDcoCodigo());
                SiiEstadoDocContab unSiiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(ESTADO_ANULADO_DOC_CON);
                unsiidocumentocontable.setSiiEstadoDocContab(unSiiEstadoDocContab);
                unsiidocumentocontable.setDcoMotivoAnula("Reliquidación de contrato");
                documentoContableDao.actualizar(unsiidocumentocontable);
            }
            
            // Se genera el consecutivo del documento contable
            Integer numeroDocumentoContable = documentoContableDao.buscarConsecutivoDocumentoContable(tipoDocumentoContable);
            String descripcionOper = "";
            BigDecimal valor = new BigDecimal(0);

            //Se consulta la persona asociada al operador
            SiiOperador siioperador = operadorDao.buscarPorCodigoOperador(codOperador);

            // Se inserta el documento contable
            SiiDocumentoContable siiDocumentoContable = new SiiDocumentoContable();
            SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo(tipoDocumentoContable);
            SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarPorCodigo(ESTADO_BORRADOR_DOC_CON);
            siiDocumentoContable.setDcoNumeroCompr(numeroDocumentoContable);
            siiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
            siiDocumentoContable.setDcoFechaOper(fechaActual);
            siiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
            siiDocumentoContable.setSiiLiquidacionMesDE(liquidacionDe);
            siiDocumentoContable.setSiiLiquidacionMesGA(liquidacionGa);
            SiiDocumentoContable resultadoDocConta = documentoContableDao.insertar(siiDocumentoContable);

            // se  insertan los movimientos contables
            List<SiiCuentaContTipoDocCont> listMovi = cuentaContTipoDocContDao.buscarSiiCuentaContTipoDocContPorTipoDoc(tipoDocumentoContable);
            if (listMovi.size() > 0) {
                for (SiiCuentaContTipoDocCont unMov : listMovi) {
                    SiiImputacionContable siiImputacionContable = new SiiImputacionContable();
                    SiiCuentasContables siiCuentasContables = new SiiCuentasContables();
                    siiCuentasContables.setCcoCodigo(unMov.getSiiCuentasContables().getCcoCodigo());
                    siiImputacionContable.setImcTipoMovim(unMov.getCctTipoMovim());
                    siiImputacionContable.setSiiCuentasContables(siiCuentasContables);
                    siiImputacionContable.setSiiDocumentoContable(resultadoDocConta);
                    if (unMov.getCctConcepto().equals("DE")) {
                        descripcionOper = "CUOTA " + consecutivoCuota + " DERECHOS DE EXPLOTACIÓN POR COBRAR CONTRATO " + numContrato;
                        valor = totalDE;
                    }
                    else if (unMov.getCctConcepto().equals("GA")) {
                        descripcionOper = "CUOTA " + consecutivoCuota + " GASTOS DE ADMINISTRACIÓN POR COBRAR CONTRATO " + numContrato;
                        valor = totalGA;
                    }
                    siiImputacionContable.setImcEstado(EnumEstadoImputacionContable.ACTIVO.getId());
                    siiImputacionContable.setImcDescrOperacion(descripcionOper);
                    siiImputacionContable.setImcValor(valor);
                    if (siioperador.getSiiPersona() != null) {
                        siiImputacionContable.setSiiPersona(siioperador.getSiiPersona());
                    }
                    siiImputacionContable.setImcReferencia1(liquidacionDe.getSiiContrato().getConNumero());
                    siiImputacionContable.setImcReferencia2(consecutivoCuota.toString());
                    imputacionContableDao.insertarImputacionContable(siiImputacionContable);

                }
            }

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();

        }

    }

    public SiiCuotaOperador insertarCuotaOperador(SiiLiquidacionMes resultadoSiiLiquida, Date fechaPago, int numCuota, BigDecimal valor, int vigencia, int mesALiquidar, String concepto,
                                                  Long codOperador, SiiReporteVentas reporteVtas, String estado) {
        SiiCuotaOperador retorno = null;
        try {
            Long codigoConcepto = 0L;

            SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
            if (resultadoSiiLiquida != null) {
                siiCuotaOperador.setSiiLiquidacionMes(resultadoSiiLiquida);
            }
            siiCuotaOperador.setCopFechaLimPag(fechaPago);
            siiCuotaOperador.setCopNumCuota(numCuota);
            siiCuotaOperador.setCopTipoDocSopor("CO");
            siiCuotaOperador.setCopValor(valor);
            siiCuotaOperador.setCopVigencia(vigencia);
            siiCuotaOperador.setMesCodigo(mesALiquidar);
            siiCuotaOperador.setCopCancelada(estado);
            siiCuotaOperador.setCopTipoCartera("C");
            if (concepto.equals("DE")) {
                codigoConcepto = CONCEPTO_CUOTA_DE;
            }
            else if (concepto.equals("GA")) {
                codigoConcepto = CONCEPTO_CUOTA_GA;
            }
            SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(codigoConcepto);
            siiCuotaOperador.setSiiConceptoCuota(siiConceptoCuota);
            SiiOperador siiOperador = operadorDao.buscarPorCodigoOperador(codOperador);
            siiCuotaOperador.setSiiOperador(siiOperador);

            retorno = cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperador);

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public void insertarCuotaOperadorMod(Date fechaPago, int numCuota, BigDecimal valor, int vigencia, int mesALiquidar, String concepto, Long codOperador, SiiReporteVentas reporteVtas) {
        try {
            Long codigoConcepto = 0L;
            SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
            siiCuotaOperador.setCopFechaLimPag(fechaPago);
            siiCuotaOperador.setCopNumCuota(numCuota);
            siiCuotaOperador.setCopTipoDocSopor("CO");
            siiCuotaOperador.setCopValor(valor);
            siiCuotaOperador.setCopVigencia(vigencia);
            siiCuotaOperador.setMesCodigo(mesALiquidar);
            siiCuotaOperador.setCopCancelada("T");
            siiCuotaOperador.setCopTipoCartera("C");
            if (concepto.equals("DE")) {
                codigoConcepto = CONCEPTO_CUOTA_DE;
            }
            else if (concepto.equals("GA")) {
                codigoConcepto = CONCEPTO_CUOTA_GA;
            }
            SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(codigoConcepto);
            siiCuotaOperador.setSiiConceptoCuota(siiConceptoCuota);
            SiiOperador siiOperador = operadorDao.buscarPorCodigoOperador(codOperador);
            siiCuotaOperador.setSiiOperador(siiOperador);

            cuotaOperadorDao.insertarSiiCuotaOperador(siiCuotaOperador);

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();

        }
    }

    public SiiCuotaOperador crearCuotaOperador(SiiLiquidacionMes resultadoSiiLiquida, Date fechaPago, int numCuota, BigDecimal valor, int vigencia, int mesALiquidar, String concepto,
                                               Long codOperador) {
        SiiCuotaOperador retorno = null;
        try {
            Long codigoConcepto = 0L;

            SiiCuotaOperador siiCuotaOperador = new SiiCuotaOperador();
            if (resultadoSiiLiquida != null) {
                siiCuotaOperador.setSiiLiquidacionMes(resultadoSiiLiquida);
            }
            siiCuotaOperador.setCopFechaLimPag(fechaPago);
            siiCuotaOperador.setCopNumCuota(numCuota);
            siiCuotaOperador.setCopTipoDocSopor("CO");
            siiCuotaOperador.setCopValor(valor);
            siiCuotaOperador.setCopVigencia(vigencia);
            siiCuotaOperador.setMesCodigo(mesALiquidar);
            siiCuotaOperador.setCopCancelada("A");
            siiCuotaOperador.setCopTipoCartera("C");
            if (concepto.equals("DE")) {
                codigoConcepto = CONCEPTO_CUOTA_DE;
            }
            else if (concepto.equals("GA")) {
                codigoConcepto = CONCEPTO_CUOTA_GA;
            }
            SiiConceptoCuota siiConceptoCuota = conceptoCuotaDao.buscarConceptoCuotaXId(codigoConcepto);
            siiCuotaOperador.setSiiConceptoCuota(siiConceptoCuota);
            SiiOperador siiOperador = operadorDao.buscarPorCodigoOperador(codOperador);
            siiCuotaOperador.setSiiOperador(siiOperador);

            retorno = siiCuotaOperador;

        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public List<InteresCuotaVO> ejecutarInteresMensual(Date fechaActual) throws ExcepcionDAO, ExcepcionAplicacion {

        List<InteresCuotaVO> listInteresVo = new ArrayList<InteresCuotaVO>();
        try {
            Long icuCodigo = interesCuotaDAO.buscarNumeroInteresesPorDia(fechaActual);
            if (icuCodigo == 0) {

                List<InteresCuotaVO> listaIntereses = new ArrayList<InteresCuotaVO>();
                listaIntereses = liquidacionMesDao.EjecutarInteresMensual(fechaActual);

                //Movimiento contable

                SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();
                SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("INM");
                Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("INM");
                insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                insertSiiDocumentoContable.setDcoFechaOper(fechaActual);
                insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                String nombreEstado = "BORRADOR";
                SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
                insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                insertSiiDocumentoContable = documentoContableDao.insertar(insertSiiDocumentoContable);

                for (InteresCuotaVO interesCuotaVo : listaIntereses) {

                    interesCuotaVo.setIcuValor(Utilidades.redondear(interesCuotaVo.getIcuValor(), 0));
                    if (interesCuotaVo.getIcuValor().compareTo(BigDecimal.ZERO) > 0) {
                        SiiInteresCuota siiInteresCuota = conversionVoEntidad.convertir(interesCuotaVo);
                        siiInteresCuota = interesCuotaDAO.insertarSiiInteresCuota(siiInteresCuota);
                        listInteresVo.add(new InteresCuotaVO(siiInteresCuota));

                        //ingresar movimiento contable
                        List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont = new ArrayList<SiiCuentaContTipoDocCont>();
                        List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(interesCuotaVo.getConcepto());

                        listaSiiCuentaContTipoDocCont = detalleRecaudoDao.BuscarCuentaContTipoDocContable(listaSiiConceptoCuota.get(0).getCcuAbreviatura(), "INM");
                        for (SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont : listaSiiCuentaContTipoDocCont) {
                            SiiImputacionContable siiImputacionContable = new SiiImputacionContable();
                            siiImputacionContable.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                            siiImputacionContable.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                            SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                            //validaciones
                            if (siiCuentasContables.getCcoObligaTerc().equals("S")) {
                                SiiPersona siiPersona = personaDao.buscarPersonaPorId(interesCuotaVo.getPersonaVo().getPerCodigo());
                                siiImputacionContable.setSiiPersona(siiPersona);
                            }
                            if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                                siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                            if (siiCuentasContables.getCcoReferencia1().equals("S")) {
                                if (interesCuotaVo.getConcepto().equals("DERECHOS DE EXPLOTACIÓN") || interesCuotaVo.getConcepto().equals("GASTOS DE ADMINISTRACIÓN"))
                                    siiImputacionContable.setImcReferencia1(interesCuotaVo.getNumeroContrato().toString());
                                else
                                    siiImputacionContable.setImcReferencia1(interesCuotaVo.getNumeroResolucion().toString());
                            }
                            if (siiCuentasContables.getCcoReferencia2().equals("S"))
                                siiImputacionContable.setImcReferencia2(String.valueOf(interesCuotaVo.getNumeroCuota()));

                            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
                            String strDate = sm.format(fechaActual);
                            siiImputacionContable.setImcDescrOperacion("Intereses|| " + strDate);
                            siiImputacionContable.setImcValor(interesCuotaVo.getIcuValor());
                            siiImputacionContable.setImcEstado("A");
                            imputacionContableDao.insertarImputacionContable(siiImputacionContable);
                        }
                    }

                }
            }
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionAplicacion("Error general: " + ex.getMessage());
        }

        return listInteresVo;
    }


    //  @Schedule(minute = "30", hour = "0") //Para probar cada 5 minutos usar minute = "*/5", hour = "*"
    /*  public void ejecutarInteresMensualAutomatico() {
        try{
            Date fechaActual= new Date();
            List<InteresCuotaVO>  listaIntereses = new ArrayList<InteresCuotaVO>();
            listaIntereses= liquidacionMesDao.EjecutarInteresMensual(fechaActual);
            List<InteresCuotaVO> listInteresVo = new ArrayList<InteresCuotaVO>();

            //Movimiento contable

            SiiDocumentoContable insertSiiDocumentoContable= new SiiDocumentoContable();
            SiiTipoDocContable siiTipoDocContable =tipoDocContableDao.buscarPorCodigo("INM");
            Integer consecutivo =documentoContableDao.buscarConsecutivoDocumentoContable("INM");
            insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
            insertSiiDocumentoContable.setDcoFechaOper(fechaActual);
            insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
            String nombreEstado="BORRADOR";
            SiiEstadoDocContab  siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
            insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
            insertSiiDocumentoContable=documentoContableDao.insertar(insertSiiDocumentoContable);
            String concp= "";

            for(InteresCuotaVO interesCuotaVo :listaIntereses ){

               interesCuotaVo.setIcuValor(Utilidades.redondear (interesCuotaVo.getIcuValor(), 0)); // RESULTADO: 3784.675890 => 3785  interesCuotaVo.
               if(interesCuotaVo.getIcuValor().compareTo(BigDecimal.ZERO)>0 ){
                   SiiInteresCuota siiInteresCuota= conversionVoEntidad.convertir(interesCuotaVo);
                   SiiInteresCuota siiInteresCuotaResult = interesCuotaDAO.insertarSiiInteresCuota(siiInteresCuota);
                   listInteresVo.add(new InteresCuotaVO(siiInteresCuota) );

                    //ingresar movimiento contable
                    List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont= new ArrayList<SiiCuentaContTipoDocCont>();
                    List<SiiConceptoCuota> listaSiiConceptoCuota = conceptoCuotaDao.buscarTodoSiiConceptoCuotaXNombre(interesCuotaVo.getConcepto());

                    listaSiiCuentaContTipoDocCont=detalleRecaudoDao.BuscarCuentaContTipoDocContable( listaSiiConceptoCuota.get(0).getCcuAbreviatura(), "INM");
                    for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont :listaSiiCuentaContTipoDocCont){
                        SiiImputacionContable siiImputacionContable= new SiiImputacionContable();
                        siiImputacionContable.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                        siiImputacionContable.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                        SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                        //validaciones
                        if(siiCuentasContables.getCcoObligaTerc().equals("S") ){
                             SiiPersona siiPersona = personaDao.buscarPersonaPorId(interesCuotaVo.getPersonaVo().getPerCodigo());
                             siiImputacionContable.setSiiPersona(siiPersona);
                        }
                        if(siiCuentasContables.getCcoNumDocConta().equals("S") )
                            siiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                        if(siiCuentasContables.getCcoReferencia1().equals("S") ){
                            if(interesCuotaVo.getConcepto().equals("DERECHOS DE EXPLOTACIÓN")||interesCuotaVo.getConcepto().equals("GASTOS DE ADMINISTRACIÓN")  )
                             siiImputacionContable.setImcReferencia1(interesCuotaVo.getNumeroContrato().toString());
                            else
                            siiImputacionContable.setImcReferencia1(interesCuotaVo.getNumeroResolucion().toString());
                        }
                        if(siiCuentasContables.getCcoReferencia2().equals("S"))
                             siiImputacionContable.setImcReferencia2(String.valueOf(interesCuotaVo.getNumeroCuota()));

                        SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
                        String strDate = sm.format(fechaActual);
                        siiImputacionContable.setImcDescrOperacion("Intereses|| "+ strDate);
                        siiImputacionContable.setImcValor(interesCuotaVo.getIcuValor());
                        siiImputacionContable.setImcEstado("A");
                        imputacionContableDao.insertarInputacionContable(siiImputacionContable);
                    }
                }

            }
        }catch(Exception ex){
            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarInteresMensualAutomatico","Error en la ejecucion del interés - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS") + " - Mensaje : " + ex.getMessage(), null);
        }
        adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarInteresMensualAutomatico","Ejecucion correcta del interés - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS"), null);
    }

*/
    public Date buscarSiiFestivo(Date pFecha) throws ExcepcionDAO {
        Date diaFestivo = festivoDao.buscarSiiFestivo(pFecha);
        return diaFestivo;
    }


    public List<RepLiquidacionVO> obtenerInventarioLiquidadoPorMesYVigencia(Integer vigencia, Integer mes, String contrato) throws ExcepcionDAO {
        List<RepLiquidacionVO> listLiquidacion = liquidacionMesDao.obtenerInventarioLiquidadoPorMesYVigencia(vigencia, mes, contrato);
        return listLiquidacion;
    }

    /**
     * calcula los Derechos de explotacion de las Mets On Line.
     * @param idMet - Id de la MET.
     * @param mesALiquidar - Mes de las ventas reportadas.
     * param vigencia - vigencia de las ventas reportadas.
     * @return BigDecimal
     * @throws ExcepcionDAO
     */
    public BigDecimal calcularDEMetsOnLine(Long idMet, int mesALiquidar, int vigencia, SiiReporteVentas reporteVtasVo, SiiReporteVentas reporteVtasSugeridas) throws ExcepcionDAO {
        BigDecimal valorAPagarDeIng = new BigDecimal(0);

        // Se consulta las ventas reportadas para la met
        LiquidaMetOnLineVO vtsVo = new LiquidaMetOnLineVO();
        // Busca parametro de liquidacion
        SiiParametrosSistema parametro = parametrosSistemaDao.buscarParametroPorId("PORCENTAJE_MET_VENTAS");
        BigDecimal parametroTmp = new BigDecimal(parametro.getPsiValor());
        BigDecimal parametroLiq = parametroTmp.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        if (idMet != null && reporteVtasVo != null) {
            if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                vtsVo = ventasMetDao.buscarVentasMet(idMet, new Integer(mesALiquidar), new Integer(vigencia), reporteVtasVo);
                if (vtsVo != null)
                    valorAPagarDeIng = Utilidades.redondear(vtsVo.getValorInicialVentas().multiply(parametroLiq), 0);
            }
            else if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.VENTAS_MODIFICADAS.getId())) {
                vtsVo = ventasMetDao.buscarVentasMet(idMet, new Integer(mesALiquidar), new Integer(vigencia), reporteVtasSugeridas);
                if (vtsVo != null)
                    valorAPagarDeIng = Utilidades.redondear(vtsVo.getValorModifVentas().multiply(parametroLiq), 0);
            }
            else if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.VENTAS_Q.getId())) {
                vtsVo = ventasMetDao.buscarVentasMet(idMet, new Integer(mesALiquidar), new Integer(vigencia), reporteVtasSugeridas);
                if (vtsVo != null)
                    valorAPagarDeIng = Utilidades.redondear(vtsVo.getValorConsulta().multiply(parametroLiq), 0);
            }


        }
        return valorAPagarDeIng;
    }

    public List<SiiLiquidacionEstabl> calcularDEPorEstablecimiento(ContratoVO miContrato, Integer vigencia, Integer mesALiquidar, BigDecimal total, SiiReporteVentas reporteVtasVo,
                                                                   SiiLiquidacionMes siiLiquidaDE, SiiLiquidacionMes siiLiquidaGA) throws ExcepcionDAO {
        Date fechaInicio = miContrato.getConFechaIni();
        Date fechaFin = miContrato.getConFechaFin();

        List<OficioLiquidacionPrevioVO> listaEstablecimientos = new ArrayList();

        BigDecimal numeroDiasALiquidar = new BigDecimal(0);
        BigDecimal valorAPagarDE = new BigDecimal(0);
        BigDecimal valorAPagarGA = new BigDecimal(0);
        BigDecimal totalDE = new BigDecimal(0);
        BigDecimal totalGA = new BigDecimal(0);
        BigDecimal valorAPagarDEOnLine = new BigDecimal(0);
        BigDecimal tarifaGA = (new BigDecimal(1)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        BigDecimal granTotalGA = Utilidades.redondear(total.multiply(tarifaGA), 0);
        List<SiiLiquidacionEstabl> listaLiqEstabDE = new ArrayList<SiiLiquidacionEstabl>();
        BigDecimal maximoDiaLiq = new BigDecimal(1);
        BigDecimal valorDETmp = new BigDecimal(0);
        List<OficioLiquidacionPrevioVO> listaInventario = new ArrayList();

        // Fechas de operacion del mes
        Calendar fechaIniOper = Calendar.getInstance();
        fechaIniOper.set(fechaIniOper.get(Calendar.YEAR), mesALiquidar - 1, 1);

        Calendar fechaFinOper = Calendar.getInstance();
        fechaFinOper.set(fechaIniOper.get(Calendar.YEAR), fechaIniOper.get(Calendar.MONTH), fechaIniOper.getActualMaximum(Calendar.DAY_OF_MONTH));
        listaEstablecimientos = liquidacionMesDao.buscarEstablecimientoContrato(miContrato.getConCodigo(), fechaIniOper.getTime(), fechaFinOper.getTime());
        try {
            if (listaEstablecimientos != null && listaEstablecimientos.size() > 0) {
                for (OficioLiquidacionPrevioVO unEstVo : listaEstablecimientos) {
                    listaInventario = liquidacionMesDao.buscarInventarioPorEstablecimiento(unEstVo.getIdEstablecimiento(), fechaIniOper.getTime(), fechaFinOper.getTime(), miContrato.getConCodigo());
                    if (listaInventario != null && listaInventario.size() > 0) {
                        totalDE = new BigDecimal(0);
                        for (OficioLiquidacionPrevioVO miInventarioVo : listaInventario) {
                            valorAPagarDE = new BigDecimal(0);
                            valorAPagarGA = new BigDecimal(0);
                            valorAPagarDEOnLine = new BigDecimal(0);
                            fechaInicio = miInventarioVo.getFechaInicioContrato();
                            if (miInventarioVo.getFechaFinDefinitiva() != null) {
                                fechaFin = miInventarioVo.getFechaFinDefinitiva();
                            }
                            else {
                                fechaFin = miInventarioVo.getFechaFinContrato();
                            }

                            DuplaVO miDupla = calcularDiasALiquidar(vigencia, mesALiquidar, miInventarioVo.getFechaInicioLiq(), miInventarioVo.getFechaFinLiq(), fechaInicio, fechaFin);
                            if (miDupla != null) {
                                numeroDiasALiquidar = miDupla.getValor();
                                maximoDiaLiq = new BigDecimal(miDupla.getConcepto());
                            }
                            //numeroDiasALiquidar=calcularNumeroDiasLiquidar(miInventarioVo.getFechaInicioLiq(),miInventarioVo.getFechaFinLiq(),fechaInicio,fechaFin);
                            if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 0 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 16) {
                                if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 5 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 16) {
                                    valorDETmp = Utilidades.redondear((miInventarioVo.getDerechosExplMensual()), 0);
                                    if (numeroDiasALiquidar.compareTo(maximoDiaLiq) == 0) {
                                        valorAPagarDE = Utilidades.redondear(valorDETmp.multiply(new BigDecimal(miInventarioVo.getInventarioSillas())), 0);
                                    }
                                    else {
                                        valorAPagarDE =
                                            ((Utilidades.redondear(valorDETmp.divide(maximoDiaLiq, 3, RoundingMode.HALF_UP),
                                                                   0)).multiply(numeroDiasALiquidar)).multiply(new BigDecimal(miInventarioVo.getInventarioSillas()));
                                    }
                                    valorAPagarGA = valorAPagarDE.multiply(tarifaGA);
                                }
                                else {
                                    valorDETmp = Utilidades.redondear((miInventarioVo.getDerechosExplMensual()), 0);
                                    miInventarioVo.setDerechosExplMensual(valorDETmp);
                                    if (numeroDiasALiquidar.compareTo(maximoDiaLiq) == 0) {
                                        valorAPagarDE = Utilidades.redondear(valorDETmp, 0);
                                    }
                                    else {
                                        valorAPagarDE = ((Utilidades.redondear(valorDETmp.divide(maximoDiaLiq, 3, RoundingMode.HALF_UP), 0)).multiply(numeroDiasALiquidar));
                                    }

                                    if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 0 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 4) {
                                        if (miInventarioVo.getIndicadorOnLine().equals("S")) {
                                            if (reporteVtasVo != null) {
                                                valorAPagarDEOnLine = calcularDEMetsOnLine(miInventarioVo.getIdMet(), mesALiquidar, vigencia, reporteVtasVo, null);
                                                if (valorAPagarDEOnLine != null) {
                                                    if (valorAPagarDE.compareTo(valorAPagarDEOnLine) < 0) {
                                                        valorAPagarDE = valorAPagarDEOnLine;
                                                    }
                                                }
                                            }
                                        }
                                    }

                                }
                                if (valorAPagarDE != null)
                                    totalDE = totalDE.add(valorAPagarDE);
                            }
                        }

                    }
                    // Se arma la lista de liquidacion por establecimiento para DE a insertar
                    SiiLiquidacionEstabl siiLiquidacionEstablDE = new SiiLiquidacionEstabl();
                    siiLiquidacionEstablDE.setLesValor(totalDE);
                    siiLiquidacionEstablDE.setLesPonderado(totalDE.divide(total, 11, RoundingMode.HALF_UP));
                    SiiEstablecimiento siiEstablecimiento = establecimientoDao.buscarEstablecimientoPorId(unEstVo.getIdEstablecimiento());
                    siiLiquidacionEstablDE.setSiiEstablecimiento(siiEstablecimiento);
                    siiLiquidacionEstablDE.setSiiLiquidacionMes(siiLiquidaDE);
                    listaLiqEstabDE.add(siiLiquidacionEstablDE);

                    // Se arma la lista de liquidacion por establecimiento para GA a insertar
                    totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);
                    SiiLiquidacionEstabl siiLiquidacionEstablGA = new SiiLiquidacionEstabl();
                    siiLiquidacionEstablGA.setLesValor(totalGA);
                    siiLiquidacionEstablGA.setLesPonderado(totalGA.divide(granTotalGA, 11, RoundingMode.HALF_UP));
                    siiLiquidacionEstablGA.setSiiEstablecimiento(siiEstablecimiento);
                    siiLiquidacionEstablGA.setSiiLiquidacionMes(siiLiquidaGA);
                    listaLiqEstabDE.add(siiLiquidacionEstablGA);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return listaLiqEstabDE;

    }

    public BigDecimal calcularNumeroDiasLiquidar(Date fechaInicioOperacion, Date fechaFinOperacion, Calendar fechaIniComparar, Calendar fechaFinComparar) {
        BigDecimal numeroDiasALiquidar = new BigDecimal(0);
        int maximoDiaMes = 30;
        Calendar fechaAjusteIniOper = Calendar.getInstance();
        fechaAjusteIniOper.setTime(fechaInicioOperacion);

        Calendar fechaAjusteFinOper = Calendar.getInstance();
        fechaAjusteFinOper.setTime(fechaFinOperacion);

        if ((fechaInicioOperacion.before(fechaIniComparar.getTime()) || Utilidades.truncDate(fechaInicioOperacion).equals(Utilidades.truncDate(fechaIniComparar.getTime()))) &&
            (fechaFinOperacion.after(fechaFinComparar.getTime()) || Utilidades.truncDate(fechaFinOperacion).equals(Utilidades.truncDate(fechaFinComparar.getTime())))) {
            numeroDiasALiquidar = new BigDecimal(30);
        }
        else if (fechaAjusteIniOper.get(Calendar.MONTH) == fechaIniComparar.get(Calendar.MONTH) && fechaInicioOperacion.after(fechaIniComparar.getTime())) {
            if (fechaFinOperacion.before(fechaInicioOperacion)) {
                numeroDiasALiquidar = new BigDecimal(0);
            }
            else {
                Calendar calfechaIniOper = Calendar.getInstance();
                calfechaIniOper.setTime(fechaInicioOperacion);
                numeroDiasALiquidar = new BigDecimal(maximoDiaMes - calfechaIniOper.get(Calendar.DATE) + 1);
                if (calfechaIniOper.get(Calendar.DATE) == 31 && numeroDiasALiquidar.equals(new BigDecimal(0))) {
                    numeroDiasALiquidar = numeroDiasALiquidar.add(new BigDecimal(1));
                }
            }
        }
        else if (fechaFinOperacion.before(fechaFinComparar.getTime()) && (fechaAjusteFinOper.get(Calendar.MONTH) == (fechaFinComparar.get(Calendar.MONTH)))) {
            Calendar calfechaFinOper = Calendar.getInstance();
            calfechaFinOper.setTime(fechaFinOperacion);
            numeroDiasALiquidar = new BigDecimal(calfechaFinOper.get(Calendar.DATE));
        }
        return numeroDiasALiquidar;
    }

    public ReporteVentasVO buscarReporteVentasPorMesYVigencia(Integer mes, Integer vigencia) throws ExcepcionDAO {
        return reporteVentasDao.buscarReporteVentasPorMesYVigencia(mes, vigencia);
    }

    public LiquidacionVO ejecutarLiquidacionSugerida(ContratoVO miContrato, BigDecimal valorSmmlv, int vigencia, int mesALiquidar, Date fechaPagoOportuno, SiiReporteVentas reporteVtasVo,
                                                     Long consecutivoCuota, SiiReporteVentas reporteVtasSugerida) throws ExcepcionDAO {
        List<OficioLiquidacionPrevioVO> miListaInventarioVo = null;
        String numeroContrato = null;
        BigDecimal valorAPagarDE = new BigDecimal(0);
        BigDecimal valorAPagarDEOnLine = new BigDecimal(0);
        BigDecimal valorAPagarGA = new BigDecimal(0);
        BigDecimal valorTotalMensual = new BigDecimal(0);
        BigDecimal totalDE = new BigDecimal(0);
        BigDecimal totalGA = new BigDecimal(0);
        BigDecimal tarifaGA = (new BigDecimal(1)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        BigDecimal maximoDiaLiq = new BigDecimal(1);
        BigDecimal valorDETarifaFija = new BigDecimal(0);
        Calendar fechaInicioLiquidacion = Calendar.getInstance();
        fechaInicioLiquidacion.set(vigencia, mesALiquidar, 1);
        BigDecimal numeroDiasALiquidar = new BigDecimal(1);
        Date fechaInicioOperacion;
        Date fechaFinOperacion;
        Date fechaInicioContrato;
        Date fechaFinContrato;
        Date fechaActual = new Date();
        List<SiiLiquidacionMes> listaLiq = new ArrayList();
        BigDecimal valorDETmp = new BigDecimal(0);

        // Manejo de variables para totalizar el resumen de elementos no conectados
        Integer numElementosApuesta1 = 0;
        Integer numElementosApuesta2 = 0;
        Integer numElementosApuesta3 = 0;
        Integer numElementosApuesta4 = 0;
        Integer numElementosApuesta5 = 0;
        Integer numElementosApuesta6 = 0;
        Integer numElementosApuesta7 = 0;
        Integer numElementosApuesta8 = 0;
        Integer numElementosApuesta9 = 0;
        Integer numElementosApuesta10 = 0;
        Integer numElementosApuesta11 = 0;
        Integer numElementosApuesta12 = 0;
        Integer numElementosApuesta13 = 0;
        BigDecimal deTipoApuesta1 = new BigDecimal(0);
        BigDecimal deTipoApuesta2 = new BigDecimal(0);
        BigDecimal deTipoApuesta3 = new BigDecimal(0);
        BigDecimal deTipoApuesta4 = new BigDecimal(0);
        BigDecimal deTipoApuesta5 = new BigDecimal(0);
        BigDecimal deTipoApuesta6 = new BigDecimal(0);
        BigDecimal deTipoApuesta7 = new BigDecimal(0);
        BigDecimal deTipoApuesta8 = new BigDecimal(0);
        BigDecimal deTipoApuesta9 = new BigDecimal(0);
        BigDecimal deTipoApuesta10 = new BigDecimal(0);
        BigDecimal deTipoApuesta11 = new BigDecimal(0);
        BigDecimal deTipoApuesta12 = new BigDecimal(0);
        BigDecimal deTipoApuesta13 = new BigDecimal(0);
        List<SiiResumenNoConectado> listaNoConectado = new ArrayList();
        BigDecimal tarifaTipoA1 = new BigDecimal(0);
        BigDecimal tarifaTipoA2 = new BigDecimal(0);
        BigDecimal tarifaTipoA3 = new BigDecimal(0);
        BigDecimal tarifaTipoA4 = new BigDecimal(0);
        BigDecimal tarifaTipoA5 = new BigDecimal(0);
        BigDecimal tarifaTipoA6 = new BigDecimal(0);
        BigDecimal tarifaTipoA7 = new BigDecimal(0);
        BigDecimal tarifaTipoA8 = new BigDecimal(0);
        BigDecimal tarifaTipoA9 = new BigDecimal(0);
        BigDecimal tarifaTipoA10 = new BigDecimal(0);
        BigDecimal tarifaTipoA11 = new BigDecimal(0);
        BigDecimal tarifaTipoA12 = new BigDecimal(0);
        BigDecimal tarifaTipoA13 = new BigDecimal(0);
        SiiTipoApuesta siiTipoApuesta1 = null;
        SiiTipoApuesta siiTipoApuesta2 = null;
        SiiTipoApuesta siiTipoApuesta3 = null;
        SiiTipoApuesta siiTipoApuesta4 = null;
        SiiTipoApuesta siiTipoApuesta5 = null;
        SiiTipoApuesta siiTipoApuesta6 = null;
        SiiTipoApuesta siiTipoApuesta7 = null;
        SiiTipoApuesta siiTipoApuesta8 = null;
        SiiTipoApuesta siiTipoApuesta9 = null;
        SiiTipoApuesta siiTipoApuesta10 = null;
        SiiTipoApuesta siiTipoApuesta11 = null;
        SiiTipoApuesta siiTipoApuesta12 = null;
        SiiTipoApuesta siiTipoApuesta13 = null;
        List<SiiTipoApuesta> listaTipoApuesta = new ArrayList<SiiTipoApuesta>();
        SiiTipoApuesta siiTipoApuesta = null;
        BigDecimal deEst = new BigDecimal(0);
        BigDecimal gaEst = new BigDecimal(0);
        BigDecimal deTotalEstab = new BigDecimal(0);
        Long tmpEstAct = new Long(0);
        Long tmpEstSte = new Long(0);
        OficioLiquidacionPrevioVO miInventarioVo = null;
        OficioLiquidacionPrevioVO miInventarioVo2 = null;
        List<SiiLiquidacionEstabl> listaLiqEstabDE = new ArrayList<SiiLiquidacionEstabl>();
        List<SiiLiquidacionEstabl> listaLiqEstabGA = new ArrayList<SiiLiquidacionEstabl>();
        Calendar rangoInicialLiquidar = Calendar.getInstance();
        Calendar rangoFinalLiquidar = Calendar.getInstance();

        // Se fijal el rango Inicial de liquidacion
        rangoInicialLiquidar.set(vigencia, mesALiquidar - 1, 1);
        rangoFinalLiquidar.set(rangoInicialLiquidar.get(Calendar.YEAR), rangoInicialLiquidar.get(Calendar.MONTH), rangoInicialLiquidar.getActualMaximum(Calendar.DAY_OF_MONTH));

        LiquidacionVO liquidacion = new LiquidacionVO();


        try {
            // Se consulta el inventario del contrato

            miListaInventarioVo =
                liquidacionMesDao.buscarInventarioPorContratoYRangoOperacion(miContrato.getConCodigo(), sdf.format(rangoInicialLiquidar.getTime()), sdf.format(rangoFinalLiquidar.getTime()),
                                                                             EnumTipoNovedad.RETIRO_ELEMENTOS.getId(), vigencia);
            if (miListaInventarioVo != null && miListaInventarioVo.size() > 0) {
                for (int i = 0; i < miListaInventarioVo.size(); i++) {

                    miInventarioVo = miListaInventarioVo.get(i);
                    valorAPagarDE = new BigDecimal(0);
                    valorAPagarGA = new BigDecimal(0);
                    valorAPagarDEOnLine = new BigDecimal(0);
                    fechaInicioOperacion = miInventarioVo.getFechaInicioLiq();
                    fechaFinOperacion = miInventarioVo.getFechaFinLiq();
                    fechaInicioContrato = miInventarioVo.getFechaInicioContrato();
                    SiiEstablecimiento siiEstablecimiento = null;


                    // *****  para controlar la liquidacion por establecimiento
                    if (i == 0) {
                        tmpEstAct = miInventarioVo.getIdEstablecimiento();
                    }

                    if (i < (miListaInventarioVo.size() - 1)) {
                        miInventarioVo2 = miListaInventarioVo.get(i + 1);
                        tmpEstSte = miInventarioVo2.getIdEstablecimiento();
                    }

                    //********************************************
                    if (miInventarioVo.getFechaFinDefinitiva() != null) {
                        fechaFinContrato = miInventarioVo.getFechaFinDefinitiva();
                    }
                    else {
                        fechaFinContrato = miInventarioVo.getFechaFinContrato();
                    }

                    DuplaVO miDupla = calcularDiasALiquidar(vigencia, mesALiquidar, fechaInicioOperacion, fechaFinOperacion, fechaInicioContrato, fechaFinContrato);
                    if (miDupla != null) {
                        numeroDiasALiquidar = miDupla.getValor();
                        maximoDiaLiq = new BigDecimal(miDupla.getConcepto());
                    }

                    if (numeroDiasALiquidar.compareTo(new BigDecimal(0)) == 1) {
                        // cálculo del valor a pagar por derechos de explotación (DE)
                        if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 0 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 16) {
                            // Datos para resumen no conectados
                            listaTipoApuesta = tipoApuestaDao.buscarSiiTipoApuestaPorCodigoTipoApuesta(miInventarioVo.getCodigoApuesta());
                            if (listaTipoApuesta != null && listaTipoApuesta.size() > 0) {
                                siiTipoApuesta = listaTipoApuesta.get(0);
                            }

                            if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 5 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 16) {
                                valorDETmp = Utilidades.redondear((miInventarioVo.getDerechosExplMensual()), 0);
                                miInventarioVo.setDerechosExplMensual(valorDETmp);

                                if (numeroDiasALiquidar.compareTo(maximoDiaLiq) == 0) {
                                    valorAPagarDE = Utilidades.redondear(valorDETmp.multiply(new BigDecimal(miInventarioVo.getInventarioSillas())), 0);
                                }
                                else {
                                    valorAPagarDE =
                                        ((Utilidades.redondear(valorDETmp.divide(maximoDiaLiq, 3, RoundingMode.HALF_UP),
                                                               0)).multiply(numeroDiasALiquidar)).multiply(new BigDecimal(miInventarioVo.getInventarioSillas()));
                                }
                                valorAPagarGA = valorAPagarDE.multiply(tarifaGA);
                                valorTotalMensual = valorAPagarDE.add(valorAPagarGA);

                                // totaliza por tipo de apuesta
                                if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 6) {
                                    numElementosApuesta6 = numElementosApuesta6 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta6 = deTipoApuesta6.add(valorAPagarDE);
                                    tarifaTipoA6 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta6 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 7) {
                                    numElementosApuesta7 = numElementosApuesta7 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta7 = deTipoApuesta7.add(valorAPagarDE);
                                    tarifaTipoA7 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta7 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 8) {
                                    numElementosApuesta8 = numElementosApuesta8 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta8 = deTipoApuesta8.add(valorAPagarDE);
                                    tarifaTipoA8 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta8 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 9) {
                                    numElementosApuesta9 = numElementosApuesta9 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta9 = deTipoApuesta9.add(valorAPagarDE);
                                    tarifaTipoA9 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta9 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 10) {
                                    numElementosApuesta10 = numElementosApuesta10 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta10 = deTipoApuesta10.add(valorAPagarDE);
                                    tarifaTipoA10 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta10 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 11) {
                                    numElementosApuesta11 = numElementosApuesta11 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta11 = deTipoApuesta11.add(valorAPagarDE);
                                    tarifaTipoA11 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta11 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 12) {
                                    numElementosApuesta12 = numElementosApuesta12 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta12 = deTipoApuesta12.add(valorAPagarDE);
                                    tarifaTipoA12 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta12 = siiTipoApuesta;
                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 13) {
                                    numElementosApuesta13 = numElementosApuesta13 + (miInventarioVo.getInventarioSillas()).intValue();
                                    deTipoApuesta13 = deTipoApuesta13.add(valorAPagarDE);
                                    tarifaTipoA13 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta13 = siiTipoApuesta;
                                }

                            }
                            else {
                                valorDETmp = Utilidades.redondear((miInventarioVo.getDerechosExplMensual()), 0);
                                miInventarioVo.setDerechosExplMensual(valorDETmp);
                                if (numeroDiasALiquidar.compareTo(maximoDiaLiq) == 0) {
                                    valorAPagarDE = Utilidades.redondear(valorDETmp, 0);
                                }
                                else {
                                    valorAPagarDE = ((Utilidades.redondear(valorDETmp.divide(maximoDiaLiq, 3, RoundingMode.HALF_UP), 0)).multiply(numeroDiasALiquidar));
                                }
                                valorDETarifaFija = valorAPagarDE;
                                if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) > 0 && Integer.parseInt(miInventarioVo.getCodigoApuesta()) < 4) {
                                    if (miInventarioVo.getIndicadorOnLine().equals("S")) {
                                        if (reporteVtasVo != null) {
                                            if (reporteVtasSugerida == null && reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                                                valorAPagarDEOnLine = calcularDEMetsOnLine(miInventarioVo.getIdMet(), mesALiquidar, vigencia, reporteVtasVo, reporteVtasSugerida);
                                            }
                                            else if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.VENTAS_MODIFICADAS.getId()) ||
                                                     reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.VENTAS_Q.getId())) {
                                                valorAPagarDEOnLine = calcularDEMetsOnLine(miInventarioVo.getIdMet(), mesALiquidar, vigencia, reporteVtasVo, reporteVtasSugerida);
                                                /*duplaModif = calcularDEMetsOnLineModificada(miInventarioVo.getIdMet(), mesALiquidar, vigencia, reporteVtasVo, reporteVtasSugerida);
                                                            if(duplaModif!= null){
                                                                valorAPagarDEOnLine = duplaModif.getValor();
                                                            }*/
                                            }


                                            if (valorAPagarDEOnLine != null) {
                                                if (valorAPagarDE.compareTo(valorAPagarDEOnLine) < 0) {
                                                    valorAPagarDE = valorAPagarDEOnLine;
                                                }
                                            }
                                            // Actualiza ventas Met
                                            if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                                                List<SiiVentasMet> listaSiiVentas = ventasMetDao.buscarVentasMetPorReporteVentasYNuc(reporteVtasVo.getRveCodigo(), miInventarioVo.getNuc());
                                                if (listaSiiVentas != null && listaSiiVentas.size() > 0) {
                                                    for (SiiVentasMet siiVentas : listaSiiVentas) {
                                                        if (siiVentas.getSiiMet().getMetCodigo().equals(miInventarioVo.getIdMet())) {
                                                            siiVentas.setVmeLiqTarifaFija(valorDETarifaFija);
                                                            siiVentas.setVmeLiqTarifaVar(valorAPagarDEOnLine);
                                                            siiVentas.setVmeLiqEfectiva(valorAPagarDE);
                                                            ventasMetDao.actualizar(siiVentas);
                                                        }
                                                    }
                                                }
                                                else {
                                                    // se inserta la ventas con valor tarifa variable cero
                                                    SiiVentasMet siiVentasNo = new SiiVentasMet();
                                                    siiVentasNo.setVmeValorInicial(new BigDecimal(0));
                                                    SiiMet siiMetNo = metDao.buscarPorCodigoMet(miInventarioVo.getIdMet());
                                                    siiVentasNo.setSiiMet(siiMetNo);
                                                    siiVentasNo.setVmeVigencia(vigencia);
                                                    SiiMes siiMesNo = mesDao.buscarMesPorId(mesALiquidar);
                                                    siiVentasNo.setSiiMes(siiMesNo);
                                                    siiVentasNo.setVmeDiasRepor(new Integer(0));
                                                    siiVentasNo.setSiiReporteVentas(reporteVtasVo);
                                                    siiVentasNo.setVmeLiqTarifaFija(valorDETarifaFija);
                                                    siiVentasNo.setVmeLiqTarifaVar(new BigDecimal(0));
                                                    siiVentasNo.setVmeLiqEfectiva(valorDETarifaFija);
                                                    siiVentasNo.setSiiContrato((conversionVoEntidad.convertir(miContrato)));
                                                    ventasMetDao.insertarSiiVentasMet(siiVentasNo);

                                                }
                                            }
                                            else if (reporteVtasVo.getRveTipoReporte().equals(EnumTipoReporteVentas.VENTAS_MODIFICADAS.getId())) {
                                                //Actualiza modificaciones ventas
                                                List<SiiModificaVentasMet> listaModif = modificaVentasMetDao.buscarModificacionesVentasPorReporteVentas(reporteVtasVo.getRveCodigo());
                                                if (listaModif != null && listaModif.size() > 0) {
                                                    for (SiiModificaVentasMet siiModificaVentasMet : listaModif) {
                                                        if (siiModificaVentasMet.getSiiVentasMet().getSiiMet().getMetUid().equals(miInventarioVo.getNuc())) {
                                                            siiModificaVentasMet.setMvmLiqTarifaFija(valorDETarifaFija);
                                                            siiModificaVentasMet.setMvmLiqTarifaVar(valorAPagarDEOnLine);
                                                            siiModificaVentasMet.setMvmLiqEfectiva(valorAPagarDE);
                                                            modificaVentasMetDao.actualizarSiiModificaVentasMet(siiModificaVentasMet);
                                                        }
                                                    }
                                                }
                                            }


                                        }
                                        else {
                                            // Se registran en resumen no conectada Mets conectadas sin reporte de ventas
                                            if ((miInventarioVo.getCodigoApuesta().trim().equals("1"))) {
                                                numElementosApuesta1 = numElementosApuesta1 + 1;
                                                deTipoApuesta1 = deTipoApuesta1.add(valorAPagarDE);
                                                tarifaTipoA1 = miInventarioVo.getDerechosExplMensual();
                                                siiTipoApuesta1 = siiTipoApuesta;
                                            }
                                            else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 2) {
                                                numElementosApuesta2 = numElementosApuesta2 + 1;
                                                deTipoApuesta2 = deTipoApuesta2.add(valorAPagarDE);
                                                tarifaTipoA2 = miInventarioVo.getDerechosExplMensual();
                                                siiTipoApuesta2 = siiTipoApuesta;
                                            }
                                            else if ((miInventarioVo.getCodigoApuesta().trim().equals("3"))) {
                                                numElementosApuesta3 = numElementosApuesta3 + 1;
                                                deTipoApuesta3 = deTipoApuesta3.add(valorAPagarDE);
                                                tarifaTipoA3 = miInventarioVo.getDerechosExplMensual();
                                                siiTipoApuesta3 = siiTipoApuesta;

                                            }
                                        }

                                    }
                                    else if ((miInventarioVo.getCodigoApuesta().trim().equals("1"))) {
                                        numElementosApuesta1 = numElementosApuesta1 + 1;
                                        deTipoApuesta1 = deTipoApuesta1.add(valorAPagarDE);
                                        tarifaTipoA1 = miInventarioVo.getDerechosExplMensual();
                                        siiTipoApuesta1 = siiTipoApuesta;
                                    }
                                    else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 2) {
                                        numElementosApuesta2 = numElementosApuesta2 + 1;
                                        deTipoApuesta2 = deTipoApuesta2.add(valorAPagarDE);
                                        tarifaTipoA2 = miInventarioVo.getDerechosExplMensual();
                                        siiTipoApuesta2 = siiTipoApuesta;
                                    }
                                    else if ((miInventarioVo.getCodigoApuesta().trim().equals("3"))) {
                                        numElementosApuesta3 = numElementosApuesta3 + 1;
                                        deTipoApuesta3 = deTipoApuesta3.add(valorAPagarDE);
                                        tarifaTipoA3 = miInventarioVo.getDerechosExplMensual();
                                        siiTipoApuesta3 = siiTipoApuesta;
                                    }
                                    else {
                                        System.out.println(" Else Met:" + miInventarioVo.getIdMet() + " apuesta: " + miInventarioVo.getCodigoApuesta());
                                    }


                                }
                                else if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 4) {
                                    numElementosApuesta4 = numElementosApuesta4 + 1;
                                    deTipoApuesta4 = deTipoApuesta4.add(valorAPagarDE);
                                    tarifaTipoA4 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta4 = siiTipoApuesta;
                                }
                                if (Integer.parseInt(miInventarioVo.getCodigoApuesta()) == 5) {
                                    numElementosApuesta5 = numElementosApuesta5 + 1;
                                    deTipoApuesta5 = deTipoApuesta5.add(valorAPagarDE);
                                    tarifaTipoA5 = miInventarioVo.getDerechosExplMensual();
                                    siiTipoApuesta5 = siiTipoApuesta;
                                }
                                valorAPagarGA = valorAPagarDE.multiply(tarifaGA);
                                valorTotalMensual = valorAPagarDE.add(valorAPagarGA);
                            }
                        }
                        // Totaliza DE y GA
                        totalDE = totalDE.add(valorAPagarDE);
                        deTotalEstab = deTotalEstab.add(valorAPagarDE);


                        // ********* liquidacion por establecimiento *****
                        if (i == (miListaInventarioVo.size() - 1)) {
                            tmpEstSte = miInventarioVo.getIdEstablecimiento();
                            deEst = deTotalEstab;
                            gaEst = Utilidades.redondear(deEst.multiply(tarifaGA), 0);

                            SiiLiquidacionEstabl siiLiquidacionEstablDE1 = new SiiLiquidacionEstabl();
                            SiiLiquidacionEstabl siiLiquidacionEstablGA1 = new SiiLiquidacionEstabl();
                            // Se consulta el establecimiento
                            siiEstablecimiento = establecimientoDao.buscarEstablecimientoPorId(miInventarioVo.getIdEstablecimiento());

                            siiLiquidacionEstablDE1.setLesValor(deEst);
                            siiLiquidacionEstablDE1.setSiiEstablecimiento(siiEstablecimiento);
                            siiLiquidacionEstablGA1.setLesValor(gaEst);
                            siiLiquidacionEstablGA1.setSiiEstablecimiento(siiEstablecimiento);

                            listaLiqEstabDE.add(siiLiquidacionEstablDE1);
                            listaLiqEstabGA.add(siiLiquidacionEstablGA1);

                            System.out.println(" Establecimiento:" + siiEstablecimiento.getEstCodigo() + " totalDE:" + deEst);
                            System.out.println(" Establecimiento:" + siiEstablecimiento.getEstCodigo() + " totalGA:" + gaEst);

                            deEst = new BigDecimal(0);
                            gaEst = new BigDecimal(0);
                            deTotalEstab = new BigDecimal(0);
                        }

                        if (!tmpEstAct.equals(tmpEstSte)) {
                            deEst = deTotalEstab;
                            gaEst = Utilidades.redondear(deEst.multiply(tarifaGA), 0);

                            SiiLiquidacionEstabl siiLiquidacionEstablDE = new SiiLiquidacionEstabl();
                            SiiLiquidacionEstabl siiLiquidacionEstablGA = new SiiLiquidacionEstabl();

                            // Se consulta el establecimiento
                            siiEstablecimiento = establecimientoDao.buscarEstablecimientoPorId(tmpEstAct);
                            siiLiquidacionEstablDE.setSiiEstablecimiento(siiEstablecimiento);
                            siiLiquidacionEstablDE.setLesValor(deEst);

                            siiLiquidacionEstablGA.setSiiEstablecimiento(siiEstablecimiento);
                            siiLiquidacionEstablGA.setLesValor(gaEst);


                            listaLiqEstabDE.add(siiLiquidacionEstablDE);
                            listaLiqEstabGA.add(siiLiquidacionEstablGA);

                            System.out.println(" Establecimiento:" + siiEstablecimiento.getEstCodigo() + " totalDE:" + deEst);
                            System.out.println(" Establecimiento:" + siiEstablecimiento.getEstCodigo() + " totalGA:" + gaEst);
                            deEst = new BigDecimal(0);
                            gaEst = new BigDecimal(0);
                            deTotalEstab = new BigDecimal(0);
                        }
                        tmpEstAct = tmpEstSte;

                        // **************

                    }

                } //*************
                totalDE = Utilidades.redondear(totalDE, 0);
                totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);

                listaNoConectado =
                    construirNoConectadas(numElementosApuesta1, deTipoApuesta1, tarifaTipoA1, siiTipoApuesta1, numElementosApuesta2, deTipoApuesta2, tarifaTipoA2, siiTipoApuesta2,
                                          numElementosApuesta3, deTipoApuesta3, tarifaTipoA3, siiTipoApuesta3, numElementosApuesta4, deTipoApuesta4, tarifaTipoA4, siiTipoApuesta4,
                                          numElementosApuesta5, deTipoApuesta5, tarifaTipoA5, siiTipoApuesta5, numElementosApuesta6, deTipoApuesta6, tarifaTipoA6, siiTipoApuesta6,
                                          numElementosApuesta7, deTipoApuesta7, tarifaTipoA7, siiTipoApuesta7, numElementosApuesta8, deTipoApuesta8, tarifaTipoA8, siiTipoApuesta8,
                                          numElementosApuesta9, deTipoApuesta9, tarifaTipoA9, siiTipoApuesta9, numElementosApuesta10, deTipoApuesta10, tarifaTipoA10, siiTipoApuesta10,
                                          numElementosApuesta11, deTipoApuesta11, tarifaTipoA11, siiTipoApuesta11, numElementosApuesta12, deTipoApuesta12, tarifaTipoA12, siiTipoApuesta12,
                                          numElementosApuesta13, deTipoApuesta13, tarifaTipoA13, siiTipoApuesta13);


                SiiLiquidacionMes liquidacionDE = new SiiLiquidacionMes();
                liquidacionDE.setLiqConcepto("DE");
                liquidacionDE.setLiqValor(totalDE);
                liquidacionDE.setLiqFechaLimPago(fechaPagoOportuno);
                liquidacionDE.setLiqFecha(fechaActual);
                liquidacionDE.setLmeVigencia(vigencia);
                liquidacionDE.setSiiContrato(conversionVoEntidad.convertir(miContrato));
                SiiMes siiMes = mesDao.buscarMesPorId(mesALiquidar);
                liquidacionDE.setSiiMes(siiMes);
                SiiSmmlv miSiiSmmlv = new SiiSmmlv();
                miSiiSmmlv.setSmmVigencia(vigencia);
                miSiiSmmlv.setSmmValor(valorSmmlv.longValue());
                liquidacionDE.setSiiSmmlv(miSiiSmmlv);
                liquidacionDE.setLmeNumCuota(new Integer(consecutivoCuota.intValue()));
                listaLiq.add(liquidacionDE);

                SiiLiquidacionMes liquidacionGA = new SiiLiquidacionMes();
                liquidacionGA.setLiqConcepto("GA");
                liquidacionGA.setLiqValor(totalGA);
                liquidacionGA.setLiqFechaLimPago(fechaPagoOportuno);
                liquidacionGA.setLiqFecha(fechaActual);
                liquidacionGA.setLmeVigencia(vigencia);
                liquidacionGA.setSiiContrato(conversionVoEntidad.convertir(miContrato));
                SiiMes siiMesGA = mesDao.buscarMesPorId(mesALiquidar);
                liquidacionGA.setSiiMes(siiMesGA);
                SiiSmmlv miSiiSmmlvGA = new SiiSmmlv();
                miSiiSmmlvGA.setSmmVigencia(vigencia);
                miSiiSmmlvGA.setSmmValor(valorSmmlv.longValue());
                liquidacionGA.setSiiSmmlv(miSiiSmmlvGA);
                liquidacionGA.setLmeNumCuota(new Integer(consecutivoCuota.intValue()));
                listaLiq.add(liquidacionGA);

                liquidacion.setListaLiq(listaLiq);
                liquidacion.setListaNoConectados(listaNoConectado);
                liquidacion.setListaLiqEstabDE(listaLiqEstabDE);
                liquidacion.setListaLiqEstabGA(listaLiqEstabGA);


            }


        } catch (Exception ex) {
            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarLiquidacionMensualAutomatico",
                                "Error en la ejecucion de la liquidación del contrato : " + numeroContrato + " - Mensaje : " + ex.getMessage(), null);
        }
        return liquidacion;
    }

    public List<SiiResumenNoConectado> construirNoConectadas(Integer numElementosApuesta1, BigDecimal deTipoApuesta1, BigDecimal tarifaTipoA1, SiiTipoApuesta siiTipoApuesta1,
                                                             Integer numElementosApuesta2, BigDecimal deTipoApuesta2, BigDecimal tarifaTipoA2, SiiTipoApuesta siiTipoApuesta2,
                                                             Integer numElementosApuesta3, BigDecimal deTipoApuesta3, BigDecimal tarifaTipoA3, SiiTipoApuesta siiTipoApuesta3,
                                                             Integer numElementosApuesta4, BigDecimal deTipoApuesta4, BigDecimal tarifaTipoA4, SiiTipoApuesta siiTipoApuesta4,
                                                             Integer numElementosApuesta5, BigDecimal deTipoApuesta5, BigDecimal tarifaTipoA5, SiiTipoApuesta siiTipoApuesta5,
                                                             Integer numElementosApuesta6, BigDecimal deTipoApuesta6, BigDecimal tarifaTipoA6, SiiTipoApuesta siiTipoApuesta6,
                                                             Integer numElementosApuesta7, BigDecimal deTipoApuesta7, BigDecimal tarifaTipoA7, SiiTipoApuesta siiTipoApuesta7,
                                                             Integer numElementosApuesta8, BigDecimal deTipoApuesta8, BigDecimal tarifaTipoA8, SiiTipoApuesta siiTipoApuesta8,
                                                             Integer numElementosApuesta9, BigDecimal deTipoApuesta9, BigDecimal tarifaTipoA9, SiiTipoApuesta siiTipoApuesta9,
                                                             Integer numElementosApuesta10, BigDecimal deTipoApuesta10, BigDecimal tarifaTipoA10, SiiTipoApuesta siiTipoApuesta10,
                                                             Integer numElementosApuesta11, BigDecimal deTipoApuesta11, BigDecimal tarifaTipoA11, SiiTipoApuesta siiTipoApuesta11,
                                                             Integer numElementosApuesta12, BigDecimal deTipoApuesta12, BigDecimal tarifaTipoA12, SiiTipoApuesta siiTipoApuesta12,
                                                             Integer numElementosApuesta13, BigDecimal deTipoApuesta13, BigDecimal tarifaTipoA13, SiiTipoApuesta siiTipoApuesta13) {
        List<SiiResumenNoConectado> listaNoConectado = new ArrayList();
        SiiResumenNoConectado resumenNoConect1 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect2 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect3 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect4 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect5 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect6 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect7 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect8 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect9 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect10 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect11 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect12 = new SiiResumenNoConectado();
        SiiResumenNoConectado resumenNoConect13 = new SiiResumenNoConectado();

        // SE arma los elementos no conectados

        if (siiTipoApuesta1 != null) {
            resumenNoConect1.setRncNumElemen(numElementosApuesta1);
            resumenNoConect1.setRncValorDe(deTipoApuesta1);
            resumenNoConect1.setRncValorTarifa(tarifaTipoA1);
            resumenNoConect1.setSiiTipoApuesta(siiTipoApuesta1);
            listaNoConectado.add(resumenNoConect1);
        }

        if (siiTipoApuesta2 != null) {
            resumenNoConect2.setRncNumElemen(numElementosApuesta2);
            resumenNoConect2.setRncValorDe(deTipoApuesta2);
            resumenNoConect2.setRncValorTarifa(tarifaTipoA2);
            resumenNoConect2.setSiiTipoApuesta(siiTipoApuesta2);
            listaNoConectado.add(resumenNoConect2);
        }

        if (siiTipoApuesta3 != null) {
            resumenNoConect3.setRncNumElemen(numElementosApuesta3);
            resumenNoConect3.setRncValorDe(deTipoApuesta3);
            resumenNoConect3.setRncValorTarifa(tarifaTipoA3);
            resumenNoConect3.setSiiTipoApuesta(siiTipoApuesta3);
            listaNoConectado.add(resumenNoConect3);
        }

        if (siiTipoApuesta4 != null) {
            resumenNoConect4.setRncNumElemen(numElementosApuesta4);
            resumenNoConect4.setRncValorDe(deTipoApuesta4);
            resumenNoConect4.setRncValorTarifa(tarifaTipoA4);
            resumenNoConect4.setSiiTipoApuesta(siiTipoApuesta4);
            listaNoConectado.add(resumenNoConect4);
        }

        if (siiTipoApuesta5 != null) {
            resumenNoConect5.setRncNumElemen(numElementosApuesta5);
            resumenNoConect5.setRncValorDe(deTipoApuesta5);
            resumenNoConect5.setRncValorTarifa(tarifaTipoA5);
            resumenNoConect5.setSiiTipoApuesta(siiTipoApuesta5);
            listaNoConectado.add(resumenNoConect5);
        }

        if (siiTipoApuesta6 != null) {
            resumenNoConect6.setRncNumElemen(numElementosApuesta6);
            resumenNoConect6.setRncValorDe(deTipoApuesta6);
            resumenNoConect6.setRncValorTarifa(tarifaTipoA6);
            resumenNoConect6.setSiiTipoApuesta(siiTipoApuesta6);
            listaNoConectado.add(resumenNoConect6);
        }

        if (siiTipoApuesta7 != null) {
            resumenNoConect7.setRncNumElemen(numElementosApuesta7);
            resumenNoConect7.setRncValorDe(deTipoApuesta7);
            resumenNoConect7.setRncValorTarifa(tarifaTipoA7);
            resumenNoConect7.setSiiTipoApuesta(siiTipoApuesta7);
            listaNoConectado.add(resumenNoConect7);
        }

        if (siiTipoApuesta8 != null) {
            resumenNoConect8.setRncNumElemen(numElementosApuesta8);
            resumenNoConect8.setRncValorDe(deTipoApuesta8);
            resumenNoConect8.setRncValorTarifa(tarifaTipoA8);
            resumenNoConect8.setSiiTipoApuesta(siiTipoApuesta8);
            listaNoConectado.add(resumenNoConect8);
        }

        if (siiTipoApuesta9 != null) {
            resumenNoConect9.setRncNumElemen(numElementosApuesta9);
            resumenNoConect9.setRncValorDe(deTipoApuesta9);
            resumenNoConect9.setRncValorTarifa(tarifaTipoA9);
            resumenNoConect9.setSiiTipoApuesta(siiTipoApuesta9);
            listaNoConectado.add(resumenNoConect9);
        }

        if (siiTipoApuesta10 != null) {
            resumenNoConect10.setRncNumElemen(numElementosApuesta10);
            resumenNoConect10.setRncValorDe(deTipoApuesta10);
            resumenNoConect10.setRncValorTarifa(tarifaTipoA10);
            resumenNoConect10.setSiiTipoApuesta(siiTipoApuesta10);
            listaNoConectado.add(resumenNoConect10);
        }

        if (siiTipoApuesta11 != null) {
            resumenNoConect11.setRncNumElemen(numElementosApuesta11);
            resumenNoConect11.setRncValorDe(deTipoApuesta11);
            resumenNoConect11.setRncValorTarifa(tarifaTipoA11);
            resumenNoConect11.setSiiTipoApuesta(siiTipoApuesta11);
            listaNoConectado.add(resumenNoConect11);
        }

        if (siiTipoApuesta12 != null) {
            resumenNoConect12.setRncNumElemen(numElementosApuesta12);
            resumenNoConect12.setRncValorDe(deTipoApuesta12);
            resumenNoConect12.setRncValorTarifa(tarifaTipoA12);
            resumenNoConect12.setSiiTipoApuesta(siiTipoApuesta12);
            listaNoConectado.add(resumenNoConect12);
        }

        if (siiTipoApuesta13 != null) {
            resumenNoConect13.setRncNumElemen(numElementosApuesta13);
            resumenNoConect13.setRncValorDe(deTipoApuesta13);
            resumenNoConect13.setRncValorTarifa(tarifaTipoA13);
            resumenNoConect13.setSiiTipoApuesta(siiTipoApuesta13);
            listaNoConectado.add(resumenNoConect13);
        }

        return listaNoConectado;

    }

    public DuplaVO calcularDiasALiquidar(Integer vigencia, Integer mesALiquidar, Date fechaInicioOperacion, Date fechaFinOperacion, Date fechaInicioContrato, Date fechaFinContrato) {
        BigDecimal numeroDiasALiquidar;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        // mes anterior al de la liquidacion
        Calendar fechaIniComparar = Calendar.getInstance();
        fechaIniComparar.set(vigencia, mesALiquidar, 1);
        fechaIniComparar.add(Calendar.MONTH, -1);
        Calendar fechaFinComparar = Calendar.getInstance();
        fechaFinComparar.set(vigencia, fechaIniComparar.get(Calendar.MONTH), fechaIniComparar.getActualMaximum(Calendar.DAY_OF_MONTH));
        // mes posterior al de la liquidacion
        Calendar fechaFinCompararCont = Calendar.getInstance();
        fechaFinCompararCont.set(vigencia, fechaFinComparar.get(Calendar.MONTH), 1);

        fechaFinCompararCont.set(vigencia, fechaFinCompararCont.get(Calendar.MONTH), 1);

        int maximoDiaLiq = 30;

        Calendar fechaInicioContratoTmp = Calendar.getInstance();
        Calendar fechaFinContratoTmp = Calendar.getInstance();
        fechaInicioContratoTmp.setTime(fechaInicioContrato);
        fechaFinContratoTmp.setTime(fechaFinContrato);

        // cálculo del número de dias a liquidar
       
        System.out.print( format1.format(fechaIniComparar.getTime()));
        System.out.print( format1.format(fechaFinOperacion));
       
        if (fechaInicioOperacion.after(fechaFinComparar.getTime()) || fechaFinOperacion.before(fechaIniComparar.getTime())) {
            numeroDiasALiquidar = new BigDecimal(0);
        }
        else if (fechaInicioContrato.after(fechaIniComparar.getTime()) && (fechaInicioContrato.before(fechaFinComparar.getTime()) || fechaInicioContrato.equals(fechaFinComparar.getTime()))) {
            numeroDiasALiquidar = new BigDecimal(maximoDiaLiq - fechaInicioContratoTmp.get(Calendar.DATE) + 1);
        }
        else if ((fechaFinContrato.after(fechaIniComparar.getTime()) || fechaFinContrato.equals(fechaIniComparar.getTime())) && fechaFinContrato.before(fechaFinComparar.getTime())) {
            numeroDiasALiquidar = new BigDecimal(fechaFinContratoTmp.get((Calendar.DATE)));
            if (numeroDiasALiquidar.compareTo(new BigDecimal(maximoDiaLiq)) > 0)
                numeroDiasALiquidar = new BigDecimal(maximoDiaLiq);

        }
        else {
            numeroDiasALiquidar = new BigDecimal(maximoDiaLiq);
        }
        // valida cuando la fecha del contrato termina el primero de cada mes 
        if( numeroDiasALiquidar.compareTo(BigDecimal.ZERO ) == 0 && format1.format(fechaIniComparar.getTime()).equals(format1.format(fechaFinOperacion)) ){
            numeroDiasALiquidar=BigDecimal.ONE;
        }


        DuplaVO duplaVo = new DuplaVO();
        duplaVo.setValor(numeroDiasALiquidar);
        duplaVo.setConcepto(String.valueOf(maximoDiaLiq));
        return duplaVo;
    }

    public List<SiiLiquidacionMes> guardarLiquidacion(LiquidacionVO liquidacion, BigDecimal totalDE, BigDecimal tarifaGA, ContratoVO miContrato, int vigencia, int mesALiquidar,
                                                      SiiReporteVentas reporteVtas) throws ExcepcionDAO {
        System.out.print("Guarda liquidacion sugerida contrato:" + miContrato.getConNumero());
        SiiLiquidacionMes resultadoSiiLiquida = null;
        SiiLiquidacionMes resultadoLiquidacion = null;
        List<SiiLiquidacionMes> listaLiquidacion = new ArrayList();

        if (liquidacion != null) {
            if (liquidacion.getListaLiq() != null && liquidacion.getListaLiq().size() > 0) {
                for (SiiLiquidacionMes siiLiquidacionMes : liquidacion.getListaLiq()) {
                    if (reporteVtas != null) {
                        siiLiquidacionMes.setSiiReporteVentas(reporteVtas);
                    }


                    // inserta liquidacion para DE
                    if (siiLiquidacionMes.getLiqConcepto().equals("DE")) {
                        resultadoSiiLiquida = liquidacionMesDao.insertarLiquidacionMes(siiLiquidacionMes);
                        listaLiquidacion.add(resultadoSiiLiquida);
                    }
                    if (siiLiquidacionMes.getLiqConcepto().equals("GA")) {
                        resultadoLiquidacion = liquidacionMesDao.insertarLiquidacionMes(siiLiquidacionMes);
                        listaLiquidacion.add(resultadoLiquidacion);
                    }
                }

            }
        }

        // Se guarda la liquidacion por establecimiento
        System.out.println(" Comienza registro de la liquidacion por establecimiento..");
        guardarLiquidacionXEstablecimiento(resultadoSiiLiquida, resultadoLiquidacion, totalDE, liquidacion, tarifaGA);


        /*guardarLiquidacionEstablecimiento(miContrato, resultadoSiiLiquida,  resultadoLiquidacion,
                                                  tarifaGA, totalDE,vigencia,mesALiquidar,reporteVtas); */

        return listaLiquidacion;

    }

    public void guardarLiquidacionEstablecimiento(ContratoVO miContrato, SiiLiquidacionMes siiLiquidaDE, SiiLiquidacionMes siiLiquidaGA, BigDecimal totalDE, int vigencia, int mesALiquidar,
                                                  SiiReporteVentas reporteVtas, BigDecimal totalGA) {

        List<SiiLiquidacionEstabl> listaLiqEstabDE = new ArrayList<SiiLiquidacionEstabl>();

        try {
            System.out.println("Guarda liquidacion por establecimiento contrato:" + miContrato.getConNumero());
            listaLiqEstabDE = calcularDEPorEstablecimiento(miContrato, vigencia, mesALiquidar, totalDE, reporteVtas, siiLiquidaDE, siiLiquidaGA);
            // Se inserta la liquidación por establecimiento
            insertarLiquidacionEstablecimiento(listaLiqEstabDE);
        } catch (Exception ex) {
            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarLiquidacionMensualAutomatico",
                                "Error en la ejecucion de la liquidación del contrato : " + miContrato.getConNumero() + " - Mensaje : " + ex.getMessage(), null);
        }

    }

    public SiiInteresCuota calcularInteresCuota(SiiCuotaOperador resultadoSiiCuotaOperador, BigDecimal totalDE, Date fechaActual, long diasAno, Integer diasMora, String concepto) {
        // Busca la tasa del concepto DE
        BigDecimal intDE = new BigDecimal(0);
        SiiInteresCuota SiiInteres = new SiiInteresCuota();
        Long codigoConcepto = new Long(0);
        SiiConceptoCuota cuotaDe = null;
        BigDecimal pCien = new BigDecimal(100);
        try {
            if (resultadoSiiCuotaOperador != null) {
                cuotaDe = conceptoCuotaDao.buscarConceptoCuotaXId(resultadoSiiCuotaOperador.getSiiConceptoCuota().getCcuCodigo());
            }
            else {
                if (concepto.equals("DE"))
                    codigoConcepto = EnumConceptoCuota.DERECHOS_DE_EXPLOTACION.getId();
                else if (concepto.equals("GA"))
                    codigoConcepto = EnumConceptoCuota.GASTOS_DE_ADMINISTRACION.getId();

                cuotaDe = conceptoCuotaDao.buscarConceptoCuotaXId(codigoConcepto);
            }
            if (cuotaDe != null && cuotaDe.getCcuTipoTasa().equals(EnumTipoTasa.SUPER_BANCARIA.getId())) {
                SiiTasaIntSuperban tasaSB = tasaIntSuperbanDao.consultarTasaIntSuperbanActiva();
                intDE = ((totalDE.multiply(tasaSB.getTisTasa().divide(pCien, 5, RoundingMode.HALF_UP))).divide(new BigDecimal(diasAno), 3, RoundingMode.HALF_UP)).multiply(new BigDecimal(diasMora));

                SiiInteres.setIcuFecha(fechaActual);
                SiiInteres.setIcuBaseCalc(totalDE);
                SiiInteres.setIcuTasaAplic(tasaSB.getTisTasa());
                SiiInteres.setIcuCancelado("N");
                SiiInteres.setSiiCuotaOperador(resultadoSiiCuotaOperador);
                SiiInteres.setIcuValor(Utilidades.redondear(intDE, 0));

            }
        } catch (Exception ex) {
            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarInteresMensualAutomatico",
                                "Error en la ejecucion del interés - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS") + " - Mensaje : " + ex.getMessage(), null);
        }
        return SiiInteres;
    }

    public void ejecutarLiquidacionXEstablecimiento(int vigencia, int mesALiquidar, String tipoReporteVtas) throws ExcepcionDAO, ExcepcionAplicacion {

        List<SiiLiquidacionMes> listaLidacionMes = new ArrayList();
        List<ContratoVO> miListaContratos = new ArrayList();
        SiiReporteVentas reporteVtas = null;
        BigDecimal totalDE = new BigDecimal(0);
        BigDecimal totalGA = new BigDecimal(0);
        SiiLiquidacionMes siiLiquidacionDE = null;
        SiiLiquidacionMes siiLiquidacionGA = null;

        try {
            SiiContrato unSiiContrato = contratoDao.buscarContratoPorId(new Long(19337));
            miListaContratos.add(new ContratoVO(unSiiContrato));
            if (miListaContratos.size() > 0) {
                if (tipoReporteVtas.equals(EnumTipoReporteVentas.PRIMER_REPORTE.getId())) {
                    for (ContratoVO miContrato : miListaContratos) {
                        try {
                            reporteVtas = reporteVentasDao.buscarReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, tipoReporteVtas, miContrato.getConCodigo());
                            // Se consulta la liquidación de DE del contrato para el mes y vigencia dada
                            listaLidacionMes = liquidacionMesDao.buscarLiquidacionMesPorContratoPorVigenciaPorMes(miContrato.getConCodigo(), vigencia, mesALiquidar);

                            // cálculo de la liquidación por Establecimiento de DE
                            if (listaLidacionMes != null && listaLidacionMes.size() > 0) {
                                for (SiiLiquidacionMes unSiiLiquidacionMes : listaLidacionMes) {
                                    if (unSiiLiquidacionMes.getLiqConcepto().equals("DE")) {
                                        siiLiquidacionDE = unSiiLiquidacionMes;
                                        totalDE = unSiiLiquidacionMes.getLiqValor();
                                    }
                                    else if (unSiiLiquidacionMes.getLiqConcepto().equals("GA")) {
                                        siiLiquidacionGA = unSiiLiquidacionMes;
                                        totalGA = unSiiLiquidacionMes.getLiqValor();
                                    }
                                }
                                guardarLiquidacionEstablecimiento(miContrato, siiLiquidacionDE, siiLiquidacionGA, totalDE, vigencia, mesALiquidar, reporteVtas, totalGA);
                            }
                        } catch (ExcepcionDAO ex) {
                            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarLiquidacionXEstablecimiento",
                                                "Error en la ejecucion de liquidacion por establecimiento - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS") +
                                                " - Mensaje : " + ex.getMessage(), null);
                        }
                    } // cierre for
                }

            }
        } catch (ExcepcionDAO ex) {
            adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarLiquidacionXEstablecimiento",
                                "Error en la ejecucion de liquidacion por establecimiento - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS") + " - Mensaje : " +
                                ex.getMessage(), null);
            throw ex;
        }
        adminLogGeneral.log("AdminLiquidacionMesBean - ejecutarLiquidacionXEstablecimiento",
                            "Ejecucion correcta de la liquidacion por establecimiento - sistema : " + adminParametrosSistema.buscarCadenaParametroPorId("BASE_DE_DATOS"), null);

    }

    public void guardarLiquidacionXEstablecimiento(SiiLiquidacionMes resultadoSiiLiquidaDE, SiiLiquidacionMes resultadoSiiLiquidaGA, BigDecimal totalDE, LiquidacionVO liquidacion,
                                                   BigDecimal tarifaGA) {

        List<SiiLiquidacionEstabl> liquidaEstablDE = new ArrayList();
        List<SiiLiquidacionEstabl> liquidaEstablGA = new ArrayList();
        BigDecimal totalGA = totalDE.multiply(tarifaGA);

        try {

            if (liquidacion != null) {
                liquidaEstablDE = liquidacion.getListaLiqEstabDE();
                liquidaEstablGA = liquidacion.getListaLiqEstabGA();
            }

            // Se arma la liquidacion por establecimiento para DE para insertarla

            if (liquidaEstablDE != null && liquidaEstablDE.size() > 0) {
                for (SiiLiquidacionEstabl unaLiqDEVo : liquidaEstablDE) {
                    unaLiqDEVo.setSiiLiquidacionMes(resultadoSiiLiquidaDE);
                    unaLiqDEVo.setLesPonderado(unaLiqDEVo.getLesValor().divide(totalDE, 11, RoundingMode.HALF_UP));
                    liquidacionEstablecimientoDao.insertarSiiLiquidacionEstabl(unaLiqDEVo);
                }
            }

            if (liquidaEstablGA != null && liquidaEstablGA.size() > 0) {
                for (SiiLiquidacionEstabl unaLiqGAVo : liquidaEstablGA) {
                    unaLiqGAVo.setSiiLiquidacionMes(resultadoSiiLiquidaGA);
                    unaLiqGAVo.setLesPonderado(unaLiqGAVo.getLesValor().divide(totalGA, 11, RoundingMode.HALF_UP));
                    liquidacionEstablecimientoDao.insertarSiiLiquidacionEstabl(unaLiqGAVo);
                }
            }


        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
        }

    }

    /**
     * calcula los Derechos de explotacion de las Mets On Line MOdificadas.
     * @param idMet - Id de la MET.
     * @param mesALiquidar - Mes de las ventas reportadas.
     * param vigencia - vigencia de las ventas reportadas.
     * @return BigDecimal
     * @throws ExcepcionDAO
     */
    public DuplaVO calcularDEMetsOnLineModificada(Long idMet, int mesALiquidar, int vigencia, SiiReporteVentas reporteVtasVo, SiiReporteVentas reporteVtasSugerida) throws ExcepcionDAO {
        BigDecimal valorAPagarDeIng = new BigDecimal(0);
        List<SiiModificaVentasMet> listaModificaVtas = new ArrayList();
        DuplaVO respuesta = new DuplaVO();

        // Se consulta las ventas reportadas para la met
        LiquidaMetOnLineVO vtsVo = new LiquidaMetOnLineVO();
        // Busca parametro de liquidacion
        SiiParametrosSistema parametro = parametrosSistemaDao.buscarParametroPorId("PORCENTAJE_MET_VENTAS");
        BigDecimal parametroTmp = new BigDecimal(parametro.getPsiValor());
        BigDecimal parametroLiq = parametroTmp.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        if (idMet != null && reporteVtasSugerida != null) {
            vtsVo = ventasMetDao.buscarVentasMet(idMet, new Integer(mesALiquidar), new Integer(vigencia), reporteVtasSugerida);
            if (vtsVo != null) {
                // Consulto si existe una modificacion asociada a las ventas
                listaModificaVtas = modificaVentasMetDao.buscarModificacionesVentasPorCodigoVentasYRpteVtas(vtsVo.getVmeCodigo(), reporteVtasVo.getRveCodigo());
                if (listaModificaVtas.size() > 0) {
                    valorAPagarDeIng = Utilidades.redondear(listaModificaVtas.get(0).getMvmValorVentas().multiply(parametroLiq), 0);
                    respuesta.setConcepto(reporteVtasVo.getRveTipoReporte());
                    respuesta.setValor(valorAPagarDeIng);
                }
                else {
                    valorAPagarDeIng = Utilidades.redondear(vtsVo.getValorModifVentas().multiply(parametroLiq), 0);
                    respuesta.setConcepto(reporteVtasSugerida.getRveTipoReporte());
                    respuesta.setValor(valorAPagarDeIng);
                }
            }
        }
        return respuesta;
    }

    /**
     * obtiene la ultima liquidación.
     * @return LiquidacionMesVO
     * @throws ExcepcionDAO
     */

    public LiquidacionMesVO buscarUltimaLiquidacion() throws ExcepcionDAO {
        LiquidacionMesVO liquidaVo = null;
        List<SiiLiquidacionMes> listaSiiLiq = null;
        listaSiiLiq = liquidacionMesDao.buscarUltimaLiquidacion();
        if (listaSiiLiq != null && listaSiiLiq.size() > 0) {
            liquidaVo = new LiquidacionMesVO(listaSiiLiq.get(0));
        }
        return liquidaVo;

    }


    /**
     * @param miContrato
     * @param vigencia
     * @param mesALiquidar
     * @param consecutivoCuota
     */
    public void ejecutarLiquidacionMesPorContrato(ContratoVO miContrato, int vigencia, int mesALiquidar, Long consecutivoCuota) {
        Date fechaPagoOportuno = null;
        BigDecimal valorSmmlv = new BigDecimal(0);
        Calendar fechaInicial = Calendar.getInstance();
        fechaInicial.set(vigencia, mesALiquidar, 1);
        Calendar fechaFinal = Calendar.getInstance();
        fechaFinal.set(fechaInicial.get(Calendar.YEAR), fechaInicial.get(Calendar.MONTH), fechaInicial.getActualMaximum(Calendar.DAY_OF_MONTH));
        LiquidacionVO liquidacion = null;
        SiiReporteVentas reporteVtas = null;
        List<SiiLiquidacionMes> listaLiq = null;
        List<SiiResumenNoConectado> listaNoConectadas = null;
        BigDecimal totalDE = new BigDecimal(0);
        BigDecimal tarifaGA = (new BigDecimal(1)).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        SiiLiquidacionMes resultadoSiiLiquidaDE = null;
        SiiLiquidacionMes resultadoSiiLiquidaGA = null;
        SiiCuotaOperador resultadoSiiCuotaOperador = null;
        BigDecimal totalGA = new BigDecimal(0);
        Calendar fechaContable = Calendar.getInstance();
        fechaContable.set(vigencia, mesALiquidar - 1, 1);
        fechaContable.set(fechaContable.get(Calendar.YEAR), fechaContable.get(Calendar.MONTH), fechaContable.getActualMaximum(Calendar.DAY_OF_MONTH));
        try {
            // Calculo de la fecha de pago oportuno
            fechaPagoOportuno = obtenerDiasHabiles(fechaInicial, fechaFinal);

            // Se obtiene el valor del Smmlv
            Long valorSmmlvTmp = buscarSmmlvPorVigencia(vigencia);

            if (valorSmmlvTmp != null) {
                valorSmmlv = new BigDecimal(valorSmmlvTmp.longValue());
            }

            // Se obtiene el reporte de ventas del mes a liquidar
            reporteVtas = reporteVentasDao.buscarReporteVentasPorMesVigenciaTipoReporte(mesALiquidar, vigencia, EnumTipoReporteVentas.PRIMER_REPORTE.getId(), miContrato.getConCodigo());

            // Se ejecuta la liquidación
            liquidacion = ejecutarLiquidacionSugerida(miContrato, valorSmmlv, vigencia, mesALiquidar, fechaPagoOportuno, reporteVtas, consecutivoCuota.longValue(), null);

            // Se guarda la liquidación
            if (liquidacion != null) {
                listaLiq = liquidacion.getListaLiq();

                listaNoConectadas = liquidacion.getListaNoConectados();
                if (listaLiq != null && listaLiq.size() > 0) {
                    for (SiiLiquidacionMes unSiiLiquida : listaLiq) {
                        if (unSiiLiquida.getLiqConcepto().equals("DE"))
                            totalDE = unSiiLiquida.getLiqValor();
                    }
                }
            }

            // 2.  guarda liquidación mensual y liquidación establecimiento

            List<SiiLiquidacionMes> resultadoSiiLiquidacion = guardarLiquidacion(liquidacion, totalDE, tarifaGA, miContrato, vigencia, mesALiquidar, reporteVtas);

            // 3.  Guarda la cuota por operador para DE
            if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                for (SiiLiquidacionMes siiLiquida : resultadoSiiLiquidacion) {
                    if (siiLiquida.getLiqConcepto().equals("DE")) {
                        resultadoSiiLiquidaDE = siiLiquida;
                    }
                    if (siiLiquida.getLiqConcepto().equals("GA")) {
                        resultadoSiiLiquidaGA = siiLiquida;
                    }
                }
            }
            resultadoSiiCuotaOperador = null;
            if (resultadoSiiLiquidacion != null && resultadoSiiLiquidacion.size() > 0) {
                resultadoSiiCuotaOperador =
                    insertarCuotaOperador(resultadoSiiLiquidaDE, fechaPagoOportuno, consecutivoCuota.intValue(), totalDE, vigencia, mesALiquidar, "DE", miContrato.getOperadorVo().getOpeCodigo(),
                                          reporteVtas, "A");

                System.out.println("Guarda resumen no conectado:" + miContrato.getConNumero());
                if (listaNoConectadas != null && listaNoConectadas.size() > 0) {
                    for (SiiResumenNoConectado elemNoConectado : listaNoConectadas) {
                        elemNoConectado.setSiiCuotaOperador(resultadoSiiCuotaOperador);
                        resumenNoConectadoDao.insertarSiiResumenNoConectado(elemNoConectado);
                    }
                }
                totalGA = Utilidades.redondear(totalDE.multiply(tarifaGA), 0);
                resultadoSiiCuotaOperador = null;
                resultadoSiiCuotaOperador =
                    insertarCuotaOperador(resultadoSiiLiquidaGA, fechaPagoOportuno, consecutivoCuota.intValue(), totalGA, vigencia, mesALiquidar, "GA", miContrato.getOperadorVo().getOpeCodigo(),
                                          reporteVtas, "A");

                // 4. se insertar los documentos contables
                insertarMovimientosContables(TIPO_DOC_CONT_ACC, fechaContable.getTime(), consecutivoCuota, miContrato.getConNumero(), totalDE, totalGA, miContrato.getOperadorVo().getOpeCodigo(),
                                             resultadoSiiLiquidaDE, resultadoSiiLiquidaGA);

            }


        } catch (ExcepcionDAO e) {
            e.printStackTrace();
        }

    }

    public SiiInteresCuota calcularInteresModificada(Date fechaPagoOportuno, BigDecimal saldoConcepto, SiiCuotaOperador siiCuotaOperador) {
        Calendar fecha1 = Calendar.getInstance();
        fecha1.setTime(fechaPagoOportuno);
        fecha1.add(Calendar.DATE, 1);
        Calendar fecha2 = Calendar.getInstance();
        SiiTasaIntSuperban siiTasaIntSuperban = null;
        SiiTasaInteres siiTasaInteres = null;
        BigDecimal numeroDias = new BigDecimal(0);
        long diferencia = 0;
        long numDiasRestantes = 0;
        BigDecimal ims = new BigDecimal(0);
        BigDecimal im = new BigDecimal(0);
        BigDecimal imc = new BigDecimal(0);
        BigDecimal tisTasaTmp = new BigDecimal(0);
        BigDecimal saldoIntC = saldoConcepto;
        BigDecimal saldo = saldoConcepto;
        BigDecimal cien = BigDecimal.valueOf(100L);
        SiiInteresCuota SiiInteres = new SiiInteresCuota();

        try {
            // Si tipo tasa = SB
            if (siiCuotaOperador.getSiiConceptoCuota().getCcuTipoTasa().equals("SB")) {
                if (fecha1.getTime().before(fecha2.getTime()) || fecha1.getTime().equals(fecha2.getTime())) {
                    ims = new BigDecimal(0);

                    // Se consulta la tasa SB
                    siiTasaIntSuperban = tasaIntSuperbanDao.consultarTasaIntSuperbanXFecha(fecha1.getTime());
                    // Calcula el número de días
                    if (siiTasaIntSuperban != null) {
                        tisTasaTmp = siiTasaIntSuperban.getTisTasa().divide(new BigDecimal(100), 15, RoundingMode.HALF_UP);
                        if ((fecha1.getTime().after(siiTasaIntSuperban.getTisVigenDesde()) || fecha1.getTime().equals(siiTasaIntSuperban.getTisVigenDesde())) &&
                            fecha1.getTime().before(siiTasaIntSuperban.getTisVigenHasta()) &&
                            (fecha2.getTime().after(siiTasaIntSuperban.getTisVigenDesde()) &&
                             (fecha2.getTime().before(siiTasaIntSuperban.getTisVigenHasta()) || fecha2.getTime().equals(siiTasaIntSuperban.getTisVigenHasta())))) {
                            diferencia = fecha2.getTime().getTime() - fecha1.getTime().getTime();
                            numDiasRestantes = (diferencia / (1000 * 60 * 60 * 24) + 1);
                            numeroDias = new BigDecimal(numDiasRestantes);
                        }
                        else if (fecha1.getTime().before(siiTasaIntSuperban.getTisVigenDesde()) && fecha2.getTime().after(siiTasaIntSuperban.getTisVigenHasta())) {

                            diferencia = siiTasaIntSuperban.getTisVigenHasta().getTime() - siiTasaIntSuperban.getTisVigenDesde().getTime();
                            numDiasRestantes = (diferencia / (1000 * 60 * 60 * 24) + 1);
                            numeroDias = new BigDecimal(numDiasRestantes);
                        }
                        else if ((fecha1.getTime().after(siiTasaIntSuperban.getTisVigenDesde()) || fecha1.getTime().equals(siiTasaIntSuperban.getTisVigenDesde())) &&
                                 (fecha1.getTime().before(siiTasaIntSuperban.getTisVigenHasta()) || fecha1.getTime().equals(siiTasaIntSuperban.getTisVigenHasta()))) {
                            diferencia = siiTasaIntSuperban.getTisVigenHasta().getTime() - fecha1.getTime().getTime();
                            numDiasRestantes = (diferencia / (1000 * 60 * 60 * 24) + 1);
                            numeroDias = new BigDecimal(numDiasRestantes);
                        }
                        else if ((fecha2.getTime().after(siiTasaIntSuperban.getTisVigenDesde()) || fecha2.getTime().equals(siiTasaIntSuperban.getTisVigenDesde())) &&
                                 (fecha2.getTime().before(siiTasaIntSuperban.getTisVigenHasta()) || fecha2.getTime().equals(siiTasaIntSuperban.getTisVigenHasta()))) {
                            diferencia = fecha2.getTime().getTime() - siiTasaIntSuperban.getTisVigenDesde().getTime();
                            numDiasRestantes = (diferencia / (1000 * 60 * 60 * 24) + 1);
                            numeroDias = new BigDecimal(numDiasRestantes);
                        }

                        // Valida el tipo de interes
                        if (siiTasaIntSuperban.getTisTipoInteres().equals(EnumTasaIntSuperBan.SIMPLE.getId())) {
                            ims = (saldo.multiply(tisTasaTmp).multiply(numeroDias)).divide(new BigDecimal(365), 15, RoundingMode.HALF_UP);
                            im = im.add(ims);
                        }
                        else if (siiTasaIntSuperban.getTisTipoInteres().equals(EnumTasaIntSuperBan.COMPUESTO.getId())) {
                            imc =
                                saldoIntC.multiply(new BigDecimal(Math.pow((BigDecimal.ONE.add(siiTasaIntSuperban.getTisTasa().divide(new BigDecimal(100), 15, RoundingMode.HALF_UP))).doubleValue(),
                                                                           (numeroDias.divide(new BigDecimal(365), 15, RoundingMode.HALF_UP)).doubleValue()) - 1));
                            saldoIntC = saldoIntC.add(imc);
                            im = im.add(imc);
                        }
                        //****
                        fecha1.add(Calendar.DAY_OF_YEAR, 1);
                    }
                }
            } //si  tipo de tasa es diferente a SB
            else {
                if (fecha1.getTime().before(fecha2.getTime()) || fecha1.getTime().equals(fecha2.getTime())) {
                    siiTasaInteres = tasaInteresDao.consultarTasaIntXFecha(fecha1.getTime(), siiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura());
                    if (siiTasaInteres.getTaiCodigo() != null) {
                        // Calcula el número de días
                        diferencia = fecha2.getTime().getTime() - fecha1.getTime().getTime();
                        numDiasRestantes = (diferencia / (1000 * 60 * 60 * 24) + 1);
                        numeroDias = new BigDecimal(numDiasRestantes);

                        // Calcula los intereses
                        im =
                            (saldo.multiply(siiTasaInteres.getTaiPorcentaje().divide(cien, 15, BigDecimal.ROUND_UNNECESSARY)).multiply(numeroDias)).divide(new BigDecimal(365), 15,
                                                                                                                                                           RoundingMode.HALF_UP);
                        //fecha1.add(Calendar.DAY_OF_YEAR, 1);
                    }
                }
            }

            SiiInteres.setIcuFecha(fecha2.getTime());
            SiiInteres.setIcuBaseCalc(saldoConcepto);
            if (siiCuotaOperador.getSiiConceptoCuota().getCcuTipoTasa().equals("SB"))
                SiiInteres.setIcuTasaAplic(siiTasaIntSuperban.getTisTasa());
            else
                SiiInteres.setIcuTasaAplic(siiTasaInteres.getTaiPorcentaje());
            SiiInteres.setIcuCancelado("N");
            SiiInteres.setSiiCuotaOperador(siiCuotaOperador);
            SiiInteres.setIcuValor(Utilidades.redondear(im, 0));

        } catch (ExcepcionDAO e) {
            e.printStackTrace();
        }
        return SiiInteres;

    }


}
