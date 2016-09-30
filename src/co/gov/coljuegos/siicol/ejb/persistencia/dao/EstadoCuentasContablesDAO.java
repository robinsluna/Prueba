package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCuentaContable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoCuentasContablesDAO extends GenericDAO<SiiEstadoCuentaContable>{
    public EstadoCuentasContablesDAO() {
        super(SiiEstadoCuentaContable.class);
    }
}
