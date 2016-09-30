package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ASEGURADORA")
public class SiiAseguradora implements Serializable {
    private static final long serialVersionUID = 6067030860040022693L;
    private Long aseCodigo;
    private List<SiiPolizaContrat> siiPolizaContratList;
    private SiiPersona siiPersona;
    private List<SiiPolizaContProv> siiPolizaContProvList;

    public SiiAseguradora() {
    }

    public SiiAseguradora(Long aseCodigo, Long perCodigo) {
        this.aseCodigo = aseCodigo;
    }

    @Id
    @Column(name = "ASE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ASEGURADORA_COD")
    @SequenceGenerator(name = "SEQ_ASEGURADORA_COD", sequenceName = "SEQ_ASEGURADORA_COD",allocationSize=1)
    public Long getAseCodigo() {
        return aseCodigo;
    }

    public void setAseCodigo(Long aseCodigo) {
        this.aseCodigo = aseCodigo;
    }

    @OneToMany(mappedBy = "siiAseguradora")
    public List<SiiPolizaContrat> getSiiPolizaContratList() {
        return siiPolizaContratList;
    }

    public void setSiiPolizaContratList(List<SiiPolizaContrat> siiPolizaContratList) {
        this.siiPolizaContratList = siiPolizaContratList;
    }

    public SiiPolizaContrat addSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().add(siiPolizaContrat);
        siiPolizaContrat.setSiiAseguradora(this);
        return siiPolizaContrat;
    }

    public SiiPolizaContrat removeSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        getSiiPolizaContratList().remove(siiPolizaContrat);
        siiPolizaContrat.setSiiAseguradora(null);
        return siiPolizaContrat;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }
    @OneToMany(mappedBy = "siiAseguradora")
    public List<SiiPolizaContProv> getSiiPolizaContProvList() {
        return siiPolizaContProvList;
    }

    public void setSiiPolizaContProvList(List<SiiPolizaContProv> siiPolizaContProvList) {
        this.siiPolizaContProvList = siiPolizaContProvList;
    }

    public SiiPolizaContProv addSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().add(siiPolizaContProv);
        siiPolizaContProv.setSiiAseguradora(this);
        return siiPolizaContProv;
    }

    public SiiPolizaContProv removeSiiPolizaContProv(SiiPolizaContProv siiPolizaContProv) {
        getSiiPolizaContProvList().remove(siiPolizaContProv);
        siiPolizaContProv.setSiiAseguradora(null);
        return siiPolizaContProv;
    }
}
