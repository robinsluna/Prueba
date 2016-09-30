/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 02-07-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class LiquidaMetOnLineVO {
    private Long vmeCodigo;
    private Long invCodigo;
    private BigDecimal valorInicialVentas;
    private BigDecimal valorModifVentas;
    private BigDecimal valorCorrecVentas;
    private BigDecimal valorConsulta;
    private Integer porcentaje;
    
    
    public LiquidaMetOnLineVO() {        
    }

    public void setVmeCodigo(Long vmeCodigo) {
        this.vmeCodigo = vmeCodigo;
    }

    public Long getVmeCodigo() {
        return vmeCodigo;
    }

    public void setInvCodigo(Long invCodigo) {
        this.invCodigo = invCodigo;
    }

    public Long getInvCodigo() {
        return invCodigo;
    }

    public void setValorInicialVentas(BigDecimal valorInicialVentas) {
        this.valorInicialVentas = valorInicialVentas;
    }

    public BigDecimal getValorInicialVentas() {
        return valorInicialVentas;
    }

    public void setValorModifVentas(BigDecimal valorModifVentas) {
        this.valorModifVentas = valorModifVentas;
    }

    public BigDecimal getValorModifVentas() {
        return valorModifVentas;
    }

    public void setValorCorrecVentas(BigDecimal valorCorrecVentas) {
        this.valorCorrecVentas = valorCorrecVentas;
    }

    public BigDecimal getValorCorrecVentas() {
        return valorCorrecVentas;
    }


    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }


    public void setValorConsulta(BigDecimal valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }
}
