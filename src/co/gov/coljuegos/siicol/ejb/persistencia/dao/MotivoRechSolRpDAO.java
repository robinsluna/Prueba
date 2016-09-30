/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 27-11-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoRechSolRp;
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
public class MotivoRechSolRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public MotivoRechSolRpDAO() {
        recursos = new Recursos();
    }
    
    public SiiMotivoRechSolRp buscarPorCodigoMotivoRechSolRp(Long idCodigoMotivo) throws ExcepcionDAO {
        SiiMotivoRechSolRp motivoRechazoRetorno = null;
        try {
            motivoRechazoRetorno = (SiiMotivoRechSolRp) manager.find(SiiMotivoRechSolRp.class, idCodigoMotivo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoRechSolRpDAO");
        }
        return motivoRechazoRetorno;

    }
    
    public SiiMotivoRechSolRp insertarSiiMotivoRechSolRp(SiiMotivoRechSolRp motivoRechazoSolRp) throws ExcepcionDAO {
        try {
            manager.persist(motivoRechazoSolRp); 
            manager.flush(); 
            return motivoRechazoSolRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoRechSolRpDAO");
        }
    }
    
    public SiiMotivoRechSolRp actualizarSiiMotivoRechSolRp(SiiMotivoRechSolRp motivoRechazoSolRp) throws ExcepcionDAO {
        try {
            manager.merge(motivoRechazoSolRp); 
            manager.flush(); 
            return motivoRechazoSolRp; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoRechSolRpDAO");
        }
    }
    public void borrarSiiMotivoRechSolRp(Long idCodigoMotivo) throws ExcepcionDAO {
        SiiMotivoRechSolRp motivoRechSolRp = null;
        try {
            motivoRechSolRp = manager.find(SiiMotivoRechSolRp.class, idCodigoMotivo);
            manager.remove(motivoRechSolRp);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoRechSolRpDAO");
        }
    }
    
    
    public List<SiiMotivoRechSolRp> buscarTodoSiiMotivoRechSolRp() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiMotivoRechSolRp o");
            Query query = manager.createQuery(sql.toString());
            List<SiiMotivoRechSolRp> listaMotivosRechazo = query.getResultList();
            return listaMotivosRechazo;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "MotivoRechSolRpDAO");
        }

    }
}
