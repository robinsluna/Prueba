package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoModifCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificacionCdp;

import java.util.List;

public class EstadoModifCdpVO {
    private String emcActivo;
    private Long emcCodigo;
    private String emcDescripcion;
    private String emcNombre;
    private List<SiiModificacionCdp> siiModificacionCdpList;
    
    public EstadoModifCdpVO(SiiEstadoModifCdp siiEstadoModifCdp) {
        this.emcActivo = siiEstadoModifCdp.getEmcActivo();
        this.emcCodigo = siiEstadoModifCdp.getEmcCodigo();
        this.emcDescripcion = siiEstadoModifCdp.getEmcDescripcion();
        this.emcNombre = siiEstadoModifCdp.getEmcNombre();
        }

    public EstadoModifCdpVO() {
    }

    public void setEmcActivo(String emcActivo) {
        this.emcActivo = emcActivo;
    }

    public String getEmcActivo() {
        return emcActivo;
    }

    public void setEmcCodigo(Long emcCodigo) {
        this.emcCodigo = emcCodigo;
    }

    public Long getEmcCodigo() {
        return emcCodigo;
    }

    public void setEmcDescripcion(String emcDescripcion) {
        this.emcDescripcion = emcDescripcion;
    }

    public String getEmcDescripcion() {
        return emcDescripcion;
    }

    public void setEmcNombre(String emcNombre) {
        this.emcNombre = emcNombre;
    }

    public String getEmcNombre() {
        return emcNombre;
    }

    public void setSiiModificacionCdpList(List<SiiModificacionCdp> siiModificacionCdpList) {
        this.siiModificacionCdpList = siiModificacionCdpList;
    }

    public List<SiiModificacionCdp> getSiiModificacionCdpList() {
        return siiModificacionCdpList;
    }
}
