package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSoporteModif;
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
public class TipoDocSoporteModifDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoDocSoporteModifDAO() {
        recursos = new Recursos();
    }

    public List<SiiTipoDocSoporteModif> buscarTodosTipoDocSoporteModif() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocSoporteModif o");
            Query query = manager.createQuery(sql.toString());
            List l = query.getResultList();
            return l;
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoDocSoporteModifDAO");
        }
    }

    public SiiTipoDocSoporteModif buscarTipoSoporteModifPorId(Long tdmCodigo) throws ExcepcionDAO {
        SiiTipoDocSoporteModif siiTipoDocSoporteModif = null;
        try {
            siiTipoDocSoporteModif = (SiiTipoDocSoporteModif) manager.find(SiiTipoDocSoporteModif.class, tdmCodigo);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoDocSoporteModifDAO");
        }
        return siiTipoDocSoporteModif;
    }

    public SiiTipoDocSoporteModif buscarTipoSoporteModifPorNombre(String tdmNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocSoporteModif o WHERE o.tdmNombre = :tdmNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tdmNombre", tdmNombre);
            return (SiiTipoDocSoporteModif) query.getSingleResult();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoDocSoporteModifDAO");
        }
    }
}
