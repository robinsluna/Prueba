package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_TASA_INT_SUPERBAN")
public class SiiTasaIntSuperban implements Serializable {
    private static final long serialVersionUID = -4759930359008453980L;
    private String tisActivo;
    private BigDecimal tisCodigo;
    private Date tisFecha;
    private BigDecimal tisTasa;
    private Date tisVigenDesde;
    private Date tisVigenHasta;
    private String tisTipoInteres; 

    public SiiTasaIntSuperban() {
    }

    public SiiTasaIntSuperban(String tisActivo, BigDecimal tisCodigo, Date tisFecha, BigDecimal tisTasa, String tisTipoInteres) {
        this.tisActivo = tisActivo;
        this.tisCodigo = tisCodigo;
        this.tisFecha = tisFecha;
        this.tisTasa = tisTasa;
        this.tisTipoInteres = tisTipoInteres;
    }

    @Column(name = "TIS_ACTIVO", nullable = false, length = 1)
    public String getTisActivo() {
        return tisActivo;
    }

    public void setTisActivo(String tisActivo) {
        this.tisActivo = tisActivo;
    }

    @Id
    @Column(name = "TIS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TASA_INT_SUPERBAN_COD")
    @SequenceGenerator(name = "SEQ_TASA_INT_SUPERBAN_COD", sequenceName = "SEQ_TASA_INT_SUPERBAN_COD", allocationSize = 1)
    public BigDecimal getTisCodigo() {
        return tisCodigo;
    }

    public void setTisCodigo(BigDecimal tisCodigo) {
        this.tisCodigo = tisCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIS_FECHA", nullable = false)
    public Date getTisFecha() {
        return tisFecha;
    }

    public void setTisFecha(Date tisFecha) {
        this.tisFecha = tisFecha;
    }

    @Column(name = "TIS_TASA", nullable = false)
    public BigDecimal getTisTasa() {
        return tisTasa;
    }

    public void setTisTasa(BigDecimal tisTasa) {
        this.tisTasa = tisTasa;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIS_VIGEN_DESDE", nullable = false)
    public Date getTisVigenDesde() {
        return tisVigenDesde;
    }

    public void setTisVigenDesde(Date tisVigenDesde) {
        this.tisVigenDesde = tisVigenDesde;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIS_VIGEN_HASTA", nullable = false)
    public Date getTisVigenHasta() {
        return tisVigenHasta;
    }

    public void setTisVigenHasta(Date tisVigenHasta) {
        this.tisVigenHasta = tisVigenHasta;
    }


    public void setTisTipoInteres(String tisTipoInteres) {
        this.tisTipoInteres = tisTipoInteres;
    }
    
    @Column(name = "TIS_TIPO_INTERES", nullable = false, length = 1)
    public String getTisTipoInteres() {
        return tisTipoInteres;
    }
}
