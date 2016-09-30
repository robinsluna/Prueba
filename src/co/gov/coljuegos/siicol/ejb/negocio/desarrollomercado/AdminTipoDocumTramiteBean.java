package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocumentoTramiteDAO;

import co.gov.coljuegos.siicol.ejb.vo.TipoDocumTramiteVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoDocumTramiteBean implements AdminTipoDocumTramite {
    @EJB
   TipoDocumentoTramiteDAO tipoDocumTramiteDao;
    public AdminTipoDocumTramiteBean() {
        
    }
    
    public TipoDocumTramiteVO buscarDocumentoPorId(Long id) throws ExcepcionDAO {
        return new TipoDocumTramiteVO(tipoDocumTramiteDao.buscarPorCodigo(id));
    }
}
