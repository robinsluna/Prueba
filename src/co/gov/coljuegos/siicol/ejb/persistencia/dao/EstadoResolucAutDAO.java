package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoResolucAutDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoResolucAutDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoResolucAut buscarEstadoResolucAutPorId(Long idEstado) throws ExcepcionDAO {
        SiiEstadoResolucAut estadoResolucAut = null;
        try {
            estadoResolucAut = (SiiEstadoResolucAut) manager.find(SiiEstadoResolucAut.class, idEstado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoResolucAutDAO");
        }
        return estadoResolucAut;
    }

    public SiiEstadoResolucAut buscarEstadoResolucAutPorEstado(String estado) throws ExcepcionDAO {
        SiiEstadoResolucAut estadoResolucAut = new SiiEstadoResolucAut();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoResolucAut o WHERE o.eraNombre like :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado",estado);
            estadoResolucAut = (SiiEstadoResolucAut) query.getSingleResult();
            return estadoResolucAut;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoResolucAutDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoResolucAutDAO");
        }
        
    }
}
