package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class AreaColjuegosDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AreaColjuegosDAO() {
        
        recursos = new Recursos();
        //super();
    }
    public SiiAreaColjuegos buscarAreaColjuegosPorId(Long idAreaColjuegos) throws ExcepcionDAO{
        SiiAreaColjuegos areaColjuegosRetorno = null;
        try{
            areaColjuegosRetorno = (SiiAreaColjuegos) manager.find(SiiAreaColjuegos.class, idAreaColjuegos);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AreaColjuegosDAO");            
        }
        return areaColjuegosRetorno;
    }
    
    public SiiAreaColjuegos insertarAreaColjuegos(SiiAreaColjuegos areaColjuegos) throws ExcepcionDAO{
        try{
            manager.persist(areaColjuegos);                                                                                
            manager.flush();                                                                                               
            return areaColjuegos;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AreaColjuegosDAO");
        }
    }
    public SiiAreaColjuegos actualizarAreaColjuegos(SiiAreaColjuegos areaColjuegos) throws ExcepcionDAO{
        try{            
            manager.merge(areaColjuegos);
            manager.flush();
            return areaColjuegos;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AreaColjuegosDAO");
        }
    }
    /*
    public SiiAreaColjuegos eliminarAreaColjuegos(SiiAreaColjuegos areaColjuegos) throws ExcepcionDAO{
        try{
            manager.remove(areaColjuegos);
            manager.flush();
            return areaColjuegos;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AreaColjuegosDAO");
        }
    }
    */
    public List<SiiAreaColjuegos> buscarAreaColjuegosPorNombre(SiiAreaColjuegos unAreaColjuegos) throws ExcepcionDAO{
        List<SiiAreaColjuegos>  areaColjuegosRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT areaColjuegos FROM SiiAreaColjuegos areaColjuegos");
            sql.append(" WHERE areaColjuegos.acoNombre = :areaColjuegos");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("areaColjuegos", unAreaColjuegos.getAcoCodigo());
            areaColjuegosRetorno = query.getResultList();      
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AreaColjuegosDAO");            
        }
        return areaColjuegosRetorno;        
    }
    
    
    
    /**
     * Consulta el listado de &Aacute;reas Coljuegos asociadas al nombre especificado.
     * @param acoNombre - Nombre del &Aacute;rea Coljuegos.
     * @return List of SiiAreaColjuegos
     * @throws ExcepcionDAO
     */
    public List<SiiAreaColjuegos> buscarAreaColjuegosPorNombre(String acoNombre) throws ExcepcionDAO 
    {
        List<SiiAreaColjuegos>  areaColjuegosRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT areaColjuegos FROM SiiAreaColjuegos areaColjuegos");
            sql.append(" WHERE areaColjuegos.acoNombre = :acoNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("acoNombre", acoNombre);
            areaColjuegosRetorno = query.getResultList();      
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());            
        }
        return areaColjuegosRetorno;        
    }
    
    
    public List<SiiAreaColjuegos> buscarTodoAreaColjuegos()
            throws ExcepcionDAO{
        try{
            List<SiiAreaColjuegos> listaAreaColjuegos = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT areaCol FROM SiiAreaColjuegos areaCol");
            sql.append(" ORDER BY areaCol.acoNombre ASC");
            Query query = manager.createQuery(sql.toString());
            listaAreaColjuegos = query.getResultList();
            return listaAreaColjuegos;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AreaColjuegosDAO");
        }
    }
    
    
    /**
     * Realiza la b&uacute;squeda del &Aacute;rea Coljuegos a trav&eacute;s de su Abreviatura.
     * @param acoAbreviatura - Abreviatura.
     * @return Instance of SiiAreaColjuegos.
     * @throws ExcepcionDAO
     */
    public SiiAreaColjuegos buscarAreaColjuegosPorAbreviatura (String acoAbreviatura) throws ExcepcionDAO
    {
        SiiAreaColjuegos  resultado = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT a FROM SiiAreaColjuegos a ");
            sql.append("WHERE a.acoAbreviatura = :acoAbreviatura ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("acoAbreviatura", acoAbreviatura);
            
            try {
                resultado = (SiiAreaColjuegos) query.getSingleResult();
            }
            catch (NonUniqueResultException nue) {
                // Obtener el primer registro, en caso tal que aparezca mas de uno asociado a la misma abreviatura
                List<SiiAreaColjuegos> lista = query.getResultList();
                if (lista!=null && !lista.isEmpty())
                    resultado = lista.get(0);
            }
            
        }
        catch (NoResultException e) {
            resultado = null;
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());            
        }
        return (resultado);        
    }
}
