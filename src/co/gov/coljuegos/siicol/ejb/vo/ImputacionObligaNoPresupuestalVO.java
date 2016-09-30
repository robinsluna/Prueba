package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class ImputacionObligaNoPresupuestalVO {
    private String razonSocial;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Long idImputacion; 
    private Long codigoCuentaContable;
    private String tipoComprobante;
    private Integer numeroComprobante;
    private String descripcionOperacion;
    private String tipoMovimiento;
    private BigDecimal valor;
    private String codigoFuenteFinanciacion;
    private String cadena;
    private Long codAreaColjuegos;
    private String ionEstado;
    private Long onpCodigo;
    private Long ionCodigo;
    
    
    public ImputacionObligaNoPresupuestalVO() {
        
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) 
    {
        boolean igual = false;
        if (o instanceof ImputacionObligaNoPresupuestalVO) {
            ImputacionObligaNoPresupuestalVO iVO = (ImputacionObligaNoPresupuestalVO) o;
            if (iVO != null) {
                igual =
                    ((iVO.razonSocial != null && iVO.razonSocial.equals(this.razonSocial)) || (iVO.razonSocial == null && this.razonSocial == null)) &&
                    ((iVO.primerNombre != null && iVO.primerNombre.equals(this.primerNombre)) || (iVO.primerNombre == null && this.primerNombre == null)) &&
                    ((iVO.segundoNombre != null && iVO.segundoNombre.equals(this.segundoNombre)) || (iVO.segundoNombre == null && this.segundoNombre == null)) &&
                    ((iVO.primerApellido != null && iVO.primerApellido.equals(this.primerApellido)) || (iVO.primerApellido == null && this.primerApellido == null)) &&
                    ((iVO.segundoApellido != null && iVO.segundoApellido.equals(this.segundoApellido)) || (iVO.segundoApellido == null && this.segundoApellido == null)) &&
                    ((iVO.tipoIdentificacion != null && iVO.tipoIdentificacion.equals(this.tipoIdentificacion)) || (iVO.tipoIdentificacion == null && this.tipoIdentificacion == null)) &&
                    ((iVO.numeroIdentificacion != null && iVO.numeroIdentificacion.equals(this.numeroIdentificacion)) || (iVO.numeroIdentificacion == null && this.numeroIdentificacion == null)) &&
                    ((iVO.idImputacion != null && iVO.idImputacion.equals(this.idImputacion)) || (iVO.idImputacion == null && this.idImputacion == null)) &&
                    ((iVO.codigoCuentaContable != null && iVO.codigoCuentaContable.equals(this.codigoCuentaContable)) || (iVO.codigoCuentaContable == null && this.codigoCuentaContable == null)) &&
                    ((iVO.tipoComprobante != null && iVO.tipoComprobante.equals(this.tipoComprobante)) || (iVO.tipoComprobante == null && this.tipoComprobante == null)) &&
                    ((iVO.numeroComprobante != null && iVO.numeroComprobante.equals(this.numeroComprobante)) || (iVO.numeroComprobante == null && this.numeroComprobante == null)) &&
                    ((iVO.descripcionOperacion != null && iVO.descripcionOperacion.equals(this.descripcionOperacion)) || (iVO.descripcionOperacion == null && this.descripcionOperacion == null)) &&
                    ((iVO.tipoMovimiento != null && iVO.tipoMovimiento.equals(this.tipoMovimiento)) || (iVO.tipoMovimiento == null && this.tipoMovimiento == null)) &&
                    ((iVO.valor != null && iVO.valor.equals(this.valor)) || (iVO.valor == null && this.valor == null)) &&
                    ((iVO.codigoFuenteFinanciacion != null && iVO.codigoFuenteFinanciacion.equals(this.codigoFuenteFinanciacion)) || (iVO.codigoFuenteFinanciacion == null && this.codigoFuenteFinanciacion == null)) && 
                    ((iVO.cadena != null && iVO.cadena.equals(this.cadena)) || (iVO.cadena == null && this.cadena == null)) && 
                    ((iVO.codAreaColjuegos != null && iVO.codAreaColjuegos.equals(this.codAreaColjuegos)) || (iVO.codAreaColjuegos == null && this.codAreaColjuegos == null)) &&
                    ((iVO.ionEstado != null && iVO.ionEstado.equals(this.ionEstado)) || (iVO.ionEstado == null && this.ionEstado == null)) && 
                    ((iVO.onpCodigo != null && iVO.onpCodigo.equals(this.onpCodigo)) || (iVO.onpCodigo == null && this.onpCodigo == null)) && 
                    ((iVO.ionCodigo != null && iVO.ionCodigo.equals(this.ionCodigo)) || (iVO.ionCodigo == null && this.ionCodigo == null));
            }
        }
        
        return (igual);
    }
    
    
    

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setIdImputacion(Long idImputacion) {
        this.idImputacion = idImputacion;
    }

    public Long getIdImputacion() {
        return idImputacion;
    }

    public void setCodigoCuentaContable(Long codigoCuentaContable) {
        this.codigoCuentaContable = codigoCuentaContable;
    }

    public Long getCodigoCuentaContable() {
        return codigoCuentaContable;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setNumeroComprobante(Integer numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Integer getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setDescripcionOperacion(String descripcionOperacion) {
        this.descripcionOperacion = descripcionOperacion;
    }

    public String getDescripcionOperacion() {
        return descripcionOperacion;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCodAreaColjuegos(Long codAreaColjuegos) {
        this.codAreaColjuegos = codAreaColjuegos;
    }

    public Long getCodAreaColjuegos() {
        return codAreaColjuegos;
    }

    public void setCodigoFuenteFinanciacion(String codigoFuenteFinanciacion) {
        this.codigoFuenteFinanciacion = codigoFuenteFinanciacion;
    }

    public String getCodigoFuenteFinanciacion() {
        return codigoFuenteFinanciacion;
    }

    public void setIonEstado(String ionEstado) {
        this.ionEstado = ionEstado;
    }

    public String getIonEstado() {
        return ionEstado;
    }

    public void setOnpCodigo(Long onpCodigo) {
        this.onpCodigo = onpCodigo;
    }

    public Long getOnpCodigo() {
        return onpCodigo;
    }

    public void setIonCodigo(Long ionCodigo) {
        this.ionCodigo = ionCodigo;
    }

    public Long getIonCodigo() {
        return ionCodigo;
    }

}
