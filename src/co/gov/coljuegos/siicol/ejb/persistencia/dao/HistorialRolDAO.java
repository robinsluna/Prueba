package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistorialRol;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class HistorialRolDAO extends GenericDAO<SiiHistorialRol> {
    public HistorialRolDAO() {
        super(SiiHistorialRol.class);
    }
}
