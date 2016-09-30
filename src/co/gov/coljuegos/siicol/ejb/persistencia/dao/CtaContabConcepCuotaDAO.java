/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-10-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCtaContabConcepCuota;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class CtaContabConcepCuotaDAO extends GenericDAO<SiiCtaContabConcepCuota>
{
    /**
     * Constructor.
     */
    public CtaContabConcepCuotaDAO() 
    {
        super(SiiCtaContabConcepCuota.class);
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros asociados al Concepto Cuota especificado.
     * @param ccuCodigo - C&oacute;digo del Concepto Cuota.
     * @return Lista de Cuentas Contables Concepto Cuota asociadas al Concepto Cuota.
     * @throws ExcepcionDAO
     */
    public List<SiiCtaContabConcepCuota> buscarCuentasContablesPorIdConceptoCuota (Long ccuCodigo) throws ExcepcionDAO 
    {
        return (this.buscarCCCPorConceptoCuotaYCuentaContable(ccuCodigo, null));
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de los registros asociados al Concepto Cuota y a la Cuenta Contable especificadas.
     * @param ccuCodigo - C&oacute;digo del Concepto Cuota.
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable.
     * @return Lista de Cuentas Contables Concepto Cuota asociadas al Concepto Cuota y a la Cuenta Contable.
     * @throws ExcepcionDAO
     */
    private List<SiiCtaContabConcepCuota> buscarCCCPorConceptoCuotaYCuentaContable (Long ccuCodigo, Long ccoCodigo) throws ExcepcionDAO 
    {
        List<SiiCtaContabConcepCuota> resultado = null;
        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT c FROM SiiCtaContabConcepCuota c ");
            sql.append("WHERE c.siiConceptoCuota.ccuCodigo = :ccuCodigo ");
            
            if (ccoCodigo!=null)
                sql.append("AND c.siiCuentasContables.ccoCodigo = :ccoCodigo ");
            
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("ccuCodigo", ccuCodigo);
            
            if (ccoCodigo!=null)
                query.setParameter("ccoCodigo", ccoCodigo);
            
            resultado = query.getResultList();
        }
        catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Obtiene el registro asociado al Concepto Cuota y Cuenta Contable especificados.
     * @param ccuCodigo - C&oacute;digo del Concepto Cuota.
     * @param ccoCodigo - C&oacute;digo de la Cuenta Contable.
     * @return Registro de Cuenta Contable Concepto Cuota.
     * @throws ExcepcionDAO
     */
    public SiiCtaContabConcepCuota buscarPorConceptoCuotaYCuentaContable (Long ccuCodigo, Long ccoCodigo) throws ExcepcionDAO 
    {
        SiiCtaContabConcepCuota resultado = null;
        List<SiiCtaContabConcepCuota> lista = this.buscarCCCPorConceptoCuotaYCuentaContable(ccuCodigo, ccoCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = lista.get(0);
        }
        
        return (resultado);
    }
}
