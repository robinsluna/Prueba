/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.VigenciaFuturaResultVO;
import co.gov.coljuegos.siicol.ejb.vo.VigenciaFuturaVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz para el manejo de Vigencias Futuras.
 * @author Camilo Miranda
 */
@Local
public interface AdminVigenciaFutura 
{
    public VigenciaFuturaVO buscarVigenciaFuturaPorId (Long vfuCodigo) throws ExcepcionDAO;
    public VigenciaFuturaVO insertarVigenciaFutura (VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public VigenciaFuturaVO insertarVigenciaFutura (VigenciaFuturaVO vigenciaFuturaVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion;
    public VigenciaFuturaVO actualizarVigenciaFutura (VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion ;
    public VigenciaFuturaVO actualizarVigenciaFutura (VigenciaFuturaVO vigenciaFuturaVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion ;
    public void borrarVigenciaFutura (Long vfuCodigo) throws ExcepcionDAO;
    public List<VigenciaFuturaVO> buscarTodaVigenciaFutura () throws ExcepcionDAO;
    public List<VigenciaFuturaVO> buscarVigenciaFuturaPorEstado (String vfuEstado) throws ExcepcionDAO;
    
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaVigenciaFuturaResultEliminar (List<VigenciaFuturaResultVO> listaVigenciaFuturaResultEliminar);
}
