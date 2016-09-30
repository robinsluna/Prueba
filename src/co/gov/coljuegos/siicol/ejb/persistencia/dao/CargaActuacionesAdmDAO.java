package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierreAnualCont;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CargaActuacionesAdmDAO extends GenericDAO<SiiCargaActuacionesAdm> {
    public CargaActuacionesAdmDAO()
    {
        super(SiiCargaActuacionesAdm.class);
    }
    
    
    public List<SiiCargaActuacionesAdm> buscarNumReSolucionFechaActAdm(Long numResolucion ,Date fechaActAdm) throws ExcepcionDAO {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT c FROM SiiCargaActuacionesAdm c");
            sql.append(" where c.caaNumResolucion = :numResolucion  and c.caaFechaResoluc = :fechaActAdm");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("numResolucion", numResolucion);
            query.setParameter("fechaActAdm", fechaActAdm);
            List<SiiCargaActuacionesAdm> listaSiiCargaActuacionesAdm = query.getResultList();
            
            return listaSiiCargaActuacionesAdm;
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
      
    }
    public SiiCargaActuacionesAdm buscarCuotaOperadorXActtAdm(Long copCodigo) throws ExcepcionDAO {
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT c FROM SiiCuotaOperador cop");
            sql.append(" inner join siiCargaActuacionesAdm c");
            sql.append(" where cop.copCodigo = :copCodigo");
            Query query = em.createQuery(sql.toString());
            query.setParameter("copCodigo", copCodigo);
            
            List<SiiCargaActuacionesAdm> listaSiiCargaActuacionesAdm = query.getResultList();
            
            return listaSiiCargaActuacionesAdm.get(0);
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
      
    }
    
    public Integer buscarConsecutivoCargaActuacionesAdm() throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(MAX(p.caa_consecutivo)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'000001')) ");
            sql.append("FROM sii_carga_actuaciones_adm p "); 
            sql.append("WHERE p.caa_consecutivo LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            Query query = em.createNativeQuery(sql.toString());
         
            if(query.getSingleResult() != null){
                consecutivo = new Integer(((BigDecimal)query.getSingleResult()).intValueExact());
            }
            
        }
        catch (javax.persistence.NoResultException ne) {
            consecutivo = null;
        }
        catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }

    public List<SiiCargaActuacionesAdm> buscarPersonasCargaActAdminPorNumeroId(String identificacion) throws ExcepcionDAO {
    List<SiiCargaActuacionesAdm> resultado = null;

    if(identificacion != null) {

    try {

    StringBuilder sql = new StringBuilder();
    sql.append("SELECT o FROM SiiCargaActuacionesAdm o ");
    sql.append("WHERE o.siiPersona.perNumIdentificacion = :identificacion ");

    Query query = em.createQuery(sql.toString());
    query.setParameter("identificacion", identificacion);

    resultado = query.getResultList();

    } catch(PersistenceException pe) {
    String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
    throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
    } catch(Exception e) {
    throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
    }
    }

    return (resultado);
    }    
}



