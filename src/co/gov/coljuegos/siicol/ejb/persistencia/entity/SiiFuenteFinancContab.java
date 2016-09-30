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
@Table(name = "SII_FUENTE_FINANC_CONTAB")
public class SiiFuenteFinancContab implements Serializable {
    private static final long serialVersionUID = 7599640540351349030L;
    private String fccNombre;
    private String ffcCodigo;
    private List<SiiDetalleRubro> siiDetalleRubroList;
    private List<SiiObligacionConcepto> siiObligacionConceptoList;
    private List<SiiImputacionContable> siiImputacionContableList;
    private List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList;
    private List<SiiCuentaBancaria> siiCuentaBancariaList;
    private List<SiiDetalleContNomina> siiDetalleContNominaList;
    private List<SiiNotaCredito> siiNotaCreditoList;
    private List<SiiOrdenPago> siiOrdenPagoList;


    public SiiFuenteFinancContab() {
    }

    public SiiFuenteFinancContab(String fccNombre, String ffcCodigo) {
        this.fccNombre = fccNombre;
        this.ffcCodigo = ffcCodigo;
    }

    @Column(name = "FCC_NOMBRE", nullable = false, length = 50)
    public String getFccNombre() {
        return fccNombre;
    }

    public void setFccNombre(String fccNombre) {
        this.fccNombre = fccNombre;
    }

    @Id
    @Column(name = "FFC_CODIGO", nullable = false, length = 3)
    public String getFfcCodigo() {
        return ffcCodigo;
    }

    public void setFfcCodigo(String ffcCodigo) {
        this.ffcCodigo = ffcCodigo;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiDetalleRubro> getSiiDetalleRubroList() {
        return siiDetalleRubroList;
    }

    public void setSiiDetalleRubroList(List<SiiDetalleRubro> siiDetalleRubroList) {
        this.siiDetalleRubroList = siiDetalleRubroList;
    }

    public SiiDetalleRubro addSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        getSiiDetalleRubroList().add(siiDetalleRubro);
        siiDetalleRubro.setSiiFuenteFinancContab(this);
        return siiDetalleRubro;
    }

    public SiiDetalleRubro removeSiiDetalleRubro(SiiDetalleRubro siiDetalleRubro) {
        getSiiDetalleRubroList().remove(siiDetalleRubro);
        siiDetalleRubro.setSiiFuenteFinancContab(null);
        return siiDetalleRubro;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoList() {
        return siiObligacionConceptoList;
    }

    public void setSiiObligacionConceptoList(List<SiiObligacionConcepto> siiObligacionConceptoList) {
        this.siiObligacionConceptoList = siiObligacionConceptoList;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiFuenteFinancContab(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoList().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiFuenteFinancContab(null);
        return siiObligacionConcepto;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiFuenteFinancContab(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiFuenteFinancContab(null);
        return siiImputacionContable;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiCuentaContTipoDocCont> getSiiCuentaContTipoDocContList() {
        return siiCuentaContTipoDocContList;
    }

    public void setSiiCuentaContTipoDocContList(List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList) {
        this.siiCuentaContTipoDocContList = siiCuentaContTipoDocContList;
    }

    public SiiCuentaContTipoDocCont addSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().add(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiFuenteFinancContab(this);
        return siiCuentaContTipoDocCont;
    }

    public SiiCuentaContTipoDocCont removeSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().remove(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiFuenteFinancContab(null);
        return siiCuentaContTipoDocCont;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiCuentaBancaria> getSiiCuentaBancariaList() {
        return siiCuentaBancariaList;
    }

    public void setSiiCuentaBancariaList(List<SiiCuentaBancaria> siiCuentaBancariaList) {
        this.siiCuentaBancariaList = siiCuentaBancariaList;
    }

    public SiiCuentaBancaria addSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().add(siiCuentaBancaria);
        siiCuentaBancaria.setSiiFuenteFinancContab(this);
        return siiCuentaBancaria;
    }

    public SiiCuentaBancaria removeSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().remove(siiCuentaBancaria);
        siiCuentaBancaria.setSiiFuenteFinancContab(null);
        return siiCuentaBancaria;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiDetalleContNomina> getSiiDetalleContNominaList() {
        return siiDetalleContNominaList;
    }

    public void setSiiDetalleContNominaList(List<SiiDetalleContNomina> siiDetalleContNominaList) {
        this.siiDetalleContNominaList = siiDetalleContNominaList;
    }

    public SiiDetalleContNomina addSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().add(siiDetalleContNomina);
        siiDetalleContNomina.setSiiFuenteFinancContab(this);
        return siiDetalleContNomina;
    }

    public SiiDetalleContNomina removeSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        getSiiDetalleContNominaList().remove(siiDetalleContNomina);
        siiDetalleContNomina.setSiiFuenteFinancContab(null);
        return siiDetalleContNomina;
    }

    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiNotaCredito> getSiiNotaCreditoList() {
        return siiNotaCreditoList;
    }

    public void setSiiNotaCreditoList(List<SiiNotaCredito> siiNotaCreditoList) {
        this.siiNotaCreditoList = siiNotaCreditoList;
    }

    public SiiNotaCredito addSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoList().add(siiNotaCredito);
        siiNotaCredito.setSiiFuenteFinancContab(this);
        return siiNotaCredito;
    }

    public SiiNotaCredito removeSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        getSiiNotaCreditoList().remove(siiNotaCredito);
        siiNotaCredito.setSiiFuenteFinancContab(null);
        return siiNotaCredito;
    }
    
    @OneToMany(mappedBy = "siiFuenteFinancContab")
    public List<SiiOrdenPago> getSiiOrdenPagoList() {
        return siiOrdenPagoList;
    }

    public void setSiiOrdenPagoList(List<SiiOrdenPago> siiOrdenPagoList) {
        this.siiOrdenPagoList = siiOrdenPagoList;
    }

    public SiiOrdenPago addSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().add(siiOrdenPago);
        siiOrdenPago.setSiiFuenteFinancContab(this);
        return siiOrdenPago;
    }

    public SiiOrdenPago removeSiiOrdenPago(SiiOrdenPago siiOrdenPago) {
        getSiiOrdenPagoList().remove(siiOrdenPago);
        siiOrdenPago.setSiiFuenteFinancContab(null);
        return siiOrdenPago;
    }

}
