package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

@Entity
@Table(name = "SII_RESPONSABILIDAD_DIAN")
@PrimaryKey(validation=IdValidation.NULL)
public class SiiResponsabilidadDian implements Serializable {
    private static final long serialVersionUID = -3322853414270767062L;
    private Long rdiCodigo;
    private String rdiNombre;
    private List<SiiResponDianPersona> siiResponDianPersonaList;

    public SiiResponsabilidadDian() {
    }

    public SiiResponsabilidadDian(Long rdiCodigo, String rdiNombre) {
        this.rdiCodigo = rdiCodigo;
        this.rdiNombre = rdiNombre;
    }

    @Id
    @Column(name = "RDI_CODIGO", nullable = false)
    public Long getRdiCodigo() {
        return rdiCodigo;
    }

    public void setRdiCodigo(Long rdiCodigo) {
        this.rdiCodigo = rdiCodigo;
    }

    @Column(name = "RDI_NOMBRE", nullable = false, length = 100)
    public String getRdiNombre() {
        return rdiNombre;
    }

    public void setRdiNombre(String rdiNombre) {
        this.rdiNombre = rdiNombre;
    }


    @OneToMany(mappedBy = "siiResponsabilidadDian")
    public List<SiiResponDianPersona> getSiiResponDianPersonaList() {
        return siiResponDianPersonaList;
    }

    public void setSiiResponDianPersonaList(List<SiiResponDianPersona> siiResponDianPersonaList) {
        this.siiResponDianPersonaList = siiResponDianPersonaList;
    }

    public SiiResponDianPersona addSiiResponDianPersona(SiiResponDianPersona siiResponDianPersona) {
        getSiiResponDianPersonaList().add(siiResponDianPersona);
        siiResponDianPersona.setSiiResponsabilidadDian(this);
        return siiResponDianPersona;
    }

    public SiiResponDianPersona removeSiiResponDianPersona(SiiResponDianPersona siiResponDianPersona) {
        getSiiResponDianPersonaList().remove(siiResponDianPersona);
        siiResponDianPersona.setSiiResponsabilidadDian(null);
        return siiResponDianPersona;
    }
}
