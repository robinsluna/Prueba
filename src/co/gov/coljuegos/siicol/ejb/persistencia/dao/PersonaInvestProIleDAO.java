package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonaInvestProIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PersonaInvestProIleDAO extends AbstractDAO<Long, SiiPersonaInvestProIle> {
    public PersonaInvestProIleDAO() {
        super(SiiPersonaInvestProIle.class);
    }

    public List<SiiPersonaInvestProIle> buscarPersonasInvestPorProcesoIleId(Long prsCodigo) throws ExcepcionDAO {
        List<SiiPersonaInvestProIle> resultado = null;

        if(prsCodigo != null) {

            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiPersonaInvestProIle o ");
                sql.append("WHERE o.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);

                resultado = query.getResultList();

            } catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }

        return (resultado);
    }
    
    public List<SiiPersonaInvestProIle> buscarPersonasInvestPorNumeroId(String identificacion) throws ExcepcionDAO {
        List<SiiPersonaInvestProIle> resultado = null;

        if(identificacion != null) {

            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiPersonaInvestProIle o ");
                sql.append("WHERE o.siiPersona.perNumIdentificacion = :identificacion ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("identificacion", identificacion);

                resultado = query.getResultList();

            } catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }

        return (resultado);
    }
}
