package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_ESTADO_DOC_CONPES")
public class SiiEstadoDocConpes implements Serializable {
    private static final long serialVersionUID = 1054550862897094421L;
    private Long edcCodigo;
    private String edcNombre;
    private List<SiiDocumentoConpes> siiDocumentoConpesList;

    public SiiEstadoDocConpes() {
    }

    public SiiEstadoDocConpes(Long edcCodigo, String edcNombre) {
        this.edcCodigo = edcCodigo;
        this.edcNombre = edcNombre;
    }

    @Id
    @Column(name = "EDC_CODIGO", nullable = false)
    public Long getEdcCodigo() {
        return edcCodigo;
    }

    public void setEdcCodigo(Long edcCodigo) {
        this.edcCodigo = edcCodigo;
    }

    @Column(name = "EDC_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEdcNombre() {
        return edcNombre;
    }

    public void setEdcNombre(String edcNombre) {
        this.edcNombre = edcNombre;
    }

    @OneToMany(mappedBy = "siiEstadoDocConpes")
    public List<SiiDocumentoConpes> getSiiDocumentoConpesList() {
        return siiDocumentoConpesList;
    }

    public void setSiiDocumentoConpesList(List<SiiDocumentoConpes> siiDocumentoConpesList) {
        this.siiDocumentoConpesList = siiDocumentoConpesList;
    }

    public SiiDocumentoConpes addSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        getSiiDocumentoConpesList().add(siiDocumentoConpes);
        siiDocumentoConpes.setSiiEstadoDocConpes(this);
        return siiDocumentoConpes;
    }

    public SiiDocumentoConpes removeSiiDocumentoConpes(SiiDocumentoConpes siiDocumentoConpes) {
        getSiiDocumentoConpesList().remove(siiDocumentoConpes);
        siiDocumentoConpes.setSiiEstadoDocConpes(null);
        return siiDocumentoConpes;
    }
}
