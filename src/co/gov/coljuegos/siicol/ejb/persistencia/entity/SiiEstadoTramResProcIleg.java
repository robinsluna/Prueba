package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_TRAM_RES_PROC_ILEG")
public class SiiEstadoTramResProcIleg implements Serializable {
    private static final long serialVersionUID = 6671073983111870050L;
    private Long etrCodigo;
    private String etrNombre;
    private List<SiiTramiteResolProIle> siiTramiteResolProIleList;
    private Integer etrOrden;

    public SiiEstadoTramResProcIleg() {
    }

    public SiiEstadoTramResProcIleg(Long etrCodigo, String etrNombre) {
        this.etrCodigo = etrCodigo;
        this.etrNombre = etrNombre;
    }

    @Id
    @Column(name = "ETR_CODIGO", nullable = false)
    public Long getEtrCodigo() {
        return etrCodigo;
    }

    public void setEtrCodigo(Long etrCodigo) {
        this.etrCodigo = etrCodigo;
    }

    @Column(name = "ETR_NOMBRE", nullable = false, length = 30)
    public String getEtrNombre() {
        return etrNombre;
    }

    public void setEtrNombre(String etrNombre) {
        this.etrNombre = etrNombre;
    }

    @OneToMany(mappedBy = "siiEstadoTramResProcIleg")
    public List<SiiTramiteResolProIle> getSiiTramiteResolProIleList() {
        return siiTramiteResolProIleList;
    }

    public void setSiiTramiteResolProIleList(List<SiiTramiteResolProIle> siiTramiteResolProIleList) {
        this.siiTramiteResolProIleList = siiTramiteResolProIleList;
    }

    public SiiTramiteResolProIle addSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleList().add(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiEstadoTramResProcIleg(this);
        return siiTramiteResolProIle;
    }

    public SiiTramiteResolProIle removeSiiTramiteResolProIle(SiiTramiteResolProIle siiTramiteResolProIle) {
        getSiiTramiteResolProIleList().remove(siiTramiteResolProIle);
        siiTramiteResolProIle.setSiiEstadoTramResProcIleg(null);
        return siiTramiteResolProIle;
    }

    @Column(name = "ETR_ORDEN", nullable = false)
    public Integer getEtrOrden() {
        return etrOrden;
    }

    public void setEtrOrden(Integer etrOrden) {
        this.etrOrden = etrOrden;
    }
}
