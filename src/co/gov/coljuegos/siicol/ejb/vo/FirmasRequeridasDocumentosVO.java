package co.gov.coljuegos.siicol.ejb.vo;

import java.util.Date;

public class FirmasRequeridasDocumentosVO {
    String fun_nombre;
    String fre_etiqueta;
    String usu_nombre_usuario;
    String per_nombre_completo;
    Long fdo_codigo;
    Long usu_codigo;
    Date fdo_fecha_firma;
    Long fre_codigo;
    Long fdo_id_documento;
    
    
    public FirmasRequeridasDocumentosVO() {
    }

    public void setFun_nombre(String fun_nombre) {
        this.fun_nombre = fun_nombre;
    }

    public String getFun_nombre() {
        return fun_nombre;
    }

    public void setFre_etiqueta(String fre_etiqueta) {
        this.fre_etiqueta = fre_etiqueta;
    }

    public String getFre_etiqueta() {
        return fre_etiqueta;
    }

    public void setUsu_nombre_usuario(String usu_nombre_usuario) {
        this.usu_nombre_usuario = usu_nombre_usuario;
    }

    public String getUsu_nombre_usuario() {
        return usu_nombre_usuario;
    }

    public void setPer_nombre_completo(String per_nombre_completo) {
        this.per_nombre_completo = per_nombre_completo;
    }

    public String getPer_nombre_completo() {
        return per_nombre_completo;
    }

    public void setFdo_codigo(Long fdo_codigo) {
        this.fdo_codigo = fdo_codigo;
    }

    public Long getFdo_codigo() {
        return fdo_codigo;
    }

    public void setUsu_codigo(Long usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    public Long getUsu_codigo() {
        return usu_codigo;
    }

    public void setFdo_fecha_firma(Date fdo_fecha_firma) {
        this.fdo_fecha_firma = fdo_fecha_firma;
    }

    public Date getFdo_fecha_firma() {
        return fdo_fecha_firma;
    }

    public void setFre_codigo(Long fre_codigo) {
        this.fre_codigo = fre_codigo;
    }

    public Long getFre_codigo() {
        return fre_codigo;
    }

    public void setFdo_id_documento(Long fdo_id_documento) {
        this.fdo_id_documento = fdo_id_documento;
    }

    public Long getFdo_id_documento() {
        return fdo_id_documento;
    }
}
