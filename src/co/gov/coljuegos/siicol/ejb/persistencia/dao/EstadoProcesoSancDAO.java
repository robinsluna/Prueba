package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcesoSanc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo del Estado de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class EstadoProcesoSancDAO extends AbstractDAO<Long, SiiEstadoProcesoSanc> 
{
    /**
     * Constructor.
     */
    public EstadoProcesoSancDAO() 
    {
        super(SiiEstadoProcesoSanc.class);
    }

    public SiiEstadoProcesoSanc buscarEstadoPorNombre(String epsNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoProcesoSanc o WHERE o.epsNombre=:epsNombre");            
            Query query = em.createQuery(sql.toString());
            query.setParameter("epsNombre",epsNombre);
            return (SiiEstadoProcesoSanc) query.getSingleResult();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoProcesoSancDAO");
        }

    }
}
