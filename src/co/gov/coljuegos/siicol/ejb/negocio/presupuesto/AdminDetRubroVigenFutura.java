/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DetRubroVigenFuturaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de la relaci&oacute;n entre Detalles Rubro y Vigencia Futura.
 * @author Camilo Miranda
 */
@Local
public interface AdminDetRubroVigenFutura 
{
    public DetRubroVigenFuturaVO buscarDetRubroVigenFuturaPorId (Long drvCodigo) throws ExcepcionDAO;
    public DetRubroVigenFuturaVO insertarDetRubroVigenFutura (DetRubroVigenFuturaVO detRubroVigenFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public DetRubroVigenFuturaVO actualizarDetRubroVigenFutura (DetRubroVigenFuturaVO detRubroVigenFuturaVo) throws ExcepcionDAO;
    public void borrarDetRubroVigenFutura (Long drvCodigo) throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarTodoDetRubroVigenFutura () throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarPorVigencia (Integer drvVigencia) throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarPorVigencia (Integer drvVigencia, Long vfuCodigo) throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarPorCodigoVigenciaFutura (Long vfuCodigo) throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarPorVigenciaFuturaEstado (Long vfuCodigo, String drvEstado) throws ExcepcionDAO;
    public List<DetRubroVigenFuturaVO> buscarPorVigenciaFuturaDetalleRubro (Long vfuCodigo, Long druCodigo) throws ExcepcionDAO;
}
