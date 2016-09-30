package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;

import java.util.List;

public class PlanContratacionVO {
    
    private Long pcnCodigo;
    private Integer pcnVigencia;
    private List<ItemPlanContratacVO> itemPlanContratacVoList;
    
    
    public PlanContratacionVO(SiiPlanContratacion siiPlanContratacion) {
        this.pcnCodigo = siiPlanContratacion.getPcnCodigo();
        this.pcnVigencia = siiPlanContratacion.getPcnVigencia();
    }
    
    public PlanContratacionVO() {
    }


    public void setPcnCodigo(Long pcnCodigo) {
        this.pcnCodigo = pcnCodigo;
    }

    public Long getPcnCodigo() {
        return pcnCodigo;
    }

    public void setPcnVigencia(Integer pcnVigencia) {
        this.pcnVigencia = pcnVigencia;
    }

    public Integer getPcnVigencia() {
        return pcnVigencia;
    }

    public void setItemPlanContratacVoList(List<ItemPlanContratacVO> itemPlanContratacVoList) {
        this.itemPlanContratacVoList = itemPlanContratacVoList;
    }

    public List<ItemPlanContratacVO> getItemPlanContratacVoList() {
        return itemPlanContratacVoList;
    }
}
