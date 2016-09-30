/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DetalleFinancDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DetalleFinancDAO() {
        recursos = new Recursos();
    }

    public SiiDetalleFinanc buscarDetalleFinancPorCodigo(Long idCodigoDetFinanc) throws ExcepcionDAO {
        SiiDetalleFinanc retorno = null;
        try {
            retorno = (SiiDetalleFinanc) manager.find(SiiDetalleFinanc.class, idCodigoDetFinanc);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }
        return retorno;

    }

    public SiiDetalleFinanc insertarSiiDetalleFinanc(SiiDetalleFinanc detalleFinanc) throws ExcepcionDAO {
        try {
            manager.persist(detalleFinanc);
            manager.flush();
            return detalleFinanc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }
    }

    public SiiDetalleFinanc actualizarSiiDetalleFinanc(SiiDetalleFinanc detalleFinanc) throws ExcepcionDAO {
        try {
            manager.merge(detalleFinanc);
            manager.flush();
            return detalleFinanc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }
    }

    public void borrarSiiDetalleFinanc(Long idCodigoDetalleFinanc) throws ExcepcionDAO {
        SiiDetalleFinanc detalleFinanc = null;
        try {
            detalleFinanc = manager.find(SiiDetalleFinanc.class, idCodigoDetalleFinanc);
            manager.remove(detalleFinanc);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }
    }


    public List<SiiDetalleFinanc> buscarTodoSiiDetalleFinanc() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleFinanc o");
            Query query = manager.createQuery(sql.toString());
            List<SiiDetalleFinanc> listaDetalleFinanc = query.getResultList();
            return listaDetalleFinanc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }

    }

    public SiiDetalleFinanc buscarDetalleFinancPorPersona(Long perCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDetalleFinanc o JOIN o.siiPersona2 p WHERE p.perCodigo = :perCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            List<SiiDetalleFinanc> detalles = query.getResultList();
            SiiDetalleFinanc detalleFinanc;
            if (detalles.size() > 0) {
                detalleFinanc = (SiiDetalleFinanc) detalles.get(0);
            } else {
                detalleFinanc = new SiiDetalleFinanc();
            }

            return detalleFinanc;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }

    }

    /**
     * @author Giovanni
     * @param perCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleFinanc> buscarDetallesFinancierosXPersona(Long perCodigo) throws ExcepcionDAO {
        List<SiiDetalleFinanc> siiDetalleFinancs = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT df FROM SiiDetalleFinanc df");
            sql.append(" WHERE df.siiPersona2.perCodigo = :perCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            siiDetalleFinancs = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleFinancDAO");
        }
        return siiDetalleFinancs;
    }


}
