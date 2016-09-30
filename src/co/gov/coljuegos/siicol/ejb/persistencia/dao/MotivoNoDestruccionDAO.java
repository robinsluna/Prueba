/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoNoDestruccion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Data Access Object que gestiona los motivos de no destrucción
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class MotivoNoDestruccionDAO extends AbstractDAO<Long, SiiMotivoNoDestruccion> {

    /**
     * Constructor.
     */

    public MotivoNoDestruccionDAO() {
        super(SiiMotivoNoDestruccion.class);
    }
}
