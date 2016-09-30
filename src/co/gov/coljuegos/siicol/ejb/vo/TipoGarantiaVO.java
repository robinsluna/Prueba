package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoGarantia;

import java.util.List;

public class TipoGarantiaVO {
    private String tgaActivo;
    private Long tgaCodigo;
    private String tgaDescripciom;
    private String tgaNombre;
    private List<EstudioPrevioVO> EstudioPrevioListVo;

    public TipoGarantiaVO(){
        
    }
    public TipoGarantiaVO(SiiTipoGarantia siiTipoGarantia) {
        this.tgaActivo = siiTipoGarantia.getTgaActivo();
        this.tgaCodigo = siiTipoGarantia.getTgaCodigo();
        this.tgaDescripciom = siiTipoGarantia.getTgaDescripciom();
        this.tgaNombre = siiTipoGarantia.getTgaNombre();
    }

    public void setTgaActivo(String tgaActivo) {
        this.tgaActivo = tgaActivo;
    }

    public String getTgaActivo() {
        return tgaActivo;
    }

    public void setTgaCodigo(Long tgaCodigo) {
        this.tgaCodigo = tgaCodigo;
    }

    public Long getTgaCodigo() {
        return tgaCodigo;
    }

    public void setTgaDescripciom(String tgaDescripciom) {
        this.tgaDescripciom = tgaDescripciom;
    }

    public String getTgaDescripciom() {
        return tgaDescripciom;
    }

    public void setTgaNombre(String tgaNombre) {
        this.tgaNombre = tgaNombre;
    }

    public String getTgaNombre() {
        return tgaNombre;
    }

    public void setEstudioPrevioListVo(List<EstudioPrevioVO> EstudioPrevioListVo) {
        this.EstudioPrevioListVo = EstudioPrevioListVo;
    }

    public List<EstudioPrevioVO> getEstudioPrevioListVo() {
        return EstudioPrevioListVo;
    }
}
