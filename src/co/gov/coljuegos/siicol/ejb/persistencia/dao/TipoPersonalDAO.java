/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 17-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudEstMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoPersonal;
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
public class TipoPersonalDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoPersonalDAO() {
        recursos = new Recursos();
    }
    
    public SiiTipoPersonal buscarTipoPersonalPorCodigo(Long idCodigoTipoPersonal) throws ExcepcionDAO {
        SiiTipoPersonal retorno = null;
        try {
            retorno = (SiiTipoPersonal) manager.find(SiiTipoPersonal.class, idCodigoTipoPersonal);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoPersonalDAO");
        }
        return retorno;

    }
    
    public SiiTipoPersonal insertarSiiTipoPersonal(SiiTipoPersonal tipoPersonal) throws ExcepcionDAO {
        try {
            manager.persist(tipoPersonal); 
            manager.flush(); 
            return tipoPersonal; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoPersonalDAO");
        }
    }
    
    public SiiTipoPersonal actualizarSiiTipoPersonal(SiiTipoPersonal tipoPersonal) throws ExcepcionDAO {
        try {
            manager.merge(tipoPersonal); 
            manager.flush(); 
            return tipoPersonal; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoPersonalDAO");
        }
    }
    public void borrarSiiTipoPersonal(Long idCodigoTipoPersonal) throws ExcepcionDAO {
        SiiTipoPersonal resultado = null;
        try {
            resultado = manager.find(SiiTipoPersonal.class, idCodigoTipoPersonal);
            manager.remove(resultado);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoPersonalDAO");
        }
    }
    
    
    public List<SiiTipoPersonal> buscarTodoSiiTipoPersonal() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoPersonal o");
            Query query = manager.createQuery(sql.toString());
            List<SiiTipoPersonal> listaTipoPersonal = query.getResultList();
            return listaTipoPersonal;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoPersonalDAO");
        }

    }
}
