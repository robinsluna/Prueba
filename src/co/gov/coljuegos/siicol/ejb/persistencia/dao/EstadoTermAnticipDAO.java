package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTermAnticip;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoTermAnticipDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoTermAnticipDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoTermAnticip buscarEstadoTermAnticipPorId (Long idEtaCodigo) throws ExcepcionDAO{
        SiiEstadoTermAnticip siiEstadoTermAnticip = null;
        try{
            siiEstadoTermAnticip = (SiiEstadoTermAnticip) manager.find(SiiEstadoTermAnticip.class, idEtaCodigo);
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoTermAnticipDAO");
        }
        return siiEstadoTermAnticip;
    }
}

