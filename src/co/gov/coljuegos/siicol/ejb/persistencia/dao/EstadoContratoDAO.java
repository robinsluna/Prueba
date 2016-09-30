package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoContratoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoContratoDAO() {
        recursos = new Recursos();
    }

    public SiiEstadoContrato buscarEstadoContratoPorNombre(String ecoNombre) throws ExcepcionDAO {
        SiiEstadoContrato estado = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoContrato o WHERE o.ecoNombre = :ecoNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ecoNombre", ecoNombre);
            estado = (SiiEstadoContrato) query.getSingleResult();

        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoContratoDAO");

        }
        return estado;
    }
    
    public SiiEstadoContrato buscarEstadoContratoPorId(Long ecoCodigo) throws ExcepcionDAO {
        SiiEstadoContrato siiEstadoContrato = null;
        try {
            siiEstadoContrato = (SiiEstadoContrato) manager.find(SiiEstadoContrato.class, ecoCodigo);
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoContratoDAO");
        }
        return siiEstadoContrato;
    }

}
