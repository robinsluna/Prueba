package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
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

public class ItemCotizacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public ItemCotizacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiItemCotizacion buscarItemCotizacionPorId(Long itdItemCotizacion) throws ExcepcionDAO {
        SiiItemCotizacion localItemCotizacion = null;
        try{
            localItemCotizacion = (SiiItemCotizacion) manager.find(SiiItemCotizacion.class, itdItemCotizacion);
            
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
        return localItemCotizacion;
    }
    
    public SiiItemCotizacion insertarItemCotizacion(SiiItemCotizacion itemCotizacion) throws ExcepcionDAO {
    try{
        manager.persist(itemCotizacion);
        manager.flush();
        return itemCotizacion;
    } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }
    
    public SiiItemCotizacion actualizarItemCotizacion(SiiItemCotizacion itemCotizacion) throws ExcepcionDAO {
        try {
            manager.merge(itemCotizacion);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
        return itemCotizacion;
    }
    
    public void eliminarItemCotizacion(Long idItemCotizacion) throws ExcepcionDAO {
            SiiItemCotizacion localItemCotizacion;
        try {
            localItemCotizacion = (SiiItemCotizacion) manager.find(SiiItemCotizacion.class, idItemCotizacion);
            manager.remove(localItemCotizacion);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
            }
        }
    
    public List<SiiItemCotizacion> buscarTodoItemCotizacion() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiItemCotizacion o");
            //sql.append(" where o.itemCotizacion.icoCodigo=:codigo");
            Query query = manager.createQuery(sql.toString());
            //query.setParameter("codigo", itemCotizacion.getIcoCodigo());
            List<SiiItemCotizacion> listaItemCotizacion = query.getResultList();
            return listaItemCotizacion;

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }
    
    public List<SiiItemCotizacion> buscarItemCotizacionPorCotizacion(Long idCotizacionEstudio) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiItemCotizacion o inner join o.siiCotizacionEstudio cotizacionEstudio where cotizacionEstudio.cesCodigo = :idCotizacionEstudio");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCotizacionEstudio", idCotizacionEstudio);
            List<SiiItemCotizacion> listaItemCotizacion = query.getResultList();
            return listaItemCotizacion;

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }

    public SiiItemCotizacion elementoOferta(Long isoCodigo, Long cesCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiItemCotizacion o INNER JOIN o.siiCotizacionEstudio ces INNER JOIN o.siiItemSolicitud iso WHERE ces.cesCodigo = :cesCodigo AND iso.isoCodigo = :isoCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cesCodigo", cesCodigo);
            query.setParameter("isoCodigo", isoCodigo);
            return (SiiItemCotizacion) query.getSingleResult();

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }

    public BigDecimal preciosUnitariosMinimos(Long emeCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MIN(valor_unitario)\n" + 
            "FROM\n" + 
            "  (SELECT ces.eme_codigo,\n" + 
            "    ces.CES_CODIGO,\n" + 
            "    SUM(ico.ICO_VALOR_UNIT) valor_unitario\n" + 
            "  FROM sii_item_cotizacion ico\n" + 
            "  INNER JOIN sii_cotizacion_estudio ces\n" + 
            "  ON ico.CES_CODIGO    = ces.CES_CODIGO\n" + 
            "  WHERE ces.eme_codigo = #emeCodigo\n" + 
            "  GROUP BY ces.ces_codigo ,\n" + 
            "    ces.eme_codigo\n" + 
            "  )\n");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("emeCodigo", emeCodigo);
            return (BigDecimal) query.getSingleResult();

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }
    }

