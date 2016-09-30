/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepInfExogena;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class ConcepInfExogenaDAO extends GenericDAO<SiiConcepInfExogena>
{
    /**
     * Constructor.
     */
    public ConcepInfExogenaDAO() {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiConcepInfExogena.class);
    }
}
