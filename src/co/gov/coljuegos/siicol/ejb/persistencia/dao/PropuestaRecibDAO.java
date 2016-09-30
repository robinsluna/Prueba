/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class PropuestaRecibDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    private Recursos recursos;
    
    
    /**
     * Constructor.
     */
    public PropuestaRecibDAO() 
    {
        this.recursos = new Recursos();
    }
    
    
    /**
     * Realiza la consulta de una Propuesta Recibida a trav&eacute;s del C&oacute;digo de la misma.
     * @param idCodigoPropuestaRecib
     * @return SiiPropuestaRecib
     * @throws ExcepcionDAO
     */
    public SiiPropuestaRecib buscarPorCodigoPropuestaRecib (Long idCodigoPropuestaRecib) 
        throws ExcepcionDAO 
    {
        SiiPropuestaRecib propuestaRecib = null;
        try {
            propuestaRecib = em.find(SiiPropuestaRecib.class, idCodigoPropuestaRecib);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaRecibDAO");
        }
        return propuestaRecib;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de una Propuesta Recibida.
     * @param siiPropuestaRecib
     * @return SiiPropuestaRecib
     * @throws ExcepcionDAO
     */
    public SiiPropuestaRecib insertarSiiPropuestaRecib (SiiPropuestaRecib siiPropuestaRecib) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(siiPropuestaRecib); 
            em.flush(); 
            return siiPropuestaRecib; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaRecibDAO");
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Propuesta Recibida.
     * @param siiPropuestaRecib
     * @return SiiPropuestaRecib
     * @throws ExcepcionDAO
     */
    public SiiPropuestaRecib actualizarSiiPropuestaRecib (SiiPropuestaRecib siiPropuestaRecib) 
    throws ExcepcionDAO 
    {
        try {
            em.merge(siiPropuestaRecib); 
            em.flush(); 
            return siiPropuestaRecib; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaRecibDAO");
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Propuesta Recibida.
     * @param idCodigoPropuestaRecib
     * @throws ExcepcionDAO
     */
    public void borrarSiiPropuestaRecib (Long idCodigoPropuestaRecib) 
        throws ExcepcionDAO 
    {
        SiiPropuestaRecib propuestaRecibBorrar = null;
        try {
            propuestaRecibBorrar = em.find(SiiPropuestaRecib.class, idCodigoPropuestaRecib);
            if (propuestaRecibBorrar!=null) {
                em.remove(propuestaRecibBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaRecibDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de las Propuestas Recibidas asociadas a una Recepci&oacute;n de Propuestas.
     * @param rprCodigo - C&oacute;digo de la Recepci&oacute;n de Propuestas.
     * @return listado de SiiPropuestaRecib.
     * @throws ExcepcionDAO
     */
    public List<SiiPropuestaRecib> buscarPorCodigoRecepcionPropuestas (Long rprCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pr FROM SiiPropuestaRecib pr, ");
            sql.append("              SiiRecepcionPropuestas rp ");
            sql.append("WHERE rp.rprCodigo = pr.siiRecepcionPropuestas.rprCodigo ");
            sql.append("AND rp.rprCodigo = :rprCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("rprCodigo", rprCodigo);
            List<SiiPropuestaRecib> listaPR = query.getResultList();
            return listaPR;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaRecibDAO");
        }
    }
    
}
