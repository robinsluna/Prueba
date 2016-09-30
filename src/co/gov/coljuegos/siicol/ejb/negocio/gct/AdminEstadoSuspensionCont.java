package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSuspensionContVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoSuspensionCont {
    public EstadoSuspensionContVO buscarEstadoPorNombre(String string) throws ExcepcionDAO;
}
