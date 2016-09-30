package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_DOCUM_TRAMITE")
public class SiiTipoDocumTramite implements Serializable {
    private static final long serialVersionUID = 5808284576766569788L;
    private Long tdtCodigo;
    private String tdtNombre;
    private String tdtTrd;

    public SiiTipoDocumTramite() {
    }

    public SiiTipoDocumTramite(Long tdtCodigo, String tdtNombre, String tdtTrd) {
        this.tdtCodigo = tdtCodigo;
        this.tdtNombre = tdtNombre;
        this.tdtTrd = tdtTrd;
    }

    @Id
    @Column(name = "TDT_CODIGO", nullable = false)
    public Long getTdtCodigo() {
        return tdtCodigo;
    }

    public void setTdtCodigo(Long tdtCodigo) {
        this.tdtCodigo = tdtCodigo;
    }

    @Column(name = "TDT_NOMBRE", nullable = false, length = 80)
    public String getTdtNombre() {
        return tdtNombre;
    }

    public void setTdtNombre(String tdtNombre) {
        this.tdtNombre = tdtNombre;
    }

    @Column(name = "TDT_TRD", length = 20)
    public String getTdtTrd() {
        return tdtTrd;
    }

    public void setTdtTrd(String tdtTrd) {
        this.tdtTrd = tdtTrd;
    }
}
