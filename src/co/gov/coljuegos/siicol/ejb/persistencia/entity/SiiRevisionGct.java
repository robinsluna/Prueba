package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_REVISION_GCT")
public class SiiRevisionGct implements Serializable {
    private static final long serialVersionUID = -7790043837655084474L;
    private Long rgcCodigo;
    private Date rgcFecha;
    private String rgcObservac;
    private String rgcValido;
    private SiiContrato siiContrato;

    public SiiRevisionGct() {
    }

    public SiiRevisionGct(SiiContrato siiContrato, Long rgcCodigo, Date rgcFecha, String rgcObservac,
                          String rgcValido) {
        this.siiContrato = siiContrato;
        this.rgcCodigo = rgcCodigo;
        this.rgcFecha = rgcFecha;
        this.rgcObservac = rgcObservac;
        this.rgcValido = rgcValido;
    }


    @Id
    @Column(name = "RGC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REVISION_GCT_COD")
    @SequenceGenerator(name = "SEQ_REVISION_GCT_COD", sequenceName = "SEQ_REVISION_GCT_COD",allocationSize=1)
    public Long getRgcCodigo() {
        return rgcCodigo;
    }

    public void setRgcCodigo(Long rgcCodigo) {
        this.rgcCodigo = rgcCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RGC_FECHA", nullable = false)
    public Date getRgcFecha() {
        return rgcFecha;
    }

    public void setRgcFecha(Date rgcFecha) {
        this.rgcFecha = rgcFecha;
    }

    @Column(name = "RGC_OBSERVAC", nullable = false, length = 1500)
    public String getRgcObservac() {
        return rgcObservac;
    }

    public void setRgcObservac(String rgcObservac) {
        this.rgcObservac = rgcObservac;
    }

    @Column(name = "RGC_VALIDO", nullable = false, length = 1)
    public String getRgcValido() {
        return rgcValido;
    }

    public void setRgcValido(String rgcValido) {
        this.rgcValido = rgcValido;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }
}
