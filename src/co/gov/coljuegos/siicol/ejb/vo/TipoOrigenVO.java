package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAcuerdoPago;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoOrigen;

import java.util.List;

public class TipoOrigenVO {
    private Long torCodigo;
    private String torNombre;
    private List<AcuerdoPagoVO> acuerdoPagoList;
   
    public TipoOrigenVO(SiiTipoOrigen siiTipoOrigen) {
         this.torCodigo = siiTipoOrigen.getTorCodigo();
         this.torNombre = siiTipoOrigen.getTorNombre();
     }
   
   public TipoOrigenVO() {        
    }

    public void setTorCodigo(Long torCodigo) {
        this.torCodigo = torCodigo;
    }

    public Long getTorCodigo() {
        return torCodigo;
    }

    public void setTorNombre(String torNombre) {
        this.torNombre = torNombre;
    }

    public String getTorNombre() {
        return torNombre;
    }

    public void setAcuerdoPagoList(List<AcuerdoPagoVO> acuerdoPagoList) {
        this.acuerdoPagoList = acuerdoPagoList;
    }

    public List<AcuerdoPagoVO> getAcuerdoPagoList() {
        return acuerdoPagoList;
    }
}
