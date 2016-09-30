package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoPolizaCont;

import java.util.List;

public class EstadoPolizaContVO {
    private Long epoCodigo;
    private String epoNombre;
    private List<PolizaContratVO> polizaContratListVo;

    
    public EstadoPolizaContVO() {
    }
    
    public EstadoPolizaContVO(SiiEstadoPolizaCont siiEstadoPolizaCont) {
        this.epoCodigo = siiEstadoPolizaCont.getEpoCodigo();
        this.epoNombre = siiEstadoPolizaCont.getEpoNombre();

    }

    public void setEpoCodigo(Long epoCodigo) {
        this.epoCodigo = epoCodigo;
    }

    public Long getEpoCodigo() {
        return epoCodigo;
    }

    public void setEpoNombre(String epoNombre) {
        this.epoNombre = epoNombre;
    }

    public String getEpoNombre() {
        return epoNombre;
    }

    public void setPolizaContratListVo(List<PolizaContratVO> polizaContratListVo) {
        this.polizaContratListVo = polizaContratListVo;
    }

    public List<PolizaContratVO> getPolizaContratListVo() {
        return polizaContratListVo;
    }
}
