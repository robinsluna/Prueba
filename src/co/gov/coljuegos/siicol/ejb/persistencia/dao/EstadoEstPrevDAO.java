package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstPrev;
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
public class EstadoEstPrevDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoEstPrevDAO() {
        recursos = new Recursos();
    }
    public SiiEstadoEstPrev buscarEstadoEstPrevPorId(Long idEstadoEstPrev) throws ExcepcionDAO{
        SiiEstadoEstPrev siiEstadoEstPrev = null;
        try{
            siiEstadoEstPrev = (SiiEstadoEstPrev) manager.find(SiiEstadoEstPrev.class, idEstadoEstPrev);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
        }
        return siiEstadoEstPrev;
    }

    public SiiEstadoEstPrev insertarEstadoEstPrev(SiiEstadoEstPrev siiEstadoEstPrev) throws ExcepcionDAO{
        try{
            manager.persist(siiEstadoEstPrev);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
        }
        return siiEstadoEstPrev;
    }
    
    public SiiEstadoEstPrev actualizarEstadoEstPrevPorId(SiiEstadoEstPrev siiEstadoEstPrev) throws ExcepcionDAO{
        try{
            siiEstadoEstPrev = manager.merge(siiEstadoEstPrev);
            manager.flush();
            return siiEstadoEstPrev;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
        }
    }
    public List<SiiEstadoEstPrev> buscarTodoEstadoEstPrev() throws ExcepcionDAO{
        try{
            List<SiiEstadoEstPrev> listaEstadoEstPrev = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT eep FROM SiiEstadoEstPrev eep");
            Query query = manager.createQuery(sql.toString());
            listaEstadoEstPrev = query.getResultList();
            return listaEstadoEstPrev;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"UsuarioDAO");
        }        
    }
}