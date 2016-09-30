/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-06-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleContNomina;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class DetalleContNominaDAO extends GenericDAO<SiiDetalleContNomina> 
{
    /**
     * Constructor.
     */
    public DetalleContNominaDAO() {
        super(SiiDetalleContNomina.class);
    }
    
    
    /**
     * Obtiene el listado de Detalles de Cargue de Archivos Contables de N&oacute;mina, que se encuentran asociados al c&oacute;digo de Obligaci&oacute;n suministrado.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return List of SiiDetalleContNomina
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleContNomina> buscarPorCodigoObligacion (Long oblCodigo) throws ExcepcionDAO {
        List<SiiDetalleContNomina> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleContNomina o ");
            sql.append("WHERE o.siiObligacion.oblCodigo = :oblCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            
            resultado = query.getResultList();
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        return (resultado);
    }
}
