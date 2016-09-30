package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DistribucionPfcDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoSolicPfcmDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificPfcAnualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ObligacionPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicPfcmDetalleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPFCMenDetalleRDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPfcMensualDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPfcAnual;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolPfcMensDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DistribucionPfcVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPfcmVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPfcAnualVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetallePFCMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicPfcmDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPFCMenDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPfcMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminSolicitudPFCMensualBean implements AdminSolicitudPFCMensual {

    @Resource
    SessionContext sessionContext;

    @EJB
    private SolicitudPfcMensualDAO solicitudPfcMensualDao;
    @EJB
    private SolicPfcmDetalleDAO solicPfcmDetalleDao;
    @EJB
    private DistribucionPfcDAO distibucionPfcDao;
    @EJB
    private ObligacionPagoDAO obligacionPagoDao;
    @EJB
    private ModificPfcAnualDAO modificPfcAnualDao;
    @EJB
    private EstadoSolicPfcmDAO estadoSolicPfcmDao;
    @EJB
    private SolicitudPFCMenDetalleRDAO solicitudPFCMenDetalleRDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public AdminSolicitudPFCMensualBean() {

    }

    public List<SolicitudPfcMensualVO> buscarTodaSolicitudPfcm() throws ExcepcionDAO {
        List<SiiSolicitudPfcMens> listaSiiSolicitudPfcMens = solicitudPfcMensualDao.buscarTodaSolicitudPfcm();
        List<SolicitudPfcMensualVO> listaSiiSolicitudPfcMensVo = new ArrayList();
        for (SiiSolicitudPfcMens unaSolicitudPfcMens : listaSiiSolicitudPfcMens) {
            SolicitudPfcMensualVO nuevaObliDetRubroCdpVo = new SolicitudPfcMensualVO(unaSolicitudPfcMens);
            listaSiiSolicitudPfcMensVo.add(nuevaObliDetRubroCdpVo);
        }
        return listaSiiSolicitudPfcMensVo;
    }

    public SolicitudPfcMensualVO buscarSolicitudPfcMensPorId(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {
        SiiSolicitudPfcMens siiSolicitudPfcMens =
            solicitudPfcMensualDao.buscarSolicitudPfcMensPorId(solicitudPfcMensualVo.getSpfCodigo());
        return new SolicitudPfcMensualVO(siiSolicitudPfcMens);

    }

    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObli(RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO {

        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetPFCMensualVo =
            new ArrayList<RubroFuenteDetallePFCMensualVO>();
        List<RubroFuenteDetallePFCMensualVO> listaRetornoVo = new ArrayList<RubroFuenteDetallePFCMensualVO>();
        DistribucionPfcVO distribucionPfcVo = new DistribucionPfcVO();
        //listado rubros con valor aprobado
        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetPFCMenVo =
            solicitudPfcMensualDao.buscarListaFuenteDetallefuenteXObli(rubroFuenteDetPFCMensualVo);

        for (RubroFuenteDetallePFCMensualVO unRubroDetalle : listaRubroFuenteDetPFCMenVo) {

            List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetPFCMenTotalVo =
                obligacionPagoDao.buscarObligacionXIdDetalleRubroCdp(unRubroDetalle.getCodigoDetalleRubro(),
                                                                     rubroFuenteDetPFCMensualVo.getMes().longValue());

            //calcula el pfc anual
            RubroFuenteDetallePFCMensualVO unRubroFDPfcMensualVo = new RubroFuenteDetallePFCMensualVO();
            BigDecimal tempValorMes = new BigDecimal(0);
            BigDecimal tempValoraPagar = new BigDecimal(0);
            BigDecimal valorAnticipo = new BigDecimal(0);
            BigDecimal valorAplazamiento = new BigDecimal(0);
            BigDecimal ValorSobrante = new BigDecimal(0);

            if (listaRubroFuenteDetPFCMenTotalVo.size() > 0) {
                for (RubroFuenteDetalleFuenteRpVO unRubroFuenteDetFuenteRpVo : listaRubroFuenteDetPFCMenTotalVo) {
                    tempValorMes = unRubroFuenteDetFuenteRpVo.getRfdValoraPagar().add(tempValorMes);
                }
                unRubroFDPfcMensualVo.setDpfValorPFCAnual(unRubroDetalle.getDpfValorPFCAnual());
                unRubroFDPfcMensualVo.setDpfValorPFCMensual(tempValorMes);


                //sobrante anterior


                //valor anticipo
                //valorAnticipo=tempValorMes.subtract(unRubroDetalle.getDpfValorPFCAnual().add(sobrante anterior));


                //ValorSobrante=unRubroDetalle.getDpfValorPFCAnual()+
                tempValoraPagar = unRubroDetalle.getDpfValorPFCAnual().subtract(tempValorMes);
                //valor anticipo Sobrante anterior =  Valor aprobado en el PFC anual + Aplazamientos – Anticipos - Suma del valor del rubro en las Ordenes de pago en estado
                //“PAGADO” correspondientes al mes anterior al que se está solicitando y lo guarda en Sobrante anterior del rubro en el PFC anual.
                BigDecimal tempAnti = new BigDecimal(-1);
                if (tempValoraPagar.compareTo(BigDecimal.ZERO) < 0) {
                    tempValoraPagar = tempValoraPagar.multiply(tempAnti);
                    unRubroFDPfcMensualVo.setDpfValorAnticipo(tempValoraPagar);
                } else {
                    unRubroFDPfcMensualVo.setDpfValoraplazamiento(tempValoraPagar);
                }

                unRubroFDPfcMensualVo.setCadena(unRubroDetalle.getCadena());

                unRubroFDPfcMensualVo.setCodigoDetalleRubro(unRubroDetalle.getCodigoDetalleRubro());
            }
            if (unRubroFDPfcMensualVo.getCodigoDetalleRubro() != null)
                listaRetornoVo.add(unRubroFDPfcMensualVo);
        }
        return listaRetornoVo;

    }


    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObliNacion(RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO {

        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetPFCMensualVo =
            new ArrayList<RubroFuenteDetallePFCMensualVO>();
        List<RubroFuenteDetallePFCMensualVO> listaRetornoVo = new ArrayList<RubroFuenteDetallePFCMensualVO>();
        DistribucionPfcVO distribucionPfcVo = new DistribucionPfcVO();

        List<RubroFuenteDetallePFCMensualVO> listaRubroFuenteDetPFCMenVo =
            solicitudPfcMensualDao.buscarListaFuenteDetallefuenteXObli(rubroFuenteDetPFCMensualVo);

        for (RubroFuenteDetallePFCMensualVO unRubroDetalle : listaRubroFuenteDetPFCMenVo) {

            List<RubroFuenteDetalleFuenteRpVO> listaRubroFuenteDetPFCMenTotalVo =
                obligacionPagoDao.buscarObligacionXIdDetalleRubroCdp(unRubroDetalle.getCodigoDetalleRubro(),
                                                                     rubroFuenteDetPFCMensualVo.getMes().longValue());

            RubroFuenteDetallePFCMensualVO unRubroFDPfcMensualVo = new RubroFuenteDetallePFCMensualVO();
            BigDecimal tempValorMes = new BigDecimal(0);
            BigDecimal tempValoraPagar = new BigDecimal(0);
            BigDecimal valorAnticipo = new BigDecimal(0);
            BigDecimal valorAplzamiento = new BigDecimal(0);

            if (listaRubroFuenteDetPFCMenTotalVo.size() > 0) {
                for (RubroFuenteDetalleFuenteRpVO unRubroFuenteDetFuenteRpVo : listaRubroFuenteDetPFCMenTotalVo) {
                    tempValorMes = unRubroFuenteDetFuenteRpVo.getRfdValoraPagar().add(tempValorMes);
                }
                tempValoraPagar = unRubroDetalle.getDpfValorPFCAnual().subtract(tempValorMes);
                //valor anticipo
                BigDecimal tempAnti = new BigDecimal(-1);
                if (tempValoraPagar.compareTo(BigDecimal.ZERO) < 0) {
                    tempValoraPagar = tempValoraPagar.multiply(tempAnti);
                    unRubroFDPfcMensualVo.setDpfValorAnticipo(tempValoraPagar);
                }
                /* //valor aplazamiento
                if(tempValoraPagar.compareTo(BigDecimal.ZERO) > 0)
                    unRubroFDPfcMensualVo.setDpfValoraplazamiento(tempValoraPagar);*/
                unRubroFDPfcMensualVo.setDpfValorPFCAnual(unRubroDetalle.getDpfValorPFCAnual());
                unRubroFDPfcMensualVo.setCadena(unRubroDetalle.getCadena());
                unRubroFDPfcMensualVo.setDpfValorPFCMensual(tempValorMes);
                unRubroFDPfcMensualVo.setCodigoDetalleRubro(unRubroDetalle.getCodigoDetalleRubro());
            }
            if (unRubroFDPfcMensualVo.getCodigoDetalleRubro() != null)
                listaRetornoVo.add(unRubroFDPfcMensualVo);
        }
        return listaRetornoVo;

    }

    public SolicitudPfcMensualVO insertarSolicPfcm(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {
        SolicitudPfcMensualVO unSolicitudPfcMensualVo = new SolicitudPfcMensualVO();

        SiiSolicitudPfcMens siiSolicitudPfcMens = conversionVoEntidad.convertir(solicitudPfcMensualVo);
        SiiSolicitudPfcMens siiSolicitudPfcMensResultado =
            solicitudPfcMensualDao.insertarSolicPfcm(siiSolicitudPfcMens);
        //unSolicitudPfcMensualVo.setSpfCodigo(siiSolicitudPfcMensResultado.getSpfCodigo());
        List<SolicPfcmDetalleVO> listaSolicPfcmDetalleVo = solicitudPfcMensualVo.getSolicPfcmDetalleVo();
        List<SolicitudPFCMenDetalleVO> listaSolicitudPfcMensualVo =
            solicitudPfcMensualVo.getListSolicitudPFCMenDetalleVo();

        for (SolicitudPFCMenDetalleVO unaSolicitudPfcMensualVo : listaSolicitudPfcMensualVo) {
            SolicitudPFCMenDetalleVO unaSolicitudPFCMenDetalleVo = new SolicitudPFCMenDetalleVO();
            unaSolicitudPfcMensualVo.setDetalleRubroVo(unaSolicitudPfcMensualVo.getDetalleRubroVo());
            unaSolicitudPfcMensualVo.setSprValorAprobado(unaSolicitudPfcMensualVo.getSprValorAprobado());
            SiiSolPfcMensDetRub unaSiiSolPfcMensDetRub = conversionVoEntidad.convertir(unaSolicitudPfcMensualVo);
            unaSiiSolPfcMensDetRub.setSiiSolicitudPfcMens(siiSolicitudPfcMensResultado);
            unaSiiSolPfcMensDetRub = solicitudPFCMenDetalleRDao.insertarSolicPfcMenDetalleR(unaSiiSolPfcMensDetRub);
        }

        for (SolicPfcmDetalleVO unaSolicPfcmDetalleVo : listaSolicPfcmDetalleVo) {
            SolicPfcmDetalleVO unSolicPfcmDetalleVo = new SolicPfcmDetalleVO();
            SiiSolicPfcmDetalle nuevaSolicPfcDetalle = conversionVoEntidad.convertir(unaSolicPfcmDetalleVo);
            nuevaSolicPfcDetalle.setSiiSolicitudPfcMens(siiSolicitudPfcMens);
            nuevaSolicPfcDetalle = solicPfcmDetalleDao.insertarSolicPfcmDet(nuevaSolicPfcDetalle);
            unSolicPfcmDetalleVo.setSpdCodigo(nuevaSolicPfcDetalle.getSpdCodigo());
            List<ModificPfcAnualVO> listaModificacionesPfcAnual = unaSolicPfcmDetalleVo.getModificPfcAnualVo();

            for (ModificPfcAnualVO modificPfcAnualVo : listaModificacionesPfcAnual) {
                SiiModificPfcAnual nuevaModificPfcAnual = null;
                nuevaModificPfcAnual = conversionVoEntidad.convertir(modificPfcAnualVo);
                nuevaModificPfcAnual.setSiiSolicPfcmDetalle(nuevaSolicPfcDetalle);
                nuevaModificPfcAnual = modificPfcAnualDao.insertarModPfca(nuevaModificPfcAnual);

            }
        }
        return new SolicitudPfcMensualVO(siiSolicitudPfcMensResultado);
    }

    /**
     * @author Modifica Giovanni
     * @param solicitudPfcMensualVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public SolicitudPfcMensualVO actualizarSolicPfcm(SolicitudPfcMensualVO solicitudPfcMensualVo,
                                                     UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                       ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiSolicitudPfcMens siiSolicitudPfcMensTemp = new SiiSolicitudPfcMens();
        siiSolicitudPfcMensTemp =
            solicitudPfcMensualDao.buscarSolicitudPfcMensPorId(solicitudPfcMensualVo.getSpfCodigo());
        if (siiSolicitudPfcMensTemp.getSiiEstadoSolicPfcm().getEspCodigo() !=
            solicitudPfcMensualVo.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud pfc mensual fue cambiado durante la modificación. Seleccione nuevamente la solicitud pfc mensual");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (solicitudPfcMensualVo.getEstadoSolicPfcmVo().getEspCodigo() !=
            solicitudPfcMensualVo.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_PFC_MENSUAL.getId(),
                                                         solicitudPfcMensualVo.getEstadoSolicPfcmVo().getEspCodigo(),
                                                         usuarioLogueado, solicitudPfcMensualVo.getSpfCodigo());
        }

        SiiSolicitudPfcMens siiSolicitudPfcMens = conversionVoEntidad.convertir(solicitudPfcMensualVo);
        List<SolicPfcmDetalleVO> listaSolicPfcmDetalleVo = solicitudPfcMensualVo.getSolicPfcmDetalleVo();
        /* for (SolicitudPFCMenDetalleVO unaSolicitudPfcMensualVo :listaSolicitudPfcMensualVo){
               SolicitudPFCMenDetalleVO  unaSolicitudPFCMenDetalleVo= new SolicitudPFCMenDetalleVO ();
               unaSolicitudPfcMensualVo.setDetalleRubroVo(unaSolicitudPfcMensualVo.getDetalleRubroVo());
               unaSolicitudPfcMensualVo.setSprValorAprobado(unaSolicitudPfcMensualVo.getSprValorAprobado());
               SiiSolPfcMensDetRub unaSiiSolPfcMensDetRub= conversionVoEntidad.convertir(unaSolicitudPfcMensualVo);
               unaSiiSolPfcMensDetRub.setSiiSolicitudPfcMens(siiSolicitudPfcMensResultado);
               unaSiiSolPfcMensDetRub=solicitudPFCMenDetalleRDao.insertarSolicPfcMenDetalleR(unaSiiSolPfcMensDetRub);
           }*/


        for (SolicPfcmDetalleVO unaSolicPfcmDetalleVo : listaSolicPfcmDetalleVo) {
            SolicPfcmDetalleVO unSolicPfcmDetalleVo = new SolicPfcmDetalleVO();
            SiiSolicPfcmDetalle nuevaSolicPfcDetalle = conversionVoEntidad.convertir(unaSolicPfcmDetalleVo);
            nuevaSolicPfcDetalle = solicPfcmDetalleDao.insertarSolicPfcmDet(nuevaSolicPfcDetalle);
            unSolicPfcmDetalleVo.setSpdCodigo(nuevaSolicPfcDetalle.getSpdCodigo());
            List<ModificPfcAnualVO> listaModificacionesPfcAnual = unaSolicPfcmDetalleVo.getModificPfcAnualVo();

            for (ModificPfcAnualVO modificPfcAnualVo : listaModificacionesPfcAnual) {
                SiiModificPfcAnual nuevaModificPfcAnual = null;
                nuevaModificPfcAnual = conversionVoEntidad.convertir(modificPfcAnualVo);
                nuevaModificPfcAnual.setSiiSolicPfcmDetalle(nuevaSolicPfcDetalle);
                nuevaModificPfcAnual = modificPfcAnualDao.insertarModPfca(nuevaModificPfcAnual);

            }
        }

        return new SolicitudPfcMensualVO(solicitudPfcMensualDao.actualizarSolicPfcm(siiSolicitudPfcMens));
    }

    public List<SolicitudPfcMensualVO> buscarTodaSolicitudPfcmNacion() throws ExcepcionDAO {
        List<SiiSolicitudPfcMens> listaSolicitudPfcMensualVo = solicitudPfcMensualDao.buscarTodaSolicitudPfcmNacion();
        List<SolicitudPfcMensualVO> listaSiiSolicitudPfcMensVo = new ArrayList();
        for (SiiSolicitudPfcMens unaSolicitudPfcMens : listaSolicitudPfcMensualVo) {
            SolicitudPfcMensualVO nuevaObliDetRubroCdpVo = new SolicitudPfcMensualVO(unaSolicitudPfcMens);
            listaSiiSolicitudPfcMensVo.add(nuevaObliDetRubroCdpVo);
        }
        return listaSiiSolicitudPfcMensVo;

    }

    public SolicitudPfcMensualVO buscarTodaSolicitudPfcmxVigenciMes(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {

        SiiSolicitudPfcMens siiSolicitudPfcMens = conversionVoEntidad.convertir(solicitudPfcMensualVo);
        SiiSolicitudPfcMens unasolicitudPfcMensual =
            solicitudPfcMensualDao.buscarTodaSolicitudPfcmxVigenciMes(siiSolicitudPfcMens.getSpfVigencia(),
                                                                      siiSolicitudPfcMens.getSiiMes1().getMesCodigo());
        return new SolicitudPfcMensualVO(unasolicitudPfcMensual);

    }

    public List<SolicPfcmDetalleVO> buscarTodoDetallePorSolPfcm(SolicPfcmDetalleVO solicPfcmDetalleVo) throws ExcepcionDAO {
        List<SiiSolicPfcmDetalle> listaSiiSolicPfcmDetalle =
            solicPfcmDetalleDao.buscarTodoDetallePorSolPfcm(solicPfcmDetalleVo.getSolicitudPfcMensualVo().getSpfCodigo());
        List<SolicPfcmDetalleVO> listaSolicPfcmDetalleVo = new ArrayList();
        for (SiiSolicPfcmDetalle unaSiiSolicPfcmDetalle : listaSiiSolicPfcmDetalle) {
            SolicPfcmDetalleVO nuevaSolicPfcmDetalleVo = new SolicPfcmDetalleVO(unaSiiSolicPfcmDetalle);
            listaSolicPfcmDetalleVo.add(nuevaSolicPfcmDetalleVo);
        }

        return listaSolicPfcmDetalleVo;
    }

    public EstadoSolicPfcmVO buscarEstadoSolicPfcmPorId(EstadoSolicPfcmVO estadoSolicPfcmVo) throws ExcepcionDAO {
        return new EstadoSolicPfcmVO(estadoSolicPfcmDao.buscarEstadoSolicPfcmPorId(estadoSolicPfcmVo.getEspCodigo()));
    }

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXSpd(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO {

        List<SiiModificPfcAnual> listaSiiModificPfcAnual;
        listaSiiModificPfcAnual = modificPfcAnualDao.buscarTodoModificacPfcAnualXSpd(modificPfcAnualVo);
        List<ModificPfcAnualVO> listaModificPfcAnualvo = new ArrayList();
        for (SiiModificPfcAnual unModificPfcAnual : listaSiiModificPfcAnual) {
            listaModificPfcAnualvo.add(new ModificPfcAnualVO(unModificPfcAnual));
        }
        return listaModificPfcAnualvo;
    }

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXVigenciaMes(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO {
        List<ModificPfcAnualVO> listaModificPfcAnualVo;
        listaModificPfcAnualVo =
            modificPfcAnualDao.buscarTodoModificacPfcAnualXVigenciaMes(modificPfcAnualVo.getVigencia(),
                                                                       modificPfcAnualVo.getMesVo().getMesCodigo());
        return listaModificPfcAnualVo;
    }

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXSpf(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {
        List<ModificPfcAnualVO> listaModificPfcAnualVo;
        listaModificPfcAnualVo =
            modificPfcAnualDao.buscarTodoModificacPfcAnualXSpf(solicitudPfcMensualVo.getSpfCodigo());
        return listaModificPfcAnualVo;
    }


    public List<SolicitudPFCMenDetalleVO> buscarTodaSolicitudPfcMensualDettaleXIdSpf(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO {
        List<SiiSolPfcMensDetRub> listaSolicitudPFCMenDetalle;
        List<SolicitudPFCMenDetalleVO> listaSolicitudPFCMenDetalleVo = new ArrayList();
        listaSolicitudPFCMenDetalle =
            solicitudPFCMenDetalleRDao.buscarTodaSolicitudPfcMensualDettaleXIdSpf(solicitudPfcMensualVo.getSpfCodigo());

        for (SiiSolPfcMensDetRub unaSiiSolPfcMensDetRub : listaSolicitudPFCMenDetalle) {
            SolicitudPFCMenDetalleVO nuevaSolicitudPFCMenDetalleVo =
                new SolicitudPFCMenDetalleVO(unaSiiSolPfcMensDetRub);
            listaSolicitudPFCMenDetalleVo.add(nuevaSolicitudPFCMenDetalleVo);
        }

        return listaSolicitudPFCMenDetalleVo;
    }
    
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdNotaCredito(Long  ncrCodigo) throws ExcepcionDAO {

         List<RubroFuenteDetalleFuenteRpVO> listRubroFuenteDetalleFuenteRpVo =
            obligacionPagoDao.buscarRubroFuenteFDetfuenteXIdNotaCredito(ncrCodigo);
         
        return listRubroFuenteDetalleFuenteRpVo;

    }


}
