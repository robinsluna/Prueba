package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracionSug;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DetalleDeclaracionSugDAO extends GenericDAO<SiiDetalleDeclaracionSug>{

    public DetalleDeclaracionSugDAO(){
        super(SiiDetalleDeclaracionSug.class);
    }

    /**
     *Metodo encargado de consulta el listado de tasas interes
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleDeclaracionSug> consultarListaDetalleDeclaracionSug() throws ExcepcionDAO {
        List<SiiDetalleDeclaracionSug> listaDetalleDeclaracionSug = new ArrayList<SiiDetalleDeclaracionSug>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiDetalleDeclaracionSug u");

            Query consulta = em.createQuery(sql.toString());
            listaDetalleDeclaracionSug = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaDetalleDeclaracionSug;
    }

    /**
     *Metodo encargado de hacer la consulta de los detalles declaracion sugerida registrados para un codigo
     * de una declaracion sugerida
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleDeclaracionSug> consultarListaDetalleDeclaracionSugPorCodigoDecSug(long codigoDeclaracionSug) throws ExcepcionDAO {
        List<SiiDetalleDeclaracionSug> listaDetalleDeclaracionSug = new ArrayList<SiiDetalleDeclaracionSug>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiDetalleDeclaracionSug u");
            sql.append(" INNER JOIN u.siiDeclaracionSugerida dsu");
            sql.append(" WHERE dsu.dsuCodigo = :codigoDeclaracionSugerida");

            Query consulta = em.createQuery(sql.toString());
            consulta.setParameter("codigoDeclaracionSugerida", codigoDeclaracionSug);

            listaDetalleDeclaracionSug = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaDetalleDeclaracionSug;
    }
}
