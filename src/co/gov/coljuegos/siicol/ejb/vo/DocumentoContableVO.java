/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 22-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModifEstadoDocContab;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para el Documento Contable.
 * @author Camilo Miranda
 */
public class DocumentoContableVO 
{
    private Long dcoCodigo;
    private Date dcoFechaOper;
    private Integer dcoNumeroCompr;
    private String dcoConcepto;
    private String dcoMotivoAnula;
    private BigDecimal dcoValor;
    
    private ObligacionVO obligacionVo;
    private TipoDocContableVO tipoDocContableVo;
    private OrdenPagoVO ordenPagoVo;
    private DetalleRecaudoVO detalleRecaudoVo;
    private EstadoDocContabVO estadoDocContabVo;
    private InteresCuotaVO interesCuotaVo;
    private UsuarioVO usuarioApruebaVo;
    private UsuarioVO usuarioRegistraVo;
    private CierreAnualContableVO cierreAnualContableVo;
    private CargaDocumentoContVO cargaDocumentoContVo;
    private NotaCreditoVO notaCreditoVo;
    private IncumplimientoContrVO incumplimientoContrVo;
    private LiquidacionMesVO liquidacionMesDE;
    private LiquidacionMesVO liquidacionMesGA;
    private ProcesoSancionatorioVO procesoSancionatorioVo;
    private ModifEstadoDocContabVO modifEstadoDocContabVo;
    
    private List<ImputacionContableVO> imputacionContableList;
    
    // Manejo de cambio de estados
    private Long idEstadoAnterior;
    
    
    
    /**
     * Constructor.
     */
    public DocumentoContableVO() { }
    
    
    /**
     * Constructor.
     * @param siiDocumentoContable
     */
    public DocumentoContableVO (SiiDocumentoContable siiDocumentoContable) {
        if (siiDocumentoContable!=null) {
            this.dcoCodigo = siiDocumentoContable.getDcoCodigo();
            this.dcoFechaOper = siiDocumentoContable.getDcoFechaOper();
            this.dcoNumeroCompr = siiDocumentoContable.getDcoNumeroCompr();
            this.dcoConcepto = siiDocumentoContable.getDcoConcepto();
            this.dcoMotivoAnula = siiDocumentoContable.getDcoMotivoAnula();
            this.dcoValor = siiDocumentoContable.getDcoValor();
            
            if (siiDocumentoContable.getSiiObligacion() != null) {
                this.obligacionVo = new ObligacionVO(siiDocumentoContable.getSiiObligacion());
            }
            
            if (siiDocumentoContable.getSiiTipoDocContable() != null) {
                this.tipoDocContableVo = new TipoDocContableVO(siiDocumentoContable.getSiiTipoDocContable());
            }
            
            if (siiDocumentoContable.getSiiOrdenPago() != null) {
                this.ordenPagoVo = new OrdenPagoVO(siiDocumentoContable.getSiiOrdenPago());
            }
            
            if (siiDocumentoContable.getSiiDetalleRecaudo() != null) {
                this.detalleRecaudoVo = new DetalleRecaudoVO(siiDocumentoContable.getSiiDetalleRecaudo());
            }
            
            if (siiDocumentoContable.getSiiEstadoDocContab() != null) {
                this.estadoDocContabVo = new EstadoDocContabVO(siiDocumentoContable.getSiiEstadoDocContab());
                this.idEstadoAnterior = siiDocumentoContable.getSiiEstadoDocContab().getEdoCodigo();
            }
            
            if (siiDocumentoContable.getSiiInteresCuota() != null) {
                this.interesCuotaVo = new InteresCuotaVO(siiDocumentoContable.getSiiInteresCuota());
            }
            
            if (siiDocumentoContable.getSiiUsuarioAprueba() != null) {
                this.usuarioApruebaVo = new UsuarioVO(siiDocumentoContable.getSiiUsuarioAprueba());
            }
            
            if (siiDocumentoContable.getSiiUsuarioRegistra() != null) {
                this.usuarioRegistraVo = new UsuarioVO(siiDocumentoContable.getSiiUsuarioRegistra());
            }
            
            if (siiDocumentoContable.getSiiCierreAnualContable()!=null) {
                this.cierreAnualContableVo = new CierreAnualContableVO(siiDocumentoContable.getSiiCierreAnualContable());
            }
            
            if (siiDocumentoContable.getSiiCargaDocumentoCont()!=null) {
                this.cargaDocumentoContVo = new CargaDocumentoContVO(siiDocumentoContable.getSiiCargaDocumentoCont());
            }
            
            if (siiDocumentoContable.getSiiNotaCredito()!=null) {
                this.notaCreditoVo = new NotaCreditoVO(siiDocumentoContable.getSiiNotaCredito());
            }
            
            if (siiDocumentoContable.getSiiIncumplimientoContr()!=null) {
                this.incumplimientoContrVo = new IncumplimientoContrVO(siiDocumentoContable.getSiiIncumplimientoContr());
            }
            
            if (siiDocumentoContable.getSiiLiquidacionMesDE()!=null) {
                this.liquidacionMesDE = new LiquidacionMesVO(siiDocumentoContable.getSiiLiquidacionMesDE());
            }
            
            if (siiDocumentoContable.getSiiLiquidacionMesGA()!=null) {
                this.liquidacionMesGA = new LiquidacionMesVO(siiDocumentoContable.getSiiLiquidacionMesGA());
            }
            
            if (siiDocumentoContable.getSiiProcesoSancionatorio()!=null) {
                this.procesoSancionatorioVo = new ProcesoSancionatorioVO(siiDocumentoContable.getSiiProcesoSancionatorio());
            }
            
            if(siiDocumentoContable.getSiiModifEstadoDocContab() != null){
                this.modifEstadoDocContabVo = new ModifEstadoDocContabVO(siiDocumentoContable.getSiiModifEstadoDocContab());
            }
        }
    }


    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoFechaOper(Date dcoFechaOper) {
        this.dcoFechaOper = dcoFechaOper;
    }

    public Date getDcoFechaOper() {
        return dcoFechaOper;
    }

    public void setDcoNumeroCompr(Integer dcoNumeroCompr) {
        this.dcoNumeroCompr = dcoNumeroCompr;
    }

    public Integer getDcoNumeroCompr() {
        return dcoNumeroCompr;
    }


    public void setDcoConcepto(String dcoConcepto) {
        this.dcoConcepto = dcoConcepto;
    }

    public String getDcoConcepto() {
        return dcoConcepto;
    }

    public void setDcoMotivoAnula(String dcoMotivoAnula) {
        this.dcoMotivoAnula = dcoMotivoAnula;
    }

    public String getDcoMotivoAnula() {
        return dcoMotivoAnula;
    }

    public void setDcoValor(BigDecimal dcoValor) {
        this.dcoValor = dcoValor;
    }

    public BigDecimal getDcoValor() {
        return dcoValor;
    }

    public void setDetalleRecaudoVo(DetalleRecaudoVO detalleRecaudoVo) {
        this.detalleRecaudoVo = detalleRecaudoVo;
    }

    public DetalleRecaudoVO getDetalleRecaudoVo() {
        return detalleRecaudoVo;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }

    public void setTipoDocContableVo(TipoDocContableVO tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public TipoDocContableVO getTipoDocContableVo() {
        return tipoDocContableVo;
    }


    public void setOrdenPagoVo(OrdenPagoVO ordenPagoVo) {
        this.ordenPagoVo = ordenPagoVo;
    }

    public OrdenPagoVO getOrdenPagoVo() {
        return ordenPagoVo;
    }

    public void setEstadoDocContabVo(EstadoDocContabVO estadoDocContabVo) {
        this.estadoDocContabVo = estadoDocContabVo;
    }

    public EstadoDocContabVO getEstadoDocContabVo() {
        return estadoDocContabVo;
    }

    public void setImputacionContableList(List<ImputacionContableVO> imputacionContableList) {
        this.imputacionContableList = imputacionContableList;
    }

    public List<ImputacionContableVO> getImputacionContableList() {
        return imputacionContableList;
    }


    public void setInteresCuotaVo(InteresCuotaVO interesCuotaVo) {
        this.interesCuotaVo = interesCuotaVo;
    }

    public InteresCuotaVO getInteresCuotaVo() {
        return interesCuotaVo;
    }


    public void setUsuarioApruebaVo(UsuarioVO usuarioApruebaVo) {
        this.usuarioApruebaVo = usuarioApruebaVo;
    }

    public UsuarioVO getUsuarioApruebaVo() {
        return usuarioApruebaVo;
    }

    public void setUsuarioRegistraVo(UsuarioVO usuarioRegistraVo) {
        this.usuarioRegistraVo = usuarioRegistraVo;
    }

    public UsuarioVO getUsuarioRegistraVo() {
        return usuarioRegistraVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setCierreAnualContableVo(CierreAnualContableVO cierreAnualContableVo) {
        this.cierreAnualContableVo = cierreAnualContableVo;
    }

    public CierreAnualContableVO getCierreAnualContableVo() {
        return cierreAnualContableVo;
    }

    public void setCargaDocumentoContVo(CargaDocumentoContVO cargaDocumentoContVo) {
        this.cargaDocumentoContVo = cargaDocumentoContVo;
    }

    public CargaDocumentoContVO getCargaDocumentoContVo() {
        return cargaDocumentoContVo;
    }

    public void setNotaCreditoVo(NotaCreditoVO notaCreditoVo) {
        this.notaCreditoVo = notaCreditoVo;
    }

    public NotaCreditoVO getNotaCreditoVo() {
        return notaCreditoVo;
    }

    public void setIncumplimientoContrVo(IncumplimientoContrVO incumplimientoContrVo) {
        this.incumplimientoContrVo = incumplimientoContrVo;
    }

    public IncumplimientoContrVO getIncumplimientoContrVo() {
        return incumplimientoContrVo;
    }

    public void setLiquidacionMesDE(LiquidacionMesVO liquidacionMesDE) {
        this.liquidacionMesDE = liquidacionMesDE;
    }

    public LiquidacionMesVO getLiquidacionMesDE() {
        return liquidacionMesDE;
    }

    public void setLiquidacionMesGA(LiquidacionMesVO liquidacionMesGA) {
        this.liquidacionMesGA = liquidacionMesGA;
    }

    public LiquidacionMesVO getLiquidacionMesGA() {
        return liquidacionMesGA;
    }

    public void setProcesoSancionatorioVo(ProcesoSancionatorioVO procesoSancionatorioVo) {
        this.procesoSancionatorioVo = procesoSancionatorioVo;
    }

    public ProcesoSancionatorioVO getProcesoSancionatorioVo() {
        return procesoSancionatorioVo;
    }
    
    

    /**
     * Adiciona un registro de Imputaci&oacute;n Contable a la lista.
     * @param imputacionContableVO
     * @return
     */
    public boolean addImputacionContableVO (ImputacionContableVO imputacionContableVO) 
    {
        boolean exitoso = false;
        
        if (imputacionContableList==null)
            imputacionContableList = new ArrayList<ImputacionContableVO>();
        
        exitoso = imputacionContableList.add(imputacionContableVO);
        if (exitoso)
            imputacionContableVO.setDocumentoContableVo(this);
        return (exitoso);
    }
    
    /**
     * Elimina un registro de Imputaci&oacute;n Contable de la lista.
     * @param imputacionContableVO
     * @return
     */
    public boolean removeImputacionContableVO (ImputacionContableVO imputacionContableVO) 
    {
        boolean exitoso = false;
        exitoso = imputacionContableList.remove(imputacionContableVO);
        if (exitoso)
            imputacionContableVO.setDocumentoContableVo(null);
        return (exitoso);
    }
    
    
    
    /**
     * Obtiene  el Nombre asociado al Estado del Documento Contable.
     * @return String value Of estadoDocContabVo.
     */
    public String getNombreEstadoDocContab() {
        String nombre = null;
        if (estadoDocContabVo!=null && estadoDocContabVo.getEdoCodigo()!=null) {
            nombre = EnumEstadoDocContab.getNombreById(estadoDocContabVo.getEdoCodigo());
        }
        return nombre;
    }
    
    
    /**
     * Obtiene el Tipo de Documento Contable a trav&eacute;s del objeto TipoDocContableVO.
     * @return tipoDocContableVo.tdcCodigo
     */
    public String getIdTipoDocumentoContable() {
        return (tipoDocContableVo!=null?tipoDocContableVo.getTdcCodigo():null);
    }


    public void setModifEstadoDocContabVo(ModifEstadoDocContabVO modifEstadoDocContabVo) {
        this.modifEstadoDocContabVo = modifEstadoDocContabVo;
    }

    public ModifEstadoDocContabVO getModifEstadoDocContabVo() {
        return modifEstadoDocContabVo;
    }
}
