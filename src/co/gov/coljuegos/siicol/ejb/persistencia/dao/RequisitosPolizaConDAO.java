package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitosPolizaCon;
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
public class RequisitosPolizaConDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public RequisitosPolizaConDAO() {
        recursos = new Recursos();
    }
    
    public List<SiiRequisitosPolizaCon> buscarTodoRequisitoPoliza() throws ExcepcionDAO {
        List<SiiRequisitosPolizaCon> listaSiiRequisitosPolizaCon = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rpc FROM SiiRequisitosPolizaCon rpc");
            sql.append(" WHERE rpc.rpcActivo = 'S'");
            Query query = manager.createQuery(sql.toString());
            listaSiiRequisitosPolizaCon = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiRequisitosPolizaCon;
    }
    
    public SiiRequisitosPolizaCon buscarRequisitosPolizaPorId(Long rpcCodigo) throws ExcepcionDAO {
        SiiRequisitosPolizaCon siiRequisitosPolizaCon = null;
        try {
            siiRequisitosPolizaCon = manager.find(SiiRequisitosPolizaCon.class, rpcCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiRequisitosPolizaCon;
    }
    
}
