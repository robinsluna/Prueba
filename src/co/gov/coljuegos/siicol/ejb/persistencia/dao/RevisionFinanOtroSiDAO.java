
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisFinancOtrosi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class RevisionFinanOtroSiDAO extends AbstractDAO<Long, SiiRevisFinancOtrosi>{
    public RevisionFinanOtroSiDAO() {
        super(SiiRevisFinancOtrosi.class);
    }
    
    public List<SiiRevisFinancOtrosi> buscarRevisionFinanPorOtroSi(Long osiCodigo, String rfoTipoValidac) throws ExcepcionDAO {
        List<SiiRevisFinancOtrosi> revisiones; 
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiRevisFinancOtrosi o WHERE o.siiOtrosi.osiCodigo = :osiCodigo AND o.rfoTipoValidac=:rfoTipoValidac");
            Query query = em.createQuery(sql.toString());
            query.setParameter("osiCodigo", osiCodigo);
            query.setParameter("rfoTipoValidac", rfoTipoValidac);
            revisiones = query.getResultList();
        }catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RevisFinancOtroSiDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "RevisFinancOtroSiDAO");

        }
        return revisiones;
    }
}
