package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;

import java.util.Date;

public class HistEstadoSustanVO {
    private Long hesCodigo;
    private String hesEstado;
    private Date hesFechaAct;
    private Date hesFechaInact;
    private String hesGrupoAsignVisit;
    private SustanciadorAuditorVO sustanciadorAuditorVo;
    private UsuarioVO usuarioConectVo;
    
    public HistEstadoSustanVO() {
        
    }
    
    public HistEstadoSustanVO(SiiHistEstadoSustan siiHistEstadoSustan) {
        this.hesCodigo = siiHistEstadoSustan.getHesCodigo();
        this.hesEstado = siiHistEstadoSustan.getHesEstado();
        this.hesFechaAct = siiHistEstadoSustan.getHesFechaAct();
        this.hesFechaInact = siiHistEstadoSustan.getHesFechaInact();
        this.hesGrupoAsignVisit = siiHistEstadoSustan.getHesGrupoAsignVisit();
        //Padres:
        if (siiHistEstadoSustan.getSiiSustanciadorAuditor() != null) {
            this.sustanciadorAuditorVo = new SustanciadorAuditorVO(siiHistEstadoSustan.getSiiSustanciadorAuditor());
        }
        if (siiHistEstadoSustan.getSiiUsuarioConect() != null) {
            this.usuarioConectVo = new UsuarioVO(siiHistEstadoSustan.getSiiUsuarioConect());
        }
        
    }

    public void setHesCodigo(Long hesCodigo) {
        this.hesCodigo = hesCodigo;
    }

    public Long getHesCodigo() {
        return hesCodigo;
    }

    public void setHesEstado(String hesEstado) {
        this.hesEstado = hesEstado;
    }

    public String getHesEstado() {
        return hesEstado;
    }

    public void setHesFechaAct(Date hesFechaAct) {
        this.hesFechaAct = hesFechaAct;
    }

    public Date getHesFechaAct() {
        return hesFechaAct;
    }

    public void setHesFechaInact(Date hesFechaInact) {
        this.hesFechaInact = hesFechaInact;
    }

    public Date getHesFechaInact() {
        return hesFechaInact;
    }

    public void setHesGrupoAsignVisit(String hesGrupoAsignVisit) {
        this.hesGrupoAsignVisit = hesGrupoAsignVisit;
    }

    public String getHesGrupoAsignVisit() {
        return hesGrupoAsignVisit;
    }

    public void setSustanciadorAuditorVo(SustanciadorAuditorVO sustanciadorAuditorVo) {
        this.sustanciadorAuditorVo = sustanciadorAuditorVo;
    }

    public SustanciadorAuditorVO getSustanciadorAuditorVo() {
        return sustanciadorAuditorVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }
}
