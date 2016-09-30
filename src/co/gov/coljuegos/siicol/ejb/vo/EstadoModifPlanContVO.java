package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPlanCont;

import java.util.List;

public class EstadoModifPlanContVO {
    private Long emoCodigo;
    private String emoNombre;
    private List<ModificacionPlanContVO> modificacionPlanContListVo;
    
    public EstadoModifPlanContVO(){
        
    }
    public EstadoModifPlanContVO(SiiEstadoModifPlanCont e) {
        this.emoCodigo = e.getEmoCodigo();
        this.emoNombre = e.getEmoNombre();
    }

    public void setEmoCodigo(Long emoCodigo) {
        this.emoCodigo = emoCodigo;
    }

    public Long getEmoCodigo() {
        return emoCodigo;
    }

    public void setEmoNombre(String emoNombre) {
        this.emoNombre = emoNombre;
    }

    public String getEmoNombre() {
        return emoNombre;
    }

    public void setModificacionPlanContListVo(List<ModificacionPlanContVO> modificacionPlanContListVo) {
        this.modificacionPlanContListVo = modificacionPlanContListVo;
    }

    public List<ModificacionPlanContVO> getModificacionPlanContListVo() {
        return modificacionPlanContListVo;
    }

}
