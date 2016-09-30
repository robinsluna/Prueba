package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class AcuerdoPagoAbonoVO {
    
    private BigDecimal cuota;
    private BigDecimal codigoConcepto;
    private String abreviaturaConcepto;
    private BigDecimal valorAplicarCapital;
    private BigDecimal valorAplicarInteres; 
    private String descripcionConcepto;
    private Long copCodigo;
    
    
    public AcuerdoPagoAbonoVO() {
        
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setCodigoConcepto(BigDecimal codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }

    public BigDecimal getCodigoConcepto() {
        return codigoConcepto;
    }

    public void setValorAplicarCapital(BigDecimal valorAplicarCapital) {
        this.valorAplicarCapital = valorAplicarCapital;
    }

    public BigDecimal getValorAplicarCapital() {
        return valorAplicarCapital;
    }

    public void setValorAplicarInteres(BigDecimal valorAplicarInteres) {
        this.valorAplicarInteres = valorAplicarInteres;
    }

    public BigDecimal getValorAplicarInteres() {
        return valorAplicarInteres;
    }

    public void setAbreviaturaConcepto(String abreviaturaConcepto) {
        this.abreviaturaConcepto = abreviaturaConcepto;
    }

    public String getAbreviaturaConcepto() {
        return abreviaturaConcepto;
    }

    public void setDescripcionConcepto(String descripcionConcepto) {
        this.descripcionConcepto = descripcionConcepto;
    }

    public String getDescripcionConcepto() {
        return descripcionConcepto;
    }


    public void setCopCodigo(Long copCodigo) {
        this.copCodigo = copCodigo;
    }

    public Long getCopCodigo() {
        return copCodigo;
    }
}
