/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 13-01-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


/**
 * Value Object para la Informaci&oacute;n de los Saldos de Imputaciones asociadas a Cuentas Contables.
 * @author Camilo Miranda
 */
public class InfoSaldoImpCuentaContabVO 
{
    private Long ccoCodigo;
    private Long acoCodigo;
    private String ffcCodigo;
    private Long perCodigo;
    private BigDecimal valorDebitos;
    private BigDecimal valorCreditos;
    private BigDecimal saldo;
    
    
    /**
     * Constructor.
     */
    public InfoSaldoImpCuentaContabVO() { }


    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    public Long getCcoCodigo() {
        return ccoCodigo;
    }

    public void setAcoCodigo(Long acoCodigo) {
        this.acoCodigo = acoCodigo;
    }

    public Long getAcoCodigo() {
        return acoCodigo;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setPerCodigo(Long perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Long getPerCodigo() {
        return perCodigo;
    }

    public void setValorDebitos(BigDecimal valorDebitos) {
        this.valorDebitos = valorDebitos;
    }

    public BigDecimal getValorDebitos() {
        return valorDebitos;
    }

    public void setValorCreditos(BigDecimal valorCreditos) {
        this.valorCreditos = valorCreditos;
    }

    public BigDecimal getValorCreditos() {
        return valorCreditos;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
