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
@Table(name = "SII_ESTADO_OBLIGACION")
public class SiiEstadoObligacion implements Serializable {
    private static final long serialVersionUID = 4218200708022052703L;
    private Long eobCodigo;
    private String eobNombre;
    private List<SiiObligacion> siiObligacionList;

    public SiiEstadoObligacion() {
    }

    public SiiEstadoObligacion(Long eobCodigo, String eobNombre) {
        this.eobCodigo = eobCodigo;
        this.eobNombre = eobNombre;
    }

    @Id
    @Column(name = "EOB_CODIGO", nullable = false)
    public Long getEobCodigo() {
        return eobCodigo;
    }

    public void setEobCodigo(Long eobCodigo) {
        this.eobCodigo = eobCodigo;
    }

    @Column(name = "EOB_NOMBRE", nullable = false, length = 20, insertable=false, updatable = false)
    public String getEobNombre() {
        return eobNombre;
    }

    public void setEobNombre(String eobNombre) {
        this.eobNombre = eobNombre;
    }

    @OneToMany(mappedBy = "siiEstadoObligacion")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiEstadoObligacion(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiEstadoObligacion(null);
        return siiObligacion;
    }
}
