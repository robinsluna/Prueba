/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 21-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoRp;
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
public class EstadoRpDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoRpDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoRp buscarEstadoRpPorId(Long idErpCodigo) throws ExcepcionDAO{
        SiiEstadoRp estadoRpRetorno = null;
        try{
            estadoRpRetorno = (SiiEstadoRp) manager.find(SiiEstadoRp.class, idErpCodigo);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoRpDAO");
        }
        return estadoRpRetorno;
    }
    
   
    public List<SiiEstadoRp> buscarEstadoRpPorCodigo(SiiEstadoRp siiEstadoRp) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estadoRp FROM SiiEstadoRp estadoRp");
            sql.append(" WHERE estadoRp.erpCodigo = :codigoEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoEstado", siiEstadoRp.getErpCodigo());
            List<SiiEstadoRp> listaEntidadEstadoRp = query.getResultList();
            
            return listaEntidadEstadoRp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoRpDAO"); 
        }
    }
    
    public List<SiiEstadoRp> buscarCodEstadoPorNombre(String estadoRp) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estadoRp FROM SiiEstadoRp estadoRp");
            sql.append(" WHERE estadoRp.erpNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", estadoRp);
            List<SiiEstadoRp> listaEntidadEstadoRp = query.getResultList();
            
            return listaEntidadEstadoRp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoRpDAO"); 
        }
    }
    
    public List<SiiEstadoRp> buscarTodoEstadoRp() throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estadoRp FROM SiiEstadoRp estadoRp");
            Query query = manager.createQuery(sql.toString());
            List<SiiEstadoRp> listaEntidadEstadoRp = query.getResultList();
            
            return listaEntidadEstadoRp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoRpDAO"); 
        }
    }
    
}
