package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActividadIcaPers;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ActividadIcaPersDAO extends GenericDAO<SiiActividadIcaPers> {
    
    /**
     * Constructor.
     */
    public ActividadIcaPersDAO() {
        super(SiiActividadIcaPers.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de las Actividades ICA a trav&eacute;s del C&oacute;digo de la Persona.
     * @param perCodigo - C&oacute;digo de la Persona.
     * @return List of SiiActividadIcaPers
     */
    public List<SiiActividadIcaPers> buscarPorCodigoPersona (Long perCodigo) throws ExcepcionDAO {
        List<SiiActividadIcaPers> lista = new ArrayList<SiiActividadIcaPers>();
        
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aip FROM SiiActividadIcaPers aip ");
            sql.append("WHERE aip.siiPersona.perCodigo = :perCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            lista = query.getResultList();
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return lista;
    }
    
    
    /**
     * Realiza la b&uacute;squeda de la Actividades ICA PRINCIPAL a trav&eacute;s del C&oacute;digo de la Persona.
     * @param perCodigo - C&oacute;digo de la Persona.
     * @return List of SiiActividadIcaPers
     */
    public SiiActividadIcaPers buscarActividadIcaPersPrincipalPorCodigoPersona (Long perCodigo) throws ExcepcionDAO {
        SiiActividadIcaPers principal = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aip FROM SiiActividadIcaPers aip, ");
            sql.append("                SiiPersona p ");
            sql.append("WHERE p.perCodigo = aip.siiPersona.perCodigo ");
            sql.append("AND p.perCodigo = :perCodigo ");
            sql.append("AND aip.aipActivPrinc = :aipActivPrinc");
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            query.setParameter("aipActivPrinc", EnumDecision.SI.getId());
            principal = (SiiActividadIcaPers) query.getSingleResult();  
        }
        catch (javax.persistence.NoResultException ne) {
            principal = null;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return principal; 
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Actividades ICA a trav&eacute;s del Tipo de Contribuyente y Tipo de Proveedor.
     * @param perTipoPersona - Tipo del Contribuyente.
     * @param perTipoProveed - Tipo de Proveedor.
     * @return List of SiiActividadIcaPers
     */
    public List<SiiActividadIcaPers> buscarPorTipoContribuyenteProveedor (String perTipoPersona, String perTipoProveed) throws ExcepcionDAO {
        List<SiiActividadIcaPers> lista = new ArrayList<SiiActividadIcaPers>();
        
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aip FROM SiiActividadIcaPers aip ");
            sql.append("INNER JOIN aip.siiPersona per ");
            sql.append("WHERE 1 = 1 ");
            
            if (perTipoPersona!=null)
                sql.append("AND per.perTipoPersona = :perTipoPersona ");
            if (perTipoProveed!=null)
                sql.append("AND per.perTipoProveedor = :perTipoProveedor ");
            
            
            Query query = em.createQuery(sql.toString());
            
            if (perTipoPersona!=null)
                query.setParameter("perTipoPersona", perTipoPersona);
            if (perTipoProveed!=null)
                query.setParameter("perTipoProveed", perTipoProveed);
            
            
            lista = query.getResultList();
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());
        }
        
        return lista;
    }
}


