package co.gov.coljuegos.siicol.ejb.vo.siito.declaracion;

import java.math.BigDecimal;

import java.util.Date;

public class DeclaracionConsultaOtrosVO {
    
    public String nit;
    public Long numLiquidacion;
    public Date fechaLiquidacion;
    public String numContrato;
    public Date fechaContrato;
    public BigDecimal codigoConcepto;
    public BigDecimal tipoDocSoporte;
    public BigDecimal numDocSoporte;
    public String fechaDocSoporte;
    public Integer numConsecutivoCuota;
    public BigDecimal anioOperacion;
    public BigDecimal mesOperacion;
    public Date fechaLimitePagoOportuno;
    public BigDecimal saldoCuotas;
    public BigDecimal valorAPagar;
    public BigDecimal interesesMoraCausados;
    public BigDecimal interesesMoraPpagar;
    
    public DeclaracionConsultaOtrosVO() {
       
    }


}
