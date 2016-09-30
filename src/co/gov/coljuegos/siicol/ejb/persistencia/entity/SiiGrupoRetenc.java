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
@Table(name = "SII_GRUPO_RETENC")
public class SiiGrupoRetenc implements Serializable {
    private static final long serialVersionUID = 5749330758737136148L;
    private Long greCodigo;
    private String greNombre;
    private List<SiiTipoRetencion> siiTipoRetencionList;
    private List<SiiReglaImpuestos> siiReglaImpuestosList;

    public SiiGrupoRetenc() {
    }

    public SiiGrupoRetenc(Long greCodigo, String greNombre) {
        this.greCodigo = greCodigo;
        this.greNombre = greNombre;
    }

    @Id
    @Column(name = "GRE_CODIGO", nullable = false)
    public Long getGreCodigo() {
        return greCodigo;
    }

    public void setGreCodigo(Long greCodigo) {
        this.greCodigo = greCodigo;
    }

    @Column(name = "GRE_NOMBRE", nullable = false, length = 50)
    public String getGreNombre() {
        return greNombre;
    }

    public void setGreNombre(String greNombre) {
        this.greNombre = greNombre;
    }

    @OneToMany(mappedBy = "siiGrupoRetenc")
    public List<SiiTipoRetencion> getSiiTipoRetencionList() {
        return siiTipoRetencionList;
    }

    public void setSiiTipoRetencionList(List<SiiTipoRetencion> siiTipoRetencionList) {
        this.siiTipoRetencionList = siiTipoRetencionList;
    }

    public SiiTipoRetencion addSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().add(siiTipoRetencion);
        siiTipoRetencion.setSiiGrupoRetenc(this);
        return siiTipoRetencion;
    }

    public SiiTipoRetencion removeSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().remove(siiTipoRetencion);
        siiTipoRetencion.setSiiGrupoRetenc(null);
        return siiTipoRetencion;
    }

    @OneToMany(mappedBy = "siiGrupoRetenc")
    public List<SiiReglaImpuestos> getSiiReglaImpuestosList() {
        return siiReglaImpuestosList;
    }

    public void setSiiReglaImpuestosList(List<SiiReglaImpuestos> siiReglaImpuestosList) {
        this.siiReglaImpuestosList = siiReglaImpuestosList;
    }

    public SiiReglaImpuestos addSiiReglaImpuestos(SiiReglaImpuestos siiReglaImpuestos) {
        getSiiReglaImpuestosList().add(siiReglaImpuestos);
        siiReglaImpuestos.setSiiGrupoRetenc(this);
        return siiReglaImpuestos;
    }

    public SiiReglaImpuestos removeSiiReglaImpuestos(SiiReglaImpuestos siiReglaImpuestos) {
        getSiiReglaImpuestosList().remove(siiReglaImpuestos);
        siiReglaImpuestos.setSiiGrupoRetenc(null);
        return siiReglaImpuestos;
    }
}
