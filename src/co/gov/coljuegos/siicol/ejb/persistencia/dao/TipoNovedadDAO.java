package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoNovedad;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TipoNovedadDAO extends GenericDAO<SiiTipoNovedad>{
   
     @PersistenceContext(unitName = "siicolPU")
         private EntityManager manager;
    private Recursos recursos;
    
    public TipoNovedadDAO() {
        super(SiiTipoNovedad.class);
    }
        
    public SiiTipoNovedad buscarPorNombre(String tnoNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiTipoNovedad o WHERE o.tnoNombre = :tnoNombre");
            Query query = em.createQuery(sql.toString());
            query.setParameter("tnoNombre", tnoNombre);
            return (SiiTipoNovedad) query.getSingleResult();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

    }

    public SiiTipoNovedad buscarTipoNovedadPorId(Long tnoCodigo) throws ExcepcionDAO {
        SiiTipoNovedad resultado = null ;
        try {
            resultado = (SiiTipoNovedad) manager.find(SiiTipoNovedad.class, tnoCodigo);

        
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return resultado;

    }
}
   