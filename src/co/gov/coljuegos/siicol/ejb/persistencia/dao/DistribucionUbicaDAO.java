package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionUbica;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoConpes;
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
public class DistribucionUbicaDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public DistribucionUbicaDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiDistribucionUbica buscarDistribucionUbicaPorId (Long idDistriUbi) throws ExcepcionDAO {
        SiiDistribucionUbica siiDistribucionUbica = null;
        try {
            siiDistribucionUbica =  manager.find(SiiDistribucionUbica.class, idDistriUbi); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionUbicaDAO");
        }
        return siiDistribucionUbica;

    }
    
    public SiiDistribucionUbica  insertarDistribucionUbica (SiiDistribucionUbica siiDistribucionUbica) throws ExcepcionDAO {
        try {
            manager.persist(siiDistribucionUbica);                                
            manager.flush();                                                   
            return siiDistribucionUbica; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionUbicaDAO");
        }
    }
    
    public SiiDistribucionUbica actualizarSiiDistribucionUbica(SiiDistribucionUbica siiDistribucionUbica) throws ExcepcionDAO {
        try {
            manager.merge(siiDistribucionUbica);                                                                           
            manager.flush();                                                                                             
            return siiDistribucionUbica;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionUbicaDAO");
        }
    }  
    
    
    public List<SiiDistribucionUbica> buscarDistribucionUbicaXIdDocConpes(Long idDocCompes) throws ExcepcionDAO {
        List<SiiDistribucionUbica> listaSiiDistribucionUbica = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT dub FROM SiiDistribucionUbica dub");
            sql.append(" Inner Join  dub.siiEnteTerritorial et");
            sql.append(" Inner Join et.siiUbicacion ub");            
            sql.append(" WHERE dub.siiDocumentoConpes.dcnCodigo = :idDocCompes");
            sql.append(" and ub.ubiCodigoPadre <>'CO'");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDocCompes", idDocCompes);
            listaSiiDistribucionUbica = query.getResultList();


           return listaSiiDistribucionUbica;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDistribucionUbicaDAO");
        }

    }
    
    
    
}
