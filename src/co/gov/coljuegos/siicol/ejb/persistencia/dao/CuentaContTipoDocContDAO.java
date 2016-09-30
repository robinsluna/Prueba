/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Mónica Pabón
 * FECHA	: 11-02-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CuentaContTipoDocContDAO extends GenericDAO<SiiCuentaContTipoDocCont> {
    
    /**
     * Constructor.
     */
    public CuentaContTipoDocContDAO() {
        super(SiiCuentaContTipoDocCont.class);
    }
    
     
    public List<SiiCuentaContTipoDocCont> buscarSiiCuentaContTipoDocContPorTipoDoc(String tipoDocumento) throws ExcepcionDAO {
        List<SiiCuentaContTipoDocCont> lista = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiCuentaContTipoDocCont o INNER JOIN o.siiTipoDocContable pc WHERE pc.tdcCodigo = :tipoDocumento and o.cctActivo='S'");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDocumento", tipoDocumento);
            lista = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
        return lista;

    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de SiiCuentaContTipoDocCont a trav&eacute;s del Tipo de Documento Contable, el Concepto, el N&uacute;mero de Identificaci&oacute;n, el Tipo de Retenci&oacute;n y la Fuente de Financiaci&oacute;n Contable.
     * @param tdcCodigo - Tipo de Documento Contable.
     * @param cctConcepto - Concepto Contable.
     * @param perNumIdentificacion - N&uacute;mero de Identificaci&oacute;n del tercero.
     * @param cctTipoRetNomina - C&oacute;digo del Tipo de Retenci&oacute;n.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiCuentaContTipoDocCont
     * @throws ExcepcionDAO
     */
    public List<SiiCuentaContTipoDocCont> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo, String cctConcepto, String perNumIdentificacion, String cctTipoRetNomina, String ffcCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(tdcCodigo, cctConcepto, perNumIdentificacion, cctTipoRetNomina, ffcCodigo, false) );
    }
    
    
    
     /**
      * Realiza la b&uacute;squeda de SiiCuentaContTipoDocCont a trav&eacute;s del Tipo de Documento Contable, el Concepto, el N&uacute;mero de Identificaci&oacute;n, el Tipo de Retenci&oacute;n y la Fuente de Financiaci&oacute;n Contable.
      * @param tdcCodigo - Tipo de Documento Contable.
      * @param cctConcepto - Concepto Contable.
      * @param perNumIdentificacion - N&uacute;mero de Identificaci&oacute;n del tercero.
      * @param cctTipoRetNomina - C&oacute;digo del Tipo de Retenci&oacute;n.
      * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
      * @param buscarCuentasSinConcepto - Flag que determina si la b&uacute;squeda se realiza &uacute;nicamente para Cuentas que no poseen Concepto asociado.
      * @return List of SiiCuentaContTipoDocCont
      * @throws ExcepcionDAO
      */
     public List<SiiCuentaContTipoDocCont> buscarPorTipoDocConceptoNumIdentificacionTipoRetencionFFC(String tdcCodigo, String cctConcepto, String perNumIdentificacion, String cctTipoRetNomina, String ffcCodigo, boolean buscarCuentasSinConcepto) throws ExcepcionDAO 
     {
         List<SiiCuentaContTipoDocCont> lista = null;
         try {
             StringBuilder sql = new StringBuilder();
             sql.append("SELECT o from SiiCuentaContTipoDocCont o ");
             sql.append("INNER JOIN o.siiTipoDocContable pc ");
             sql.append("WHERE o.cctCodigo = o.cctCodigo ");
             sql.append("AND o.cctActivo = :cctActivo ");
             
             if (tdcCodigo!=null)
                sql.append("AND pc.tdcCodigo = :tdcCodigo ");
             
             if (cctConcepto!=null) {
                 sql.append("AND o.cctConcepto = :cctConcepto ");
             }
             else {
                 if (buscarCuentasSinConcepto)
                    sql.append("AND o.cctConcepto IS NULL ");
             }
             
             if (perNumIdentificacion!=null)
                 sql.append("AND o.siiPersona.perNumIdentificacion = :perNumIdentificacion ");
             
             if (cctTipoRetNomina!=null)
                 sql.append("AND o.cctTipoRetNomina = :cctTipoRetNomina ");
             
             if (ffcCodigo!=null)
                 sql.append("AND o.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
             
             
             Query query = em.createQuery(sql.toString());
             query.setParameter("cctActivo", EnumDecision.SI.getId());
             
             if (tdcCodigo!=null)
                query.setParameter("tdcCodigo", tdcCodigo);
             if (cctConcepto!=null)
                 query.setParameter("cctConcepto", cctConcepto);  
             if (perNumIdentificacion!=null)
                 query.setParameter("perNumIdentificacion", perNumIdentificacion);
             if (cctTipoRetNomina!=null)
                 query.setParameter("cctTipoRetNomina", cctTipoRetNomina);
             if (ffcCodigo!=null)
                 query.setParameter("ffcCodigo", ffcCodigo);
             
             
             lista = query.getResultList();
             

         } catch (PersistenceException pe) {
             String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
         }
         return lista;
     }
    
    
    public List<SiiCuentaContTipoDocCont> buscarSiiCuentaContTipoDocContPorTipoDocYConcepto(String tipoDocumento, String concepto) throws ExcepcionDAO {
        List<SiiCuentaContTipoDocCont> lista = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiCuentaContTipoDocCont o INNER JOIN o.siiTipoDocContable pc " );
            sql.append(" WHERE pc.tdcCodigo = :tipoDocumento and o.cctConcepto=:concepto and o.cctActivo='S'");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tipoDocumento", tipoDocumento);
            query.setParameter("concepto", concepto);
            lista = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
        return lista;

    }
}
