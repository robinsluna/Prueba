package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionFinan;

import java.util.Date;

public class RevisionFinanVO {
    private Long rfiCodigo;
    private Date rfiFecha;
    private String rfiObservac;
    private String rfiValida;
    private ContratoVO contratoVo;
    private String rfiTipoValidac;
    
    public RevisionFinanVO() {
        
    }

    public RevisionFinanVO(SiiRevisionFinan revisionFinan) {
        this.rfiCodigo = revisionFinan.getRfiCodigo();
        this.rfiFecha = revisionFinan.getRfiFecha();
        this.rfiObservac = revisionFinan.getRfiObservac();
        this.rfiValida = revisionFinan.getRfiValida();
        this.rfiTipoValidac = revisionFinan.getRfiTipoValidac();
        
        if (revisionFinan.getSiiContrato() != null) {
            this.contratoVo = new ContratoVO(revisionFinan.getSiiContrato());
        }
        
    }

    public void setRfiCodigo(Long rfiCodigo) {
        this.rfiCodigo = rfiCodigo;
    }

    public Long getRfiCodigo() {
        return rfiCodigo;
    }

    public void setRfiFecha(Date rfiFecha) {
        this.rfiFecha = rfiFecha;
    }

    public Date getRfiFecha() {
        return rfiFecha;
    }

    public void setRfiObservac(String rfiObservac) {
        this.rfiObservac = rfiObservac;
    }

    public String getRfiObservac() {
        return rfiObservac;
    }

    public void setRfiValida(String rfiValida) {
        this.rfiValida = rfiValida;
    }

    public String getRfiValida() {
        return rfiValida;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }

    public void setRfiTipoValidac(String rfiTipoValidac) {
        this.rfiTipoValidac = rfiTipoValidac;
    }

    public String getRfiTipoValidac() {
        return rfiTipoValidac;
    }
}
