/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 29-12-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;


import java.math.BigDecimal;


/**
 * Value Object para la informaci&oacute;n resultante de la Vigencia Futura.
 * @author Camilo Miranda
 */
public class VigenciaFuturaResultVO 
{
    private String rubro;
    private String descRubro;
    private BigDecimal valorVigencia1;
    private BigDecimal valorVigencia2;
    private BigDecimal valorVigencia3;
    private BigDecimal valorVigencia4;
    private BigDecimal valorVigencia5;
    
    
    private VigenciaFuturaVO vigenciaFuturaVo;
    private DetalleRubroVO detalleRubroVo;
    
    
    /**
     * Constructor.
     */
    public VigenciaFuturaResultVO() { }


    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getRubro() {
        return rubro;
    }

    public void setDescRubro(String descRubro) {
        this.descRubro = descRubro;
    }

    public String getDescRubro() {
        return descRubro;
    }

    public void setValorVigencia1(BigDecimal valorVigencia1) {
        this.valorVigencia1 = valorVigencia1;
    }

    public BigDecimal getValorVigencia1() {
        return valorVigencia1;
    }

    public void setValorVigencia2(BigDecimal valorVigencia2) {
        this.valorVigencia2 = valorVigencia2;
    }

    public BigDecimal getValorVigencia2() {
        return valorVigencia2;
    }

    public void setValorVigencia3(BigDecimal valorVigencia3) {
        this.valorVigencia3 = valorVigencia3;
    }

    public BigDecimal getValorVigencia3() {
        return valorVigencia3;
    }

    public void setValorVigencia4(BigDecimal valorVigencia4) {
        this.valorVigencia4 = valorVigencia4;
    }

    public BigDecimal getValorVigencia4() {
        return valorVigencia4;
    }

    public void setValorVigencia5(BigDecimal valorVigencia5) {
        this.valorVigencia5 = valorVigencia5;
    }

    public BigDecimal getValorVigencia5() {
        return valorVigencia5;
    }

    public void setVigenciaFuturaVo(VigenciaFuturaVO vigenciaFuturaVo) {
        this.vigenciaFuturaVo = vigenciaFuturaVo;
    }

    public VigenciaFuturaVO getVigenciaFuturaVo() {
        return vigenciaFuturaVo;
    }

    public void setDetalleRubroVo(DetalleRubroVO detalleRubroVo) {
        this.detalleRubroVo = detalleRubroVo;
    }

    public DetalleRubroVO getDetalleRubroVo() {
        return detalleRubroVo;
    }
}
