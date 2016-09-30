/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-03-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoNomina;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Conceptos de N&oacute;mina.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ConceptoNominaDAO extends AbstractDAO<String, SiiConceptoNomina> 
{
    /**
     * Constructor.
     */
    public ConceptoNominaDAO() {
        super(SiiConceptoNomina.class);
    }
    
    
    /**
     * Obtiene el listado de Conceptos de N&oacute;mina que se encuentran en estado <i>ACTIVO</i>.
     * @return List of SiiConceptoNomina.
     * @throws ExcepcionDAO
     */
    public List<SiiConceptoNomina> buscarConceptoNominaActivos () throws ExcepcionDAO 
    {
        List<SiiConceptoNomina> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT cno FROM SiiConceptoNomina cno ");
            sql.append("WHERE cno.cnoActivo = :cnoActivo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("cnoActivo", EnumDecision.SI.getId());
            
            resultado = query.getResultList();
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Valida si el Concepto N&oacute;mina se encuentra asociado a un Comprobante Contable.
     * @param cnoCodigo - C&oacute;digo del Concepto N&oacute;mina.
     * @return Se encuentra asociado a un Comprobante Contable activo?
     * @throws ExcepcionDAO
     */
    public boolean isConceptoNominaAsociadoDocumentoContable(String cnoCodigo) throws ExcepcionDAO 
    {
        boolean asociado = false;
        
        if (cnoCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT DISTINCT cno.CNO_CODIGO ");
                sql.append("FROM SII_CONCEPTO_NOMINA cno ");
                sql.append("INNER JOIN sii_detalle_cont_nomina dct  ON  dct.CNO_CODIGO = cno.CNO_CODIGO ");
                sql.append("INNER JOIN sii_obligacion obl  ON  obl.OBL_CODIGO = dct.OBL_CODIGO ");
                sql.append("INNER JOIN sii_documento_contable dco  ON  dco.OBL_CODIGO = obl.OBL_CODIGO ");
                sql.append("WHERE dco.edo_codigo <> #edoCodigo ");
                sql.append("AND cno.CNO_CODIGO = #cnoCodigo ");
                
                Query query = em.createNativeQuery(sql.toString());
                query.setParameter("edoCodigo", EnumEstadoDocContab.ANULADO.getId());
                query.setParameter("cnoCodigo", cnoCodigo);
                
                String resultado = (String) query.getSingleResult();
                
                asociado = resultado!=null && !resultado.isEmpty();
                
            }
            catch (NoResultException e) {
                asociado = false;
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (asociado);
    }
}
