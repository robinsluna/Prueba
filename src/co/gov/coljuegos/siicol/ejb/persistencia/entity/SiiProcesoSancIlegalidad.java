package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "SII_PROCESO_SANC_ILEGALIDAD")
public class SiiProcesoSancIlegalidad implements Serializable {
    private static final long serialVersionUID = 8732213200673352090L;
    private Date prsAuArcFechaGen;
    private Date prsAuArcSolNFecR;
    private String prsAuArcSolNRadi;
    private Long prsCodigo;
    private Integer prsConsecutivo;
    private String prsInterpRecApel;
    private String prsInterpRecRepo;
    private List<SiiAutoDecretaPrueProIle> siiAutoDecretaPrueProIleList;
    private List<SiiComunicacSujSancIle> siiComunicacSujSancIleList;
    private List<SiiPersonaInvestProIle> siiPersonaInvestProIleList;
    private List<SiiAutoFormCargProIle> siiAutoFormCargProIleList;
    private SiiResolucionProcIleg siiResolucionProcIlegApela;
    private SiiResolucionProcIleg siiResolucionProcIlegResol;
    private SiiDenuncia siiDenuncia;
    private SiiResolucionProcIleg siiResolucionProcIlegReposicion;
    private SiiUsuario siiUsuarioConec;
    private SiiEstadoProcSanIleg siiEstadoProcSanIleg;
    private List<SiiDescargoProcIleg> siiDescargoProcIlegList;
    private List<SiiInhabilidadPersona> siiInhabilidadPersonaList;
    private SiiResolucionProcIleg siiResolucionProcIlegSinSancion;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiElementoProcesoIle> siiElementoProcesoIleList;
    private Date prsFechaConHech;
    private String prsNumeroAuto;
    private Date prsFechaAuto;

    public SiiProcesoSancIlegalidad() {
    }

    public SiiProcesoSancIlegalidad(SiiDenuncia siiDenuncia, SiiEstadoProcSanIleg siiEstadoProcSanIleg, Date prsAuArcFechaGen, Date prsAuArcSolNFecR, String prsAuArcSolNRadi, Long prsCodigo,
                                    Integer prsConsecutivo, String prsInterpRecApel, String prsInterpRecRepo, SiiResolucionProcIleg siiResolucionProcIlegResol,
                                    SiiResolucionProcIleg siiResolucionProcIlegApela, SiiResolucionProcIleg siiResolucionProcIlegReposicion,
                                    SiiUsuario siiUsuarioConec) {
        this.siiDenuncia = siiDenuncia;
        this.siiEstadoProcSanIleg = siiEstadoProcSanIleg;
        this.prsAuArcFechaGen = prsAuArcFechaGen;
        this.prsAuArcSolNFecR = prsAuArcSolNFecR;
        this.prsAuArcSolNRadi = prsAuArcSolNRadi;
        this.prsCodigo = prsCodigo;
        this.prsConsecutivo = prsConsecutivo;
        this.prsInterpRecApel = prsInterpRecApel;
        this.prsInterpRecRepo = prsInterpRecRepo;
        this.siiResolucionProcIlegResol = siiResolucionProcIlegResol;
        this.siiResolucionProcIlegApela = siiResolucionProcIlegApela;
        this.siiResolucionProcIlegReposicion = siiResolucionProcIlegReposicion;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRS_AU_ARC_FECHA_GEN")
    public Date getPrsAuArcFechaGen() {
        return prsAuArcFechaGen;
    }

    public void setPrsAuArcFechaGen(Date prsAuArcFechaGen) {
        this.prsAuArcFechaGen = prsAuArcFechaGen;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRS_AU_ARC_SOL_N_FEC_R")
    public Date getPrsAuArcSolNFecR() {
        return prsAuArcSolNFecR;
    }

    public void setPrsAuArcSolNFecR(Date prsAuArcSolNFecR) {
        this.prsAuArcSolNFecR = prsAuArcSolNFecR;
    }

    @Column(name = "PRS_AU_ARC_SOL_N_RADI", length = 30)
    public String getPrsAuArcSolNRadi() {
        return prsAuArcSolNRadi;
    }

    public void setPrsAuArcSolNRadi(String prsAuArcSolNRadi) {
        this.prsAuArcSolNRadi = prsAuArcSolNRadi;
    }

    @Id
    @Column(name = "PRS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROC_SANC_ILEG_COD")
    @SequenceGenerator(name = "SEQ_PROC_SANC_ILEG_COD", sequenceName = "SEQ_PROC_SANC_ILEG_COD",allocationSize=1)
    public Long getPrsCodigo() {
        return prsCodigo;
    }

    public void setPrsCodigo(Long prsCodigo) {
        this.prsCodigo = prsCodigo;
    }

    @Column(name = "PRS_CONSECUTIVO", nullable = false)
    public Integer getPrsConsecutivo() {
        return prsConsecutivo;
    }

    public void setPrsConsecutivo(Integer prsConsecutivo) {
        this.prsConsecutivo = prsConsecutivo;
    }

    @Column(name = "PRS_INTERP_REC_APEL", nullable = false, length = 1)
    public String getPrsInterpRecApel() {
        return prsInterpRecApel;
    }

    public void setPrsInterpRecApel(String prsInterpRecApel) {
        this.prsInterpRecApel = prsInterpRecApel;
    }

    @Column(name = "PRS_INTERP_REC_REPO", nullable = false, length = 1)
    public String getPrsInterpRecRepo() {
        return prsInterpRecRepo;
    }

    public void setPrsInterpRecRepo(String prsInterpRecRepo) {
        this.prsInterpRecRepo = prsInterpRecRepo;
    }


    @OneToMany(mappedBy = "siiProcesoSancIlegalidad", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiAutoDecretaPrueProIle> getSiiAutoDecretaPrueProIleList() {
        return siiAutoDecretaPrueProIleList;
    }

    public void setSiiAutoDecretaPrueProIleList(List<SiiAutoDecretaPrueProIle> siiAutoDecretaPrueProIleList) {
        this.siiAutoDecretaPrueProIleList = siiAutoDecretaPrueProIleList;
    }

    public SiiAutoDecretaPrueProIle addSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        getSiiAutoDecretaPrueProIleList().add(siiAutoDecretaPrueProIle);
        siiAutoDecretaPrueProIle.setSiiProcesoSancIlegalidad(this);
        return siiAutoDecretaPrueProIle;
    }

    public SiiAutoDecretaPrueProIle removeSiiAutoDecretaPrueProIle(SiiAutoDecretaPrueProIle siiAutoDecretaPrueProIle) {
        getSiiAutoDecretaPrueProIleList().remove(siiAutoDecretaPrueProIle);
        siiAutoDecretaPrueProIle.setSiiProcesoSancIlegalidad(null);
        return siiAutoDecretaPrueProIle;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiComunicacSujSancIle> getSiiComunicacSujSancIleList() {
        return siiComunicacSujSancIleList;
    }

    public void setSiiComunicacSujSancIleList(List<SiiComunicacSujSancIle> siiComunicacSujSancIleList) {
        this.siiComunicacSujSancIleList = siiComunicacSujSancIleList;
    }

    public SiiComunicacSujSancIle addSiiComunicacSujSancIle(SiiComunicacSujSancIle siiComunicacSujSancIle) {
        getSiiComunicacSujSancIleList().add(siiComunicacSujSancIle);
        siiComunicacSujSancIle.setSiiProcesoSancIlegalidad(this);
        return siiComunicacSujSancIle;
    }

    public SiiComunicacSujSancIle removeSiiComunicacSujSancIle(SiiComunicacSujSancIle siiComunicacSujSancIle) {
        getSiiComunicacSujSancIleList().remove(siiComunicacSujSancIle);
        siiComunicacSujSancIle.setSiiProcesoSancIlegalidad(null);
        return siiComunicacSujSancIle;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiPersonaInvestProIle> getSiiPersonaInvestProIleList() {
        return siiPersonaInvestProIleList;
    }

    public void setSiiPersonaInvestProIleList(List<SiiPersonaInvestProIle> siiPersonaInvestProIleList) {
        this.siiPersonaInvestProIleList = siiPersonaInvestProIleList;
    }

    public SiiPersonaInvestProIle addSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleList().add(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiProcesoSancIlegalidad(this);
        return siiPersonaInvestProIle;
    }

    public SiiPersonaInvestProIle removeSiiPersonaInvestProIle(SiiPersonaInvestProIle siiPersonaInvestProIle) {
        getSiiPersonaInvestProIleList().remove(siiPersonaInvestProIle);
        siiPersonaInvestProIle.setSiiProcesoSancIlegalidad(null);
        return siiPersonaInvestProIle;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiAutoFormCargProIle> getSiiAutoFormCargProIleList() {
        return siiAutoFormCargProIleList;
    }

    public void setSiiAutoFormCargProIleList(List<SiiAutoFormCargProIle> siiAutoFormCargProIleList) {
        this.siiAutoFormCargProIleList = siiAutoFormCargProIleList;
    }

    public SiiAutoFormCargProIle addSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        getSiiAutoFormCargProIleList().add(siiAutoFormCargProIle);
        siiAutoFormCargProIle.setSiiProcesoSancIlegalidad(this);
        return siiAutoFormCargProIle;
    }

    public SiiAutoFormCargProIle removeSiiAutoFormCargProIle(SiiAutoFormCargProIle siiAutoFormCargProIle) {
        getSiiAutoFormCargProIleList().remove(siiAutoFormCargProIle);
        siiAutoFormCargProIle.setSiiProcesoSancIlegalidad(null);
        return siiAutoFormCargProIle;
    }

    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO_APELAC")
    public SiiResolucionProcIleg getSiiResolucionProcIlegApela() {
        return siiResolucionProcIlegApela;
    }

    public void setSiiResolucionProcIlegApela(SiiResolucionProcIleg siiResolucionProcIlegApela) {
        this.siiResolucionProcIlegApela = siiResolucionProcIlegApela;
    }

    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO")
    public SiiResolucionProcIleg getSiiResolucionProcIlegResol() {
        return siiResolucionProcIlegResol;
    }

    public void setSiiResolucionProcIlegResol(SiiResolucionProcIleg siiResolucionProcIlegResol) {
        this.siiResolucionProcIlegResol = siiResolucionProcIlegResol;
    }

    @ManyToOne
    @JoinColumn(name = "DEN_CODIGO")
    public SiiDenuncia getSiiDenuncia() {
        return siiDenuncia;
    }

    public void setSiiDenuncia(SiiDenuncia siiDenuncia) {
        this.siiDenuncia = siiDenuncia;
    }

    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO_REPOSIC")
    public SiiResolucionProcIleg getSiiResolucionProcIlegReposicion() {
        return siiResolucionProcIlegReposicion;
    }

    public void setSiiResolucionProcIlegReposicion(SiiResolucionProcIleg siiResolucionProcIlegReposicion) {
        this.siiResolucionProcIlegReposicion = siiResolucionProcIlegReposicion;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "EPI_CODIGO")
    public SiiEstadoProcSanIleg getSiiEstadoProcSanIleg() {
        return siiEstadoProcSanIleg;
    }

    public void setSiiEstadoProcSanIleg(SiiEstadoProcSanIleg siiEstadoProcSanIleg) {
        this.siiEstadoProcSanIleg = siiEstadoProcSanIleg;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    public List<SiiDescargoProcIleg> getSiiDescargoProcIlegList() {
        return siiDescargoProcIlegList;
    }

    public void setSiiDescargoProcIlegList(List<SiiDescargoProcIleg> siiDescargoProcIlegList) {
        this.siiDescargoProcIlegList = siiDescargoProcIlegList;
    }

    public SiiDescargoProcIleg addSiiDescargoProcIleg(SiiDescargoProcIleg siiDescargoProcIleg) {
        getSiiDescargoProcIlegList().add(siiDescargoProcIleg);
        siiDescargoProcIleg.setSiiProcesoSancIlegalidad(this);
        return siiDescargoProcIleg;
    }

    public SiiDescargoProcIleg removeSiiDescargoProcIleg(SiiDescargoProcIleg siiDescargoProcIleg) {
        getSiiDescargoProcIlegList().remove(siiDescargoProcIleg);
        siiDescargoProcIleg.setSiiProcesoSancIlegalidad(null);
        return siiDescargoProcIleg;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad")
    public List<SiiInhabilidadPersona> getSiiInhabilidadPersonaList() {
        return siiInhabilidadPersonaList;
    }

    public void setSiiInhabilidadPersonaList(List<SiiInhabilidadPersona> siiInhabilidadPersonaList) {
        this.siiInhabilidadPersonaList = siiInhabilidadPersonaList;
    }

    public SiiInhabilidadPersona addSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().add(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiProcesoSancIlegalidad(this);
        return siiInhabilidadPersona;
    }

    public SiiInhabilidadPersona removeSiiInhabilidadPersona(SiiInhabilidadPersona siiInhabilidadPersona) {
        getSiiInhabilidadPersonaList().remove(siiInhabilidadPersona);
        siiInhabilidadPersona.setSiiProcesoSancIlegalidad(null);
        return siiInhabilidadPersona;
    }

    @ManyToOne
    @JoinColumn(name = "RPI_CODIGO_SIN_SANC")
    public SiiResolucionProcIleg getSiiResolucionProcIlegSinSancion() {
        return siiResolucionProcIlegSinSancion;
    }

    public void setSiiResolucionProcIlegSinSancion(SiiResolucionProcIleg siiResolucionProcIlegSinSancion) {
        this.siiResolucionProcIlegSinSancion = siiResolucionProcIlegSinSancion;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiProcesoSancIlegalidad(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiProcesoSancIlegalidad(null);
        return siiCuotaOperador;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiProcesoSancIlegalidad(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiProcesoSancIlegalidad(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiProcesoSancIlegalidad")
    public List<SiiElementoProcesoIle> getSiiElementoProcesoIleList() {
        return siiElementoProcesoIleList;
    }

    public void setSiiElementoProcesoIleList(List<SiiElementoProcesoIle> siiElementoProcesoIleList) {
        this.siiElementoProcesoIleList = siiElementoProcesoIleList;
    }

    public SiiElementoProcesoIle addSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().add(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiProcesoSancIlegalidad(this);
        return siiElementoProcesoIle;
    }

    public SiiElementoProcesoIle removeSiiElementoProcesoIle(SiiElementoProcesoIle siiElementoProcesoIle) {
        getSiiElementoProcesoIleList().remove(siiElementoProcesoIle);
        siiElementoProcesoIle.setSiiProcesoSancIlegalidad(null);
        return siiElementoProcesoIle;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRS_FECHA_CON_HECH")
    public Date getPrsFechaConHech() {
        return prsFechaConHech;
    }
    
    public void setPrsFechaConHech(Date prsFechaConHech) {
        this.prsFechaConHech = prsFechaConHech;
    }

    @Column(name = "PRS_NUMERO_AUTO", length = 30)
    public String getPrsNumeroAuto() {
        return prsNumeroAuto;
    }
    
    public void setPrsNumeroAuto(String prsNumeroAuto) {
        this.prsNumeroAuto = prsNumeroAuto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRS_FECHA_AUTO")
    public Date getPrsFechaAuto() {
        return prsFechaAuto;
    }
    
    public void setPrsFechaAuto(Date prsFechaAuto) {
        this.prsFechaAuto = prsFechaAuto;
    }
}
