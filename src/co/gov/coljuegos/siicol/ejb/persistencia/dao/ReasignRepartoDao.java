package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocContable;
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
public class ReasignRepartoDao {
    
    /** Entity Manager */
    @PersistenceContext(unitName = "siicolPU")
    protected EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    protected Recursos recursos;
    
    public ReasignRepartoDao() {
        super();
    }
    
    /**
     * Realiza la b&uacute;squeda de TODOS los registros correspondientes a la Entidad base.
     * @return List of SiiTipoDocContable
     * @throws ExcepcionDAO
     */
    public List<SiiTipoDocContable> buscarTodo() throws ExcepcionDAO 
    {
        List<SiiTipoDocContable> lista = null;
        
        try {                
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoDocContable o");
            Query query = em.createQuery(sql.toString());
            lista = query.getResultList();
            
            return lista;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
}
