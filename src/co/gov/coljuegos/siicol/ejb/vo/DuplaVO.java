package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class DuplaVO {
    private String concepto;
    private BigDecimal valor;   
    
    public DuplaVO() {        
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
