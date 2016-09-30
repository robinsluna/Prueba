package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_EXPEDIENTE_FISICO")
public class SiiExpedienteFisico implements Serializable {
    private static final long serialVersionUID = -5905327145448616794L;
    private String efiActivo;
    private Long efiCodigo;
    private Date efiFecha;
    private List<SiiExpedArchFisico> siiExpedArchFisicoList;
    private List<SiiProcesoContratacion> siiProcesoContratacionList;
    private List<SiiSolicitudAutoriza> siiSolicitudAutorizaList;

    public SiiExpedienteFisico() {
    }

    public SiiExpedienteFisico(String efiActivo, Long efiCodigo, Date efiFecha) {
        this.efiActivo = efiActivo;
        this.efiCodigo = efiCodigo;
        this.efiFecha = efiFecha;
    }

    @Column(name = "EFI_ACTIVO", nullable = false, length = 1)
    public String getEfiActivo() {
        return efiActivo;
    }

    public void setEfiActivo(String efiActivo) {
        this.efiActivo = efiActivo;
    }

    @Id
    @Column(name = "EFI_CODIGO", nullable = false)
    public Long getEfiCodigo() {
        return efiCodigo;
    }

    public void setEfiCodigo(Long efiCodigo) {
        this.efiCodigo = efiCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EFI_FECHA", nullable = false)
    public Date getEfiFecha() {
        return efiFecha;
    }

    public void setEfiFecha(Date efiFecha) {
        this.efiFecha = efiFecha;
    }

    @OneToMany(mappedBy = "siiExpedienteFisico")
    public List<SiiExpedArchFisico> getSiiExpedArchFisicoList() {
        return siiExpedArchFisicoList;
    }

    public void setSiiExpedArchFisicoList(List<SiiExpedArchFisico> siiExpedArchFisicoList) {
        this.siiExpedArchFisicoList = siiExpedArchFisicoList;
    }

    public SiiExpedArchFisico addSiiExpedArchFisico(SiiExpedArchFisico siiExpedArchFisico) {
        getSiiExpedArchFisicoList().add(siiExpedArchFisico);
        siiExpedArchFisico.setSiiExpedienteFisico(this);
        return siiExpedArchFisico;
    }

    public SiiExpedArchFisico removeSiiExpedArchFisico(SiiExpedArchFisico siiExpedArchFisico) {
        getSiiExpedArchFisicoList().remove(siiExpedArchFisico);
        siiExpedArchFisico.setSiiExpedienteFisico(null);
        return siiExpedArchFisico;
    }

    @OneToMany(mappedBy = "siiExpedienteFisico")
    public List<SiiProcesoContratacion> getSiiProcesoContratacionList() {
        return siiProcesoContratacionList;
    }

    public void setSiiProcesoContratacionList(List<SiiProcesoContratacion> siiProcesoContratacionList) {
        this.siiProcesoContratacionList = siiProcesoContratacionList;
    }

    public SiiProcesoContratacion addSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        getSiiProcesoContratacionList().add(siiProcesoContratacion);
        siiProcesoContratacion.setSiiExpedienteFisico(this);
        return siiProcesoContratacion;
    }

    public SiiProcesoContratacion removeSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        getSiiProcesoContratacionList().remove(siiProcesoContratacion);
        siiProcesoContratacion.setSiiExpedienteFisico(null);
        return siiProcesoContratacion;
    }

    @OneToMany(mappedBy = "siiExpedienteFisico")
    public List<SiiSolicitudAutoriza> getSiiSolicitudAutorizaList() {
        return siiSolicitudAutorizaList;
    }

    public void setSiiSolicitudAutorizaList(List<SiiSolicitudAutoriza> siiSolicitudAutorizaList) {
        this.siiSolicitudAutorizaList = siiSolicitudAutorizaList;
    }

    public SiiSolicitudAutoriza addSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().add(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteFisico(this);
        return siiSolicitudAutoriza;
    }

    public SiiSolicitudAutoriza removeSiiSolicitudAutoriza(SiiSolicitudAutoriza siiSolicitudAutoriza) {
        getSiiSolicitudAutorizaList().remove(siiSolicitudAutoriza);
        siiSolicitudAutoriza.setSiiExpedienteFisico(null);
        return siiSolicitudAutoriza;
    }
}
