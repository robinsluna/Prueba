package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoUsuario;
import co.gov.coljuegos.siicol.ejb.vo.EstadoUsuarioVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoUsuario {
    public EstadoUsuarioVO buscarEstadoUsuarioPorId(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO;
    public EstadoUsuarioVO insertarEstadoUsario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO;
    public EstadoUsuarioVO actualizarEstadoUsuario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO;
    public void eliminarEstadoUsuario(EstadoUsuarioVO estadoUsuarioVo) throws ExcepcionDAO;
}
