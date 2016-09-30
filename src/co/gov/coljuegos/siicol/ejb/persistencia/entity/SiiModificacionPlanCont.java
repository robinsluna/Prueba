package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_MODIFICACION_PLAN_CONT")
public class SiiModificacionPlanCont implements Serializable {
    private static final long serialVersionUID = 3324702923720568258L;
    private Long mpcCodigo;
    private Integer mpcConsecutivo;
    private Integer mpcVigencia;
    private List<SiiDocumSoporModif> siiDocumSoporModifList;
    private SiiEstadoModifPlanCont siiEstadoModifPlanCont;
    private List<SiiModPlanConItemPlanDetRub> siiModPlanConItemPlanDetRubList;
    private Date mpcFecha;

    public SiiModificacionPlanCont() {
    }

    public SiiModificacionPlanCont(SiiEstadoModifPlanCont siiEstadoModifPlanCont, Long mpcCodigo,
                                   Integer mpcConsecutivo, Integer mpcVigencia) {
        this.siiEstadoModifPlanCont = siiEstadoModifPlanCont;
        this.mpcCodigo = mpcCodigo;
        this.mpcConsecutivo = mpcConsecutivo;
        this.mpcVigencia = mpcVigencia;
    }


    @Id
    @Column(name = "MPC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIF_PLAN_CONT_COD")
    @SequenceGenerator(name = "SEQ_MODIF_PLAN_CONT_COD", sequenceName = "SEQ_MODIF_PLAN_CONT_COD",allocationSize=1)
    public Long getMpcCodigo() {
        return mpcCodigo;
    }

    public void setMpcCodigo(Long mpcCodigo) {
        this.mpcCodigo = mpcCodigo;
    }

    @Column(name = "MPC_CONSECUTIVO", nullable = false)
    public Integer getMpcConsecutivo() {
        return mpcConsecutivo;
    }

    public void setMpcConsecutivo(Integer mpcConsecutivo) {
        this.mpcConsecutivo = mpcConsecutivo;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MPC_FECHA", nullable = false)
    public Date getMpcFecha() {
        return mpcFecha;
    }

    public void setMpcFecha(Date mpcFecha) {
        this.mpcFecha = mpcFecha;
    }

    @Column(name = "MPC_VIGENCIA", nullable = false)
    public Integer getMpcVigencia() {
        return mpcVigencia;
    }

    public void setMpcVigencia(Integer mpcVigencia) {
        this.mpcVigencia = mpcVigencia;
    }

    @OneToMany(mappedBy = "siiModificacionPlanCont")
    public List<SiiDocumSoporModif> getSiiDocumSoporModifList() {
        return siiDocumSoporModifList;
    }

    public void setSiiDocumSoporModifList(List<SiiDocumSoporModif> siiDocumSoporModifList) {
        this.siiDocumSoporModifList = siiDocumSoporModifList;
    }

    public SiiDocumSoporModif addSiiDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) {
        getSiiDocumSoporModifList().add(siiDocumSoporModif);
        siiDocumSoporModif.setSiiModificacionPlanCont(this);
        return siiDocumSoporModif;
    }

    public SiiDocumSoporModif removeSiiDocumSoporModif(SiiDocumSoporModif siiDocumSoporModif) {
        getSiiDocumSoporModifList().remove(siiDocumSoporModif);
        siiDocumSoporModif.setSiiModificacionPlanCont(null);
        return siiDocumSoporModif;
    }

    @ManyToOne
    @JoinColumn(name = "EMO_CODIGO")
    public SiiEstadoModifPlanCont getSiiEstadoModifPlanCont() {
        return siiEstadoModifPlanCont;
    }

    public void setSiiEstadoModifPlanCont(SiiEstadoModifPlanCont siiEstadoModifPlanCont) {
        this.siiEstadoModifPlanCont = siiEstadoModifPlanCont;
    }

    @OneToMany(mappedBy = "siiModificacionPlanCont")
    public List<SiiModPlanConItemPlanDetRub> getSiiModPlanConItemPlanDetRubList() {
        return siiModPlanConItemPlanDetRubList;
    }

    public void setSiiModPlanConItemPlanDetRubList(List<SiiModPlanConItemPlanDetRub> siiModPlanConItemPlanDetRubList) {
        this.siiModPlanConItemPlanDetRubList = siiModPlanConItemPlanDetRubList;
    }

    public SiiModPlanConItemPlanDetRub addSiiModPlanConItemPlanDetRub(SiiModPlanConItemPlanDetRub siiModPlanConItemPlanDetRub) {
        getSiiModPlanConItemPlanDetRubList().add(siiModPlanConItemPlanDetRub);
        siiModPlanConItemPlanDetRub.setSiiModificacionPlanCont(this);
        return siiModPlanConItemPlanDetRub;
    }

    public SiiModPlanConItemPlanDetRub removeSiiModPlanConItemPlanDetRub(SiiModPlanConItemPlanDetRub siiModPlanConItemPlanDetRub) {
        getSiiModPlanConItemPlanDetRubList().remove(siiModPlanConItemPlanDetRub);
        siiModPlanConItemPlanDetRub.setSiiModificacionPlanCont(null);
        return siiModPlanConItemPlanDetRub;
    }

}
