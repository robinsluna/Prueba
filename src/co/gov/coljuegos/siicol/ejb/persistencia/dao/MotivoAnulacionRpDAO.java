/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.AdendaVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminoReferenciaVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MotivoAnulacionRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MotivoAnulacionRpDAO() {
        recursos = new Recursos();
    }
    
    public SiiMotivoAnulRp buscarPorCodigoMotivoAnulacion(Long idCodigoMotivo) throws ExcepcionDAO {
        SiiMotivoAnulRp motivoAnulacionRetorno = null;
        try {
            motivoAnulacionRetorno = (SiiMotivoAnulRp) manager.find(SiiMotivoAnulRp.class, idCodigoMotivo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoAnulacionRpDAO");
        }
        return motivoAnulacionRetorno;

    }
    
    public SiiMotivoAnulRp insertarSiiMotivoAnulRp(SiiMotivoAnulRp motivoAnulacionRp) throws ExcepcionDAO {
        try {
            manager.persist(motivoAnulacionRp); 
            manager.flush(); 
            return motivoAnulacionRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoAnulacionRpDAO");
        }
    }
    
    public SiiMotivoAnulRp actualizarSiiMotivoAnulRp(SiiMotivoAnulRp motivoAnulacionRp) throws ExcepcionDAO {
        try {
            manager.merge(motivoAnulacionRp); 
            manager.flush(); 
            return motivoAnulacionRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoAnulacionRpDAO");
        }
    }
    public void borrarSiiMotivoAnulRp(Long idCodigoMotivo) throws ExcepcionDAO {
        SiiMotivoAnulRp motivoAnulacionRp = null;
        try {
            motivoAnulacionRp = manager.find(SiiMotivoAnulRp.class, idCodigoMotivo);
            manager.remove(motivoAnulacionRp);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoAnulacionRpDAO");
        }
    }
    
    
    public List<SiiMotivoAnulRp> buscarTodoSiiMotivoAnulRp() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiMotivoAnulRp o");
            Query query = manager.createQuery(sql.toString());
            List<SiiMotivoAnulRp> listaMotivosAnulacion = query.getResultList();
            return listaMotivosAnulacion;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoAnulacionRpDAO");
        }

    }
}
