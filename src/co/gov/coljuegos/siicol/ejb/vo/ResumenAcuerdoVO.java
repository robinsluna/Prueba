package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class ResumenAcuerdoVO {
    private String descripcionConcepto;
    private BigDecimal cuota;
    private BigDecimal saldoDeuda;
    private BigDecimal saldoInteres;
    private BigDecimal porcentajeDeuda;    
    private BigDecimal abonoInicial;   
    private BigDecimal valorAplicarCapital;
    private BigDecimal valorAplicarInteres;
    private BigDecimal total;
    private BigDecimal codigoConcepto;
    private Long copCodigo;
    
    
    public ResumenAcuerdoVO() {        
    }


    public void setDescripcionConcepto(String descripcionConcepto) {
        this.descripcionConcepto = descripcionConcepto;
    }

    public String getDescripcionConcepto() {
        return descripcionConcepto;
    }

    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getCuota() {
        return cuota;
    }

    public void setSaldoDeuda(BigDecimal saldoDeuda) {
        this.saldoDeuda = saldoDeuda;
    }

    public BigDecimal getSaldoDeuda() {
        return saldoDeuda;
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

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }


    public void setSaldoInteres(BigDecimal saldoInteres) {
        this.saldoInteres = saldoInteres;
    }

    public BigDecimal getSaldoInteres() {
        return saldoInteres;
    }

    public void setPorcentajeDeuda(BigDecimal porcentajeDeuda) {
        this.porcentajeDeuda = porcentajeDeuda;
    }

    public BigDecimal getPorcentajeDeuda() {
        return porcentajeDeuda;
    }

    public void setAbonoInicial(BigDecimal abonoInicial) {
        this.abonoInicial = abonoInicial;
    }

    public BigDecimal getAbonoInicial() {
        return abonoInicial;
    }


    public void setCodigoConcepto(BigDecimal codigoConcepto) {
        this.codigoConcepto = codigoConcepto;
    }

    public BigDecimal getCodigoConcepto() {
        return codigoConcepto;
    }

    public void setCopCodigo(Long copCodigo) {
        this.copCodigo = copCodigo;
    }

    public Long getCopCodigo() {
        return copCodigo;
    }
}
