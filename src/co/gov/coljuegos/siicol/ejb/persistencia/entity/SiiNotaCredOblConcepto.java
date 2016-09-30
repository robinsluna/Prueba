package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SII_NOTA_CRED_OBL_CONCEPTO")
public class SiiNotaCredOblConcepto implements Serializable {
    private static final long serialVersionUID = 7931575629040706828L;
    private BigDecimal ncoAiu;
    private BigDecimal ncoBenefDedAfc;
    private BigDecimal ncoBenefDedAfp;
    private Long ncoCodigo;
    private BigDecimal ncoIva;
    private BigDecimal ncoSubtotal;
    private BigDecimal ncoValor;
    private SiiNotaCredito siiNotaCredito;
    private SiiObligacionConcepto siiObligacionConcepto;
    private BigDecimal ncoValorRetest;
    private BigDecimal ncoValorRetica;
    private BigDecimal ncoValorRetiva;
    private BigDecimal ncoValorRetrenta;
    private SiiDetalleContNomina siiDetalleContNomina;

    public SiiNotaCredOblConcepto() {
    }

    public SiiNotaCredOblConcepto(BigDecimal ncoAiu, BigDecimal ncoBenefDedAfc, BigDecimal ncoBenefDedAfp, Long ncoCodigo, BigDecimal ncoIva,
                                  BigDecimal ncoSubtotal, BigDecimal ncoValor, SiiNotaCredito siiNotaCredito,
                                  SiiObligacionConcepto siiObligacionConcepto) {
        this.ncoAiu = ncoAiu;
        this.ncoBenefDedAfc = ncoBenefDedAfc;
        this.ncoBenefDedAfp = ncoBenefDedAfp;
        this.ncoCodigo = ncoCodigo;
        this.ncoIva = ncoIva;
        this.ncoSubtotal = ncoSubtotal;
        this.ncoValor = ncoValor;
        this.siiNotaCredito = siiNotaCredito;
        this.siiObligacionConcepto = siiObligacionConcepto;
    }

    @Column(name = "NCO_AIU")
    public BigDecimal getNcoAiu() {
        return ncoAiu;
    }

    public void setNcoAiu(BigDecimal ncoAiu) {
        this.ncoAiu = ncoAiu;
    }

    @Column(name = "NCO_BENEF_DED_AFC")
    public BigDecimal getNcoBenefDedAfc() {
        return ncoBenefDedAfc;
    }

    public void setNcoBenefDedAfc(BigDecimal ncoBenefDedAfc) {
        this.ncoBenefDedAfc = ncoBenefDedAfc;
    }

    @Column(name = "NCO_BENEF_DED_AFP")
    public BigDecimal getNcoBenefDedAfp() {
        return ncoBenefDedAfp;
    }

    public void setNcoBenefDedAfp(BigDecimal ncoBenefDedAfp) {
        this.ncoBenefDedAfp = ncoBenefDedAfp;
    }

    @Id
    @Column(name = "NCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_NOTA_CRED_OBL_CONC_COD")
    @SequenceGenerator(name = "SEQ_NOTA_CRED_OBL_CONC_COD", sequenceName = "SEQ_NOTA_CRED_OBL_CONC_COD",allocationSize=1)
    public Long getNcoCodigo() {
        return ncoCodigo;
    }

    public void setNcoCodigo(Long ncoCodigo) {
        this.ncoCodigo = ncoCodigo;
    }

    @Column(name = "NCO_IVA")
    public BigDecimal getNcoIva() {
        return ncoIva;
    }

    public void setNcoIva(BigDecimal ncoIva) {
        this.ncoIva = ncoIva;
    }

    @Column(name = "NCO_SUBTOTAL", nullable = false)
    public BigDecimal getNcoSubtotal() {
        return ncoSubtotal;
    }

    public void setNcoSubtotal(BigDecimal ncoSubtotal) {
        this.ncoSubtotal = ncoSubtotal;
    }

    @Column(name = "NCO_VALOR", nullable = false)
    public BigDecimal getNcoValor() {
        return ncoValor;
    }

    public void setNcoValor(BigDecimal ncoValor) {
        this.ncoValor = ncoValor;
    }


    @ManyToOne
    @JoinColumn(name = "NCR_CODIGO")
    public SiiNotaCredito getSiiNotaCredito() {
        return siiNotaCredito;
    }

    public void setSiiNotaCredito(SiiNotaCredito siiNotaCredito) {
        this.siiNotaCredito = siiNotaCredito;
    }


    @ManyToOne
    @JoinColumn(name = "OCO_CODIGO")
    public SiiObligacionConcepto getSiiObligacionConcepto() {
        return siiObligacionConcepto;
    }

    public void setSiiObligacionConcepto(SiiObligacionConcepto siiObligacionConcepto) {
        this.siiObligacionConcepto = siiObligacionConcepto;
    }

    @Column(name = "NCO_VALOR_RETEST")
    public BigDecimal getNcoValorRetest() {
        return ncoValorRetest;
    }

    public void setNcoValorRetest(BigDecimal ncoValorRetest) {
        this.ncoValorRetest = ncoValorRetest;
    }

    @Column(name = "NCO_VALOR_RETICA")
    public BigDecimal getNcoValorRetica() {
        return ncoValorRetica;
    }

    public void setNcoValorRetica(BigDecimal ncoValorRetica) {
        this.ncoValorRetica = ncoValorRetica;
    }

    @Column(name = "NCO_VALOR_RETIVA")
    public BigDecimal getNcoValorRetiva() {
        return ncoValorRetiva;
    }

    public void setNcoValorRetiva(BigDecimal ncoValorRetiva) {
        this.ncoValorRetiva = ncoValorRetiva;
    }

    @Column(name = "NCO_VALOR_RETRENTA")
    public BigDecimal getNcoValorRetrenta() {
        return ncoValorRetrenta;
    }

    public void setNcoValorRetrenta(BigDecimal ncoValorRetrenta) {
        this.ncoValorRetrenta = ncoValorRetrenta;
    }
    @ManyToOne
    @JoinColumn(name = "DCM_CODIGO")
    public SiiDetalleContNomina getSiiDetalleContNomina() {
        return siiDetalleContNomina;
    }

    public void setSiiDetalleContNomina(SiiDetalleContNomina siiDetalleContNomina) {
        this.siiDetalleContNomina = siiDetalleContNomina;
    }
}
