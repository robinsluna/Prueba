package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPruebaIleg;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoPruebaIlegDAO extends AbstractDAO<Long,SiiTipoPruebaIleg>{
    public TipoPruebaIlegDAO() {
        super(SiiTipoPruebaIleg.class);
    }
}
