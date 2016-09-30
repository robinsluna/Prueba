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
@Table(name = "SII_TIPO_DOC_SOP_SOLIC_PAGO")
public class SiiTipoDocSopSolicPago implements Serializable {
    private static final long serialVersionUID = -1170195792154082678L;
    private Long tspCodigo;
    private String tspCombre;
    private List<SiiSolicitudPago> siiSolicitudPagoList;
    private List<SiiOrdenPago> siiOrdenPagoList;

    public SiiTipoDocSopSolicPago() {
    }

    public SiiTipoDocSopSolicPago(Long tspCodigo, String tspCombre) {
        this.tspCodigo = tspCodigo;
        this.tspCombre = tspCombre;
    }

    @Id
    @Column(name = "TSP_CODIGO", nullable = false)
    public Long getTspCodigo() {
        return tspCodigo;
    }

    public void setTspCodigo(Long tspCodigo) {
        this.tspCodigo = tspCodigo;
    }

    @Column(name = "TSP_COMBRE", nullable = false, length = 50)
    public String getTspCombre() {
        return tspCombre;
    }

    public void setTspCombre(String tspCombre) {
        this.tspCombre = tspCombre;
    }

    @OneToMany(mappedBy = "siiTipoDocSopSolicPago")
    public List<SiiSolicitudPago> getSiiSolicitudPagoList() {
        return siiSolicitudPagoList;
    }

    public void setSiiSolicitudPagoList(List<SiiSolicitudPago> siiSolicitudPagoList) {
        this.siiSolicitudPagoList = siiSolicitudPagoList;
    }

    public SiiSolicitudPago addSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList().add(siiSolicitudPago);
        siiSolicitudPago.setSiiTipoDocSopSolicPago(this);
        return siiSolicitudPago;
    }

    public SiiSolicitudPago removeSiiSolicitudPago(SiiSolicitudPago siiSolicitudPago) {
        getSiiSolicitudPagoList().remove(siiSolicitudPago);
        siiSolicitudPago.setSiiTipoDocSopSolicPago(null);
        return siiSolicitudPago;
    }

    @OneToMany(mappedBy = "siiTipoDocSopSolicPago")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiTipoDocSopSolicPago(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiTipoDocSopSolicPago(null);
        return siiOrdenPago;
    }
}
