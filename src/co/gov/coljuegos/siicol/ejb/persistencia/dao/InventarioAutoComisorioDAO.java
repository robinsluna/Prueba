package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioAutoComis;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class InventarioAutoComisorioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public InventarioAutoComisorioDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiInventarioAutoComis insertarInventarioAutoComis(SiiInventarioAutoComis siiInventarioAutoComis) throws ExcepcionDAO {
        try {
            manager.persist(siiInventarioAutoComis);
            manager.flush();
            return siiInventarioAutoComis;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioAutoComisorioDAO");
        }
        catch (Exception ex) {
                    ex.printStackTrace();
                    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                    throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InventarioAutoComisorioDAO");
                }
    }
}
