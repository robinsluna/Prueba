package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSuspensionContr;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SuspensionContrDAO extends AbstractDAO<Long, SiiSuspensionContr>{
    public SuspensionContrDAO() {
        super(SiiSuspensionContr.class);
    }
    
    public List<SiiSuspensionContr> buscarTodaSuspension(String stringOrder ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiSuspensionContr o "+ stringOrder);
            Query query = em.createQuery(sql.toString());                        
            return query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
}
