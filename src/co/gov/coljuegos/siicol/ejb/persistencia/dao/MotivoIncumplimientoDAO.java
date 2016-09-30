package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaVisita;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoIncumplimiento;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MotivoIncumplimientoDAO extends AbstractDAO<Long, SiiMotivoIncumplimiento>{
    public MotivoIncumplimientoDAO() {
        super(SiiMotivoIncumplimiento.class);
    }
    
    
    /*public List<SiiMotivoIncumplimiento> buscarMotivoIncumplimientoXTipo (String minTipo) throws ExcepcionDAO{
        List<SiiMotivoIncumplimiento> listaMotivoIncumplimiento = new ArrayList<SiiMotivoIncumplimiento>();
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT m FROM SiiMotivoIncumplimiento m where m.minTipo = :minTipo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("minTipo", minTipo);
            listaMotivoIncumplimiento = query.getResultList();        
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaMotivoIncumplimiento;
    }*/
    
}
