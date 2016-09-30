package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinancResolAutoriz;
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
public class RevisionFinancResolAutorizDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RevisionFinancResolAutorizDAO() {
        recursos = new Recursos();
    }
    
    public SiiRevisionFinancResolAutoriz buscarRevisionFinancResolAutoriz(Long id) throws ExcepcionDAO {
        SiiRevisionFinancResolAutoriz localRevisionFinancResolAutoriz = null;
        try {
            localRevisionFinancResolAutoriz = (SiiRevisionFinancResolAutoriz) manager.find(SiiRevisionFinancResolAutoriz.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinancResolAutorizDAO");
        }
        return localRevisionFinancResolAutoriz;
    }

    public List<SiiRevisionFinancResolAutoriz> buscarRevisionFinancResolAutorizPorResolucion(Long rauCodigo) throws ExcepcionDAO {
        List<SiiRevisionFinancResolAutoriz> revisiones; 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRevisionFinancResolAutoriz o WHERE o.siiResolucionAutoriz.rauCodigo = :rauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rauCodigo", rauCodigo);
            revisiones = query.getResultList();
        }catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RevisionFinancResolAutorizDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RevisionFinancResolAutorizDAO");

        }
        return revisiones;

    }
    
    public SiiRevisionFinancResolAutoriz insertarRevisionFinancResolAutoriz(SiiRevisionFinancResolAutoriz revisionFinan) throws ExcepcionDAO {
        try {
            manager.persist(revisionFinan);
            manager.flush();
            return revisionFinan;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinancResolAutorizDAO");
        }

    }

    public SiiRevisionFinancResolAutoriz actualizarRevisionFinancResolAutoriz(SiiRevisionFinancResolAutoriz revisionFinan) throws ExcepcionDAO {
        try {
            manager.merge(revisionFinan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinancResolAutorizDAO");
        }
        return revisionFinan;
    }

    public void eliminarRevisionFinancResolAutoriz(Long idRevisionFinancResolAutoriz) throws ExcepcionDAO {
        SiiRevisionFinancResolAutoriz localRevisionFinancResolAutoriz = null;
        try {
            localRevisionFinancResolAutoriz = (SiiRevisionFinancResolAutoriz) manager.find(SiiRevisionFinancResolAutoriz.class, idRevisionFinancResolAutoriz);
            manager.remove(localRevisionFinancResolAutoriz);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionFinancResolAutorizDAO");
        }
    }

}
