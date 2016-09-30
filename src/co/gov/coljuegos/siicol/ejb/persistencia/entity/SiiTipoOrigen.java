package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_ORIGEN")
public class SiiTipoOrigen implements Serializable {
    private static final long serialVersionUID = 2230001976756657414L;
    private Long torCodigo;
    private String torNombre;
    private List<SiiAcuerdoPago> siiAcuerdoPagoList;

    public SiiTipoOrigen() {
    }

    public SiiTipoOrigen(Long torCodigo, String torNombre) {
        this.torCodigo = torCodigo;
        this.torNombre = torNombre;
    }

    @Id
    @Column(name = "TOR_CODIGO", nullable = false)
    public Long getTorCodigo() {
        return torCodigo;
    }

    public void setTorCodigo(Long torCodigo) {
        this.torCodigo = torCodigo;
    }

    @Column(name = "TOR_NOMBRE", nullable = false, length = 30)
    public String getTorNombre() {
        return torNombre;
    }

    public void setTorNombre(String torNombre) {
        this.torNombre = torNombre;
    }

    @OneToMany(mappedBy = "siiTipoOrigen")
    public List<SiiAcuerdoPago> getSiiAcuerdoPagoList() {
        return siiAcuerdoPagoList;
    }

    public void setSiiAcuerdoPagoList(List<SiiAcuerdoPago> siiAcuerdoPagoList) {
        this.siiAcuerdoPagoList = siiAcuerdoPagoList;
    }

    public SiiAcuerdoPago addSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        getSiiAcuerdoPagoList().add(siiAcuerdoPago);
        siiAcuerdoPago.setSiiTipoOrigen(this);
        return siiAcuerdoPago;
    }

    public SiiAcuerdoPago removeSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        getSiiAcuerdoPagoList().remove(siiAcuerdoPago);
        siiAcuerdoPago.setSiiTipoOrigen(null);
        return siiAcuerdoPago;
    }
}
