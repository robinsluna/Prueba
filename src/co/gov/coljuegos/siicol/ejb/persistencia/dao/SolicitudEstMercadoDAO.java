package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

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

public class SolicitudEstMercadoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public SolicitudEstMercadoDAO() {
        recursos = new Recursos();
    }
    
     
    public SiiSolicitudEstMercado insertarSolicitudEstMercado(SiiSolicitudEstMercado solicitudEstMercado) throws ExcepcionDAO{
        try{
            manager.persist(solicitudEstMercado);                                                                                //La guarda en el almacen
            manager.flush();                                                                                                     //Pasa a la Bd
            return solicitudEstMercado; 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");
        }
    }
    

    public SiiSolicitudEstMercado buscarSolicitudEstMercadoPorId(Long idSolicitudEstudioMercado) throws ExcepcionDAO{
        SiiSolicitudEstMercado solicitudEstMercadoRetorno = null;
        try{
            solicitudEstMercadoRetorno = (SiiSolicitudEstMercado) manager.find(SiiSolicitudEstMercado.class, idSolicitudEstudioMercado);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return solicitudEstMercadoRetorno;
    }
    
    public List<SiiSolicitudEstMercado> buscarSolicitudesEstMercadoPorArea(SiiAreaColjuegos unAreaColjuegos) throws ExcepcionDAO{
        List<SiiSolicitudEstMercado> solicitudEstMercadoRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT solEst FROM SiiSolicitudEstMercado solEst");
            sql.append(" WHERE solEst.siiAreaColjuegos.acoCodigo = :codigoArea");
           
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoArea", unAreaColjuegos.getAcoCodigo());

            solicitudEstMercadoRetorno = query.getResultList();            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return solicitudEstMercadoRetorno;
    }
    
        public List<SiiSolicitudEstMercado> buscarSolicitudEMPorIdProcesoContratacion(SiiProcesoContratacion unProcesoContratacion) throws ExcepcionDAO{
            List<SiiSolicitudEstMercado> solicitudEstMercadoRetorno = null;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT solEst FROM SiiSolicitudEstMercado solEst ");
                sql.append(" WHERE solEst.siiProcesoContratacion.prcCodigo = :codigoArea");
               
                Query query = manager.createQuery(sql.toString());
                query.setParameter("codigoArea", unProcesoContratacion.getPrcCodigo());

                solicitudEstMercadoRetorno = query.getResultList();            
            }catch (PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
            }
            return solicitudEstMercadoRetorno;
        }
    
    
    public SiiSolicitudEstMercado actualizarSolicitudEstMercado(SiiSolicitudEstMercado solicitudEstMercado) throws ExcepcionDAO{
        //SiiSolicitudEstMercado solicitudEstMercado = null;
        try{            
            manager.merge(solicitudEstMercado);
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return solicitudEstMercado;
    }
    
        public List<SiiSolicitudEstMercado> buscarSolicitudesEstMercadoPorEstado(SiiEstadoSolEstMercado unEstadoSolicitud) throws ExcepcionDAO{
            List<SiiSolicitudEstMercado> solicitudEstMercadoRetorno = null;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT solEst FROM SiiSolicitudEstMercado solEst JOIN solEst.siiEstadoSolEstMercado");
                sql.append(" WHERE solEst.siiEstadoSolEstMercado.semCodigo = :estadoSolicitud");
                Query query = manager.createQuery(sql.toString());
                query.setParameter("estadoSolicitud", unEstadoSolicitud.getEseCodigo());
                solicitudEstMercadoRetorno = query.getResultList();            
                
            }catch (PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
            }
            //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
            return solicitudEstMercadoRetorno;
        }        
        
        public List<SiiSolicitudEstMercado> buscarTodoSolicitudEstMercado()
                throws ExcepcionDAO{
            try{
                List<SiiSolicitudEstMercado> listaSolicitudEstMercado = new ArrayList();           
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT solEstMerc FROM SiiSolicitudEstMercado solEstMerc");
                sql.append(" order by solEstMerc.semCodigo desc");
                Query query = manager.createQuery(sql.toString());
                listaSolicitudEstMercado= query.getResultList();
                return listaSolicitudEstMercado;
                
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");
            }
        }
        
        public List<SiiSolicitudEstMercado> buscarSolicitudesEstMercadoPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{
                    List<SiiSolicitudEstMercado> solicitudEstMercadoRetorno = null;
                    try{
                        StringBuilder sql = new StringBuilder();
                        sql.append(" SELECT solEst FROM SiiSolicitudEstMercado solEst ");
                        sql.append(" WHERE solEst.siiProcesoContratacion.prcCodigo = :idProcesoContratacion");
                        Query query = manager.createQuery(sql.toString());
                        query.setParameter("idProcesoContratacion", idProcesoContratacion);
                        solicitudEstMercadoRetorno = query.getResultList();            
                        
                    }catch (PersistenceException pe){
                        String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                        throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
                    }
                    //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
                    return solicitudEstMercadoRetorno;
                }
    } 