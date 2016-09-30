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
@Table(name = "SII_MOTIVO_INCU_INF_SUPERV")
public class SiiMotivoIncuInfSuperv implements Serializable {
    private static final long serialVersionUID = -4769045553162274487L;
    private String miiActivo;
    private Long miiCodigo;
    private SiiMotivoIncumplimiento siiMotivoIncumplimiento;
    private SiiInformeSupervision siiInformeSupervision;

    public SiiMotivoIncuInfSuperv() {
    }

    public SiiMotivoIncuInfSuperv(SiiInformeSupervision siiInformeSupervision, String miiActivo, Long miiCodigo,
                                  SiiMotivoIncumplimiento siiMotivoIncumplimiento) {
        this.siiInformeSupervision = siiInformeSupervision;
        this.miiActivo = miiActivo;
        this.miiCodigo = miiCodigo;
        this.siiMotivoIncumplimiento = siiMotivoIncumplimiento;
    }


    @Column(name = "MII_ACTIVO", nullable = false, length = 1)
    public String getMiiActivo() {
        return miiActivo;
    }

    public void setMiiActivo(String miiActivo) {
        this.miiActivo = miiActivo;
    }

    @Id
    @Column(name = "MII_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MOT_IN_INF_SUP_COD")
    @SequenceGenerator(name = "SEQ_MOT_IN_INF_SUP_COD", sequenceName = "SEQ_MOT_IN_INF_SUP_COD",allocationSize=1)
    public Long getMiiCodigo() {
        return miiCodigo;
    }

    public void setMiiCodigo(Long miiCodigo) {
        this.miiCodigo = miiCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "MIN_CODIGO")
    public SiiMotivoIncumplimiento getSiiMotivoIncumplimiento() {
        return siiMotivoIncumplimiento;
    }

    public void setSiiMotivoIncumplimiento(SiiMotivoIncumplimiento siiMotivoIncumplimiento) {
        this.siiMotivoIncumplimiento = siiMotivoIncumplimiento;
    }

    @ManyToOne
    @JoinColumn(name = "ISU_CODIGO")
    public SiiInformeSupervision getSiiInformeSupervision() {
        return siiInformeSupervision;
    }

    public void setSiiInformeSupervision(SiiInformeSupervision siiInformeSupervision) {
        this.siiInformeSupervision = siiInformeSupervision;
    }
}
