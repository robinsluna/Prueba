package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncuInfSuperv;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MotivoIncuInfSupervDAO extends AbstractDAO<Long, SiiMotivoIncuInfSuperv>{
    public MotivoIncuInfSupervDAO() {
        super(SiiMotivoIncuInfSuperv.class);
    }

    
    public List<SiiMotivoIncuInfSuperv> buscarMotivoIncuPorInfSuper(Long isuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiMotivoIncuInfSuperv o WHERE o.siiInformeSupervision.isuCodigo = :isuCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("isuCodigo", isuCodigo);
            List<SiiMotivoIncuInfSuperv> listaMotivoIncumInfSup = query.getResultList();
            return listaMotivoIncumInfSup;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
}
