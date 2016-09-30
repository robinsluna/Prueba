package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcIleg;

import java.util.Date;
import java.util.List;

public class ResolucionProcIlegVO {
    private Long rpiCodigo;
    private String rpiComunFiscalia;
    private Date rpiFechaGenera;
    private Date rpiFechaRadicSol;
    private Date rpiFechaResol;
    private String rpiNumeroRadicSol;
    private String rpiNumeroResol;
    private String rpiPresQueja;
    private String rpiTipoResol;
    private Date rpiFechaNotificacion;

    private UsuarioVO usuarioConecVo;

    private List<ComunicResolPersIleVO> comunicResolPersIleListVo;
    private List<TramiteResolProIleVO> tramiteResolProIleListVo;
    private List<ProcesoSancIlegalidadVO> procesoSancIlegalidadApelaListVo;
    private List<ProcesoSancIlegalidadVO> procesoSancIlegalidadResolListVo;
    private List<ProcesoSancIlegalidadVO> procesoSancIlegalidadReposicionListVo;
    
    public ResolucionProcIlegVO() {
        
    }
    
    public ResolucionProcIlegVO(SiiResolucionProcIleg siiResolucionProcIleg) {
        if (siiResolucionProcIleg!=null) {
            this.rpiCodigo = siiResolucionProcIleg.getRpiCodigo();
            this.rpiComunFiscalia = siiResolucionProcIleg.getRpiComunFiscalia();
            this.rpiFechaGenera = siiResolucionProcIleg.getRpiFechaGenera();
            this.rpiFechaRadicSol = siiResolucionProcIleg.getRpiFechaRadicSol();
            this.rpiFechaResol = siiResolucionProcIleg.getRpiFechaResol();
            this.rpiNumeroRadicSol = siiResolucionProcIleg.getRpiNumeroRadicSol();
            this.rpiNumeroResol = siiResolucionProcIleg.getRpiNumeroResol();
            this.rpiPresQueja = siiResolucionProcIleg.getRpiPresQueja();
            this.rpiTipoResol = siiResolucionProcIleg.getRpiTipoResol();
            this.rpiFechaNotificacion = siiResolucionProcIleg.getRpiFechaNotificacion();
            
            //Padres
            if (siiResolucionProcIleg.getSiiUsuarioConec() != null) {
                this.usuarioConecVo = new UsuarioVO(siiResolucionProcIleg.getSiiUsuarioConec());
            }
        }
    }

    public void setRpiCodigo(Long rpiCodigo) {
        this.rpiCodigo = rpiCodigo;
    }

    public Long getRpiCodigo() {
        return rpiCodigo;
    }

    public void setRpiComunFiscalia(String rpiComunFiscalia) {
        this.rpiComunFiscalia = rpiComunFiscalia;
    }

    public String getRpiComunFiscalia() {
        return rpiComunFiscalia;
    }

    public void setRpiFechaGenera(Date rpiFechaGenera) {
        this.rpiFechaGenera = rpiFechaGenera;
    }

    public Date getRpiFechaGenera() {
        return rpiFechaGenera;
    }

    public void setRpiFechaRadicSol(Date rpiFechaRadicSol) {
        this.rpiFechaRadicSol = rpiFechaRadicSol;
    }

    public Date getRpiFechaRadicSol() {
        return rpiFechaRadicSol;
    }

    public void setRpiFechaResol(Date rpiFechaResol) {
        this.rpiFechaResol = rpiFechaResol;
    }

    public Date getRpiFechaResol() {
        return rpiFechaResol;
    }

    public void setRpiNumeroRadicSol(String rpiNumeroRadicSol) {
        this.rpiNumeroRadicSol = rpiNumeroRadicSol;
    }

    public String getRpiNumeroRadicSol() {
        return rpiNumeroRadicSol;
    }

    public void setRpiNumeroResol(String rpiNumeroResol) {
        this.rpiNumeroResol = rpiNumeroResol;
    }

    public String getRpiNumeroResol() {
        return rpiNumeroResol;
    }

    public void setRpiPresQueja(String rpiPresQueja) {
        this.rpiPresQueja = rpiPresQueja;
    }

    public String getRpiPresQueja() {
        return rpiPresQueja;
    }

    public void setRpiTipoResol(String rpiTipoResol) {
        this.rpiTipoResol = rpiTipoResol;
    }

    public String getRpiTipoResol() {
        return rpiTipoResol;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setComunicResolPersIleListVo(List<ComunicResolPersIleVO> comunicResolPersIleListVo) {
        this.comunicResolPersIleListVo = comunicResolPersIleListVo;
    }

    public List<ComunicResolPersIleVO> getComunicResolPersIleListVo() {
        return comunicResolPersIleListVo;
    }

    public void setTramiteResolProIleListVo(List<TramiteResolProIleVO> tramiteResolProIleListVo) {
        this.tramiteResolProIleListVo = tramiteResolProIleListVo;
    }

    public List<TramiteResolProIleVO> getTramiteResolProIleListVo() {
        return tramiteResolProIleListVo;
    }

    public TramiteResolProIleVO getTramiteResolProIleVo() {
        return tramiteResolProIleListVo.get(0);
    }

    public void setProcesoSancIlegalidadApelaListVo(List<ProcesoSancIlegalidadVO> procesoSancIlegalidadApelaListVo) {
        this.procesoSancIlegalidadApelaListVo = procesoSancIlegalidadApelaListVo;
    }

    public List<ProcesoSancIlegalidadVO> getProcesoSancIlegalidadApelaListVo() {
        return procesoSancIlegalidadApelaListVo;
    }

    public void setProcesoSancIlegalidadResolListVo(List<ProcesoSancIlegalidadVO> procesoSancIlegalidadResolListVo) {
        this.procesoSancIlegalidadResolListVo = procesoSancIlegalidadResolListVo;
    }

    public List<ProcesoSancIlegalidadVO> getProcesoSancIlegalidadResolListVo() {
        return procesoSancIlegalidadResolListVo;
    }

    public void setProcesoSancIlegalidadReposicionListVo(List<ProcesoSancIlegalidadVO> procesoSancIlegalidadReposicionListVo) {
        this.procesoSancIlegalidadReposicionListVo = procesoSancIlegalidadReposicionListVo;
    }

    public List<ProcesoSancIlegalidadVO> getProcesoSancIlegalidadReposicionListVo() {
        return procesoSancIlegalidadReposicionListVo;
    }

    public void setRpiFechaNotificacion(Date rpiFechaNotificacion) {
        this.rpiFechaNotificacion = rpiFechaNotificacion;
    }

    public Date getRpiFechaNotificacion() {
        return rpiFechaNotificacion;
    }
}
