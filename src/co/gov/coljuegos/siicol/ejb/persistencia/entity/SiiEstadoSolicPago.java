package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_SOLIC_PAGO")
public class SiiEstadoSolicPago implements Serializable {
    private static final long serialVersionUID = -8355905191598505687L;
    private Long esoCodigo;
    private String esoNombre;
    private List<SiiSolicitudPago> siiSolicitudPagoList1;

    public SiiEstadoSolicPago() {
    }

    public SiiEstadoSolicPago(Long esoCodigo, String esoNombre) {
        this.esoCodigo = esoCodigo;
        this.esoNombre = esoNombre;
    }

    @Id
    @Column(name = "ESO_CODIGO", nullable = false)
    public Long getEsoCodigo() {
        return esoCodigo;
    }

    public void setEsoCodigo(Long esoCodigo) {
        this.esoCodigo = esoCodigo;
    }

    @Column(name = "ESO_NOMBRE", nullable = false, length = 30, insertable=false, updatable = false)
    public String getEsoNombre() {
        return esoNombre;
    }

    public void setEsoNombre(String esoNombre) {
        this.esoNombre = esoNombre;
    }

    @OneToMany(mappedBy = "siiEstadoSolicPago")
    public List<SiiSolicitudPago> getSiiSolicitudPagoList1() {
        return siiSolicitudPagoList1;
    }

    public void setSiiSolicitudPagoList1(List<SiiSolicitudPago> siiSolicitudPagoList1) {
        this.siiSolicitudPagoList1 = siiSolicitudPagoList1;
    }

    public SiiSolicitudPago addSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList1().add(siiSolicitudPago);
        siiSolicitudPago.setSiiEstadoSolicPago(this);
        return siiSolicitudPago;
    }

    public SiiSolicitudPago removeSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList1().remove(siiSolicitudPago);
        siiSolicitudPago.setSiiEstadoSolicPago(null);
        return siiSolicitudPago;
    }
}
