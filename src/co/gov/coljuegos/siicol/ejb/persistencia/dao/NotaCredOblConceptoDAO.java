/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 09-06-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Notas de Cr&eacute;dito por Obligaci&oacute;n Concepto.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class NotaCredOblConceptoDAO extends AbstractDAO<Long, SiiNotaCredOblConcepto> 
{
    /**
     * Constructor.
     */
    public NotaCredOblConceptoDAO() 
    {
        super(SiiNotaCredOblConcepto.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Conceptos de Obligaci&oacute;n de la Nota de Cr&eacute;dito, asociados a la Nota de Cr&eacute;dito especificada.
     * @param ncrCodigo - C&oacute;digo de la Nota de Cr&eacute;dito.
     * @return List of SiiNotaCredOblConcepto.
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredOblConcepto> buscarNotaCredOblConceptoPorIdNotaCredito (Long ncrCodigo) throws ExcepcionDAO 
    {
        List<SiiNotaCredOblConcepto> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT nco FROM SiiNotaCredOblConcepto nco ");
            sql.append("WHERE nco.siiNotaCredito.ncrCodigo = :ncrCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ncrCodigo", ncrCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Obligaci&oacute;n Concepto de la Nota de Cr&eacute;dito, asociados al registro de Obligaci&oacute;n Concepto de la Obligaci&oacute;n.
     * @param ocoCodigo - C&oacute;dito de la Obligaci&oacute;n Concepto de la Obligaci&oacute;n.
     * @return List of SiiNotaCredOblConcepto
     * @throws ExcepcionDAO
     */
    public List<SiiNotaCredOblConcepto> buscarNotaCredOblConceptoPorObligacionConcepto (Long ocoCodigo) throws ExcepcionDAO 
    {
        List<SiiNotaCredOblConcepto> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT nco FROM SiiNotaCredOblConcepto nco ");
            sql.append("WHERE nco.siiObligacionConcepto.ocoCodigo = :ocoCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ocoCodigo", ocoCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
}
