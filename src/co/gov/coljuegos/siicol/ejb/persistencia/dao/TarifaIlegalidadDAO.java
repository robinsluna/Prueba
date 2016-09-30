package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTarifaIlegalidad;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class TarifaIlegalidadDAO extends AbstractDAO<Long, SiiTarifaIlegalidad> 
{
    /**
     * Constructor.
     */
    public TarifaIlegalidadDAO() 
    {
        super(SiiTarifaIlegalidad.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de la Tarifa de Ilegalidad asociada a la Clase de Juego y Tipo de Instrumento especificados.
     * @param cjuCodigo - C&oacute;digo de la Clase de Juego.
     * @param tinCodigo - C&oacute;digo del Tipo de Instrumento.
     * @return Tarifa de Ilegalidad correspondiente a los par&aacute;metros suministrados.
     * @throws ExcepcionDAO
     */
    public List<SiiTarifaIlegalidad> buscarTarifaIlegalidadPorClaseJuegoTipoInstrumento (Long cjuCodigo, Long tinCodigo) throws ExcepcionDAO 
    {
        List<SiiTarifaIlegalidad> resultado = null;
        
        if (cjuCodigo!=null) {
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT tle FROM SiiTarifaIlegalidad tle ");
                sql.append("WHERE tle.siiClaseJuego.cjuCodigo = :cjuCodigo ");
                
                if (tinCodigo!=null)
                    sql.append("AND tle.siiTipoInstrumento.tinCodigo = :tinCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("cjuCodigo", cjuCodigo);
                
                if (tinCodigo!=null)
                    query.setParameter("tinCodigo", tinCodigo);
                
                
                resultado = query.getResultList();
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch (Exception ex) {
                ex.printStackTrace();
                throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
            }
        }
        
        return (resultado);
    }
}
