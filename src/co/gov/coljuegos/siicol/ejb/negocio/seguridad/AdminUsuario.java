/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 26-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.seguridad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import javax.ejb.Local;

@Local

public interface AdminUsuario {
    public UsuarioVO insertarUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO;

    public UsuarioVO buscarUsuarioPorId(UsuarioVO usuarioVo) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param usuarioVo
     * @param usuarioLogueado
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public void actualizarUsuario(UsuarioVO usuarioVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                         ExcepcionAplicacion;

    //public void eliminarUsuario(UsuarioVO usuarioVo) throws ExcepcionDAO;

    public List<UsuarioVO> buscarTodosUsuario() throws ExcepcionDAO;
    
    public List<UsuarioVO> buscarTodoUsuarioConPersona() throws ExcepcionDAO;

    public List<UsuarioVO> buscarUsuariosPorIdFuncion(Long idFuncion) throws ExcepcionDAO;

    public void autenticarWS(UsuarioVO usuarioVo) throws ExcepcionAplicacion;

    public UsuarioVO autenticarDirectorio(UsuarioVO usuarioVo) throws ExcepcionAplicacion;

    public UsuarioVO buscarUsuarioPorLogin(UsuarioVO unUsuarioVo) throws ExcepcionDAO;

    public UsuarioVO buscarUsuarioPorIdPersona(UsuarioVO unUsuarioVo) throws ExcepcionDAO;

    public UsuarioVO buscarUsuarioPorIdPersona(Long perCodigo) throws ExcepcionDAO;

    public String convertPassword(String password, String salt) throws ExcepcionAplicacion;

    public UsuarioVO buscarUsuarioRolPorId(Long idUsuario) throws ExcepcionDAO;

}
