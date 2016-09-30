package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoInventario;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFinancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EnteTerritorialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteDocumDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.JuegoMesaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LicenciaAcdvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MarcaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MesaCasinoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MetDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonalEmpresaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminalAcdvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocRadicadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoIdentificacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoInstrumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoPersonalDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.UbicacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.EstadoCargueInventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.MovCargInvEstCargInvDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.siito.MovCargueInventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEnteTerritorial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteDocum;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiJuegoMesa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLicenciaAcdv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMarca;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMesaCasino;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminalAcdv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocRadicado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoEstadoCargueInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargInvEstCargInv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueInventario;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOWS;
import co.gov.coljuegos.siicol.ejb.vo.ClaseJuegoVO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleFinancVO;
import co.gov.coljuegos.siicol.ejb.vo.EnteTerritorialVO;
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
import co.gov.coljuegos.siicol.ejb.wsvo.DocumentoRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.ExpedienteRadicadoWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.MovCargueInventarioWSVO;
import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminNovedadBean implements AdminNovedad {

    @EJB
    private OperadorDAO operadorDAO;
    @EJB
    private PersonaDAO personaDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDAO;
    @EJB
    private InventarioDAO inventarioDAO;
    @EJB
    private ContratoDAO contratoDAO;
    @EJB
    private EstablecimientoDAO establecimientoDAO;
    @EJB
    private NovedadDAO novedadDAO;
    @EJB
    private InstrumentoDAO instrumentoDAO;
    @EJB
    private MarcaDAO marcaDAO;
    @EJB
    private MetDAO metDAO;
    @EJB
    private PersonalEmpresaDAO personalEmpresaDAO;
    @EJB
    private DetalleFinancDAO detalleFinancDAO;
    @EJB
    private ConversionVOWS conversionVOWS;
    @EJB
    private TipoInstrumentoDAO tipoInstrumentoDao;
    @EJB
    private MesaCasinoDAO mesaCasinoDAO;
    @EJB
    private UbicacionDAO ubicacionDAO;
    @EJB
    private MovCargueInventarioDAO movCargueInventarioDAO;
    @EJB
    private EstadoCargueInventarioDAO estadoCargueInventarioDAO;
    @EJB
    private MovCargInvEstCargInvDAO movCargInvEstCargInvDAO;
    @EJB
    private EnteTerritorialDAO enteTerritorialDAO;
    @EJB
    private LicenciaAcdvDAO licenciaAcdvDAO;
    @EJB
    private TerminalAcdvDAO terminalAcdvDAO;
    @EJB
    private TipoApuestaDAO tipoApuestaDAO;
    @EJB
    private EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    private EstadoContratoDAO estadoContratoDao;
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    @EJB
    private TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    private MarcaDAO marcaDao;
    @EJB
    private JuegoMesaDAO juegoMesaDao;
    @EJB
    private ExpedienteDocumDAO expedienteDocumDAO;
    @EJB
    private DocumentoRadicadoDAO documentoRadicadoDAO;
    @EJB
    private ExpedienteRadicadoDAO expedienteRadicadoDAO;
    @EJB
    private TipoPersonalDAO tipoPersonalDao;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    private TipoDocRadicadoDAO tipoDocRadicadoDao;

    public AdminNovedadBean() {
    }

    Long TIPO_SOLICITUD_CONTRATO_NUEVO = 10L;
    Long TIPO_SOLICITUD_RENOVACION_CONTRATO = 20L;
    Long TIPO_SOLICITUD_PRORROGA_CONTRATO = 30L;
    Long TIPO_SOLICITUD_ACTUALIZACION_OPERADOR = 50L;
    Long TIPO_SOLICITUD_DESISTIR_SOLICITUD = 70L;
    Long TIPO_SOLICITUD_TRASLADO_AUTOMATICO = 80L;
    Long TIPO_SOLICITUD_OTRAS_NOVEDADES = 90L;
    Long TIPO_INSTRUMENTO_MET = 1L;
    Long TIPO_INSTRUMENTO_BINGO = 2L;
    Long TIPO_NOVEDAD_CREACION_LOCAL = 20L;
    Long TIPO_NOVEDAD_ADICION_ELEMENTOS = 30L;
    Long TIPO_NOVEDAD_RETIRO_ELEMENTOS = 40L;
    Long TIPO_NOVEDAD_TRASLADO_ELEMENTOS = 50L;
    Long TIPO_NOVEDAD_REEMPLAZO_ELEMENTOS = 60L;
    Long TIPO_NOVEDAD_CAMBIO_APUESTA = 70L;
    Long TIPO_NOVEDAD_ELEMENTOS_EN_BODEGA = 80L;
    Long ESTADO_CONTRATO_ELABORADO = 1L;
    Long ESTADO_SOLICITUD_REVISADO = 1L;
    Long TIPO_PERSONAL_REVISOR_FISCAL = 1L;
    Long TIPO_PERSONAL_CONTACTO = 2L;
    Long TIPO_PERSONAL_APODERADO = 3L;
    Long TIPO_PERSONAL_SOCIO_MAYORITARIO = 4L;


    BigDecimal CLASE_JUEGO_LOCALIZADOS = new BigDecimal(1);

    public String aplicarNovedadesSolicitudLocalizados(SolicitudAutorizaVO solicitud, ContratoVO contrato, int tiempoProrroga, Long tipoNovedad, String direccionLocal, String ubicacionLocal,
                                                       List<InstrumentoVO> listaInstContratoNuevo, EstablecimientoVO establecimiento, TipoApuestaVO tipoApuesta, ClaseJuegoVO claseJuegoVo,
                                                       TipoJuegoVO tipoJuegoVo, InventarioVO inventarioVo, Integer numeroSillas, PersonaVO operador, String pNit, PersonaVO repLegal, PersonaVO revisor,
                                                       PersonaVO contacto, PersonaVO apoderado, PersonaVO socio1, PersonaVO socio2, PersonaVO socio3, PersonaVO socio4, PersonaVO socio5,
                                                       DetalleFinancVO detalleFinanVo, Long tipoElemento) throws ExcepcionDAO {

        // se inserta la solicitud
        SiiSolicitudAutoriza resultadoSolicitud = insertarSolicitudAutorizacion(solicitud);

        Calendar fechaSol = Calendar.getInstance();
        fechaSol.setTime(solicitud.getSauFecha());
        fechaSol.add(Calendar.DATE, -1);
        fechaSol.set(Calendar.HOUR, 23);
        fechaSol.set(Calendar.MINUTE, 59);
        fechaSol.set(Calendar.SECOND, 59);

        Calendar fechaIniOf = Calendar.getInstance();
        fechaIniOf.setTime(solicitud.getSauFecha());
        fechaIniOf.set(Calendar.HOUR, 0);

        Calendar fechaActual = Calendar.getInstance();
        fechaActual.set(Calendar.HOUR, 0);

        Calendar fechaFinConNuevo = Calendar.getInstance();
        fechaFinConNuevo.add(Calendar.YEAR, tiempoProrroga);


        List<SiiInventario> listaInventarios = new ArrayList<SiiInventario>();
        String resultado = "";

        //******
        //Long tipoElemento = 0L;
        String codLocal = "";
        int cantidadSillas = 0;
        String codLocalDestino = "";
        String uidMet = "";
        String nuidMet = "";
        String serialMet = "";
        SiiPersona perOper;
        List<SiiPersonalEmpresa> listPersonal = null;

        SiiContrato contratoPro = null;

        if (solicitud.getTipoSolicAutorizaVo() != null) {
            // se busca el operador
            SiiOperador operadorNuevoContrato = (operadorDAO.buscarOperadorPorNit(solicitud.getSauNit())).get(0);

            if (solicitud.getTipoSolicAutorizaVo().getTsaCodigo().equals(TIPO_SOLICITUD_CONTRATO_NUEVO)) {

                // se inserta el contrato
                SiiContrato resultadoSiiContrato = insertarSiiContrato(fechaActual.getTime(), fechaFinConNuevo.getTime(), ESTADO_CONTRATO_ELABORADO, operadorNuevoContrato);

                // se insertan las novedades
                SiiNovedad resultadoSiiNovedad = insertarSiiNovedad(fechaActual.getTime(), resultadoSiiContrato, tipoNovedad, resultadoSolicitud);

                // se inserta el establecimiento
                SiiEstablecimiento estableNuevoContrato = new SiiEstablecimiento();
                estableNuevoContrato.setEstCodInterno(establecimiento.getEstCodInterno());
                estableNuevoContrato.setEstDireccion(establecimiento.getEstDireccion());
                estableNuevoContrato.setEstNombre(establecimiento.getEstNombre());
                estableNuevoContrato.setSiiOperador2(operadorNuevoContrato);
                estableNuevoContrato.setSiiUbicacion1(conversionVoEntidad.convertir(establecimiento.getUbicacionVo()));
                SiiEstablecimiento resultadoSiiEstablecimiento = establecimientoDAO.insertarSiiEstablecimiento(estableNuevoContrato);

                // se insertan los instrumentos

                for (InstrumentoVO unInsContraNuevo : listaInstContratoNuevo) {
                    SiiInstrumento instrumentoContNuevo = conversionVoEntidad.convertir(unInsContraNuevo);
                    instrumentoContNuevo.setInsFechaRegistro(solicitud.getSauFecha());
                    instrumentoContNuevo.setInsActivo("S");
                    instrumentoContNuevo.setTapCodigo(unInsContraNuevo.getTapCodigo());

                    SiiTipoInstrumento tipoInstNuevo = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(unInsContraNuevo.getTipoInstrumentoVo().getTinCodigo());
                    instrumentoContNuevo.setSiiTipoInstrumento(tipoInstNuevo);

                    if (unInsContraNuevo.getTipoInstrumentoVo().getTinCodigo().equals(TIPO_INSTRUMENTO_MET)) {
                        // se inserta la marca
                        SiiMarca resultadoMarca = insertarSiiMarca(unInsContraNuevo.getMetVo().getMarcaVo());
                        // se inserta la Met
                        SiiMet resultadoSiiMet = insertarSiiMet(unInsContraNuevo.getMetVo(), resultadoMarca);
                        instrumentoContNuevo.setSiiMet(resultadoSiiMet);
                    }

                    if (operadorNuevoContrato != null) {
                        instrumentoContNuevo.setSiiOperador1(operadorNuevoContrato);
                    }
                    SiiInstrumento resultadoInstrumento = instrumentoDAO.insertarSiiInstrumento(instrumentoContNuevo);

                    SiiTipoApuesta siiTipoApuesta = conversionVoEntidad.convertir(tipoApuesta);

                    // Se inserta el inventario
                    insertarSiiInventario(fechaActual.getTime(), fechaActual.getTime(), fechaActual.getTime(), fechaActual.getTime(), resultadoSiiEstablecimiento, resultadoInstrumento,
                                          resultadoSiiNovedad, siiTipoApuesta, numeroSillas);

                }
            } else if (solicitud.getTipoSolicAutorizaVo().getTsaCodigo().equals(TIPO_SOLICITUD_RENOVACION_CONTRATO)) {
                // Se consulta el contrato existente
                SiiContrato contratoRenov = contratoDAO.buscarContratoPorNumero(contrato.getConNumero());

                // se insertan las novedades
                SiiNovedad resultadoSiiNovedad = insertarSiiNovedad(fechaActual.getTime(), contratoRenov, tipoNovedad, resultadoSolicitud);

                // se inserta el establecimiento
                SiiEstablecimiento estableNuevoContrato = new SiiEstablecimiento();
                estableNuevoContrato.setEstCodInterno(establecimiento.getEstCodInterno());
                estableNuevoContrato.setEstDireccion(establecimiento.getEstDireccion());
                estableNuevoContrato.setEstNombre(establecimiento.getEstNombre());
                estableNuevoContrato.setSiiOperador2(operadorNuevoContrato);
                estableNuevoContrato.setSiiUbicacion1(conversionVoEntidad.convertir(establecimiento.getUbicacionVo()));
                SiiEstablecimiento resultadoSiiEstablecimiento = establecimientoDAO.insertarSiiEstablecimiento(estableNuevoContrato);

                // se insertan los instrumentos

                for (InstrumentoVO unInsContraNuevo : listaInstContratoNuevo) {
                    SiiInstrumento instrumentoContNuevo = conversionVoEntidad.convertir(unInsContraNuevo);
                    instrumentoContNuevo.setInsFechaRegistro(solicitud.getSauFecha());
                    instrumentoContNuevo.setInsActivo("S");
                    instrumentoContNuevo.setTapCodigo(unInsContraNuevo.getTapCodigo());

                    SiiTipoInstrumento tipoInstNuevo = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(unInsContraNuevo.getTipoInstrumentoVo().getTinCodigo());
                    instrumentoContNuevo.setSiiTipoInstrumento(tipoInstNuevo);

                    if (unInsContraNuevo.getTipoInstrumentoVo().getTinCodigo().equals(TIPO_INSTRUMENTO_MET)) {
                        // se inserta la marca
                        SiiMarca resultadoMarca = insertarSiiMarca(unInsContraNuevo.getMetVo().getMarcaVo());
                        // se inserta la Met
                        SiiMet resultadoSiiMet = insertarSiiMet(unInsContraNuevo.getMetVo(), resultadoMarca);
                        instrumentoContNuevo.setSiiMet(resultadoSiiMet);
                    }

                    if (operadorNuevoContrato != null) {
                        instrumentoContNuevo.setSiiOperador1(operadorNuevoContrato);
                    }
                    SiiInstrumento resultadoInstrumento = instrumentoDAO.insertarSiiInstrumento(instrumentoContNuevo);

                    SiiTipoApuesta siiTipoApuesta = conversionVoEntidad.convertir(tipoApuesta);

                    // Se inserta el inventario
                    insertarSiiInventario(fechaActual.getTime(), fechaActual.getTime(), fechaActual.getTime(), fechaActual.getTime(), resultadoSiiEstablecimiento, resultadoInstrumento,
                                          resultadoSiiNovedad, siiTipoApuesta, numeroSillas);

                }

            } else if (solicitud.getTipoSolicAutorizaVo().getTsaCodigo().equals(TIPO_SOLICITUD_PRORROGA_CONTRATO)) {
                if (contrato != null && !contrato.equals("")) {
                    // se actualiza el contrato segun la prorroga
                    SiiContrato unContrato = new SiiContrato();
                    unContrato = contratoDAO.buscarContratoPorNumero(contrato.getConNumero());
                    if (unContrato != null) {
                        Calendar fechafinContrato = Calendar.getInstance();
                        fechafinContrato.setTime(unContrato.getConFechaFin());
                        fechafinContrato.add(Calendar.YEAR, tiempoProrroga);
                        unContrato.setConFechaFin(fechafinContrato.getTime());
                        contratoPro = contratoDAO.actualizarSiiContrato(unContrato);

                    }
                    // se inserta la novedad
                    SiiNovedad ResulNovedadPro = insertarSiiNovedad(fechaActual.getTime(), contratoPro, tipoNovedad, resultadoSolicitud);


                    listaInventarios = inventarioDAO.buscarInventarioPorNumContrato(unContrato.getConNumero());
                    if (listaInventarios != null) {
                        for (SiiInventario unInventario : listaInventarios) {
                            unInventario.setInvFechaFinLiq(fechaActual.getTime());
                            unInventario.setInvFechaFinOfi(fechaActual.getTime());
                            unInventario.setInvFechaIniLiq(fechaActual.getTime());
                            unInventario.setInvFechaIniOfi(fechaActual.getTime());
                            unInventario.setInvEstado("PA");
                            unInventario.setSiiNovedad(ResulNovedadPro);
                            inventarioDAO.insertarSiiInventario(unInventario);
                        }
                    }
                }
            } else if (solicitud.getTipoSolicAutorizaVo().getTsaCodigo().equals(TIPO_SOLICITUD_ACTUALIZACION_OPERADOR)) {
                // Se consulta y actualiza el operador
                perOper = personaDAO.buscarPersonaPorNumeroIdYTipoId(pNit, "NIT");
                if (perOper != null) {
                    if (operador.getPerJurNombreLargo() != null && !operador.getPerJurNombreLargo().equals("")) {
                        perOper.setPerJurNombreLargo(operador.getPerJurNombreLargo());
                    }
                    if (operador.getPerDireccion() != null && !operador.getPerDireccion().equals("")) {
                        perOper.setPerDireccion(operador.getPerDireccion());
                    }
                    if (operador.getPerTelefono() != null && !operador.getPerTelefono().equals("")) {
                        perOper.setPerTelefono(operador.getPerTelefono());
                    }
                    if (operador.getPerTelefono2() != null && !operador.getPerTelefono2().equals("")) {
                        perOper.setPerTelefono2(operador.getPerTelefono2());
                    }
                    if (operador.getPerEmail() != null && !operador.getPerEmail().equals("")) {
                        perOper.setPerEmail(operador.getPerEmail());
                    }
                    if (operador.getUbicacionVo().getUbiCodigo() != null) {
                        SiiUbicacion siiUbicacion = ubicacionDAO.buscarUbicacionPorId(operador.getUbicacionVo().getUbiCodigo());
                        perOper.setSiiUbicacion1(siiUbicacion);
                    }
                    personaDAO.actualizarPersona(perOper);

                    // Se actualiza el representante Legal
                    SiiPersona repLegalOri = perOper.getSiiPersona();
                    if (repLegal != null && repLegalOri != null) {
                        actualizarSiiPersona(repLegalOri, repLegal);
                    }
                    // Se consulta y actualiza el revisor fiscal
                    listPersonal = personalEmpresaDAO.buscarPersonalEmpresaPorIdPersona(perOper.getPerCodigo());
                    if (listPersonal != null && listPersonal.size() > 0) {
                        for (SiiPersonalEmpresa personal : listPersonal) {
                            SiiPersona personalOr = personaDAO.buscarPersonaPorId(personal.getSiiPersona3().getPerCodigo());
                            if (personal.getSiiTipoPersonal().getTpeCodigo().equals(TIPO_PERSONAL_REVISOR_FISCAL)) {
                                if (personalOr != null && revisor != null) {
                                    actualizarSiiPersona(personalOr, revisor);
                                }
                            } else if (personal.getSiiTipoPersonal().getTpeCodigo().equals(TIPO_PERSONAL_CONTACTO)) {
                                if (personalOr != null && contacto != null) {
                                    actualizarSiiPersona(personalOr, contacto);
                                }
                            } else if (personal.getSiiTipoPersonal().getTpeCodigo().equals(TIPO_PERSONAL_APODERADO)) {
                                if (personalOr != null && apoderado != null) {
                                    actualizarSiiPersona(personalOr, apoderado);
                                }
                            } else if (personal.getSiiTipoPersonal().getTpeCodigo().equals(TIPO_PERSONAL_SOCIO_MAYORITARIO)) {
                                if (personalOr != null) {
                                    if (socio1 != null) {
                                        actualizarSiiPersona(personalOr, socio1);
                                    }
                                    if (socio2 != null) {
                                        actualizarSiiPersona(personalOr, socio2);
                                    }
                                    if (socio3 != null) {
                                        actualizarSiiPersona(personalOr, socio3);
                                    }
                                    if (socio4 != null) {
                                        actualizarSiiPersona(personalOr, socio4);
                                    }
                                    if (socio5 != null) {
                                        actualizarSiiPersona(personalOr, socio5);
                                    }
                                }
                            }
                        }
                    }
                    // Se actualizan las transacciones en moneda extranjera
                    SiiDetalleFinanc detalleFinanOr = detalleFinancDAO.buscarDetalleFinancPorPersona(perOper.getPerCodigo());
                    actualizarDetalleFinan(detalleFinanOr, detalleFinanVo);

                } else {
                    resultado = "001 No existe el operador";
                }


            } else if (solicitud.getTipoSolicAutorizaVo().getTsaCodigo().equals(TIPO_SOLICITUD_TRASLADO_AUTOMATICO)) {
                if (tipoElemento.equals(TIPO_INSTRUMENTO_MET)) {
                    SiiInventario siiInventario = inventarioDAO.buscarUltimoInstrumentoPorTipoElementoMet(uidMet, nuidMet, serialMet, tipoElemento);
                    if (siiInventario != null) {
                        siiInventario.setInvEstado("I");
                        // actualiza el inventario
                        inventarioDAO.actualizarSiiInventario(siiInventario);

                        // se inserta un nuevo registro en inventario en estado R
                        siiInventario.setInvFechaFinLiq(fechaSol.getTime());
                        siiInventario.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventario.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventario.setInvEstado("R");
                        inventarioDAO.insertarSiiInventario(siiInventario);

                        // Se inserta nuevo registro en inventario en estado A
                        SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                        siiEstablecimiento.setEstCodInterno(codLocal);
                        siiInventario.setSiiEstablecimiento(siiEstablecimiento);
                        siiInventario.setInvFechaIniLiq(fechaIniOf.getTime());
                        siiInventario.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventario.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventario.setInvEstado("A");
                        inventarioDAO.insertarSiiInventario(siiInventario);

                    }
                } else if (tipoElemento.equals(TIPO_INSTRUMENTO_BINGO)) {
                    // Busca el ultimo elemento del inventario del elemento para el local de la solicitud
                    SiiInventario siiInventarioBingo = inventarioDAO.buscarUltimoInstrumentoPorTipoElementoYLocal(tipoElemento, codLocal);
                    siiInventarioBingo.setInvEstado("I");
                    // actualiza el inventario
                    inventarioDAO.actualizarSiiInventario(siiInventarioBingo);

                    // se inserta un nuevo registro
                    siiInventarioBingo.setInvFechaFinLiq(fechaSol.getTime());
                    siiInventarioBingo.setInvFechaIniOfi(fechaIniOf.getTime());
                    siiInventarioBingo.setInvFechaFinOfi(fechaIniOf.getTime());
                    siiInventarioBingo.setInvEstado("R");
                    inventarioDAO.insertarSiiInventario(siiInventarioBingo);

                    // se inserta un nuevo registro si el numero de sillas del ultimo registro es mayor que el numero de sillas de la solicitud
                    if (siiInventarioBingo.getInvSillas() > cantidadSillas) {
                        numeroSillas = siiInventarioBingo.getInvSillas() - cantidadSillas;
                        siiInventarioBingo.setInvSillas(numeroSillas);
                        siiInventarioBingo.setInvFechaIniLiq(fechaIniOf.getTime());
                        siiInventarioBingo.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventarioBingo.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventarioBingo.setInvEstado("A");
                        inventarioDAO.insertarSiiInventario(siiInventarioBingo);
                    }
                    // Busca en el inventario,el ultimo elemento del juego en el local destino de la solicitud
                    SiiInventario siiInventarioBingo2 = inventarioDAO.buscarUltimoInstrumentoPorTipoElementoYLocal(tipoElemento, codLocalDestino);
                    if (siiInventarioBingo2 != null) {
                        siiInventarioBingo2.setInvSillas(numeroSillas);
                        siiInventarioBingo2.setInvEstado("I");

                        // actualiza el inventario
                        inventarioDAO.actualizarSiiInventario(siiInventarioBingo2);

                        // Inserta registro
                        siiInventarioBingo2.setInvFechaFinLiq(fechaSol.getTime());
                        siiInventarioBingo2.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvEstado("R");
                        inventarioDAO.insertarSiiInventario(siiInventarioBingo2);

                        //iinserta registro
                        siiInventarioBingo2.setInvSillas(numeroSillas + cantidadSillas);
                        siiInventarioBingo2.setInvFechaIniLiq(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvEstado("A");
                        inventarioDAO.insertarSiiInventario(siiInventarioBingo2);

                    } else {
                        SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                        siiEstablecimiento.setEstCodInterno(codLocalDestino);
                        siiInventarioBingo2.setSiiEstablecimiento(siiEstablecimiento);
                        siiInventarioBingo2.setInvSillas(cantidadSillas);
                        siiInventarioBingo2.setInvFechaIniLiq(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvFechaIniOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvFechaFinOfi(fechaIniOf.getTime());
                        siiInventarioBingo2.setInvEstado("A");
                        inventarioDAO.insertarSiiInventario(siiInventarioBingo2);
                    }
                }
            }

        } else if (tipoNovedad.equals(TIPO_NOVEDAD_CREACION_LOCAL)) {
            // inserta establecimiento
            SiiEstablecimiento establecimientoNuevo = new SiiEstablecimiento();
            establecimientoNuevo.setEstCodInterno(establecimiento.getEstCodInterno());
            establecimientoNuevo.setEstDireccion(establecimiento.getEstDireccion());
            establecimientoNuevo.setSiiUbicacion1(conversionVoEntidad.convertir(establecimiento.getUbicacionVo()));
            establecimientoNuevo.setEstNombre(establecimiento.getEstNombre());
            establecimientoDAO.insertarSiiEstablecimiento(establecimientoNuevo);
        } else if (tipoNovedad.equals(TIPO_NOVEDAD_ADICION_ELEMENTOS)) {


        }


        resultado = "exito";
        return resultado;
    }

    public SiiSolicitudAutoriza insertarSolicitudAutorizacion(SolicitudAutorizaVO solicitud) throws ExcepcionDAO {
        SiiSolicitudAutoriza miSolicitud = conversionVoEntidad.convertir(solicitud);
        SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(ESTADO_SOLICITUD_REVISADO);
        miSolicitud.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
        SiiSolicitudAutoriza resultado = solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(miSolicitud);
        return resultado;
    }

    public List<NovedadVO> buscarNovedadesPorIdContrato(Long idContrato) throws ExcepcionDAO {
        List<SiiNovedad> novedades = new ArrayList<SiiNovedad>();
        List<NovedadVO> novedadesVo = new ArrayList<NovedadVO>();
        novedades = novedadDAO.buscarNovedadesPorIdContrato(idContrato, false);
        for (SiiNovedad novedad : novedades) {
            novedadesVo.add(new NovedadVO(novedad));
        }
        return novedadesVo;
    }

    public BigDecimal valorInicialContrato(Long idContrato) throws ExcepcionDAO {
        return novedadDAO.valorInicialContrato(idContrato);
    }

    public BigDecimal valorOtroSi(Long idOtroSi) throws ExcepcionDAO {
        return novedadDAO.valorOtroSi(idOtroSi);
    }

    public SiiContrato insertarSiiContrato(Date pFechaInicio, Date pFechaFin, long pEstado, SiiOperador pOperador) throws ExcepcionDAO {
        SiiContrato siiContrato = new SiiContrato();
        siiContrato.setConFechaFin(pFechaFin);
        siiContrato.setConFechaIni(pFechaInicio);
        SiiEstadoContrato estadoNuevoContrato = estadoContratoDao.buscarEstadoContratoPorId(pEstado);
        siiContrato.setSiiEstadoContrato(estadoNuevoContrato);
        siiContrato.setSiiOperador(pOperador);
        SiiContrato resultadoSiiContrato = contratoDAO.insertarSiiContrato(siiContrato);
        return resultadoSiiContrato;
    }

    public SiiNovedad insertarSiiNovedad(Date pFecha, SiiContrato contrato, Long tipoNovedad, SiiSolicitudAutoriza solicitud) throws ExcepcionDAO {
        SiiNovedad novedad = new SiiNovedad();
        novedad.setNovFecha(pFecha);
        novedad.setSiiContrato(contrato);
        SiiTipoNovedad siiTipoNovedadSolConNuevo = tipoNovedadDao.buscarPorCodigo(tipoNovedad);
        novedad.setSiiTipoNovedad(siiTipoNovedadSolConNuevo);
        novedad.setSiiSolicitudAutoriza(solicitud);
        SiiNovedad resultadoSiiNovedad = novedadDAO.insertarSiiNovedad(novedad);
        return resultadoSiiNovedad;

    }

    public SiiMet insertarSiiMet(MetVO unaMet, SiiMarca marca) throws ExcepcionDAO {
        SiiMet siiMetNuevoContrato = new SiiMet();
        siiMetNuevoContrato.setMetUid(unaMet.getMetUid());
        siiMetNuevoContrato.setMetNuid(unaMet.getMetNuid());
        siiMetNuevoContrato.setMetSerial(unaMet.getMetSerial());
        siiMetNuevoContrato.setMetModelo(unaMet.getMetModelo());
        siiMetNuevoContrato.setSiiMarca(marca);
        siiMetNuevoContrato.setMetFechaFab(unaMet.getMetFechaFab());
        siiMetNuevoContrato.setMetHomologado(unaMet.getMetHomologado());
        siiMetNuevoContrato.setMetMarcaAnterior(unaMet.getMetMarcaAnterior());
        siiMetNuevoContrato.setMetOnline(unaMet.getMetOnline());
        SiiMet resultadoSiiMet = metDAO.insertarSiiMet(siiMetNuevoContrato);
        return resultadoSiiMet;

    }

    public SiiMarca insertarSiiMarca(MarcaVO marcaVo) throws ExcepcionDAO {
        SiiMarca marcaNuevoContrato = new SiiMarca();
        marcaNuevoContrato.setMarNombre(marcaVo.getMarNombre());
        SiiMarca resultadoSiiMarca = marcaDAO.insertarSiiMarca(marcaNuevoContrato);
        return resultadoSiiMarca;
    }

    public SiiInventario insertarSiiInventario(Date fechaIniLiq, Date fechaFinLiq, Date fechaIniOfi, Date fechaFinOfi, SiiEstablecimiento establecimiento, SiiInstrumento instrumento,
                                               SiiNovedad novedad, SiiTipoApuesta tipoApuesta, Integer numeroSillas) throws ExcepcionDAO {
        SiiInventario siiInventario = new SiiInventario();
        siiInventario.setInvEstado("PA");
        siiInventario.setInvFechaFinLiq(fechaFinLiq);
        siiInventario.setInvFechaFinOfi(fechaFinOfi);
        siiInventario.setInvFechaIniLiq(fechaIniLiq);
        siiInventario.setInvFechaIniOfi(fechaIniOfi);
        siiInventario.setSiiEstablecimiento(establecimiento);
        siiInventario.setSiiInstrumento(instrumento);
        siiInventario.setSiiNovedad(novedad);
        siiInventario.setSiiTipoApuesta(tipoApuesta);

        if (instrumento.getSiiTipoInstrumento().getTinCodigo().equals(TIPO_INSTRUMENTO_BINGO)) {
            siiInventario.setInvSillas(numeroSillas);
        }
        SiiInventario resultadoSiiInventario = inventarioDAO.insertarSiiInventario(siiInventario);
        return resultadoSiiInventario;
    }

    public SiiPersona actualizarSiiPersona(SiiPersona personaOrigen, PersonaVO personaDestino) throws ExcepcionDAO {
        if (personaDestino.getPerPrimerNombre() != null && !personaDestino.getPerPrimerNombre().equals("")) {
            personaOrigen.setPerPrimerNombre(personaDestino.getPerPrimerNombre());
        }
        if (personaDestino.getPerSegundoNombre() != null && !personaDestino.getPerSegundoNombre().equals("")) {
            personaOrigen.setPerSegundoNombre(personaDestino.getPerSegundoNombre());
        }
        if (personaDestino.getPerPrimerApellido() != null && !personaDestino.getPerPrimerApellido().equals("")) {
            personaOrigen.setPerPrimerApellido(personaDestino.getPerPrimerApellido());
        }
        if (personaDestino.getPerSegundoApellido() != null && !personaDestino.getPerSegundoApellido().equals("")) {
            personaOrigen.setPerSegundoApellido(personaDestino.getPerSegundoApellido());
        }
        if (personaDestino.getTipoIdentificacionVo().getTidCodigo() != null && !personaDestino.getTipoIdentificacionVo().getTidCodigo().equals("")) {
            SiiTipoIdentificacion tipoIde = tipoIdentificacionDao.buscarTipoIdentificacionPorId(personaDestino.getTipoIdentificacionVo().getTidCodigo());
            personaOrigen.setSiiTipoIdentificacion1(tipoIde);
        }
        if (personaDestino.getPerNumIdentificacion() != null && !personaDestino.getPerNumIdentificacion().equals("")) {
            personaOrigen.setPerNumIdentificacion(personaDestino.getPerNumIdentificacion());
        }
        if (personaDestino.getPerDireccion() != null && !personaDestino.getPerDireccion().equals("")) {
            personaOrigen.setPerDireccion(personaDestino.getPerDireccion());
        }
        if (personaDestino.getPerTelefono() != null && !personaDestino.getPerTelefono().equals("")) {
            personaOrigen.setPerTelefono(personaDestino.getPerTelefono());
        }
        if (personaDestino.getPerTelefono2() != null && !personaDestino.getPerTelefono2().equals("")) {
            personaOrigen.setPerTelefono2(personaDestino.getPerTelefono2());
        }
        if (personaDestino.getPerEmail() != null && !personaDestino.getPerEmail().equals("")) {
            personaOrigen.setPerEmail(personaDestino.getPerEmail());
        }
        if (personaDestino.getUbicacionVo() != null && !personaDestino.getUbicacionVo().equals("")) {
            SiiUbicacion ubicaRl = ubicacionDAO.buscarUbicacionPorId(personaDestino.getUbicacionVo().getUbiCodigo());
            personaOrigen.setSiiUbicacion1(ubicaRl);
        }
        personaDAO.actualizarPersona(personaOrigen);
        return personaOrigen;
    }

    public SiiDetalleFinanc actualizarDetalleFinan(SiiDetalleFinanc detalleFinancOrg, DetalleFinancVO detalleFinancVo) throws ExcepcionDAO {
        SiiDetalleFinanc resultadoDetalleFinanc = null;
        if (detalleFinancOrg != null && detalleFinancVo != null) {
            if (detalleFinancVo.getDfiActivosTot() != null) {
                detalleFinancOrg.setDfiActivosTot(detalleFinancVo.getDfiActivosTot());
            }
            if (detalleFinancVo.getDfiAdqComprav() != null) {
                detalleFinancOrg.setDfiAdqComprav(detalleFinancVo.getDfiAdqComprav());
            }
            if (detalleFinancVo.getDfiAdqDonac() != null) {
                detalleFinancOrg.setDfiAdqDonac(detalleFinancVo.getDfiAdqDonac());
            }
            if (detalleFinancVo.getDfiAdqNoPoseeBien() != null) {
                detalleFinancOrg.setDfiAdqNoPoseeBien(detalleFinancVo.getDfiAdqNoPoseeBien());
            }
            if (detalleFinancVo.getDfiAdqOtro() != null) {
                detalleFinancOrg.setDfiAdqOtro(detalleFinancVo.getDfiAdqOtro());
            }
            if (detalleFinancVo.getDfiAdqOtroCual() != null) {
                detalleFinancOrg.setDfiAdqOtroCual(detalleFinancVo.getDfiAdqOtroCual());
            }
            if (detalleFinancVo.getDfiCambiosDiv() != null) {
                detalleFinancOrg.setDfiCambiosDiv(detalleFinancVo.getDfiCambiosDiv());
            }
            if (detalleFinancVo.getDfiEgreNoOpe() != null) {
                detalleFinancOrg.setDfiEgreNoOpe(detalleFinancVo.getDfiEgreNoOpe());
            }
            if (detalleFinancVo.getDfiEgresosMens() != null) {
                detalleFinancOrg.setDfiEgresosMens(detalleFinancVo.getDfiEgresosMens());
            }
            if (detalleFinancVo.getDfiExportaciones() != null) {
                detalleFinancOrg.setDfiExportaciones(detalleFinancVo.getDfiExportaciones());
            }
            if (detalleFinancVo.getDfiGiros() != null) {
                detalleFinancOrg.setDfiGiros(detalleFinancVo.getDfiGiros());
            }
            if (detalleFinancVo.getDfiImportaciones() != null) {
                detalleFinancOrg.setDfiImportaciones(detalleFinancVo.getDfiImportaciones());
            }
            if (detalleFinancVo.getDfiIngrNoOper() != null && !detalleFinancVo.getDfiIngrNoOper().equals("")) {
                detalleFinancOrg.setDfiIngrNoOper(detalleFinancVo.getDfiIngrNoOper());
            }
            if (detalleFinancVo.getDfiIngresosMens() != null && !detalleFinancVo.getDfiIngresosMens().equals("")) {
                detalleFinancOrg.setDfiIngresosMens(detalleFinancVo.getDfiIngresosMens());
            }
            if (detalleFinancVo.getDfiInversiones() != null && !detalleFinancVo.getDfiInversiones().equals("")) {
                detalleFinancOrg.setDfiInversiones(detalleFinancVo.getDfiInversiones());
            }
            if (detalleFinancVo.getDfiOperacInt() != null && !detalleFinancVo.getDfiOperacInt().equals("")) {
                detalleFinancOrg.setDfiOperacInt(detalleFinancVo.getDfiOperacInt());
            }
            if (detalleFinancVo.getDfiOrdenesPago() != null && !detalleFinancVo.getDfiOrdenesPago().equals("")) {
                detalleFinancOrg.setDfiOrdenesPago(detalleFinancVo.getDfiOrdenesPago());
            }
            if (detalleFinancVo.getDfiOriCual() != null && !detalleFinancVo.getDfiOriCual().equals("")) {
                detalleFinancOrg.setDfiOriCual(detalleFinancVo.getDfiOriCual());
            }
            if (detalleFinancVo.getDfiOriFonNegocio() != null && !detalleFinancVo.getDfiOriFonNegocio().equals("")) {
                detalleFinancOrg.setDfiOriFonNegocio(detalleFinancVo.getDfiOriFonNegocio());
            }
            if (detalleFinancVo.getDfiOriFonSocios() != null && !detalleFinancVo.getDfiOriFonSocios().equals("")) {
                detalleFinancOrg.setDfiOriFonSocios(detalleFinancVo.getDfiOriFonSocios());
            }
            if (detalleFinancVo.getDfiOriOtro() != null && !detalleFinancVo.getDfiOriOtro().equals("")) {
                detalleFinancOrg.setDfiOriOtro(detalleFinancVo.getDfiOriOtro());
            }
            if (detalleFinancVo.getDfiOtrosIngr() != null && !detalleFinancVo.getDfiOtrosIngr().equals("")) {
                detalleFinancOrg.setDfiOtrosIngr(detalleFinancVo.getDfiOtrosIngr());
            }
            if (detalleFinancVo.getDfiPasivosTot() != null && !detalleFinancVo.getDfiPasivosTot().equals("")) {
                detalleFinancOrg.setDfiPasivosTot(detalleFinancVo.getDfiPasivosTot());
            }
            if (detalleFinancVo.getDfiPatrimonioTot() != null && !detalleFinancVo.getDfiPatrimonioTot().equals("")) {
                detalleFinancOrg.setDfiPatrimonioTot(detalleFinancVo.getDfiPatrimonioTot());
            }
            if (detalleFinancVo.getDfiPrestamosMe() != null && !detalleFinancVo.getDfiPrestamosMe().equals("")) {
                detalleFinancOrg.setDfiPrestamosMe(detalleFinancVo.getDfiPrestamosMe());
            }
            if (detalleFinancVo.getDfiRemesas() != null && !detalleFinancVo.getDfiRemesas().equals("")) {
                detalleFinancOrg.setDfiRemesas(detalleFinancVo.getDfiRemesas());
            }
            if (detalleFinancVo.getDfiTransferencias() != null && !detalleFinancVo.getDfiTransferencias().equals("")) {
                detalleFinancOrg.setDfiTransferencias(detalleFinancVo.getDfiTransferencias());
            }
            resultadoDetalleFinanc = detalleFinancDAO.actualizarSiiDetalleFinanc(detalleFinancOrg);

        }
        return resultadoDetalleFinanc;
    }

    public List<NovedadVO> buscarNovedadPorSolicitudAutotiza(Long sauCodigo) throws ExcepcionDAO {
        List<SiiNovedad> novedades = new ArrayList<SiiNovedad>();
        List<NovedadVO> novedadesVo = new ArrayList<NovedadVO>();
        novedades = novedadDAO.buscarNovedadPorSolicitudAutotiza(sauCodigo);
        for (SiiNovedad novedad : novedades) {
            novedadesVo.add(new NovedadVO(novedad));
        }
        return novedadesVo;
    }

    public List<NovedadVO> buscarNovedadesPorEstadoDeSolicitud(String estadoSolicitud) throws ExcepcionDAO {
        List<SiiNovedad> novedades = new ArrayList<SiiNovedad>();
        List<NovedadVO> novedadesVo = new ArrayList<NovedadVO>();
        novedades = novedadDAO.buscarNovedadesPorEstadoDeSolicitud(estadoSolicitud);
        for (SiiNovedad novedad : novedades) {
            novedadesVo.add(new NovedadVO(novedad));
        }
        return novedadesVo;

    }

    /**
     * Metodo encargado de almacenar en la base de datos todos los elementos de una novedad (Adicion de Elementos)
     * @param solicitudAutorizaWSVO
     * @param movCargueInventarioWSVOs
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String insertarNovedadAdicionElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                                 List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo, Boolean docCargados) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        String resultado = "";

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();

        if (!docCargados) {
            //Validamos que almenos traiga un documento
            boolean hayDocumento = false;
            for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                        hayDocumento = true;
                        break;
                    }
            }

            if (!hayDocumento) {
                throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
            }

            SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
            SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();

            if (expediente == null) {
                //Gestion Documental

                siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                        if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                        throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                      radicadoWSVO.perNumIdentificacion);
                                    }
                                    siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                    if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                        throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                    }
                                    SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                    if (siiTipoDocRadicado == null) {
                                        throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                      siiDocumentoRadicado.getDraCodigo());
                                    }
                                    siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                                    documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                                }
                            }
                        }
                }
                //Convertimos la solicitud de autorizacion WS a Entidad

                //Convertimos a VO
                SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
                solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

                //Convertimos a entidad

                siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

                siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

                //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
                SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
                siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
                //Persistimos en la base de datos la solicitud de autorizacion

                solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
            } else {
                siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);

            }

        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }


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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);


        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);


        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            /*
            * Inventario que vamos a registrar
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
            //SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta + "");


            /*
            * Lleno los datos del inventario
            */

            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                int CantidadSillas = (int) movCargueInventarioWSVO.movCargueInvCantSillas;
                SiiInventario siiInventarioBingoActual =
                    inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                              movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());
                if (siiInventarioBingoActual != null) {
                    SiiInventario siiInventarioBingoPR = copiarInventarioObjetoNuevo(siiInventarioBingoActual);
                    siiInventarioBingoPR.setSiiNovedad(siiNovedad);
                    siiInventarioBingoPR.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                    CantidadSillas = CantidadSillas + siiInventarioBingoPR.getInvSillas();
                    inventarioDAO.insertarSiiInventario(siiInventarioBingoPR);
                }
                siiInventario.setInvSillas(CantidadSillas);
            }

            siiInventario.setSiiEstablecimiento(siiEstablecimiento);
            siiInventario.setSiiInstrumento(siiInstrumento);
            siiInventario.setSiiNovedad(siiNovedad);
            siiInventario.setSiiTipoApuesta(siiTipoApuesta);
            siiInventario.setInvFechaFinLiq(calendarHoraCero.getTime());
            siiInventario.setInvFechaFinOfi(siiContrato.getConFechaFin());
            siiInventario.setInvFechaIniLiq(calendarHoraCero.getTime());
            siiInventario.setInvFechaIniOfi(calendarHoraCero.getTime());
            siiInventario.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

            inventarioDAO.insertarSiiInventario(siiInventario);

        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo encargado de hacer la creacion de un establecimiento con la informacion que llega del web-services
     * @param solicitudAutorizaWSVO
     * @param movCargueInventarioWSVOs
     * @author Giovanni Modifica
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..   siiEstablecimiento.getEstCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String crearLocal(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs, List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo,
                             Boolean docCargados) throws ExcepcionAplicacion, ExcepcionDAO {


        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        String resultado = "";
        Calendar calendar = Calendar.getInstance();

        if (solicitudAutorizaWSVO.numeroSiito == null || solicitudAutorizaWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("El numero siito no puede ser nulo, por favor verifique");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }


        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();

        if (!docCargados) {
            //Validamos que almenos traiga un documento
            boolean hayDocumento = false;
            for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                        hayDocumento = true;
                        break;
                    }
            }

            if (!hayDocumento) {
                throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
            }

            SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
            SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();

            if (expediente == null) {
                //Gestion Documental

                siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                        if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                        throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                      radicadoWSVO.perNumIdentificacion);
                                    }
                                    siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                    if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                        throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                    }
                                    SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                    if (siiTipoDocRadicado == null) {
                                        throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                      siiDocumentoRadicado.getDraCodigo());
                                    }
                                    siiDocumentoRadicado.setSiiTipoDocRadicado(siiTipoDocRadicado);

                                    documentoRadicadoDAO.insertarSiiDocumentoRadicado(siiDocumentoRadicado);
                                }
                            }
                        }
                }
                // Convertimos la solicitud de autorizacion WS a Entidad
                //Convertimos a VO
                SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
                solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

                //Convertimos a entidad

                siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

                siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

                //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
                SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
                siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
                //Persistimos en la base de datos la solicitud de autorizacion
                solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);

            } else {
                siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
            }
        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }


        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizaWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);

        /*
        * Verificamos que el establecimiento que nos llega tenga todos los campos que son obligatorios y creamos une establecimiento
        */
        SiiEstablecimiento siiEstablecimiento = null;

        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
            siiEstablecimiento = new SiiEstablecimiento();

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
            siiEstablecimiento.setSiiNovedad(siiNovedad);
            establecimientoDAO.insertarSiiEstablecimiento(siiEstablecimiento);
        }

        resultado = siiEstablecimiento.getEstCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo encargado hacer el retiro de la base de datos todos los elementos de una novedad (retiro de Elementos)
     * @param solicitudAutorizaWSVO
     * @param movCargueInventarioWSVOs
     * @Author David Tafur
     * @author Modifica: Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String insertarNovedadRetiroElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo, boolean docCargados) throws ExcepcionAplicacion, ExcepcionDAO {
        Calendar calendar = Calendar.getInstance();
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

        if (siiOperadorPersona.getPerCodigo() == null || siiOperadorPersona.getPerCodigo() < 0) {
            throw new ExcepcionAplicacion("No se encontro ningun operador por ese numero de nit por favor verifique");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        SiiOperador siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());


        if (!docCargados) {
            //Validamos que almenos traiga un documento
            boolean hayDocumento = false;
            for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                        hayDocumento = true;
                        break;
                    }
            }


            if (!hayDocumento) {
                throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
            }


            SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
            SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();

            if (expediente == null) {
                //Gestion Documental
                siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                        if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                        throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                      radicadoWSVO.perNumIdentificacion);
                                    }
                                    siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                    if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                        throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                    }
                                    SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                    if (siiTipoDocRadicado == null) {
                                        throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                      siiDocumentoRadicado.getDraCodigo());
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
                solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

                //Convertimos a entidad
                siiSolicitudAutoriza = new SiiSolicitudAutoriza();
                siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

                siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

                //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
                SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
                siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
                //Persistimos en la base de datos la solicitud de autorizacion

                solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
            } else {
                siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
            }


        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }

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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());

        if (siiContrato == null || siiContrato.getConCodigo() < 1) {
            throw new ExcepcionAplicacion("No se encontro un contrato registrado por el numero de contrato, por favor verifique.");
        }

        siiNovedad.setSiiContrato(siiContrato);


        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);


        /*
         * Consulta inventarios para ese contrato para cuando no sea mets.
         */
        List<SiiInventario> listaInventarioMesasDeContrato = new ArrayList<SiiInventario>();
        listaInventarioMesasDeContrato = inventarioDAO.buscarInventarioMesaPorContrato(siiContrato.getConCodigo());


        /*
        *DATOS DE LA TABLA INTERMEDIA
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            /*
            * Inventario que vamos a registrar
            */
            SiiInventario siiInventario = new SiiInventario();


            //Tipo de instrumento
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));


            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * ESTABLECIMIENTO
            * Buscamos el establecimiento para ese registro de inventario
            * _/_/_/_/_/_/_/_/_/_/_/_/*/
            //SiiEstablecimiento siiEstablecimiento = null;
            ////siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
            //if (siiEstablecimiento == null) {
            //    throw new ExcepcionAplicacion("No se encontro el local " + movCargueInventarioWSVO.movCargueInvCodLocal + " asociado el operador con Nit " + movCargueInventarioWSVO.movCargueInvNit);
            //}

            /*
            * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
             _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
            Una vez localizado el establecimiento
            vamor a buscar el inventario con los
            datos que ya tenemos
            _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
            _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
            */
            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId()) {
                siiInventario =
                    inventarioDAO.buscarInventarioXSerialXMarcaXLocalContratoYNUC(movCargueInventarioWSVO.movCargueInvSerialInstRet, Long.parseLong(movCargueInventarioWSVO.movCargueInvIndAmpDis),
                                                                                  movCargueInventarioWSVO.movCargueInvCont, movCargueInventarioWSVO.movCargueInvIucRet,
                                                                                  movCargueInventarioWSVO.movCargueInvCodLocal);

                //inventarioDAO.buscarInventarioXEstablecimientoYDatosMet(siiEstablecimiento.getEstCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstRet,movCargueInventarioWSVO.movCargueInvIucRet, movCargueInventarioWSVO.movCargueInvCont);
            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                siiInventario =
                    inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                              movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());
                if (movCargueInventarioWSVO.movCargueInvCantSillas < siiInventario.getInvSillas()) {
                    SiiInventario siiInventarioBingoPA = copiarInventarioObjetoNuevo(siiInventario);
                    siiInventarioBingoPA.setSiiNovedad(siiNovedad);
                    siiInventarioBingoPA.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
                    int CantidadSillas = siiInventario.getInvSillas() - (int) movCargueInventarioWSVO.movCargueInvCantSillas;
                    siiInventarioBingoPA.setInvSillas(CantidadSillas);
                    inventarioDAO.insertarSiiInventario(siiInventarioBingoPA);
                }

            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {

                //Una vez que tengo todos los inventarios entonces recorro la lista para localizar el inventario que
                //cumpla con las condiciones de elemento y tipo de elemento para proceder a retirarlo

                for (SiiInventario siiInventarioItem : listaInventarioMesasDeContrato) {
                    if (siiInventarioItem.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "") &&
                        siiInventarioItem.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal) &&
                        siiInventarioItem.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc) &&
                        siiInventarioItem.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {
                        siiInventario = siiInventarioItem;
                        listaInventarioMesasDeContrato.remove(siiInventarioItem);
                        break;
                    }
                }
            }

            if (siiInventario == null || siiInventario.getInvCodigo() == null) {
                throw new ExcepcionAplicacion("No se encontro inventario que coicida con los datos suministrados");
            }
            /*  Codigo anterior FIX - INCOHERENTE
                    //Consultamos el instrumento de ese inventario y el tipo de instrumento
                    SiiInstrumento siiInstrumento = new SiiInstrumento();
                    siiInstrumento =
                        instrumentoDAO.buscarPorCodigoInstrumento(siiInventarioItem.getSiiInstrumento().getInsCodigo());
                    //Tipo instrumento
                    SiiTipoInstrumento siiTipoInstrumentoItem = new SiiTipoInstrumento();
                    siiTipoInstrumento =
                        tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(siiInstrumento.getInsCodigo());
                    if (siiTipoInstrumento != null) {
                        if (siiTipoInstrumento.getTinCodigo() == siiTipoInstrumentoItem.getTinCodigo()) {
                            siiInventario = siiInventarioItem;
                            break;
                        }
                    }*/


            //siiEstablecimiento = siiInventario.getSiiEstablecimiento();


            //SiiInstrumento siiInstrumento = null;
            //if (siiInventario != null && siiInventario.getSiiInstrumento() != null) {
            //    siiInstrumento = instrumentoDAO.buscarPorCodigoInstrumento(siiInventario.getSiiInstrumento().getInsCodigo());
            //}

            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * TIPO APUESTA
            * _/_/_/_/_/_/_/_/_/_/_/_/*/
            //if (siiInstrumento != null) {
            //SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);


            SiiInventario siiInventarioNuevo = new SiiInventario();
            siiInventarioNuevo = copiarInventarioObjetoNuevo(siiInventario);
            siiInventarioNuevo.setInvPg(siiInventario.getInvPg());
            //siiInventarioNuevo.setInvSillas(siiInventario.getInvSillas());
            siiInventarioNuevo.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
            //siiInventarioNuevo.setInvFechaFinLiq(calendarHoraCero.getTime());
            //siiInventarioNuevo.setInvFechaFinOfi(siiContrato.getConFechaFin());
            //siiInventarioNuevo.setInvFechaIniLiq(calendarHoraCero.getTime());
            //siiInventarioNuevo.setInvFechaIniOfi(calendarHoraCero.getTime());
            //siiInventarioNuevo.setSiiEstablecimiento(siiEstablecimiento);
            //siiInventarioNuevo.setSiiInstrumento(siiInstrumento);
            siiInventarioNuevo.setSiiNovedad(siiNovedad);
            //siiInventarioNuevo.setSiiTipoApuesta(siiTipoApuesta);
            inventarioDAO.insertarSiiInventario(siiInventarioNuevo);
            //}
        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo encargado de almacenar en la base de datos una novedad de traslado (Traslado de Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @author Modifica: Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String trasladoElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                   List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calendar = Calendar.getInstance();
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

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();

        if (expediente == null) {
            //Gestion Documental
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                    throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                  radicadoWSVO.perNumIdentificacion);
                                }
                                siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                    throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                }
                                SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                if (siiTipoDocRadicado == null) {
                                    throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                  siiDocumentoRadicado.getDraCodigo());
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

            solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

            //Convertimos a entidad
            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

            //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
            //Persistimos en la base de datos la solicitud de autorizacion

            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }


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
        siiNovedad.setNovFecha(calendar.getTime());

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
                        inventarioDAO.buscarInventarioXUIDYContrato(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), movCargueInventarioWSVO.movCargueInvCont,
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
                    /*siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                    inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);*/



                    /*
                     * Creamos una replica del registro y remplazamos las fechas y el estado que seria pendiente de retiro
                     */
                    SiiInventario siiInvNuevoRegistro = new SiiInventario();
                    siiInvNuevoRegistro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    //siiInvNuevoRegistro.setInvFechaFinLiq(calendar.getTime());
                    //siiInvNuevoRegistro.setInvFechaIniLiq(calendar.getTime());
                    //siiInvNuevoRegistro.setInvFechaFinOfi(calendar.getTime());
                    //siiInvNuevoRegistro.setInvFechaIniOfi(calendar.getTime());
                    siiInvNuevoRegistro.setSiiNovedad(siiNovedad);
                    siiInvNuevoRegistro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                    inventarioDAO.insertarSiiInventario(siiInvNuevoRegistro);

                    /*
                     * Registramos otro inventario con el codigo del local de destino y el estado pendiente de activar
                    */
                    SiiInventario siiInvNuevoPendActivar = new SiiInventario();
                    siiInvNuevoPendActivar = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                    siiInvNuevoPendActivar.setInvFechaFinLiq(calendar.getTime());
                    siiInvNuevoPendActivar.setInvFechaIniLiq(calendar.getTime());
                    siiInvNuevoPendActivar.setInvFechaFinOfi(calendar.getTime());
                    siiInvNuevoPendActivar.setInvFechaIniOfi(calendar.getTime());
                    siiInvNuevoPendActivar.setSiiNovedad(siiNovedad);
                    /*
                     * Nuevo establecimiento donde se va a trasladar (Ya debe existir)
                     */
                    siiInvNuevoPendActivar.setSiiEstablecimiento(siiEstablecimientoDestino);
                    siiInvNuevoPendActivar.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
                    inventarioDAO.insertarSiiInventario(siiInvNuevoPendActivar);
                } else {
                    resultado = "-1 No se encuentra la maquina con serial " + movCargueInventarioWSVO.movCargueInvCodMarca + " en el inventario con los criterios mencionados.";
                    throw new ExcepcionAplicacion("-1 No se encuentra la maquina con serial " + movCargueInventarioWSVO.movCargueInvCodMarca + " en el inventario con los criterios mencionados.");
                }


                //ACDV
            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.ACDV.getId()) {

                /*
                * Si el registro del inventario de la tabla intermedia trae el codigo del uid que es unico entonces podemos
                * consultarlo por este criterio, de lo contrario debemos consultar por el serial el operador y la marca
                */
                SiiInventario siiInventarioPorTrasladar = new SiiInventario();

                siiInventarioPorTrasladar =
                    inventarioDAO.buscarInventarioACDVXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                      movCargueInventarioWSVO.movCargueInvCodMarca, movCargueInventarioWSVO.movCargueInvCont,
                                                                                      movCargueInventarioWSVO.movCargueInvCodLocal);

                /*
                * Una vez tenemos el inventario entonces procedemos a cambiarle el estado a inactivo
                */
                //siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());

                /*
                * Lo registramos con el cambio
                */
                //inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);

                /*
                * Creamos una replica del registro y remplazamos las fechas y el estado que seria pendiente de retiro
                */
                SiiInventario siiInvNuevoRegistro = new SiiInventario();
                siiInvNuevoRegistro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                //siiInvNuevoRegistro.setInvFechaFinLiq(calendar.getTime());
                //siiInvNuevoRegistro.setInvFechaIniLiq(calendar.getTime());
                //siiInvNuevoRegistro.setInvFechaFinOfi(calendar.getTime());
                //siiInvNuevoRegistro.setInvFechaIniOfi(calendar.getTime());
                siiInvNuevoRegistro.setSiiNovedad(siiNovedad);
                siiInvNuevoRegistro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());

                inventarioDAO.insertarSiiInventario(siiInvNuevoRegistro);

                /*
                 * Registramos otro inventario con el codigo del local de destino y el estado pendiente de activar
                */
                SiiInventario siiInvNuevoPendActivar = new SiiInventario();
                siiInvNuevoPendActivar = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                siiInvNuevoPendActivar.setInvFechaFinLiq(calendar.getTime());
                siiInvNuevoPendActivar.setInvFechaIniLiq(calendar.getTime());
                siiInvNuevoPendActivar.setInvFechaFinOfi(calendar.getTime());
                siiInvNuevoPendActivar.setInvFechaIniOfi(calendar.getTime());

                /*
                 * Nuevo establecimiento donde se va a trasladar (Ya debe existir)
                 */
                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                siiInvNuevoPendActivar.setSiiEstablecimiento(siiEstablecimiento);
                siiInvNuevoPendActivar.setSiiNovedad(siiNovedad);
                siiInvNuevoPendActivar.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

                inventarioDAO.insertarSiiInventario(siiInvNuevoPendActivar);
            } else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {

                /*
                * Si el registro del inventario de la tabla intermedia trae el codigo del uid que es unico entonces podemos
                * consultarlo por este criterio, de lo contrario debemos consultar por el serial el operador y la marca
                */
                SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                for (SiiInventario siiInventarioPorTrasladar : siiInventarioMesasContrato) {

                    if (siiInventarioPorTrasladar.getSiiEstablecimiento().getEstCodInterno().equalsIgnoreCase(movCargueInventarioWSVO.movCargueInvCodLocal)) {


                        //Creamos una replica del registro y remplazamos las fechas y el estado que seria pendiente de retiro

                        SiiInventario siiInvNuevoRegistro = new SiiInventario();
                        siiInvNuevoRegistro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                        //  siiInvNuevoRegistro.setInvFechaFinLiq(calDiaAnterior.getTime());
                        siiInvNuevoRegistro.setSiiNovedad(siiNovedad);
                        siiInvNuevoRegistro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                        inventarioDAO.insertarSiiInventario(siiInvNuevoRegistro);


                        // Registramos otro inventario con el codigo del local de destino y el estado pendiente de activar

                        SiiInventario siiInvNuevoPendActivar = new SiiInventario();
                        siiInvNuevoPendActivar = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                        siiInvNuevoPendActivar.setInvFechaFinLiq(calendarHoraCero.getTime());
                        siiInvNuevoPendActivar.setInvFechaIniLiq(calendarHoraCero.getTime());
                        siiInvNuevoPendActivar.setInvFechaFinOfi(calendarHoraCero.getTime());
                        siiInvNuevoPendActivar.setInvFechaIniOfi(calendarHoraCero.getTime());

                        /*Nuevo establecimiento donde se va a trasladar (Ya debe existir)*/
                        siiInvNuevoPendActivar.setSiiNovedad(siiNovedad);
                        siiInvNuevoPendActivar.setSiiEstablecimiento(siiEstablecimientoDestino);
                        siiInvNuevoPendActivar.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

                        inventarioDAO.insertarSiiInventario(siiInvNuevoPendActivar);
                        siiInventarioMesasContrato.remove(siiInventarioPorTrasladar);
                        break;
                    }
                }
            } //BINGO
            else if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {

                /*
                * Para traslado de sillas
                */
                SiiInventario siiInventarioPorTrasladar = new SiiInventario();

                //siiInventarioPorTrasladar = inventarioDAO.buscarUltimoInstrumentoPorTipoElementoYLocal(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst),movCargueInventarioWSVO.movCargueInvCodLocal);
                siiInventarioPorTrasladar =
                    inventarioDAO.buscarUltimoInstrumentoPorTipoElementoApuestaYLocalPorOperador(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst),
                                                                                                 movCargueInventarioWSVO.movCargueInvCodApuesta, movCargueInventarioWSVO.movCargueInvCodLocal,
                                                                                                 siiContrato.getConCodigo());

                /* siiInventarioPorTrasladar.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                //Actualizamos el registro
                inventarioDAO.actualizarSiiInventario(siiInventarioPorTrasladar);*/

                /*
                 * Copiamos el registro y insertamos las nuevas fechas y el nuevo estado
                 */
                SiiInventario siiInventarioPendRetiro = new SiiInventario();
                siiInventarioPendRetiro = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);

                //siiInventarioPendRetiro.setInvFechaFinLiq(calendar.getTime());
                //siiInventarioPendRetiro.setInvFechaIniLiq(calendar.getTime());
                //siiInventarioPendRetiro.setInvFechaFinOfi(solicitudAutorizaWSVO.fecha);
                //siiInventarioPendRetiro.setInvFechaIniOfi(solicitudAutorizaWSVO.fecha);
                siiInventarioPendRetiro.setSiiNovedad(siiNovedad);
                siiInventarioPendRetiro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());

                inventarioDAO.insertarSiiInventario(siiInventarioPendRetiro);

                /*
                 * Verificamos si el numero de sillas del
                 * ultimo registro en el inventario es mayor al numero de siullas en la solicitud
                 */

                //Cantidad de sillas
                Long cantidadSillasFinal = siiInventarioPorTrasladar.getInvSillas() - movCargueInventarioWSVO.movCargueInvCantSillas;

                if (cantidadSillasFinal.intValue() > 0) {

                    SiiInventario siiInvCantSillasMayor = new SiiInventario();
                    siiInvCantSillasMayor = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    siiInvCantSillasMayor.setInvSillas(cantidadSillasFinal.intValue());
                    siiInvCantSillasMayor.setInvFechaFinLiq(calendarHoraCero.getTime());
                    siiInvCantSillasMayor.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvCantSillasMayor.setInvFechaFinOfi(calendarHoraCero.getTime());
                    siiInvCantSillasMayor.setInvFechaIniOfi(calendarHoraCero.getTime());
                    siiInvCantSillasMayor.setSiiNovedad(siiNovedad);
                    siiInvCantSillasMayor.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
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


                    /*
                    * Copiamos el registro para cambiarle las fecha y el estado
                    */
                    SiiInventario siiInventPendienteRetiro = new SiiInventario();
                    siiInventPendienteRetiro = copiarInventarioObjetoNuevo(siiInventarioLocalDest);
                    siiInventPendienteRetiro.setSiiNovedad(siiNovedad);
                    siiInventPendienteRetiro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                    inventarioDAO.insertarSiiInventario(siiInventPendienteRetiro);

                    /*
                    * Sumamos la cantidad de sillas
                    */

                    SiiInventario siiInvSumaSillas = new SiiInventario();
                    siiInvSumaSillas = copiarInventarioObjetoNuevo(siiInventarioLocalDest);

                    //Cantidad de sillas
                    Long cantidadSillasFinalDestino = siiInventarioLocalDest.getInvSillas() + movCargueInventarioWSVO.movCargueInvCantSillas;

                    siiInvSumaSillas.setInvSillas(cantidadSillasFinalDestino.intValue());
                    siiInvSumaSillas.setInvFechaFinLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaFinOfi(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaIniOfi(calendarHoraCero.getTime());
                    siiInvSumaSillas.setSiiNovedad(siiNovedad);
                    siiInvSumaSillas.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
                    inventarioDAO.insertarSiiInventario(siiInvSumaSillas);
                } else {
                    SiiInventario siiInvSumaSillas = new SiiInventario();
                    siiInvSumaSillas = copiarInventarioObjetoNuevo(siiInventarioPorTrasladar);
                    siiInvSumaSillas.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
                    siiInvSumaSillas.setInvFechaFinLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaFinOfi(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvFechaIniOfi(calendarHoraCero.getTime());
                    siiInvSumaSillas.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
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
     *Metodo encargado de hacer un cambio de apuesta sobre algun instrumento en el inventario
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @author Modifica: Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..   siiEstablecimiento.getEstCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String cambioApuesta(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        if (solicitudAutorizaWSVO.numeroSiito == null || solicitudAutorizaWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("El numero siito no puede ser nulo, por favor verifique");
        }

        String resultado = "";
        Calendar calendar = Calendar.getInstance();

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizaWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (solicitudAutorizaWSVO.numeroSiito == null || solicitudAutorizaWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("El numero siito no puede ser nulo, por favor verifique");
        }

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();


        if (expediente == null) {
            //Gestion Documental
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                    throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                  radicadoWSVO.perNumIdentificacion);
                                }
                                siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                    throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                }
                                SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                if (siiTipoDocRadicado == null) {
                                    throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                  siiDocumentoRadicado.getDraCodigo());
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
            solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

            //Convertimos a entidad
            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

            //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);

            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }


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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);

        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder
        * a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */

        /*
         * Si no es una met entonces traigo todos los inventarios para ese contrato
         */
        List<SiiInventario> listaInventariosDeContrato = new ArrayList<SiiInventario>();
        listaInventariosDeContrato = inventarioDAO.buscarInventarioPorNumContrato(siiContrato.getConCodigo());

        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {


            //Tipo de instrumento
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));


            SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
            siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

            if (siiEstablecimiento == null) {
                throw new ExcepcionAplicacion("No se encontro Establecimiento con codigo de operador " + siiOperador.getOpeCodigo() + " y codigo interno de local " +
                                              movCargueInventarioWSVO.movCargueInvCodLocal);
            }
            /*
            * Consultamos en el inventario el ultimo registro que cumple con los criterios de entra de la solicitud
             * de autorizacion
             */
            SiiInventario siiInventario = new SiiInventario();

            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MET.getId()) {

                siiInventario =
                    //inventarioDAO.buscarInventarioXEstablecimientoYDatosMet(siiEstablecimiento.getEstCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvNuidAd);//linea vieja
                    inventarioDAO.buscarInventarioXEstablecimientoYDatosMet(siiEstablecimiento.getEstCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                            movCargueInventarioWSVO.movCargueInvIucAd.toString(), movCargueInventarioWSVO.movCargueInvCont); //linea nueva
                if (siiInventario == null) {
                    throw new ExcepcionAplicacion("No se encontro inventario con los datos condEst=" + siiEstablecimiento.getEstCodigo() + ",Serial=" +
                                                  movCargueInventarioWSVO.movCargueInvSerialInstAd + ",NUC=" + movCargueInventarioWSVO.movCargueInvIucAd.toString() + ",NumeroContrato=" +
                                                  movCargueInventarioWSVO.movCargueInvCont);
                }

            }
            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                siiInventario =
                    inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                              movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());


            }
            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {


                //Una vez que tengo todos los inventarios entonces recorro la lista para localizar el inventario que
                //cumpla con las condiciones de elemento y tipo de elemento para proceder a retirarlo

                for (SiiInventario siiInventarioItem : listaInventariosDeContrato) {
                    if (siiInventarioItem.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "") &&
                        siiInventarioItem.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal) &&
                        siiInventarioItem.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc) &&
                        siiInventarioItem.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {
                        siiInventario = siiInventarioItem;
                        listaInventariosDeContrato.remove(siiInventarioItem);
                        break;

                    }

                }
            }

            if (siiInventario == null) {
                throw new ExcepcionAplicacion("No se encontro inventario que coicida con los datos suministrados");
            }


            /*
            * Inactivamos el anterior registro
            */

            //siiInventario.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
            //inventarioDAO.actualizarSiiInventario(siiInventario);

            /*
            * Duplicamos el registro y le ingresamos el nuevo tipo de apuesta con el estado PA
            */
            SiiInventario siiInventarioPendRetiro = new SiiInventario();
            siiInventarioPendRetiro = copiarInventarioObjetoNuevo(siiInventario);
            //siiInventarioPendRetiro.setInvCodigo(null);
            siiInventarioPendRetiro.setSiiNovedad(siiNovedad);
            siiInventarioPendRetiro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
            inventarioDAO.insertarSiiInventario(siiInventarioPendRetiro);

            /*
            * Duplicamos el registro y le ingresamos el nuevo tipo de apuesta con el estado PA
            */
            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * TIPO APUESTA
            * _/_/_/_/_/_/_/_/_/_/_/_/*/


            //SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuestaNew);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuestaNew + "");
            SiiInventario siiInventarioPendAprobar = new SiiInventario();
            siiInventarioPendAprobar = copiarInventarioObjetoNuevo(siiInventario);
            //siiInventarioPendAprobar.setInvCodigo(null);
            siiInventarioPendAprobar.setSiiNovedad(siiNovedad);
            siiInventarioPendAprobar.setSiiTipoApuesta(siiTipoApuesta);
            siiInventarioPendAprobar.setInvFechaFinLiq(calendarHoraCero.getTime());
            siiInventarioPendAprobar.setInvFechaFinOfi(siiContrato.getConFechaFin());
            siiInventarioPendAprobar.setInvFechaIniLiq(calendarHoraCero.getTime());
            siiInventarioPendAprobar.setInvFechaIniOfi(calendarHoraCero.getTime());

            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                if (siiInventario.getInvSillas() > movCargueInventarioWSVO.movCargueInvCantSillas) {
                    int CantidadSillas = siiInventario.getInvSillas() - (int) movCargueInventarioWSVO.movCargueInvCantSillas;
                    SiiInventario siiInventarioPendienteAprobarAnterior = copiarInventarioObjetoNuevo(siiInventario);
                    siiInventarioPendienteAprobarAnterior.setSiiNovedad(siiNovedad);
                    siiInventarioPendienteAprobarAnterior.setInvSillas(CantidadSillas);
                    siiInventarioPendienteAprobarAnterior.setInvFechaFinLiq(calendarHoraCero.getTime());
                    siiInventarioPendienteAprobarAnterior.setInvFechaFinOfi(siiContrato.getConFechaFin());
                    siiInventarioPendienteAprobarAnterior.setInvFechaIniLiq(calendarHoraCero.getTime());
                    siiInventarioPendienteAprobarAnterior.setInvFechaIniOfi(calendarHoraCero.getTime());

                    siiInventarioPendienteAprobarAnterior.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
                    inventarioDAO.insertarSiiInventario(siiInventarioPendienteAprobarAnterior);

                }

                SiiInventario InventarioNewApuesta =
                    inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                              movCargueInventarioWSVO.movCargueInvCodApuestaNew, siiContrato.getConCodigo());
                int cantidadNewInvetario = (int) movCargueInventarioWSVO.movCargueInvCantSillas;
                if (InventarioNewApuesta != null) {
                    cantidadNewInvetario = cantidadNewInvetario + InventarioNewApuesta.getInvSillas();
                    SiiInventario InventarioNewApuestaPR = copiarInventarioObjetoNuevo(InventarioNewApuesta);
                    InventarioNewApuestaPR.setSiiNovedad(siiNovedad);
                    InventarioNewApuestaPR.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                    inventarioDAO.insertarSiiInventario(InventarioNewApuestaPR);
                }
                siiInventarioPendAprobar.setInvSillas(cantidadNewInvetario);
            }

            siiInventarioPendAprobar.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());
            inventarioDAO.insertarSiiInventario(siiInventarioPendAprobar);
        }

        resultado = " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo encargado de almacenar en la base de datos todos los elementos de una novedad (Elementos en bodega)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String elementosEnBodega(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                    List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        String resultado = "";

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();

        if (expediente == null) {
            //Gestion Documental
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                    throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                  radicadoWSVO.perNumIdentificacion);
                                }
                                siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                    throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                }
                                SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                if (siiTipoDocRadicado == null) {
                                    throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                  siiDocumentoRadicado.getDraCodigo());
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
            solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

            //Convertimos a entidad

            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

            //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
            //Persistimos en la base de datos la solicitud de autorizacion

            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);
        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }


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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);


        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);


        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            /*
            * Inventario que vamos a registrar
            */
            SiiInventario siiInventario = new SiiInventario();


            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * ESTABLECIMIENTO
            * Buscamos el establecimiento para ese registro de inventario
            * _/_/_/_/_/_/_/_/_/_/_/_/*/

            SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
            siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * INSTRUMENTO
            * Tipo intrumento
            * _/_/_/_/_/_/_/_/_/_/_/_/*/

            SiiInstrumento siiInstrumento = new SiiInstrumento();
            //Tipo de instrumento
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));

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
            }
            siiInstrumento.setSiiTipoInstrumento(siiTipoInstrumento);
            siiInstrumento.setTapCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
            siiInstrumento.setInsFechaRegistro(calendar.getTime());
            siiInstrumento.setSiiMet(siiMet);
            siiInstrumento.setSiiOperador1(siiOperador);
            siiInstrumento.setInsActivo("S");
            siiInstrumento.setInsFechaRegistro(calendar.getTime());
            siiInstrumento.setInsFechaModific(calendar.getTime());


            //Persisto el instrumento
            instrumentoDAO.insertarSiiInstrumento(siiInstrumento);

            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * TIPO APUESTA
            * _/_/_/_/_/_/_/_/_/_/_/_/*/
            //SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta + "");

            /*
            * Lleno los datos del inventario
            */

            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                siiInventario.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
            }


            siiInventario.setSiiEstablecimiento(siiEstablecimiento);
            siiInventario.setSiiInstrumento(siiInstrumento);
            siiInventario.setSiiNovedad(siiNovedad);
            siiInventario.setSiiTipoApuesta(siiTipoApuesta);
            siiInventario.setInvFechaFinLiq(calendarHoraCero.getTime());
            siiInventario.setInvFechaFinOfi(siiContrato.getConFechaFin());
            siiInventario.setInvFechaIniLiq(calendarHoraCero.getTime());
            siiInventario.setInvFechaIniOfi(calendarHoraCero.getTime());
            siiInventario.setInvEstado(EnumEstadoInventario.ELEMENTO_EN_BODEGA.getId());

            inventarioDAO.insertarSiiInventario(siiInventario);

        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }

    /**
     *Metodo encargado de almacenar en la base de datos todos los datos ACDV
     * @param solicitudAutorizaWSVO
     * @author Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String creacionLicenciaACDV(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                       List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion, ExcepcionDAO {

        Calendar calendar = Calendar.getInstance();
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        String resultado = "";

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }

        SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();

        if (expediente == null) {
            //Gestion Documental
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                    throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                  radicadoWSVO.perNumIdentificacion);
                                }
                                siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                    throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                }
                                SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                if (siiTipoDocRadicado == null) {
                                    throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                  siiDocumentoRadicado.getDraCodigo());
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

            solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

            //Convertimos a entidad

            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

            //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);
            //Persistimos en la base de datos la solicitud de autorizacion

            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);

        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }
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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);

        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            /*
             * Adicion Licencia ACDV
             */
            SiiLicenciaAcdv siiLicenciaAcdv = new SiiLicenciaAcdv();

            //Llenamos los datos de la licencia
            siiLicenciaAcdv.setLacModalidad(Integer.parseInt(String.valueOf(movCargueInventarioWSVOs.get(0).movCargueInvTipNov)));
            siiLicenciaAcdv.setLacNumero(movCargueInventarioWSVO.movCargueInvNumLic);
            siiLicenciaAcdv.setLacNumeroTerm(Integer.valueOf(String.valueOf(movCargueInventarioWSVO.movCargueInvCantTerm)));

            licenciaAcdvDAO.insertarSiiLicenciaAcdv(siiLicenciaAcdv);
        }

        resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }

    /**
     *Metodo encargado de hacer el reemplazo en la base de datos todos los elementos de una novedad (Reemplazo Elementos)
     * @param solicitudAutorizaWSVO
     * @Author David Tafur
     * @author Modifica: Giovanni
     * @return Devuelve una cadena con el mensaje "Proceso Exitoso" de la siguiente forma..  resultado = siiSolicitudAutoriza.getSauCodigo() + " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";
     */
    public String reemplazoElemento(SolicitudAutorizaWSVO solicitudAutorizaWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                    List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionAplicacion, ExcepcionDAO {
        Calendar calendarHoraCero = Calendar.getInstance();
        calendarHoraCero.set(Calendar.HOUR_OF_DAY, 0);
        calendarHoraCero.set(Calendar.MINUTE, 0);
        calendarHoraCero.set(Calendar.SECOND, 0);
        calendarHoraCero.set(Calendar.MILLISECOND, 0);

        if (solicitudAutorizaWSVO == null) {
            throw new ExcepcionAplicacion("La solicitud de atutorizacion no puede ser nula");
        }

        if (solicitudAutorizaWSVO.numeroSiito == null || solicitudAutorizaWSVO.numeroSiito.equals("")) {
            throw new ExcepcionAplicacion("El numero siito no puede ser nulo, por favor verifique");
        }

        String resultado = "";
        Calendar calendar = Calendar.getInstance();

        /*
        * Buscamos el operador
        */

        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizaWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (listaExpedienteRadicadoWsVo == null || listaExpedienteRadicadoWsVo.size() < 1) {
            throw new ExcepcionAplicacion("La solicitud de autorizacion debe tener al menos 1 expediente radicado.");

        }

        //Validamos que almenos traiga un documento
        boolean hayDocumento = false;
        for (ExpedienteRadicadoWSVO expedienteRadicadoWsVo : listaExpedienteRadicadoWsVo) {
            if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {
                    hayDocumento = true;
                    break;
                }
        }

        if (!hayDocumento) {
            throw new ExcepcionAplicacion("El expediente debe tener al menos 1 documento radicado");
        }


        SiiExpedienteDocum expediente = expedienteDocumDAO.buscarExpedienteDocumPorId(solicitudAutorizaWSVO.numeroSiito);
        SiiExpedienteDocum siiExpedienteDocumento = new SiiExpedienteDocum();
        SolicitudAutorizaVO solicitudAutorizaVO = new SolicitudAutorizaVO();
        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();

        if (expediente == null) {
            //Gestion Documental
            siiExpedienteDocumento.setEdoCodigo(solicitudAutorizaWSVO.numeroSiito);
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

                if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo != null)
                    if (expedienteRadicadoWsVo.listaDocumentoRadicadosWsVo.size() > 0) {

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
                                    throw new ExcepcionAplicacion("Al registrar el documento radicado no se encontro una persona con el numero de identificacion: " +
                                                                  radicadoWSVO.perNumIdentificacion);
                                }
                                siiDocumentoRadicado.setSiiPersona(siiPersonaRadicado);

                                if (radicadoWSVO.codigoTipoDocRadicado == null || radicadoWSVO.codigoTipoDocRadicado <= 0) {
                                    throw new ExcepcionAplicacion("Falta el tipo de documento del documento " + siiDocumentoRadicado.getDraCodigo());
                                }
                                SiiTipoDocRadicado siiTipoDocRadicado = tipoDocRadicadoDao.buscarTipoDocRadicadoPorId(radicadoWSVO.codigoTipoDocRadicado);
                                if (siiTipoDocRadicado == null) {
                                    throw new ExcepcionAplicacion("No se encontró el tipo de documento " + radicadoWSVO.codigoTipoDocRadicado + " del documento " +
                                                                  siiDocumentoRadicado.getDraCodigo());
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
            solicitudAutorizaVO = conversionVOWS.convertir(solicitudAutorizaWSVO);

            //Convertimos a entidad

            siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVO);

            siiSolicitudAutoriza.setSiiExpedienteDocum(siiExpedienteDocumento);

            //Ingresamos el estado de la solicitud cuando se trata de un nuevo local
            SiiEstadoSolicAutoriz siiEstadoSolicAutoriz = estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.APROBADO.getId());
            siiSolicitudAutoriza.setSiiEstadoSolicAutoriz(siiEstadoSolicAutoriz);

            solicitudAutorizaDAO.insertarSiiSolicitudAutoriza(siiSolicitudAutoriza);

        } else {
            siiSolicitudAutoriza = solicitudAutorizaDAO.buscarSolicitudAutorizacionPorNumeroSiito(solicitudAutorizaWSVO.numeroSiito);
        }
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
        siiNovedad.setNovFecha(calendar.getTime());

        //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
        SiiContrato siiContrato = new SiiContrato();
        //Contrato de la novedad
        siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizaWSVO.numeroContrato, siiOperador.getOpeCodigo());
        siiNovedad.setSiiContrato(siiContrato);

        //Registro de la novedad
        novedadDAO.insertarSiiNovedad(siiNovedad);

        /*
         * Si no es una met entonces traigo todos los inventarios para ese contrato
         */
        List<SiiInventario> listaInventariosDeContrato = new ArrayList<SiiInventario>();
        listaInventariosDeContrato = inventarioDAO.buscarInventarioPorNumContrato(siiContrato.getConCodigo());


        /*
        * Una vez que traemos los datos de la tabla intermedia entre siito y siicol entonces vamos a procesder
        * a crear los objetos de tipo siiNovedad para hacer la persistencia de los datos
        */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            SiiEstablecimiento siiEstablecimiento = new SiiEstablecimiento();
            siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
            if (siiEstablecimiento == null) {
                throw new ExcepcionAplicacion("No se encontró el establecimiento " + movCargueInventarioWSVO.movCargueInvCodLocal + " para Nit " + movCargueInventarioWSVO.movCargueInvNit);
            }

            //Tipo de instrumento
            SiiTipoInstrumento siiTipoInstrumento = tipoInstrumentoDao.buscarTipoInstrumentoPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst));

            /*
            * Consultamos en el inventario el ultimo registro que cumple con los criterios de entra de la solicitud
             * de autorizacion
             */
            SiiInventario siiInventario = null;
            if (siiTipoInstrumento.getTinCodigo() ==
                EnumTipoInstrumento.MET.getId()) {
                //siiInventario = inventarioDAO.buscarInventarioXEstablecimientoYDatosMet(siiEstablecimiento.getEstCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstRet, movCargueInventarioWSVO.movCargueInvIucRet);
                siiInventario =
                                      inventarioDAO.buscarInventarioXEstablecimientoYDatosMet(siiEstablecimiento.getEstCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstRet,
                                                                                              movCargueInventarioWSVO.movCargueInvIucRet, movCargueInventarioWSVO.movCargueInvCont);
            } else {


                //Una vez que tengo todos los inventarios entonces recorro la lista para localizar el inventario que
                //cumpla con las condiciones de elemento y tipo de elemento para proceder a retirarlo
                for (SiiInventario siiInventarioItem : listaInventariosDeContrato) {
                    if (siiInventarioItem.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                        if (siiInventarioItem.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                            if (siiInventarioItem.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                                if (siiInventarioItem.getInvSillas().longValue() == movCargueInventarioWSVO.movCargueInvCantSillas) {
                                    siiInventario = siiInventarioItem;
                                    listaInventariosDeContrato.remove(siiInventarioItem);
                                    break;
                                }
                            } else if (siiInventarioItem.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                                if (siiInventarioItem.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {
                                    siiInventario = siiInventarioItem;
                                    listaInventariosDeContrato.remove(siiInventarioItem);
                                    break;

                                }
                            }
                        }
                    }
                }
            }

            if (siiInventario == null) {
                throw new ExcepcionAplicacion("No se encontró inventario");
            }

            if (siiInventario != null) {

                /*
                * Existen registros en sii_Inventario con fechas que incumplen la restriccion fecha final menor que la inicial
                */


                /*
                * Inactivamos el anterior registro
                *
                *fixme alan
                *if (siiInventario.getInvFechaFinOfi().before(siiInventario.getInvFechaIniOfi())) {
                    System.out.println("Codigo inventario:" + siiInventario.getInvCodigo());
                    System.out.println("inicial: " + siiInventario.getInvFechaIniOfi());
                    System.out.println("Final: " + siiInventario.getInvFechaFinOfi());
                    siiInventario.setInvFechaFinOfi(siiInventario.getInvFechaIniOfi());
                }

                //siiInventario.setInvFechaFinOfi(new Date());
                //siiInventario.setInvEstado(EnumEstadoInventario.INACTIVO.getId());
                //inventarioDAO.actualizarSiiInventario(siiInventario);
                /*
                * Duplicamos el registro y le ingresamos el nuevo tipo de apuesta con el estado PA
                */
                SiiInventario siiInventarioPendRetiro = new SiiInventario();

                siiInventarioPendRetiro = copiarInventarioObjetoNuevo(siiInventario);
                //siiInventarioPendRetiro.setInvCodigo(null);
                siiInventarioPendRetiro.setInvEstado(EnumEstadoInventario.PENDIENTE_RETIRO.getId());
                //siiInventarioPendRetiro.setInvFechaIniLiq(calendarHoraCero.getTime());
                //siiInventarioPendRetiro.setInvFechaFinLiq(calendarHoraCero.getTime());
                //siiInventarioPendRetiro.setInvFechaIniOfi(calendarHoraCero.getTime());
                //siiInventarioPendRetiro.setInvFechaFinOfi(calendarHoraCero.getTime());
                siiInventarioPendRetiro.setSiiNovedad(siiNovedad);
                inventarioDAO.insertarSiiInventario(siiInventarioPendRetiro);
            }
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
                SiiMesaCasino siiMesaCasino = null;
                if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {
                    siiMesaCasino = new SiiMesaCasino();
                    //siiMesaCasino.setMcaCodigo(mcaCodigo);
                    SiiJuegoMesa siiJuegoMesa = juegoMesaDao.buscarJuegoMesaPorCodigo(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipJuegos));
                    siiMesaCasino.setSiiJuegoMesa(siiJuegoMesa);
                    mesaCasinoDAO.insertarSiiMesaCasino(siiMesaCasino);
                    siiInstrumento.setSiiMesaCasino(siiMesaCasino);
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


                //Persisto el instrumento
                instrumentoDAO.insertarSiiInstrumento(siiInstrumento);

            }

            /*_/_/_/_/_/_/_/_/_/_/_/_/_/
            * TIPO APUESTA
            * _/_/_/_/_/_/_/_/_/_/_/_/*/
            //SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(movCargueInventarioWSVO.movCargueInvCodApuesta);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarSiiTipoApuestaByCodigoTipoApuesta(movCargueInventarioWSVO.movCargueInvCodApuesta + "");
            /*
            * Lleno los datos del inventario
            */
            SiiInventario siiInventarioNuevo = new SiiInventario();
            if (siiTipoInstrumento.getTinCodigo() == EnumTipoInstrumento.BINGO.getId()) {
                siiInventario.setInvSillas((int) movCargueInventarioWSVO.movCargueInvCantSillas);
            }

            siiInventarioNuevo.setSiiEstablecimiento(siiEstablecimiento);
            siiInventarioNuevo.setSiiInstrumento(siiInstrumento);
            siiInventarioNuevo.setSiiNovedad(siiNovedad);
            siiInventarioNuevo.setSiiTipoApuesta(siiTipoApuesta);
            siiInventarioNuevo.setInvFechaFinLiq(calendarHoraCero.getTime());
            siiInventarioNuevo.setInvFechaFinOfi(siiContrato.getConFechaFin());
            siiInventarioNuevo.setInvFechaIniLiq(calendarHoraCero.getTime());
            siiInventarioNuevo.setInvFechaIniOfi(calendarHoraCero.getTime());
            siiInventarioNuevo.setInvEstado(EnumEstadoInventario.PENDIENTE_APROBAR.getId());

            inventarioDAO.insertarSiiInventario(siiInventarioNuevo);
        }

        resultado = " " + solicitudAutorizaWSVO.codigoMovimiento + " Proceso Exitoso";

        return resultado;
    }


    /**
     *Metodo especializado, encargado de copiar un inventario de tipo entidad a otro, haciendo la copia
     * campo a campo para quitarle las referencias
     * @Author David Tafur
     * @param siiInventarioAnterior
     * @return
     */
    public SiiInventario copiarInventarioObjetoNuevo(SiiInventario siiInventarioAnterior) throws ExcepcionDAO {
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
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDAO.buscarTipoApuestaPorCodigo(siiInventarioAnterior.getSiiTipoApuesta().getTapCodigo());
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
     *
     * Metodo de validacion otras novedades
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesOtrasNovedades(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO, Exception {
        String respuesta = null;
        int contErrores = 0;
        boolean entroNovedad = false;
        // boolean errorGlobal = false;

        if (solicitudAutorizacionWSVO.nit == null || solicitudAutorizacionWSVO.nit.equals("")) {
            throw new Exception("El número NIT no puede ser nulo por favor verifique.");
        }

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        //Operador operador
        if (siiOperadorPersona.getPerCodigo() != null) {
            SiiOperador siiOperador = new SiiOperador();
            siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());
            //Si en la tabla intermedia no se trae el contrato no lo buscamos, de lo contrario
            SiiContrato siiContrato = new SiiContrato();
            //Contrato de la novedad
            siiContrato = contratoDAO.buscarContratoPorNumeroYCodigoOperador(solicitudAutorizacionWSVO.numeroContrato, siiOperador.getOpeCodigo());

            //contErrores = validarInventarioXOperadorOtrasNovedades(siiOperador.getOpeCodigo(), movCargueInventarioWSVOs, 90L);
            List<SiiInventario> listaInventarioMesa = inventarioDAO.buscarInventarioMesaPorContrato(siiContrato.getConCodigo()); //linea nueva para verificar cantidad de bingo

            /*
             * Se pre cargan los locales con sus municipios cargados en el archivo en un hashMAp para evitar reconsultas en cada novedad
             * */
            List<SiitoMovCargueInventario> localesCargados = movCargueInventarioDAO.consultarElementosXTipoNovedad(Long.valueOf(solicitudAutorizacionWSVO.radicado).longValue(), 50l);
            HashMap<String, String> localMun_Cargados = new HashMap();
            for (SiitoMovCargueInventario movCargueInventarioLocal : localesCargados) {
                localMun_Cargados.put(movCargueInventarioLocal.getMovCargueInvCodLocal(), movCargueInventarioLocal.getMovCargueInvCodMunLoc());

            }


            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

                /*
                 * ------------------------------------------
                 * 3.5 - TIPO DE NOVEDAD 50 CREACION DE LOCAL
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                    entroNovedad = true;

                    /*
                     * VALIDACION: El codigo el local no debe existir en el inventario del operador-contrato.
                     * Si no desplegar el Mensaje: 9050001 - Codigo del Local ya existe.
                     */
                    SiiEstablecimiento siiEstablecimiento = null;
                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                    if (siiEstablecimiento != null) {
                        contErrores = insertarError(9050001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                    }

                    /*
                     * VALIDACION: El codigo del municipio DANE debe existir en la tabla correspondiente.
                     * Si no desplegar el Mensaje: 9050002 - Codigo DANE municipio no existe.
                     */
                    SiiUbicacion siiUbicacion = new SiiUbicacion();
                    siiUbicacion = ubicacionDAO.buscarUbicacionPorId(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                    if (siiUbicacion == null) {
                        contErrores = insertarError(9050002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                    }
                }

                /*
                 * ------------------------------------------
                 * 3.1 - TIPO DE NOVEDAD 10 ADICION ELEMENTOS
                 * ------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.ADICION_ELEMENTOS.getId()) {
                    entroNovedad = true;

                    /*
                     *se verifica que exista el local del elemento que se desea agregar en el inventario actual
                     */
                    SiiEstablecimiento localInventario = null;
                    localInventario = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                    if (localInventario == null) {
                        if (!localMun_Cargados.containsKey(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                            contErrores = insertarError(9010010L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        }
                    }

                    /*
                     * VALIDACION: Para el tipo de elemento 1-MET, Si el NUC viene diligenciado, debera buscarlo
                     * en el inventario de Coljuegos, validar que NO se encuentre activo, Si no despelgar el Mensaje:
                     * 9010001 - NUC se encuentra Activo
                     */
                    //1-MET AQUIIIII
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {

                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");

                            if (siiInventario != null) {


                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010001L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                contErrores++;

                                if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                        contErrores++;
                                        siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010005L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                        contErrores++;
                                    }
                                } else {
                                    contErrores++;
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010004L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    //siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero()); no se complementa porque es de cara al operador.
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                }
                            } else {

                                siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), null);
                                if (siiInventario == null) {

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(2010012L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;

                                } else if (siiInventario != null) {
                                    String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                    long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                    if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                        if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010013L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        } else {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010002L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                        if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010014L);
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
                            List<SiiInventario> listSiiInventarioSMA = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas, "'A'");

                            //if (siiInventario != null) {
                            if (listSiiInventarioSMA != null && !listSiiInventarioSMA.isEmpty()) {
                                contErrores++;

                                //SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                HashMap<Long, String> errores = new HashMap();
                                for (SiiInventario siiInventario : listSiiInventarioSMA) {
                                    if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                        //if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                        if (!errores.containsKey(9010005L)) {
                                            errores.put(9010005L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(9010005L, errores.get(9010005L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        }
                                        //}
                                    } else {
                                        if (!errores.containsKey(9010004L)) {
                                            errores.put(9010004L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(9010004L, errores.get(2010004L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
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
                                List<SiiInventario> listaSiiInventarioSM1_72 = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas1_72, "'A'");
                                if (listaSiiInventarioSM1_72 != null && !listaSiiInventarioSM1_72.isEmpty()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(9010004L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>CONTRATO</th>");
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
                                List<SiiInventario> listSiiInventarioSMNULL = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, marcas, null);
                                if (!listSiiInventarioSMNULL.isEmpty()) {
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv2 = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(9010015L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
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

                        // VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011

                        SiiEstablecimiento siiEstablecimiento = null;
                        siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                        //Se verifica en la base de datos actual
                        if (siiEstablecimiento != null) {
                            if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        } else {
                            //Se verifica en la tabla intermedia si viene por crear local
                            List<SiitoMovCargueInventario> locales = movCargueInventarioDAO.consultarElementosXTipoNovedad(Long.valueOf(solicitudAutorizacionWSVO.radicado).longValue(), 50l);
                            List<SiitoMovCargueInventario> adiciones = movCargueInventarioDAO.consultarElementosXTipoNovedad(Long.valueOf(solicitudAutorizacionWSVO.radicado).longValue(), 10l);
                            for (SiitoMovCargueInventario local : locales) {
                                for (SiitoMovCargueInventario adicion : adiciones) {
                                    if (movCargueInventarioWSVO.movCargueInvCodigo == adicion.getMovCargueInvCodigo()) {
                                        if (local.getMovCargueInvCodLocal().equals(adicion.getMovCargueInvCodLocal())) {
                                            if (!local.getMovCargueInvCodMunLoc().equals(adicion.getMovCargueInvCodMunLoc())) {
                                                contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }
                            }
                        }


                        // VALIDACION: Para el tipo de elemento 1-MET, Si el NUC viene diligenciado debera buscarlo en el inventario de Coljuegos,
                        // si el NUID esta diligenciado validar que el NUID corresponda con el registrado, Si no deplegar el Mensaje: 9010003 -
                        // NUID no corresponde a ese NUC.


                        /*if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                                // verificamos en siicol la informacion

                               SiiInstrumento siiInstrumento = null;
                               siiInstrumento =
                                   instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                     String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                               // Verificamos la informacion de serial y la marca para el registro
                               if (siiInstrumento != null) {
                                   if (siiInstrumento.getSiiMet().getMetNuid() != movCargueInventarioWSVO.movCargueInvNuidAd) {
                                       contErrores = insertarError(9010003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                   }
                               }
                           }



                        // VALIDACION: Para tipo de elemento 1-MET, Si el campo "Indicador conexion en linea SCLM" reportado es 2 y la MET existe en el
                        // inventario del operador-contrato y NO esta marcada como en "Periodo de gracia", desplegar el Mensaje: 9010006 -
                        // MET no se encuentra en el peridodo de gracia.


                           if (movCargueInventarioWSVO.movCargueInvIndInstSclmIn == 2L) {
                               SiiInventario siiInventario = null;
                               if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                                   siiInventario =
                                       inventarioDAO.buscarInventarioXUIDYContrato(movCargueInventarioWSVO.movCargueInvNuidAd, movCargueInventarioWSVO.movCargueInvCont,
                                                                                   movCargueInventarioWSVO.movCargueInvCodLocal);
                               } else {
                                   siiInventario =
                                       inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                     movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                                     movCargueInventarioWSVO.movCargueInvCodLocal);
                               }

                               if (siiInventario != null) {
                                   if (!siiInventario.getInvPg().equals("S")) {
                                       contErrores = insertarError(9010006L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                   }
                               }
                           }
                        //}


                         // VALIDACION: Validar que el codigo de apuesta reportado corresponda al tipo de elemento reportado, Si no desplegar
                         // el Mensaje: 9010007 - Codigo de apuesta no corresponde a ese tipo de elemento.

                        //if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                               if (movCargueInventarioWSVO.movCargueInvCodApuesta <= 1 && movCargueInventarioWSVO.movCargueInvCodApuesta >= 3) {
                                   contErrores = insertarError(9010007L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                               }
                           }*/


                        /*
                        //NUC diligenciado
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                            SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");
                            //SI ES ACTIVA
                            if (siiInventario != null) {
                                contErrores = insertarError(9010001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);



                                // VALIDACION: Si la (1-MET) o 5-ACDV, se encuentra en un contrato activo y si el Nit y el contrato del operador
                                // de la base de datos es diferente al Nit y el contrato del operador que realiza la novedad debera desplegar el
                                // Mensaje: 9010004 - Elemento de juego autorizado en el inventario de otro contrato de concesion.

                                if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(movCargueInventarioWSVO.movCargueInvCont)) {
                                    //||!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    contErrores = insertarError(9010004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                } else {


                                     // VALIDACION: Si la (1-MET) o 5-ACDV, se encuentra en un contrato activo y si el Nit y el contrato del operador
                                     // de la base de datos es IGUAL al Nit y el contrato que realiza la novedad y el establecimiento de la base de datos
                                     // es diferente al establecimiento de la novedad debera despelgar el Mensaje: 9010005 - Elemento de juego
                                     // actualmente autorizado en el establecimiento xxxx (xxxx: Establecimiento de la base de datos).

                                    if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                        contErrores = insertarError(9010005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            } else { //NO ESTA ACTIVA

                                siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), null);
                                if (siiInventario == null) {


                                    // Relacion con el cargue inventario estado cargue

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9010012L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);

                                    //VERIFICAR QUE EXISTA PARA ESA MARCA Y SERIAL

                                    SiiInventario siiInventarioXNitYMarca =
                                        inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);

                                    if (siiInventarioXNitYMarca == null) {
                                        contErrores = insertarError(9010002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }

                                } else {

                                     // VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011

                                    SiiEstablecimiento siiEstablecimiento = null;
                                    siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                                    if (siiEstablecimiento != null) {
                                        if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                            contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                        }
                                    }

                                    SiiInventario siiInventarioXNitYMarca =
                                        inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);

                                    if (siiInventarioXNitYMarca == null) {
                                        contErrores = insertarError(9010002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    } else {
                                        if (!siiInventarioXNitYMarca.getSiiInstrumento().getSiiMet().getMetNuid().equals(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd))) {
                                            contErrores = insertarError(9010002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                        }
                                    }
                                }

                            }
                        } else {
                            //NUC sin diligenciar
                            SiiInventario siiInventario =
                                inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);

                            if (siiInventario != null) {
                                //contErrores++;


                                 // Relacion con el cargue inventario estado cargue

                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                //siitoMovCargInvEstCargInv.setEstCargInvCodigo(1010001L);
                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);


                                // VALIDACION: Si la (1-MET) o 5-ACDV, se encuentra en un contrato activo y si el Nit y el contrato del operador
                                // de la base de datos es diferente al Nit y el contrato del operador que realiza la novedad debera desplegar el
                                // Mensaje: 9010004 - Elemento de juego autorizado en el inventario de otro contrato de concesion.

                                if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(movCargueInventarioWSVO.movCargueInvCont)) {
                                    //!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    contErrores = insertarError(9010004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                } else {


                                     // VALIDACION: Si la (1-MET) o 5-ACDV, se encuentra en un contrato activo y si el Nit y el contrato del operador
                                     // de la base de datos es IGUAL al Nit y el contrato que realiza la novedad y el establecimiento de la base de datos
                                     // es diferente al establecimiento de la novedad debera despelgar el Mensaje: 9010005 - Elemento de juego
                                     // actualmente autorizado en el establecimiento xxxx (xxxx: Establecimiento de la base de datos).

                                    if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                        contErrores = insertarError(9010005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            } else { //AQUI


                                // VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011

                                SiiEstablecimiento siiEstablecimiento = null;
                                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);
                                //Se verifica en la base de datos actual
                                if (siiEstablecimiento != null) {
                                    if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                        contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                } else {
                                    //Se verifica en la tabla intermedia si viene por crear local
                                    List<SiitoMovCargueInventario> locales = movCargueInventarioDAO.consultarElementosXTipoNovedad(Long.valueOf(solicitudAutorizacionWSVO.radicado).longValue(), 50l);
                                    List<SiitoMovCargueInventario> adiciones = movCargueInventarioDAO.consultarElementosXTipoNovedad(Long.valueOf(solicitudAutorizacionWSVO.radicado).longValue(), 10l);
                                    for (SiitoMovCargueInventario local : locales) {
                                        for (SiitoMovCargueInventario adicion : adiciones) {
                                            if (movCargueInventarioWSVO.movCargueInvCodigo == adicion.getMovCargueInvCodigo()) {
                                                if (local.getMovCargueInvCodLocal().equals(adicion.getMovCargueInvCodLocal())) {
                                                    if (!local.getMovCargueInvCodMunLoc().equals(adicion.getMovCargueInvCodMunLoc())) {
                                                        contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
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
                                * Mensaje: 9010004 - Elemento de juego autorizado en el inventario de otro contrato de concesion.
                                */
                                if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(movCargueInventarioWSVO.movCargueInvCont)) {
                                    //!siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    contErrores = insertarError(9010004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                } else {

                                    /*
                                     * VALIDACION: Si la 1-MET o (5-ACDV), se encuentra en un contrato activo y si el Nit y el contrato del operador
                                     * de la base de datos es IGUAL al Nit y el contrato que realiza la novedad y el establecimiento de la base de datos
                                     * es diferente al establecimiento de la novedad debera despelgar el Mensaje: 9010005 - Elemento de juego
                                     * actualmente autorizado en el establecimiento xxxx (xxxx: Establecimiento de la base de datos).
                                     */
                                    if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                        contErrores = insertarError(9010005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            } else {

                                /*
                                 * VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011
                                 */
                                SiiEstablecimiento siiEstablecimiento = null;
                                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                                if (siiEstablecimiento != null) {
                                    if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                        contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            }
                        }
                    }

                    /*
                     * VALIDACION: Para el tipo de elemento 1-MET, Si el NUC viene diligenciado, debera buscarlo
                     * en el inventario de Coljuegos, Si existe debe validar que el serial y la marca reportada corresponda
                     * con el registrado, Si no desplegar el Mensaje:9010002 - Serial y Marca no corresponden a ese NUC
                     */
                    //OTRO
                    if (movCargueInventarioWSVO.movCargueInvTipInst != null) {

                        /*
                         * OTRO
                         */
                        if (movCargueInventarioWSVO.movCargueInvTipInst.equals(EnumTipoInstrumento.OTRO.getId() + "") ||
                            movCargueInventarioWSVO.movCargueInvTipInst.equals(EnumTipoInstrumento.MESA_DE_CASINO.getId() + "") ||
                            movCargueInventarioWSVO.movCargueInvTipInst.equals(EnumTipoInstrumento.BINGO.getId() + "")) {
                            if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                                /*
                                 * verificamos en siicol la informacion
                                 */
                                SiiInstrumento siiInstrumento = null;
                                siiInstrumento =
                                    instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                      String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                                // Verificamos la informacion de serial y la marca para el registro
                                if (siiInstrumento != null) {
                                    if (!siiInstrumento.getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd) &&
                                        siiInstrumento.getSiiMet().getSiiMarca().getMarCodigo() != movCargueInventarioWSVO.movCargueInvCodMarca.longValue()) {

                                        contErrores = insertarError(9010002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                /*
                                 * VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011
                                 */
                                SiiEstablecimiento siiEstablecimiento = null;
                                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                                if (siiEstablecimiento != null) {
                                    if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                        contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            } else {

                                /*
                                 * VALIDACION: Código de establecimiento no coincide con codigo DANE, Continuacion error 9010011
                                 */
                                SiiEstablecimiento siiEstablecimiento = null;
                                siiEstablecimiento = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocal);

                                if (siiEstablecimiento != null) {
                                    if (!siiEstablecimiento.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                        contErrores = insertarError(9010011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            }
                        }
                    }


                    /*
                     * VALIDACION: Para tipo de elemento 2-Bingo validar que el codigo de apuesta reportado corresponda con la poblacion
                     * del municipio. Si no desplegar el Mensaje: 9010009 - Codigo de apuesta para bingo no corresponde a la poblacion.
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc));
                        //SiiEnteTerritorial siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc);


                        if (siiEnteTerritorial != null) {
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 6) {
                                //if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 7) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 8) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 9) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 10) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 11) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 12) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 13) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 14) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 15) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }

                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 22) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }
                            if (movCargueInventarioWSVO.movCargueInvCodApuesta == 23) {
                                if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                    contErrores = insertarError(9010009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
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
                     * VALIDACION: Validar que la cantidad de elementos reportados adicionados a un local corresponda a la cantidad minima
                     * de elementos de acerdo a la poblacion del municipio
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        SiiEnteTerritorial siiEnteTerritorial = new SiiEnteTerritorial();
                        siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc);

                        if (siiEnteTerritorial != null) {

                        } else {
                            contErrores++;

                            /*
                            * Creamos la descripcion del error en estado cargue inventario
                            */
                            SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;
                            siitoEstadoCargueInventario = estadoCargueInventarioDAO.buscarSiitoEstadoCargueInventarioXEstCargInvDesc("El ente territorial no existe en el sistema");

                            if (siitoEstadoCargueInventario == null) {
                                siitoEstadoCargueInventario = new SiitoEstadoCargueInventario();
                                siitoEstadoCargueInventario.setEstCargInvDesc("El ente territorial no existe en el sistema");
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

                }

                /*
                 * --------------------------------------------
                 * 3.2 - TIPO DE NOVEDAD 20 RETIRO DE ELEMENTOS
                 * --------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.RETIRO_ELEMENTOS.getId()) {
                    entroNovedad = true;

                    /************************************************************************************************
                     * Comprobamos el tipo de elemento
                     ************************************************************************************************/
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {

                        /*
                         * VALIDACION: Si Tipo de elemento 1-MET, Si viene diligenciado el NUC validar que exista en el inventario
                         * activo y autorizado del operador-contrato, que el codigo del local, el codigo de municipio DANE del local
                         * y codigo de apuesta reportado correponda al registrado para esa MET. Si no desplegar el Mensaeje:
                         * 9020001 - Cod. Local o Cod. Municipio o Cod. De apuesta no corresponde para ese NUC.
                         */
                        if (movCargueInventarioWSVO.movCargueInvIucRet != null) {

                            /*
                             * Validamos que exista en el inventario activo y autorizado del operador contrato
                             */
                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXUIDYContrato(String.valueOf(movCargueInventarioWSVO.movCargueInvIucRet), movCargueInventarioWSVO.movCargueInvCont,
                                                                            movCargueInventarioWSVO.movCargueInvCodLocal);

                            if (siiInventario != null) {

                                //Como esta el NUID se verifica que corresponda al serial y marca reportado
                                if (!(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstRet) &&
                                      (siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "").equals(movCargueInventarioWSVO.movCargueInvIndAmpDis + ""))) {
                                    contErrores = insertarError(9020007L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                                /*
                                * Si encontro algun registro por estos criterios entonces seguimos con las validaciones
                                * Hacemos la vlidacion de que el codigo del local retiro sea el mismo al que esta registrado
                                */
                                if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                    contErrores = insertarError(9020001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                                /*
                                * Comprobamos que el codigo DANE del municipio corresponda al del local
                                */
                                if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                    contErrores = insertarError(9020001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                                /*
                                 * Comprobamos que el tipo de apuesta reportado sea igual al tipo de apuesta registrado
                                 */
                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    contErrores = insertarError(9020001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                            } else {
                                contErrores = insertarError(9020001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                        } else {

                            /*
                             * VALIDACION: Si Tipo de elemento 1-MET, Si NO viene diligenciado el NUC, Serial y Marca validar que exista
                             * en el inventario activo y autorizado del operador-contrato, que el codigo local, el codigo de municipio DANE
                             * del local y codigo de apuesta reportado corresponda al registrado para esa MET. Si no desplegar el Mensaje:
                             * 9020002 - Cod. Local o Cod.Municipio o Cod. De apuesta no corresponde para ese Serial y Marca.
                             */
                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstRet,
                                                                                              movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                              movCargueInventarioWSVO.movCargueInvCodLocal);

                            boolean esError = false;

                            if (siiInventario == null) {
                                esError = true;
                            } else {
                                /*
                                * Comprobamos que el codigo DANE del municipio corresponda al del local
                                */
                                if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                    esError = true;
                                }

                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    esError = true;
                                }
                            }

                            if (esError) {
                                contErrores = insertarError(9030002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }

                    } else if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        /*
                        * VALIDACION: Si tipo de elemento 2-Bingo, con el local reportado validar que exista registrado en le inventario
                        * activo y autorizado del operador-contrato, por lo menos un bingo con la cantidad de sillas y el codigo de apuesta reportado.
                        * Si no desplegar el Mensaje: 9020003 - No existe Bingo con Cantidad de sillas y Cod. Apuesta en ese local
                        */
                        SiiInventario siiInventario = null;
                        siiInventario =
                            inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                                      movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());

                        if (siiInventario == null) {
                            contErrores = insertarError(9020003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        } else {
                            if (movCargueInventarioWSVO.movCargueInvCantSillas > siiInventario.getInvSillas()) {
                                contErrores = insertarError(9020008L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }

                    } else if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {

                        /*
                         * VALIDACION: Si tipo de elemento 3-Mesas, con el local reportado validar que exista en el inventario activo
                         * y autorizado del operador-contrato, por lo menos una mesa con el mismo "tipo de juego reportado" y que
                         * corresponda el codigo del local, el codgio DANE del local y Cod. de apuesta reportado con el registrado.
                         * Si no desplegar el Mensaje: 9020004 - No existe Mesa con Tipo de juego, Cod. DANE y Cod. de apuesta
                         * en ese local.
                         */
                        //  List<SiiInventario> listaInventarioMesa = inventarioDAO.buscarInventarioMesaPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                        boolean almenosUnaCorresponde = false;

                        for (SiiInventario inventarioMesa : listaInventarioMesa) {
                            /*
                            * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                            * apuesta
                            */
                            if (inventarioMesa.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                inventarioMesa.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc) &&
                                inventarioMesa.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "") &&
                                inventarioMesa.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal) &&
                                inventarioMesa.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {
                                listaInventarioMesa.remove(inventarioMesa);
                                almenosUnaCorresponde = true;
                                break;
                            }
                        }
                        if (!almenosUnaCorresponde) {
                            contErrores = insertarError(9020004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);

                        }


                    }

                    /***********************************************************************************
                     * VALIDACION: Si tipo de elemento 4-otros, con el local reportado validar que exista en el inventario activo
                     * y autorizado del operador-contrato, que corresponda el codigo del local, el codigo DANE del local y Cod. de apuesta
                     * reportado con el registrado. Si no desplegar el Mensaje: 9020005 - No existe Otros con Tipo de juego,
                     * Cod. DANE y Cod. apuesta en ese local
                     ***********************************************************************************/
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.OTRO.getId()) {
                        if (movCargueInventarioWSVO.movCargueInvNuidAd != null) {
                            List<SiiInventario> listaInventario =
                                inventarioDAO.buscarInventarioOtroPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                            boolean almenosUnaCorresponde = false;

                            for (SiiInventario siiInventario : listaInventario) {

                                /************************************************************************************************
                                * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                                * apuesta
                                ************************************************************************************************/
                                if (siiInventario.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                    siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo() == movCargueInventarioWSVO.movCargueInvCodMunLoc &&
                                    siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    almenosUnaCorresponde = true;
                                    break;
                                }
                            }
                            if (!almenosUnaCorresponde) {
                                contErrores = insertarError(9020005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }
                    }
                }

                /*
                 * --------------------------------------------
                 * 3.3 - TIPO DE NOVEDAD 30 TRASLADO ELEMENTOS
                 * --------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.TRASLADO_ELEMENTOS.getId()) {
                    entroNovedad = true;

                    /*
                     * Comprobamos el tipo de elemento
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {

                        /*
                         * Verificamos si viene diligenciado el nuc
                         */
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null && !movCargueInventarioWSVO.movCargueInvIucAd.equals("")) {

                            /*
                             * VALIDACION: Si tipo de elemento 1-MET, Si viene diligenciado el NUC validar que exista en el inventario activo
                             * y autorizado del operador-contrato, que el codigo del local, el codigo municipio DANE del local y codigo
                             * de apuesta reportado corresponda al registrado para esa MET. Si no desplegar el Mensaje: 9030001 - Cod.
                             * Local o Cod. Municipio o Cod. De apuesta no corresponde para ese NUC.
                             */
                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXUIDYContrato(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), movCargueInventarioWSVO.movCargueInvCont,
                                                                            movCargueInventarioWSVO.movCargueInvCodLocal);

                            if (siiInventario != null) {
                                boolean esError = false;

                                /*
                                * Si encontro algun registro por estos criterios entonces seguimos con las validaciones
                                * Hacemos la vlidacion de que el codigo del local retiro sea el mismo al que esta registrado
                                */
                                if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                    esError = true;
                                }

                                /*
                                * Comprobamos que el codigo DANE del municipio corresponda al del local
                                */
                                if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                    esError = true;
                                }

                                /*
                                 * Comprobamos que el tipo de apuesta reportado sea igual al tipo de apuesta registrado
                                 */
                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    esError = true;
                                }

                                if (esError) {
                                    contErrores = insertarError(9030001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    contErrores = insertarError(9030008L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                                if (siiInventario.getSiiInstrumento().getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                    if (!(siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo().intValue() == movCargueInventarioWSVO.movCargueInvCodMarca)) {
                                        contErrores = insertarError(9030010L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                } else {
                                    contErrores = insertarError(9030010L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }

                            } else {
                                contErrores = insertarError(9030001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                        } else {

                            /*
                             * VALIDACION: Si Tipo elemento 1-MET, Si NO viene diligenciado el NUC, por Serial y Marca validar que exista en
                             * el inventario activo y autorizado del operador-contrato, que el codigo del local, el codigo de municipio
                             * DANE del local y codigo de apuesta reportado corresponda al registrado para ese MET. Si no desplegar el Mensaje:
                             * 9030002 - Cod. Local o Cod Municipio o Cod. De apuesta no corresponde para ese Serial y Marca.
                             */
                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                              movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                              movCargueInventarioWSVO.movCargueInvCodLocal);

                            if (siiInventario == null) {
                                contErrores = insertarError(9030002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            } else {
                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    contErrores = insertarError(9030008L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }


                        }


                    } else if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        /*
                        * VALIDACION: Si tipo de elemento 2-Bingo, con el local reportado validar que exista registrado en el inventario
                        * activo y autorizado del operador-contrato, por lo menos un bingo con la cantidad de sillas
                        * y el codigo de apuesta reportado. Si no desplegar el Mensaje: 9030003 - No existe Bingo con Cantidad
                        * de sillas y Cod Apuesta en ese local.
                        */
                        SiiInventario siiInventario = null;
                        siiInventario =
                            inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                                      movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());

                        if (siiInventario == null) {
                            contErrores = insertarError(9030003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        } else {

                            if (movCargueInventarioWSVO.movCargueInvCantSillas > siiInventario.getInvSillas()) {
                                contErrores = insertarError(9030012L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                            EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLocDest));
                            //SiiEnteTerritorial siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(movCargueInventarioWSVO.movCargueInvCodMunLoc);


                            if (siiEnteTerritorial != null) {
                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 6) {
                                    //if (siiEnteTerritorial.getEtiPoblacion() > 100000) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 7) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 8) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 9) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 10) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 11) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 12) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 13) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 14) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 15) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() < 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 22) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                                if (movCargueInventarioWSVO.movCargueInvCodApuesta == 23) {
                                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000) {
                                        contErrores = insertarError(9030011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }

                            }
                        }


                    }

                    else if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {

                        boolean encontroLocalOrigen = false;
                        boolean encontroLocalDestino = false;


                        /*
                         * VALIDACION: Si tipo de elemento 3-Mesas, con el local reportado validar que exista en el inventario activo
                         * y autorizado del operador-contrato, por lo menos una mesa con el mismo "tipo de juego reportado" y que
                         * corresponda el codigo del local, el codgio DANE del local y Cod. de apuesta reportado con el registrado.
                         * Si no desplegar el Mensaje: 9030004 - No existe Mesa con Tipo de juego, Cod. DANE y Cod. de apuesta
                         * en ese local.
                         */
                        //List<SiiInventario> listaInventarioMesa = inventarioDAO.buscarInventarioMesaPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                        boolean almenosUnaCorresponde = false;

                        for (SiiInventario inventarioMesa : listaInventarioMesa) {
                            /*
                            * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                            * apuesta
                            */
                            if (inventarioMesa.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                inventarioMesa.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc) &&
                                inventarioMesa.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "") &&
                                inventarioMesa.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal) &&
                                inventarioMesa.getSiiInstrumento().getSiiMesaCasino().getSiiJuegoMesa().getJmeCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvTipJuegos)) {
                                listaInventarioMesa.remove(inventarioMesa);
                                almenosUnaCorresponde = true;
                                break;
                            }
                        }
                        if (!almenosUnaCorresponde) {
                            contErrores = insertarError(9030004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        }

                    }

                    /*
                     * VALIDACION: Si tipo de elemento 4-otros, con el local reportado validar que exista en el inventario activo
                     * y autorizado del operador-contrato, que corresponda el codigo del local, el codigo DANE del local y Cod. de apuesta
                     * reportado con el registrado. Si no desplegar el Mensaje: 9030005 - No existe Otros con Tipo de juego,
                     * Cod. DANE y Cod. apuesta en ese local
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.OTRO.getId()) {
                        if (movCargueInventarioWSVO.movCargueInvNuidAd != null) {
                            List<SiiInventario> listaInventario =
                                inventarioDAO.buscarInventarioOtroPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                            boolean almenosUnaCorresponde = false;

                            for (SiiInventario siiInventario : listaInventario) {

                                /*
                                * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                                * apuesta
                                */
                                if (siiInventario.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                    siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo() == movCargueInventarioWSVO.movCargueInvCodMunLoc &&
                                    siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    almenosUnaCorresponde = true;
                                    break;
                                }

                                if (!almenosUnaCorresponde) {
                                    contErrores = insertarError(9030005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }
                        }
                    }

                    SiiEstablecimiento siiEstablecimientoDestino = null;
                    siiEstablecimientoDestino = establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvCodLocalDest);
                    //Se verifica en la base de datos actual
                    if (siiEstablecimientoDestino == null) {
                        /*verifica que el local se este creando en e archivo cargado*/
                        if (!localMun_Cargados.containsKey(movCargueInventarioWSVO.movCargueInvCodLocalDest)) {
                            contErrores = insertarError(9030007L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        }
                    } else if (siiEstablecimientoDestino != null) {
                        /*
                         * VALIDACION: Código de establecimiento no coincide con codigo DANE destino, Continuacion error 9010011
                         */
                        if (!siiEstablecimientoDestino.getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLocDest)) {
                            contErrores = insertarError(9030009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        }
                    }

                    /*
                     * VALIDACION: Validar que código de local destino exista en el inventario actual del operador-contrato,
                     * de lo contrario generar un mensaje de error que diga: 9030007-Local Destino no existe en inventario actual.
                     */

                }

                /*
                 * ----------------------------------------------
                 * 3.4 - TIPO DE NOVEDAD 40 REMPLAZO DE ELEMENTOS
                 * ----------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.REEMPLAZO_ELEMENTOS.getId()) {
                    entroNovedad = true;

                    /*
                     * VALIDACION: Si Tipo de elemento 1-MET, Si viene diligenciado el NUC-Retiro validar que exita en el inventario
                     * activo y autorizado del operador-contrato, que el codigo del local, el codigo de municipio DANE del local
                     * y codigo de apuesta-Retiro reportado corresponda al registro para esa MET. Si no despelgar el Mensaje:
                     *  9040001 - Cod. Local o Cod. Municipio o Cod. De apuesta no correspone para ese NUC a retirar.
                     */

                    /*
                     * Comprobamos el tipo de elemento
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {

                        //Para el tipo de elemento 1-MET, SI el NUC viene diligenciado, deberá buscarlo en el inventario de Coljuegos,
                        //validar que NO se encuentre ACTIVO, Si no desplegar el Mensaje: 1010001- NUC se encuentra Activo”.
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");

                            if (siiInventario != null) {


                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040007L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                contErrores++;

                                if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                    if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {

                                        siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                        siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040010L);
                                        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                        siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                        contErrores++;
                                    }
                                } else {
                                    contErrores++;
                                    siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040014L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    //siitoMovCargInvEstCargInv.setComplemento(siiInventario.getSiiNovedad().getSiiContrato().getConNumero()); no se complementa porque es de cara al operador.
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;
                                }
                            } else {

                                siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), null);
                                if (siiInventario == null) {

                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040015L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                    contErrores++;

                                } else if (siiInventario != null) {
                                    String serial = siiInventario.getSiiInstrumento().getSiiMet().getMetSerial();
                                    long marca = siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo();
                                    if (!serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {
                                        if (marca == movCargueInventarioWSVO.movCargueInvCodMarca.longValue() || marca == 1 || marca == 72) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040017L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        } else {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040012L);
                                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                            contErrores++;
                                        }
                                    } else if (serial.equals(movCargueInventarioWSVO.movCargueInvSerialInstAd)) {

                                        if (marca != movCargueInventarioWSVO.movCargueInvCodMarca && marca != 1L && marca != 72L) {
                                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9040018L);
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
                                    if (siiInventario.getSiiNovedad().getSiiContrato().getSiiOperador().getSiiPersona().getPerNumIdentificacion().equals(movCargueInventarioWSVO.movCargueInvNit)) {
                                        if (!siiInventario.getSiiNovedad().getSiiContrato().getConNumero().equals(solicitudAutorizacionWSVO.numeroContrato)) {
                                            if (!errores.containsKey(9040010L)) {
                                                errores.put(9040010L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                            } else {
                                                errores.put(9040010L, errores.get(9040010L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                            }

                                        }
                                    } else {
                                        if (!errores.containsKey(9040014L)) {
                                            errores.put(9040014L, siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
                                        } else {
                                            errores.put(9040014L, errores.get(9040014L) + "," + siiInventario.getSiiNovedad().getSiiContrato().getConNumero());
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
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(9040014L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>CONTRATO</th>");
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
                                    siitoMovCargInvEstCargInv2.setEstCargInvCodigo(9040018L);
                                    siitoMovCargInvEstCargInv2.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    StringBuilder complemento = new StringBuilder("<br/><center><table class=\"newtabla\" ><tr><th>SERIAL</th><th>MARCA ACTUAL</th><th>NUC</th>");
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


                            /*if (movCargueInventarioWSVO.movCargueInvIucAd != null) {
                                SiiInventario siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");
                                if (siiInventario != null) {
                                    contErrores = insertarError(9040007L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    SiiInventario siiInventarioSM = null;
                                    siiInventarioSM = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                                    if (siiInventarioSM == null) {
                                        contErrores = insertarError(9040008L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                } else {
                                    siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "A");
                                    if (siiInventario != null) {
                                        if (!(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd) &&
                                              siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo().toString().equals(movCargueInventarioWSVO.movCargueInvCodMarca.toString()))) { //se entiende que es la de adición
                                            contErrores = insertarError(9040012L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                        }
                                        if (!movCargueInventarioWSVO.movCargueInvCont.equals(siiInventario.getSiiNovedad().getSiiContrato().getConNumero())) {
                                            contErrores = insertarError(9040016L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                        }
                                    } else {
                                        siiInventario = inventarioDAO.buscarInventarioMETXCriterios(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), "I");
                                        if (!(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd) &&
                                              (siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "").equals(movCargueInventarioWSVO.movCargueInvCodMarca +
                                                                                                                                       ""))) { //se entiende que es la de adición
                                            contErrores = insertarError(9040012L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                        }
                                    }
                                }
                            } else {

                                //NO TIENE NUC SE BUSCA POR SERIAL Y MARCA de ADICIÓN
                                SiiInventario siiInventarioSM = null;
                                siiInventarioSM = inventarioDAO.buscarInventarioMetPorSerialMarca(movCargueInventarioWSVO.movCargueInvSerialInstAd, movCargueInventarioWSVO.movCargueInvCodMarca);
                                if (siiInventarioSM != null) {
                                    if (!movCargueInventarioWSVO.movCargueInvCont.equals(siiInventarioSM.getSiiNovedad().getSiiContrato().getConNumero())) {
                                        contErrores = insertarError(9040016L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    } else {
                                        contErrores = insertarError(9040010L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            }*/

                            /*if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                                // verificamos en siicol la informacion
                                SiiInstrumento siiInstrumento = null;
                                siiInstrumento =
                                    instrumentoDAO.consultarInstrumentosMETXCriterios(Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst), siiOperador.getOpeCodigo(),
                                                                                      String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd));

                                // Verificamos la informacion de serial y la marca para el registro
                                if (siiInstrumento != null) {
                                    if (siiInstrumento.getSiiMet().getMetNuid() != movCargueInventarioWSVO.movCargueInvNuidAd) {
                                        contErrores = insertarError(9040009L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                    }
                                }
                            }*/


                            // VALIDACION: Validar que el codigo de apuesta_Adicion reportado corresponda al tipo de elemento reportado, Si no desplegar
                            // el Mensaje: 9040011 - Codigo de apuesta no corresponde a ese tipo de elemento.


                            /*if (movCargueInventarioWSVO.movCargueInvCodApuesta <= 1 && movCargueInventarioWSVO.movCargueInvCodApuesta >= 3) {
                                contErrores = insertarError(9040011L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }*/


                            //  VALIDACION: Para el tipo de elemento 1-MET, Si el NUC-Adicion viene diligenciado debera buscarlo en el inventario de Coljuegos,
                            // si el NUID-Adicion esta diligenciado validar que el NUID-Adicion corresponda con el registrado, Si no deplegar el Mensaje: 9040009-
                            // NUID no corresponde a ese NUC adicionar.


                            // VALIDACION:  Para el tipo de elemento 1-MET y 5-ACDV, Si el NUC-Adicion NO viene diligenciado, validar que NO existan en el
                            // inventario de Coljuegos por Operador-contrato elementos Activos con el mismo local,
                            // serial y codigo de marca reportado, Si no desplegar el Mensaje: 9040010 - Serial-Adicion y Marca-Adicion Adicionar duplicado
                            // en el inventario para ese local

                            /*if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) ==
                                    EnumTipoInstrumento.MET.getId()) {
                                    if (movCargueInventarioWSVO.movCargueInvIucAd == null) {

                                        SiiInventario siiInventario = null;

                                        siiInventario =
                                            inventarioDAO.buscarInventarioXSerialXMarcaContratoActivos(movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                       movCargueInventarioWSVO.movCargueInvCodMarca,
                                                                                                       movCargueInventarioWSVO.movCargueInvCont);

                                         // Verificamos que el isntrumento este o no en siicol como invetario

                                        if (siiInventario != null) {
                                            contErrores =
                                                insertarError(9040010L, movCargueInventarioWSVO.movCargueInvCodigo,
                                                              contErrores);
                                        }
                                    }
                                }*/

                        }

                        // Verificamos si viene diligenciado el nuc retiro

                        if (movCargueInventarioWSVO.movCargueInvIucRet != null || !movCargueInventarioWSVO.movCargueInvIucRet.equals("")) {


                            // Validamos que exista en el inventario activo y autorizado del operador contrato

                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXUIDYContrato(String.valueOf(movCargueInventarioWSVO.movCargueInvIucRet), movCargueInventarioWSVO.movCargueInvCont,
                                                                            movCargueInventarioWSVO.movCargueInvCodLocal);


                            if (siiInventario != null) {

                                //Como esta el NUID se verifica que corresponda al serial y marca reportado
                                if (!(siiInventario.getSiiInstrumento().getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstRet) &&
                                      (siiInventario.getSiiInstrumento().getSiiMet().getSiiMarca().getMarCodigo() + "").equals(movCargueInventarioWSVO.movCargueInvIndAmpDis + ""))) {
                                    contErrores = insertarError(9040013L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }


                                // Si encontro algun registro por estos criterios entonces seguimos con las validaciones
                                // Hacemos la vlidacion de que el codigo del local retiro sea el mismo al que esta registrado

                                if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                    contErrores = insertarError(9040001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }


                                // Comprobamos que el codigo DANE del municipio corresponda al del local

                                if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                    contErrores = insertarError(9040001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }


                                // Comprobamos que el tipo de apuesta reportado sea igual al tipo de apuesta registrado

                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    contErrores = insertarError(9040001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            } else {
                                contErrores = insertarError(9040001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                        } else {


                            // VALIDACION: Si Tipo de elemento 1-MET, Si NO viene diligenciado el NUC, por Serial y Marca validar que exista
                            // en el inventario activo y autorizado del operador-contrato, que el codigo del local, el codigo de municipio
                            // DANE del local y codigo de apuesta-Retiro reportado corresponda al registrado para ese MET.
                            // Si no desplegar el Mensaje: 9040002 - Cod. Local o Cod. Municipio o Cod. De apuesta no corresponde para ese
                            // Serial y Marca a retirar.

                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.buscarInventarioXOperadorXSerialXMarcaYContrato(siiOperador.getOpeCodigo(), movCargueInventarioWSVO.movCargueInvSerialInstRet,
                                                                                              movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                              movCargueInventarioWSVO.movCargueInvCodLocal);

                            if (siiInventario != null) {


                                // Si lo encuentra hacemos las validaciones

                                if (!siiInventario.getSiiEstablecimiento().getEstCodInterno().equals(movCargueInventarioWSVO.movCargueInvCodLocal)) {
                                    contErrores = insertarError(9040002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }


                                // Comprobamos que el codigo DANE del municipio corresponda al del local

                                if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                    contErrores = insertarError(9040002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }


                                // Comprobamos que el tipo de apuesta reportado sea igual al tipo de apuesta registrado

                                if (!siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    contErrores = insertarError(9040002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            } else {
                                contErrores = insertarError(9040002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }
                    }

                    /*
                         * VALIDACION: Si tipo de elemento 3-Mesas, con el local reportado validar que exista en el inventario activo
                         * y autorizado del operador-contrato, por lo menos una mesa con el mismo "tipo de juego reportado" y que
                         * corresponda el codigo del local, el codgio DANE del local y Cod. de apuesta reportado con el registrado.
                         * Si no desplegar el Mensaje: 9040004 - No existe Mesa con Tipo de juego, Cod. DANE y Cod. de apuesta a retirar
                         * en ese local.
                         */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {


                        List<SiiInventario> listaInventarioMesas =
                            inventarioDAO.buscarInventarioMesaPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                        boolean almenosUnaCorresponde = false;

                        for (SiiInventario inventarioMesa : listaInventarioMesas) {

                            /*
                                * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                                * apuesta
                                */
                            if (inventarioMesa.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                inventarioMesa.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo() == movCargueInventarioWSVO.movCargueInvCodMunLoc &&
                                inventarioMesa.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                almenosUnaCorresponde = true;
                                break;
                            }

                            if (!almenosUnaCorresponde) {
                                contErrores = insertarError(9040004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }
                    }

                    /*
                         * VALIDACION: Si tipo de elemento 4-otros, con el local reportado validar que exista en el inventario activo
                         * y autorizado del operador-contrato, que corresponda el codigo del local, el codigo DANE del local y Cod. de apuesta-Retiro
                         * reportado con el registrado. Si no desplegar el Mensaje: 9040005 - No existe Otros con Tipo de juego,
                         * Cod. DANE y Cod. apuesta a retirar en ese local
                         */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.OTRO.getId()) {
                        if (movCargueInventarioWSVO.movCargueInvNuidAd != null) {
                            List<SiiInventario> listaInventario =
                                inventarioDAO.buscarInventarioOtroPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                            boolean almenosUnaCorresponde = false;

                            for (SiiInventario siiInventario : listaInventario) {

                                /*
                                    * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                                    * apuesta
                                    */
                                if (siiInventario.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                    siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo() == movCargueInventarioWSVO.movCargueInvCodMunLoc &&
                                    siiInventario.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                    almenosUnaCorresponde = true;
                                    break;
                                }

                                if (!almenosUnaCorresponde) {
                                    contErrores = insertarError(9040005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }
                        }
                    }


                    // VALIDACION: Para el tipo de elemento 1-MET y 5-ACDV, Si el NUC-Adicion viene diligenciado, debera buscarlo
                    // en el inventario de Coljuegos, validar que NO se encuentre activo, Si no despelgar el Mensaje:
                    // 9040007 - NUC adicionar se encuentra Activo


                    // VALIDACION: Para el tipo de elemento 1-MET y 5-ACDV, Si el NUC-Adicion viene diligenciado, debera buscarlo
                    // en el inventario de Coljuegos, Si existe debe validar que el serial-Adicion y la marca-Adicion reportada corresponda
                    // con el registrado, Si no desplegar el Mensaje:9040008 - Serial y Marca no corresponden a ese NUC


                }


                /*
                 * -------------------------------------------
                 * 3.6 - TIPO DE NOVEDAD 60 CAMBIO DE APUESTA
                 * -------------------------------------------
                 */
                if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CAMBIO_APUESTA.getId()) {
                    entroNovedad = true;

                    /*
                     * VALIDACION: Si Tipo de elemento 1-MET, Si viene diligenciado el NUC validar que exista en el inventario
                     * activo y autorizado del operador-contrato, que el codigo del local, el codigo de municipio DANE del local
                     * y codigo de apuesta reportado correponda al registrado para esa MET. Si no desplegar el Mensaeje:
                     * 9060001 - Cod. Local o Cod. Municipio o Cod. De apuesta no corresponde para ese NUC.
                     */
                    //Met
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MET.getId()) {
                        //Nuc
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null && !movCargueInventarioWSVO.movCargueInvIucAd.equals("")) {

                            SiiInstrumento siiInstrumento = null;
                            siiInstrumento =
                                instrumentoDAO.validarNUCXContratoXCodigoLocalXCodigoDaneXTipoApuesta(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd),
                                                                                                      movCargueInventarioWSVO.movCargueInvCont, movCargueInventarioWSVO.movCargueInvCodLocal,
                                                                                                      movCargueInventarioWSVO.movCargueInvCodMunLoc, movCargueInventarioWSVO.movCargueInvCodApuesta);

                            if (siiInstrumento == null) {
                                contErrores = insertarError(9060001L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);

                            } else {
                                //Como esta el NUID se verifica que corresponda al serial y marca reportado
                                if (!(siiInstrumento.getSiiMet().getMetSerial().equals(movCargueInventarioWSVO.movCargueInvSerialInstAd) &&
                                      (siiInstrumento.getSiiMet().getSiiMarca().getMarCodigo() + "").equals(movCargueInventarioWSVO.movCargueInvCodMarca + ""))) {
                                    contErrores = insertarError(9060005L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                }
                            }
                        } else {

                            /*
                             * VALIDACION: Si Tipo de elemento 1-MET, Si NO viene diligenciado el NUC, Serial y Marca validar que exista
                             * en el inventario activo y autorizado del operador-contrato, que el codigo local, el codigo de municipio DANE
                             * del local y codigo de apuesta reportado corresponda al registrado para esa MET. Si no desplegar el Mensaje:
                             * 9060002 - Cod. Local o Cod.Municipio o Cod. De apuesta no corresponde para ese Serial y Marca.
                             */
                            SiiInstrumento siiInstrumento = null;
                            siiInstrumento =
                                instrumentoDAO.validarSerialYMarcaXContratoXCodigoLocalXCodigoDaneXTipoApuesta(movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                               movCargueInventarioWSVO.movCargueInvCodMarca.longValue(),
                                                                                                               movCargueInventarioWSVO.movCargueInvCont, movCargueInventarioWSVO.movCargueInvCodLocal,
                                                                                                               movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                                               movCargueInventarioWSVO.movCargueInvCodApuesta);

                            if (siiInstrumento == null) {
                                contErrores = insertarError(9060002L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                        }

                    }
                    /*
                    * VALIDACION: Si tipo de elemento 2-Bingo, con el local reportado validar que exista registrado en le inventario
                    * activo y autorizado del operador-contrato, por lo menos un bingo con la cantidad de sillas y el codigo de apuesta reportado.
                    * Si no desplegar el Mensaje: 9060003 - No existe Bingo con Cantidad de sillas y Cod. Apuesta en ese local
                    */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.BINGO.getId()) {

                        /*
                             * para tipo de elemento bingo con el local reportado validar que exista registrado por lo menos un bingo con la cantidad
                             * de sillas y el codigo de apuesta reportado
                             */
                        SiiInventario siiInventario = null;
                        siiInventario =
                            inventarioDAO.buscarInventarioBingoPorEstablecimientoTipoApuestaYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc,
                                                                                                      movCargueInventarioWSVO.movCargueInvCodApuesta, siiContrato.getConCodigo());

                        if (siiInventario == null) {
                            contErrores = insertarError(9060003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                        } else {

                            if (movCargueInventarioWSVO.movCargueInvCantSillas > siiInventario.getInvSillas()) {
                                contErrores = insertarError(9060015L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }

                            if (!siiInventario.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo().trim().equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                contErrores = insertarError(9060006L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }
                    }

                    /*
                     * VALIDACION: Si tipo de elemento 3-Mesas, con el local reportado validar que exista en el inventario activo
                     * y autorizado del operador-contrato, por lo menos una mesa con el mismo "tipo de juego reportado" y que
                     * corresponda el codigo del local, el codgio DANE del local y Cod. de apuesta reportado con el registrado.
                     * Si no desplegar el Mensaje: 9060004 - No existe Mesa con Tipo de juego, Cod. DANE y Cod. de apuesta
                     * en ese local.
                     */
                    if (Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) == EnumTipoInstrumento.MESA_DE_CASINO.getId()) {

                        List<SiiInventario> listaInventarioMesas =
                            inventarioDAO.buscarInventarioMesaPorEstablecimientoYContrato(movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCont);
                        boolean almenosUnaCorresponde = false;

                        for (SiiInventario inventarioMesa : listaInventarioMesas) {

                            /*
                            * Se verifica si almenos una mesa de ese local corresponde al mismo tipo de elemento codigo dane y el codigo de
                            * apuesta
                            */
                            if (inventarioMesa.getSiiInstrumento().getSiiTipoInstrumento().getTinCodigo() == Long.parseLong(movCargueInventarioWSVO.movCargueInvTipInst) &&
                                inventarioMesa.getSiiEstablecimiento().getSiiUbicacion1().getUbiCodigo() == movCargueInventarioWSVO.movCargueInvCodMunLoc &&
                                inventarioMesa.getSiiTipoApuesta().getTapCodigoApuesta().equals(movCargueInventarioWSVO.movCargueInvCodApuesta + "")) {
                                almenosUnaCorresponde = true;
                                break;
                            }

                            if (!almenosUnaCorresponde) {
                                contErrores = insertarError(9060004L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                            }
                        }
                    }
                }
            }
        }

        /*
         * Verificar el numero de errores
         */
        //if (!errorGlobal) {
        if (contErrores > 0) {
            respuesta = "1 Se encontraron " + contErrores + " errores";
        } else {
            if (entroNovedad) {
                respuesta = "1 No se encontraron errores";
            } else {
                respuesta = "20 No registra el tipo de Novedad";
            }
        }
        //}

        return respuesta;
    }

    /**
     *
     * Metodo de validacion Met Linea elementos
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesReporteMetLinea(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO {
        String respuesta = null;
        int contErrores = 0;
        boolean entroNovedad = false;
        boolean errorGlobal = false;

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (siiOperador != null) {
            //   if (siiOperador.getOpeTipoPoblac().equals("A")) {
            if (movCargueInventarioWSVOs != null && !movCargueInventarioWSVOs.isEmpty()) {
                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

                    /*
                     * ---------------------------------------
                     * 4.1 - TIPO DE NOVEDAD 11 MET EN LINEA
                     * ---------------------------------------
                     */
                    if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CAMBIO_ESTADO_METL.getId()) {
                        entroNovedad = true;

                        /*
                             * VALIDACION:  Si viene diligenciado el NUC validar que el serial y marca correspondan con los enviados
                             * --PENDIENTE
                             */

                        /*
                             * VALIDACION: Si viene diligenciado el NUC, validar que la exista en el inventario activo y autorizado del
                             * operador-contrato, que le codigo del local y el codigo de municipio DANE del local reportado corresponda
                             * al registrado para esa MET. Si no desplegar el Mensaje: 9111001 - Codigo del local o Codigo DANE no corresponde
                             * para ese NUC.
                             */
                        if (movCargueInventarioWSVO.movCargueInvIucAd != null) {

                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.validarNUCXContratoXCodigoLocalXCodigoDane(String.valueOf(movCargueInventarioWSVO.movCargueInvIucAd), movCargueInventarioWSVO.movCargueInvCont,
                                                                                         movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc);

                            if (siiInventario == null) {

                                contErrores++;

                                /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(9111001L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            } else {

                                /*
                                     * VALIDACION: Si viene diligenciado el NUC, validar que exista en el inventario activo y autorizado
                                     * del operador-contrato y se encuentre en estado "Perdiodo de Gracia". Si no desplegar el Mensaje:
                                     * 91111003 - La MET no se encuentra en periodo de gracia para ese NUC.
                                     */
                                if (!siiInventario.getInvPg().equals("S")) {

                                    contErrores++;

                                    /*
                                        * Relacion con el cargue inventario estado cargue
                                        */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9111003L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        } else {

                            /*
                                 * VALIDACION: Si NO viene diligenciado el NUC, por Serial y Marca validar que la exista en el inventario activo
                                 * y autorizado del operador-contrato, que le codigo del local y el codigo de municipio DANE del local reportado
                                 * corresponda al registrado para esa MET. Si no desplegar el Mensaje: 9111002 - Codigo del local o Codigo DANE
                                 * no corresponde para ese Serial y Marca.
                                */
                            SiiInventario siiInventario = null;
                            siiInventario =
                                inventarioDAO.validarMETSerialYMarcaXContratoXCodigoLocalXCodigoDane(movCargueInventarioWSVO.movCargueInvSerialInstAd,
                                                                                                     movCargueInventarioWSVO.movCargueInvCodMarca.longValue(), movCargueInventarioWSVO.movCargueInvCont,
                                                                                                     movCargueInventarioWSVO.movCargueInvCodLocal, movCargueInventarioWSVO.movCargueInvCodMunLoc);

                            if (siiInventario == null) {

                                contErrores++;

                                /*
                                    * Relacion con el cargue inventario estado cargue
                                    */
                                SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                siitoMovCargInvEstCargInv.setEstCargInvCodigo(9111002L);
                                siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            } else {

                                /*
                                     * VALIDACION: Si NO viene diligenciado el NUC,POR Serial y Marca validar que exista en el inventario activo y autorizado
                                     * del operador-contrato y se encuentre en estado "Perdiodo de Gracia". Si no desplegar el Mensaje:
                                     * 91111004 - La MET no se encuentra en periodo de gracia para ese Serial y Marca.
                                     */
                                if (!siiInventario.getInvPg().equals("S")) {

                                    contErrores++;

                                    /*
                                        * Relacion con el cargue inventario estado cargue
                                        */
                                    SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                                    siitoMovCargInvEstCargInv.setEstCargInvCodigo(9111004L);
                                    siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                    movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                                }
                            }
                        }
                    }
                }

                /*
                     * VALIDACION: Validar que la cantidad de MET reportadas para marcar correspondan al 30% de las MET marcadas como
                     * en "Periodo de gracia". Si no desplegar el Mensaje: 9111005 - Cantidad de MET a marcar no correponde al 30%
                     * de las MET en periodo de gracia.
                     */
                //                    List<SiiInstrumento> siiInstrumentos = null;
                //                    siiInstrumentos = instrumentoDAO.consultarInstrumentosXOperadorPG(siiOperador.getOpeCodigo());
                //
                //                    if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                //
                //                        /*
                //                        * Se calcula el 30%
                //                        */
                //                        int totalRegistros = siiInstrumentos.size();
                //                        int treintaPorcientoRegistros = (totalRegistros * 30) / 100;
                //                        int treintaPorcientoRegistrosRedondeado =
                //                            (new BigDecimal(treintaPorcientoRegistros).setScale(0,
                //                                                                                BigDecimal.ROUND_HALF_UP)).intValue();
                //
                //                        /*
                //                         * Contamos las reportadas
                //                         */
                //                        int totalReportadas = 0;
                //                        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                //
                //                            /*
                //                             * ---------------------------------------
                //                             * 2.2 - TIPO DE NOVEDAD 11 MET EN LINEA
                //                             * ---------------------------------------
                //                             */
                //                            if (movCargueInventarioWSVO.movCargueInvTipNov ==
                //                                EnumTipoNovedad.CAMBIO_ESTADO_METL.getId()) {
                //                                totalReportadas++;
                //                            }
                //                        }
                //
                //                        //validamos
                //                        if (treintaPorcientoRegistrosRedondeado == totalReportadas) {
                //
                //                            contErrores++;
                //
                //                            /*
                //                            * Relacion con el cargue inventario estado cargue
                //                            */
                //                            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
                //                            siitoMovCargInvEstCargInv.setEstCargInvCodigo(9111004L);
                //                            siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVOs.get(0).movCargueInvCodigo);
                //                            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                //                        }
                //                    }

            } else {
                errorGlobal = true;
                respuesta = "60 No hay datos en la tabla intermedia.";

            }
            // }// else {
            // errorGlobal = true;
            //  respuesta = "50 Tipo de Operador invalido para el periodo de reporte.";
            //   }
        } else {
            errorGlobal = true;
            respuesta = "30 El operador no se encuentra registrado";
        }

        /*
         * Verificar el numero de errores
         */
        if (!errorGlobal) {
            if (contErrores > 0) {
                respuesta = "1 Se encontraron " + contErrores + " errores";
            } else {
                if (entroNovedad) {
                    respuesta = "1 No se encontraron errores";
                } else {
                    respuesta = "20 No registra el tipo de Novedad";
                }
            }
        }

        return respuesta;
    }

    /**
     *
     * Metodo de validacion Contadores Met
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @throws ExcepcionDAO
     */
    public String validacionesReporteContadoresMet(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs) throws ExcepcionDAO {
        String respuesta = null;
        int contErrores = 0;
        boolean entroNovedad = false;
        boolean errorGlobal = false;

        /*
        * Buscamos el operador
        */
        SiiPersona siiOperadorPersona = new SiiPersona();
        siiOperadorPersona = personaDAO.buscarPersonaPorTipoYNumeroIdentificacion(EnumTipoIdentificacion.NUMERO_IDENTIFICACION_TRIBUTARIO.getId(), solicitudAutorizacionWSVO.nit);

        //Operador operador
        SiiOperador siiOperador = new SiiOperador();
        siiOperador = operadorDAO.buscarOperadorXCodigoPersona(siiOperadorPersona.getPerCodigo());

        if (siiOperador != null) {


        } else {
            errorGlobal = true;
            respuesta = "30 El operador no se encuentra registrado";
        }

        /*
         * Verificar el numero de errores
         */
        if (!errorGlobal) {
            if (contErrores > 0) {
                respuesta = "1 Se encontraron " + contErrores + " errores";
            } else {
                if (entroNovedad) {
                    respuesta = "1 No se encontraron errores";
                } else {
                    respuesta = "20 No registra el tipo de Novedad";
                }
            }
        }

        return respuesta;
    }

    /**
     * @author Giovanni
     * @param solicitudAutorizacionWSVO
     * @param movCargueInventarioWSVOs
     * @return
     * @throws ExcepcionDAO
     * @throws Exception
     */
    public String cargaOtrasNovedades(SolicitudAutorizaWSVO solicitudAutorizacionWSVO, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs,
                                      List<ExpedienteRadicadoWSVO> listaExpedienteRadicadoWsVo) throws ExcepcionDAO, ExcepcionAplicacion {
        String resultado = "";
        Boolean docCargados = false;
        //Se ignora MovimientoSiito
        solicitudAutorizacionWSVO.codigoMovimiento = new Long(solicitudAutorizacionWSVO.numeroSiito);

        /*
         * Lista para agrupar las novedades
         */
        List<MovCargueInventarioWSVO> movCargueInventarioNovedadWSVOs = new ArrayList<MovCargueInventarioWSVO>();
        /*
         * Lista para agrupar las novedades reportadas
         */
        List<Long> novedadesReportadas = new ArrayList<Long>();

        /*
         * Inventario
         */
        for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {

            /*
             * Verificamos que la novedad no exista

           // boolean existeNovedad = false;
            for (Long novedad : novedadesReportadas) {
                if (novedad.equals(movCargueInventarioWSVO.movCargueInvTipNov)) {
                    existeNovedad = true;
                    break;
                }
            }


            if (!existeNovedad) {*/
            if (!novedadesReportadas.contains(movCargueInventarioWSVO.movCargueInvTipNov)) {
                novedadesReportadas.add(movCargueInventarioWSVO.movCargueInvTipNov);
            }
        }

        /*
         *Buscamos primero si se deben crear locales
         */
        for (Long novedad : novedadesReportadas) {
            movCargueInventarioNovedadWSVOs = new ArrayList<MovCargueInventarioWSVO>();

            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (novedad.equals(movCargueInventarioWSVO.movCargueInvTipNov)) {
                    movCargueInventarioNovedadWSVOs.add(movCargueInventarioWSVO);
                }
            }

            /*
             * ---------------------------------------
             * CREAR LOCAL
             * ---------------------------------------
             */
            //if (movCargueInventarioNovedadWSVOs.get(0).movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
            if (novedad.equals(EnumTipoNovedad.CREACION_LOCAL.getId())) {
                resultado = crearLocal(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo, docCargados);
                docCargados = true;
            }
        }

        /*
         * Recorremos las listas para agrupar las novedades y cargarlas
         */
        for (Long novedad : novedadesReportadas) {

            /*
             * Borramos la lista para la nueva novedad
             */
            movCargueInventarioNovedadWSVOs = new ArrayList<MovCargueInventarioWSVO>();

            for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                if (novedad.equals(movCargueInventarioWSVO.movCargueInvTipNov)) {
                    movCargueInventarioNovedadWSVOs.add(movCargueInventarioWSVO);
                }
            }

            /*
             * ---------------------------------------
             * ADICION ELEMENTOS
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.ADICION_ELEMENTOS.getId())) {
                resultado = insertarNovedadAdicionElemento(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo, docCargados);
                docCargados = true;
            }

            /*
             * ---------------------------------------
             * RETIRO ELEMENTOS
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.RETIRO_ELEMENTOS.getId())) {
                resultado = insertarNovedadRetiroElemento(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo, docCargados);
                docCargados = true;
            }

            /*
             * ---------------------------------------
             * TRASLADO ELEMENTOS
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.TRASLADO_ELEMENTOS.getId())) {
                resultado = trasladoElemento(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo);
            }

            /*
             * ---------------------------------------
             * REEMPLAZO ELEMENTOS
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.REEMPLAZO_ELEMENTOS.getId())) {
                resultado = reemplazoElemento(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo);
            }


            /*
             * ---------------------------------------
             * CAMBIO APUESTA
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.CAMBIO_APUESTA.getId())) {
                resultado = cambioApuesta(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo);
            }

            /*
             * ---------------------------------------
             * ELEMENTOS EN BODEGA
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.ELEMENTOS_BODEGA.getId())) {
                resultado = elementosEnBodega(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo);
            }

            /*
             * ---------------------------------------
             * CREACION LICENCIA ACDV
             * ---------------------------------------
             */
            if (novedad.equals(EnumTipoNovedad.CREACION_LICENCIA_ACDV.getId())) {
                resultado = creacionLicenciaACDV(solicitudAutorizacionWSVO, movCargueInventarioNovedadWSVOs, listaExpedienteRadicadoWsVo);
            }
        }
        return resultado;
    }

    /**
     * @author Giovanni
     * @param movCargueInventarioWSVOs
     * @return
     * @throws ExcepcionDAO
     */

    /*private int validarInventarioXOperadorOtrasNovedades(Long codOperador, List<MovCargueInventarioWSVO> movCargueInventarioWSVOs, Long tipoSolicitud) throws ExcepcionDAO {
        int respuesta = 0;
        int contErrores = 0;


         //Minimos por Local



        // Verificamos cuantos locales registran en el inventario

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
                                if (movCargueInventarioLocalWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                    if (movCargueInventarioLocalWSVO.movCargueInvCodMunLoc.equals(movCargueInventarioWSVO.movCargueInvCodMunLoc)) {
                                        SiiEstablecimiento siiEstablecimiento = null;
                                        establecimientoDAO.buscarEstablecimientoXOperadorYCodInterno(codOperador, movCargueInventarioLocalWSVO.movCargueInvCodLocal);

                                        if (siiEstablecimiento == null) {

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


                                             // Verificamos los elementos

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
                                                        } else if (movCargueInventarioLocalCntWSVO.movCargueInvTipNov == EnumTipoNovedad.TRASLADO_ELEMENTOS.getId()) {
                                                            if (movCargueInventarioLocalCntWSVO.movCargueInvCodLocalDest.equals(movCargueInventarioLocalWSVO.movCargueInvCodLocal)) {
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
                        }
                        municipiosMinimosVOs.add(municipiosMinimosVO);
                    }
                }
            }
        }


         // Validacion: verifica que un local no se encuentre repetido en varios municipios

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


            // Creamos la descripcion del error en estado cargue inventario

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


            // Relacion con el cargue inventario estado cargue

            SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
            siitoMovCargInvEstCargInv.setEstCargInvCodigo(siitoEstadoCargueInventario.getEstCargInvCodigo());


            // Verificamos la linea del local mov cargue inventario codigo

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
                EnteTerritorialVO siiEnteTerritorial = new EnteTerritorialVO(enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio()));
            //siiEnteTerritorial siiEnteTerritorial = enteTerritorialDAO.buscarEnteTerritorialXIdUbicacion(municipiosMinimosVO.getCodigoMunicipio());

                //Item 1: De 500.001 en adelante = 20 Elementos
                if (siiEnteTerritorial != null) {
                   // if (siiEnteTerritorial.getEtiPoblacion() > 500000) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 500000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 20) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                //siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }
                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 2: De 100.001 a 500.000 = 16 Elementos
                if (siiEnteTerritorial != null) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 100000 && siiEnteTerritorial.getEtiPoblacionActual() <= 500000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 16) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                // siitoMovCargInvEstCargInv.setMovCargueInvCodigo(movCargueInventarioWSVO.movCargueInvCodigo);
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }

                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 3: De 50.001 a 100.000 = 13 Elementos
                if (siiEnteTerritorial != null) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 50000 && siiEnteTerritorial.getEtiPoblacionActual() <= 100000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 13) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }

                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 4: De 25.001 a 50.000 = 11 Elementos
                if (siiEnteTerritorial != null) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 25000 && siiEnteTerritorial.getEtiPoblacionActual() <= 50000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 11) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }

                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 5: De 10.001 a 25.000 = 7 Elementos
                if (siiEnteTerritorial != null) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() > 10000 && siiEnteTerritorial.getEtiPoblacionActual() <= 25000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 7) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }

                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }

                //Item 6: De menos de 10.000  = 3 Elementos
                if (siiEnteTerritorial != null) {
                    if (siiEnteTerritorial.getEtiPoblacionActual() <= 10000) {

                        for (LocalesMinimosVO localesMinimosVO : municipiosMinimosVO.getLocalesMinimosVOs()) {
                            if (localesMinimosVO.getNumeroInstrumentos() < 3) {
                                //contErrores++;


                                for (MovCargueInventarioWSVO movCargueInventarioWSVO : movCargueInventarioWSVOs) {
                                    if (movCargueInventarioWSVO.movCargueInvTipSolCodigo == tipoSolicitud) {
                                        if (movCargueInventarioWSVO.movCargueInvTipNov == EnumTipoNovedad.CREACION_LOCAL.getId()) {
                                            if (movCargueInventarioWSVO.movCargueInvCodLocal.equals(localesMinimosVO.getCodigoLocal())) {
                                                contErrores = insertarError(9050003L, movCargueInventarioWSVO.movCargueInvCodigo, contErrores);
                                            }
                                        }
                                    }
                                }

                                //movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
                            }
                        }
                    }
                }
            }
        }


         // Verificar el numero de errores

        if (contErrores > 0) {
            respuesta = contErrores;
        }

        return respuesta;
    }*/

    public List<Long> buscarUltimasSolicitudeDelContrato(Long conCodigo) throws ExcepcionDAO, Exception {
        return novedadDAO.buscarUltimasSolicitudeDelContrato(conCodigo);
    }

    public int insertarError(Long codigoError, long estado, int contErrores) throws ExcepcionDAO {

        /*
        * Relación con el cargue inventario estado cargue
        */

        SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv = new SiitoMovCargInvEstCargInv();
        siitoMovCargInvEstCargInv.setEstCargInvCodigo(codigoError);
        siitoMovCargInvEstCargInv.setMovCargueInvCodigo(estado);
        try {
            movCargInvEstCargInvDAO.registrarMovCargInvEstCargInv(siitoMovCargInvEstCargInv);
        } catch (ExcepcionDAO e) {
            e.printStackTrace();
        }
        return contErrores + 1;
    }

    public SolicitudAutorizaVO buscarSolicitudAutorizaContratoNuevoPorIdContrato(Long conCodigo) throws ExcepcionDAO {
        return new SolicitudAutorizaVO(novedadDAO.buscarSolicitudAutorizaContratoNuevoPorIdContrato(conCodigo));
    }

    public List<NovedadVO> buscarNovedadesPorIdOtrosi(Long idOtrosi) throws ExcepcionDAO {
        List<NovedadVO> listaNovedadVo = null;
        List<SiiNovedad> listaSiiNovedad = novedadDAO.buscarNovedadesPorIdOtrosi(idOtrosi);
        if (listaSiiNovedad != null && listaSiiNovedad.size() > 0) {
            listaNovedadVo = new ArrayList<>();
            for (SiiNovedad siiNovedad : listaSiiNovedad) {
                NovedadVO novedadVo = new NovedadVO(siiNovedad);
                listaNovedadVo.add(novedadVo);
            }
        }
        return listaNovedadVo;
    }


}
