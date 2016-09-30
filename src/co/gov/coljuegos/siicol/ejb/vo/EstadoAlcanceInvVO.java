package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAlcanceInv;

import java.util.List;

public class EstadoAlcanceInvVO {
    private Long eaiCodigo;
    private String eaiNombre;
    private List<AlcanceInvitacionVO> alcanceInvitacionListVo;
    
    public EstadoAlcanceInvVO() {
        
    }
    
    public EstadoAlcanceInvVO(SiiEstadoAlcanceInv estadoAlcanceInv) {
        this.eaiCodigo = estadoAlcanceInv.getEaiCodigo();
        this.eaiNombre = estadoAlcanceInv.getEaiNombre();
    }


    public void setEaiCodigo(Long eaiCodigo) {
        this.eaiCodigo = eaiCodigo;
    }

    public Long getEaiCodigo() {
        return eaiCodigo;
    }

    public void setEaiNombre(String eaiNombre) {
        this.eaiNombre = eaiNombre;
    }

    public String getEaiNombre() {
        return eaiNombre;
    }

    public void setAlcanceInvitacionListVo(List<AlcanceInvitacionVO> alcanceInvitacionListVo) {
        this.alcanceInvitacionListVo = alcanceInvitacionListVo;
    }

    public List<AlcanceInvitacionVO> getAlcanceInvitacionListVo() {
        return alcanceInvitacionListVo;
    }

}
