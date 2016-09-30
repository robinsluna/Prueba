package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReintegroIngresoPag;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRpDetRubroCdp;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

public class RpDetRubReintIngPagVO{
    
    private Long rinCodigo;
    private ReintegroPagaduriaVO reintegroPagaduriaVo;
    private UsuarioVO usuarioConecVo;
    private RpDetRubroCdpVO rpDetRubroCdpVo;
    private BigDecimal rinValorReintegro;
    
    
    public RpDetRubReintIngPagVO(){
     
    }

    public void setRinCodigo(Long rinCodigo){
        this.rinCodigo = rinCodigo;
    }

    public Long getRinCodigo(){
        return rinCodigo;
    }

    public void setReintegroPagaduriaVo(ReintegroPagaduriaVO reintegroPagaduriaVo){
        this.reintegroPagaduriaVo = reintegroPagaduriaVo;
    }

    public ReintegroPagaduriaVO getReintegroPagaduriaVo(){
        return reintegroPagaduriaVo;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo){
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo(){
        return usuarioConecVo;
    }

    public void setRpDetRubroCdpVo(RpDetRubroCdpVO rpDetRubroCdpVo){
        this.rpDetRubroCdpVo = rpDetRubroCdpVo;
    }

    public RpDetRubroCdpVO getRpDetRubroCdpVo(){
        return rpDetRubroCdpVo;
    }

    public void setRinValorReintegro(BigDecimal rinValorReintegro){
        this.rinValorReintegro = rinValorReintegro;
    }

    public BigDecimal getRinValorReintegro(){
        return rinValorReintegro;
    }


}
