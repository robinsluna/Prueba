package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstPrevDetRubro;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;
import javax.persistence.Query;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstPrevDetRubroDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstPrevDetRubroDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstPrevDetRubro buscarEstPrevDetRubroPorId(Long idEstPrevDetRubro) throws ExcepcionDAO{
            SiiEstPrevDetRubro siiidEstPrevDetRubroRetorno = null;
            try{
                siiidEstPrevDetRubroRetorno = (SiiEstPrevDetRubro) manager.find(SiiEstPrevDetRubro.class, idEstPrevDetRubro);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"idEstPrevDetRubroDAO");
            }
            return siiidEstPrevDetRubroRetorno;
        }
    
    public SiiEstPrevDetRubro insertarEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) throws ExcepcionDAO{
        try{
            manager.persist(siiEstPrevDetRubro);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstPrevDetRubroDAO");
        }
        return siiEstPrevDetRubro;
    }
    
    public SiiEstPrevDetRubro actualizarEstPrevDetRubro(SiiEstPrevDetRubro siiEstPrevDetRubro) throws ExcepcionDAO{
        try{
            siiEstPrevDetRubro = manager.merge(siiEstPrevDetRubro);
            manager.flush();
            return siiEstPrevDetRubro;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstPrevDetRubroDAO");
        }
    }
    
    public List<SiiEstPrevDetRubro> buscarTodosEstPrevDetRubro() throws ExcepcionDAO{
        try{
            List<SiiEstPrevDetRubro > listaEstPrevDetRubro  = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT epdr FROM SiiEstPrevDetRubro epdr");
            Query query = manager.createQuery(sql.toString());
            listaEstPrevDetRubro = query.getResultList();

            return listaEstPrevDetRubro;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstPrevDetRubroDAO");
        }
    }
    
    public List<SiiEstPrevDetRubro> buscarEstPrevDetRubroPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO{
        try{
            List<SiiEstPrevDetRubro> listaEstPrevDetRubro = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT epdr FROM SiiEstPrevDetRubro epdr WHERE epdr.siiEstudioPrevio2.epeCodigo = :idEstudioPrevio");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idEstudioPrevio", idEstPrevio);
            listaEstPrevDetRubro = query.getResultList();            
            return listaEstPrevDetRubro;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"EstPrevDetRubroDAO");
        }
        
    }
    
    public void eliminarEstPrevDetRubro (Long idEstPrevDetRubro) throws ExcepcionDAO{
        try {
            SiiEstPrevDetRubro estPrevDetRubro = (SiiEstPrevDetRubro) manager.find(SiiEstPrevDetRubro.class, idEstPrevDetRubro);
            manager.remove(estPrevDetRubro);
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"EstPrevDetRubroDAO");
            }
    }
}
