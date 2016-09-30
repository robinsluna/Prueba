package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DocumSoporModifVO;

import java.util.List;

public interface AdminDocumSoporModif {
    List<DocumSoporModifVO> documentosSoportePorModif(Long mpcCodigo) throws ExcepcionDAO;
    public boolean existeDocumento(DocumSoporModifVO documSoporModifVO) throws ExcepcionDAO;
}
