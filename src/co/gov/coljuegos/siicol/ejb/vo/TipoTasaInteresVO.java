package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoTasaInteres;

import java.util.List;

public class TipoTasaInteresVO {
    private String ttiAbreviatura;
    private Long ttiCodigo;
    private String ttiNombre;
    private List<TasaInteresVO> TasaInteresListVo;
    
    public TipoTasaInteresVO() {
        super();
    }
    
    public TipoTasaInteresVO(SiiTipoTasaInteres siiTipoTasaInteres){
        this.ttiAbreviatura = siiTipoTasaInteres.getTtiAbreviatura();
        this.ttiCodigo = siiTipoTasaInteres.getTtiCodigo();
        this.ttiNombre = siiTipoTasaInteres.getTtiNombre();                
    }

    public void setTtiAbreviatura(String ttiAbreviatura) {
        this.ttiAbreviatura = ttiAbreviatura;
    }

    public String getTtiAbreviatura() {
        return ttiAbreviatura;
    }

    public void setTtiCodigo(Long ttiCodigo) {
        this.ttiCodigo = ttiCodigo;
    }

    public Long getTtiCodigo() {
        return ttiCodigo;
    }

    public void setTtiNombre(String ttiNombre) {
        this.ttiNombre = ttiNombre;
    }

    public String getTtiNombre() {
        return ttiNombre;
    }

    public void setTasaInteresListVo(List<TasaInteresVO> TasaInteresListVo) {
        this.TasaInteresListVo = TasaInteresListVo;
    }

    public List<TasaInteresVO> getTasaInteresListVo() {
        return TasaInteresListVo;
    }
}
