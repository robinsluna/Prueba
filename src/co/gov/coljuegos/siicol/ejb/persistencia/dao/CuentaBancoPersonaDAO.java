package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancoPersona;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class CuentaBancoPersonaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    /**
     * @author Giovanni
     * @param siiCuentaBancoPersona
     * @throws ExcepcionDAO
     */
    public void insertarPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) throws ExcepcionDAO {
        try {
            manager.persist(siiCuentaBancoPersona);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CuentaBancoPersonaDAO");
        }
    }


    /**
     * @author Giovanni
     * @param siiCuentaBancoPersona
     * @throws ExcepcionDAO
     */
    public void actualizarPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) throws ExcepcionDAO {
        try {
            manager.merge(siiCuentaBancoPersona);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CuentaBancoPersonaDAO");
        }
    }
    
    public SiiCuentaBancoPersona buscarCuentaBancoPersonaPorId(Long idCodigoCcuenta) throws ExcepcionDAO {
        SiiCuentaBancoPersona siiCuentaBancoPersona = null;
        try{
            siiCuentaBancoPersona = (SiiCuentaBancoPersona) manager.find(SiiCuentaBancoPersona.class, idCodigoCcuenta);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
        return siiCuentaBancoPersona;
    }
    /**
     * @author Giovanni
     * @param siiCuentaBancoPersona
     * @throws ExcepcionDAO
     */
    public SiiCuentaBancoPersona insertarSiiCuentaBancoPersona(SiiCuentaBancoPersona siiCuentaBancoPersona) throws ExcepcionDAO {
        try {
            manager.persist(siiCuentaBancoPersona);
            manager.flush();
            return siiCuentaBancoPersona;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CuentaBancoPersonaDAO");
        }
    }
}
