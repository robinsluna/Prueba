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
@Table(name = "SII_RESOLUCION_AUTORIZ")
public class SiiResolucionAutoriz implements Serializable {
    private static final long serialVersionUID = -2287131640098078173L;
    private Long rauCodigo;
    private Date rauFechaNotif;
    private Date rauFechaPasFirma;
    private Date rauFechaPasRev;
    private Date rauFechaResFirme;
    private Date rauFechaResol;
    private String rauMedioNotif;
    private Long rauNumeroRes;
    private SiiEstadoResolucAut siiEstadoResolucAut;
    private SiiSolicitudAutoriza siiSolicitudAutoriza;
    private String rauObservaciones;
    private List<SiiComunicacSiito> siiComunicacSiitoList;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiRevisionFinancResolAutoriz> siiRevisionFinancResolAutorizList;
    private List<SiiRevisionGctResolucAutoriza> siiRevisionGctResolucAutorizaList;
    private String rauValidacFinanc;
    private String rauValidacGct;


    public SiiResolucionAutoriz() {
    }

    public SiiResolucionAutoriz(SiiEstadoResolucAut siiEstadoResolucAut, Long rauCodigo, Long rauNumeroRes, String rauObservaciones,
                                SiiSolicitudAutoriza siiSolicitudAutoriza, Date rauFechaNotif, String rauMedioNotif, Date rauFechaResol, Date rauFechaPasFirma,
                                Date rauFechaPasRev, Date rauFechaResFirme, SiiArchivoFisico siiArchivoFisico) {
        this.siiEstadoResolucAut = siiEstadoResolucAut;
        this.rauCodigo = rauCodigo;
        this.rauFechaNotif = rauFechaNotif;
        this.rauFechaPasFirma = rauFechaPasFirma;
        this.rauFechaPasRev = rauFechaPasRev;
        this.rauFechaResFirme = rauFechaResFirme;
        this.rauFechaResol = rauFechaResol;
        this.rauMedioNotif = rauMedioNotif;
        this.rauNumeroRes = rauNumeroRes;
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
        this.rauObservaciones = rauObservaciones;
        this.siiArchivoFisico = siiArchivoFisico;

    }


    @Id
    @Column(name = "RAU_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOLUCION_AUTORIZ")
    @SequenceGenerator(name = "SEQ_RESOLUCION_AUTORIZ", sequenceName = "SEQ_RESOLUCION_AUTORIZ",allocationSize=1)
    public Long getRauCodigo() {
        return rauCodigo;
    }

    public void setRauCodigo(Long rauCodigo) {
        this.rauCodigo = rauCodigo;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAU_FECHA_NOTIF")
    public Date getRauFechaNotif() {
        return rauFechaNotif;
    }

    public void setRauFechaNotif(Date rauFechaNotif) {
        this.rauFechaNotif = rauFechaNotif;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAU_FECHA_RESOL", nullable = false)
    public Date getRauFechaResol() {
        return rauFechaResol;
    }

    public void setRauFechaResol(Date rauFechaResol) {
        this.rauFechaResol = rauFechaResol;
    }

    @Column(name = "RAU_MEDIO_NOTIF", length = 2)
    public String getRauMedioNotif() {
        return rauMedioNotif;
    }

    public void setRauMedioNotif(String rauMedioNotif) {
        this.rauMedioNotif = rauMedioNotif;
    }

    @Column(name = "RAU_NUMERO_RES")
    public Long getRauNumeroRes() {
        return rauNumeroRes;
    }

    public void setRauNumeroRes(Long rauNumeroRes) {
        this.rauNumeroRes = rauNumeroRes;
    }


    @ManyToOne
    @JoinColumn(name = "ERA_CODIGO")
    public SiiEstadoResolucAut getSiiEstadoResolucAut() {
        return siiEstadoResolucAut;
    }

    public void setSiiEstadoResolucAut(SiiEstadoResolucAut siiEstadoResolucAut) {
        this.siiEstadoResolucAut = siiEstadoResolucAut;
    }

    @ManyToOne
    @JoinColumn(name = "SAU_CODIGO")
    public SiiSolicitudAutoriza getSiiSolicitudAutoriza() {
        return siiSolicitudAutoriza;
    }

    public void setSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        this.siiSolicitudAutoriza = siiSolicitudAutoriza;
    }

    @Column(name = "RAU_OBSERVACIONES", length = 500)
    public String getRauObservaciones() {
        return rauObservaciones;
    }

    public void setRauObservaciones(String rauObservaciones) {
        this.rauObservaciones = rauObservaciones;
    }

    @OneToMany(mappedBy = "siiResolucionAutoriz")
    public List<SiiComunicacSiito> getSiiComunicacSiitoList() {
        return siiComunicacSiitoList;
    }

    public void setSiiComunicacSiitoList(List<SiiComunicacSiito> siiComunicacSiitoList) {
        this.siiComunicacSiitoList = siiComunicacSiitoList;
    }

    public SiiComunicacSiito addSiiComunicacSiito(SiiComunicacSiito siiComunicacSiito) {
        getSiiComunicacSiitoList().add(siiComunicacSiito);
        siiComunicacSiito.setSiiResolucionAutoriz(this);
        return siiComunicacSiito;
    }

    public SiiComunicacSiito removeSiiComunicacSiito(SiiComunicacSiito siiComunicacSiito) {
        getSiiComunicacSiitoList().remove(siiComunicacSiito);
        siiComunicacSiito.setSiiResolucionAutoriz(null);
        return siiComunicacSiito;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAU_FECHA_PAS_FIRMA")
    public Date getRauFechaPasFirma() {
        return rauFechaPasFirma;
    }

    public void setRauFechaPasFirma(Date rauFechaPasFirma) {
        this.rauFechaPasFirma = rauFechaPasFirma;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAU_FECHA_PAS_REV")
    public Date getRauFechaPasRev() {
        return rauFechaPasRev;
    }

    public void setRauFechaPasRev(Date rauFechaPasRev) {
        this.rauFechaPasRev = rauFechaPasRev;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAU_FECHA_RES_FIRME")
    public Date getRauFechaResFirme() {
        return rauFechaResFirme;
    }

    public void setRauFechaResFirme(Date rauFechaResFirme) {
        this.rauFechaResFirme = rauFechaResFirme;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiResolucionAutoriz")
    public List<SiiRevisionFinancResolAutoriz> getSiiRevisionFinancResolAutorizList() {
        return siiRevisionFinancResolAutorizList;
    }

    public void setSiiRevisionFinancResolAutorizList(List<SiiRevisionFinancResolAutoriz> siiRevisionFinancResolAutorizList) {
        this.siiRevisionFinancResolAutorizList = siiRevisionFinancResolAutorizList;
    }

    public SiiRevisionFinancResolAutoriz addSiiRevisionFinancResolAutoriz(SiiRevisionFinancResolAutoriz siiRevisionFinancResolAutoriz) {
        getSiiRevisionFinancResolAutorizList().add(siiRevisionFinancResolAutoriz);
        siiRevisionFinancResolAutoriz.setSiiResolucionAutoriz(this);
        return siiRevisionFinancResolAutoriz;
    }

    public SiiRevisionFinancResolAutoriz removeSiiRevisionFinancResolAutoriz(SiiRevisionFinancResolAutoriz siiRevisionFinancResolAutoriz) {
        getSiiRevisionFinancResolAutorizList().remove(siiRevisionFinancResolAutoriz);
        siiRevisionFinancResolAutoriz.setSiiResolucionAutoriz(null);
        return siiRevisionFinancResolAutoriz;
    }

    @OneToMany(mappedBy = "siiResolucionAutoriz")
    public List<SiiRevisionGctResolucAutoriza> getSiiRevisionGctResolucAutorizaList() {
        return siiRevisionGctResolucAutorizaList;
    }

    public void setSiiRevisionGctResolucAutorizaList(List<SiiRevisionGctResolucAutoriza> siiRevisionGctResolucAutorizaList) {
        this.siiRevisionGctResolucAutorizaList = siiRevisionGctResolucAutorizaList;
    }

    public SiiRevisionGctResolucAutoriza addSiiRevisionGctResolucAutoriza(SiiRevisionGctResolucAutoriza siiRevisionGctResolucAutoriza) {
        getSiiRevisionGctResolucAutorizaList().add(siiRevisionGctResolucAutoriza);
        siiRevisionGctResolucAutoriza.setSiiResolucionAutoriz(this);
        return siiRevisionGctResolucAutoriza;
    }

    public SiiRevisionGctResolucAutoriza removeSiiRevisionGctResolucAutoriza(SiiRevisionGctResolucAutoriza siiRevisionGctResolucAutoriza) {
        getSiiRevisionGctResolucAutorizaList().remove(siiRevisionGctResolucAutoriza);
        siiRevisionGctResolucAutoriza.setSiiResolucionAutoriz(null);
        return siiRevisionGctResolucAutoriza;
    }

    @Column(name = "RAU_VALIDAC_FINANC", length = 1100)
    public String getRauValidacFinanc() {
        return rauValidacFinanc;
    }

    public void setRauValidacFinanc(String rauValidacFinanc) {
        this.rauValidacFinanc = rauValidacFinanc;
    }

    @Column(name = "RAU_VALIDAC_GCT", length = 1100)
    public String getRauValidacGct() {
        return rauValidacGct;
    }

    public void setRauValidacGct(String rauValidacGct) {
        this.rauValidacGct = rauValidacGct;
    }
}
