package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoProcesoIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Elementos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ElementoProcesoIleDAO extends AbstractDAO<Long, SiiElementoProcesoIle> 
{
    /**
     * Constructor.
     */
    public ElementoProcesoIleDAO() 
    {
        super(SiiElementoProcesoIle.class);
    }
    
    
    /**
     * Consulta el listado de Elementos asociados al Proceso Sancionatorio de Ilegalidad especificado.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiElementoProcesoIle.
     * @throws ExcepcionDAO
     */
    public List<SiiElementoProcesoIle> buscarElementoProcesoIlePorIdProceso (Long prsCodigo) throws ExcepcionDAO 
    {
        List<SiiElementoProcesoIle> resultado = null;
        
        if (prsCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT epr FROM SiiElementoProcesoIle epr ");
                sql.append("WHERE epr.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");
                sql.append("AND epr.eprActivo = :eprActivo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);
                query.setParameter("eprActivo", EnumDecision.SI.getId());
                
                resultado = query.getResultList();
                
            }
            catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
