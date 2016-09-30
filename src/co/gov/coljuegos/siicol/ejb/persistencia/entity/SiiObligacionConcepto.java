package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_OBLIGACION_CONCEPTO")
public class SiiObligacionConcepto implements Serializable {
    private static final long serialVersionUID = 5341058748950022520L;
    private Long ocoCodigo;
    private BigDecimal ocoImpuestoIca;
    private BigDecimal ocoImpuestoIva;
    private BigDecimal ocoImpuestoRent;
    private BigDecimal ocoValorIca;
    private BigDecimal ocoValorIni;
    private BigDecimal ocoValorIva;
    private BigDecimal ocoValorRenta;
    private SiiObligacion siiObligacion;
    private SiiConceptoGasto siiConceptoGasto;
    private SiiRp siiRp;
    private BigDecimal ocoAiu;
    private BigDecimal ocoIva;
    private BigDecimal ocoSubtotal;
    private SiiFuenteFinancContab siiFuenteFinancContab;
    private List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList;
    private SiiActividadIca siiActividadIca;
    private SiiTipoRetencion siiTipoRetencionRenta;
    private SiiTipoRetencion siiTipoRetencionIva;
    private BigDecimal ocoBaseRetef;
    private SiiPersona siiPersonaBenefAfp;
    private SiiPersona siiPersonaBenefAfc;
    private BigDecimal ocoValorVolAfc;
    private BigDecimal ocoValorVolAfp;
    private String ocoEstampillaUnal;
    private SiiTipoRetencion siiTipoRetencionEstamp;
    private BigDecimal ocoValorRetEstamp;
    private BigDecimal ocoImpuestoEstamp;
    private List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList;

    public SiiObligacionConcepto() {
    }

    public SiiObligacionConcepto(SiiConceptoGasto siiConceptoGasto, SiiObligacion siiObligacion, Long ocoCodigo, BigDecimal ocoValorIni,
                                 BigDecimal ocoImpuestoIca, BigDecimal ocoImpuestoIva, BigDecimal ocoImpuestoRent,
                                 BigDecimal ocoValorIca, BigDecimal ocoValorIva, BigDecimal ocoValorRenta, SiiRp siiRp, BigDecimal ocoAiu,
                                 BigDecimal ocoIva, BigDecimal ocoSubtotal, SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiConceptoGasto = siiConceptoGasto;
        this.siiObligacion = siiObligacion;
        this.ocoCodigo = ocoCodigo;
        this.ocoImpuestoIca = ocoImpuestoIca;
        this.ocoImpuestoIva = ocoImpuestoIva;
        this.ocoImpuestoRent = ocoImpuestoRent;
        this.ocoIva = ocoIva;
        this.ocoSubtotal = ocoSubtotal;
        this.ocoValorIca = ocoValorIca;
        this.ocoValorIni = ocoValorIni;
        this.ocoValorIva = ocoValorIva;
        this.ocoValorRenta = ocoValorRenta;
        this.siiRp = siiRp;
        this.siiFuenteFinancContab = siiFuenteFinancContab;
        this.ocoAiu = ocoAiu;
    }


    @Id
    @Column(name = "OCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_OBLIGACION_CONCEPTO_COD")
    @SequenceGenerator(name = "SEQ_OBLIGACION_CONCEPTO_COD", sequenceName = "SEQ_OBLIGACION_CONCEPTO_COD",allocationSize=1)
    public Long getOcoCodigo() {
        return ocoCodigo;
    }

    public void setOcoCodigo(Long ocoCodigo) {
        this.ocoCodigo = ocoCodigo;
    }

    @Column(name = "OCO_IMPUESTO_ICA", nullable = false)
    public BigDecimal getOcoImpuestoIca() {
        return ocoImpuestoIca;
    }

    public void setOcoImpuestoIca(BigDecimal ocoImpuestoIca) {
        this.ocoImpuestoIca = ocoImpuestoIca;
    }

    @Column(name = "OCO_IMPUESTO_IVA", nullable = false)
    public BigDecimal getOcoImpuestoIva() {
        return ocoImpuestoIva;
    }

    public void setOcoImpuestoIva(BigDecimal ocoImpuestoIva) {
        this.ocoImpuestoIva = ocoImpuestoIva;
    }

    @Column(name = "OCO_IMPUESTO_RENT", nullable = false)
    public BigDecimal getOcoImpuestoRent() {
        return ocoImpuestoRent;
    }

    public void setOcoImpuestoRent(BigDecimal ocoImpuestoRent) {
        this.ocoImpuestoRent = ocoImpuestoRent;
    }
    @Column(name = "OCO_IVA", nullable = false)
    public BigDecimal getOcoIva() {
        return ocoIva;
    }

    public void setOcoIva(BigDecimal ocoIva) {
        this.ocoIva = ocoIva;
    }

    @Column(name = "OCO_SUBTOTAL", nullable = false)
    public BigDecimal getOcoSubtotal() {
        return ocoSubtotal;
    }

    public void setOcoSubtotal(BigDecimal ocoSubtotal) {
        this.ocoSubtotal = ocoSubtotal;
    }

    @Column(name = "OCO_VALOR_ICA", nullable = false)
    public BigDecimal getOcoValorIca() {
        return ocoValorIca;
    }

    public void setOcoValorIca(BigDecimal ocoValorIca) {
        this.ocoValorIca = ocoValorIca;
    }

    @Column(name = "OCO_VALOR_INI")
    public BigDecimal getOcoValorIni() {
        return ocoValorIni;
    }

    public void setOcoValorIni(BigDecimal ocoValorIni) {
        this.ocoValorIni = ocoValorIni;
    }

    @Column(name = "OCO_VALOR_IVA", nullable = false)
    public BigDecimal getOcoValorIva() {
        return ocoValorIva;
    }

    public void setOcoValorIva(BigDecimal ocoValorIva) {
        this.ocoValorIva = ocoValorIva;
    }

    @Column(name = "OCO_VALOR_RENTA", nullable = false)
    public BigDecimal getOcoValorRenta() {
        return ocoValorRenta;
    }

    public void setOcoValorRenta(BigDecimal ocoValorRenta) {
        this.ocoValorRenta = ocoValorRenta;
    }


    @ManyToOne
    @JoinColumn(name = "OBL_CODIGO")
    public SiiObligacion getSiiObligacion() {
        return siiObligacion;
    }

    public void setSiiObligacion(SiiObligacion siiObligacion) {
        this.siiObligacion = siiObligacion;
    }

    @ManyToOne
    @JoinColumn(name = "CGA_CODIGO")
    public SiiConceptoGasto getSiiConceptoGasto() {
        return siiConceptoGasto;
    }

    public void setSiiConceptoGasto(SiiConceptoGasto siiConceptoGasto) {
        this.siiConceptoGasto = siiConceptoGasto;
    }

    @ManyToOne
    @JoinColumn(name = "RP_CODIGO")
    public SiiRp getSiiRp() {
        return siiRp;
    }

    public void setSiiRp(SiiRp siiRp) {
        this.siiRp = siiRp;
    }

    @Column(name = "OCO_AIU", nullable = false)
    public BigDecimal getOcoAiu() {
        return ocoAiu;
    }

    public void setOcoAiu(BigDecimal ocoAiu) {
        this.ocoAiu = ocoAiu;
    }

    @ManyToOne
    @JoinColumn(name = "FFC_CODIGO")
    public SiiFuenteFinancContab getSiiFuenteFinancContab() {
        return siiFuenteFinancContab;
    }

    public void setSiiFuenteFinancContab(SiiFuenteFinancContab siiFuenteFinancContab) {
        this.siiFuenteFinancContab = siiFuenteFinancContab;
    }

    @OneToMany(mappedBy = "siiObligacionConcepto")
    public List<SiiOblConcRpDetRubCdp> getSiiOblConcRpDetRubCdpList() {
        return siiOblConcRpDetRubCdpList;
    }

    public void setSiiOblConcRpDetRubCdpList(List<SiiOblConcRpDetRubCdp> siiOblConcRpDetRubCdpList) {
        this.siiOblConcRpDetRubCdpList = siiOblConcRpDetRubCdpList;
    }

    public SiiOblConcRpDetRubCdp addSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().add(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiObligacionConcepto(this);
        return siiOblConcRpDetRubCdp;
    }

    public SiiOblConcRpDetRubCdp removeSiiOblConcRpDetRubCdp(SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) {
        getSiiOblConcRpDetRubCdpList().remove(siiOblConcRpDetRubCdp);
        siiOblConcRpDetRubCdp.setSiiObligacionConcepto(null);
        return siiOblConcRpDetRubCdp;
    }

    @ManyToOne
    @JoinColumn(name = "AIC_CODIGO")
    public SiiActividadIca getSiiActividadIca() {
        return siiActividadIca;
    }

    public void setSiiActividadIca(SiiActividadIca siiActividadIca) {
        this.siiActividadIca = siiActividadIca;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_RENTA")
    public SiiTipoRetencion getSiiTipoRetencionRenta() {
        return siiTipoRetencionRenta;
    }

    public void setSiiTipoRetencionRenta(SiiTipoRetencion siiTipoRetencionRenta) {
        this.siiTipoRetencionRenta = siiTipoRetencionRenta;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_IVA")
    public SiiTipoRetencion getSiiTipoRetencionIva() {
        return siiTipoRetencionIva;
    }

    public void setSiiTipoRetencionIva(SiiTipoRetencion siiTipoRetencionIva) {
        this.siiTipoRetencionIva = siiTipoRetencionIva;
    }

    @Column(name = "OCO_BASE_RETEF")
    public BigDecimal getOcoBaseRetef() {
        return ocoBaseRetef;
    }

    public void setOcoBaseRetef(BigDecimal ocoBaseRetef) {
        this.ocoBaseRetef = ocoBaseRetef;
    }

    @Column(name = "OCO_ESTAMPILLA_UNAL", length = 1)
    public String getOcoEstampillaUnal() {
        return ocoEstampillaUnal;
    }

    public void setOcoEstampillaUnal(String ocoEstampillaUnal) {
        this.ocoEstampillaUnal = ocoEstampillaUnal;
    }

    @Column(name = "OCO_VALOR_VOL_AFC")
    public BigDecimal getOcoValorVolAfc() {
        return ocoValorVolAfc;
    }

    public void setOcoValorVolAfc(BigDecimal ocoValorVolAfc) {
        this.ocoValorVolAfc = ocoValorVolAfc;
    }

    @Column(name = "OCO_VALOR_VOL_AFP")
    public BigDecimal getOcoValorVolAfp() {
        return ocoValorVolAfp;
    }

    public void setOcoValorVolAfp(BigDecimal ocoValorVolAfp) {
        this.ocoValorVolAfp = ocoValorVolAfp;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_BENEF_AFP")
    public SiiPersona getSiiPersonaBenefAfp() {
        return siiPersonaBenefAfp;
    }

    public void setSiiPersonaBenefAfp(SiiPersona siiPersonaBenefAfp) {
        this.siiPersonaBenefAfp = siiPersonaBenefAfp;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_BENEF_AFC")
    public SiiPersona getSiiPersonaBenefAfc() {
        return siiPersonaBenefAfc;
    }

    public void setSiiPersonaBenefAfc(SiiPersona siiPersonaBenefAfc) {
        this.siiPersonaBenefAfc = siiPersonaBenefAfc;
    }

    @Column(name = "OCO_VALOR_RET_ESTAMP")
    public BigDecimal getOcoValorRetEstamp() {
        return ocoValorRetEstamp;
    }

    public void setOcoValorRetEstamp(BigDecimal ocoValorRetEstamp) {
        this.ocoValorRetEstamp = ocoValorRetEstamp;
    }

    @ManyToOne
    @JoinColumn(name = "TRE_CODIGO_ESTAMP")
    public SiiTipoRetencion getSiiTipoRetencionEstamp() {
        return siiTipoRetencionEstamp;
    }

    public void setSiiTipoRetencionEstamp(SiiTipoRetencion siiTipoRetencionEstamp) {
        this.siiTipoRetencionEstamp = siiTipoRetencionEstamp;
    }
    
    @Column(name = "OCO_IMPUESTO_ESTAMP")
    public BigDecimal getOcoImpuestoEstamp() {
        return ocoImpuestoEstamp;
    }
    
    public void setOcoImpuestoEstamp(BigDecimal ocoImpuestoEstamp) {
        this.ocoImpuestoEstamp = ocoImpuestoEstamp;
    }

    @OneToMany(mappedBy = "siiObligacionConcepto")
    public List<SiiNotaCredOblConcepto> getSiiNotaCredOblConceptoList() {
        return siiNotaCredOblConceptoList;
    }

    public void setSiiNotaCredOblConceptoList(List<SiiNotaCredOblConcepto> siiNotaCredOblConceptoList) {
        this.siiNotaCredOblConceptoList = siiNotaCredOblConceptoList;
    }

    public SiiNotaCredOblConcepto addSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().add(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiObligacionConcepto(this);
        return siiNotaCredOblConcepto;
    }

    public SiiNotaCredOblConcepto removeSiiNotaCredOblConcepto(SiiNotaCredOblConcepto siiNotaCredOblConcepto) {
        getSiiNotaCredOblConceptoList().remove(siiNotaCredOblConcepto);
        siiNotaCredOblConcepto.setSiiObligacionConcepto(null);
        return siiNotaCredOblConcepto;
    }
}
