package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_EVALUACION_JUR_TEC_FIN")
public class SiiEvaluacionJurTecFin implements Serializable {
    private static final long serialVersionUID = -2756988609219589714L;
    private Long ejtCodigo;
    private Date ejtFechaAprobFin;
    private Date ejtFechaAprobJur;
    private Date ejtFechaAprobTec;
    private List<SiiPropuestaEvaluacion> siiPropuestaEvaluacionList;
    private SiiEstadoEvaluacionJtf siiEstadoEvaluacionJtf;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiArchivoFisico siiArchivoFisicoJur;
    private SiiArchivoFisico siiArchivoFisicoTec;
    private SiiArchivoFisico siiArchivoFisicoFin;
    private String ejtObservaciones;

    public SiiEvaluacionJurTecFin() {
    }

    public SiiEvaluacionJurTecFin(SiiEstadoEvaluacionJtf siiEstadoEvaluacionJtf, Long ejtCodigo, Date ejtFechaAprobFin,
                                  Date ejtFechaAprobJur, Date ejtFechaAprobTec, SiiArchivoFisico siiArchivoFisicoFin, SiiArchivoFisico siiArchivoFisicoJur,
                                  SiiArchivoFisico siiArchivoFisicoTec, SiiProcesoContratacion siiProcesoContratacion, String ejtObservaciones) {
        this.siiEstadoEvaluacionJtf = siiEstadoEvaluacionJtf;
        this.ejtCodigo = ejtCodigo;
        this.ejtFechaAprobFin = ejtFechaAprobFin;
        this.ejtFechaAprobJur = ejtFechaAprobJur;
        this.ejtFechaAprobTec = ejtFechaAprobTec;
        this.siiProcesoContratacion = siiProcesoContratacion;
        this.siiArchivoFisicoFin = siiArchivoFisicoFin;
        this.siiArchivoFisicoJur = siiArchivoFisicoJur;
        this.siiArchivoFisicoTec = siiArchivoFisicoTec;
        this.ejtObservaciones = ejtObservaciones;
    }


    @Id
    @Column(name = "EJT_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_EVALUACION_JTF_COD")
    @SequenceGenerator(name = "SEQ_EVALUACION_JTF_COD", sequenceName = "SEQ_EVALUACION_JTF_COD",allocationSize=1)
    public Long getEjtCodigo() {
        return ejtCodigo;
    }

    public void setEjtCodigo(Long ejtCodigo) {
        this.ejtCodigo = ejtCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EJT_FECHA_APROB_FIN", nullable = false)
    public Date getEjtFechaAprobFin() {
        return ejtFechaAprobFin;
    }

    public void setEjtFechaAprobFin(Date ejtFechaAprobFin) {
        this.ejtFechaAprobFin = ejtFechaAprobFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EJT_FECHA_APROB_JUR", nullable = false)
    public Date getEjtFechaAprobJur() {
        return ejtFechaAprobJur;
    }

    public void setEjtFechaAprobJur(Date ejtFechaAprobJur) {
        this.ejtFechaAprobJur = ejtFechaAprobJur;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EJT_FECHA_APROB_TEC", nullable = false)
    public Date getEjtFechaAprobTec() {
        return ejtFechaAprobTec;
    }

    public void setEjtFechaAprobTec(Date ejtFechaAprobTec) {
        this.ejtFechaAprobTec = ejtFechaAprobTec;
    }


    @OneToMany(mappedBy = "siiEvaluacionJurTecFin")
    public List<SiiPropuestaEvaluacion> getSiiPropuestaEvaluacionList() {
        return siiPropuestaEvaluacionList;
    }

    public void setSiiPropuestaEvaluacionList(List<SiiPropuestaEvaluacion> siiPropuestaEvaluacionList) {
        this.siiPropuestaEvaluacionList = siiPropuestaEvaluacionList;
    }

    public SiiPropuestaEvaluacion addSiiPropuestaEvaluacion(SiiPropuestaEvaluacion siiPropuestaEvaluacion) {
        getSiiPropuestaEvaluacionList().add(siiPropuestaEvaluacion);
        siiPropuestaEvaluacion.setSiiEvaluacionJurTecFin(this);
        return siiPropuestaEvaluacion;
    }

    public SiiPropuestaEvaluacion removeSiiPropuestaEvaluacion(SiiPropuestaEvaluacion siiPropuestaEvaluacion) {
        getSiiPropuestaEvaluacionList().remove(siiPropuestaEvaluacion);
        siiPropuestaEvaluacion.setSiiEvaluacionJurTecFin(null);
        return siiPropuestaEvaluacion;
    }

    @ManyToOne
    @JoinColumn(name = "EEJ_CODIGO")
    public SiiEstadoEvaluacionJtf getSiiEstadoEvaluacionJtf() {
        return siiEstadoEvaluacionJtf;
    }

    public void setSiiEstadoEvaluacionJtf(SiiEstadoEvaluacionJtf siiEstadoEvaluacionJtf) {
        this.siiEstadoEvaluacionJtf = siiEstadoEvaluacionJtf;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_EVAL_JUR")
    public SiiArchivoFisico getSiiArchivoFisicoJur() {
        return siiArchivoFisicoJur;
    }

    public void setSiiArchivoFisicoJur(SiiArchivoFisico siiArchivoFisicoJur) {
        this.siiArchivoFisicoJur = siiArchivoFisicoJur;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_EVAL_TEC")
    public SiiArchivoFisico getSiiArchivoFisicoTec() {
        return siiArchivoFisicoTec;
    }

    public void setSiiArchivoFisicoTec(SiiArchivoFisico siiArchivoFisicoTec) {
        this.siiArchivoFisicoTec = siiArchivoFisicoTec;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO_EVAL_FIN")
    public SiiArchivoFisico getSiiArchivoFisicoFin() {
        return siiArchivoFisicoFin;
    }

    public void setSiiArchivoFisicoFin(SiiArchivoFisico siiArchivoFisicoFin) {
        this.siiArchivoFisicoFin = siiArchivoFisicoFin;
    }

    @Column(name = "EJT_OBSERVACIONES", length = 2000)
    public String getEjtObservaciones() {
        return ejtObservaciones;
    }

    public void setEjtObservaciones(String ejtObservaciones) {
        this.ejtObservaciones = ejtObservaciones;
    }
}
