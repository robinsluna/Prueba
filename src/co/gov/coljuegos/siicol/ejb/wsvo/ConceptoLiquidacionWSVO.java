package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;

import java.util.Date;

public class ConceptoLiquidacionWSVO {

    public String numeroResolucion;
    public Integer numeroCuota;
    public Date pagoOportunoHasta;
    public BigDecimal saldoCuota;
    public BigDecimal interesesMora;
    public BigDecimal total;
    public String descripcionConcepto;

    public ConceptoLiquidacionWSVO() {
        super();
    }
}
