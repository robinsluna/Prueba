/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Glenis Reyes
 * FECHA	: 28-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicPfcmDetalle;

import java.math.BigDecimal;

import java.util.List;

public class SolicPfcmDetalleVO {
    
    private Long spdCodigo;
    private BigDecimal spdValorAntic;
    private BigDecimal spdValorAplaz;
    private BigDecimal spdValorProgram;
    private SolicitudPfcMensualVO solicitudPfcMensualVo;
    private List<ModificPfcAnualVO> modificPfcAnualVo;
    private List<ModificPfcAnualVO> borrarModificPfcAnualVo;
    
    public SolicPfcmDetalleVO(SiiSolicPfcmDetalle siiSolicPfcmDetalle) {
        this.spdCodigo = siiSolicPfcmDetalle.getSpdCodigo();
        this.spdValorAntic = siiSolicPfcmDetalle.getSpdValorAntic();
        this.spdValorAplaz = siiSolicPfcmDetalle.getSpdValorAplaz();
        this.spdValorProgram = siiSolicPfcmDetalle.getSpdValorProgram();
        this.solicitudPfcMensualVo = new SolicitudPfcMensualVO(siiSolicPfcmDetalle.getSiiSolicitudPfcMens());
    }

    public void setBorrarModificPfcAnualVo(List<ModificPfcAnualVO> borrarModificPfcAnualVo) {
        this.borrarModificPfcAnualVo = borrarModificPfcAnualVo;
    }

    public List<ModificPfcAnualVO> getBorrarModificPfcAnualVo() {
        return borrarModificPfcAnualVo;
    }

    public void setModificPfcAnualVo(List<ModificPfcAnualVO> modificPfcAnualVo) {
        this.modificPfcAnualVo = modificPfcAnualVo;
    }

    public List<ModificPfcAnualVO> getModificPfcAnualVo() {
        return modificPfcAnualVo;
    }

    public SolicPfcmDetalleVO() {
    }

    public void setSpdCodigo(Long spdCodigo) {
        this.spdCodigo = spdCodigo;
    }

    public Long getSpdCodigo() {
        return spdCodigo;
    }

    public void setSpdValorAntic(BigDecimal spdValorAntic) {
        this.spdValorAntic = spdValorAntic;
    }

    public BigDecimal getSpdValorAntic() {
        return spdValorAntic;
    }

    public void setSpdValorAplaz(BigDecimal spdValorAplaz) {
        this.spdValorAplaz = spdValorAplaz;
    }

    public BigDecimal getSpdValorAplaz() {
        return spdValorAplaz;
    }

    public void setSpdValorProgram(BigDecimal spdValorProgram) {
        this.spdValorProgram = spdValorProgram;
    }

    public BigDecimal getSpdValorProgram() {
        return spdValorProgram;
    }


    public void setSolicitudPfcMensualVo(SolicitudPfcMensualVO solicitudPfcMensualVo) {
        this.solicitudPfcMensualVo = solicitudPfcMensualVo;
    }

    public SolicitudPfcMensualVO getSolicitudPfcMensualVo() {
        return solicitudPfcMensualVo;
    }

}
