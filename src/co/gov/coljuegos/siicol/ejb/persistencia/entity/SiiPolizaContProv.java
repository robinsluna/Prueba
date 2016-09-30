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
@Table(name = "SII_POLIZA_CONT_PROV")
public class SiiPolizaContProv implements Serializable {
    private static final long serialVersionUID = -2266551547854860956L;
    private Long pcpCodigo;
    private String pcpEstado;
    private Date pcpFechaExped;
    private Date pcpFechaRecep;
    private String pcpNumero;
    private List<SiiAmparoPolContProv> siiAmparoPolContProvList;
    private SiiAseguradora siiAseguradora;
    private SiiArchivoFisico siiArchivoFisico;
    private Date pcpFechaAprob;
    private SiiProcesoContratacion siiProcesoContratacion;

    public SiiPolizaContProv() {
    }

    public SiiPolizaContProv(SiiAseguradora siiAseguradora, Long pcpCodigo, String pcpEstado, Date pcpFechaExped,
                             Date pcpFechaRecep, String pcpNumero, SiiArchivoFisico siiArchivoFisico, Date pcpFechaAprob) {
        this.siiAseguradora = siiAseguradora;
        this.pcpCodigo = pcpCodigo;
        this.pcpEstado = pcpEstado;
        this.pcpFechaAprob = pcpFechaAprob;
        this.pcpFechaExped = pcpFechaExped;
        this.pcpFechaRecep = pcpFechaRecep;
        this.pcpNumero = pcpNumero;
        this.siiArchivoFisico = siiArchivoFisico;
    }


    @Id
    @Column(name = "PCP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_POLIZA_CONT_PROV_COD")
    @SequenceGenerator(name = "SEQ_POLIZA_CONT_PROV_COD", sequenceName = "SEQ_POLIZA_CONT_PROV_COD",allocationSize=1)
    public Long getPcpCodigo() {
        return pcpCodigo;
    }

    public void setPcpCodigo(Long pcpCodigo) {
        this.pcpCodigo = pcpCodigo;
    }

    @Column(name = "PCP_ESTADO", nullable = false, length = 1)
    public String getPcpEstado() {
        return pcpEstado;
    }

    public void setPcpEstado(String pcpEstado) {
        this.pcpEstado = pcpEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCP_FECHA_EXPED", nullable = false)
    public Date getPcpFechaExped() {
        return pcpFechaExped;
    }

    public void setPcpFechaExped(Date pcpFechaExped) {
        this.pcpFechaExped = pcpFechaExped;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCP_FECHA_RECEP", nullable = false)
    public Date getPcpFechaRecep() {
        return pcpFechaRecep;
    }

    public void setPcpFechaRecep(Date pcpFechaRecep) {
        this.pcpFechaRecep = pcpFechaRecep;
    }

    @Column(name = "PCP_NUMERO", nullable = false, length = 50)
    public String getPcpNumero() {
        return pcpNumero;
    }

    public void setPcpNumero(String pcpNumero) {
        this.pcpNumero = pcpNumero;
    }


    @OneToMany(mappedBy = "siiPolizaContProv")
    public List<SiiAmparoPolContProv> getSiiAmparoPolContProvList() {
        return siiAmparoPolContProvList;
    }

    public void setSiiAmparoPolContProvList(List<SiiAmparoPolContProv> siiAmparoPolContProvList) {
        this.siiAmparoPolContProvList = siiAmparoPolContProvList;
    }

    public SiiAmparoPolContProv addSiiAmparoPolContProv(SiiAmparoPolContProv siiAmparoPolContProv) {
        getSiiAmparoPolContProvList().add(siiAmparoPolContProv);
        siiAmparoPolContProv.setSiiPolizaContProv(this);
        return siiAmparoPolContProv;
    }

    public SiiAmparoPolContProv removeSiiAmparoPolContProv(SiiAmparoPolContProv siiAmparoPolContProv) {
        getSiiAmparoPolContProvList().remove(siiAmparoPolContProv);
        siiAmparoPolContProv.setSiiPolizaContProv(null);
        return siiAmparoPolContProv;
    }

    @ManyToOne
    @JoinColumn(name = "ASE_CODIGO")
    public SiiAseguradora getSiiAseguradora() {
        return siiAseguradora;
    }

    public void setSiiAseguradora(SiiAseguradora siiAseguradora) {
        this.siiAseguradora = siiAseguradora;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCP_FECHA_APROB")
    public Date getPcpFechaAprob() {
        return pcpFechaAprob;
    }

    public void setPcpFechaAprob(Date pcpFechaAprob) {
        this.pcpFechaAprob = pcpFechaAprob;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }
}
