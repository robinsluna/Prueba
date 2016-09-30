/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Mónica Pabon
 * FECHA	: 10-02-2014
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecaudoEstablec;

import java.math.BigDecimal;

import java.util.List;

public class LiquidacionEstablVO {
    private Long lesCodigo;
    private BigDecimal lesPonderado;
    private BigDecimal lesValor;
    private LiquidacionMesVO liquidacionMesVo;
    private EstablecimientoVO establecimientoVo;
    private AsignacionRecaudoVO asignacionRecaudoVo;
    private UbicacionVO ubicacionVo;
    private String numEstablecimiento;
    private String codigoUbicacion; 
    private Long hleCodigo;
    
    public LiquidacionEstablVO() {
        
    }
    public LiquidacionEstablVO(SiiLiquidacionEstabl siiLiquidacionEstabl) {
        this.lesCodigo = siiLiquidacionEstabl.getLesCodigo();
        this.lesPonderado = siiLiquidacionEstabl.getLesPonderado();
        this.lesValor = siiLiquidacionEstabl.getLesValor();
        this.numEstablecimiento = siiLiquidacionEstabl.getLesNumEstablec();
        if(siiLiquidacionEstabl.getSiiLiquidacionMes()!= null){
            this.liquidacionMesVo = new LiquidacionMesVO(siiLiquidacionEstabl.getSiiLiquidacionMes());
        }
        if(siiLiquidacionEstabl.getSiiEstablecimiento()!= null){
            this.establecimientoVo = new EstablecimientoVO(siiLiquidacionEstabl.getSiiEstablecimiento());
        }
        if(siiLiquidacionEstabl.getSiiAsignacionRecaudo() != null ){
            this.asignacionRecaudoVo = new AsignacionRecaudoVO(siiLiquidacionEstabl.getSiiAsignacionRecaudo());
        }
        if( siiLiquidacionEstabl.getSiiUbicacionMunEstab() != null ){
            this.ubicacionVo = new UbicacionVO(siiLiquidacionEstabl.getSiiUbicacionMunEstab() );
        }
        
        
    }

    public void setLesCodigo(Long lesCodigo) {
        this.lesCodigo = lesCodigo;
    }

    public Long getLesCodigo() {
        return lesCodigo;
    }

    public void setLesPonderado(BigDecimal lesPonderado) {
        this.lesPonderado = lesPonderado;
    }

    public BigDecimal getLesPonderado() {
        return lesPonderado;
    }

    public void setLesValor(BigDecimal lesValor) {
        this.lesValor = lesValor;
    }

    public BigDecimal getLesValor() {
        return lesValor;
    }

    public void setLiquidacionMesVo(LiquidacionMesVO liquidacionMesVo) {
        this.liquidacionMesVo = liquidacionMesVo;
    }

    public LiquidacionMesVO getLiquidacionMesVo() {
        return liquidacionMesVo;
    }

    public void setEstablecimientoVo(EstablecimientoVO establecimientoVo) {
        this.establecimientoVo = establecimientoVo;
    }

    public EstablecimientoVO getEstablecimientoVo() {
        return establecimientoVo;
    }

    public void setNumEstablecimiento(String numEstablecimiento) {
        this.numEstablecimiento = numEstablecimiento;
    }

    public String getNumEstablecimiento() {
        return numEstablecimiento;
    }


    public void setUbicacionVo(UbicacionVO ubicacionVo) {
        this.ubicacionVo = ubicacionVo;
    }

    public UbicacionVO getUbicacionVo() {
        return ubicacionVo;
    }

    public void setCodigoUbicacion(String codigoUbicacion) {
        this.codigoUbicacion = codigoUbicacion;
    }

    public String getCodigoUbicacion() {
        return codigoUbicacion;
    }

    public void setHleCodigo(Long hleCodigo) {
        this.hleCodigo = hleCodigo;
    }

    public Long getHleCodigo() {
        return hleCodigo;
    }
}
