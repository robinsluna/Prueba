package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstablecSuspensionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstablecSuspension {
    public List<EstablecSuspensionVO> buscarEstablecSuspensionPorSuspension(Long scoCodigo) throws ExcepcionDAO;
}
