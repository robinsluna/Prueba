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
@Table(name = "SII_RESOLUCION_INCUM_CONTR")
public class SiiResolucionIncumContr implements Serializable {
    private static final long serialVersionUID = -3045108194852238344L;
    private Long rcoCodigo;
    private String rcoFechaFinInhab;
    private Date rcoFechaIniInhab;
    private Date rcoFechaNotific;
    private Date rcoFechaResol;
    private Date rcoFechaResolFirme;
    private Date rcoFechaSupInc;
    private String rcoNumeroResol;
    private String rcoOrigenRecurso;
    private String rcoReponeRecurso;
    private String rcoTipoDecision;
    private String rcoTipoResol;
    private List<SiiTramiteResolSanCon> siiTramiteResolSanConList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrResolList;
    private List<SiiIncumplimientoContr> siiIncumplimientoContrRecursoList;
    private SiiArchivoFisico siiArchivoFisico;
    private String rcoSinSancion;

    public SiiResolucionIncumContr() {
    }

    public SiiResolucionIncumContr(SiiArchivoFisico siiArchivoFisico, Long rcoCodigo, String rcoFechaFinInhab,
                                   Date rcoFechaIniInhab, Date rcoFechaNotific, Date rcoFechaResol,
                                   Date rcoFechaResolFirme, Date rcoFechaSupInc, String rcoNumeroResol,
                                   String rcoOrigenRecurso, String rcoReponeRecurso, String rcoTipoDecision,
                                   String rcoTipoResol) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.rcoCodigo = rcoCodigo;
        this.rcoFechaFinInhab = rcoFechaFinInhab;
        this.rcoFechaIniInhab = rcoFechaIniInhab;
        this.rcoFechaNotific = rcoFechaNotific;
        this.rcoFechaResol = rcoFechaResol;
        this.rcoFechaResolFirme = rcoFechaResolFirme;
        this.rcoFechaSupInc = rcoFechaSupInc;
        this.rcoNumeroResol = rcoNumeroResol;
        this.rcoOrigenRecurso = rcoOrigenRecurso;
        this.rcoReponeRecurso = rcoReponeRecurso;
        this.rcoTipoDecision = rcoTipoDecision;
        this.rcoTipoResol = rcoTipoResol;
    }


    @Id
    @Column(name = "RCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RESOL_INCUM_CONTR_COD")
    @SequenceGenerator(name = "SEQ_RESOL_INCUM_CONTR_COD", sequenceName = "SEQ_RESOL_INCUM_CONTR_COD",allocationSize=1)
    public Long getRcoCodigo() {
        return rcoCodigo;
    }

    public void setRcoCodigo(Long rcoCodigo) {
        this.rcoCodigo = rcoCodigo;
    }

    @Column(name = "RCO_FECHA_FIN_INHAB", length = 20)
    public String getRcoFechaFinInhab() {
        return rcoFechaFinInhab;
    }

    public void setRcoFechaFinInhab(String rcoFechaFinInhab) {
        this.rcoFechaFinInhab = rcoFechaFinInhab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RCO_FECHA_INI_INHAB")
    public Date getRcoFechaIniInhab() {
        return rcoFechaIniInhab;
    }

    public void setRcoFechaIniInhab(Date rcoFechaIniInhab) {
        this.rcoFechaIniInhab = rcoFechaIniInhab;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RCO_FECHA_NOTIFIC")
    public Date getRcoFechaNotific() {
        return rcoFechaNotific;
    }

    public void setRcoFechaNotific(Date rcoFechaNotific) {
        this.rcoFechaNotific = rcoFechaNotific;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RCO_FECHA_RESOL")
    public Date getRcoFechaResol() {
        return rcoFechaResol;
    }

    public void setRcoFechaResol(Date rcoFechaResol) {
        this.rcoFechaResol = rcoFechaResol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RCO_FECHA_RESOL_FIRME")
    public Date getRcoFechaResolFirme() {
        return rcoFechaResolFirme;
    }

    public void setRcoFechaResolFirme(Date rcoFechaResolFirme) {
        this.rcoFechaResolFirme = rcoFechaResolFirme;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RCO_FECHA_SUP_INC")
    public Date getRcoFechaSupInc() {
        return rcoFechaSupInc;
    }

    public void setRcoFechaSupInc(Date rcoFechaSupInc) {
        this.rcoFechaSupInc = rcoFechaSupInc;
    }

    @Column(name = "RCO_NUMERO_RESOL", length = 30)
    public String getRcoNumeroResol() {
        return rcoNumeroResol;
    }

    public void setRcoNumeroResol(String rcoNumeroResol) {
        this.rcoNumeroResol = rcoNumeroResol;
    }

    @Column(name = "RCO_ORIGEN_RECURSO", length = 1)
    public String getRcoOrigenRecurso() {
        return rcoOrigenRecurso;
    }

    public void setRcoOrigenRecurso(String rcoOrigenRecurso) {
        this.rcoOrigenRecurso = rcoOrigenRecurso;
    }

    @Column(name = "RCO_REPONE_RECURSO", length = 1)
    public String getRcoReponeRecurso() {
        return rcoReponeRecurso;
    }

    public void setRcoReponeRecurso(String rcoReponeRecurso) {
        this.rcoReponeRecurso = rcoReponeRecurso;
    }

    @Column(name = "RCO_TIPO_DECISION", length = 1)
    public String getRcoTipoDecision() {
        return rcoTipoDecision;
    }

    public void setRcoTipoDecision(String rcoTipoDecision) {
        this.rcoTipoDecision = rcoTipoDecision;
    }

    @Column(name = "RCO_TIPO_RESOL", length = 1)
    public String getRcoTipoResol() {
        return rcoTipoResol;
    }

    public void setRcoTipoResol(String rcoTipoResol) {
        this.rcoTipoResol = rcoTipoResol;
    }

    @OneToMany(mappedBy = "siiResolucionIncumContr")
    public List<SiiTramiteResolSanCon> getSiiTramiteResolSanConList() {
        return siiTramiteResolSanConList;
    }

    public void setSiiTramiteResolSanConList(List<SiiTramiteResolSanCon> siiTramiteResolSanConList) {
        this.siiTramiteResolSanConList = siiTramiteResolSanConList;
    }

    public SiiTramiteResolSanCon addSiiTramiteResolSanCon(SiiTramiteResolSanCon siiTramiteResolSanCon) {
        getSiiTramiteResolSanConList().add(siiTramiteResolSanCon);
        siiTramiteResolSanCon.setSiiResolucionIncumContr(this);
        return siiTramiteResolSanCon;
    }

    public SiiTramiteResolSanCon removeSiiTramiteResolSanCon(SiiTramiteResolSanCon siiTramiteResolSanCon) {
        getSiiTramiteResolSanConList().remove(siiTramiteResolSanCon);
        siiTramiteResolSanCon.setSiiResolucionIncumContr(null);
        return siiTramiteResolSanCon;
    }

    @OneToMany(mappedBy = "siiResolucionIncumContrResol")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrResolList() {
        return siiIncumplimientoContrResolList;
    }

    public void setSiiIncumplimientoContrResolList(List<SiiIncumplimientoContr> siiIncumplimientoContrResolList) {
        this.siiIncumplimientoContrResolList = siiIncumplimientoContrResolList;
    }

    public SiiIncumplimientoContr addSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrResolList().add(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiResolucionIncumContrResol(this);
        return siiIncumplimientoContr;
    }

    public SiiIncumplimientoContr removeSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        getSiiIncumplimientoContrResolList().remove(siiIncumplimientoContr);
        siiIncumplimientoContr.setSiiResolucionIncumContrResol(null);
        return siiIncumplimientoContr;
    }

    @OneToMany(mappedBy = "siiResolucionIncumContrRecurso")
    public List<SiiIncumplimientoContr> getSiiIncumplimientoContrRecursoList() {
        return siiIncumplimientoContrRecursoList;
    }

    public void setSiiIncumplimientoContrRecursoList(List<SiiIncumplimientoContr> siiIncumplimientoContrRecursoList) {
        this.siiIncumplimientoContrRecursoList = siiIncumplimientoContrRecursoList;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Column(name = "RCO_SIN_SANCION", length = 1)
    public String getRcoSinSancion() {
        return rcoSinSancion;
    }
    
    public void setRcoSinSancion(String rcoSinSancion) {
        this.rcoSinSancion = rcoSinSancion;
    }

}
