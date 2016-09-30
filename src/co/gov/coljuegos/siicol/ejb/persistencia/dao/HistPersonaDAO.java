package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistPersona;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HistPersonaDAO extends GenericDAO<SiiHistPersona>{

    /**
     * Constuctor.
     */
    public HistPersonaDAO() {
        super(SiiHistPersona.class);
    }

}
