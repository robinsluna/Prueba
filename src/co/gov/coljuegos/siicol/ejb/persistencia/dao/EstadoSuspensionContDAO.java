package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSuspensionCont;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoSuspensionContDAO extends AbstractDAO<Long, SiiEstadoSuspensionCont>{
    public EstadoSuspensionContDAO() {
        super(SiiEstadoSuspensionCont.class);
    }

    public SiiEstadoSuspensionCont buscarEstadoPorNombre(String escNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoSuspensionCont o WHERE o.escNombre = :escNombre");
            Query query = em.createQuery(sql.toString());
            query.setParameter("escNombre",escNombre);
            return (SiiEstadoSuspensionCont) query.getSingleResult();

        } catch (PersistenceException pe) {
            String mensajeError = "No se encuentra el estado. " + recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoSuspensionContDAO");
        }
    }
}
