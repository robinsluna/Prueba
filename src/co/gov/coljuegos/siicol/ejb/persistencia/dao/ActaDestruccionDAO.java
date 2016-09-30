/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Data access object que gestiona las actas de destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
 */

@Stateless
@LocalBean
public class ActaDestruccionDAO extends AbstractDAO<Long, SiiActaDestruccion>{
    
    /**
     * Constructor.
     */
    
    public ActaDestruccionDAO() {
        super(SiiActaDestruccion.class);
    }
}
