/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-01-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class EstadoCierreAnualContDAO extends GenericDAO<SiiEstadoCierreAnualCont> 
{
    /**
     * Constructor.
     */
    public EstadoCierreAnualContDAO () 
    {
        super(SiiEstadoCierreAnualCont.class);
    }
}
