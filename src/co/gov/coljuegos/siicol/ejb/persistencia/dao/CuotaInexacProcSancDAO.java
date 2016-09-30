/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaInexacProcSanc;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona la cuota inexacta de los procesos sancionatorios.
 * @author PAOLA ANDREAR RUEDA LEÓN
 */

@Stateless
@LocalBean
public class CuotaInexacProcSancDAO extends AbstractDAO<Long, SiiCuotaInexacProcSanc>{
    
    /**
     * Constructor.
     */
    public CuotaInexacProcSancDAO() {
        super(SiiCuotaInexacProcSanc.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Cuotas de Inexactitud que se encuentran asociadas al Proceso Sancionatorio especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
     * @return Listado de SiiCuotaInexacProcSanc.
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaInexacProcSanc> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO
    {
        return ( this.buscarCuotaInexacProcSancPorIdProcesoSancionatorio(psaCodigo, true) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de las Cuotas de Inexactitud que se encuentran asociadas al Proceso Sancionatorio especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
     * @param soloActivos - Flag que determina si s&oacute;lo se deben obtener los registros en estado <i>ACTIVO</i>.
     * @return Listado de SiiCuotaInexacProcSanc.
     * @throws ExcepcionDAO
     */
    public List<SiiCuotaInexacProcSanc> buscarCuotaInexacProcSancPorIdProcesoSancionatorio (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO
    {
        List<SiiCuotaInexacProcSanc> resultado = null;
        
        if (psaCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cip FROM SiiCuotaInexacProcSanc cip ");
                sql.append("WHERE cip.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                if (soloActivos)
                    sql.append("AND cip.cipActivo = :cipActivo ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo);
                
                if (soloActivos)
                    query.setParameter("cipActivo", EnumDecision.SI.getId());
                
                
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
