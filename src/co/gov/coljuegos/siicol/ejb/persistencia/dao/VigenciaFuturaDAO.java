/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVigenciaFutura;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class VigenciaFuturaDAO extends GenericDAO<SiiVigenciaFutura> 
{   
    /**
     * Constuctor.
     */
    public VigenciaFuturaDAO() 
    {
        super(SiiVigenciaFutura.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de Vigencias Futuras por Estado de la misma.
     * @param vfuEstado - Estado de la Vigencia.
     * @return List of SiiVigenciaFutura.
     * @throws ExcepcionDAO
     */
    public List<SiiVigenciaFutura> buscarVigenciaFuturaPorEstado (String vfuEstado) throws ExcepcionDAO
    {
        List<SiiVigenciaFutura> resultado = null;
        
        if (vfuEstado!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT v FROM SiiVigenciaFutura v ");
                sql.append("WHERE v.vfuEstado = :vfuEstado ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("vfuEstado", vfuEstado);
                
                resultado = query.getResultList();
            }
            catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
