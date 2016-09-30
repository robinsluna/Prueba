/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 19-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoSolicAutoriza;
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
public class TipoSolicAutorizaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public TipoSolicAutorizaDAO() {
        recursos = new Recursos();
    }
    
    public SiiTipoSolicAutoriza buscarTipoSolicAutorizaPorCodigo(Long idCodigoSolicAutoriza) throws ExcepcionDAO {
        SiiTipoSolicAutoriza retorno = null;
        try {
            retorno = (SiiTipoSolicAutoriza) manager.find(SiiTipoSolicAutoriza.class, idCodigoSolicAutoriza);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoSolicAutorizaDAO");
        }
        return retorno;

    }
    
    public SiiTipoSolicAutoriza insertarSiiTipoSolicAutoriza(SiiTipoSolicAutoriza tipoSolicAutoriza) throws ExcepcionDAO {
        try {
            manager.persist(tipoSolicAutoriza); 
            manager.flush(); 
            return tipoSolicAutoriza; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoSolicAutorizaDAO");
        }
    }
    
    public SiiTipoSolicAutoriza actualizarSiiTipoSolicAutoriza(SiiTipoSolicAutoriza tipoSolicAutoriza) throws ExcepcionDAO {
        try {
            manager.merge(tipoSolicAutoriza); 
            manager.flush(); 
            return tipoSolicAutoriza; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoSolicAutorizaDAO");
        }
    }
    public void borrarSiiTipoSolicAutoriza(Long idCodigoSolicAutoriza) throws ExcepcionDAO {
        SiiTipoSolicAutoriza tipoSolicAutoriza = null;
        try {
            tipoSolicAutoriza = manager.find(SiiTipoSolicAutoriza.class, idCodigoSolicAutoriza);
            manager.remove(tipoSolicAutoriza);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoSolicAutorizaDAO");
        }
    }
    
    
    public List<SiiTipoSolicAutoriza> buscarTodoSiiTipoSolicAutoriza() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiTipoSolicAutoriza o");
            Query query = manager.createQuery(sql.toString());
            List<SiiTipoSolicAutoriza> listaTipoSolicAutoriza = query.getResultList();
            return listaTipoSolicAutoriza;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TipoSolicAutorizaDAO");
        }

    }

    public List<SiiTipoSolicAutoriza> buscarTodaTipoSolicAutoriza () throws ExcepcionDAO {
            List<SiiTipoSolicAutoriza> tipoSolicAutoriza;
            try{
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT o FROM SiiTipoSolicAutoriza o");
                Query query = manager.createQuery(sql.toString());
                
                tipoSolicAutoriza = query.getResultList();
            } catch (PersistenceException pe){
                
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, "TipoSolicAutorizaDAO");
            }catch (Exception ex) {
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "TipoSolicAutorizaDAO");
            }
        return tipoSolicAutoriza;
    }

    public static List<SiiTipoSolicAutoriza> buscarTodoTipoSolicAutoriza() {
        return null;
    }
}
