package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoResolucAutVO;

public interface AdminEstadoResolucAut {
    public EstadoResolucAutVO buscarEstadoResolucAutPorId(Long idEstado) throws ExcepcionDAO;
    public EstadoResolucAutVO buscarEstadoResolucAutPorEstado(String estado) throws ExcepcionDAO;
}
