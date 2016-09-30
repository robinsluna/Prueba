package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteRadicado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ExpedienteRadicadoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ExpedienteRadicadoDAO() {
        recursos = new Recursos();
    }

    /**
     *
     * @param siiExpedienteRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiExpedienteRadicado insertarExpedienteRadicado(SiiExpedienteRadicado siiExpedienteRadicado) throws ExcepcionDAO {
        try {
            manager.persist(siiExpedienteRadicado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteRadicado;
    }

    /**
     *
     * @param idExpedienteRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiExpedienteRadicado buscarExpedienteRadicadoPorId(Long idExpedienteRadicado) throws ExcepcionDAO {
        SiiExpedienteRadicado siiExpedienteRadicado = null;
        try {
            siiExpedienteRadicado = manager.find(SiiExpedienteRadicado.class, idExpedienteRadicado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiExpedienteRadicado;
    }

}
