package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPoblacionEnte;

import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class PoblacionEnteDAO extends AbstractDAO<Long, SiiPoblacionEnte> 
{
    public PoblacionEnteDAO(){
        super(SiiPoblacionEnte.class);
    }
    
    public SiiPoblacionEnte buscarEnteTerritorialPorId (Long eti_codigo) throws ExcepcionDAO {
        SiiPoblacionEnte siiPoblacionEnte = null;
        try {
            siiPoblacionEnte =  em.find(SiiPoblacionEnte.class, eti_codigo); 
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SiiPoblacionEnteDAO");
        }
        return siiPoblacionEnte;

    }
    
    public List<SiiPoblacionEnte> buscarPoblacionPorCargaPoblacion(Date fecha) throws ExcepcionDAO {
        List<SiiPoblacionEnte> lista = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiPoblacionEnte o WHERE o.penFechaFin = :fecha ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            lista = query.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
        }
        return lista;

    }
    
    
    /**
     * Obtiene el listado de Poblaci&oacute;n Ente vigentes, asociado al Ente Territorial especificado.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @return Listado de SiiPoblacionEnte.
     * @throws ExcepcionDAO
     */
    public List<SiiPoblacionEnte> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo) throws ExcepcionDAO 
    {
        return ( this.buscarPoblacionEntePorIdEnteTerritorial(etiCodigo, true) );
    }
    
    
    
    /**
     * Obtiene el listado de Poblaci&oacute;n Ente vigente, asociado al Ente Territorial especificado.
     * @param etiCodigo - C&oacute;digo del Ente Territorial.
     * @param soloVigentes - Flag que determina si &uacute;nicamente deben obtenerse los registros que se encuentren vigentes respecto a la fecha actual.
     * @return Listado de SiiPoblacionEnte.
     * @throws ExcepcionDAO
     */
    public List<SiiPoblacionEnte> buscarPoblacionEntePorIdEnteTerritorial (Long etiCodigo, boolean soloVigentes) throws ExcepcionDAO 
    {
        List<SiiPoblacionEnte> resultado = null;
        
        if (etiCodigo!=null) {
            try {
                
                Date fechaActual = Utilidades.truncDate(new Date());
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT pen from SiiPoblacionEnte pen ");
                sql.append("WHERE pen.siiEnteTerritorial.etiCodigo = :etiCodigo ");
                
                if (soloVigentes) {
                    sql.append("AND FUNC('TRUNC', pen.penFechaIni) >= :fechaActual ");
                    sql.append("AND FUNC('TRUNC', pen.penFechaFin) <= :fechaActual ");
                }
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("etiCodigo", etiCodigo);
                
                if (soloVigentes)
                    query.setParameter("fechaActual", fechaActual);
                
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "CuentaContTipoDocContDAO");
            }
            catch (Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
