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
@Table(name = "SII_MOTIVO_DEVOLUCION")
public class SiiMotivoDevolucion implements Serializable {
    private static final long serialVersionUID = -7712392619848933729L;
    private Long mdeCodigo;
    private String mdeNombre;
    private List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList;

    public SiiMotivoDevolucion() {
    }

    public SiiMotivoDevolucion(Long mdeCodigo, String mdeNombre) {
        this.mdeCodigo = mdeCodigo;
        this.mdeNombre = mdeNombre;
    }

    @Id
    @Column(name = "MDE_CODIGO", nullable = false)
    public Long getMdeCodigo() {
        return mdeCodigo;
    }

    public void setMdeCodigo(Long mdeCodigo) {
        this.mdeCodigo = mdeCodigo;
    }

    @Column(name = "MDE_NOMBRE", nullable = false, length = 150)
    public String getMdeNombre() {
        return mdeNombre;
    }

    public void setMdeNombre(String mdeNombre) {
        this.mdeNombre = mdeNombre;
    }

    @OneToMany(mappedBy = "siiMotivoDevolucion")
    public List<SiiSolicitudEstMercado> getSiiSolicitudEstMercadoList() {
        return siiSolicitudEstMercadoList;
    }

    public void setSiiSolicitudEstMercadoList(List<SiiSolicitudEstMercado> siiSolicitudEstMercadoList) {
        this.siiSolicitudEstMercadoList = siiSolicitudEstMercadoList;
    }

    public SiiSolicitudEstMercado addSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().add(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiMotivoDevolucion(this);
        return siiSolicitudEstMercado;
    }

    public SiiSolicitudEstMercado removeSiiSolicitudEstMercado(SiiSolicitudEstMercado siiSolicitudEstMercado) {
        getSiiSolicitudEstMercadoList().remove(siiSolicitudEstMercado);
        siiSolicitudEstMercado.setSiiMotivoDevolucion(null);
        return siiSolicitudEstMercado;
    }
}
