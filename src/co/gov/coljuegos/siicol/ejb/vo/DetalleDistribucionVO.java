package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import javax.xml.rpc.holders.BigDecimalHolder;

public class DetalleDistribucionVO {
    private String depto;
    private String municipio;
    private String codDepto;
    private String codMunicipio;
    private String concepto;
    private String tipoConcepto;
    private BigDecimal valorRecaudo;
    private BigDecimal valorPropio;
    private BigDecimal valorTodos;
    private BigDecimal valorDeTodos;
    
    public DetalleDistribucionVO() {        
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getDepto() {
        return depto;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setTipoConcepto(String tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

    public String getTipoConcepto() {
        return tipoConcepto;
    }

    public void setValorRecaudo(BigDecimal valorRecaudo) {
        this.valorRecaudo = valorRecaudo;
    }

    public BigDecimal getValorRecaudo() {
        return valorRecaudo;
    }

    public void setValorPropio(BigDecimal valorPropio) {
        this.valorPropio = valorPropio;
    }

    public BigDecimal getValorPropio() {
        return valorPropio;
    }

    public void setValorTodos(BigDecimal valorTodos) {
        this.valorTodos = valorTodos;
    }

    public BigDecimal getValorTodos() {
        return valorTodos;
    }

    public void setValorDeTodos(BigDecimal valorDeTodos) {
        this.valorDeTodos = valorDeTodos;
    }

    public BigDecimal getValorDeTodos() {
        return valorDeTodos;
    }

}
