/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.BalancePruebaVO;

import co.gov.coljuegos.siicol.ejb.vo.FiltrosBalancePruebaVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminBalancePrueba {
    
    public List<BalancePruebaVO> generarBalancePrueba (FiltrosBalancePruebaVO filtros) throws ExcepcionDAO;
    public List<BalancePruebaVO> generarBalancePrueba (FiltrosBalancePruebaVO filtros, boolean generarCuentasAdicionales) throws ExcepcionDAO;
    public void establecerSaldoInicial (BalancePruebaVO balancePruebaVo, FiltrosBalancePruebaVO filtros) throws ExcepcionDAO;
    
}
