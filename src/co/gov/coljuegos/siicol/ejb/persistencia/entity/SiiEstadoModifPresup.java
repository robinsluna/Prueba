package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_MODIF_PRESUP")
public class SiiEstadoModifPresup implements Serializable {
    private static final long serialVersionUID = -4762487387302776488L;
    private Long empCodigo;
    private String empNombre;
    private List<SiiModificPresup> siiModificPresupList;

    public SiiEstadoModifPresup() {
    }

    public SiiEstadoModifPresup(Long empCodigo, String empNombre) {
        this.empCodigo = empCodigo;
        this.empNombre = empNombre;
    }

    @Id
    @Column(name = "EMP_CODIGO", nullable = false)
    public Long getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(Long empCodigo) {
        this.empCodigo = empCodigo;
    }

    @Column(name = "EMP_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEmpNombre() {
        return empNombre;
    }

    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    @OneToMany(mappedBy = "siiEstadoModifPresup")
    public List<SiiModificPresup> getSiiModificPresupList() {
        return siiModificPresupList;
    }

    public void setSiiModificPresupList(List<SiiModificPresup> siiModificPresupList) {
        this.siiModificPresupList = siiModificPresupList;
    }

    public SiiModificPresup addSiiModificPresup(SiiModificPresup siiModificPresup) {
        getSiiModificPresupList().add(siiModificPresup);
        siiModificPresup.setSiiEstadoModifPresup(this);
        return siiModificPresup;
    }

    public SiiModificPresup removeSiiModificPresup(SiiModificPresup siiModificPresup) {
        getSiiModificPresupList().remove(siiModificPresup);
        siiModificPresup.setSiiEstadoModifPresup(null);
        return siiModificPresup;
    }
}
