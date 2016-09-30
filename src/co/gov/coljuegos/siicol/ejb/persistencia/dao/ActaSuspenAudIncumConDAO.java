package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaSuspenAudIncumCon;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Actas de Suspensi&oacute;n de Audiencia en procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ActaSuspenAudIncumConDAO extends AbstractDAO<Long, SiiActaSuspenAudIncumCon> 
{
    /**
     * Constructor.
     */
    public ActaSuspenAudIncumConDAO() 
    {
        super(SiiActaSuspenAudIncumCon.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de las Actas de Suspensi&oacute;n de la Audiencia que se encuentran asociadas al proceso de Incumplimiento Contractual.
     * @param icnCodigo - C&oacute;digo del proceso de Incumplimiento Contractual.
     * @return Listado de Actas de Suspensi&oacute;n de la Audiencia.
     * @throws ExcepcionDAO
     */
    public List<SiiActaSuspenAudIncumCon> buscarActaSuspenAudPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO 
    {
        List<SiiActaSuspenAudIncumCon> resultado = null;
        
        if (icnCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT asa FROM SiiActaSuspenAudIncumCon asa ");
                sql.append("WHERE asa.siiIncumplimientoContr.icnCodigo = :icnCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("icnCodigo", icnCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
