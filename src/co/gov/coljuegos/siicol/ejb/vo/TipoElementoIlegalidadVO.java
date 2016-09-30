package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;

import java.util.List;

public class TipoElementoIlegalidadVO {
    private Long teiCodigo;
    private String teiNombre;
    private List<ElementoIlegDenunVO> elementoIlegDenunListVo;
    private List<ElementoIlegInfVerVO> elementoIlegInfVerListVo;
    private List<ElementoRetiradoAccVO> elementoRetiradoAccListVo;

    public TipoElementoIlegalidadVO() {
    }
    public TipoElementoIlegalidadVO(SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.teiCodigo = siiTipoElemenIlegalidad.getTeiCodigo();
        this.teiNombre = siiTipoElemenIlegalidad.getTeiNombre();
    }

    public void setTeiCodigo(Long teiCodigo) {
        this.teiCodigo = teiCodigo;
    }

    public Long getTeiCodigo() {
        return teiCodigo;
    }

    public void setTeiNombre(String teiNombre) {
        this.teiNombre = teiNombre;
    }

    public String getTeiNombre() {
        return teiNombre;
    }

    public void setElementoIlegDenunListVo(List<ElementoIlegDenunVO> elementoIlegDenunListVo) {
        this.elementoIlegDenunListVo = elementoIlegDenunListVo;
    }

    public List<ElementoIlegDenunVO> getElementoIlegDenunListVo() {
        return elementoIlegDenunListVo;
    }

    public void setElementoIlegInfVerListVo(List<ElementoIlegInfVerVO> elementoIlegInfVerListVo) {
        this.elementoIlegInfVerListVo = elementoIlegInfVerListVo;
    }

    public List<ElementoIlegInfVerVO> getElementoIlegInfVerListVo() {
        return elementoIlegInfVerListVo;
    }

    public void setElementoRetiradoAccListVo(List<ElementoRetiradoAccVO> elementoRetiradoAccListVo) {
        this.elementoRetiradoAccListVo = elementoRetiradoAccListVo;
    }

    public List<ElementoRetiradoAccVO> getElementoRetiradoAccListVo() {
        return elementoRetiradoAccListVo;
    }

}
