package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecSuspension;
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
public class EstablecSuspensionDAO extends AbstractDAO<Long, SiiEstablecSuspension> {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public EstablecSuspensionDAO() {
        super(SiiEstablecSuspension.class);
        recursos = new Recursos();
    }

    public List<SiiEstablecSuspension> buscarEstablecSuspensionPorSuspension(Long scoCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstablecSuspension o WHERE o.siiSuspensionContr.scoCodigo=:scoCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("scoCodigo", scoCodigo);
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstablecSuspensionDAO");
        }
    }
}


