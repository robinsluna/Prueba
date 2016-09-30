package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionAlegatoProSan;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para la persistencia de registros de Recepci&oacute;n de Alegatos para Proceso Sancionatorio de Fiscalizaci&oacute;n.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class RecepcionAlegatoProSanDAO extends AbstractDAO<Long, SiiRecepcionAlegatoProSan> 
{
    /**
     * Constructor.
     */
    public RecepcionAlegatoProSanDAO() 
    {
        super(SiiRecepcionAlegatoProSan.class);
    }
    
    
    
    /**
     * Obtiene el listado de Alegatos asociados al Proceso Sancionatorio de Fiscalizaci&oacute;n correspondiente al ID especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @return Listado de SiiRecepcionAlegatoProSan.
     * @throws ExcepcionDAO
     */
    public List<SiiRecepcionAlegatoProSan> buscarRecepcionAlegatoProSanPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<SiiRecepcionAlegatoProSan> resultado = null;
        
        if (psaCodigo!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ral FROM SiiRecepcionAlegatoProSan ral ");
                sql.append("WHERE ral.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch (Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
