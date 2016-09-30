package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoProveedorVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminContratoProveedor {

    public ContratoProveedorVO insertarContratoProveedor(ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param contratoProveedorVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ContratoProveedorVO actualizarContratoProveedor(ContratoProveedorVO contratoProveedorVo,
                                                           UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                             ExcepcionAplicacion;

    public ContratoProveedorVO buscarContratoProveedorPorId(ContratoProveedorVO contratoProveedorVo) throws ExcepcionDAO;

    public List<ContratoProveedorVO> buscarContratoProveedorPorIdOficioAdjudicacion(Long idOficioAdjudicacion) throws ExcepcionDAO;
}
