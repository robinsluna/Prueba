package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoPse;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;


@Stateless
@LocalBean
public class PagoOpePseDAO {
    
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public PagoOpePseDAO() {
        recursos = new Recursos();
    }
    
    public SiiRecaudoPse insertarPagoOperadorPse (SiiRecaudoPse siiRecaudoPse) throws ExcepcionDAO {
        try {
            manager.persist(siiRecaudoPse);                          
            manager.flush();                                                                        
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRecaudoPse; 
    }
    
    public SiiRecaudoPse  buscarRecaudoPseXId(Long idRecaudoPse) throws ExcepcionDAO {
        SiiRecaudoPse siiRecaudoPse = null;
        try {
            siiRecaudoPse = manager.find(SiiRecaudoPse.class, idRecaudoPse);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRecaudoPse;

    }
    
    public SiiRecaudoPse actualizarRecaudoPse(SiiRecaudoPse siiRecaudoPse) throws ExcepcionDAO{
        try{
            siiRecaudoPse = manager.merge(siiRecaudoPse);
            manager.flush();   
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRecaudoPse;
    }
    
   
    
   
    
    
    
    
}
