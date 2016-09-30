package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpLiqEstablAsigRec;
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
public class HlpLiqEstAsigRecDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public HlpLiqEstAsigRecDAO() {
        recursos = new Recursos();
    }
    
    public SiiHlpLiqEstablAsigRec insertarHlpLiqEstablAsigRec(SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec) throws ExcepcionDAO{
        try{
            manager.persist(siiHlpLiqEstablAsigRec);                                                                                
            manager.flush();                                                                                               
            return siiHlpLiqEstablAsigRec;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"HlpLiqEstAsigRecDAO");
        }
    }
    
    public SiiHlpLiqEstablAsigRec actualizarAsignacionRecaudo (SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec) throws ExcepcionDAO{
        try{            
            manager.merge(siiHlpLiqEstablAsigRec);
            manager.flush();
            return siiHlpLiqEstablAsigRec;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "HlpLiqEstAsigRecDAO");
        }
    }
    
    public SiiHlpLiqEstablAsigRec buscarAsignacionRecaudoPorId(Long areCodigo) throws ExcepcionDAO{
        SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec = null;
        try{
            siiHlpLiqEstablAsigRec = (SiiHlpLiqEstablAsigRec) manager.find(SiiHlpLiqEstablAsigRec.class, areCodigo);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"HlpLiqEstAsigRecDAO");            
        }
        return siiHlpLiqEstablAsigRec;
    }
    
    public void borrarHlpLiqEstablAsigRec(Long idCodigo) throws ExcepcionDAO {
        SiiHlpLiqEstablAsigRec siiHlpLiqEstablAsigRec = null;
        try {
            siiHlpLiqEstablAsigRec = manager.find(SiiHlpLiqEstablAsigRec.class, idCodigo);
            manager.remove(siiHlpLiqEstablAsigRec);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "HlpLiqEstAsigRecDAO");
        }
    }
    
    public List<SiiHlpLiqEstablAsigRec> buscarHlpLiqEstablAsigRecXAsigRec(Long areCodigo) throws ExcepcionDAO 
    {
        List<SiiHlpLiqEstablAsigRec>  areaColjuegosRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT h FROM SiiHlpLiqEstablAsigRec h");
            sql.append(" WHERE h.areCodigo = :areCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("areCodigo", areCodigo);
            areaColjuegosRetorno = query.getResultList();      
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, getClass().getSimpleName());            
        }
        return areaColjuegosRetorno;        
    }
    
    
    
}
