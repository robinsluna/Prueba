package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemSolicitud;
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

public class ItemSolicitudDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ItemSolicitudDAO() {
        recursos = new Recursos();
    }
    
    public SiiItemSolicitud buscarItemSolicitudPorId(Long idItemSolicitud) throws ExcepcionDAO{
        SiiItemSolicitud localItemSolicitud = null;
        try {
            localItemSolicitud = (SiiItemSolicitud) manager.find(SiiItemSolicitud.class, idItemSolicitud);
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"itemSolicitudDAO");
        }
        return localItemSolicitud;

    }
    
    public SiiItemSolicitud insertarItemSolicitud(SiiItemSolicitud itemSolicitud) throws ExcepcionDAO {
        try{
            manager.persist(itemSolicitud);
            manager.flush();
            return itemSolicitud;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"itemSolicitudDAO");            
        }
    }
    
    public SiiItemSolicitud actualizarItemSolicitud(SiiItemSolicitud itemSolicitud) throws ExcepcionDAO {
        try {            
            itemSolicitud = manager.merge(itemSolicitud);
            manager.flush();
            return itemSolicitud;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"itemSolicitudDAO");            
        }
    }
    
    public void eliminarItemSolicitud(Long idItemSolicitud) throws ExcepcionDAO {
        SiiItemSolicitud localItemSolicitud;
        try {
            localItemSolicitud = (SiiItemSolicitud) manager.find(SiiItemSolicitud.class, idItemSolicitud);
            manager.remove(localItemSolicitud);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"itemSolicitudDAO");            
        }
    }
    
    public List<SiiItemSolicitud> buscarTodosItemSolicitud () throws ExcepcionDAO{
        try{
            List<SiiItemSolicitud> listaItemSolicitud = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemSolicitud o");
            Query query = manager.createQuery(sql.toString());
            listaItemSolicitud = query.getResultList();
            return listaItemSolicitud;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemSolicitudDAO");
        }
    }

    
    public List<SiiItemSolicitud>   buscarItemsSolicitudPorIdSEM(Long idItemSolicitud) throws ExcepcionDAO{
        List<SiiItemSolicitud> itemsSolicitudRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT itm FROM SiiSolicitudEstMercado sem");
            sql.append(" INNER JOIN sem.siiItemSolicitudList itm");
            sql.append(" WHERE sem.semCodigo = :idsem");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idsem", idItemSolicitud);
            itemsSolicitudRetorno = query.getResultList();   
            
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"itemSolicitudDAO");
        }
        return itemsSolicitudRetorno;

    }
    
    
    
    

    
    public List<SiiItemSolicitud> buscarItemSolicitudPorSolicitud(Long idSolicutudEstudio) throws ExcepcionDAO{
        try{
            List<SiiItemSolicitud> listaItemSolicitud = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemSolicitud o INNER JOIN o.siiSolicitudEstMercado solicitudEstudio WHERE solicitudEstudio.semCodigo = :idSolicitudEstudio");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idSolicitudEstudio", idSolicutudEstudio);
            listaItemSolicitud = query.getResultList();
            return listaItemSolicitud;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemSolicitudDAO");
        }
    }

    public  List<SiiItemSolicitud> elementos(Long prcCodigo)  throws ExcepcionDAO {
        try{
            List<SiiItemSolicitud> listaItemSolicitud = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiItemSolicitud o INNER JOIN o.siiSolicitudEstMercado sem WHERE sem.siiProcesoContratacion.prcCodigo = :prcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            listaItemSolicitud = query.getResultList();
            return listaItemSolicitud;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemSolicitudDAO");
        }        
    }
}
