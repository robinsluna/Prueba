package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoObligacionDAO extends GenericDAO<SiiEstadoObligacion>{
    
    
    public EstadoObligacionDAO() {
        super(SiiEstadoObligacion.class);
    }
}
