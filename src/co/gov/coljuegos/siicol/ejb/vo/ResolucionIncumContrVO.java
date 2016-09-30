package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionIncumContr;

import java.util.Date;
import java.util.List;


/**
 * Value Object para el manejo de la Resoluci&oacute;n de Incumplimiento Contractual.
 * @author Camilo Miranda
 */
public class ResolucionIncumContrVO 
{
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
    private String rcoSinSancion;
    
    private ArchivoFisicoVO archivoFisicoVo;
    
    private List<IncumplimientoContrVO> incumplimientoContrResolList; 
    private List<IncumplimientoContrVO> incumplimientoContrRecursoList;
    private List<TramiteResolSanConVO> tramiteResolSanConList;
    
    
    /**
     * Constructor.
     */
    public ResolucionIncumContrVO () { }
    
    
    
    /**
     * Constructor.
     * @param siiResolucionIncumContr
     */
    public ResolucionIncumContrVO (SiiResolucionIncumContr siiResolucionIncumContr) 
    {
        if (siiResolucionIncumContr!=null) {
            this.rcoCodigo = siiResolucionIncumContr.getRcoCodigo();
            this.rcoFechaFinInhab = siiResolucionIncumContr.getRcoFechaFinInhab();
            this.rcoFechaIniInhab = siiResolucionIncumContr.getRcoFechaIniInhab();
            this.rcoFechaNotific = siiResolucionIncumContr.getRcoFechaNotific();
            this.rcoFechaResol = siiResolucionIncumContr.getRcoFechaResol();
            this.rcoFechaResolFirme = siiResolucionIncumContr.getRcoFechaResolFirme();
            this.rcoFechaSupInc = siiResolucionIncumContr.getRcoFechaSupInc();
            this.rcoNumeroResol = siiResolucionIncumContr.getRcoNumeroResol();
            this.rcoOrigenRecurso = siiResolucionIncumContr.getRcoOrigenRecurso();
            this.rcoReponeRecurso = siiResolucionIncumContr.getRcoReponeRecurso();
            this.rcoTipoDecision = siiResolucionIncumContr.getRcoTipoDecision();
            this.rcoTipoResol = siiResolucionIncumContr.getRcoTipoResol();
            this.rcoSinSancion = siiResolucionIncumContr.getRcoSinSancion();
            
            if (siiResolucionIncumContr.getSiiArchivoFisico()!=null)
                this.archivoFisicoVo = new ArchivoFisicoVO(siiResolucionIncumContr.getSiiArchivoFisico());
        }
    }

    
    
    public void setRcoCodigo(Long rcoCodigo) {
        this.rcoCodigo = rcoCodigo;
    }

    public Long getRcoCodigo() {
        return rcoCodigo;
    }

    public void setRcoFechaFinInhab(String rcoFechaFinInhab) {
        this.rcoFechaFinInhab = rcoFechaFinInhab;
    }

    public String getRcoFechaFinInhab() {
        return rcoFechaFinInhab;
    }

    public void setRcoFechaIniInhab(Date rcoFechaIniInhab) {
        this.rcoFechaIniInhab = rcoFechaIniInhab;
    }

    public Date getRcoFechaIniInhab() {
        return rcoFechaIniInhab;
    }

    public void setRcoFechaNotific(Date rcoFechaNotific) {
        this.rcoFechaNotific = rcoFechaNotific;
    }

    public Date getRcoFechaNotific() {
        return rcoFechaNotific;
    }

    public void setRcoFechaResol(Date rcoFechaResol) {
        this.rcoFechaResol = rcoFechaResol;
    }

    public Date getRcoFechaResol() {
        return rcoFechaResol;
    }

    public void setRcoFechaResolFirme(Date rcoFechaResolFirme) {
        this.rcoFechaResolFirme = rcoFechaResolFirme;
    }

    public Date getRcoFechaResolFirme() {
        return rcoFechaResolFirme;
    }

    public void setRcoFechaSupInc(Date rcoFechaSupInc) {
        this.rcoFechaSupInc = rcoFechaSupInc;
    }

    public Date getRcoFechaSupInc() {
        return rcoFechaSupInc;
    }

    public void setRcoNumeroResol(String rcoNumeroResol) {
        this.rcoNumeroResol = rcoNumeroResol;
    }

    public String getRcoNumeroResol() {
        return rcoNumeroResol;
    }

    public void setRcoOrigenRecurso(String rcoOrigenRecurso) {
        this.rcoOrigenRecurso = rcoOrigenRecurso;
    }

    public String getRcoOrigenRecurso() {
        return rcoOrigenRecurso;
    }

    public void setRcoReponeRecurso(String rcoReponeRecurso) {
        this.rcoReponeRecurso = rcoReponeRecurso;
    }

    public String getRcoReponeRecurso() {
        return rcoReponeRecurso;
    }

    public void setRcoTipoDecision(String rcoTipoDecision) {
        this.rcoTipoDecision = rcoTipoDecision;
    }

    public String getRcoTipoDecision() {
        return rcoTipoDecision;
    }

    public void setRcoTipoResol(String rcoTipoResol) {
        this.rcoTipoResol = rcoTipoResol;
    }

    public String getRcoTipoResol() {
        return rcoTipoResol;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public void setIncumplimientoContrResolList(List<IncumplimientoContrVO> incumplimientoContrResolList) {
        this.incumplimientoContrResolList = incumplimientoContrResolList;
    }

    public List<IncumplimientoContrVO> getIncumplimientoContrResolList() {
        return incumplimientoContrResolList;
    }

    public void setIncumplimientoContrRecursoList(List<IncumplimientoContrVO> incumplimientoContrRecursoList) {
        this.incumplimientoContrRecursoList = incumplimientoContrRecursoList;
    }

    public List<IncumplimientoContrVO> getIncumplimientoContrRecursoList() {
        return incumplimientoContrRecursoList;
    }

    public void setTramiteResolSanConList(List<TramiteResolSanConVO> tramiteResolSanConList) {
        this.tramiteResolSanConList = tramiteResolSanConList;
    }

    public List<TramiteResolSanConVO> getTramiteResolSanConList() {
        return tramiteResolSanConList;
    }

    public void setRcoSinSancion(String rcoSinSancion) {
        this.rcoSinSancion = rcoSinSancion;
    }

    public String getRcoSinSancion() {
        return rcoSinSancion;
    }
}
