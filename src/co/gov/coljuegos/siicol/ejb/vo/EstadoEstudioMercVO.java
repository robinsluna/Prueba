package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoEstudioMerc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;

import java.util.List;

public class EstadoEstudioMercVO {
    private Long eemCodigo;
    private String eemDescripcion;
    private String eemNombre;
    private List<EstudioMercadoVO> estudioMercadoListVO;
    
    public EstadoEstudioMercVO () {
        
    }

    public EstadoEstudioMercVO(SiiEstadoEstudioMerc estadoEstudioMerc) {
        this.eemCodigo = estadoEstudioMerc.getEemCodigo();
        this.eemDescripcion = estadoEstudioMerc.getEemDescripcion();
        this.eemNombre = estadoEstudioMerc.getEemNombre();
    }
    
    public void setEemCodigo(Long eemCodigo) {
        this.eemCodigo = eemCodigo;
    }

    public Long getEemCodigo() {
        return eemCodigo;
    }

    public void setEemDescripcion(String eemDescripcion) {
        this.eemDescripcion = eemDescripcion;
    }

    public String getEemDescripcion() {
        return eemDescripcion;
    }

    public void setEemNombre(String eemNombre) {
        this.eemNombre = eemNombre;
    }

    public String getEemNombre() {
        return eemNombre;
    }


    public void setEstudioMercadoListVO(List<EstudioMercadoVO> estudioMercadoListVO) {
        this.estudioMercadoListVO = estudioMercadoListVO;
    }

    public List<EstudioMercadoVO> getEstudioMercadoListVO() {
        return estudioMercadoListVO;
    }
    
}
