/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-08-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribVO;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribucionVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Detalles de Distribuci&oacute;n.
 * @author Camilo Miranda
 */
@Local
public interface AdminDetalleDistrib {
    
    public DetalleDistribVO buscarPorCodigoDetalleDistrib(Long dmeCodigo) throws ExcepcionDAO;
    public DetalleDistribVO insertarDetalleDistrib(DetalleDistribVO detalleDistribVo) throws ExcepcionDAO;
    public List<DetalleDistribVO> buscarDetalleDistribPorIdDistribucion(Long dmeCodigo) throws ExcepcionDAO;
    public List<DetalleDistribucionVO> buscarDetalleDistribucionPorId(Long idDistriMes) throws ExcepcionDAO;
    
}
