package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCdpRp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;

public class CdpRpVO {
    private Long crpCodigo;
    private RpVO rpVo;
    private CdpVO cdpVo;
    
    public CdpRpVO() {        
    }
    public CdpRpVO(SiiCdpRp siiCdpRp) { 
        this.crpCodigo = siiCdpRp.getCrpCodigo();
        if(siiCdpRp.getSiiRp()!= null)
            this.rpVo = new RpVO(siiCdpRp.getSiiRp());
        if(siiCdpRp.getSiiCdp()!= null)
            this.cdpVo = new CdpVO(siiCdpRp.getSiiCdp());
    }

    public void setCrpCodigo(Long crpCodigo) {
        this.crpCodigo = crpCodigo;
    }

    public Long getCrpCodigo() {
        return crpCodigo;
    }

    public void setRpVo(RpVO rpVo) {
        this.rpVo = rpVo;
    }

    public RpVO getRpVo() {
        return rpVo;
    }

    public void setCdpVo(CdpVO cdpVo) {
        this.cdpVo = cdpVo;
    }

    public CdpVO getCdpVo() {
        return cdpVo;
    }
}
