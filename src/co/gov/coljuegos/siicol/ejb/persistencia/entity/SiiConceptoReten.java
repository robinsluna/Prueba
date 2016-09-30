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
@Table(name = "SII_CONCEPTO_RETEN")
public class SiiConceptoReten implements Serializable {
    private static final long serialVersionUID = -5956604957337208157L;
    private Long creCodigo;
    private String creNombre;
    private List<SiiTipoRetencion> siiTipoRetencionList;

    public SiiConceptoReten() {
    }

    public SiiConceptoReten(Long creCodigo, String creNombre) {
        this.creCodigo = creCodigo;
        this.creNombre = creNombre;
    }

    @Id
    @Column(name = "CRE_CODIGO", nullable = false)
    public Long getCreCodigo() {
        return creCodigo;
    }

    public void setCreCodigo(Long creCodigo) {
        this.creCodigo = creCodigo;
    }

    @Column(name = "CRE_NOMBRE", nullable = false, length = 60)
    public String getCreNombre() {
        return creNombre;
    }

    public void setCreNombre(String creNombre) {
        this.creNombre = creNombre;
    }

    @OneToMany(mappedBy = "siiConceptoReten")
    public List<SiiTipoRetencion> getSiiTipoRetencionList() {
        return siiTipoRetencionList;
    }

    public void setSiiTipoRetencionList(List<SiiTipoRetencion> siiTipoRetencionList) {
        this.siiTipoRetencionList = siiTipoRetencionList;
    }

    public SiiTipoRetencion addSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().add(siiTipoRetencion);
        siiTipoRetencion.setSiiConceptoReten(this);
        return siiTipoRetencion;
    }

    public SiiTipoRetencion removeSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().remove(siiTipoRetencion);
        siiTipoRetencion.setSiiConceptoReten(null);
        return siiTipoRetencion;
    }
}
