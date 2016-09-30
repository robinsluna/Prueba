package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class ReporteOperadorVO {
    private String concepto;
    private String numeroIdentificacion;
    private String razonSocial;
    private BigDecimal valor; 
    private BigDecimal valorIntereses;
    private Long codConcepto;
    
    private String departamento;
    private String municipio;
    private String codDane; 
    private String codDepto;
   
    
    
    public ReporteOperadorVO() {       
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setCodDane(String codDane) {
        this.codDane = codDane;
    }

    public String getCodDane() {
        return codDane;
    }


    public void setValorIntereses(BigDecimal valorIntereses) {
        this.valorIntereses = valorIntereses;
    }

    public BigDecimal getValorIntereses() {
        return valorIntereses;
    }

    public void setCodConcepto(Long codConcepto) {
        this.codConcepto = codConcepto;
    }

    public Long getCodConcepto() {
        return codConcepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodDepto() {
        return codDepto;
    }

}
