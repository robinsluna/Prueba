package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOrdenPago;

public class EstadoOrdenPagoVO {
    private Long eopCodigo;
    private String eopNombre;
    
    
    /**
     * Constructor.
     */
    public EstadoOrdenPagoVO() { }
    
    
    /**
     * Constructor.
     * @param siiEstadoOrdenPago
     */
    public EstadoOrdenPagoVO (SiiEstadoOrdenPago siiEstadoOrdenPago) {
        if (siiEstadoOrdenPago!=null) {
            this.eopCodigo = siiEstadoOrdenPago.getEopCodigo();
            this.eopNombre = siiEstadoOrdenPago.getEopNombre();
        }
    }


    public void setEopCodigo(Long eopCodigo) {
        this.eopCodigo = eopCodigo;
    }

    public Long getEopCodigo() {
        return eopCodigo;
    }

    public void setEopNombre(String eopNombre) {
        this.eopNombre = eopNombre;
    }

    public String getEopNombre() {
        return eopNombre;
    }
}
