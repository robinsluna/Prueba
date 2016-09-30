package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ConceptoRetenVO;

import java.util.List;

public interface AdminConceptoReten {
    
    public List<ConceptoRetenVO> buscarTodoConceptoReten() throws ExcepcionDAO;
    public ConceptoRetenVO buscarConceptoRetenPorCodigo(Long idConceptoReten) throws ExcepcionDAO;
}
