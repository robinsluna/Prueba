package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoProcesoTerminosProcesales;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosProcesales;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejko de T&eacute;rminos Procesales.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class TerminosProcesalesDAO extends AbstractDAO<Long, SiiTerminosProcesales> 
{
    /**
     * Constructor.
     */
    public TerminosProcesalesDAO() 
    {
        super(SiiTerminosProcesales.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los T&eacute;rminos Procesales asociados al Estado del Proceso Sancionatorio de Fiscalizaci&oacute;n especificado.
     * @param epsCodigo - C&oacute;digo del Estado del Proceso Sancionatorio de Fiscalizaci&oacute;n.
     * @return Listado de SiiTerminosProcesales.
     * @throws ExcepcionDAO
     */
    public SiiTerminosProcesales buscarTerminoProcesalFiscalizacionPorEstadoProceso (Long epsCodigo) throws ExcepcionDAO
    {
        SiiTerminosProcesales resultado = null;
        
        if (epsCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT tpr FROM SiiTerminosProcesales tpr ");
                sql.append("WHERE tpr.tprProceso = :tprProceso ");
                sql.append("AND tpr.siiEstadoProcesoSanc.epsCodigo = :epsCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("tprProceso", EnumTipoProcesoTerminosProcesales.FISCALIZACION.getId());
                query.setParameter("epsCodigo", epsCodigo);
                
                resultado = (SiiTerminosProcesales) query.getSingleResult();
                
            }
            catch (NoResultException ne) {
                resultado = null;
                //ne.printStackTrace();
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
    
    
    
    /**
     * Realiza la b&uacute;squeda de los T&eacute;rminos Procesales asociados al Estado del Proceso Sancionatorio de Ilegalidad especificado.
     * @param epiCodigo - C&oacute;digo del Estado del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiTerminosProcesales.
     * @throws ExcepcionDAO
     */
    public SiiTerminosProcesales buscarTerminoProcesalIlegalidadPorEstadoProceso (Long epiCodigo) throws ExcepcionDAO
    {
        SiiTerminosProcesales resultado = null;
        
        if (epiCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT tpr FROM SiiTerminosProcesales tpr ");
                sql.append("WHERE tpr.tprProceso = :tprProceso ");
                sql.append("AND tpr.siiEstadoProcSanIleg.epiCodigo = :epiCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("tprProceso", EnumTipoProcesoTerminosProcesales.ILEGALIDAD.getId());
                query.setParameter("epiCodigo", epiCodigo);
                
                resultado = (SiiTerminosProcesales) query.getSingleResult();
                
            }
            catch (NoResultException ne) {
                resultado = null;
                //ne.printStackTrace();
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
