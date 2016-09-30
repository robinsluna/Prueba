/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.PropuestaEvaluacionVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Propuestas de Evaluaci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminPropuestaEvaluacion 
{
    public PropuestaEvaluacionVO buscarPorCodigoPropuestaRecib (Long idCodigoPropuestaEvaluacion) throws ExcepcionDAO;
    public PropuestaEvaluacionVO insertarSiiPropuestaEvaluacion (PropuestaEvaluacionVO propuestaEvaluacionVO) throws ExcepcionDAO;
    public PropuestaEvaluacionVO actualizarSiiPropuestaEvaluacion (PropuestaEvaluacionVO propuestaEvaluacionVO) throws ExcepcionDAO;
    public void borrarSiiPropuestaEvaluacion (Long idCodigoPropuestaEvaluacion) throws ExcepcionDAO;
    public List<PropuestaEvaluacionVO> buscarTodaPropuestaEvaluacionVO () throws ExcepcionDAO;
    public List<PropuestaEvaluacionVO> buscarPorCodigoEvaluacionJurTecFin (Long ejtCodigo) throws ExcepcionDAO;
}
