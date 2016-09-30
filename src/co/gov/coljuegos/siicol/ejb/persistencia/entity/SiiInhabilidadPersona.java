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
@Table(name = "SII_INHABILIDAD_PERSONA")
public class SiiInhabilidadPersona implements Serializable {
    private static final long serialVersionUID = 3286009017187508873L;
    private String ipeActivo;
    private Long ipeCodigo;
    private Date ipeFechaFin;
    private Date ipeFechaIni;
    private SiiUsuario siiUsuarioConec;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private SiiIncumplimientoContr siiIncumplimientoContr;
    private SiiPersona siiPersona;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;

    public SiiInhabilidadPersona() {
    }

    public SiiInhabilidadPersona(SiiIncumplimientoContr siiIncumplimientoContr, String ipeActivo, Long ipeCodigo, Date ipeFechaFin, Date ipeFechaIni, SiiPersona siiPersona,
                                 SiiProcesoSancIlegalidad siiProcesoSancIlegalidad, SiiProcesoSancionatorio siiProcesoSancionatorio, SiiUsuario siiUsuarioConec) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
        this.ipeActivo = ipeActivo;
        this.ipeCodigo = ipeCodigo;
        this.ipeFechaFin = ipeFechaFin;
        this.ipeFechaIni = ipeFechaIni;
        this.siiPersona = siiPersona;
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Column(name = "IPE_ACTIVO", nullable = false, length = 1)
    public String getIpeActivo() {
        return ipeActivo;
    }

    public void setIpeActivo(String ipeActivo) {
        this.ipeActivo = ipeActivo;
    }

    @Id
    @Column(name = "IPE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_INHABILIDAD_PERSONA_COD")
    @SequenceGenerator(name = "SEQ_INHABILIDAD_PERSONA_COD", sequenceName = "SEQ_INHABILIDAD_PERSONA_COD",allocationSize=1)
    public Long getIpeCodigo() {
        return ipeCodigo;
    }

    public void setIpeCodigo(Long ipeCodigo) {
        this.ipeCodigo = ipeCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPE_FECHA_FIN", nullable = false)
    public Date getIpeFechaFin() {
        return ipeFechaFin;
    }

    public void setIpeFechaFin(Date ipeFechaFin) {
        this.ipeFechaFin = ipeFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "IPE_FECHA_INI", nullable = false)
    public Date getIpeFechaIni() {
        return ipeFechaIni;
    }

    public void setIpeFechaIni(Date ipeFechaIni) {
        this.ipeFechaIni = ipeFechaIni;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
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
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }
}
