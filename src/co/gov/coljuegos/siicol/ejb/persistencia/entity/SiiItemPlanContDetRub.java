package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ITEM_PLAN_CONT_DET_RUB")
public class SiiItemPlanContDetRub implements Serializable {
    private static final long serialVersionUID = 6204993755337500645L;
    private Long idrCodigo;
    private Long idrValor;
    private SiiDetalleRubro siiDetalleRubro;
    private SiiItemPlanContratac siiItemPlanContratac;
    private List<SiiModPlanConItemPlanDetRub> siiModPlanConItemPlanDetRubDesList;

    public SiiItemPlanContDetRub() {
    }

    public SiiItemPlanContDetRub(SiiDetalleRubro siiDetalleRubro, Long idrCodigo, Long idrValor,
                                 SiiItemPlanContratac siiItemPlanContratac) {
        this.siiDetalleRubro = siiDetalleRubro;
        this.idrCodigo = idrCodigo;
        this.idrValor = idrValor;
        this.siiItemPlanContratac = siiItemPlanContratac;
    }


    @Id
    @Column(name = "IDR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM_PLAN_CONT_DET_RUB")
    @SequenceGenerator(name = "SEQ_ITEM_PLAN_CONT_DET_RUB", sequenceName = "SEQ_ITEM_PLAN_CONT_DET_RUB",allocationSize=1)
    public Long getIdrCodigo() {
        return idrCodigo;
    }

    public void setIdrCodigo(Long idrCodigo) {
        this.idrCodigo = idrCodigo;
    }

    @Column(name = "IDR_VALOR", nullable = false)
    public Long getIdrValor() {
        return idrValor;
    }

    public void setIdrValor(Long idrValor) {
        this.idrValor = idrValor;
    }


    @ManyToOne
    @JoinColumn(name = "DRU_CODIGO")
    public SiiDetalleRubro getSiiDetalleRubro() {
        return siiDetalleRubro;
    }

    public void setSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        this.siiDetalleRubro = siiDetalleRubro;
    }

    @ManyToOne
    @JoinColumn(name = "IPC_CODIGO")
    public SiiItemPlanContratac getSiiItemPlanContratac() {
        return siiItemPlanContratac;
    }

    public void setSiiItemPlanContratac(SiiItemPlanContratac siiItemPlanContratac) {
        this.siiItemPlanContratac = siiItemPlanContratac;
    }


    @OneToMany(mappedBy = "siiItemPlanContDetRubDes")
    public List<SiiModPlanConItemPlanDetRub> getSiiModPlanConItemPlanDetRubDesList() {
        return siiModPlanConItemPlanDetRubDesList;
    }

    public void setSiiModPlanConItemPlanDetRubDesList(List<SiiModPlanConItemPlanDetRub> siiModPlanConItemPlanDetRubDesList) {
        this.siiModPlanConItemPlanDetRubDesList = siiModPlanConItemPlanDetRubDesList;
    }
}
