package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinancResolAutoriz;

import java.util.Date;

public class RevisionFinancResolAutorizVO {
    private Long rfrCodigo;
    private Date rfrFecha;
    private String rfrObservaciones;
    private String rfrValida;
    private ResolucionAutorizVO resolucionAutorizVo;

    public RevisionFinancResolAutorizVO ()  {
        
    }
    
    public RevisionFinancResolAutorizVO (SiiRevisionFinancResolAutoriz rev) {
        this.rfrCodigo = rev.getRfrCodigo();
        this.rfrFecha = rev.getRfrFecha();
        this.rfrObservaciones = rev.getRfrObservaciones();
        this.rfrValida = rev.getRfrValida();
        //Padres:
        if (rev.getSiiResolucionAutoriz() != null) {
            this.resolucionAutorizVo = new ResolucionAutorizVO(rev.getSiiResolucionAutoriz());                
        }
        
    }

    public void setRfrCodigo(Long rfrCodigo) {
        this.rfrCodigo = rfrCodigo;
    }

    public Long getRfrCodigo() {
        return rfrCodigo;
    }

    public void setRfrFecha(Date rfrFecha) {
        this.rfrFecha = rfrFecha;
    }

    public Date getRfrFecha() {
        return rfrFecha;
    }

    public void setRfrObservaciones(String rfrObservaciones) {
        this.rfrObservaciones = rfrObservaciones;
    }

    public String getRfrObservaciones() {
        return rfrObservaciones;
    }

    public void setRfrValida(String rfrValida) {
        this.rfrValida = rfrValida;
    }

    public String getRfrValida() {
        return rfrValida;
    }

    public void setResolucionAutorizVo(ResolucionAutorizVO resolucionAutorizVo) {
        this.resolucionAutorizVo = resolucionAutorizVo;
    }

    public ResolucionAutorizVO getResolucionAutorizVo() {
        return resolucionAutorizVo;
    }
}
