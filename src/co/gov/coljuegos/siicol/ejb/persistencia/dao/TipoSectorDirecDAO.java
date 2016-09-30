package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSectorDirec;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean

public class TipoSectorDirecDAO extends AbstractDAO<Long, SiiTipoSectorDirec> {
    
    
    public TipoSectorDirecDAO() {
        super(SiiTipoSectorDirec.class);
    }
}
