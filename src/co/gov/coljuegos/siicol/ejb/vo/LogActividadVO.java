package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLogActividad;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.sql.Timestamp;

import java.util.Date;

public class LogActividadVO {
    
    private Long loaCodigo;
    private Date loaFecha;
    private String loaIdSesion;
    private String loaPermisoAcc;
    private String loaUrl;
    private UsuarioVO usuarioVo;
    
    public LogActividadVO() {
    }
    
    public LogActividadVO(SiiLogActividad siiLogActividad) {
        this.loaCodigo = siiLogActividad.getLoaCodigo();
        this.loaFecha = siiLogActividad.getLoaFecha();
        this.loaIdSesion = siiLogActividad.getLoaIdSesion();
        this.loaPermisoAcc = siiLogActividad.getLoaPermisoAcc();
        this.loaUrl = siiLogActividad.getLoaUrl();
        if(siiLogActividad.getSiiUsuario() != null){
            usuarioVo = new UsuarioVO(siiLogActividad.getSiiUsuario());
        }
    }


    public void setLoaCodigo(Long loaCodigo) {
        this.loaCodigo = loaCodigo;
    }

    public Long getLoaCodigo() {
        return loaCodigo;
    }

    public void setLoaFecha(Date loaFecha) {
        this.loaFecha = loaFecha;
    }

    public Date getLoaFecha() {
        return loaFecha;
    }

    public void setLoaIdSesion(String loaIdSesion) {
        this.loaIdSesion = loaIdSesion;
    }

    public String getLoaIdSesion() {
        return loaIdSesion;
    }

    public void setLoaPermisoAcc(String loaPermisoAcc) {
        this.loaPermisoAcc = loaPermisoAcc;
    }

    public String getLoaPermisoAcc() {
        return loaPermisoAcc;
    }

    public void setLoaUrl(String loaUrl) {
        this.loaUrl = loaUrl;
    }

    public String getLoaUrl() {
        return loaUrl;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }
}
