package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoSustanVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminHistEstadoSustan {
    public List<HistEstadoSustanVO> buscarHistEstadoSustanPorSustan(Long suaCodigo) throws ExcepcionDAO;
}
