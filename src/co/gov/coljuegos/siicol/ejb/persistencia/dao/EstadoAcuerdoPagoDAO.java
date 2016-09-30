package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAcuerdoPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCdp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Stateless
@LocalBean
public class EstadoAcuerdoPagoDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoAcuerdoPagoDAO() {
        recursos = new Recursos();
    }
    public SiiEstadoAcuerdoPago buscarEstadoAcuerdoPagoPorId(long idEstado) throws ExcepcionDAO {
        SiiEstadoAcuerdoPago estadoAcuerdo = null;
        try {
            estadoAcuerdo = (SiiEstadoAcuerdoPago) manager.find(SiiEstadoAcuerdoPago.class, idEstado);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoAcuerdoPagoDAO");
        } 
        return estadoAcuerdo;
    }
}
