package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiComunicacSujSancIle;

import java.util.Date;

public class ComunicacSujSancIleVO {
    private String cssActivo;
    private Long cssCodigo;
    private Date cssFechaRad;
    private String cssRadicado;
    private ProcesoSancIlegalidadVO procesoSancIlegalidadVo;
    private UsuarioVO usuarioConecVo;

    public ComunicacSujSancIleVO() {
        
    }
    
    public ComunicacSujSancIleVO(SiiComunicacSujSancIle comunicacSujSancIle) {
        this.cssCodigo = comunicacSujSancIle.getCssCodigo();
        this.cssActivo = comunicacSujSancIle.getCssActivo();
        this.cssFechaRad = comunicacSujSancIle.getCssFechaRad();
        this.cssRadicado = comunicacSujSancIle.getCssRadicado();
        if (comunicacSujSancIle.getSiiProcesoSancIlegalidad()!=null) {
            this.procesoSancIlegalidadVo = new ProcesoSancIlegalidadVO(comunicacSujSancIle.getSiiProcesoSancIlegalidad());
        }
        if (comunicacSujSancIle.getSiiUsuarioConec()!= null) {
            this.usuarioConecVo = new UsuarioVO(comunicacSujSancIle.getSiiUsuarioConec());
        }
    }

    public void setCssActivo(String cssActivo) {
        this.cssActivo = cssActivo;
    }

    public String getCssActivo() {
        return cssActivo;
    }

    public void setCssCodigo(Long cssCodigo) {
        this.cssCodigo = cssCodigo;
    }

    public Long getCssCodigo() {
        return cssCodigo;
    }

    public void setCssFechaRad(Date cssFechaRad) {
        this.cssFechaRad = cssFechaRad;
    }

    public Date getCssFechaRad() {
        return cssFechaRad;
    }

    public void setCssRadicado(String cssRadicado) {
        this.cssRadicado = cssRadicado;
    }

    public String getCssRadicado() {
        return cssRadicado;
    }

    public void setProcesoSancIlegalidadVo(ProcesoSancIlegalidadVO procesoSancIlegalidadVo) {
        this.procesoSancIlegalidadVo = procesoSancIlegalidadVo;
    }

    public ProcesoSancIlegalidadVO getProcesoSancIlegalidadVo() {
        return procesoSancIlegalidadVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
