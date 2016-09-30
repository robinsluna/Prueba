package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOtrosi;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoOtrosiDAO extends GenericDAO<SiiEstadoOtrosi>{

    public EstadoOtrosiDAO() {
        super(SiiEstadoOtrosi.class);
    }

    public SiiEstadoOtrosi buscarEstadoOtroSiPorNombre(String eosNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoOtrosi o WHERE o.eosNombre = :eosNombre");
            Query query = em.createQuery(sql.toString());
            query.setParameter("eosNombre", eosNombre);
            return (SiiEstadoOtrosi) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoOtrosiDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoOtrosiDAO");
        }
    }
}

