/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PFC
 * AUTOR	: Walter Becerra
 * FECHA	: 17-03-2014
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreContable;

import java.util.Date;
import java.util.List;

public class CierreMensualVO {
    
    private Long cicCodigo;
    private Integer cicVigencia;
    private MesVO mesVo;
    private Date cicFechaCierre;
    private List<DetalleCierreContVO> detalleCierreContListVo;

    
    
    
     public CierreMensualVO() {
       
    }
    
    public CierreMensualVO(SiiCierreContable siiCierreContable) {
       this.cicCodigo=siiCierreContable.getCicCodigo();
       this.cicFechaCierre=siiCierreContable.getCicFechaCCont();
       this.cicVigencia=siiCierreContable.getCicVigencia();
       if (this.cicFechaCierre == null) {
           this.cicFechaCierre = new Date();
       }
       
       if(siiCierreContable.getSiiMes()!= null )
           this.mesVo= new MesVO(siiCierreContable.getSiiMes());
       
    }


    public void setCicCodigo(Long cicCodigo) {
        this.cicCodigo = cicCodigo;
    }

    public Long getCicCodigo() {
        return cicCodigo;
    }


    public void setCicVigencia(Integer cicVigencia) {
        this.cicVigencia = cicVigencia;
    }

    public Integer getCicVigencia() {
        return cicVigencia;
    }

    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setCicFechaCierre(Date cicFechaCierre) {
        this.cicFechaCierre = cicFechaCierre;
    }

    public Date getCicFechaCierre() {
        return cicFechaCierre;
    }


    public void setDetalleCierreContListVo(List<DetalleCierreContVO> detalleCierreContListVo) {
        this.detalleCierreContListVo = detalleCierreContListVo;
    }

    public List<DetalleCierreContVO> getDetalleCierreContListVo() {
        return detalleCierreContListVo;
    }
}
