package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcSanIleg;

import java.util.List;

public class EstadoProcSanIlegVO {
    private Long epiCodigo;
    private String epiNombre;
    private List<ProcesoSancIlegalidadVO> procesoSancIlegalidadListVo;
    
    public EstadoProcSanIlegVO() {
    }

    public EstadoProcSanIlegVO(SiiEstadoProcSanIleg siiEstadoProcSanIleg) {
        this.epiCodigo = siiEstadoProcSanIleg.getEpiCodigo();
        this.epiNombre = siiEstadoProcSanIleg.getEpiNombre();
    }

    public void setEpiCodigo(Long epiCodigo) {
        this.epiCodigo = epiCodigo;
    }

    public Long getEpiCodigo() {
        return epiCodigo;
    }

    public void setEpiNombre(String epiNombre) {
        this.epiNombre = epiNombre;
    }

    public String getEpiNombre() {
        return epiNombre;
    }

    public void setProcesoSancIlegalidadListVo(List<ProcesoSancIlegalidadVO> procesoSancIlegalidadListVo) {
        this.procesoSancIlegalidadListVo = procesoSancIlegalidadListVo;
    }

    public List<ProcesoSancIlegalidadVO> getProcesoSancIlegalidadListVo() {
        return procesoSancIlegalidadListVo;
    }
}
