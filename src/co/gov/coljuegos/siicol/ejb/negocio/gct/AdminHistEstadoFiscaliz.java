package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoFiscalizVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminHistEstadoFiscaliz {
    public List<HistEstadoFiscalizVO> buscarTodoHistEstadoFiscalizVo() throws ExcepcionDAO;
    public HistEstadoFiscalizVO insertarHistEstadoFiscaliz(HistEstadoFiscalizVO histEstadoFiscalizVo) throws ExcepcionDAO;
    public List<HistEstadoFiscalizVO> buscarHistEstadoFiscalizPorFiscaliz(Long fsuCodigo) throws ExcepcionDAO;
}
