package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifRpDetRubCdp;
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
public class ModifRpDetRubCdpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ModifRpDetRubCdpDAO() {
        recursos = new Recursos();
    }
    
    public List<SiiModifRpDetRubCdp> listaModifRpDetRubCdp(Long mrpCodigo) throws ExcepcionDAO {
        List<SiiModifRpDetRubCdp> listaSiiModifRpDetRubCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModifRpDetRubCdp o WHERE o.siiModificacionRp.mrpCodigo = :mrpCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mrpCodigo", mrpCodigo);
            listaSiiModifRpDetRubCdp = query.getResultList();
           
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
        return listaSiiModifRpDetRubCdp;
    }
    
    public List<SiiModifRpDetRubCdp> listaModifRpDetRubCdpPorRpDetRubroCdp(Long rdrCodigo) throws ExcepcionDAO {
        List<SiiModifRpDetRubCdp> listaSiiModifRpDetRubCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiModifRpDetRubCdp o WHERE o.siiRpDetRubroCdp.rdrCodigo = :rdrCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            listaSiiModifRpDetRubCdp = query.getResultList();
           
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
        return listaSiiModifRpDetRubCdp;
    }

    public SiiModifRpDetRubCdp insertarModifRpDetRubCdp(SiiModifRpDetRubCdp modif) throws ExcepcionDAO {
        try {
            manager.persist(modif);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
        return modif;
    }

    public SiiModifRpDetRubCdp actualizarModifRpDetRubCdp(SiiModifRpDetRubCdp modif) throws ExcepcionDAO {
        try {
            modif = manager.merge(modif);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
        return modif;
    }
    
    public SiiModifRpDetRubCdp buscarModifRpDetRubCdpPorId(Long id) throws ExcepcionDAO {
        SiiModifRpDetRubCdp modif = null;
        try {
            modif = manager.find(SiiModifRpDetRubCdp.class,id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
        return modif;
    }

    public BigDecimal valorDecRpPorDetRubRpAprobados(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE o.siiRpDetRubroCdp.rdrCodigo = :rdrCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND m.mrpTipoModif='D'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
    }

    public BigDecimal valorIncRpPorDetRubRpAprobados(Long rdrCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE o.siiRpDetRubroCdp.rdrCodigo = :rdrCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND m.mrpTipoModif='I'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("rdrCodigo", rdrCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
    }

    public BigDecimal valorDecRpDetRubCdpAprobado(Long drcCodigo,Long rpCodigo) throws ExcepcionDAO { //TODO
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE r.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND o.siiRpDetRubroCdp.siiRp.rpCodigo = :rpCodigo " +
                "AND m.mrpTipoModif='D'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo", drcCodigo);
            query.setParameter("rpCodigo", rpCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }

    }

    public BigDecimal valorIncRpDetRubCdpAprobado(Long drcCodigo,Long rpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE r.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND o.siiRpDetRubroCdp.siiRp.rpCodigo = :rpCodigo " +
                "AND m.mrpTipoModif='I'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo", drcCodigo);
            query.setParameter("rpCodigo", rpCodigo);            
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }

    }


    /*     public BigDecimal valorNotasCreditoSinReconocimiento(Long drcCodigo) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE r.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND m.mrpTipoModif='I'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo", drcCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
    }

    public BigDecimal valorReintegrosNotasCreditoConReconocimiento(Long drcCodigo) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUM(o.mrdValor) " +
                "FROM SiiModifRpDetRubCdp o " +
                "JOIN o.siiModificacionRp m " +
                "JOIN o.siiRpDetRubroCdp r " +
                "WHERE r.siiDetalleRubroCdp.drcCodigo = :drcCodigo " +
                "AND m.siiEstadoModificRp.emrNombre='APROBADO' " +
                "AND m.mrpTipoModif='I'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("drcCodigo", drcCodigo);
            BigDecimal valor = (BigDecimal) query.getSingleResult();
            return (BigDecimal) (valor == null ? BigDecimal.ZERO : valor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ModifRpDetRubCdpDAO");
        }
    } */
}
