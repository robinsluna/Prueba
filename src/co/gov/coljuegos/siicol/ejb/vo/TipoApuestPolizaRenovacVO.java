package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoApuestPolizaRenovac;

import java.math.BigDecimal;

public class TipoApuestPolizaRenovacVO {
    
    private Long talCodigo;
    private Integer talDuracion;
    private BigDecimal talValorDe;
    private BigDecimal talValorGa;
    private UsuarioVO usuarioConecVo;
    private PolizaContratVO polizaContratVo;
    private TipoApuestaVO tipoApuestaVo;
    private Long talNumeroElem;
    private BigDecimal talValorUnitario;
    
    public TipoApuestPolizaRenovacVO() {
    }
    
    public TipoApuestPolizaRenovacVO(SiiTipoApuestPolizaRenovac siiTipoApuestPolizaRenovac) {
        this.talCodigo = siiTipoApuestPolizaRenovac.getTalCodigo();
        this.talDuracion = siiTipoApuestPolizaRenovac.getTalDuracion();
        this.talValorDe = siiTipoApuestPolizaRenovac.getTalValorDe();
        this.talValorGa = siiTipoApuestPolizaRenovac.getTalValorGa();
        this.talNumeroElem = siiTipoApuestPolizaRenovac.getTalNumeroElem();
        this.talValorUnitario = siiTipoApuestPolizaRenovac.getTalValorUnitario();
        
        if(siiTipoApuestPolizaRenovac.getSiiUsuarioConec() != null){
            this.usuarioConecVo = new UsuarioVO(siiTipoApuestPolizaRenovac.getSiiUsuarioConec());
        }
        if(siiTipoApuestPolizaRenovac.getSiiPolizaContrat() != null){
            this.polizaContratVo = new PolizaContratVO(siiTipoApuestPolizaRenovac.getSiiPolizaContrat());
        }
        if(siiTipoApuestPolizaRenovac.getSiiTipoApuesta() != null){
            this.tipoApuestaVo = new TipoApuestaVO(siiTipoApuestPolizaRenovac.getSiiTipoApuesta());
        }
    }


    public void setTalCodigo(Long talCodigo) {
        this.talCodigo = talCodigo;
    }

    public Long getTalCodigo() {
        return talCodigo;
    }

    public void setTalDuracion(Integer talDuracion) {
        this.talDuracion = talDuracion;
    }

    public Integer getTalDuracion() {
        return talDuracion;
    }

    public void setTalValorDe(BigDecimal talValorDe) {
        this.talValorDe = talValorDe;
    }

    public BigDecimal getTalValorDe() {
        return talValorDe;
    }

    public void setTalValorGa(BigDecimal talValorGa) {
        this.talValorGa = talValorGa;
    }

    public BigDecimal getTalValorGa() {
        return talValorGa;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }

    public void setPolizaContratVo(PolizaContratVO polizaContratVo) {
        this.polizaContratVo = polizaContratVo;
    }

    public PolizaContratVO getPolizaContratVo() {
        return polizaContratVo;
    }

    public void setTipoApuestaVo(TipoApuestaVO tipoApuestaVo) {
        this.tipoApuestaVo = tipoApuestaVo;
    }

    public TipoApuestaVO getTipoApuestaVo() {
        return tipoApuestaVo;
    }

    public void setTalNumeroElem(Long talNumeroElem) {
        this.talNumeroElem = talNumeroElem;
    }

    public Long getTalNumeroElem() {
        return talNumeroElem;
    }

    public void setTalValorUnitario(BigDecimal talValorUnitario) {
        this.talValorUnitario = talValorUnitario;
    }

    public BigDecimal getTalValorUnitario() {
        return talValorUnitario;
    }
}
