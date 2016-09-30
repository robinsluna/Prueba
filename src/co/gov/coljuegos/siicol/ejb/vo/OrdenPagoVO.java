/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PAC Y TESORERIA
 * AUTOR	: Camilo Miranda
 * FECHA	: 23-01-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOrdenPago;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Value Object para las &Oacute;rdenes de Pago.
 * @author Christian Acosta
 */
public class OrdenPagoVO implements Comparable<OrdenPagoVO>
{
    /** N&uacute;mero de secuencia asociado a la Orden de Pago */
    private Long orpCodigo;
    /** Consecutivo para manejo interno de la Orden de Pago */
    private Integer orpConsecutivo;
    
    private Date orpFecha;
    private String orpPagDestFinal;
    private Integer gastosPersonal;
    private Integer gastosGenerales;
    private Integer recursosPropios;
    private Integer valorSelecionado; 
    private String indicadorPago;
    private BigDecimal valorGasto;
    private String vigencia;
    
    private String motivoAnulacion;
    private String numeroDocCobro;
    
    private TipoDocContableVO tipoDocContableVo;
    private ObligacionVO obligacionVo;
    private EstadoOrdenPagoVO estadoOrdenPagoVo;
    private CuentaBancariaVO cuentaBancariaVo;
    
    private UsuarioVO usuarioRegistraVo;
    private UsuarioVO usuarioApruebaVo;
    private ObligacionNoPresupVO obligacionNoPresupVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    
    private List<DocumentoContableVO> documentoContableList;
    
    //Campos temporales
    private Long numeroRP;
    private Long codBeneficiario;
    private ProveedorVO beneficiario;
    private TipoDocCobroSolPagoVO tipoDocCobroSolPagoVo;
    
    // Manejo de cambio de estados
    private Long idEstadoAnterior;
    

    
       
    /**
     * Constructor.
     */
    public OrdenPagoVO() { }
    
    
    /**
     * Constructor.
     * @param siiOrdenPago
     */
    public OrdenPagoVO (SiiOrdenPago siiOrdenPago) {
        if (siiOrdenPago!=null) {
            this.orpCodigo = siiOrdenPago.getOrpCodigo();
            this.orpConsecutivo = siiOrdenPago.getOrpConsecutivo();
            this.orpFecha = siiOrdenPago.getOrpFecha();
            this.orpPagDestFinal = siiOrdenPago.getOrpPagDestFinal();
            this.valorGasto=siiOrdenPago.getOrpValorGasto();
            this.indicadorPago=siiOrdenPago.getOrpTipoGasto();
            this.numeroRP=siiOrdenPago.getOblNumeroRp();
            this.numeroDocCobro= siiOrdenPago.getOrpNumDocSop();
            if (siiOrdenPago.getSiiObligacion() != null) {
                this.obligacionVo = new ObligacionVO(siiOrdenPago.getSiiObligacion());
            }
            
            if (siiOrdenPago.getSiiCuentaBancaria() != null) {
                this.cuentaBancariaVo = new CuentaBancariaVO(siiOrdenPago.getSiiCuentaBancaria());
            }
            
            if (siiOrdenPago.getSiiEstadoOrdenPago() != null) {
                this.estadoOrdenPagoVo = new EstadoOrdenPagoVO(siiOrdenPago.getSiiEstadoOrdenPago());
                this.idEstadoAnterior = siiOrdenPago.getSiiEstadoOrdenPago().getEopCodigo();
            }
            
            if (siiOrdenPago.getSiiUsuarioAprueba() != null) {
                this.usuarioApruebaVo = new UsuarioVO(siiOrdenPago.getSiiUsuarioAprueba());
            }
            
            if (siiOrdenPago.getSiiUsuarioRegistra() != null) {
                this.usuarioRegistraVo = new UsuarioVO(siiOrdenPago.getSiiUsuarioRegistra());
            }
            if (siiOrdenPago.getSiiProveedor() != null) {
                this.beneficiario = new ProveedorVO(siiOrdenPago.getSiiProveedor());
            }
            if (siiOrdenPago.getSiiTipoDocSopSolicPago() != null) {
                this.tipoDocCobroSolPagoVo = new TipoDocCobroSolPagoVO(siiOrdenPago.getSiiTipoDocSopSolicPago());
            }
            
            if (siiOrdenPago.getOrpFecha() != null) {
                String formato="yyyy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
                this.vigencia=(dateFormat.format(siiOrdenPago.getOrpFecha()));
            }
            if(siiOrdenPago.getSiiObligacionNoPresup()!= null){
                this.obligacionNoPresupVo = new ObligacionNoPresupVO(siiOrdenPago.getSiiObligacionNoPresup());
            }
            
            if (siiOrdenPago.getSiiTipoDocContable() != null) {
                this.tipoDocContableVo = new TipoDocContableVO(siiOrdenPago.getSiiTipoDocContable());
            }
            
            if (siiOrdenPago.getSiiFuenteFinancContab()!=null) {
                this.fuenteFinancContabVo = new FuenteFinancContabVO(siiOrdenPago.getSiiFuenteFinancContab());
            }
            
        }
    }
    
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(OrdenPagoVO opVo) {
        if (opVo!=null && opVo.orpConsecutivo!=null && this.orpConsecutivo!=null) {
            return ( this.orpConsecutivo.compareTo(opVo.orpConsecutivo) );
        }
        return -2;
    }
    
    
    

    public void setOrpCodigo(Long orpCodigo) {
        this.orpCodigo = orpCodigo;
    }

    public Long getOrpCodigo() {
        return orpCodigo;
    }

    public void setOrpFecha(Date orpFecha) {
        this.orpFecha = orpFecha;
    }

    public Date getOrpFecha() {
        return orpFecha;
    }

    public void setOrpPagDestFinal(String orpPagDestFinal) {
        this.orpPagDestFinal = orpPagDestFinal;
    }

    public String getOrpPagDestFinal() {
        return orpPagDestFinal;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }

    public void setEstadoOrdenPagoVo(EstadoOrdenPagoVO estadoOrdenPagoVo) {
        this.estadoOrdenPagoVo = estadoOrdenPagoVo;
    }

    public EstadoOrdenPagoVO getEstadoOrdenPagoVo() {
        return estadoOrdenPagoVo;
    }

    public void setCuentaBancariaVo(CuentaBancariaVO cuentaBancariaVo) {
        this.cuentaBancariaVo = cuentaBancariaVo;
    }

    public CuentaBancariaVO getCuentaBancariaVo() {
        return cuentaBancariaVo;
    }

    public void setDocumentoContableList(List<DocumentoContableVO> documentoContableList) {
        this.documentoContableList = documentoContableList;
    }

    public List<DocumentoContableVO> getDocumentoContableList() {
        return documentoContableList;
    }

    public void setMotivoAnulacion(String motivoAnulacion) {
        this.motivoAnulacion = motivoAnulacion;
    }

    public String getMotivoAnulacion() {
        return motivoAnulacion;
    }

    public void setUsuarioRegistraVo(UsuarioVO usuarioRegistraVo) {
        this.usuarioRegistraVo = usuarioRegistraVo;
    }

    public UsuarioVO getUsuarioRegistraVo() {
        return usuarioRegistraVo;
    }

    public void setUsuarioApruebaVo(UsuarioVO usuarioApruebaVo) {
        this.usuarioApruebaVo = usuarioApruebaVo;
    }

    public UsuarioVO getUsuarioApruebaVo() {
        return usuarioApruebaVo;
    }


    public void setNumeroRP(Long numeroRP) {
        this.numeroRP = numeroRP;
    }

    public Long getNumeroRP() {
        return numeroRP;
    }

    public void setValorGasto(BigDecimal valorGasto) {
        this.valorGasto = valorGasto;
    }

    public BigDecimal getValorGasto() {
        return valorGasto;
    }

    public void setCodBeneficiario(Long codBeneficiario) {
        this.codBeneficiario = codBeneficiario;
    }

    public Long getCodBeneficiario() {
        return codBeneficiario;
    }

    public void setBeneficiario(ProveedorVO beneficiario) {
        this.beneficiario = beneficiario;
    }

    public ProveedorVO getBeneficiario() {
        return beneficiario;
    }


    public void setNumeroDocCobro(String numeroDocCobro) {
        this.numeroDocCobro = numeroDocCobro;
    }

    public String getNumeroDocCobro() {
        return numeroDocCobro;
    }

    public void setGastosPersonal(Integer gastosPersonal) {
        this.gastosPersonal = gastosPersonal;
    }

    public Integer getGastosPersonal() {
        return gastosPersonal;
    }

    public void setGastosGenerales(Integer gastosGenerales) {
        this.gastosGenerales = gastosGenerales;
    }

    public Integer getGastosGenerales() {
        return gastosGenerales;
    }

    public void setRecursosPropios(Integer recursosPropios) {
        this.recursosPropios = recursosPropios;
    }

    public Integer getRecursosPropios() {
        return recursosPropios;
    }

    public void setValorSelecionado(Integer valorSelecionado) {
        this.valorSelecionado = valorSelecionado;
    }


    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }


    public Integer getValorSelecionado() {
        return valorSelecionado;
    }


    public void setIndicadorPago(String indicadorPago) {
        this.indicadorPago = indicadorPago;
    }

    public String getIndicadorPago() {
        return indicadorPago;
    }

    /**
     * Obtiene el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Orden de Pago)
     * @return documentoContableList.first
     */
    public DocumentoContableVO getDocumentoContable () {
        return ( documentoContableList!=null && !documentoContableList.isEmpty()?documentoContableList.get(0):null );
    }
    
    
    /**
     * Establece el Documento Contable.
     * (En la pr&aacute;ctica, s&oacute;lamente existe un (1) Documento Contable por Orden de Pago)
     * @param documentoContableVO
     */
    public void setDocumentoContable (DocumentoContableVO documentoContableVO) {
        if (documentoContableList==null)
            documentoContableList = new ArrayList<DocumentoContableVO>();
        else
            documentoContableList.clear();
        
        if (documentoContableVO!=null) {
            documentoContableVO.setOrdenPagoVo(this);
            documentoContableList.add(documentoContableVO);
        }
    }


    public void setTipoDocCobroSolPagoVo(TipoDocCobroSolPagoVO tipoDocCobroSolPagoVo) {
        this.tipoDocCobroSolPagoVo = tipoDocCobroSolPagoVo;
    }

    public TipoDocCobroSolPagoVO getTipoDocCobroSolPagoVo() {
        return tipoDocCobroSolPagoVo;
    }

    public void setObligacionNoPresupVo(ObligacionNoPresupVO obligacionNoPresupVo) {
        this.obligacionNoPresupVo = obligacionNoPresupVo;
    }

    public ObligacionNoPresupVO getObligacionNoPresupVo() {
        return obligacionNoPresupVo;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setOrpTipoGasto(String orpTipoGasto) {
        this.indicadorPago = orpTipoGasto;
    }

    public String getOrpTipoGasto() {
        return indicadorPago;
    }

    public void setOrpConsecutivo(Integer orpConsecutivo) {
        this.orpConsecutivo = orpConsecutivo;
    }

    public Integer getOrpConsecutivo() {
        return orpConsecutivo;
    }

    public void setTipoDocContableVo(TipoDocContableVO tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public TipoDocContableVO getTipoDocContableVo() {
        return tipoDocContableVo;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }
    
    
    
    
    /**
     * Obtiene el nombre asociado al Flag <i>Obliga Pago Destinatario Final</i>.
     * @return S&iacute;/No.
     */
    public String getObligaPagoDestFinal() 
    {
        String resultado = null;
        if (orpPagDestFinal!=null) {
            resultado = EnumDecision.getNombreById(orpPagDestFinal);
        }
        
        return (resultado);
    }

    
    /**
     * Obtiene el nombre del Estado de la Orden de Pago.
     * @return estadoOrdenPagoVo.eopNombre
     */
    public String getNombreEstadoOrdenPago() 
    {
        return ( estadoOrdenPagoVo!=null ? estadoOrdenPagoVo.getEopNombre() : null );
    }
    
    
    /**
     * Obtiene el Identificador del Tipo de Documento Contable.
     * @return tipoDocContableVo.tdcCodigo
     */
    public String getIdTipoDocumentoContable() 
    {
        return ( tipoDocContableVo!=null ? tipoDocContableVo.getTdcCodigo() : null );
    }
}
