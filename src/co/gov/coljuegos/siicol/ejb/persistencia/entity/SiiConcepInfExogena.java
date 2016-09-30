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
@Table(name = "SII_CONCEP_INF_EXOGENA")
public class SiiConcepInfExogena implements Serializable {
    private static final long serialVersionUID = -4846445091091398834L;
    private Long cieCodigo;
    private String cieNombre;
    private List<SiiImputacionContable> siiImputacionContableList;

    public SiiConcepInfExogena() {
    }

    public SiiConcepInfExogena(Long cieCodigo, String cieNombre) {
        this.cieCodigo = cieCodigo;
        this.cieNombre = cieNombre;
    }

    @Id
    @Column(name = "CIE_CODIGO", nullable = false)
    public Long getCieCodigo() {
        return cieCodigo;
    }

    public void setCieCodigo(Long cieCodigo) {
        this.cieCodigo = cieCodigo;
    }

    @Column(name = "CIE_NOMBRE", nullable = false, length = 300)
    public String getCieNombre() {
        return cieNombre;
    }

    public void setCieNombre(String cieNombre) {
        this.cieNombre = cieNombre;
    }

    @OneToMany(mappedBy = "siiConcepInfExogena")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiConcepInfExogena(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiConcepInfExogena(null);
        return siiImputacionContable;
    }
}
