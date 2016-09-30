package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAlcanceInvitacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class AlcanceInvitacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public AlcanceInvitacionDAO() {
        recursos = new Recursos();
    }

    public SiiAlcanceInvitacion buscarAlcanceInvitacionPorId (Long idAlcanceInvitacion) throws ExcepcionDAO {
        SiiAlcanceInvitacion alcanceInvitacion = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiAlcanceInvitacion o WHERE o.aliCodigo = :idAlcanceInvitacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idAlcanceInvitacion", idAlcanceInvitacion);
            alcanceInvitacion = (SiiAlcanceInvitacion) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AlcanceInvitacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "AlcanceInvitacionDAO");

        }
        return alcanceInvitacion;
    }
    
    public SiiAlcanceInvitacion buscarUltimoAlcanceInvitacionPorProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO {

        SiiAlcanceInvitacion alcanceInvitacion = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT MAX(o.aliCodigo) FROM SiiAlcanceInvitacion o JOIN o.siiProcesoContratacion p WHERE p.prcCodigo = :idProcesoContratacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idProcesoContratacion", idProcesoContratacion);
            Long aliCodigo = (Long) query.getSingleResult();

            if (aliCodigo != null) {
                alcanceInvitacion = buscarAlcanceInvitacionPorId(aliCodigo);
            }
            
            

        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AlcanceInvitacionDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "AlcanceInvitacionDAO");

        }
        return alcanceInvitacion;
    }

    public SiiAlcanceInvitacion insertarAlcanceInvitacion(SiiAlcanceInvitacion alcanceInvitacion) throws ExcepcionDAO {
        try {
            manager.persist(alcanceInvitacion);
            manager.flush();
            return alcanceInvitacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AlcanceInvitacionDAO");
        }

    }

    public SiiAlcanceInvitacion actualizarAlcanceInvitacion(SiiAlcanceInvitacion alcanceInvitacion) throws ExcepcionDAO {
        try {
            manager.merge(alcanceInvitacion);
            manager.flush();
            return alcanceInvitacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AlcanceInvitacionDAO");
        }

    }
    
    public void eliminarAlcanceInvitacion(Long idAlcanceInvitacion) throws ExcepcionDAO {
        SiiAlcanceInvitacion localAlcanceInvitacion;
        try {
            localAlcanceInvitacion = (SiiAlcanceInvitacion) manager.find(SiiAlcanceInvitacion.class, idAlcanceInvitacion);
            manager.remove(localAlcanceInvitacion);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AlcanceInvitacionDAO");
        }
    }
}

