package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

import java.util.List;

public class CadenaPresupuestalVO {
    
    private BigDecimal VALOR_TOTAL_CDP;
    private BigDecimal VALOR_TOTAL_MODIFICADO_CDP;
    private List<CadenaPresupuestalRubroVO> CADENA_PRESUPUESTAL_RUBRO_VO;    

    public BigDecimal getVALOR_TOTAL_CDP() {
        return VALOR_TOTAL_CDP;
    }

    public void setVALOR_TOTAL_CDP(BigDecimal VALOR_TOTAL_CDP) {
        this.VALOR_TOTAL_CDP = VALOR_TOTAL_CDP;
    }

    public List<CadenaPresupuestalRubroVO> getCADENA_PRESUPUESTAL_RUBRO_VO() {
        return CADENA_PRESUPUESTAL_RUBRO_VO;
    }

    public void setCADENA_PRESUPUESTAL_RUBRO_VO(List<CadenaPresupuestalRubroVO> CADENA_PRESUPUESTAL_RUBRO_VO) {
        this.CADENA_PRESUPUESTAL_RUBRO_VO = CADENA_PRESUPUESTAL_RUBRO_VO;
    }

    public BigDecimal getVALOR_TOTAL_MODIFICADO_CDP() {
        return VALOR_TOTAL_MODIFICADO_CDP;
    }

    public void setVALOR_TOTAL_MODIFICADO_CDP(BigDecimal VALOR_TOTAL_MODIFICADO_CDP) {
        this.VALOR_TOTAL_MODIFICADO_CDP = VALOR_TOTAL_MODIFICADO_CDP;
    }
}
