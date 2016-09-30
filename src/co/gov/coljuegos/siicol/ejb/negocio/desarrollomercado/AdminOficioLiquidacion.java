package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.DuplaVO;
import co.gov.coljuegos.siicol.ejb.vo.GarantPolizaOficLiqVO;
import co.gov.coljuegos.siicol.ejb.vo.OfiLiquidacionSolAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficLiqTipoApuestaVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionPrevioVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioLiquidacionVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;

import java.util.List;

public interface AdminOficioLiquidacion {

    public OficioLiquidacionVO insertarSiiOficioLiquidacion(OficioLiquidacionVO oficioLiquidacionVo,
                                                            SolicitudAutorizaVO solAutoriza,
                                                            List<GarantPolizaOficLiqVO> garPolizaOfic,
                                                            List<OficLiqTipoApuestaVO> listOficLiqTa) throws ExcepcionDAO;

    /**
     * @auhtor Modifica Giovanni
     * @param oficioLiquidacionVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public OficioLiquidacionVO actualizarSiiOficioLiquidacion(OficioLiquidacionVO oficioLiquidacionVO,
                                                              UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                                ExcepcionAplicacion;

    public void borrarSiiOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO;

    public List<OficioLiquidacionVO> buscarTodoSiiOficioLiquidacion() throws ExcepcionDAO;

    public List<OficioLiquidacionVO> buscarOficioLiquidacionPorSolicitudAutorizacion(Long sauCodigo) throws ExcepcionDAO;

    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacion(UsuarioVO usuarioLogueado) throws ExcepcionDAO;

    public OficioLiquidacionVO buscarPorCodigoOficioLiquidacion(Long idOficioLiquidacion) throws ExcepcionDAO;

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionPorSolicitud(Long idSolicitud) throws ExcepcionDAO;

    public List<OficioLiquidacionPrevioVO> buscarOficiosLiquidacionPorCodigo(Long idOficio) throws ExcepcionDAO;

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorSolicitud(Long idContrato) throws ExcepcionDAO;

    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionValorModificaPorSolicitud(Long idSolicitud) throws ExcepcionDAO;

    public List<DuplaVO> buscarPagosPorContrato(long codigoContrato) throws ExcepcionDAO;

    public Long cantidadElementosPorSolicitud(Long sauCodigo) throws ExcepcionDAO;

    public List<ContratoVO> buscarContratoPorOficioLiquidacion(Long idOficio ) throws ExcepcionDAO;
    
    public List<OfiLiquidacionSolAutorizaVO> buscarTodosOficioLiquidacionModifContrato(UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    
    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionModificaPorContrato(Long idContrato) throws ExcepcionDAO;
    
    public List<OficioLiquidacionPrevioVO> calcularOficioLiquidacionNuevoInventarioPorSolicitud(Long idSolicitud, Long idContrato) throws ExcepcionDAO;
    
    public List<OficioLiquidacionPrevioVO> obtenerLiquidacioncionOficioLiqPorContrato(Long idContrato) throws ExcepcionDAO;
	
    public OficioLiquidacionVO insertarSiiOficioLiquidacionModifContrato(OficioLiquidacionVO oficioLiquidacionVo,
                                                                                                            SolicitudAutorizaVO solAutoriza,
                                                                                                            List<GarantPolizaOficLiqVO> garPolizaOfic,
                                                                                                            List<OficLiqTipoApuestaVO> listOficLiqTa,
                                                                                                            List<InventarioVO> listaElementosActualizar,
                                                                                                            List<OficioLiquidacionPrevioVO> listaElementosAct,
                                                                                                            List<OficioLiquidacionPrevioVO> listaElementosModif,
                                                                                                            List<OficioLiquidacionPrevioVO> listaElementosNuevos                                                                                                                
                                                                                                            ) throws ExcepcionDAO;														
    public List<Long> consultarCodigoInventarioPorSolicitud(Long idSolicitud) throws ExcepcionDAO;
    
    public List<OficLiqTipoApuestaVO> buscarSiiOficLiqTipoApuestaPorCodigoEIndicador(Long idOficio,String indicador) throws ExcepcionDAO;
    
    public List<DuplaVO> buscarPagosPorContratoYDestino(long codigoContrato) throws ExcepcionDAO;
}
