package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoJuego;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class TipoJuegoDAO extends GenericDAO<SiiTipoJuego>{


    public TipoJuegoDAO() {
        super(SiiTipoJuego.class);
    }
}
