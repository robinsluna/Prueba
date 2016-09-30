package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@Local
public class EstadoModifCdpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstadoModifCdpDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoModifCdp buscarEstadoModifCdpPorId(Long emcCodigo) throws ExcepcionDAO {
        SiiEstadoModifCdp estadoModifCdp = null;
        try {
            return estadoModifCdp = (SiiEstadoModifCdp) manager.find(SiiEstadoModifCdp.class, emcCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifCdpDAO");
        }
        
        
    }
    
    public SiiEstadoModifCdp buscarEstadoModifCdpPorNombre(String nombre) throws ExcepcionDAO {
        SiiEstadoModifCdp estadoModifCdp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiEstadoModifCdp o where o.emcNombre = :nombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombre", nombre);
            estadoModifCdp = (SiiEstadoModifCdp) query.getSingleResult();
            return estadoModifCdp;

            } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoModifCdpDAO");
            
        }
    }
}
