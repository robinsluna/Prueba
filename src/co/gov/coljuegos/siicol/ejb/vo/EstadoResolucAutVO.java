package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoResolucAut;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionAutoriz;

import java.util.List;

public class EstadoResolucAutVO {
    private Long eraCodigo;
    private String eraNombre;
    private List<ResolucionAutorizVO> resolucionAutorizListVO;
    
    public EstadoResolucAutVO(SiiEstadoResolucAut siiEstadoResolucAut) {
        this.eraCodigo = siiEstadoResolucAut.getEraCodigo();
        this.eraNombre = siiEstadoResolucAut.getEraNombre();

    }
    public EstadoResolucAutVO() {
        
    }

    public void setEraCodigo(Long eraCodigo) {
        this.eraCodigo = eraCodigo;
    }

    public Long getEraCodigo() {
        return eraCodigo;
    }

    public void setEraNombre(String eraNombre) {
        this.eraNombre = eraNombre;
    }

    public String getEraNombre() {
        return eraNombre;
    }

    public void setResolucionAutorizListVO(List<ResolucionAutorizVO> resolucionAutorizListVO) {
        this.resolucionAutorizListVO = resolucionAutorizListVO;
    }

    public List<ResolucionAutorizVO> getResolucionAutorizListVO() {
        return resolucionAutorizListVO;
    }
}
