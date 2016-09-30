package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargInvEstCargInv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class MovCargInvEstCargInvDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * @author Giovanni
     * @param siitoMovCargInvEstCargInv
     * @throws ExcepcionDAO
     */
    public void registrarMovCargInvEstCargInv(SiitoMovCargInvEstCargInv siitoMovCargInvEstCargInv) throws ExcepcionDAO {
        try {
            entityManager.persist(siitoMovCargInvEstCargInv);
            entityManager.flush();
        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "MovCargInvEstCargInvDAO");
        }
    }
}
