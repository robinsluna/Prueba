/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIca;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ActividadIcaDAO extends GenericDAO<SiiActividadIca> {
    
    /**
     * Constructor.
     */
    public ActividadIcaDAO() {
        super(SiiActividadIca.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Actividad ICA correspondiente al c&oacute;digo especificado.
     * @param aicCodigo - C&oacute;digo de la Actividad ICA a buscar.
     * @return instance of SiiActividadIca
     * @throws ExcepcionDAO
     */
    public SiiActividadIca buscarPorCodigoActividadIca (String aicCodigo) throws ExcepcionDAO {
        SiiActividadIca resultado = null;
        
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aic FROM SiiActividadIca aic ");
            sql.append("WHERE aic.aicCodigo = :aicCodigo ");
            sql.append("ORDER BY aic.aicCodigo ASC ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("aicCodigo", aicCodigo);
            
            resultado = (SiiActividadIca) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            resultado = null;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    /**
     * Elimina la actividad ICA correspondiente al c&oacute;digo suministrado.
     * @param aicCodigo - C&oacute;digo de la actividad ICA que se desea eliminar.
     * @throws ExcepcionDAO
     */
    public void borrarActividadIca (String aicCodigo) throws ExcepcionDAO {
        SiiActividadIca siiActividadIca = null;
        
        try {
            siiActividadIca = em.find(SiiActividadIca.class, aicCodigo);
            if (siiActividadIca!=null) {
                em.remove(siiActividadIca);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
}
