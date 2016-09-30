package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPruebaAutoDecrPru;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Pruebas del Auto que Decreta Pruebas del Proceso Sancionatorio de Ilegalidad.
 * @author Carlos Arciniegas
 */
@Stateless
@LocalBean
public class PruebaAutoDecrPruDAO extends AbstractDAO<Long, SiiPruebaAutoDecrPru>
{
    /**
     * Constructor.
     */
    public PruebaAutoDecrPruDAO() 
    {
        super(SiiPruebaAutoDecrPru.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Pruebas asociadas al Auto que Decreta Pruebas especificado.
     * @param atpCodigo - C&oacute;digo del Auto que Decreta Pruebas.
     * @return Listado de SiiPruebaAutoDecrPru.
     * @throws ExcepcionDAO
     */
    public List<SiiPruebaAutoDecrPru> buscarPruebaAutoDecrPruPorIdAutoDecretaPrueProIle (Long atpCodigo) throws ExcepcionDAO 
    {
        List<SiiPruebaAutoDecrPru> resultado = null;
        
        if (atpCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT pap FROM SiiPruebaAutoDecrPru pap ");
                sql.append("WHERE pap.siiAutoDecretaPrueProIle.atpCodigo = :atpCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("atpCodigo", atpCodigo);
                
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
