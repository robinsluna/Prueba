package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado.AdminInventario;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecSuspensionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FestivoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SuspensionContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoNovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSuspensionContr;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstablecSuspensionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.SuspensionContrVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoNovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminSuspensionContrBean implements AdminSuspensionContr {
    @EJB
    SuspensionContrDAO suspensionContrDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private FestivoDAO festivoDao;
    @EJB
    private InventarioDAO inventarioDao;
    @EJB
    private ContratoDAO contratoDao;
    @EJB
    private EstadoContratoDAO estadoContratoDao;
    @EJB
    private NovedadDAO novedadDao;
    @EJB
    private TipoNovedadDAO tipoNovedadDao;
    @EJB
    private AdminInventario adminInventario;
    @EJB
    private EstablecSuspensionDAO establecSuspensionDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;


    public AdminSuspensionContrBean() {

    }

    public List<SuspensionContrVO> solicitudesSuspension() throws ExcepcionDAO {
        List<SuspensionContrVO> solicitudesSuspensionVo = new ArrayList<SuspensionContrVO>();
        for(SiiSuspensionContr suspension : suspensionContrDao.buscarTodaSuspension("ORDER BY o.scoCodigo DESC")) {

            SuspensionContrVO solicitudVo = new SuspensionContrVO(suspension);

            if(solicitudVo.getEstadoSuspensionContVo().getEscNombre().equals("SOLICITADO") && solicitudVo.getScoFechaRadica() != null) {
                int dias = diasEntreSemana(solicitudVo.getScoFechaRadica(), new Date()) - festivoDao.diasFestivosEntre(solicitudVo.getScoFechaRadica(), new Date());
                if(dias > 0) {
                    dias = dias - 1;
                }
                solicitudVo.setDiasHabiles(dias);
            }

            if(solicitudVo.getEstadoSuspensionContVo().getEscNombre().equals("RECHAZADO") && solicitudVo.getScoFechaRadRecha() != null) {
                int dias = diasEntreSemana(solicitudVo.getScoFechaRadRecha(), new Date()) - festivoDao.diasFestivosEntre(solicitudVo.getScoFechaRadRecha(), new Date());
                if(dias > 0) {
                    dias = dias - 1;
                }
                solicitudVo.setDiasHabiles(dias);
            }

            if(solicitudVo.getEstadoSuspensionContVo().getEscNombre().equals("REQUERIDO") && solicitudVo.getScoFechaRadica() != null) {
                Date fechaRequerimieto =
                    adminLogCambioEstado.buscarFechaLogCambioEstadoPorDocumentoEstado(EnumTipoDocColjuegos.SUSPENSION_CONTRATO_CONCESION.getId(),
                                                                                      solicitudVo.getEstadoSuspensionContVo().getEscCodigo(), solicitudVo.getScoCodigo());
                if(fechaRequerimieto == null) {
                    fechaRequerimieto = solicitudVo.getScoFechaRadica();
                }
                int dias = diasEntreSemana(solicitudVo.getScoFechaRadica(), new Date()) - festivoDao.diasFestivosEntre(solicitudVo.getScoFechaRadica(), new Date());
                if(dias > 0) {
                    dias = dias - 1;
                }
                solicitudVo.setDiasHabiles(dias);
            }

            if(solicitudVo.getEstadoSuspensionContVo().getEscNombre().equals("APROBADO") && solicitudVo.getScoFechaActaSusp() != null) {
                int dias = diasEntreSemana(solicitudVo.getScoFechaActaSusp(), new Date()) - festivoDao.diasFestivosEntre(solicitudVo.getScoFechaActaSusp(), new Date());
                if(dias > 0) {
                    dias = dias - 1;
                }
                solicitudVo.setDiasHabiles(dias);
            }

            if(solicitudVo.getEstadoSuspensionContVo().getEscNombre().equals("DESISTIDO") && solicitudVo.getScoFechaRadDesist() != null) {
                int dias = diasEntreSemana(solicitudVo.getScoFechaRadDesist(), new Date()) - festivoDao.diasFestivosEntre(solicitudVo.getScoFechaRadDesist(), new Date());
                if(dias > 0) {
                    dias = dias - 1;
                }
                solicitudVo.setDiasHabiles(dias);
            }

            solicitudesSuspensionVo.add(solicitudVo);
        }
        return solicitudesSuspensionVo;

    }

    private int diasEntreSemana(Date fechaInicial, Date fechaFinal) {
        Calendar calInicial = Calendar.getInstance();
        Calendar calFinal = Calendar.getInstance();
        calInicial.setTime(fechaInicial);
        calFinal.setTime(fechaFinal);
        int diasEntreSemana = 0;
        while(calInicial.before(calFinal)) {
            if((Calendar.SATURDAY != calInicial.get(Calendar.DAY_OF_WEEK)) && (Calendar.SUNDAY != calInicial.get(Calendar.DAY_OF_WEEK))) {
                diasEntreSemana++;
                calInicial.add(Calendar.DATE, 1);
            }
            else {
                calInicial.add(Calendar.DATE, 1);
            }
        }
        return diasEntreSemana;
    }


    public SuspensionContrVO insertarSolicitudSuspension(SuspensionContrVO suspensionContrVo, List<EstablecimientoVO> establecimientosSeleccionadosVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                                                                                                         ExcepcionAplicacion {
        SuspensionContrVO suspensionVo = new SuspensionContrVO(suspensionContrDao.insertar(conversionVoEntidad.convertir(suspensionContrVo)));
        suspensionVo.setEstablecSuspensionListVo(new ArrayList<EstablecSuspensionVO>());
        if(establecimientosSeleccionadosVo != null && establecimientosSeleccionadosVo.size() > 0 && suspensionContrVo.getScoTipo().equals("P")) {
            for(EstablecimientoVO establecimientoVo : establecimientosSeleccionadosVo) {
                EstablecSuspensionVO establecimientoSuspensionVo = new EstablecSuspensionVO();
                establecimientoSuspensionVo.setEstablecimientoVo(establecimientoVo);
                establecimientoSuspensionVo.setSuspensionContrVo(suspensionVo);
                establecimientoSuspensionVo = new EstablecSuspensionVO(establecSuspensionDao.insertar(conversionVoEntidad.convertir(establecimientoSuspensionVo)));
                suspensionVo.getEstablecSuspensionListVo().add(establecimientoSuspensionVo);
            }
        }
        else if((establecimientosSeleccionadosVo == null || establecimientosSeleccionadosVo.size() == 0) && suspensionContrVo.getScoTipo().equals("P")) {
            throw new ExcepcionAplicacion("La suspension parcial debe indicar los establecimientos a suspender");
        }
        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SUSPENSION_CONTRATO_CONCESION.getId(), suspensionContrVo.getEstadoSuspensionContVo().getEscCodigo(), usuarioLogueado,
                                                     suspensionContrVo.getScoCodigo());

        return suspensionVo;
    }


    public SuspensionContrVO actualizarSolicitudSuspension(SuspensionContrVO suspensionContrVo, UsuarioVO usuarioLogueado, boolean cambioEstado) throws ExcepcionDAO {
        if(cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SUSPENSION_CONTRATO_CONCESION.getId(), suspensionContrVo.getEstadoSuspensionContVo().getEscCodigo(), usuarioLogueado,
                                                         suspensionContrVo.getScoCodigo());
        }
        return new SuspensionContrVO(suspensionContrDao.actualizar(conversionVoEntidad.convertir(suspensionContrVo)));
    }

    /**
     * @param suspensionContrVo
     * @return
     * @throws ExcepcionDAO
     *
     */
    public SuspensionContrVO aprobarSolicitudSuspension(SuspensionContrVO suspensionContrVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO {

        actualizarInventario(suspensionContrVo);
        suspensionContrVo.getContratoVo().setEstadoContratoVo(new EstadoContratoVO(estadoContratoDao.buscarEstadoContratoPorNombre("SUSPENDIDO")));
        contratoDao.actualizarSiiContrato(conversionVoEntidad.convertir(suspensionContrVo.getContratoVo()));

        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.CONTRATO_CONCESION.getId(), suspensionContrVo.getContratoVo().getEstadoContratoVo().getEcoCodigo(), usuarioLogueado,
                                                     suspensionContrVo.getContratoVo().getConCodigo());
        adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SUSPENSION_CONTRATO_CONCESION.getId(), suspensionContrVo.getEstadoSuspensionContVo().getEscCodigo(), usuarioLogueado,
                                                     suspensionContrVo.getScoCodigo());

        return new SuspensionContrVO(suspensionContrDao.actualizar(conversionVoEntidad.convertir(suspensionContrVo)));
    }


    /**
     * @param suspensionContrVo
     * @throws ExcepcionDAO
     *
     * Actualiza el inventario, así:
     * o       Si el Tipo de suspensión es Total, toma todos los elementos del contrato que se encuentren en estado A: Activo.
     * Si el Tipo de suspensión es Parcial, toma todos los elementos de los establecimientos relacionados en la Solicitud de suspensión.
     * o       Para cada uno de los elementos seleccionados en el punto anterior realiza lo siguiente:
     * ?       Hace dos copias del registro con idéntica información.
     * ?       Coloca el primer registro en estado I: Inactivo.
     * ?       En el segundo registro coloca la fecha del día anterior a la fecha inicial de la suspensión en Fecha final de liquidación.
     * ?       En el tercer registro realiza lo siguiente:
     * ?       Coloca la fecha siguiente a la fecha final de la suspensión en Fecha inicial de liquidación.
     * ?       Si el Indicador Modifica fecha final es SI, coloca la Fecha final definitiva del contrato en Fecha final de liquidación.
     * ?       Coloca el contrato en estado SUSPENDIDO.
     */

    private void actualizarInventario(SuspensionContrVO suspensionContrVo) throws ExcepcionDAO {
        List<InventarioVO> listaInventario = new ArrayList<InventarioVO>();
        List<InventarioVO> listaInventarioCopia1 = new ArrayList<InventarioVO>();
        List<InventarioVO> listaInventarioCopia2 = new ArrayList<InventarioVO>();
        if(suspensionContrVo.getScoTipo().equals("T")) {
            // Si el Tipo de suspensión es Total, toma todos los elementos del contrato que se encuentren en estado A: Activo.
            listaInventario = adminInventario.buscarInventarioActivoPorContrato(suspensionContrVo.getContratoVo().getConNumero());

        }
        else if(suspensionContrVo.getScoTipo().equals("P")) {
            //Si el Tipo de suspensión es Parcial, toma todos los elementos de los establecimientos relacionados en la Solicitud de suspensión.
            for(EstablecSuspensionVO establecimientoVo : suspensionContrVo.getEstablecSuspensionListVo()) {
                for(SiiInventario inventario :
                    inventarioDao.buscarInventarioActivoPorEstablecimientoContrato(establecimientoVo.getEstablecimientoVo().getEstCodigo(), suspensionContrVo.getContratoVo().getConNumero())) {
                    listaInventario.add(new InventarioVO(inventario));
                }
            }
        }

        listaInventarioCopia1 = new ArrayList<InventarioVO>(listaInventario.size());
        listaInventarioCopia2 = new ArrayList<InventarioVO>(listaInventario.size());

        for(InventarioVO inventario : listaInventario) {
            inventario.setInvEstado("I");
            inventarioDao.actualizarSiiInventario(conversionVoEntidad.convertir(inventario));
        }

        for(InventarioVO inv : listaInventario) {
            inv.setInvCodigo(null);
            inv.setInvEstado("A");
            listaInventarioCopia1.add(new InventarioVO(conversionVoEntidad.convertir(inv)));
            listaInventarioCopia2.add(new InventarioVO(conversionVoEntidad.convertir(inv)));
        }

        //En el segundo registro coloca la fecha del día anterior a la fecha inicial de la suspensión en Fecha final de liquidación.
        Calendar fechaFinalLiquidacion_reg2 = Calendar.getInstance();
        fechaFinalLiquidacion_reg2.setTime((suspensionContrVo.getScoFechaIniSusAct()));
        fechaFinalLiquidacion_reg2.add(Calendar.DATE, -1);

        //En el tercer registro coloca la fecha siguiente a la fecha final de la suspensión en Fecha inicial de liquidación.
        Calendar fechaInicialLiquidacion_reg3 = Calendar.getInstance();
        fechaInicialLiquidacion_reg3.setTime((suspensionContrVo.getScoFechaFinSusp()));
        fechaInicialLiquidacion_reg3.add(Calendar.DATE, +1);

        TipoNovedadVO tipoNovedadVo = new TipoNovedadVO(tipoNovedadDao.buscarPorNombre("SUSPENSIÓN CONTRATO"));
        NovedadVO novedadVo = new NovedadVO();
        novedadVo.setNovFecha(fechaInicialLiquidacion_reg3.getTime());
        novedadVo.setContratoVO(suspensionContrVo.getContratoVo());
        novedadVo.setTipoNovedad(tipoNovedadVo);
        novedadVo.setSolicitudAutorizaVO(null);
        novedadVo.setOtroSiVo(null);

        novedadVo = new NovedadVO(novedadDao.insertarSiiNovedad(conversionVoEntidad.convertir(novedadVo)));

        //Si el Indicador Modifica fecha final es SI, coloca la Fecha final definitiva del contrato en Fecha final de liquidación.
        if("S".equals(suspensionContrVo.getScoModificaFecFin())) {
            suspensionContrVo.getContratoVo().setConFechaFinDefin(suspensionContrVo.getScoFechaFinDefCon());
            contratoDao.actualizarSiiContrato(conversionVoEntidad.convertir(suspensionContrVo.getContratoVo()));
        }

        for(InventarioVO inventario : listaInventarioCopia1) {
            inventario.setInvFechaFinLiq(fechaFinalLiquidacion_reg2.getTime());
            inventario.setNovedadVo(novedadVo);
            inventarioDao.insertarSiiInventario(conversionVoEntidad.convertir(inventario));
        }


        for(InventarioVO inventario : listaInventarioCopia2) {
            inventario.setInvFechaIniLiq(fechaInicialLiquidacion_reg3.getTime());
            if("S".equals(suspensionContrVo.getScoModificaFecFin())) {
                inventario.setInvFechaFinLiq(suspensionContrVo.getContratoVo().getConFechaFinDefin());
            }
            inventario.setNovedadVo(novedadVo);
            inventarioDao.insertarSiiInventario(conversionVoEntidad.convertir(inventario));
        }
    }

    public SuspensionContrVO modificarTermino(SuspensionContrVO suspensionContrVo) throws ExcepcionDAO {

        actualizarTerminoInventario(suspensionContrVo);
        return new SuspensionContrVO(suspensionContrDao.actualizar(conversionVoEntidad.convertir(suspensionContrVo)));
    }

    private void actualizarTerminoInventario(SuspensionContrVO suspensionContrVo) throws ExcepcionDAO {
        List<InventarioVO> listaInventario = new ArrayList<InventarioVO>();
        if(suspensionContrVo.getScoTipo().equals("T")) {
            // Si el Tipo de suspensión es Total, toma todos los elementos del contrato que se encuentren en estado A: Activo.
            listaInventario = adminInventario.buscarInventarioActivoPorContrato(suspensionContrVo.getContratoVo().getConNumero());

        }
        else if(suspensionContrVo.getScoTipo().equals("P")) {
            //Si el Tipo de suspensión es Parcial, toma todos los elementos de los establecimientos relacionados en la Solicitud de suspensión.
            for(EstablecSuspensionVO establecimientoVo : suspensionContrVo.getEstablecSuspensionListVo()) {
                for(SiiInventario inventario :
                    inventarioDao.buscarInventarioActivoPorEstablecimientoContrato(establecimientoVo.getEstablecimientoVo().getEstCodigo(), suspensionContrVo.getContratoVo().getConNumero())) {
                    listaInventario.add(new InventarioVO(inventario));
                }
            }
        }

        Calendar fechaInicialLiquidacion = Calendar.getInstance();
        fechaInicialLiquidacion.setTime((suspensionContrVo.getScoFechaFinSusp()));
        fechaInicialLiquidacion.add(Calendar.DATE, +1);

        TipoNovedadVO tipoNovedadVo = new TipoNovedadVO(tipoNovedadDao.buscarPorNombre("TERMINACIÓN SUSPENSION CONTRATO"));
        NovedadVO novedadVo = new NovedadVO();
        novedadVo.setNovFecha(fechaInicialLiquidacion.getTime());
        novedadVo.setContratoVO(suspensionContrVo.getContratoVo());
        novedadVo.setTipoNovedad(tipoNovedadVo);
        novedadVo.setSolicitudAutorizaVO(null);
        novedadVo.setOtroSiVo(null);

        novedadVo = new NovedadVO(novedadDao.insertarSiiNovedad(conversionVoEntidad.convertir(novedadVo)));

        for(InventarioVO inv : listaInventario) {
            if(inv.getInvFechaIniLiq().equals(fechaInicialLiquidacion)) {
                InventarioVO copiaInv = new InventarioVO(conversionVoEntidad.convertir(inv));
                inv.setInvEstado("I");
                inventarioDao.actualizarSiiInventario(conversionVoEntidad.convertir(inv));
                copiaInv.setInvFechaIniLiq(suspensionContrVo.getScoFechaReanuda());
                copiaInv.setNovedadVo(novedadVo);
                if("S".equals(suspensionContrVo.getScoModificaFecFin())) {
                    copiaInv.setInvFechaFinLiq(suspensionContrVo.getContratoVo().getConFechaFinDefin());
                }
                inventarioDao.insertarSiiInventario(conversionVoEntidad.convertir(copiaInv));
            }

        }

    }
}
