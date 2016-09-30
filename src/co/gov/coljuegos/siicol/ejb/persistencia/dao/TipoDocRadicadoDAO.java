package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocRadicado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class TipoDocRadicadoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TipoDocRadicadoDAO() {
        recursos = new Recursos();
    }

    /**
     *
     * @param siiTipoDocRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTipoDocRadicado insertarTipoDocRadicado(SiiTipoDocRadicado siiTipoDocRadicado) throws ExcepcionDAO {
        try {
            manager.persist(siiTipoDocRadicado);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoDocRadicado;
    }

    /**
     *
     * @param idTipoDocRadicado
     * @return
     * @throws ExcepcionDAO
     */
    public SiiTipoDocRadicado buscarTipoDocRadicadoPorId(Long idTipoDocRadicado) throws ExcepcionDAO {
        SiiTipoDocRadicado siiTipoDocRadicado = null;
        try {
            siiTipoDocRadicado = manager.find(SiiTipoDocRadicado.class, idTipoDocRadicado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoDocRadicado;
    }


    public SiiTipoDocRadicado actualizarTipoDocRadicado(SiiTipoDocRadicado siiTipoDocRadicado) throws ExcepcionDAO {
        try {
            manager.merge(siiTipoDocRadicado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiTipoDocRadicado;
    }
}
