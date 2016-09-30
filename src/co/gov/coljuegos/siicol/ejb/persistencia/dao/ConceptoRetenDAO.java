/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoReten;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


@Stateless
@LocalBean
public class ConceptoRetenDAO extends GenericDAO<SiiConceptoReten> {

    /**
     * Constructor.
     */
    public ConceptoRetenDAO() {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiConceptoReten.class);
    }
}
