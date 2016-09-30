/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoDocContabVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n del Estado de Documento Contable.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoDocContab 
{
    public EstadoDocContabVO buscarPorCodigoEstadoDocContab (Long idEstadoDocContab) throws ExcepcionDAO;
    public EstadoDocContabVO insertarEstadoDocContab (EstadoDocContabVO estadoDocContabVO) throws ExcepcionDAO;
    public EstadoDocContabVO actualizarEstadoDocContab (EstadoDocContabVO estadoDocContabVO) throws ExcepcionDAO;
    public void borrarEstadoDocContab (Long idEstadoDocContab) throws ExcepcionDAO;
    public List<EstadoDocContabVO> buscarTodoEstadoDocContab () throws ExcepcionDAO;    
}
