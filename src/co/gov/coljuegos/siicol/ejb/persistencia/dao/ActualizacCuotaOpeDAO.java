package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActualizacCuotaOpe;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActualizacionMulta;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ActualizacCuotaOpeDAO extends GenericDAO<SiiActualizacCuotaOpe>{
    public ActualizacCuotaOpeDAO(){
        super(SiiActualizacCuotaOpe.class);
    }
}
