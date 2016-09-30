package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_DOC_RADICADO")
public class SiiTipoDocRadicado implements Serializable {
    private static final long serialVersionUID = 6469303951989691628L;
    private Long tdrCodigo;
    private String tdrNombre;
    private List<SiiDocumentoRadicado> siiDocumentoRadicadoList;

    public SiiTipoDocRadicado() {
    }

    public SiiTipoDocRadicado(Long tdrCodigo, String tdrNombre) {
        this.tdrCodigo = tdrCodigo;
        this.tdrNombre = tdrNombre;
    }

    @Id
    @Column(name = "TDR_CODIGO", nullable = false)
    public Long getTdrCodigo() {
        return tdrCodigo;
    }

    public void setTdrCodigo(Long tdrCodigo) {
        this.tdrCodigo = tdrCodigo;
    }

    @Column(name = "TDR_NOMBRE", nullable = false, length = 50)
    public String getTdrNombre() {
        return tdrNombre;
    }

    public void setTdrNombre(String tdrNombre) {
        this.tdrNombre = tdrNombre;
    }

    @OneToMany(mappedBy = "siiTipoDocRadicado")
    public List<SiiDocumentoRadicado> getSiiDocumentoRadicadoList() {
        return siiDocumentoRadicadoList;
    }

    public void setSiiDocumentoRadicadoList(List<SiiDocumentoRadicado> siiDocumentoRadicadoList) {
        this.siiDocumentoRadicadoList = siiDocumentoRadicadoList;
    }

    public SiiDocumentoRadicado addSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().add(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiTipoDocRadicado(this);
        return siiDocumentoRadicado;
    }

    public SiiDocumentoRadicado removeSiiDocumentoRadicado(SiiDocumentoRadicado siiDocumentoRadicado) {
        getSiiDocumentoRadicadoList().remove(siiDocumentoRadicado);
        siiDocumentoRadicado.setSiiTipoDocRadicado(null);
        return siiDocumentoRadicado;
    }
}
