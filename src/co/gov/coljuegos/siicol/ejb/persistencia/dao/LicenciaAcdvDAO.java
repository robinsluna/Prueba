package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLicenciaAcdv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class LicenciaAcdvDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public LicenciaAcdvDAO() {
        super();
    }

    /**
     * @author Giovanni
     * @param siiLicenciaAcdv
     * @return
     * @throws ExcepcionDAO
     */
    public SiiLicenciaAcdv actualizarSiiLicenciaAcdv(SiiLicenciaAcdv siiLicenciaAcdv) throws ExcepcionDAO {
        try {
            manager.merge(siiLicenciaAcdv);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LicenciaAcdvDAO");
        }
        return siiLicenciaAcdv;
    }

    /**
     * @author Giovanni
     * @param siiLicenciaAcdv
     * @return
     * @throws ExcepcionDAO
     */
    public SiiLicenciaAcdv insertarSiiLicenciaAcdv(SiiLicenciaAcdv siiLicenciaAcdv) throws ExcepcionDAO {
        try {
            manager.persist(siiLicenciaAcdv);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LicenciaAcdvDAO");
        }
        return siiLicenciaAcdv;
    }
}
