/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponDianPersona;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ResponDianPersonaDAO extends GenericDAO<SiiResponDianPersona> {
    
    /**
     * Constructor.
     */
    public ResponDianPersonaDAO() {
        super(SiiResponDianPersona.class);
    }
    
    
    
    /**
     * Obtiene el listado de asociaciones de Responsabilidad DIAN con Persona por medio del c&oacute;digo de la misma.
     * @param perCodigo - C&oacute;digo de la Persona.
     * @return List of SiiResponDianPersona
     */
    public List<SiiResponDianPersona> buscarPorCodigoPersona (Long perCodigo) throws ExcepcionDAO {
        List<SiiResponDianPersona> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiResponDianPersona o ");
            sql.append("WHERE o.siiPersona.perCodigo = :perCodigo");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
