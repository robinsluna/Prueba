package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
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
public class EstadoSolEstMercadoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoSolEstMercadoDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoSolEstMercado buscarEstadoSolEstMercadoPorId(Long idEstadoSolEstMerc) throws ExcepcionDAO{
        SiiEstadoSolEstMercado estadoSolEstMercadoRetorno = null;
        try{
            estadoSolEstMercadoRetorno = (SiiEstadoSolEstMercado) manager.find(SiiEstadoSolEstMercado.class, idEstadoSolEstMerc);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");
        }        
        return estadoSolEstMercadoRetorno;
    }
    
    public List<SiiEstadoSolEstMercado> buscarEstadoSolEstMercadoPorEstado(SiiEstadoSolEstMercado unEstadoSolEstMercado) throws ExcepcionDAO{
        List<SiiEstadoSolEstMercado> estadoSolEstMercadoRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT estadoSolEst FROM SiiEstadoSolEstMercado estadoSolEst");
            sql.append(" WHERE estadoSolEst.siiEstadoSolEstMercado.ESE_CODIGO = :estadoSolEstMercado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoSolEstMercado", unEstadoSolEstMercado.getEseCodigo());
            estadoSolEstMercadoRetorno = query.getResultList();      
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return estadoSolEstMercadoRetorno;
    }
    
    public SiiEstadoSolEstMercado actualizarEstadoSolEstMercado(SiiEstadoSolEstMercado estadoSolEstMercado) throws ExcepcionDAO{
        try{
            manager.merge(estadoSolEstMercado);                                                                                
            manager.flush();                                                                                               
            return estadoSolEstMercado;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");
        }
    }        
    
    public SiiEstadoSolEstMercado insertarEstadoSolEstMercado(SiiEstadoSolEstMercado estadoSolEstMercado) throws ExcepcionDAO{
        try{
            manager.persist(estadoSolEstMercado);                                                                                
            manager.flush();                                                                                               
            return estadoSolEstMercado;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");
        }
    }

    public void eliminarEstadoSolEstMercado(Long idEstadoSolEstMerc) throws ExcepcionDAO{
        try{
            SiiEstadoSolEstMercado estadoSolEstMercadoBorrar = (SiiEstadoSolEstMercado) manager.find(SiiEstadoSolEstMercado.class, idEstadoSolEstMerc);
            manager.remove(estadoSolEstMercadoBorrar);
            manager.flush();
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoSolEstMercadoDAO");
        }
    }
    
    public SiiEstadoSolEstMercado buscarEstadoSolEstMercadoPorNombre(SiiEstadoSolEstMercado unEstadoSolEstMercado) throws ExcepcionDAO{
        SiiEstadoSolEstMercado siiEstadoSolEstMercado = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT estadoSolEst FROM SiiEstadoSolEstMercado estadoSolEst");
            sql.append(" WHERE estadoSolEst.eseNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", unEstadoSolEstMercado.getEseNombre());
            List<SiiEstadoSolEstMercado> listaSiiEstadoSolEstMercado = query.getResultList();
           
            if (listaSiiEstadoSolEstMercado != null && !listaSiiEstadoSolEstMercado.isEmpty()) {
                siiEstadoSolEstMercado = listaSiiEstadoSolEstMercado.get(0);
            }
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");            
        }
        return siiEstadoSolEstMercado;
    }
  
        
    

    public List<SiiEstadoSolEstMercado> buscarTodoEstadoSolEstMercado() throws ExcepcionDAO{
        try{
            List<SiiEstadoSolEstMercado> listaEstadoSolEstMercado = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estadoSolEst FROM SiiEstadoSolEstMercado estadoSolEst");
            Query query = manager.createQuery(sql.toString());
            listaEstadoSolEstMercado = query.getResultList();
            return listaEstadoSolEstMercado;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoSolEstMercadoDAO");
        }
    }
       
}
