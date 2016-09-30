package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class AmparoOficioLiqVO {
    
    private String riesgos;
    private String vigencia;
    private BigDecimal valorTotalContrato;
    private String porcentaje;
    private BigDecimal valorAsegurar;
    private BigDecimal valorTotalAsegurar;        
    
    
    
    public AmparoOficioLiqVO() {        
    }

    public void setRiesgos(String riesgos) {
        this.riesgos = riesgos;
    }

    public String getRiesgos() {
        return riesgos;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setValorTotalContrato(BigDecimal valorTotalContrato) {
        this.valorTotalContrato = valorTotalContrato;
    }

    public BigDecimal getValorTotalContrato() {
        return valorTotalContrato;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setValorAsegurar(BigDecimal valorAsegurar) {
        this.valorAsegurar = valorAsegurar;
    }

    public BigDecimal getValorAsegurar() {
        return valorAsegurar;
    }

    public void setValorTotalAsegurar(BigDecimal valorTotalAsegurar) {
        this.valorTotalAsegurar = valorTotalAsegurar;
    }

    public BigDecimal getValorTotalAsegurar() {
        return valorTotalAsegurar;
    }

}
