/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaEvaluacion;
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
public class PropuestaEvaluacionDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    private Recursos recursos;
    
    
    /**
     * Constructor.
     */
    public PropuestaEvaluacionDAO() 
    {
        this.recursos = new Recursos();
    }
    
    
    /**
     * Realiza la consulta de una Propuesta de Evaluaci&oacute;n a trav&eacute;s del C&oacute;digo de la misma.
     * @param idCodigoPropuestaEvaluacion
     * @return SiiPropuestaEvaluacion
     * @throws ExcepcionDAO
     */
    public SiiPropuestaEvaluacion buscarPorCodigoPropuestaEvaluacion (Long idCodigoPropuestaEvaluacion) 
        throws ExcepcionDAO 
    {
        SiiPropuestaEvaluacion propuestaRecib = null;
        try {
            propuestaRecib = em.find(SiiPropuestaEvaluacion.class, idCodigoPropuestaEvaluacion);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
        return propuestaRecib;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de una Propuesta de Evaluaci&oacute;n.
     * @param siiPropuestaEvaluacion
     * @return SiiPropuestaEvaluacion
     * @throws ExcepcionDAO
     */
    public SiiPropuestaEvaluacion insertarSiiPropuestaEvaluacion (SiiPropuestaEvaluacion siiPropuestaEvaluacion) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(siiPropuestaEvaluacion); 
            em.flush(); 
            return siiPropuestaEvaluacion; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Propuesta de Evaluaci&oacute;n.
     * @param siiPropuestaEvaluacion
     * @return SiiPropuestaEvaluacion
     * @throws ExcepcionDAO
     */
    public SiiPropuestaEvaluacion actualizarSiiPropuestaEvaluacion (SiiPropuestaEvaluacion siiPropuestaEvaluacion) 
    throws ExcepcionDAO 
    {
        try {
            em.merge(siiPropuestaEvaluacion); 
            em.flush(); 
            return siiPropuestaEvaluacion; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Propuesta de Evaluaci&oacute;n.
     * @param idCodigoPropuestaEvaluacion
     * @throws ExcepcionDAO
     */
    public void borrarSiiPropuestaEvaluacion (Long idCodigoPropuestaEvaluacion) 
        throws ExcepcionDAO 
    {
        SiiPropuestaEvaluacion propuestaEvalBorrar = null;
        try {
            propuestaEvalBorrar = em.find(SiiPropuestaEvaluacion.class, idCodigoPropuestaEvaluacion);
            if (propuestaEvalBorrar!=null) {
                em.remove(propuestaEvalBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de todos los registros de Propuesta de Evaluaci&oacute;n.
     * @return List of SiiPropuestaEvaluacion
     */
    public List<SiiPropuestaEvaluacion> buscarTodaPropuestaEvaluacion () 
        throws ExcepcionDAO
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiPropuestaEvaluacion o");
            Query query = em.createQuery(sql.toString());
            List<SiiPropuestaEvaluacion> lista = query.getResultList();
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de las Propuestas de Evaluaci&oacute;n asociadas a la Evaluaci&oacute;n especificada.
     * @param ejtCodigo - C&oacute;digo de la Evaluaci&oacute;n Jur&iacute;dica/T&eacute;cnica/Financiera
     * @return List of SiiPropuestaEvaluacion
     * @throws ExcepcionDAO
     */
    public List<SiiPropuestaEvaluacion> buscarPorCodigoEvaluacionJurTecFin (Long ejtCodigo) 
        throws ExcepcionDAO
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pe FROM SiiPropuestaEvaluacion pe, ");
            sql.append("               SiiEvaluacionJurTecFin ejtf ");
            sql.append("WHERE ejtf.ejtCodigo = pe.siiEvaluacionJurTecFin.ejtCodigo ");
            sql.append("AND ejtf.ejtCodigo = :ejtCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("ejtCodigo", ejtCodigo);
            List<SiiPropuestaEvaluacion> listaPEv = query.getResultList();
            return listaPEv;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PropuestaEvaluacionDAO");
        }
    }
    
}
