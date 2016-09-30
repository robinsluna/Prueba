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

@Stateless
@LocalBean
public class UtilDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public UtilDAO() {
        super();
    }
    
    public String valorEnLetras(int numero) throws ExcepcionDAO {
        String valorLetras;
        
        try{
            StringBuilder sql = new StringBuilder("select numtoletras(:numero) from dual");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numero", numero);
            List<Object[]> results = query.getResultList();
            
            return  "";
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"UtilDAO"); 
        }
    
    }
}
