package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MotivoDevolucionDAO extends GenericDAO<SiiMotivoDevolucion>{


    public MotivoDevolucionDAO() {
        super(SiiMotivoDevolucion.class);
    }
}
