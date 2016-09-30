/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-08-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucSanCon;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * DAO para el manejo del Estado de Resoluciones de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class EstadoResolucSanConDAO extends AbstractDAO<Long, SiiEstadoResolucSanCon>
{
    /**
     * Constructor.
     */
    public EstadoResolucSanConDAO() 
    {
        super(SiiEstadoResolucSanCon.class);
    }
}
