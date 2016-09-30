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
@Table(name = "SII_POBLACION_ENTE")
public class SiiPoblacionEnte implements Serializable {
    private static final long serialVersionUID = -3045285622831109559L;
    private Long penCodigo;
    private Date penFechaFin;
    private Date penFechaIni;
    private Long penPoblacCabec;
    private Long penPoblacResto;
    private Long penPoblacTotal;
    private SiiEnteTerritorial siiEnteTerritorial;
    private SiiUsuario siiUsuarioConec;
    private SiiCargaPoblacion siiCargaPoblacion;

    public SiiPoblacionEnte() {
    }

    public SiiPoblacionEnte(SiiCargaPoblacion siiCargaPoblacion, SiiEnteTerritorial siiEnteTerritorial, Long penCodigo, Date penFechaFin, Date penFechaIni, Long penPoblacCabec, Long penPoblacResto,
                            Long penPoblacTotal, SiiUsuario siiUsuarioConec) {
        this.siiCargaPoblacion = siiCargaPoblacion;
        this.siiEnteTerritorial = siiEnteTerritorial;
        this.penCodigo = penCodigo;
        this.penFechaFin = penFechaFin;
        this.penFechaIni = penFechaIni;
        this.penPoblacCabec = penPoblacCabec;
        this.penPoblacResto = penPoblacResto;
        this.penPoblacTotal = penPoblacTotal;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "PEN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_POBLACION_ENTE_COD")
    @SequenceGenerator(name = "SEQ_POBLACION_ENTE_COD", sequenceName = "SEQ_POBLACION_ENTE_COD",allocationSize=1)
    public Long getPenCodigo() {
        return penCodigo;
    }

    public void setPenCodigo(Long penCodigo) {
        this.penCodigo = penCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PEN_FECHA_FIN", nullable = false)
    public Date getPenFechaFin() {
        return penFechaFin;
    }

    public void setPenFechaFin(Date penFechaFin) {
        this.penFechaFin = penFechaFin;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PEN_FECHA_INI", nullable = false)
    public Date getPenFechaIni() {
        return penFechaIni;
    }

    public void setPenFechaIni(Date penFechaIni) {
        this.penFechaIni = penFechaIni;
    }

    @Column(name = "PEN_POBLAC_CABEC", nullable = false)
    public Long getPenPoblacCabec() {
        return penPoblacCabec;
    }

    public void setPenPoblacCabec(Long penPoblacCabec) {
        this.penPoblacCabec = penPoblacCabec;
    }

    @Column(name = "PEN_POBLAC_RESTO", nullable = false)
    public Long getPenPoblacResto() {
        return penPoblacResto;
    }

    public void setPenPoblacResto(Long penPoblacResto) {
        this.penPoblacResto = penPoblacResto;
    }

    @Column(name = "PEN_POBLAC_TOTAL", nullable = false)
    public Long getPenPoblacTotal() {
        return penPoblacTotal;
    }

    public void setPenPoblacTotal(Long penPoblacTotal) {
        this.penPoblacTotal = penPoblacTotal;
    }


    @ManyToOne
    @JoinColumn(name = "ETI_CODIGO")
    public SiiEnteTerritorial getSiiEnteTerritorial() {
        return siiEnteTerritorial;
    }

    public void setSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        this.siiEnteTerritorial = siiEnteTerritorial;
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
    @JoinColumn(name = "CPO_CODIGO")
    public SiiCargaPoblacion getSiiCargaPoblacion() {
        return siiCargaPoblacion;
    }

    public void setSiiCargaPoblacion(SiiCargaPoblacion siiCargaPoblacion) {
        this.siiCargaPoblacion = siiCargaPoblacion;
    }
}
