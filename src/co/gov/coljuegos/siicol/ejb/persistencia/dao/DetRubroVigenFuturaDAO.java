/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetRubroVigenFutura;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class DetRubroVigenFuturaDAO extends GenericDAO<SiiDetRubroVigenFutura> 
{
    /**
     * Constructor.
     */
    public DetRubroVigenFuturaDAO() 
    {
        super(SiiDetRubroVigenFutura.class);
    }
    
    
    /**
     * Realiza la consulta de registros de Detalle Rubro por Vigencia Futura, de acuerdo a la vigencia dada.
     * @param drvVigencia - Vigencia.
     * @return List of SiiDetRubroVigenFutura
     * @throws ExcepcionDAO
     */
    public List<SiiDetRubroVigenFutura> buscarPorVigencia (Integer drvVigencia) throws ExcepcionDAO 
    {
        return ( this.buscarPorVigencia(drvVigencia, null) );
    }
    
    
    /**
     * Realiza la consulta de registros de Detalle Rubro por Vigencia Futura, de acuerdo a la vigencia y vigencia futura dadas.
     * @param drvVigencia - Vigencia.
     * @param vfuCodigo - C&oacute;digo de la Vigencia Futura.
     * @return List of SiiDetRubroVigenFutura
     * @throws ExcepcionDAO
     */
    public List<SiiDetRubroVigenFutura> buscarPorVigencia (Integer drvVigencia, Long vfuCodigo) throws ExcepcionDAO 
    {
        List<SiiDetRubroVigenFutura> resultado = null;
        
        if (drvVigencia!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dvf from SiiDetRubroVigenFutura dvf ");
                sql.append("WHERE dvf.drvVigencia = :drvVigencia ");
                
                if (vfuCodigo!=null)
                    sql.append("AND dvf.siiVigenciaFutura.vfuCodigo = :vfuCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("drvVigencia", drvVigencia);
                
                if (vfuCodigo!=null)
                    query.setParameter("vfuCodigo", vfuCodigo);
                
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta de registros de Detalle Rubro por Vigencia Futura, de acuerdo a la vigencia futura dada.
     * @param vfuCodigo - C&oacute;digo de la Vigencia Futura.
     * @return List of SiiDetRubroVigenFutura
     * @throws ExcepcionDAO
     */
    public List<SiiDetRubroVigenFutura> buscarPorCodigoVigenciaFutura (Long vfuCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPorVigenciaFuturaEstado(vfuCodigo, null) );
    }
    
    
    /**
     * Realiza la consulta de registros de Detalle Rubro por Vigencia Futura, de acuerdo a la vigencia futura y Estado dados.
     * @param vfuCodigo - C&oacute;digo de la Vigencia Futura.
     * @param drvEstado - Estado.
     * @return List of SiiDetRubroVigenFutura
     * @throws ExcepcionDAO
     */
    public List<SiiDetRubroVigenFutura> buscarPorVigenciaFuturaEstado (Long vfuCodigo, String drvEstado) throws ExcepcionDAO 
    {
        List<SiiDetRubroVigenFutura> resultado = null;
        
        if (vfuCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dvf from SiiDetRubroVigenFutura dvf ");
                sql.append("WHERE dvf.siiVigenciaFutura.vfuCodigo = :vfuCodigo ");
                
                if (drvEstado!=null)
                    sql.append("AND dvf.drvEstado = :drvEstado ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("vfuCodigo", vfuCodigo);
                
                if (drvEstado!=null)
                    query.setParameter("drvEstado", drvEstado);
                
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la consulta de registros de Detalle Rubro por Vigencia Futura y Detalle Rubro.
     * @param vfuCodigo - C&oacute;digo de la Vigencia Futura.
     * @param druCodigo - C&oacute;digo del Detalle Rubro.
     * @return List of SiiDetRubroVigenFutura
     * @throws ExcepcionDAO
     */
    public List<SiiDetRubroVigenFutura> buscarPorVigenciaFuturaDetalleRubro (Long vfuCodigo, Long druCodigo) throws ExcepcionDAO 
    {
        List<SiiDetRubroVigenFutura> resultado = null;
        
        if (vfuCodigo!=null && druCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dvf from SiiDetRubroVigenFutura dvf ");
                sql.append("WHERE dvf.siiVigenciaFutura.vfuCodigo = :vfuCodigo ");
                sql.append("AND dvf.siiDetalleRubro.druCodigo = :druCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("vfuCodigo", vfuCodigo);
                query.setParameter("druCodigo", druCodigo);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
