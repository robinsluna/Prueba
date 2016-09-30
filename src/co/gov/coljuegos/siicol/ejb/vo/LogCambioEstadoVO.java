package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogCambioEstado;

import java.util.Date;


public class LogCambioEstadoVO {
    
    private Long lceCodigo;
    private Long lceCodigoDoc;
    private Long lceEstadoNuevo;
    private Date lceFecha;
    private UsuarioVO usuarioVo;
    private TipoDocumentoColjuegosVO tipoDocumentoColjuegosVo;
    private String LceNombEstNuevo;
    
    public LogCambioEstadoVO() {
    }

    public LogCambioEstadoVO(SiiLogCambioEstado siiLogCambioEstado) {
        if(siiLogCambioEstado != null){
            this.lceCodigo = siiLogCambioEstado.getLceCodigo();
            this.lceCodigoDoc = siiLogCambioEstado.getLceCodigoDoc();
            this.lceEstadoNuevo = siiLogCambioEstado.getLceEstadoNuevo();
            this.lceFecha = siiLogCambioEstado.getLceFecha();
            this.LceNombEstNuevo = siiLogCambioEstado.getLceNombEstNuevo();
            if(siiLogCambioEstado.getSiiUsuario() != null){
                usuarioVo = new UsuarioVO(siiLogCambioEstado.getSiiUsuario() );
            }
            if(siiLogCambioEstado.getSiiTipoDocumentoColjuegos() != null){
                this.tipoDocumentoColjuegosVo = new TipoDocumentoColjuegosVO(siiLogCambioEstado.getSiiTipoDocumentoColjuegos());
            }
        }
    }

    public void setLceCodigo(Long lceCodigo) {
        this.lceCodigo = lceCodigo;
    }

    public Long getLceCodigo() {
        return lceCodigo;
    }

    public void setLceCodigoDoc(Long lceCodigoDoc) {
        this.lceCodigoDoc = lceCodigoDoc;
    }

    public Long getLceCodigoDoc() {
        return lceCodigoDoc;
    }

    public void setLceEstadoNuevo(Long lceEstadoNuevo) {
        this.lceEstadoNuevo = lceEstadoNuevo;
    }

    public Long getLceEstadoNuevo() {
        return lceEstadoNuevo;
    }

    public void setLceFecha(Date lceFecha) {
        this.lceFecha = lceFecha;
    }

    public Date getLceFecha() {
        return lceFecha;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setTipoDocumentoColjuegosVo(TipoDocumentoColjuegosVO tipoDocumentoColjuegosVo) {
        this.tipoDocumentoColjuegosVo = tipoDocumentoColjuegosVo;
    }

    public TipoDocumentoColjuegosVO getTipoDocumentoColjuegosVo() {
        return tipoDocumentoColjuegosVo;
    }

    public void setLceNombEstNuevo(String LceNombEstNuevo) {
        this.LceNombEstNuevo = LceNombEstNuevo;
    }

    public String getLceNombEstNuevo() {
        return LceNombEstNuevo;
    }
}
