/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DocumentoContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ImputacionContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModifEstadoDocContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImputacionContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CambioEstDocContableVO;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ImputacionContableVO;
import co.gov.coljuegos.siicol.ejb.vo.ModifEstadoDocContabVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminDocumentoContableBean implements AdminDocumentoContable {
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    DocumentoContableDAO documentoContableDAO;
    @EJB
    private ImputacionContableDAO imputacionContableDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;
    @EJB
    private ModifEstadoDocContabDAO modifEstadoDocContabDao;

    
    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<ImputacionContableVO> listaImputacionContableEliminar;
    
    
    
    /**
     * Constructor.
     */
    public AdminDocumentoContableBean() {
        super();
    }
    
    
    
    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO 
    {
        if (this.listaImputacionContableEliminar!=null && !listaImputacionContableEliminar.isEmpty()) {
            this.eliminarImputacionesContables();
        }
    }
    
    
    /**
     * Elimina c/u de los registros de Imputaci&oacute;n Contable asociados al Documento Contable, que se encuentran pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarImputacionesContables () throws ExcepcionDAO 
    {
        if (this.listaImputacionContableEliminar!=null && !listaImputacionContableEliminar.isEmpty()) {
            for (ImputacionContableVO icVO : listaImputacionContableEliminar) {
                if (icVO.getImcCodigo() != null) {
                    imputacionContableDao.eliminar(icVO.getImcCodigo());
                }
            }
            
            // establecer nulo nuevamente el listado
            this.listaImputacionContableEliminar = null;
        }
    }
    
    
    

    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Imputaciones Contables asociadas al Documento Contable.
     * @param dc - Entidad Documento Contable.
     * @param documentoContableVo - Value Object Documento Contable.
     * @param updateEnabled - Flag que determina si se encuentra habilitada la actualizaci&oacute;n de registros de Imputaci&oacute;n Contable.
     * @throws ExcepcionDAO
     */
    private void persistirImputacionesContables(SiiDocumentoContable dc, DocumentoContableVO documentoContableVo, boolean updateEnabled) throws ExcepcionDAO {
        if (dc != null && documentoContableVo != null) {
            List<ImputacionContableVO> imputacionContableList = documentoContableVo.getImputacionContableList();
            if (imputacionContableList!=null) {
                for (ImputacionContableVO icVO : imputacionContableList) {
                    if (icVO!=null) {
                        if (icVO.getImcCodigo()==null || updateEnabled) {
                            icVO.setDocumentoContableVo(documentoContableVo);
                            SiiImputacionContable siiIC = conversionVoEntidad.convertir(icVO);
                            if (siiIC != null) {
                                siiIC.setSiiDocumentoContable(dc);
                                if (siiIC.getImcCodigo() == null) {
                                    // OPERACION INSERTAR
                                    imputacionContableDao.insertar(siiIC);
                                } else {
                                    if (updateEnabled) {
                                        // OPERACION ACTUALIZAR
                                        imputacionContableDao.actualizar(siiIC);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Override
    public DocumentoContableVO buscarPorCodigoDocumentoContable(Long dcoCodigo) throws ExcepcionDAO {
        SiiDocumentoContable siiDocumentoContable = documentoContableDAO.buscarPorCodigo(dcoCodigo);
        if (siiDocumentoContable == null)
            return null;
        return (new DocumentoContableVO(siiDocumentoContable));
    }

    
    @Override
    public DocumentoContableVO insertarDocumentoContable(DocumentoContableVO documentoContableVO) throws ExcepcionDAO {
        return ( this.insertarDocumentoContable(documentoContableVO, false) );
    }
    
    
    @Override
    public DocumentoContableVO insertarDocumentoContable(DocumentoContableVO documentoContableVO, boolean imcUpdateEnabled) throws ExcepcionDAO {
        SiiDocumentoContable siiDocumentoContable =
            documentoContableDAO.insertar(conversionVoEntidad.convertir(documentoContableVO));


        ////////////////////////////
        // Imputaciones Contables //
        ////////////////////////////
        documentoContableVO.setDcoCodigo(siiDocumentoContable.getDcoCodigo());
        this.persistirImputacionesContables(siiDocumentoContable, documentoContableVO, imcUpdateEnabled);

        return (new DocumentoContableVO(siiDocumentoContable));
    }

    
    @Override
    public DocumentoContableVO actualizarDocumentoContable(DocumentoContableVO documentoContableVO, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        return ( this.actualizarDocumentoContable(documentoContableVO, usuarioLogueado, false) );
    }
    
    
    
    /**
     * @author Modifica Giovanni
     * @param documentoContableVO
     * @param usuarioLogueado
     * @param imcUpdateEnabled
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    @Override
    public DocumentoContableVO actualizarDocumentoContable(DocumentoContableVO documentoContableVO,
                                                           UsuarioVO usuarioLogueado,
                                                           boolean imcUpdateEnabled) 
        throws ExcepcionDAO, ExcepcionAplicacion 
    {

        /*
         * Manejo de error de concurrencia
         */
        /*SiiDocumentoContable siiDocumentoContableTemp = new SiiDocumentoContable();
        siiDocumentoContableTemp = documentoContableDAO.buscarPorCodigo(documentoContableVO.getDcoCodigo());
        if (siiDocumentoContableTemp.getSiiEstadoDocContab().getEdoCodigo() !=
            documentoContableVO.getIdEstadoAnterior()) {
            throw new ExcepcionAplicacion("Error de concurrencia: El estado del documento contable fue cambiado durante la modificación. Seleccione nuevamente el documento contable");
        }*/

        /*
         * Registro del log de estados esto solo si el estado tuvo un cambio
         */
        if (documentoContableVO.getEstadoDocContabVo().getEdoCodigo() != documentoContableVO.getIdEstadoAnterior()) {
            adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.DOCUMENTO_CONTABLE.getId(),
                                                         documentoContableVO.getEstadoDocContabVo().getEdoCodigo(),
                                                         usuarioLogueado, documentoContableVO.getDcoCodigo());
        }
        
        
        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();
        
        
        SiiDocumentoContable siiDocumentoContable =
            documentoContableDAO.actualizar(conversionVoEntidad.convertir(documentoContableVO));


        ////////////////////////////
        // Imputaciones Contables //
        ////////////////////////////
        this.persistirImputacionesContables(siiDocumentoContable, documentoContableVO, imcUpdateEnabled);

        return (new DocumentoContableVO(siiDocumentoContable));
    }

    @Override
    public void borrarDocumentoContable(Long dcoCodigo) throws ExcepcionDAO {
        documentoContableDAO.eliminar(dcoCodigo);
    }

    @Override
    public List<DocumentoContableVO> buscarTodoDocumentoContable() throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarTodo();
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }


    @Override
    public List<DocumentoContableVO> buscarPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoObligacion(oblCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }


    @Override
    public List<DocumentoContableVO> buscarPorCodigoOrdenPago(Long orpCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoOrdenPago(orpCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }


    @Override
    public List<DocumentoContableVO> buscarPorTipoDocumentoContable(String tdcCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorTipoDocumentoContable(tdcCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }
    
    
    public List<DocumentoContableVO> buscarTodoDocConPorEstadoTipo(Long pEstado,String tdcCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarTodoDocConPorEstadoTipo(pEstado,tdcCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }
    


    @Override
    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo) throws ExcepcionDAO {
        return (documentoContableDAO.buscarConsecutivoDocumentoContable(tdcCodigo));
    }
    
    
    @Override
    public Integer buscarConsecutivoDocumentoContable(String tdcCodigo, Integer vigencia) throws ExcepcionDAO {
        return ( documentoContableDAO.buscarConsecutivoDocumentoContable(tdcCodigo, vigencia) );
    }


    @Override
    public DocumentoContableVO buscarUltimoDocumentoContable(String tdcCodigo) throws ExcepcionDAO {
        SiiDocumentoContable siiDocumentoContable = documentoContableDAO.buscarUltimoDocumentoContable(tdcCodigo);
        if (siiDocumentoContable == null)
            return null;
        return (new DocumentoContableVO(siiDocumentoContable));
    }

    @Override
    public List<DocumentoContableVO> buscarPorRangoPaginacion(Integer first, Integer last, String sortField,
                                                              String sortOrder) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista =
            documentoContableDAO.buscarPorRangoPaginacion(first, last, sortField, sortOrder);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }

    @Override
    public List<DocumentoContableVO> buscarPorFiltros(Map<String, Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorFiltros(filtros, sortField, sortOrder);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }

    @Override
    public Integer obtenerRowCount() throws ExcepcionDAO {
        return (documentoContableDAO.obtenerRowCount());
    }


    @Override
    public boolean isMesCerrado(DocumentoContableVO documentoContableVo) throws ExcepcionDAO {
        boolean valido = false;
        if (documentoContableVo != null)
            valido = documentoContableDAO.isMesCerrado(conversionVoEntidad.convertir(documentoContableVo));

        return valido;
    }
    
    
    
    
    
    /**
     * Almacena la informaci&oacute;n de los Documentos Contables suministrados, uno a uno.
     * @param listaDocumentosContables - Listado de Documentos Contables a persistir.
     * @throws Exception
     */
    @Override
    public void persistirDocumentosContables(List<DocumentoContableVO> listaDocumentosContables, UsuarioVO usuarioLogueado) throws Exception 
    {
        if (listaDocumentosContables!=null) {
            for (DocumentoContableVO documentoContableVo: listaDocumentosContables) {
                if (documentoContableVo!=null) {
                    if (documentoContableVo.getDcoCodigo()!=null) {
                        // ACTUALIZAR el Documento Contable junto a sus entidades hijas
                        this.actualizarDocumentoContable(documentoContableVo, usuarioLogueado);
                    }
                    else {
                        // INSERTAR el Documento Contable junto a sus entidades hijas
                        this.insertarDocumentoContable(documentoContableVo);
                    }
                }
            }
        }
    }
    
    
    
    /**
     * Inserta los registros de los Documentos Contables suministrados, uno a uno.
     * @param listaDocumentosContables - Listado de Documentos Contables a persistir.
     * @throws Exception
     */
    @Override
    public void insertarDocumentosContables(List<DocumentoContableVO> listaDocumentosContables) throws Exception 
    {
        if (listaDocumentosContables!=null) {
            for (DocumentoContableVO documentoContableVo: listaDocumentosContables) {
                if (documentoContableVo!=null) {
                    if (documentoContableVo.getDcoCodigo()==null) {
                        // INSERTAR el Documento Contable junto a sus entidades hijas
                        this.insertarDocumentoContable(documentoContableVo);
                    }
                }
            }
        }
    }
    
    
    @Override
    public List<Integer> buscarTodoNumeroComprobante() throws ExcepcionDAO {
        return (documentoContableDAO.buscarTodoNumeroComprobante());
    }
    
    @Override
    public List<Integer> buscarNumerosComprobantePorTipoDocumento(String tdcCodigo) throws ExcepcionDAO {
        return (documentoContableDAO.buscarNumerosComprobantePorTipoDocumento(tdcCodigo));
    }
    
    @Override
    public DocumentoContableVO buscarPorTipoYNumeroComprobante(String tdcCodigo, Integer dcoNumeroCompr) throws ExcepcionDAO {
        DocumentoContableVO resultado = null;
        SiiDocumentoContable siiDocumentoContable = documentoContableDAO.buscarPorTipoYNumeroComprobante(tdcCodigo, dcoNumeroCompr);
        if (siiDocumentoContable!=null)
            resultado = new DocumentoContableVO(siiDocumentoContable);
        
        return ( resultado );
    }
    
    @Override
    public List<DocumentoContableVO> buscarPorOrdenPagoTipoDocContab(Long orpCodigo, String tdcCodigo) throws ExcepcionDAO 
    {
        List<DocumentoContableVO> resultado = null;
        
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorOrdenPagoTipoDocContab(orpCodigo, tdcCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorCodigoCierreAnualContable (Long cacCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoCierreAnualContable(cacCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }
    
    
    
    @Override
    public List<DocumentoContableVO> buscarPorCodigoCargaDocumentoCont (Long cdcCodigo) throws ExcepcionDAO 
    {
        List<DocumentoContableVO> listaDocumentoContable = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoCargaDocumentoCont(cdcCodigo);
        if (lista != null) {
            listaDocumentoContable = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    listaDocumentoContable.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (listaDocumentoContable);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorCodigoNotaCredito (Long ncrCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoNotaCredito(ncrCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }

   
    @Override
    public List<DocumentoContableVO> buscarPorCodigoReintegroPag (Long ripCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorCodigoReintegroPag(ripCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorIdLiquidacionMes (Long lmeCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorIdLiquidacionMes(lmeCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorIdLiquidacionMes (Long lmeCodigo, String tdcCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorIdLiquidacionMes(lmeCodigo, tdcCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorIdIncumplimientoContr (Long icnCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorIdIncumplimientoContr(icnCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<DocumentoContableVO> buscarPorIdProcesoSancionatorio(Long psaCodigo) throws ExcepcionDAO {
        List<DocumentoContableVO> resultado = null;
        List<SiiDocumentoContable> lista = documentoContableDAO.buscarPorIdProcesoSancionatorio(psaCodigo);
        if (lista != null) {
            resultado = new ArrayList<DocumentoContableVO>();
            for (SiiDocumentoContable siiDocumentoContable : lista) {
                if (siiDocumentoContable!=null)
                    resultado.add(new DocumentoContableVO(siiDocumentoContable));
            }
        }
        return (resultado);
    }
      
    public List<CambioEstDocContableVO> buscarTodoDocConPorEstado(Long pEstado ) throws ExcepcionDAO {
        List<CambioEstDocContableVO> resultado = null;
        List<CambioEstDocContableVO> lista = documentoContableDAO.buscarTodoDocConPorEstado(pEstado);
        if (lista != null) {
            resultado = new ArrayList<CambioEstDocContableVO>();
            for (CambioEstDocContableVO objetoVo : lista) {
                if (objetoVo!=null)
                    resultado.add(new CambioEstDocContableVO (objetoVo)); 
                }
        }
        return (resultado);
    } 
   
    public ModifEstadoDocContabVO insertarSiiModifEstadoDocContab(ModifEstadoDocContabVO modifEstadoDocContab) throws ExcepcionDAO {
        return new ModifEstadoDocContabVO(modifEstadoDocContabDao.insertarSiiModifEstadoDocContab( conversionVoEntidad.convertir(modifEstadoDocContab)));
    }
    
  
    
    ///////////////////
    // Modificadores //
    ///////////////////
    
    @Override
    public void setListaImputacionContableEliminar(List<ImputacionContableVO> listaImputacionContableEliminar) {
        this.listaImputacionContableEliminar = listaImputacionContableEliminar;
    }

    public List<ImputacionContableVO> getListaImputacionContableEliminar() {
        return listaImputacionContableEliminar;
    }
}
