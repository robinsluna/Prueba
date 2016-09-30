package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiExpedArchFisico;

public class ExpedArchFisicoVO {
    
    private String eafActivo;
    private Long eafCodigo;
    private ExpedienteFisicoVO expedienteFisicoVo;
    private ArchivoFisicoVO archivoFisicoVo;
    
    public ExpedArchFisicoVO() {
    }
    
    public ExpedArchFisicoVO(SiiExpedArchFisico siiExpedArchFisico) {
        this.eafActivo = siiExpedArchFisico.getEafActivo();
        this.eafCodigo = siiExpedArchFisico.getEafCodigo();
        this.expedienteFisicoVo = new ExpedienteFisicoVO(siiExpedArchFisico.getSiiExpedienteFisico());
        this.archivoFisicoVo = new ArchivoFisicoVO(siiExpedArchFisico.getSiiArchivoFisico());
    }

    public void setEafActivo(String eafActivo) {
        this.eafActivo = eafActivo;
    }

    public String getEafActivo() {
        return eafActivo;
    }

    public void setEafCodigo(Long eafCodigo) {
        this.eafCodigo = eafCodigo;
    }

    public Long getEafCodigo() {
        return eafCodigo;
    }

    public void setExpedienteFisicoVo(ExpedienteFisicoVO expedienteFisicoVo) {
        this.expedienteFisicoVo = expedienteFisicoVo;
    }

    public ExpedienteFisicoVO getExpedienteFisicoVo() {
        return expedienteFisicoVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }
}
