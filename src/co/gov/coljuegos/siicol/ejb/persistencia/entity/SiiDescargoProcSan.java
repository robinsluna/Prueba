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
@Table(name = "SII_DESCARGO_PROC_SAN")
public class SiiDescargoProcSan implements Serializable {
    private static final long serialVersionUID = -7361754983362156733L;
    private Long dpsCodigo;
    private Date dpsFechaRad;
    private String dpsPruebasSol;
    private String dpsRadicado;
    private String dpsSolicitaPru;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;

    public SiiDescargoProcSan() {
    }

    public SiiDescargoProcSan(Long dpsCodigo, Date dpsFechaRad, String dpsPruebasSol, String dpsRadicado, String dpsSolicitaPru, SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.dpsCodigo = dpsCodigo;
        this.dpsFechaRad = dpsFechaRad;
        this.dpsPruebasSol = dpsPruebasSol;
        this.dpsRadicado = dpsRadicado;
        this.dpsSolicitaPru = dpsSolicitaPru;
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @Id
    @Column(name = "DPS_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DESCARGO_PROC_SAN_COD")
    @SequenceGenerator(name = "SEQ_DESCARGO_PROC_SAN_COD", sequenceName = "SEQ_DESCARGO_PROC_SAN_COD",allocationSize=1)
    public Long getDpsCodigo() {
        return dpsCodigo;
    }

    public void setDpsCodigo(Long dpsCodigo) {
        this.dpsCodigo = dpsCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DPS_FECHA_RAD", nullable = false)
    public Date getDpsFechaRad() {
        return dpsFechaRad;
    }

    public void setDpsFechaRad(Date dpsFechaRad) {
        this.dpsFechaRad = dpsFechaRad;
    }

    @Column(name = "DPS_PRUEBAS_SOL")
    public String getDpsPruebasSol() {
        return dpsPruebasSol;
    }

    public void setDpsPruebasSol(String dpsPruebasSol) {
        this.dpsPruebasSol = dpsPruebasSol;
    }

    @Column(name = "DPS_RADICADO", nullable = false, length = 30)
    public String getDpsRadicado() {
        return dpsRadicado;
    }

    public void setDpsRadicado(String dpsRadicado) {
        this.dpsRadicado = dpsRadicado;
    }

    @Column(name = "DPS_SOLICITA_PRU", nullable = false, length = 1)
    public String getDpsSolicitaPru() {
        return dpsSolicitaPru;
    }

    public void setDpsSolicitaPru(String dpsSolicitaPru) {
        this.dpsSolicitaPru = dpsSolicitaPru;
    }


    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }
}
