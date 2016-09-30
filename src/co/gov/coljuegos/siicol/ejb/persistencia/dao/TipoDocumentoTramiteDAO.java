package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumTramite;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoDocumentoTramiteDAO extends AbstractDAO<Long, SiiTipoDocumTramite>{
    public TipoDocumentoTramiteDAO() {
        super(SiiTipoDocumTramite.class);
    }
}
