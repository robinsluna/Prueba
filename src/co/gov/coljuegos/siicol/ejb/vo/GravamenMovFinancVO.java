package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGravamenMovFinanc;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class GravamenMovFinancVO {
    private String gmfActivo;
    private Long gmfCodigo;
    private Date gmfFechaReg;
    private BigDecimal gmfValor;
    private List<DetalleRubroCdpVO> detalleRubroCdpListVo;
    
    public GravamenMovFinancVO() {
    }

    public GravamenMovFinancVO(SiiGravamenMovFinanc siiGravamenMovFinanc){
        this.gmfActivo = siiGravamenMovFinanc.getGmfActivo();
        this.gmfCodigo = siiGravamenMovFinanc.getGmfCodigo();
        this.gmfFechaReg = siiGravamenMovFinanc.getGmfFechaReg();
        this.gmfValor = siiGravamenMovFinanc.getGmfValor();
    }

    public void setGmfActivo(String gmfActivo) {
        this.gmfActivo = gmfActivo;
    }

    public String getGmfActivo() {
        return gmfActivo;
    }

    public void setGmfCodigo(Long gmfCodigo) {
        this.gmfCodigo = gmfCodigo;
    }

    public Long getGmfCodigo() {
        return gmfCodigo;
    }

    public void setGmfFechaReg(Date gmfFechaReg) {
        this.gmfFechaReg = gmfFechaReg;
    }

    public Date getGmfFechaReg() {
        return gmfFechaReg;
    }

    public void setGmfValor(BigDecimal gmfValor) {
        this.gmfValor = gmfValor;
    }

    public BigDecimal getGmfValor() {
        return gmfValor;
    }

    public void setDetalleRubroCdpListVo(List<DetalleRubroCdpVO> detalleRubroCdpListVo) {
        this.detalleRubroCdpListVo = detalleRubroCdpListVo;
    }

    public List<DetalleRubroCdpVO> getDetalleRubroCdpListVo() {
        return detalleRubroCdpListVo;
    }
}
