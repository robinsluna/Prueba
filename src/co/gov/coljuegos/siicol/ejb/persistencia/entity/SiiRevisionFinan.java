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
@Table(name = "SII_REVISION_FINAN")
public class SiiRevisionFinan implements Serializable {
    private static final long serialVersionUID = -3799816328700077022L;
    private Long rfiCodigo;
    private Date rfiFecha;
    private String rfiObservac;
    private String rfiValida;
    private SiiContrato siiContrato;
    private String rfiTipoValidac;

    public SiiRevisionFinan() {
    }

    public SiiRevisionFinan(SiiContrato siiContrato, Long rfiCodigo, Date rfiFecha, String rfiObservac,
                            String rfiValida) {
        this.siiContrato = siiContrato;
        this.rfiCodigo = rfiCodigo;
        this.rfiFecha = rfiFecha;
        this.rfiObservac = rfiObservac;
        this.rfiValida = rfiValida;
    }


    @Id
    @Column(name = "RFI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REVISION_FINAN_COD")
    @SequenceGenerator(name = "SEQ_REVISION_FINAN_COD", sequenceName = "SEQ_REVISION_FINAN_COD",allocationSize=1)
    public Long getRfiCodigo() {
        return rfiCodigo;
    }

    public void setRfiCodigo(Long rfiCodigo) {
        this.rfiCodigo = rfiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RFI_FECHA", nullable = false)
    public Date getRfiFecha() {
        return rfiFecha;
    }

    public void setRfiFecha(Date rfiFecha) {
        this.rfiFecha = rfiFecha;
    }

    @Column(name = "RFI_OBSERVAC", nullable = false, length = 1500)
    public String getRfiObservac() {
        return rfiObservac;
    }

    public void setRfiObservac(String rfiObservac) {
        this.rfiObservac = rfiObservac;
    }

    @Column(name = "RFI_VALIDA", nullable = false, length = 1)
    public String getRfiValida() {
        return rfiValida;
    }

    public void setRfiValida(String rfiValida) {
        this.rfiValida = rfiValida;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @Column(name = "RFI_TIPO_VALIDAC", nullable = false, length = 3)
    public String getRfiTipoValidac() {
        return rfiTipoValidac;
    }

    public void setRfiTipoValidac(String rfiTipoValidac) {
        this.rfiTipoValidac = rfiTipoValidac;
    }
}
