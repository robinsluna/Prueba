package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.Calendar;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AutoComisorioDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public AutoComisorioDAO() {
        recursos = new Recursos();
    }
    
    
    public SiiAutoComisorio insertarSiiAutoComisorio(SiiAutoComisorio siiAutoComisorio) throws ExcepcionDAO {
        try {
            manager.persist(siiAutoComisorio);
            manager.flush();
            return siiAutoComisorio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
    
    public SiiAutoComisorio actualizarAutoComisorio(SiiAutoComisorio siiAutoComisorio) throws ExcepcionDAO {
        try {
            siiAutoComisorio = manager.merge(siiAutoComisorio);
            manager.flush();
            return siiAutoComisorio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }
    
    public List<SiiAutoComisorio> buscarTodoAutoComisorio( ) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT a FROM SiiAutoComisorio a  ");
            sql.append(" order by a.aucCodigo desc ");
            Query query = manager.createQuery(sql.toString());
           
            List<SiiAutoComisorio> listaAutoComisorio = query.getResultList();
            return listaAutoComisorio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
    }
    
    public SiiAutoComisorio buscarPorCodigoAutoComisorio(Long aucCodigo) throws ExcepcionDAO {
        SiiAutoComisorio retornoAutoComisorio = null;
        try {
            retornoAutoComisorio = (SiiAutoComisorio) manager.find(SiiAutoComisorio.class, aucCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
        return retornoAutoComisorio;

    }
    
    public SiiAutoComisorio buscarPorNumeroAutoComisorio(Long autNumero) throws ExcepcionDAO {
        SiiAutoComisorio retornoAutoComisorio = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT a FROM SiiAutoComisorio a");
            sql.append(" where  a.aucNumero=:autNumero");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("autNumero", autNumero.intValue());
            List<SiiAutoComisorio> listaAutoComisorio = query.getResultList();
                if (listaAutoComisorio.size() > 0) {
                    retornoAutoComisorio = listaAutoComisorio.get(0);
                }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReintegroPagaduriaDAO");
        }
        return retornoAutoComisorio;

    }
    
    public String   siguienteNumeroAutoComisorio() throws ExcepcionDAO {
        Integer i;
        String  consecutivo=null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT max(a.aucNumero) FROM SiiAutoComisorio a");
            Query query = manager.createQuery(sql.toString());
            i = (Integer) query.getSingleResult();
            if (i == null) {
                return "00";
            }
            else 
                return consecutivo= Integer.toString(i + 1) ;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
       
    }
    
    public List<SiiAutoComisorio> buscarAutoComisorioPorTipoVisitaYCodigoContrato (String tipoVisita, Long conCodigo) throws ExcepcionDAO{
        List<SiiAutoComisorio> listaAutoComisorio = null;
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ac FROM SiiAutoComisorio ac" +
                " where ac.aucTipoVisita = :tipoVisita and ac.siiContrato.conCodigo = :conCodigo" +
                " order by ac desc");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoVisita", tipoVisita);
            query.setParameter("conCodigo", conCodigo);
            listaAutoComisorio = query.getResultList();
            
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ContratoDAO");
        }
        return listaAutoComisorio;
    }
}
