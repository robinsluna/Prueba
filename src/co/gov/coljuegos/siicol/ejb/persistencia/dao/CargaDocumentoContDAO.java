package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaDocumentoCont;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class CargaDocumentoContDAO extends AbstractDAO<Long, SiiCargaDocumentoCont> 
{
    /**
     * Constructor.
     */
    public CargaDocumentoContDAO() {
        super(SiiCargaDocumentoCont.class);
    }
}
