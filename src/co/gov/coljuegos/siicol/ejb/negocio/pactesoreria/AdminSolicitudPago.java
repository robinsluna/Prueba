package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;
import co.gov.coljuegos.siicol.ejb.vo.RpVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminSolicitudPago {

    public List<SolicitudPagoVO> buscarTodoSiiSolitudPago() throws ExcepcionDAO;

    public List<RpVO> programacionDelPFCMensual(Integer vigencia, Integer seleccionMesPago) throws ExcepcionDAO;

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
                                                                                        ExcepcionAplicacion;

    
    public void insertarSolicitudPago(SolicitudPagoVO solicitudPagoVO) throws ExcepcionDAO, ExcepcionAplicacion;

    public List<SolicitudPagoVO> buscarSiiSolitudPagoXEstado(long estado) throws ExcepcionDAO;

    public SolicitudPagoVO buscarSiiSolitudPagoXRp(Long idRp) throws ExcepcionDAO;

    public Long buscarConsecutivoSolicitudPago() throws ExcepcionDAO;

    public List<SolicitudPagoVO> buscarSolitudPagoSinObligacionXEstado(Long esoCodigo) throws ExcepcionDAO;
    
    public Long buscarConsecutivoSolicitudPago (Integer vigencia) throws ExcepcionDAO;
}
