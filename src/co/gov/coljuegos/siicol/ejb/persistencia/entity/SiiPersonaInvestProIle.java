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
@Table(name = "SII_PERSONA_INVEST_PRO_ILE")
public class SiiPersonaInvestProIle implements Serializable {
    private static final long serialVersionUID = -5495711404099741838L;
    private String pipActivo;
    private Long pipCodigo;
    private Date pipComIniFechaRad;
    private String pipComIniRadicado;
    private Date pipResEnvFecha;
    private String pipResEnvIndResp;
    private String pipResEnvNumGuia;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;
    private List<SiiDireccionProcePerIle> siiDireccionProcePerIleList;
    private SiiUsuario siiUsuarioConec;
    private List<SiiComunicResolPersIle> siiComunicResolPersIleList;
    private List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoList;
    private SiiPersona siiPersona;
    private String pipCreada;
    private List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruList;
    private String pipSancionada;
    private String pipInvestigada;
    private String pipAutorEnvEmail;

    public SiiPersonaInvestProIle() {
    }

    public SiiPersonaInvestProIle(SiiPersona siiPersona, String pipActivo, Long pipCodigo, Date pipComIniFechaRad, String pipComIniRadicado, Date pipResEnvFecha, String pipResEnvIndResp,
                                  String pipResEnvNumGuia, SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiUsuario siiUsuarioConec) {
        this.siiPersona = siiPersona;
        this.pipActivo = pipActivo;
        this.pipCodigo = pipCodigo;
        this.pipComIniFechaRad = pipComIniFechaRad;
        this.pipComIniRadicado = pipComIniRadicado;
        this.pipResEnvFecha = pipResEnvFecha;
        this.pipResEnvIndResp = pipResEnvIndResp;
        this.pipResEnvNumGuia = pipResEnvNumGuia;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Column(name = "PIP_ACTIVO", nullable = false, length = 1)
    public String getPipActivo() {
        return pipActivo;
    }

    public void setPipActivo(String pipActivo) {
        this.pipActivo = pipActivo;
    }

    @Id
    @Column(name = "PIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERS_INVEST_PRO_ILE_COD")
    @SequenceGenerator(name = "SEQ_PERS_INVEST_PRO_ILE_COD", sequenceName = "SEQ_PERS_INVEST_PRO_ILE_COD",allocationSize=1)
    public Long getPipCodigo() {
        return pipCodigo;
    }

    public void setPipCodigo(Long pipCodigo) {
        this.pipCodigo = pipCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIP_COM_INI_FECHA_RAD")
    public Date getPipComIniFechaRad() {
        return pipComIniFechaRad;
    }

    public void setPipComIniFechaRad(Date pipComIniFechaRad) {
        this.pipComIniFechaRad = pipComIniFechaRad;
    }

    @Column(name = "PIP_COM_INI_RADICADO", length = 30)
    public String getPipComIniRadicado() {
        return pipComIniRadicado;
    }

    public void setPipComIniRadicado(String pipComIniRadicado) {
        this.pipComIniRadicado = pipComIniRadicado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PIP_RES_ENV_FECHA")
    public Date getPipResEnvFecha() {
        return pipResEnvFecha;
    }

    public void setPipResEnvFecha(Date pipResEnvFecha) {
        this.pipResEnvFecha = pipResEnvFecha;
    }

    @Column(name = "PIP_RES_ENV_IND_RESP", length = 1)
    public String getPipResEnvIndResp() {
        return pipResEnvIndResp;
    }

    public void setPipResEnvIndResp(String pipResEnvIndResp) {
        this.pipResEnvIndResp = pipResEnvIndResp;
    }

    @Column(name = "PIP_RES_ENV_NUM_GUIA", length = 30)
    public String getPipResEnvNumGuia() {
        return pipResEnvNumGuia;
    }

    public void setPipResEnvNumGuia(String pipResEnvNumGuia) {
        this.pipResEnvNumGuia = pipResEnvNumGuia;
    }


    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiPersonaInvestProIle")
    public List<SiiDireccionProcePerIle> getSiiDireccionProcePerIleList() {
        return siiDireccionProcePerIleList;
    }

    public void setSiiDireccionProcePerIleList(List<SiiDireccionProcePerIle> siiDireccionProcePerIleList) {
        this.siiDireccionProcePerIleList = siiDireccionProcePerIleList;
    }

    public SiiDireccionProcePerIle addSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().add(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiPersonaInvestProIle(this);
        return siiDireccionProcePerIle;
    }

    public SiiDireccionProcePerIle removeSiiDireccionProcePerIle(SiiDireccionProcePerIle siiDireccionProcePerIle) {
        getSiiDireccionProcePerIleList().remove(siiDireccionProcePerIle);
        siiDireccionProcePerIle.setSiiPersonaInvestProIle(null);
        return siiDireccionProcePerIle;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiPersonaInvestProIle")
    public List<SiiComunicResolPersIle> getSiiComunicResolPersIleList() {
        return siiComunicResolPersIleList;
    }

    public void setSiiComunicResolPersIleList(List<SiiComunicResolPersIle> siiComunicResolPersIleList) {
        this.siiComunicResolPersIleList = siiComunicResolPersIleList;
    }

    public SiiComunicResolPersIle addSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleList().add(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiPersonaInvestProIle(this);
        return siiComunicResolPersIle;
    }

    public SiiComunicResolPersIle removeSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleList().remove(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiPersonaInvestProIle(null);
        return siiComunicResolPersIle;
    }

    @OneToMany(mappedBy = "siiPersonaInvestProIle")
    public List<SiiPersonaInvProIleAuto> getSiiPersonaInvProIleAutoList() {
        return siiPersonaInvProIleAutoList;
    }

    public void setSiiPersonaInvProIleAutoList(List<SiiPersonaInvProIleAuto> siiPersonaInvProIleAutoList) {
        this.siiPersonaInvProIleAutoList = siiPersonaInvProIleAutoList;
    }

    public SiiPersonaInvProIleAuto addSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoList().add(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiPersonaInvestProIle(this);
        return siiPersonaInvProIleAuto;
    }

    public SiiPersonaInvProIleAuto removeSiiPersonaInvProIleAuto(SiiPersonaInvProIleAuto siiPersonaInvProIleAuto) {
        getSiiPersonaInvProIleAutoList().remove(siiPersonaInvProIleAuto);
        siiPersonaInvProIleAuto.setSiiPersonaInvestProIle(null);
        return siiPersonaInvProIleAuto;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @Column(name = "PIP_CREADA", length = 1)
    public String getPipCreada() {
        return pipCreada;
    }
    
    public void setPipCreada(String pipCreada) {
        this.pipCreada = pipCreada;
    }

    @OneToMany(mappedBy = "siiPersonaInvestProIle")
    public List<SiiPerInvesProIleAutoPru> getSiiPerInvesProIleAutoPruList() {
        return siiPerInvesProIleAutoPruList;
    }

    public void setSiiPerInvesProIleAutoPruList(List<SiiPerInvesProIleAutoPru> siiPerInvesProIleAutoPruList) {
        this.siiPerInvesProIleAutoPruList = siiPerInvesProIleAutoPruList;
    }

    public SiiPerInvesProIleAutoPru addSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruList().add(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiPersonaInvestProIle(this);
        return siiPerInvesProIleAutoPru;
    }

    public SiiPerInvesProIleAutoPru removeSiiPerInvesProIleAutoPru(SiiPerInvesProIleAutoPru siiPerInvesProIleAutoPru) {
        getSiiPerInvesProIleAutoPruList().remove(siiPerInvesProIleAutoPru);
        siiPerInvesProIleAutoPru.setSiiPersonaInvestProIle(null);
        return siiPerInvesProIleAutoPru;
    }

    @Column(name = "PIP_SANCIONADA", length = 1)
    public String getPipSancionada() {
        return pipSancionada;
    }
    
    public void setPipSancionada(String pipSancionada) {
        this.pipSancionada = pipSancionada;
    }

    @Column(name = "PIP_INVESTIGADA", length = 1)
    public String getPipInvestigada() {
        return pipInvestigada;
    }
    
    public void setPipInvestigada(String pipInvestigada) {
        this.pipInvestigada = pipInvestigada;
    }

    @Column(name = "PIP_AUTOR_ENV_EMAIL", length = 1)
    public String getPipAutorEnvEmail() {
        return pipAutorEnvEmail;
    }
    
    public void setPipAutorEnvEmail(String pipAutorEnvEmail) {
        this.pipAutorEnvEmail = pipAutorEnvEmail;
    }    
}
