/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaDestruccion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Data access object que gestiona las actas de destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
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
