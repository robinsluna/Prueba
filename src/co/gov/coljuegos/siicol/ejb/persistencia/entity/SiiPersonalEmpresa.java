package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_PERSONAL_EMPRESA")
public class SiiPersonalEmpresa implements Serializable {
    private static final long serialVersionUID = 2573795962987623251L;
    private String pemActivo;
    private Long pemCodigo;
    private Date pemFechaInactivac;
    private Date pemFechaRegistro;
    private SiiTipoPersonal siiTipoPersonal;
    private SiiPersona siiPersona; //Persona Empresa
    private SiiPersona siiPersona3; //Persona
    private BigDecimal pemPorcentajePart;

    public SiiPersonalEmpresa() {
    }

    public SiiPersonalEmpresa(String pemActivo, Long pemCodigo, Date pemFechaRegistro, SiiPersona siiPersona3,
                              SiiPersona siiPersona, SiiTipoPersonal siiTipoPersonal, Date pemFechaInactivac,
                              BigDecimal pemPorcentajePart) {
        this.pemActivo = pemActivo;
        this.pemCodigo = pemCodigo;
        this.pemFechaInactivac = pemFechaInactivac;
        this.pemFechaRegistro = pemFechaRegistro;
        this.siiPersona3 = siiPersona3;
        this.siiPersona = siiPersona;
        this.siiTipoPersonal = siiTipoPersonal;
        this.pemPorcentajePart = pemPorcentajePart;
    }

    @Column(name = "PEM_ACTIVO", nullable = false, length = 1)
    public String getPemActivo() {
        return pemActivo;
    }

    public void setPemActivo(String pemActivo) {
        this.pemActivo = pemActivo;
    }

    @Id
    @Column(name = "PEM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PERSONAL_EMPRESA_COD")
    @SequenceGenerator(name = "SEQ_PERSONAL_EMPRESA_COD", sequenceName = "SEQ_PERSONAL_EMPRESA_COD", allocationSize = 1)
    public Long getPemCodigo() {
        return pemCodigo;
    }

    public void setPemCodigo(Long pemCodigo) {
        this.pemCodigo = pemCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PEM_FECHA_INACTIVAC")
    public Date getPemFechaInactivac() {
        return pemFechaInactivac;
    }

    public void setPemFechaInactivac(Date pemFechaInactivac) {
        this.pemFechaInactivac = pemFechaInactivac;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PEM_FECHA_REGISTRO", nullable = false)
    public Date getPemFechaRegistro() {
        return pemFechaRegistro;
    }

    public void setPemFechaRegistro(Date pemFechaRegistro) {
        this.pemFechaRegistro = pemFechaRegistro;
    }

    @Column(name = "PEM_PORCENTAJE_PART")
    public BigDecimal getPemPorcentajePart() {
        return pemPorcentajePart;
    }

    public void setPemPorcentajePart(BigDecimal pemPorcentajePart) {
        this.pemPorcentajePart = pemPorcentajePart;
    }

    @ManyToOne
    @JoinColumn(name = "TPE_CODIGO")
    public SiiTipoPersonal getSiiTipoPersonal() {
        return siiTipoPersonal;
    }

    public void setSiiTipoPersonal(SiiTipoPersonal siiTipoPersonal) {
        this.siiTipoPersonal = siiTipoPersonal;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_EMPRESA")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona3() {
        return siiPersona3;
    }

    public void setSiiPersona3(SiiPersona siiPersona3) {
        this.siiPersona3 = siiPersona3;
    }
}
