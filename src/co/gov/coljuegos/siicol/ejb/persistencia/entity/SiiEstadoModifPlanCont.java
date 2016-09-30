package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_MODIF_PLAN_CONT")
public class SiiEstadoModifPlanCont implements Serializable {
    private static final long serialVersionUID = 2408223203726374805L;
    private Long emoCodigo;
    private String emoNombre;
    private List<SiiModificacionPlanCont> siiModificacionPlanContList;

    public SiiEstadoModifPlanCont() {
    }

    public SiiEstadoModifPlanCont(Long emoCodigo, String emoNombre) {
        this.emoCodigo = emoCodigo;
        this.emoNombre = emoNombre;
    }

    @Id
    @Column(name = "EMO_CODIGO", nullable = false)
    public Long getEmoCodigo() {
        return emoCodigo;
    }

    public void setEmoCodigo(Long emoCodigo) {
        this.emoCodigo = emoCodigo;
    }

    @Column(name = "EMO_NOMBRE", nullable = false, length = 20)
    public String getEmoNombre() {
        return emoNombre;
    }

    public void setEmoNombre(String emoNombre) {
        this.emoNombre = emoNombre;
    }

    @OneToMany(mappedBy = "siiEstadoModifPlanCont")
    public List<SiiModificacionPlanCont> getSiiModificacionPlanContList() {
        return siiModificacionPlanContList;
    }

    public void setSiiModificacionPlanContList(List<SiiModificacionPlanCont> siiModificacionPlanContList) {
        this.siiModificacionPlanContList = siiModificacionPlanContList;
    }

    public SiiModificacionPlanCont addSiiModificacionPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) {
        getSiiModificacionPlanContList().add(siiModificacionPlanCont);
        siiModificacionPlanCont.setSiiEstadoModifPlanCont(this);
        return siiModificacionPlanCont;
    }

    public SiiModificacionPlanCont removeSiiModificacionPlanCont(SiiModificacionPlanCont siiModificacionPlanCont) {
        getSiiModificacionPlanContList().remove(siiModificacionPlanCont);
        siiModificacionPlanCont.setSiiEstadoModifPlanCont(null);
        return siiModificacionPlanCont;
    }
}
