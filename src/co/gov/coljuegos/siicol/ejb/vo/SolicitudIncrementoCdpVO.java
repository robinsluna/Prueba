package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;


public class SolicitudIncrementoCdpVO {
    
    Long rp_codigo;  //rubro codigo
    BigDecimal cdpInc_valor;    // valor por rublo
    
    
    public SolicitudIncrementoCdpVO() {
    
    }    
    public void setRp_codigo(Long rp_codigo) {
        this.rp_codigo = rp_codigo;
    }

    public Long getRp_codigo() {
        return rp_codigo;
    }

    public void setCdpInc_valor(BigDecimal cdpInc_valor) {
        this.cdpInc_valor = cdpInc_valor;
    }

    public BigDecimal getCdpInc_valor() {
        return cdpInc_valor;
    }
 
}
