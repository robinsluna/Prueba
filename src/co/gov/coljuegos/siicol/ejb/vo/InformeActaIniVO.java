package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeActaIni;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

public class InformeActaIniVO implements Serializable{
    private Long iaiCodigo;
    private Date iaiFecha;
    private String iaiPago;
    private String iaiTipoInforme;
    private BigDecimal iaiValor;
    private ActaIniContratoVO actaIniContratoVo;

    public InformeActaIniVO() {

    }

    public InformeActaIniVO(SiiInformeActaIni informeActaIni) {
        this.iaiCodigo = informeActaIni.getIaiCodigo();
        this.iaiFecha = informeActaIni.getIaiFecha();
        this.iaiPago = informeActaIni.getIaiPago();
        this.iaiTipoInforme = informeActaIni.getIaiTipoInforme();
        this.iaiValor = informeActaIni.getIaiValor();
        //Padres:
        if (informeActaIni.getSiiActaIniContrato() != null) {
            this.actaIniContratoVo = new ActaIniContratoVO(informeActaIni.getSiiActaIniContrato());
        }

    }

    public void setIaiCodigo(Long iaiCodigo) {
        this.iaiCodigo = iaiCodigo;
    }

    public Long getIaiCodigo() {
        return iaiCodigo;
    }

    public void setIaiFecha(Date iaiFecha) {
        this.iaiFecha = iaiFecha;
    }

    public Date getIaiFecha() {
        return iaiFecha;
    }

    public void setIaiPago(String iaiPago) {
        this.iaiPago = iaiPago;
    }

    public String getIaiPago() {
        return iaiPago;
    }

    public void setIaiTipoInforme(String iaiTipoInforme) {
        this.iaiTipoInforme = iaiTipoInforme;
    }

    public String getIaiTipoInforme() {
        return iaiTipoInforme;
    }

    public void setIaiValor(BigDecimal iaiValor) {
        this.iaiValor = iaiValor;
    }

    public BigDecimal getIaiValor() {
        return iaiValor;
    }

    public void setActaIniContratoVo(ActaIniContratoVO actaIniContratoVo) {
        this.actaIniContratoVo = actaIniContratoVo;
    }

    public ActaIniContratoVO getActaIniContratoVo() {
        return actaIniContratoVo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InformeActaIniVO))
            return false;

        InformeActaIniVO informeActaIniVo = (InformeActaIniVO) obj;

        return (informeActaIniVo.getIaiFecha() != null && informeActaIniVo.getIaiFecha().equals(iaiFecha)) &&               
               (informeActaIniVo.getIaiTipoInforme() != null &&
                informeActaIniVo.getIaiTipoInforme().equals(iaiTipoInforme));
    }
    
    public int hashCode() {
            int hash = 1;
            if(iaiFecha != null)
                hash = hash * 31 + iaiFecha.hashCode();
             
            if(iaiPago != null)
                hash = hash * 29 + iaiPago.hashCode();
     
            if(iaiTipoInforme != null)
                hash = hash * 27 + iaiTipoInforme.hashCode();

            return hash;
        }
}
