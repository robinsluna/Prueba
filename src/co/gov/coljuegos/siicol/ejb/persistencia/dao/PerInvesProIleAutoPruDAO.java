package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPerInvesProIleAutoPru;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Personas Investigadas para el Auto que Decreta Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class PerInvesProIleAutoPruDAO extends AbstractDAO<Long, SiiPerInvesProIleAutoPru> 
{
    /**
     * Constructor.
     */
    public PerInvesProIleAutoPruDAO() 
    {
        super(SiiPerInvesProIleAutoPru.class);
    }
    
    
    
    /**
     * Obtiene la lista de Personas Investigadas asociadas al Auto que Decreta Pruebas especificado.
     * @param atpCodigo - C&oacute;digo del Auto que Decreta Pruebas.
     * @return Listado de SiiPerInvesProIleAutoPru.
     * @throws ExcepcionDAO
     */
    public List<SiiPerInvesProIleAutoPru> buscarPerInvesProIleAutoPruPorIdAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO 
    {
        List<SiiPerInvesProIleAutoPru> resultado = null;
        
        if (atpCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT pau FROM SiiPerInvesProIleAutoPru pau ");
                sql.append("WHERE pau.siiAutoDecretaPrueProIle.atpCodigo = :atpCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("atpCodigo", atpCodigo);
                
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
