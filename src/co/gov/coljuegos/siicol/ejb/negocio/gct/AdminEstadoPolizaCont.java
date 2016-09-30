package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoPolizaContVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoPolizaCont {
    public EstadoPolizaContVO buscarEstadoPolizaContPorEstado(String estado) throws ExcepcionDAO;
    public EstadoPolizaContVO buscarEstadoPolizaContPorId(Long epoCodigo) throws ExcepcionDAO;
}
