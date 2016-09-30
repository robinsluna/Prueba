package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_EXPED_ARCH_FISICO")
public class SiiExpedArchFisico implements Serializable {
    private static final long serialVersionUID = 214140896743631425L;
    private String eafActivo;
    private Long eafCodigo;
    private SiiExpedienteFisico siiExpedienteFisico;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiExpedArchFisico() {
    }

    public SiiExpedArchFisico(SiiArchivoFisico siiArchivoFisico, String eafActivo, Long eafCodigo,
                              SiiExpedienteFisico siiExpedienteFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.eafActivo = eafActivo;
        this.eafCodigo = eafCodigo;
        this.siiExpedienteFisico = siiExpedienteFisico;
    }


    @Column(name = "EAF_ACTIVO", nullable = false, length = 1)
    public String getEafActivo() {
        return eafActivo;
    }

    public void setEafActivo(String eafActivo) {
        this.eafActivo = eafActivo;
    }

    @Id
    @Column(name = "EAF_CODIGO", nullable = false)
    public Long getEafCodigo() {
        return eafCodigo;
    }

    public void setEafCodigo(Long eafCodigo) {
        this.eafCodigo = eafCodigo;
    }


    @ManyToOne
    @JoinColumn(name = "EFI_CODIGO")
    public SiiExpedienteFisico getSiiExpedienteFisico() {
        return siiExpedienteFisico;
    }

    public void setSiiExpedienteFisico(SiiExpedienteFisico siiExpedienteFisico) {
        this.siiExpedienteFisico = siiExpedienteFisico;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
}
