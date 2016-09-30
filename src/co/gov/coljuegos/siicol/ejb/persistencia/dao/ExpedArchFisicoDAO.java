package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class ExpedArchFisicoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
        
    public ExpedArchFisicoDAO() {
        recursos = new Recursos();
    }
    public SiiExpedArchFisico insertarExpedArchivoFisico(SiiExpedArchFisico siiExpedArchFisico) throws ExcepcionDAO{
        try{
            manager.persist(siiExpedArchFisico);                                                                                
            manager.flush();                                                                                               
            return siiExpedArchFisico;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ExpedArchivoFisicoDAO");
        }
    }
    

    public SiiExpedArchFisico buscarExpedArchivoFisicoPorId(Long idExpedArchivoFisico) throws ExcepcionDAO{
        SiiExpedArchFisico expedArchivoFisicoRetorno = null;
        try{
            expedArchivoFisicoRetorno = (SiiExpedArchFisico) manager.find(SiiExpedArchFisico.class, idExpedArchivoFisico);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ExpedArchivoFisicoDAO");            
        }
        return expedArchivoFisicoRetorno;
    }
    
    public SiiExpedArchFisico actualizarExpedArchivoFisico(SiiExpedArchFisico siiExpedArchFisico) throws ExcepcionDAO{
        try{            
            manager.merge(siiExpedArchFisico);
            manager.flush();
            return siiExpedArchFisico;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ExpedArchivoFisicoDAO");
        }
    }
}

