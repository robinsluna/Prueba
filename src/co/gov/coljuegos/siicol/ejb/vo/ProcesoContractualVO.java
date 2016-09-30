package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRepartoFiscalizador;

import java.util.Date;
import java.util.List;

public class ProcesoContractualVO {
    
    private String numProceso;
    private String tipoActuacion;
    private String Contrato;
    private String razonSocial;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaAsignacion;
    
    private Long icnCodigo;
    private Long rfsCodigo;
    
    public ProcesoContractualVO() {
        
    }

    public String getNumProceso() {
        return numProceso;
    }

    public void setNumProceso(String numProceso) {
        this.numProceso = numProceso;
    }

    public String getTipoActuacion() {
        return tipoActuacion;
    }

    public void setTipoActuacion(String tipoActuacion) {
        this.tipoActuacion = tipoActuacion;
    }

    public String getContrato() {
        return Contrato;
    }

    public void setContrato(String Contrato) {
        this.Contrato = Contrato;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Long getIcnCodigo() {
        return icnCodigo;
    }

    public void setIcnCodigo(Long icnCodigo) {
        this.icnCodigo = icnCodigo;
    }

    public Long getRfsCodigo() {
        return rfsCodigo;
    }

    public void setRfsCodigo(Long rfsCodigo) {
        this.rfsCodigo = rfsCodigo;
    }
}
