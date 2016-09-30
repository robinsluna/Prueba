package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import java.util.List;

public class EstadoProcContratVO {

    private static final long serialVersionUID = -4159859396864687602L;
    private Long epcCodigo;
    private String epcDescripcion;
    private String epcNombre;
    private List<ProcesoContratacionVO> procesoContratacionListVo;

    public EstadoProcContratVO(SiiEstadoProcContrat estadoProcContrat){
        this.epcCodigo = estadoProcContrat.getEpcCodigo();
        this.epcDescripcion = estadoProcContrat.getEpcDescripcion();
        this.epcNombre = estadoProcContrat.getEpcNombre();
    } 
    public EstadoProcContratVO(){
    }
    
    public void setEpcCodigo(Long epcCodigo) {
        this.epcCodigo = epcCodigo;
    }

    public Long getEpcCodigo() {
        return epcCodigo;
    }

    public void setEpcDescripcion(String epcDescripcion) {
        this.epcDescripcion = epcDescripcion;
    }

    public String getEpcDescripcion() {
        return epcDescripcion;
    }

    public void setEpcNombre(String epcNombre) {
        this.epcNombre = epcNombre;
    }

    public String getEpcNombre() {
        return epcNombre;
    }

    public void setProcesoContratacionListVo(List<ProcesoContratacionVO> procesoContratacionListVo) {
        this.procesoContratacionListVo = procesoContratacionListVo;
    }

    public List<ProcesoContratacionVO> getProcesoContratacionListVo() {
        return procesoContratacionListVo;
    }

  
}
