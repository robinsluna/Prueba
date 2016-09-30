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
@Table(name = "SII_REVISION_GCT_RES_AUT")
public class SiiRevisionGctResolucAutoriza implements Serializable {
    private static final long serialVersionUID = 513083280991209286L;
    private Long rgrCodigo;
    private Date rgrFecha;
    private String rgrObservaciones;
    private String rgrValida;
    private SiiResolucionAutoriz siiResolucionAutoriz;

    public SiiRevisionGctResolucAutoriza() {
    }

    public SiiRevisionGctResolucAutoriza(SiiResolucionAutoriz siiResolucionAutoriz, Long rgrCodigo, Date rgrFecha,
                                         String rgrObservaciones, String rgrValida) {
        this.siiResolucionAutoriz = siiResolucionAutoriz;
        this.rgrCodigo = rgrCodigo;
        this.rgrFecha = rgrFecha;
        this.rgrObservaciones = rgrObservaciones;
        this.rgrValida = rgrValida;
    }


    @Id
    @Column(name = "RGR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REV_GCT_RES_AUT_COD")
    @SequenceGenerator(name = "SEQ_REV_GCT_RES_AUT_COD", sequenceName = "SEQ_REV_GCT_RES_AUT_COD",allocationSize=1)
    public Long getRgrCodigo() {
        return rgrCodigo;
    }

    public void setRgrCodigo(Long rgrCodigo) {
        this.rgrCodigo = rgrCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RGR_FECHA", nullable = false)
    public Date getRgrFecha() {
        return rgrFecha;
    }

    public void setRgrFecha(Date rgrFecha) {
        this.rgrFecha = rgrFecha;
    }

    @Column(name = "RGR_OBSERVACIONES", nullable = false, length = 1100)
    public String getRgrObservaciones() {
        return rgrObservaciones;
    }

    public void setRgrObservaciones(String rgrObservaciones) {
        this.rgrObservaciones = rgrObservaciones;
    }

    @Column(name = "RGR_VALIDA", nullable = false, length = 1)
    public String getRgrValida() {
        return rgrValida;
    }

    public void setRgrValida(String rgrValida) {
        this.rgrValida = rgrValida;
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
