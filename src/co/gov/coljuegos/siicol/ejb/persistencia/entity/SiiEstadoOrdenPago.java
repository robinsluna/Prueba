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
@Table(name = "SII_ESTADO_ORDEN_PAGO")
public class SiiEstadoOrdenPago implements Serializable {
    private static final long serialVersionUID = -5318145461844619749L;
    private Long eopCodigo;
    private String eopNombre;
    private List<SiiOrdenPago> siiOrdenPagoList;

    public SiiEstadoOrdenPago() {
    }

    public SiiEstadoOrdenPago(Long eopCodigo, String eopNombre) {
        this.eopCodigo = eopCodigo;
        this.eopNombre = eopNombre;
    }

    @Id
    @Column(name = "EOP_CODIGO", nullable = false)
    public Long getEopCodigo() {
        return eopCodigo;
    }

    public void setEopCodigo(Long eopCodigo) {
        this.eopCodigo = eopCodigo;
    }

    @Column(name = "EOP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEopNombre() {
        return eopNombre;
    }

    public void setEopNombre(String eopNombre) {
        this.eopNombre = eopNombre;
    }

    @OneToMany(mappedBy = "siiEstadoOrdenPago")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiEstadoOrdenPago(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiEstadoOrdenPago(null);
        return siiOrdenPago;
    }
}
