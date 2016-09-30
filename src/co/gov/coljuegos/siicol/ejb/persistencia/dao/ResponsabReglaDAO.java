/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabRegla;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ResponsabReglaDAO extends GenericDAO<SiiResponsabRegla> 
{
    /**
     * Constructor.
     */
    public ResponsabReglaDAO() {
        super(SiiResponsabRegla.class);
    }
    
    
    
    
    /**
     * Realiza la b&uacute;squeda de la relaci&oacute;n de Responsabilidades DIAN con las Reglas de Impuestos, asociadas a la Responsabilidad DIAN especificada.
     * @param rdiCodigo - C&oacute;digo de la Responsabilidad DIAN.
     * @return List of SiiResponsabRegla
     * @throws ExcepcionDAO
     */
    public List<SiiResponsabRegla> buscarPorCodigoResponsabilidadDian (Long rdiCodigo) throws ExcepcionDAO 
    {
        List<SiiResponsabRegla> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiResponsabRegla o ");
            sql.append("WHERE o.siiResponsabilidadDian.rdiCodigo = :rdiCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("rdiCodigo", rdiCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
