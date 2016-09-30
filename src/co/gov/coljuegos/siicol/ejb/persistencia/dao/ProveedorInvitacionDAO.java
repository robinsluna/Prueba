package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedorInvitacion;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class ProveedorInvitacionDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ProveedorInvitacionDAO() {
        recursos = new Recursos();
    }

    public SiiProveedorInvitacion buscarProveedorInvitacionPorId(Long idProveedorInvitacion) throws ExcepcionDAO {
        SiiProveedorInvitacion localProveedorInvitacion = null;
        try {
            localProveedorInvitacion = (SiiProveedorInvitacion) manager.find(SiiProveedorInvitacion.class, idProveedorInvitacion);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
        return localProveedorInvitacion;
    }

    public SiiProveedorInvitacion insertarProveedorInvitacion(SiiProveedorInvitacion proveedorInvitacion) throws ExcepcionDAO {
        try {
            manager.persist(proveedorInvitacion);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
        return proveedorInvitacion;
    }

    public SiiProveedorInvitacion actualizarProveedorInvitacion(SiiProveedorInvitacion proveedorInvitacion) throws ExcepcionDAO {
        try {
            manager.merge(proveedorInvitacion);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
        return proveedorInvitacion;
    }
    
    public void eliminarProveedorInvitacion(Long idProveedorInvitacion) throws ExcepcionDAO {
        SiiProveedorInvitacion localProveedorInvitacion;
        try {
            localProveedorInvitacion = (SiiProveedorInvitacion) manager.find(SiiProveedorInvitacion.class, idProveedorInvitacion);
            manager.remove(localProveedorInvitacion);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
    }
    
    public List<SiiProveedorInvitacion> buscarTodoProveedorInvitacionPorInvitacion(Integer invitacion) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();            
            sql.append("SELECT o from SiiProveedorInvitacion o INNER JOIN o.siiInvitacionProceso pc WHERE o.siiInvitacionProceso.iprCodigo = :invitacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("invitacion", invitacion);
            List<SiiProveedorInvitacion> listaProveedorInvitacion = query.getResultList();
            return listaProveedorInvitacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
    }
    public List<SiiProveedorInvitacion> buscarProveedorInvitacionPorCodProveedoreInvitacion(long idProveedor,long idInvitacionProceso) throws ExcepcionDAO {
        try {
            List<SiiProveedorInvitacion> miLista = new ArrayList<SiiProveedorInvitacion>();
            StringBuilder sql = new StringBuilder();            
            sql.append(" SELECT pin_codigo,pro_codigo,ipr_codigo from sii_proveedor_invitacion where pro_codigo =#idProveedor" );
            sql.append(" and ipr_codigo = #idInvitacionProceso");
            
            Query query = manager.createNativeQuery(sql.toString());          
            query.setParameter("idProveedor", idProveedor);
            query.setParameter("idInvitacionProceso", idInvitacionProceso);
            
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) { 
                        SiiProveedorInvitacion unSiiProveedorInvitacion = new SiiProveedorInvitacion();
                        
                        SiiInvitacionProceso unSiiInvitacionProceso = new SiiInvitacionProceso();
                        unSiiInvitacionProceso.setIprCodigo(((BigDecimal)object[2]).longValue());                        
                        unSiiProveedorInvitacion.setSiiInvitacionProceso(unSiiInvitacionProceso);
                        
                        SiiProveedor unsiiProveedor = new SiiProveedor();
                        unsiiProveedor.setProCodigo(((BigDecimal)object[1]).longValue());                        
                        unSiiProveedorInvitacion.setSiiProveedor(unsiiProveedor);
                        
                        unSiiProveedorInvitacion.setPinCodigo(((BigDecimal)object[0]).longValue());
                        miLista.add(unSiiProveedorInvitacion);
                        
                    }
            }
            
            return miLista;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
    }
    
    
    /**
     * Obtiene el listado de Proveedores de la Invitaci&oacute;n relacionada con el Proceso de Contrataci&oacute;n especificado.
     * @param prcCodigo - ID del Proceso de Contrataci&oacute;n.
     * @return List of SiiProveedorInvitacion
     * @throws ExcepcionDAO
     */
    public List<SiiProveedorInvitacion> buscarProveedorInvitacionPorProcesoContratacion (Long prcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();            
            sql.append("SELECT o from SiiProveedorInvitacion o ");
            sql.append("INNER JOIN SiiInvitacionProceso ip  ON  ip.iprCodigo = o.siiInvitacionProceso.iprCodigo ");
            sql.append("INNER JOIN SiiProcesoContratacion pc   ON  pc.prcCodigo = ip.siiProcesoContratacion.prcCodigo ");
            sql.append("WHERE pc.prcCodigo = :prcCodigo");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            
            List<SiiProveedorInvitacion> listaProveedorInvitacion = query.getResultList();
            return listaProveedorInvitacion;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorInvitacionDAO");
        }
    }

}
