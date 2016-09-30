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
@Table(name = "SII_DIRECCION_PROCESAL_INC")
public class SiiDireccionProcesalInc implements Serializable {
    private static final long serialVersionUID = -3369625570349880805L;
    private String dpiActivo;
    private Long dpiCodigo;
    private String dpiDireccion;
    private Date dpiFechaActiv;
    private Date dpiFechaInac;
    private SiiIncumplimientoContr siiIncumplimientoContr;
    private SiiOperador siiOperador;

    public SiiDireccionProcesalInc() {
    }

    public SiiDireccionProcesalInc(String dpiActivo, Long dpiCodigo, String dpiDireccion, Date dpiFechaActiv, Date dpiFechaInac, SiiIncumplimientoContr siiIncumplimientoContr,
                                   SiiOperador siiOperador) {
        this.dpiActivo = dpiActivo;
        this.dpiCodigo = dpiCodigo;
        this.dpiDireccion = dpiDireccion;
        this.dpiFechaActiv = dpiFechaActiv;
        this.dpiFechaInac = dpiFechaInac;
        this.siiIncumplimientoContr = siiIncumplimientoContr;
        this.siiOperador = siiOperador;
    }

    @Column(name = "DPI_ACTIVO", nullable = false, length = 1)
    public String getDpiActivo() {
        return dpiActivo;
    }

    public void setDpiActivo(String dpiActivo) {
        this.dpiActivo = dpiActivo;
    }

    @Id
    @Column(name = "DPI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DIRECC_PROCESAL_INC_COD")
    @SequenceGenerator(name = "SEQ_DIRECC_PROCESAL_INC_COD", sequenceName = "SEQ_DIRECC_PROCESAL_INC_COD",allocationSize=1)
    public Long getDpiCodigo() {
        return dpiCodigo;
    }

    public void setDpiCodigo(Long dpiCodigo) {
        this.dpiCodigo = dpiCodigo;
    }

    @Column(name = "DPI_DIRECCION", nullable = false, length = 150)
    public String getDpiDireccion() {
        return dpiDireccion;
    }

    public void setDpiDireccion(String dpiDireccion) {
        this.dpiDireccion = dpiDireccion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DPI_FECHA_ACTIV", nullable = false)
    public Date getDpiFechaActiv() {
        return dpiFechaActiv;
    }

    public void setDpiFechaActiv(Date dpiFechaActiv) {
        this.dpiFechaActiv = dpiFechaActiv;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DPI_FECHA_INAC")
    public Date getDpiFechaInac() {
        return dpiFechaInac;
    }

    public void setDpiFechaInac(Date dpiFechaInac) {
        this.dpiFechaInac = dpiFechaInac;
    }


    @ManyToOne
    @JoinColumn(name = "ICN_CODIGO")
    public SiiIncumplimientoContr getSiiIncumplimientoContr() {
        return siiIncumplimientoContr;
    }

    public void setSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }

    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador() {
        return siiOperador;
    }

    public void setSiiOperador(SiiOperador siiOperador) {
        this.siiOperador = siiOperador;
    }
}
