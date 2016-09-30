package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaRequisitosPol;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitosPolizaCon;

public class PolizaRequisitosPolVO {
    private Long prpCodigo;
    private String prpCumple;
    private PolizaContratVO polizaContratVo;
    private RequisitosPolizaConVO requisitosPolizaConVo;

    
    public PolizaRequisitosPolVO() {
        
    }
    
    public PolizaRequisitosPolVO(SiiPolizaRequisitosPol requisitos) {
        this.prpCodigo = requisitos.getPrpCodigo();
        this.prpCumple = requisitos.getPrpCumple();
        //Padres:
        this.polizaContratVo = new PolizaContratVO(requisitos.getSiiPolizaContrat());
        this.requisitosPolizaConVo = new RequisitosPolizaConVO(requisitos.getSiiRequisitosPolizaCon());
    }

    public void setPrpCodigo(Long prpCodigo) {
        this.prpCodigo = prpCodigo;
    }

    public Long getPrpCodigo() {
        return prpCodigo;
    }

    public void setPrpCumple(String prpCumple) {
        this.prpCumple = prpCumple;
    }

    public String getPrpCumple() {
        return prpCumple;
    }

    public void setPolizaContratVo(PolizaContratVO polizaContratVo) {
        this.polizaContratVo = polizaContratVo;
    }

    public PolizaContratVO getPolizaContratVo() {
        return polizaContratVo;
    }

    public void setRequisitosPolizaConVo(RequisitosPolizaConVO requisitosPolizaConVo) {
        this.requisitosPolizaConVo = requisitosPolizaConVo;
    }

    public RequisitosPolizaConVO getRequisitosPolizaConVo() {
        return requisitosPolizaConVo;
    }
}
