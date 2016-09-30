package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_UVT")
public class SiiUvt implements Serializable {
    private static final long serialVersionUID = 5788229854635265586L;
    private Date uvtFecha;
    private BigDecimal uvtValor;
    private Integer uvtVigencia;

    public SiiUvt() {
    }

    public SiiUvt(Date uvtFecha, BigDecimal uvtValor, Integer uvtVigencia) {
        this.uvtFecha = uvtFecha;
        this.uvtValor = uvtValor;
        this.uvtVigencia = uvtVigencia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UVT_FECHA", nullable = false)
    public Date getUvtFecha() {
        return uvtFecha;
    }

    public void setUvtFecha(Date uvtFecha) {
        this.uvtFecha = uvtFecha;
    }

    @Column(name = "UVT_VALOR", nullable = false)
    public BigDecimal getUvtValor() {
        return uvtValor;
    }

    public void setUvtValor(BigDecimal uvtValor) {
        this.uvtValor = uvtValor;
    }

    @Id
    @Column(name = "UVT_VIGENCIA", nullable = false)
    public Integer getUvtVigencia() {
        return uvtVigencia;
    }

    public void setUvtVigencia(Integer uvtVigencia) {
        this.uvtVigencia = uvtVigencia;
    }
}
