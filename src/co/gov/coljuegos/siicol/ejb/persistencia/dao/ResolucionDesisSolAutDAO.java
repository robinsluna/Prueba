package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionDesisSolAut;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class ResolucionDesisSolAutDAO extends AbstractDAO<Long, SiiResolucionDesisSolAut> {
    
    public ResolucionDesisSolAutDAO() {
        super(SiiResolucionDesisSolAut.class);
    }
    
}

