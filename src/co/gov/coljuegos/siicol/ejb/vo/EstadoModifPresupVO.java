package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifPresup;

import java.util.List;

public class EstadoModifPresupVO {
    private Long empCodigo;
    private String empNombre;
    private List<ModificPresupVO> modificPresupListVo;

    public EstadoModifPresupVO() {

    }
    
    
    /**
     * Constructor.
     * @param siiEstadoModifPresup
     */
    public EstadoModifPresupVO (SiiEstadoModifPresup siiEstadoModifPresup) {
        if (siiEstadoModifPresup!=null) {
            this.empCodigo = siiEstadoModifPresup.getEmpCodigo();
            this.empNombre = siiEstadoModifPresup.getEmpNombre();
        }
    }
    
    
    public void setEmpCodigo(Long empCodigo) {
        this.empCodigo = empCodigo;
    }

    public Long getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    public String getEmpNombre() {
        return empNombre;
    }

    public void setModificPresupListVo(List<ModificPresupVO> modificPresupListVo) {
        this.modificPresupListVo = modificPresupListVo;
    }

    public List<ModificPresupVO> getModificPresupListVo() {
        return modificPresupListVo;
    }
}
