package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOficioLiq;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoOficioLiqDAO extends GenericDAO<SiiEstadoOficioLiq>{


    public EstadoOficioLiqDAO() {
        super(SiiEstadoOficioLiq.class);
    }
}
