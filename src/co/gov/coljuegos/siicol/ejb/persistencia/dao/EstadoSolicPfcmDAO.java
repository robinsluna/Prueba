/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPfcm;
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
public class EstadoSolicPfcmDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public EstadoSolicPfcmDAO() {
        recursos = new Recursos();
    }
    
    public SiiEstadoSolicPfcm buscarEstadoSolicPfcmPorId(Long idEstadoSolicPfcm) throws ExcepcionDAO{
        SiiEstadoSolicPfcm siiEstadoSolicPfcmRetorno = null;
        try{
            siiEstadoSolicPfcmRetorno = (SiiEstadoSolicPfcm) manager.find(SiiEstadoSolicPfcm.class, idEstadoSolicPfcm);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoSolicPfcmDAO");
        }        
        return siiEstadoSolicPfcmRetorno;
    }
    
    public SiiEstadoSolicPfcm buscarEstadoSolicPfcmPorNombre(SiiEstadoSolicPfcm siiEstadoSolicPfcm) throws ExcepcionDAO{
        SiiEstadoSolicPfcm estadoSolicPfcmRetorno = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT estadoSolPfcm FROM SiiEstadoSolicPfcm estadoSolPfcm");
            sql.append(" WHERE estadoSolPfcm.espNombre = :nomEstadoSolicPfcm");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nomEstadoSolicPfcm", siiEstadoSolicPfcm.getEspNombre());
            List<SiiEstadoSolicPfcm> listaSiiEstado=query.getResultList();
           
            if (listaSiiEstado != null && !listaSiiEstado.isEmpty()) {
                estadoSolicPfcmRetorno = listaSiiEstado.get(0);
            }
                
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"EstadoSolicPfcmDAO");            
        }
        return estadoSolicPfcmRetorno;
    }
    
}
