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
@Table(name = "SII_MEDIO_DENUNCIA")
public class SiiMedioDenuncia implements Serializable {
    private static final long serialVersionUID = -6014097221804287264L;
    private Long medCodigo;
    private String medNombre;
    private List<SiiDenuncia> siiDenunciaList;

    public SiiMedioDenuncia() {
    }

    public SiiMedioDenuncia(Long medCodigo, String medNombre) {
        this.medCodigo = medCodigo;
        this.medNombre = medNombre;
    }

    @Id
    @Column(name = "MED_CODIGO", nullable = false)
    public Long getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(Long medCodigo) {
        this.medCodigo = medCodigo;
    }

    @Column(name = "MED_NOMBRE", nullable = false, length = 30)
    public String getMedNombre() {
        return medNombre;
    }

    public void setMedNombre(String medNombre) {
        this.medNombre = medNombre;
    }

    @OneToMany(mappedBy = "siiMedioDenuncia")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().add(siiDenuncia);
        siiDenuncia.setSiiMedioDenuncia(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().remove(siiDenuncia);
        siiDenuncia.setSiiMedioDenuncia(null);
        return siiDenuncia;
    }
}
