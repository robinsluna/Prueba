package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionRp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ModificacionRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModificacionRpDAO() {
        recursos = new Recursos();
    }

    public SiiModificacionRp buscarUltimaModificacionRp(Long rpCodigo) throws ExcepcionDAO {
        SiiModificacionRp modificacionRp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(o.mrpCodigo) FROM SiiModificacionRp o JOIN o.siiRp1 rp WHERE rp.rpCodigo = :rpCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rpCodigo", rpCodigo);
            Long mrpCodigo = (Long) query.getSingleResult();

            if (mrpCodigo != null) {
                modificacionRp = buscarModificacionRpPorId(mrpCodigo);
            }

            return modificacionRp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionRpDAO");

        }

    }

    public SiiModificacionRp buscarModificacionRpPorId(Long idModificacionRp) throws ExcepcionDAO {
        SiiModificacionRp siiModificacionRp = null;
        try {
            siiModificacionRp = (SiiModificacionRp) manager.find(SiiModificacionRp.class, idModificacionRp);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionRpDAO");
        }
        return siiModificacionRp;
    }

    public SiiModificacionRp insertarModificacionRp(SiiModificacionRp siiModificacionRp) throws ExcepcionDAO {
        try {
            manager.persist(siiModificacionRp);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionRpDAO");
        }
        return siiModificacionRp;
    }

    public SiiModificacionRp actualizarModifiacionRp(SiiModificacionRp siiModificacionRp) throws ExcepcionDAO {
        try {
            siiModificacionRp = manager.merge(siiModificacionRp);
            manager.flush();
            return siiModificacionRp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionRpDAO");
        }
    }

    public List<SiiModificacionRp> decrementosTramitados() throws ExcepcionDAO {
        return movimientosTramitados("D");

    }

    public Long siguienteNumeroModificacionRp(String mrpTipoModif, Integer cdpVigencia) throws ExcepcionDAO {
        BigDecimal i = BigDecimal.ZERO;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(o.MRP_CONSECUTIVO)\n" + "FROM Sii_Modificacion_Rp o\n" + "INNER JOIN sii_Rp\n" +
                       "ON o.RP_CODIGO = sii_Rp.RP_CODIGO\n" + "WHERE o.MRP_TIPO_MODIF   = #mrpTipoModif\n" +
                       "AND to_number(substr(sii_rp.rp_consecutivo,1,4)) = #cdpVigencia");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("mrpTipoModif", mrpTipoModif);
            query.setParameter("cdpVigencia", cdpVigencia);
            i = ((BigDecimal) query.getSingleResult());

        }  catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        }
        if (i == null || i.longValue() / 1000000L != cdpVigencia) {
            i = new BigDecimal(1000000L);
            i = i.multiply(new BigDecimal(cdpVigencia));
        } 
        return i.add(BigDecimal.ONE).longValue();
    }


    public List<SiiModificacionRp> incrementosTramitados() throws ExcepcionDAO {
        return movimientosTramitados("I");

    }
    
    private List<SiiModificacionRp> movimientosTramitados(String mrpTipoModif) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(
                "SELECT o FROM SiiModificacionRp o JOIN o.siiEstadoModificRp est " + 
                "WHERE o.mrpTipoModif = :mrpTipoModif " + 
                       "ORDER BY o.mrpConsecutivo DESC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mrpTipoModif", mrpTipoModif);

            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionRpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionRpDAO");

        }
    }
}
