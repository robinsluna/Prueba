package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
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
public class AmparoPolContProvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AmparoPolContProvDAO() {      
        recursos = new Recursos();
    }
    
    public SiiAmparoPolContProv buscarAmparoPolContProvPorId(Long idAmparoPolContProv) throws ExcepcionDAO{
        SiiAmparoPolContProv siiAmparoPolContProv = new SiiAmparoPolContProv();
        try{
            siiAmparoPolContProv = (SiiAmparoPolContProv) manager.find(SiiAmparoPolContProv.class, idAmparoPolContProv);
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoPolContProvDAO");
            }
        return siiAmparoPolContProv;
    }
    
    public SiiAmparoPolContProv insertarAmparoPolContProv(SiiAmparoPolContProv siiAmparoPolContProv) throws ExcepcionDAO{
        try{            
            manager.persist(siiAmparoPolContProv);                                                                            
            manager.flush();                               
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoPolContProvDAO");
        }
        return siiAmparoPolContProv;
    }
    
    public SiiAmparoPolContProv actualizarAmparoPolContProv (SiiAmparoPolContProv siiAmparoPolContProv) throws ExcepcionDAO{
        try{
            siiAmparoPolContProv = manager.merge(siiAmparoPolContProv);
            manager.flush();
            return siiAmparoPolContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoPolContProvDAO");
        }
    }
    
    public List<SiiAmparoPolContProv> buscarTodosAmparoPolContProv () throws ExcepcionDAO{
        try{
            List<SiiAmparoPolContProv> listaAmparoPolContProv = new ArrayList<SiiAmparoPolContProv>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT apcp FROM SiiAmparoPolContProv  apcp");
            Query query = manager.createQuery(sql.toString());
            listaAmparoPolContProv = query.getResultList();
            return listaAmparoPolContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AmparoPolContProvDAO");
        }
    }    
    
    public List<SiiAmparoPolContProv> buscarAmparoPolContProvPorIdPolizaContProv (Long idPolizaContProv) throws ExcepcionDAO{
        try{
            List<SiiAmparoPolContProv> listaAmparoPolContProv = new ArrayList<SiiAmparoPolContProv>();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT apcp FROM SiiAmparoPolContProv  apcp WHERE apcp.siiPolizaContProv.pcpCodigo = :idPolizaContProv");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPolizaContProv", idPolizaContProv);
            listaAmparoPolContProv = query.getResultList();
            return listaAmparoPolContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AmparoPolContProvDAO");
        }
    }    
    
    public void eliminarAmparoPolContProv (Long idAmparoPolContProv) throws ExcepcionDAO{
        try{
            SiiAmparoPolContProv amparoPolContProv = (SiiAmparoPolContProv) manager.find(SiiAmparoPolContProv.class, idAmparoPolContProv);
            manager.remove(amparoPolContProv);
            manager.flush();
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoPolContProvDAO");
            }
    }
}

