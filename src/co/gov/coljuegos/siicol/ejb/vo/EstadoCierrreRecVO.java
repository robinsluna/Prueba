package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreRecaudo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoCierrreRec;

import java.util.List;

public class EstadoCierrreRecVO {
    
    private Long ecrCodigo;
    private String ecrNombre;
    private List<CierreRecaudoVO> cierreRecaudoListVo;
    
    public EstadoCierrreRecVO(SiiEstadoCierrreRec siiEstadoCierrreRec) {
       this.ecrCodigo = siiEstadoCierrreRec.getEcrCodigo();
       this.ecrNombre = siiEstadoCierrreRec.getEcrNombre();
    }
    
    public EstadoCierrreRecVO() {
       
    }


    public void setEcrCodigo(Long ecrCodigo) {
        this.ecrCodigo = ecrCodigo;
    }

    public Long getEcrCodigo() {
        return ecrCodigo;
    }

    public void setEcrNombre(String ecrNombre) {
        this.ecrNombre = ecrNombre;
    }

    public String getEcrNombre() {
        return ecrNombre;
    }

    public void setCierreRecaudoListVo(List<CierreRecaudoVO> cierreRecaudoListVo) {
        this.cierreRecaudoListVo = cierreRecaudoListVo;
    }

    public List<CierreRecaudoVO> getCierreRecaudoListVo() {
        return cierreRecaudoListVo;
    }
}
