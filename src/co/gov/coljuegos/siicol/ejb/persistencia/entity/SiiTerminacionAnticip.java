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
@Table(name = "SII_TERMINACION_ANTICIP")
public class SiiTerminacionAnticip implements Serializable {
    private static final long serialVersionUID = -2943745788149502560L;
    private Long tanCodigo;
    private Date tanFechaActaTerAnt;
    private Date tanFechaAproTerAnt;
    private Date tanFechaRadica;
    private Date tanFechaRadicRech;
    private Date tanFechaRadDesist;
    private Date tanFechaTermAntic;
    private Date tanFechaTermSolic;
    private String tanMotivoDesistim;
    private String tanMotivoRechazo;
    private String tanMotivoSolic;
    private String tanRadicado;
    private String tanRadicadoDesistim;
    private String tanRadicadoRechazo;
    private SiiEstadoTermAnticip siiEstadoTermAnticip;
    private SiiContrato siiContrato;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiNovedad> siiNovedadList;

    public SiiTerminacionAnticip() {
    }

    public SiiTerminacionAnticip(SiiContrato siiContrato, SiiEstadoTermAnticip siiEstadoTermAnticip, Long tanCodigo, Date tanFechaActaTerAnt, Date tanFechaAproTerAnt, Date tanFechaRadDesist,
                                 Date tanFechaRadicRech, Date tanFechaRadica, Date tanFechaTermAntic, Date tanFechaTermSolic, String tanMotivoDesistim, String tanMotivoRechazo, String tanMotivoSolic,
                                 String tanRadicado, String tanRadicadoDesistim, String tanRadicadoRechazo) {
        this.siiContrato = siiContrato;
        this.siiEstadoTermAnticip = siiEstadoTermAnticip;
        this.tanCodigo = tanCodigo;
        this.tanFechaActaTerAnt = tanFechaActaTerAnt;
        this.tanFechaAproTerAnt = tanFechaAproTerAnt;
        this.tanFechaRadDesist = tanFechaRadDesist;
        this.tanFechaRadicRech = tanFechaRadicRech;
        this.tanFechaRadica = tanFechaRadica;
        this.tanFechaTermAntic = tanFechaTermAntic;
        this.tanFechaTermSolic = tanFechaTermSolic;
        this.tanMotivoDesistim = tanMotivoDesistim;
        this.tanMotivoRechazo = tanMotivoRechazo;
        this.tanMotivoSolic = tanMotivoSolic;
        this.tanRadicado = tanRadicado;
        this.tanRadicadoDesistim = tanRadicadoDesistim;
        this.tanRadicadoRechazo = tanRadicadoRechazo;
    }


    @Id
    @Column(name = "TAN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TERMINACION_ANTICIP_COD")
    @SequenceGenerator(name = "SEQ_TERMINACION_ANTICIP_COD", sequenceName = "SEQ_TERMINACION_ANTICIP_COD", allocationSize = 1)
    public Long getTanCodigo() {
        return tanCodigo;
    }

    public void setTanCodigo(Long tanCodigo) {
        this.tanCodigo = tanCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_ACTA_TER_ANT")
    public Date getTanFechaActaTerAnt() {
        return tanFechaActaTerAnt;
    }

    public void setTanFechaActaTerAnt(Date tanFechaActaTerAnt) {
        this.tanFechaActaTerAnt = tanFechaActaTerAnt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_APRO_TER_ANT")
    public Date getTanFechaAproTerAnt() {
        return tanFechaAproTerAnt;
    }

    public void setTanFechaAproTerAnt(Date tanFechaAproTerAnt) {
        this.tanFechaAproTerAnt = tanFechaAproTerAnt;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_RADICA", nullable = false)
    public Date getTanFechaRadica() {
        return tanFechaRadica;
    }

    public void setTanFechaRadica(Date tanFechaRadica) {
        this.tanFechaRadica = tanFechaRadica;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_RADIC_RECH")
    public Date getTanFechaRadicRech() {
        return tanFechaRadicRech;
    }

    public void setTanFechaRadicRech(Date tanFechaRadicRech) {
        this.tanFechaRadicRech = tanFechaRadicRech;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_RAD_DESIST")
    public Date getTanFechaRadDesist() {
        return tanFechaRadDesist;
    }

    public void setTanFechaRadDesist(Date tanFechaRadDesist) {
        this.tanFechaRadDesist = tanFechaRadDesist;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_TERM_ANTIC")
    public Date getTanFechaTermAntic() {
        return tanFechaTermAntic;
    }

    public void setTanFechaTermAntic(Date tanFechaTermAntic) {
        this.tanFechaTermAntic = tanFechaTermAntic;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TAN_FECHA_TERM_SOLIC", nullable = false)
    public Date getTanFechaTermSolic() {
        return tanFechaTermSolic;
    }

    public void setTanFechaTermSolic(Date tanFechaTermSolic) {
        this.tanFechaTermSolic = tanFechaTermSolic;
    }

    @Column(name = "TAN_MOTIVO_DESISTIM", length = 550)
    public String getTanMotivoDesistim() {
        return tanMotivoDesistim;
    }

    public void setTanMotivoDesistim(String tanMotivoDesistim) {
        this.tanMotivoDesistim = tanMotivoDesistim;
    }

    @Column(name = "TAN_MOTIVO_RECHAZO", length = 250)
    public String getTanMotivoRechazo() {
        return tanMotivoRechazo;
    }

    public void setTanMotivoRechazo(String tanMotivoRechazo) {
        this.tanMotivoRechazo = tanMotivoRechazo;
    }

    @Column(name = "TAN_MOTIVO_SOLIC", nullable = false, length = 550)
    public String getTanMotivoSolic() {
        return tanMotivoSolic;
    }

    public void setTanMotivoSolic(String tanMotivoSolic) {
        this.tanMotivoSolic = tanMotivoSolic;
    }

    @Column(name = "TAN_RADICADO", nullable = false, length = 30)
    public String getTanRadicado() {
        return tanRadicado;
    }

    public void setTanRadicado(String tanRadicado) {
        this.tanRadicado = tanRadicado;
    }

    @Column(name = "TAN_RADICADO_DESISTIM", length = 30)
    public String getTanRadicadoDesistim() {
        return tanRadicadoDesistim;
    }

    public void setTanRadicadoDesistim(String tanRadicadoDesistim) {
        this.tanRadicadoDesistim = tanRadicadoDesistim;
    }

    @Column(name = "TAN_RADICADO_RECHAZO", length = 30)
    public String getTanRadicadoRechazo() {
        return tanRadicadoRechazo;
    }

    public void setTanRadicadoRechazo(String tanRadicadoRechazo) {
        this.tanRadicadoRechazo = tanRadicadoRechazo;
    }

    @ManyToOne
    @JoinColumn(name = "ETA_CODIGO")
    public SiiEstadoTermAnticip getSiiEstadoTermAnticip() {
        return siiEstadoTermAnticip;
    }

    public void setSiiEstadoTermAnticip(SiiEstadoTermAnticip siiEstadoTermAnticip) {
        this.siiEstadoTermAnticip = siiEstadoTermAnticip;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }

    @OneToMany(mappedBy = "siiTerminacionAnticip")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiTerminacionAnticip(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiTerminacionAnticip(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiTerminacionAnticip")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiTerminacionAnticip(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiTerminacionAnticip(null);
        return siiNovedad;
    }
}
