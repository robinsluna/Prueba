package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;

public class RecaudoEstablecimientoManualVO {
    
     private Long codigo; 
     private String numeroContrato;
     private PersonaVO personaVo;
     private Long numeroCuota;
     private Date fechaPago;
     private Long ddeCodigo;
     private BigDecimal valorPago;
     private DetalleDeclaracionVO detalleDeclaracionVo;
     private AsignacionRecaudoVO asignacionRecaudoVo;
     private String estado;
    
    
    public RecaudoEstablecimientoManualVO() {
       
    }


    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }


    public void setPersonaVo(PersonaVO personaVo) {
        this.personaVo = personaVo;
    }

    public PersonaVO getPersonaVo() {
        return personaVo;
    }

    public void setNumeroCuota(Long numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Long getNumeroCuota() {
        return numeroCuota;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setDdeCodigo(Long ddeCodigo) {
        this.ddeCodigo = ddeCodigo;
    }

    public Long getDdeCodigo() {
        return ddeCodigo;
    }

    public void setDetalleDeclaracionVo(DetalleDeclaracionVO detalleDeclaracionVo) {
        this.detalleDeclaracionVo = detalleDeclaracionVo;
    }

    public DetalleDeclaracionVO getDetalleDeclaracionVo() {
        return detalleDeclaracionVo;
    }


    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setAsignacionRecaudoVo(AsignacionRecaudoVO asignacionRecaudoVo) {
        this.asignacionRecaudoVo = asignacionRecaudoVo;
    }

    public AsignacionRecaudoVO getAsignacionRecaudoVo() {
        return asignacionRecaudoVo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

}
