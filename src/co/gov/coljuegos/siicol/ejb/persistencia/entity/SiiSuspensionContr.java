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
@Table(name = "SII_SUSPENSION_CONTR")
public class SiiSuspensionContr implements Serializable {
    private static final long serialVersionUID = 1877512766458752043L;
    private Long scoCodigo;
    private Date scoFechaActaSusp;
    private Date scoFechaFinDefCon;
    private Date scoFechaFinSusAct;
    private Date scoFechaFinSusp;
    private Date scoFechaIniSusAct;
    private Date scoFechaIniSusp;
    private Date scoFechaRadDesist;
    private Date scoFechaRadRecha;
    private Date scoFechaRadica;
    private Date scoFechaReanuda;
    private String scoModificaFecFin;
    private String scoMotivoDesist;
    private String scoMotivoRachazo;
    private String scoRadicado;
    private String scoRadicadoDesist;
    private String scoRadicadoRecha;
    private String scoTipo;
    private List<SiiEstablecSuspension> siiEstablecSuspensionList;
    private SiiEstadoSuspensionCont siiEstadoSuspensionCont;
    private SiiContrato siiContrato;
    private List<SiiNovedad> siiNovedadList;


    public SiiSuspensionContr() {
    }

    public SiiSuspensionContr(SiiContrato siiContrato, SiiEstadoSuspensionCont siiEstadoSuspensionCont, Long scoCodigo, Date scoFechaActaSusp, Date scoFechaFinDefCon, Date scoFechaFinSusAct,
                              Date scoFechaFinSusp, Date scoFechaIniSusAct, Date scoFechaIniSusp, Date scoFechaRadDesist, Date scoFechaRadRecha, Date scoFechaRadica, Date scoFechaReanuda,
                              String scoModificaFecFin, String scoMotivoDesist, String scoMotivoRachazo, String scoRadicado, String scoRadicadoDesist, String scoRadicadoRecha, String scoTipo) {
        this.siiContrato = siiContrato;
        this.siiEstadoSuspensionCont = siiEstadoSuspensionCont;
        this.scoCodigo = scoCodigo;
        this.scoFechaActaSusp = scoFechaActaSusp;
        this.scoFechaFinDefCon = scoFechaFinDefCon;
        this.scoFechaFinSusAct = scoFechaFinSusAct;
        this.scoFechaFinSusp = scoFechaFinSusp;
        this.scoFechaIniSusAct = scoFechaIniSusAct;
        this.scoFechaIniSusp = scoFechaIniSusp;
        this.scoFechaRadDesist = scoFechaRadDesist;
        this.scoFechaRadRecha = scoFechaRadRecha;
        this.scoFechaRadica = scoFechaRadica;
        this.scoFechaReanuda = scoFechaReanuda;
        this.scoModificaFecFin = scoModificaFecFin;
        this.scoMotivoDesist = scoMotivoDesist;
        this.scoMotivoRachazo = scoMotivoRachazo;
        this.scoRadicado = scoRadicado;
        this.scoRadicadoDesist = scoRadicadoDesist;
        this.scoRadicadoRecha = scoRadicadoRecha;
        this.scoTipo = scoTipo;
    }


    @Id
    @Column(name = "SCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_SUSPEN_CONTR_COD")
    @SequenceGenerator(name = "SEQ_SUSPEN_CONTR_COD", sequenceName = "SEQ_SUSPEN_CONTR_COD",allocationSize=1)
    public Long getScoCodigo() {
        return scoCodigo;
    }

    public void setScoCodigo(Long scoCodigo) {
        this.scoCodigo = scoCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_ACTA_SUSP")
    public Date getScoFechaActaSusp() {
        return scoFechaActaSusp;
    }

    public void setScoFechaActaSusp(Date scoFechaActaSusp) {
        this.scoFechaActaSusp = scoFechaActaSusp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_FIN_DEF_CON")
    public Date getScoFechaFinDefCon() {
        return scoFechaFinDefCon;
    }

    public void setScoFechaFinDefCon(Date scoFechaFinDefCon) {
        this.scoFechaFinDefCon = scoFechaFinDefCon;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_FIN_SUS_ACT")
    public Date getScoFechaFinSusAct() {
        return scoFechaFinSusAct;
    }

    public void setScoFechaFinSusAct(Date scoFechaFinSusAct) {
        this.scoFechaFinSusAct = scoFechaFinSusAct;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_FIN_SUSP", nullable = false)
    public Date getScoFechaFinSusp() {
        return scoFechaFinSusp;
    }

    public void setScoFechaFinSusp(Date scoFechaFinSusp) {
        this.scoFechaFinSusp = scoFechaFinSusp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_INI_SUS_ACT")
    public Date getScoFechaIniSusAct() {
        return scoFechaIniSusAct;
    }

    public void setScoFechaIniSusAct(Date scoFechaIniSusAct) {
        this.scoFechaIniSusAct = scoFechaIniSusAct;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_INI_SUSP", nullable = false)
    public Date getScoFechaIniSusp() {
        return scoFechaIniSusp;
    }

    public void setScoFechaIniSusp(Date scoFechaIniSusp) {
        this.scoFechaIniSusp = scoFechaIniSusp;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_RAD_DESIST")
    public Date getScoFechaRadDesist() {
        return scoFechaRadDesist;
    }

    public void setScoFechaRadDesist(Date scoFechaRadDesist) {
        this.scoFechaRadDesist = scoFechaRadDesist;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_RAD_RECHA")
    public Date getScoFechaRadRecha() {
        return scoFechaRadRecha;
    }

    public void setScoFechaRadRecha(Date scoFechaRadRecha) {
        this.scoFechaRadRecha = scoFechaRadRecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_RADICA", nullable = false)
    public Date getScoFechaRadica() {
        return scoFechaRadica;
    }

    public void setScoFechaRadica(Date scoFechaRadica) {
        this.scoFechaRadica = scoFechaRadica;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "SCO_FECHA_REANUDA")
    public Date getScoFechaReanuda() {
        return scoFechaReanuda;
    }

    public void setScoFechaReanuda(Date scoFechaReanuda) {
        this.scoFechaReanuda = scoFechaReanuda;
    }

    @Column(name = "SCO_MODIFICA_FEC_FIN", length = 1)
    public String getScoModificaFecFin() {
        return scoModificaFecFin;
    }

    public void setScoModificaFecFin(String scoModificaFecFin) {
        this.scoModificaFecFin = scoModificaFecFin;
    }

    @Column(name = "SCO_MOTIVO_DESIST", length = 550)
    public String getScoMotivoDesist() {
        return scoMotivoDesist;
    }

    public void setScoMotivoDesist(String scoMotivoDesist) {
        this.scoMotivoDesist = scoMotivoDesist;
    }

    @Column(name = "SCO_MOTIVO_RACHAZO", length = 220)
    public String getScoMotivoRachazo() {
        return scoMotivoRachazo;
    }

    public void setScoMotivoRachazo(String scoMotivoRachazo) {
        this.scoMotivoRachazo = scoMotivoRachazo;
    }

    @Column(name = "SCO_RADICADO", nullable = false, length = 30)
    public String getScoRadicado() {
        return scoRadicado;
    }

    public void setScoRadicado(String scoRadicado) {
        this.scoRadicado = scoRadicado;
    }

    @Column(name = "SCO_RADICADO_DESIST", length = 30)
    public String getScoRadicadoDesist() {
        return scoRadicadoDesist;
    }

    public void setScoRadicadoDesist(String scoRadicadoDesist) {
        this.scoRadicadoDesist = scoRadicadoDesist;
    }

    @Column(name = "SCO_RADICADO_RECHA", length = 30)
    public String getScoRadicadoRecha() {
        return scoRadicadoRecha;
    }

    public void setScoRadicadoRecha(String scoRadicadoRecha) {
        this.scoRadicadoRecha = scoRadicadoRecha;
    }

    @Column(name = "SCO_TIPO", nullable = false, length = 1)
    public String getScoTipo() {
        return scoTipo;
    }

    public void setScoTipo(String scoTipo) {
        this.scoTipo = scoTipo;
    }

    @OneToMany(mappedBy = "siiSuspensionContr")
    public List<SiiEstablecSuspension> getSiiEstablecSuspensionList() {
        return siiEstablecSuspensionList;
    }

    public void setSiiEstablecSuspensionList(List<SiiEstablecSuspension> siiEstablecSuspensionList) {
        this.siiEstablecSuspensionList = siiEstablecSuspensionList;
    }

    public SiiEstablecSuspension addSiiEstablecSuspension(SiiEstablecSuspension siiEstablecSuspension) {
        getSiiEstablecSuspensionList().add(siiEstablecSuspension);
        siiEstablecSuspension.setSiiSuspensionContr(this);
        return siiEstablecSuspension;
    }

    public SiiEstablecSuspension removeSiiEstablecSuspension(SiiEstablecSuspension siiEstablecSuspension) {
        getSiiEstablecSuspensionList().remove(siiEstablecSuspension);
        siiEstablecSuspension.setSiiSuspensionContr(null);
        return siiEstablecSuspension;
    }

    @ManyToOne
    @JoinColumn(name = "ESC_CODIGO")
    public SiiEstadoSuspensionCont getSiiEstadoSuspensionCont() {
        return siiEstadoSuspensionCont;
    }

    public void setSiiEstadoSuspensionCont(SiiEstadoSuspensionCont siiEstadoSuspensionCont) {
        this.siiEstadoSuspensionCont = siiEstadoSuspensionCont;
    }

    @ManyToOne
    @JoinColumn(name = "CON_CODIGO")
    public SiiContrato getSiiContrato() {
        return siiContrato;
    }

    public void setSiiContrato(SiiContrato siiContrato) {
        this.siiContrato = siiContrato;
    }
    
    @OneToMany(mappedBy = "siiSuspensionContr")
    public List<SiiNovedad> getSiiNovedadList() {
        return siiNovedadList;
    }

    public void setSiiNovedadList(List<SiiNovedad> siiNovedadList) {
        this.siiNovedadList = siiNovedadList;
    }

    public SiiNovedad addSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().add(siiNovedad);
        siiNovedad.setSiiSuspensionContr(this);
        return siiNovedad;
    }

    public SiiNovedad removeSiiNovedad(SiiNovedad siiNovedad) {
        getSiiNovedadList().remove(siiNovedad);
        siiNovedad.setSiiSuspensionContr(null);
        return siiNovedad;
    }

}
