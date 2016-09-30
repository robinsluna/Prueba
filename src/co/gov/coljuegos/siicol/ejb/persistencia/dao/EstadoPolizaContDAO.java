package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModificRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPolizaCont;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoPolizaContDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoPolizaContDAO(){
        recursos = new Recursos();
    }
    
    public SiiEstadoPolizaCont buscarEstadoPolizaContPorEstado(String estado) throws ExcepcionDAO {
        SiiEstadoPolizaCont estadoPoliza = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoPolizaCont o where o.epoNombre = :estado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("estado", estado);
            estadoPoliza = (SiiEstadoPolizaCont) query.getSingleResult();
            return estadoPoliza;
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError  + " : " + pe.getMessage(), "EstadoPolizaContDAO");
            
        }  catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoPolizaContDAO");
        }
    }
    
    public SiiEstadoPolizaCont buscarEstadoPolizaContPorId(Long epoCodigo) throws ExcepcionDAO {
        SiiEstadoPolizaCont siiEstadoPolizaCont = null;
        try {
            siiEstadoPolizaCont = (SiiEstadoPolizaCont) manager.find(SiiEstadoPolizaCont.class, epoCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModificRpDAO");
        }
        return siiEstadoPolizaCont;
    }
}
