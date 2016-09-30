package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentaContTipoDocContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuotaOperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FestivoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmaDocumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.LogCambioEstadoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OperadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TerminacionAnticipContDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminacionAnticip;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminacionAnticipContVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.math.RoundingMode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminTerminacionAnticipContBean implements AdminTerminacionAnticipCont {
    @Resource
    SessionContext sessionContext;

    @EJB
    private TerminacionAnticipContDAO terminacionAnticipContDAO;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private FestivoDAO festivoDao;
    @EJB
    private InventarioDAO inventarioDao;
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    @EJB
    private NovedadDAO novedadDao;
    @EJB
    private AdminContrato adminContrato;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private EstadoContratoDAO estadoContratoDao;
    @EJB
    private CuotaOperadorDAO cuotaOperadorDao;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private CuentaContTipoDocContDAO cuentaContTipoDocContDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private OperadorDAO operadorDao;
    @EJB
    private PersonaDAO personaDao;


    public AdminTerminacionAnticipContBean() {
    }

    public TerminacionAnticipContVO buscarTerminacionAnticipadaPorId(Long idTanCodigo) throws ExcepcionDAO {
        SiiTerminacionAnticip siiTerminacionAnticip =
            terminacionAnticipContDAO.buscarTerminacionAnticipadaPorId(idTanCodigo);
        return new TerminacionAnticipContVO(siiTerminacionAnticip);
    }

    public TerminacionAnticipContVO insertarTerminacionAnticipada(TerminacionAnticipContVO terminacionAnticipContVo,
                                                                  UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                    ExcepcionAplicacion {
        SiiTerminacionAnticip siiTerminacionAnticip = conversionVoEntidad.convertir(terminacionAnticipContVo);
        SiiTerminacionAnticip nuevaTerminacionAnticip =
            terminacionAnticipContDAO.insertarTerminacionAnticipada(siiTerminacionAnticip);
        if (terminacionAnticipContVo.getEstadoTermAnticipVo().getEtaCodigo() !=
            terminacionAnticipContVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(19L,
                                                         terminacionAnticipContVo.getEstadoTermAnticipVo().getEtaCodigo(),
                                                         usuarioLogueado, siiTerminacionAnticip.getTanCodigo());
        }
        return new TerminacionAnticipContVO(nuevaTerminacionAnticip);
    }

    public TerminacionAnticipContVO actualizarTerminacionAnticipada(TerminacionAnticipContVO terminacionAnticipContVo,
                                                                    UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                      ExcepcionAplicacion {

        try {
            Date fechaActual = new Date();
            SiiTerminacionAnticip terminacionAnticipActual =
                terminacionAnticipContDAO.buscarTerminacionAnticipadaPorId(terminacionAnticipContVo.getTanCodigo());
            if (terminacionAnticipActual.getSiiEstadoTermAnticip().getEtaCodigo() !=
                terminacionAnticipContVo.getIdEstadoAnterior()) {
                throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud fue cambiado durante la modificación. Seleccione nuevamente la solicitud");
            }
            SiiTerminacionAnticip siiTerminacionAnticip =
                terminacionAnticipContDAO.actualizarTerminacionAnticipada(conversionVoEntidad.convertir(terminacionAnticipContVo));

            if (terminacionAnticipContVo.getEstadoTermAnticipVo().getEtaCodigo() == 5L) {
                SiiNovedad siiNovedad = new SiiNovedad();
                List<SiiInventario> siiInventarios = null;
                siiInventarios =
                    inventarioDao.buscarInventarioPorNumContratoActivo(terminacionAnticipActual.getSiiContrato().getConNumero());

                //Actualiza inventario actual
                if (siiInventarios.size() > 0) {
                    for (SiiInventario siiInventario : siiInventarios) {
                        siiInventario.setInvEstado("I");
                        inventarioDao.actualizarSiiInventario(siiInventario);
                    }
                    //Crea la nueva novedad
                    siiNovedad.setSiiContrato(terminacionAnticipActual.getSiiContrato());
                    SiiTipoNovedad siiTipoNovedad = tipoNovedadDao.buscarPorNombre("TERMINACIÓN ANTICIPADA CONTRATO");
                    siiNovedad.setSiiTipoNovedad(siiTipoNovedad);
                    siiNovedad.setNovFecha(fechaActual);
                    siiNovedad.setSiiTerminacionAnticip(siiTerminacionAnticip);
                    siiNovedad = novedadDao.insertarSiiNovedad(siiNovedad);


                    //Inserta la copia del inventario alctual con cambios
                    for (SiiInventario unSiiInventario : siiInventarios) {
                        SiiInventario siInventario = new SiiInventario();
                        siInventario.setInvEstado("A");
                        siInventario.setSiiNovedad(siiNovedad);
                        if (siiTerminacionAnticip.getTanFechaAproTerAnt() != null)
                            siInventario.setInvFechaFinLiq(siiTerminacionAnticip.getTanFechaAproTerAnt());
                        if (unSiiInventario.getInvFechaFinOfi() != null)
                            siInventario.setInvFechaFinOfi(unSiiInventario.getInvFechaFinOfi());
                        if (unSiiInventario.getInvFechaIniLiq() != null)
                            siInventario.setInvFechaIniLiq(unSiiInventario.getInvFechaIniLiq());
                        if (unSiiInventario.getInvFechaIniOfi() != null)
                            siInventario.setInvFechaIniOfi(unSiiInventario.getInvFechaIniOfi());
                        if (unSiiInventario.getInvSillas() != null)
                            siInventario.setInvPg(unSiiInventario.getInvPg());
                        if (unSiiInventario.getInvSillas() != null)
                            siInventario.setInvSillas(unSiiInventario.getInvSillas());
                        if (unSiiInventario.getSiiEstablecimiento() != null)
                            siInventario.setSiiEstablecimiento(unSiiInventario.getSiiEstablecimiento());
                        if (unSiiInventario.getSiiInstrumento() != null)
                            siInventario.setSiiInstrumento(unSiiInventario.getSiiInstrumento());
                        if (unSiiInventario.getSiiTipoApuesta() != null)
                            siInventario.setSiiTipoApuesta(unSiiInventario.getSiiTipoApuesta());
                        inventarioDao.insertarSiiInventario(siInventario);
                    }
                }

                BigDecimal calculovalorContrato;
                BigDecimal temDE = BigDecimal.ZERO;
                BigDecimal temGA = BigDecimal.ZERO;
                BigDecimal temvalor=new BigDecimal(100);
                BigDecimal temvalor2=new BigDecimal(101);
                calculovalorContrato =
                    adminContrato.calculoValorXEjecutarContratoConc(siiTerminacionAnticip.getSiiContrato().getConCodigo());
                temDE = (calculovalorContrato.multiply(temvalor)).divide(temvalor2, 0, RoundingMode.UP);
                temGA = calculovalorContrato.multiply(new BigDecimal(0.01));
                
                //Actualiza contrato
                SiiContrato unSiiContrato = new SiiContrato();
                SiiEstadoContrato siiEstadoContrato =
                    estadoContratoDao.buscarEstadoContratoPorNombre("TERMINACIÓN ANTICIPADA");
                unSiiContrato = siiTerminacionAnticip.getSiiContrato();
                unSiiContrato.setSiiEstadoContrato(siiEstadoContrato);
                unSiiContrato.setConFechaFinDefin(siiTerminacionAnticip.getTanFechaAproTerAnt());
                unSiiContrato.setConVigente("N");
                contratoDao.actualizarSiiContrato(unSiiContrato);

                //actualiza log de contrato
                if (unSiiContrato.getSiiEstadoContrato().getEcoCodigo() != null) {
                    adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(),
                                                                 unSiiContrato.getSiiEstadoContrato().getEcoCodigo(),
                                                                 usuarioLogueado, siiTerminacionAnticip.getTanCodigo());
                }

                String nombreEstado = "BORRADOR";
                SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);

                //Movimiento contable - documento contable
                SiiDocumentoContable unSiiDocumentoContable = new SiiDocumentoContable();
                SiiTipoDocContable unSiiTipoDocContable = tipoDocContableDao.buscarPorCodigo("TEA");
                Integer consecutivoTea = documentoContableDao.buscarConsecutivoDocumentoContable("TEA");
                unSiiDocumentoContable.setDcoNumeroCompr(consecutivoTea);
                Date fechaActualTea = new Date();
                unSiiDocumentoContable.setDcoFechaOper(fechaActualTea);
                unSiiDocumentoContable.setSiiTipoDocContable(unSiiTipoDocContable);
                unSiiDocumentoContable.setSiiTerminacionAnticip(siiTerminacionAnticip);
                unSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                unSiiDocumentoContable = documentoContableDao.insertarDocumentoContable(unSiiDocumentoContable);

                //Imputacion contable

                SiiPersona siiPersona = new SiiPersona();
                //buscar datos tercero
                if (unSiiContrato.getSiiOperador() != null) {
                    SiiOperador siiOperador =
                        operadorDao.buscarPorCodigoOperador(unSiiContrato.getSiiOperador().getOpeCodigo());
                    siiPersona = personaDao.buscarPersonaPorId(siiOperador.getSiiPersona().getPerCodigo());
                }
                List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont =
                    new ArrayList<SiiCuentaContTipoDocCont>();
                listaSiiCuentaContTipoDocCont =
                    cuentaContTipoDocContDao.buscarSiiCuentaContTipoDocContPorTipoDoc("TEA");

                for (SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont : listaSiiCuentaContTipoDocCont) {
                    SiiImputacionContable siiImputacionCont = new SiiImputacionContable();
                    siiImputacionCont.setSiiCuentasContables(unSiiCuentaContTipoDocCont.getSiiCuentasContables());
                    siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                    SiiCuentasContables siiCuentasContables =
                        cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                    //validaciones
                    if (siiCuentasContables.getCcoObligaTerc().equals("S"))
                        siiImputacionCont.setSiiPersona(siiPersona);
                    if (siiCuentasContables.getCcoNumDocConta().equals("S"))
                        siiImputacionCont.setSiiDocumentoContable(unSiiDocumentoContable);
                    if (siiCuentasContables.getCcoReferencia1().equals("S")) {
                        siiImputacionCont.setImcReferencia1(unSiiContrato.getConNumero());
                    }
                    siiImputacionCont.setImcDescrOperacion("TERMINACIÓN ANTICIPADA CONTRATO ");
                    if (unSiiCuentaContTipoDocCont.getCctConcepto().equals("DE"))
                        siiImputacionCont.setImcValor(temDE);
                    if (unSiiCuentaContTipoDocCont.getCctConcepto().equals("GA"))
                        siiImputacionCont.setImcValor(temGA);
                    siiImputacionCont.setImcEstado("A");
                    imputacionContableDao.insertarImputacionContable(siiImputacionCont);
                }


                //Actualiza cuotas posteriores
                List<SiiCuotaOperador> listSiiCuotaOperador =
                    cuotaOperadorDao.buscarCuotaOperadorXFecha(unSiiContrato.getConCodigo(),
                                                               siiTerminacionAnticip.getTanFechaAproTerAnt());

                for (SiiCuotaOperador unaSiiCuotaOperador : listSiiCuotaOperador) {
                    unaSiiCuotaOperador.setCopCancelada("I");
                    cuotaOperadorDao.actualizarCuotaOperador(unaSiiCuotaOperador);

                    if (unaSiiCuotaOperador.getSiiConceptoCuota().getCcuAbreviatura().equals("DE")) {

                        //Movimiento contable - documento contable reversión
                        SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();
                        SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("ACC");
                        Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("ACC");
                        insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
                        insertSiiDocumentoContable.setDcoFechaOper(fechaActual);
                        insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
                        insertSiiDocumentoContable.setSiiTerminacionAnticip(siiTerminacionAnticip);

                        insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
                        insertSiiDocumentoContable =
                            documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);

                        //Imputación contable reversión
                        List<SiiImputacionContable> ListSiiImputacionContable =
                            imputacionContableDao.buscarPorRef1Ref2ImputacionCont(unSiiContrato.getConNumero(),
                                                                                  unaSiiCuotaOperador.getCopNumCuota().toString());

                        for (SiiImputacionContable unaSiiImputacionContable : ListSiiImputacionContable) {
                            SiiImputacionContable reSiiImputacionContable = new SiiImputacionContable();
                            reSiiImputacionContable.setImcConcepto(unaSiiImputacionContable.getImcConcepto());
                            reSiiImputacionContable.setImcDescrOperacion("Reversión Cuota No. || " +
                                                                         unaSiiImputacionContable.getImcReferencia2());
                            reSiiImputacionContable.setSiiDocumentoContable(insertSiiDocumentoContable);
                            reSiiImputacionContable.setSiiCuentasContables(unaSiiImputacionContable.getSiiCuentasContables());
                            reSiiImputacionContable.setImcReferencia1(unaSiiImputacionContable.getImcReferencia1());
                            reSiiImputacionContable.setImcReferencia2(unaSiiImputacionContable.getImcReferencia2());
                            reSiiImputacionContable.setImcValor(unaSiiImputacionContable.getImcValor());
                            reSiiImputacionContable.setSiiPersona(unaSiiImputacionContable.getSiiPersona());
                            reSiiImputacionContable.setImcEstado("A");
                            if (unaSiiImputacionContable.getImcTipoMovim().equals("D"))
                                reSiiImputacionContable.setImcTipoMovim("C");
                            else
                                reSiiImputacionContable.setImcTipoMovim("D");

                            imputacionContableDao.insertarImputacionContable(reSiiImputacionContable);
                        }
                    }
                }
            }
            if (terminacionAnticipContVo.getEstadoTermAnticipVo().getEtaCodigo() !=
                terminacionAnticipContVo.getIdEstadoAnterior()) {
                adminLogCambioEstado.insertarLogCambioEstado(19L,
                                                             terminacionAnticipContVo.getEstadoTermAnticipVo().getEtaCodigo(),
                                                             usuarioLogueado, siiTerminacionAnticip.getTanCodigo());
            }
            return new TerminacionAnticipContVO(siiTerminacionAnticip);
        } catch (ExcepcionDAO ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    public List<TerminacionAnticipContVO> buscarTerminacionAnticipadaPorEstado(String estadoNombre) throws ExcepcionDAO {
        List<SiiTerminacionAnticip> listaTerminacionAnticipadaPorEstado =
            terminacionAnticipContDAO.buscarTerminacionAnticipadaPorEstado(estadoNombre);
        List<TerminacionAnticipContVO> listaTerminacionAnticipadaPorEstadoVo = new ArrayList();
        for (SiiTerminacionAnticip unaTerminacionAnticip : listaTerminacionAnticipadaPorEstado) {
            listaTerminacionAnticipadaPorEstadoVo.add(new TerminacionAnticipContVO(unaTerminacionAnticip));
        }
        return listaTerminacionAnticipadaPorEstadoVo;
    }

    /**
     * Buscar terminaciones anticipadas según Id de contrato
     * @param conCodigo
     * @return listaTerminacionAnticipadaPorEstadoVo - Lista de terminaciones anticipadas
     * @throws ExcepcionDAO
     */

    public List<TerminacionAnticipContVO> buscarTerminacionAnticipadaPorIdContrato(Long conCodigo) throws ExcepcionDAO {
        List<SiiTerminacionAnticip> listaTerminacionAnticipadaPorEstado =
            terminacionAnticipContDAO.buscarTerminacionAnticipadaPorIdContrato(conCodigo);
        List<TerminacionAnticipContVO> listaTerminacionAnticipadaPorEstadoVo = new ArrayList();
        for (SiiTerminacionAnticip unaTerminacionAnticip : listaTerminacionAnticipadaPorEstado) {
            listaTerminacionAnticipadaPorEstadoVo.add(new TerminacionAnticipContVO(unaTerminacionAnticip));
        }
        return listaTerminacionAnticipadaPorEstadoVo;
    }

    public List<TerminacionAnticipContVO> buscarTodasTerminacionAnticipada() throws ExcepcionDAO {
        List<SiiTerminacionAnticip> listaTerminacionAnticipadaPorEstado =
            terminacionAnticipContDAO.buscarTodoTerminacionAnticipada();
        List<TerminacionAnticipContVO> listaTerminacionAnticipadaPorEstadoVo = new ArrayList();
        for (SiiTerminacionAnticip unaTerminacionAnticip : listaTerminacionAnticipadaPorEstado) {
            listaTerminacionAnticipadaPorEstadoVo.add(new TerminacionAnticipContVO(unaTerminacionAnticip));
        }
        return listaTerminacionAnticipadaPorEstadoVo;
    }

    public int diasFestivosEntre(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO {
        return festivoDao.diasFestivosEntre(fechaInicial, fechaFinal);
    }
}

