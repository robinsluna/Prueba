/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 02-10-2013
 */
package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoEstudioMercVO;

import java.util.List;

import javax.ejb.Local;
@Local
public interface AdminEstadoEstudioMerc {
    public EstadoEstudioMercVO insertarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO;

    public EstadoEstudioMercVO buscarEstadoEstudioMercPorId(Long idEstadoEstudoMerc) throws ExcepcionDAO;

    public EstadoEstudioMercVO actualizarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO;

    public void eliminarEstadoEstudioMerc(EstadoEstudioMercVO estadoEstudioMercVO) throws ExcepcionDAO;

    public List<EstadoEstudioMercVO> buscarTodoEstadoEstudioMerc() throws ExcepcionDAO;

}
