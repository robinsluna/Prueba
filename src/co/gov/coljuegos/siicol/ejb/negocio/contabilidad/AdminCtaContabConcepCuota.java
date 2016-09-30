/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 24-10-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.CtaContabConcepCuotaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Cuentas Contables por Concepto Cuota.
 * @author Camilo Miranda
 */
@Local
public interface AdminCtaContabConcepCuota 
{
    public List<CtaContabConcepCuotaVO> buscarCuentasContablesPorIdConceptoCuota (Long ccuCodigo) throws ExcepcionDAO;
    public CtaContabConcepCuotaVO buscarPorConceptoCuotaYCuentaContable (Long ccuCodigo, Long ccoCodigo) throws ExcepcionDAO;
}
