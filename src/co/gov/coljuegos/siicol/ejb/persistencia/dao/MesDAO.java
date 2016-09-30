package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionFlujoCaja;
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
public class MesDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MesDAO() {
        
        recursos = new Recursos();
        
    }
    
    public SiiMes buscarMesPorId(Integer idMes) throws ExcepcionDAO {
        SiiMes siiMes = null;
        try {
            siiMes = manager.find(SiiMes.class, idMes); 
          } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(), "MesDAO");
        }
        return siiMes;
    }
    
    public List<SiiMes> buscarTodosMes() throws ExcepcionDAO{
            try{
                List<SiiMes> listaMes = null;
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT mes FROM SiiMes mes");
                Query query = manager.createQuery(sql.toString());
                listaMes = query.getResultList();
                return listaMes;
            }catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : "+pe.getMessage(),"UsuarioDAO");
            }
        }
}
