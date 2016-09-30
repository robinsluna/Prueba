package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
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
public class ConceptoCuotaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public ConceptoCuotaDAO() {
        recursos = new Recursos();  
    }
    
    public SiiConceptoCuota   buscarConceptoCuotaXId(Long idConceptoCuota) throws ExcepcionDAO {
        SiiConceptoCuota siiConceptoCuota = null;
        try {
            siiConceptoCuota = (SiiConceptoCuota) manager.find(SiiConceptoCuota.class, idConceptoCuota);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return siiConceptoCuota;

    }
    
    public List<SiiConceptoCuota> buscarTodoSiiConceptoCuota() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiConceptoCuota o");
            Query query = manager.createQuery(sql.toString());
            List<SiiConceptoCuota> listaSolAutoriza = query.getResultList();
            return listaSolAutoriza;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    public List<SiiConceptoCuota> buscarSiiConceptoCuotaPorModalidades(String modalidad1, String modalidad2, String modalidad3) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiConceptoCuota o WHERE o.ccuModalidad = :modalidad1 or o.ccuModalidad = :modalidad2 or o.ccuModalidad = :modalidad3 ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("modalidad1", modalidad1);
            query.setParameter("modalidad2", modalidad2);
            query.setParameter("modalidad3", modalidad3);
            List<SiiConceptoCuota> listaConceptos = query.getResultList();
            return listaConceptos;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    public List<SiiConceptoCuota> buscarTodoSiiConceptoCuotaXAbreviatura(String  ccuAbreviatura) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiConceptoCuota o");
            sql.append(" where o.ccuAbreviatura= :ccuAbreviatura ");
           
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ccuAbreviatura", ccuAbreviatura);
            List<SiiConceptoCuota> listaSolAutoriza = query.getResultList();
            return listaSolAutoriza;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    public List<SiiConceptoCuota> buscarTodoSiiConceptoCuotaXNombre(String  ccuNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiConceptoCuota o");
            sql.append(" where o.ccuNombre= :ccuNombre ");
           
            Query query = manager.createQuery(sql.toString());
            query.setParameter("ccuNombre", ccuNombre);
            List<SiiConceptoCuota> listaSolAutoriza = query.getResultList();
            return listaSolAutoriza;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    public List<SiiConceptoCuota> buscarTodoSiiConceptoCuotaXCategoria(String  cadNombre) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiConceptoCuota o inner join  o.siiCategoriaDistrib c");
            sql.append(" where c.cadNombre = :cadNombre  order by o.ccuNombre asc ");
           
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cadNombre", cadNombre);
            List<SiiConceptoCuota> listaSolAutoriza = query.getResultList();
            return listaSolAutoriza;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ConceptoCuotaDAO");
        }
    }
    
    
}
