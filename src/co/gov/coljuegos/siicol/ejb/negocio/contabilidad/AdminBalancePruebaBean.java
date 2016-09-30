/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 27-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.BalancePruebaDAO;
import co.gov.coljuegos.siicol.ejb.vo.BalancePruebaVO;

import co.gov.coljuegos.siicol.ejb.vo.FiltrosBalancePruebaVO;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminBalancePruebaBean implements AdminBalancePrueba {
    
    @EJB
    private BalancePruebaDAO balancePruebaDao;
    
    
    /**
     * Constructor.
     */
    public AdminBalancePruebaBean() { }

    
    /**
     * Genera el listado que conforma el <b>BALANCE DE PRUEBA</b>.
     * @param filtros - Filtros aplicados en la generaci&oacute;n del Balance de Prueba.
     * @return List of BalancePruebaVO
     * @throws ExcepcionDAO
     */
    public List<BalancePruebaVO> generarBalancePrueba(FiltrosBalancePruebaVO filtros) throws ExcepcionDAO {
        return (balancePruebaDao.generarBalancePrueba(filtros));
    }
    
    /**
     * Genera el listado que conforma el <b>BALANCE DE PRUEBA</b>.
     * @param filtros - Filtros aplicados en la generaci&oacute;n del Balance de Prueba.
     * @param generarCuentasAdicionales - Flag que determina si ser&aacute;n adicionadas las cuentas padre y cuentas de saldo inicial al resultado del Balance de Prueba.
     * @return List of BalancePruebaVO
     * @throws ExcepcionDAO
     */
    public List<BalancePruebaVO> generarBalancePrueba(FiltrosBalancePruebaVO filtros, boolean generarCuentasAdicionales) throws ExcepcionDAO {
        return (balancePruebaDao.generarBalancePrueba(filtros, generarCuentasAdicionales));
    }
    
    
    /**
     * Establece el <b>SALDO INICIAL</b> del registro de Balance de Prueba, de acuerdo a los filtros establecidos.
     * @param balancePruebaVo
     * @param filtros
     * @throws ExcepcionDAO
     */
    public void establecerSaldoInicial(BalancePruebaVO balancePruebaVo, FiltrosBalancePruebaVO filtros) throws ExcepcionDAO {
        balancePruebaDao.establecerSaldoInicial(balancePruebaVo, filtros);
    }
}
