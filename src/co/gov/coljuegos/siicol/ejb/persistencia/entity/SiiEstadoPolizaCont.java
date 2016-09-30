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
@Table(name = "SII_ESTADO_POLIZA_CONT")
public class SiiEstadoPolizaCont implements Serializable {
    private static final long serialVersionUID = -4310172546036793037L;
    private Long epoCodigo;
    private String epoNombre;
    private List<SiiPolizaContrat> siiPolizaContratList1;

    public SiiEstadoPolizaCont() {
    }

    public SiiEstadoPolizaCont(Long epoCodigo, String epoNombre) {
        this.epoCodigo = epoCodigo;
        this.epoNombre = epoNombre;
    }

    @Id
    @Column(name = "EPO_CODIGO", nullable = false)
    public Long getEpoCodigo() {
        return epoCodigo;
    }

    public void setEpoCodigo(Long epoCodigo) {
        this.epoCodigo = epoCodigo;
    }

    @Column(name = "EPO_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEpoNombre() {
        return epoNombre;
    }

    public void setEpoNombre(String epoNombre) {
        this.epoNombre = epoNombre;
    }

    @OneToMany(mappedBy = "siiEstadoPolizaCont")
    public List<SiiPolizaContrat> getSiiPolizaContratList1() {
        return siiPolizaContratList1;
    }

    public void setSiiPolizaContratList1(List<SiiPolizaContrat> siiPolizaContratList1) {
        this.siiPolizaContratList1 = siiPolizaContratList1;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList1().add(siiPolizaContrat);
        siiPolizaContrat.setSiiEstadoPolizaCont(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList1().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiEstadoPolizaCont(null);
        return siiPolizaContrat;
    }
}
