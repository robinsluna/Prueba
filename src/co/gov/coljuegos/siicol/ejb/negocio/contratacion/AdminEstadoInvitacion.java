package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoInvitacion;

import co.gov.coljuegos.siicol.ejb.vo.EstadoInvitacionVO;

import java.util.List;

import javax.ejb.Local;

@Local 

public interface AdminEstadoInvitacion {
    public EstadoInvitacionVO buscarEstadoInvitacionPorId(Long einCodigo) throws ExcepcionDAO;
    public EstadoInvitacionVO insertarEstadoInvitacion(EstadoInvitacionVO estadoInvitacionVO) throws ExcepcionDAO;                
    public EstadoInvitacionVO actualizarEstadoInvitacion(EstadoInvitacionVO estadoInvitacionVO) throws ExcepcionDAO;    
    public void eliminarEstadoInvitacion(long einCodigo) throws ExcepcionDAO;        
    public List<EstadoInvitacionVO> buscarTodoEstadoInvitacion() throws ExcepcionDAO;
    public List<EstadoInvitacionVO> buscarEstadoInvitacion(String estado) throws ExcepcionDAO;
    
}
