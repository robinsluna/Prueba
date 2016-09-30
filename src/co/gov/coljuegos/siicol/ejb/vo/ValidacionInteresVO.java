/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 23-05-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;

public class ValidacionInteresVO {
    
    private String numeroContrato;
    private long numeroCuota;
    private String descripcionconcepto;
    private long mesCuota;
    private long añoCuota;
    private Date fechaLimitePago;
    private BigDecimal valorCuota;
    private long codigoCuota;
    private BigDecimal saldo;
    private BigDecimal dia;
    private ArrayList<BigDecimal> diasMes = new ArrayList<BigDecimal>();
    private BigDecimal interesGenerado;
    private BigDecimal interesPago;
    private BigDecimal saldoInteres;
    
    
    public ValidacionInteresVO() {
     
    }


    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroCuota(long numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public long getNumeroCuota() {
        return numeroCuota;
    }

    public void setDescripcionconcepto(String descripcionconcepto) {
        this.descripcionconcepto = descripcionconcepto;
    }

    public String getDescripcionconcepto() {
        return descripcionconcepto;
    }

    public void setMesCuota(long mesCuota) {
        this.mesCuota = mesCuota;
    }

    public long getMesCuota() {
        return mesCuota;
    }

    public void setAñoCuota(long añoCuota) {
        this.añoCuota = añoCuota;
    }

    public long getAñoCuota() {
        return añoCuota;
    }

    public void setFechaLimitePago(Date fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public Date getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setValorCuota(BigDecimal valorCuota) {
        this.valorCuota = valorCuota;
    }

    public BigDecimal getValorCuota() {
        return valorCuota;
    }

    public void setCodigoCuota(long codigoCuota) {
        this.codigoCuota = codigoCuota;
    }

    public long getCodigoCuota() {
        return codigoCuota;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldoInteres(BigDecimal saldoInteres) {
        this.saldoInteres = saldoInteres;
    }

    public BigDecimal getSaldoInteres() {
        return saldoInteres;
    }

    public void setDia(BigDecimal dia) {
        this.dia = dia;
    }

    public BigDecimal getDia() {
        return dia;
    }


    public void setInteresGenerado(BigDecimal interesGenerado) {
        this.interesGenerado = interesGenerado;
    }

    public BigDecimal getInteresGenerado() {
        return interesGenerado;
    }

    public void setInteresPago(BigDecimal interesPago) {
        this.interesPago = interesPago;
    }

    public BigDecimal getInteresPago() {
        return interesPago;
    }


    public void setDiasMes(ArrayList<BigDecimal> diasMes) {
        this.diasMes = diasMes;
    }

    public ArrayList<BigDecimal> getDiasMes() {
        return diasMes;
    }
}
