package co.gov.coljuegos.siicol.ejb.vo.siito.estadoCuenta;

import java.math.BigDecimal;

import java.util.Date;

public class CuotasOperadorVO {
    
    public String numContrato;
    public String fechaContrato;
    public BigDecimal codConcepto;
    public String descConcepto;
    public String tipoDocSoporte;
    public String numeroDocSoporte;
    public Date fechaDocSoporte;
    public BigDecimal numCuota;
    public BigDecimal anioOperacion;
    public BigDecimal mesOperacion;
    public String fechaLimitePago;
    public BigDecimal valorCuota;
    public BigDecimal saldoCuota;
    public BigDecimal saldoInteres;
    public BigDecimal totalPagar;
        
    public CuotasOperadorVO() {
        super();
    }


}
