package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSufijo2Calle;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean

public class TipoSufijo2CalleDAO extends AbstractDAO<Long, SiiTipoSufijo2Calle> {
    public TipoSufijo2CalleDAO() {
        super(SiiTipoSufijo2Calle.class);
    }
}
