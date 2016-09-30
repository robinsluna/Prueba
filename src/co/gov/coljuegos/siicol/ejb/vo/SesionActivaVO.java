package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class SesionActivaVO {
    
    private String loginUsuario;
    private Date fechaLogin;
    private Date fechaUltimaActividad;
    private String ultimaPaginaSolicitada;
    private String idSesion;
    
    public SesionActivaVO() {
    }


    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    public String getIdSesion() {
        return idSesion;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }


    public void setFechaLogin(Date fechaLogin) {
        this.fechaLogin = fechaLogin;
    }

    public Date getFechaLogin() {
        return fechaLogin;
    }

    public void setFechaUltimaActividad(Date fechaUltimaActividad) {
        this.fechaUltimaActividad = fechaUltimaActividad;
    }

    public Date getFechaUltimaActividad() {
        return fechaUltimaActividad;
    }

    public void setUltimaPaginaSolicitada(String ultimaPaginaSolicitada) {
        this.ultimaPaginaSolicitada = ultimaPaginaSolicitada;
    }

    public String getUltimaPaginaSolicitada() {
        return ultimaPaginaSolicitada;
    }
}
