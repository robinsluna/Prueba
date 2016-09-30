package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResProcIleg;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class EstadoTramResProcIlegDAO  extends AbstractDAO<Long,SiiEstadoTramResProcIleg>{
    public EstadoTramResProcIlegDAO() {
        super(SiiEstadoTramResProcIleg.class);
    }
}
