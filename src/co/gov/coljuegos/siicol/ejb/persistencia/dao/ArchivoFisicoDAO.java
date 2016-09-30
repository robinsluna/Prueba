package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.ArrayList;
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

public class ArchivoFisicoDAO {
    
    @PersistenceContext(unitName="siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ArchivoFisicoDAO() {
        recursos = new Recursos();
    }
    public SiiArchivoFisico insertarArchivoFisico(SiiArchivoFisico archivoFisico) throws ExcepcionDAO{
        try{
            archivoFisico.setAfiFecha(new Date());
            manager.persist(archivoFisico);                                                                                
            manager.flush();                                                                                               
            return archivoFisico;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ArchivoFisicoDAO");
        }
    }
    

    public SiiArchivoFisico buscarArchivoFisicoPorId(Long idArchivoFisico) throws ExcepcionDAO{
        SiiArchivoFisico archivoFisicoRetorno = null;
        try{
            archivoFisicoRetorno = (SiiArchivoFisico) manager.find(SiiArchivoFisico.class, idArchivoFisico);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ArchivoFisicoDAO");            
        }
        return archivoFisicoRetorno;
        }
    /*
    public SiiArchivoFisico actualizarArchivoFisico(SiiArchivoFisico archivoFisico) throws ExcepcionDAO{
        try{            
            manager.merge(archivoFisico);
            manager.flush();
            return archivoFisico;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ArchivoFisicoDAO");
        }
    }
*/
    public List<SiiArchivoFisico> buscarTodoArchivoFisico()
            throws ExcepcionDAO{
        try{
            List<SiiArchivoFisico> listaArchivoFisico = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT archF FROM SiiArchivoFisico archF");
            Query query = manager.createQuery(sql.toString());
            listaArchivoFisico = query.getResultList();
            return listaArchivoFisico;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ArchivoFisicoDAO");
        }
    }
    
    public List<SiiArchivoFisico> buscarArchivoFisicoPorNombre(String afiNombre)
            throws ExcepcionDAO{
        try{
            List<SiiArchivoFisico> listaArchivoFisico = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiArchivoFisico o  where o.afiNombreOrignal =:afiNombre ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("afiNombre", afiNombre);
            listaArchivoFisico = query.getResultList();
            return listaArchivoFisico;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ArchivoFisicoDAO");
        }
    }
}
