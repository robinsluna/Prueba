package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocumentoColjuegos;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocumentoColjuegosVO;

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

public class TipoDocumentoColjuegosDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoDocumentoColjuegosDAO() {
        recursos = new Recursos();
    }
    public SiiTipoDocumentoColjuegos buscarTipoDocumentoColjuegosPorId(Long idTipoDocColjuegos) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos = null;
        try{
            siiTipoDocumentoColjuegos = (SiiTipoDocumentoColjuegos) manager.find(SiiTipoDocumentoColjuegos.class, idTipoDocColjuegos);
        }catch (PersistenceException pe) {
            String mensageError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensageError,"TipoDocumentoColjuegosDAO");
        }
        return siiTipoDocumentoColjuegos;
    }

    public SiiTipoDocumentoColjuegos insertarTipoDocumentoColjuegos(SiiTipoDocumentoColjuegos tipoDocumentoColjuegos) throws ExcepcionDAO {
        try{
            manager.persist(tipoDocumentoColjuegos);                                                                                                //La guarda en el almacen
            manager.flush();                                                                                                                            //Pasa a la Bd
            return tipoDocumentoColjuegos;                                                                                                         //Retorna el VO
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"TipoDocumentoColjuegosDAO");
        }
    }
    
    public SiiTipoDocumentoColjuegos actualizarTipoDocumentoColjuegos(SiiTipoDocumentoColjuegos tipoDocumentoColjuegos) throws ExcepcionDAO{
        try{
            manager.merge(tipoDocumentoColjuegos);
            manager.flush();
            return tipoDocumentoColjuegos;
            
        }catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensaje_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoDocumentoColjuegosDAO");
        }
    }

/*
    public void eliminarTipoDocumentoColjuegos(Long idTipoDocColjuegos) throws ExcepcionDAO{
            try{
                SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos = (SiiTipoDocumentoColjuegos) manager.find(SiiTipoDocumentoColjuegos.class, idTipoDocColjuegos);
                manager.remove(siiTipoDocumentoColjuegos);
                manager.flush();
            }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TipoDocumentoColjuegosDAO");
        }
            }
*/
    public List<SiiTipoDocumentoColjuegos> buscarTodoTipoDocumentoColjuegos()
            throws ExcepcionDAO{
        try{
            List<TipoDocumentoColjuegosVO> listaTipoDocumentoColjuegosVO = new ArrayList();
            List<SiiTipoDocumentoColjuegos> listaTipoDocumentoColjuegos = new ArrayList();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocumentoColjuegos o");
            Query query = manager.createQuery(sql.toString());
            listaTipoDocumentoColjuegos = query.getResultList();
             
            return listaTipoDocumentoColjuegos;
            
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"TipoDocumentoColjuegosDAO");
        }
    }


    public TipoDocumentoColjuegosVO buscarTipoDocumentoColjuegosPorNombre(String nombre) throws ExcepcionDAO {
        SiiTipoDocumentoColjuegos tipoDocumentoColjuegos = new SiiTipoDocumentoColjuegos();
        
        try{
            TipoDocumentoColjuegosVO tipoDocumentoColjuegosVO = new TipoDocumentoColjuegosVO();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocumentoColjuegos o WHERE o.tdoNombre = :nombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombre", nombre);
            tipoDocumentoColjuegos = (SiiTipoDocumentoColjuegos) query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ne) {
            tipoDocumentoColjuegos = new SiiTipoDocumentoColjuegos();
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"TipoDocumentoColjuegosDAO");
        }
        
        return new TipoDocumentoColjuegosVO(tipoDocumentoColjuegos); 
    }
}


