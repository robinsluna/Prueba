package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_DOCUMENTO_COLJUEGOS")
public class SiiTipoDocumentoColjuegos implements Serializable {
    private static final long serialVersionUID = 1736325620572599886L;
    private Long tdoCodigo;
    private String tdoDescripcion;
    private String tdoNombre;
    private List<SiiFirmasRequeridas> siiFirmasRequeridasList1;
    private List<SiiLogCambioEstado> siiLogCambioEstadoList1;

    public SiiTipoDocumentoColjuegos() {
    }

    public SiiTipoDocumentoColjuegos(Long tdoCodigo, String tdoDescripcion, String tdoNombre) {
        this.tdoCodigo = tdoCodigo;
        this.tdoDescripcion = tdoDescripcion;
        this.tdoNombre = tdoNombre;
    }

    @Id
    @Column(name = "TDO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SII_TIPO_DOC_COLJ_CODIGO")
    @SequenceGenerator(name = "SII_TIPO_DOC_COLJ_CODIGO", sequenceName = "SII_TIPO_DOC_COLJ_CODIGO",allocationSize=1)
    public Long getTdoCodigo() {
        return tdoCodigo;
    }

    public void setTdoCodigo(Long tdoCodigo) {
        this.tdoCodigo = tdoCodigo;
    }

    @Column(name = "TDO_DESCRIPCION", nullable = false, length = 100)
    public String getTdoDescripcion() {
        return tdoDescripcion;
    }

    public void setTdoDescripcion(String tdoDescripcion) {
        this.tdoDescripcion = tdoDescripcion;
    }

    @Column(name = "TDO_NOMBRE", nullable = false, length = 50)
    public String getTdoNombre() {
        return tdoNombre;
    }

    public void setTdoNombre(String tdoNombre) {
        this.tdoNombre = tdoNombre;
    }

    @OneToMany(mappedBy = "siiTipoDocumentoColjuegos1")
    public List<SiiFirmasRequeridas> getSiiFirmasRequeridasList1() {
        return siiFirmasRequeridasList1;
    }

    public void setSiiFirmasRequeridasList1(List<SiiFirmasRequeridas> siiFirmasRequeridasList1) {
        this.siiFirmasRequeridasList1 = siiFirmasRequeridasList1;
    }

    public SiiFirmasRequeridas addSiiFirmasRequeridas(SiiFirmasRequeridas siiFirmasRequeridas) {
        getSiiFirmasRequeridasList1().add(siiFirmasRequeridas);
        siiFirmasRequeridas.setSiiTipoDocumentoColjuegos1(this);
        return siiFirmasRequeridas;
    }

    public SiiFirmasRequeridas removeSiiFirmasRequeridas(SiiFirmasRequeridas siiFirmasRequeridas) {
        getSiiFirmasRequeridasList1().remove(siiFirmasRequeridas);
        siiFirmasRequeridas.setSiiTipoDocumentoColjuegos1(null);
        return siiFirmasRequeridas;
    }

    @OneToMany(mappedBy = "siiTipoDocumentoColjuegos")
    public List<SiiLogCambioEstado> getSiiLogCambioEstadoList1() {
        return siiLogCambioEstadoList1;
    }

    public void setSiiLogCambioEstadoList1(List<SiiLogCambioEstado> siiLogCambioEstadoList1) {
        this.siiLogCambioEstadoList1 = siiLogCambioEstadoList1;
    }

    public SiiLogCambioEstado addSiiLogCambioEstado(SiiLogCambioEstado siiLogCambioEstado) {
        getSiiLogCambioEstadoList1().add(siiLogCambioEstado);
        siiLogCambioEstado.setSiiTipoDocumentoColjuegos(this);
        return siiLogCambioEstado;
    }

    public SiiLogCambioEstado removeSiiLogCambioEstado(SiiLogCambioEstado siiLogCambioEstado) {
        getSiiLogCambioEstadoList1().remove(siiLogCambioEstado);
        siiLogCambioEstado.setSiiTipoDocumentoColjuegos(null);
        return siiLogCambioEstado;
    }
}
