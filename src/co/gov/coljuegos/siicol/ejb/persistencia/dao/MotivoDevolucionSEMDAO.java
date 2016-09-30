package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoDevolucion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

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

public class MotivoDevolucionSEMDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MotivoDevolucionSEMDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiMotivoDevolucion buscarMotivoDevolucionSEMPorId(Long idMotivoDevolucionSEM) throws ExcepcionDAO{
        SiiMotivoDevolucion motivoDevolucionSEMRetorno = null;
        try{
            motivoDevolucionSEMRetorno = (SiiMotivoDevolucion) manager.find(SiiMotivoDevolucion.class, idMotivoDevolucionSEM);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return motivoDevolucionSEMRetorno;
    }
    
    
    public List<SiiMotivoDevolucion> buscarTodoMotivoDevolucionSEM()
            throws ExcepcionDAO{
        try{
            List<SiiMotivoDevolucion> listaMotivoDevolucionSEM = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT motivoDev FROM SiiMotivoDevolucion motivoDev");
            Query query = manager.createQuery(sql.toString());
            listaMotivoDevolucionSEM= query.getResultList();
            return listaMotivoDevolucionSEM;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");
        }
    }
    public SiiMotivoDevolucion buscarEstadoMotivoDevPorNombre(SiiMotivoDevolucion siiMotivoDevolucion) throws ExcepcionDAO{
        SiiMotivoDevolucion siiMotivoDevolucionRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiMotivoDevolucion est");
            sql.append(" WHERE est.mdeNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", siiMotivoDevolucion.getMdeNombre());
            List<SiiMotivoDevolucion> listaSiiMotivoDevolucion = query.getResultList();
            
            if (listaSiiMotivoDevolucion != null && !listaSiiMotivoDevolucion.isEmpty()) {
                siiMotivoDevolucionRetorno = listaSiiMotivoDevolucion.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiMotivoDevolucionRetorno;
    }

}
