/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-07-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocSopSolicPagoVO;

import javax.ejb.Local;


/**
 * Interfaz local para la administraci&oacute;n de Tipos de Documento de Soporte para Solicitudes de Pago.
 * @author Camilo Miranda
 */
@Local
public interface AdminTipoDocSopSolicPago 
{
    public TipoDocSopSolicPagoVO buscarTipoDocSopSolicPagoPorId(Long tspCodigo) throws ExcepcionDAO;
}
