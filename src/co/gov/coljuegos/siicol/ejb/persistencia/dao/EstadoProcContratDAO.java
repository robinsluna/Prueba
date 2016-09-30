package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class EstadoProcContratDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoProcContratDAO() {
        recursos = new Recursos();
        
    }
    
    public SiiEstadoProcContrat BuscarEstadoProcContratPorId(Long id) throws ExcepcionDAO {
        SiiEstadoProcContrat siiEstadoProcContrat = null;
        try {
            siiEstadoProcContrat = (SiiEstadoProcContrat) manager.find(SiiEstadoProcContrat.class, id);
        } catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstadoProcContratDAO");
        }
        return siiEstadoProcContrat;
    }
    
    public SiiEstadoProcContrat insertarEstadoProcContrat (SiiEstadoProcContrat siiEstadoProcContrat) throws ExcepcionDAO {
        try {
            manager.persist(siiEstadoProcContrat);
            manager.flush();
        } catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstadoProcContratDAO");
        }
        return siiEstadoProcContrat;
    }
    
    public SiiEstadoProcContrat actualizarEstadoProcContrat(SiiEstadoProcContrat siiEstadoProcContrat) throws ExcepcionDAO {
        try { 
            siiEstadoProcContrat = manager.merge(siiEstadoProcContrat);
            manager.flush();
            return siiEstadoProcContrat;
    } catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstadoProcContratDAO");
        }
        
    }
    
    public void eliminarEstadoProcContrat (Long id) throws ExcepcionDAO {
        try {
            SiiEstadoProcContrat estadoProcContrat = (SiiEstadoProcContrat) manager.find(SiiEstadoProcContrat.class, id);
            manager.remove(estadoProcContrat);
            manager.flush();
        }  catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstadoProcContratDAO");
        }
    }
    
    public SiiEstadoProcContrat buscarEstadoProcContratPorEstado(String estado) throws ExcepcionDAO {
        try {
            SiiEstadoProcContrat estadoProcContrat = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoProcContrat o WHERE o.epcNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            estadoProcContrat = (SiiEstadoProcContrat) query.getSingleResult();
            
            return estadoProcContrat;
            
        } catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstadoProcContratDAO");
        }
        
    }
    
    
}
