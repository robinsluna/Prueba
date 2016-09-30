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
@Table(name = "SII_RESOLUCION_PROC_ILEG")
public class SiiResolucionProcIleg implements Serializable {
    private static final long serialVersionUID = -8307707980493698579L;
    private Long rpiCodigo;
    private String rpiComunFiscalia;
    private Date rpiFechaGenera;
    private Date rpiFechaRadicSol;
    private Date rpiFechaResol;
    private String rpiNumeroRadicSol;
    private String rpiNumeroResol;
    private String rpiPresQueja;
    private String rpiTipoResol;
    private List<SiiComunicResolPersIle> siiComunicResolPersIleList;
    private List<SiiTramiteResolProIle> siiTramiteResolProIleList;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadApelaList;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadResolList;
    private SiiUsuario siiUsuarioConec;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadReposicionList;
    private List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadSinSancionList;
    private Date rpiFechaNotificacion;

    public SiiResolucionProcIleg() {
    }

    public SiiResolucionProcIleg(Long rpiCodigo, String rpiComunFiscalia, Date rpiFechaGenera, Date rpiFechaRadicSol, Date rpiFechaResol, String rpiNumeroRadicSol, String rpiNumeroResol,
                                 String rpiPresQueja, String rpiTipoResol, SiiUsuario siiUsuarioConec) {
        this.rpiCodigo = rpiCodigo;
        this.rpiComunFiscalia = rpiComunFiscalia;
        this.rpiFechaGenera = rpiFechaGenera;
        this.rpiFechaRadicSol = rpiFechaRadicSol;
        this.rpiFechaResol = rpiFechaResol;
        this.rpiNumeroRadicSol = rpiNumeroRadicSol;
        this.rpiNumeroResol = rpiNumeroResol;
        this.rpiPresQueja = rpiPresQueja;
        this.rpiTipoResol = rpiTipoResol;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "RPI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOL_PROC_ILEG_COD")
    @SequenceGenerator(name = "SEQ_RESOL_PROC_ILEG_COD", sequenceName = "SEQ_RESOL_PROC_ILEG_COD",allocationSize=1)
    public Long getRpiCodigo() {
        return rpiCodigo;
    }

    public void setRpiCodigo(Long rpiCodigo) {
        this.rpiCodigo = rpiCodigo;
    }

    @Column(name = "RPI_COMUN_FISCALIA", nullable = false, length = 1)
    public String getRpiComunFiscalia() {
        return rpiComunFiscalia;
    }

    public void setRpiComunFiscalia(String rpiComunFiscalia) {
        this.rpiComunFiscalia = rpiComunFiscalia;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPI_FECHA_GENERA", nullable = false)
    public Date getRpiFechaGenera() {
        return rpiFechaGenera;
    }

    public void setRpiFechaGenera(Date rpiFechaGenera) {
        this.rpiFechaGenera = rpiFechaGenera;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPI_FECHA_RADIC_SOL")
    public Date getRpiFechaRadicSol() {
        return rpiFechaRadicSol;
    }

    public void setRpiFechaRadicSol(Date rpiFechaRadicSol) {
        this.rpiFechaRadicSol = rpiFechaRadicSol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPI_FECHA_RESOL")
    public Date getRpiFechaResol() {
        return rpiFechaResol;
    }

    public void setRpiFechaResol(Date rpiFechaResol) {
        this.rpiFechaResol = rpiFechaResol;
    }

    @Column(name = "RPI_NUMERO_RADIC_SOL", length = 30)
    public String getRpiNumeroRadicSol() {
        return rpiNumeroRadicSol;
    }

    public void setRpiNumeroRadicSol(String rpiNumeroRadicSol) {
        this.rpiNumeroRadicSol = rpiNumeroRadicSol;
    }

    @Column(name = "RPI_NUMERO_RESOL", length = 30)
    public String getRpiNumeroResol() {
        return rpiNumeroResol;
    }

    public void setRpiNumeroResol(String rpiNumeroResol) {
        this.rpiNumeroResol = rpiNumeroResol;
    }

    @Column(name = "RPI_PRES_QUEJA", nullable = false, length = 1)
    public String getRpiPresQueja() {
        return rpiPresQueja;
    }

    public void setRpiPresQueja(String rpiPresQueja) {
        this.rpiPresQueja = rpiPresQueja;
    }

    @Column(name = "RPI_TIPO_RESOL", length = 1)
    public String getRpiTipoResol() {
        return rpiTipoResol;
    }

    public void setRpiTipoResol(String rpiTipoResol) {
        this.rpiTipoResol = rpiTipoResol;
    }


    @OneToMany(mappedBy = "siiResolucionProcIleg")
    public List<SiiComunicResolPersIle> getSiiComunicResolPersIleList() {
        return siiComunicResolPersIleList;
    }

    public void setSiiComunicResolPersIleList(List<SiiComunicResolPersIle> siiComunicResolPersIleList) {
        this.siiComunicResolPersIleList = siiComunicResolPersIleList;
    }

    public SiiComunicResolPersIle addSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleList().add(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiResolucionProcIleg(this);
        return siiComunicResolPersIle;
    }

    public SiiComunicResolPersIle removeSiiComunicResolPersIle(SiiComunicResolPersIle siiComunicResolPersIle) {
        getSiiComunicResolPersIleList().remove(siiComunicResolPersIle);
        siiComunicResolPersIle.setSiiResolucionProcIleg(null);
        return siiComunicResolPersIle;
    }

    @OneToMany(mappedBy = "siiResolucionProcIleg")
    public List<SiiTramiteResolProIle> getSiiTramiteResolProIleList() {
        return siiTramiteResolProIleList;
    }

    public void setSiiTramiteResolProIleList(List<SiiTramiteResolProIle> siiTramiteResolProIleList) {
        this.siiTramiteResolProIleList = siiTramiteResolProIleList;
    }

    public SiiTramiteResolProIle addSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleList().add(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiResolucionProcIleg(this);
        return siiTramiteResolProIle;
    }

    public SiiTramiteResolProIle removeSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleList().remove(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiResolucionProcIleg(null);
        return siiTramiteResolProIle;
    }

    @OneToMany(mappedBy = "siiResolucionProcIlegApela")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadApelaList() {
        return siiProcesoSancIlegalidadApelaList;
    }

    public void setSiiProcesoSancIlegalidadApelaList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadApelaList) {
        this.siiProcesoSancIlegalidadApelaList = siiProcesoSancIlegalidadApelaList;
    }

    public SiiProcesoSancIlegalidad addSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadApelaList().add(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiResolucionProcIlegApela(this);
        return siiProcesoSancIlegalidad;
    }

    public SiiProcesoSancIlegalidad removeSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        getSiiProcesoSancIlegalidadApelaList().remove(siiProcesoSancIlegalidad);
        siiProcesoSancIlegalidad.setSiiResolucionProcIlegApela(null);
        return siiProcesoSancIlegalidad;
    }

    @OneToMany(mappedBy = "siiResolucionProcIlegResol")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadResolList() {
        return siiProcesoSancIlegalidadResolList;
    }

    public void setSiiProcesoSancIlegalidadResolList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadResolList) {
        this.siiProcesoSancIlegalidadResolList = siiProcesoSancIlegalidadResolList;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiResolucionProcIlegReposicion")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadReposicionList() {
        return siiProcesoSancIlegalidadReposicionList;
    }

    public void setSiiProcesoSancIlegalidadReposicionList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadReposicionList) {
        this.siiProcesoSancIlegalidadReposicionList = siiProcesoSancIlegalidadReposicionList;
    }

    @OneToMany(mappedBy = "siiResolucionProcIlegSinSancion")
    public List<SiiProcesoSancIlegalidad> getSiiProcesoSancIlegalidadSinSancionList() {
        return siiProcesoSancIlegalidadSinSancionList;
    }

    public void setSiiProcesoSancIlegalidadSinSancionList(List<SiiProcesoSancIlegalidad> siiProcesoSancIlegalidadSinSancionList) {
        this.siiProcesoSancIlegalidadSinSancionList = siiProcesoSancIlegalidadSinSancionList;
    }

    public SiiProcesoSancIlegalidad addSiiProcesoSancIlegalidadSinSancion(SiiProcesoSancIlegalidad siiProcesoSancIlegalidadSinSancion) {
        getSiiProcesoSancIlegalidadSinSancionList().add(siiProcesoSancIlegalidadSinSancion);
        siiProcesoSancIlegalidadSinSancion.setSiiResolucionProcIlegSinSancion(this);
        return siiProcesoSancIlegalidadSinSancion;
    }

    public SiiProcesoSancIlegalidad removeSiiProcesoSancIlegalidadSinSancion(SiiProcesoSancIlegalidad siiProcesoSancIlegalidadSinSancion) {
        getSiiProcesoSancIlegalidadSinSancionList().remove(siiProcesoSancIlegalidadSinSancion);
        siiProcesoSancIlegalidadSinSancion.setSiiResolucionProcIlegSinSancion(null);
        return siiProcesoSancIlegalidadSinSancion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPI_FECHA_NOTIFICACION")
    public Date getRpiFechaNotificacion() {
        return rpiFechaNotificacion;
    }
    
    public void setRpiFechaNotificacion(Date rpiFechaNotificacion) {
        this.rpiFechaNotificacion = rpiFechaNotificacion;
    }
}
