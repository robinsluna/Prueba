package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContProv;
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
public class PolizaContProvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public PolizaContProvDAO() {
        recursos = new Recursos();
    }
    public SiiPolizaContProv buscarPolizaContProvPorId (Long idPolizaContProv) throws ExcepcionDAO{
        SiiPolizaContProv siiPolizaContProv = new SiiPolizaContProv();
        try{
            siiPolizaContProv = (SiiPolizaContProv) manager.find(SiiPolizaContProv.class, idPolizaContProv);
        
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
            }
        return siiPolizaContProv;
    }
    
    public SiiPolizaContProv insertarPolizaContProv (SiiPolizaContProv siiPolizaContProv) throws ExcepcionDAO{
        try{
            manager.persist(siiPolizaContProv);
            manager.flush();
            return siiPolizaContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
        }
    }
    
    public SiiPolizaContProv actualizarPolizaContProv (SiiPolizaContProv siiPolizaContProv) throws ExcepcionDAO{
        try{
            manager.merge(siiPolizaContProv);                                                                                
            manager.flush();                                                                                               
            return siiPolizaContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
        }
    }
    
    public void eliminarPolizaContProv  (Long idPolizaContProv) throws ExcepcionDAO{
        try{
            SiiPolizaContProv siiPolizaContProv = (SiiPolizaContProv) manager.find(SiiPolizaContProv.class, idPolizaContProv);
            manager.remove(siiPolizaContProv);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
        }
    }
    
    public List<SiiPolizaContProv> buscarTodoPolizaContProv () throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcp FROM SiiPolizaContProv pcp");
            Query query = manager.createQuery(sql.toString());            
            List<SiiPolizaContProv> listaSiiPolizaContProv = query.getResultList();
            return listaSiiPolizaContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
        }
    }
    
    public List<SiiPolizaContProv> buscarPolizaContProvPorIdProcesoContratacion (Long idProcesoContratacion) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcp FROM SiiPolizaContProv pcp WHERE  pcp.siiProcesoContratacion.prcCodigo = :idPc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPc", idProcesoContratacion);            
            List<SiiPolizaContProv> listaSiiPolizaContProv = query.getResultList();
            return listaSiiPolizaContProv;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"PolizaContProvDAO");
        }
    }
}

