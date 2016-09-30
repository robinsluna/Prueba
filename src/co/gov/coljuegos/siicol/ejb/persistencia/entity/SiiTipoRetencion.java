package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TIPO_RETENCION")
public class SiiTipoRetencion implements Serializable {
    private static final long serialVersionUID = -2266774208490029801L;
    private String treCodigo;
    private String treNomClasific;
    private SiiGrupoRetenc siiGrupoRetenc;
    private List<SiiReglaImpuestos> siiReglaImpuestosList;
    private SiiConceptoReten siiConceptoReten;
    private SiiCuentasContables siiCuentasContables;
    private String treObservaciones;
    private Integer treRenglon;
    private BigDecimal treTarifa;
    private List<SiiPersona> siiPersonaVentasList;
    private List<SiiPersona> siiPersonaRentasList;
    private List<SiiImputacionContable> siiImputacionContVentaList;
    private List<SiiImputacionContable> siiImputacionContRentaList;
    private List<SiiObligacionConcepto> siiObligacionConceptoRentaList;
    private List<SiiObligacionConcepto> siiObligacionConceptoIvaList;
    private String treBaseUvt;
    private List<SiiHistPersona> siiHistPersonaVentList;
    private List<SiiHistPersona> siiHistPersonaRentaList;
    private List<SiiObligacionConcepto> siiObligacionConceptoEstampList;

    public SiiTipoRetencion() {
    }

    public SiiTipoRetencion(SiiCuentasContables siiCuentasContables, SiiConceptoReten siiConceptoReten,
                            SiiGrupoRetenc siiGrupoRetenc, String treCodigo, String treNomClasific, String treObservaciones,
					Integer treRenglon, BigDecimal treTarifa) {
        this.siiCuentasContables = siiCuentasContables;
        this.siiConceptoReten = siiConceptoReten;
        this.siiGrupoRetenc = siiGrupoRetenc;
        this.treCodigo = treCodigo;
        this.treNomClasific = treNomClasific;
        this.treObservaciones = treObservaciones;
        this.treRenglon = treRenglon;
        this.treTarifa = treTarifa;
    }


    @Id
    @Column(name = "TRE_CODIGO", nullable = false, length = 5)
    public String getTreCodigo() {
        return treCodigo;
    }

    public void setTreCodigo(String treCodigo) {
        this.treCodigo = treCodigo;
    }

    @Column(name = "TRE_NOM_CLASIFIC", nullable = false, length = 150)
    public String getTreNomClasific() {
        return treNomClasific;
    }

    public void setTreNomClasific(String treNomClasific) {
        this.treNomClasific = treNomClasific;
    }

    @ManyToOne
    @JoinColumn(name = "GRE_CODIGO")
    public SiiGrupoRetenc getSiiGrupoRetenc() {
        return siiGrupoRetenc;
    }

    public void setSiiGrupoRetenc(SiiGrupoRetenc siiGrupoRetenc) {
        this.siiGrupoRetenc = siiGrupoRetenc;
    }

    @OneToMany(mappedBy = "siiTipoRetencion")
    public List<SiiReglaImpuestos> getSiiReglaImpuestosList() {
        return siiReglaImpuestosList;
    }

    public void setSiiReglaImpuestosList(List<SiiReglaImpuestos> siiReglaImpuestosList) {
        this.siiReglaImpuestosList = siiReglaImpuestosList;
    }

    public SiiReglaImpuestos addSiiReglaImpuestos(SiiReglaImpuestos siiReglaImpuestos) {
        getSiiReglaImpuestosList().add(siiReglaImpuestos);
        siiReglaImpuestos.setSiiTipoRetencion(this);
        return siiReglaImpuestos;
    }

    public SiiReglaImpuestos removeSiiReglaImpuestos(SiiReglaImpuestos siiReglaImpuestos) {
        getSiiReglaImpuestosList().remove(siiReglaImpuestos);
        siiReglaImpuestos.setSiiTipoRetencion(null);
        return siiReglaImpuestos;
    }


    @ManyToOne
    @JoinColumn(name = "CRE_CODIGO")
    public SiiConceptoReten getSiiConceptoReten() {
        return siiConceptoReten;
    }

    public void setSiiConceptoReten(SiiConceptoReten siiConceptoReten) {
        this.siiConceptoReten = siiConceptoReten;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }

    @Column(name = "TRE_OBSERVACIONES", nullable = false, length = 150)
    public String getTreObservaciones() {
        return treObservaciones;
    }

    public void setTreObservaciones(String treObservaciones) {
        this.treObservaciones = treObservaciones;
    }

    @Column(name = "TRE_RENGLON", nullable = false)
    public Integer getTreRenglon() {
        return treRenglon;
    }

    public void setTreRenglon(Integer treRenglon) {
        this.treRenglon = treRenglon;
    }

    @Column(name = "TRE_TARIFA", nullable = false)
    public BigDecimal getTreTarifa() {
        return treTarifa;
    }

    public void setTreTarifa(BigDecimal treTarifa) {
        this.treTarifa = treTarifa;
    }

    @OneToMany(mappedBy = "siiTipoRetencionVentas")
    public List<SiiPersona> getSiiPersonaVentasList() {
        return siiPersonaVentasList;
    }

    public void setSiiPersonaVentasList(List<SiiPersona> siiPersonaVentasList) {
        this.siiPersonaVentasList = siiPersonaVentasList;
    }

    public SiiPersona addSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaVentasList().add(siiPersona);
        siiPersona.setSiiTipoRetencionVentas(this);
        return siiPersona;
    }

    public SiiPersona removeSiiPersona(SiiPersona siiPersona) {
        getSiiPersonaVentasList().remove(siiPersona);
        siiPersona.setSiiTipoRetencionVentas(null);
        return siiPersona;
    }

    @OneToMany(mappedBy = "siiTipoRetencionRentas")
    public List<SiiPersona> getSiiPersonaRentasList() {
        return siiPersonaRentasList;
    }

    public void setSiiPersonaRentasList(List<SiiPersona> siiPersonaRentasList) {
        this.siiPersonaRentasList = siiPersonaRentasList;
    }

    @OneToMany(mappedBy = "siiTipoRetencionVenta")
    public List<SiiImputacionContable> getSiiImputacionContVentaList() {
        return siiImputacionContVentaList;
    }

    public void setSiiImputacionContVentaList(List<SiiImputacionContable> siiImputacionContVentaList) {
        this.siiImputacionContVentaList = siiImputacionContVentaList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContVentaList().add(siiImputacionContable);
        siiImputacionContable.setSiiTipoRetencionVenta(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContVentaList().remove(siiImputacionContable);
        siiImputacionContable.setSiiTipoRetencionVenta(null);
        return siiImputacionContable;
    }

    @OneToMany(mappedBy = "siiTipoRetencionRenta")
    public List<SiiImputacionContable> getSiiImputacionContRentaList() {
        return siiImputacionContRentaList;
    }

    public void setSiiImputacionContRentaList(List<SiiImputacionContable> siiImputacionContRentaList) {
        this.siiImputacionContRentaList = siiImputacionContRentaList;
    }

    @OneToMany(mappedBy = "siiTipoRetencionRenta")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoRentaList() {
        return siiObligacionConceptoRentaList;
    }

    public void setSiiObligacionConceptoRentaList(List<SiiObligacionConcepto> siiObligacionConceptoRentaList) {
        this.siiObligacionConceptoRentaList = siiObligacionConceptoRentaList;
    }

    public SiiObligacionConcepto addSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoRentaList().add(siiObligacionConcepto);
        siiObligacionConcepto.setSiiTipoRetencionRenta(this);
        return siiObligacionConcepto;
    }

    public SiiObligacionConcepto removeSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        getSiiObligacionConceptoRentaList().remove(siiObligacionConcepto);
        siiObligacionConcepto.setSiiTipoRetencionRenta(null);
        return siiObligacionConcepto;
    }

    @OneToMany(mappedBy = "siiTipoRetencionIva")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoIvaList() {
        return siiObligacionConceptoIvaList;
    }

    public void setSiiObligacionConceptoIvaList(List<SiiObligacionConcepto> siiObligacionConceptoIvaList) {
        this.siiObligacionConceptoIvaList = siiObligacionConceptoIvaList;
    }

    @Column(name = "TRE_BASE_UVT", length = 5)
    public String getTreBaseUvt() {
        return treBaseUvt;
    }

    public void setTreBaseUvt(String treBaseUvt) {
        this.treBaseUvt = treBaseUvt;
    }

    @OneToMany(mappedBy = "siiTipoRetencionVent")
    public List<SiiHistPersona> getSiiHistPersonaVentList() {
        return siiHistPersonaVentList;
    }

    public void setSiiHistPersonaVentList(List<SiiHistPersona> siiHistPersonaVentList) {
        this.siiHistPersonaVentList = siiHistPersonaVentList;
    }

    public SiiHistPersona addSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaVentList().add(siiHistPersona);
        siiHistPersona.setSiiTipoRetencionVent(this);
        return siiHistPersona;
    }

    public SiiHistPersona removeSiiHistPersona(SiiHistPersona siiHistPersona) {
        getSiiHistPersonaVentList().remove(siiHistPersona);
        siiHistPersona.setSiiTipoRetencionVent(null);
        return siiHistPersona;
    }

    @OneToMany(mappedBy = "siiTipoRetencionRent")
    public List<SiiHistPersona> getSiiHistPersonaRentaList() {
        return siiHistPersonaRentaList;
    }

    public void setSiiHistPersonaRentaList(List<SiiHistPersona> siiHistPersonaRentaList) {
        this.siiHistPersonaRentaList = siiHistPersonaRentaList;
    }

    @OneToMany(mappedBy = "siiTipoRetencionEstamp")
    public List<SiiObligacionConcepto> getSiiObligacionConceptoEstampList() {
        return siiObligacionConceptoEstampList;
    }

    public void setSiiObligacionConceptoEstampList(List<SiiObligacionConcepto> siiObligacionConceptoEstampList) {
        this.siiObligacionConceptoEstampList = siiObligacionConceptoEstampList;
    }
}
