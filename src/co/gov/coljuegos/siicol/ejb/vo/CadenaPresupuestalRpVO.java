package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.Date;


public class CadenaPresupuestalRpVO {

    private BigDecimal RP_CONSECUTIVO;
    private Date FECHEXPEDICIONRP;
    private String DESRUBRO;
    private BigDecimal VALOR_RUBRO_RP;
    private BigDecimal VALOR_TOTAL_MOD_RUBRO_RP;
    private BigDecimal VALOR_TOTAL_OBLI_RUBRO_RP;
    private BigDecimal VALOR_TOTAL_X_OBLIGAR_RUBRO_RP;
    private BigDecimal VALOR_TOTAL_PAGOS_RUBRO_RP;
    private BigDecimal VALOR_TOTAL_POR_PAGAR_RP;
    private String OBJETO_GASTO;


    public BigDecimal getRP_CONSECUTIVO() {
        return RP_CONSECUTIVO;
    }

    public void setRP_CONSECUTIVO(BigDecimal RP_CONSECUTIVO) {
        this.RP_CONSECUTIVO = RP_CONSECUTIVO;
    }

    public Date getFECHEXPEDICIONRP() {
        return FECHEXPEDICIONRP;
    }

    public void setFECHEXPEDICIONRP(Date FECHEXPEDICIONRP) {
        this.FECHEXPEDICIONRP = FECHEXPEDICIONRP;
    }

    public String getDESRUBRO() {
        return DESRUBRO;
    }

    public void setDESRUBRO(String DESRUBRO) {
        this.DESRUBRO = DESRUBRO;
    }

    public BigDecimal getVALOR_RUBRO_RP() {
        return VALOR_RUBRO_RP;
    }

    public void setVALOR_RUBRO_RP(BigDecimal VALOR_RUBRO_RP) {
        this.VALOR_RUBRO_RP = VALOR_RUBRO_RP;
    }

    public BigDecimal getVALOR_TOTAL_MOD_RUBRO_RP() {
        return VALOR_TOTAL_MOD_RUBRO_RP;
    }

    public void setVALOR_TOTAL_MOD_RUBRO_RP(BigDecimal VALOR_TOTAL_MOD_RUBRO_RP) {
        this.VALOR_TOTAL_MOD_RUBRO_RP = VALOR_TOTAL_MOD_RUBRO_RP;
    }

    public BigDecimal getVALOR_TOTAL_OBLI_RUBRO_RP() {
        return VALOR_TOTAL_OBLI_RUBRO_RP;
    }

    public void setVALOR_TOTAL_OBLI_RUBRO_RP(BigDecimal VALOR_TOTAL_OBLI_RUBRO_RP) {
        this.VALOR_TOTAL_OBLI_RUBRO_RP = VALOR_TOTAL_OBLI_RUBRO_RP;
    }

    public BigDecimal getVALOR_TOTAL_X_OBLIGAR_RUBRO_RP() {
        return VALOR_TOTAL_X_OBLIGAR_RUBRO_RP;
    }

    public void setVALOR_TOTAL_X_OBLIGAR_RUBRO_RP(BigDecimal VALOR_TOTAL_X_OBLIGAR_RUBRO_RP) {
        this.VALOR_TOTAL_X_OBLIGAR_RUBRO_RP = VALOR_TOTAL_X_OBLIGAR_RUBRO_RP;
    }

    public BigDecimal getVALOR_TOTAL_PAGOS_RUBRO_RP() {
        return VALOR_TOTAL_PAGOS_RUBRO_RP;
    }

    public void setVALOR_TOTAL_PAGOS_RUBRO_RP(BigDecimal VALOR_TOTAL_PAGOS_RUBRO_RP) {
        this.VALOR_TOTAL_PAGOS_RUBRO_RP = VALOR_TOTAL_PAGOS_RUBRO_RP;
    }

    public BigDecimal getVALOR_TOTAL_POR_PAGAR_RP() {
        return VALOR_TOTAL_POR_PAGAR_RP;
    }

    public void setVALOR_TOTAL_POR_PAGAR_RP(BigDecimal VALOR_TOTAL_POR_PAGAR_RP) {
        this.VALOR_TOTAL_POR_PAGAR_RP = VALOR_TOTAL_POR_PAGAR_RP;
    }

    public String getOBJETO_GASTO() {
        return OBJETO_GASTO;
    }

    public void setOBJETO_GASTO(String OBJETO_GASTO) {
        this.OBJETO_GASTO = OBJETO_GASTO;
    }
}
