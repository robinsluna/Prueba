package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSuspensionCont;

import java.util.List;

public class EstadoSuspensionContVO {
    private Long escCodigo;
    private String escNombre;
    private List<SuspensionContrVO> suspensionContrListVo;

    public EstadoSuspensionContVO() {        
    }
    
    public EstadoSuspensionContVO(SiiEstadoSuspensionCont siiEstadoSuspensionCont) {
        this.escCodigo = siiEstadoSuspensionCont.getEscCodigo();
        this.escNombre = siiEstadoSuspensionCont.getEscNombre();
    }

    public void setEscCodigo(Long escCodigo) {
        this.escCodigo = escCodigo;
    }

    public Long getEscCodigo() {
        return escCodigo;
    }

    public void setEscNombre(String escNombre) {
        this.escNombre = escNombre;
    }

    public String getEscNombre() {
        return escNombre;
    }

    public void setSuspensionContrListVo(List<SuspensionContrVO> suspensionContrListVo) {
        this.suspensionContrListVo = suspensionContrListVo;
    }

    public List<SuspensionContrVO> getSuspensionContrListVo() {
        return suspensionContrListVo;
    }
}
