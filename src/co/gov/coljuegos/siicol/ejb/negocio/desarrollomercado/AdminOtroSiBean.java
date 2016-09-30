package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoOtrosi;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoOtrosiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.GarantPolizaOficLiqDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NovedadDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficLiqTipoApuestaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioLiquidacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ResolucionAutorizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RevisionFinanOtroSiDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudAutorizaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNovedad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOtrosi;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.ResolucionAutorizVO;
import co.gov.coljuegos.siicol.ejb.vo.RevisFinancOtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminOtroSiBean implements AdminOtroSi {
    @EJB
    OtroSiDAO otroSiDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private NovedadDAO novedadDAO;
    @EJB
    private OficioLiquidacionDAO oficioLiquidacionDAO;
    @EJB
    private OficLiqTipoApuestaDAO oficLiqTipoApuestaDAO;
    @EJB
    private ResolucionAutorizDAO resolucionAutorizDAO;
    @EJB
    private EstadoSolicAutorizDAO estadoSolicAutorizDao;
    @EJB
    private SolicitudAutorizaDAO solicitudAutorizaDao;
    @EJB
    private RevisionFinanOtroSiDAO adminRevisFinanOtroSiDao;
    @EJB
    private NovedadDAO novedadDao;
    @EJB
    private GarantPolizaOficLiqDAO garantPolizaOficLiqDao;
    @EJB
    AdminInventario adminInventario;
    @EJB
    ContratoDAO contratoDao;
    @EJB
    EstadoOtrosiDAO estadoOtroSiDao;

    public OtroSiVO guardarOtroSi(OtroSiVO otroSiVo, UsuarioVO usuarioLogueado, boolean cambioEstado, SolicitudAutorizaVO solicitudAutorizaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        if(otroSiVo.getOsiConsecutivo() == null) {
            otroSiVo.setOsiConsecutivo(otroSiDao.siguienteNumeroOtroSi());
        }
        List<RevisFinancOtroSiVO> revisionesFinanVo = otroSiVo.getRevisFinancOtroSiListVo();
        if(EnumEstadoOtrosi.PERFECCIONADO.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            if(solicitudAutorizaVo.getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.PRORROGA_CONTRATO.getId())) {
                Calendar nuevaFechaFinal = new GregorianCalendar();
                nuevaFechaFinal.setTime(solicitudAutorizaVo.getUltimaNovedadVo().getContratoVO().getConFechaFinDefin() == null ? solicitudAutorizaVo.getUltimaNovedadVo().getContratoVO().getConFechaFin() : solicitudAutorizaVo.getUltimaNovedadVo().getContratoVO().getConFechaFinDefin());
                nuevaFechaFinal.add(Calendar.MONTH, solicitudAutorizaVo.getSauTiempoContr());
                otroSiVo.setOsiFechaFin(nuevaFechaFinal.getTime());
                // la fecha dada aqui será actualizada como fecha fin de contrato al aplicar el inventario.
            } else {
                otroSiVo.setOsiFechaFin(solicitudAutorizaVo.getUltimaNovedadVo().getContratoVO().getConFechaFinDefin());
            }
            /**
             * -        Si la solicitud es Tipo 90 Otras Novedades con Indicador de Ampliación = 2
             * o       Coloca el Otrosí en estado “LEGALIZADO”.
             * o       Coloca la solicitud de autorización en estado “OTROSÍ LEGALIZADO”.
             * De lo contrario:
             * o       Coloca el Otrosí en estado “PERFECCIONADO”.
             * o       Coloca la solicitud de autorización en estado “OTROSÍ PERFECCIONADO”.
             */
            if(solicitudAutorizaVo.getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.OTRAS_NOVEDADES.getId()) && solicitudAutorizaVo.getSauAmpliacion() == 2) {
                otroSiVo.setEstadoOtroSiVo(new EstadoOtroSiVO(estadoOtroSiDao.buscarPorCodigo(EnumEstadoOtrosi.LEGALIZADO.getId())));
            }
        }
        if(otroSiVo.getOsiCodigo() == null) {
            otroSiVo = new OtroSiVO(otroSiDao.insertarSiiOtroSi(conversionVoEntidad.convertir(otroSiVo)));
        }
        else {
            otroSiVo = new OtroSiVO(otroSiDao.actualizarSiiOtroSi(conversionVoEntidad.convertir(otroSiVo)));

        }

        for(NovedadVO nov : solicitudAutorizaVo.getNovedadListVo()) {

            nov.setOtroSiVo(otroSiVo);
            novedadDAO.actualizarSiiNovedad(conversionVoEntidad.convertir(nov));


        }
        if(cambioEstado) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.OTROSI_CONTRATO_CONCESION.getId(), otroSiVo.getEstadoOtroSiVo().getEosCodigo(), usuarioLogueado, otroSiVo.getOsiCodigo());
        }

        if(EnumEstadoOtrosi.PROYECTADO.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            EstadoSolicAutorizVO estadoVo = new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.OTROSI_EN_TRAMITE.getId()));
            solicitudAutorizaVo.setEstadoSolicAutoriz(estadoVo);
            solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));
        }

        if(EnumEstadoOtrosi.VALIDADO_FINANCIERA.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo()) || EnumEstadoOtrosi.NO_VALIDADO_FINANCIERA.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            for(RevisFinancOtroSiVO rev : revisionesFinanVo) {
                if("FIN".equals(rev.getRfoTipoValidac())) {
                    rev = guardarRevision(otroSiVo, rev);
                }

            }
        }

        if(EnumEstadoOtrosi.VALIDADO_GCT.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo()) || EnumEstadoOtrosi.NO_VALIDADO_GCT.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            for(RevisFinancOtroSiVO rev : revisionesFinanVo) {
                if("GCT".equals(rev.getRfoTipoValidac())) {
                    rev = guardarRevision(otroSiVo, rev);
                }

            }

        }

        if(EnumEstadoOtrosi.VALIDADO_CCA.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo()) || EnumEstadoOtrosi.NO_VALIDADO_CCA.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            for(RevisFinancOtroSiVO rev : revisionesFinanVo) {
                if("CCA".equals(rev.getRfoTipoValidac())) {
                    rev = guardarRevision(otroSiVo, rev);
                }

            }

        }

        if(EnumEstadoOtrosi.LEGALIZADO.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            /**
             * -        Si la solicitud es 90 Otras Novedades e Indicador de Ampliación = 2
             *          Coloca la solicitud de autorización en estado “OTROSÍ LEGALIZADO”.
             * o        Ejecuta el Flujo 9 – Actualizar inventario
             */
            if(solicitudAutorizaVo.getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.OTRAS_NOVEDADES.getId()) && solicitudAutorizaVo.getSauAmpliacion() == 2) {
                solicitudAutorizaVo.setEstadoSolicAutoriz( new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.OTROSI_LEGALIZADO.getId())));
                solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));                
                if (otroSiVo.getOsiFechaFin()!=null) {
                    otroSiVo.setOsiFechaFin(solicitudAutorizaVo.getUltimaNovedadVo().getContratoVO().getConFechaFinDefin());
                }
                adminInventario.actualizarInventarioXTipoSolicitudYTipoNovedad(otroSiVo, solicitudAutorizaVo, otroSiVo.getOsiFecha());                    
            } else {
                solicitudAutorizaVo.setEstadoSolicAutoriz(new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.OTROSI_EN_TRAMITE.getId())));
                solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));                
            }

        }


        if(EnumEstadoOtrosi.PERFECCIONADO.getId().equals(otroSiVo.getEstadoOtroSiVo().getEosCodigo())) {
            solicitudAutorizaVo.setEstadoSolicAutoriz(new EstadoSolicAutorizVO(estadoSolicAutorizDao.buscarEstadoSolicAutorizPorId(EnumEstadoSolicitudAutoriza.OTROSI_PERFECCIONADO.getId())));
            solicitudAutorizaDao.actualizarSiiSolicitudAutoriza(conversionVoEntidad.convertir(solicitudAutorizaVo));
            /**
             * -	Si la solicitud es Tipo 30 Prórroga contrato
             * o	Modifica la Fecha final definitiva del contrato agregando a la fecha final definitiva actual, la Duración en meses de la prórroga.
             * o	Ejecuta el Flujo 9 – Actualizar inventario
             */
            if(solicitudAutorizaVo.getTipoSolicAutorizaVo().getTsaCodigo().equals(EnumTipoSolicitudAutoriza.PRORROGA_CONTRATO.getId())) {
                adminInventario.actualizarInventarioXTipoSolicitudYTipoNovedad(otroSiVo, solicitudAutorizaVo, otroSiVo.getOsiFecha());

            }
        }

        otroSiVo.setRevisFinancOtroSiListVo(revisionesFinanVo);

        return otroSiVo;

    }

    private RevisFinancOtroSiVO guardarRevision(OtroSiVO otroSiVo, RevisFinancOtroSiVO rev) throws ExcepcionDAO {
        rev.setOtroSiVo(otroSiVo);
        if(rev.getRfoCodigo() == null) {
            rev = new RevisFinancOtroSiVO(adminRevisFinanOtroSiDao.insertar(conversionVoEntidad.convertir(rev)));
        }
        else {
            rev = new RevisFinancOtroSiVO(adminRevisFinanOtroSiDao.actualizar(conversionVoEntidad.convertir(rev)));


        }
        return rev;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<OtroSiVO> otrosiPerfeccionadosSinPolizasPendientes() throws ExcepcionDAO {
        List<OtroSiVO> otroSiVOs = new ArrayList<OtroSiVO>();
        List<SiiOtrosi> listaSiiOtrosi = otroSiDao.otrosiPerfeccionadosSinPolizasPendientes();
        for(SiiOtrosi siiOtrosi : listaSiiOtrosi) {
            //Buscamos los datos de Contrato y Solicitud Autorización
            List<SiiNovedad> listaSiiNovedad = novedadDao.buscarNovedadesPorIdOtrosi(siiOtrosi.getOsiCodigo());
            SiiNovedad siiNovedad = null;
            if(listaSiiNovedad != null && listaSiiNovedad.size() > 0) {
                if(listaSiiNovedad.get(0).getSiiSolicitudAutoriza().getSiiEstadoSolicAutoriz().getEsaCodigo() != EnumEstadoSolicitudAutoriza.OTROSI_PERFECCIONADO.getId()) {
                    continue;
                }
                siiNovedad = listaSiiNovedad.get(0);
            }
            OtroSiVO otroSiVo = new OtroSiVO(siiOtrosi);
            if(siiNovedad != null && siiNovedad.getSiiContrato() != null) {
                otroSiVo.setContratoVO(new ContratoVO(siiNovedad.getSiiContrato()));
            }
            if(siiNovedad != null && siiNovedad.getSiiSolicitudAutoriza() != null) {
                otroSiVo.setSolicitudAutorizaVO(new SolicitudAutorizaVO(siiNovedad.getSiiSolicitudAutoriza()));
            }
            otroSiVOs.add(otroSiVo);
        }

        return otroSiVOs;

    }

    /**
     * @author Giovanni
     * @param idOtrosi
     * @return
     */
    public OtroSiVO buscarOtrosiPolizaConcesion(Long idOtrosi) throws ExcepcionDAO {
        SiiOtrosi siiOtrosi = new SiiOtrosi();
        siiOtrosi = otroSiDao.buscarOtroSiPorId(idOtrosi);
        OtroSiVO otroSiVO = new OtroSiVO(siiOtrosi);

        //Novedad
        List<SiiNovedad> siiNovedads = new ArrayList<SiiNovedad>();
        siiNovedads = novedadDAO.buscarNovedadesPorIdOtrosi(idOtrosi);

        otroSiVO.setNovedadListVo(new ArrayList<NovedadVO>());
        for(SiiNovedad siiNovedad : siiNovedads) {
            if(siiNovedad.getSiiOtrosi() != null && siiNovedad.getSiiSolicitudAutoriza() != null) {
                NovedadVO novedadVO = new NovedadVO(siiNovedad);

                //Oficio Liquidacion
                List<SiiOficioLiquidacion> listaSiiOficioLiquidacion = new ArrayList<SiiOficioLiquidacion>();
                listaSiiOficioLiquidacion = oficioLiquidacionDAO.buscarOficioLiquidacionPorSolicitudAutorizacion(novedadVO.getSolicitudAutorizaVO().getSauCodigo());
                novedadVO.getSolicitudAutorizaVO().setOficioLiquidacionListVo(new ArrayList<OficioLiquidacionVO>());

                OficioLiquidacionVO oficioLiquidacionVO = new OficioLiquidacionVO(listaSiiOficioLiquidacion.get(listaSiiOficioLiquidacion.size() - 1));

                //oficio liquidacion tipo apuesta
                List<SiiOficLiqTipoApuesta> listSiiOficLiqTipoApuesta = new ArrayList<SiiOficLiqTipoApuesta>();
                listSiiOficLiqTipoApuesta = oficLiqTipoApuestaDAO.buscarSiiOficLiqTipoApuestaNuevoPorOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());

                oficioLiquidacionVO.setOficLiqTipoApuestaListVo(new ArrayList<OficLiqTipoApuestaVO>());
                if(listSiiOficLiqTipoApuesta != null) {
                    for(SiiOficLiqTipoApuesta siiOficLiqTipoApuesta : listSiiOficLiqTipoApuesta) {
                        OficLiqTipoApuestaVO oficLiqTipoApuestaVO = new OficLiqTipoApuestaVO(siiOficLiqTipoApuesta);
                        oficioLiquidacionVO.getOficLiqTipoApuestaListVo().add(oficLiqTipoApuestaVO);
                    }
                }

                //Garantia Poliza oficio de liquidacion
                oficioLiquidacionVO.setGarantPolizaOficLiqVOs(new ArrayList<GarantPolizaOficLiqVO>());
                List<SiiGarantPolizaOficLiq> listSiiGarantPolizaOficLiq = garantPolizaOficLiqDao.consultarGarantPolizaOficLiqXOficioLiquidacion(oficioLiquidacionVO.getOliCodigo());
                if(listSiiGarantPolizaOficLiq != null) {
                    for(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq : listSiiGarantPolizaOficLiq) {
                        GarantPolizaOficLiqVO garantPolizaOficLiqVo = new GarantPolizaOficLiqVO(siiGarantPolizaOficLiq);
                        oficioLiquidacionVO.getGarantPolizaOficLiqVOs().add(garantPolizaOficLiqVo);
                    }
                }

                novedadVO.getSolicitudAutorizaVO().getOficioLiquidacionListVo().add(oficioLiquidacionVO);

                //Resolucion de autorizacion
                List<SiiResolucionAutoriz> listSiiResolucionAutoriz = new ArrayList<SiiResolucionAutoriz>();
                listSiiResolucionAutoriz = resolucionAutorizDAO.buscarResolucionAutorizPorSolicitudAutoriza(novedadVO.getSolicitudAutorizaVO().getSauCodigo());
                novedadVO.getSolicitudAutorizaVO().setResolucionAutorizListVo(new ArrayList<ResolucionAutorizVO>());
                if(listSiiResolucionAutoriz != null) {
                    for(SiiResolucionAutoriz siiResolucionAutoriz : listSiiResolucionAutoriz) {
                        ResolucionAutorizVO resolucionAutorizVO = new ResolucionAutorizVO(siiResolucionAutoriz);
                        novedadVO.getSolicitudAutorizaVO().getResolucionAutorizListVo().add(resolucionAutorizVO);
                    }
                }
                otroSiVO.getNovedadListVo().add(novedadVO);
            }
        }

        return otroSiVO;
    }

    public List<OtroSiVO> buscarOtroSiPorIdContrato(Long conCodigo) throws ExcepcionDAO {
        List<OtroSiVO> listaOtroSiVo = new ArrayList<OtroSiVO>();
        for(SiiOtrosi otroSi : otroSiDao.buscarOtroSiPorIdContrato(conCodigo)) {
            if(otroSi == null) {
            }
            else {
                listaOtroSiVo.add(new OtroSiVO(otroSi));
            }
        }
        return listaOtroSiVo;
    }

}
