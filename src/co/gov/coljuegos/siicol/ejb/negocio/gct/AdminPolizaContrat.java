package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContratVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminPolizaContrat {

    /**
     * @author Giovanni
     * @param polizaContratVo
     * @param usuarioLogin
     * @throws ExcepcionDAO
     */
    public void guardarPolizaContrat(PolizaContratVO polizaContratVo, UsuarioVO usuarioLogin) throws ExcepcionDAO,
                                                                                                     ExcepcionAplicacion;

    public List<PolizaContratVO> buscarPolizasContrat() throws ExcepcionDAO;

    /**
     * Guarda un historial de la poliza y genera un nuevo registro
     * @author Giovanni
     * @param polizaContratVO
     * @param usuarioLogin
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void guardarHistorialYNuevaPoliza(PolizaContratVO polizaContratVO,
                                             UsuarioVO usuarioLogin) throws ExcepcionDAO, ExcepcionAplicacion;

    /**
     * @Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public PolizaContratVO buscarPolizasContratXIdCompleto(Long idPolizaContrato) throws ExcepcionDAO;

    /**
     * @author Giovanni
     * @param polizaContratVO
     * @param usuarioLogin
     * @throws ExcepcionDAO
     */
    public void actualizarPolizaContrat(PolizaContratVO polizaContratVO, UsuarioVO usuarioLogin) throws ExcepcionDAO,
                                                                                                        ExcepcionAplicacion;
    
    
    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<PolizaContratVO> buscarPolizasOtrosiConcesion() throws ExcepcionDAO;
    
    public List<PolizaContratVO> buscarPolizasPorContrato(Long idContrato) throws ExcepcionDAO ;
    
    public List<PolizaContratVO> buscarPolizasContratRenovacion() throws ExcepcionDAO;
}
