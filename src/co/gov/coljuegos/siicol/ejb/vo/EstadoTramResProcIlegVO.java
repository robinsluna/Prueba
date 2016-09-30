package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResProcIleg;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;

import java.util.List;

public class EstadoTramResProcIlegVO  implements Comparable {
    private Long etrCodigo;
    private String etrNombre;
    private Integer etrOrden;
    
    private List<SiiTramiteResolProIle> siiTramiteResolProIleList;
    
    public EstadoTramResProcIlegVO() {
    }
    
    public EstadoTramResProcIlegVO(SiiEstadoTramResProcIleg siiEstadoTramResProcIleg) {
        if (siiEstadoTramResProcIleg!=null) {
            this.etrCodigo = siiEstadoTramResProcIleg.getEtrCodigo();
            this.etrNombre = siiEstadoTramResProcIleg.getEtrNombre();
            this.etrOrden = siiEstadoTramResProcIleg.getEtrOrden();
        }
    }

    public void setEtrCodigo(Long etrCodigo) {
        this.etrCodigo = etrCodigo;
    }

    public Long getEtrCodigo() {
        return etrCodigo;
    }

    public void setEtrNombre(String etrNombre) {
        this.etrNombre = etrNombre;
    }

    public String getEtrNombre() {
        return etrNombre;
    }

    public void setSiiTramiteResolProIleList(List<SiiTramiteResolProIle> siiTramiteResolProIleList) {
        this.siiTramiteResolProIleList = siiTramiteResolProIleList;
    }

    public List<SiiTramiteResolProIle> getSiiTramiteResolProIleList() {
        return siiTramiteResolProIleList;
    }

    public void setEtrOrden(Integer etrOrden) {
        this.etrOrden = etrOrden;
    }

    public Integer getEtrOrden() {
        return etrOrden;
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof EstadoTramResProcIlegVO) {
            EstadoTramResProcIlegVO estado = (EstadoTramResProcIlegVO) o;
            if (this.etrOrden!=null && estado!=null && estado.etrOrden!=null) {
                // comparar los estados por medio de la columna de ordenamiento de los mismos.
                resultado = this.etrOrden.compareTo(estado.etrOrden);
            }
        }
        
        return (resultado);
    }
}
