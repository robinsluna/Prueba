package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ObligacionConceptoDAO extends GenericDAO<SiiObligacionConcepto>{
    
    
    /**
     * Constructor.
     */
    public ObligacionConceptoDAO() {
        super(SiiObligacionConcepto.class);
    }
    
    
    
    /**
     * Realiza la consulta de las Recepciones de Propuesta asociadas a un Proceso de Contrataci&oacute;n.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @return listado de SiiObligacionConcepto.
     * @throws ExcepcionDAO
     */
    public List<SiiObligacionConcepto> buscarPorCodigoObligacion (Long oblCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oc FROM SiiObligacionConcepto oc, ");
            sql.append("               SiiObligacion o ");
            sql.append("WHERE o.oblCodigo = oc.siiObligacion.oblCodigo ");
            sql.append("AND o.oblCodigo = :oblCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("oblCodigo", oblCodigo);
            List<SiiObligacionConcepto> listaOC = query.getResultList();
            return listaOC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Obtiene el listado de Conceptos asociados a la Obligaci&oacute;n, RP suministrados.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of SiiObligacionConcepto
     * @throws ExcepcionDAO
     */
    public List<SiiObligacionConcepto> buscarPorCodigoObligacionRP (Long oblCodigo, Long rpCodigo) throws ExcepcionDAO  {
        return (this.buscarPorObligacionRpFuenteFinancContab(oblCodigo, rpCodigo, null));
    }
    
    
    /**
     * Obtiene el listado de Conceptos asociados al RP y Fuente de Financiaci&oacute;n Contable dados.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiObligacionConcepto
     * @throws ExcepcionDAO
     */
    public List<SiiObligacionConcepto> buscarPorRpFuenteFinancContab (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO {
        return (this.buscarPorObligacionRpFuenteFinancContab(null, rpCodigo, ffcCodigo));
    }
    
    
    /**
     * Obtiene el listado de Conceptos asociados a la Obligaci&oacute;n, RP y Fuente de Financiaci&oacute;n Contable dadas.
     * @param oblCodigo - C&oacute;digo de la Obligaci&oacute;n.
     * @param rpCodigo - C&oacute;digo del RP.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiObligacionConcepto
     * @throws ExcepcionDAO
     */
    public List<SiiObligacionConcepto> buscarPorObligacionRpFuenteFinancContab (Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oc FROM SiiObligacionConcepto oc, ");
            sql.append("               SiiObligacion o ");
            sql.append("WHERE o.oblCodigo = oc.siiObligacion.oblCodigo ");
            
            if (oblCodigo!=null)
                sql.append("AND o.oblCodigo = :oblCodigo ");
            
            if (rpCodigo!=null)
                sql.append("AND oc.siiRp.rpCodigo = :rpCodigo ");
            
            if (ffcCodigo!=null)
                sql.append("AND oc.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
            
            
            Query query = em.createQuery(sql.toString());
            
            if (oblCodigo!=null)
                query.setParameter("oblCodigo", oblCodigo);
            if (rpCodigo!=null)
                query.setParameter("rpCodigo", rpCodigo);
            if (ffcCodigo!=null)
                query.setParameter("ffcCodigo", ffcCodigo);
            
            
            List<SiiObligacionConcepto> listaOC = query.getResultList();
            return listaOC;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
}