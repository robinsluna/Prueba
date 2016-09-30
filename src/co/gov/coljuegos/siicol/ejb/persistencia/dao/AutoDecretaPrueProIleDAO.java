package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoDecretaPrueProIle;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo del Auto que Decreta Pruebas en un Proceso Sancionatorio de Ilegalidad.
 * Utilizado para los siguientes Tipos de Auto: 
 * <li>DECRETA PRUEBAS</li>
 * <li>NIEGA PRUEBAS</li>
 * <li>TRASLADO PARA ALEGATOS</li>
 * 
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class AutoDecretaPrueProIleDAO  extends AbstractDAO<Long, SiiAutoDecretaPrueProIle>
{
    /**
     * Constructor.
     */
    public AutoDecretaPrueProIleDAO() 
    {
        super(SiiAutoDecretaPrueProIle.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Autos que Decretan Pruebas que se encuentran asociados al Proceso Sancionatorio de Ilegalidad especificado.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiAutoDecretaPrueProIle.
     * @throws ExcepcionDAO
     */
    public List<SiiAutoDecretaPrueProIle> buscarAutoDecretaPrueProIlePorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarAutoDecretaPrueProIlePorProcesoYTipoAuto(prsCodigo, null) );
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los Autos que Decretan Pruebas que se encuentran asociados al Proceso y Tipo de Auto especificado.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @param atpTipoAuto - Tipo de Auto (D=DECRETA PRUEBAS, N=NIEGA PRUEBAS, T=TRASLADO PARA ALEGATOS).
     * @return Listado de SiiAutoDecretaPrueProIle.
     * @throws ExcepcionDAO
     */
    public List<SiiAutoDecretaPrueProIle> buscarAutoDecretaPrueProIlePorProcesoYTipoAuto (Long prsCodigo, String atpTipoAuto) throws ExcepcionDAO 
    {
        List<SiiAutoDecretaPrueProIle> resultado = null;
        
        if (prsCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT atp FROM SiiAutoDecretaPrueProIle atp ");
                sql.append("WHERE atp.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");
                
                if (atpTipoAuto!=null)
                    sql.append("AND atp.atpTipoAuto = :atpTipoAuto ");
                
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);
                
                if (atpTipoAuto!=null)
                    query.setParameter("atpTipoAuto", atpTipoAuto);
                
                
                resultado = query.getResultList();
                
            }
            catch(PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch(Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
