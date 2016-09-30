package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseContrato;
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
public class ClaseContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ClaseContratoDAO() {
        recursos = new Recursos();
    }

    public SiiClaseContrato buscarClaseContratoPorId(Long clcCodigo) throws ExcepcionDAO {
        try {
            return (SiiClaseContrato) manager.find(SiiClaseContrato.class, clcCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ClaseContratoDAO");
        }

    }

    public List<SiiClaseContrato> listaClaseContrato() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiClaseContrato o");
            Query query = manager.createQuery(sql.toString());
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ClaseContratoDAO");
        }
    }

    public SiiClaseContrato buscarClaseContratoPorNombre(String clcNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiClaseContrato o WHERE o.clcNombre=:clcNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("clcNombre", clcNombre);
            return (SiiClaseContrato) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ClaseContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ClaseContratoDAO");

        }
    }
}
