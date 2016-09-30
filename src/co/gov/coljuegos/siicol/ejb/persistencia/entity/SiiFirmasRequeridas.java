package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_FIRMAS_REQUERIDAS")
public class SiiFirmasRequeridas implements Serializable {
    private static final long serialVersionUID = 1385748201063866381L;
    private Long freCodigo;
    private String freEtiqueta;
    private SiiFuncion siiFuncion;
    private SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos1;
    private List<SiiFirmaDocumento> siiFirmaDocumentoList;
    private String freActivo;

    public SiiFirmasRequeridas() {
    }

    public SiiFirmasRequeridas(String freActivo, Long freCodigo, String freEtiqueta, SiiFuncion siiFuncion,
                               SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos1) {
        this.freCodigo = freCodigo;
        this.freEtiqueta = freEtiqueta;
        this.siiFuncion = siiFuncion;
        this.siiTipoDocumentoColjuegos1 = siiTipoDocumentoColjuegos1;
        this.freActivo = freActivo;
    }

    @Id
    @Column(name = "FRE_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_FIRMAS_REQUERIDAS_COD")
    @SequenceGenerator(name = "SEQ_FIRMAS_REQUERIDAS_COD", sequenceName = "SEQ_FIRMAS_REQUERIDAS_COD",allocationSize=1)
    public Long getFreCodigo() {
        return freCodigo;
    }

    public void setFreCodigo(Long freCodigo) {
        this.freCodigo = freCodigo;
    }

    @Column(name = "FRE_ETIQUETA", nullable = false, length = 20)
    public String getFreEtiqueta() {
        return freEtiqueta;
    }

    public void setFreEtiqueta(String freEtiqueta) {
        this.freEtiqueta = freEtiqueta;
    }


    @ManyToOne
    @JoinColumn(name = "FUN_CODIGO")
    public SiiFuncion getSiiFuncion() {
        return siiFuncion;
    }

    public void setSiiFuncion(SiiFuncion siiFuncion) {
        this.siiFuncion = siiFuncion;
    }

    @ManyToOne
    @JoinColumn(name = "TDO_CODIGO")
    public SiiTipoDocumentoColjuegos getSiiTipoDocumentoColjuegos1() {
        return siiTipoDocumentoColjuegos1;
    }

    public void setSiiTipoDocumentoColjuegos1(SiiTipoDocumentoColjuegos siiTipoDocumentoColjuegos1) {
        this.siiTipoDocumentoColjuegos1 = siiTipoDocumentoColjuegos1;
    }

    @OneToMany(mappedBy = "siiFirmasRequeridas")
    public List<SiiFirmaDocumento> getSiiFirmaDocumentoList() {
        return siiFirmaDocumentoList;
    }

    public void setSiiFirmaDocumentoList(List<SiiFirmaDocumento> siiFirmaDocumentoList) {
        this.siiFirmaDocumentoList = siiFirmaDocumentoList;
    }

    public SiiFirmaDocumento addSiiFirmaDocumento(SiiFirmaDocumento siiFirmaDocumento) {
        getSiiFirmaDocumentoList().add(siiFirmaDocumento);
        siiFirmaDocumento.setSiiFirmasRequeridas(this);
        return siiFirmaDocumento;
    }

    public SiiFirmaDocumento removeSiiFirmaDocumento(SiiFirmaDocumento siiFirmaDocumento) {
        getSiiFirmaDocumentoList().remove(siiFirmaDocumento);
        siiFirmaDocumento.setSiiFirmasRequeridas(null);
        return siiFirmaDocumento;
    }

    @Column(name = "FRE_ACTIVO", nullable = false, length = 1)
    public String getFreActivo() {
        return freActivo;
    }

    public void setFreActivo(String freActivo) {
        this.freActivo = freActivo;
    }
}
