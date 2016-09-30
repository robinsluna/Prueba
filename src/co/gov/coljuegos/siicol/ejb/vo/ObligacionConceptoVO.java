package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionConcepto;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;


public class ObligacionConceptoVO {

    private Long ocoCodigo;
    private BigDecimal ocoImpuestoIca;
    private BigDecimal ocoImpuestoIva;
    private BigDecimal ocoImpuestoRent;
    private BigDecimal ocoValorIca;
    private BigDecimal ocoValorIni;
    private BigDecimal ocoValorIva;
    private BigDecimal ocoValorRenta;
    private BigDecimal ocoAiu;
    private BigDecimal ocoIva;
    private BigDecimal ocoSubtotal;
    private BigDecimal ocoBaseRetef;
    private BigDecimal ocoValorVolAfc;
    private BigDecimal ocoValorVolAfp;
    private BigDecimal ocoValorRetEstamp;
    private String ocoEstampillaUnal;
    private BigDecimal ocoImpuestoEstamp;
    
    private ObligacionVO obligacionVo;
    private ConceptoGastoVO conceptoGastoVo;
    private RpVO rpVo;
    private FuenteFinancContabVO fuenteFinancContabVo;
    private TipoRetencionVO tipoRetencionRentaVo;
    private TipoRetencionVO tipoRetencionIvaVo;
    private ActividadIcaVO actividadIcaVo;
    private TipoRetencionVO tipoRetencionEstamp;
    private PersonaVO personaBenefAfpVo;
    private PersonaVO personaBenefAfcVo;
    
    private List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList;
    

    
    /**
     * Constructor.
     */
    public ObligacionConceptoVO() { }
    
    
    
    /**
     * Constructor.
     * @param siiObligacionConcepto
     */
    public ObligacionConceptoVO(SiiObligacionConcepto siiObligacionConcepto){
        this.ocoCodigo =  siiObligacionConcepto.getOcoCodigo();    
        this.ocoImpuestoIca =  siiObligacionConcepto.getOcoImpuestoIca();
        this.ocoImpuestoIva =  siiObligacionConcepto.getOcoImpuestoIva();
        this.ocoImpuestoRent =  siiObligacionConcepto.getOcoImpuestoRent();
        this.ocoValorIca =  siiObligacionConcepto.getOcoValorIca();
        this.ocoValorIni = siiObligacionConcepto.getOcoValorIni();
        this.ocoValorIva =  siiObligacionConcepto.getOcoValorIva();
        this.ocoValorRenta =  siiObligacionConcepto.getOcoValorRenta();
        this.ocoAiu =  siiObligacionConcepto.getOcoAiu();
        this.ocoIva =  siiObligacionConcepto.getOcoIva();
        this.ocoSubtotal =  siiObligacionConcepto.getOcoSubtotal();
        this.ocoBaseRetef = siiObligacionConcepto.getOcoBaseRetef();
        this.ocoValorVolAfc = siiObligacionConcepto.getOcoValorVolAfc();
        this.ocoValorVolAfp = siiObligacionConcepto.getOcoValorVolAfp();
        this.ocoValorRetEstamp = siiObligacionConcepto.getOcoValorRetEstamp();
        this.ocoEstampillaUnal = siiObligacionConcepto.getOcoEstampillaUnal();
        this.ocoImpuestoEstamp = siiObligacionConcepto.getOcoImpuestoEstamp();
        
        
        if(siiObligacionConcepto.getSiiObligacion() != null){
            this.obligacionVo=  new ObligacionVO(siiObligacionConcepto.getSiiObligacion());
        }
        if(siiObligacionConcepto.getSiiConceptoGasto() != null){
            this.conceptoGastoVo=  new ConceptoGastoVO(siiObligacionConcepto.getSiiConceptoGasto());
        }
        if(siiObligacionConcepto.getSiiRp() != null){
            this.rpVo=  new RpVO(siiObligacionConcepto.getSiiRp());
        }
        if (siiObligacionConcepto.getSiiFuenteFinancContab()!=null) {
            this.fuenteFinancContabVo = new FuenteFinancContabVO(siiObligacionConcepto.getSiiFuenteFinancContab());
        }
        if (siiObligacionConcepto.getSiiTipoRetencionRenta()!=null) {
            this.tipoRetencionRentaVo = new TipoRetencionVO(siiObligacionConcepto.getSiiTipoRetencionRenta());
        }
        if (siiObligacionConcepto.getSiiTipoRetencionIva()!=null) {
            this.tipoRetencionIvaVo = new TipoRetencionVO(siiObligacionConcepto.getSiiTipoRetencionIva());
        }
        if (siiObligacionConcepto.getSiiActividadIca()!=null) {
            this.actividadIcaVo = new ActividadIcaVO(siiObligacionConcepto.getSiiActividadIca());
        }
        if (siiObligacionConcepto.getSiiTipoRetencionEstamp()!=null) {
            this.tipoRetencionEstamp = new TipoRetencionVO(siiObligacionConcepto.getSiiTipoRetencionEstamp());
        }
        if (siiObligacionConcepto.getSiiPersonaBenefAfp()!=null) {
            this.personaBenefAfpVo = new PersonaVO(siiObligacionConcepto.getSiiPersonaBenefAfp());
        }
        if (siiObligacionConcepto.getSiiPersonaBenefAfc()!=null) {
            this.personaBenefAfcVo = new PersonaVO(siiObligacionConcepto.getSiiPersonaBenefAfc());
        }
    }


    public void setOcoCodigo(Long ocoCodigo) {
        this.ocoCodigo = ocoCodigo;
    }

    public Long getOcoCodigo() {
        return ocoCodigo;
    }

    public void setOcoImpuestoIca(BigDecimal ocoImpuestoIca) {
        this.ocoImpuestoIca = ocoImpuestoIca;
    }

    public BigDecimal getOcoImpuestoIca() {
        return ocoImpuestoIca;
    }

    public void setOcoImpuestoIva(BigDecimal ocoImpuestoIva) {
        this.ocoImpuestoIva = ocoImpuestoIva;
    }

    public BigDecimal getOcoImpuestoIva() {
        return ocoImpuestoIva;
    }

    public void setOcoImpuestoRent(BigDecimal ocoImpuestoRent) {
        this.ocoImpuestoRent = ocoImpuestoRent;
    }

    public BigDecimal getOcoImpuestoRent() {
        return ocoImpuestoRent;
    }

    public void setOcoValorIca(BigDecimal ocoValorIca) {
        this.ocoValorIca = ocoValorIca;
    }

    public BigDecimal getOcoValorIca() {
        return ocoValorIca;
    }

    public void setOcoValorIva(BigDecimal ocoValorIva) {
        this.ocoValorIva = ocoValorIva;
    }

    public BigDecimal getOcoValorIva() {
        return ocoValorIva;
    }

    public void setOcoValorRenta(BigDecimal ocoValorRenta) {
        this.ocoValorRenta = ocoValorRenta;
    }

    public BigDecimal getOcoValorRenta() {
        return ocoValorRenta;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }

    public void setConceptoGastoVo(ConceptoGastoVO conceptoGastoVo) {
        this.conceptoGastoVo = conceptoGastoVo;
    }

    public ConceptoGastoVO getConceptoGastoVo() {
        return conceptoGastoVo;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }
    
    public void setOcoAiu(BigDecimal ocoAiu) {
        this.ocoAiu = ocoAiu;
    }

    public BigDecimal getOcoAiu() {
        return ocoAiu;
    }

    public void setOcoIva(BigDecimal ocoIva) {
        this.ocoIva = ocoIva;
    }

    public BigDecimal getOcoIva() {
        return ocoIva;
    }


    public void setOcoValorIni(BigDecimal ocoValorIni) {
        this.ocoValorIni = ocoValorIni;
    }

    public BigDecimal getOcoValorIni() {
        return ocoValorIni;
    }

    public void setOcoSubtotal(BigDecimal ocoSubtotal) {
        this.ocoSubtotal = ocoSubtotal;
    }

    public BigDecimal getOcoSubtotal() {
        return ocoSubtotal;
    }


    public void setFuenteFinancContabVo(FuenteFinancContabVO fuenteFinancContabVo) {
        this.fuenteFinancContabVo = fuenteFinancContabVo;
    }

    public FuenteFinancContabVO getFuenteFinancContabVo() {
        return fuenteFinancContabVo;
    }


    public void setOblConcRpDetRubCdpList(List<OblConcRpDetRubCdpVO> oblConcRpDetRubCdpList) {
        this.oblConcRpDetRubCdpList = oblConcRpDetRubCdpList;
    }

    public List<OblConcRpDetRubCdpVO> getOblConcRpDetRubCdpList() {
        return oblConcRpDetRubCdpList;
    }


    public void setTipoRetencionRentaVo(TipoRetencionVO tipoRetencionRentaVo) {
        this.tipoRetencionRentaVo = tipoRetencionRentaVo;
    }

    public TipoRetencionVO getTipoRetencionRentaVo() {
        return tipoRetencionRentaVo;
    }

    public void setTipoRetencionIvaVo(TipoRetencionVO tipoRetencionIvaVo) {
        this.tipoRetencionIvaVo = tipoRetencionIvaVo;
    }

    public TipoRetencionVO getTipoRetencionIvaVo() {
        return tipoRetencionIvaVo;
    }

    public void setActividadIcaVo(ActividadIcaVO actividadIcaVo) {
        this.actividadIcaVo = actividadIcaVo;
    }

    public ActividadIcaVO getActividadIcaVo() {
        return actividadIcaVo;
    }

    public void setOcoBaseRetef(BigDecimal ocoBaseRetef) {
        this.ocoBaseRetef = ocoBaseRetef;
    }

    public BigDecimal getOcoBaseRetef() {
        return ocoBaseRetef;
    }

    public void setOcoValorVolAfc(BigDecimal ocoValorVolAfc) {
        this.ocoValorVolAfc = ocoValorVolAfc;
    }

    public BigDecimal getOcoValorVolAfc() {
        return ocoValorVolAfc;
    }

    public void setOcoValorVolAfp(BigDecimal ocoValorVolAfp) {
        this.ocoValorVolAfp = ocoValorVolAfp;
    }

    public BigDecimal getOcoValorVolAfp() {
        return ocoValorVolAfp;
    }

    public void setOcoValorRetEstamp(BigDecimal ocoValorRetEstamp) {
        this.ocoValorRetEstamp = ocoValorRetEstamp;
    }

    public BigDecimal getOcoValorRetEstamp() {
        return ocoValorRetEstamp;
    }

    public void setOcoEstampillaUnal(String ocoEstampillaUnal) {
        this.ocoEstampillaUnal = ocoEstampillaUnal;
    }

    public String getOcoEstampillaUnal() {
        return ocoEstampillaUnal;
    }

    public void setTipoRetencionEstamp(TipoRetencionVO tipoRetencionEstamp) {
        this.tipoRetencionEstamp = tipoRetencionEstamp;
    }

    public TipoRetencionVO getTipoRetencionEstamp() {
        return tipoRetencionEstamp;
    }

    public void setPersonaBenefAfpVo(PersonaVO personaBenefAfpVo) {
        this.personaBenefAfpVo = personaBenefAfpVo;
    }

    public PersonaVO getPersonaBenefAfpVo() {
        return personaBenefAfpVo;
    }

    public void setPersonaBenefAfcVo(PersonaVO personaBenefAfcVo) {
        this.personaBenefAfcVo = personaBenefAfcVo;
    }

    public PersonaVO getPersonaBenefAfcVo() {
        return personaBenefAfcVo;
    }

    public void setOcoImpuestoEstamp(BigDecimal ocoImpuestoEstamp) {
        this.ocoImpuestoEstamp = ocoImpuestoEstamp;
    }

    public BigDecimal getOcoImpuestoEstamp() {
        return ocoImpuestoEstamp;
    }

    
    
    
    /**
     * Adiciona un registro al listado de OblConcRpDetRubCdpVO.
     * @param oblConcRpDetRubCdpVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean addOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) 
    {
        boolean exitoso = false;
        
        if (oblConcRpDetRubCdpList==null)
            oblConcRpDetRubCdpList = new ArrayList<OblConcRpDetRubCdpVO>();
        
        exitoso = oblConcRpDetRubCdpList.add(oblConcRpDetRubCdpVo);
        
        if (exitoso)
            oblConcRpDetRubCdpVo.setObligacionConceptoVo(this);
        
        return (exitoso);
    }
    
    
    /**
     * Elimina un registro del listado OblConcRpDetRubCdpVO.
     * @param oblConcRpDetRubCdpVo - Objeto a adicionar.
     * @return ¿Operaci&oacute;n exitosa?
     */
    public boolean removeOblConcRpDetRubCdp (OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) {
        boolean exitoso = false;
        
        if (oblConcRpDetRubCdpList!=null) {
            exitoso = oblConcRpDetRubCdpList.remove(oblConcRpDetRubCdpVo);
            
            if (exitoso)
                oblConcRpDetRubCdpVo.setObligacionConceptoVo(null);
        }
        
        return (exitoso);
    }

    
    
    
    /**
     * Calcula el <b>TOTAL</b> del Concepto de la Obligaci&oacute;n.
     * @return SUBTOTAL + IVA.
     */
    public BigDecimal getTotal () {
        BigDecimal total = new BigDecimal(0);
        if (this.ocoSubtotal!=null)
            total = total.add(this.ocoSubtotal);
        if (this.ocoIva!=null)
            total = total.add(this.ocoIva);
        return (total);
    }
    
    
    /**
     * Obtiene el <b>VALOR A GIRAR</b>.
     * @return TOTAL - RETENCION_IMPUESTO_SOBRE_LA_RENTA - RETENCION_IVA - RETENCION_ICA - RETENCION_PRO_ESTAMPILLA_UNAL - VALOR_APORTE_VOLUNTARIO_AFP - VALOR_APORTE_VOLUNTARIO_AFC.
     */
    public BigDecimal getValorAGirar () {
        BigDecimal valorGirar = new BigDecimal(0);
        BigDecimal total = this.getTotal();
        
        if (total!=null && total.compareTo(new BigDecimal(0))>0) {
            valorGirar = total;
            if (this.ocoValorRenta!=null)
                valorGirar = valorGirar.subtract(this.ocoValorRenta);
            if (this.ocoValorIva!=null)
                valorGirar = valorGirar.subtract(this.ocoValorIva);
            if (this.ocoValorIca!=null)
                valorGirar = valorGirar.subtract(this.ocoValorIca);
            if (this.ocoValorRetEstamp!=null)
                valorGirar = valorGirar.subtract(this.ocoValorRetEstamp);
            if (this.ocoValorVolAfp!=null)
                valorGirar = valorGirar.subtract(this.ocoValorVolAfp);
            if (this.ocoValorVolAfc!=null)
                valorGirar = valorGirar.subtract(this.ocoValorVolAfc);
        }
        
        return (valorGirar);
    }
    
}
