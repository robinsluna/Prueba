package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;

import java.util.Date;

public class HistEstadoFiscalizVO {
    
    private Long hefCodigo;
    private String hefEstado;
    private Date hefFechaAct;
    private Date hefFechaInact;
    private String hefGrupoAsignVisit;
    private UsuarioVO usuarioConectVo;
    private FiscalizadorSustancVO fiscalizadorSustancVo;

    public HistEstadoFiscalizVO() {

    }

    public HistEstadoFiscalizVO(SiiHistEstadoFiscaliz siiHistEstadoFiscaliz) {
        this.hefCodigo = siiHistEstadoFiscaliz.getHefCodigo();
        this.hefEstado = siiHistEstadoFiscaliz.getHefEstado();
        this.hefFechaAct = siiHistEstadoFiscaliz.getHefFechaAct();
        this.hefFechaInact = siiHistEstadoFiscaliz.getHefFechaInact();
        this.hefGrupoAsignVisit = siiHistEstadoFiscaliz.getHefGrupoAsignVisit();
        // Padres
        if (siiHistEstadoFiscaliz.getSiiFiscalizadorSustanc() != null) {
            this.fiscalizadorSustancVo = new FiscalizadorSustancVO(siiHistEstadoFiscaliz.getSiiFiscalizadorSustanc());
        }
        if (siiHistEstadoFiscaliz.getSiiUsuarioConect() != null) {
            this.usuarioConectVo = new UsuarioVO(siiHistEstadoFiscaliz.getSiiUsuarioConect());
        }
    }

    public void setHefCodigo(Long hefCodigo) {
        this.hefCodigo = hefCodigo;
    }

    public Long getHefCodigo() {
        return hefCodigo;
    }

    public void setHefEstado(String hefEstado) {
        this.hefEstado = hefEstado;
    }

    public String getHefEstado() {
        return hefEstado;
    }

    public void setHefFechaAct(Date hefFechaAct) {
        this.hefFechaAct = hefFechaAct;
    }

    public Date getHefFechaAct() {
        return hefFechaAct;
    }

    public void setHefFechaInact(Date hefFechaInact) {
        this.hefFechaInact = hefFechaInact;
    }

    public Date getHefFechaInact() {
        return hefFechaInact;
    }

    public void setFiscalizadorSustancVo(FiscalizadorSustancVO fiscalizadorSustancVo) {
        this.fiscalizadorSustancVo = fiscalizadorSustancVo;
    }

    public FiscalizadorSustancVO getFiscalizadorSustancVo() {
        return fiscalizadorSustancVo;
    }

    public void setHefGrupoAsignVisit(String hefGrupoAsignVisit) {
        this.hefGrupoAsignVisit = hefGrupoAsignVisit;
    }

    public String getHefGrupoAsignVisit() {
        return hefGrupoAsignVisit;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }
}
