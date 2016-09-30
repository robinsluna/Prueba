package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiClaseContrato;

import java.util.List;

public class ClaseContratoVO {
    private Long clcCodigo;
    private String clcNombre;
    private List<ActaIniContratoVO> actaIniContratoListVo;
    
    public ClaseContratoVO() {
        
    }
    public ClaseContratoVO(SiiClaseContrato claseContrato) {
        this.clcCodigo = claseContrato.getClcCodigo();
        this.clcNombre = claseContrato.getClcNombre();
    }

    public void setClcCodigo(Long clcCodigo) {
        this.clcCodigo = clcCodigo;
    }

    public Long getClcCodigo() {
        return clcCodigo;
    }

    public void setClcNombre(String clcNombre) {
        this.clcNombre = clcNombre;
    }

    public String getClcNombre() {
        return clcNombre;
    }

    public void setActaIniContratoListVo(List<ActaIniContratoVO> actaIniContratoListVo) {
        this.actaIniContratoListVo = actaIniContratoListVo;
    }

    public List<ActaIniContratoVO> getActaIniContratoListVo() {
        return actaIniContratoListVo;
    }
}
