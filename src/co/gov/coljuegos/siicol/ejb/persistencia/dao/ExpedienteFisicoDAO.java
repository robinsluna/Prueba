package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ExpedienteFisicoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ExpedienteFisicoDAO() {
        recursos = new Recursos();
    }
    public SiiExpedienteFisico insertarExpedienteFisico(SiiExpedienteFisico siiExpedienteFisico) throws ExcepcionDAO{
        try{
            manager.persist(siiExpedienteFisico);                                                                                
            manager.flush();                                                                                               
            return siiExpedienteFisico;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ExpedienteFisicoDAO");
        }
    }
    

    public SiiExpedienteFisico buscarExpedienteFisicoPorId(Long idExpedienteFisico) throws ExcepcionDAO{
        SiiExpedienteFisico expedienteFisicoRetorno = null;
        try{
            expedienteFisicoRetorno = (SiiExpedienteFisico) manager.find(SiiExpedienteFisico.class, idExpedienteFisico);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ExpedienteFisicoDAO");            
        }
        return expedienteFisicoRetorno;
    }
    
    public SiiExpedienteFisico actualizarExpedienteFisico(SiiExpedienteFisico expedienteFisico) throws ExcepcionDAO{
        try{            
            manager.merge(expedienteFisico);
            manager.flush();
            return expedienteFisico;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ExpedienteFisicoDAO");
        }
    }
}
