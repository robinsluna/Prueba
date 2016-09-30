package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPresup;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoModifPresupDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoModifPresupDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoModifPresup buscarEstadoModifPresupPorId (Long idMprCodigo) throws ExcepcionDAO{
        SiiEstadoModifPresup siiEstadoModifPresup  = null;
        try{
            siiEstadoModifPresup  = (SiiEstadoModifPresup) manager.find(SiiEstadoModifPresup.class  , idMprCodigo);
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifPresupDAO");   
        }
        return siiEstadoModifPresup;
    }
    
    public SiiEstadoModifPresup actualizarEstadoModifPresup (SiiEstadoModifPresup siiEstadoModifPresup) throws ExcepcionDAO{
        try{
            manager.merge(siiEstadoModifPresup);
            manager.flush();
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifPresupDAO");
            }
        return siiEstadoModifPresup;
    }
    
    public SiiEstadoModifPresup insertarEstadoModifPresup (SiiEstadoModifPresup siiEstadoModifPresup) throws ExcepcionDAO {
        try{
            manager.persist(siiEstadoModifPresup);
            manager.flush();
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifPresupDAO");
        }
        return siiEstadoModifPresup;
    }
}


