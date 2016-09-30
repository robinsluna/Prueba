/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 10-01-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class PagoOperadorDetalleRefVO {
  
    private Long opfReferenciaPago;
    private BigDecimal opfValor;
    //private String opfProcedencia;
    //medio de pago
    private Long opfNumeroOperacion;
    private Long opfNumeroAutorizacion;
    private String opfEntidadFinanciera;
    private String opfSucursal;
    private String opfSecuencia;
    //tabla causales de devolucion
    // estado
  
  
    public PagoOperadorDetalleRefVO() {
        
    }


    public void setOpfReferenciaPago(Long opfReferenciaPago) {
        this.opfReferenciaPago = opfReferenciaPago;
    }

    public Long getOpfReferenciaPago() {
        return opfReferenciaPago;
    }

    public void setOpfValor(BigDecimal opfValor) {
        this.opfValor = opfValor;
    }

    public BigDecimal getOpfValor() {
        return opfValor;
    }

    public void setOpfNumeroOperacion(Long opfNumeroOperacion) {
        this.opfNumeroOperacion = opfNumeroOperacion;
    }

    public Long getOpfNumeroOperacion() {
        return opfNumeroOperacion;
    }

    public void setOpfNumeroAutorizacion(Long opfNumeroAutorizacion) {
        this.opfNumeroAutorizacion = opfNumeroAutorizacion;
    }

    public Long getOpfNumeroAutorizacion() {
        return opfNumeroAutorizacion;
    }

    public void setOpfEntidadFinanciera(String opfEntidadFinanciera) {
        this.opfEntidadFinanciera = opfEntidadFinanciera;
    }

    public String getOpfEntidadFinanciera() {
        return opfEntidadFinanciera;
    }

    public void setOpfSucursal(String opfSucursal) {
        this.opfSucursal = opfSucursal;
    }

    public String getOpfSucursal() {
        return opfSucursal;
    }

    public void setOpfSecuencia(String opfSecuencia) {
        this.opfSecuencia = opfSecuencia;
    }

    public String getOpfSecuencia() {
        return opfSecuencia;
    }

}
