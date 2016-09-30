/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class TipoDocSopSolicPagoDAO extends GenericDAO<SiiTipoDocSopSolicPago> {
    
    /**
     * Constructor.
     */
    public TipoDocSopSolicPagoDAO() 
    {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiTipoDocSopSolicPago.class);
    }
}
