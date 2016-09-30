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
@Table(name = "SII_EXPEDIENTE_DOCUM")
public class SiiExpedienteDocum implements Serializable {
    private static final long serialVersionUID = 5544899667956334013L;
    private String edoCodigo;
    private Date edoFecha;
    private List<SiiExpedienteRadicado> siiExpedienteRadicadoList;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;
    private SiiExpedienteDocum siiExpedienteDocumPadre;
    private List<SiiExpedienteDocum> siiExpedienteDocumHijosList;

    public SiiExpedienteDocum() {
    }

    public SiiExpedienteDocum(String edoCodigo, Date edoFecha) {
        this.edoCodigo = edoCodigo;
        this.edoFecha = edoFecha;
    }

    @Id
    @Column(name = "EDO_CODIGO", nullable = false, length = 16)
    public String getEdoCodigo() {
        return edoCodigo;
    }

    public void setEdoCodigo(String edoCodigo) {
        this.edoCodigo = edoCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EDO_FECHA", nullable = false)
    public Date getEdoFecha() {
        return edoFecha;
    }

    public void setEdoFecha(Date edoFecha) {
        this.edoFecha = edoFecha;
    }

    @OneToMany(mappedBy = "siiExpedienteDocum")
    public List<SiiExpedienteRadicado> getSiiExpedienteRadicadoList() {
        return siiExpedienteRadicadoList;
    }

    public void setSiiExpedienteRadicadoList(List<SiiExpedienteRadicado> siiExpedienteRadicadoList) {
        this.siiExpedienteRadicadoList = siiExpedienteRadicadoList;
    }

    public SiiExpedienteRadicado addSiiExpedienteRadicado(SiiExpedienteRadicado siiExpedienteRadicado) {
        getSiiExpedienteRadicadoList().add(siiExpedienteRadicado);
        siiExpedienteRadicado.setSiiExpedienteDocum(this);
        return siiExpedienteRadicado;
    }

    public SiiExpedienteRadicado removeSiiExpedienteRadicado(SiiExpedienteRadicado siiExpedienteRadicado) {
        getSiiExpedienteRadicadoList().remove(siiExpedienteRadicado);
        siiExpedienteRadicado.setSiiExpedienteDocum(null);
        return siiExpedienteRadicado;
    }

    @OneToMany(mappedBy = "siiExpedienteDocum")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteDocum(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteDocum(null);
        return siiSolicitudAutoriza;
    }

    @ManyToOne
    @JoinColumn(name = "EDO_CODIGO_PADRE")
    public SiiExpedienteDocum getSiiExpedienteDocumPadre() {
        return siiExpedienteDocumPadre;
    }

    public void setSiiExpedienteDocumPadre(SiiExpedienteDocum siiExpedienteDocumPadre) {
        this.siiExpedienteDocumPadre = siiExpedienteDocumPadre;
    }

    @OneToMany(mappedBy = "siiExpedienteDocumPadre")
    public List<SiiExpedienteDocum> getSiiExpedienteDocumHijosList() {
        return siiExpedienteDocumHijosList;
    }

    public void setSiiExpedienteDocumHijosList(List<SiiExpedienteDocum> siiExpedienteDocumHijosList) {
        this.siiExpedienteDocumHijosList = siiExpedienteDocumHijosList;
    }

    public SiiExpedienteDocum addSiiExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) {
        getSiiExpedienteDocumHijosList().add(siiExpedienteDocum);
        siiExpedienteDocum.setSiiExpedienteDocumPadre(this);
        return siiExpedienteDocum;
    }

    public SiiExpedienteDocum removeSiiExpedienteDocum(SiiExpedienteDocum siiExpedienteDocum) {
        getSiiExpedienteDocumHijosList().remove(siiExpedienteDocum);
        siiExpedienteDocum.setSiiExpedienteDocumPadre(null);
        return siiExpedienteDocum;
    }
}
