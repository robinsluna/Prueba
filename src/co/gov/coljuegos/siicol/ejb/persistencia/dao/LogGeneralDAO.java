package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogGeneral;
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
public class LogGeneralDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public LogGeneralDAO() {
        recursos = new Recursos();
    }
    
    public void insertarLog (SiiLogGeneral siiLogGeneral) throws ExcepcionDAO{
        try{
            manager.persist(siiLogGeneral);                                                                                     //La guarda en el almacen
            manager.flush();                                                                                                            //Pasa a la Bd
                                                                                                           //Retorna la Entidad
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"LogGeneralDAO");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    /**
     * Busca todos los M&oacute;dulos que han sido asociados en los registros del Log General.
     * @return Listado de M&oacute;dulos.
     * @throws ExcepcionDAO
     */
    public List<String> buscarTodoModuloLogGeneral () throws ExcepcionDAO 
    {
        List<String> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT LGE_MODULO FROM SII_LOG_GENERAL ORDER BY 1");
            
            Query query = manager.createNativeQuery(sql.toString());
            resultado = query.getResultList();
            
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"LogGeneralDAO");
        }
        
        return (resultado);
    }
}
