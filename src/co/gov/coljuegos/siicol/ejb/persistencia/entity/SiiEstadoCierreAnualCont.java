package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_CIERRE_AN_CONT")
public class SiiEstadoCierreAnualCont implements Serializable {
    private static final long serialVersionUID = 2670522617112512243L;
    private Long ecaCodigo;
    private String ecaNombre;
    private List<SiiCierreAnualContable> siiCierreAnualContableList;

    public SiiEstadoCierreAnualCont() {
    }

    public SiiEstadoCierreAnualCont(Long ecaCodigo, String ecaNombre) {
        this.ecaCodigo = ecaCodigo;
        this.ecaNombre = ecaNombre;
    }

    @Id
    @Column(name = "ECA_CODIGO", nullable = false)
    public Long getEcaCodigo() {
        return ecaCodigo;
    }

    public void setEcaCodigo(Long ecaCodigo) {
        this.ecaCodigo = ecaCodigo;
    }

    @Column(name = "ECA_NOMBRE", nullable = false, length = 20)
    public String getEcaNombre() {
        return ecaNombre;
    }

    public void setEcaNombre(String ecaNombre) {
        this.ecaNombre = ecaNombre;
    }

    @OneToMany(mappedBy = "siiEstadoCierreAnualCont")
    public List<SiiCierreAnualContable> getSiiCierreAnualContableList() {
        return siiCierreAnualContableList;
    }

    public void setSiiCierreAnualContableList(List<SiiCierreAnualContable> siiCierreAnualContableList) {
        this.siiCierreAnualContableList = siiCierreAnualContableList;
    }

    public SiiCierreAnualContable addSiiCierreAnualContable(SiiCierreAnualContable siiCierreAnualContable) {
        getSiiCierreAnualContableList().add(siiCierreAnualContable);
        siiCierreAnualContable.setSiiEstadoCierreAnualCont(this);
        return siiCierreAnualContable;
    }

    public SiiCierreAnualContable removeSiiCierreAnualContable(SiiCierreAnualContable siiCierreAnualContable) {
        getSiiCierreAnualContableList().remove(siiCierreAnualContable);
        siiCierreAnualContable.setSiiEstadoCierreAnualCont(null);
        return siiCierreAnualContable;
    }
}
