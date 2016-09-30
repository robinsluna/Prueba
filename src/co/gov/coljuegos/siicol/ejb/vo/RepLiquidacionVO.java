/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 20-10-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;

public class RepLiquidacionVO {
    private String contrato;
    private int cuota;
    private String establecimiento;
    private String tipoElemento;
    private Integer numeroSillas;
    private Integer minimoSillas;
    private String tipoApuesta;
    private String tarifaMesFormula;
    private BigDecimal tarifaMes;
    private BigDecimal tarifaDia;
    private Integer numeroDias;
    private BigDecimal valorDELiquidado;
    private BigDecimal valorGALiquidado;
    private Date fechaInicioLiq;
    private Date fechaFinLiq;
           
    
    public RepLiquidacionVO() {
       
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getContrato() {
        return contrato;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public int getCuota() {
        return cuota;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setTipoElemento(String tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public String getTipoElemento() {
        return tipoElemento;
    }

    public void setNumeroSillas(Integer numeroSillas) {
        this.numeroSillas = numeroSillas;
    }

    public Integer getNumeroSillas() {
        return numeroSillas;
    }

    public void setMinimoSillas(Integer minimoSillas) {
        this.minimoSillas = minimoSillas;
    }

    public Integer getMinimoSillas() {
        return minimoSillas;
    }

    public void setTipoApuesta(String tipoApuesta) {
        this.tipoApuesta = tipoApuesta;
    }

    public String getTipoApuesta() {
        return tipoApuesta;
    }

    public void setTarifaMesFormula(String tarifaMesFormula) {
        this.tarifaMesFormula = tarifaMesFormula;
    }

    public String getTarifaMesFormula() {
        return tarifaMesFormula;
    }

    public void setTarifaMes(BigDecimal tarifaMes) {
        this.tarifaMes = tarifaMes;
    }

    public BigDecimal getTarifaMes() {
        return tarifaMes;
    }

    public void setTarifaDia(BigDecimal tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public BigDecimal getTarifaDia() {
        return tarifaDia;
    }

    public void setNumeroDias(Integer numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Integer getNumeroDias() {
        return numeroDias;
    }

    public void setValorDELiquidado(BigDecimal valorDELiquidado) {
        this.valorDELiquidado = valorDELiquidado;
    }

    public BigDecimal getValorDELiquidado() {
        return valorDELiquidado;
    }

    public void setValorGALiquidado(BigDecimal valorGALiquidado) {
        this.valorGALiquidado = valorGALiquidado;
    }

    public BigDecimal getValorGALiquidado() {
        return valorGALiquidado;
    }

    public void setFechaInicioLiq(Date fechaInicioLiq) {
        this.fechaInicioLiq = fechaInicioLiq;
    }

    public Date getFechaInicioLiq() {
        return fechaInicioLiq;
    }

    public void setFechaFinLiq(Date fechaFinLiq) {
        this.fechaFinLiq = fechaFinLiq;
    }

    public Date getFechaFinLiq() {
        return fechaFinLiq;
    }
}
