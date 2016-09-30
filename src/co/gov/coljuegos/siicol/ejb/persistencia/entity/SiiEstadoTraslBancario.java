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
@Table(name = "SII_ESTADO_TRASL_BANCARIO")
public class SiiEstadoTraslBancario implements Serializable {
    private static final long serialVersionUID = -2863049928724132544L;
    private Long etbCodigo;
    private String etbNombre;
    private List<SiiTrasladoBancario> siiTrasladoBancarioList;

    public SiiEstadoTraslBancario() {
    }

    public SiiEstadoTraslBancario(Long etbCodigo, String etbNombre) {
        this.etbCodigo = etbCodigo;
        this.etbNombre = etbNombre;
    }

    @Id
    @Column(name = "ETB_CODIGO", nullable = false)
    public Long getEtbCodigo() {
        return etbCodigo;
    }

    public void setEtbCodigo(Long etbCodigo) {
        this.etbCodigo = etbCodigo;
    }

    @Column(name = "ETB_NOMBRE", nullable = false, length = 20)
    public String getEtbNombre() {
        return etbNombre;
    }

    public void setEtbNombre(String etbNombre) {
        this.etbNombre = etbNombre;
    }

    @OneToMany(mappedBy = "siiEstadoTraslBancario")
    public List<SiiTrasladoBancario> getSiiTrasladoBancarioList() {
        return siiTrasladoBancarioList;
    }

    public void setSiiTrasladoBancarioList(List<SiiTrasladoBancario> siiTrasladoBancarioList) {
        this.siiTrasladoBancarioList = siiTrasladoBancarioList;
    }

    public SiiTrasladoBancario addSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        getSiiTrasladoBancarioList().add(siiTrasladoBancario);
        siiTrasladoBancario.setSiiEstadoTraslBancario(this);
        return siiTrasladoBancario;
    }

    public SiiTrasladoBancario removeSiiTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) {
        getSiiTrasladoBancarioList().remove(siiTrasladoBancario);
        siiTrasladoBancario.setSiiEstadoTraslBancario(null);
        return siiTrasladoBancario;
    }
}
