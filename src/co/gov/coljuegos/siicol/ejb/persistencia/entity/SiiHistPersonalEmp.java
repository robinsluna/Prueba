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
@Table(name = "SII_HIST_PERSONAL_EMP")
public class SiiHistPersonalEmp implements Serializable {
    private static final long serialVersionUID = -6315790693771624463L;
    private String hpmActivo;
    private Long hpmCodigo;
    private Date hpmFechaInactivac;
    private Date hpmFechaRegistro;
    private BigDecimal hpmPorcentajePart;
    private SiiHistPersona siiHistPersonaEmpresa;
    private SiiTipoPersonal siiTipoPersonal;
    private SiiHistPersona siiHistPersonaPersona;

    public SiiHistPersonalEmp() {
    }

    public SiiHistPersonalEmp(SiiHistPersona siiHistPersonaPersona, SiiHistPersona siiHistPersonaEmpresa,
                              String hpmActivo, Long hpmCodigo, Date hpmFechaInactivac, Date hpmFechaRegistro,
                              BigDecimal hpmPorcentajePart, SiiTipoPersonal siiTipoPersonal) {
        this.siiHistPersonaPersona = siiHistPersonaPersona;
        this.siiHistPersonaEmpresa = siiHistPersonaEmpresa;
        this.hpmActivo = hpmActivo;
        this.hpmCodigo = hpmCodigo;
        this.hpmFechaInactivac = hpmFechaInactivac;
        this.hpmFechaRegistro = hpmFechaRegistro;
        this.hpmPorcentajePart = hpmPorcentajePart;
        this.siiTipoPersonal = siiTipoPersonal;
    }


    @Column(name = "HPM_ACTIVO", nullable = false, length = 1)
    public String getHpmActivo() {
        return hpmActivo;
    }

    public void setHpmActivo(String hpmActivo) {
        this.hpmActivo = hpmActivo;
    }

    @Id
    @Column(name = "HPM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HIST_PERSONAL_EMP_COD")
    @SequenceGenerator(name = "SEQ_HIST_PERSONAL_EMP_COD", sequenceName = "SEQ_HIST_PERSONAL_EMP_COD",
                       allocationSize = 1)
    public Long getHpmCodigo() {
        return hpmCodigo;
    }

    public void setHpmCodigo(Long hpmCodigo) {
        this.hpmCodigo = hpmCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HPM_FECHA_INACTIVAC")
    public Date getHpmFechaInactivac() {
        return hpmFechaInactivac;
    }

    public void setHpmFechaInactivac(Date hpmFechaInactivac) {
        this.hpmFechaInactivac = hpmFechaInactivac;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HPM_FECHA_REGISTRO", nullable = false)
    public Date getHpmFechaRegistro() {
        return hpmFechaRegistro;
    }

    public void setHpmFechaRegistro(Date hpmFechaRegistro) {
        this.hpmFechaRegistro = hpmFechaRegistro;
    }

    @Column(name = "HPM_PORCENTAJE_PART")
    public BigDecimal getHpmPorcentajePart() {
        return hpmPorcentajePart;
    }

    public void setHpmPorcentajePart(BigDecimal hpmPorcentajePart) {
        this.hpmPorcentajePart = hpmPorcentajePart;
    }


    @ManyToOne
    @JoinColumn(name = "HPE_CODIGO_EMPRESA")
    public SiiHistPersona getSiiHistPersonaEmpresa() {
        return siiHistPersonaEmpresa;
    }

    public void setSiiHistPersonaEmpresa(SiiHistPersona siiHistPersonaEmpresa) {
        this.siiHistPersonaEmpresa = siiHistPersonaEmpresa;
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
    @JoinColumn(name = "HPE_CODIGO")
    public SiiHistPersona getSiiHistPersonaPersona() {
        return siiHistPersonaPersona;
    }

    public void setSiiHistPersonaPersona(SiiHistPersona siiHistPersonaPersona) {
        this.siiHistPersonaPersona = siiHistPersonaPersona;
    }
}
