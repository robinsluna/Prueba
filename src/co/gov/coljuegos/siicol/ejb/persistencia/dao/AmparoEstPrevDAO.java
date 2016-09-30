package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class AmparoEstPrevDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AmparoEstPrevDAO() {
        recursos = new Recursos();
    }
    
    public SiiAmparoEstPrev buscarAmparoEstPrevPorId(Long idAmparoEstPrev) throws ExcepcionDAO{
            SiiAmparoEstPrev  siiAmparoEstPrevRetorno = null;
            try{
                siiAmparoEstPrevRetorno = (SiiAmparoEstPrev) manager.find(SiiAmparoEstPrev.class, idAmparoEstPrev);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoEstPrevDAO");
            }
            return siiAmparoEstPrevRetorno;
        }
    
    public SiiAmparoEstPrev  insertarAmparoEstPrev (SiiAmparoEstPrev  siiAmparoEstPrev) throws ExcepcionDAO{
        try{
            manager.persist(siiAmparoEstPrev);                                                                            //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoEstPrevDAO");
        }
        return siiAmparoEstPrev;
    }
    
    public SiiAmparoEstPrev actualizarAmparoEstPrev(SiiAmparoEstPrev siiAmparoEstPrev) throws ExcepcionDAO{
        try{
            siiAmparoEstPrev = manager.merge(siiAmparoEstPrev);
            manager.flush();
            return siiAmparoEstPrev;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoEstPrevDAO");
        }
    }
    
    public List<SiiAmparoEstPrev> buscarTodosAmparoEstPrev() throws ExcepcionDAO{
        try{
            List<SiiAmparoEstPrev> listaAmparoEstPrev = null;            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aep FROM SiiAmparoEstPrev aep");
            Query query = manager.createQuery(sql.toString());
            listaAmparoEstPrev = query.getResultList();

            return listaAmparoEstPrev;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AmparoEstPrevDAO");
        }
    }
    
    public List<SiiAmparoEstPrev> buscarAmparoEstPrevPorIdEstPrevio (Long idEstPrevio) throws ExcepcionDAO{
        try{
            List<SiiAmparoEstPrev> listaAmparoEstPrev = null;
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT aep FROM SiiAmparoEstPrev aep WHERE aep.siiEstudioPrevio.epeCodigo = :idEstudioPrevio");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idEstudioPrevio", idEstPrevio);
            listaAmparoEstPrev = query.getResultList();
            return listaAmparoEstPrev;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AmparoEstPrevDAO");
        }
    }
    
    public void eliminarAmparoEstPrev (Long idAmparoEstPrev) throws ExcepcionDAO{
        try{
            SiiAmparoEstPrev amparoEstPrev = (SiiAmparoEstPrev) manager.find(SiiAmparoEstPrev.class, idAmparoEstPrev);
            manager.remove(amparoEstPrev);
            manager.flush();
        }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"AmparoEstPrevDAO");
            }
    }
}

