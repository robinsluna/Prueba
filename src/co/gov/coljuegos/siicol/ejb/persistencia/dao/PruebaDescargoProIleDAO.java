package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaDescargoProIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Pruebas de Descargo del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class PruebaDescargoProIleDAO extends AbstractDAO<Long, SiiPruebaDescargoProIle> 
{
    /**
     * Constructor.
     */
    public PruebaDescargoProIleDAO () 
    {
        super(SiiPruebaDescargoProIle.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Pruebas asociadas al Descargo del Proceso Sancionatorio de Ilegalidad especificado.
     * @param dprCodigo - C&oacute;digo del Descargo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiPruebaDescargoProIle.
     * @throws ExcepcionDAO
     */
    public List<SiiPruebaDescargoProIle> buscarPruebaDescargoProIlePorIdDescargo (Long dprCodigo) throws ExcepcionDAO 
    {
        List<SiiPruebaDescargoProIle> resultado = null;
        
        if (dprCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT pdp FROM SiiPruebaDescargoProIle pdp ");
                sql.append("WHERE pdp.siiDescargoProcIleg.dprCodigo = :dprCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("dprCodigo", dprCodigo);
                
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
