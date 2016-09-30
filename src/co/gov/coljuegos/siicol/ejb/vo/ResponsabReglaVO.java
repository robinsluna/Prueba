package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReglaImpuestos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabRegla;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResponsabilidadDian;

public class ResponsabReglaVO {
    private Long rreCodigo;
    private ResponsabilidadDianVO responsabilidadDianVo;
    private ReglaImpuestosVO reglaImpuestosVo;
    
    public ResponsabReglaVO() {
    }
    
    public ResponsabReglaVO(SiiResponsabRegla siiResponsabRegla) {
        this.rreCodigo = siiResponsabRegla.getRreCodigo();
        //Padres
        if (siiResponsabRegla.getSiiResponsabilidadDian() != null){
            this.responsabilidadDianVo = new ResponsabilidadDianVO(siiResponsabRegla.getSiiResponsabilidadDian());
        }
        if (siiResponsabRegla.getSiiReglaImpuestos() != null){
            this.reglaImpuestosVo = new ReglaImpuestosVO(siiResponsabRegla.getSiiReglaImpuestos());
        }        
    }


    public void setRreCodigo(Long rreCodigo) {
        this.rreCodigo = rreCodigo;
    }

    public Long getRreCodigo() {
        return rreCodigo;
    }

    public void setResponsabilidadDianVo(ResponsabilidadDianVO responsabilidadDianVo) {
        this.responsabilidadDianVo = responsabilidadDianVo;
    }

    public ResponsabilidadDianVO getResponsabilidadDianVo() {
        return responsabilidadDianVo;
    }

    public void setReglaImpuestosVo(ReglaImpuestosVO reglaImpuestosVo) {
        this.reglaImpuestosVo = reglaImpuestosVo;
    }

    public ReglaImpuestosVO getReglaImpuestosVo() {
        return reglaImpuestosVo;
    }

}
