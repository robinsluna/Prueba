package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;

import java.math.BigDecimal;

import java.util.Date;

public class TasaIntSuperbanVO {

    private String tisActivo;
    private BigDecimal tisCodigo;
    private Date tisFecha;
    private BigDecimal tisTasa;
    private Date tisVigenDesde;
    private Date tisVigenHasta;
    private String tisTipoInteres;

    public TasaIntSuperbanVO() {

    }

    public TasaIntSuperbanVO(SiiTasaIntSuperban siiTasaIntSuperban) {

        this.tisActivo = siiTasaIntSuperban.getTisActivo();
        this.tisCodigo = siiTasaIntSuperban.getTisCodigo();
        this.tisFecha = siiTasaIntSuperban.getTisFecha();
        this.tisTasa = siiTasaIntSuperban.getTisTasa();
        this.tisVigenDesde = siiTasaIntSuperban.getTisVigenDesde();
        this.tisVigenHasta = siiTasaIntSuperban.getTisVigenHasta();
        this.tisTipoInteres = siiTasaIntSuperban.getTisTipoInteres();
    }


    public String getTisActivo() {
        return tisActivo;
    }

    public void setTisActivo(String tisActivo) {
        this.tisActivo = tisActivo;
    }

    public BigDecimal getTisCodigo() {
        return tisCodigo;
    }

    public void setTisCodigo(BigDecimal tisCodigo) {
        this.tisCodigo = tisCodigo;
    }

    public Date getTisFecha() {
        return tisFecha;
    }

    public void setTisFecha(Date tisFecha) {
        this.tisFecha = tisFecha;
    }

    public BigDecimal getTisTasa() {
        return tisTasa;
    }

    public void setTisTasa(BigDecimal tisTasa) {
        this.tisTasa = tisTasa;
    }


    public Date getTisVigenDesde() {
        return tisVigenDesde;
    }

    public void setTisVigenDesde(Date tisVigenDesde) {
        this.tisVigenDesde = tisVigenDesde;
    }

    public Date getTisVigenHasta() {
        return tisVigenHasta;
    }

    public void setTisVigenHasta(Date tisVigenHasta) {
        this.tisVigenHasta = tisVigenHasta;
    }

    public void setTisTipoInteres(String tisTipoInteres) {
        this.tisTipoInteres = tisTipoInteres;
    }

    public String getTisTipoInteres() {
        return tisTipoInteres;
    }
}
