/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 19-06-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleContNominaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interface local para la administraci&oacute;n de Detalle de Cargue de N&oacute;mina.
 * @author Camilo Miranda
 */
@Local
public interface AdminDetalleContNomina 
{
    public DetalleContNominaVO buscarDetalleContNominaPorId (Long dcmCodigo) throws ExcepcionDAO;
    public DetalleContNominaVO insertarDetalleContNomina (DetalleContNominaVO detalleContNominaVo) throws ExcepcionDAO;
    public DetalleContNominaVO actualizarDetalleContNomina (DetalleContNominaVO detalleContNominaVo) throws ExcepcionDAO;
    public void borrarDetalleContNomina (Long dcmCodigo) throws ExcepcionDAO;
    public List<DetalleContNominaVO> buscarTodoDetalleContNomina () throws ExcepcionDAO;
    public List<DetalleContNominaVO> buscarPorCodigoObligacion (Long oblCodigo) throws ExcepcionDAO;
}
