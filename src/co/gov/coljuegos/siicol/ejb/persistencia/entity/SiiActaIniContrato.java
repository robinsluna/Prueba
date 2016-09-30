package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_ACTA_INI_CONTRATO")
public class SiiActaIniContrato implements Serializable {
    private static final long serialVersionUID = -7740917837729776048L;
    private Long acnCodigo;
    private List<SiiInformeContrProv> siiInformeContrProvList;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiProcesoContratacion siiProcesoContratacion;
    private SiiClaseContrato siiClaseContrato;
    private List<SiiInformeActaIni> siiInformeActaIniList;
    private Date acnFechaIni;
    private Integer acnEstado;

    public SiiActaIniContrato() {
    }

    public SiiActaIniContrato(Long acnCodigo, SiiArchivoFisico siiArchivoFisico, SiiClaseContrato siiClaseContrato,
                              SiiProcesoContratacion siiProcesoContratacion) {
        this.acnCodigo = acnCodigo;
        this.siiArchivoFisico = siiArchivoFisico;
        this.siiClaseContrato = siiClaseContrato;
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @Id
    @Column(name = "ACN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACTA_INI_CONTR_COD")
    @SequenceGenerator(name = "SEQ_ACTA_INI_CONTR_COD", sequenceName = "SEQ_ACTA_INI_CONTR_COD",allocationSize=1)
    public Long getAcnCodigo() {
        return acnCodigo;
    }

    public void setAcnCodigo(Long acnCodigo) {
        this.acnCodigo = acnCodigo;
    }


    @OneToMany(mappedBy = "siiActaIniContrato")
    public List<SiiInformeContrProv> getSiiInformeContrProvList() {
        return siiInformeContrProvList;
    }

    public void setSiiInformeContrProvList(List<SiiInformeContrProv> siiInformeContrProvList) {
        this.siiInformeContrProvList = siiInformeContrProvList;
    }

    public SiiInformeContrProv addSiiInformeContrProv(SiiInformeContrProv siiInformeContrProv) {
        getSiiInformeContrProvList().add(siiInformeContrProv);
        siiInformeContrProv.setSiiActaIniContrato(this);
        return siiInformeContrProv;
    }

    public SiiInformeContrProv removeSiiInformeContrProv(SiiInformeContrProv siiInformeContrProv) {
        getSiiInformeContrProvList().remove(siiInformeContrProv);
        siiInformeContrProv.setSiiActaIniContrato(null);
        return siiInformeContrProv;
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
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @ManyToOne
    @JoinColumn(name = "CLC_CODIGO")
    public SiiClaseContrato getSiiClaseContrato() {
        return siiClaseContrato;
    }

    public void setSiiClaseContrato(SiiClaseContrato siiClaseContrato) {
        this.siiClaseContrato = siiClaseContrato;
    }

    @OneToMany(mappedBy = "siiActaIniContrato")
    public List<SiiInformeActaIni> getSiiInformeActaIniList() {
        return siiInformeActaIniList;
    }

    public void setSiiInformeActaIniList(List<SiiInformeActaIni> siiInformeActaIniList) {
        this.siiInformeActaIniList = siiInformeActaIniList;
    }

    public SiiInformeActaIni addSiiInformeActaIni(SiiInformeActaIni siiInformeActaIni) {
        getSiiInformeActaIniList().add(siiInformeActaIni);
        siiInformeActaIni.setSiiActaIniContrato(this);
        return siiInformeActaIni;
    }

    public SiiInformeActaIni removeSiiInformeActaIni(SiiInformeActaIni siiInformeActaIni) {
        getSiiInformeActaIniList().remove(siiInformeActaIni);
        siiInformeActaIni.setSiiActaIniContrato(null);
        return siiInformeActaIni;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACN_FECHA_INI", nullable = false)
    public Date getAcnFechaIni() {
        return acnFechaIni;
    }

    public void setAcnFechaIni(Date acnFechaIni) {
        this.acnFechaIni = acnFechaIni;
    }

    @Column(name = "ACN_ESTADO", nullable = false)
    public Integer getAcnEstado() {
        return acnEstado;
    }

    public void setAcnEstado(Integer acnEstado) {
        this.acnEstado = acnEstado;
    }
}
