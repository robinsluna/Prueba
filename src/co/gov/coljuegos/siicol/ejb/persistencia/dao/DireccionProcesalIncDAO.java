package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccionProcesalInc;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Direcciones Procesales de procesos de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class DireccionProcesalIncDAO extends AbstractDAO<Long, SiiDireccionProcesalInc> 
{
    /**
     * Constructor.
     */
    public DireccionProcesalIncDAO() {
        super(SiiDireccionProcesalInc.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Direcciones Procesales asociadas al proceso de Incumplimiento Contractual especificado.
     * @param icnCodigo - C&oacute;digo del proceso de Incumplimiento.
     * @return Lista de SiiDireccionProcesalInc.
     * @throws ExcepcionDAO
     */
    public List<SiiDireccionProcesalInc> buscarDireccionProcesalIncPorIdIncumplimiento (Long icnCodigo) throws ExcepcionDAO 
    {
        List<SiiDireccionProcesalInc> resultado = null;
        
        if (icnCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dpi FROM SiiDireccionProcesalInc dpi ");
                sql.append("WHERE dpi.siiIncumplimientoContr.icnCodigo = :icnCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("icnCodigo", icnCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
                
            }
        }
        
        return (resultado);
    }
    
    public List<SiiDireccionProcesalInc> buscarDireccionProcesalIncPorPersonaInvestigada (Long icnCodigo) throws ExcepcionDAO 
    {
        List<SiiDireccionProcesalInc> resultado = null;
        
        if (icnCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dpi FROM SiiDireccionProcesalInc dpi ");
                sql.append("WHERE dpi.siiIncumplimientoContr.icnCodigo = :icnCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("icnCodigo", icnCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
                
            }
        }
        
        return (resultado);
    }
}
