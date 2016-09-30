package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_TASA_INTERES")
public class SiiTasaInteres implements Serializable {
    private static final long serialVersionUID = 5039616073214098757L;
    private String taiActivo;
    private Long taiCodigo;
    private Date taiFecha;
    private Date taiFechaDesde;
    private Date taiFechaHasta;
    private BigDecimal taiPorcentaje;
    private String taiTipoInteres;
    private SiiUsuario siiUsuarioConec;
    private SiiTipoTasaInteres siiTipoTasaInteres;

    public SiiTasaInteres() {
    }

    public SiiTasaInteres(String taiActivo, Long taiCodigo, Date taiFecha, Date taiFechaDesde, Date taiFechaHasta, BigDecimal taiPorcentaje, String taiTipoInteres, SiiTipoTasaInteres siiTipoTasaInteres,
                          SiiUsuario siiUsuarioConec) {
        this.taiActivo = taiActivo;
        this.taiCodigo = taiCodigo;
        this.taiFecha = taiFecha;
        this.taiFechaDesde = taiFechaDesde;
        this.taiFechaHasta = taiFechaHasta;
        this.taiPorcentaje = taiPorcentaje;
        this.taiTipoInteres = taiTipoInteres;
        this.siiTipoTasaInteres = siiTipoTasaInteres;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Column(name = "TAI_ACTIVO", nullable = false, length = 1)
    public String getTaiActivo() {
        return taiActivo;
    }

    public void setTaiActivo(String taiActivo) {
        this.taiActivo = taiActivo;
    }

    @Id
    @Column(name = "TAI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TASA_INTERES_COD")
    @SequenceGenerator(name = "SEQ_TASA_INTERES_COD", sequenceName = "SEQ_TASA_INTERES_COD",allocationSize=1)
    public Long getTaiCodigo() {
        return taiCodigo;
    }

    public void setTaiCodigo(Long taiCodigo) {
        this.taiCodigo = taiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAI_FECHA", nullable = false)
    public Date getTaiFecha() {
        return taiFecha;
    }

    public void setTaiFecha(Date taiFecha) {
        this.taiFecha = taiFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAI_FECHA_DESDE", nullable = false)
    public Date getTaiFechaDesde() {
        return taiFechaDesde;
    }

    public void setTaiFechaDesde(Date taiFechaDesde) {
        this.taiFechaDesde = taiFechaDesde;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAI_FECHA_HASTA", nullable = false)
    public Date getTaiFechaHasta() {
        return taiFechaHasta;
    }

    public void setTaiFechaHasta(Date taiFechaHasta) {
        this.taiFechaHasta = taiFechaHasta;
    }

    @Column(name = "TAI_PORCENTAJE", nullable = false)
    public BigDecimal getTaiPorcentaje() {
        return taiPorcentaje;
    }

    public void setTaiPorcentaje(BigDecimal taiPorcentaje) {
        this.taiPorcentaje = taiPorcentaje;
    }

    @Column(name = "TAI_TIPO_INTERES", nullable = false, length = 1)
    public String getTaiTipoInteres() {
        return taiTipoInteres;
    }

    public void setTaiTipoInteres(String taiTipoInteres) {
        this.taiTipoInteres = taiTipoInteres;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CON")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "TTI_CODIGO")
    public SiiTipoTasaInteres getSiiTipoTasaInteres() {
        return siiTipoTasaInteres;
    }

    public void setSiiTipoTasaInteres(SiiTipoTasaInteres siiTipoTasaInteres) {
        this.siiTipoTasaInteres = siiTipoTasaInteres;
    }
}
