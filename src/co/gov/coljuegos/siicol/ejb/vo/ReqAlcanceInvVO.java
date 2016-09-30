package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqAlcanceInv;

public class ReqAlcanceInvVO {
    private Long raiCodigo;
    private Integer rcrPuntaje;
    private AlcanceInvitacionVO alcanceInvitacionVo;
    private RequisitoCritVO requisitoCritVo;


    public ReqAlcanceInvVO(SiiReqAlcanceInv reqAlcanceInv) {
        this.raiCodigo = reqAlcanceInv.getRaiCodigo();
        this.rcrPuntaje = reqAlcanceInv.getRcrPuntaje();
        //Padres:
        if (reqAlcanceInv.getSiiAlcanceInvitacion() != null) {
            this.alcanceInvitacionVo = new AlcanceInvitacionVO(reqAlcanceInv.getSiiAlcanceInvitacion());
        }
        if (reqAlcanceInv.getSiiRequisitoCrit() != null) {
            this.requisitoCritVo = new RequisitoCritVO(reqAlcanceInv.getSiiRequisitoCrit());
        }
        
        
    }
    
    public ReqAlcanceInvVO() {
        
    }


    public void setRaiCodigo(Long raiCodigo) {
        this.raiCodigo = raiCodigo;
    }

    public Long getRaiCodigo() {
        return raiCodigo;
    }

    public void setRcrPuntaje(Integer rcrPuntaje) {
        this.rcrPuntaje = rcrPuntaje;
    }

    public Integer getRcrPuntaje() {
        return rcrPuntaje;
    }

    public void setAlcanceInvitacionVo(AlcanceInvitacionVO alcanceInvitacionVo) {
        this.alcanceInvitacionVo = alcanceInvitacionVo;
    }

    public AlcanceInvitacionVO getAlcanceInvitacionVo() {
        return alcanceInvitacionVo;
    }

    public void setRequisitoCritVo(RequisitoCritVO requisitoCritVo) {
        this.requisitoCritVo = requisitoCritVo;
    }

    public RequisitoCritVO getRequisitoCritVo() {
        return requisitoCritVo;
    }
}
