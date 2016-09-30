/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 27-09-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;

import java.util.List;

public class SmmlvVO {
     
    private Long smmValor;
    private Integer smmVigencia;
    private List<LiquidacionMesVO> liquidacionMesVoList;
    
    public SmmlvVO(SiiSmmlv siiSmmlv){
        this.smmValor = siiSmmlv.getSmmValor();
        this.smmVigencia = siiSmmlv.getSmmVigencia();
    }
    
    public SmmlvVO() {
    }

    public void setSmmValor(Long smmValor) {
        this.smmValor = smmValor;
    }

    public Long getSmmValor() {
        return smmValor;
    }

    public void setSmmVigencia(Integer smmVigencia) {
        this.smmVigencia = smmVigencia;
    }

    public Integer getSmmVigencia() {
        return smmVigencia;
    }

    public void setLiquidacionMesVoList(List<LiquidacionMesVO> liquidacionMesVoList) {
        this.liquidacionMesVoList = liquidacionMesVoList;
    }

    public List<LiquidacionMesVO> getLiquidacionMesVoList() {
        return liquidacionMesVoList;
    }

}
