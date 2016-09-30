package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SolicitudPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.MesVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionVO;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminSolicitudPagoBean implements AdminSolicitudPago {

    @EJB
    private SolicitudPagoDAO solicitudPagoDAO;
    @EJB
    private RpDAO rpDao;
    @EJB
    private AdminObligacion adminObligacion;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    public List<SolicitudPagoVO> buscarTodoSiiSolitudPago() throws ExcepcionDAO {

        List<SiiSolicitudPago> listaSiiSolicitudPago = solicitudPagoDAO.buscarTodoSolicitudPago();
        List<SolicitudPagoVO> listaSiiSolicitudPagoVo = new ArrayList();

        if (listaSiiSolicitudPago != null) {
            for (SiiSolicitudPago unaSolicitudPago : listaSiiSolicitudPago) {
                if (unaSolicitudPago != null) {
                    SolicitudPagoVO nuevaObliDetRubroCdpVo = new SolicitudPagoVO(unaSolicitudPago);

                    if (unaSolicitudPago.getSiiEstadoSolicPago() != null)
                        nuevaObliDetRubroCdpVo.setEstadoSolicPagoVo(new EstadoSolicPagoVO(unaSolicitudPago.getSiiEstadoSolicPago()));
                    
                    if (unaSolicitudPago.getSiiMes()!=null)
                        nuevaObliDetRubroCdpVo.setMesVo(new MesVO(unaSolicitudPago.getSiiMes()));
                    
                    if (unaSolicitudPago.getSiiRp()!=null)
                        nuevaObliDetRubroCdpVo.setRpVo(new RpVO(unaSolicitudPago.getSiiRp()));
                    
                    
                    listaSiiSolicitudPagoVo.add(nuevaObliDetRubroCdpVo);
                }
            }
        }
        return listaSiiSolicitudPagoVo;
    }

    public List<RpVO> programacionDelPFCMensual(Integer vigencia, Integer seleccionMesPago) throws ExcepcionDAO {
        //CON PFC
        //List<BigDecimal> listaProgramacion = solicitudPagoDao.programaciónDelPFCMensual(vigencia, seleccionMesPago);
        //SIN PFC
        List<Long> listaProgramacion = solicitudPagoDAO.sinProgramaciónDelPFCMensual();
        List<RpVO> listaRpVo = new ArrayList();

        for (Long codRP : listaProgramacion) {
            RpVO rp = new RpVO(rpDao.buscarPorCodigoRp(codRP));
            listaRpVo.add(rp);
        }

        return listaRpVo;
    }


    /**
     * Almacena la informaci&oacute;n de los hijos de la Solicitud.
     * @param solicitudPagoVO
     * @throws ExcepcionDAO
     */
    private void persistirHijos(SolicitudPagoVO solicitudPagoVO) throws ExcepcionDAO, ExcepcionAplicacion {
        this.persistirObligacion(solicitudPagoVO);
    }


    /**
     * Almacena las Obligaciones que se encuentran asociadas a la Solicitud.
     * @param solicitudPagoVO
     * @throws ExcepcionDAO
     */
    private void persistirObligacion(SolicitudPagoVO solicitudPagoVO) throws ExcepcionDAO, ExcepcionAplicacion {
        if (solicitudPagoVO != null && solicitudPagoVO.getObligacionList() != null &&
            !solicitudPagoVO.getObligacionList().isEmpty()) {

            for (ObligacionVO obligacionVo : solicitudPagoVO.getObligacionList()) {
                if (obligacionVo != null) {
                    if (obligacionVo.getOblCodigo() == null) {
                        //insertar
                        adminObligacion.insertarObligacion(obligacionVo);
                    } else {
                        // actualizar
                        adminObligacion.actualizarObligacion(obligacionVo);
                    }
                }
            }
        }
    }

    /**
     * @author Modifica Giovanni
     * @param solicitudPagoVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public SiiSolicitudPago actualizarEstadoSolicitud(SolicitudPagoVO solicitudPagoVO,
                                                      UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                        ExcepcionAplicacion {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiSolicitudPago siiSolicitudPagoTemp = new SiiSolicitudPago();
        siiSolicitudPagoTemp = solicitudPagoDAO.buscarSolicitudPagoPorId(solicitudPagoVO.getSpaCodigo());
        if (siiSolicitudPagoTemp.getSiiEstadoSolicPago().getEsoCodigo() != solicitudPagoVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado de la solicitud de pago fue cambiado durante la modificación. Seleccione nuevamente la soliictud de pago");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (solicitudPagoVO.getEstadoSolicPagoVo().getEsoCodigo() != solicitudPagoVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.SOLICITUD_PAGO.getId(),
                                                         solicitudPagoVO.getEstadoSolicPagoVo().getEsoCodigo(),
                                                         usuarioLogueado, solicitudPagoVO.getSpaCodigo());
        }

        SiiSolicitudPago siiSolicitudPago =
            solicitudPagoDAO.actualizarEstadoSolicitud(conversionVoEntidad.convertir(solicitudPagoVO));
        if (siiSolicitudPago != null && solicitudPagoVO != null) {
            this.persistirHijos(solicitudPagoVO);
        }

        return (siiSolicitudPago);
    }

    public void insertarSolicitudPago(SolicitudPagoVO solicitudPagoVO) throws ExcepcionDAO, ExcepcionAplicacion {
        solicitudPagoDAO.insertarSolicitudPago(conversionVoEntidad.convertir(solicitudPagoVO));
        if (solicitudPagoVO != null) {
            this.persistirHijos(solicitudPagoVO);
        }
    }

    @Override
    public List<SolicitudPagoVO> buscarSiiSolitudPagoXEstado(long estado) throws ExcepcionDAO {

        List<SiiSolicitudPago> listaSiiSolicitudPago = solicitudPagoDAO.buscarSiiSolitudPagoXEstado(estado);
        List<SolicitudPagoVO> listaSiiSolicitudPagoVo = new ArrayList();

        for (SiiSolicitudPago unaSolicitudPago : listaSiiSolicitudPago) {
            SolicitudPagoVO nuevaObliDetRubroCdpVo = new SolicitudPagoVO(unaSolicitudPago);
            nuevaObliDetRubroCdpVo.setEstadoSolicPagoVo(new EstadoSolicPagoVO(unaSolicitudPago.getSiiEstadoSolicPago()));
            nuevaObliDetRubroCdpVo.setMesVo(new MesVO(unaSolicitudPago.getSiiMes()));
            nuevaObliDetRubroCdpVo.setRpVo(new RpVO(unaSolicitudPago.getSiiRp()));
            listaSiiSolicitudPagoVo.add(nuevaObliDetRubroCdpVo);
        }
        return listaSiiSolicitudPagoVo;
    }

    @Override
    public SolicitudPagoVO buscarSiiSolitudPagoXRp(Long idRp) throws ExcepcionDAO {
        SiiSolicitudPago solicitudPago = solicitudPagoDAO.buscarSiiSolitudPagoXRp(idRp);
        SolicitudPagoVO miSolVo = null;
        if (solicitudPago != null) {
            miSolVo = new SolicitudPagoVO(solicitudPago);
        }
        return miSolVo;
    }
    
    @Override
    public Long buscarConsecutivoSolicitudPago() throws ExcepcionDAO {
        return (solicitudPagoDAO.buscarConsecutivoSolicitudPago());
    }
    
    @Override
    public Long buscarConsecutivoSolicitudPago (Integer vigencia) throws ExcepcionDAO {
        return ( solicitudPagoDAO.buscarConsecutivoSolicitudPago(vigencia) );
    }
    
    
    @Override
    public List<SolicitudPagoVO> buscarSolitudPagoSinObligacionXEstado(Long esoCodigo) throws ExcepcionDAO {
        List<SolicitudPagoVO> resultado = null;
        List<SiiSolicitudPago> lista = solicitudPagoDAO.buscarSiiSolitudPagoSinObligacionXEstado(esoCodigo);
        if (lista != null) {
            resultado = new ArrayList<SolicitudPagoVO>();
            for (SiiSolicitudPago siiSolicitudPago : lista) {
                resultado.add(new SolicitudPagoVO(siiSolicitudPago));
            }
        }
        return (resultado);
    }
}
