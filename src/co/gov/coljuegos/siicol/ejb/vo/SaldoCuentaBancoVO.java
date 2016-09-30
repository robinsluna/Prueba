/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 10-02-2014
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSaldoCtaBanco;

import java.math.BigDecimal;

import java.util.Date;

public class SaldoCuentaBancoVO {
   
   private Long scbCodigo;
   private BigDecimal scbSaldo;
   private String scbEstado;
   private Date scbFEcha;
   private CuentaBancariaVO cuentaBancariaVo;
   
   
    public SaldoCuentaBancoVO(SiiSaldoCtaBanco siiSaldoCtaBanco) {
    if(siiSaldoCtaBanco != null){
        this.setScbCodigo(siiSaldoCtaBanco.getScbCodigo());
        this.setScbEstado(siiSaldoCtaBanco.getScbEstado());
        this.setScbFEcha(siiSaldoCtaBanco.getScbFecha());
        this.setScbSaldo(siiSaldoCtaBanco.getScbSaldo());
        
        //padres
        if(siiSaldoCtaBanco.getSiiCuentaBancaria()!=null){
            this.cuentaBancariaVo= new CuentaBancariaVO(siiSaldoCtaBanco.getSiiCuentaBancaria());
        } 
        } 
    }
   
   
   
    public SaldoCuentaBancoVO() {
        
   
    }


    public void setScbCodigo(Long scbCodigo) {
        this.scbCodigo = scbCodigo;
    }

    public Long getScbCodigo() {
        return scbCodigo;
    }

    public void setScbSaldo(BigDecimal scbSaldo) {
        this.scbSaldo = scbSaldo;
    }

    public BigDecimal getScbSaldo() {
        return scbSaldo;
    }

    public void setScbEstado(String scbEstado) {
        this.scbEstado = scbEstado;
    }

    public String getScbEstado() {
        return scbEstado;
    }

    public void setScbFEcha(Date scbFEcha) {
        this.scbFEcha = scbFEcha;
    }

    public Date getScbFEcha() {
        return scbFEcha;
    }

    public void setCuentaBancariaVo(CuentaBancariaVO cuentaBancariaVo) {
        this.cuentaBancariaVo = cuentaBancariaVo;
    }

    public CuentaBancariaVO getCuentaBancariaVo() {
        return cuentaBancariaVo;
    }

}
