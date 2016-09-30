package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAmparo;
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
public class TipoAmparoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoAmparoDAO() {
        recursos = new Recursos();
    }
    
    public SiiTipoAmparo buscarTipoAmparoPorId(Long idTipoAmparo) throws ExcepcionDAO{
            SiiTipoAmparo siiTipoAmparoRetorno = null;
            try{
                siiTipoAmparoRetorno = (SiiTipoAmparo) manager.find(SiiTipoAmparo.class, idTipoAmparo);
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"TipoAmparoDAO");
            }
            return siiTipoAmparoRetorno;
        }
    
    public SiiTipoAmparo insertarTipoAmparo(SiiTipoAmparo siiTipoAmparo) throws ExcepcionDAO{
        try{
            manager.persist(siiTipoAmparo);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                              //Retorna el VO
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"TipoAmparoDAO");
        }
        return siiTipoAmparo;
    }
    
    public List<SiiTipoAmparo> buscarTodosTipoAmparo() throws ExcepcionDAO{
        try{
            List<SiiTipoAmparo> listaTipoAmparo = null;
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ta FROM SiiTipoAmparo ta ORDER BY ta.tamDescripcion");
            Query query = manager.createQuery(sql.toString());
            listaTipoAmparo = query.getResultList();
            return listaTipoAmparo;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"TipoAmparoDAO");
        }
    }
    
    public List<SiiTipoAmparo> buscarTipoAmparoPorNombre(SiiTipoAmparo unTipoAmparo) throws ExcepcionDAO{
    List<SiiTipoAmparo>  tipoAmparoRetorno = null;
    try{
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ta FROM SiiTipoAmparo ta");
        sql.append(" WHERE ta.tamNombre = :taNombre");
        Query query = manager.createQuery(sql.toString());
        query.setParameter("taNombre", unTipoAmparo.getTamNombre());
        tipoAmparoRetorno = query.getResultList();      
    }catch (PersistenceException pe){
        String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
        throw new ExcepcionDAO(mensajeError,"TipoAmparoDAO");            
    }
    return tipoAmparoRetorno;               
    }

}
