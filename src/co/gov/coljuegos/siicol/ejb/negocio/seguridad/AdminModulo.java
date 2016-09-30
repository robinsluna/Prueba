package co.gov.coljuegos.siicol.ejb.negocio.seguridad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ModuloVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminModulo {
    public List<ModuloVO> buscarModulosPorIdUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO;
    //public List<ModuloVO> buscarModulosPorIdUsuarioPorIdModuloPadre(UsuarioVO usuarioVo, ModuloVO moduloVo) throws ExcepcionDAO;
    public ModuloVO buscarModuloPorNombre(ModuloVO moduloVo) throws ExcepcionDAO;
    public List<ModuloVO> buscarTodosModulosConSinPermisoPorRol(Long idRol) throws ExcepcionDAO;
    public void actualizarModulosPermisoTodos(List<ModuloVO> listaModulosVo) throws ExcepcionDAO;
    public void insertarModulosPermisoTodos(List<ModuloVO> listaModulosVo) throws ExcepcionDAO;
    public List<ModuloVO> buscarSoloModulosPorIdUsuarioConOrden(UsuarioVO usuarioVo) throws ExcepcionDAO;
    public List<ModuloVO> buscarTodosModulos() throws ExcepcionDAO;
    //public ModuloVO buscarModuloPorPath (String modPath) throws ExcepcionDAO;
}
