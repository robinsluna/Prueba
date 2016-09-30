package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorTecn;

import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * DAO para proveedor de tecnologia
 * @author Giovanni
 */
@Stateless
@LocalBean
public class ProveedorTecnDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * Registro
     *
     * @param siiProveedorTecn
     * @throws ExcepcionDAO
     */
    public void insertarProveedorTecn(SiiProveedorTecn siiProveedorTecn) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.persist(siiProveedorTecn);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorTecnDAO");
        }
    }

    /**
     * actualizar
     *
     * @param siiProveedorTecn
     * @throws ExcepcionDAO
     */
    public void actualizarProveedorTecn(SiiProveedorTecn siiProveedorTecn) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.merge(siiProveedorTecn);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorTecnDAO");
        }
    }

}
