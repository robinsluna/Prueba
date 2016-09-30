package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoObligacion;

public class EstadoObligacionVO {
    
    private Long eobCodigo;
    private String eobNombre;
    
    
    public EstadoObligacionVO() {
        
    }

    public EstadoObligacionVO(SiiEstadoObligacion siiEstadoObligacion) {
        this.eobCodigo = siiEstadoObligacion.getEobCodigo();
        this.eobNombre = siiEstadoObligacion.getEobNombre();
    }

    public void setEobCodigo(Long eobCodigo) {
        this.eobCodigo = eobCodigo;
    }

    public Long getEobCodigo() {
        return eobCodigo;
    }

    public void setEobNombre(String eobNombre) {
        this.eobNombre = eobNombre;
    }

    public String getEobNombre() {
        return eobNombre;
    }

}
