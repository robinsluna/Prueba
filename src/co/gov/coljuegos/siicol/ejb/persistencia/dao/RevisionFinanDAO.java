package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinan;
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
public class RevisionFinanDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public RevisionFinanDAO() {
        recursos = new Recursos();
    }
    
    public SiiRevisionFinan buscarRevisionFinan(Long id) throws ExcepcionDAO {
        SiiRevisionFinan localRevisionFinan = null;
        try {
            localRevisionFinan = (SiiRevisionFinan) manager.find(SiiRevisionFinan.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinanDAO");
        }
        return localRevisionFinan;
    }

    public List<SiiRevisionFinan> buscarRevisionFinanPorContrato(Long conCodigo,String rfiTipoValidac) throws ExcepcionDAO {
        List<SiiRevisionFinan> revisiones; 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRevisionFinan o WHERE o.siiContrato.conCodigo = :conCodigo AND o.rfiTipoValidac=:rfiTipoValidac");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            query.setParameter("rfiTipoValidac", rfiTipoValidac);
            revisiones = query.getResultList();
        }catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RevisionFinanDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RevisionFinanDAO");

        }
        return revisiones;

    }
    
    public SiiRevisionFinan insertarRevisionFinan(SiiRevisionFinan revisionFinan) throws ExcepcionDAO {
        try {
            manager.persist(revisionFinan);
            manager.flush();
            return revisionFinan;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinanDAO");
        }

    }

    public SiiRevisionFinan actualizarRevisionFinan(SiiRevisionFinan revisionFinan) throws ExcepcionDAO {
        try {
            manager.merge(revisionFinan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinanDAO");
        }
        return revisionFinan;
    }

    public void eliminarRevisionFinan(Long idRevisionFinan) throws ExcepcionDAO {
        SiiRevisionFinan localRevisionFinan = null;
        try {
            localRevisionFinan = (SiiRevisionFinan) manager.find(SiiRevisionFinan.class, idRevisionFinan);
            manager.remove(localRevisionFinan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinanDAO");
        }
    }
    
}
