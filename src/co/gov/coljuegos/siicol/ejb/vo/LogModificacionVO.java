package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogActividad;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogCampoModificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogModificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.Date;
import java.util.List;

public class LogModificacionVO {
    
    private Long lmoCodigo;
    private String lmoDescripcionTabla;
    private Date lmoFecha;
    private String lmoIpUsuarioBd;
    private String lmoTabla;
    private String lmoUsuarioBd;
    private String usuTipoModific;
    private UsuarioVO usuarioConecVo;
    //private List<SiiLogCampoModificacion> siiLogCampoModificacionList;
 
    
    public LogModificacionVO(SiiLogModificacion siiLogModificacion) {
        this.lmoCodigo = siiLogModificacion.getLmoCodigo();
        this.lmoDescripcionTabla = siiLogModificacion.getLmoDescripcionTabla();
        this.lmoFecha = siiLogModificacion.getLmoFecha();
        this.lmoIpUsuarioBd = siiLogModificacion.getLmoIpUsuarioBd();
        this.lmoTabla = siiLogModificacion.getLmoTabla();
        this.lmoUsuarioBd = siiLogModificacion.getLmoUsuarioBd();
        if(siiLogModificacion.getSiiUsuarioConec() != null){
            usuarioConecVo = new UsuarioVO(siiLogModificacion.getSiiUsuarioConec());
        }
    }


    public void setLmoCodigo(Long lmoCodigo) {
        this.lmoCodigo = lmoCodigo;
    }

    public Long getLmoCodigo() {
        return lmoCodigo;
    }

    public void setLmoDescripcionTabla(String lmoDescripcionTabla) {
        this.lmoDescripcionTabla = lmoDescripcionTabla;
    }

    public String getLmoDescripcionTabla() {
        return lmoDescripcionTabla;
    }

    public void setLmoFecha(Date lmoFecha) {
        this.lmoFecha = lmoFecha;
    }

    public Date getLmoFecha() {
        return lmoFecha;
    }

    public void setLmoIpUsuarioBd(String lmoIpUsuarioBd) {
        this.lmoIpUsuarioBd = lmoIpUsuarioBd;
    }

    public String getLmoIpUsuarioBd() {
        return lmoIpUsuarioBd;
    }

    public void setLmoTabla(String lmoTabla) {
        this.lmoTabla = lmoTabla;
    }

    public String getLmoTabla() {
        return lmoTabla;
    }

    public void setLmoUsuarioBd(String lmoUsuarioBd) {
        this.lmoUsuarioBd = lmoUsuarioBd;
    }

    public String getLmoUsuarioBd() {
        return lmoUsuarioBd;
    }

    public void setUsuTipoModific(String usuTipoModific) {
        this.usuTipoModific = usuTipoModific;
    }

    public String getUsuTipoModific() {
        return usuTipoModific;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }
}
