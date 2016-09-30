package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrNoCorresp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class InstrnoCorrespDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public InstrnoCorrespDAO() {
        recursos = new Recursos();
    }
    
    public SiiInstrNoCorresp insertarInstrnoCorresp(SiiInstrNoCorresp siiInstrNoCorresp) throws ExcepcionDAO {
        try {
            manager.persist(siiInstrNoCorresp);
            manager.flush();
            return siiInstrNoCorresp;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrnoCorrespDAO");
        }
    }
    
    
}
