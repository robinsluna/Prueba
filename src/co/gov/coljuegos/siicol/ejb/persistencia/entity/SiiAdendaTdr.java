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
@Table(name = "SII_ADENDA_TDR")
public class SiiAdendaTdr implements Serializable {
    private static final long serialVersionUID = 6536096226791503509L;
    private Long atdCodigo;
    private Date atdFechaAprob;
    private Date atdFechaEnvPub;
    private Date atdFechaPub;
    private String atdRadicado;
    private SiiTerminosReferencia siiTerminosReferencia;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiAdendaTdr() {
    }

    public SiiAdendaTdr(Long atdCodigo, Date atdFechaAprob, Date atdFechaEnvPub, Date atdFechaPub, String atdRadicado,
                        SiiTerminosReferencia siiTerminosReferencia, SiiArchivoFisico siiArchivoFisico) {
        this.atdCodigo = atdCodigo;
        this.atdFechaAprob = atdFechaAprob;
        this.atdFechaEnvPub = atdFechaEnvPub;
        this.atdFechaPub = atdFechaPub;
        this.atdRadicado = atdRadicado;
        this.siiTerminosReferencia = siiTerminosReferencia;
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Id
    @Column(name = "ATD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ADENDA_TDR_COD")
    @SequenceGenerator(name = "SEQ_ADENDA_TDR_COD", sequenceName = "SEQ_ADENDA_TDR_COD",allocationSize=1)
    public Long getAtdCodigo() {
        return atdCodigo;
    }

    public void setAtdCodigo(Long atdCodigo) {
        this.atdCodigo = atdCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATD_FECHA_APROB")
    public Date getAtdFechaAprob() {
        return atdFechaAprob;
    }

    public void setAtdFechaAprob(Date atdFechaAprob) {
        this.atdFechaAprob = atdFechaAprob;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATD_FECHA_ENV_PUB")
    public Date getAtdFechaEnvPub() {
        return atdFechaEnvPub;
    }

    public void setAtdFechaEnvPub(Date atdFechaEnvPub) {
        this.atdFechaEnvPub = atdFechaEnvPub;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ATD_FECHA_PUB")
    public Date getAtdFechaPub() {
        return atdFechaPub;
    }

    public void setAtdFechaPub(Date atdFechaPub) {
        this.atdFechaPub = atdFechaPub;
    }

    @Column(name = "ATD_RADICADO", length = 100)
    public String getAtdRadicado() {
        return atdRadicado;
    }

    public void setAtdRadicado(String atdRadicado) {
        this.atdRadicado = atdRadicado;
    }


    @ManyToOne
    @JoinColumn(name = "TDR_CODIGO")
    public SiiTerminosReferencia getSiiTerminosReferencia() {
        return siiTerminosReferencia;
    }

    public void setSiiTerminosReferencia(SiiTerminosReferencia siiTerminosReferencia) {
        this.siiTerminosReferencia = siiTerminosReferencia;
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
