package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoPolContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContProv;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAmparo;

import java.math.BigDecimal;

import java.util.Date;

public class AmparoPolContProvVO {
    private Long apcCodigo;
    private BigDecimal apcValorAseg;
    private Date apcVigenciaDes;
    private Date apcVigenciaHas;
    private PolizaContProvVO polizaContProvVo;
    private TipoAmparoVO tipoAmparoVo;

    public AmparoPolContProvVO() {        
    }

    public AmparoPolContProvVO(SiiAmparoPolContProv siiAmparoPolContProv) {
        this.apcCodigo = siiAmparoPolContProv.getApcCodigo();
        this.apcValorAseg = siiAmparoPolContProv.getApcValorAseg();
        this.apcVigenciaDes = siiAmparoPolContProv.getApcVigenciaDes();
        this.apcVigenciaHas = siiAmparoPolContProv.getApcVigenciaHas();
        //Padres
        this.polizaContProvVo = new PolizaContProvVO (siiAmparoPolContProv.getSiiPolizaContProv());
        this.tipoAmparoVo = new TipoAmparoVO (siiAmparoPolContProv.getSiiTipoAmparo());
    }


    public void setApcCodigo(Long apcCodigo) {
        this.apcCodigo = apcCodigo;
    }

    public Long getApcCodigo() {
        return apcCodigo;
    }

    public void setApcValorAseg(BigDecimal apcValorAseg) {
        this.apcValorAseg = apcValorAseg;
    }

    public BigDecimal getApcValorAseg() {
        return apcValorAseg;
    }

    public void setApcVigenciaDes(Date apcVigenciaDes) {
        this.apcVigenciaDes = apcVigenciaDes;
    }

    public Date getApcVigenciaDes() {
        return apcVigenciaDes;
    }

    public void setApcVigenciaHas(Date apcVigenciaHas) {
        this.apcVigenciaHas = apcVigenciaHas;
    }

    public Date getApcVigenciaHas() {
        return apcVigenciaHas;
    }

    public void setPolizaContProvVo(PolizaContProvVO polizaContProvVo) {
        this.polizaContProvVo = polizaContProvVo;
    }

    public PolizaContProvVO getPolizaContProvVo() {
        return polizaContProvVo;
    }

    public void setTipoAmparoVo(TipoAmparoVO tipoAmparoVo) {
        this.tipoAmparoVo = tipoAmparoVo;
    }

    public TipoAmparoVO getTipoAmparoVo() {
        return tipoAmparoVo;
    }
}
