/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 12-03-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOblConcRpDetRubCdp;

import java.math.BigDecimal;


/**
 * Value Object para la entidad de intersecci&oacute;n entre Obligaci&oacute;n Concepto y RpDetRubroCdp.
 * Tabla: <b>SII_OBL_CONC_RP_DET_RUB_CDP</b>.
 * @author Camilo Miranda
 */
public class OblConcRpDetRubCdpVO 
{
    private Long ocrCodigo;
    private BigDecimal ocrValor;
    private ObligacionConceptoVO obligacionConceptoVo;
    private RpDetRubroCdpVO rpDetRubroCdpVo;
    private ObligacionVO obligacionVo;
    
    
    
    /**
     * Constructor.
     */
    public OblConcRpDetRubCdpVO() { }
    
    
    /**
     * Constructor.
     * @param siiOblConcRpDetRubCdp - Entity.
     */
    public OblConcRpDetRubCdpVO (SiiOblConcRpDetRubCdp siiOblConcRpDetRubCdp) 
    {
        if (siiOblConcRpDetRubCdp!=null) {
            this.ocrCodigo = siiOblConcRpDetRubCdp.getOcrCodigo();
            this.ocrValor = siiOblConcRpDetRubCdp.getOcrValor();
            
            if (siiOblConcRpDetRubCdp.getSiiObligacion()!=null) {
                this.obligacionVo = new ObligacionVO(siiOblConcRpDetRubCdp.getSiiObligacion());
            }
            
            if (siiOblConcRpDetRubCdp.getSiiObligacionConcepto()!=null) {
                this.obligacionConceptoVo = new ObligacionConceptoVO(siiOblConcRpDetRubCdp.getSiiObligacionConcepto());
            }
            
            if (siiOblConcRpDetRubCdp.getSiiRpDetRubroCdp()!=null) {
                this.rpDetRubroCdpVo = new RpDetRubroCdpVO(siiOblConcRpDetRubCdp.getSiiRpDetRubroCdp());
            }
        }
    }


    public void setOcrCodigo(Long ocrCodigo) {
        this.ocrCodigo = ocrCodigo;
    }

    public Long getOcrCodigo() {
        return ocrCodigo;
    }

    public void setOcrValor(BigDecimal ocrValor) {
        this.ocrValor = ocrValor;
    }

    public BigDecimal getOcrValor() {
        return ocrValor;
    }

    public void setObligacionConceptoVo(ObligacionConceptoVO obligacionConceptoVo) {
        this.obligacionConceptoVo = obligacionConceptoVo;
    }

    public ObligacionConceptoVO getObligacionConceptoVo() {
        return obligacionConceptoVo;
    }

    public void setRpDetRubroCdpVo(RpDetRubroCdpVO rpDetRubroCdpVo) {
        this.rpDetRubroCdpVo = rpDetRubroCdpVo;
    }

    public RpDetRubroCdpVO getRpDetRubroCdpVo() {
        return rpDetRubroCdpVo;
    }

    public void setObligacionVo(ObligacionVO obligacionVo) {
        this.obligacionVo = obligacionVo;
    }

    public ObligacionVO getObligacionVo() {
        return obligacionVo;
    }
}
