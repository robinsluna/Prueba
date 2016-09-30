package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;
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
public class ReqEstudioPrevioDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ReqEstudioPrevioDAO() {
        recursos = new Recursos();
    }

    public SiiReqEstudioPrevio buscarReqEstudioPrevioPorId(Long idReqEstudioPrevio) throws ExcepcionDAO {
        SiiReqEstudioPrevio siiReqEstudioPrevioRetorno = null;
        try {
            siiReqEstudioPrevioRetorno =
                (SiiReqEstudioPrevio) manager.find(SiiReqEstudioPrevio.class, idReqEstudioPrevio);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiReqEstudioPrevioDAO");
        }
        return siiReqEstudioPrevioRetorno;
    }

    public SiiReqEstudioPrevio insertarReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) throws ExcepcionDAO {
        try {
            manager.persist(siiReqEstudioPrevio); //La guarda en el almacen
            manager.flush(); //Retorna el VO
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReqEstudioPrevioDAO");
        }
        return siiReqEstudioPrevio;
    }

    public SiiReqEstudioPrevio actualizarReqEstudioPrevio(SiiReqEstudioPrevio siiReqEstudioPrevio) throws ExcepcionDAO {
        try {
            siiReqEstudioPrevio = manager.merge(siiReqEstudioPrevio);
            manager.flush();
            return siiReqEstudioPrevio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReqEstudioPrevioDAO");
        }
    }

    public List<SiiReqEstudioPrevio> buscarTodosReqEstudioPrevio() throws ExcepcionDAO {
        try {
            List<SiiReqEstudioPrevio> listaReqEstudioPrevio = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rep FROM SiiReqEstudioPrevio rep");
            Query query = manager.createQuery(sql.toString());
            listaReqEstudioPrevio = query.getResultList();
            return listaReqEstudioPrevio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ReqEstudioPrevioDAO");
        }
    }

    public List<SiiReqEstudioPrevio> buscarReqEstudioPrevioPorEstudioPrevio(Long id) throws ExcepcionDAO {
        try {
            List<SiiReqEstudioPrevio> listaReqEstudioPrevio = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM  SiiReqEstudioPrevio o WHERE o.siiEstudioPrevio1.epeCodigo = :id");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            listaReqEstudioPrevio = query.getResultList();
            return listaReqEstudioPrevio;


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ReqEstudioPrevioDAO");
        }
    }
    
    public void eliminarReqEstudioPrevio(Long idReqEstudioPrevio) throws ExcepcionDAO{
        try{
            SiiReqEstudioPrevio reqEstudioPrevio = (SiiReqEstudioPrevio) manager.find(SiiReqEstudioPrevio.class, idReqEstudioPrevio);
            manager.remove(reqEstudioPrevio);
            manager.flush();
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ReqEstudioPrevioDAO");
            }
    }
}

