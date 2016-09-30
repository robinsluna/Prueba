/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoNoDestruccion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Data Access Object que gestiona los motivos de no destrucci�n
 * @author PAOLA ANDREA RUEDA LE�N
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
