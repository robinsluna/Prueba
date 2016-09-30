package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoProcContrat {
    public EstadoProcContratVO BuscarEstadoProcContratPorId(Long id) throws ExcepcionDAO;
    public EstadoProcContratVO insertarEstadoProcContrat (EstadoProcContratVO estadoProcContratVO) throws ExcepcionDAO;
    public EstadoProcContratVO actualizarEstadoProcContrat(EstadoProcContratVO estadoProcContratVO) throws ExcepcionDAO;
    public void eliminarEstadoProcContrat (Long id) throws ExcepcionDAO;
    public EstadoProcContratVO buscarEstadoProcContratPorEstado(String estado) throws ExcepcionDAO;
}
