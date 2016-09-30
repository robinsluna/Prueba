package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMoneda;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * DAO para moneda
 * @author Giovanni
 */
@Stateless
@LocalBean
public class MonedaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager entityManager;
    private Recursos recursos;

    /**
     * Registro
     *
     * @param siiMoneda
     * @throws ExcepcionDAO
     */
    public void insertarMoneda(SiiMoneda siiMoneda) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.persist(siiMoneda);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "MonedaDAO");
        }
    }

    /**
     * actualizar
     *
     * @param siiMoneda
     * @throws ExcepcionDAO
     */
    public void actualizarMoneda(SiiMoneda siiMoneda) throws ExcepcionDAO {
        recursos = new Recursos();
        try {
            entityManager.merge(siiMoneda);
            entityManager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "MonedaDAO");
        }
    }
    
    /**
     * Metodo para traer todas las monedas
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiMoneda> buscarMonedas() throws ExcepcionDAO {
        List<SiiMoneda> siiMonedas = new ArrayList<SiiMoneda>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT m FROM SiiMoneda m");
            sql.append(" ORDER BY m.monNombre ASC");

            Query query = entityManager.createQuery(sql.toString());
            siiMonedas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MonedaDAO");
        }
        return siiMonedas;
    }
    
    public SiiMoneda buscarMonedaPorId(Long idMoneda) throws ExcepcionDAO{
        SiiMoneda siiMoneda = null;
        try {
            siiMoneda = (SiiMoneda) entityManager.find(SiiMoneda.class, idMoneda);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModuloDAO");
        }
        return siiMoneda;
    }
}
