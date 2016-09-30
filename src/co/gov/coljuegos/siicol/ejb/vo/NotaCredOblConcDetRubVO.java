/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-06-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcDetRub;

import java.math.BigDecimal;


/**
 * Value Object para el manejo de Notas de Cr&eacute;dito por Obligaci&oacute;n/Detalle Rubro CDP.
 * @author Camilo Miranda
 */
public class NotaCredOblConcDetRubVO 
{
    private Long ndrCodigo;
    private BigDecimal ndrValor;
    
    private OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo;
    private NotaCreditoVO notaCreditoVo;
    
    
    /**
     * Constructor.
     */
    public NotaCredOblConcDetRubVO() { }
    
    
    /**
     * Constructor.
     * @param siiNotaCredOblConcDetRub
     */
    public NotaCredOblConcDetRubVO (SiiNotaCredOblConcDetRub siiNotaCredOblConcDetRub) 
    {
        if (siiNotaCredOblConcDetRub!=null) {
            this.ndrCodigo = siiNotaCredOblConcDetRub.getNdrCodigo();
            this.ndrValor = siiNotaCredOblConcDetRub.getNdrValor();
            
            if (siiNotaCredOblConcDetRub.getSiiOblConcRpDetRubCdp()!=null)
                this.oblConcRpDetRubCdpVo = new OblConcRpDetRubCdpVO(siiNotaCredOblConcDetRub.getSiiOblConcRpDetRubCdp());
            
            if (siiNotaCredOblConcDetRub.getSiiNotaCredito()!=null)
                this.notaCreditoVo = new NotaCreditoVO(siiNotaCredOblConcDetRub.getSiiNotaCredito());
        }
    }

    
    
    public void setNdrCodigo(Long ndrCodigo) {
        this.ndrCodigo = ndrCodigo;
    }

    public Long getNdrCodigo() {
        return ndrCodigo;
    }

    public void setNdrValor(BigDecimal ndrValor) {
        this.ndrValor = ndrValor;
    }

    public BigDecimal getNdrValor() {
        return ndrValor;
    }

    public void setOblConcRpDetRubCdpVo(OblConcRpDetRubCdpVO oblConcRpDetRubCdpVo) {
        this.oblConcRpDetRubCdpVo = oblConcRpDetRubCdpVo;
    }

    public OblConcRpDetRubCdpVO getOblConcRpDetRubCdpVo() {
        return oblConcRpDetRubCdpVo;
    }

    public void setNotaCreditoVo(NotaCreditoVO notaCreditoVo) {
        this.notaCreditoVo = notaCreditoVo;
    }

    public NotaCreditoVO getNotaCreditoVo() {
        return notaCreditoVo;
    }
}
