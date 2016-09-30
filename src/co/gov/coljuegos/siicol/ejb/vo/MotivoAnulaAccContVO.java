package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMotivoAnulaAccCont;

import java.util.List;

public class MotivoAnulaAccContVO {
    private Long macCodigo;
    private String macNombre;
    private List<AccionControlVO> accionControlListVo;
    
    public MotivoAnulaAccContVO() {
        
    }

    public MotivoAnulaAccContVO(SiiMotivoAnulaAccCont motivo) {
        this.macCodigo = motivo.getMacCodigo();
        this.macNombre = motivo.getMacNombre();
        //Padres:
    }

    public void setMacCodigo(Long macCodigo) {
        this.macCodigo = macCodigo;
    }

    public Long getMacCodigo() {
        return macCodigo;
    }

    public void setMacNombre(String macNombre) {
        this.macNombre = macNombre;
    }

    public String getMacNombre() {
        return macNombre;
    }

    public void setAccionControlListVo(List<AccionControlVO> accionControlListVo) {
        this.accionControlListVo = accionControlListVo;
    }

    public List<AccionControlVO> getAccionControlListVo() {
        return accionControlListVo;
    }
}
