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
@Table(name = "SII_RESULTADO_VERIF_DENUN")
public class SiiResultadoVerifDenun implements Serializable {
    private static final long serialVersionUID = 7443730913745270068L;
    private Long revCodigo;
    private String revNombre;
    private List<SiiDenuncia> siiDenunciaList;

    public SiiResultadoVerifDenun() {
    }

    public SiiResultadoVerifDenun(Long revCodigo, String revNombre) {
        this.revCodigo = revCodigo;
        this.revNombre = revNombre;
    }

    @Id
    @Column(name = "REV_CODIGO", nullable = false)
    public Long getRevCodigo() {
        return revCodigo;
    }

    public void setRevCodigo(Long revCodigo) {
        this.revCodigo = revCodigo;
    }

    @Column(name = "REV_NOMBRE", nullable = false, length = 40)
    public String getRevNombre() {
        return revNombre;
    }

    public void setRevNombre(String revNombre) {
        this.revNombre = revNombre;
    }

    @OneToMany(mappedBy = "siiResultadoVerifDenun")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().add(siiDenuncia);
        siiDenuncia.setSiiResultadoVerifDenun(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().remove(siiDenuncia);
        siiDenuncia.setSiiResultadoVerifDenun(null);
        return siiDenuncia;
    }
}
