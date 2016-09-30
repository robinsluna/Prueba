package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_CARGA_DOCUMENTO_CONT")
public class SiiCargaDocumentoCont implements Serializable {
    private static final long serialVersionUID = 6560946651752920913L;
    private Long cdcCodigo;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private SiiArchivoFisico siiArchivoFisico;
    private String cdcDescripcion;

    public SiiCargaDocumentoCont() {
    }

    public SiiCargaDocumentoCont(SiiArchivoFisico siiArchivoFisico, Long cdcCodigo) {
        this.siiArchivoFisico = siiArchivoFisico;
        this.cdcCodigo = cdcCodigo;
    }


    @Id
    @Column(name = "CDC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "CARGA_DOCUMENTO_CONT_SEQ")
    @SequenceGenerator(name = "CARGA_DOCUMENTO_CONT_SEQ", sequenceName = "CARGA_DOCUMENTO_CONT_SEQ",allocationSize=1)
    public Long getCdcCodigo() {
        return cdcCodigo;
    }

    public void setCdcCodigo(Long cdcCodigo) {
        this.cdcCodigo = cdcCodigo;
    }

    @OneToMany(mappedBy = "siiCargaDocumentoCont")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiCargaDocumentoCont(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiCargaDocumentoCont(null);
        return siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
    
    @Column(name = "CDC_DESCRIPCION", length = 250)
    public String getCdcDescripcion() {
        return cdcDescripcion;
    }


    public void setCdcDescripcion(String cdcDescripcion) {
        this.cdcDescripcion = cdcDescripcion;
    }
    
}
