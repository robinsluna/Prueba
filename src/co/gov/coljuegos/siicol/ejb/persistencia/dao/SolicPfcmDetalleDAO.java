/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 03-11-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.SolicPfcmDetalleVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SolicPfcmDetalleDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public SolicPfcmDetalleDAO() {
        recursos = new Recursos();
    }
    
    public SiiSolicPfcmDetalle buscarSolicitudPfcmPorId(Long idSolicPfcmDet) throws ExcepcionDAO {
        SiiSolicPfcmDetalle siiSolicPfcmDetalleRetorno = null;
        try {
            siiSolicPfcmDetalleRetorno =(SiiSolicPfcmDetalle) manager.find(SiiSolicPfcmDetalle.class, idSolicPfcmDet);
         
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
        return siiSolicPfcmDetalleRetorno;
    }
    
    public SiiSolicPfcmDetalle insertarSolicPfcmDet(SiiSolicPfcmDetalle siiSolicPfcmDetalle) throws ExcepcionDAO {
        try {
            manager.persist(siiSolicPfcmDetalle);                                                            //La guarda en el almacen
            manager.flush();                                                                                 //Pasa a la Bd
            return siiSolicPfcmDetalle;                                                                      //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
    
    public SiiSolicPfcmDetalle actualizarSolicPfcmDet(SiiSolicPfcmDetalle siiSolicPfcmDetalle) throws ExcepcionDAO {
        try {
            manager.merge(siiSolicPfcmDetalle);                                                                           
            manager.flush();                                                                                             
           return siiSolicPfcmDetalle;                                                                                 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicPfcmDetalleDAO");
        }
    }
    
    public List<SiiSolicPfcmDetalle> buscarTodoDetallePorSolPfcm(Long idSolicitud ) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solPfcmDet FROM SiiSolicPfcmDetalle solPfcmDet");
            sql.append(" INNER JOIN solPfcmDet.siiSolicitudPfcMens SoliMen");
            sql.append(" WHERE solPfcmDet.siiSolicitudPfcMens.spfCodigo = :codigoSolPfcm");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoSolPfcm", idSolicitud);
            List<SiiSolicPfcmDetalle> listaEntidadSolPfcmDet= query.getResultList();

            return listaEntidadSolPfcmDet;
            
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicPfcmDetalleDAO");
        }
    }
    
    
    
    
}
