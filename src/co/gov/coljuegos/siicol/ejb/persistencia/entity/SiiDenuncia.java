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
@Table(name = "SII_DENUNCIA")
public class SiiDenuncia implements Serializable {
    private static final long serialVersionUID = 5309786141709991881L;
    private String denBarrio;
    private Long denCodigo;
    private Integer denDenunEdad;
    private String denDenunEmail;
    private String denDenunGenero;
    private String denDenunNumIden;
    private String denDenunPrimApe;
    private String denDenunPrimNom;
    private String denDenunRazonSoc;
    private String denDenunSegApe;
    private String denDenunSegNom;
    private String denDenunTelef;
    private String denDetalle;
    private String denDnadoNumIden;
    private String denDnadoPrimApe;
    private String denDnadoPrimNom;
    private String denDnadoSegApe;
    private String denDnadoSegNom;
    private String denDnadoTelef;
    private Date denFechaDescarte;
    private Date denFechaRadicado;
    private String denFuente;
    private String denLocal;
    private String denLocalidad;
    private String denMotivoDescarte;
    private Integer denNumero;
    private Integer denNumeroSoporte;
    private String denPaginaWeb;
    private String denRadicado;
    private String denRtaCanal;
    private String denRtaDescripcion;
    private String denRtaEstado;
    private Date denRtaFechaRadic;
    private Date denRtaFechaRadAl;
    private Date denRtaFechaRadFis;
    private String denRtaRadicado;
    private String denRtaRadicAlcal;
    private String denRtaRadicFisc;
    private String denTipoDenunciante;
    private String denTipJuegoLoc;
    private String denTipJuegoNov;
    private String denTipJuegoOtros;
    private String denTipJuegoSinIden;
    private String denTipoSoporte;
    private Date denVerfesFecha;
    private String denVerfesObserv;
    private String denVerfesVerCon;
    private String denVerfesVerTra;
    private Long usuCodigo;
    private SiiUbicacion siiUbicacionLocal;
    private SiiAreaColjuegos siiAreaColjuegos;
    private SiiResultadoVerifDenun siiResultadoVerifDenun;
    private SiiEstadoDenuncia siiEstadoDenuncia;
    private SiiUbicacion siiUbicacionDenunciante;
    private SiiTipoIdentificacion siiTipoIdentificacion;
    private List<SiiDenunciaOrdenTrab> siiDenunciaOrdenTrabList;
    private List<SiiElementoIlegDenun> siiElementoIlegDenunList;
    private SiiTipoIdentificacion siiTipoIdentificacionDenunciado;
    private SiiUbicacion siiUbicacionMunicDenunciado;
    private SiiMedioDenuncia siiMedioDenuncia;
    private List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList;
    private SiiDireccion siiDireccionDenun;
    private SiiDireccion siiDireccion;
    private SiiDireccion siiDireccionDnado;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadList;

    public SiiDenuncia() {
    }

    public SiiDenuncia(SiiAreaColjuegos siiAreaColjuegos, String denBarrio, Long denCodigo, Integer denDenunEdad, String denDenunEmail, String denDenunGenero,
                       String denDenunNumIden, String denDenunPrimApe, String denDenunPrimNom, String denDenunRazonSoc, String denDenunSegApe, String denDenunSegNom, String denDenunTelef,
                       String denDetalle, Date denFechaDescarte, Date denFechaRadicado, String denFuente, String denLocal, String denLocalidad, String denMotivoDescarte,
                       Integer denNumero, String denRadicado, String denRtaCanal, String denRtaDescripcion, String denRtaEstado, Date denRtaFechaRadAl,
                       Date denRtaFechaRadFis, Date denRtaFechaRadic, String denRtaRadicAlcal, String denRtaRadicFisc, String denRtaRadicado, String denTipJuegoLoc, String denTipJuegoNov,
                       String denTipJuegoOtros, String denTipJuegoSinIden, String denTipoDenunciante, Date denVerfesFecha, String denVerfesObserv, String denVerfesVerCon, String denVerfesVerTra,
                       SiiEstadoDenuncia siiEstadoDenuncia, SiiResultadoVerifDenun siiResultadoVerifDenun, SiiTipoIdentificacion siiTipoIdentificacion, SiiUbicacion siiUbicacionDenunciante,
                       SiiUbicacion siiUbicacionLocal, Long usuCodigo) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.denBarrio = denBarrio;
        this.denCodigo = denCodigo;
        this.denDenunEdad = denDenunEdad;
        this.denDenunEmail = denDenunEmail;
        this.denDenunGenero = denDenunGenero;
        this.denDenunNumIden = denDenunNumIden;
        this.denDenunPrimApe = denDenunPrimApe;
        this.denDenunPrimNom = denDenunPrimNom;
        this.denDenunRazonSoc = denDenunRazonSoc;
        this.denDenunSegApe = denDenunSegApe;
        this.denDenunSegNom = denDenunSegNom;
        this.denDenunTelef = denDenunTelef;
        this.denDetalle = denDetalle;
        this.denFechaDescarte = denFechaDescarte;
        this.denFechaRadicado = denFechaRadicado;
        this.denFuente = denFuente;
        this.denLocal = denLocal;
        this.denLocalidad = denLocalidad;
        this.denMotivoDescarte = denMotivoDescarte;
        this.denNumero = denNumero;
        this.denRadicado = denRadicado;
        this.denRtaCanal = denRtaCanal;
        this.denRtaDescripcion = denRtaDescripcion;
        this.denRtaEstado = denRtaEstado;
        this.denRtaFechaRadAl = denRtaFechaRadAl;
        this.denRtaFechaRadFis = denRtaFechaRadFis;
        this.denRtaFechaRadic = denRtaFechaRadic;
        this.denRtaRadicAlcal = denRtaRadicAlcal;
        this.denRtaRadicFisc = denRtaRadicFisc;
        this.denRtaRadicado = denRtaRadicado;
        this.denTipJuegoLoc = denTipJuegoLoc;
        this.denTipJuegoNov = denTipJuegoNov;
        this.denTipJuegoOtros = denTipJuegoOtros;
        this.denTipJuegoSinIden = denTipJuegoSinIden;
        this.denTipoDenunciante = denTipoDenunciante;
        this.denVerfesFecha = denVerfesFecha;
        this.denVerfesObserv = denVerfesObserv;
        this.denVerfesVerCon = denVerfesVerCon;
        this.denVerfesVerTra = denVerfesVerTra;
        this.siiEstadoDenuncia = siiEstadoDenuncia;
        this.siiResultadoVerifDenun = siiResultadoVerifDenun;
        this.siiTipoIdentificacion = siiTipoIdentificacion;
        this.siiUbicacionDenunciante = siiUbicacionDenunciante;
        this.siiUbicacionLocal = siiUbicacionLocal;
        this.usuCodigo = usuCodigo;
    }


    @Column(name = "DEN_BARRIO", length = 40)
    public String getDenBarrio() {
        return denBarrio;
    }

    public void setDenBarrio(String denBarrio) {
        this.denBarrio = denBarrio;
    }

    @Id
    @Column(name = "DEN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DENUNCIA_COD")
    @SequenceGenerator(name = "SEQ_DENUNCIA_COD", sequenceName = "SEQ_DENUNCIA_COD",allocationSize=1)
    public Long getDenCodigo() {
        return denCodigo;
    }

    public void setDenCodigo(Long denCodigo) {
        this.denCodigo = denCodigo;
    }

    @Column(name = "DEN_DENUN_EDAD")
    public Integer getDenDenunEdad() {
        return denDenunEdad;
    }

    public void setDenDenunEdad(Integer denDenunEdad) {
        this.denDenunEdad = denDenunEdad;
    }

    @Column(name = "DEN_DENUN_EMAIL", length = 30)
    public String getDenDenunEmail() {
        return denDenunEmail;
    }

    public void setDenDenunEmail(String denDenunEmail) {
        this.denDenunEmail = denDenunEmail;
    }

    @Column(name = "DEN_DENUN_GENERO", length = 1)
    public String getDenDenunGenero() {
        return denDenunGenero;
    }

    public void setDenDenunGenero(String denDenunGenero) {
        this.denDenunGenero = denDenunGenero;
    }

    @Column(name = "DEN_DENUN_NUM_IDEN", length = 20)
    public String getDenDenunNumIden() {
        return denDenunNumIden;
    }

    public void setDenDenunNumIden(String denDenunNumIden) {
        this.denDenunNumIden = denDenunNumIden;
    }

    @Column(name = "DEN_DENUN_PRIM_APE", length = 15)
    public String getDenDenunPrimApe() {
        return denDenunPrimApe;
    }

    public void setDenDenunPrimApe(String denDenunPrimApe) {
        this.denDenunPrimApe = denDenunPrimApe;
    }

    @Column(name = "DEN_DENUN_PRIM_NOM", length = 15)
    public String getDenDenunPrimNom() {
        return denDenunPrimNom;
    }

    public void setDenDenunPrimNom(String denDenunPrimNom) {
        this.denDenunPrimNom = denDenunPrimNom;
    }

    @Column(name = "DEN_DENUN_RAZON_SOC", length = 100)
    public String getDenDenunRazonSoc() {
        return denDenunRazonSoc;
    }

    public void setDenDenunRazonSoc(String denDenunRazonSoc) {
        this.denDenunRazonSoc = denDenunRazonSoc;
    }

    @Column(name = "DEN_DENUN_SEG_APE", length = 15)
    public String getDenDenunSegApe() {
        return denDenunSegApe;
    }

    public void setDenDenunSegApe(String denDenunSegApe) {
        this.denDenunSegApe = denDenunSegApe;
    }

    @Column(name = "DEN_DENUN_SEG_NOM", length = 15)
    public String getDenDenunSegNom() {
        return denDenunSegNom;
    }

    public void setDenDenunSegNom(String denDenunSegNom) {
        this.denDenunSegNom = denDenunSegNom;
    }

    @Column(name = "DEN_DENUN_TELEF", length = 20)
    public String getDenDenunTelef() {
        return denDenunTelef;
    }

    public void setDenDenunTelef(String denDenunTelef) {
        this.denDenunTelef = denDenunTelef;
    }

    @Column(name = "DEN_DETALLE")
    public String getDenDetalle() {
        return denDetalle;
    }

    public void setDenDetalle(String denDetalle) {
        this.denDetalle = denDetalle;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_FECHA_DESCARTE")
    public Date getDenFechaDescarte() {
        return denFechaDescarte;
    }

    public void setDenFechaDescarte(Date denFechaDescarte) {
        this.denFechaDescarte = denFechaDescarte;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_FECHA_RADICADO", nullable = false)
    public Date getDenFechaRadicado() {
        return denFechaRadicado;
    }

    public void setDenFechaRadicado(Date denFechaRadicado) {
        this.denFechaRadicado = denFechaRadicado;
    }

    @Column(name = "DEN_FUENTE", nullable = false, length = 1)
    public String getDenFuente() {
        return denFuente;
    }

    public void setDenFuente(String denFuente) {
        this.denFuente = denFuente;
    }

    @Column(name = "DEN_LOCAL", length = 40)
    public String getDenLocal() {
        return denLocal;
    }

    public void setDenLocal(String denLocal) {
        this.denLocal = denLocal;
    }

    @Column(name = "DEN_LOCALIDAD", length = 40)
    public String getDenLocalidad() {
        return denLocalidad;
    }

    public void setDenLocalidad(String denLocalidad) {
        this.denLocalidad = denLocalidad;
    }

    @Column(name = "DEN_MOTIVO_DESCARTE", length = 110)
    public String getDenMotivoDescarte() {
        return denMotivoDescarte;
    }

    public void setDenMotivoDescarte(String denMotivoDescarte) {
        this.denMotivoDescarte = denMotivoDescarte;
    }

    @Column(name = "DEN_NUMERO", nullable = false)
    public Integer getDenNumero() {
        return denNumero;
    }

    public void setDenNumero(Integer denNumero) {
        this.denNumero = denNumero;
    }

    @Column(name = "DEN_RADICADO", nullable = false, length = 30)
    public String getDenRadicado() {
        return denRadicado;
    }

    public void setDenRadicado(String denRadicado) {
        this.denRadicado = denRadicado;
    }

    @Column(name = "DEN_RTA_CANAL", length = 1)
    public String getDenRtaCanal() {
        return denRtaCanal;
    }

    public void setDenRtaCanal(String denRtaCanal) {
        this.denRtaCanal = denRtaCanal;
    }

    @Column(name = "DEN_RTA_DESCRIPCION")
    public String getDenRtaDescripcion() {
        return denRtaDescripcion;
    }

    public void setDenRtaDescripcion(String denRtaDescripcion) {
        this.denRtaDescripcion = denRtaDescripcion;
    }

    @Column(name = "DEN_RTA_ESTADO", length = 1)
    public String getDenRtaEstado() {
        return denRtaEstado;
    }

    public void setDenRtaEstado(String denRtaEstado) {
        this.denRtaEstado = denRtaEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_RTA_FECHA_RADIC")
    public Date getDenRtaFechaRadic() {
        return denRtaFechaRadic;
    }

    public void setDenRtaFechaRadic(Date denRtaFechaRadic) {
        this.denRtaFechaRadic = denRtaFechaRadic;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_RTA_FECHA_RAD_AL")
    public Date getDenRtaFechaRadAl() {
        return denRtaFechaRadAl;
    }

    public void setDenRtaFechaRadAl(Date denRtaFechaRadAl) {
        this.denRtaFechaRadAl = denRtaFechaRadAl;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_RTA_FECHA_RAD_FIS")
    public Date getDenRtaFechaRadFis() {
        return denRtaFechaRadFis;
    }

    public void setDenRtaFechaRadFis(Date denRtaFechaRadFis) {
        this.denRtaFechaRadFis = denRtaFechaRadFis;
    }

    @Column(name = "DEN_RTA_RADICADO", length = 30)
    public String getDenRtaRadicado() {
        return denRtaRadicado;
    }

    public void setDenRtaRadicado(String denRtaRadicado) {
        this.denRtaRadicado = denRtaRadicado;
    }

    @Column(name = "DEN_RTA_RADIC_ALCAL", length = 30)
    public String getDenRtaRadicAlcal() {
        return denRtaRadicAlcal;
    }

    public void setDenRtaRadicAlcal(String denRtaRadicAlcal) {
        this.denRtaRadicAlcal = denRtaRadicAlcal;
    }

    @Column(name = "DEN_RTA_RADIC_FISC", length = 30)
    public String getDenRtaRadicFisc() {
        return denRtaRadicFisc;
    }

    public void setDenRtaRadicFisc(String denRtaRadicFisc) {
        this.denRtaRadicFisc = denRtaRadicFisc;
    }

    @Column(name = "DEN_TIPO_DENUNCIANTE", nullable = false, length = 1)
    public String getDenTipoDenunciante() {
        return denTipoDenunciante;
    }

    public void setDenTipoDenunciante(String denTipoDenunciante) {
        this.denTipoDenunciante = denTipoDenunciante;
    }

    @Column(name = "DEN_TIP_JUEGO_LOC", length = 1)
    public String getDenTipJuegoLoc() {
        return denTipJuegoLoc;
    }

    public void setDenTipJuegoLoc(String denTipJuegoLoc) {
        this.denTipJuegoLoc = denTipJuegoLoc;
    }

    @Column(name = "DEN_TIP_JUEGO_NOV", length = 1)
    public String getDenTipJuegoNov() {
        return denTipJuegoNov;
    }

    public void setDenTipJuegoNov(String denTipJuegoNov) {
        this.denTipJuegoNov = denTipJuegoNov;
    }

    @Column(name = "DEN_TIP_JUEGO_OTROS", length = 1)
    public String getDenTipJuegoOtros() {
        return denTipJuegoOtros;
    }

    public void setDenTipJuegoOtros(String denTipJuegoOtros) {
        this.denTipJuegoOtros = denTipJuegoOtros;
    }

    @Column(name = "DEN_TIP_JUEGO_SIN_IDEN", length = 1)
    public String getDenTipJuegoSinIden() {
        return denTipJuegoSinIden;
    }

    public void setDenTipJuegoSinIden(String denTipJuegoSinIden) {
        this.denTipJuegoSinIden = denTipJuegoSinIden;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DEN_VERFES_FECHA")
    public Date getDenVerfesFecha() {
        return denVerfesFecha;
    }

    public void setDenVerfesFecha(Date denVerfesFecha) {
        this.denVerfesFecha = denVerfesFecha;
    }

    @Column(name = "DEN_VERFES_OBSERV")
    public String getDenVerfesObserv() {
        return denVerfesObserv;
    }

    public void setDenVerfesObserv(String denVerfesObserv) {
        this.denVerfesObserv = denVerfesObserv;
    }

    @Column(name = "DEN_VERFES_VER_CON", length = 1)
    public String getDenVerfesVerCon() {
        return denVerfesVerCon;
    }

    public void setDenVerfesVerCon(String denVerfesVerCon) {
        this.denVerfesVerCon = denVerfesVerCon;
    }

    @Column(name = "DEN_VERFES_VER_TRA", length = 1)
    public String getDenVerfesVerTra() {
        return denVerfesVerTra;
    }

    public void setDenVerfesVerTra(String denVerfesVerTra) {
        this.denVerfesVerTra = denVerfesVerTra;
    }


    @Column(name = "USU_CODIGO")
    public Long getUsuCodigo() {
        return usuCodigo;
    }

    public void setUsuCodigo(Long usuCodigo) {
        this.usuCodigo = usuCodigo;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_LOCAL")
    public SiiUbicacion getSiiUbicacionLocal() {
        return siiUbicacionLocal;
    }

    public void setSiiUbicacionLocal(SiiUbicacion siiUbicacionLocal) {
        this.siiUbicacionLocal = siiUbicacionLocal;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO_DENUN")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
    }

    @ManyToOne
    @JoinColumn(name = "REV_CODIGO")
    public SiiResultadoVerifDenun getSiiResultadoVerifDenun() {
        return siiResultadoVerifDenun;
    }

    public void setSiiResultadoVerifDenun(SiiResultadoVerifDenun siiResultadoVerifDenun) {
        this.siiResultadoVerifDenun = siiResultadoVerifDenun;
    }

    @ManyToOne
    @JoinColumn(name = "EDN_CODIGO")
    public SiiEstadoDenuncia getSiiEstadoDenuncia() {
        return siiEstadoDenuncia;
    }

    public void setSiiEstadoDenuncia(SiiEstadoDenuncia siiEstadoDenuncia) {
        this.siiEstadoDenuncia = siiEstadoDenuncia;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_DENUN")
    public SiiUbicacion getSiiUbicacionDenunciante() {
        return siiUbicacionDenunciante;
    }

    public void setSiiUbicacionDenunciante(SiiUbicacion siiUbicacionDenunciante) {
        this.siiUbicacionDenunciante = siiUbicacionDenunciante;
    }

    @ManyToOne
    @JoinColumn(name = "TID_CODIGO")
    public SiiTipoIdentificacion getSiiTipoIdentificacion() {
        return siiTipoIdentificacion;
    }

    public void setSiiTipoIdentificacion(SiiTipoIdentificacion siiTipoIdentificacion) {
        this.siiTipoIdentificacion = siiTipoIdentificacion;
    }

    @OneToMany(mappedBy = "siiDenuncia")
    public List<SiiDenunciaOrdenTrab> getSiiDenunciaOrdenTrabList() {
        return siiDenunciaOrdenTrabList;
    }

    public void setSiiDenunciaOrdenTrabList(List<SiiDenunciaOrdenTrab> siiDenunciaOrdenTrabList) {
        this.siiDenunciaOrdenTrabList = siiDenunciaOrdenTrabList;
    }

    public SiiDenunciaOrdenTrab addSiiDenunciaOrdenTrab(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        getSiiDenunciaOrdenTrabList().add(siiDenunciaOrdenTrab);
        siiDenunciaOrdenTrab.setSiiDenuncia(this);
        return siiDenunciaOrdenTrab;
    }

    public SiiDenunciaOrdenTrab removeSiiDenunciaOrdenTrab(SiiDenunciaOrdenTrab siiDenunciaOrdenTrab) {
        getSiiDenunciaOrdenTrabList().remove(siiDenunciaOrdenTrab);
        siiDenunciaOrdenTrab.setSiiDenuncia(null);
        return siiDenunciaOrdenTrab;
    }

    @OneToMany(mappedBy = "siiDenuncia")
    public List<SiiElementoIlegDenun> getSiiElementoIlegDenunList() {
        return siiElementoIlegDenunList;
    }

    public void setSiiElementoIlegDenunList(List<SiiElementoIlegDenun> siiElementoIlegDenunList) {
        this.siiElementoIlegDenunList = siiElementoIlegDenunList;
    }

    public SiiElementoIlegDenun addSiiElementoIlegDenun(SiiElementoIlegDenun siiElementoIlegDenun) {
        getSiiElementoIlegDenunList().add(siiElementoIlegDenun);
        siiElementoIlegDenun.setSiiDenuncia(this);
        return siiElementoIlegDenun;
    }

    public SiiElementoIlegDenun removeSiiElementoIlegDenun(SiiElementoIlegDenun siiElementoIlegDenun) {
        getSiiElementoIlegDenunList().remove(siiElementoIlegDenun);
        siiElementoIlegDenun.setSiiDenuncia(null);
        return siiElementoIlegDenun;
    }
    
    @Column(name = "DEN_NUMERO_SOPORTE")
    public Integer getDenNumeroSoporte() {
        return denNumeroSoporte;
    }

    public void setDenNumeroSoporte(Integer denNumeroSoporte) {
        this.denNumeroSoporte = denNumeroSoporte;
    }

    @Column(name = "DEN_PAGINA_WEB", length = 110)
    public String getDenPaginaWeb() {
        return denPaginaWeb;
    }

    public void setDenPaginaWeb(String denPaginaWeb) {
        this.denPaginaWeb = denPaginaWeb;
    }

    @Column(name = "DEN_TIPO_SOPORTE", length = 1)
    public String getDenTipoSoporte() {
        return denTipoSoporte;
    }

    public void setDenTipoSoporte(String denTipoSoporte) {
        this.denTipoSoporte = denTipoSoporte;
    }

    @Column(name = "DEN_DNADO_NUM_IDEN", length = 20)
    public String getDenDnadoNumIden() {
        return denDnadoNumIden;
    }

    public void setDenDnadoNumIden(String denDnadoNumIden) {
        this.denDnadoNumIden = denDnadoNumIden;
    }

    @Column(name = "DEN_DNADO_PRIM_APE", length = 20)
    public String getDenDnadoPrimApe() {
        return denDnadoPrimApe;
    }

    public void setDenDnadoPrimApe(String denDnadoPrimApe) {
        this.denDnadoPrimApe = denDnadoPrimApe;
    }

    @Column(name = "DEN_DNADO_PRIM_NOM", length = 20)
    public String getDenDnadoPrimNom() {
        return denDnadoPrimNom;
    }

    public void setDenDnadoPrimNom(String denDnadoPrimNom) {
        this.denDnadoPrimNom = denDnadoPrimNom;
    }

    @Column(name = "DEN_DNADO_SEG_APE", length = 20)
    public String getDenDnadoSegApe() {
        return denDnadoSegApe;
    }

    public void setDenDnadoSegApe(String denDnadoSegApe) {
        this.denDnadoSegApe = denDnadoSegApe;
    }

    @Column(name = "DEN_DNADO_SEG_NOM", length = 20)
    public String getDenDnadoSegNom() {
        return denDnadoSegNom;
    }

    public void setDenDnadoSegNom(String denDnadoSegNom) {
        this.denDnadoSegNom = denDnadoSegNom;
    }

    @Column(name = "DEN_DNADO_TELEF", length = 20)
    public String getDenDnadoTelef() {
        return denDnadoTelef;
    }

    public void setDenDnadoTelef(String denDnadoTelef) {
        this.denDnadoTelef = denDnadoTelef;
    }

    @ManyToOne
    @JoinColumn(name = "TID_CODIGO_DNADO")
    public SiiTipoIdentificacion getSiiTipoIdentificacionDenunciado() {
        return siiTipoIdentificacionDenunciado;
    }

    public void setSiiTipoIdentificacionDenunciado(SiiTipoIdentificacion siiTipoIdentificacionDenunciado) {
        this.siiTipoIdentificacionDenunciado = siiTipoIdentificacionDenunciado;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_DNADO")
    public SiiUbicacion getSiiUbicacionMunicDenunciado() {
        return siiUbicacionMunicDenunciado;
    }

    public void setSiiUbicacionMunicDenunciado(SiiUbicacion siiUbicacionMunicDenunciado) {
        this.siiUbicacionMunicDenunciado = siiUbicacionMunicDenunciado;
    }

    @ManyToOne
    @JoinColumn(name = "MED_CODIGO")
    public SiiMedioDenuncia getSiiMedioDenuncia() {
        return siiMedioDenuncia;
    }

    public void setSiiMedioDenuncia(SiiMedioDenuncia siiMedioDenuncia) {
        this.siiMedioDenuncia = siiMedioDenuncia;
    }

    @OneToMany(mappedBy = "siiDenuncia")
    public List<SiiAutoComisorioAccCon> getSiiAutoComisorioAccConList(){
        return siiAutoComisorioAccConList;
    }

    public void setSiiAutoComisorioAccConList(List<SiiAutoComisorioAccCon> siiAutoComisorioAccConList){
        this.siiAutoComisorioAccConList = siiAutoComisorioAccConList;
    }

    public SiiAutoComisorioAccCon addSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().add(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiDenuncia(this);
        return siiAutoComisorioAccCon;
    }

    public SiiAutoComisorioAccCon removeSiiAutoComisorioAccCon(SiiAutoComisorioAccCon siiAutoComisorioAccCon){
        getSiiAutoComisorioAccConList().remove(siiAutoComisorioAccCon);
        siiAutoComisorioAccCon.setSiiDenuncia(null);
        return siiAutoComisorioAccCon;
    }
    
    @JoinColumn(name = "DIR_CODIGO_DENUN")
    public SiiDireccion getSiiDireccionDenun() {
        return siiDireccionDenun;
    }

    public void setSiiDireccionDenun(SiiDireccion siiDireccionDenun) {
        this.siiDireccionDenun = siiDireccionDenun;
    }

    @ManyToOne
    @JoinColumn(name = "DIR_CODIGO")
    public SiiDireccion getSiiDireccion() {
        return siiDireccion;
    }

    public void setSiiDireccion(SiiDireccion siiDireccion) {
        this.siiDireccion = siiDireccion;
    }

    @ManyToOne
    @JoinColumn(name = "DIR_CODIGO_DNADO")
    public SiiDireccion getSiiDireccionDnado() {
        return siiDireccionDnado;
    }

    public void setSiiDireccionDnado(SiiDireccion siiDireccionDnado) {
        this.siiDireccionDnado = siiDireccionDnado;
    }
    @OneToMany(mappedBy = "siiDenuncia")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadList() {
        return siiProcesoSancIlegalidadList;
    }

    public void setSiiProcesoSancIlegalidadList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadList) {
        this.siiProcesoSancIlegalidadList = siiProcesoSancIlegalidadList;
    }

    public SiiProcesoSancIlegalidad addSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadList().add(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiDenuncia(this);
        return siiProcesoSancIlegalidad;
    }

    public SiiProcesoSancIlegalidad removeSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadList().remove(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiDenuncia(null);
        return siiProcesoSancIlegalidad;
    }
}
