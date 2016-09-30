/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 11-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenTrabajoVisita;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object para el manejo de las órdenes de trabajo de visitas
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class OrdenTrabajoVisitaDAO extends AbstractDAO<Long, SiiOrdenTrabajoVisita> {
    private Recursos recursos;
    
    /**
     * Constructor
     */
    public OrdenTrabajoVisitaDAO () {
        super(SiiOrdenTrabajoVisita.class);
    }
    
    /**
     * Buscar todas las ordenes de trabajo
     * @return listaSiiOrdenTrabajoVisita - lista de todas las órdenes de trabajo.
     * @throws ExcepcionDAO
     */
    public List<SiiOrdenTrabajoVisita> buscarTodoOrdenTrabajoVisita() throws ExcepcionDAO {
        List<SiiOrdenTrabajoVisita> listaSiiOrdenTrabajoVisita= null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select otv_numero, otv_fecha, otv_fecha_inicio, otv_fecha_final, otv_estado from sii_orden_trabajo_visita;" );
            Query query = em.createQuery(sql.toString());
            listaSiiOrdenTrabajoVisita = query.getResultList();
            return listaSiiOrdenTrabajoVisita;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
        
    } 
    
    
    /**
     * Obtiene el número consecutivo para la orden de trabajo
     * @return consecutivo
     * @throws ExcepcionDAO
     */
    public Integer obtenerConsecutivoOrdenTrabajoVisita () throws ExcepcionDAO 
    {
        Integer consecutivo = null;
        
        try{
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT NVL(MAX(otv.OTV_NUMERO)+1, TO_NUMBER(TO_CHAR(CURRENT_DATE,'yy')||'0001')) ");
            sql.append("FROM SII_ORDEN_TRABAJO_VISITA otv "); 
            sql.append("WHERE otv.OTV_NUMERO LIKE ''||TO_CHAR(CURRENT_DATE,'yy')||'%' ");
            
            Query query = em.createNativeQuery(sql.toString());
            
            Object result = query.getSingleResult();
            if(result != null){
                consecutivo = new Integer(((BigDecimal)result).intValueExact());
            }
            
        }
        catch (NoResultException e) {
            consecutivo = null;
        }
        catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (consecutivo);
    }
    
    public List<SiiOrdenTrabajoVisita> buscarOrdenTrabajoXEstadoAprobado(Long perCodigo) throws ExcepcionDAO {
        List<SiiOrdenTrabajoVisita> listaSiiOrdenTrabajoVisita = null;
           try {
             
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT distinct o FROM SiiAuditorOrdenTrab a ");
            sql.append(" inner join  a.siiOrdenTrabajoVisita o ");      
            sql.append(" inner join  a.siiSustanciadorAuditor su ");
            sql.append(" inner join  su.siiPersona p ");
            sql.append(" where o.otvEstado = 'A' and p.perCodigo =:perCodigo ");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("perCodigo", perCodigo);
            listaSiiOrdenTrabajoVisita = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiOrdenTrabajoVisita;
    }

    public List<SiiOrdenTrabajoVisita> buscarOrdenesTrabajoAprobadas() throws ExcepcionDAO {
        List<SiiOrdenTrabajoVisita> listaSiiOrdenTrabajoVisita = null;
           try {
             
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT distinct o FROM SiiAuditorOrdenTrab a ");
            sql.append(" inner join  a.siiOrdenTrabajoVisita o ");      
            sql.append(" inner join  a.siiSustanciadorAuditor su ");
            sql.append(" where o.otvEstado = 'A' ");
            
            Query query = em.createQuery(sql.toString());
            listaSiiOrdenTrabajoVisita = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiOrdenTrabajoVisita;
    }


    public SiiOrdenTrabajoVisita buscarOrdenTrabajoXId(Long idOrden) throws ExcepcionDAO {
        SiiOrdenTrabajoVisita retornoOrdenTrabajo = null;
        try {
            retornoOrdenTrabajo = (SiiOrdenTrabajoVisita) em.find(SiiOrdenTrabajoVisita.class, idOrden);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OrdenTrabajoVisitaDAO");
        }
        return retornoOrdenTrabajo;

    }
    
}
