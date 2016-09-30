package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqAlcanceInv;
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
public class ReqAlcanceInvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ReqAlcanceInvDAO() {
        recursos = new Recursos();
    }
    
    public SiiReqAlcanceInv buscarReqAlcanceInvPorId(Long id) throws ExcepcionDAO {
        SiiReqAlcanceInv reqAlcanceInv = null;
        try {
            reqAlcanceInv = (SiiReqAlcanceInv) manager.find(SiiReqAlcanceInv.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ReqAlcanceInvDAO");
        }
        return reqAlcanceInv;
    }
    
    public List<SiiReqAlcanceInv> buscarReqAlcanceInvPorAlcanceInv(Long id) throws  ExcepcionDAO {
        try {
            List<SiiReqAlcanceInv> listaReqAlcanceInv = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiReqAlcanceInv o JOIN o.siiAlcanceInvitacion e WHERE e.aliCodigo = :id");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            listaReqAlcanceInv = query.getResultList();
            
            return listaReqAlcanceInv;

        } catch  (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ReqAlcanceInvDAO");
        }
    }
    
    public SiiReqAlcanceInv insertarReqAlcanceInv(SiiReqAlcanceInv reqAlcanceInv) throws ExcepcionDAO {
        try {
            manager.persist(reqAlcanceInv);
            manager.flush();
            return reqAlcanceInv;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ReqAlcanceInvDAO");
        }
        
    }

    public SiiReqAlcanceInv actualizarReqAlcanceInv(SiiReqAlcanceInv reqAlcanceInv) throws ExcepcionDAO {
        try {
            manager.merge(reqAlcanceInv);
            manager.flush();
            return reqAlcanceInv;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ReqAlcanceInvDAO");
        }
        
    }
    
    public void eliminarReqAlcanceInv(SiiReqAlcanceInv reqAlcanceInv) throws ExcepcionDAO {
        try {
            manager.remove(reqAlcanceInv);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ReqAlcanceInvDAO");
        }
    }
 
}
