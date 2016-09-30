package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_REQ_ALCANCE_INV")
public class SiiReqAlcanceInv implements Serializable {
    private static final long serialVersionUID = 5709831044752758362L;
    private Long raiCodigo;
    private Integer rcrPuntaje;
    private SiiAlcanceInvitacion siiAlcanceInvitacion;
    private SiiRequisitoCrit siiRequisitoCrit;

    public SiiReqAlcanceInv() {
    }

    public SiiReqAlcanceInv(SiiAlcanceInvitacion siiAlcanceInvitacion, Long raiCodigo,
                            SiiRequisitoCrit siiRequisitoCrit, Integer rcrPuntaje) {
        this.siiAlcanceInvitacion = siiAlcanceInvitacion;
        this.raiCodigo = raiCodigo;
        this.siiRequisitoCrit = siiRequisitoCrit;
        this.rcrPuntaje = rcrPuntaje;
    }


    @Id
    @Column(name = "RAI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REQ_ALCANCE_INV")
    @SequenceGenerator(name = "SEQ_REQ_ALCANCE_INV", sequenceName = "SEQ_REQ_ALCANCE_INV",allocationSize=1)
    public Long getRaiCodigo() {
        return raiCodigo;
    }

    public void setRaiCodigo(Long raiCodigo) {
        this.raiCodigo = raiCodigo;
    }


    @Column(name = "RCR_PUNTAJE")
    public Integer getRcrPuntaje() {
        return rcrPuntaje;
    }

    public void setRcrPuntaje(Integer rcrPuntaje) {
        this.rcrPuntaje = rcrPuntaje;
    }

    @ManyToOne
    @JoinColumn(name = "ALI_CODIGO")
    public SiiAlcanceInvitacion getSiiAlcanceInvitacion() {
        return siiAlcanceInvitacion;
    }

    public void setSiiAlcanceInvitacion(SiiAlcanceInvitacion siiAlcanceInvitacion) {
        this.siiAlcanceInvitacion = siiAlcanceInvitacion;
    }

    @ManyToOne
    @JoinColumn(name = "RCR_CODIGO")
    public SiiRequisitoCrit getSiiRequisitoCrit() {
        return siiRequisitoCrit;
    }

    public void setSiiRequisitoCrit(SiiRequisitoCrit siiRequisitoCrit) {
        this.siiRequisitoCrit = siiRequisitoCrit;
    }
}
