package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class AmortizacionVO {
    private Integer numCuota;
    private Date fechaPago;
    private BigDecimal saldoInicial;
    private BigDecimal valorAmortizacion;
    private BigDecimal interesFinanciacion;
    private BigDecimal cuotaInteresesNoFinanciados;
    private BigDecimal totalCuota;
    private BigDecimal saldoFinal; 
    private BigDecimal cuota;
    private BigDecimal valorFinal;
    
    
    public AmortizacionVO() {        
    }

    public void setNumCuota(Integer numCuota) {
        this.numCuota = numCuota;
    }

    public Integer getNumCuota() {
        return numCuota;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setSaldoInicial(BigDecimal saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public BigDecimal getSaldoInicial() {
        return saldoInicial;
    }

    public void setValorAmortizacion(BigDecimal valorAmortizacion) {
        this.valorAmortizacion = valorAmortizacion;
    }

    public BigDecimal getValorAmortizacion() {
        return valorAmortizacion;
    }

    public void setInteresFinanciacion(BigDecimal interesFinanciacion) {
        this.interesFinanciacion = interesFinanciacion;
    }

    public BigDecimal getInteresFinanciacion() {
        return interesFinanciacion;
    }

    public void setCuotaInteresesNoFinanciados(BigDecimal cuotaInteresesNoFinanciados) {
        this.cuotaInteresesNoFinanciados = cuotaInteresesNoFinanciados;
    }

    public BigDecimal getCuotaInteresesNoFinanciados() {
        return cuotaInteresesNoFinanciados;
    }

    public void setTotalCuota(BigDecimal totalCuota) {
        this.totalCuota = totalCuota;
    }

    public BigDecimal getTotalCuota() {
        return totalCuota;
    }

    public void setSaldoFinal(BigDecimal saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public BigDecimal getSaldoFinal() {
        return saldoFinal;
    }


    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    public BigDecimal getCuota() {
        return cuota;
    }


    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }
}
