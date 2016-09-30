package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoContratoVO;


public interface AdminEstadoContrato {
    public EstadoContratoVO buscarEstadoContratoPorNombre(String ecoNombre) throws ExcepcionDAO;
    public EstadoContratoVO buscarEstadoContratoPorId(Long ecoCodigo) throws ExcepcionDAO;
}
