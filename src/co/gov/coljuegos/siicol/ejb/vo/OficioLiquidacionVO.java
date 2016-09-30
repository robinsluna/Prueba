package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class OficioLiquidacionVO {
    private Long oliCodigo;
    private Integer oliConsecutivo;
    private Date oliFechaOficio;
    private List<OficLiqTipoApuestaVO> oficLiqTipoApuestaListVo;
    private SolicitudAutorizaVO solicitudAutorizaVo;
    private EstadoOficioLiqVO estadoOficioLiqVo;
    private BigDecimal oliValorDerExpl;
    private BigDecimal oliValorGastAdm;
    private Long idEstadoAnterior;
    private List<GarantPolizaOficLiqVO> garantPolizaOficLiqVOs;

    public OficioLiquidacionVO() {

    }

    /**
     * @author Modifica Giovanni
     * @param siiOficioLiquidacion
     */
    public OficioLiquidacionVO(SiiOficioLiquidacion siiOficioLiquidacion) {
        this.oliCodigo = siiOficioLiquidacion.getOliCodigo();
        this.oliConsecutivo = siiOficioLiquidacion.getOliConsecutivo();
        this.oliFechaOficio = siiOficioLiquidacion.getOliFechaOficio();
        this.oliValorDerExpl = siiOficioLiquidacion.getOliValorDerExpl();
        this.oliValorGastAdm = siiOficioLiquidacion.getOliValorGastAdm();

        //Padres:
        //Estado
        if (siiOficioLiquidacion.getSiiEstadoOficioLiq() != null) {
            this.estadoOficioLiqVo = new EstadoOficioLiqVO(siiOficioLiquidacion.getSiiEstadoOficioLiq());
            this.idEstadoAnterior = siiOficioLiquidacion.getSiiEstadoOficioLiq().getEolCodigo();
        }

        //Solicitud Autorizacion
        if (siiOficioLiquidacion.getSiiSolicitudAutoriza() != null) {
            this.solicitudAutorizaVo = new SolicitudAutorizaVO(siiOficioLiquidacion.getSiiSolicitudAutoriza());
        }
    }


    public void setOliCodigo(Long oliCodigo) {
        this.oliCodigo = oliCodigo;
    }

    public Long getOliCodigo() {
        return oliCodigo;
    }

    public void setOliConsecutivo(Integer oliConsecutivo) {
        this.oliConsecutivo = oliConsecutivo;
    }

    public Integer getOliConsecutivo() {
        return oliConsecutivo;
    }

    public void setOliFechaOficio(Date oliFechaOficio) {
        this.oliFechaOficio = oliFechaOficio;
    }

    public Date getOliFechaOficio() {
        return oliFechaOficio;
    }


    public void setOficLiqTipoApuestaListVo(List<OficLiqTipoApuestaVO> oficLiqTipoApuestaListVo) {
        this.oficLiqTipoApuestaListVo = oficLiqTipoApuestaListVo;
    }

    public List<OficLiqTipoApuestaVO> getOficLiqTipoApuestaListVo() {
        return oficLiqTipoApuestaListVo;
    }

    public void setSolicitudAutorizaVo(SolicitudAutorizaVO solicitudAutorizaVo) {
        this.solicitudAutorizaVo = solicitudAutorizaVo;
    }

    public SolicitudAutorizaVO getSolicitudAutorizaVo() {
        return solicitudAutorizaVo;
    }

    public void setEstadoOficioLiqVo(EstadoOficioLiqVO estadoOficioLiqVo) {
        this.estadoOficioLiqVo = estadoOficioLiqVo;
    }

    public EstadoOficioLiqVO getEstadoOficioLiqVo() {
        return estadoOficioLiqVo;
    }

    public void setOliValorDerExpl(BigDecimal oliValorDerExpl) {
        this.oliValorDerExpl = oliValorDerExpl;
    }

    public BigDecimal getOliValorDerExpl() {
        return oliValorDerExpl;
    }

    public void setOliValorGastAdm(BigDecimal oliValorGastAdm) {
        this.oliValorGastAdm = oliValorGastAdm;
    }

    public BigDecimal getOliValorGastAdm() {
        return oliValorGastAdm;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }

    public List<GarantPolizaOficLiqVO> getGarantPolizaOficLiqVOs() {
        return garantPolizaOficLiqVOs;
    }

    public void setGarantPolizaOficLiqVOs(List<GarantPolizaOficLiqVO> garantPolizaOficLiqVOs) {
        this.garantPolizaOficLiqVOs = garantPolizaOficLiqVOs;
    }
}
