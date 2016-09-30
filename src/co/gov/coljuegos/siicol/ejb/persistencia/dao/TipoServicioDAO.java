package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoServicio;
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
public class TipoServicioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoServicioDAO() {
        recursos = new Recursos();
    }

    public SiiTipoServicio buscarTipoServicioPorId(Long idTipoServicio) throws ExcepcionDAO {
        SiiTipoServicio tipoServicio = null;
        try {
            tipoServicio = (SiiTipoServicio) manager.find(SiiTipoServicio.class, idTipoServicio);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return tipoServicio;
    }
    
    public SiiTipoServicio buscarTipoServicioPorNombre(String nombreServicio) throws ExcepcionDAO {
        SiiTipoServicio tipoServicio = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoServicio o WHERE o.tseNombre LIKE :nombreServicio");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreServicio", nombreServicio );
            tipoServicio = (SiiTipoServicio) query.getResultList().get(0);
            return tipoServicio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<SiiTipoServicio> buscarTodoTipoServicio() throws ExcepcionDAO {
        List<SiiTipoServicio> listaTipoServicio = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoServicio o");
            Query query = manager.createQuery(sql.toString());
            listaTipoServicio = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaTipoServicio;
    }
}

