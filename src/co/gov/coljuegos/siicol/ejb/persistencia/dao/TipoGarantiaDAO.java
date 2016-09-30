package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoGarantia;
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
public class TipoGarantiaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoGarantiaDAO() {
        recursos = new Recursos();
    }

    public SiiTipoGarantia buscarTipoGarantiaPorId(Long idTipoGarantia) throws ExcepcionDAO {
        SiiTipoGarantia siiTipoGarantia = null;
        try {
            siiTipoGarantia = (SiiTipoGarantia) manager.find(SiiTipoGarantia.class, idTipoGarantia);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoGarantia;
    }

    public void eliminarTipoGarantia(Long idTipoGarantia) throws ExcepcionDAO {
        try {
            SiiTipoGarantia tipoGarantia = (SiiTipoGarantia) manager.find(SiiTipoGarantia.class, idTipoGarantia);
            manager.remove(tipoGarantia);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoGarantiaDAO");
        }
    }

    public List<SiiTipoGarantia> buscarTodosTipoGarantia() throws ExcepcionDAO {
        try {
            List<SiiTipoGarantia> listaTipoGarantia = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT tGarantia FROM SiiTipoGarantia tGarantia");
            Query query = manager.createQuery(sql.toString());
            listaTipoGarantia = query.getResultList();
            return listaTipoGarantia;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public List<SiiTipoGarantia> buscarTipoGarantiaPorNombre(String nombreGarantia) throws ExcepcionDAO {
        List<SiiTipoGarantia> tipoGarantiaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT tGarantia FROM SiiTipoGarantia tGarantia");
            sql.append(" WHERE tGarantia.tgaNombre = :gNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("gNombre", nombreGarantia);
            tipoGarantiaRetorno = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return tipoGarantiaRetorno;
    }

}

