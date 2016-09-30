package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_DOC_SOP_MODIF")
public class SiiTipoDocSoporteModif implements Serializable {
    private static final long serialVersionUID = 4861367956410545630L;
    private Long tdmCodigo;
    private String tdmNombre;
    private List<SiiDocumSoporModif> siiDocumSoporModifList;

    public SiiTipoDocSoporteModif() {
    }

    public SiiTipoDocSoporteModif(Long tdmCodigo, String tdmNombre) {
        this.tdmCodigo = tdmCodigo;
        this.tdmNombre = tdmNombre;
    }

    @Id
    @Column(name = "TDM_CODIGO", nullable = false)
    public Long getTdmCodigo() {
        return tdmCodigo;
    }

    public void setTdmCodigo(Long tdmCodigo) {
        this.tdmCodigo = tdmCodigo;
    }

    @Column(name = "TDM_NOMBRE", nullable = false, length = 20)
    public String getTdmNombre() {
        return tdmNombre;
    }

    public void setTdmNombre(String tdmNombre) {
        this.tdmNombre = tdmNombre;
    }

    @OneToMany(mappedBy = "siiTipoDocSoporteModif")
    public List<SiiDocumSoporModif> getSiiDocumSoporModifList() {
        return siiDocumSoporModifList;
    }

    public void setSiiDocumSoporModifList(List<SiiDocumSoporModif> siiDocumSoporModifList) {
        this.siiDocumSoporModifList = siiDocumSoporModifList;
    }

    public SiiDocumSoporModif addSiiDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) {
        getSiiDocumSoporModifList().add(siiDocumSoporModif);
        siiDocumSoporModif.setSiiTipoDocSoporteModif(this);
        return siiDocumSoporModif;
    }

    public SiiDocumSoporModif removeSiiDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) {
        getSiiDocumSoporModifList().remove(siiDocumSoporModif);
        siiDocumSoporModif.setSiiTipoDocSoporteModif(null);
        return siiDocumSoporModif;
    }
}
