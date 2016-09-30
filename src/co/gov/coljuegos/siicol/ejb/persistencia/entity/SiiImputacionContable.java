package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_IMPUTACION_CONTABLE")
public class SiiImputacionContable implements Serializable {
    private static final long serialVersionUID = 5225313562503998294L;
    private Long imcCodigo;
    private String imcConcepto;
    private String imcDescrOperacion;
    private String imcReferencia1;
    private String imcReferencia2;
    private String imcTipoMovim;
    private SiiDocumentoContable siiDocumentoContable;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private SiiAreaColjuegos siiAreaColjuegos;
    private SiiConcepInfExogena siiConcepInfExogena;
    private SiiCuentasContables siiCuentasContables;
    private BigDecimal imcValor;
    private SiiPersona siiPersona;
    private String imcEstado;
    private BigDecimal imcBase;
    private SiiTipoRetencion siiTipoRetencionVenta;
    private SiiTipoRetencion siiTipoRetencionRenta;
    private Integer imcAgrupacion;
    private List<SiiImpContabOblNoPres> siiImpContabOblNoPresList;

    public SiiImputacionContable() {
    }

    public SiiImputacionContable(SiiAreaColjuegos siiAreaColjuegos, SiiCuentasContables siiCuentasContables, BigDecimal imcValor,
                                 SiiConcepInfExogena siiConcepInfExogena, SiiDocumentoContable siiDocumentoContable, String imcEstado,
                                 SiiFuenteFinancContab siiFuenteFinancContab, Long imcCodigo, String imcDescrOperacion, BigDecimal imcBase,
                                 String imcReferencia1, String imcReferencia2, String imcTipoMovim, SiiPersona siiPersona, String imcConcepto,
								SiiTipoRetencion siiTipoRetencionRenta, SiiTipoRetencion siiTipoRetencionVenta, Integer imcAgrupacion) {
        this.siiAreaColjuegos = siiAreaColjuegos;
        this.siiCuentasContables = siiCuentasContables;
        this.siiConcepInfExogena = siiConcepInfExogena;
        this.siiDocumentoContable = siiDocumentoContable;
        this.siiFuenteFinancContab = siiFuenteFinancContab;
        this.imcCodigo = imcCodigo;
        this.imcConcepto = imcConcepto;
        this.imcDescrOperacion = imcDescrOperacion;
        this.imcReferencia1 = imcReferencia1;
        this.imcReferencia2 = imcReferencia2;
        this.imcTipoMovim = imcTipoMovim;
        this.imcValor = imcValor;
        this.siiPersona = siiPersona;
        this.imcEstado = imcEstado;
        this.imcAgrupacion = imcAgrupacion;
        this.imcBase = imcBase;
        this.siiTipoRetencionRenta = siiTipoRetencionRenta;
        this.siiTipoRetencionVenta = siiTipoRetencionVenta;
    }


    @Id
    @Column(name = "IMC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_IMPUTAC_CONTABLE_COD")
    @SequenceGenerator(name = "SEQ_IMPUTAC_CONTABLE_COD", sequenceName = "SEQ_IMPUTAC_CONTABLE_COD",allocationSize=1)
    public Long getImcCodigo() {
        return imcCodigo;
    }

    public void setImcCodigo(Long imcCodigo) {
        this.imcCodigo = imcCodigo;
    }

    @Column(name = "IMC_CONCEPTO", length = 250)
    public String getImcConcepto() {
        return imcConcepto;
    }

    public void setImcConcepto(String imcConcepto) {
        this.imcConcepto = imcConcepto;
    }

    @Column(name = "IMC_DESCR_OPERACION", nullable = false, length = 200)
    public String getImcDescrOperacion() {
        return imcDescrOperacion;
    }

    public void setImcDescrOperacion(String imcDescrOperacion) {
        this.imcDescrOperacion = imcDescrOperacion;
    }


    @Column(name = "IMC_REFERENCIA1", length = 20)
    public String getImcReferencia1() {
        return imcReferencia1;
    }

    public void setImcReferencia1(String imcReferencia1) {
        this.imcReferencia1 = imcReferencia1;
    }

    @Column(name = "IMC_REFERENCIA2", length = 20)
    public String getImcReferencia2() {
        return imcReferencia2;
    }

    public void setImcReferencia2(String imcReferencia2) {
        this.imcReferencia2 = imcReferencia2;
    }

    @Column(name = "IMC_TIPO_MOVIM", nullable = false, length = 1)
    public String getImcTipoMovim() {
        return imcTipoMovim;
    }

    public void setImcTipoMovim(String imcTipoMovim) {
        this.imcTipoMovim = imcTipoMovim;
    }

    @ManyToOne
    @JoinColumn(name = "DCO_CODIGO")
    public SiiDocumentoContable getSiiDocumentoContable() {
        return siiDocumentoContable;
    }

    public void setSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        this.siiDocumentoContable = siiDocumentoContable;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @ManyToOne
    @JoinColumn(name = "ACO_CODIGO")
    public SiiAreaColjuegos getSiiAreaColjuegos() {
        return siiAreaColjuegos;
    }

    public void setSiiAreaColjuegos(SiiAreaColjuegos siiAreaColjuegos) {
        this.siiAreaColjuegos = siiAreaColjuegos;
    }

    @ManyToOne
    @JoinColumn(name = "CIE_CODIGO")
    public SiiConcepInfExogena getSiiConcepInfExogena() {
        return siiConcepInfExogena;
    }

    public void setSiiConcepInfExogena(SiiConcepInfExogena siiConcepInfExogena) {
        this.siiConcepInfExogena = siiConcepInfExogena;
    }

    @ManyToOne
    @JoinColumn(name = "CCO_CODIGO")
    public SiiCuentasContables getSiiCuentasContables() {
        return siiCuentasContables;
    }

    public void setSiiCuentasContables(SiiCuentasContables siiCuentasContables) {
        this.siiCuentasContables = siiCuentasContables;
    }

    @Column(name = "IMC_VALOR", nullable = false)
    public BigDecimal getImcValor() {
        return imcValor;
    }

    public void setImcValor(BigDecimal imcValor) {
        this.imcValor = imcValor;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @Column(name = "IMC_ESTADO", length = 1)
    public String getImcEstado() {
        return imcEstado;
    }

    public void setImcEstado(String imcEstado) {
        this.imcEstado = imcEstado;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_VENTAS")
    public SiiTipoRetencion getSiiTipoRetencionVenta() {
        return siiTipoRetencionVenta;
    }

    public void setSiiTipoRetencionVenta(SiiTipoRetencion siiTipoRetencionVenta) {
        this.siiTipoRetencionVenta = siiTipoRetencionVenta;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_RENTA")
    public SiiTipoRetencion getSiiTipoRetencionRenta() {
        return siiTipoRetencionRenta;
    }

    public void setSiiTipoRetencionRenta(SiiTipoRetencion siiTipoRetencionRenta) {
        this.siiTipoRetencionRenta = siiTipoRetencionRenta;
    }

    @Column(name = "IMC_BASE")
    public BigDecimal getImcBase() {
        return imcBase;
    }

    public void setImcBase(BigDecimal imcBase) {
        this.imcBase = imcBase;
    }

    @Column(name = "IMC_AGRUPACION")
    public Integer getImcAgrupacion() {
        return imcAgrupacion;
    }

    public void setImcAgrupacion(Integer imcAgrupacion) {
        this.imcAgrupacion = imcAgrupacion;
    }

    @OneToMany(mappedBy = "siiImputacionContable")
    public List<SiiImpContabOblNoPres> getSiiImpContabOblNoPresList() {
        return siiImpContabOblNoPresList;
    }

    public void setSiiImpContabOblNoPresList(List<SiiImpContabOblNoPres> siiImpContabOblNoPresList) {
        this.siiImpContabOblNoPresList = siiImpContabOblNoPresList;
    }

    public SiiImpContabOblNoPres addSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().add(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiImputacionContable(this);
        return siiImpContabOblNoPres;
    }

    public SiiImpContabOblNoPres removeSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().remove(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiImputacionContable(null);
        return siiImpContabOblNoPres;
    }
}
