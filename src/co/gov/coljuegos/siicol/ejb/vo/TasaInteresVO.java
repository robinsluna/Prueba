package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoTasaInteres;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

import java.util.Date;

public class TasaInteresVO {
    private String taiActivo;
    private Long taiCodigo;
    private Date taiFecha;
    private Date taiFechaDesde;
    private Date taiFechaHasta;
    private BigDecimal taiPorcentaje;
    private String taiTipoInteres;
    private UsuarioVO usuarioConecVo;
    private TipoTasaInteresVO tipoTasaInteresVo;
    
    public TasaInteresVO() {
        super();
    }
    
    public TasaInteresVO(SiiTasaInteres siiTasaInteres) {
        this.taiActivo = siiTasaInteres.getTaiActivo();
        this.taiCodigo = siiTasaInteres.getTaiCodigo();
        this.taiFecha = siiTasaInteres.getTaiFecha();
        this.taiFechaDesde = siiTasaInteres.getTaiFechaDesde();
        this.taiFechaHasta = siiTasaInteres.getTaiFechaHasta();
        this.taiPorcentaje = siiTasaInteres.getTaiPorcentaje();
        this.taiTipoInteres = siiTasaInteres.getTaiTipoInteres();
        
        if (siiTasaInteres.getSiiUsuarioConec() != null){
            this.usuarioConecVo = new UsuarioVO(siiTasaInteres.getSiiUsuarioConec());            
        }
        if (siiTasaInteres.getSiiTipoTasaInteres() != null){
            this.tipoTasaInteresVo = new TipoTasaInteresVO(siiTasaInteres.getSiiTipoTasaInteres());
        }
    }

    public void setTaiActivo(String taiActivo) {
        this.taiActivo = taiActivo;
    }

    public String getTaiActivo() {
        return taiActivo;
    }

    public void setTaiCodigo(Long taiCodigo) {
        this.taiCodigo = taiCodigo;
    }

    public Long getTaiCodigo() {
        return taiCodigo;
    }

    public void setTaiFecha(Date taiFecha) {
        this.taiFecha = taiFecha;
    }

    public Date getTaiFecha() {
        return taiFecha;
    }

    public void setTaiFechaDesde(Date taiFechaDesde) {
        this.taiFechaDesde = taiFechaDesde;
    }

    public Date getTaiFechaDesde() {
        return taiFechaDesde;
    }

    public void setTaiFechaHasta(Date taiFechaHasta) {
        this.taiFechaHasta = taiFechaHasta;
    }

    public Date getTaiFechaHasta() {
        return taiFechaHasta;
    }

    public void setTaiPorcentaje(BigDecimal taiPorcentaje) {
        this.taiPorcentaje = taiPorcentaje;
    }

    public BigDecimal getTaiPorcentaje() {
        return taiPorcentaje;
    }

    public void setTaiTipoInteres(String taiTipoInteres) {
        this.taiTipoInteres = taiTipoInteres;
    }

    public String getTaiTipoInteres() {
        return taiTipoInteres;
    }

    public void setUsuarioConecVo(UsuarioVO usuarioConecVo) {
        this.usuarioConecVo = usuarioConecVo;
    }

    public UsuarioVO getUsuarioConecVo() {
        return usuarioConecVo;
    }


    public void setTipoTasaInteresVo(TipoTasaInteresVO tipoTasaInteresVo) {
        this.tipoTasaInteresVo = tipoTasaInteresVo;
    }

    public TipoTasaInteresVO getTipoTasaInteresVo() {
        return tipoTasaInteresVo;
    }
}
