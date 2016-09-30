/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 04-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class InventarioContratoVO {
     
    private Long codigoContrato;
    private String numeroContrato;
    private Long codigoOperador;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;
    private Long codigoInventario;
    private Date fechaInicioLiquidacion;
    private Date fechaFinLiquidacion;
    private Long codigoTipoApuesta;
    private String derechosExplotacion;
    private String gastosAdministracion;
    private Long codigoApuesta;
    private String apuesta;
    private Integer minimoSillas;
    private Integer inventarioSillas;
    private Long tipoInstrumento;
    private Long codigoNovedad;
        
    public InventarioContratoVO() {
    }


    public void setCodigoContrato(Long codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Long getCodigoContrato() {
        return codigoContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setCodigoOperador(Long codigoOperador) {
        this.codigoOperador = codigoOperador;
    }

    public Long getCodigoOperador() {
        return codigoOperador;
    }

    public void setFechaInicioContrato(Date fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public Date getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaFinContrato(Date fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public Date getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setCodigoInventario(Long codigoInventario) {
        this.codigoInventario = codigoInventario;
    }

    public Long getCodigoInventario() {
        return codigoInventario;
    }

    public void setFechaInicioLiquidacion(Date fechaInicioLiquidacion) {
        this.fechaInicioLiquidacion = fechaInicioLiquidacion;
    }

    public Date getFechaInicioLiquidacion() {
        return fechaInicioLiquidacion;
    }

    public void setFechaFinLiquidacion(Date fechaFinLiquidacion) {
        this.fechaFinLiquidacion = fechaFinLiquidacion;
    }

    public Date getFechaFinLiquidacion() {
        return fechaFinLiquidacion;
    }

    public void setCodigoTipoApuesta(Long codigoTipoApuesta) {
        this.codigoTipoApuesta = codigoTipoApuesta;
    }

    public Long getCodigoTipoApuesta() {
        return codigoTipoApuesta;
    }

    public void setDerechosExplotacion(String derechosExplotacion) {
        this.derechosExplotacion = derechosExplotacion;
    }

    public String getDerechosExplotacion() {
        return derechosExplotacion;
    }

    public void setGastosAdministracion(String gastosAdministracion) {
        this.gastosAdministracion = gastosAdministracion;
    }

    public String getGastosAdministracion() {
        return gastosAdministracion;
    }

    public void setCodigoApuesta(Long codigoApuesta) {
        this.codigoApuesta = codigoApuesta;
    }

    public Long getCodigoApuesta() {
        return codigoApuesta;
    }

    public void setApuesta(String apuesta) {
        this.apuesta = apuesta;
    }

    public String getApuesta() {
        return apuesta;
    }

    public void setMinimoSillas(Integer minimoSillas) {
        this.minimoSillas = minimoSillas;
    }

    public Integer getMinimoSillas() {
        return minimoSillas;
    }

    public void setInventarioSillas(Integer inventarioSillas) {
        this.inventarioSillas = inventarioSillas;
    }

    public Integer getInventarioSillas() {
        return inventarioSillas;
    }

    public void setTipoInstrumento(Long tipoInstrumento) {
        this.tipoInstrumento = tipoInstrumento;
    }

    public Long getTipoInstrumento() {
        return tipoInstrumento;
    }

    public void setCodigoNovedad(Long codigoNovedad) {
        this.codigoNovedad = codigoNovedad;
    }

    public Long getCodigoNovedad() {
        return codigoNovedad;
    }

}
