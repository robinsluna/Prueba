/*
 * SISTEMA      : SIICOL
 * MÓDULO       : PAC y TESORERIA
 * AUTOR        : Camilo Miranda
 * FECHA        : 10-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPago;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class EstadoSolicPagoDAO 
{
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager em;
    
    /** Encargado de obtener valores de los archivos de Properties */
    private Recursos recursos;
    
    
    
    /**
     * Constructor.
     */
    public EstadoSolicPagoDAO() {
        this.recursos = new Recursos();
    }
    
    
    
    /**
     * Realiza la consulta de un Estado de Solicitud de Pago a trav&eacute;s del C&oacute;digo del mismo.
     * @param idEstadoSolicPago
     * @return SiiEstadoSolicPago
     * @throws ExcepcionDAO
     */
    public SiiEstadoSolicPago buscarPorCodigoEstadoSolicPago (Long idEstadoSolicPago) 
        throws ExcepcionDAO 
    {
        SiiEstadoSolicPago estadoSolicPago = null;
        try {
            estadoSolicPago = em.find(SiiEstadoSolicPago.class, idEstadoSolicPago);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicPagoDAO");
        }
        return estadoSolicPago;

    }
    
    
    /**
     * Realiza la Inserci&oacute;n de un registro de Estado de Solicitud de Pago.
     * @param siiEstadoSolicPago
     * @return SiiEstadoSolicPago
     * @throws ExcepcionDAO
     */
    public SiiEstadoSolicPago insertarSiiEstadoSolicPago (SiiEstadoSolicPago siiEstadoSolicPago) 
        throws ExcepcionDAO 
    {
        try {
            em.persist(siiEstadoSolicPago); 
            em.flush(); 
            return siiEstadoSolicPago; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicPagoDAO");
        }
    }
    
    
    /**
     * Realiza la Actualizaci&oacute;n del registro del Estado de Solicitud de Pago.
     * @param siiEstadoSolicPago
     * @return SiiEstadoSolicPago
     * @throws ExcepcionDAO
     */
    public SiiEstadoSolicPago actualizarSiiEstadoSolicPago(SiiEstadoSolicPago siiEstadoSolicPago) 
    throws ExcepcionDAO 
    {
        try {
            em.merge(siiEstadoSolicPago); 
            em.flush(); 
            return siiEstadoSolicPago; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicPagoDAO");
        }
    }
    
    
    /**
     * Realiza la Eliminaci&oacute;n del registro del Estado de Solicitud de Pago.
     * @param idEstadoSolicPago
     * @throws ExcepcionDAO
     */
    public void borrarSiiEstadoSolicPago (Long idEstadoSolicPago) 
        throws ExcepcionDAO 
    {
        SiiEstadoSolicPago estadoSolicPagoBorrar = null;
        try {
            estadoSolicPagoBorrar = em.find(SiiEstadoSolicPago.class, idEstadoSolicPago);
            if (estadoSolicPagoBorrar!=null) {
                em.remove(estadoSolicPagoBorrar);
                em.flush();
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicPagoDAO");
        }
    }
    
    
    
    /**
     * Realiza la consulta de Todos los Estados de Solicitud de Pago.
     * @return listado de SiiEstadoSolicPago.
     * @throws ExcepcionDAO
     */
    public List<SiiEstadoSolicPago> buscarTodoSiiEstadoSolicPago() 
        throws ExcepcionDAO 
    {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiEstadoSolicPago o");
            Query query = em.createQuery(sql.toString());
            List<SiiEstadoSolicPago> listaSP = query.getResultList();
            return listaSP;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoSolicPagoDAO");
        }
    }

    
}
