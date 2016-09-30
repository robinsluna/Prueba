package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.ModificacionCdpVO;

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
public class ModificacionCdpDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModificacionCdpDAO() {
        recursos = new Recursos();
    }

    public SiiModificacionCdp buscarModificacionCdpPorId(Long idModificacionCdp) throws ExcepcionDAO {
        SiiModificacionCdp siiModificacionCdp = null;
        try {
            siiModificacionCdp = (SiiModificacionCdp) manager.find(SiiModificacionCdp.class, idModificacionCdp);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
        }
        return siiModificacionCdp;
    }

    public SiiModificacionCdp insertarModificacionCdp(SiiModificacionCdp siiModificacionCdp) throws ExcepcionDAO {
        try {
            manager.persist(siiModificacionCdp); //La guarda en el almacen
            manager.flush(); //Retorna el VO
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
            
        }
        return siiModificacionCdp;
    }

    public SiiModificacionCdp actualizarModifiacionCdp(SiiModificacionCdp siiModificacionCdp) throws ExcepcionDAO {
        try {
            siiModificacionCdp = manager.merge(siiModificacionCdp);
            manager.flush();
            return siiModificacionCdp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
        }
    }

    public void eliminarModificacionCdp(Long idModificacionCdp) throws ExcepcionDAO {
        try {
            SiiModificacionCdp modificacionCdpBorrar =
                (SiiModificacionCdp) manager.find(SiiModificacionCdp.class, idModificacionCdp);
            manager.remove(modificacionCdpBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
        }
    }

    public List<SiiModificacionCdp> buscarTodosModificacionCdp() throws ExcepcionDAO {
        try {
            List<SiiModificacionCdp> listaModificacionCdp = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT modCdp FROM SiiModificacionCdp modCdp");
            Query query = manager.createQuery(sql.toString());
            listaModificacionCdp = query.getResultList();

            return listaModificacionCdp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        }
    }

    public SiiModificacionCdp buscarUltimaModificacionCdp(Long idCdp) throws ExcepcionDAO {
        SiiModificacionCdp modificacionCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MAX(o.mcdCodigo) FROM SiiModificacionCdp o JOIN o.siiCdp cdp WHERE cdp.cdpCodigo = :idCdp");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCdp", idCdp);
            Long mcdCodigo = (Long) query.getSingleResult();

            if (mcdCodigo != null) {
                modificacionCdp = buscarModificacionCdpPorId(mcdCodigo);
            }

            return modificacionCdp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionCdpDAO");

        }

    }
    
    public List<SiiModificacionCdp> decrementosTramitados() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o JOIN o.siiEstadoModifCdp est WHERE o.mcdTipoMod = 'D' AND est.emcNombre IN ('APROBADO','RECHAZADO')");
            Query query = manager.createQuery(sql.toString());
            return  query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionCdpDAO");

        }
    }

    public List<SiiModificacionCdp> incrementosTramitados() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o JOIN o.siiEstadoModifCdp est WHERE o.mcdTipoMod = 'I' AND est.emcNombre IN ('APROBADO','RECHAZADO')");
            Query query = manager.createQuery(sql.toString());
            List l = query.getResultList();
            return (List<SiiModificacionCdp>) l;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionCdpDAO");

        }
    }

    public List<SiiModificacionCdp> incrementosExistentes() throws ExcepcionDAO {
        return movimientosExistentesPorTipo("I");
    }

    private List<SiiModificacionCdp> movimientosExistentesPorTipo(String mcdTipoMod) throws co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o WHERE o.mcdTipoMod = :mcdTipoMod ORDER BY o.mcdNumero DESC");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mcdTipoMod", mcdTipoMod);
            List l = query.getResultList();
            return (List<SiiModificacionCdp>) l;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionCdpDAO");

        }
    }

    public List<SiiModificacionCdp> decrementosExistentes() throws ExcepcionDAO {
        return movimientosExistentesPorTipo("D");
    }

    public List<SiiModificacionCdp> buscarModificacionesCdpPorCdp(Long id) throws ExcepcionDAO {
        try {
            List<SiiModificacionCdp> listaModificacionCdp = null;

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o JOIN o.siiCdp cdp WHERE cdp.cdpCodigo = :id");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("id", id);
            listaModificacionCdp = query.getResultList();

            return listaModificacionCdp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        }
    }

    public List<SiiModificacionCdp> buscarDecrementosCdpEnTramite() throws ExcepcionDAO {
        // Excluye a los INCREMENTADO DECREMENTADO Y RECHAZADO
        try {
            List<SiiModificacionCdp> listaModificacionCdp = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o JOIN o.siiEstadoModifCdp est " +
                "WHERE o.mcdTipoMod = 'D' " +
                "AND est.cdpCodigo IN ('BORRADOR','CERRADO', 'REVISADO','IMPRESO') " +
                "ORDER BY o.mcdNumero DESC");
            Query query = manager.createQuery(sql.toString());
            listaModificacionCdp = query.getResultList();

            return listaModificacionCdp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        }

    }


    public List<ModificacionCdpVO> buscarModificacionCdpPorIdRubro(Long IdDrcCodigo) throws ExcepcionDAO {
        List<ModificacionCdpVO> listaModificacionCdpVo = new ArrayList<ModificacionCdpVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT mc FROM sii_modificacion_cdp mc ");
            sql.append("INNER JOIN sii_modif_cdp_det_rub_cdp mcdrc ON (mc.mcd_codigo = mcdrc.mcd_codigo) ");
            sql.append("where mcdrc.drc_codigo = #miIdDrcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("miIdDrcCodigo", IdDrcCodigo);
            listaModificacionCdpVo = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModificacionCdpDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "ModificacionCdpDAO");
        }
        return listaModificacionCdpVo;
    }

    public List<SiiModificacionCdp> buscarIncrementosCdpEnTramite() throws ExcepcionDAO {
        // Excluye a los INCREMENTADO DECREMENTADO Y RECHAZADO
        try {
            List<SiiModificacionCdp> listaModificacionCdpVO = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModificacionCdp o JOIN o.siiEstadoModifCdp est WHERE o.mcdTipoMod = 'I' AND est.cdpCodigo IN ('BORRADOR','CERRADO', 'REVISADO','IMPRESO')");
            Query query = manager.createQuery(sql.toString());
            listaModificacionCdpVO = query.getResultList();

            return listaModificacionCdpVO;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        }
    }


    public Long siguienteNumeroModificacionCdp(String mcdTipoMod, Integer cdpVigencia) throws ExcepcionDAO {
        Long i;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT Max(o.mcdNumero) FROM  SiiModificacionCdp o WHERE o.mcdTipoMod = :mcdTipoMod and o.siiCdp.cdpVigencia = :cdpVigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mcdTipoMod", mcdTipoMod);
            query.setParameter("cdpVigencia", cdpVigencia);
            i = (Long) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ModificacionCdpDAO");
        }
        if (i == null || i / 1000000L != cdpVigencia) {
            i = cdpVigencia * 1000000L;
        }
        return i + 1;
    }
}

