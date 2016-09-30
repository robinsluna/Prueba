/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GESTIÓN CONTRACTUAL
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-08-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolSanCon;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * DAO para el manejo de Tr&aacute;mites de Resoluci&oacute;n con Sanci&oacute;n.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class TramiteResolSanConDAO extends AbstractDAO<Long, SiiTramiteResolSanCon> 
{
    /**
     * Constructor.
     */
    public TramiteResolSanConDAO() {
        super(SiiTramiteResolSanCon.class);
    }
    
    
    /**
     * Obtiene el listado de Tr&aacute;mites de Resoluci&oacute;n Sin Sanci&oacute;n, que se encuentran asociados a la Resoluci&oacute;n especificada.
     * @param rcoCodigo - C&oacute;digo de la Resoluci&oacute;n.
     * @return List of SiiTramiteResolSanCon.
     * @throws ExcepcionDAO
     */
    public List<SiiTramiteResolSanCon> buscarTramiteResolSanConPorIdResolucion (Long rcoCodigo) throws ExcepcionDAO 
    {
        List<SiiTramiteResolSanCon> resultado = null;
        
        if (rcoCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT trs FROM SiiTramiteResolSanCon trs ");
                sql.append("WHERE trs.siiResolucionIncumContr.rcoCodigo = :rcoCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("rcoCodigo", rcoCodigo);
                
                resultado = query.getResultList();
            }
            catch(PersistenceException pe){
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, this.getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
