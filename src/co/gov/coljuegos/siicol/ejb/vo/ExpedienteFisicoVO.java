package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedienteFisico;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class ExpedienteFisicoVO {
    
    private String efiActivo;
    private Long efiCodigo;
    private Date efiFecha;
    private List<ExpedArchFisicoVO> expedArchFisicoVoList;
    
    public ExpedienteFisicoVO(SiiExpedienteFisico siiExpedienteFisico) {
        this.efiActivo = siiExpedienteFisico.getEfiActivo();
        this.efiCodigo = siiExpedienteFisico.getEfiCodigo();
        this.efiFecha = siiExpedienteFisico.getEfiFecha();
    }
    
    public ExpedienteFisicoVO() {
    }


    public void setEfiActivo(String efiActivo) {
        this.efiActivo = efiActivo;
    }

    public String getEfiActivo() {
        return efiActivo;
    }

    public void setEfiCodigo(Long efiCodigo) {
        this.efiCodigo = efiCodigo;
    }

    public Long getEfiCodigo() {
        return efiCodigo;
    }

    public void setEfiFecha(Date efiFecha) {
        this.efiFecha = efiFecha;
    }

    public Date getEfiFecha() {
        return efiFecha;
    }

    public void setExpedArchFisicoVoList(List<ExpedArchFisicoVO> expedArchFisicoVoList) {
        this.expedArchFisicoVoList = expedArchFisicoVoList;
    }

    public List<ExpedArchFisicoVO> getExpedArchFisicoVoList() {
        return expedArchFisicoVoList;
    }
}
