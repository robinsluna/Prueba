package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPlanCont;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoModifPlanContDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoModifPlanContDAO() {
        recursos = new Recursos();
    }

    public SiiEstadoModifPlanCont buscarEstadoPorNombre(String estado) throws ExcepcionDAO {
        SiiEstadoModifPlanCont estadoModifPlanCont= new SiiEstadoModifPlanCont();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoModifPlanCont o WHERE o.emoNombre like :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado",estado);
            estadoModifPlanCont = (SiiEstadoModifPlanCont) query.getSingleResult();
            return estadoModifPlanCont;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifPlanContDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoModifPlanContDAO");
        }
    }

    public SiiEstadoModifPlanCont buscarEstadoModifPlanContPorId(Long emoCodigo) throws ExcepcionDAO {
        SiiEstadoModifPlanCont siiEstadoModifPlanCont = null;
        try {
            return siiEstadoModifPlanCont = (SiiEstadoModifPlanCont) manager.find(SiiEstadoModifPlanCont.class, emoCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifPlanContDAO");
        }

    }
}
