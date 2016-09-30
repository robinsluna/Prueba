package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_PLAN_CONTRATACION")
public class SiiPlanContratacion implements Serializable {
    private static final long serialVersionUID = -99320551870997523L;
    private Long pcnCodigo;
    private Integer pcnVigencia;
    private List<SiiItemPlanContratac> siiItemPlanContratacList1;

    public SiiPlanContratacion() {
    }

    public SiiPlanContratacion(Long pcnCodigo, Integer pcnVigencia) {
        this.pcnCodigo = pcnCodigo;
        this.pcnVigencia = pcnVigencia;
    }

    @Id
    @Column(name = "PCN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PLAN_CONTRATACION_COD")
    @SequenceGenerator(name = "SEQ_PLAN_CONTRATACION_COD", sequenceName = "SEQ_PLAN_CONTRATACION_COD",allocationSize=1)
    public Long getPcnCodigo() {
        return pcnCodigo;
    }

    public void setPcnCodigo(Long pcnCodigo) {
        this.pcnCodigo = pcnCodigo;
    }

    @Column(name = "PCN_VIGENCIA", nullable = false)
    public Integer getPcnVigencia() {
        return pcnVigencia;
    }

    public void setPcnVigencia(Integer pcnVigencia) {
        this.pcnVigencia = pcnVigencia;
    }

    @OneToMany(mappedBy = "siiPlanContratacion")
    public List<SiiItemPlanContratac> getSiiItemPlanContratacList1() {
        return siiItemPlanContratacList1;
    }

    public void setSiiItemPlanContratacList1(List<SiiItemPlanContratac> siiItemPlanContratacList1) {
        this.siiItemPlanContratacList1 = siiItemPlanContratacList1;
    }

    public SiiItemPlanContratac addSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacList1().add(siiItemPlanContratac);
        siiItemPlanContratac.setSiiPlanContratacion(this);
        return siiItemPlanContratac;
    }

    public SiiItemPlanContratac removeSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        getSiiItemPlanContratacList1().remove(siiItemPlanContratac);
        siiItemPlanContratac.setSiiPlanContratacion(null);
        return siiItemPlanContratac;
    }
}
