/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 28-04-2015
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


/**
 * Value Object para un Registro del archivo utilizado para el Cargue de Comprobantes Contables.
 * @author Camilo Miranda
 */
public class RegistroCargaComprobanteContableVO 
{
    /** TIPO DE COMPROBANTE */
    private String tipoComprobante;
    /** NUMERO DE COMPROBANTE */
    private Integer numeroComprobante;
    /** FECHA OPERACION */
    private Date fechaOperacion;
    /** PERIODO CONTABLE */
    private String periodoContable;
    /** CUENTA CONTABLE */
    private String cuentaContable;
    /** TIPO DE MOVIMIENTO */
    private String tipoMovimiento;
    /** TIPO DE DOCUMENTO */
    private Long tipoDocumento;
    /** NUMERO DE DOCUMENTO */
    private String numeroDocumento;
    /** DIGITO DE VERIFICACION */
    private Integer digitoVerificacion;
    /** FUENTE DE FINANCIACION */
    private String ffcCodigo;
    /** CENTRO DE COSTOS */
    private String centroCostos;
    /** REFERENCIA 1 */
    private String referencia1;
    /** REFERENCIA 2 */
    private String referencia2;
    /** CONCEPTO */
    private String concepto;
    /** DESCRIPCION DE LA OPERACION */
    private String descripcionOperacion;
    /** VALOR */
    private BigDecimal valor;
    
    
    /** ¿REGISTRO SATISFACTORIAMENTE CARGADO? */
    private boolean satisfactorio;
    /** OBSERVACIONES */
    private String observaciones;
    
    
    ///////////////////////////////////////////
    // Value Objects asociados a los campos. //
    ///////////////////////////////////////////
    private TipoDocContableVO tipoDocContableVo;
    private CuentasContablesVO cuentasContablesVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    private PersonaVO personaVo;
    private AreaColjuegosVO areaColjuegosVo;
    
    
    
    /**
     * Constructor.
     */
    public RegistroCargaComprobanteContableVO() { }

    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        boolean resultado = false;
        if (o!=null && o instanceof RegistroCargaComprobanteContableVO) {
            RegistroCargaComprobanteContableVO reg = (RegistroCargaComprobanteContableVO) o;
            
            resultado = ( (tipoComprobante!=null && tipoComprobante.equals(reg.tipoComprobante)) || (tipoComprobante==null && reg.tipoComprobante==null) ) && 
                        ( (numeroComprobante!=null && numeroComprobante.equals(reg.numeroComprobante)) || (numeroComprobante==null && reg.numeroComprobante==null) ) && 
                        ( (fechaOperacion!=null && fechaOperacion.equals(reg.fechaOperacion)) || (fechaOperacion==null && reg.fechaOperacion==null) ) && 
                        ( (cuentaContable!=null && cuentaContable.equals(reg.cuentaContable)) || (cuentaContable==null && reg.cuentaContable==null) ) && 
                        ( (tipoMovimiento!=null && tipoMovimiento.equals(reg.tipoMovimiento)) || (tipoMovimiento==null && reg.tipoMovimiento==null) ) && 
                        ( (tipoDocumento!=null && tipoDocumento.equals(reg.tipoDocumento)) || (tipoDocumento==null && reg.tipoDocumento==null) ) && 
                        ( (numeroDocumento!=null && numeroDocumento.equals(reg.numeroDocumento)) || (numeroDocumento==null && reg.numeroDocumento==null) ) && 
                        ( (digitoVerificacion!=null && digitoVerificacion.equals(reg.digitoVerificacion)) || (digitoVerificacion==null && reg.digitoVerificacion==null) ) && 
                        ( (ffcCodigo!=null && ffcCodigo.equals(reg.ffcCodigo)) || (ffcCodigo==null && reg.ffcCodigo==null) ) && 
                        ( (referencia1!=null && referencia1.equals(reg.referencia1)) || (referencia1==null && reg.referencia1==null) ) && 
                        ( (referencia2!=null && referencia2.equals(reg.referencia2)) || (referencia2==null && reg.referencia2==null) ) && 
                        ( (centroCostos!=null && centroCostos.equals(reg.centroCostos)) || (centroCostos==null && reg.centroCostos==null) ) && 
                        ( (valor!=null && valor.equals(reg.valor)) || (valor==null && reg.valor==null) ) && 
                        ( (descripcionOperacion!=null && descripcionOperacion.equals(reg.descripcionOperacion)) || (descripcionOperacion==null && reg.descripcionOperacion==null) );

        }
        
        return (resultado);
    }
    
    
    
    
    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Integer getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setPeriodoContable(String periodoContable) {
        this.periodoContable = periodoContable;
    }

    public String getPeriodoContable() {
        return periodoContable;
    }

    public void setCuentaContable(String cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getCuentaContable() {
        return cuentaContable;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setDigitoVerificacion(Integer digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public Integer getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setReferencia1(String referencia1) {
        this.referencia1 = referencia1;
    }

    public String getReferencia1() {
        return referencia1;
    }

    public void setReferencia2(String referencia2) {
        this.referencia2 = referencia2;
    }

    public String getReferencia2() {
        return referencia2;
    }

    public void setSatisfactorio(boolean satisfactorio) {
        this.satisfactorio = satisfactorio;
    }

    public boolean isSatisfactorio() {
        return satisfactorio;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setTipoDocContableVo(TipoDocContableVO tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public TipoDocContableVO getTipoDocContableVo() {
        return tipoDocContableVo;
    }

    public void setCuentasContablesVo(CuentasContablesVO cuentasContablesVo) {
        this.cuentasContablesVo = cuentasContablesVo;
    }

    public CuentasContablesVO getCuentasContablesVo() {
        return cuentasContablesVo;
    }

    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }

    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setAreaColjuegosVo(AreaColjuegosVO areaColjuegosVo) {
        this.areaColjuegosVo = areaColjuegosVo;
    }

    public AreaColjuegosVO getAreaColjuegosVo() {
        return areaColjuegosVo;
    }
}
