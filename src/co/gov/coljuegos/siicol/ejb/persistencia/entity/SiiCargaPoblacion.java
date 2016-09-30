package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_CARGA_POBLACION")
public class SiiCargaPoblacion implements Serializable {
    private static final long serialVersionUID = -2944125903039678756L;
    private Long cpoCodigo;
    private Integer cpoConsecutivoCar;
    private Date cpoFechaRad;
    private Date cpoFechaRegistro;
    private String cpoFuente;
    private String cpoNumeroRad;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiUsuario siiUsuarioConec;
    private List<SiiPoblacionEnte> siiPoblacionEnteList;

    public SiiCargaPoblacion() {
    }

    public SiiCargaPoblacion(SiiArchivoFisico siiArchivoFisico, Long cpoCodigo, Integer cpoConsecutivoCar, Date cpoFechaRad, Date cpoFechaRegistro, String cpoFuente, String cpoNumeroRad,
                             SiiUsuario siiUsuarioConec) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.cpoCodigo = cpoCodigo;
        this.cpoConsecutivoCar = cpoConsecutivoCar;
        this.cpoFechaRad = cpoFechaRad;
        this.cpoFechaRegistro = cpoFechaRegistro;
        this.cpoFuente = cpoFuente;
        this.cpoNumeroRad = cpoNumeroRad;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "CPO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CARGA_POBLACION_COD")
    @SequenceGenerator(name = "SEQ_CARGA_POBLACION_COD", sequenceName = "SEQ_CARGA_POBLACION_COD",allocationSize=1)
    public Long getCpoCodigo() {
        return cpoCodigo;
    }

    public void setCpoCodigo(Long cpoCodigo) {
        this.cpoCodigo = cpoCodigo;
    }

    @Column(name = "CPO_CONSECUTIVO_CAR", nullable = false)
    public Integer getCpoConsecutivoCar() {
        return cpoConsecutivoCar;
    }

    public void setCpoConsecutivoCar(Integer cpoConsecutivoCar) {
        this.cpoConsecutivoCar = cpoConsecutivoCar;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CPO_FECHA_RAD", nullable = false)
    public Date getCpoFechaRad() {
        return cpoFechaRad;
    }

    public void setCpoFechaRad(Date cpoFechaRad) {
        this.cpoFechaRad = cpoFechaRad;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CPO_FECHA_REGISTRO", nullable = false)
    public Date getCpoFechaRegistro() {
        return cpoFechaRegistro;
    }

    public void setCpoFechaRegistro(Date cpoFechaRegistro) {
        this.cpoFechaRegistro = cpoFechaRegistro;
    }

    @Column(name = "CPO_FUENTE", nullable = false, length = 1)
    public String getCpoFuente() {
        return cpoFuente;
    }

    public void setCpoFuente(String cpoFuente) {
        this.cpoFuente = cpoFuente;
    }

    @Column(name = "CPO_NUMERO_RAD", length = 30)
    public String getCpoNumeroRad() {
        return cpoNumeroRad;
    }

    public void setCpoNumeroRad(String cpoNumeroRad) {
        this.cpoNumeroRad = cpoNumeroRad;
    }


    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiCargaPoblacion")
    public List<SiiPoblacionEnte> getSiiPoblacionEnteList() {
        return siiPoblacionEnteList;
    }

    public void setSiiPoblacionEnteList(List<SiiPoblacionEnte> siiPoblacionEnteList) {
        this.siiPoblacionEnteList = siiPoblacionEnteList;
    }

    public SiiPoblacionEnte addSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteList().add(siiPoblacionEnte);
        siiPoblacionEnte.setSiiCargaPoblacion(this);
        return siiPoblacionEnte;
    }

    public SiiPoblacionEnte removeSiiPoblacionEnte(SiiPoblacionEnte siiPoblacionEnte) {
        getSiiPoblacionEnteList().remove(siiPoblacionEnte);
        siiPoblacionEnte.setSiiCargaPoblacion(null);
        return siiPoblacionEnte;
    }
}
