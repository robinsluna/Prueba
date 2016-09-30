package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModificRp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class EstadoModificRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoModificRpDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoModificRp buscarEstadoModificRpPorId(Long emcCodigo) throws ExcepcionDAO {
        SiiEstadoModificRp estadoModificRp = null;
        try {
            return estadoModificRp = (SiiEstadoModificRp) manager.find(SiiEstadoModificRp.class, emcCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModificRpDAO");
        }
        
        
    }
    
    public SiiEstadoModificRp buscarEstadoModificRpPorNombre(String nombre) throws ExcepcionDAO {
        SiiEstadoModificRp estadoModificRp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoModificRp o where o.emrNombre = :nombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombre", nombre);
            estadoModificRp = (SiiEstadoModificRp) query.getSingleResult();
            return estadoModificRp;

            } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModificRpDAO");
            
        }
    }

}
