package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiObligacionPago;

import java.math.BigDecimal;

public class ObligDetRubroCdpVO {
    private Long odrCodigo;
    private Long odrValorPagar;
    private ObligacionPagoVO obligacionPagoVo;
    private DetalleRubroCdpVO detalleRubroCdpVo;
    private String odrActivo;
    private RpDetRubroCdpVO rpDetRubroCdpVo;
    private BigDecimal cuatroXMil;
    
    public ObligDetRubroCdpVO (){
   
    }
    
    public ObligDetRubroCdpVO (SiiObligDetRubroCdp siiObligDetRubroCdp){
        this.odrCodigo = siiObligDetRubroCdp.getOdrCodigo();
        this.odrValorPagar = siiObligDetRubroCdp.getOdrValorPagar();
        //Padres
        this.detalleRubroCdpVo = new DetalleRubroCdpVO(siiObligDetRubroCdp.getSiiDetalleRubroCdp());
        this.obligacionPagoVo = new ObligacionPagoVO(siiObligDetRubroCdp.getSiiObligacionPago());
        this.rpDetRubroCdpVo = new  RpDetRubroCdpVO(siiObligDetRubroCdp.getSiiRpDetRubroCdp());
    }

    public void setRpDetRubroCdpVo(RpDetRubroCdpVO rpDetRubroCdpVo) {
        this.rpDetRubroCdpVo = rpDetRubroCdpVo;
    }

    public RpDetRubroCdpVO getRpDetRubroCdpVo() {
        return rpDetRubroCdpVo;
    }

    public void setOdrCodigo(Long odrCodigo) {
        this.odrCodigo = odrCodigo;
    }

    public Long getOdrCodigo() {
        return odrCodigo;
    }

    public void setOdrValorPagar(Long odrValorPagar) {
        this.odrValorPagar = odrValorPagar;
    }

    public Long getOdrValorPagar() {
        return odrValorPagar;
    }

    public void setObligacionPagoVo(ObligacionPagoVO obligacionPagoVo) {
        this.obligacionPagoVo = obligacionPagoVo;
    }

    public ObligacionPagoVO getObligacionPagoVo() {
        return obligacionPagoVo;
    }

    public void setDetalleRubroCdpVo(DetalleRubroCdpVO detalleRubroCdpVo) {
        this.detalleRubroCdpVo = detalleRubroCdpVo;
    }

    public DetalleRubroCdpVO getDetalleRubroCdpVo() {
        return detalleRubroCdpVo;
    }

    public void setOdrActivo(String odrActivo) {
        this.odrActivo = odrActivo;
    }

    public String getOdrActivo() {
        return odrActivo;
    }


    public void setCuatroXMil(BigDecimal cuatroXMil) {
        this.cuatroXMil = cuatroXMil;
    }

    public BigDecimal getCuatroXMil() {
        return cuatroXMil;
    }

}


