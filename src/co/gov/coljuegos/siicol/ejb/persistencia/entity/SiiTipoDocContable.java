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
@Table(name = "SII_TIPO_DOC_CONTABLE")
public class SiiTipoDocContable implements Serializable {
    private static final long serialVersionUID = -6826889224074357464L;
    private String tdcCodigo;
    private String tdcNombre;
    private List<SiiObligacion> siiObligacionList;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList;
    private String tdcPermiteManual;
    private List<SiiOrdenPago> siiOrdenPagoList;
    private String tdcActivo;

    public SiiTipoDocContable() {
    }

    public SiiTipoDocContable(String tdcCodigo, String tdcNombre) {
        this.tdcCodigo = tdcCodigo;
        this.tdcNombre = tdcNombre;
    }

    @Id
    @Column(name = "TDC_CODIGO", nullable = false, length = 5)
    public String getTdcCodigo() {
        return tdcCodigo;
    }

    public void setTdcCodigo(String tdcCodigo) {
        this.tdcCodigo = tdcCodigo;
    }

    @Column(name = "TDC_NOMBRE", nullable = false, length = 50)
    public String getTdcNombre() {
        return tdcNombre;
    }

    public void setTdcNombre(String tdcNombre) {
        this.tdcNombre = tdcNombre;
    }

    @OneToMany(mappedBy = "siiTipoDocContable")
    public List<SiiObligacion> getSiiObligacionList() {
        return siiObligacionList;
    }

    public void setSiiObligacionList(List<SiiObligacion> siiObligacionList) {
        this.siiObligacionList = siiObligacionList;
    }

    public SiiObligacion addSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().add(siiObligacion);
        siiObligacion.setSiiTipoDocContable(this);
        return siiObligacion;
    }

    public SiiObligacion removeSiiObligacion(SiiObligacion siiObligacion) {
        getSiiObligacionList().remove(siiObligacion);
        siiObligacion.setSiiTipoDocContable(null);
        return siiObligacion;
    }

    @OneToMany(mappedBy = "siiTipoDocContable")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiTipoDocContable(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiTipoDocContable(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiTipoDocContable")
    public List<SiiCuentaContTipoDocCont> getSiiCuentaContTipoDocContList() {
        return siiCuentaContTipoDocContList;
    }

    public void setSiiCuentaContTipoDocContList(List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList) {
        this.siiCuentaContTipoDocContList = siiCuentaContTipoDocContList;
    }

    public SiiCuentaContTipoDocCont addSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().add(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiTipoDocContable(this);
        return siiCuentaContTipoDocCont;
    }

    public SiiCuentaContTipoDocCont removeSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().remove(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiTipoDocContable(null);
        return siiCuentaContTipoDocCont;
    }

    @Column(name = "TDC_PERMITE_MANUAL", nullable = false, length = 1)
    public String getTdcPermiteManual() {
        return tdcPermiteManual;
    }

    public void setTdcPermiteManual(String tdcPermiteManual) {
        this.tdcPermiteManual = tdcPermiteManual;
    }

    @OneToMany(mappedBy = "siiTipoDocContable")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiTipoDocContable(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiTipoDocContable(null);
        return siiOrdenPago;
    }

    @Column(name = "TDC_ACTIVO", nullable = false, length = 1)
    public String getTdcActivo() {
        return tdcActivo;
    }

    public void setTdcActivo(String tdcActivo) {
        this.tdcActivo = tdcActivo;
    }
}
