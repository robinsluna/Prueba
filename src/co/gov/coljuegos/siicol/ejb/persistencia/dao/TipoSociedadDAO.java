package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSociedad;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoSociedadDAO extends GenericDAO<SiiTipoSociedad>{


    public TipoSociedadDAO() {
        super(SiiTipoSociedad.class);
    }
}


