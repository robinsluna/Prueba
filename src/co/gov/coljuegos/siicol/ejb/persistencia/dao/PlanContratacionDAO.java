package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;
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
public class PlanContratacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public PlanContratacionDAO() {
        recursos = new Recursos();
    }
    
    public SiiPlanContratacion buscarPlanContratacionPorId(Long idPlanContratac) throws ExcepcionDAO {
        SiiPlanContratacion planContratacion = null;
        try {
            planContratacion = (SiiPlanContratacion) manager.find(SiiPlanContratacion.class, idPlanContratac);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PlanContratacDAO");
        }
        return planContratacion;
    }
    
    public SiiPlanContratacion insertarPlanContratacion(SiiPlanContratacion planContratac) throws ExcepcionDAO {
        try {
            manager.persist(planContratac);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PlanContratacDAO");
        }
        return planContratac;
    }
    
    public SiiPlanContratacion actualizarPlanContratacion(SiiPlanContratacion planContratac) throws ExcepcionDAO {
        try {
            manager.merge(planContratac);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "PlanContratacDAO");
        }
        return planContratac;
    }
    
    public SiiPlanContratacion buscarPlanContratacionPorVigencia (Integer vigencia) throws ExcepcionDAO{
        SiiPlanContratacion siiPlanContratacionRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT planC FROM SiiPlanContratacion planC WHERE planC.pcnVigencia = :vigencia");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("vigencia",vigencia); 
            List<SiiPlanContratacion> listaPlanes = query.getResultList();
            if(listaPlanes != null && listaPlanes.size() > 0){
                siiPlanContratacionRetorno = listaPlanes.get(0);
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
        return siiPlanContratacionRetorno;
    }
}
