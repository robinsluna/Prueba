package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

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
@Table(name = "SII_HISTORIAL_ROL")
public class SiiHistorialRol implements Serializable {
    private static final long serialVersionUID = -2556228068751592171L;
    private Long hroCodigo;
    private Date hroFechaActInacPer;
    private Date hroFechaActivRol;
    private Date hroFechaAsigna;
    private Date hroFechaDesasigna;
    private Date hroFechaInactivRol;
    private SiiRol siiRol;
    private SiiUsuario siiUsuarioConec;
    private List<SiiHistorialPermiso> siiHistorialPermisoList;

    public SiiHistorialRol() {
    }

    public SiiHistorialRol(Long hroCodigo, Date hroFechaActInacPer, Date hroFechaActivRol, Date hroFechaAsigna, Date hroFechaDesasigna, Date hroFechaInactivRol, SiiRol siiRol,
                           SiiUsuario siiUsuarioConec) {
        this.hroCodigo = hroCodigo;
        this.hroFechaActInacPer = hroFechaActInacPer;
        this.hroFechaActivRol = hroFechaActivRol;
        this.hroFechaAsigna = hroFechaAsigna;
        this.hroFechaDesasigna = hroFechaDesasigna;
        this.hroFechaInactivRol = hroFechaInactivRol;
        this.siiRol = siiRol;
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @Id
    @Column(name = "HRO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_HISTORIAL_ROL_COD")
    @SequenceGenerator(name = "SEQ_HISTORIAL_ROL_COD", sequenceName = "SEQ_HISTORIAL_ROL_COD",allocationSize=1)
    public Long getHroCodigo() {
        return hroCodigo;
    }

    public void setHroCodigo(Long hroCodigo) {
        this.hroCodigo = hroCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HRO_FECHA_ACT_INAC_PER", nullable = false)
    public Date getHroFechaActInacPer() {
        return hroFechaActInacPer;
    }

    public void setHroFechaActInacPer(Date hroFechaActInacPer) {
        this.hroFechaActInacPer = hroFechaActInacPer;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HRO_FECHA_ACTIV_ROL")
    public Date getHroFechaActivRol() {
        return hroFechaActivRol;
    }

    public void setHroFechaActivRol(Date hroFechaActivRol) {
        this.hroFechaActivRol = hroFechaActivRol;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HRO_FECHA_ASIGNA")
    public Date getHroFechaAsigna() {
        return hroFechaAsigna;
    }

    public void setHroFechaAsigna(Date hroFechaAsigna) {
        this.hroFechaAsigna = hroFechaAsigna;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HRO_FECHA_DESASIGNA")
    public Date getHroFechaDesasigna() {
        return hroFechaDesasigna;
    }

    public void setHroFechaDesasigna(Date hroFechaDesasigna) {
        this.hroFechaDesasigna = hroFechaDesasigna;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "HRO_FECHA_INACTIV_ROL")
    public Date getHroFechaInactivRol() {
        return hroFechaInactivRol;
    }

    public void setHroFechaInactivRol(Date hroFechaInactivRol) {
        this.hroFechaInactivRol = hroFechaInactivRol;
    }


    @ManyToOne
    @JoinColumn(name = "ROL_CODIGO")
    public SiiRol getSiiRol() {
        return siiRol;
    }

    public void setSiiRol(SiiRol siiRol) {
        this.siiRol = siiRol;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @OneToMany(mappedBy = "siiHistorialRol")
    public List<SiiHistorialPermiso> getSiiHistorialPermisoList() {
        return siiHistorialPermisoList;
    }

    public void setSiiHistorialPermisoList(List<SiiHistorialPermiso> siiHistorialPermisoList) {
        this.siiHistorialPermisoList = siiHistorialPermisoList;
    }

    public SiiHistorialPermiso addSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().add(siiHistorialPermiso);
        siiHistorialPermiso.setSiiHistorialRol(this);
        return siiHistorialPermiso;
    }

    public SiiHistorialPermiso removeSiiHistorialPermiso(SiiHistorialPermiso siiHistorialPermiso) {
        getSiiHistorialPermisoList().remove(siiHistorialPermiso);
        siiHistorialPermiso.setSiiHistorialRol(null);
        return siiHistorialPermiso;
    }
}
