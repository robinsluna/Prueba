package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmasRequeridas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@Local
public class FirmaDocumentoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public FirmaDocumentoDAO() {
        recursos = new Recursos();

    }

    public SiiFirmaDocumento buscarFirmaDocumentoPorId(Long idFirmaDocumento) throws ExcepcionDAO {
        SiiFirmaDocumento firmaDocumento = null;
        try {
            firmaDocumento = (SiiFirmaDocumento) manager.find(SiiFirmaDocumento.class, idFirmaDocumento);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
        return firmaDocumento;

    }

    public SiiFirmaDocumento insertarFirmaDocumento(SiiFirmaDocumento firmaDocumento) throws ExcepcionDAO {
        try {
            manager.persist(firmaDocumento);
            manager.flush();
            return firmaDocumento;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
    }

    public SiiFirmaDocumento actualizarFirmaDocumento(SiiFirmaDocumento firmaDocumento) throws ExcepcionDAO {
        try {
            manager.merge(firmaDocumento);
            manager.flush();
            return firmaDocumento;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
    }

    public void eliminarFirmaDocumento(Long idFirmaDocumento) throws ExcepcionDAO {
        SiiFirmaDocumento firmaDocumento = null;
        try {
            firmaDocumento = (SiiFirmaDocumento) manager.find(SiiFirmaDocumento.class, idFirmaDocumento);
            manager.remove(firmaDocumento);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
    }

    public List<SiiFirmaDocumento> buscarFirmaDocumentoPorIdTipoDocumento(Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fD FROM SiiFirmaDocumento fD " + "WHERE fD.fdoIdDocumento = :idTipoDocumento");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idTipoDocumento", idTipoDocumento);
            listaFirmaDocumento = query.getResultList();
            return listaFirmaDocumento;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
    }

    public List<SiiFirmaDocumento> buscarFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento,
                                                                                   Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = new ArrayList<SiiFirmaDocumento>();
        SiiFirmaDocumento firmaDocumento = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fd.fdo_codigo, fd.usu_codigo, fd.fdo_fecha_firma, fd.fre_codigo, fd.fdo_id_documento " +
                       "FROM sii_firma_documento fd WHERE fd.usu_codigo in " + "(SELECT u.usu_codigo " +
                       "FROM sii_firmas_requeridas fr " +
                       "INNER JOIN sii_tipo_documento_coljuegos tdc ON (fr.tdo_codigo = tdc.tdo_codigo) " +
                       "INNER JOIN sii_funcion f ON (fr.fun_codigo = f.fun_codigo) " +
                       "INNER JOIN sii_usuario u ON (f.fun_codigo = u.fun_codigo) " +
                       "INNER JOIN sii_persona p ON u.per_codigo = p.per_codigo " +
                       "WHERE tdc.tdo_codigo = #idTipoDocumento) " + "AND fd.fdo_id_documento = #idDocumento");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idDocumento", idDocumento);
            query.setParameter("idTipoDocumento", idTipoDocumento);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {
                firmaDocumento = new SiiFirmaDocumento();
                for (Object[] object : results) {
                    SiiFirmaDocumento unaFirmaDocumento = new SiiFirmaDocumento();
                    unaFirmaDocumento.setFdoCodigo(((BigDecimal) object[0]).longValue());
                    unaFirmaDocumento.setFdoIdDocumento(idDocumento);
                    SiiFirmasRequeridas siiFirmasRequeridas = new SiiFirmasRequeridas();
                    siiFirmasRequeridas.setFreCodigo(((BigDecimal) object[4]).longValue());
                    unaFirmaDocumento.setSiiFirmasRequeridas(siiFirmasRequeridas);
                    SiiUsuario siiUsuario = new SiiUsuario();
                    siiUsuario.setUsuCodigo(((BigDecimal) object[1]).longValue());
                    unaFirmaDocumento.setSiiUsuario(siiUsuario);
                    unaFirmaDocumento.setTdoFechaFirma((Date) object[2]);
                    listaFirmaDocumento.add(unaFirmaDocumento);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "FirmaDocumentoDAO");
        }
        return listaFirmaDocumento;
    }

    public List<SiiFirmaDocumento> buscarJqlFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento,
                                                                                      Long idTipoDocumento) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFirmaDocumento o " + "WHERE o.fdoIdDocumento = :idDocumento " +
                       "AND o.siiFirmasRequeridas.siiTipoDocumentoColjuegos1.tdoCodigo = :idTipoDocumento ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDocumento", idDocumento);
            query.setParameter("idTipoDocumento", idTipoDocumento);
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "FirmaDocumentoDAO");
        }
    }

    public List<SiiFirmaDocumento> buscarFirmaDocumentoPorIdTipoDocumentoEntidad(Long idDocumento,
                                                                                 Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT fD FROM SiiFirmaDocumento fD " + "WHERE fD.fdoIdDocumento = :idDocumento " +
                       "AND fD.siiFirmasRequeridas.siiTipoDocumentoColjuegos1.tdoCodigo = :idTipoDocumento ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDocumento", idDocumento);
            query.setParameter("idTipoDocumento", idTipoDocumento);
            listaFirmaDocumento = query.getResultList();
            return listaFirmaDocumento;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "FirmaDocumentoDAO");
        }
    }

}
