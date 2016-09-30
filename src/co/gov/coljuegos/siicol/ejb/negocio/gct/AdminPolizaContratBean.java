package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoPolizaContrato;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminInventario;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CuentasContablesDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRecaudoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoPolizaContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantiaPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficInfPolizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PolizaRequisitosPolDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestPolizaRenovacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPolizaCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficInfPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuestPolizaRenovac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficInfPolizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContratVO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaRequisitosPolVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestPolizaRenovacVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminPolizaContratBean implements AdminPolizaContrat {
    @EJB
    private GarantiaPolizaDAO garantiaPolizaDao;
    @EJB
    private PolizaContratDAO polizaContratDAO;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PolizaRequisitosPolDAO polizaRequisitosPolDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private InventarioDAO inventarioDao;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    private NovedadDAO novedadDao;
    @EJB
    private EstadoPolizaContDAO estadoPolizaContDao;
    @EJB
    private OficInfPolizaDAO oficInfPolizaDAO;
    @EJB
    private TipoDocContableDAO tipoDocContableDao;
    @EJB
    private DocumentoContableDAO documentoContableDao;
    @EJB
    private EstadoDocContabDAO estadoDocContabDao;
    @EJB
    private DetalleRecaudoDAO detalleRecaudoDao;
    @EJB
    private CuentasContablesDAO cuentasContablesDao;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private AdminInventario adminInventario;
    @EJB
    private OficInfPolizaDAO oficInfPolizaDao;
    @EJB
    private OtroSiDAO otroSiDao;
    @EJB
    private TipoApuestPolizaRenovacDAO tipoApuestPolizaRenovacDao;

    public AdminPolizaContratBean() {

    }


    /**
     * Guarda un historial de la poliza y genera un nuevo registro
     * @author Giovanni
     * @param polizaContratVO
     * @param usuarioLogin
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void guardarHistorialYNuevaPoliza(PolizaContratVO polizaContratVO, UsuarioVO usuarioLogin) throws ExcepcionDAO, ExcepcionAplicacion {
        //Guardamos la poliza nueva
        Long codPoliza = polizaContratVO.getPccCodigo();
        polizaContratVO.setPccCodigo(null);

        //Reseteamos los requisitos poliza de contrato
        for(PolizaRequisitosPolVO polizaRequisitosPolVO : polizaContratVO.getPolizaRequisitosPolVO()) {
            polizaRequisitosPolVO.setPrpCodigo(null);
        }

        //Reseteamos las garantias de la poliza de contrato
        for(GarantiaPolizaVO garantiaPolizaVO : polizaContratVO.getGarantiaPolizaListVO()) {
            garantiaPolizaVO.setGpoCodigo(null);
        }

        guardarPolizaContrat(polizaContratVO, usuarioLogin);

        //Actualizamos el estado de la anterior
        SiiPolizaContrat siiPolizaContrat = null;
        siiPolizaContrat = polizaContratDAO.buscarPolizaContratPorCodigo(codPoliza);

        //Estado
        SiiEstadoPolizaCont siiEstadoPolizaCont = estadoPolizaContDao.buscarEstadoPolizaContPorId(EnumEstadoPolizaContrato.INACTIVO.getId());
        siiPolizaContrat.setSiiEstadoPolizaCont(siiEstadoPolizaCont);

        PolizaContratVO polizaContratTempVO = new PolizaContratVO(siiPolizaContrat);
        actualizarPolizaContrat(polizaContratTempVO, usuarioLogin);
    }


    /**
     * @author Giovanni
     * @param polizaContratVO
     * @param usuarioLogin
     * @throws ExcepcionDAO
     */
    public void guardarPolizaContrat(PolizaContratVO polizaContratVO, UsuarioVO usuarioLogin) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        if(polizaContratVO.getPccCodigo() != null && polizaContratVO.getPccCodigo() > 0) {
            SiiPolizaContrat siiPolizaContratBd = polizaContratDAO.buscarPolizaContratPorCodigo(polizaContratVO.getPccCodigo());
            if(!siiPolizaContratBd.getSiiEstadoPolizaCont().getEpoCodigo().equals(polizaContratVO.getIdEstadoAnterior())) {
                throw new ExcepcionAplicacion("Error de concurrencia: El estado de la póliza fue cambiado durante la modificación. Seleccione nuevamente la póliza");
            }
        }

        SiiPolizaContrat siiPolizaContrat = conversionVoEntidad.convertir(polizaContratVO);


        polizaContratDAO.insertarPolizaContrat(siiPolizaContrat);

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if(polizaContratVO.getEstadoPolizaContVO().getEpoCodigo() != polizaContratVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.POLIZA_CONTRAT.getId(), polizaContratVO.getEstadoPolizaContVO().getEpoCodigo(), usuarioLogin,
                                                         siiPolizaContrat.getPccCodigo());
        }

        /*
         * Persistimos los requisitos poliza de contrato
         */
        for(PolizaRequisitosPolVO polizaRequisitosPolVO : polizaContratVO.getPolizaRequisitosPolVO()) {
            SiiPolizaRequisitosPol siiPolizaRequisitosPol = new SiiPolizaRequisitosPol();
            siiPolizaRequisitosPol = conversionVoEntidad.convertir(polizaRequisitosPolVO);
            siiPolizaRequisitosPol.setSiiPolizaContrat(siiPolizaContrat);
            polizaRequisitosPolDao.insertarPolizaRequisitosPol(siiPolizaRequisitosPol);
        }

        /*
         * Persistimos las garantias de la poliza de contrato
         */
        for(GarantiaPolizaVO garantiaPolizaVO : polizaContratVO.getGarantiaPolizaListVO()) {
            SiiGarantiaPoliza siiGarantiaPoliza = new SiiGarantiaPoliza();
            siiGarantiaPoliza = conversionVoEntidad.convertir(garantiaPolizaVO);
            siiGarantiaPoliza.setSiiPolizaContrat(siiPolizaContrat);
            garantiaPolizaDao.insertarGarantiaPoliza(siiGarantiaPoliza);
        }
        
        //Si existen Tipos de apuesta de renovación de póliza, los guardamos
        PolizaContratVO unaPolizaContratVo = new PolizaContratVO();
        unaPolizaContratVo.setPccCodigo(siiPolizaContrat.getPccCodigo());
        if(polizaContratVO.getTipoApuestPolizaRenovacListVo() != null && polizaContratVO.getTipoApuestPolizaRenovacListVo().size() > 0){
            for(TipoApuestPolizaRenovacVO tipoApuestPolizaRenovacVo : polizaContratVO.getTipoApuestPolizaRenovacListVo()){
                tipoApuestPolizaRenovacVo.setPolizaContratVo(unaPolizaContratVo);
                SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac = conversionVoEntidad.convertir(tipoApuestPolizaRenovacVo);
                tipoApuestPolizaRenovacDao.insertar(siiTipoApuestPolizaRenovac);
            }
        }

    }

    /**
     * @author Giovanni
     * @param polizaContratVO
     * @param usuarioLogin
     */
    public void actualizarPolizaContrat(PolizaContratVO polizaContratVO, UsuarioVO usuarioLogin) throws ExcepcionDAO, ExcepcionAplicacion {

        SiiSolicitudAutoriza siiSolicitudAutoriza = new SiiSolicitudAutoriza();
        SiiPolizaContrat siiPolizaContrat = conversionVoEntidad.convertir(polizaContratVO);

        //Registro del log de estados esto solo si el estado tuvo un cambio
        if (!polizaContratVO.getEstadoPolizaContVO().getEpoCodigo().equals(polizaContratVO.getIdEstadoAnterior())) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.POLIZA_CONTRAT.getId(), polizaContratVO.getEstadoPolizaContVO().getEpoCodigo(), usuarioLogin,
                                                         polizaContratVO.getPccCodigo());
        }

        //Agregamos los datos de informacion de la poliza
        if (polizaContratVO.getOficInfPolizaListVO() != null && !polizaContratVO.getOficInfPolizaListVO().isEmpty()) {
            for (OficInfPolizaVO oficInfPolizaVO : polizaContratVO.getOficInfPolizaListVO()) {
                oficInfPolizaVO.setPolizaContratVo(polizaContratVO);
                SiiOficInfPoliza siiOficInfPoliza = conversionVoEntidad.convertir(oficInfPolizaVO);
                oficInfPolizaDAO.insertarOficInfPoliza(siiOficInfPoliza);
            }
        }

        polizaContratDAO.actualizarPolizaContrat(siiPolizaContrat);

        if ("S".equals(polizaContratVO.getPccRenovacion())) {
            //Es renovación de póliza, no realiza más operaciones
            return;
        }

        if (polizaContratVO.getEstadoPolizaContVO().getEpoCodigo().equals(EnumEstadoPolizaContrato.APROBADO.getId())) {

            SiiContrato siiContrato = null;
            SiiOtrosi siiOtrosi = null;
            ContratoVO contratoVo = null;
            SolicitudAutorizaVO solicitudAutorizaVo = null;

            if ("S".equals(polizaContratVO.getPccContratoNue())) {
                //La póliza es de un contrato

                solicitudAutorizaVo = polizaContratVO.getContratoVO().getSolicitudAutorizaVo();

                //Actualizacion Contrato
                contratoVo = polizaContratVO.getContratoVO();
                actualizarContrato(siiContrato, contratoVo);

                //Registro del log de estados esto solo si el estado del contrato tuvo un cambio
                if (!contratoVo.getEstadoContratoVo().getEcoCodigo().equals(contratoVo.getIdEstadoAnterior())) {
                    adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(), polizaContratVO.getContratoVO().getEstadoContratoVo().getEcoCodigo(), usuarioLogin,
                                                                 polizaContratVO.getContratoVO().getConCodigo());
                }
            }
            else {
                //La póliza es para un otrosi polizaContratVO.getOtroSiVO() != null
                actualizarOtroSi(siiOtrosi, polizaContratVO.getOtroSiVO());
                solicitudAutorizaVo = polizaContratVO.getOtroSiVO().getSolicitudAutorizaVO();
            }

            //Actualizacion Solicitud de autorizacion
            siiSolicitudAutoriza = actualizacionSolicitudAutorizacion(polizaContratVO, usuarioLogin, siiSolicitudAutoriza, solicitudAutorizaVo);

            //Actualizacion Inventario
            actualizarInventario(polizaContratVO, solicitudAutorizaVo);
        }
        generarImputacionContable(polizaContratVO, siiSolicitudAutoriza, siiPolizaContrat);
    }

    private void actualizarContrato(SiiContrato siiContrato, ContratoVO contratoVo) throws ExcepcionDAO {
        siiContrato = conversionVoEntidad.convertir(contratoVo);
        contratoDao.actualizarSiiContrato(siiContrato);
    }
    
    private void actualizarOtroSi(SiiOtrosi siiOtrosi, OtroSiVO otroSiVo) throws ExcepcionDAO {
        siiOtrosi = conversionVoEntidad.convertir(otroSiVo);
        otroSiDao.actualizarSiiOtroSi(siiOtrosi);
    }

    private void actualizarInventario(PolizaContratVO polizaContratVO, SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO,
                                                                                                                       ExcepcionAplicacion {
        List<SiiNovedad> listaSiiNovedad = new ArrayList<SiiNovedad>();
        listaSiiNovedad = novedadDao.buscarNovedadPorSolicitudAutotiza(solicitudAutorizaVo.getSauCodigo());

        if("S".equals(polizaContratVO.getPccContratoNue())) {
            //Para contrato
            adminInventario.actualizarInventarioXTipoSolicitudYTipoNovedad(null, solicitudAutorizaVo, polizaContratVO.getPccFechaAprobac());
        }
        else {
            //Para Otrosi
            adminInventario.actualizarInventarioXTipoSolicitudYTipoNovedad(polizaContratVO.getOtroSiVO(), solicitudAutorizaVo, polizaContratVO.getPccFechaAprobac());
        }
    }

    private void activarInventario(PolizaContratVO polizaContratVO, List<SiiNovedad> listaSiiNovedad) throws ExcepcionDAO {
        for(SiiNovedad siiNovedad : listaSiiNovedad) {
            List<SiiInventario> listaSiiInventario = inventarioDao.buscarInventarioPorNovedad(siiNovedad.getNovCodigo());

            for(SiiInventario siiInventario : listaSiiInventario) {
                siiInventario.setInvFechaIniLiq(polizaContratVO.getContratoVO().getConFechaIni());
                siiInventario.setInvFechaFinLiq(polizaContratVO.getContratoVO().getConFechaFin());
                siiInventario.setInvEstado("A");
                inventarioDao.actualizarSiiInventario(siiInventario);
            }
        }
    }

    private void generarImputacionContable(PolizaContratVO polizaContratVO, SiiSolicitudAutoriza siiSolicitudAutoriza,
                                          SiiPolizaContrat siiPolizaContrat) throws ExcepcionDAO {
        //documento contable
        if( polizaContratVO.getContratoVO() != null && polizaContratVO.getContratoVO().getEstadoContratoVo().getEcoNombre().equals("LEGALIZADO")){            
                    
            SiiDocumentoContable insertSiiDocumentoContable = new SiiDocumentoContable();
            SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("OCC");
            Integer consecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("OCC");
            insertSiiDocumentoContable.setDcoNumeroCompr(consecutivo);
            insertSiiDocumentoContable.setDcoFechaOper(siiPolizaContrat.getPccFechaAprobac());
            insertSiiDocumentoContable.setSiiTipoDocContable(siiTipoDocContable);
            insertSiiDocumentoContable.setSiiPolizaContrat(siiPolizaContrat);
            String nombreEstado = "BORRADOR";
            SiiEstadoDocContab siiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nombreEstado);
            insertSiiDocumentoContable.setSiiEstadoDocContab(siiEstadoDocContab);
            insertSiiDocumentoContable = documentoContableDao.insertarDocumentoContable(insertSiiDocumentoContable);
    
            //imputacion contable Debito General
            
            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocCont = detalleRecaudoDao.BuscarCuentaContTipoDocContable(null, "OCC");
    
            for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont : listaSiiCuentaContTipoDocCont) {
                SiiImputacionContable siiImputacionCont = new SiiImputacionContable();
                siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                siiImputacionCont.setSiiCuentasContables(siiCuentasContables);
                //validaciones
                if(siiCuentasContables.getCcoObligaTerc().equals("S")) {
                    if (siiPolizaContrat.getSiiContrato()==null) {
                        siiImputacionCont.setSiiPersona(conversionVoEntidad.convertir(polizaContratVO.getOtroSiVO().getContratoVO().getOperadorVo().getPersonaVo()));
                    } else {
                        siiImputacionCont.setSiiPersona(siiPolizaContrat.getSiiContrato().getSiiOperador().getSiiPersona());                            
                    }
                }
                if(siiCuentasContables.getCcoNumDocConta().equals("S")) {
                    siiImputacionCont.setSiiDocumentoContable(insertSiiDocumentoContable);
                }
                if(siiCuentasContables.getCcoReferencia1().equals("S")) {
                    if (siiPolizaContrat.getSiiContrato()==null) {
                        siiImputacionCont.setImcReferencia1(polizaContratVO.getOtroSiVO().getContratoVO().getConNumero());
                    } else {
                        siiImputacionCont.setImcReferencia1(siiPolizaContrat.getSiiContrato().getConNumero());
                    }
                    
                }
                if(siiCuentasContables.getCcoReferencia2().equals("S")) {
                    siiImputacionCont.setImcReferencia2(String.valueOf(siiSolicitudAutoriza.getSiiResolucionAutorizList().get(0).getRauNumeroRes()));
                }
                siiImputacionCont.setImcDescrOperacion("OTORGAMIENTO CONTRATO DE CONCESIÓN OFICIO DE LIQUIDACIÓN No || " +
                                                       siiSolicitudAutoriza.getSiiOficioLiquidacionList().get(0).getOliConsecutivo());
                if(unSiiCuentaContTipoDocCont.getCctConcepto().equals("DE")) {
                    siiImputacionCont.setImcValor(siiSolicitudAutoriza.getSiiOficioLiquidacionList().get(0).getOliValorDerExpl());
                }
                if(unSiiCuentaContTipoDocCont.getCctConcepto().equals("GA")) {
                    siiImputacionCont.setImcValor(siiSolicitudAutoriza.getSiiOficioLiquidacionList().get(0).getOliValorGastAdm());
                }
                siiImputacionCont.setImcEstado("A");
                imputacionContableDao.insertarInputacionContable(siiImputacionCont);
            }
    
        }
        
        
        //imputación contable para poliza otro si
        if(polizaContratVO.getOtroSiVO()!= null && polizaContratVO.getOtroSiVO().getEstadoOtroSiVo().getEosNombre().equals("LEGALIZADO")) {
            PolizaContratVO unapolizaContratVo = new PolizaContratVO();
            unapolizaContratVo = polizaContratDAO.buscarValorImputacionPoliza(polizaContratVO.getPccCodigo());
        
            Date fechaRegistro = new Date();
            SiiDocumentoContable insertSiiDocContable = new SiiDocumentoContable();
            SiiTipoDocContable siiTipoDocContable = tipoDocContableDao.buscarPorCodigo("MCC");
            Integer unConsecutivo = documentoContableDao.buscarConsecutivoDocumentoContable("MCC");
            insertSiiDocContable.setDcoNumeroCompr(unConsecutivo);
            insertSiiDocContable.setDcoFechaOper(siiPolizaContrat.getPccFechaAprobac());
            insertSiiDocContable.setSiiTipoDocContable(siiTipoDocContable);
            insertSiiDocContable.setSiiPolizaContrat(siiPolizaContrat);
            String nomEstado = "BORRADOR";
            SiiEstadoDocContab unSiiEstadoDocContab = estadoDocContabDao.buscarEstadoDocContabXNombre(nomEstado);
            insertSiiDocContable.setSiiEstadoDocContab(unSiiEstadoDocContab);
            insertSiiDocContable = documentoContableDao.insertarDocumentoContable(insertSiiDocContable);

            //imputacion contable Debito General
            List<SiiCuentaContTipoDocCont> listaSiiCuentaContTipoDocContOtroSi = detalleRecaudoDao.BuscarCuentaContTipoDocContable(null, "MCC");

            for(SiiCuentaContTipoDocCont unSiiCuentaContTipoDocCont : listaSiiCuentaContTipoDocContOtroSi) {
                SiiImputacionContable siiImputacionCont = new SiiImputacionContable();
                SiiCuentasContables siiCuentasContables = cuentasContablesDao.buscarPorCodigo(unSiiCuentaContTipoDocCont.getSiiCuentasContables().getCcoCodigo());
                
                siiImputacionCont.setSiiCuentasContables(siiCuentasContables);
                //validaciones
                if(siiCuentasContables.getCcoObligaTerc().equals("S")) {
                    if (siiPolizaContrat.getSiiContrato()==null) {
                        siiImputacionCont.setSiiPersona(conversionVoEntidad.convertir(polizaContratVO.getOtroSiVO().getContratoVO().getOperadorVo().getPersonaVo()));
                    } 
                }
                if(siiCuentasContables.getCcoNumDocConta().equals("S")) {
                    siiImputacionCont.setSiiDocumentoContable(insertSiiDocContable);
                }
                if(siiCuentasContables.getCcoReferencia1().equals("S")) {
                    if (siiPolizaContrat.getSiiContrato()==null) {
                        siiImputacionCont.setImcReferencia1(polizaContratVO.getOtroSiVO().getContratoVO().getConNumero());
                    } 

                }
                if(siiCuentasContables.getCcoReferencia2().equals("S")) {
                    siiImputacionCont.setImcReferencia2(String.valueOf(siiSolicitudAutoriza.getSiiResolucionAutorizList().get(0).getRauNumeroRes()));
                }
                siiImputacionCont.setImcDescrOperacion("MODIFICACIÓN CONTRATO DE CONCESIÓN OFICIO DE LIQUIDACIÓN No || " +
                                                       siiSolicitudAutoriza.getSiiOficioLiquidacionList().get(0).getOliConsecutivo());
                
                if(unSiiCuentaContTipoDocCont.getCctConcepto().equals("DE")) {
                    siiImputacionCont.setImcValor(unapolizaContratVo.getValorDe());
                    if(unapolizaContratVo.getValorDe().compareTo(BigDecimal.ZERO) > 0)
                        siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                    else
                        if(unSiiCuentaContTipoDocCont.getCctTipoMovim().equals("D"))
                            siiImputacionCont.setImcTipoMovim("C");
                        else
                            siiImputacionCont.setImcTipoMovim("D");
                }
                if(unSiiCuentaContTipoDocCont.getCctConcepto().equals("GA")) {
                    siiImputacionCont.setImcValor(unapolizaContratVo.getValorGa());
                    if(unapolizaContratVo.getValorGa().compareTo(BigDecimal.ZERO) > 0)
                        siiImputacionCont.setImcTipoMovim(unSiiCuentaContTipoDocCont.getCctTipoMovim());
                    else
                        if(unSiiCuentaContTipoDocCont.getCctTipoMovim().equals("D"))
                            siiImputacionCont.setImcTipoMovim("C");
                        else
                            siiImputacionCont.setImcTipoMovim("D");
                }
                siiImputacionCont.setImcEstado("A");
                imputacionContableDao.insertarInputacionContable(siiImputacionCont);
            }
        }
    }

    private SiiSolicitudAutoriza actualizacionSolicitudAutorizacion(PolizaContratVO polizaContratVO, UsuarioVO usuarioLogin, SiiSolicitudAutoriza siiSolicitudAutoriza,
                                                                    SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO {
        siiSolicitudAutoriza = conversionVoEntidad.convertir(solicitudAutorizaVo);

        /*
         * Registro del log de estados esto solo si el estado de la solicitud tuvo un cambio
         */
        if(!solicitudAutorizaVo.getEstadoSolicAutoriz().getEsaCodigo().equals(solicitudAutorizaVo.getIdEstadoAnterior())) {
            if(polizaContratVO.getOtroSiVO() != null) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(),
                                                             polizaContratVO.getOtroSiVO().getSolicitudAutorizaVO().getEstadoSolicAutoriz().getEsaCodigo(), usuarioLogin,
                                                             polizaContratVO.getOtroSiVO().getSolicitudAutorizaVO().getSauCodigo());
            } else {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_AUTORIZA.getId(),
                                                             polizaContratVO.getContratoVO().getSolicitudAutorizaVo().getEstadoSolicAutoriz().getEsaCodigo(), usuarioLogin,
                                                             polizaContratVO.getContratoVO().getSolicitudAutorizaVo().getSauCodigo());
            }
            
        }

        solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(siiSolicitudAutoriza);
        return siiSolicitudAutoriza;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<PolizaContratVO> buscarPolizasContrat() throws ExcepcionDAO {
        List<PolizaContratVO> listaPolizaContratVo = new ArrayList<PolizaContratVO>();
        List<SiiPolizaContrat> listaSiiPolizaContratRenovacion = polizaContratDAO.buscarPolizasContrat();
        if(listaSiiPolizaContratRenovacion != null) {
            for(SiiPolizaContrat siiPolizaContrat : listaSiiPolizaContratRenovacion) {
                PolizaContratVO polizaContratVO = new PolizaContratVO(siiPolizaContrat);

                /*
                 * Verificamos la informacion de la poliza
                 */
                List<SiiOficInfPoliza> siiOficInfPolizas = oficInfPolizaDAO.buscarOficInfPolizaXPolizaConcesion(siiPolizaContrat.getPccCodigo());
                if(siiOficInfPolizas != null && !siiOficInfPolizas.isEmpty()) {
                    polizaContratVO.setOficInfPolizaListVO(new ArrayList<OficInfPolizaVO>());
                    for(SiiOficInfPoliza siiOficInfPoliza : siiOficInfPolizas) {
                        OficInfPolizaVO oficInfPolizaVO = new OficInfPolizaVO(siiOficInfPoliza);
                        polizaContratVO.getOficInfPolizaListVO().add(oficInfPolizaVO);
                    }
                }

                listaPolizaContratVo.add(polizaContratVO);
            }
        }
        return listaPolizaContratVo;
    }

    /**
     * @author El Gatopardo
     * @return
     * @throws ExcepcionDAO
     */
    public List<PolizaContratVO> buscarPolizasContratRenovacion() throws ExcepcionDAO {
        List<PolizaContratVO> listaPolizaContratVo = new ArrayList<PolizaContratVO>();
        List<SiiPolizaContrat> listaSiiPolizaContratRenovacion = polizaContratDAO.buscarPolizasContratRenovacion();
        if(listaSiiPolizaContratRenovacion != null) {
            for(SiiPolizaContrat siiPolizaContrat : listaSiiPolizaContratRenovacion) {
                PolizaContratVO polizaContratVO = new PolizaContratVO(siiPolizaContrat);

                /*
                 * Verificamos la informacion de la poliza
                 */
                List<SiiOficInfPoliza> siiOficInfPolizas = oficInfPolizaDAO.buscarOficInfPolizaXPolizaConcesion(siiPolizaContrat.getPccCodigo());
                if(siiOficInfPolizas != null && !siiOficInfPolizas.isEmpty()) {
                    polizaContratVO.setOficInfPolizaListVO(new ArrayList<OficInfPolizaVO>());
                    for(SiiOficInfPoliza siiOficInfPoliza : siiOficInfPolizas) {
                        OficInfPolizaVO oficInfPolizaVO = new OficInfPolizaVO(siiOficInfPoliza);
                        polizaContratVO.getOficInfPolizaListVO().add(oficInfPolizaVO);
                    }
                }

                listaPolizaContratVo.add(polizaContratVO);
            }
        }
        return listaPolizaContratVo;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<PolizaContratVO> buscarPolizasOtrosiConcesion() throws ExcepcionDAO {
        List<PolizaContratVO> polizaContratVOs = new ArrayList<PolizaContratVO>();
        List<SiiPolizaContrat> siiPolizaContrats = polizaContratDAO.buscarPolizasOtrosiConcesion();
        for(SiiPolizaContrat siiPolizaContrat : siiPolizaContrats) {
            PolizaContratVO polizaContratVO = new PolizaContratVO(siiPolizaContrat);
            polizaContratVOs.add(polizaContratVO);
        }
        return polizaContratVOs;
    }

    /**
     * @Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public PolizaContratVO buscarPolizasContratXIdCompleto(Long idPolizaContrato) throws ExcepcionDAO {
        SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
        siiPolizaContrat = polizaContratDAO.buscarPolizaContratPorCodigo(idPolizaContrato);

        PolizaContratVO polizaContratVO = new PolizaContratVO(siiPolizaContrat);

        /*
         * Buscar requisitos poliza contrato
         */
        List<SiiPolizaRequisitosPol> siiPolizaRequisitosPols = new ArrayList<SiiPolizaRequisitosPol>();
        siiPolizaRequisitosPols = polizaRequisitosPolDao.buscarPolizaRequisitosXPolizaCont(polizaContratVO.getPccCodigo());
        polizaContratVO.setPolizaRequisitosPolVO(new ArrayList<PolizaRequisitosPolVO>());
        for(SiiPolizaRequisitosPol siiPolizaRequisitosPol : siiPolizaRequisitosPols) {
            PolizaRequisitosPolVO polizaRequisitosPolVO = new PolizaRequisitosPolVO(siiPolizaRequisitosPol);
            polizaContratVO.getPolizaRequisitosPolVO().add(polizaRequisitosPolVO);
        }

        /*
         * Buscar garantías poliza de contrato
         */
        List<SiiGarantiaPoliza> siiGarantiaPolizas = new ArrayList<SiiGarantiaPoliza>();
        siiGarantiaPolizas = garantiaPolizaDao.buscarGarantiaPolizaPorPolizaContrat(polizaContratVO.getPccCodigo());
        polizaContratVO.setGarantiaPolizaListVO(new ArrayList<GarantiaPolizaVO>());
        for(SiiGarantiaPoliza siiGarantiaPoliza : siiGarantiaPolizas) {
            GarantiaPolizaVO garantiaPolizaVO = new GarantiaPolizaVO(siiGarantiaPoliza);
            polizaContratVO.getGarantiaPolizaListVO().add(garantiaPolizaVO);
        }
        
        List<SiiOficInfPoliza> siiOficInfPolizas = new ArrayList<SiiOficInfPoliza>();
        siiOficInfPolizas = oficInfPolizaDao.buscarOficInfPolizaXPolizaConcesion(polizaContratVO.getPccCodigo());
        polizaContratVO.setOficInfPolizaListVO(new ArrayList<OficInfPolizaVO>());
        for (SiiOficInfPoliza siiOficInfPoliza :siiOficInfPolizas ) {
            polizaContratVO.getOficInfPolizaListVO().add(new OficInfPolizaVO(siiOficInfPoliza));
        }

        return polizaContratVO;
    }


    public List<PolizaContratVO> buscarPolizasPorContrato(Long idContrato) throws ExcepcionDAO {
        List<PolizaContratVO> polizaContratVOs = new ArrayList<PolizaContratVO>();
        List<SiiPolizaContrat> siiPolizaContrats = polizaContratDAO.buscarPolizasPorContrato(idContrato);
        for(SiiPolizaContrat siiPolizaContrat : siiPolizaContrats) {
            PolizaContratVO polizaContratVO = new PolizaContratVO(siiPolizaContrat);
            polizaContratVOs.add(polizaContratVO);
        }
        return polizaContratVOs;
    }

}
