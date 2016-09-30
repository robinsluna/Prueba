package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminalAcdv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class TerminalAcdvDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TerminalAcdvDAO() {
        super();
    }

    /**
     * @author Giovanni
     * @param siiTerminalAcdv
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTerminalAcdv actualizarSiiLicenciaAcdv(SiiTerminalAcdv siiTerminalAcdv) throws ExcepcionDAO {
        try {
            manager.merge(siiTerminalAcdv);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminalAcdvDAO");
        }
        return siiTerminalAcdv;
    }

    /**
     * @author Giovanni
     * @param siiTerminalAcdv
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTerminalAcdv insertarSiiLicenciaAcdv(SiiTerminalAcdv siiTerminalAcdv) throws ExcepcionDAO {
        try {
            manager.persist(siiTerminalAcdv);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminalAcdvDAO");
        }
        return siiTerminalAcdv;
    }
}
