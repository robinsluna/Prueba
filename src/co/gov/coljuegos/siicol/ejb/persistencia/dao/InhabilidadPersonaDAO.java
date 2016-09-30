package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoProcesoGCT;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInhabilidadPersona;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Inhabilidad Persona.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class InhabilidadPersonaDAO extends AbstractDAO<Long, SiiInhabilidadPersona>
{
    /**
     * Constructor.
     */
    public InhabilidadPersonaDAO() 
    {
        super(SiiInhabilidadPersona.class);
    }
    
    
    
    /**
     * Busca el registro de Inhabilidad asociado al c&oacute;digo de la Persona especificado.
     * @param perCodigo - C&oacute;digo de la Persona.
     * @return Registro de Inhabilidad Persona.
     * @throws ExcepcionDAO
     */
    public List<SiiInhabilidadPersona> buscarInhabilidadPersonaPorIdPersona (Long perCodigo) throws ExcepcionDAO {
        List<SiiInhabilidadPersona> resultado = null;
        
        if (perCodigo!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ipe FROM SiiInhabilidadPersona ipe ");
                sql.append("WHERE ipe.siiPersona.perCodigo = :perCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("perCodigo", perCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName(), ex);
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Busca el registro de Inhabilidad asociado al c&oacute;digo de la Persona y el Tipo de Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @param perCodigo - C&oacute;digo de la Persona.
     * @param idProceso - C&oacute;digo del Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @param tipoProceso - Tipo de Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @return Registro de Inhabilidad Persona.
     * @throws ExcepcionDAO
     */
    public SiiInhabilidadPersona buscarInhabilidadPersonaPorIdPersonaYTipoProceso (Long perCodigo, Long idProceso, Long tipoProceso) throws ExcepcionDAO 
    {
        return ( this.buscarInhabilidadPersonaPorIdPersonaYTipoProceso(perCodigo, idProceso, tipoProceso, false) );
    }
    
    
    /**
     * Busca el registro de Inhabilidad asociado al c&oacute;digo de la Persona y el Tipo de Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @param perCodigo - C&oacute;digo de la Persona.
     * @param idProceso - C&oacute;digo del Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @param tipoProceso - Tipo de Proceso (Incumplimiento/Fiscalizaci&oacute;n/Ilegalidad).
     * @param soloActivos - Flag que determina si s&oacute;lo se deben obtener los registros en estado <i>ACTIVO</i>.
     * @return Registro de Inhabilidad Persona.
     * @throws ExcepcionDAO
     */
    public SiiInhabilidadPersona buscarInhabilidadPersonaPorIdPersonaYTipoProceso (Long perCodigo, Long idProceso, Long tipoProceso, boolean soloActivos) throws ExcepcionDAO 
    {
        SiiInhabilidadPersona resultado = null;
        
        if (perCodigo!=null && idProceso!=null && tipoProceso!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ipe FROM SiiInhabilidadPersona ipe ");
                sql.append("WHERE ipe.siiPersona.perCodigo = :perCodigo ");
                
                if (soloActivos)
                    sql.append("AND ipe.ipeActivo = :ipeActivo ");
                
                
                if (EnumTipoProcesoGCT.INCUMPLIMIENTO_CONTRACTUAL.getId().equals(tipoProceso)) 
                    sql.append("AND ipe.siiIncumplimientoContr.icnCodigo = :idProceso ");
                else if (EnumTipoProcesoGCT.SANCIONATORIO_FISCALIZACION.getId().equals(tipoProceso)) 
                    sql.append("AND ipe.siiProcesoSancionatorio.psaCodigo = :idProceso ");
                else if (EnumTipoProcesoGCT.SANCIONATORIO_ILEGALIDAD.getId().equals(tipoProceso)) 
                    sql.append("AND ipe.siiProcesoSancIlegalidad.prsCodigo = :idProceso ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("perCodigo", perCodigo);
                query.setParameter("idProceso", idProceso);
                
                if (soloActivos)
                    query.setParameter("ipeActivo", EnumDecision.SI.getId());
                
                
                List<SiiInhabilidadPersona> lista = query.getResultList();
                if (lista!=null && !lista.isEmpty())
                    resultado = lista.get(0);
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName(), ex);
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Busca los registros de Inhabilidad Operador para el Proceso de Incumplimiento Contractual especificado.
     * @param icnCodigo - C&oacute;digo del Proceso de Incumplimiento Contractual.
     * @return Listado de SiiInhabilidadPersona asociados al Proceso.
     * @throws ExcepcionDAO
     */
    public List<SiiInhabilidadPersona> buscarInhabilidadPersonaPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO 
    {
        List<SiiInhabilidadPersona> resultado = null;
        
        if (icnCodigo!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ipe FROM SiiInhabilidadPersona ipe ");
                sql.append("WHERE ipe.siiIncumplimientoContr.icnCodigo = :icnCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("icnCodigo", icnCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName(), ex);
            }
        }
        
        return (resultado);
    }
    
    
    /**
     * Busca los registros de Inhabilidad Operador para el Proceso Sancionatorio de Fiscalizaci&oacute;n especificado.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @return Listado de SiiInhabilidadPersona asociados al Proceso.
     * @throws ExcepcionDAO
     */
    public List<SiiInhabilidadPersona> buscarInhabilidadPersonaPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO 
    {
        List<SiiInhabilidadPersona> resultado = null;
        
        if (psaCodigo!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ipe FROM SiiInhabilidadPersona ipe ");
                sql.append("WHERE ipe.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName(), ex);
            }
        }
        
        return (resultado);
    }
    
    /**
     * Busca los registros de Inhabilidad Operador para el Proceso Sancionatorio de Ilegalidad especificado.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiInhabilidadPersona asociados al Proceso.
     * @throws ExcepcionDAO
     */
    public List<SiiInhabilidadPersona> buscarInhabilidadPersonaPorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO 
    {
        List<SiiInhabilidadPersona> resultado = null;
        
        if (prsCodigo!=null) {
            
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ipe FROM SiiInhabilidadPersona ipe ");
                sql.append("WHERE ipe.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception ex) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName(), ex);
            }
        }
        
        return (resultado);
    }
}
