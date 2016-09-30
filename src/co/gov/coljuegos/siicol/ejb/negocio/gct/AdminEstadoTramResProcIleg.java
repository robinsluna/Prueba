package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResProcIlegVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoTramResProcIleg {
    public EstadoTramResProcIlegVO buscarEstadoTramResProcIlegPorCodigo (Long etrCodigo) throws ExcepcionDAO;
    public List<EstadoTramResProcIlegVO> buscarTodoEstadoTramResProcIleg () throws ExcepcionDAO;
}
