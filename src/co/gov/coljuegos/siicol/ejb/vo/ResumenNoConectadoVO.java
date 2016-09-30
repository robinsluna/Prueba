package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResumenNoConectado;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuesta;

import java.math.BigDecimal;

public class ResumenNoConectadoVO {
    private Long rncCodigo;
    private Integer rncNumElemen;
    private BigDecimal rncValorDe;
    private BigDecimal rncValorTarifa;
    private CuotaOperadorVO cuotaOperadorVo;
    private TipoApuestaVO tipoApuestaVO;
   
    public ResumenNoConectadoVO(SiiResumenNoConectado siiResumenNoConectado) {
        this.rncCodigo = siiResumenNoConectado.getRncCodigo();
        this.rncNumElemen = siiResumenNoConectado.getRncNumElemen();
        this.rncValorDe = siiResumenNoConectado.getRncValorDe();
        this.rncValorTarifa = siiResumenNoConectado.getRncValorTarifa();
        
        if(siiResumenNoConectado.getSiiCuotaOperador()!= null){
            this.cuotaOperadorVo = new CuotaOperadorVO(siiResumenNoConectado.getSiiCuotaOperador());
        }
        
        if(siiResumenNoConectado.getSiiTipoApuesta()!= null){
            this.tipoApuestaVO = new TipoApuestaVO(siiResumenNoConectado.getSiiTipoApuesta());
        }
    }
    
    public ResumenNoConectadoVO() {        
    }

    public void setRncCodigo(Long rncCodigo) {
        this.rncCodigo = rncCodigo;
    }

    public Long getRncCodigo() {
        return rncCodigo;
    }

    public void setRncNumElemen(Integer rncNumElemen) {
        this.rncNumElemen = rncNumElemen;
    }

    public Integer getRncNumElemen() {
        return rncNumElemen;
    }

    public void setRncValorDe(BigDecimal rncValorDe) {
        this.rncValorDe = rncValorDe;
    }

    public BigDecimal getRncValorDe() {
        return rncValorDe;
    }

    public void setRncValorTarifa(BigDecimal rncValorTarifa) {
        this.rncValorTarifa = rncValorTarifa;
    }

    public BigDecimal getRncValorTarifa() {
        return rncValorTarifa;
    }

    public void setCuotaOperadorVo(CuotaOperadorVO cuotaOperadorVo) {
        this.cuotaOperadorVo = cuotaOperadorVo;
    }

    public CuotaOperadorVO getCuotaOperadorVo() {
        return cuotaOperadorVo;
    }


    public void setTipoApuestaVO(TipoApuestaVO tipoApuestaVO) {
        this.tipoApuestaVO = tipoApuestaVO;
    }

    public TipoApuestaVO getTipoApuestaVO() {
        return tipoApuestaVO;
    }

}
