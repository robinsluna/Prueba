package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_ACUERDO_PAGO")
public class SiiEstadoAcuerdoPago implements Serializable {
    private static final long serialVersionUID = 4361048318584336826L;
    private Long eapCodigo;
    private String eapNombre;
    private List<SiiAcuerdoPago> siiAcuerdoPagoList;

    public SiiEstadoAcuerdoPago() {
    }

    public SiiEstadoAcuerdoPago(Long eapCodigo, String eapNombre) {
        this.eapCodigo = eapCodigo;
        this.eapNombre = eapNombre;
    }

    @Id
    @Column(name = "EAP_CODIGO", nullable = false)
    public Long getEapCodigo() {
        return eapCodigo;
    }

    public void setEapCodigo(Long eapCodigo) {
        this.eapCodigo = eapCodigo;
    }

    @Column(name = "EAP_NOMBRE", nullable = false, length = 30)
    public String getEapNombre() {
        return eapNombre;
    }

    public void setEapNombre(String eapNombre) {
        this.eapNombre = eapNombre;
    }

    @OneToMany(mappedBy = "siiEstadoAcuerdoPago")
    public List<SiiAcuerdoPago> getSiiAcuerdoPagoList() {
        return siiAcuerdoPagoList;
    }

    public void setSiiAcuerdoPagoList(List<SiiAcuerdoPago> siiAcuerdoPagoList) {
        this.siiAcuerdoPagoList = siiAcuerdoPagoList;
    }

    public SiiAcuerdoPago addSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        getSiiAcuerdoPagoList().add(siiAcuerdoPago);
        siiAcuerdoPago.setSiiEstadoAcuerdoPago(this);
        return siiAcuerdoPago;
    }

    public SiiAcuerdoPago removeSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        getSiiAcuerdoPagoList().remove(siiAcuerdoPago);
        siiAcuerdoPago.setSiiEstadoAcuerdoPago(null);
        return siiAcuerdoPago;
    }
}
