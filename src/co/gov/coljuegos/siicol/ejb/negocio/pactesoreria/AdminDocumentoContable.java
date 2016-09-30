/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.vo.CambioEstDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ModifEstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;


@Local
public interface AdminDocumentoContable {
    public DocumentoContableVO buscarPorCodigoDocumentoContable(Long dcoCodigo) throws ExcepcionDAO;

    public DocumentoContableVO insertarDocumentoContable(DocumentoContableVO documentoContableVO) throws ExcepcionDAO;
    
    public DocumentoContableVO insertarDocumentoContable(DocumentoContableVO documentoContableVO, boolean imcUpdateEnabled) throws ExcepcionDAO;

    /**
     * @author Modifica Giovanni
     * @param documentoContableVO
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public DocumentoContableVO actualizarDocumentoContable(DocumentoContableVO documentoContableVO,
                                                           UsuarioVO usuarioLogueado) throws ExcepcionDAO,
                                                                                             ExcepcionAplicacion;
    
    public DocumentoContableVO actualizarDocumentoContable(DocumentoContableVO documentoContableVO, UsuarioVO usuarioLogueado, boolean imcUpdateEnabled) throws ExcepcionDAO, ExcepcionAplicacion;

    public void borrarDocumentoContable(Long dcoCodigo) throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarTodoDocumentoContable() throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarPorCodigoOrdenPago(Long orpCodigo) throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarPorTipoDocumentoContable(String tdcCodigo) throws ExcepcionDAO;

    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo) throws ExcepcionDAO;
    
    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo, Integer vigencia) throws ExcepcionDAO;

    public DocumentoContableVO buscarUltimoDocumentoContable(String tdcCodigo) throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarPorRangoPaginacion(Integer first, Integer last, String sortField,
                                                              String sortOrder) throws ExcepcionDAO;

    public List<DocumentoContableVO> buscarPorFiltros(Map<String, Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO;

    public Integer obtenerRowCount() throws ExcepcionDAO;

    public boolean isMesCerrado(DocumentoContableVO documentoContableVo) throws ExcepcionDAO;
    
    public void persistirDocumentosContables (List<DocumentoContableVO> listaDocumentosContables, UsuarioVO usuarioLogueado) throws Exception;
    
    public void insertarDocumentosContables (List<DocumentoContableVO> listaDocumentosContables) throws Exception;
    
    public List<Integer> buscarTodoNumeroComprobante () throws ExcepcionDAO;
    
    public List<Integer> buscarNumerosComprobantePorTipoDocumento (String tdcCodigo) throws ExcepcionDAO;
    
    public DocumentoContableVO buscarPorTipoYNumeroComprobante (String tdcCodigo, Integer dcoNumeroCompr) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorOrdenPagoTipoDocContab (Long orpCodigo, String tdcCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorCodigoCierreAnualContable (Long cacCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorCodigoCargaDocumentoCont (Long cdcCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorCodigoNotaCredito (Long ncrCodigo) throws ExcepcionDAO;
  
    public List<DocumentoContableVO> buscarPorCodigoReintegroPag (Long ripCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorIdLiquidacionMes (Long lmeCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorIdLiquidacionMes (Long lmeCodigo, String tdcCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarPorIdProcesoSancionatorio (Long psaCodigo) throws ExcepcionDAO;
    
    public List<CambioEstDocContableVO> buscarTodoDocConPorEstado(Long pEstado ) throws ExcepcionDAO;
    
    public ModifEstadoDocContabVO insertarSiiModifEstadoDocContab(ModifEstadoDocContabVO modifEstadoDocContab) throws ExcepcionDAO;
    
    public List<DocumentoContableVO> buscarTodoDocConPorEstadoTipo(Long pEstado,String  tdcCodigo) throws ExcepcionDAO ;
    
    ///////////////////////
    // Metodos Delegados //
    ///////////////////////
    public void setListaImputacionContableEliminar(List<ImputacionContableVO> listaImputacionContableEliminar) throws ExcepcionDAO;
    
    
    
}
