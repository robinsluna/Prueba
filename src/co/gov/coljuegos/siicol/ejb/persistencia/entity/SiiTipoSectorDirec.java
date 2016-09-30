package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_SECTOR_DIREC")
public class SiiTipoSectorDirec implements Serializable {
    private static final long serialVersionUID = -1382627301291654903L;
    private Long tsdCodigo;
    private String tsdNombre;
    private List<SiiDireccion> siiDireccionPpalList;
    private List<SiiDireccion> siiDireccionNum2List;

    public SiiTipoSectorDirec() {
    }

    public SiiTipoSectorDirec(Long tsdCodigo, String tsdNombre) {
        this.tsdCodigo = tsdCodigo;
        this.tsdNombre = tsdNombre;
    }

    @Id
    @Column(name = "TSD_CODIGO", nullable = false)
    public Long getTsdCodigo() {
        return tsdCodigo;
    }

    public void setTsdCodigo(Long tsdCodigo) {
        this.tsdCodigo = tsdCodigo;
    }

    @Column(name = "TSD_NOMBRE", nullable = false, length = 20)
    public String getTsdNombre() {
        return tsdNombre;
    }

    public void setTsdNombre(String tsdNombre) {
        this.tsdNombre = tsdNombre;
    }

    @OneToMany(mappedBy = "siiTipoSectorDirecPpal")
    public List<SiiDireccion> getSiiDireccionPpalList() {
        return siiDireccionPpalList;
    }

    public void setSiiDireccionPpalList(List<SiiDireccion> siiDireccionPpalList) {
        this.siiDireccionPpalList = siiDireccionPpalList;
    }

    public SiiDireccion addSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionPpalList().add(siiDireccion);
        siiDireccion.setSiiTipoSectorDirecPpal(this);
        return siiDireccion;
    }

    public SiiDireccion removeSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionPpalList().remove(siiDireccion);
        siiDireccion.setSiiTipoSectorDirecPpal(null);
        return siiDireccion;
    }

    @OneToMany(mappedBy = "siiTipoSectorDirecNum2")
    public List<SiiDireccion> getSiiDireccionNum2List() {
        return siiDireccionNum2List;
    }

    public void setSiiDireccionNum2List(List<SiiDireccion> siiDireccionNum2List) {
        this.siiDireccionNum2List = siiDireccionNum2List;
    }
}
