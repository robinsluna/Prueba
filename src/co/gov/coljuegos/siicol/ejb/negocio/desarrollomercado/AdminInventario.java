package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadInventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.OtroSiVO;
import co.gov.coljuegos.siicol.ejb.vo.SolicitudAutorizaVO;

import java.util.Date;
import java.util.List;

public interface AdminInventario {
    public List<InventarioVO> buscarInventarioPorNumContrato(String numeroContrato) throws ExcepcionDAO;
    
    public List<InventarioVO> consultaInventarioPorNitContrato(String nit,String numeroContrato) throws ExcepcionDAO;    

    public List<InventarioVO> buscarInventarioPorNumOtroSi(Long consecutivoOtroSi) throws ExcepcionDAO;

    /**
     * Metodo para la actualizacion del inventario por medio de una solicitud y sus novedades
     * @author Giovanni
     * @throws ExcepcionDAO
     * @param otroSiVO
     * @param solicitudAutorizaVO
     */
    public void actualizarInventarioXTipoSolicitudYTipoNovedad(OtroSiVO otroSiVO,
                                                               SolicitudAutorizaVO solicitudAutorizaVO,
                                                               Date fechaIniLiq) throws ExcepcionDAO, ExcepcionAplicacion ;

    public List<InventarioVO> buscarInventarioPorNovedad(Long codNovedad) throws ExcepcionDAO;

    public List<NovedadInventarioVO> buscarInventarioContratoInicial(Long conCodigo) throws ExcepcionDAO,
                                                                                            ExcepcionAplicacion;

    public List<NovedadInventarioVO> buscarHistorialInvContrato(Long conCodigo) throws ExcepcionDAO,
                                                                                       ExcepcionAplicacion;

    public List<InventarioVO> consultaInventarioPorContratoSiito(String numeroContrato)throws ExcepcionDAO;
    
    public List<InventarioVO> consultaInventarioPorEstado (String estados)throws ExcepcionDAO;
    
    public List<SiiInventario> consultaSiiInventarioPorEstado (String estados)throws ExcepcionDAO;
    
    public List<SiiInventario> consultaSiiInventarioPorEstadoPorPeriodos(String estados,String fechaini,String fechafin)throws ExcepcionDAO;
    
    public InventarioVO buscarInventarioPorId(Long idCodigo) throws ExcepcionDAO;

    public List<InventarioVO> buscarInventarioActivoOPenRetiroPorEstContrato(Long estCodigo,String conNumero) throws ExcepcionDAO ;
    
    public List<InventarioVO> buscarInventarioActivoPorEstContrato(Long estCodigo,String conNumero) throws ExcepcionDAO ;
    
    public List<InventarioVO> buscarInventarioActivoPorContrato(String conNumero) throws ExcepcionDAO;
    
    public List<InventarioVO> buscarBingosPorCodigoDANE(String codigoDane,String contrato) throws ExcepcionDAO;

    public String buscarJuegosAutorizadosPorNitOperador (String nit) throws ExcepcionDAO;
    
    public List<InventarioVO> buscarInventarioPorTipoApuesta(Long tapCodigo) throws ExcepcionDAO;
    
    public List<InventarioVO> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo) throws ExcepcionDAO;
    
    public List<InventarioVO> buscarInventarioPorContratoYTipoApuesta(Long conCodigo, Long tapCodigo, String invEstado) throws ExcepcionDAO;
    
    public InventarioVO insertarInventario (InventarioVO inventarioVo) throws ExcepcionDAO;
    
    public InventarioVO actualizarInventario (InventarioVO inventarioVo) throws ExcepcionDAO;
}
