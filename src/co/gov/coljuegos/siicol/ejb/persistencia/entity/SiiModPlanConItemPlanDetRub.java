package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_MOD_PLAN_CON_IT_PL_DRU")
public class SiiModPlanConItemPlanDetRub implements Serializable {
    private static final long serialVersionUID = -1394888574344932977L;
    private String midActivo;
    private Long midCodigo;
    private String midTipo;
    private Long midValor;
    private SiiItemPlanContDetRub siiItemPlanContDetRubDes;
    private SiiModificacionPlanCont siiModificacionPlanCont;

    public SiiModPlanConItemPlanDetRub() {
    }

    public SiiModPlanConItemPlanDetRub(SiiItemPlanContDetRub siiItemPlanContDetRubDes,
                                       String midActivo, Long midCodigo,
                                       String midTipo, Long midValor, SiiModificacionPlanCont siiModificacionPlanCont) {
        this.siiItemPlanContDetRubDes = siiItemPlanContDetRubDes;
        this.midActivo = midActivo;
        this.midCodigo = midCodigo;
        this.midTipo = midTipo;
        this.midValor = midValor;
        this.siiModificacionPlanCont = siiModificacionPlanCont;
    }


    @Column(name = "MID_ACTIVO", nullable = false, length = 1)
    public String getMidActivo() {
        return midActivo;
    }

    public void setMidActivo(String midActivo) {
        this.midActivo = midActivo;
    }

    @Id
    @Column(name = "MID_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MPC_IT_PL_DRU_COD")
    @SequenceGenerator(name = "SEQ_MPC_IT_PL_DRU_COD", sequenceName = "SEQ_MPC_IT_PL_DRU_COD",allocationSize=1)
    public Long getMidCodigo() {
        return midCodigo;
    }

    public void setMidCodigo(Long midCodigo) {
        this.midCodigo = midCodigo;
    }

    @Column(name = "MID_TIPO", nullable = false, length = 1)
    public String getMidTipo() {
        return midTipo;
    }

    public void setMidTipo(String midTipo) {
        this.midTipo = midTipo;
    }

    @Column(name = "MID_VALOR", nullable = false)
    public Long getMidValor() {
        return midValor;
    }

    public void setMidValor(Long midValor) {
        this.midValor = midValor;
    }


    @ManyToOne
    @JoinColumn(name = "IDR_CODIGO_DEST")
    public SiiItemPlanContDetRub getSiiItemPlanContDetRubDes() {
        return siiItemPlanContDetRubDes;
    }

    public void setSiiItemPlanContDetRubDes(SiiItemPlanContDetRub siiItemPlanContDetRubDes) {
        this.siiItemPlanContDetRubDes = siiItemPlanContDetRubDes;
    }

    @ManyToOne
    @JoinColumn(name = "MPC_CODIGO")
    public SiiModificacionPlanCont getSiiModificacionPlanCont() {
        return siiModificacionPlanCont;
    }

    public void setSiiModificacionPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) {
        this.siiModificacionPlanCont = siiModificacionPlanCont;
    }
}
