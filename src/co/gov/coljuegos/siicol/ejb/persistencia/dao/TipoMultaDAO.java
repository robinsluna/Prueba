package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoMulta;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Data Access Object para el manejo de Tipos de Multa.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class TipoMultaDAO extends AbstractDAO<Long, SiiTipoMulta> 
{
    /**
     * Constructor.
     */
    public TipoMultaDAO () 
    {
        super(SiiTipoMulta.class);
    }
}
