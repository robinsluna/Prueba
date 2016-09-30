package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class SolicitudDetalleRubroCdpVO {
    
    Long ffi_codigo;
    String ffi_nombre;
    String ffi_descripcion;
    Long dff_codigo;
    String dff_descripcion;
    Long dru_codigo;
    String descripcion;
    BigDecimal dru_valor;
    Long vigencia;
    Long drc_codigo;
    Long cdp_codigo;
    BigDecimal cdp_valor;
    BigDecimal saldo_apropiacion;
    BigDecimal saldo_anterior;
    String aplica_gf;
    Long idGf;
    Long ffi_codigo_fuente;
    Long dff_ffi_codigo;
    String codigo_rubro;
    Long dff_codigo_recurso;

    public void setDff_codigo_recurso(Long dff_codigo_recurso) {
        this.dff_codigo_recurso = dff_codigo_recurso;
    }

    public Long getDff_codigo_recurso() {
        return dff_codigo_recurso;
    }

    public SolicitudDetalleRubroCdpVO() {        
    }

    public void setFfi_codigo(Long ffi_codigo) {
        this.ffi_codigo = ffi_codigo;
    }

    public Long getFfi_codigo() {
        return ffi_codigo;
    }

    public void setFfi_nombre(String ffi_nombre) {
        this.ffi_nombre = ffi_nombre;
    }

    public String getFfi_nombre() {
        return ffi_nombre;
    }

    public void setDff_codigo(Long dff_codigo) {
        this.dff_codigo = dff_codigo;
    }

    public Long getDff_codigo() {
        return dff_codigo;
    }

    public void setDff_descripcion(String dff_descripcion) {
        this.dff_descripcion = dff_descripcion;
    }

    public String getDff_descripcion() {
        return dff_descripcion;
    }

    public void setDru_codigo(Long dru_codigo) {
        this.dru_codigo = dru_codigo;
    }

    public Long getDru_codigo() {
        return dru_codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDru_valor(BigDecimal dru_valor) {
        this.dru_valor = dru_valor;
    }

    public BigDecimal getDru_valor() {
        return dru_valor;
    }

    public void setVigencia(Long vigencia) {
        this.vigencia = vigencia;
    }

    public Long getVigencia() {
        return vigencia;
    }

    public void setDrc_codigo(Long drc_codigo) {
        this.drc_codigo = drc_codigo;
    }

    public Long getDrc_codigo() {
        return drc_codigo;
    }

    public void setCdp_codigo(Long cdp_codigo) {
        this.cdp_codigo = cdp_codigo;
    }

    public Long getCdp_codigo() {
        return cdp_codigo;
    }

    public void setCdp_valor(BigDecimal cdp_valor) {
        this.cdp_valor = cdp_valor;
    }

    public BigDecimal getCdp_valor() {
        return cdp_valor;
    }

    public void setSaldo_apropiacion(BigDecimal saldo_apropiacion) {
        this.saldo_apropiacion = saldo_apropiacion;
    }

    public BigDecimal getSaldo_apropiacion() {
        return saldo_apropiacion;
    }

    public void setFfi_descripcion(String ffi_descripcion) {
        this.ffi_descripcion = ffi_descripcion;
    }

    public String getFfi_descripcion() {
        return ffi_descripcion;
    }

    public void setSaldo_anterior(BigDecimal saldo_anterior) {
        this.saldo_anterior = saldo_anterior;
    }

    public BigDecimal getSaldo_anterior() {
        return saldo_anterior;
    }

    public void setAplica_gf(String aplica_gf) {
        this.aplica_gf = aplica_gf;
    }

    public String getAplica_gf() {
        return aplica_gf;
    }

    public void setIdGf(Long idGf) {
        this.idGf = idGf;
    }

    public Long getIdGf() {
        return idGf;
    }

    public void setFfi_codigo_fuente(Long ffi_codigo_fuente) {
        this.ffi_codigo_fuente = ffi_codigo_fuente;
    }

    public Long getFfi_codigo_fuente() {
        return ffi_codigo_fuente;
    }

    public void setDff_ffi_codigo(Long dff_ffi_codigo) {
        this.dff_ffi_codigo = dff_ffi_codigo;
    }

    public Long getDff_ffi_codigo() {
        return dff_ffi_codigo;
    }

    public void setCodigo_rubro(String codigo_rubro) {
        this.codigo_rubro = codigo_rubro;
    }

    public String getCodigo_rubro() {
        return codigo_rubro;
    }


}
