package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_POLIZA_CONTR")
public class SiiTipoPolizaContr implements Serializable {
    private static final long serialVersionUID = -824513217327287022L;
    private Long tpcCodigo;
    private String tpcNombre;
    private List<SiiPolizaContrat> siiPolizaContratList;

    public SiiTipoPolizaContr() {
    }

    public SiiTipoPolizaContr(Long tpcCodigo, String tpcNombre) {
        this.tpcCodigo = tpcCodigo;
        this.tpcNombre = tpcNombre;
    }

    @Id
    @Column(name = "TPC_CODIGO", nullable = false)
    public Long getTpcCodigo() {
        return tpcCodigo;
    }

    public void setTpcCodigo(Long tpcCodigo) {
        this.tpcCodigo = tpcCodigo;
    }

    @Column(name = "TPC_NOMBRE", nullable = false, length = 30)
    public String getTpcNombre() {
        return tpcNombre;
    }

    public void setTpcNombre(String tpcNombre) {
        this.tpcNombre = tpcNombre;
    }

    @OneToMany(mappedBy = "siiTipoPolizaContr")
    public List<SiiPolizaContrat> getSiiPolizaContratList() {
        return siiPolizaContratList;
    }

    public void setSiiPolizaContratList(List<SiiPolizaContrat> siiPolizaContratList) {
        this.siiPolizaContratList = siiPolizaContratList;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().add(siiPolizaContrat);
        siiPolizaContrat.setSiiTipoPolizaContr(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiTipoPolizaContr(null);
        return siiPolizaContrat;
    }
}
