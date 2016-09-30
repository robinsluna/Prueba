package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoEstadoCargueInventario;
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
public class EstadoCargueInventarioDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * @author Giovanni
     * @param siitoEstadoCargueInventario
     * @throws ExcepcionDAO
     */
    public void registrarEstadoCargueInventario(SiitoEstadoCargueInventario siitoEstadoCargueInventario) throws ExcepcionDAO {
        try {
            entityManager.persist(siitoEstadoCargueInventario);
            entityManager.flush();
        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "EstadoCargueInventarioDAO");
        }
    }

    /**
     * @author Giovanni
     * @param estCargInvDesc
     * @return
     * @throws ExcepcionDAO
     */
    public SiitoEstadoCargueInventario buscarSiitoEstadoCargueInventarioXEstCargInvDesc(String estCargInvDesc) throws ExcepcionDAO {
        List<SiitoEstadoCargueInventario> siitoEstadoCargueInventarios = null;
        SiitoEstadoCargueInventario siitoEstadoCargueInventario = null;

        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT est FROM SiitoEstadoCargueInventario est");
            sql.append(" WHERE est.estCargInvDesc = :estCargInvDesc");

            Query query = entityManager.createQuery(sql.toString());
            query.setParameter("estCargInvDesc", estCargInvDesc);

            siitoEstadoCargueInventarios = query.getResultList();

            if (siitoEstadoCargueInventarios != null && !siitoEstadoCargueInventarios.isEmpty()) {
                siitoEstadoCargueInventario = siitoEstadoCargueInventarios.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoCargueInventarioDAO");
        }
        return siitoEstadoCargueInventario;
    }
}
