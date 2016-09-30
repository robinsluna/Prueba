/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
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
public class TipoDocContableDAO 
{
    /** Entity Manager */
    @PersistenceContext(unitName = "siicolPU")
    protected EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    protected Recursos recursos;
    
    
    
    /**
     * Constructor.
     */
    public TipoDocContableDAO() {
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Realiza la consulta de la Entidad a trav&eacute;s del identificador de la misma.
     * @param tdcCodigo - C&oacute;digo del Tipo de Documento Contable.
     * @return SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public SiiTipoDocContable buscarPorCodigo (String tdcCodigo) 
        throws ExcepcionDAO 
    {
        SiiTipoDocContable entidad = null;
        try {
            entidad = em.find(SiiTipoDocContable.class, tdcCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return entidad;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de la Entidad.
     * @param entidad
     * @return SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public SiiTipoDocContable insertar (SiiTipoDocContable entidad) 
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
     * @return SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public SiiTipoDocContable actualizar (SiiTipoDocContable entidad) 
        throws ExcepcionDAO 
    {
        try {
            SiiTipoDocContable result = em.merge(entidad); 
            em.flush(); 
            return result; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }


    /**
     * Realiza la Eliminaci&oacute;n del registro de la Entidad.
     * @param tdcCodigo - C&oacute;digo del Tipo de Documento Contable.
     * @throws ExcepcionDAO
     */
    public void eliminar(SiiTipoDocContable entidadBorrar) throws ExcepcionDAO {
        try {
            SiiTipoDocContable documentoDelete;
            documentoDelete = em.find(SiiTipoDocContable.class, entidadBorrar.getTdcCodigo());
            if (documentoDelete != null) {
                em.remove(documentoDelete);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public List<SiiTipoDocContable> buscarTodo () 
        throws ExcepcionDAO 
    {
        List<SiiTipoDocContable> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocContable o  order by o.tdcNombre asc ");
            Query query = em.createQuery(sql.toString());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros que son prmitidos en el <b>Registro Manual de Comprobantes Contables</b>, correspondientes a la Entidad base.
     * @return List of SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public List<SiiTipoDocContable> buscarPermitidosRegistroManual () 
        throws ExcepcionDAO 
    {
        List<SiiTipoDocContable> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocContable o ");
            sql.append("WHERE o.tdcPermiteManual = :tdcPermiteManual");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tdcPermiteManual", EnumDecision.SI.getId());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
}
