package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActualizacionMulta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ActualizacionMultaDAO extends GenericDAO<SiiActualizacionMulta>{
    public ActualizacionMultaDAO(){
        super(SiiActualizacionMulta.class);
    }
    
    public SiiActualizacionMulta buscarActualizacionMultaPorVigencia(Integer vigencia) throws ExcepcionDAO {
        List<SiiActualizacionMulta> listaSiiActualizacionMulta = null;
        SiiActualizacionMulta siiActualizacionMulta = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT amu FROM SiiActualizacionMulta amu ");
            sql.append("WHERE amu.amuVigencia = :vigencia ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);

            listaSiiActualizacionMulta = query.getResultList();
            if(listaSiiActualizacionMulta != null && listaSiiActualizacionMulta.size() > 0){
                siiActualizacionMulta = listaSiiActualizacionMulta.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex){
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiActualizacionMulta;
    }
}
