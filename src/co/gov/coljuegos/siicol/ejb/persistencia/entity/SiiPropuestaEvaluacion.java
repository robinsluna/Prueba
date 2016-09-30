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
@Table(name = "SII_PROPUESTA_EVALUACION")
public class SiiPropuestaEvaluacion implements Serializable {
    private static final long serialVersionUID = 4755961192891272883L;
    private Integer pevCalificacion;
    private Long pevCodigo;
    private String pevCumpleEvFin;
    private String pevCumpleEvJur;
    private String pevCumpleEvTec;
    private Long pevIva;
    private Long pevValor;
    private SiiEvaluacionJurTecFin siiEvaluacionJurTecFin;
    private SiiPropuestaRecib siiPropuestaRecib;

    public SiiPropuestaEvaluacion() {
    }

    public SiiPropuestaEvaluacion(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin, Integer pevCalificacion,
                                  Long pevCodigo, String pevCumpleEvFin, String pevCumpleEvJur, String pevCumpleEvTec,
                                  Long pevIva, Long pevValor, SiiPropuestaRecib siiPropuestaRecib) {
        this.siiEvaluacionJurTecFin = siiEvaluacionJurTecFin;
        this.pevCalificacion = pevCalificacion;
        this.pevCodigo = pevCodigo;
        this.pevCumpleEvFin = pevCumpleEvFin;
        this.pevCumpleEvJur = pevCumpleEvJur;
        this.pevCumpleEvTec = pevCumpleEvTec;
        this.pevIva = pevIva;
        this.pevValor = pevValor;
        this.siiPropuestaRecib = siiPropuestaRecib;
    }


    @Column(name = "PEV_CALIFICACION")
    public Integer getPevCalificacion() {
        return pevCalificacion;
    }

    public void setPevCalificacion(Integer pevCalificacion) {
        this.pevCalificacion = pevCalificacion;
    }

    @Id
    @Column(name = "PEV_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROPUESTA_EVAL_COD")
    @SequenceGenerator(name = "SEQ_PROPUESTA_EVAL_COD", sequenceName = "SEQ_PROPUESTA_EVAL_COD",allocationSize=1)
    public Long getPevCodigo() {
        return pevCodigo;
    }

    public void setPevCodigo(Long pevCodigo) {
        this.pevCodigo = pevCodigo;
    }

    @Column(name = "PEV_CUMPLE_EV_FIN", nullable = false, length = 1)
    public String getPevCumpleEvFin() {
        return pevCumpleEvFin;
    }

    public void setPevCumpleEvFin(String pevCumpleEvFin) {
        this.pevCumpleEvFin = pevCumpleEvFin;
    }

    @Column(name = "PEV_CUMPLE_EV_JUR", nullable = false, length = 1)
    public String getPevCumpleEvJur() {
        return pevCumpleEvJur;
    }

    public void setPevCumpleEvJur(String pevCumpleEvJur) {
        this.pevCumpleEvJur = pevCumpleEvJur;
    }

    @Column(name = "PEV_CUMPLE_EV_TEC", nullable = false, length = 1)
    public String getPevCumpleEvTec() {
        return pevCumpleEvTec;
    }

    public void setPevCumpleEvTec(String pevCumpleEvTec) {
        this.pevCumpleEvTec = pevCumpleEvTec;
    }

    @Column(name = "PEV_IVA", nullable = false)
    public Long getPevIva() {
        return pevIva;
    }

    public void setPevIva(Long pevIva) {
        this.pevIva = pevIva;
    }

    @Column(name = "PEV_VALOR", nullable = false)
    public Long getPevValor() {
        return pevValor;
    }

    public void setPevValor(Long pevValor) {
        this.pevValor = pevValor;
    }


    @ManyToOne
    @JoinColumn(name = "EJT_CODIGO")
    public SiiEvaluacionJurTecFin getSiiEvaluacionJurTecFin() {
        return siiEvaluacionJurTecFin;
    }

    public void setSiiEvaluacionJurTecFin(SiiEvaluacionJurTecFin siiEvaluacionJurTecFin) {
        this.siiEvaluacionJurTecFin = siiEvaluacionJurTecFin;
    }

    @ManyToOne
    @JoinColumn(name = "PRE_CODIGO")
    public SiiPropuestaRecib getSiiPropuestaRecib() {
        return siiPropuestaRecib;
    }

    public void setSiiPropuestaRecib(SiiPropuestaRecib siiPropuestaRecib) {
        this.siiPropuestaRecib = siiPropuestaRecib;
    }
}
