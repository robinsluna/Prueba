package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoTasaInteres;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoTasaInteresDAO extends AbstractDAO<Long,SiiTipoTasaInteres> {
    public TipoTasaInteresDAO() {
        super(SiiTipoTasaInteres.class);
    }
}
