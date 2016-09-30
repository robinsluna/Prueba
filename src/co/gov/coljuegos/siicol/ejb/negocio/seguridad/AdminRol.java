package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminRol {
    public List<RolVO> buscarTodosRoles() throws ExcepcionDAO;

    public RolVO insertarRol(RolVO rolVo) throws ExcepcionDAO;

    public List<RolVO> buscarTodosRolesConSinPermisoPorUsuario(Long idUsuario) throws ExcepcionDAO;
    
    public List<RolVO> buscarUsuariosIdPorRol(Long idUsuario) throws ExcepcionDAO ;

}
