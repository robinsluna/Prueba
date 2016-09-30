package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantPolizaOficLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaExigida;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class GarantPolizaOficLiqVO {
    private Long golCodigo;
    private String golDescripcion;
    private BigDecimal golValorAmparo;
    private OficioLiquidacionVO oficioLiquidacionVo;
    private GarantiaExigidaVO garantiaExigidaVo;
    
       
    public GarantPolizaOficLiqVO() {
    }
    
    public GarantPolizaOficLiqVO(SiiGarantPolizaOficLiq siiGarantPolizaOficLiq) {
       this.golCodigo = siiGarantPolizaOficLiq.getGolCodigo();
       this.golDescripcion = siiGarantPolizaOficLiq.getGolDescripcion();
       this.golValorAmparo = siiGarantPolizaOficLiq.getGolValorAmparo();
       if(siiGarantPolizaOficLiq.getSiiOficioLiquidacion() != null){
           this.oficioLiquidacionVo = new OficioLiquidacionVO ( siiGarantPolizaOficLiq.getSiiOficioLiquidacion());           
        }
       if(siiGarantPolizaOficLiq.getSiiGarantiaExigida()!= null){
             this.garantiaExigidaVo = new  GarantiaExigidaVO(siiGarantPolizaOficLiq.getSiiGarantiaExigida());
       }
    }

    public void setGolCodigo(Long golCodigo) {
        this.golCodigo = golCodigo;
    }

    public Long getGolCodigo() {
        return golCodigo;
    }

    public void setGolDescripcion(String golDescripcion) {
        this.golDescripcion = golDescripcion;
    }

    public String getGolDescripcion() {
        return golDescripcion;
    }

    public void setGolValorAmparo(BigDecimal golValorAmparo) {
        this.golValorAmparo = golValorAmparo;
    }

    public BigDecimal getGolValorAmparo() {
        return golValorAmparo;
    }

    public void setOficioLiquidacionVo(OficioLiquidacionVO oficioLiquidacionVo) {
        this.oficioLiquidacionVo = oficioLiquidacionVo;
    }

    public OficioLiquidacionVO getOficioLiquidacionVo() {
        return oficioLiquidacionVo;
    }

    public void setGarantiaExigidaVo(GarantiaExigidaVO garantiaExigidaVo) {
        this.garantiaExigidaVo = garantiaExigidaVo;
    }

    public GarantiaExigidaVO getGarantiaExigidaVo() {
        return garantiaExigidaVo;
    }

}
