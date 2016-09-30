package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOficioLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudAutoriza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class OfiLiquidacionSolAutorizaVO {
    private Integer consecutivo;   
    private Date fechaExpedicion;   
    private String numeroSiito;
    String razonSocial;
    String nit;
    String estado;
    Long oliCodigo;
    Long sauCodigo;
    private String nombreUsuario;
	private Long codigoContrato;
	private String tipoSolicitudAutoriza;
    
    public OfiLiquidacionSolAutorizaVO() {
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setNumeroSiito(String numeroSiito) {
        this.numeroSiito = numeroSiito;
    }

    public String getNumeroSiito() {
        return numeroSiito;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setOliCodigo(Long oliCodigo) {
        this.oliCodigo = oliCodigo;
    }

    public Long getOliCodigo() {
        return oliCodigo;
    }

    public void setSauCodigo(Long sauCodigo) {
        this.sauCodigo = sauCodigo;
    }

    public Long getSauCodigo() {
        return sauCodigo;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setCodigoContrato(Long codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Long getCodigoContrato() {
        return codigoContrato;
    }
	public void setTipoSolicitudAutoriza(String tipoSolicitudAutoriza) {
		this.tipoSolicitudAutoriza = tipoSolicitudAutoriza;
    }

    public String getTipoSolicitudAutoriza() {
        return tipoSolicitudAutoriza;
    }
}
