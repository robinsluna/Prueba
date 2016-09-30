package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoRetenc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class GrupoRetencDAO extends GenericDAO<SiiGrupoRetenc>{


    public GrupoRetencDAO() {
        super(SiiGrupoRetenc.class);
    }
}
