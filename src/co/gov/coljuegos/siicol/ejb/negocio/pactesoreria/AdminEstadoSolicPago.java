/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoSolicPagoVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminEstadoSolicPago {
    public EstadoSolicPagoVO buscarPorCodigoEstadoSolicPago (Long idEstadoSolicPago) throws ExcepcionDAO;
    public EstadoSolicPagoVO insertarSiiEstadoSolicPago (EstadoSolicPagoVO estadoSolicPago) throws ExcepcionDAO;
    public EstadoSolicPagoVO actualizarSiiEstadoSolicPago(EstadoSolicPagoVO estadoSolicPago) throws ExcepcionDAO;
    public void borrarSiiEstadoSolicPago (Long idEstadoSolicPago) throws ExcepcionDAO;
    public List<EstadoSolicPagoVO> buscarTodoSiiEstadoSolicPago() throws ExcepcionDAO;
}
