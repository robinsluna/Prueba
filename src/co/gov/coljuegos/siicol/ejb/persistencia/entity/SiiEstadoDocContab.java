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
@Table(name = "SII_ESTADO_DOC_CONTAB")
public class SiiEstadoDocContab implements Serializable {
    private static final long serialVersionUID = -2753601988974769625L;
    private Long edoCodigo;
    private String edoNombre;
    private List<SiiDocumentoContable> siiDocumentoContableList;

    public SiiEstadoDocContab() {
    }

    public SiiEstadoDocContab(Long edoCodigo, String edoNombre) {
        this.edoCodigo = edoCodigo;
        this.edoNombre = edoNombre;
    }

    @Id
    @Column(name = "EDO_CODIGO", nullable = false)
    public Long getEdoCodigo() {
        return edoCodigo;
    }

    public void setEdoCodigo(Long edoCodigo) {
        this.edoCodigo = edoCodigo;
    }

    @Column(name = "EDO_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEdoNombre() {
        return edoNombre;
    }

    public void setEdoNombre(String edoNombre) {
        this.edoNombre = edoNombre;
    }

    @OneToMany(mappedBy = "siiEstadoDocContab")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiEstadoDocContab(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiEstadoDocContab(null);
        return siiDocumentoContable;
    }
}
