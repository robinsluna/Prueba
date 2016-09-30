package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_DESCARGO_PROC_ILEG")
public class SiiDescargoProcIleg implements Serializable {
    private static final long serialVersionUID = -8100608466532514783L;
    private Long dprCodigo;
    private Date dprFechaRadic;
    private String dprRadicado;
    private String dprSolicitaPrue;
    private SiiUsuario siiUsuario;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;
    private List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleList;
    private String dprObservaciones;

    public SiiDescargoProcIleg() {
    }

    public SiiDescargoProcIleg(Long dprCodigo, Date dprFechaRadic, String dprRadicado, String dprSolicitaPrue, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad,
                               SiiUsuario siiUsuario) {
        this.dprCodigo = dprCodigo;
        this.dprFechaRadic = dprFechaRadic;
        this.dprRadicado = dprRadicado;
        this.dprSolicitaPrue = dprSolicitaPrue;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiUsuario = siiUsuario;
    }

    @Id
    @Column(name = "DPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DESCAR_PRO_ILE_COD")
    @SequenceGenerator(name = "SEQ_DESCAR_PRO_ILE_COD", sequenceName = "SEQ_DESCAR_PRO_ILE_COD",allocationSize=1)
    public Long getDprCodigo() {
        return dprCodigo;
    }

    public void setDprCodigo(Long dprCodigo) {
        this.dprCodigo = dprCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DPR_FECHA_RADIC", nullable = false)
    public Date getDprFechaRadic() {
        return dprFechaRadic;
    }

    public void setDprFechaRadic(Date dprFechaRadic) {
        this.dprFechaRadic = dprFechaRadic;
    }

    @Column(name = "DPR_RADICADO", nullable = false, length = 30)
    public String getDprRadicado() {
        return dprRadicado;
    }

    public void setDprRadicado(String dprRadicado) {
        this.dprRadicado = dprRadicado;
    }

    @Column(name = "DPR_SOLICITA_PRUE", nullable = false, length = 1)
    public String getDprSolicitaPrue() {
        return dprSolicitaPrue;
    }

    public void setDprSolicitaPrue(String dprSolicitaPrue) {
        this.dprSolicitaPrue = dprSolicitaPrue;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuario() {
        return siiUsuario;
    }

    public void setSiiUsuario(SiiUsuario siiUsuario) {
        this.siiUsuario = siiUsuario;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiDescargoProcIleg")
    public List<SiiPruebaDescargoProIle> getSiiPruebaDescargoProIleList() {
        return siiPruebaDescargoProIleList;
    }

    public void setSiiPruebaDescargoProIleList(List<SiiPruebaDescargoProIle> siiPruebaDescargoProIleList) {
        this.siiPruebaDescargoProIleList = siiPruebaDescargoProIleList;
    }

    public SiiPruebaDescargoProIle addSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleList().add(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiDescargoProcIleg(this);
        return siiPruebaDescargoProIle;
    }

    public SiiPruebaDescargoProIle removeSiiPruebaDescargoProIle(SiiPruebaDescargoProIle siiPruebaDescargoProIle) {
        getSiiPruebaDescargoProIleList().remove(siiPruebaDescargoProIle);
        siiPruebaDescargoProIle.setSiiDescargoProcIleg(null);
        return siiPruebaDescargoProIle;
    }

    @Column(name = "DPR_OBSERVACIONES", length = 4000)
    public String getDprObservaciones() {
        return dprObservaciones;
    }

    public void setDprObservaciones(String dprObservaciones) {
        this.dprObservaciones = dprObservaciones;
    }
}
