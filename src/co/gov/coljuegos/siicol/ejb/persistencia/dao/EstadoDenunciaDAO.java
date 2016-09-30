package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDenuncia;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class EstadoDenunciaDAO extends AbstractDAO<Long, SiiEstadoDenuncia> {

    public EstadoDenunciaDAO() {
        super(SiiEstadoDenuncia.class);
    }

    public SiiEstadoDenuncia buscarEstadoPorNombre(String ednNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoDenuncia o WHERE o.ednNombre = :ednNombre");
            Query query = em.createQuery(sql.toString());
            query.setParameter("ednNombre", ednNombre);
            return (SiiEstadoDenuncia) query.getSingleResult();
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoDenunciaDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoDenunciaDAO");

        }

    }
}
