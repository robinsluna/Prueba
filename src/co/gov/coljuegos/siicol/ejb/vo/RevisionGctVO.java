package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContrato;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRevisionGct;

import java.util.Date;

public class RevisionGctVO {
    private Long rgcCodigo;
    private Date rgcFecha;
    private String rgcObservac;
    private String rgcValido;
    private ContratoVO contratoVo;
    
    public RevisionGctVO() {
        
    }

    public RevisionGctVO(SiiRevisionGct revisionGct) {
        this.rgcCodigo = revisionGct.getRgcCodigo();
        this.rgcFecha = revisionGct.getRgcFecha();
        this.rgcObservac = revisionGct.getRgcObservac();
        this.rgcValido = revisionGct.getRgcValido();
        if (revisionGct.getSiiContrato() != null) {
            this.contratoVo = new ContratoVO(revisionGct.getSiiContrato());            
        }
        
    }

    public void setRgcCodigo(Long rgcCodigo) {
        this.rgcCodigo = rgcCodigo;
    }

    public Long getRgcCodigo() {
        return rgcCodigo;
    }

    public void setRgcFecha(Date rgcFecha) {
        this.rgcFecha = rgcFecha;
    }

    public Date getRgcFecha() {
        return rgcFecha;
    }

    public void setRgcObservac(String rgcObservac) {
        this.rgcObservac = rgcObservac;
    }

    public String getRgcObservac() {
        return rgcObservac;
    }

    public void setRgcValido(String rgcValido) {
        this.rgcValido = rgcValido;
    }

    public String getRgcValido() {
        return rgcValido;
    }

    public void setContratoVo(ContratoVO contratoVo) {
        this.contratoVo = contratoVo;
    }

    public ContratoVO getContratoVo() {
        return contratoVo;
    }
}
