package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_DOCUMENTO_TDR")
public class SiiDocumentoTdr implements Serializable {
    private static final long serialVersionUID = 2757673599153932173L;
    private Long dtdCodigo;
    private String dtdTipoDocTdr;
    private SiiTerminosReferencia siiTerminosReferencia;
    private SiiArchivoFisico siiArchivoFisico;

    public SiiDocumentoTdr() {
    }

    public SiiDocumentoTdr(SiiArchivoFisico siiArchivoFisico, Long dtdCodigo, String dtdTipoDocTdr,
                           SiiTerminosReferencia siiTerminosReferencia) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.dtdCodigo = dtdCodigo;
        this.dtdTipoDocTdr = dtdTipoDocTdr;
        this.siiTerminosReferencia = siiTerminosReferencia;
    }


    @Id
    @Column(name = "DTD_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_DOCUMENTO_TDR_COD")
    @SequenceGenerator(name = "SEQ_DOCUMENTO_TDR_COD", sequenceName = "SEQ_DOCUMENTO_TDR_COD",allocationSize=1)
    public Long getDtdCodigo() {
        return dtdCodigo;
    }

    public void setDtdCodigo(Long dtdCodigo) {
        this.dtdCodigo = dtdCodigo;
    }

    @Column(name = "DTD_TIPO_DOC_TDR", nullable = false, length = 30)
    public String getDtdTipoDocTdr() {
        return dtdTipoDocTdr;
    }

    public void setDtdTipoDocTdr(String dtdTipoDocTdr) {
        this.dtdTipoDocTdr = dtdTipoDocTdr;
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
