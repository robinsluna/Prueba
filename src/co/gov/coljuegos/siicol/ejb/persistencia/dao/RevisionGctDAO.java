package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGct;
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
public class RevisionGctDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public RevisionGctDAO() {
        recursos = new Recursos();
    }
    
    public SiiRevisionGct buscarRevisionGct(Long id) throws ExcepcionDAO {
        SiiRevisionGct localRevisionGct = null;
        try {
            localRevisionGct = (SiiRevisionGct) manager.find(SiiRevisionGct.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctDAO");
        }
        return localRevisionGct;
    }

    
    public List<SiiRevisionGct> buscarRevisionGctPorContrato(Long conCodigo) throws ExcepcionDAO {
        List<SiiRevisionGct> revisiones; 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRevisionGct o WHERE o.siiContrato.conCodigo = :conCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            revisiones = query.getResultList();
        }catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RevisionGctDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RevisionGctDAO");

        }
        return revisiones;

    }
    
    public SiiRevisionGct insertarRevisionGct(SiiRevisionGct revisionGct) throws ExcepcionDAO {
        try {
            manager.persist(revisionGct);
            manager.flush();
            return revisionGct;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctDAO");
        }

    }

    public SiiRevisionGct actualizarRevisionGct(SiiRevisionGct revisionGct) throws ExcepcionDAO {
        try {
            manager.merge(revisionGct);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctDAO");
        }
        return revisionGct;
    }

    public void eliminarRevisionGct(Long idRevisionGct) throws ExcepcionDAO {
        SiiRevisionGct localRevisionGct = null;
        try {
            localRevisionGct = (SiiRevisionGct) manager.find(SiiRevisionGct.class, idRevisionGct);
            manager.remove(localRevisionGct);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctDAO");
        }
    }

}
