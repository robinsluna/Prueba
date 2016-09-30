package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoAlcanceInvVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoAlcanceInv {
    public EstadoAlcanceInvVO buscarEstadoAlcanceInvPorId(Long eaiCodigo) throws ExcepcionDAO;
    public EstadoAlcanceInvVO insertarEstadoAlcanceInv(EstadoAlcanceInvVO estadoAlcanceInvVO) throws ExcepcionDAO;                
    public EstadoAlcanceInvVO actualizarEstadoAlcanceInv(EstadoAlcanceInvVO estadoAlcanceInvVO) throws ExcepcionDAO;    
    public void eliminarEstadoAlcanceInv(long eaiCodigo) throws ExcepcionDAO;        
    public List<EstadoAlcanceInvVO> buscarTodoEstadoAlcanceInv() throws ExcepcionDAO;
    public List<EstadoAlcanceInvVO> buscarEstadoAlcanceInv(String estado) throws ExcepcionDAO;
}
