/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-08-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionIncumContr;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * DAO para el manejo de Resoluciones de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ResolucionIncumContrDAO extends AbstractDAO<Long, SiiResolucionIncumContr>
{
    /**
     * Constructor.
     */
    public ResolucionIncumContrDAO () 
    {
        super(SiiResolucionIncumContr.class);
    }
    
    
    /**
     * Obtiene el listado de Resoluciones de Incumplimiento Contractual asociadas al Estado de Tr&aacute;mite especificado.
     * @param ersCodigo - C&oacute;digo del Estado del Tr&aacute;mite de Resoluci&oacute;n.
     * @return List of SiiResolucionIncumContr.
     * @throws ExcepcionDAO
     */
    public List<SiiResolucionIncumContr> buscarResolucionIncumContrPorEstadoTramite (Long ersCodigo) throws ExcepcionDAO
    {
        return ( this.buscarResolucionIncumContrPorEstadoTramEInterponeRecurso(ersCodigo, null) );
    }
    
    
    
    /**
     * Obtiene el listado de Resoluciones de Incumplimiento Contractual asociadas al Estado de Tr&aacute;mite e Indicador de Repone Recurso especificados.
     * @param ersCodigo - C&oacute;digo del Estado del Tr&aacute;mite de Resoluci&oacute;n.
     * @param rcoReponeRecurso - Indicador Repone Recurso.
     * @return List of SiiResolucionIncumContr.
     * @throws ExcepcionDAO
     */
    public List<SiiResolucionIncumContr> buscarResolucionIncumContrPorEstadoTramEInterponeRecurso (Long ersCodigo, String rcoReponeRecurso) throws ExcepcionDAO
    {
        List<SiiResolucionIncumContr> resultado = null;
        
        if (ersCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT rco FROM SiiResolucionIncumContr rco, ");
                sql.append("                SiiTramiteResolSanCon trs, ");
                sql.append("                SiiEstadoResolucSanCon ers ");
                sql.append("WHERE trs.siiResolucionIncumContr.rcoCodigo = rco.rcoCodigo ");
                sql.append("AND trs.siiEstadoResolucSanCon.ersCodigo = ers.ersCodigo ");
                sql.append("AND ers.ersCodigo = :ersCodigo ");
                
                if (rcoReponeRecurso!=null)
                    sql.append("AND rco.rcoReponeRecurso = :rcoReponeRecurso ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("ersCodigo", ersCodigo);
                
                if (rcoReponeRecurso!=null)
                    query.setParameter("rcoReponeRecurso", rcoReponeRecurso);
                
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
