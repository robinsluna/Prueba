package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiParametrosSistema;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ParametrosSistemaDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ParametrosSistemaDAO() {
        recursos = new Recursos();
    }
    
    public SiiParametrosSistema buscarParametroPorId(String Id) throws ExcepcionDAO{
        SiiParametrosSistema retornoParametro = null;
        try {
            retornoParametro = manager.find(SiiParametrosSistema.class, Id);

        } catch (PersistenceException pe) {
            throw new ExcepcionDAO("Error de operación de Base de Datos. : " + pe.getMessage(), "OperadorDAO");
        }
        return retornoParametro;
    }
}
