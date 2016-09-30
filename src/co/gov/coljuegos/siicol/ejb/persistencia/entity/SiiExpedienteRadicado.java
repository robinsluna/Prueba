package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_EXPEDIENTE_RADICADO")
public class SiiExpedienteRadicado implements Serializable {
    private static final long serialVersionUID = 5386867580999457494L;
    private String exrCodigo;
    private SiiExpedienteDocum siiExpedienteDocum;
    private Date exrFecha;
    private List<SiiDocumentoRadicado> siiDocumentoRadicadoList;

    public SiiExpedienteRadicado() {
    }

    public SiiExpedienteRadicado(SiiExpedienteDocum siiExpedienteDocum,
                                 String exrCodigo) {
        this.siiExpedienteDocum = siiExpedienteDocum;
        this.exrCodigo = exrCodigo;
    }


    @Id
    @Column(name = "EXR_CODIGO", nullable = false, length = 30)
    public String getExrCodigo() {
        return exrCodigo;
    }

    public void setExrCodigo(String exrCodigo) {
        this.exrCodigo = exrCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "EDO_CODIGO")
    public SiiExpedienteDocum getSiiExpedienteDocum() {
        return siiExpedienteDocum;
    }

    public void setSiiExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) {
        this.siiExpedienteDocum = siiExpedienteDocum;
    }

    @OneToMany(mappedBy = "siiExpedienteRadicado")
    public List<SiiDocumentoRadicado> getSiiDocumentoRadicadoList() {
        return siiDocumentoRadicadoList;
    }

    public void setSiiDocumentoRadicadoList(List<SiiDocumentoRadicado> siiDocumentoRadicadoList) {
        this.siiDocumentoRadicadoList = siiDocumentoRadicadoList;
    }

    public SiiDocumentoRadicado addSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().add(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiExpedienteRadicado(this);
        return siiDocumentoRadicado;
    }

    public SiiDocumentoRadicado removeSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().remove(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiExpedienteRadicado(null);
        return siiDocumentoRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXR_FECHA", nullable = false)
    public Date getExrFecha() {
        return exrFecha;
    }

    public void setExrFecha(Date exrFecha) {
        this.exrFecha = exrFecha;
    }
}
