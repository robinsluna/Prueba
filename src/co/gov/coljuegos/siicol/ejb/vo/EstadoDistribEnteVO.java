package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDistribucionMes;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoDistribEnte;

import java.util.List;

public class EstadoDistribEnteVO {
    
    private Long edeCodigo;
    private String edeNombre;
    private List<DistribucionMesVO> distribucionMesListVo;
    
    public EstadoDistribEnteVO(SiiEstadoDistribEnte siiEstadoDistribEnte) {
        this.edeCodigo = siiEstadoDistribEnte.getEdeCodigo();
        this.edeNombre = siiEstadoDistribEnte.getEdeNombre();
    }
    public EstadoDistribEnteVO() {        
    }

    public void setEdeCodigo(Long edeCodigo) {
        this.edeCodigo = edeCodigo;
    }

    public Long getEdeCodigo() {
        return edeCodigo;
    }

    public void setEdeNombre(String edeNombre) {
        this.edeNombre = edeNombre;
    }

    public String getEdeNombre() {
        return edeNombre;
    }

    public void setDistribucionMesListVo(List<DistribucionMesVO> distribucionMesListVo) {
        this.distribucionMesListVo = distribucionMesListVo;
    }

    public List<DistribucionMesVO> getDistribucionMesListVo() {
        return distribucionMesListVo;
    }

}
