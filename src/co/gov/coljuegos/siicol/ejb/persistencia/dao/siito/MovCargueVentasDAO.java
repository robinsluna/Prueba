package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueVentas;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MovCargueVentasDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager manager;
    private Recursos recursos;


    /**
     * @author Giovanni
     * @param movCarVentMovSol
     * @return
     */
    public List<SiitoMovCargueVentas> consultarMovCargueVentasXMovCarVentMovSol(Long movCarVentMovSol) throws ExcepcionDAO {
        List<SiitoMovCargueVentas> siitoMovCargueVentas = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mcv FROM SiitoMovCargueVentas mcv");
            sql.append(" WHERE mcv.movCarVentMovSol = :movCarVentMovSol");
            sql.append(" ORDER BY mcv.movCarVentContrato, mcv.movCarVentNit");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("movCarVentMovSol", movCarVentMovSol);

            siitoMovCargueVentas = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return siitoMovCargueVentas;
    }
    
    /*public List<SiitoMovCargueVentas> consultarMovCargueVentasXVigenciaMes(String vigenciaMes) throws ExcepcionDAO {
        List<SiitoMovCargueVentas> siitoMovCargueVentas = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mcv FROM SiitoMovCargueVentas mcv");
            sql.append(" WHERE mcv.movCarVentFechaVenta = :vigenciaMes");
            sql.append(" ORDER BY mcv.movCarVentContrato, mcv.movCarVentNit");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("vigenciaMes", vigenciaMes);

            siitoMovCargueVentas = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return siitoMovCargueVentas;
    }*/
}
