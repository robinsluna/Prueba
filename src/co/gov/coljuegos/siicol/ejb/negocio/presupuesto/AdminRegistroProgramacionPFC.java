/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Walter Becerra
 * FECHA	: 26-11-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ObligDetRubroCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;


import co.gov.coljuegos.siicol.ejb.vo.RubroFuenteDetalleFuenteRpVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminRegistroProgramacionPFC {
   
    public List<ObligacionPagoVO> buscarTodoObligacionPago() throws ExcepcionDAO;
    public ObligacionPagoVO insertarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO ;
    public ObligacionPagoVO buscarObligacionPagoPorId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
    public List<ObligacionPagoVO>  buscarObligacionPagoXCamposSinId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO ;
    public List<RubroFuenteDetalleFuenteRpVO> buscarListaFuenteDetallefuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO;
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO;
    public List<RubroFuenteDetalleFuenteRpVO> buscarRubroFuenteFDetfuenteXIdObligacion(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO;
    public List<RubroFuenteDetalleFuenteRpVO>  buscarObligacionXIdDetalleRubroCdp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo) throws ExcepcionDAO;
    public RubroFuenteDetalleFuenteRpVO  buscarTotalDecrementoRPXIdRp(RubroFuenteDetalleFuenteRpVO rubroFuenteDetallefuenteRpVo ) throws ExcepcionDAO;
}
