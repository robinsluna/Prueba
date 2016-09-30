package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
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
public class EstadoCdpDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoCdpDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoCdp buscarEstadoCdpPorId(long idEstadoCdp) throws ExcepcionDAO {
        SiiEstadoCdp estadoCdp = null;
        try {
            estadoCdp = (SiiEstadoCdp) manager.find(SiiEstadoCdp.class, idEstadoCdp);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoCdpDAO");
        } 
        return estadoCdp;
    }
    
    public SiiEstadoCdp insertarEstadoCdp(SiiEstadoCdp estadoCdp) throws ExcepcionDAO {
        try {
            manager.persist(estadoCdp);
            manager.flush();
            return estadoCdp;
        } catch (PersistenceException pe) {
            String mensajeError =  recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoCdpDAO");
        }
    }
    
    public void eliminarEstadoCdp(long idEstadoCdp) throws ExcepcionDAO {
        try {
            SiiEstadoCdp estadoCdp = (SiiEstadoCdp) manager.find(SiiEstadoCdp.class, idEstadoCdp);
            manager.remove(estadoCdp);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError =  recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoCdpDAO");
        }
        
    }
    
    public List<SiiEstadoCdp> buscarTodoCdp() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoCdp o");
            Query query = manager.createQuery(sql.toString());
            List<SiiEstadoCdp> listaEstadoCdp = query.getResultList();
            return listaEstadoCdp;
        } catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoCdpDAO");
        }
    }
    
}
