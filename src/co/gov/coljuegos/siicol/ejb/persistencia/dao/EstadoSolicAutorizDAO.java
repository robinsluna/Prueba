package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicAutoriz;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoSolicAutorizDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoSolicAutorizDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoSolicAutoriz buscarEstadoSolicAutorizPorId(long idEstadoSol) throws ExcepcionDAO {
        SiiEstadoSolicAutoriz estadoSolAuto = null;
        try {
            estadoSolAuto = (SiiEstadoSolicAutoriz) manager.find(SiiEstadoSolicAutoriz.class, idEstadoSol);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicAutorizDAO");
        } 
        return estadoSolAuto;
    }
    
    public SiiEstadoSolicAutoriz buscarEstadoSolicAutorizPorNombre(String estado) throws ExcepcionDAO {
        SiiEstadoSolicAutoriz estadoSolic = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoSolicAutoriz o WHERE o.esaNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            estadoSolic = (SiiEstadoSolicAutoriz) query.getSingleResult();
            return estadoSolic;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicAutorizDAO");
        }         
    }
    
}
