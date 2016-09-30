package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProcSan;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


/**
 * Data Access Object para el manejo de Tr&aacute;mites de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class TramiteResolProcSanDAO extends AbstractDAO<Long, SiiTramiteResolProcSan> 
{
    /**
     * Constructor.
     */
    public TramiteResolProcSanDAO() 
    {
        super(SiiTramiteResolProcSan.class);
    }
    
    
    /**
     * Realiza la b&uacute;squeda de los Tr&aacute;mites de Resoluci&oacute;n de Proceso Sancionatorio asociados a la Resoluci&oacute;n especificada.
     * @param repCodigo - C&oacute;digo de la Resoluci&oacute;n de Proceso Sancionatorio.
     * @return List of SiiTramiteResolProcSan.
     * @throws ExcepcionDAO
     */
    public List<SiiTramiteResolProcSan> buscarTramiteResolProcSanPorIdResolucion (Long repCodigo) throws ExcepcionDAO
    {
        List<SiiTramiteResolProcSan> resultado = null;
        
        if (repCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT trp FROM SiiTramiteResolProcSan trp ");
                sql.append("WHERE trp.siiResolucionProcSanc.repCodigo = :repCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("repCodigo", repCodigo);
                
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
