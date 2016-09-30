package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAjuste;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoAjusteDAO extends GenericDAO<SiiTipoAjuste> {
    public TipoAjusteDAO() {
        super(SiiTipoAjuste.class);
    }
}
