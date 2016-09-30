/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaRecibVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Propuestas Recibidas.
 * @author Camilo Miranda
 */
@Local
public interface AdminPropuestaRecib 
{
    public PropuestaRecibVO buscarPorCodigoPropuestaRecib (Long idCodigoPropuestaRecib)throws ExcepcionDAO;
    public PropuestaRecibVO insertarSiiPropuestaRecib (PropuestaRecibVO propuestaRecibVO) throws ExcepcionDAO;
    public PropuestaRecibVO actualizarSiiPropuestaRecib (PropuestaRecibVO propuestaRecibVO) throws ExcepcionDAO;
    public void borrarSiiPropuestaRecib (Long idCodigoPropuestaRecib) throws ExcepcionDAO;
    public List<PropuestaRecibVO> buscarPorCodigoRecepcionPropuestas (Long rprCodigo) throws ExcepcionDAO;
}
