/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-06-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;

import java.util.List;


import java.math.BigDecimal;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

import javax.persistence.NoResultException;



/**
 * Data Access Object para el manejo de Notas de Cr&eacute;dito.
 * @author Camilo Miranda
 */


@Stateless
@LocalBean
public class NotaCreditoDAO extends AbstractDAO<Long, SiiNotaCredito>
{
    
    /**
     * Constructor.
     */
    public NotaCreditoDAO() 
    {
        super(SiiNotaCredito.class);
    }

    
    
    public List<SiiNotaCredito> buscarTodoNotaCreditoAprobado(String estado) throws ExcepcionDAO {
        List<SiiNotaCredito> listaSiiNotaCredito = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT n from SiiNotaCredito n  WHERE  (n.ncrEstado = :estado  and n.ncrTipoNota='CFP' )  ");
            sql.append(" or (n.ncrEstado = :estado  and n.ncrTipoNota='CPR' and n.ncrRcIndepend='S'   ) order by n.ncrNumero desc" );
            Query query = em.createQuery(sql.toString());
            query.setParameter("estado",estado);
            listaSiiNotaCredito = query.getResultList();
            return listaSiiNotaCredito;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
        
    }    
    
  
    
    
    
    /**
     * Obtiene el consecutivo de la Nota de Cr&eacute;dito, correspondiente al tipo especificado.
     * @param ncrTipoNota - Tipo de la Nota de Cr&eacute;dito.
     * @return notaCredito.numero.nextval[ncrTipoNota]
     * @throws ExcepcionDAO
     */
    public Integer obtenerConsecutivoNotaCredito (String ncrTipoNota) throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        
        try{
            StringBuilder sql = new StringBuilder();
            
            
            sql.append("SELECT NVL(MAX(nc.NCR_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM SII_NOTA_CREDITO nc "); 
            sql.append("WHERE nc.NCR_NUMERO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            if (ncrTipoNota!=null) {
                sql.append("AND nc.NCR_TIPO_NOTA = #ncrTipoNota ");
            }
            
            Query query = em.createNativeQuery(sql.toString());
            
            if (ncrTipoNota!=null)
                query.setParameter("ncrTipoNota", ncrTipoNota);
            
            Object result = query.getSingleResult();
            if(result != null){
                consecutivo = new Integer(((BigDecimal)result).intValueExact());
            }
            
        }
        catch (NoResultException e) {
            consecutivo = null;
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (consecutivo);
    }
    
    
    
    /**
     * Obtiene la fecha de la &uacute;ltima nota de cr&eacute;dito registrada.
     * @param ncrTipoNota - Tipo de Nota de Cr&eacute;dito.
     * @return notasCredito->last.ncrFecha
     * @throws ExcepcionDAO
     */
    public Date obtenerUltimaFechaRegistrada (String ncrTipoNota) throws ExcepcionDAO 
    {
        Date ultimaFecha = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(NCR_FECHA) FROM SII_NOTA_CREDITO ");
            sql.append("WHERE NCR_TIPO_NOTA = #ncrTipoNota ");
            
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("ncrTipoNota", ncrTipoNota);
            
            ultimaFecha = (Date) query.getSingleResult();
        }
        catch (NoResultException e) {
            ultimaFecha = null;
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }
        
        return (ultimaFecha);
    }
    
    
    /**
     * Busca el listado de Notas de Cr&eacute;dito que se encuentran asociados al Tipo de Nota de Cr&eacute;dito especificado.
     * @param ncrTipoNota - Tipo de Nota de Cr&eacute;dito.
     * @return List of SiiNotaCredito.
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredito> buscarNotaCreditoPorTipo (String ncrTipoNota) throws ExcepcionDAO 
    {
        List<SiiNotaCredito> resultado = null;
        
        if (ncrTipoNota!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ncr FROM SiiNotaCredito ncr ");
                sql.append("WHERE ncr.ncrTipoNota = :ncrTipoNota ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ncrTipoNota", ncrTipoNota);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Busca el listado de Notas de Cr&eacute;dito que se encuentran asociados a la Obligaci&oacute;n especificada.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return List of SiiNotaCredito.
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredito> buscarNotaCreditoPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO 
    {
        List<SiiNotaCredito> resultado = null;
        
        if (oblCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ncr FROM SiiNotaCredito ncr ");
                sql.append("WHERE ncr.siiObligacion.oblCodigo = :oblCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("oblCodigo", oblCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    /**
     * Busca el listado de Notas de Cr&eacute;dito que se encuentran asociados a la Obligaci&oacute;n, Fuente de Financiaci&oacute;n Contable, TipoNota especificada.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @param ncrTipoNota - Tipo de Nota de Cr&eacute;dito.
     * @param ncrEstado - Estado de la Nota de Cr&eacute;dito.
     * @return List of SiiNotaCredito.
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredito> buscarNotaCreditoPorObligacionFFCTipoNotaEstado(Long oblCodigo, String ffcCodigo, String ncrTipoNota, String ncrEstado) throws ExcepcionDAO 
    {
        List<SiiNotaCredito> resultado = null;
        
        if (oblCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ncr FROM SiiNotaCredito ncr ");
                sql.append("WHERE ncr.ncrCodigo = ncr.ncrCodigo ");
                
                if (oblCodigo!=null)
                    sql.append("AND ncr.siiObligacion.oblCodigo = :oblCodigo ");
                if (ffcCodigo!=null)
                    sql.append("AND ncr.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
                if (ncrTipoNota!=null)
                    sql.append("AND ncr.ncrTipoNota = :ncrTipoNota ");
                if (ncrEstado!=null)
                    sql.append("AND ncr.ncrEstado = :ncrEstado ");
                
                
                Query query = em.createQuery(sql.toString());
                if (oblCodigo!=null)
                    query.setParameter("oblCodigo", oblCodigo);
                if (ffcCodigo!=null)
                    query.setParameter("ffcCodigo", ffcCodigo);
                if (ncrTipoNota!=null)
                    query.setParameter("ncrTipoNota", ncrTipoNota);
                if (ncrEstado!=null)
                    query.setParameter("ncrEstado", ncrEstado);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
    
    
    
    public SiiNotaCredito buscarPorCodigoNotaCredito(Long ncrCodigo) throws ExcepcionDAO {
        SiiNotaCredito retornoSiiNotaCredito = null;
        try {
            retornoSiiNotaCredito = (SiiNotaCredito) em.find(SiiNotaCredito.class, ncrCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
        return retornoSiiNotaCredito;

    }
    
}
