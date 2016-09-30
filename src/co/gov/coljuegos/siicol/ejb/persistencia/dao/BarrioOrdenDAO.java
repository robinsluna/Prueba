/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBarrioOrden;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMunicipioOrdenTrab;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona los barrios de la orden de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class BarrioOrdenDAO extends AbstractDAO<Long, SiiBarrioOrden> {

    /**
     * Constructor
     */
    public BarrioOrdenDAO() {
        super(SiiBarrioOrden.class);
    }

    /**
     * Buscar todos los barrios según código de orden de trabajo de visita.
     * @param codOrdenTrab
     * @return listaBarrioOrden - Lista de los barrios con determinada orden de trabajo de visita.
     * @throws ExcepcionDAO
     */
    public List<SiiBarrioOrden> buscarTodoBarrioOrdenXCodigoOrdenTrab(Long codOrdenTrab) throws ExcepcionDAO {
        List<SiiBarrioOrden> listaBarrioOrden = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT bot FROM SiiBarrioOrden bot");
            sql.append(" WHERE bot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrab and bot.borActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrab", codOrdenTrab);
            listaBarrioOrden = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "BarrioOrdenDAO");
        }
        return listaBarrioOrden;

    }
    
    /**
     * Indica si existe el barrio según código de la orden, nombre y municipio
     * @param codOrdenTrabajo
     * @param borNombre
     * @param ubiCodigo
     * @return resul - boolean
     * @throws ExcepcionDAO
     */
    public boolean existeBarrioOrdenXCodOrdenXNombreXMunicipio(Long codOrdenTrabajo, String borNombre, String ubiCodigo) throws ExcepcionDAO {
        boolean resul = false;
        List<SiiBarrioOrden> listaBarrioOrden = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT bor FROM SiiBarrioOrden bor");
            sql.append(" WHERE bor.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrabajo ");
            sql.append("and bor.borNombre = :borNombre and bor.siiUbicacionMunicipio.ubiCodigo = :ubiCodigo and bor.borActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrabajo", codOrdenTrabajo);
            query.setParameter("borNombre", borNombre);
            query.setParameter("ubiCodigo", ubiCodigo);
            
            listaBarrioOrden = query.getResultList();
            if (!listaBarrioOrden.isEmpty()) {
                resul = true;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "BarrioOrdenDAO");
        }
        return resul;
    }
}
