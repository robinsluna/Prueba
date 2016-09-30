package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class OficioLiquidacionPrevioVO {
    private Long tapCodigo;
    private String tap_nombre;
    private Integer cantidad;
    private BigDecimal valorUnidad;
    private BigDecimal derechosExplMensual;
    private BigDecimal gastosAdministracionMensual;
    private BigDecimal valorTotalMensual;
    private Date fechaExpedicion;
    private String numeroSiito;
    private String nit;
    private String razonSocial;
    private Date fechaInicioContrato;
    private Date fechaFinContrato;
    private String numeroContrato; 
    private Integer mesesLiquidados;
    private String codigoApuesta;
    private Integer minimoSillas;
    private Long inventarioSillas;
    private Long oliCodigo;
    private String estado;
    private Long conCodigo;
    private Date fechaInicioLiq;
    private Date fechaFinLiq;
    private Long idEstablecimiento;
    private Long idMet;
    private String indicadorOnLine;
    private Integer sauCodigo;
    private String establecimiento;
    private Date fechaFinDefinitiva;
    private Long invCodigo;
    private String indicadorLiq;
	private String nuc;
   
    
    public OficioLiquidacionPrevioVO() {
    }

@Override
    public Object clone() {
        OficioLiquidacionPrevioVO oficio = new OficioLiquidacionPrevioVO();
        oficio.tapCodigo = tapCodigo;
        oficio.tap_nombre = tap_nombre;
        oficio.cantidad = cantidad;
        oficio.valorUnidad =  valorUnidad;
            oficio.derechosExplMensual = derechosExplMensual;
            oficio.gastosAdministracionMensual = gastosAdministracionMensual;
            oficio.valorTotalMensual = valorTotalMensual;
            oficio.fechaExpedicion = fechaExpedicion;
            oficio.numeroSiito =  numeroSiito;
            oficio.nit = nit;
            oficio.razonSocial = razonSocial;
            oficio.fechaInicioContrato =  fechaInicioContrato;
            oficio.fechaFinContrato =  fechaFinContrato;
            oficio.numeroContrato =  numeroContrato; 
            oficio.mesesLiquidados =  mesesLiquidados;
            oficio.codigoApuesta = codigoApuesta;
            oficio.minimoSillas = minimoSillas;
            oficio.inventarioSillas = inventarioSillas;
            oficio.oliCodigo = oliCodigo;
            oficio.estado = estado;
            oficio.conCodigo = conCodigo;
            oficio.fechaInicioLiq = fechaInicioLiq;
            oficio.fechaFinLiq = fechaFinLiq;
            oficio.idEstablecimiento = idEstablecimiento;
            oficio.idMet = idMet;
            oficio.indicadorOnLine = indicadorOnLine;
            oficio.sauCodigo = sauCodigo;
            oficio.establecimiento = establecimiento;
            oficio.fechaFinDefinitiva = fechaFinDefinitiva;
            oficio.invCodigo = invCodigo;
            oficio.indicadorLiq = indicadorLiq;
            oficio.nuc = nuc;
                        
        return oficio;
    }

    public void setTapCodigo(Long tapCodigo) {
        this.tapCodigo = tapCodigo;
    }

    public Long getTapCodigo() {
        return tapCodigo;
    }

    public void setTap_nombre(String tap_nombre) {
        this.tap_nombre = tap_nombre;
    }

    public String getTap_nombre() {
        return tap_nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setValorUnidad(BigDecimal valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public BigDecimal getValorUnidad() {
        return valorUnidad;
    }

    public void setDerechosExplMensual(BigDecimal derechosExplMensual) {
        this.derechosExplMensual = derechosExplMensual;
    }

    public BigDecimal getDerechosExplMensual() {
        return derechosExplMensual;
    }


    public void setGastosAdministracionMensual(BigDecimal gastosAdministracionMensual) {
        this.gastosAdministracionMensual = gastosAdministracionMensual;
    }

    public BigDecimal getGastosAdministracionMensual() {
        return gastosAdministracionMensual;
    }

    public void setValorTotalMensual(BigDecimal valorTotalMensual) {
        this.valorTotalMensual = valorTotalMensual;
    }

    public BigDecimal getValorTotalMensual() {
        return valorTotalMensual;
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

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNit() {
        return nit;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
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

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNumeroContrato() {
        return numeroContrato;
    }


    public void setMesesLiquidados(Integer mesesLiquidados) {
        this.mesesLiquidados = mesesLiquidados;
    }

    public Integer getMesesLiquidados() {
        return mesesLiquidados;
    }


    public void setCodigoApuesta(String codigoApuesta) {
        this.codigoApuesta = codigoApuesta;
    }

    public String getCodigoApuesta() {
        return codigoApuesta;
    }

    public void setMinimoSillas(Integer minimoSillas) {
        this.minimoSillas = minimoSillas;
    }

    public Integer getMinimoSillas() {
        return minimoSillas;
    }

    public void setInventarioSillas(Long inventarioSillas) {
        this.inventarioSillas = inventarioSillas;
    }

    public Long getInventarioSillas() {
        return inventarioSillas;
    }

    public void setOliCodigo(Long oliCodigo) {
        this.oliCodigo = oliCodigo;
    }

    public Long getOliCodigo() {
        return oliCodigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setConCodigo(Long conCodigo) {
        this.conCodigo = conCodigo;
    }

    public Long getConCodigo() {
        return conCodigo;
    }

    public void setFechaInicioLiq(Date fechaInicioLiq) {
        this.fechaInicioLiq = fechaInicioLiq;
    }

    public Date getFechaInicioLiq() {
        return fechaInicioLiq;
    }

    public void setFechaFinLiq(Date fechaFinLiq) {
        this.fechaFinLiq = fechaFinLiq;
    }

    public Date getFechaFinLiq() {
        return fechaFinLiq;
    }

    public void setIdEstablecimiento(Long idEstablecimiento) {
        this.idEstablecimiento = idEstablecimiento;
    }

    public Long getIdEstablecimiento() {
        return idEstablecimiento;
    }

    public void setIdMet(Long idMet) {
        this.idMet = idMet;
    }

    public Long getIdMet() {
        return idMet;
    }

    public void setIndicadorOnLine(String indicadorOnLine) {
        this.indicadorOnLine = indicadorOnLine;
    }

    public String getIndicadorOnLine() {
        return indicadorOnLine;
    }

    public void setSauCodigo(Integer sauCodigo) {
        this.sauCodigo = sauCodigo;
    }

    public Integer getSauCodigo() {
        return sauCodigo;
    }

	public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setFechaFinDefinitiva(Date fechaFinDefinitiva) {
        this.fechaFinDefinitiva = fechaFinDefinitiva;
    }

    public Date getFechaFinDefinitiva() {
        return fechaFinDefinitiva;
    }

    public void setInvCodigo(Long invCodigo) {
        this.invCodigo = invCodigo;
    }

    public Long getInvCodigo() {
        return invCodigo;
    }


    public void setIndicadorLiq(String indicadorLiq) {
        this.indicadorLiq = indicadorLiq;
    }

    public String getIndicadorLiq() {
        return indicadorLiq;
    }
	public void setNuc(String nuc) {
        this.nuc = nuc;
    }

    public String getNuc() {
        return nuc;
    }
}
