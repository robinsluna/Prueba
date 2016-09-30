/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEvaluacionJtfVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n del Estado de Evaluaci&oacute;n Jur&iacute;dica, T&eacute;cnica y Financiera.
 * @author Camilo Miranda
 */
@Local
public interface AdminEstadoEvaluacionJtf 
{
    public EstadoEvaluacionJtfVO buscarPorCodigoEstadoEvaluacionJtf (Long idEstadoEvaluacionJtf) throws ExcepcionDAO;
    public EstadoEvaluacionJtfVO insertarSiiEstadoEvaluacionJtf (EstadoEvaluacionJtfVO estadoEvaluacionJtfVO) throws ExcepcionDAO;
    public EstadoEvaluacionJtfVO actualizarSiiEstadoEvaluacionJtf (EstadoEvaluacionJtfVO estadoEvaluacionJtfVO) throws ExcepcionDAO;
    public void borrarSiiEstadoEvaluacionJtf (Long idEstadoEvaluacionJtf) throws ExcepcionDAO;
    public List<EstadoEvaluacionJtfVO> buscarTodoEstadoEvaluacionJtf () throws ExcepcionDAO;
}
