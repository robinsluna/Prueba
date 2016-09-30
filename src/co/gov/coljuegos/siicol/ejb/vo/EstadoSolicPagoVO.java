package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoSolicPago;


public class EstadoSolicPagoVO {
   
    private Long esoCodigo;
    private String esoNombre;
    

    public EstadoSolicPagoVO() {
        
    }

    public EstadoSolicPagoVO(SiiEstadoSolicPago estado) {
        if (estado!=null) {
            this.esoCodigo = estado.getEsoCodigo();
            this.esoNombre = estado.getEsoNombre();
        }
    }

    public EstadoSolicPagoVO(Long esoCodigo, String esoNombre) {
        this.esoCodigo = esoCodigo;
        this.esoNombre = esoNombre;
    }


    public void setEsoCodigo(Long esoCodigo) {
        this.esoCodigo = esoCodigo;
    }

    public Long getEsoCodigo() {
        return esoCodigo;
    }

    public void setEsoNombre(String esoNombre) {
        this.esoNombre = esoNombre;
    }

    public String getEsoNombre() {
        return esoNombre;
    }


}
