/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcSan;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona el descargo de los procesos sancionatorios.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class DescargoProcSanDAO extends AbstractDAO<Long, SiiDescargoProcSan>{
    
    /**
     * Constructor
     */
    public DescargoProcSanDAO() {
        super(SiiDescargoProcSan.class);
    }
    
    
    /**
     * Obtiene el listado de Descargos asociados al Proceso Sancionatorio de Fiscalizaci&oacute;n correspondiente al ID especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @return Listado de SiiDescargoProcSan.
     * @throws ExcepcionDAO
     */
    public List<SiiDescargoProcSan> buscarDescargoProcSanPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<SiiDescargoProcSan> resultado = null;
        
        if (psaCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dps FROM SiiDescargoProcSan dps ");
                sql.append("WHERE dps.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch (Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
