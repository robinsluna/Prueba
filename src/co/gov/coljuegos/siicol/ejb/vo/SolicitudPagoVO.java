package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPago;

import java.math.BigDecimal;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class SolicitudPagoVO {
    
    private Long spaCodigo;
    private Long spaConsecutivo;   
    private Date spaFechaSol;
    private String spaFechaSolFormat;
    private String spaMotivoDevoluc;
    private String spaNumDocCobro;
    private String spaObservaciones;
    private String spaTipoCuenta;
    private BigDecimal spaValorCuenta;
    private Integer spaVigencia;
    private Long spaSoportesOriginales;    
    private RpVO rpVo;
    private EstadoSolicPagoVO estadoSolicPagoVo;
    private MesVO mesVo;    
    private List<ObligacionVO> obligacionList;
    private Long idEstadoAnterior;
    private TipoDocSopSolicPagoVO tipoDocSopSolicPagoVo;
    
    
    /**
     * Constructor.
     * @param siiSolicitudPago
     */
    public SolicitudPagoVO (SiiSolicitudPago siiSolicitudPago){
        
        this.spaCodigo = siiSolicitudPago.getSpaCodigo();
        this.spaConsecutivo = siiSolicitudPago.getSpaConsecutivo();
        DateFormat df =  DateFormat.getDateInstance();
        if(siiSolicitudPago.getSpaFechaSol() != null){
           this.spaFechaSolFormat = df.format(siiSolicitudPago.getSpaFechaSol()); 
        }
        this.spaFechaSol = siiSolicitudPago.getSpaFechaSol();
        this.spaMotivoDevoluc = siiSolicitudPago.getSpaMotivoDevoluc();
        this.spaNumDocCobro = siiSolicitudPago.getSpaNumDocCobro();
        this.spaObservaciones = siiSolicitudPago.getSpaObservaciones();
        this.spaTipoCuenta = siiSolicitudPago.getSpaTipoCuenta();
        this.spaValorCuenta = siiSolicitudPago.getSpaValorCuenta();
        this.spaVigencia = siiSolicitudPago.getSpaVigencia();
        
        if(siiSolicitudPago.getSiiRp() != null){
            this.rpVo =  new RpVO(siiSolicitudPago.getSiiRp());
        }
        
        //Estado
        if(siiSolicitudPago.getSiiEstadoSolicPago() != null){
            this.estadoSolicPagoVo =  new EstadoSolicPagoVO(siiSolicitudPago.getSiiEstadoSolicPago());
            this.idEstadoAnterior = siiSolicitudPago.getSiiEstadoSolicPago().getEsoCodigo();
        }
        
        if(siiSolicitudPago.getSiiMes() != null){
            this.mesVo =  new MesVO(siiSolicitudPago.getSiiMes());
        }
        
        // Tipo Documento Soporte
        if (siiSolicitudPago.getSiiTipoDocSopSolicPago()!=null) {
            this.tipoDocSopSolicPagoVo = new TipoDocSopSolicPagoVO(siiSolicitudPago.getSiiTipoDocSopSolicPago());
        }

    } 
    
    
    /**
     * Constructor.
     */
    public SolicitudPagoVO() {
        
    }
    

    public void setSpaCodigo(Long spaCodigo) {
        this.spaCodigo = spaCodigo;
    }

    public Long getSpaCodigo() {
        return spaCodigo;
    }

    public void setSpaConsecutivo(Long spaConsecutivo) {
        this.spaConsecutivo = spaConsecutivo;
    }

    public Long getSpaConsecutivo() {
        return spaConsecutivo;
    }

    public void setSpaFechaSol(Date spaFechaSol) {
        this.spaFechaSol = spaFechaSol;
    }

    public Date getSpaFechaSol() {
        return spaFechaSol;
    }

    public void setSpaMotivoDevoluc(String spaMotivoDevoluc) {
        this.spaMotivoDevoluc = spaMotivoDevoluc;
    }

    public String getSpaMotivoDevoluc() {
        return spaMotivoDevoluc;
    }

    public void setSpaNumDocCobro(String spaNumDocCobro) {
        this.spaNumDocCobro = spaNumDocCobro;
    }

    public String getSpaNumDocCobro() {
        return spaNumDocCobro;
    }

    public void setSpaObservaciones(String spaObservaciones) {
        this.spaObservaciones = spaObservaciones;
    }

    public String getSpaObservaciones() {
        return spaObservaciones;
    }

    public void setSpaTipoCuenta(String spaTipoCuenta) {
        this.spaTipoCuenta = spaTipoCuenta;
    }

    public String getSpaTipoCuenta() {
        return spaTipoCuenta;
    }

    public void setSpaValorCuenta(BigDecimal spaValorCuenta) {
        this.spaValorCuenta = spaValorCuenta;
    }

    public BigDecimal getSpaValorCuenta() {
        return spaValorCuenta;
    }

    public void setSpaVigencia(Integer spaVigencia) {
        this.spaVigencia = spaVigencia;
    }

    public Integer getSpaVigencia() {
        return spaVigencia;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }

    public void setEstadoSolicPagoVo(EstadoSolicPagoVO estadoSolicPagoVo) {
        this.estadoSolicPagoVo = estadoSolicPagoVo;
    }

    public EstadoSolicPagoVO getEstadoSolicPagoVo() {
        return estadoSolicPagoVo;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setSpaFechaSolFormat(String spaFechaSolFormat) {
        this.spaFechaSolFormat = spaFechaSolFormat;
    }

    public String getSpaFechaSolFormat() {
        return spaFechaSolFormat;
    }

    public void setObligacionList(List<ObligacionVO> obligacionList) {
        this.obligacionList = obligacionList;
    }

    public List<ObligacionVO> getObligacionList() {
        return obligacionList;
    }
    
    
    /**
     * Establece la Obligaci&oacute;n correspondiente a la Solicitud de Pago.
     * @param obligacionVo
     */
    public void setObligacion (ObligacionVO obligacionVo) {
        if (obligacionVo!=null) {
            if (obligacionList==null)
                obligacionList = new ArrayList<ObligacionVO>();
            
            obligacionList.add(obligacionVo);
        }
        else {
            if (obligacionList!=null)
                obligacionList.clear();
        }
    }


    /**
     * Obtiene el Tipo de Documento del Beneficiario.
     * @return rpVo->tipoDocumento
     */
    public String getTipoDocBeneficiario () 
    {
        return ( rpVo!=null&&rpVo.getProveedorVo()!=null&&rpVo.getProveedorVo().getPersonaVo()!=null?rpVo.getProveedorVo().getPersonaVo().getTipoIdentificacionNombreCorto():null);    
    }
    
    /**
     * Obtiene el Tipo de Documento del Beneficiario.
     * @return rpVo->numIdentificacion
     */
    public String getNumeroDocBeneficiario () 
    {
        return ( rpVo!=null&&rpVo.getProveedorVo()!=null&&rpVo.getProveedorVo().getPersonaVo()!=null?rpVo.getProveedorVo().getPersonaVo().getPerNumIdentificacion():null);    
    }
    
    /**
     * Obtiene el Tipo de Documento del Beneficiario.
     * @return rpVo->nombreCompleto
     */
    public String getNombreBeneficiario () 
    {
        return ( rpVo!=null&&rpVo.getProveedorVo()!=null&&rpVo.getProveedorVo().getPersonaVo()!=null?rpVo.getProveedorVo().getPersonaVo().getNombreCompleto():null);    
    }
    
    
    /**
     * Obtiene el C&oacute;digo del Beneficiario.
     * @return rpVo->proCodigo
     */
    public Long getCodigoBeneficiario () {
        return ( rpVo!=null&&rpVo.getProveedorVo()!=null&&rpVo.getProveedorVo()!=null?rpVo.getProveedorVo().getProCodigo():null);    
    }
    
    
    /**
     * Obtiene el Beneficiario.
     * @return rpVo->proveedorVo
     */
    public ProveedorVO getBeneficiario () {
        return ( rpVo!=null?rpVo.getProveedorVo():null);
    }


    public void setSpaSoportesOriginales(Long spaSoportesOriginales) {
        this.spaSoportesOriginales = spaSoportesOriginales;
    }

    public Long getSpaSoportesOriginales() {
        return spaSoportesOriginales;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public void setTipoDocSopSolicPagoVo(TipoDocSopSolicPagoVO tipoDocSopSolicPagoVo) {
        this.tipoDocSopSolicPagoVo = tipoDocSopSolicPagoVo;
    }

    public TipoDocSopSolicPagoVO getTipoDocSopSolicPagoVo() {
        return tipoDocSopSolicPagoVo;
    }
}
