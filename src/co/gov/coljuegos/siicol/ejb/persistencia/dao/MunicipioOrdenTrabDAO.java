/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona los municipios de las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class MunicipioOrdenTrabDAO extends AbstractDAO<Long, SiiMunicipioOrdenTrab> {

    /**
     * Constructor.
     */
    public MunicipioOrdenTrabDAO() {
        super(SiiMunicipioOrdenTrab.class);
    }

    /**
     * Buscar los municipios con orden de trabajo según código de orden de trabajo.
     * @param codOrdenTrab
     * @return listaMunicipioOrdenTrab - Lista de municipios según código de orden de trabajo.
     * @throws ExcepcionDAO
     */
    public List<SiiMunicipioOrdenTrab> buscarTodoMunicipioOrdenTrabXCodigoOrdenTrab(Long codOrdenTrab) throws ExcepcionDAO {
        List<SiiMunicipioOrdenTrab> listaMunicipioOrdenTrab = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT mot FROM SiiMunicipioOrdenTrab mot");
            sql.append(" WHERE mot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrab and mot.motActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrab", codOrdenTrab);
            listaMunicipioOrdenTrab = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "MunicipioOrdenTrabDAO");
        }
        return listaMunicipioOrdenTrab;

    }

    /**
     * Indica si existe un municipio con orden de trabajo
     * @param codOrdenTrabajo
     * @param codUbicacion
     * @return
     * @throws ExcepcionDAO
     */
    public boolean existeMunicipioOrdenTrabXCodOrdenXCodUbicacion(Long codOrdenTrabajo, String codUbicacion) throws ExcepcionDAO {
        boolean resul = false;
        List<SiiMunicipioOrdenTrab> listaMunicipioOrdenTrab = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT mot FROM SiiMunicipioOrdenTrab mot");
            sql.append(" WHERE mot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrabajo ");
            sql.append("and mot.siiUbicacionMunicipio.ubiCodigo = :codUbicacion and mot.motActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrabajo", codOrdenTrabajo);
            query.setParameter("codUbicacion", codUbicacion);
            listaMunicipioOrdenTrab = query.getResultList();
            if (!listaMunicipioOrdenTrab.isEmpty()) {
                resul = true;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "MunicipioOrdenTrabDAO");
        }
        return resul;
    }
}
