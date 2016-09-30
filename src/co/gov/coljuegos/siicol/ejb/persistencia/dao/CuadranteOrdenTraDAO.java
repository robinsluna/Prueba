/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona los cuadrantes de la orden de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class CuadranteOrdenTraDAO extends AbstractDAO<Long, SiiCuadranteOrdenTra> {

    /**
     * Constructor
     */
    public CuadranteOrdenTraDAO() {
        super(SiiCuadranteOrdenTra.class);
    }

    /**
     * Buscar todos los cuadrantes según el código de la orden de trabajo de visita.
     * @param codOrdenTrab
     * @return listaCuadranteOrdenTra - Lista de los cuadrantes de la orden de trabajo de visita.
     * @throws ExcepcionDAO
     */
    public List<SiiCuadranteOrdenTra> buscarTodoCuadranteXOrdenTrab(Long codOrdenTrab) throws ExcepcionDAO {
        List<SiiCuadranteOrdenTra> listaCuadranteOrdenTra = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cot FROM SiiCuadranteOrdenTra cot");
            sql.append(" WHERE cot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrab and cot.cotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrab", codOrdenTrab);
            listaCuadranteOrdenTra = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CuadranteOrdenTraDAO");
        }
        return listaCuadranteOrdenTra;

    }

    /**
     * Indica si existe ese cuadrante con orden de trabajo de visita.
     * @param codOrdenTrabajo
     * @return resul - boolean
     * @throws ExcepcionDAO
     */
    public boolean existeCuadranteOrdenTraXCodOrden(Long codOrdenTrabajo, String limite1, String limite2,
                                                    String limite3, String limite4) throws ExcepcionDAO {
        boolean resul = false;
        List<SiiCuadranteOrdenTra> listaCuadranteOrdenTra = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT cot FROM SiiCuadranteOrdenTra cot");
            sql.append(" WHERE cot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrabajo ");
            sql.append("and cot.cotLimite1 = :limite1 and cot.cotLimite2 = :limite2 and cot.cotLimite3 = :limite3 ");
            sql.append("and cot.cotLimite4 = :limite4 and cot.cotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrabajo", codOrdenTrabajo);
            query.setParameter("limite1", limite1);
            query.setParameter("limite2", limite2);
            query.setParameter("limite3", limite3);
            query.setParameter("limite4", limite4);
            listaCuadranteOrdenTra = query.getResultList();
            if (!listaCuadranteOrdenTra.isEmpty()) {
                resul = true;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CuadranteOrdenTraDAO");
        }
        return resul;
    }
}
