package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGctResolucAutoriza;
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
public class RevisionGctResolucAutorizaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RevisionGctResolucAutorizaDAO() {
        recursos = new Recursos();
    }
    
    public SiiRevisionGctResolucAutoriza buscarRevisionGctResolucAutoriza(Long id) throws ExcepcionDAO {
        SiiRevisionGctResolucAutoriza localRevisionGctResolucAutoriza = null;
        try {
            localRevisionGctResolucAutoriza = (SiiRevisionGctResolucAutoriza) manager.find(SiiRevisionGctResolucAutoriza.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctResolucAutorizaDAO");
        }
        return localRevisionGctResolucAutoriza;
    }

    public List<SiiRevisionGctResolucAutoriza> buscarRevisionGctResolucAutorizaPorResolucion(Long rauCodigo) throws ExcepcionDAO {
        List<SiiRevisionGctResolucAutoriza> revisiones; 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRevisionGctResolucAutoriza o WHERE o.siiResolucionAutoriz.rauCodigo = :rauCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rauCodigo", rauCodigo);
            revisiones = query.getResultList();
        }catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RevisionGctResolucAutorizaDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RevisionGctResolucAutorizaDAO");

        }
        return revisiones;

    }
    
    public SiiRevisionGctResolucAutoriza insertarRevisionGctResolucAutoriza(SiiRevisionGctResolucAutoriza revisionFinan) throws ExcepcionDAO {
        try {
            manager.persist(revisionFinan);
            manager.flush();
            return revisionFinan;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctResolucAutorizaDAO");
        }

    }

    public SiiRevisionGctResolucAutoriza actualizarRevisionGctResolucAutoriza(SiiRevisionGctResolucAutoriza revisionFinan) throws ExcepcionDAO {
        try {
            manager.merge(revisionFinan);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctResolucAutorizaDAO");
        }
        return revisionFinan;
    }

    public void eliminarRevisionGctResolucAutoriza(Long idRevisionGctResolucAutoriza) throws ExcepcionDAO {
        SiiRevisionGctResolucAutoriza localRevisionGctResolucAutoriza = null;
        try {
            localRevisionGctResolucAutoriza = (SiiRevisionGctResolucAutoriza) manager.find(SiiRevisionGctResolucAutoriza.class, idRevisionGctResolucAutoriza);
            manager.remove(localRevisionGctResolucAutoriza);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "RevisionGctResolucAutorizaDAO");
        }
    }

}
