package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_ACTA_SUSPEN_AUD_INCUM_CON")
public class SiiActaSuspenAudIncumCon implements Serializable {
    private static final long serialVersionUID = -2423200746017856177L;
    private Long asaCodigo;
    private Date asaFecha;
    private Date asaFechaReanud;
    private String asaMotivo;
    private String asaObservaciones;
    private SiiIncumplimientoContr siiIncumplimientoContr;

    public SiiActaSuspenAudIncumCon() {
    }

    public SiiActaSuspenAudIncumCon(Long asaCodigo, Date asaFecha, Date asaFechaReanud, String asaMotivo, String asaObservaciones, SiiIncumplimientoContr siiIncumplimientoContr) {
        this.asaCodigo = asaCodigo;
        this.asaFecha = asaFecha;
        this.asaFechaReanud = asaFechaReanud;
        this.asaMotivo = asaMotivo;
        this.asaObservaciones = asaObservaciones;
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }

    @Id
    @Column(name = "ASA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTA_SUSP_AUD_INCUM_COD")
    @SequenceGenerator(name = "SEQ_ACTA_SUSP_AUD_INCUM_COD", sequenceName = "SEQ_ACTA_SUSP_AUD_INCUM_COD",allocationSize=1)
    public Long getAsaCodigo() {
        return asaCodigo;
    }

    public void setAsaCodigo(Long asaCodigo) {
        this.asaCodigo = asaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ASA_FECHA", nullable = false)
    public Date getAsaFecha() {
        return asaFecha;
    }

    public void setAsaFecha(Date asaFecha) {
        this.asaFecha = asaFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ASA_FECHA_REANUD")
    public Date getAsaFechaReanud() {
        return asaFechaReanud;
    }

    public void setAsaFechaReanud(Date asaFechaReanud) {
        this.asaFechaReanud = asaFechaReanud;
    }

    @Column(name = "ASA_MOTIVO", nullable = false, length = 55)
    public String getAsaMotivo() {
        return asaMotivo;
    }

    public void setAsaMotivo(String asaMotivo) {
        this.asaMotivo = asaMotivo;
    }

    @Column(name = "ASA_OBSERVACIONES", nullable = false, length = 550)
    public String getAsaObservaciones() {
        return asaObservaciones;
    }

    public void setAsaObservaciones(String asaObservaciones) {
        this.asaObservaciones = asaObservaciones;
    }


    @ManyToOne
    @JoinColumn(name = "ICN_CODIGO")
    public SiiIncumplimientoContr getSiiIncumplimientoContr() {
        return siiIncumplimientoContr;
    }

    public void setSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }
}
