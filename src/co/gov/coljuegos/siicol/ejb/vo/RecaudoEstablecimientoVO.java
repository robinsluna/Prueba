
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: R y T
 * AUTOR	: Walter becerra
 * FECHA	: 06-02-2014
 */
package co.gov.coljuegos.siicol.ejb.vo;

import java.math.BigDecimal;

public class RecaudoEstablecimientoVO {
    
    private Long lesCodigo;
    private EstablecimientoVO establecimientoVo;
    private LiquidacionMesVO liquidacionMesVo;
    private BigDecimal lesValor;
    private Long lesPonderado;
    
    
    public RecaudoEstablecimientoVO() {
       
    }

    public void setLesCodigo(Long lesCodigo) {
        this.lesCodigo = lesCodigo;
    }

    public Long getLesCodigo() {
        return lesCodigo;
    }

    public void setEstablecimientoVo(EstablecimientoVO establecimientoVo) {
        this.establecimientoVo = establecimientoVo;
    }

    public EstablecimientoVO getEstablecimientoVo() {
        return establecimientoVo;
    }

    public void setLiquidacionMesVo(LiquidacionMesVO liquidacionMesVo) {
        this.liquidacionMesVo = liquidacionMesVo;
    }

    public LiquidacionMesVO getLiquidacionMesVo() {
        return liquidacionMesVo;
    }

    public void setLesValor(BigDecimal lesValor) {
        this.lesValor = lesValor;
    }

    public BigDecimal getLesValor() {
        return lesValor;
    }

    public void setLesPonderado(Long lesPonderado) {
        this.lesPonderado = lesPonderado;
    }

    public Long getLesPonderado() {
        return lesPonderado;
    }

}
