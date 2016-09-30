package co.gov.coljuegos.siicol.ejb.wsvo;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class LiquidacionOtrosConceptosWSVO {

    public Long numeroLiquidacion;
    public Long codigoLiquidacionSug;
    public Date fechaLiquidacion;
    public String razonSocial;
    public String telefonos;
    public String nit;
    public String ciudad;
    public String departamento;
    public String direccion;
    public String contador;
    public String revisorFiscal;
    public String representanteLegal;
    public List<CuotaOperadorWSVO> listaCuotaOperadorWSVO;
    public String perEmail;
    public String tipoIdentificacionEmpresa;
    public String contrato;

    //Cupones de pago
    public Long referenciaPagoDE;
    public Long referenciaPagoGA;
    public BigDecimal totalPagarDE;
    public BigDecimal totalPagarGA;
    /*public BigDecimal interesesMoraDE;
    public BigDecimal interesesMoraGA;*/

    public LiquidacionOtrosConceptosWSVO() {
        super();
    }
}
