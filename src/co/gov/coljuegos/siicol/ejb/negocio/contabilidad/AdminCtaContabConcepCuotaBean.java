/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-10-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CtaContabConcepCuotaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCtaContabConcepCuota;
import co.gov.coljuegos.siicol.ejb.vo.CtaContabConcepCuotaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCtaContabConcepCuotaBean implements AdminCtaContabConcepCuota 
{
    @EJB
    private CtaContabConcepCuotaDAO ctaContabConcepCuotaDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminCtaContabConcepCuotaBean() { }
    
    
    
    @Override
    public List<CtaContabConcepCuotaVO> buscarCuentasContablesPorIdConceptoCuota(Long ccuCodigo) throws ExcepcionDAO 
    {
        List<CtaContabConcepCuotaVO> resultado = null;
        List<SiiCtaContabConcepCuota> lista = ctaContabConcepCuotaDao.buscarCuentasContablesPorIdConceptoCuota(ccuCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CtaContabConcepCuotaVO>();
            
            for (SiiCtaContabConcepCuota siiCtaContabConcepCuota: lista) {
                if (siiCtaContabConcepCuota!=null) {
                    resultado.add(new CtaContabConcepCuotaVO(siiCtaContabConcepCuota));
                }
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public CtaContabConcepCuotaVO buscarPorConceptoCuotaYCuentaContable (Long ccuCodigo, Long ccoCodigo) throws ExcepcionDAO 
    {
        CtaContabConcepCuotaVO resultado = null;
        SiiCtaContabConcepCuota siiCtaContabConcepCuota = ctaContabConcepCuotaDao.buscarPorConceptoCuotaYCuentaContable(ccuCodigo, ccoCodigo);
        if (siiCtaContabConcepCuota!=null) {
            resultado = new CtaContabConcepCuotaVO(siiCtaContabConcepCuota);
        }
        
        return (resultado);
    }
}
