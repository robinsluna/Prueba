package co.gov.coljuegos.siicol.ejb.vo;


public class NovedadInventarioVO {
    private String conNumero;
    private String osiConsecutivo;
    private String tsaNombre;
    private String tnoNombre;
    private String tapNombre;
    private Long cantidad;
    private String estNombre;
    private String estDireccion;
    private String municipio;
    private String departamento;
    
    public NovedadInventarioVO() {
        
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setOsiConsecutivo(String osiConsecutivo) {
        this.osiConsecutivo = osiConsecutivo;
    }

    public String getOsiConsecutivo() {
        return osiConsecutivo;
    }

    public void setTsaNombre(String tsaNombre) {
        this.tsaNombre = tsaNombre;
    }

    public String getTsaNombre() {
        return tsaNombre;
    }

    public void setTnoNombre(String tnoNombre) {
        this.tnoNombre = tnoNombre;
    }

    public String getTnoNombre() {
        return tnoNombre;
    }

    public void setTapNombre(String tapNombre) {
        this.tapNombre = tapNombre;
    }

    public String getTapNombre() {
        return tapNombre;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setEstNombre(String estNombre) {
        this.estNombre = estNombre;
    }

    public String getEstNombre() {
        return estNombre;
    }

    public void setEstDireccion(String estDireccion) {
        this.estDireccion = estDireccion;
    }

    public String getEstDireccion() {
        return estDireccion;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }
}
