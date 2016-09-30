package co.gov.coljuegos.siicol.ejb.vo.siito.declaracion;

import java.math.BigDecimal;

import java.util.Date;

public class DeclaracionConsultaVO {

    public String nit;
    public Long numLiquidacion;
    public Date fechaLiquidacion;
    public String numContrato;
    public Date fechaContrato;
    public BigDecimal codigoConcepto;

    public Integer numConsecutivoCuota;
    public Integer anioOperacion;
    public Integer mesOperacion;
    public Date fechaLimitePagoOportuno;
    public BigDecimal saldoCuotas;
    public BigDecimal valorAPagar;
    public BigDecimal interesesMoraCausados;
    public BigDecimal interesesMoraPpagar;


    public DeclaracionConsultaVO() {
        
    }


    
}
