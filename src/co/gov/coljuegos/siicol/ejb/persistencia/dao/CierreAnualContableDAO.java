/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-01-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoCierreAnCont;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreAnualContable;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CierreAnualContableDAO extends GenericDAO<SiiCierreAnualContable> 
{
    /**
     * Constructor.
     */
    public CierreAnualContableDAO () 
    {
        super(SiiCierreAnualContable.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de registros de Cierre Anual Contable por Vigencia.
     * @param cacVigencia - Vigencia asociada al Cierre Anual Contable.
     * @return Lista de registros de Cierre Anual Contable.
     * @throws ExcepcionDAO
     */
    public List<SiiCierreAnualContable> buscarPorVigencia (Integer cacVigencia) throws ExcepcionDAO 
    {
        return (this.buscarTodoPorVigenciaYEstado(cacVigencia, null));
    }
    


    /**
     * Realiza la b&uacute;squeda de registros de Cierre Anual Contable <i>APROBADOS</i>.
     * @return Lista de registros de Cierre Anual Contable.
     * @throws ExcepcionDAO
     */
    public List<SiiCierreAnualContable> buscarCierresAprobados () throws ExcepcionDAO 
    {
        return (this.buscarTodoPorVigenciaYEstado(null, EnumEstadoCierreAnCont.APROBADO.getId()));
    }
    
    
    
    /**
     * Realiza la consulta del registro de Cierre Anual Contable asociado a la Vigencia y Estado suministrados.
     * @param cacVigencia - Vigencia asociada al Cierre Anual Contable.
     * @param ecaCodigo - C&oacute;digo del Estado del Cierre Anual Contable.
     * @return Registro de Cierre Anual Contable.
     * @throws ExcepcionDAO
     */
    public SiiCierreAnualContable buscarPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO 
    {
        SiiCierreAnualContable resultado = null;
        if (cacVigencia!=null && ecaCodigo!=null) {
            List<SiiCierreAnualContable> lista = this.buscarTodoPorVigenciaYEstado(cacVigencia, ecaCodigo);
            if (lista!=null && !lista.isEmpty()) {
                resultado = lista.get(0);
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de registros de Cierre Anual Contable asociados a la Vigencia y Estado suministrados.
     * @param cacVigencia - Vigencia asociada al Cierre Anual Contable.
     * @param ecaCodigo - C&oacute;digo del Estado del Cierre Anual Contable.
     * @return Lista de registros de Cierre Anual Contable.
     * @throws ExcepcionDAO
     */
    public List<SiiCierreAnualContable> buscarTodoPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO 
    {
        List<SiiCierreAnualContable> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cac FROM SiiCierreAnualContable cac ");
            sql.append("WHERE cac.cacCodigo = cac.cacCodigo ");
            
            if (cacVigencia!=null)
                sql.append("AND cac.cacVigencia = :cacVigencia ");
            
            if (ecaCodigo!=null)
                sql.append("AND cac.siiEstadoCierreAnualCont.ecaCodigo = :ecaCodigo ");
            
            Query query = em.createQuery(sql.toString());
            
            if (cacVigencia!=null)
                query.setParameter("cacVigencia", cacVigencia);
            
            if (ecaCodigo!=null)
                query.setParameter("ecaCodigo", ecaCodigo);
            
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
