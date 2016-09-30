package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DetalleRubroCdpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DetalleRubroCdpDAO() {
        recursos = new Recursos();
    }

    public SiiDetalleRubroCdp buscarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO {
        SiiDetalleRubroCdp detalleRubroCdpRetorno = null;
        try {
            detalleRubroCdpRetorno = (SiiDetalleRubroCdp) manager.find(SiiDetalleRubroCdp.class, idDetalleRubroCdp);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
        return detalleRubroCdpRetorno;

    }

    public SiiDetalleRubroCdp insertarSiiDetalleRubroCdp(SiiDetalleRubroCdp detalleRubroCdp) throws ExcepcionDAO {
        try {
            manager.persist(detalleRubroCdp);
            manager.flush();
            return detalleRubroCdp;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public SiiDetalleRubroCdp actualizarSiiDetalleRubroCdp(SiiDetalleRubroCdp detalleRubroCdp) throws ExcepcionDAO {
        try {
            manager.merge(detalleRubroCdp);
            manager.flush();
            return detalleRubroCdp;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public void borrarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO {
        SiiDetalleRubroCdp detalleRubroCdpBorrar = null;
        try {
            detalleRubroCdpBorrar = manager.find(SiiDetalleRubroCdp.class, idDetalleRubroCdp);
            manager.remove(detalleRubroCdpBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public List<SiiDetalleRubroCdp> buscarTodoSiiDetalleRubroCdp() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleRubroCdp o");
            Query query = manager.createQuery(sql.toString());
            List<SiiDetalleRubroCdp> listaDetalleRubroCdp = query.getResultList();
            return listaDetalleRubroCdp;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }

    }

    public List<SiiDetalleRubroCdp> buscarDetalleRubroCdpPorIdCdp(Long idCdp) throws ExcepcionDAO {
        List<SiiDetalleRubroCdp> listaSiiDetalleRubroCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT drc FROM SiiDetalleRubroCdp drc WHERE drc.siiCdp.cdpCodigo = :idCdp");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCdp", idCdp);
            listaSiiDetalleRubroCdp = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
        return listaSiiDetalleRubroCdp;
    }

    /**
     * @author Giovanni
     * @param idCdp
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleRubroCdp> buscarDetalleRubroCdpPorIdCdpCadenaPresupuestal(Long idCdp) throws ExcepcionDAO {
        List<SiiDetalleRubroCdp> siiDetalleRubroCdps = null;
        try {
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT drc FROM SiiDetalleRubroCdp drc");
            sql.append(" WHERE drc.siiCdp.cdpCodigo = :idCdp");
            sql.append(" AND drc.druValor != 0");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCdp", idCdp);
            
            siiDetalleRubroCdps = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
        return siiDetalleRubroCdps;
    }

    public List<SiiDetalleRubroCdp> buscarDetalleRubroCdpPorDetalleRubroYcdp(Long druCodigo,
                                                                             Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleRubroCdp o WHERE o.siiDetalleRubro.druCodigo = :druCodigo and o.siiCdp.cdpCodigo = :cdpCodigo order by o.drcAplicaGmf");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("cdpCodigo", cdpCodigo);
            return (List<SiiDetalleRubroCdp>) query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public SiiDetalleRubroCdp buscarDetalleRubroCdpPorDetalleRubroYcdpYgmf(Long druCodigo, Long cdpCodigo,
                                                                           String drcAplicaGmf) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleRubroCdp o WHERE o.siiDetalleRubro.druCodigo = :druCodigo and o.siiCdp.cdpCodigo = :cdpCodigo and  o.drcAplicaGmf = :drcAplicaGmf");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("cdpCodigo", cdpCodigo);
            query.setParameter("drcAplicaGmf", drcAplicaGmf);

            return (SiiDetalleRubroCdp) query.getSingleResult();
        } catch (NoResultException nre) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + nre.getMessage(), "DetalleRubroCdpDAO");
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public String aplicaGmfAlRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT drc.drcAplicaGmf FROM SiiDetalleRubroCdp drc \n" +
                       "WHERE drc.siiDetalleRubro.druCodigo = :druCodigo AND drc.siiCdp.cdpCodigo = :cdpCodigo \n" +
                       "AND drc.drcAplicaGmf = 'S'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);
            query.setParameter("cdpCodigo", cdpCodigo);

            return (String) query.getSingleResult();
        } catch (NoResultException nre) {
            return "N";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }

    public List<SiiDetalleRubroCdp> buscarDetallesRubroCdpPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleRubroCdp o WHERE o.siiDetalleRubro.druCodigo = :druCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("druCodigo", druCodigo);

            return  query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleRubroCdpDAO");
        }
    }
}
