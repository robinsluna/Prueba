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
@Table(name = "SII_TIPO_UBICACION")
public class SiiTipoUbicacion implements Serializable {
    private static final long serialVersionUID = 678320692415590717L;
    private Long tiuCodigo;
    private String tiuNombre;
    private List<SiiUbicacion> siiUbicacionList1;

    public SiiTipoUbicacion() {
    }

    public SiiTipoUbicacion(Long tiuCodigo, String tiuNombre) {
        this.tiuCodigo = tiuCodigo;
        this.tiuNombre = tiuNombre;
    }

    @Id
    @Column(name = "TIU_CODIGO", nullable = false)
    public Long getTiuCodigo() {
        return tiuCodigo;
    }

    public void setTiuCodigo(Long tiuCodigo) {
        this.tiuCodigo = tiuCodigo;
    }

    @Column(name = "TIU_NOMBRE", nullable = false, length = 30)
    public String getTiuNombre() {
        return tiuNombre;
    }

    public void setTiuNombre(String tiuNombre) {
        this.tiuNombre = tiuNombre;
    }

    @OneToMany(mappedBy = "siiTipoUbicacion")
    public List<SiiUbicacion> getSiiUbicacionList1() {
        return siiUbicacionList1;
    }

    public void setSiiUbicacionList1(List<SiiUbicacion> siiUbicacionList1) {
        this.siiUbicacionList1 = siiUbicacionList1;
    }

    public SiiUbicacion addSiiUbicacion(SiiUbicacion siiUbicacion) {
        getSiiUbicacionList1().add(siiUbicacion);
        siiUbicacion.setSiiTipoUbicacion(this);
        return siiUbicacion;
    }

    public SiiUbicacion removeSiiUbicacion(SiiUbicacion siiUbicacion) {
        getSiiUbicacionList1().remove(siiUbicacion);
        siiUbicacion.setSiiTipoUbicacion(null);
        return siiUbicacion;
    }
}
