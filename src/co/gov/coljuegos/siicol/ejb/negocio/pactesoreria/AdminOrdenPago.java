package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoOrdenPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.OrdenPagoVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;

import java.util.Map;

import javax.ejb.Local;

@Local
public interface AdminOrdenPago {
    public List<OrdenPagoVO> buscarTodoOrdenPago() throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoAprobadas() throws ExcepcionDAO ;
    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoCuentasXPagar() throws ExcepcionDAO;
    public OrdenPagoVO insertarOrdenPago(OrdenPagoVO ordenPagoVO) throws Exception;
    public OrdenPagoVO insertarOrdenPago(OrdenPagoVO ordenPagoVO, boolean persistirHijos) throws Exception;
    public OrdenPagoVO actualizarOrdenPago(OrdenPagoVO ordenPagoVO) throws Exception;
    public OrdenPagoVO actualizarOrdenPago(OrdenPagoVO ordenPagoVO, boolean persistirHijos) throws Exception;
    public OrdenPagoVO anularOrdenPago(OrdenPagoVO ordenPagoVO,UsuarioVO usuarioLogueado) throws ExcepcionDAO;
    public Integer buscarConsecutivoOrdenPago() throws ExcepcionDAO;
    public Integer buscarConsecutivoOrdenPago(String tdcCodigo) throws ExcepcionDAO;
    public OrdenPagoVO buscarOrdenPagoPorCodigo(long codOrdenPagoVO) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarRangoOrdenPagoPorCodigo(Integer inicio, Integer fin)throws ExcepcionDAO;
    public OrdenPagoVO actualizarOrdenPagoMovimientoContable(OrdenPagoVO ordenPagoVo)throws ExcepcionDAO ;
    public List<OrdenPagoVO> confirmarOrdenPago(List<OrdenPagoVO> listaOrdenPagoVo,UsuarioVO usuarioLogueado)throws ExcepcionDAO ;
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoPorId(long codEstadoOrdenPagoVo) throws ExcepcionDAO ;
    public EstadoOrdenPagoVO buscarEstadoOrdenPagoXNombre(String  nombreEstado) throws ExcepcionDAO ;
    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoCuentarPagar() throws ExcepcionDAO ;
    public List<OrdenPagoVO> buscarTodasOrdenPagoCuentasXPagar() throws ExcepcionDAO ;
    public List<OrdenPagoVO> buscarOrdenPagoPorObligacion (Long oblCodigo) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorObligacionTipoGasto (Long oblCodigo, String orpTipoGasto) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarTodoSiiOrdenPagoNoPresupuestal() throws ExcepcionDAO;
    public void persistirOrdenesPago (List<OrdenPagoVO> listaOrdenesPago) throws Exception;
    public void actualizarOrdenesPagoMovimientoContable (List<OrdenPagoVO> listaOrdenesPago) throws Exception;
    public List<OrdenPagoVO> buscarOrdenPagoPorEstado (Long eopCodigo) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContable (String tdcCodigo) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContableYEstado (String tdcCodigo, Long eopCodigo) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorTipoDocContableObligacion (String tdcCodigo) throws ExcepcionDAO;
    public OrdenPagoVO buscarOrdenPagoPorConsecutivoYTipoDocContable (Integer orpConsecutivo, String tdcCodigo) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorObligacionFFC (Long oblCodigo, String ffcCodigo) throws ExcepcionDAO;
    
    
    //
    // METODOS USADOS PARA PAGINACION EN LAZY DATA MODELS.
    //
    public List<OrdenPagoVO> buscarOrdenPagoPorRangoPaginacion (Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarOrdenPagoPorRangoPaginacion (String tdcCodigo, Integer first, Integer last, String sortField, String sortOrder) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarPorFiltros (Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO;
    public List<OrdenPagoVO> buscarPorFiltros (String tdcCodigo, Map<String,Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO;
    public Integer obtenerRowCount () throws ExcepcionDAO;
    public Integer obtenerRowCount (String tdcCodigo) throws ExcepcionDAO;
    //
    
    
    
    
    /**
     * @author Giovanni
     * @param codOrdenPago
     * @return
     * @throws ExcepcionDAO
     */
    public OrdenPagoVO imprimirOrdenPagoPorCodigo(Long codOrdenPago) throws ExcepcionDAO;
}
