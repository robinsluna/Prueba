package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulaAccCont;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class MotivoAnulaAccContDAO extends AbstractDAO<Long, SiiMotivoAnulaAccCont> {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MotivoAnulaAccContDAO() {
        super(SiiMotivoAnulaAccCont.class);
        recursos = new Recursos();
    }
}
