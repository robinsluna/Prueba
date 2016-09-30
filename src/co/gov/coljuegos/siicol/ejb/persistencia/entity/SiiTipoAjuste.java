package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_AJUSTE")
public class SiiTipoAjuste implements Serializable {
    private Long tajCodigo;
    private String tajNombre;
    private List<SiiAjuste> siiAjusteList;

    public SiiTipoAjuste() {
    }

    public SiiTipoAjuste(Long tajCodigo, String tajNombre) {
        this.tajCodigo = tajCodigo;
        this.tajNombre = tajNombre;
    }

    @Id
    @Column(name = "TAJ_CODIGO", nullable = false)
    public Long getTajCodigo() {
        return tajCodigo;
    }

    public void setTajCodigo(Long tajCodigo) {
        this.tajCodigo = tajCodigo;
    }

    @Column(name = "TAJ_NOMBRE", nullable = false, length = 80)
    public String getTajNombre() {
        return tajNombre;
    }

    public void setTajNombre(String tajNombre) {
        this.tajNombre = tajNombre;
    }

    @OneToMany(mappedBy = "siiTipoAjuste")
    public List<SiiAjuste> getSiiAjusteList() {
        return siiAjusteList;
    }

    public void setSiiAjusteList(List<SiiAjuste> siiAjusteList) {
        this.siiAjusteList = siiAjusteList;
    }

    public SiiAjuste addSiiAjuste(SiiAjuste siiAjuste) {
        getSiiAjusteList().add(siiAjuste);
        siiAjuste.setSiiTipoAjuste(this);
        return siiAjuste;
    }

    public SiiAjuste removeSiiAjuste(SiiAjuste siiAjuste) {
        getSiiAjusteList().remove(siiAjuste);
        siiAjuste.setSiiTipoAjuste(null);
        return siiAjuste;
    }
}
