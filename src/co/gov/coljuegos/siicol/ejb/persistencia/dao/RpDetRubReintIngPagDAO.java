package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubReintIngPag;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class RpDetRubReintIngPagDAO extends GenericDAO<SiiRpDetRubReintIngPag> { 
   
   
    public RpDetRubReintIngPagDAO(){
        super(SiiRpDetRubReintIngPag.class);
    }
    
    public List<SiiRpDetRubReintIngPag> buscarRpDetRubReintIngPagXReiIngresoPag(Long ripCodigo ) throws ExcepcionDAO {
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT c FROM SiiRpDetRubReintIngPag c");
            sql.append(" where c.siiReintegroIngresoPag.ripCodigo = :ripCodigo  ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ripCodigo", ripCodigo);
            List<SiiRpDetRubReintIngPag> listaSiiRpDetRubReintIngPag = query.getResultList();
            
            return listaSiiRpDetRubReintIngPag;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
      
    }
    
    
}
