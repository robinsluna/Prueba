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
@Table(name = "SII_ESTADO_DENUNCIA")
public class SiiEstadoDenuncia implements Serializable {
    private static final long serialVersionUID = 2107271763588337716L;
    private Long ednCodigo;
    private String ednNombre;
    private List<SiiDenuncia> siiDenunciaList;

    public SiiEstadoDenuncia() {
    }

    public SiiEstadoDenuncia(Long ednCodigo, String ednNombre) {
        this.ednCodigo = ednCodigo;
        this.ednNombre = ednNombre;
    }

    @Id
    @Column(name = "EDN_CODIGO", nullable = false)
    public Long getEdnCodigo() {
        return ednCodigo;
    }

    public void setEdnCodigo(Long ednCodigo) {
        this.ednCodigo = ednCodigo;
    }

    @Column(name = "EDN_NOMBRE", nullable = false, length = 30)
    public String getEdnNombre() {
        return ednNombre;
    }

    public void setEdnNombre(String ednNombre) {
        this.ednNombre = ednNombre;
    }

    @OneToMany(mappedBy = "siiEstadoDenuncia")
    public List<SiiDenuncia> getSiiDenunciaList() {
        return siiDenunciaList;
    }

    public void setSiiDenunciaList(List<SiiDenuncia> siiDenunciaList) {
        this.siiDenunciaList = siiDenunciaList;
    }

    public SiiDenuncia addSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().add(siiDenuncia);
        siiDenuncia.setSiiEstadoDenuncia(this);
        return siiDenuncia;
    }

    public SiiDenuncia removeSiiDenuncia(SiiDenuncia siiDenuncia) {
        getSiiDenunciaList().remove(siiDenuncia);
        siiDenuncia.setSiiEstadoDenuncia(null);
        return siiDenuncia;
    }
}
