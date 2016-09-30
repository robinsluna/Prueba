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
@Table(name = "SII_REQ_ESTUDIO_PREVIO")
public class SiiReqEstudioPrevio implements Serializable {
    private static final long serialVersionUID = 451982048926021911L;
    private Long resCodigo;
    private Integer resPuntaje;
    private SiiEstudioPrevio siiEstudioPrevio1;
    private SiiRequisitoCrit siiRequisitoCrit;

    public SiiReqEstudioPrevio() {
    }

    public SiiReqEstudioPrevio(SiiEstudioPrevio siiEstudioPrevio1, SiiRequisitoCrit siiRequisitoCrit, Long resCodigo,
                               Integer resPuntaje) {
        this.siiEstudioPrevio1 = siiEstudioPrevio1;
        this.siiRequisitoCrit = siiRequisitoCrit;
        this.resCodigo = resCodigo;
        this.resPuntaje = resPuntaje;
    }


    @Id
    @Column(name = "RES_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_REQ_ESTUDIO_PREVIO_COD")
    @SequenceGenerator(name = "SEQ_REQ_ESTUDIO_PREVIO_COD", sequenceName = "SEQ_REQ_ESTUDIO_PREVIO_COD",allocationSize=1)
    public Long getResCodigo() {
        return resCodigo;
    }

    public void setResCodigo(Long resCodigo) {
        this.resCodigo = resCodigo;
    }

    @Column(name = "RES_PUNTAJE")
    public Integer getResPuntaje() {
        return resPuntaje;
    }

    public void setResPuntaje(Integer resPuntaje) {
        this.resPuntaje = resPuntaje;
    }

    @ManyToOne
    @JoinColumn(name = "EPE_CODIGO")
    public SiiEstudioPrevio getSiiEstudioPrevio1() {
        return siiEstudioPrevio1;
    }

    public void setSiiEstudioPrevio1(SiiEstudioPrevio siiEstudioPrevio1) {
        this.siiEstudioPrevio1 = siiEstudioPrevio1;
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
