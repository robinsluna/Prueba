/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-06-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;

import java.math.BigDecimal;


/**
 * Value Object para la relaci&oacute;n entre Notas de Cr&eacute;dito y los Conceptos de Obligaci&oacute;n.
 * @author Camilo Miranda
 */
public class NotaCredOblConceptoVO 
{
    private Long ncoCodigo;
    private BigDecimal ncoAiu;
    private BigDecimal ncoBenefDedAfc;
    private BigDecimal ncoBenefDedAfp;
    private BigDecimal ncoIva;
    private BigDecimal ncoSubtotal;
    private BigDecimal ncoValor;
    private BigDecimal ncoValorRetest;
    private BigDecimal ncoValorRetica;
    private BigDecimal ncoValorRetiva;
    private BigDecimal ncoValorRetrenta;
    
    private NotaCreditoVO notaCreditoVo;
    private ObligacionConceptoVO obligacionConceptoVo;
    private DetalleContNominaVO detalleContNominaVo;
    
    
    
    /**
     * Constructor.
     */
    public NotaCredOblConceptoVO() { }
    
    
    /**
     * 
     * @param siiNotaCredOblConcepto
     */
    public NotaCredOblConceptoVO (SiiNotaCredOblConcepto siiNotaCredOblConcepto) 
    {
        if (siiNotaCredOblConcepto!=null) {
            this.ncoCodigo = siiNotaCredOblConcepto.getNcoCodigo();
            this.ncoAiu = siiNotaCredOblConcepto.getNcoAiu();
            this.ncoBenefDedAfc = siiNotaCredOblConcepto.getNcoBenefDedAfc();
            this.ncoBenefDedAfp = siiNotaCredOblConcepto.getNcoBenefDedAfp();
            this.ncoIva = siiNotaCredOblConcepto.getNcoIva();
            this.ncoSubtotal = siiNotaCredOblConcepto.getNcoSubtotal();
            this.ncoValor = siiNotaCredOblConcepto.getNcoValor();
            this.ncoValorRetest = siiNotaCredOblConcepto.getNcoValorRetest();
            this.ncoValorRetica = siiNotaCredOblConcepto.getNcoValorRetica();
            this.ncoValorRetiva = siiNotaCredOblConcepto.getNcoValorRetiva();
            this.ncoValorRetrenta = siiNotaCredOblConcepto.getNcoValorRetrenta();
            
            
            if (siiNotaCredOblConcepto.getSiiNotaCredito()!=null)
                this.notaCreditoVo = new NotaCreditoVO(siiNotaCredOblConcepto.getSiiNotaCredito());
            
            if (siiNotaCredOblConcepto.getSiiObligacionConcepto()!=null)
                this.obligacionConceptoVo = new ObligacionConceptoVO(siiNotaCredOblConcepto.getSiiObligacionConcepto());
            
            if (siiNotaCredOblConcepto.getSiiDetalleContNomina()!=null)
                this.detalleContNominaVo = new DetalleContNominaVO(siiNotaCredOblConcepto.getSiiDetalleContNomina());
        }
    }
    
    
    
    
    /**
     * Calcula el <b>TOTAL</b> del Concepto de la Nota de Cr&eacute;dito.
     * @return SUBTOTAL + IVA.
     */
    public BigDecimal getTotal () {
        BigDecimal total = new BigDecimal(0);
        if (this.ncoSubtotal!=null)
            total = total.add(this.ncoSubtotal);
        if (this.ncoIva!=null)
            total = total.add(this.ncoIva);
        return (total);
    }
    
    
    
    /**
     * Obtiene el Valor a Descontar para el Concepto de la Nota de Cr&eacute;dito.
     * @return SUBTOTAL + IVA - RETENCION_RENTA - RETENCION_IVA - RETENCION_ICA - RETENCION_UNAL - VALOR_AFP - VALOR_AFC.
     */
    public BigDecimal getValorADescontar() 
    {
        BigDecimal valorADescontar = new BigDecimal(0);
        
        BigDecimal total = this.getTotal();
        valorADescontar = valorADescontar.add(total);
        
        if (this.ncoValorRetrenta!=null)
            valorADescontar = valorADescontar.subtract(this.ncoValorRetrenta);
        
        if (this.ncoValorRetiva!=null)
            valorADescontar = valorADescontar.subtract(this.ncoValorRetiva);
        
        if (this.ncoValorRetica!=null)
            valorADescontar = valorADescontar.subtract(this.ncoValorRetica);
    
        if (this.ncoValorRetest!=null)
            valorADescontar = valorADescontar.subtract(this.ncoValorRetest);
        
        if (this.ncoBenefDedAfp!=null)
            valorADescontar = valorADescontar.subtract(this.ncoBenefDedAfp);
        
        if (this.ncoBenefDedAfc!=null)
            valorADescontar = valorADescontar.subtract(this.ncoBenefDedAfc);
        
        
        return (valorADescontar);
    }
    
    
    
    
    public void setNcoAiu(BigDecimal ncoAiu) {
        this.ncoAiu = ncoAiu;
    }

    public BigDecimal getNcoAiu() {
        return ncoAiu;
    }

    public void setNcoBenefDedAfc(BigDecimal ncoBenefDedAfc) {
        this.ncoBenefDedAfc = ncoBenefDedAfc;
    }

    public BigDecimal getNcoBenefDedAfc() {
        return ncoBenefDedAfc;
    }

    public void setNcoBenefDedAfp(BigDecimal ncoBenefDedAfp) {
        this.ncoBenefDedAfp = ncoBenefDedAfp;
    }

    public BigDecimal getNcoBenefDedAfp() {
        return ncoBenefDedAfp;
    }

    public void setNcoCodigo(Long ncoCodigo) {
        this.ncoCodigo = ncoCodigo;
    }

    public Long getNcoCodigo() {
        return ncoCodigo;
    }

    public void setNcoIva(BigDecimal ncoIva) {
        this.ncoIva = ncoIva;
    }

    public BigDecimal getNcoIva() {
        return ncoIva;
    }

    public void setNcoSubtotal(BigDecimal ncoSubtotal) {
        this.ncoSubtotal = ncoSubtotal;
    }

    public BigDecimal getNcoSubtotal() {
        return ncoSubtotal;
    }

    public void setNcoValor(BigDecimal ncoValor) {
        this.ncoValor = ncoValor;
    }

    public BigDecimal getNcoValor() {
        return ncoValor;
    }

    public void setNotaCreditoVo(NotaCreditoVO notaCreditoVo) {
        this.notaCreditoVo = notaCreditoVo;
    }

    public NotaCreditoVO getNotaCreditoVo() {
        return notaCreditoVo;
    }

    public void setObligacionConceptoVo(ObligacionConceptoVO obligacionConceptoVo) {
        this.obligacionConceptoVo = obligacionConceptoVo;
    }

    public ObligacionConceptoVO getObligacionConceptoVo() {
        return obligacionConceptoVo;
    }

    public void setNcoValorRetest(BigDecimal ncoValorRetest) {
        this.ncoValorRetest = ncoValorRetest;
    }

    public BigDecimal getNcoValorRetest() {
        return ncoValorRetest;
    }

    public void setNcoValorRetica(BigDecimal ncoValorRetica) {
        this.ncoValorRetica = ncoValorRetica;
    }

    public BigDecimal getNcoValorRetica() {
        return ncoValorRetica;
    }

    public void setNcoValorRetiva(BigDecimal ncoValorRetiva) {
        this.ncoValorRetiva = ncoValorRetiva;
    }

    public BigDecimal getNcoValorRetiva() {
        return ncoValorRetiva;
    }

    public void setNcoValorRetrenta(BigDecimal ncoValorRetrenta) {
        this.ncoValorRetrenta = ncoValorRetrenta;
    }

    public BigDecimal getNcoValorRetrenta() {
        return ncoValorRetrenta;
    }

    public void setDetalleContNominaVo(DetalleContNominaVO detalleContNominaVo) {
        this.detalleContNominaVo = detalleContNominaVo;
    }

    public DetalleContNominaVO getDetalleContNominaVo() {
        return detalleContNominaVo;
    }
}
