package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAmparoEstPrev;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoAmparo;

import java.util.List;

public class TipoAmparoVO {
    private String tamActivo;
    private Long tamCodigo;
    private String tamDescripcion;
    private String tamNombre;
    private List<AmparoEstPrevVO> amparoEstPrevListVo;
    
    public TipoAmparoVO(){
        
    }
    public TipoAmparoVO(SiiTipoAmparo siiTipoAmparo) {
        this.tamActivo = siiTipoAmparo.getTamActivo();
        this.tamCodigo = siiTipoAmparo.getTamCodigo();
        this.tamDescripcion = siiTipoAmparo.getTamDescripcion();
        this.tamNombre = siiTipoAmparo.getTamNombre();
    }

    public void setTamActivo(String tamActivo) {
        this.tamActivo = tamActivo;
    }

    public String getTamActivo() {
        return tamActivo;
    }

    public void setTamCodigo(Long tamCodigo) {
        this.tamCodigo = tamCodigo;
    }

    public Long getTamCodigo() {
        return tamCodigo;
    }

    public void setTamDescripcion(String tamDescripcion) {
        this.tamDescripcion = tamDescripcion;
    }

    public String getTamDescripcion() {
        return tamDescripcion;
    }

    public void setTamNombre(String tamNombre) {
        this.tamNombre = tamNombre;
    }

    public String getTamNombre() {
        return tamNombre;
    }

    public void setAmparoEstPrevListVo(List<AmparoEstPrevVO> amparoEstPrevListVo) {
        this.amparoEstPrevListVo = amparoEstPrevListVo;
    }

    public List<AmparoEstPrevVO> getAmparoEstPrevListVo() {
        return amparoEstPrevListVo;
    }
}
