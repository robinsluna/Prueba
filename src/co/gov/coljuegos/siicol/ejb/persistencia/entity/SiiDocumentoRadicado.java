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
@Table(name = "SII_DOCUMENTO_RADICADO")
public class SiiDocumentoRadicado implements Serializable {
    private static final long serialVersionUID = -6640635495284371411L;
    private String draCodigo;
    private Date draFecha;
    private SiiExpedienteRadicado siiExpedienteRadicado;
    private SiiTipoDocRadicado siiTipoDocRadicado;
    private SiiPersona siiPersona;
    private SiiTipoPersonal siiTipoPersonal;


    public SiiDocumentoRadicado() {
    }

    public SiiDocumentoRadicado(String draCodigo, Date draFecha, SiiPersona siiPersona,
                                SiiTipoDocRadicado siiTipoDocRadicado) {
        this.draCodigo = draCodigo;
        this.draFecha = draFecha;
        this.siiPersona = siiPersona;
        this.siiTipoDocRadicado = siiTipoDocRadicado;
    }

    @Id
    @Column(name = "DRA_CODIGO", nullable = false, length = 16)
    public String getDraCodigo() {
        return draCodigo;
    }

    public void setDraCodigo(String draCodigo) {
        this.draCodigo = draCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DRA_FECHA", nullable = false)
    public Date getDraFecha() {
        return draFecha;
    }

    public void setDraFecha(Date draFecha) {
        this.draFecha = draFecha;
    }


    @ManyToOne
    @JoinColumn(name = "EXR_CODIGO")
    public SiiExpedienteRadicado getSiiExpedienteRadicado() {
        return siiExpedienteRadicado;
    }

    public void setSiiExpedienteRadicado(SiiExpedienteRadicado siiExpedienteRadicado) {
        this.siiExpedienteRadicado = siiExpedienteRadicado;
    }

    @ManyToOne
    @JoinColumn(name = "TDR_CODIGO")
    public SiiTipoDocRadicado getSiiTipoDocRadicado() {
        return siiTipoDocRadicado;
    }

    public void setSiiTipoDocRadicado(SiiTipoDocRadicado siiTipoDocRadicado) {
        this.siiTipoDocRadicado = siiTipoDocRadicado;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "TPE_CODIGO")
    public SiiTipoPersonal getSiiTipoPersonal() {
        return siiTipoPersonal;
    }

    public void setSiiTipoPersonal(SiiTipoPersonal siiTipoPersonal) {
        this.siiTipoPersonal = siiTipoPersonal;
    }
}
