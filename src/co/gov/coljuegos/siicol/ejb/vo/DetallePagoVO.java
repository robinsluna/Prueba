package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


public class DetallePagoVO {
    
    private String cuenta;
    private String nombreCuenta;
    private String fuenteFin;
    private String ref1;
    private String numObliga;
    private String naturaleza;
    private BigDecimal valor;

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public String getFuenteFin() {
        return fuenteFin;
    }

    public void setFuenteFin(String fuenteFin) {
        this.fuenteFin = fuenteFin;
    }

    public String getRef1() {
        return ref1;
    }

    public void setRef1(String ref1) {
        this.ref1 = ref1;
    }

    public String getNumObliga() {
        return numObliga;
    }

    public void setNumObliga(String numObliga) {
        this.numObliga = numObliga;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
