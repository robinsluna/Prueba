package co.gov.coljuegos.siicol.ejb.vo;


public class ProgramacionRPVO {
    
    private Integer codRP;
    private String numDocBeneficiario;
    private String nombreRazonSocial;
    private String objeto;
    private String direccion;
    private String telefono;
    private long valorFactura;
    private char tipoFactura;
    private String numeroDocCobro;
    private int solicituConSoporteOriginal;
    private String observaciones;
    private String motivoDevolucion;

    
    public ProgramacionRPVO() {
        super();
    }


    public void setCodRP(Integer codRP) {
        this.codRP = codRP;
    }

    public Integer getCodRP() {
        return codRP;
    }

    public void setNumDocBeneficiario(String numDocBeneficiario) {
        this.numDocBeneficiario = numDocBeneficiario;
    }

    public String getNumDocBeneficiario() {
        return numDocBeneficiario;
    }

    public void setNombreRazonSocial(String nombreRazonSocial) {
        this.nombreRazonSocial = nombreRazonSocial;
    }

    public String getNombreRazonSocial() {
        return nombreRazonSocial;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public String getObjeto() {
        return objeto;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setValorFactura(long valorFactura) {
        this.valorFactura = valorFactura;
    }

    public long getValorFactura() {
        return valorFactura;
    }


    public void setTipoFactura(char tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public char getTipoFactura() {
        return tipoFactura;
    }

    public void setNumeroDocCobro(String numeroDocCobro) {
        this.numeroDocCobro = numeroDocCobro;
    }

    public String getNumeroDocCobro() {
        return numeroDocCobro;
    }

    public void setSolicituConSoporteOriginal(int solicituConSoporteOriginal) {
        this.solicituConSoporteOriginal = solicituConSoporteOriginal;
    }

    public int getSolicituConSoporteOriginal() {
        return solicituConSoporteOriginal;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setMotivoDevolucion(String motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public String getMotivoDevolucion() {
        return motivoDevolucion;
    }
}
