/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Camilo Miranda
 * FECHA	: 16-05-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


/**
 * Value Object para un Registro del archivo utilizado para el Cargue de N&oacute;mina.
 * @author Camilo Miranda
 */
public class RegistroCargaNominaVO 
{
    /** CONTRATO */
    private Long contrato;
    /** CONCEPTO */
    private String concepto;
    /** TIPO DE DOCUMENTO */
    private Long tipoDocumento;
    /** NUMERO DE DOCUMENTO */
    private String numeroDocumento;
    /** DIGITO DE VERIFICACION */
    private Integer digitoVerificacion;
    /** FUENTE DE FINANCIACION */
    private String ffcCodigo;
    /** REFERENCIA 1 */
    private String referencia1;
    /** REFERENCIA 2 */
    private String referencia2;
    /** CENTRO DE COSTOS */
    private Long centroCostos;
    /** VALOR */
    private BigDecimal valor;
    /** TIPO DE RETENCION */
    private String tipoRetencion;
    
    /** ¿REGISTRO SATISFACTORIAMENTE CARGADO? */
    private boolean satisfactorio;
    /** OBSERVACIONES */
    private String observaciones;
    
    
    
    /**
     * Constructor.
     */
    public RegistroCargaNominaVO() { }

    
    
    public void setContrato(Long contrato) {
        this.contrato = contrato;
    }

    public Long getContrato() {
        return contrato;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
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

    public void setCentroCostos(Long centroCostos) {
        this.centroCostos = centroCostos;
    }

    public Long getCentroCostos() {
        return centroCostos;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setTipoRetencion(String tipoRetencion) {
        this.tipoRetencion = tipoRetencion;
    }

    public String getTipoRetencion() {
        return tipoRetencion;
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
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object o) {
        boolean resultado = false;
        if (o!=null && o instanceof RegistroCargaNominaVO) {
            RegistroCargaNominaVO reg = (RegistroCargaNominaVO) o;
            
            resultado = ( (contrato!=null && contrato.equals(reg.contrato)) || (contrato==null && reg.contrato==null) ) && 
                        ( (concepto!=null && concepto.equals(reg.concepto)) || (concepto==null && reg.concepto==null) ) && 
                        ( (tipoDocumento!=null && tipoDocumento.equals(reg.tipoDocumento)) || (tipoDocumento==null && reg.tipoDocumento==null) ) && 
                        ( (numeroDocumento!=null && numeroDocumento.equals(reg.numeroDocumento)) || (numeroDocumento==null && reg.numeroDocumento==null) ) && 
                        ( (digitoVerificacion!=null && digitoVerificacion.equals(reg.digitoVerificacion)) || (digitoVerificacion==null && reg.digitoVerificacion==null) ) && 
                        ( (ffcCodigo!=null && ffcCodigo.equals(reg.ffcCodigo)) || (ffcCodigo==null && reg.ffcCodigo==null) ) && 
                        ( (referencia1!=null && referencia1.equals(reg.referencia1)) || (referencia1==null && reg.referencia1==null) ) && 
                        ( (referencia2!=null && referencia2.equals(reg.referencia2)) || (referencia2==null && reg.referencia2==null) ) && 
                        ( (centroCostos!=null && centroCostos.equals(reg.centroCostos)) || (centroCostos==null && reg.centroCostos==null) ) && 
                        ( (valor!=null && valor.equals(reg.valor)) || (valor==null && reg.valor==null) ) && 
                        ( (tipoRetencion!=null && tipoRetencion.equals(reg.tipoRetencion)) || (tipoRetencion==null && reg.tipoRetencion==null) );

        }
        
        return (resultado);
    }
}
