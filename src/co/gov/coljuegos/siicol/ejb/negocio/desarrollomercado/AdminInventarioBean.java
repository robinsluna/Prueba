package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoNovedad;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadInventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.TipoApuestaVO;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminInventarioBean implements AdminInventario {

    @EJB
    private InventarioDAO inventarioDao;
    @EJB
    private NovedadDAO novedadDAO;
    @EJB
    private ContratoDAO contratoDAO;
    @EJB
    private EstablecimientoDAO establecimientoDAO;
    @EJB
    private TipoApuestaDAO tipoApuestaDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;


    public AdminInventarioBean() {

    }

    public List<InventarioVO> buscarInventarioPorNumContrato(String numeroContrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioPorNumContrato(numeroContrato);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    public List<InventarioVO> consultaInventarioPorNitContrato(String nit, String numeroContrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.consultaInventarioPorNitContrato(nit, numeroContrato);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    public List<InventarioVO> buscarInventarioPorNovedad(Long codNovedad) throws ExcepcionDAO {
        List<InventarioVO> listaInventarioVo = new ArrayList<InventarioVO>();
        for(SiiInventario inv : inventarioDao.buscarInventarioPorNovedad(codNovedad)) {
            listaInventarioVo.add(new InventarioVO(inv));
        }
        return listaInventarioVo;
    }

    public List<NovedadInventarioVO> buscarInventarioContratoInicial(Long conCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        return inventarioDao.buscarInventarioContratoInicial(conCodigo);
    }

    public List<NovedadInventarioVO> buscarHistorialInvContrato(Long conCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        return inventarioDao.buscarHistorialInvContrato(conCodigo);
    }

    public List<InventarioVO> buscarInventarioPorNumOtroSi(Long consecutivoOtroSi) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioPorNumOtroSi(consecutivoOtroSi);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    /**
     * Metodo para la actualizacion del inventario por medio de una solicitud y sus novedades
     * @author Giovanni
     * @throws ExcepcionDAO
     * @param otroSiVO
     * @param solicitudAutorizaVO
     */
    public void actualizarInventarioXTipoSolicitudYTipoNovedad(OtroSiVO otroSiVO, SolicitudAutorizaVO solicitudAutorizaVO, Date fechaIniLiq) throws ExcepcionDAO, ExcepcionAplicacion {

        /*
         * Consultamos las novedades sea para poliza OtroSi o resolucion de autorizacion
         */
        List<SiiNovedad> siiNovedads = null;        
        Date fechaFinLiq;

        if(otroSiVO != null) {
            
            siiNovedads = novedadDAO.buscarNovedadesPorIdOtrosi(otroSiVO.getOsiCodigo());
            fechaFinLiq = fechaFinLiquidacionOtroSi(otroSiVO, siiNovedads);


        }
        else {
            siiNovedads = novedadDAO.buscarNovedadPorSolicitudAutotiza(solicitudAutorizaVO.getSauCodigo());
            fechaFinLiq =
                siiNovedads.get(0).getSiiContrato().getConFechaFinDefin() != null ? siiNovedads.get(0).getSiiContrato().getConFechaFinDefin() : siiNovedads.get(0).getSiiContrato().getConFechaFin();
        }

        Calendar f = Calendar.getInstance();
        f.setTime(fechaFinLiq);
        f.set(Calendar.HOUR, 23);
        f.set(Calendar.MINUTE, 59);
        f.set(Calendar.SECOND, 59);
        fechaFinLiq = f.getTime();

        fechaIniLiq = Utilidades.truncDate(fechaIniLiq);
        
        if (fechaIniLiq.after(fechaFinLiq)) {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            throw new ExcepcionAplicacion("Error: La fecha inicial "+dt.format(fechaIniLiq)+" es mayor que la fecha final "+dt.format(fechaFinLiq)+" de liquidación" );
        }
        
        if(siiNovedads != null && !siiNovedads.isEmpty()) {
            for(SiiNovedad siiNovedad : siiNovedads) {

                inventarioDao.inactivarInventarioPendiente(siiNovedad.getNovCodigo());

                actualizarInventarioPorProrroga(fechaFinLiq, siiNovedad);

                actualizarInventarioPorCreacionLocal(siiNovedad);

                actualizarInventarioPorAdicion(fechaFinLiq, fechaIniLiq, siiNovedad);

                actualizarInventarioPorRetiro(fechaIniLiq, siiNovedad);
                // se ajusta la actualizacion de traslados para contemplar el caso donde no hay sino resolucion por no haber modificacion del valor del contrato.
                // en este caso se usa la fecha de final del contrato como fecha final de los elementos adicionados en el traslado.
                actualizarInventarioPorTraslado(fechaFinLiq, fechaIniLiq, siiNovedad);

                actualizarInventarioPorReemplazo(fechaFinLiq, fechaIniLiq, siiNovedad);

                actualizarInventarioPorCambioApuesta(fechaFinLiq, fechaIniLiq, siiNovedad);

                actualizarInventarioPorCreacionLicenciaACDV(fechaFinLiq, fechaIniLiq, siiNovedad);

            }

            verificacionActualizacionInventario(solicitudAutorizaVO, siiNovedads);
        }
    }

    private Date fechaFinLiquidacionOtroSi(OtroSiVO otroSiVO, List<SiiNovedad> siiNovedads) {
        
        for (SiiNovedad novedad : siiNovedads) {
            if (EnumTipoNovedad.PRORROGA_CONTRATO.getId().equals(novedad.getSiiTipoNovedad().getTnoCodigo())) {
                if (otroSiVO.getOsiFechaFin() != null && novedad.getSiiContrato().getConFechaFinDefin() != null && otroSiVO.getOsiFechaFin().after(novedad.getSiiContrato().getConFechaFinDefin())) {
                    Calendar calFechaFinContrato = Calendar.getInstance();
                    calFechaFinContrato.setTime(otroSiVO.getContratoVO().getConFechaFinDefin());
                    calFechaFinContrato.add(Calendar.MONTH, otroSiVO.getSolicitudAutorizaVO().getSauTiempoContr());
                    otroSiVO.getContratoVO().setConFechaFinDefin(calFechaFinContrato.getTime());
                    return otroSiVO.getContratoVO().getConFechaFinDefin();
                }

            }
        }

        return siiNovedads.get(0).getSiiContrato().getConFechaFinDefin() != null ? siiNovedads.get(0).getSiiContrato().getConFechaFinDefin() : otroSiVO.getContratoVO().getConFechaFin();
    }

    /**
     * Metodo para la revisar cuantos registros del inventario quedan pendientes de actualizar para la lista de novedades de la solicitud
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion si quedan registros pendientes de aplicar
     * @param otroSiVO
     * @param solicitudAutorizaVO
     */
    private void verificacionActualizacionInventario(SolicitudAutorizaVO solicitudAutorizaVO, List<SiiNovedad> siiNovedads) throws ExcepcionDAO, ExcepcionAplicacion {
        Integer invPendiente = 0;

        for(SiiNovedad siiNovedad : siiNovedads) {
            invPendiente = inventarioDao.cantidadInventarioPendiente(siiNovedad.getNovCodigo());
        }
        if(invPendiente > 0) {
            throw new ExcepcionAplicacion("Error de Actualización de Inventario: No se pueden actualizar " + invPendiente +
                                          " registros de inventario con estado pendiente para las novedades asociadas a la solicitud codigo " + solicitudAutorizaVO.getSauCodigo());
        }
        List<SiiEstablecimiento> establecimientos = establecimientoDAO.buscarEstablecimientoXIdContrato(siiNovedads.get(0).getSiiContrato().getConCodigo());
        for(SiiEstablecimiento establecimiento : establecimientos) {
            List<SiiInventario> inv = inventarioDao.buscarInventarioActivoPorEstablecimiento(establecimiento.getEstCodigo());
            if(inv.size() == 0) {
                establecimiento.setEstEstado("I");
                establecimientoDAO.actualizarEstablecimiento(establecimiento);
            }
        }


    }

    private void actualizarInventarioPorCreacionLicenciaACDV(Date fechaFin, Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.CREACION_LICENCIA_ACDV.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PA
             */
            List<SiiInventario> siiInventarioPAs = null;
            siiInventarioPAs = inventarioDao.buscarInventarioPorNovedadEstadoPA(siiNovedad.getNovCodigo());
            if(siiInventarioPAs != null && !siiInventarioPAs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPAs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    siiInventario.setInvFechaIniLiq(fechaIniLiq);
                    siiInventario.setInvFechaFinLiq(fechaFin);
                    siiInventario.setInvEstado("A");
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }
        }
    }

    private void actualizarInventarioPorCambioApuesta(Date fechaFin, Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.CAMBIO_APUESTA.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PA
             */
            List<SiiInventario> siiInventarioPAs = null;
            siiInventarioPAs = inventarioDao.buscarInventarioPorNovedadEstadoPA(siiNovedad.getNovCodigo());
            if(siiInventarioPAs != null && !siiInventarioPAs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPAs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    siiInventario.setInvFechaIniLiq(fechaIniLiq);
                    siiInventario.setInvFechaFinLiq(fechaFin);
                    siiInventario.setInvEstado("A");
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }

            /*
             * Actualizamos el inventario en estado PR
             */
            List<SiiInventario> siiInventarioPRs = null;
            siiInventarioPRs = inventarioDao.buscarInventarioPorNovedadEstadoPR(siiNovedad.getNovCodigo());
            if(siiInventarioPRs != null && !siiInventarioPRs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPRs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    Calendar fechaFinLiq = Calendar.getInstance();
                    fechaFinLiq.setTime(fechaIniLiq);
                    fechaFinLiq.add(Calendar.SECOND, -1);

                    siiInventario.setInvFechaFinLiq(fechaFinLiq.getTime());
                    siiInventario.setInvEstado("R");
                    inventarioDao.actualizarSiiInventario(siiInventario);

                }
            }

        }
    }

    private void actualizarInventarioPorReemplazo(Date fechaFin, Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.REEMPLAZO_ELEMENTOS.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PA
             */
            List<SiiInventario> siiInventarioPAs = null;
            siiInventarioPAs = inventarioDao.buscarInventarioPorNovedadEstadoPA(siiNovedad.getNovCodigo());
            if(siiInventarioPAs != null && !siiInventarioPAs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPAs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    siiInventario.setInvFechaIniLiq(fechaIniLiq);
                    siiInventario.setInvFechaFinLiq(fechaFin);
                    siiInventario.setInvEstado("A");
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }

            /*
             * Actualizamos el inventario en estado PR
             */
            List<SiiInventario> siiInventarioPRs = null;
            siiInventarioPRs = inventarioDao.buscarInventarioPorNovedadEstadoPR(siiNovedad.getNovCodigo());
            if(siiInventarioPRs != null && !siiInventarioPRs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPRs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    Calendar fechaFinLiq = Calendar.getInstance();
                    fechaFinLiq.setTime(fechaIniLiq);
                    fechaFinLiq.add(Calendar.SECOND, -1);

                    siiInventario.setInvFechaFinLiq(fechaFinLiq.getTime());
                    siiInventario.setInvEstado("R");
                    inventarioDao.actualizarSiiInventario(siiInventario);

                }
            }
        }
    }

    private void actualizarInventarioPorTraslado(Date fechaFin, Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.TRASLADO_ELEMENTOS.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PA
             */
            List<SiiInventario> siiInventarioPAs = null;
            siiInventarioPAs = inventarioDao.buscarInventarioPorNovedadEstadoPA(siiNovedad.getNovCodigo());
            if(siiInventarioPAs != null && !siiInventarioPAs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPAs) {
                    /*
                         * Actualizar la fecha fin de cada uno de los elementos
                         */
                    siiInventario.setInvFechaIniLiq(fechaIniLiq);
                    siiInventario.setInvFechaFinLiq(fechaFin);
                    siiInventario.setInvEstado("A");
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }

            /*
             * Actualizamos el inventario en estado PR
             */
            List<SiiInventario> siiInventarioPRs = null;
            siiInventarioPRs = inventarioDao.buscarInventarioPorNovedadEstadoPR(siiNovedad.getNovCodigo());
            if(siiInventarioPRs != null && !siiInventarioPRs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPRs) {
                    /*
                         * Actualizar la fecha fin de cada uno de los elementos
                         */
                    Calendar fechaFinLiq = Calendar.getInstance();
                    fechaFinLiq.setTime(fechaIniLiq);
                    fechaFinLiq.add(Calendar.SECOND, -1);

                    System.out.println("fechas inv PR -> R: " + fechaIniLiq.toString() + ' ' + fechaFinLiq.getTime().toString());
                    siiInventario.setInvFechaFinLiq(fechaFinLiq.getTime());
                    siiInventario.setInvEstado("R");
                    System.out.println("fechas sii_inv PR -> R: " + siiInventario.getInvFechaIniLiq().toString() + ' ' + siiInventario.getInvFechaFinLiq().toString());
                    inventarioDao.actualizarSiiInventario(siiInventario);

                }
            }
        }
    }

    private void actualizarInventarioPorRetiro(Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.RETIRO_ELEMENTOS.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PR
             */
            List<SiiInventario> siiInventarioPRs = null;
            siiInventarioPRs = inventarioDao.buscarInventarioPorNovedadEstadoPR(siiNovedad.getNovCodigo());
            if(siiInventarioPRs != null && !siiInventarioPRs.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarioPRs) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    Calendar fechaFinLiq = Calendar.getInstance();
                    fechaFinLiq.setTime(fechaIniLiq);
                    fechaFinLiq.add(Calendar.SECOND, -1);

                    siiInventario.setInvFechaFinLiq(fechaFinLiq.getTime());
                    siiInventario.setInvEstado("R");
                    inventarioDao.actualizarSiiInventario(siiInventario);

                }
            }
        }
    }

    private void actualizarInventarioPorAdicion(Date fechaFin, Date fechaIniLiq, SiiNovedad siiNovedad) throws ExcepcionDAO {
        
        if(EnumTipoNovedad.ADICION_ELEMENTOS.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos el inventario en estado PA
             */
            List<SiiInventario> siiInventarios = null;
            siiInventarios = inventarioDao.buscarInventarioPorNovedadEstadoPA(siiNovedad.getNovCodigo());
            if(siiInventarios != null && !siiInventarios.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarios) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    siiInventario.setInvFechaIniLiq(fechaIniLiq);
                    siiInventario.setInvFechaFinLiq(fechaFin);                    
                    siiInventario.setInvEstado("A");
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }
        }
    }

    private void actualizarInventarioPorCreacionLocal(SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.CREACION_LOCAL.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            List<SiiEstablecimiento> siiEstablecimientos = null;
            siiEstablecimientos = establecimientoDAO.consultarEstablecimientosXNovedadEstadoPA(siiNovedad.getNovCodigo());

            if(siiEstablecimientos != null && !siiEstablecimientos.isEmpty()) {
                for(SiiEstablecimiento siiEstablecimiento : siiEstablecimientos) {

                    /*
                     * Cambio de estado del local
                     */
                    siiEstablecimiento.setEstEstado("A");
                    establecimientoDAO.actualizarPersona(siiEstablecimiento);
                }
            }
        }
    }

    private void actualizarInventarioPorProrroga(Date fechaFin, SiiNovedad siiNovedad) throws ExcepcionDAO {
        if(EnumTipoNovedad.PRORROGA_CONTRATO.getId().equals(siiNovedad.getSiiTipoNovedad().getTnoCodigo())) {

            /*
             * Actualizamos la fecha del contrato final definitiva
             */
            siiNovedad.getSiiContrato().setConFechaFinDefin(fechaFin);
            contratoDAO.actualizarSiiContrato(siiNovedad.getSiiContrato());

            /*
             * Actualizamos el inventario
             */
            List<SiiInventario> siiInventarios = null;
            siiInventarios = inventarioDao.buscarInventarioPorNumContratoActivo(siiNovedad.getSiiContrato().getConNumero());
            if(siiInventarios != null && !siiInventarios.isEmpty()) {
                for(SiiInventario siiInventario : siiInventarios) {

                    /*
                     * Actualizar la fecha fin de cada uno de los elementos
                     */
                    siiInventario.setInvFechaFinLiq(fechaFin);
                    inventarioDao.actualizarSiiInventario(siiInventario);
                }
            }
        }
    }

    @Override
    public List<InventarioVO> consultaInventarioPorContratoSiito(String numeroContrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioPorNumContrato(numeroContrato);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    public List<InventarioVO> consultaInventarioPorEstado(String estados) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarTodoElInventarioXEstado(estados);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    public List<SiiInventario> consultaSiiInventarioPorEstado(String estados) throws ExcepcionDAO {
        return inventarioDao.buscarTodoElInventarioXEstado(estados);
    }

    public List<SiiInventario> consultaSiiInventarioPorEstadoPorPeriodos(String estados, String fechaini, String fechafin) throws ExcepcionDAO {
        return inventarioDao.buscarTodoElInventarioXEstadoPorPeriodos(estados, fechaini, fechafin);
    }


    public InventarioVO buscarInventarioPorId(Long idCodigo) throws ExcepcionDAO {
        SiiInventario SiiIinventario = inventarioDao.buscarInventarioPorId(idCodigo);
        InventarioVO inventarioVo = new InventarioVO(SiiIinventario);
        return inventarioVo;
    }


    public List<InventarioVO> buscarInventarioActivoOPenRetiroPorEstContrato(Long estCodigo, String conNumero) throws ExcepcionDAO {
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioActivoOPenRetiroPorEstContrato(estCodigo, conNumero);
        for(SiiInventario inventario : listaInventario) {
            InventarioVO unInventarioVo = new InventarioVO(inventario);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(inventario.getSiiInstrumento().getTapCodigo());
            unInventarioVo.getInstrumentoVo().setTipoApuestaVo(new TipoApuestaVO(siiTipoApuesta));
            listaInventarioVO.add(unInventarioVo);

        }
        return listaInventarioVO;

    }

    public List<InventarioVO> buscarInventarioActivoPorEstContrato(Long estCodigo, String conNumero) throws ExcepcionDAO {
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioActivoPorEstContrato(estCodigo, conNumero);
        for(SiiInventario inventario : listaInventario) {
            InventarioVO unInventarioVo = new InventarioVO(inventario);
            SiiTipoApuesta siiTipoApuesta = tipoApuestaDao.buscarTipoApuestaPorCodigo(inventario.getSiiInstrumento().getTapCodigo());
            unInventarioVo.getInstrumentoVo().setTipoApuestaVo(new TipoApuestaVO(siiTipoApuesta));
            listaInventarioVO.add(unInventarioVo);

        }
        return listaInventarioVO;

    }


    public List<InventarioVO> buscarInventarioActivoPorContrato(String conNumero) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarInventarioActivoPorContrato(conNumero);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }

    public List<InventarioVO> buscarBingosPorCodigoDANE(String codigoDane, String contrato) throws ExcepcionDAO {
        List<SiiInventario> listaInventario = inventarioDao.buscarBingosPorCodigoDANE(codigoDane, contrato);
        List<InventarioVO> listaInventarioVO = new ArrayList<InventarioVO>();
        for(SiiInventario inventario : listaInventario) {
            listaInventarioVO.add(new InventarioVO(inventario));
        }
        return listaInventarioVO;
    }


    public String buscarJuegosAutorizadosPorNitOperador(String nit) throws ExcepcionDAO {
        return inventarioDao.buscarJuegosAutorizadosPorNitOperador(nit);
    }

    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO#buscarInventarioPorTipoApuesta(java.lang.Long)
     */
    @Override
    public List<InventarioVO> buscarInventarioPorTipoApuesta(Long tapCodigo) throws ExcepcionDAO {
        List<InventarioVO> resultado = null;
        List<SiiInventario> lista = inventarioDao.buscarInventarioPorTipoApuesta(tapCodigo);
        if(lista != null) {
            resultado = new ArrayList<InventarioVO>();
            for(SiiInventario siiInventario : lista) {
                if(siiInventario != null)
                    resultado.add(new InventarioVO(siiInventario));
            }
        }

        return (resultado);
    }


    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO#buscarInventarioPorContratoYTipoApuesta(java.lang.Long, java.lang.Long)
     */
    @Override
    public List<InventarioVO> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo) throws ExcepcionDAO {
        List<InventarioVO> resultado = null;
        List<SiiInventario> lista = inventarioDao.buscarInventarioPorContratoYTipoApuesta(conCodigo, tapCodigo);
        if(lista != null) {
            resultado = new ArrayList<InventarioVO>();
            for(SiiInventario siiInventario : lista) {
                if(siiInventario != null)
                    resultado.add(new InventarioVO(siiInventario));
            }
        }

        return (resultado);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.InventarioDAO#buscarInventarioPorContratoYTipoApuesta(java.lang.Long, java.lang.Long, java.lang.String)
     */
    @Override
    public List<InventarioVO> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo, String invEstado) throws ExcepcionDAO {
        List<InventarioVO> resultado = null;
        List<SiiInventario> lista = inventarioDao.buscarInventarioPorContratoYTipoApuesta(conCodigo, tapCodigo, invEstado);
        if(lista != null) {
            resultado = new ArrayList<InventarioVO>();
            for(SiiInventario siiInventario : lista) {
                if(siiInventario != null)
                    resultado.add(new InventarioVO(siiInventario));
            }
        }

        return (resultado);
    }

    
    
    @Override
    public InventarioVO insertarInventario(InventarioVO inventarioVo) throws ExcepcionDAO {
        InventarioVO resultado = null;
        SiiInventario siiInventario = inventarioDao.insertarSiiInventario(conversionVoEntidad.convertir(inventarioVo));
        if(siiInventario != null)
            resultado = new InventarioVO(siiInventario);

        return (resultado);
    }

    @Override
    public InventarioVO actualizarInventario(InventarioVO inventarioVo) throws ExcepcionDAO {
        InventarioVO resultado = null;
        SiiInventario siiInventario = inventarioDao.actualizarSiiInventario(conversionVoEntidad.convertir(inventarioVo));
        if(siiInventario != null)
            resultado = new InventarioVO(siiInventario);

        return (resultado);
    }
}
