package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoCdpVO;

import java.util.List;

import javax.ejb.Local;
@Local
public interface AdminEstadoCdp {
    public EstadoCdpVO buscarEstadoCdpPorId(long idEstadoCdp) throws ExcepcionDAO;
    public EstadoCdpVO insertarEstadoCdp(EstadoCdpVO estadoCdpVO) throws ExcepcionDAO;
    public void eliminarEstadoCdp(long idEstadoCdp) throws ExcepcionDAO;
    public List<EstadoCdpVO> buscarTodoCdp() throws ExcepcionDAO;
}
