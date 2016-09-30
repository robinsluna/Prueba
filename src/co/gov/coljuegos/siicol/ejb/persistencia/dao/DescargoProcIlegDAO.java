package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcIleg;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class DescargoProcIlegDAO  extends AbstractDAO<Long,SiiDescargoProcIleg>
{
    /**
     * Constructor.
     */
    public DescargoProcIlegDAO() 
    {
        super(SiiDescargoProcIleg.class);
    }
    
    
    
    /**
     * Obtiene el listado de Descargos asociados al Proceso Sancionatorio de Ilegalidad correspondiente al c&oacute;digo suministrado.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiDescargoProcIleg.
     * @throws ExcepcionDAO
     */
    public List<SiiDescargoProcIleg> buscarDescargoProcIlegPorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO 
    {
        List<SiiDescargoProcIleg> resultado = null;
        
        if (prsCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT dpr FROM SiiDescargoProcIleg dpr ");
                sql.append("WHERE dpr.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");
                
                Query query = em.createQuery(sql.toString());
                query.setParameter("prsCodigo", prsCodigo);
                
                resultado = query.getResultList();
                
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            }
            catch (Exception e) {
                throw new ExcepcionDAO("Error general de base de datos : " + e.getMessage(), getClass().getSimpleName(), e);
            }
        }
        
        return (resultado);
    }
}
