/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import co.gov.coljuegos.siicol.ejb.vo.MetVO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona auditor de orden de trabajo
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class AuditorOrdenTrabDAO extends AbstractDAO<Long, SiiAuditorOrdenTrab>{
    
    /**
     * Constructor
     */
    public AuditorOrdenTrabDAO() {
        super(SiiAuditorOrdenTrab.class);
    }
    
    /**
     * Buscar todos los auditores por código de orden de trabajo de visita.
     * @param codOrdenTrab
     * @return listaAuditorOrdenTra - Lista de los auditores por código de trabajo de visita.
     * @throws ExcepcionDAO
     */
    public List<SiiAuditorOrdenTrab> buscarTodoAuditorXOrdenTrab(Long codOrdenTrab) throws ExcepcionDAO {
        List<SiiAuditorOrdenTrab> listaAuditorOrdenTra = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT aot FROM SiiAuditorOrdenTrab aot");
            sql.append(" WHERE aot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrab and aot.aotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrab", codOrdenTrab);
            listaAuditorOrdenTra = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AuditorOrdenTrabDAO");
        }
        return listaAuditorOrdenTra;

    } 
    
    /**
     * Indica si un funcionario está asignado en una orden de trabajo.
     * @param suaCodigo
     * @return true:false
     * @throws ExcepcionDAO
     */
    
    public boolean isAsignado(Long suaCodigo) throws ExcepcionDAO {
        List<SiiAuditorOrdenTrab> listaAuditorOrdenTra = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT aot FROM SiiAuditorOrdenTrab aot");
            sql.append(" WHERE aot.siiSustanciadorAuditor.suaCodigo = :suaCodigo and aot.aotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("suaCodigo", suaCodigo);
            listaAuditorOrdenTra = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AuditorOrdenTrabDAO");
        }
        
        return listaAuditorOrdenTra.size()>0 ? true:false;

    }
}
