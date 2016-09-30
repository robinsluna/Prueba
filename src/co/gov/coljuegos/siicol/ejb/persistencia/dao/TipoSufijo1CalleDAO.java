package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo1Calle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoSufijo1CalleDAO extends AbstractDAO<Long, SiiTipoSufijo1Calle> {
    public TipoSufijo1CalleDAO() {
        super(SiiTipoSufijo1Calle.class);
    }
}
