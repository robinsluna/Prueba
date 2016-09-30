package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;

public class ReqEstudioPrevioVO {
    private Long resCodigo;
    private Integer resPuntaje;
 //   private String tipoRequisito; // usada para filtrar los tipos de requisitos en requisitoCritVo.rcrTipo
    private EstudioPrevioVO estudioPrevioVo;
    private RequisitoCritVO requisitoCritVo;
    
    public ReqEstudioPrevioVO(SiiReqEstudioPrevio siiReqEstudioPrevio) {
        this.resCodigo = siiReqEstudioPrevio.getResCodigo();
        this.resPuntaje = siiReqEstudioPrevio.getResPuntaje();
        this.estudioPrevioVo = new EstudioPrevioVO(siiReqEstudioPrevio.getSiiEstudioPrevio1());
        this.requisitoCritVo = new RequisitoCritVO(siiReqEstudioPrevio.getSiiRequisitoCrit());
    }
    
    public ReqEstudioPrevioVO(){
        
    }

    public void setResCodigo(Long resCodigo) {
        this.resCodigo = resCodigo;
    }

    public Long getResCodigo() {
        return resCodigo;
    }

    public void setResPuntaje(Integer resPuntaje) {
        this.resPuntaje = resPuntaje;
    }

    public Integer getResPuntaje() {
        return resPuntaje;
    }

    public void setEstudioPrevioVo(EstudioPrevioVO estudioPrevioVo) {
        this.estudioPrevioVo = estudioPrevioVo;
    }

    public EstudioPrevioVO getEstudioPrevioVo() {
        return estudioPrevioVo;
    }

    public void setRequisitoCritVo(RequisitoCritVO requisitoCritVo) {
        this.requisitoCritVo = requisitoCritVo;
    }

    public RequisitoCritVO getRequisitoCritVo() {
        return requisitoCritVo;
    }
}
