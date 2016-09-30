package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogActividad;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class LogActividadDAO extends GenericDAO<SiiLogActividad>{
    public LogActividadDAO() {
        super(SiiLogActividad.class);
    }
}
