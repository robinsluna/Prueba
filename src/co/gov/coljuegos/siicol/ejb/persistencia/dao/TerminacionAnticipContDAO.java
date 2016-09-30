package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminacionAnticip;
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
public class TerminacionAnticipContDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public TerminacionAnticipContDAO() {
        recursos = new Recursos();
    }

    public SiiTerminacionAnticip buscarTerminacionAnticipadaPorId(Long idTanCodigo) throws ExcepcionDAO {
        SiiTerminacionAnticip siiTerminacionAnticip = null;
        try {
            siiTerminacionAnticip = (SiiTerminacionAnticip) manager.find(SiiTerminacionAnticip.class, idTanCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
        return siiTerminacionAnticip;
    }

    public SiiTerminacionAnticip insertarTerminacionAnticipada(SiiTerminacionAnticip siiTerminacionAnticip) throws ExcepcionDAO {
        try {
            manager.persist(siiTerminacionAnticip);
            manager.flush();
            return siiTerminacionAnticip;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }

    public SiiTerminacionAnticip actualizarTerminacionAnticipada(SiiTerminacionAnticip siiTerminacionAnticip) throws ExcepcionDAO {
        try {
            manager.merge(siiTerminacionAnticip);
            manager.flush();
            return siiTerminacionAnticip;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }

    public void eliminarTerminacionAnticipada(Long idTapCodigo) throws ExcepcionDAO {
        try {
            SiiTerminacionAnticip siiTerminacionAnticip =
                (SiiTerminacionAnticip) manager.find(SiiTerminacionAnticip.class, idTapCodigo);
            manager.remove(siiTerminacionAnticip);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }

    public List<SiiTerminacionAnticip> buscarTodoTerminacionAnticipada() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT terminaAnticipa FROM SiiTerminacionAnticip terminaAnticipa order by terminaAnticipa.tanRadicado desc");
            Query query = manager.createQuery(sql.toString());
            List<SiiTerminacionAnticip> listaTerminacionAnticip = query.getResultList();
            return listaTerminacionAnticip;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }

    public List<SiiTerminacionAnticip> buscarTerminacionAnticipadaPorEstado(String estadoNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT terminaAnticipa FROM SiiTerminacionAnticip terminaAnticipa INNER JOIN  terminaAnticipa.siiEstadoTermAnticip estadoTan WHERE estadoTan.etaNombre =: estadoNombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoNombre", estadoNombre);
            List<SiiTerminacionAnticip> listaTerminacionAnticip = query.getResultList();
            return listaTerminacionAnticip;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }

    /**
     * Buscar las terminaciones anticipadas según id de contrato
     * @param conCodigo
     * @return listaTerminacionAnticip - Lista de terminaciones anticipadas
     * @throws ExcepcionDAO
     */

    public List<SiiTerminacionAnticip> buscarTerminacionAnticipadaPorIdContrato(Long conCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT terminaAnticipa FROM SiiTerminacionAnticip terminaAnticipa WHERE terminaAnticipa.siiContrato.conCodigo = :conCodigo ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);
            List<SiiTerminacionAnticip> listaTerminacionAnticip = query.getResultList();
            return listaTerminacionAnticip;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TerminacionAnticipContDAO");
        }
    }
    
}
