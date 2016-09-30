package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialPermiso;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HistorialPermisoDAO extends GenericDAO<SiiHistorialPermiso> {
    public HistorialPermisoDAO() {
        super(SiiHistorialPermiso.class);
    }
}
