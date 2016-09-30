package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoColjuegos;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean


public class ProcesoColjuegosDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ProcesoColjuegosDAO() {
        recursos = new Recursos();
    }
    
    public SiiProcesoColjuegos insertarProcesoColjuegos(SiiProcesoColjuegos procesoColjuegos) throws ExcepcionDAO{
        try{
            manager.persist(procesoColjuegos);                                                                                
            manager.flush();                                                                                               
            return procesoColjuegos;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ProcesoColjuegosDAO");
        }
    }
    
    public SiiProcesoColjuegos buscarProcesoColjuegosPorId(Long idProcesoColjuegos) throws ExcepcionDAO{
        SiiProcesoColjuegos procesoColjuegosRetorno = null;
        try{
            procesoColjuegosRetorno = (SiiProcesoColjuegos) manager.find(SiiProcesoColjuegos.class, idProcesoColjuegos);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ProcesoColjuegosDAO");            
        }
        return procesoColjuegosRetorno;
        }
    
    public SiiProcesoColjuegos actualizarProcesoColjuegos(SiiProcesoColjuegos procesoColjuegos) throws ExcepcionDAO{
        try{            
            manager.merge(procesoColjuegos);
            manager.flush();
            return procesoColjuegos;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoColjuegosDAO");
        }
    }
    /*
    public SiiProcesoColjuegos eliminarProcesoColjuegos(SiiProcesoColjuegos procesoColjuegos) throws ExcepcionDAO{
        try{
            manager.remove(procesoColjuegos);
            manager.flush();
            return procesoColjuegos;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProcesoColjuegosDAO");
        }
    }
    */
    public List<SiiProcesoColjuegos> buscarProcesoColjuegosPorNombre(SiiProcesoColjuegos unProcesoColjuegos) throws ExcepcionDAO{
    List<SiiProcesoColjuegos> procesoColjuegosRetorno = null;
    try{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT procColjuegos FROM SiiProcesoColjuegos procColjuegos");
        sql.append(" WHERE procColjuegos.pcoNombre = :procesoColjuegos");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("procesoColjuegos", unProcesoColjuegos.getPcoCodigo());
        procesoColjuegosRetorno = query.getResultList();  
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ProcesoColjuegosDAO");            
        }
        return procesoColjuegosRetorno;
    }
    
    public List<SiiProcesoColjuegos> buscarTodoProcesoColjuegos()
            throws ExcepcionDAO{
        try{
            List<SiiProcesoColjuegos> listaProcesoColjuegos = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT procesoCol FROM SiiProcesoColjuegos procesoCol");
            sql.append(" ORDER BY procesoCol.pcoNombre ASC ");
            Query query = manager.createQuery(sql.toString());
            listaProcesoColjuegos = query.getResultList();
            return listaProcesoColjuegos;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ProcesoColjuegosDAO");
        }
    }
}
