package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_SUFIJO2_CALLE")
public class SiiTipoSufijo2Calle implements Serializable {
    private static final long serialVersionUID = 7431983278677396172L;
    private Long tsuCodigo;
    private String tsuNombre;
    private List<SiiDireccion> siiDireccionList;

    public SiiTipoSufijo2Calle() {
    }

    public SiiTipoSufijo2Calle(Long tsuCodigo, String tsuNombre) {
        this.tsuCodigo = tsuCodigo;
        this.tsuNombre = tsuNombre;
    }

    @Id
    @Column(name = "TSU_CODIGO", nullable = false)
    public Long getTsuCodigo() {
        return tsuCodigo;
    }

    public void setTsuCodigo(Long tsuCodigo) {
        this.tsuCodigo = tsuCodigo;
    }

    @Column(name = "TSU_NOMBRE", nullable = false, length = 1)
    public String getTsuNombre() {
        return tsuNombre;
    }

    public void setTsuNombre(String tsuNombre) {
        this.tsuNombre = tsuNombre;
    }

    @OneToMany(mappedBy = "siiTipoSufijo2Calle")
    public List<SiiDireccion> getSiiDireccionList() {
        return siiDireccionList;
    }

    public void setSiiDireccionList(List<SiiDireccion> siiDireccionList) {
        this.siiDireccionList = siiDireccionList;
    }

    public SiiDireccion addSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionList().add(siiDireccion);
        siiDireccion.setSiiTipoSufijo2Calle(this);
        return siiDireccion;
    }

    public SiiDireccion removeSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionList().remove(siiDireccion);
        siiDireccion.setSiiTipoSufijo2Calle(null);
        return siiDireccion;
    }
}
