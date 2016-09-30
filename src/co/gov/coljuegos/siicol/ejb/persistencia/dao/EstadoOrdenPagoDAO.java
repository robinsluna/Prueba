package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDocConpes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOrdenPago;
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
public class EstadoOrdenPagoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    public EstadoOrdenPagoDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoOrdenPago buscarEstadoOrdenPagoPorId(Long idOrdenPago) throws ExcepcionDAO {
        SiiEstadoOrdenPago siiEstadoOrdenPago = null;
        try {
            siiEstadoOrdenPago =
                (SiiEstadoOrdenPago) manager.find(SiiEstadoOrdenPago.class, idOrdenPago);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "EstadoEstudioMercDAO");
        }
        return siiEstadoOrdenPago;
    }
    
    public SiiEstadoOrdenPago buscarEstadoOrdenPagoXNombre(String nombreEstado ) throws ExcepcionDAO {
        try {
            SiiEstadoOrdenPago siiEstadoOrdenPago= null;
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT est FROM SiiEstadoOrdenPago est");
            sql.append(" WHERE est.eopNombre = :nombreEstado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombreEstado", nombreEstado);
            List<SiiEstadoOrdenPago> listaSiiEstadoOrdenPago= query.getResultList();
            
            if (listaSiiEstadoOrdenPago != null && !listaSiiEstadoOrdenPago.isEmpty()) {
                siiEstadoOrdenPago = listaSiiEstadoOrdenPago.get(0);
            }
            return siiEstadoOrdenPago;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiDocumentoConpesDAO");
        }
    }
    
    
}
