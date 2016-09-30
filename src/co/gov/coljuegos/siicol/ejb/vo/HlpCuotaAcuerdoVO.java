/* 
 * SISTEMA	: SIICOL
 * AUTOR	: Mónica Pabón
 * FECHA	: 22-01-2015
 */


package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaAcuerdo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHlpCuotaOpCuoAcu;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class HlpCuotaAcuerdoVO {
    
    private Long ccuCodigo;    
    private Long hcaCodigo;
    private Integer hcaNumCuota;
    private BigDecimal hcaValor;
    private Integer hcaVigencia;
    private MesVO mesVo;
    private List<HlpCuotaOpCuoAcuVO> hlpCuotaOpCuoAcuListVO;
    private AcuerdoPagoVO acuerdoPagoVo;
    private Date hcaFechaPago;
    
    public HlpCuotaAcuerdoVO(SiiHlpCuotaAcuerdo siiHlpCuotaAcuerdo) {
       this.ccuCodigo = siiHlpCuotaAcuerdo.getCcuCodigo();
       this.hcaCodigo = siiHlpCuotaAcuerdo.getHcaCodigo();
       this.hcaNumCuota = siiHlpCuotaAcuerdo.getHcaNumCuota();
       this.hcaValor = siiHlpCuotaAcuerdo.getHcaValor();
       this.hcaVigencia = siiHlpCuotaAcuerdo.getHcaVigencia();
       this.hcaFechaPago = siiHlpCuotaAcuerdo.getHcaFechaPago();
       
       if(siiHlpCuotaAcuerdo.getSiiMes()!= null){
        this.mesVo = new MesVO (siiHlpCuotaAcuerdo.getSiiMes());
       }       
       if(siiHlpCuotaAcuerdo.getSiiAcuerdoPago()!= null){
           this.acuerdoPagoVo = new AcuerdoPagoVO(siiHlpCuotaAcuerdo.getSiiAcuerdoPago());
        }
    }
    
    public HlpCuotaAcuerdoVO(){}

    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }

    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setHcaCodigo(Long hcaCodigo) {
        this.hcaCodigo = hcaCodigo;
    }

    public Long getHcaCodigo() {
        return hcaCodigo;
    }

    public void setHcaNumCuota(Integer hcaNumCuota) {
        this.hcaNumCuota = hcaNumCuota;
    }

    public Integer getHcaNumCuota() {
        return hcaNumCuota;
    }

    public void setHcaValor(BigDecimal hcaValor) {
        this.hcaValor = hcaValor;
    }

    public BigDecimal getHcaValor() {
        return hcaValor;
    }

    public void setHcaVigencia(Integer hcaVigencia) {
        this.hcaVigencia = hcaVigencia;
    }

    public Integer getHcaVigencia() {
        return hcaVigencia;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setAcuerdoPagoVo(AcuerdoPagoVO acuerdoPagoVo) {
        this.acuerdoPagoVo = acuerdoPagoVo;
    }

    public AcuerdoPagoVO getAcuerdoPagoVo() {
        return acuerdoPagoVo;
    }

    public void setHcaFechaPago(Date hcaFechaPago) {
        this.hcaFechaPago = hcaFechaPago;
    }

    public Date getHcaFechaPago() {
        return hcaFechaPago;
    }

    public void setHlpCuotaOpCuoAcuListVO(List<HlpCuotaOpCuoAcuVO> hlpCuotaOpCuoAcuListVO) {
        this.hlpCuotaOpCuoAcuListVO = hlpCuotaOpCuoAcuListVO;
    }

    public List<HlpCuotaOpCuoAcuVO> getHlpCuotaOpCuoAcuListVO() {
        return hlpCuotaOpCuoAcuListVO;
    }


}
