package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcIleg;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ResolucionProcIlegDAO extends AbstractDAO<Long,SiiResolucionProcIleg>{
    public ResolucionProcIlegDAO() {
        super(SiiResolucionProcIleg.class);
    }
}
