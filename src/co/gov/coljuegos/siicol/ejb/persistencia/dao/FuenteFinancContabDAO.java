/*
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-01-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class FuenteFinancContabDAO extends GenericDAO<SiiFuenteFinancContab> 
{
    /**
     * Constructor.
     */
    public FuenteFinancContabDAO() {
        super(SiiFuenteFinancContab.class);
    }
    
    
    
    /**
     * Realiza la consulta de Fuente de Financiaci&oacute;n Contable por C&oacute;digo.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return SiiFuenteFinancContab
     * @throws ExcepcionDAO
     */
    public SiiFuenteFinancContab buscarPorCodigo (String ffcCodigo) throws ExcepcionDAO {
       SiiFuenteFinancContab siiFuenteFinancContab = null;
        try{
            siiFuenteFinancContab = em.find(SiiFuenteFinancContab.class, ffcCodigo);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return siiFuenteFinancContab; 
    }
    
    
    
    /**
     * Realiza la eliminaci&oacute;n de la Fuente de Financiaci&oacute;n Contable basada en el C&oacute;digo.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return SiiFuenteFinancContab
     * @throws ExcepcionDAO
     */
    public void eliminar (String ffcCodigo) throws ExcepcionDAO {
        try{
            SiiFuenteFinancContab siiFuenteFinancContab = em.find(SiiFuenteFinancContab.class, ffcCodigo);
            em.remove(siiFuenteFinancContab);
            em.flush();
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Consulta el listado de Fuentes de Financiaci&oacute;n Contables relacionadas con el c&oacute;digo de RP especificado.
     * @param rpCodigo - C&oacute;digo del RP.
     * @return List of SiiFuenteFinancContab
     * @throws ExcepcionDAO
     */
    public List<SiiFuenteFinancContab> buscarFuenteFinancContabPorRp(Long rpCodigo) throws ExcepcionDAO {
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ffc FROM SiiFuenteFinancContab ffc, "); 
            sql.append("                SiiRp rp, ");
            sql.append("                SiiRpDetRubroCdp rpdrcdp, ");
            sql.append("                SiiDetalleRubroCdp drcdp, ");
            sql.append("                SiiDetalleRubro dr "); 
            sql.append("WHERE rpdrcdp.siiRp.rpCodigo = rp.rpCodigo ");
            sql.append("AND rpdrcdp.siiDetalleRubroCdp.drcCodigo = drcdp.drcCodigo "); 
            sql.append("AND drcdp.siiDetalleRubro.druCodigo = dr.druCodigo "); 
            sql.append("AND dr.siiFuenteFinancContab.ffcCodigo = ffc.ffcCodigo ");
            sql.append("AND rp.rpCodigo = :rpCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            List<SiiFuenteFinancContab> listaFuenteFinancContab = query.getResultList();
            return listaFuenteFinancContab;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
}
