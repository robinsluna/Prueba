package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiActaIniContrato;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeContrProv;

import java.math.BigDecimal;

import java.util.Date;

public class InformeContrProvVO {
    private Long incCodigo;
    private Date incFecha;
    private String incPago;
    private String incTipoInforme;
    private BigDecimal incValor;
    private ActaIniContratoVO actaIniContratoVo;
    
    public InformeContrProvVO() {
        
    }

    public InformeContrProvVO(SiiInformeContrProv informeContrProv) {
        this.incCodigo = informeContrProv.getIncCodigo();
        this.incFecha = informeContrProv.getIncFecha();
        this.incPago = informeContrProv.getIncPago();
        this.incTipoInforme = informeContrProv.getIncTipoInforme();
        this.incValor = informeContrProv.getIncValor();  
        //Padres:
        if (informeContrProv.getSiiActaIniContrato() == null) {
            this.actaIniContratoVo = new ActaIniContratoVO(informeContrProv.getSiiActaIniContrato());
        }
    }

    public void setIncCodigo(Long incCodigo) {
        this.incCodigo = incCodigo;
    }

    public Long getIncCodigo() {
        return incCodigo;
    }

    public void setIncFecha(Date incFecha) {
        this.incFecha = incFecha;
    }

    public Date getIncFecha() {
        return incFecha;
    }

    public void setIncPago(String incPago) {
        this.incPago = incPago;
    }

    public String getIncPago() {
        return incPago;
    }

    public void setIncTipoInforme(String incTipoInforme) {
        this.incTipoInforme = incTipoInforme;
    }

    public String getIncTipoInforme() {
        return incTipoInforme;
    }

    public void setIncValor(BigDecimal incValor) {
        this.incValor = incValor;
    }

    public BigDecimal getIncValor() {
        return incValor;
    }

    public void setActaIniContratoVo(ActaIniContratoVO actaIniContratoVo) {
        this.actaIniContratoVo = actaIniContratoVo;
    }

    public ActaIniContratoVO getActaIniContratoVo() {
        return actaIniContratoVo;
    }
}
