package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeSupervision;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class InformeSupervisionDAO extends AbstractDAO<Long, SiiInformeSupervision> {
    public InformeSupervisionDAO() {
        super(SiiInformeSupervision.class);
    }

    public List<SiiInformeSupervision> buscarInformesOrdenadosPorFechaRadiYCodigo() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiInformeSupervision o ORDER BY o.isuFechaRadicacion DESC, o.isuCodigo DESC");
            Query query = em.createQuery(sql.toString());
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "InformeSupervisionDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InformeSupervisionDAO");

        }
    }
    
    public List<SiiInformeSupervision> buscarInformesSupervision(Long usuCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiInformeSupervision o WHERE o.siiUsuario.usuCodigo = :usuCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("usuCodigo", usuCodigo);
            return query.getResultList();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "InformeSupervisionDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InformeSupervisionDAO");

        }
    }

    public int calcularConsecutivoProcesoPorTipoActuacionSupervisor(Long tacCodigo) throws ExcepcionDAO {
        // 4 proceso fiscalizacion
        // 3 proceso incumplimiento
        try {
            StringBuilder sql = new StringBuilder();
            if (tacCodigo == 3L) {
                sql.append(" SELECT max(o.icnConsecutivo) FROM SiiIncumplimientoContr  o JOIN o.siiInformeSupervision i WHERE o.siiInformeSupervision.siiTipoActuacion.tacCodigo = :tacCodigo");                
            } else if (tacCodigo == 4L) {
                sql.append(" SELECT max(o.psaConsecutivo) FROM SiiProcesoSancionatorio  o JOIN o.siiInformeSupervision i WHERE o.siiInformeSupervision.siiTipoActuacion.tacCodigo = :tacCodigo");                
            }
            Query query = em.createQuery(sql.toString());
            query.setParameter("tacCodigo", tacCodigo);
            Integer i = (Integer) query.getSingleResult();
            if (i==null) {
                i = 0;
            }
            return i;
        } catch(NoResultException nre) {
            return 0;
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "InformeSupervisionDAO");
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "InformeSupervisionDAO");

        }
    }
}
