/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	:26-03-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de la Actividad ICA.
 * @author Camilo Miranda
 */
@Local
public interface AdminActividadIca {
    public ActividadIcaVO buscarPorCodigoActividadIca (String aicCodigo) throws ExcepcionDAO;
    public ActividadIcaVO insertarActividadIca (ActividadIcaVO actividadIcaVO) throws ExcepcionDAO;
    public ActividadIcaVO actualizarActividadIca (ActividadIcaVO actividadIcaVO) throws ExcepcionDAO;
    public void borrarActividadIca (String aicCodigo) throws ExcepcionDAO;
    public List<ActividadIcaVO> buscarTodaActividadIca () throws ExcepcionDAO;
}
