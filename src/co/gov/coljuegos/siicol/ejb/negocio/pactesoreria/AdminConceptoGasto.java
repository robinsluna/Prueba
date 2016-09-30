package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoGastoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminConceptoGasto {
    
    public List<ConceptoGastoVO> buscarTodoConceptoGasto() throws ExcepcionDAO;
    
}
