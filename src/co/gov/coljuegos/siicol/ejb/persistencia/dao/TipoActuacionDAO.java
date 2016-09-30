package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoActuacion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class TipoActuacionDAO extends AbstractDAO<Long, SiiTipoActuacion> {


    public TipoActuacionDAO() {
        super(SiiTipoActuacion.class);
    }

    public SiiTipoActuacion buscarTipoActuacionPorNombre(String tipoActuacion) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoActuacion o WHERE o.tacNombre = :tipoActuacion");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoActuacion", tipoActuacion);
            return (SiiTipoActuacion) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoActuacionDAO");
        }
    }
}
