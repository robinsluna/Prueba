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
@Table(name = "SII_DOCUMENTO_CONPES")
public class SiiDocumentoConpes implements Serializable {
    private static final long serialVersionUID = -937633003818423321L;
    private String dcnActivo;
    private Long dcnCodigo;
    private Date dcnFecha;
    private Date dcnFechaReg;
    private String dcnNumero;
    private SiiEstadoDocConpes siiEstadoDocConpes;
    private List<SiiDistribucionUbica> siiDistribucionUbicaList;
    private SiiArchivoFisico siiArchivoFisico;
    private List<SiiDistribucionMes> siiDistribucionMesList;

    public SiiDocumentoConpes() {
    }

    public SiiDocumentoConpes(SiiArchivoFisico siiArchivoFisico, String dcnActivo, Long dcnCodigo, Date dcnFecha,
                              Date dcnFechaReg, String dcnNumero, SiiEstadoDocConpes siiEstadoDocConpes) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.dcnActivo = dcnActivo;
        this.dcnCodigo = dcnCodigo;
        this.dcnFecha = dcnFecha;
        this.dcnFechaReg = dcnFechaReg;
        this.dcnNumero = dcnNumero;
        this.siiEstadoDocConpes = siiEstadoDocConpes;
    }


    @Column(name = "DCN_ACTIVO", nullable = false, length = 1)
    public String getDcnActivo() {
        return dcnActivo;
    }

    public void setDcnActivo(String dcnActivo) {
        this.dcnActivo = dcnActivo;
    }

    @Id
    @Column(name = "DCN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DOCUMENTO_CONPES_COD")
    @SequenceGenerator(name = "SEQ_DOCUMENTO_CONPES_COD", sequenceName = "SEQ_DOCUMENTO_CONPES_COD",allocationSize=1)
    public Long getDcnCodigo() {
        return dcnCodigo;
    }

    public void setDcnCodigo(Long dcnCodigo) {
        this.dcnCodigo = dcnCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCN_FECHA", nullable = false)
    public Date getDcnFecha() {
        return dcnFecha;
    }

    public void setDcnFecha(Date dcnFecha) {
        this.dcnFecha = dcnFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DCN_FECHA_REG", nullable = false)
    public Date getDcnFechaReg() {
        return dcnFechaReg;
    }

    public void setDcnFechaReg(Date dcnFechaReg) {
        this.dcnFechaReg = dcnFechaReg;
    }

    @Column(name = "DCN_NUMERO", nullable = false, length = 10)
    public String getDcnNumero() {
        return dcnNumero;
    }

    public void setDcnNumero(String dcnNumero) {
        this.dcnNumero = dcnNumero;
    }


    @ManyToOne
    @JoinColumn(name = "EDC_CODIGO")
    public SiiEstadoDocConpes getSiiEstadoDocConpes() {
        return siiEstadoDocConpes;
    }

    public void setSiiEstadoDocConpes(SiiEstadoDocConpes siiEstadoDocConpes) {
        this.siiEstadoDocConpes = siiEstadoDocConpes;
    }

    @OneToMany(mappedBy = "siiDocumentoConpes")
    public List<SiiDistribucionUbica> getSiiDistribucionUbicaList() {
        return siiDistribucionUbicaList;
    }

    public void setSiiDistribucionUbicaList(List<SiiDistribucionUbica> siiDistribucionUbicaList) {
        this.siiDistribucionUbicaList = siiDistribucionUbicaList;
    }

    public SiiDistribucionUbica addSiiDistribucionUbica(SiiDistribucionUbica siiDistribucionUbica) {
        getSiiDistribucionUbicaList().add(siiDistribucionUbica);
        siiDistribucionUbica.setSiiDocumentoConpes(this);
        return siiDistribucionUbica;
    }

    public SiiDistribucionUbica removeSiiDistribucionUbica(SiiDistribucionUbica siiDistribucionUbica) {
        getSiiDistribucionUbicaList().remove(siiDistribucionUbica);
        siiDistribucionUbica.setSiiDocumentoConpes(null);
        return siiDistribucionUbica;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @OneToMany(mappedBy = "siiDocumentoConpes")
    public List<SiiDistribucionMes> getSiiDistribucionMesList() {
        return siiDistribucionMesList;
    }

    public void setSiiDistribucionMesList(List<SiiDistribucionMes> siiDistribucionMesList) {
        this.siiDistribucionMesList = siiDistribucionMesList;
    }

    public SiiDistribucionMes addSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().add(siiDistribucionMes);
        siiDistribucionMes.setSiiDocumentoConpes(this);
        return siiDistribucionMes;
    }

    public SiiDistribucionMes removeSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().remove(siiDistribucionMes);
        siiDistribucionMes.setSiiDocumentoConpes(null);
        return siiDistribucionMes;
    }
}
