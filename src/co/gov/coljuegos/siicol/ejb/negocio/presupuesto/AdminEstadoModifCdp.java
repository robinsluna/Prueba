package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifCdpVO;

public interface AdminEstadoModifCdp {
    public EstadoModifCdpVO buscarEstadoModifCdpPorId(Long emcCodigo) throws ExcepcionDAO;
    public EstadoModifCdpVO buscarEstadoModifCdpPorNombre(String nombre) throws ExcepcionDAO;
}
