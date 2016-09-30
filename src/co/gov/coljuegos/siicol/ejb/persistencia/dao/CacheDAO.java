package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class CacheDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager em;
    
    public CacheDAO() {
    }
    
    public void limpiarCache() throws ExcepcionDAO{
        try{
            em.getEntityManagerFactory().getCache().evictAll();
        }catch(PersistenceException pe) {
            throw new ExcepcionDAO("Error de persistencia al limpiar cache: " + pe.getMessage(),"SqlDirectDAO");            
        }catch(Exception ex) {
            throw new ExcepcionDAO("Error general DAO al limpiar cache: " + ex.getMessage(),"SqlDirectDAO");            
        }
    }
}
