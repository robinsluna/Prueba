package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_CALLE_DIRECCION")
public class SiiTipoCalleDireccion implements Serializable {
    private static final long serialVersionUID = -7728558655509799164L;
    private Long tcdCodigo;
    private String tcdNombre;
    private String tdcAbreviatura;
    private List<SiiDireccion> siiDireccionList;

    public SiiTipoCalleDireccion() {
    }

    public SiiTipoCalleDireccion(Long tcdCodigo, String tcdNombre, String tdcAbreviatura) {
        this.tcdCodigo = tcdCodigo;
        this.tcdNombre = tcdNombre;
        this.tdcAbreviatura = tdcAbreviatura;
    }

    @Id
    @Column(name = "TCD_CODIGO", nullable = false)
    public Long getTcdCodigo() {
        return tcdCodigo;
    }

    public void setTcdCodigo(Long tcdCodigo) {
        this.tcdCodigo = tcdCodigo;
    }

    @Column(name = "TCD_NOMBRE", nullable = false, length = 20)
    public String getTcdNombre() {
        return tcdNombre;
    }

    public void setTcdNombre(String tcdNombre) {
        this.tcdNombre = tcdNombre;
    }

    @Column(name = "TDC_ABREVIATURA", nullable = false, length = 2)
    public String getTdcAbreviatura() {
        return tdcAbreviatura;
    }

    public void setTdcAbreviatura(String tdcAbreviatura) {
        this.tdcAbreviatura = tdcAbreviatura;
    }

    @OneToMany(mappedBy = "siiTipoCalleDireccion")
    public List<SiiDireccion> getSiiDireccionList() {
        return siiDireccionList;
    }

    public void setSiiDireccionList(List<SiiDireccion> siiDireccionList) {
        this.siiDireccionList = siiDireccionList;
    }

    public SiiDireccion addSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionList().add(siiDireccion);
        siiDireccion.setSiiTipoCalleDireccion(this);
        return siiDireccion;
    }

    public SiiDireccion removeSiiDireccion(SiiDireccion siiDireccion) {
        getSiiDireccionList().remove(siiDireccion);
        siiDireccion.setSiiTipoCalleDireccion(null);
        return siiDireccion;
    }
}
