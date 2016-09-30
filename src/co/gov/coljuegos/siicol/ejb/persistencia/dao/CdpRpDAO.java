/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdpRp;
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
public class CdpRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CdpRpDAO() {
        recursos = new Recursos();
    }
    
    public SiiCdpRp buscarPorCodigoCdpRp(Long idCodigoCdpRp) throws ExcepcionDAO {
        SiiCdpRp retorno = null;
        try {
            retorno = (SiiCdpRp) manager.find(SiiCdpRp.class, idCodigoCdpRp);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpRpDAO");
        }
        return retorno;

    }
    
    public SiiCdpRp insertarSiiCdpRp(SiiCdpRp cdpRp) throws ExcepcionDAO {
        try {
            manager.persist(cdpRp); 
            manager.flush(); 
            return cdpRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpRpDAO");
        }
    }
    
    public SiiCdpRp actualizarSiiCdpRp(SiiCdpRp cdpRp) throws ExcepcionDAO {
        try {
            manager.merge(cdpRp); 
            manager.flush(); 
            return cdpRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CdpRpDAO");
        }
    }
    
    public List<SiiCdpRp> buscarCdpRpPorRp(Long idRp) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCdpRp o INNER JOIN o.siiRp rp WHERE rp.rpCodigo = :idRp");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRp", idRp);
            List<SiiCdpRp> listaCdpRp = query.getResultList();
            return listaCdpRp;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CdpRpDAO");
        }
    }

    public List<SiiCdpRp> buscarCdpRpPorCdp(Long cdpCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCdpRp o INNER JOIN o.siiCdp cdp WHERE cdp.cdpCodigo = :cdpCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cdpCodigo", cdpCodigo);
            List<SiiCdpRp> listaCdpRp = query.getResultList();
            return listaCdpRp;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CdpRpDAO");
        }
    }
}
