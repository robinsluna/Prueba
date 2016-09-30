/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Walter Becerra
 * FECHA	: 03-12-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPfcmVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPfcAnualVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;
import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetallePFCMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicPfcmDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPFCMenDetalleVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPfcMensualVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminSolicitudPFCMensual {


    public List<SolicitudPfcMensualVO> buscarTodaSolicitudPfcm() throws ExcepcionDAO;

    public SolicitudPfcMensualVO buscarSolicitudPfcMensPorId(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO;

    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObli(RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO;

    public SolicitudPfcMensualVO insertarSolicPfcm(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO;

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
                                                                                       ExcepcionAplicacion;

    public List<SolicitudPfcMensualVO> buscarTodaSolicitudPfcmNacion() throws ExcepcionDAO;

    public List<SolicPfcmDetalleVO> buscarTodoDetallePorSolPfcm(SolicPfcmDetalleVO solicPfcmDetalleVo) throws ExcepcionDAO;

    public EstadoSolicPfcmVO buscarEstadoSolicPfcmPorId(EstadoSolicPfcmVO estadoSolicPfcmVo) throws ExcepcionDAO;

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXSpd(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO;

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXVigenciaMes(ModificPfcAnualVO modificPfcAnualVo) throws ExcepcionDAO;

    public List<RubroFuenteDetallePFCMensualVO> buscarListaFuenteDetallefuenteXObliNacion(RubroFuenteDetallePFCMensualVO rubroFuenteDetPFCMensualVo) throws ExcepcionDAO;

    public SolicitudPfcMensualVO buscarTodaSolicitudPfcmxVigenciMes(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO;

    public List<SolicitudPFCMenDetalleVO> buscarTodaSolicitudPfcMensualDettaleXIdSpf(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO;

    public List<ModificPfcAnualVO> buscarTodoModificacPfcAnualXSpf(SolicitudPfcMensualVO solicitudPfcMensualVo) throws ExcepcionDAO;
    
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdNotaCredito(Long  ncrCodigo) throws ExcepcionDAO ;
}
