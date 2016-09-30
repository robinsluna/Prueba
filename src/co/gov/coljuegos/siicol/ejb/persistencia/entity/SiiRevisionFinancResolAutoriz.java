package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_REVISION_FINANC_RES_AUT")
public class SiiRevisionFinancResolAutoriz implements Serializable {
    private static final long serialVersionUID = 952345357132529041L;
    private Long rfrCodigo;
    private Date rfrFecha;
    private String rfrObservaciones;
    private String rfrValida;
    private SiiResolucionAutoriz siiResolucionAutoriz;

    public SiiRevisionFinancResolAutoriz() {
    }

    public SiiRevisionFinancResolAutoriz(SiiResolucionAutoriz siiResolucionAutoriz, Long rfrCodigo, Date rfrFecha,
                                         String rfrObservaciones, String rfrValida) {
        this.siiResolucionAutoriz = siiResolucionAutoriz;
        this.rfrCodigo = rfrCodigo;
        this.rfrFecha = rfrFecha;
        this.rfrObservaciones = rfrObservaciones;
        this.rfrValida = rfrValida;
    }


    @Id
    @Column(name = "RFR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REV_FINANC_RES_AUT_COD")
    @SequenceGenerator(name = "SEQ_REV_FINANC_RES_AUT_COD", sequenceName = "SEQ_REV_FINANC_RES_AUT_COD",allocationSize=1)
    public Long getRfrCodigo() {
        return rfrCodigo;
    }

    public void setRfrCodigo(Long rfrCodigo) {
        this.rfrCodigo = rfrCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFR_FECHA", nullable = false)
    public Date getRfrFecha() {
        return rfrFecha;
    }

    public void setRfrFecha(Date rfrFecha) {
        this.rfrFecha = rfrFecha;
    }

    @Column(name = "RFR_OBSERVACIONES", nullable = false, length = 1100)
    public String getRfrObservaciones() {
        return rfrObservaciones;
    }

    public void setRfrObservaciones(String rfrObservaciones) {
        this.rfrObservaciones = rfrObservaciones;
    }

    @Column(name = "RFR_VALIDA", nullable = false, length = 1)
    public String getRfrValida() {
        return rfrValida;
    }

    public void setRfrValida(String rfrValida) {
        this.rfrValida = rfrValida;
    }

    @ManyToOne
    @JoinColumn(name = "RAU_CODIGO")
    public SiiResolucionAutoriz getSiiResolucionAutoriz() {
        return siiResolucionAutoriz;
    }

    public void setSiiResolucionAutoriz(SiiResolucionAutoriz siiResolucionAutoriz) {
        this.siiResolucionAutoriz = siiResolucionAutoriz;
    }
}
