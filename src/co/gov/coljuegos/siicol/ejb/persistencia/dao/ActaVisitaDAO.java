package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
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
public class ActaVisitaDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ActaVisitaDAO() {
        recursos = new Recursos();
    }
    
    public SiiActaVisita insertarSiiActaVisita(SiiActaVisita siiActaVisita) throws ExcepcionDAO {
        try {
            manager.persist(siiActaVisita); 
            manager.flush(); 
            return siiActaVisita; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
    }
    
    public List<SiiActaVisita> buscarActaVisitaPorAutoComisorio (Long aucCodigo) throws ExcepcionDAO{
        List<SiiActaVisita> listaActaVisita = new ArrayList<SiiActaVisita>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT av FROM SiiActaVisita av where av.aucCodigo = :AucCodigo  ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("aucCodigo", aucCodigo);
            listaActaVisita = query.getResultList();        
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaActaVisita;
    }
    
    public List<SiiActaVisita> buscarActaVisitaPorNumero (String  aviNumero) throws ExcepcionDAO{
        List<SiiActaVisita> listaActaVisita = new ArrayList<SiiActaVisita>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT av FROM SiiActaVisita av where av.aviNumero = :aviNumero  ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("aviNumero", aviNumero);
            listaActaVisita = query.getResultList();        
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaActaVisita;
    }
}
