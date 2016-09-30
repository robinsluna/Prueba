/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */


package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionPropuestasVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de Recepci&oacute;n de Propuestas.
 * @author Camilo Miranda
 */
@Local
public interface AdminRecepcionPropuestas 
{
    public RecepcionPropuestasVO buscarPorCodigoRecepcionPropuestas (Long idCodigoRecepcionPropuestas) throws ExcepcionDAO;
    public RecepcionPropuestasVO insertarSiiRecepcionPropuestas (RecepcionPropuestasVO recepcionPropuestasVO) throws ExcepcionDAO;
    public RecepcionPropuestasVO actualizarSiiRecepcionPropuestas (RecepcionPropuestasVO recepcionPropuestasVO) throws ExcepcionDAO;
    public void borrarSiiRecepcionPropuestas (Long idCodigoRecepcionPropuestas) throws ExcepcionDAO;
    public List<RecepcionPropuestasVO> buscarTodoSiiRecepcionPropuestas () throws ExcepcionDAO;
    public List<RecepcionPropuestasVO> buscarPorCodigoProcesoContratacion (Long prcCodigo) throws ExcepcionDAO;
}
