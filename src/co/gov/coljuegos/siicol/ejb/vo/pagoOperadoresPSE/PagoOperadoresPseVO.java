/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 03-02-2014
 */
package co.gov.coljuegos.siicol.ejb.vo.pagoOperadoresPSE;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoPse;

import java.math.BigDecimal;

import java.util.Date;

public class PagoOperadoresPseVO {
    
    private Long rpsCodigo;
    private Date rpsFechaEstado;
    private String rpsCodigoTrans;
    private String rpsReferencia1;
    private String rpsReferencia2;
    private BigDecimal valorPagado;
    private String rpsEstado;
      
    public PagoOperadoresPseVO() {
       
       
    }
    public PagoOperadoresPseVO(SiiRecaudoPse siiRecaudoPse) {
        this.setRpsCodigo(siiRecaudoPse.getRpsCodigo());
        this.setRpsCodigoTrans(siiRecaudoPse.getRpsCodigoTrans());
        this.setRpsFechaEstado(siiRecaudoPse.getRpsFechaEstado());
        this.setRpsReferencia1(siiRecaudoPse.getRpsReferencia1());
        this.setRpsEstado(siiRecaudoPse.getRpsEstado());
       //falta estado
       
    }

    public void setRpsEstado(String rpsEstado) {
        this.rpsEstado = rpsEstado;
    }

    public String getRpsEstado() {
        return rpsEstado;
    }

    public void setValorPagado(BigDecimal valorPagado) {
        this.valorPagado = valorPagado;
    }

    public BigDecimal getValorPagado() {
        return valorPagado;
    }

    public void setRpsCodigo(Long rpsCodigo) {
        this.rpsCodigo = rpsCodigo;
    }

    public Long getRpsCodigo() {
        return rpsCodigo;
    }

    public void setRpsFechaEstado(Date rpsFechaEstado) {
        this.rpsFechaEstado = rpsFechaEstado;
    }

    public Date getRpsFechaEstado() {
        return rpsFechaEstado;
    }

    public void setRpsCodigoTrans(String rpsCodigoTrans) {
        this.rpsCodigoTrans = rpsCodigoTrans;
    }

    public String getRpsCodigoTrans() {
        return rpsCodigoTrans;
    }

    public void setRpsReferencia1(String rpsReferencia1) {
        this.rpsReferencia1 = rpsReferencia1;
    }

    public String getRpsReferencia1() {
        return rpsReferencia1;
    }

    public void setRpsReferencia2(String rpsReferencia2) {
        this.rpsReferencia2 = rpsReferencia2;
    }

    public String getRpsReferencia2() {
        return rpsReferencia2;
    }
}
