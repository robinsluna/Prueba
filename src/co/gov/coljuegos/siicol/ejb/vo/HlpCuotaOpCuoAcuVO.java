/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Mónica Pabón
 * FECHA	: 22-01-2015
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;

import java.math.BigDecimal;

public class HlpCuotaOpCuoAcuVO {
    private BigDecimal hcaValor;
    private BigDecimal hcaValorAbono;
    private BigDecimal hcaValorAbInt;
    private BigDecimal hcaValorInt;
    private Long hcoCodigo;
    private CuotaOperadorVO cuotaOperadorVo;
    private HlpCuotaAcuerdoVO hlpCuotaAcuerdoVo;
    
    public HlpCuotaOpCuoAcuVO(SiiHlpCuotaOpCuoAcu siiHlpCuotaOpCuoAcu) {
        this.hcaValor = siiHlpCuotaOpCuoAcu.getHcaValor();
        this.hcaValorAbono = siiHlpCuotaOpCuoAcu.getHcaValorAbono();
        this.hcaValorAbInt = siiHlpCuotaOpCuoAcu.getHcaValorAbInt();
        this.hcaValorInt = siiHlpCuotaOpCuoAcu.getHcaValorInt();
        this.hcoCodigo = siiHlpCuotaOpCuoAcu.getHcoCodigo();
        if(siiHlpCuotaOpCuoAcu.getSiiCuotaOperador()!= null){
           this.cuotaOperadorVo = new CuotaOperadorVO(siiHlpCuotaOpCuoAcu.getSiiCuotaOperador()); 
        }
        if(siiHlpCuotaOpCuoAcu.getSiiHlpCuotaAcuerdo()!= null){
            this.hlpCuotaAcuerdoVo = new HlpCuotaAcuerdoVO(siiHlpCuotaOpCuoAcu.getSiiHlpCuotaAcuerdo());
        }
    }
    
    public HlpCuotaOpCuoAcuVO() { }

    public void setHcaValor(BigDecimal hcaValor) {
        this.hcaValor = hcaValor;
    }

    public BigDecimal getHcaValor() {
        return hcaValor;
    }

    public void setHcaValorAbono(BigDecimal hcaValorAbono) {
        this.hcaValorAbono = hcaValorAbono;
    }

    public BigDecimal getHcaValorAbono() {
        return hcaValorAbono;
    }

    public void setHcaValorAbInt(BigDecimal hcaValorAbInt) {
        this.hcaValorAbInt = hcaValorAbInt;
    }

    public BigDecimal getHcaValorAbInt() {
        return hcaValorAbInt;
    }

    public void setHcaValorInt(BigDecimal hcaValorInt) {
        this.hcaValorInt = hcaValorInt;
    }

    public BigDecimal getHcaValorInt() {
        return hcaValorInt;
    }

    public void setHcoCodigo(Long hcoCodigo) {
        this.hcoCodigo = hcoCodigo;
    }

    public Long getHcoCodigo() {
        return hcoCodigo;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }

    public void setHlpCuotaAcuerdoVo(HlpCuotaAcuerdoVO hlpCuotaAcuerdoVo) {
        this.hlpCuotaAcuerdoVo = hlpCuotaAcuerdoVo;
    }

    public HlpCuotaAcuerdoVO getHlpCuotaAcuerdoVo() {
        return hlpCuotaAcuerdoVo;
    }

}
