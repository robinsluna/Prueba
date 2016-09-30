package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDetalleDeclaracion {
    public DetalleDeclaracionVO buscarPorCodigoDetalleDeclaracion(Long idCodigoDetalleDeclar)  throws ExcepcionDAO;
    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXCodigoCuota(Long codigoCuota) throws ExcepcionDAO ;
}
