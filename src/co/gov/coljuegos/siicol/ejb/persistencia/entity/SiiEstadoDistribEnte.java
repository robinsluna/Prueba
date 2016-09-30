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
@Table(name = "SII_ESTADO_DISTRIB_ENTE")
public class SiiEstadoDistribEnte implements Serializable {
    private static final long serialVersionUID = 4800944302463181970L;
    private Long edeCodigo;
    private String edeNombre;
    private List<SiiDistribucionMes> siiDistribucionMesList;

    public SiiEstadoDistribEnte() {
    }

    public SiiEstadoDistribEnte(Long edeCodigo, String edeNombre) {
        this.edeCodigo = edeCodigo;
        this.edeNombre = edeNombre;
    }

    @Id
    @Column(name = "EDE_CODIGO", nullable = false)
    public Long getEdeCodigo() {
        return edeCodigo;
    }

    public void setEdeCodigo(Long edeCodigo) {
        this.edeCodigo = edeCodigo;
    }

    @Column(name = "EDE_NOMBRE", nullable = false, length = 20)
    public String getEdeNombre() {
        return edeNombre;
    }

    public void setEdeNombre(String edeNombre) {
        this.edeNombre = edeNombre;
    }

    @OneToMany(mappedBy = "siiEstadoDistribEnte")
    public List<SiiDistribucionMes> getSiiDistribucionMesList() {
        return siiDistribucionMesList;
    }

    public void setSiiDistribucionMesList(List<SiiDistribucionMes> siiDistribucionMesList) {
        this.siiDistribucionMesList = siiDistribucionMesList;
    }

    public SiiDistribucionMes addSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().add(siiDistribucionMes);
        siiDistribucionMes.setSiiEstadoDistribEnte(this);
        return siiDistribucionMes;
    }

    public SiiDistribucionMes removeSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().remove(siiDistribucionMes);
        siiDistribucionMes.setSiiEstadoDistribEnte(null);
        return siiDistribucionMes;
    }
}
