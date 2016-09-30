package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligNoPres;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoObligNoPresDAO extends GenericDAO<SiiEstadoObligNoPres> {

    public EstadoObligNoPresDAO() {
        super(SiiEstadoObligNoPres.class);
    }
}
