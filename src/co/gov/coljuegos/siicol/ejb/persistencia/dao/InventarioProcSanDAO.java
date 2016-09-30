/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventarioProcSan;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object que gestiona el inventario del proceso sancionatorio.
 * @author PAOLA ANDREA RUEDA LEÓN
 */
@Stateless
@LocalBean
public class InventarioProcSanDAO extends AbstractDAO<Long, SiiInventarioProcSan> {

    /**
     * Constructor.
     */
    public InventarioProcSanDAO() {
        super(SiiInventarioProcSan.class);
    }
    
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Inventario <i>ACTIVOS</i> del Proceso Sancionatorio por medio del c&oacute;digo del Proceso Sancionatorio.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
     * @return Listado de relaciones de Inventario con Proceso Sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<SiiInventarioProcSan> buscarInventarioProcSanPorIdProceso (Long psaCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarInventarioProcSanPorIdProceso(psaCodigo, true) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Inventario del Proceso Sancionatorio por medio del c&oacute;digo del Proceso Sancionatorio.
     * @param psaCodigo - C&oacute;digo del Proceso Sancionatorio.
     * @param soloActivos - Flag que determina si s&oacute;lo se deben obtener los registros en estado ACTIVO.
     * @return Listado de relaciones de Inventario con Proceso Sancionatorio.
     * @throws ExcepcionDAO
     */
    public List<SiiInventarioProcSan> buscarInventarioProcSanPorIdProceso (Long psaCodigo, boolean soloActivos) throws ExcepcionDAO 
    {
        List<SiiInventarioProcSan> resultado = null;
        
        if (psaCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT ips FROM SiiInventarioProcSan ips ");
                sql.append("WHERE ips.siiProcesoSancionatorio.psaCodigo = :psaCodigo ");
                
                if (soloActivos)
                    sql.append("AND ips.ipsActivo = :ipsActivo ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("psaCodigo", psaCodigo);
                
                if (soloActivos)
                    query.setParameter("ipsActivo", EnumDecision.SI.getId());
                
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
