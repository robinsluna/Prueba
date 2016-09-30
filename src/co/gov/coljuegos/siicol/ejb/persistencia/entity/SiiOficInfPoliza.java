package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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
@Table(name = "SII_OFIC_INF_POLIZA")
public class SiiOficInfPoliza implements Serializable {
    private static final long serialVersionUID = -7274191414366093694L;
    private Long oipCodigo;
    private Date oipFechaRadic;
    private String oipNumRadica;
    private String oipTipoDocum;
    private SiiArchivoFisico siiArchivoFisico;
    private SiiPolizaContrat siiPolizaContrat;

    public SiiOficInfPoliza() {
    }

    public SiiOficInfPoliza(SiiArchivoFisico siiArchivoFisico, Long oipCodigo, Date oipFechaRadic, String oipNumRadica,
                            String oipTipoDocum, SiiPolizaContrat siiPolizaContrat) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.oipCodigo = oipCodigo;
        this.oipFechaRadic = oipFechaRadic;
        this.oipNumRadica = oipNumRadica;
        this.oipTipoDocum = oipTipoDocum;
        this.siiPolizaContrat = siiPolizaContrat;
    }


    @Id
    @Column(name = "OIP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OFIC_INF_POLIZA_COD")
    @SequenceGenerator(name = "SEQ_OFIC_INF_POLIZA_COD", sequenceName = "SEQ_OFIC_INF_POLIZA_COD",allocationSize=1)
    public Long getOipCodigo() {
        return oipCodigo;
    }

    public void setOipCodigo(Long oipCodigo) {
        this.oipCodigo = oipCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "OIP_FECHA_RADIC")
    public Date getOipFechaRadic() {
        return oipFechaRadic;
    }

    public void setOipFechaRadic(Date oipFechaRadic) {
        this.oipFechaRadic = oipFechaRadic;
    }

    @Column(name = "OIP_NUM_RADICA", length = 30)
    public String getOipNumRadica() {
        return oipNumRadica;
    }

    public void setOipNumRadica(String oipNumRadica) {
        this.oipNumRadica = oipNumRadica;
    }

    @Column(name = "OIP_TIPO_DOCUM", length = 2)
    public String getOipTipoDocum() {
        return oipTipoDocum;
    }

    public void setOipTipoDocum(String oipTipoDocum) {
        this.oipTipoDocum = oipTipoDocum;
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
    @JoinColumn(name = "PCC_CODIGO")
    public SiiPolizaContrat getSiiPolizaContrat() {
        return siiPolizaContrat;
    }

    public void setSiiPolizaContrat(SiiPolizaContrat siiPolizaContrat) {
        this.siiPolizaContrat = siiPolizaContrat;
    }
}
