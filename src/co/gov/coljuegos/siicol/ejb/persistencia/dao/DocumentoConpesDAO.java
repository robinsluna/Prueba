/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 24-01-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class DocumentoConpesDAO {
    
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public DocumentoConpesDAO() {
        recursos = new Recursos();
    }
    
    public SiiDocumentoConpes buscarDocumentoConpesPorId (Long idDocConpes) throws ExcepcionDAO {
        SiiDocumentoConpes siiDocumentoConpesRetorno = null;
        try {
            siiDocumentoConpesRetorno =  manager.find(SiiDocumentoConpes.class, idDocConpes); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
        return siiDocumentoConpesRetorno;

    }
    
    public SiiDocumentoConpes  insertarDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) throws ExcepcionDAO {
        try {
            manager.persist(siiDocumentoConpes);                                
            manager.flush();                                                   
            return siiDocumentoConpes; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }
    
    public SiiDocumentoConpes actualizarDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) throws ExcepcionDAO {
        try {
            manager.merge(siiDocumentoConpes);                                                                           
            manager.flush();                                                                                             
            return siiDocumentoConpes;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }  
    
    public List<SiiDocumentoConpes> buscarTodosDocumentoConpes() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT udb FROM SiiDocumentoConpes udb");
            sql.append(" order by udb.dcnCodigo desc");
            Query query = manager.createQuery(sql.toString());
            List<SiiDocumentoConpes> listaSiiDocumentoConpes = query.getResultList();

           return listaSiiDocumentoConpes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }

    }

    public List<SiiDocumentoConpes> buscarTodosDocumentoConpesXNumeroYVigencia(Date fecha, String docNumero ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT udb FROM SiiDocumentoConpes udb");
            sql.append(" WHERE udb.dcnFecha = :fecha");
            sql.append(" AND udb.dcnNumero = :docNumero");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            query.setParameter("docNumero", docNumero);
            
            List<SiiDocumentoConpes> listaSiiDocumentoConpes = query.getResultList();

           return listaSiiDocumentoConpes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }

    }
    
    public SiiDocumentoConpes buscarDocumentoConpesActivo() throws ExcepcionDAO {
        SiiDocumentoConpes siiDocumentoConpes= null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT udb FROM SiiDocumentoConpes udb");
            sql.append(" WHERE udb.dcnActivo = 'S' ");
            sql.append(" order by udb.dcnCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            List<SiiDocumentoConpes> listaSiiDocumentoConpes = query.getResultList();
            
            if (listaSiiDocumentoConpes != null && !listaSiiDocumentoConpes.isEmpty()) {
                siiDocumentoConpes = listaSiiDocumentoConpes.get(0);
            }

           return siiDocumentoConpes;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }

    }
    
    
    
}
