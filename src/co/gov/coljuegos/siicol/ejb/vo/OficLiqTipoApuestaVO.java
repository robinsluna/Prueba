package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficLiqTipoApuesta;

import java.math.BigDecimal;

public class OficLiqTipoApuestaVO {
    private Long otaCodigo;
    private BigDecimal otaDerExplMes;
    private BigDecimal otaGasAdmin;
    private Integer otaNumElem;
    private OficioLiquidacionVO oficioLiquidacionVo;
    private TipoApuestaVO tipoApuestaVo;
    private BigDecimal otaValorUnidad;
    private String otaIndicadorLiq;
    private BigDecimal valorTotalMensual;

    public OficLiqTipoApuestaVO() {
    }
    public OficLiqTipoApuestaVO(SiiOficLiqTipoApuesta oficLiqTipoApuesta) {
        this.otaCodigo = oficLiqTipoApuesta.getOtaCodigo();
        this.otaDerExplMes = oficLiqTipoApuesta.getOtaDerExplMes();
        this.otaGasAdmin = oficLiqTipoApuesta.getOtaGasAdmin();
        this.otaNumElem = oficLiqTipoApuesta.getOtaNumElem();
        this.otaValorUnidad = oficLiqTipoApuesta.getOtaValorUnidad();
        this.otaIndicadorLiq = oficLiqTipoApuesta.getOtaIndicadorLiq();
        //Padres:
        this.oficioLiquidacionVo = new OficioLiquidacionVO(oficLiqTipoApuesta.getSiiOficioLiquidacion());
        this.tipoApuestaVo = new TipoApuestaVO(oficLiqTipoApuesta.getSiiTipoApuesta());
    }

    public void setOtaCodigo(Long otaCodigo) {
        this.otaCodigo = otaCodigo;
    }

    public Long getOtaCodigo() {
        return otaCodigo;
    }

    public void setOtaDerExplMes(BigDecimal otaDerExplMes) {
        this.otaDerExplMes = otaDerExplMes;
    }

    public BigDecimal getOtaDerExplMes() {
        return otaDerExplMes;
    }

    public void setOtaGasAdmin(BigDecimal otaGasAdmin) {
        this.otaGasAdmin = otaGasAdmin;
    }

    public BigDecimal getOtaGasAdmin() {
        return otaGasAdmin;
    }

    public void setOtaNumElem(Integer otaNumElem) {
        this.otaNumElem = otaNumElem;
    }

    public Integer getOtaNumElem() {
        return otaNumElem;
    }

    public void setOficioLiquidacionVo(OficioLiquidacionVO oficioLiquidacionVo) {
        this.oficioLiquidacionVo = oficioLiquidacionVo;
    }

    public OficioLiquidacionVO getOficioLiquidacionVo() {
        return oficioLiquidacionVo;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setOtaValorUnidad(BigDecimal otaValorUnidad) {
        this.otaValorUnidad = otaValorUnidad;
    }

    public BigDecimal getOtaValorUnidad() {
        return otaValorUnidad;
    }


    public void setOtaIndicadorLiq(String otaIndicadorLiq) {
        this.otaIndicadorLiq = otaIndicadorLiq;
    }

    public String getOtaIndicadorLiq() {
        return otaIndicadorLiq;
    }


    public void setValorTotalMensual(BigDecimal valorTotalMensual) {
        this.valorTotalMensual = valorTotalMensual;
    }

    public BigDecimal getValorTotalMensual() {
        return valorTotalMensual;
    }
}
