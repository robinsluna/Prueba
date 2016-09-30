package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaExigida;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class GarantiaExigidaDAO extends GenericDAO<SiiGarantiaExigida> {
    
    public GarantiaExigidaDAO() {
        super(SiiGarantiaExigida.class);
    }

    public List<SiiGarantiaExigida> buscarTodaGarantiaExigida() throws ExcepcionDAO {
        List<SiiGarantiaExigida> listSiiGarantiaExigida = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiGarantiaExigida o");
            Query query = em.createQuery(sql.toString());
            listSiiGarantiaExigida = query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listSiiGarantiaExigida;
    }
}
