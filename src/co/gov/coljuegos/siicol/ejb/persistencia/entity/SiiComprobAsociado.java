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
@Table(name = "SII_COMPROB_ASOCIADO")
public class SiiComprobAsociado implements Serializable {
    private static final long serialVersionUID = -7985931692842014790L;
    private String casCodigo;
    private String casNombre;
    private List<SiiConceptoGasto> siiConceptoGastoList;

    public SiiComprobAsociado() {
    }

    public SiiComprobAsociado(String casCodigo, String casNombre) {
        this.casCodigo = casCodigo;
        this.casNombre = casNombre;
    }

    @Id
    @Column(name = "CAS_CODIGO", nullable = false, length = 5)
    public String getCasCodigo() {
        return casCodigo;
    }

    public void setCasCodigo(String casCodigo) {
        this.casCodigo = casCodigo;
    }

    @Column(name = "CAS_NOMBRE", nullable = false, length = 30)
    public String getCasNombre() {
        return casNombre;
    }

    public void setCasNombre(String casNombre) {
        this.casNombre = casNombre;
    }

    @OneToMany(mappedBy = "siiComprobAsociado")
    public List<SiiConceptoGasto> getSiiConceptoGastoList() {
        return siiConceptoGastoList;
    }

    public void setSiiConceptoGastoList(List<SiiConceptoGasto> siiConceptoGastoList) {
        this.siiConceptoGastoList = siiConceptoGastoList;
    }

    public SiiConceptoGasto addSiiConceptoGasto(SiiConceptoGasto siiConceptoGasto) {
        getSiiConceptoGastoList().add(siiConceptoGasto);
        siiConceptoGasto.setSiiComprobAsociado(this);
        return siiConceptoGasto;
    }

    public SiiConceptoGasto removeSiiConceptoGasto(SiiConceptoGasto siiConceptoGasto) {
        getSiiConceptoGastoList().remove(siiConceptoGasto);
        siiConceptoGasto.setSiiComprobAsociado(null);
        return siiConceptoGasto;
    }
}
