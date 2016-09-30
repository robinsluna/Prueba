package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_TERMINOS_REFERENCIA")
public class SiiTerminosReferencia implements Serializable {
    private static final long serialVersionUID = 911586962257956595L;
    private Long tdrCodigo;
    private Date tdrFechaApAud;
    private Date tdrFechaApDef;
    private Date tdrFechaApObs;
    private Date tdrFechaApObsDef;
    private Date tdrFechaApProy;
    private Date tdrFechaEnAud;
    private Date tdrFechaEnDef;
    private Date tdrFechaEnObs;
    private Date tdrFechaEnObsDef;
    private Date tdrFechaEnProy;
    private Date tdrFechaPbAud;
    private Date tdrFechaPbDef;
    private Date tdrFechaPbObs;
    private Date tdrFechaPbObsDef;
    private Date tdrFechaPbProy;
    private List<SiiDocumentoTdr> siiDocumentoTdrList;
    private SiiProcesoContratacion siiProcesoContratacion;
    private String tdrRadicAud;
    private String tdrRadicDef;
    private String tdrRadicObs;
    private String tdrRadicObsDef;
    private String tdrRadicProy;
    private List<SiiAdendaTdr> siiAdendaTdrList;

    public SiiTerminosReferencia() {
    }

    public SiiTerminosReferencia(SiiProcesoContratacion siiProcesoContratacion, Long tdrCodigo, Date tdrFechaApAud,
                                 Date tdrFechaApDef, Date tdrFechaApObs, Date tdrFechaApObsDef, Date tdrFechaApProy,
                                 Date tdrFechaEnAud, Date tdrFechaEnDef, Date tdrFechaEnObs, Date tdrFechaEnObsDef,
                                 Date tdrFechaEnProy, Date tdrFechaPbAud, Date tdrFechaPbDef, Date tdrFechaPbObs,
                                 Date tdrFechaPbObsDef, Date tdrFechaPbProy, String tdrRadicAud, String tdrRadicDef, String tdrRadicObs,
                                 String tdrRadicObsDef, String tdrRadicProy) {
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.tdrCodigo = tdrCodigo;
        this.tdrFechaApAud = tdrFechaApAud;
        this.tdrFechaApDef = tdrFechaApDef;
        this.tdrFechaApObs = tdrFechaApObs;
        this.tdrFechaApObsDef = tdrFechaApObsDef;
        this.tdrFechaApProy = tdrFechaApProy;
        this.tdrFechaEnAud = tdrFechaEnAud;
        this.tdrFechaEnDef = tdrFechaEnDef;
        this.tdrFechaEnObs = tdrFechaEnObs;
        this.tdrFechaEnObsDef = tdrFechaEnObsDef;
        this.tdrFechaEnProy = tdrFechaEnProy;
        this.tdrFechaPbAud = tdrFechaPbAud;
        this.tdrFechaPbDef = tdrFechaPbDef;
        this.tdrFechaPbObs = tdrFechaPbObs;
        this.tdrFechaPbObsDef = tdrFechaPbObsDef;
        this.tdrFechaPbProy = tdrFechaPbProy;
        this.tdrRadicAud = tdrRadicAud;
        this.tdrRadicDef = tdrRadicDef;
        this.tdrRadicObs = tdrRadicObs;
        this.tdrRadicObsDef = tdrRadicObsDef;
        this.tdrRadicProy = tdrRadicProy;
    }


    @Id
    @Column(name = "TDR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_TERMINOS_REFERENCIA_COD")
    @SequenceGenerator(name = "SEQ_TERMINOS_REFERENCIA_COD", sequenceName = "SEQ_TERMINOS_REFERENCIA_COD",allocationSize=1)
    public Long getTdrCodigo() {
        return tdrCodigo;
    }

    public void setTdrCodigo(Long tdrCodigo) {
        this.tdrCodigo = tdrCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_AP_AUD")
    public Date getTdrFechaApAud() {
        return tdrFechaApAud;
    }

    public void setTdrFechaApAud(Date tdrFechaApAud) {
        this.tdrFechaApAud = tdrFechaApAud;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_AP_DEF")
    public Date getTdrFechaApDef() {
        return tdrFechaApDef;
    }

    public void setTdrFechaApDef(Date tdrFechaApDef) {
        this.tdrFechaApDef = tdrFechaApDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_AP_OBS")
    public Date getTdrFechaApObs() {
        return tdrFechaApObs;
    }

    public void setTdrFechaApObs(Date tdrFechaApObs) {
        this.tdrFechaApObs = tdrFechaApObs;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_AP_OBS_DEF")
    public Date getTdrFechaApObsDef() {
        return tdrFechaApObsDef;
    }

    public void setTdrFechaApObsDef(Date tdrFechaApObsDef) {
        this.tdrFechaApObsDef = tdrFechaApObsDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_AP_PROY")
    public Date getTdrFechaApProy() {
        return tdrFechaApProy;
    }

    public void setTdrFechaApProy(Date tdrFechaApProy) {
        this.tdrFechaApProy = tdrFechaApProy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_EN_AUD")
    public Date getTdrFechaEnAud() {
        return tdrFechaEnAud;
    }

    public void setTdrFechaEnAud(Date tdrFechaEnAud) {
        this.tdrFechaEnAud = tdrFechaEnAud;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_EN_DEF")
    public Date getTdrFechaEnDef() {
        return tdrFechaEnDef;
    }

    public void setTdrFechaEnDef(Date tdrFechaEnDef) {
        this.tdrFechaEnDef = tdrFechaEnDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_EN_OBS")
    public Date getTdrFechaEnObs() {
        return tdrFechaEnObs;
    }

    public void setTdrFechaEnObs(Date tdrFechaEnObs) {
        this.tdrFechaEnObs = tdrFechaEnObs;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_EN_OBS_DEF")
    public Date getTdrFechaEnObsDef() {
        return tdrFechaEnObsDef;
    }

    public void setTdrFechaEnObsDef(Date tdrFechaEnObsDef) {
        this.tdrFechaEnObsDef = tdrFechaEnObsDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_EN_PROY")
    public Date getTdrFechaEnProy() {
        return tdrFechaEnProy;
    }

    public void setTdrFechaEnProy(Date tdrFechaEnProy) {
        this.tdrFechaEnProy = tdrFechaEnProy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_PB_AUD")
    public Date getTdrFechaPbAud() {
        return tdrFechaPbAud;
    }

    public void setTdrFechaPbAud(Date tdrFechaPbAud) {
        this.tdrFechaPbAud = tdrFechaPbAud;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_PB_DEF")
    public Date getTdrFechaPbDef() {
        return tdrFechaPbDef;
    }

    public void setTdrFechaPbDef(Date tdrFechaPbDef) {
        this.tdrFechaPbDef = tdrFechaPbDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_PB_OBS")
    public Date getTdrFechaPbObs() {
        return tdrFechaPbObs;
    }

    public void setTdrFechaPbObs(Date tdrFechaPbObs) {
        this.tdrFechaPbObs = tdrFechaPbObs;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_PB_OBS_DEF")
    public Date getTdrFechaPbObsDef() {
        return tdrFechaPbObsDef;
    }

    public void setTdrFechaPbObsDef(Date tdrFechaPbObsDef) {
        this.tdrFechaPbObsDef = tdrFechaPbObsDef;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TDR_FECHA_PB_PROY")
    public Date getTdrFechaPbProy() {
        return tdrFechaPbProy;
    }

    public void setTdrFechaPbProy(Date tdrFechaPbProy) {
        this.tdrFechaPbProy = tdrFechaPbProy;
    }

    @OneToMany(mappedBy = "siiTerminosReferencia")
    public List<SiiDocumentoTdr> getSiiDocumentoTdrList() {
        return siiDocumentoTdrList;
    }

    public void setSiiDocumentoTdrList(List<SiiDocumentoTdr> siiDocumentoTdrList) {
        this.siiDocumentoTdrList = siiDocumentoTdrList;
    }

    public SiiDocumentoTdr addSiiDocumentoTdr(SiiDocumentoTdr siiDocumentoTdr) {
        getSiiDocumentoTdrList().add(siiDocumentoTdr);
        siiDocumentoTdr.setSiiTerminosReferencia(this);
        return siiDocumentoTdr;
    }

    public SiiDocumentoTdr removeSiiDocumentoTdr(SiiDocumentoTdr siiDocumentoTdr) {
        getSiiDocumentoTdrList().remove(siiDocumentoTdr);
        siiDocumentoTdr.setSiiTerminosReferencia(null);
        return siiDocumentoTdr;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @Column(name = "TDR_RADIC_AUD", length = 200)
    public String getTdrRadicAud() {
        return tdrRadicAud;
    }

    public void setTdrRadicAud(String tdrRadicAud) {
        this.tdrRadicAud = tdrRadicAud;
    }

    @Column(name = "TDR_RADIC_DEF", length = 200)
    public String getTdrRadicDef() {
        return tdrRadicDef;
    }

    public void setTdrRadicDef(String tdrRadicDef) {
        this.tdrRadicDef = tdrRadicDef;
    }

    @Column(name = "TDR_RADIC_OBS", length = 200)
    public String getTdrRadicObs() {
        return tdrRadicObs;
    }

    public void setTdrRadicObs(String tdrRadicObs) {
        this.tdrRadicObs = tdrRadicObs;
    }

    @Column(name = "TDR_RADIC_OBS_DEF", length = 200)
    public String getTdrRadicObsDef() {
        return tdrRadicObsDef;
    }

    public void setTdrRadicObsDef(String tdrRadicObsDef) {
        this.tdrRadicObsDef = tdrRadicObsDef;
    }

    @Column(name = "TDR_RADIC_PROY", length = 200)
    public String getTdrRadicProy() {
        return tdrRadicProy;
    }

    public void setTdrRadicProy(String tdrRadicProy) {
        this.tdrRadicProy = tdrRadicProy;
    }

    @OneToMany(mappedBy = "siiTerminosReferencia")
    public List<SiiAdendaTdr> getSiiAdendaTdrList() {
        return siiAdendaTdrList;
    }

    public void setSiiAdendaTdrList(List<SiiAdendaTdr> siiAdendaTdrList) {
        this.siiAdendaTdrList = siiAdendaTdrList;
    }

    public SiiAdendaTdr addSiiAdendaTdr(SiiAdendaTdr siiAdendaTdr) {
        getSiiAdendaTdrList().add(siiAdendaTdr);
        siiAdendaTdr.setSiiTerminosReferencia(this);
        return siiAdendaTdr;
    }

    public SiiAdendaTdr removeSiiAdendaTdr(SiiAdendaTdr siiAdendaTdr) {
        getSiiAdendaTdrList().remove(siiAdendaTdr);
        siiAdendaTdr.setSiiTerminosReferencia(null);
        return siiAdendaTdr;
    }
}
