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
@Table(name = "SII_ESTUDIO_MERCADO")
public class SiiEstudioMercado implements Serializable {
    private static final long serialVersionUID = 1381193749322608327L;
    private String emeAnalisisMercado;
    private Long emeCodigo;
    private String emeDivulAcercam;
    private Date emeDivulAcercamFec;
    private String emeDivulEmail;
    private Date emeDivulEmailFec;
    private String emeDivulOtro;
    private String emeDivulOtroEspec;
    private Date emeDivulOtroFec;
    private String emeDivulProv;
    private Date emeDivulProvFec;
    private String emeDivulTel;
    private Date emeDivulTelFec;
    private Date emeFecha;
    private String emeObservaciones;
    private String emeReqPolizas;
    private List<SiiCotizacionEstudio> siiCotizacionEstudioList;
    private SiiProcesoContratacion siiProcesoContratacion1;
	private SiiEstadoEstudioMerc siiEstadoEstudioMerc;

    public SiiEstudioMercado() {
    }

    public SiiEstudioMercado(SiiEstadoEstudioMerc siiEstadoEstudioMerc, String emeAnalisisMercado, Long emeCodigo, String emeDivulAcercam, Date emeDivulAcercamFec,
                             String emeDivulEmail, Date emeDivulEmailFec, String emeDivulOtro, String emeDivulOtroEspec,
                             Date emeDivulOtroFec, String emeDivulProv, Date emeDivulProvFec, String emeDivulTel,
                             Date emeDivulTelFec, Date emeFecha, String emeObservaciones, String emeReqPolizas,
                             SiiProcesoContratacion siiProcesoContratacion1) {
		this.siiEstadoEstudioMerc = siiEstadoEstudioMerc;
        this.emeAnalisisMercado = emeAnalisisMercado;
        this.emeCodigo = emeCodigo;
        this.emeDivulAcercam = emeDivulAcercam;
        this.emeDivulAcercamFec = emeDivulAcercamFec;
        this.emeDivulEmail = emeDivulEmail;
        this.emeDivulEmailFec = emeDivulEmailFec;
        this.emeDivulOtro = emeDivulOtro;
        this.emeDivulOtroEspec = emeDivulOtroEspec;
        this.emeDivulOtroFec = emeDivulOtroFec;
        this.emeDivulProv = emeDivulProv;
        this.emeDivulProvFec = emeDivulProvFec;
        this.emeDivulTel = emeDivulTel;
        this.emeDivulTelFec = emeDivulTelFec;
        this.emeFecha = emeFecha;
        this.emeObservaciones = emeObservaciones;
        this.emeReqPolizas = emeReqPolizas;
        this.siiProcesoContratacion1 = siiProcesoContratacion1;
    }

    @Column(name = "EME_ANALISIS_MERCA_C", nullable = false)
    public String getEmeAnalisisMercado() {
        return emeAnalisisMercado;
    }

    public void setEmeAnalisisMercado(String emeAnalisisMercado) {
        this.emeAnalisisMercado = emeAnalisisMercado;
    }

    @Id
    @Column(name = "EME_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ESTUDIO_MERCADO_COD")
    @SequenceGenerator(name = "SEQ_ESTUDIO_MERCADO_COD", sequenceName = "SEQ_ESTUDIO_MERCADO_COD",allocationSize=1)
    public Long getEmeCodigo() {
        return emeCodigo;
    }

    public void setEmeCodigo(Long emeCodigo) {
        this.emeCodigo = emeCodigo;
    }

    @Column(name = "EME_DIVUL_ACERCAM", nullable = false, length = 1)
    public String getEmeDivulAcercam() {
        return emeDivulAcercam;
    }

    public void setEmeDivulAcercam(String emeDivulAcercam) {
        this.emeDivulAcercam = emeDivulAcercam;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_DIVUL_ACERCAM_FEC")
    public Date getEmeDivulAcercamFec() {
        return emeDivulAcercamFec;
    }

    public void setEmeDivulAcercamFec(Date emeDivulAcercamFec) {
        this.emeDivulAcercamFec = emeDivulAcercamFec;
    }

    @Column(name = "EME_DIVUL_EMAIL", nullable = false, length = 1)
    public String getEmeDivulEmail() {
        return emeDivulEmail;
    }

    public void setEmeDivulEmail(String emeDivulEmail) {
        this.emeDivulEmail = emeDivulEmail;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_DIVUL_EMAIL_FEC")
    public Date getEmeDivulEmailFec() {
        return emeDivulEmailFec;
    }

    public void setEmeDivulEmailFec(Date emeDivulEmailFec) {
        this.emeDivulEmailFec = emeDivulEmailFec;
    }

    @Column(name = "EME_DIVUL_OTRO", nullable = false, length = 1)
    public String getEmeDivulOtro() {
        return emeDivulOtro;
    }

    public void setEmeDivulOtro(String emeDivulOtro) {
        this.emeDivulOtro = emeDivulOtro;
    }

    @Column(name = "EME_DIVUL_OTRO_ESPEC", length = 100)
    public String getEmeDivulOtroEspec() {
        return emeDivulOtroEspec;
    }

    public void setEmeDivulOtroEspec(String emeDivulOtroEspec) {
        this.emeDivulOtroEspec = emeDivulOtroEspec;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_DIVUL_OTRO_FEC")
    public Date getEmeDivulOtroFec() {
        return emeDivulOtroFec;
    }

    public void setEmeDivulOtroFec(Date emeDivulOtroFec) {
        this.emeDivulOtroFec = emeDivulOtroFec;
    }

    @Column(name = "EME_DIVUL_PROV", nullable = false, length = 1)
    public String getEmeDivulProv() {
        return emeDivulProv;
    }

    public void setEmeDivulProv(String emeDivulProv) {
        this.emeDivulProv = emeDivulProv;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_DIVUL_PROV_FEC")
    public Date getEmeDivulProvFec() {
        return emeDivulProvFec;
    }

    public void setEmeDivulProvFec(Date emeDivulProvFec) {
        this.emeDivulProvFec = emeDivulProvFec;
    }

    @Column(name = "EME_DIVUL_TEL", nullable = false, length = 1)
    public String getEmeDivulTel() {
        return emeDivulTel;
    }

    public void setEmeDivulTel(String emeDivulTel) {
        this.emeDivulTel = emeDivulTel;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_DIVUL_TEL_FEC")
    public Date getEmeDivulTelFec() {
        return emeDivulTelFec;
    }

    public void setEmeDivulTelFec(Date emeDivulTelFec) {
        this.emeDivulTelFec = emeDivulTelFec;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EME_FECHA", nullable = false)
    public Date getEmeFecha() {
        return emeFecha;
    }

    public void setEmeFecha(Date emeFecha) {
        this.emeFecha = emeFecha;
    }

    @Column(name = "EME_OBSERVACION_C")
    public String getEmeObservaciones() {
        return emeObservaciones;
    }

    public void setEmeObservaciones(String emeObservaciones) {
        this.emeObservaciones = emeObservaciones;
    }

    @Column(name = "EME_REQ_POLIZAS", nullable = false, length = 1)
    public String getEmeReqPolizas() {
        return emeReqPolizas;
    }

    public void setEmeReqPolizas(String emeReqPolizas) {
        this.emeReqPolizas = emeReqPolizas;
    }


    @OneToMany(mappedBy = "siiEstudioMercado")
    public List<SiiCotizacionEstudio> getSiiCotizacionEstudioList() {
        return siiCotizacionEstudioList;
    }

    public void setSiiCotizacionEstudioList(List<SiiCotizacionEstudio> siiCotizacionEstudioList) {
        this.siiCotizacionEstudioList = siiCotizacionEstudioList;
    }

    public SiiCotizacionEstudio addSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().add(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiEstudioMercado(this);
        return siiCotizacionEstudio;
    }

    public SiiCotizacionEstudio removeSiiCotizacionEstudio(SiiCotizacionEstudio siiCotizacionEstudio) {
        getSiiCotizacionEstudioList().remove(siiCotizacionEstudio);
        siiCotizacionEstudio.setSiiEstudioMercado(null);
        return siiCotizacionEstudio;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion1() {
        return siiProcesoContratacion1;
    }

    public void setSiiProcesoContratacion1(SiiProcesoContratacion siiProcesoContratacion1) {
        this.siiProcesoContratacion1 = siiProcesoContratacion1;
    }

	@ManyToOne
    @JoinColumn(name = "EEM_CODIGO")
    public SiiEstadoEstudioMerc getSiiEstadoEstudioMerc() {
        return siiEstadoEstudioMerc;
    }

    public void setSiiEstadoEstudioMerc(SiiEstadoEstudioMerc siiEstadoEstudioMerc) {
        this.siiEstadoEstudioMerc = siiEstadoEstudioMerc;
    }
}
