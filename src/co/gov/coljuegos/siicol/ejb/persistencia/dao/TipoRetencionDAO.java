/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoRetencion;

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
public class TipoRetencionDAO
{
    /** Entity Manager */
    @PersistenceContext(unitName = "siicolPU")
    protected EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    protected Recursos recursos;
    
    
    
    /**
     * Constructor.
     */
    public TipoRetencionDAO() {
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Realiza la consulta de la Entidad a trav&eacute;s del identificador de la misma.
     * @param treCodigo - C&oacute;digo del Tipo de Retenci&oacute;n.
     * @return SiiTipoRetencion
     * @throws ExcepcionDAO
     */
    public SiiTipoRetencion buscarPorCodigo (String treCodigo) 
        throws ExcepcionDAO 
    {
        SiiTipoRetencion entidad = null;
        try {
            entidad = em.find(SiiTipoRetencion.class, treCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return entidad;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de la Entidad.
     * @param entidad
     * @return SiiTipoRetencion
     * @throws ExcepcionDAO
     */
    public SiiTipoRetencion insertar (SiiTipoRetencion entidad) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(entidad); 
            em.flush(); 
            return entidad; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Entidad.
     * @param entidad
     * @return SiiTipoRetencion
     * @throws ExcepcionDAO
     */
    public SiiTipoRetencion actualizar (SiiTipoRetencion entidad) 
        throws ExcepcionDAO 
    {
        try {
            SiiTipoRetencion result = em.merge(entidad); 
            em.flush(); 
            return result; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Entidad.
     * @param treCodigo - C&oacute;digo del Tipo de Retenci&oacute;n.
     * @throws ExcepcionDAO
     */
    public void eliminar (String treCodigo) 
        throws ExcepcionDAO 
    {
        SiiTipoRetencion entidadBorrar = null;
        try {
            entidadBorrar = em.find(SiiTipoRetencion.class, treCodigo);
            if (entidadBorrar!=null) {
                em.remove(entidadBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of SiiTipoRetencion
     * @throws ExcepcionDAO
     */
    public List<SiiTipoRetencion> buscarTodo () 
        throws ExcepcionDAO 
    {
        List<SiiTipoRetencion> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoRetencion o");
            Query query = em.createQuery(sql.toString());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Tipos de Retenci&oacute;n asociados al Grupo de Retenci&oacute;n especificado.
     * @param greCodigo - C&oacute;digo del Grupo de Retenci&oacute;n.
     * @return List of SiiTipoRetencion
     * @throws ExcepcionDAO
     */
    public List<SiiTipoRetencion> buscarPorIdGrupoRetencion (Long greCodigo) 
        throws ExcepcionDAO 
    {
        List<SiiTipoRetencion> lista = null;
        
        try {
            if (greCodigo!=null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiTipoRetencion o ");
                sql.append("WHERE o.siiGrupoRetenc.greCodigo = :greCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("greCodigo", greCodigo);
                
                lista = query.getResultList();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return lista;
    }
}
