package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisFinancOtrosi;

import java.util.Date;

public class RevisFinancOtroSiVO {
    private Long rfoCodigo;
    private Date rfoFecha;
    private String rfoObservaciones;
    private String rfoValida;
    private OtroSiVO otroSiVo;
    private String rfoTipoValidac;

    public RevisFinancOtroSiVO() {

    }

    public RevisFinancOtroSiVO(SiiRevisFinancOtrosi revision) {
        rfoCodigo = revision.getRfoCodigo();
        rfoFecha = revision.getRfoFecha();
        rfoObservaciones = revision.getRfoObservaciones();
        rfoValida = revision.getRfoValida();
        rfoTipoValidac = revision.getRfoTipoValidac();
        
        if (revision.getSiiOtrosi() != null) {
            otroSiVo = new OtroSiVO(revision.getSiiOtrosi());
        }
        
    }

    public void setRfoCodigo(Long rfoCodigo) {
        this.rfoCodigo = rfoCodigo;
    }

    public Long getRfoCodigo() {
        return rfoCodigo;
    }

    public void setRfoFecha(Date rfoFecha) {
        this.rfoFecha = rfoFecha;
    }

    public Date getRfoFecha() {
        return rfoFecha;
    }

    public void setRfoObservaciones(String rfoObservaciones) {
        this.rfoObservaciones = rfoObservaciones;
    }

    public String getRfoObservaciones() {
        return rfoObservaciones;
    }

    public void setRfoValida(String rfoValida) {
        this.rfoValida = rfoValida;
    }

    public String getRfoValida() {
        return rfoValida;
    }

    public void setOtroSiVo(OtroSiVO otroSiVo) {
        this.otroSiVo = otroSiVo;
    }

    public OtroSiVO getOtroSiVo() {
        return otroSiVo;
    }

    public void setRfoTipoValidac(String rfoTipoValidac) {
        this.rfoTipoValidac = rfoTipoValidac;
    }

    public String getRfoTipoValidac() {
        return rfoTipoValidac;
    }
}
