package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ObligacionPagoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminObligacionPago {
    public ObligacionPagoVO insertarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
    public ObligacionPagoVO buscarObligacionPagoPorId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
    public List<ObligacionPagoVO>  buscarObligacionPagoXCamposSinId(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
    public ObligacionPagoVO actualizarObligacionPago(ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
    public List<ObligacionPagoVO> buscarTodoObligacionPago() throws ExcepcionDAO;
    public ObligacionPagoVO insertarObligacionPagoConDetalleRubroCdp (ObligacionPagoVO obligacionPagoVo) throws ExcepcionDAO;
}

