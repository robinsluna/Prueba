/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-06-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcDetRub;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Notas de Cr&eacute;dito por Obligaci&oacute;n/Detalle Rubro CDP.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class NotaCredOblConcDetRubDAO extends AbstractDAO<Long, SiiNotaCredOblConcDetRub>
{
    /**
     * Constructor.
     */
    public NotaCredOblConcDetRubDAO () 
    {
        super(SiiNotaCredOblConcDetRub.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Obligaci&oacute;n/Detalle Rubro/RP asociados a la Nota de Cr&eacute;dito especificada.
     * @param ncrCodigo - C&oacute;digo de la Nota de Cr&eacute;dito.
     * @return List of SiiNotaCredOblConcDetRub.
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredOblConcDetRub> buscarNotaCredOblConcDetRubPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO 
    {
        List<SiiNotaCredOblConcDetRub> resultado = null;
        
        if (ncrCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                
                sql.append("SELECT ndr FROM SiiNotaCredOblConcDetRub ndr ");
                sql.append("WHERE ndr.siiNotaCredito.ncrCodigo = :ncrCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ncrCodigo", ncrCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
