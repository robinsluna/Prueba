/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CdpRpVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCdpRp {
    
    public CdpRpVO insertarCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO;
    public CdpRpVO actualizarCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO;
    public CdpRpVO buscarPorCodigoCdpRp(CdpRpVO cdpRpVo) throws ExcepcionDAO;
    public List<CdpRpVO> buscarCdpRpPorRp(Long idRp) throws ExcepcionDAO;
    public List<CdpRpVO> buscarCdpRpPorCdp(Long cdpCodigo)  throws ExcepcionDAO;
}
