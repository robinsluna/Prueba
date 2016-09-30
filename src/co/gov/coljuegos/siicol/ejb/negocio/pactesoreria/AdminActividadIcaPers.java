/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 31-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.ActividadIcaPersVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface para el Bean de administraci&oacute;n de la Actividad ICA de la Persona.
 * @author Camilo Miranda
 */
@Local
public interface AdminActividadIcaPers {
    public ActividadIcaPersVO buscarPorCodigoActividadIcaPers (Long aipCodigo) throws ExcepcionDAO;
    public ActividadIcaPersVO insertarActividadIcaPers (ActividadIcaPersVO actividadIcaPersVO) throws ExcepcionDAO;
    public ActividadIcaPersVO actualizarActividadIcaPers (ActividadIcaPersVO actividadIcaPersVO) throws ExcepcionDAO;
    public void borrarActividadIcaPers (Long aipCodigo) throws ExcepcionDAO;
    public List<ActividadIcaPersVO> buscarTodaActividadIcaPers () throws ExcepcionDAO;
    public List<ActividadIcaPersVO> buscarPorCodigoPersona (Long perCodigo) throws ExcepcionDAO;
    public ActividadIcaPersVO buscarActividadIcaPersPrincipalPorCodigoPersona (Long perCodigo) throws ExcepcionDAO;
    public List<ActividadIcaPersVO> buscarPorTipoContribuyenteProveedor (String perTipoPersona, String perTipoProveed) throws ExcepcionDAO;
}
