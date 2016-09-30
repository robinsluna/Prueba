package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumSoporModif;
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
public class DocumSoporModifDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public DocumSoporModifDAO() {
        recursos = new Recursos();
    }
    
    public SiiDocumSoporModif buscarDocumSoporModifPorId(Long dsmCodigo) throws ExcepcionDAO {
        SiiDocumSoporModif siiDocumSoporModif = null;
        try {
            siiDocumSoporModif = (SiiDocumSoporModif) manager.find(SiiDocumSoporModif.class, dsmCodigo);
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DocumSoporModifDAO");
        }
        return siiDocumSoporModif;
    }

    public SiiDocumSoporModif insertarDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) throws ExcepcionDAO {
        try {
            manager.persist(siiDocumSoporModif);
            manager.flush();
            return siiDocumSoporModif;

        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DocumSoporModifDAO");
        }        
    }
    
    public SiiDocumSoporModif actualizarDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) throws ExcepcionDAO {
        try {
            manager.merge(siiDocumSoporModif);
            manager.flush();
            return siiDocumSoporModif;
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DocumSoporModifDAO");
        }        
    }

    public List<SiiDocumSoporModif> documentosSoportePorModif(Long mpcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiDocumSoporModif o WHERE o.siiModificacionPlanCont.mpcCodigo=:mpcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("mpcCodigo", mpcCodigo);
            return query.getResultList();
        } catch (PersistenceException pe){
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DocumSoporModifDAO");
        }
    }

    public boolean existeDocumento(String dsmActivo, String dsmNumDoc, Long tdmCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT count(o) FROM SiiDocumSoporModif o WHERE o.dsmActivo=:dsmActivo AND o.siiTipoDocSoporteModif.tdmCodigo=:tdmCodigo AND o.dsmNumDoc = :dsmNumDoc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("dsmActivo", dsmActivo);
            query.setParameter("tdmCodigo", tdmCodigo);
            query.setParameter("dsmNumDoc", dsmNumDoc);
            Long x = (Long) query.getSingleResult();
            return x > 0L ? true : false;
        } catch (PersistenceException pe){
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DocumSoporModifDAO");
        }
    }

}
