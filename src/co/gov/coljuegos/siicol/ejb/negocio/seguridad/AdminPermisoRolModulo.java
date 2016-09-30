package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.PermisoRolModuloVO;

import co.gov.coljuegos.siicol.ejb.vo.PermisoVO;
import co.gov.coljuegos.siicol.ejb.vo.RolVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminPermisoRolModulo {
    
    public PermisoRolModuloVO insertarPermisoRolModulo(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO;
    public PermisoRolModuloVO buscarPermisoRolModuloPorPadres(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO;
    public void borrarPermisoRolModulo(PermisoRolModuloVO permisoRolModuloVo) throws ExcepcionDAO;
    public List<PermisoRolModuloVO> insertarListasPermisosRolesModulos(List<ModuloVO> listaModulosVo,List<PermisoVO> listaPermisosVo,
                                                                 List<RolVO> listaRoles, UsuarioVO usuarioVo) throws ExcepcionDAO;
    public List<PermisoRolModuloVO> buscarPermisoRolModuloPorRol(Long idRol) throws ExcepcionDAO;
}
