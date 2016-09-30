package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoFormCargProIle;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class AutoFormCargProIleDAO extends AbstractDAO<Long,SiiAutoFormCargProIle>{
    public AutoFormCargProIleDAO() {
        super(SiiAutoFormCargProIle.class);
    }
    
    
    /**
     * Realiza la consulta de los registros de Auto Formulaci&oacute;n Cargos asociados al Proceso Sancionatorio de Ilegalidad.
     * @param prsCodigo - C&oacute;digo del Proceso Sancionatorio de Ilegalidad.
     * @return Listado de SiiAutoFormCargProIle.
     * @throws ExcepcionDAO
     */
    public List<SiiAutoFormCargProIle> buscarAutoFormCargProIlePorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO 
    {
        List<SiiAutoFormCargProIle> resultado = null;
        
        if (prsCodigo!=null) {
            try {
                
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT afc FROM SiiAutoFormCargProIle afc ");
                sql.append("WHERE afc.siiProcesoSancIlegalidad.prsCodigo = :prsCodigo ");
                
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
    
    public BigDecimal valorTotalSancionPorAutoFormulacionCargos(Long afcCodigo) throws ExcepcionDAO {
        BigDecimal i = BigDecimal.ZERO;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sum(nvl(eac.eac_valor_sancion,0))\n" + 
            "FROM sii_auto_form_carg_pro_ile afc\n" + 
            "INNER JOIN sii_elemento_auto_form_car_ile eac\n" + 
            "ON afc.AFC_CODIGO = eac.AFC_CODIGO\n" + 
            "where eac.eac_activo = 'S'\n" + 
            "and eac.afc_codigo = :afcCodigo");
            Query query = em.createNativeQuery(sql.toString());
            query.setParameter("afcCodigo", afcCodigo);
            i = ((BigDecimal) query.getSingleResult());

        }  catch (PersistenceException pe) {
            throw new ExcepcionDAO("Error general de base de datos : " + pe.getMessage(), getClass().getSimpleName(), pe);
        }
        
        return i;
        
    }
}
