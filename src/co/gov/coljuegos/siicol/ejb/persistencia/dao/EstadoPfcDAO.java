/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Diana Caro
 * FECHA	: 20-09-2013
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPfc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
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
public class EstadoPfcDAO  {


    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoPfcDAO  () {
        recursos = new Recursos();
    }
    
    public SiiEstadoPfc buscarPorEpfCodigo(Long idEstadopfc) throws ExcepcionDAO {
        SiiEstadoPfc siiEstadoPfcRetorno = null;
        try {
            siiEstadoPfcRetorno = (SiiEstadoPfc) manager.find(SiiEstadoPfc.class, idEstadopfc); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
             throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiEstadoPfcDAO");
        }
        return siiEstadoPfcRetorno;

    }

    public SiiEstadoPfc insertarSiiEstadoPfc(SiiEstadoPfc siiEstadoPfc) throws ExcepcionDAO {
        try {
            manager.persist(siiEstadoPfc);                          
            manager.flush();                                        
            return siiEstadoPfc;                                 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SiiEstadoPfcDAO");
        }
    }

    public SiiEstadoPfc actualizarSiiEstadoPfc(SiiEstadoPfc siiEstadoPfc) throws ExcepcionDAO {
        try {
            manager.merge(siiEstadoPfc);                                                                           
            manager.flush();                                                                                             
            return siiEstadoPfc;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiEstadoPfcDAO");
        }
    }  
    
   public void borrarPorCodigoSiiEstadoPfc(Long idEstadoPfc) throws ExcepcionDAO {
        SiiEstadoPfc siiEstadoPfcBorrar = null;
        try {
            siiEstadoPfcBorrar =(SiiEstadoPfc) manager.find(SiiEstadoPfc.class, idEstadoPfc);
            manager.remove(siiEstadoPfcBorrar);                                               
            manager.flush();  
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiEstadoPfcDAO");
        }
   
    }

    public List<SiiEstadoPfc> buscarTodoSiiEstadoPfcVO() throws ExcepcionDAO {
        try {
            
      //      List<EstadoPfcVO> listaSiiEstadoPfcVo = new ArrayList();
     //       List<SiiEstadoPfc> listaEntidadEstado = new ArrayList();

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT estadoPfc FROM SiiEstadoPfc estadoPfc");
            Query query = manager.createQuery(sql.toString());
            List<SiiEstadoPfc> listaEntidadEstado = query.getResultList();
            return listaEntidadEstado;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiEstadoPfcDAO");
        }

    }
    
    public SiiEstadoPfc buscarEstadoPfcPorNombre(SiiEstadoPfc siiEstadoPfc) throws ExcepcionDAO{
        SiiEstadoPfc siiEstadoPfRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEstadoPfc est");
            sql.append(" WHERE est.epfNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", siiEstadoPfc.getEpfNombre());
            List<SiiEstadoPfc> listaSiiEstadoPfc = query.getResultList();
            
            if (listaSiiEstadoPfc != null && !listaSiiEstadoPfc.isEmpty()) {
                siiEstadoPfRetorno = listaSiiEstadoPfc.get(0);
        }
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"FuenteFinanciacionDAO");
        }
        return siiEstadoPfRetorno;
    }
    
    

}
