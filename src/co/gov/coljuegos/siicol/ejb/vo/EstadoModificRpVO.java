package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModificRp;

import java.util.List;

public class EstadoModificRpVO {
    
    private Long emrCodigo;
    private String emrNombre;
    private List<ModificacionRpVO> modificacionRpListVo;

    public EstadoModificRpVO() {
        
    }
    
    public EstadoModificRpVO(SiiEstadoModificRp siiEstadoModificRp) {
        this.emrCodigo = siiEstadoModificRp.getEmrCodigo();
        this.emrNombre = siiEstadoModificRp.getEmrNombre();
    }

    public void setEmrCodigo(Long emrCodigo) {
        this.emrCodigo = emrCodigo;
    }

    public Long getEmrCodigo() {
        return emrCodigo;
    }

    public void setEmrNombre(String emrNombre) {
        this.emrNombre = emrNombre;
    }

    public String getEmrNombre() {
        return emrNombre;
    }

    public void setModificacionRpListVo(List<ModificacionRpVO> modificacionRpListVo) {
        this.modificacionRpListVo = modificacionRpListVo;
    }

    public List<ModificacionRpVO> getModificacionRpListVo() {
        return modificacionRpListVo;
    }
}
