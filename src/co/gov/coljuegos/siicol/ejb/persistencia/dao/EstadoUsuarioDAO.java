package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoUsuario;

import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoUsuarioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public EstadoUsuarioDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoUsuario buscarEstadoUsuarioPorId(Long idEstadoUsuario) throws ExcepcionDAO{
        SiiEstadoUsuario estadoUsuarioRetorno = null;
        try{
            estadoUsuarioRetorno = (SiiEstadoUsuario) manager.find(SiiEstadoUsuario.class, idEstadoUsuario);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoUsuarioDAO");
        }        
        return estadoUsuarioRetorno;
    }
    
    public SiiEstadoUsuario insertarEstadoUsuario(SiiEstadoUsuario estadoUsuario) throws ExcepcionDAO{
        try{
            manager.persist(estadoUsuario);                                                                                
            manager.flush();                                                                                               
            return estadoUsuario;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstadoUsuarioDAO");
        }
    }
    
    public SiiEstadoUsuario actualizarEstadoUsuario(SiiEstadoUsuario estadoUsuario) throws ExcepcionDAO{
        try{            
            manager.merge(estadoUsuario);
            manager.flush();
            return estadoUsuario;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoUsuarioDAO");
        }
    }
    
    public void eliminarEstadoUsuario(Long idEstadoUsuario) throws ExcepcionDAO{
        try{
            SiiEstadoUsuario estadoUsuario = (SiiEstadoUsuario) manager.find(SiiEstadoUsuario.class, idEstadoUsuario);
            manager.remove(estadoUsuario);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoUsuarioDAO");
        }
    }

        
}
