package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReqEstudioPrevio;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRequisitoCrit;

import java.util.List;

public class RequisitoCritVO {
    private String rcrActivo;
    private Long rcrCodigo;
    private String rcrNombre;
    private String rcrTipo;
    private List<ReqEstudioPrevioVO> reqEstudioPrevioListVo;
    
    public RequisitoCritVO(SiiRequisitoCrit siiRequisitoCrit) {
        this.rcrActivo = siiRequisitoCrit.getRcrActivo();
        this.rcrCodigo = siiRequisitoCrit.getRcrCodigo();
        this.rcrNombre = siiRequisitoCrit.getRcrNombre();
        this.rcrTipo = siiRequisitoCrit.getRcrTipo();
    }

    public RequisitoCritVO(){
        
    }
    public void setRcrActivo(String rcrActivo) {
        this.rcrActivo = rcrActivo;
    }

    public String getRcrActivo() {
        return rcrActivo;
    }

    public void setRcrCodigo(Long rcrCodigo) {
        this.rcrCodigo = rcrCodigo;
    }

    public Long getRcrCodigo() {
        return rcrCodigo;
    }

    public void setRcrNombre(String rcrNombre) {
        this.rcrNombre = rcrNombre;
    }

    public String getRcrNombre() {
        return rcrNombre;
    }

    public void setRcrTipo(String rcrTipo) {
        this.rcrTipo = rcrTipo;
    }

    public String getRcrTipo() {
        return rcrTipo;
    }

    public void setReqEstudioPrevioListVo(List<ReqEstudioPrevioVO> reqEstudioPrevioListVo) {
        this.reqEstudioPrevioListVo = reqEstudioPrevioListVo;
    }

    public List<ReqEstudioPrevioVO> getReqEstudioPrevioListVo() {
        return reqEstudioPrevioListVo;
    }
}
