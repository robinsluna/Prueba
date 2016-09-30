package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoAcuerdoPago;

import java.util.List;

public class EstadoAcuerdoPagoVO {
    private Long eapCodigo;
    private String eapNombre;
    private List<AcuerdoPagoVO> acuerdoPagoList;
    
    public EstadoAcuerdoPagoVO(SiiEstadoAcuerdoPago siiEstadoAcuerdoPago) {  
        this.eapCodigo = siiEstadoAcuerdoPago.getEapCodigo();
        this.eapNombre = siiEstadoAcuerdoPago.getEapNombre();
    }
    public EstadoAcuerdoPagoVO() {        
    }

    public void setEapCodigo(Long eapCodigo) {
        this.eapCodigo = eapCodigo;
    }

    public Long getEapCodigo() {
        return eapCodigo;
    }

    public void setEapNombre(String eapNombre) {
        this.eapNombre = eapNombre;
    }

    public String getEapNombre() {
        return eapNombre;
    }

    public void setAcuerdoPagoList(List<AcuerdoPagoVO> acuerdoPagoList) {
        this.acuerdoPagoList = acuerdoPagoList;
    }

    public List<AcuerdoPagoVO> getAcuerdoPagoList() {
        return acuerdoPagoList;
    }
}
