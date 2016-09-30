/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 03-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoObligacionVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n del Estado de Obligaci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoObligacion 
{
    public EstadoObligacionVO buscarPorCodigoEstadoObligacion (Long idEstadoObligacion) throws ExcepcionDAO;
    public EstadoObligacionVO insertarSiiEstadoObligacion (EstadoObligacionVO estadoObligacionVO) throws ExcepcionDAO;
    public EstadoObligacionVO actualizarSiiEstadoObligacion (EstadoObligacionVO estadoObligacionVO) throws ExcepcionDAO;
    public void borrarSiiEstadoObligacion (Long idEstadoObligacion) throws ExcepcionDAO;
    public List<EstadoObligacionVO> buscarTodoEstadoObligacion () throws ExcepcionDAO;
}


