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
@Table(name = "SII_TIPO_SOCIEDAD")
public class SiiTipoSociedad implements Serializable {
    private static final long serialVersionUID = -9097574016567364294L;
    private Long tsoCodigo;
    private String tsoNombre;
    private List<SiiPersona> siiPersonaList;

    public SiiTipoSociedad() {
    }

    public SiiTipoSociedad(Long tsoCodigo, String tsoNombre) {
        this.tsoCodigo = tsoCodigo;
        this.tsoNombre = tsoNombre;
    }

    @Id
    @Column(name = "TSO_CODIGO", nullable = false)
    public Long getTsoCodigo() {
        return tsoCodigo;
    }

    public void setTsoCodigo(Long tsoCodigo) {
        this.tsoCodigo = tsoCodigo;
    }

    @Column(name = "TSO_NOMBRE", nullable = false, length = 50)
    public String getTsoNombre() {
        return tsoNombre;
    }

    public void setTsoNombre(String tsoNombre) {
        this.tsoNombre = tsoNombre;
    }

    @OneToMany(mappedBy = "siiTipoSociedad")
    public List<SiiPersona> getSiiPersonaList() {
        return siiPersonaList;
    }

    public void setSiiPersonaList(List<SiiPersona> siiPersonaList) {
        this.siiPersonaList = siiPersonaList;
    }

    public SiiPersona addSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().add(siiPersona);
        siiPersona.setSiiTipoSociedad(this);
        return siiPersona;
    }

    public SiiPersona removeSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaList().remove(siiPersona);
        siiPersona.setSiiTipoSociedad(null);
        return siiPersona;
    }
}
