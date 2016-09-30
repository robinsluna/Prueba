package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoIncumplContract;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoIncumplContractDAO extends AbstractDAO<Long, SiiEstadoIncumplContract> {
    public EstadoIncumplContractDAO() {
        super(SiiEstadoIncumplContract.class);
    }


    public SiiEstadoIncumplContract buscarEstadoPorNombre(String eicNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoIncumplContract o WHERE o.eicNombre=:eicNombre");            
            Query query = em.createQuery(sql.toString());
            query.setParameter("eicNombre",eicNombre);
            return (SiiEstadoIncumplContract) query.getSingleResult();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoIncumplContractDAO");
        }
    }
}
