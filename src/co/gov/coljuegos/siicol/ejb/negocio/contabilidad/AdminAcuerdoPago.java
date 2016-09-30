/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Mónica Pabón
 * FECHA	: 18-11-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.AcuerdoPagoVO;

import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.HlpCuotaAcuerdoVO;
import co.gov.coljuegos.siicol.ejb.vo.TasaIntSuperbanVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAcuerdoPago {
    public List<AcuerdoPagoVO> buscarTodoAcuerdoPago() throws ExcepcionDAO;    
    public Long consultarConsecutivoAcuerdo() throws ExcepcionDAO;    
    public AcuerdoPagoVO insertarAcuerdoPago(AcuerdoPagoVO acuerdoPagoVO,List<HlpCuotaAcuerdoVO> listaCuotasNuevas) throws ExcepcionDAO;
    public AcuerdoPagoVO buscarAcuerdoPagoPorCodigo(Long idAcuerdo) throws ExcepcionDAO;
    public List<HlpCuotaAcuerdoVO> buscarCuotasPorNumeroAcuerdoPago (Long idAcuerdoPago) throws ExcepcionDAO;
}
