/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 03-12-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinanciacion;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSmmlv;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class LiquidacionMesVO {
     
    private String liqConcepto;
    private Date liqFecha;
    private Date liqFechaLimPago;
    private BigDecimal liqValor;
    private Long lmeCodigo;
    private Integer lmeNumCuota;
    private Integer lmeVigencia;
    private SmmlvVO smmlvVo;
    private MesVO mesVo;
    private ContratoVO contratoVo;
    private ReporteVentasVO reporteVentasVo;
    private String lmeManual;
    
    public LiquidacionMesVO(SiiLiquidacionMes siiLiquidacionMes){
        this.liqConcepto = siiLiquidacionMes.getLiqConcepto();
        this.liqFecha = siiLiquidacionMes.getLiqFecha();
        this.liqFechaLimPago = siiLiquidacionMes.getLiqFechaLimPago();
        this.liqValor = siiLiquidacionMes.getLiqValor();
        this.lmeCodigo = siiLiquidacionMes.getLmeCodigo();
        this.lmeNumCuota = siiLiquidacionMes.getLmeNumCuota();
        this.lmeVigencia = siiLiquidacionMes.getLmeVigencia();
        this.lmeManual = siiLiquidacionMes.getLmeManual();
        if(siiLiquidacionMes.getSiiSmmlv()!= null){
            this.smmlvVo = new SmmlvVO (siiLiquidacionMes.getSiiSmmlv());
        }
        if(siiLiquidacionMes.getSiiMes()!= null){
            this.mesVo = new MesVO (siiLiquidacionMes.getSiiMes());
        }
        if(siiLiquidacionMes.getSiiContrato() != null){
            this.contratoVo = new ContratoVO (siiLiquidacionMes.getSiiContrato());
        }
        if(siiLiquidacionMes.getSiiReporteVentas()!= null){
            this.reporteVentasVo = new ReporteVentasVO(siiLiquidacionMes.getSiiReporteVentas());
        }
        
    }
    
    public LiquidacionMesVO() {
    }

    public void setLiqConcepto(String liqConcepto) {
        this.liqConcepto = liqConcepto;
    }

    public String getLiqConcepto() {
        return liqConcepto;
    }

    public void setLiqFecha(Date liqFecha) {
        this.liqFecha = liqFecha;
    }

    public Date getLiqFecha() {
        return liqFecha;
    }

    public void setLiqFechaLimPago(Date liqFechaLimPago) {
        this.liqFechaLimPago = liqFechaLimPago;
    }

    public Date getLiqFechaLimPago() {
        return liqFechaLimPago;
    }

   

    public void setLmeCodigo(Long lmeCodigo) {
        this.lmeCodigo = lmeCodigo;
    }

    public Long getLmeCodigo() {
        return lmeCodigo;
    }

    public void setLmeNumCuota(Integer lmeNumCuota) {
        this.lmeNumCuota = lmeNumCuota;
    }

    public Integer getLmeNumCuota() {
        return lmeNumCuota;
    }

    public void setLmeVigencia(Integer lmeVigencia) {
        this.lmeVigencia = lmeVigencia;
    }

    public Integer getLmeVigencia() {
        return lmeVigencia;
    }

    public void setSmmlvVo(SmmlvVO smmlvVo) {
        this.smmlvVo = smmlvVo;
    }

    public SmmlvVO getSmmlvVo() {
        return smmlvVo;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }


    public void setLiqValor(BigDecimal liqValor) {
        this.liqValor = liqValor;
    }

    public BigDecimal getLiqValor() {
        return liqValor;
    }


    public void setReporteVentasVo(ReporteVentasVO reporteVentasVo) {
        this.reporteVentasVo = reporteVentasVo;
    }

    public ReporteVentasVO getReporteVentasVo() {
        return reporteVentasVo;
    }

    public void setLmeManual(String lmeManual) {
        this.lmeManual = lmeManual;
    }

    public String getLmeManual() {
        return lmeManual;
    }
}
