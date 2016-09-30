package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;

import java.util.Date;

public class ConceptoCuotaWSVO {

    public String Abreviatura;
    public String nombreConcepto;
    public BigDecimal valor;
    public BigDecimal valorInteres;
    public BigDecimal valorTotal;
    public Date fechaVencimiento;
    public Long codigoCuota;
    public String destinoCuota;

    public ConceptoCuotaWSVO() {
    }
}
