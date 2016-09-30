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
@Table(name = "SII_MEDIO_PAGO")
public class SiiMedioPago implements Serializable {
    private static final long serialVersionUID = 7709992413493652869L;
    private Long mepCodigo;
    private String mepNombre;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;

    public SiiMedioPago() {
    }

    public SiiMedioPago(Long mepCodigo, String mepNombre) {
        this.mepCodigo = mepCodigo;
        this.mepNombre = mepNombre;
    }

    @Id
    @Column(name = "MEP_CODIGO", nullable = false)
    public Long getMepCodigo() {
        return mepCodigo;
    }

    public void setMepCodigo(Long mepCodigo) {
        this.mepCodigo = mepCodigo;
    }

    @Column(name = "MEP_NOMBRE", nullable = false, length = 30)
    public String getMepNombre() {
        return mepNombre;
    }

    public void setMepNombre(String mepNombre) {
        this.mepNombre = mepNombre;
    }

    @OneToMany(mappedBy = "siiMedioPago")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiMedioPago(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiMedioPago(null);
        return siiDetalleRecaudo;
    }
}
