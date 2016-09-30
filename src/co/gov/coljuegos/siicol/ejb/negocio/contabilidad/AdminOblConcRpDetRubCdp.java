/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.OblConcRpDetRubCdpVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminOblConcRpDetRubCdp 
{
    public OblConcRpDetRubCdpVO buscarPorCodigoOblConcRpDetRubCdp (Long ocrCodigo) throws ExcepcionDAO;
    public OblConcRpDetRubCdpVO insertarOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) throws ExcepcionDAO;
    public OblConcRpDetRubCdpVO actualizarOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) throws ExcepcionDAO;
    public void eliminarOblConcRpDetRubCdp (Long ocrCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarTodoOblConcRpDetRubCdp () throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacionConcepto (Long ocoCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacion (Long oblCodigo) throws ExcepcionDAO;
    public BigDecimal obtenerTotalPorRpDetRubCdp (Long rdrCodigo) throws ExcepcionDAO;
    public BigDecimal valorRubroRpEjecutado(Long rdrCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRp (Long rpCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoObligacionRpFFC (Long oblCodigo, Long rpCodigo, String ffcCodigo) throws ExcepcionDAO;
    public List<OblConcRpDetRubCdpVO> buscarPorCodigoRpFFC (Long rpCodigo, String ffcCodigo, boolean descartarOblAnuladas) throws ExcepcionDAO;
}
