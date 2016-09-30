package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioRolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminUsuarioRol {
    
    public List<UsuarioRolVO> buscarUsuarioRolPorUsuario(Long idUsuario) throws ExcepcionDAO;
    public void actualizarUsuarioRolTodosUsuarioRol(List<RolVO> listaRolVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public UsuarioVO insertarUsuarioRolTodosUsuarioRol(List<RolVO> listaRolVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO;
}
