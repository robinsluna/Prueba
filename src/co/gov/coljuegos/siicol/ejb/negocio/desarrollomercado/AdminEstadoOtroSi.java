package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOtroSiVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoOtroSi {
    public EstadoOtroSiVO buscarEstadoOtroSiPorNombre(String estadoOtroSi) throws ExcepcionDAO ;
    public EstadoOtroSiVO buscarEstadoOtroSiPorId(Long eosCodigo) throws ExcepcionDAO ;
    
}



