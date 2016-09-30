package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocumTramiteVO;

public interface AdminTipoDocumTramite {
    public TipoDocumTramiteVO buscarDocumentoPorId(Long id) throws ExcepcionDAO;
}
