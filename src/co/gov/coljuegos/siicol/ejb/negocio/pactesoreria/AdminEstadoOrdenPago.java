package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoOrdenPagoVO;

import javax.ejb.Local;


/**
 * Interfaz Local para la administraci&oacute;n de Estados de Orden de Pago.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoOrdenPago 
{
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoPorId(Long idOrdenPago) throws ExcepcionDAO;
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoXNombre(String nombreEstado) throws ExcepcionDAO;
}
