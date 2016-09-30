package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_CUENTA_CONTABLE")
public class SiiEstadoCuentaContable implements Serializable {
    private static final long serialVersionUID = -6490242314556263350L;
    private Long eccCodigo;
    private String eccNombre;
    private List<SiiCuentasContables> siiCuentasContablesList;

    public SiiEstadoCuentaContable() {
    }

    public SiiEstadoCuentaContable(Long eccCodigo, String eccNombre) {
        this.eccCodigo = eccCodigo;
        this.eccNombre = eccNombre;
    }

    @Id
    @Column(name = "ECC_CODIGO", nullable = false)
    public Long getEccCodigo() {
        return eccCodigo;
    }

    public void setEccCodigo(Long eccCodigo) {
        this.eccCodigo = eccCodigo;
    }

    @Column(name = "ECC_NOMBRE", nullable = false, length = 20)
    public String getEccNombre() {
        return eccNombre;
    }

    public void setEccNombre(String eccNombre) {
        this.eccNombre = eccNombre;
    }

    @OneToMany(mappedBy = "siiEstadoCuentaContable")
    public List<SiiCuentasContables> getSiiCuentasContablesList() {
        return siiCuentasContablesList;
    }

    public void setSiiCuentasContablesList(List<SiiCuentasContables> siiCuentasContablesList) {
        this.siiCuentasContablesList = siiCuentasContablesList;
    }

    public SiiCuentasContables addSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        getSiiCuentasContablesList().add(siiCuentasContables);
        siiCuentasContables.setSiiEstadoCuentaContable(this);
        return siiCuentasContables;
    }

    public SiiCuentasContables removeSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        getSiiCuentasContablesList().remove(siiCuentasContables);
        siiCuentasContables.setSiiEstadoCuentaContable(null);
        return siiCuentasContables;
    }
}
