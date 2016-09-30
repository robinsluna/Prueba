/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 04-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas;
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
public class RecepcionPropuestasDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    private Recursos recursos;
    
    
    
    /**
     * Constructor.
     */
    public RecepcionPropuestasDAO() 
    {
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Realiza la consulta de una Recepci&oacute;n Propuestas a trav&eacute;s del C&oacute;digo de la misma.
     * @param idCodigoRecepcionPropuestas
     * @return SiiRecepcionPropuestas
     * @throws ExcepcionDAO
     */
    public SiiRecepcionPropuestas buscarPorCodigoRecepcionPropuestas (Long idCodigoRecepcionPropuestas) 
        throws ExcepcionDAO 
    {
        SiiRecepcionPropuestas recepcionPropuestas = null;
        try {
            recepcionPropuestas = em.find(SiiRecepcionPropuestas.class, idCodigoRecepcionPropuestas);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
        return recepcionPropuestas;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de una Recepci&oacute;n Propuestas.
     * @param siiRecepcionPropuestas
     * @return SiiRecepcionPropuestas
     * @throws ExcepcionDAO
     */
    public SiiRecepcionPropuestas insertarSiiRecepcionPropuestas (SiiRecepcionPropuestas siiRecepcionPropuestas) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(siiRecepcionPropuestas); 
            em.flush(); 
            return siiRecepcionPropuestas; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Recepci&oacute;n Propuestas.
     * @param siiRecepcionPropuestas
     * @return SiiRecepcionPropuestas
     * @throws ExcepcionDAO
     */
    public SiiRecepcionPropuestas actualizarSiiRecepcionPropuestas (SiiRecepcionPropuestas siiRecepcionPropuestas) 
    throws ExcepcionDAO 
    {
        try {
            em.merge(siiRecepcionPropuestas); 
            em.flush(); 
            return siiRecepcionPropuestas; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Recepci&oacute;n Propuestas.
     * @param idCodigoRecepcionPropuestas
     * @throws ExcepcionDAO
     */
    public void borrarSiiRecepcionPropuestas (Long idCodigoRecepcionPropuestas) 
        throws ExcepcionDAO 
    {
        SiiRecepcionPropuestas recepcionPropuestasBorrar = null;
        try {
            recepcionPropuestasBorrar = em.find(SiiRecepcionPropuestas.class, idCodigoRecepcionPropuestas);
            if (recepcionPropuestasBorrar!=null) {
                em.remove(recepcionPropuestasBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de Todas las Recepciones de Propuesta.
     * @return listado de SiiRecepcionPropuestas.
     * @throws ExcepcionDAO
     */
    public List<SiiRecepcionPropuestas> buscarTodoSiiRecepcionPropuestas() 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRecepcionPropuestas o");
            Query query = em.createQuery(sql.toString());
            List<SiiRecepcionPropuestas> listaRP = query.getResultList();
            return listaRP;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de las Recepciones de Propuesta asociadas a un Proceso de Contrataci&oacute;n.
     * @param prcCodigo - C&oacute;digo del Proceso de Contrataci&oacute;n.
     * @return listado de SiiRecepcionPropuestas.
     * @throws ExcepcionDAO
     */
    public List<SiiRecepcionPropuestas> buscarPorCodigoProcesoContratacion (Long prcCodigo) 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rp FROM SiiRecepcionPropuestas rp, ");
            sql.append("              SiiProcesoContratacion pc ");
            sql.append("WHERE pc.prcCodigo = rp.siiProcesoContratacion.prcCodigo ");
            sql.append("AND pc.prcCodigo = :prcCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            List<SiiRecepcionPropuestas> listaRP = query.getResultList();
            return listaRP;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecepcionPropuestasDAO");
        }
    }
}
