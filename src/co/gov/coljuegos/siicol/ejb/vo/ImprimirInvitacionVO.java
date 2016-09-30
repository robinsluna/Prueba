package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ImprimirInvitacionVO {
   
    private BigDecimal valorContract;
    private String objeto;
    private String formaPago;
    private Integer tiempoDurac;
    private String unidadDurac;
    private String obligaciones;
    private Date fechaVencimiento;
   
    
    public ImprimirInvitacionVO() {
    }   

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setTiempoDurac(Integer tiempoDurac) {
        this.tiempoDurac = tiempoDurac;
    }

    public Integer getTiempoDurac() {
        return tiempoDurac;
    }

    public void setUnidadDurac(String unidadDurac) {
        this.unidadDurac = unidadDurac;
    }

    public String getUnidadDurac() {
        return unidadDurac;
    }

    public void setObligaciones(String obligaciones) {
        this.obligaciones = obligaciones;
    }

    public String getObligaciones() {
        return obligaciones;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setValorContract(BigDecimal valorContract) {
        this.valorContract = valorContract;
    }

    public BigDecimal getValorContract() {
        return valorContract;
    }

}
