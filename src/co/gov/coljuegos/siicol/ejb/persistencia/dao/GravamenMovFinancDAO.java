package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGravamenMovFinanc;
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
public class GravamenMovFinancDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public GravamenMovFinancDAO() {
        recursos = new Recursos();
    }
    
    public SiiGravamenMovFinanc buscarGravamenMovFinancPorId (Long idGravamenMovFinanc) throws ExcepcionDAO {
        SiiGravamenMovFinanc siiGravamenMovFinanc = new SiiGravamenMovFinanc();
        try{
            siiGravamenMovFinanc = (SiiGravamenMovFinanc) manager.find(SiiGravamenMovFinanc.class, idGravamenMovFinanc);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"GravamenMovFinancDAO");
        }
        return siiGravamenMovFinanc;
    }
    
    public List<SiiGravamenMovFinanc> buscarGravamenMovFinancPorEstado (String estadoGravamenMovFinanc) throws ExcepcionDAO{
        List<SiiGravamenMovFinanc> listaGravamenMovfinanc = new ArrayList<SiiGravamenMovFinanc>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT gmf FROM SiiGravamenMovFinanc gmf WHERE gmf.gmfActivo = :estadoGmf ");            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estadoGmf", estadoGravamenMovFinanc);
            listaGravamenMovfinanc = query.getResultList();            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"GravamenMovFinancDAO");                 
        }
        return listaGravamenMovfinanc;
    }
}


