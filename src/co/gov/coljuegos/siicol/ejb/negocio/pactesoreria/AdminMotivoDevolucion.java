package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoDevolucionVO;

import java.util.List;


public interface AdminMotivoDevolucion {

    public List<MotivoDevolucionVO> buscarTodoMotivoDevolucion() throws ExcepcionDAO;
}
