package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGctResolucAutoriza;

import java.util.Date;

public class RevisionGctResolucAutorizaVO {
    private Long rgrCodigo;
    private Date rgrFecha;
    private String rgrObservaciones;
    private String rgrValida;
    private ResolucionAutorizVO resolucionAutorizVo;
    
    public RevisionGctResolucAutorizaVO() {
        
    }

    public RevisionGctResolucAutorizaVO(SiiRevisionGctResolucAutoriza rev) {
        this.rgrCodigo = rev.getRgrCodigo();
        this.rgrFecha = rev.getRgrFecha();
        this.rgrObservaciones = rev.getRgrObservaciones();
        this.rgrValida = rev.getRgrValida();
        //Padres:
        if (rev.getSiiResolucionAutoriz() != null) {
            this.resolucionAutorizVo = new ResolucionAutorizVO(rev.getSiiResolucionAutoriz());
        }
    }

    public void setRgrCodigo(Long rgrCodigo) {
        this.rgrCodigo = rgrCodigo;
    }

    public Long getRgrCodigo() {
        return rgrCodigo;
    }

    public void setRgrFecha(Date rgrFecha) {
        this.rgrFecha = rgrFecha;
    }

    public Date getRgrFecha() {
        return rgrFecha;
    }

    public void setRgrObservaciones(String rgrObservaciones) {
        this.rgrObservaciones = rgrObservaciones;
    }

    public String getRgrObservaciones() {
        return rgrObservaciones;
    }

    public void setRgrValida(String rgrValida) {
        this.rgrValida = rgrValida;
    }

    public String getRgrValida() {
        return rgrValida;
    }

    public void setResolucionAutorizVo(ResolucionAutorizVO resolucionAutorizVo) {
        this.resolucionAutorizVo = resolucionAutorizVo;
    }

    public ResolucionAutorizVO getResolucionAutorizVo() {
        return resolucionAutorizVo;
    }
}
