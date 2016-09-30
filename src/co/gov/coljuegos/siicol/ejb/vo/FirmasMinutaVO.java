package co.gov.coljuegos.siicol.ejb.vo;

public class FirmasMinutaVO {
    String tdo_nombre;
    String tdo_descripcion;
    String fre_etiqueta;
    String per_nombre_completo;
    String per_num_identificacion;
    
    public FirmasMinutaVO() {        
    }

    public void setTdo_nombre(String tdo_nombre) {
        this.tdo_nombre = tdo_nombre;
    }

    public String getTdo_nombre() {
        return tdo_nombre;
    }

    public void setTdo_descripcion(String tdo_descripcion) {
        this.tdo_descripcion = tdo_descripcion;
    }

    public String getTdo_descripcion() {
        return tdo_descripcion;
    }

    public void setFre_etiqueta(String fre_etiqueta) {
        this.fre_etiqueta = fre_etiqueta;
    }

    public String getFre_etiqueta() {
        return fre_etiqueta;
    }

    public void setPer_nombre_completo(String per_nombre_completo) {
        this.per_nombre_completo = per_nombre_completo;
    }

    public String getPer_nombre_completo() {
        return per_nombre_completo;
    }

    public void setPer_num_identificacion(String per_num_identificacion) {
        this.per_num_identificacion = per_num_identificacion;
    }

    public String getPer_num_identificacion() {
        return per_num_identificacion;
    }
}
