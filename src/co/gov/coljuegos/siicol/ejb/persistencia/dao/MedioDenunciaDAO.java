package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMedioDenuncia;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class MedioDenunciaDAO extends AbstractDAO<Long, SiiMedioDenuncia> {

    public MedioDenunciaDAO() {
        
        super(SiiMedioDenuncia.class);
        
        
    }
}
