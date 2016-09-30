package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_SUFIJO1_CALLE")
public class SiiTipoSufijo1Calle implements Serializable {
    private static final long serialVersionUID = -280915723286206865L;
    private Long tscCodigo;
    private String tscNombre;
    private List<SiiDireccion> siiDireccionPpal1List;
    private List<SiiDireccion> siiDireccionPpal2List;
    private List<SiiDireccion> siiDireccionNum1List;

    public SiiTipoSufijo1Calle() {
    }

    public SiiTipoSufijo1Calle(Long tscCodigo, String tscNombre) {
        this.tscCodigo = tscCodigo;
        this.tscNombre = tscNombre;
    }

    @Id
    @Column(name = "TSC_CODIGO", nullable = false)
    public Long getTscCodigo() {
        return tscCodigo;
    }

    public void setTscCodigo(Long tscCodigo) {
        this.tscCodigo = tscCodigo;
    }

    @Column(name = "TSC_NOMBRE", nullable = false, length = 1)
    public String getTscNombre() {
        return tscNombre;
    }

    public void setTscNombre(String tscNombre) {
        this.tscNombre = tscNombre;
    }

    @OneToMany(mappedBy = "siiTipoSufijo1CallePpal1")
    public List<SiiDireccion> getSiiDireccionPpal1List() {
        return siiDireccionPpal1List;
    }

    public void setSiiDireccionPpal1List(List<SiiDireccion> siiDireccionPpal1List) {
        this.siiDireccionPpal1List = siiDireccionPpal1List;
    }

    public SiiDireccion addSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionPpal1List().add(siiDireccion);
        siiDireccion.setSiiTipoSufijo1CallePpal1(this);
        return siiDireccion;
    }

    public SiiDireccion removeSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionPpal1List().remove(siiDireccion);
        siiDireccion.setSiiTipoSufijo1CallePpal1(null);
        return siiDireccion;
    }

    @OneToMany(mappedBy = "siiTipoSufijo1CallePpal2")
    public List<SiiDireccion> getSiiDireccionPpal2List() {
        return siiDireccionPpal2List;
    }

    public void setSiiDireccionPpal2List(List<SiiDireccion> siiDireccionPpal2List) {
        this.siiDireccionPpal2List = siiDireccionPpal2List;
    }

    @OneToMany(mappedBy = "siiTipoSufijo1CalleNum1")
    public List<SiiDireccion> getSiiDireccionNum1List() {
        return siiDireccionNum1List;
    }

    public void setSiiDireccionNum1List(List<SiiDireccion> siiDireccionNum1List) {
        this.siiDireccionNum1List = siiDireccionNum1List;
    }

}
