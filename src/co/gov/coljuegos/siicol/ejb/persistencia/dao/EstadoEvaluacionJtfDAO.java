/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEvaluacionJtf;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@LocalBean
public class EstadoEvaluacionJtfDAO extends GenericDAO<SiiEstadoEvaluacionJtf>
{
    /**
     * Constructor.
     */
    public EstadoEvaluacionJtfDAO() 
    {
        // Establecer la clase correspondiente a la Entidad que administra el DAO
        super(SiiEstadoEvaluacionJtf.class);
    }
}
