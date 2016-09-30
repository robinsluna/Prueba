package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_INTERES_CUOTA")
public class SiiInteresCuota implements Serializable {
    private static final long serialVersionUID = 2752150572267370204L;
    private BigDecimal icuBaseCalc;
    private String icuCancelado;
    private Long icuCodigo;
    private Date icuFecha;
    private BigDecimal icuTasaAplic;
    private BigDecimal icuValor;
    private BigDecimal icuValorPagado;
    private SiiCuotaOperador siiCuotaOperador;
    private List<SiiDocumentoContable> siiDocumentoContableList;
    private List<SiiDetRecaudoInteres> siiDetRecaudoInterList;
    private SiiAjuste siiAjuste;

    public SiiInteresCuota() {
    }

    public SiiInteresCuota(SiiCuotaOperador siiCuotaOperador, BigDecimal icuBaseCalc, String icuCancelado,
                           Long icuCodigo, Date icuFecha, BigDecimal icuTasaAplic, BigDecimal icuValor,
                           BigDecimal icuValorPagado) {
        this.siiCuotaOperador = siiCuotaOperador;
        this.icuBaseCalc = icuBaseCalc;
        this.icuCancelado = icuCancelado;
        this.icuCodigo = icuCodigo;
        this.icuFecha = icuFecha;
        this.icuTasaAplic = icuTasaAplic;
        this.icuValor = icuValor;
        this.icuValorPagado = icuValorPagado;
    }


    @Column(name = "ICU_BASE_CALC", nullable = false)
    public BigDecimal getIcuBaseCalc() {
        return icuBaseCalc;
    }

    public void setIcuBaseCalc(BigDecimal icuBaseCalc) {
        this.icuBaseCalc = icuBaseCalc;
    }

    @Column(name = "ICU_CANCELADO", nullable = false, length = 1)
    public String getIcuCancelado() {
        return icuCancelado;
    }

    public void setIcuCancelado(String icuCancelado) {
        this.icuCancelado = icuCancelado;
    }

    @Id
    @Column(name = "ICU_CODIGO", nullable = false)
    public Long getIcuCodigo() {
        return icuCodigo;
    }

    public void setIcuCodigo(Long icuCodigo) {
        this.icuCodigo = icuCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ICU_FECHA", nullable = false)
    public Date getIcuFecha() {
        return icuFecha;
    }

    public void setIcuFecha(Date icuFecha) {
        this.icuFecha = icuFecha;
    }

    @Column(name = "ICU_TASA_APLIC", nullable = false)
    public BigDecimal getIcuTasaAplic() {
        return icuTasaAplic;
    }

    public void setIcuTasaAplic(BigDecimal icuTasaAplic) {
        this.icuTasaAplic = icuTasaAplic;
    }

    @Column(name = "ICU_VALOR", nullable = false)
    public BigDecimal getIcuValor() {
        return icuValor;
    }

    public void setIcuValor(BigDecimal icuValor) {
        this.icuValor = icuValor;
    }

    @Column(name = "ICU_VALOR_PAGADO")
    public BigDecimal getIcuValorPagado() {
        return icuValorPagado;
    }

    public void setIcuValorPagado(BigDecimal icuValorPagado) {
        this.icuValorPagado = icuValorPagado;
    }

    @ManyToOne
    @JoinColumn(name = "COP_CODIGO")
    public SiiCuotaOperador getSiiCuotaOperador() {
        return siiCuotaOperador;
    }

    public void setSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        this.siiCuotaOperador = siiCuotaOperador;
    }

    @OneToMany(mappedBy = "siiInteresCuota")
    public List<SiiDocumentoContable> getSiiDocumentoContableList() {
        return siiDocumentoContableList;
    }

    public void setSiiDocumentoContableList(List<SiiDocumentoContable> siiDocumentoContableList) {
        this.siiDocumentoContableList = siiDocumentoContableList;
    }

    public SiiDocumentoContable addSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().add(siiDocumentoContable);
        siiDocumentoContable.setSiiInteresCuota(this);
        return siiDocumentoContable;
    }

    public SiiDocumentoContable removeSiiDocumentoContable(SiiDocumentoContable siiDocumentoContable) {
        getSiiDocumentoContableList().remove(siiDocumentoContable);
        siiDocumentoContable.setSiiInteresCuota(null);
        return siiDocumentoContable;
    }

    @OneToMany(mappedBy = "siiInteresCuota")
    public List<SiiDetRecaudoInteres> getSiiDetRecaudoInterList() {
        return siiDetRecaudoInterList;
    }

    public void setSiiDetRecaudoInterList(List<SiiDetRecaudoInteres> siiDetRecaudoInterList) {
        this.siiDetRecaudoInterList = siiDetRecaudoInterList;
    }

    public SiiDetRecaudoInteres addSiiDetRecaudoInteres(SiiDetRecaudoInteres siiDetRecaudoInteres) {
        getSiiDetRecaudoInterList().add(siiDetRecaudoInteres);
        siiDetRecaudoInteres.setSiiInteresCuota(this);
        return siiDetRecaudoInteres;
    }

    public SiiDetRecaudoInteres removeSiiDetRecaudoInteres(SiiDetRecaudoInteres siiDetRecaudoInteres) {
        getSiiDetRecaudoInterList().remove(siiDetRecaudoInteres);
        siiDetRecaudoInteres.setSiiInteresCuota(null);
        return siiDetRecaudoInteres;
    }

    @ManyToOne
    @JoinColumn(name = "AJU_CODIGO")
    public SiiAjuste getSiiAjuste() {
        return siiAjuste;
    }

    public void setSiiAjuste(SiiAjuste siiAjuste) {
        this.siiAjuste = siiAjuste;
    }
}
