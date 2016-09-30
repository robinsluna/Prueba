package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoOficioLiq;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioLiquidacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoContratacion;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTerminosReferencia;

import java.util.Date;
import java.util.List;

public class EstadoOficioLiqVO {    
    private Long eolCodigo;
    private String eolNombre;
    private List<OficioLiquidacionVO> oficioLiquidacionListVo;
   
    
    public EstadoOficioLiqVO() {
    }
    
    public EstadoOficioLiqVO(SiiEstadoOficioLiq siiEstadoOficioLiq) {
        this.eolCodigo = siiEstadoOficioLiq.getEolCodigo();
        this.eolNombre = siiEstadoOficioLiq.getEolNombre();
    }

    public void setEolCodigo(Long eolCodigo) {
        this.eolCodigo = eolCodigo;
    }

    public Long getEolCodigo() {
        return eolCodigo;
    }

    public void setEolNombre(String eolNombre) {
        this.eolNombre = eolNombre;
    }

    public String getEolNombre() {
        return eolNombre;
    }

    public void setOficioLiquidacionListVo(List<OficioLiquidacionVO> oficioLiquidacionListVo) {
        this.oficioLiquidacionListVo = oficioLiquidacionListVo;
    }

    public List<OficioLiquidacionVO> getOficioLiquidacionListVo() {
        return oficioLiquidacionListVo;
    }


}
