/*
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 26-02-2015
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * DAO Gen&eacute;rico con las operaciones b&aacute;sicas de persistencia.
 * - <b>K</b> - Clase que corresponde a la <i>Llave Primaria</i>, utilizada para b&uacute;squedas y eliminaci&oacute;n de registros.
 * - <b>T</b> - Clase que corresponde a la <i>Entidad</i> resultante.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class AbstractDAO <K, T>
{
    /** Entity Manager */
    @PersistenceContext(unitName = "siicolPU")
    protected EntityManager em;
    
    
    /** Encargado de obtener valores de los archivos de Properties */
    protected Recursos recursos;
    /** Nombre del DAO (hijo) */
    protected String daoName;
    private Class<T> clase;
    
    
    /**
     * Constructor.
     */
    public AbstractDAO () { }
    
    
    /**
     * Constructor.
     * @param clase - Clase correspondiente a la Entidad que se toma como base para la construcci&oacute;n del DAO Gen&eacute;rico.
     */
    public AbstractDAO (Class<T> clase) 
    {
        this.clase = clase;
        this.daoName = getMyClass()!=null && clase!=null?getMyClass().getSimpleName()+"<"+clase.getSimpleName()+">":AbstractDAO.class.getSimpleName();
        this.recursos = new Recursos();
    }
    
    /**
     * Constructor.
     * @param clase - Clase correspondiente a la Entidad que se toma como base para la construcci&oacute;n del DAO Gen&eacute;rico.
     * @param daoName - Nombre del DAO (nodo hijo) que ser&aacute; mostrado en las Excepciones.
     */
    public AbstractDAO (Class<T> clase, String daoName) 
    {
        this.clase = clase;
        this.daoName = daoName;
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Obtiene el objeto Class correspondiente al DAO instanciador.
     * @return AbstractDAO<T>.class
     */
    private Class<AbstractDAO<K, T>> getMyClass()
    {
        return (Class<AbstractDAO<K, T>>)(Class<?>)AbstractDAO.class;
    }
    
    
    
    /**
     * Realiza la consulta de la Entidad a trav&eacute;s del identificador de la misma.
     * @param id
     * @return entidad de tipo "T"
     * @throws ExcepcionDAO
     */
    public T buscarPorCodigo (K id) 
        throws ExcepcionDAO 
    {
        T entidad = null;
        try {
            entidad = em.find(clase, id);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), this.daoName);
        }
        return entidad;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de la Entidad.
     * @param entidad
     * @return entidad de tipo "T"
     * @throws ExcepcionDAO
     */
    public T insertar (T entidad) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(entidad); 
            em.flush(); 
            return entidad; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), this.daoName);
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro de la Entidad.
     * @param entidad
     * @return entidad de tipo "T"
     * @throws ExcepcionDAO
     */
    public T actualizar (T entidad) 
        throws ExcepcionDAO 
    {
        try {
            T result = em.merge(entidad); 
            em.flush(); 
            return result; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), this.daoName);
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro de la Entidad.
     * @param id
     * @throws ExcepcionDAO
     */
    public void eliminar (K id) 
        throws ExcepcionDAO 
    {
        T entidadBorrar = null;
        try {
            entidadBorrar = em.find(clase, id);
            if (entidadBorrar!=null) {
                em.remove(entidadBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), this.daoName);
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of "T"
     * @throws ExcepcionDAO
     */
    public List<T> buscarTodo () 
        throws ExcepcionDAO 
    {
        List<T> lista = null;
        
        try {
            String className = clase!=null?clase.getSimpleName():null;
            
            if (className!=null) {                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM ");
                sql.append(className);
                sql.append(" o");
                Query query = em.createQuery(sql.toString());
                // Oracle Hint para obtener con mayor eficiencia los primeros 20 registros
                query.setHint("openjpa.hint.OracleSelectHint", "/*+ FIRST_ROWS(20) */");
                lista = query.getResultList();
            }
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), this.daoName);
        }
    }
}
