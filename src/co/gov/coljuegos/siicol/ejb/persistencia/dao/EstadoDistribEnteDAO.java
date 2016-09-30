package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDistribEnte;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoDistribEnteDAO extends GenericDAO<SiiEstadoDistribEnte>{


    public EstadoDistribEnteDAO() {
        super(SiiEstadoDistribEnte.class);
    }
}
