package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
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
public class ObligDetRubroCdpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public ObligDetRubroCdpDAO() {
        recursos = new Recursos();
    }
    
    public SiiObligDetRubroCdp buscarObligDetRubroCdpPorId(Long idObligDetRubroCdp) throws ExcepcionDAO{
            SiiObligDetRubroCdp siiObligDetRubroCdpRetorno = null;
            try{
                siiObligDetRubroCdpRetorno = (SiiObligDetRubroCdp) manager.find(SiiObligDetRubroCdp.class, idObligDetRubroCdp);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ObligDetRubroCdpDAO");
            }
            return siiObligDetRubroCdpRetorno;
        }
    public SiiObligDetRubroCdp insertarObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) throws ExcepcionDAO{
        try{
            manager.persist(siiObligDetRubroCdp);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ObligDetRubroCdpDAO");
        }
        return siiObligDetRubroCdp;
    }
    
    public SiiObligDetRubroCdp actualizarObligDetRubroCdp(SiiObligDetRubroCdp siiObligDetRubroCdp) throws ExcepcionDAO{
        try{
            siiObligDetRubroCdp = manager.merge(siiObligDetRubroCdp);
            manager.flush();
            return siiObligDetRubroCdp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ObligDetRubroCdpDAO");
        }
    }
    public void eliminarObligDetRubroCdp (Long idObligDetRubroCdp) throws ExcepcionDAO{
        try{
            SiiObligDetRubroCdp obligDetRubroCdpBorrar = (SiiObligDetRubroCdp) manager.find(SiiObligDetRubroCdp.class, idObligDetRubroCdp);
            manager.remove(obligDetRubroCdpBorrar);
            manager.flush();
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"ObligDetRubroCdpDAO");
        }
    }
    
    public List<SiiObligDetRubroCdp> buscarTodosObligDetRubroCdp() throws ExcepcionDAO{
        try{
            List<SiiObligDetRubroCdp> listaObligDetRubroCdp = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT oblgDetRubroCdp FROM SiiObligDetRubroCdp oblgDetRubroCdp");
            Query query = manager.createQuery(sql.toString());
            listaObligDetRubroCdp = query.getResultList();
            return listaObligDetRubroCdp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"oblgDetRubroCdpDAO");
        }
    }
}
    
    

    
    
