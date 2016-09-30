package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstablecimiento {
    public List<EstablecimientoVO> buscarEstablecimientosPorContrato(Long conCodigo) throws ExcepcionDAO;

    public EstablecimientoVO buscarEstablecimientoPorId(Long estCodigo) throws ExcepcionDAO;
    public String buscarEstablecimientoPorNitOperador (String nit) throws ExcepcionDAO;
}
