package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstPrev;

import java.util.List;

public class EstadoEstPrevVO {
    private Long eepCodigo;
    private String eepDescripcion;
    private String eepNombre;
    private List<EstudioPrevioVO> estudioPrevioListVo;
    
    public EstadoEstPrevVO(SiiEstadoEstPrev siiEstadoEstPrev) {
        this.eepCodigo = siiEstadoEstPrev.getEepCodigo();
        this.eepDescripcion = siiEstadoEstPrev.getEepDescripcion();
        this.eepNombre = siiEstadoEstPrev.getEepNombre();
    }
    
    public EstadoEstPrevVO(){
        
    }

    public void setEepCodigo(Long eepCodigo) {
        this.eepCodigo = eepCodigo;
    }

    public Long getEepCodigo() {
        return eepCodigo;
    }

    public void setEepDescripcion(String eepDescripcion) {
        this.eepDescripcion = eepDescripcion;
    }

    public String getEepDescripcion() {
        return eepDescripcion;
    }

    public void setEepNombre(String eepNombre) {
        this.eepNombre = eepNombre;
    }

    public String getEepNombre() {
        return eepNombre;
    }

    public void setEstudioPrevioListVo(List<EstudioPrevioVO> estudioPrevioListVo) {
        this.estudioPrevioListVo = estudioPrevioListVo;
    }

    public List<EstudioPrevioVO> getEstudioPrevioListVo() {
        return estudioPrevioListVo;
    }
}
