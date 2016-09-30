package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcSanIleg;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoProcSanIlegDAO   extends AbstractDAO<Long,SiiEstadoProcSanIleg>{
    public EstadoProcSanIlegDAO() {
        super(SiiEstadoProcSanIleg.class);
    }
}
