/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-09-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoElemenIlegalidad;

import java.util.List;

/**
 * Value object que gestiona los tipos de elementos de ilegalidad
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public class TipoElemenIlegalidadVO implements Cloneable, Comparable{
    
    private Long teiCodigo;
    private String teiNombre;
    private List<ElementoIlegDenunVO> ElementoIlegDenunListVo;
    
    /**
     * Value Object que gestiona los tipo de elementos de ilegalidad
     */
    public TipoElemenIlegalidadVO() {
        super();
    }
    
    /**
     * Constructor
     * @param siiTipoElemenIlegalidad
     */
    public TipoElemenIlegalidadVO(SiiTipoElemenIlegalidad siiTipoElemenIlegalidad) {
        this.teiCodigo = siiTipoElemenIlegalidad.getTeiCodigo();
        this.teiNombre = siiTipoElemenIlegalidad.getTeiNombre();
    }

    @Override
    public Object clone() {
        TipoElemenIlegalidadVO t = new TipoElemenIlegalidadVO();
        t.teiCodigo = teiCodigo;
        t.teiNombre = teiNombre;
        return t;
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

    public void setElementoIlegDenunListVo(List<ElementoIlegDenunVO> ElementoIlegDenunListVo) {
        this.ElementoIlegDenunListVo = ElementoIlegDenunListVo;
    }

    public List<ElementoIlegDenunVO> getElementoIlegDenunListVo() {
        return ElementoIlegDenunListVo;
    }

    @Override
    public int compareTo(Object o) {
        int resultado = -1;
        if (o instanceof TipoElemenIlegalidadVO) {
            TipoElemenIlegalidadVO ac = (TipoElemenIlegalidadVO) o;
            if (ac!=null && this.teiNombre!=null && ac.teiNombre!=null)
                resultado = this.teiNombre.compareTo(ac.teiNombre);
        }
        return resultado;
    }

}
